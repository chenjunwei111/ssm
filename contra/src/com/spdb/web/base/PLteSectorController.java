package com.spdb.web.base;

import com.github.pagehelper.PageInfo;
import com.spdb.pojo.base.DepartmentPojo;
import com.spdb.pojo.base.PLteSectorPojo;
import com.spdb.pojo.generator.PartitionPojo;
import com.spdb.service.base.DepartmentService;
import com.spdb.service.base.PLteSectorService;
import com.spdb.service.generator.CommonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 小区工参信息
 * 
 * @author Chan
 */

@Controller
@RequestMapping("/PLteSector")
public class PLteSectorController {
	@Resource
	PLteSectorService service;
	@Resource
	CommonService commonservice;
	@Resource
	DepartmentService departmentservice;

	/** 小区工参信息插入语句 */
	@RequestMapping("/insert")
	@ResponseBody
	public Integer insert(@RequestBody PLteSectorPojo pojo) {
		try {
			service.insert(pojo);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/** 小区工参信息删除语句 */
	@RequestMapping("/delete")
	@ResponseBody
	public Integer delete(@RequestBody PLteSectorPojo pojo) {
		try {
			service.delete(pojo);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/** 小区工参信息更新语句 */
	@RequestMapping("/update")
	@ResponseBody
	public Integer update(@RequestBody PLteSectorPojo pojo) {
		try {
			service.update(pojo);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/** 小区工参信息查询语句(参数form),根据条件查询出所有的数据集 */
	@RequestMapping("/query")
	@ResponseBody
	public List<PLteSectorPojo> query(@RequestBody PLteSectorPojo pojo) {
		try {
			return service.query(pojo);
		} catch (Exception e) {
			return null;
		}
	}

	/** 小区工参信息查询分页语句(参数form),根据条件查询出每页的数据集 */
	@RequestMapping("/queryforpage")
	@ResponseBody
	public PageInfo<PLteSectorPojo> queryforpage(
			@RequestBody PLteSectorPojo pojo, Integer pageNo, Integer pageSize) {
		try {
			return service.queryforpage(pojo, pageNo, pageSize);
		} catch (Exception e) {
			return null;
		}
	}

	/** 否存在分区数据 */
	@RequestMapping("/existSPData")
	@ResponseBody
	public Integer existSPData(@RequestBody PartitionPojo pojo) throws Exception {
		try {
			if (getDepartmentCode(pojo) == null) {
				return null;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			Integer num = commonservice.existSPData(map);
			return num;
		} catch (Exception e) {
			return 0;
		}
	}

	/** 判断表中是否包含数据 需要传入tableName、areaCode */
	@RequestMapping("/selectSP")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> selectSP(@RequestBody PartitionPojo pojo)
			throws Exception {
		pojo.setTableName("P_LTE_SECTOR");
		return commonservice.selectSP(pojo);
	}

	/** 动态SQL 在这里组装查询的sql */
	@RequestMapping("/dynamicSql")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> dynamicSql() throws Exception {
		String sql = "";
		return commonservice.dynamicSql(sql);
	}
	
	
	@RequestMapping("/dynamicSqlCnd")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> dynamicSqlCnd(String cityCode,String Date,String Cnd) throws Exception {
		String part="P"+cityCode+"_"+Date;	
		String sql = "SELECT SECTOR_ID, SECTOR_NAME, ENODEBID, ECELL_ID, EARFCN, PCI,FREQBAND, VENDOR, AZIMUTH, LONGITUDE, LATITUDE,STYLE, HEIGHT, ELECTTILT, MECHTILT,TOTLETILT FROM P_LTE_SECTOR SUBPARTITION ("+part+") WHERE 1=1 "+Cnd;	
		//System.out.println(commonservice.dynamicSql(sql).get(0));
		return commonservice.dynamicSql(sql);
	}

	/** 地图专用的sql */
	@RequestMapping("/dynamicSqlMap")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> dynamicSqlMap(String cityCode,
			String Date, String Lng, String Lat) throws Exception {
		Object part = null;
		String sqlString = " select subpartition_name p  from  user_tab_subpartitions  where table_name='P_LTE_SECTOR' and subpartition_name like 'P"
				+ cityCode
				+ "_%'  order by  subpartition_name desc";
	
	   
		List<LinkedHashMap<String, Object>> locHashMaps = commonservice
				.dynamicSql(sqlString);
		if (locHashMaps != null && locHashMaps.size() > 0) {
			for (LinkedHashMap<String, Object> k : locHashMaps) {
				//System.out.println("select count(1) from p_lte_sector subpartition ("+ k.get("P") + ") where rownum<2");
				if (commonservice
						.dynamicSqltoInt("select count(1) from p_lte_sector subpartition ("
								+ k.get("P") + ") where rownum<2") > 0) {
					part = k.get("P");
					break;
				}
			}
		}
		
//		part="P"+cityCode+"_"+part;
		if (part != null) {
			if (Lng == null || Lng.isEmpty()) {
				sqlString = "select to_char(version_date,'yyyyMMdd') mdate,LONGITUDE,LATITUDE,listagg(SECTOR_ID||'|'||AZIMUTH,',') within GROUP (order by LONGITUDE,LATITUDE) sectorId  from p_lte_sector  subpartition ("
						+ part + ") where LONGITUDE is not null and LATITUDE is not null and AZIMUTH>=0 and AZIMUTH<360 group by LONGITUDE,LATITUDE,version_date";
			} else {
//				sqlString = "select to_char(version_date,'yyyyMMdd') mdate,LONGITUDE,LATITUDE,listagg(SECTOR_ID||'|'||AZIMUTH,',') within GROUP (order by LONGITUDE,LATITUDE) sectorId  from p_lte_sector  subpartition ("
//						+ part
//						+ ")  where  LONGITUDE is not null and LATITUDE is not null and AZIMUTH>=0 and AZIMUTH<360 and FN_GET_DISTANCE(longitude,latitude,"
//						+ Lng
//						+ "," + Lat + ")<=10 group by LONGITUDE,LATITUDE,version_date";
				sqlString="with t as ( select version_date,LONGITUDE,  LATITUDE,SECTOR_ID,AZIMUTH "
                         +" FROM p_lte_sector subpartition ("+part+") "
                         +"WHERE LONGITUDE IS NOT NULL AND LATITUDE IS NOT NULL "
                         +"AND AZIMUTH >=0 AND AZIMUTH <360  and LONGITUDE-"+Lng+">-0.1 and LONGITUDE-"+Lng+"<0.1  "
                         +"and LATITUDE-"+Lat+">-0.1 and LATITUDE-"+Lat+"<0.1  "
                         +") SELECT TO_CHAR(version_date,'yyyyMMdd') mdate,  LONGITUDE,  LATITUDE, "
                         +" listagg(SECTOR_ID||'|'||AZIMUTH,',') within GROUP ( "
                         +"ORDER BY LONGITUDE,LATITUDE) sectorId "
                         +"from t where FN_GET_DISTANCE(longitude,latitude,"+Lng+","+Lat+")<=10 "
                         +"GROUP BY LONGITUDE,LATITUDE,version_date";
				
//				System.out.println(sqlString);
			}
		}
		// String part="P"+cityCode+"_"+Date;
		// String sql =
		// " select LONGITUDE,LATITUDE,listagg(SECTOR_ID||'|'||AZIMUTH,',') within GROUP (order by LONGITUDE,LATITUDE) sectorId  from p_lte_sector  subpartition ("+part+") group by LONGITUDE,LATITUDE";
//		System.out.println(sqlString);
		return commonservice.dynamicSql(sqlString);
	}

	/** 地图专用的sql */
	@RequestMapping("/dynamicSqlMap3")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> dynamicSqlMap3(String cityCode,
															 String Date, String Lng, String Lat) throws Exception {
		Object part = null;
		String sqlString = " select subpartition_name p  from  user_tab_subpartitions  where table_name='P_LTE_SECTOR' and subpartition_name like 'P"
				+ cityCode
				+ "_%'  order by  subpartition_name desc";


		List<LinkedHashMap<String, Object>> locHashMaps = commonservice
				.dynamicSql(sqlString);
		if (locHashMaps != null && locHashMaps.size() > 0) {
			for (LinkedHashMap<String, Object> k : locHashMaps) {
				//System.out.println("select count(1) from p_lte_sector subpartition ("+ k.get("P") + ") where rownum<2");
				if (commonservice
						.dynamicSqltoInt("select count(1) from p_lte_sector subpartition ("
								+ k.get("P") + ") where rownum<2") > 0) {
					part = k.get("P");
					break;
				}
			}
		}

//		part="P"+cityCode+"_"+part;
		if (part != null) {
			if (Lng == null || Lng.isEmpty()) {
				sqlString = "select to_char(version_date,'yyyyMMdd') mdate,LONGITUDE,LATITUDE,listagg(SECTOR_ID||'|'||AZIMUTH,',') within GROUP (order by LONGITUDE,LATITUDE) sectorId  from p_lte_sector  subpartition ("
						+ part + ") where LONGITUDE is not null and LATITUDE is not null and AZIMUTH>=0 and AZIMUTH<360 group by LONGITUDE,LATITUDE,version_date";
			} else {
//				sqlString = "select to_char(version_date,'yyyyMMdd') mdate,LONGITUDE,LATITUDE,listagg(SECTOR_ID||'|'||AZIMUTH,',') within GROUP (order by LONGITUDE,LATITUDE) sectorId  from p_lte_sector  subpartition ("
//						+ part
//						+ ")  where  LONGITUDE is not null and LATITUDE is not null and AZIMUTH>=0 and AZIMUTH<360 and FN_GET_DISTANCE(longitude,latitude,"
//						+ Lng
//						+ "," + Lat + ")<=10 group by LONGITUDE,LATITUDE,version_date";
				sqlString="with t as ( select version_date,LONGITUDE,  LATITUDE,SECTOR_ID,AZIMUTH "
						+" FROM p_lte_sector subpartition ("+part+") "
						+"WHERE LONGITUDE IS NOT NULL AND LATITUDE IS NOT NULL "
						+"AND AZIMUTH >=0 AND AZIMUTH <360  and LONGITUDE-"+Lng+">-0.05 and LONGITUDE-"+Lng+"<0.05  "
						+"and LATITUDE-"+Lat+">-0.05 and LATITUDE-"+Lat+"<0.05  "
						+") SELECT TO_CHAR(version_date,'yyyyMMdd') mdate,  LONGITUDE,  LATITUDE, "
						+" listagg(SECTOR_ID||'|'||AZIMUTH,',') within GROUP ( "
						+"ORDER BY LONGITUDE,LATITUDE) sectorId "
						+"from t where FN_GET_DISTANCE(longitude,latitude,"+Lng+","+Lat+")<=1.5 "
						+"GROUP BY LONGITUDE,LATITUDE,version_date";

//				System.out.println(sqlString);
			}
		}
		// String part="P"+cityCode+"_"+Date;
		// String sql =
		// " select LONGITUDE,LATITUDE,listagg(SECTOR_ID||'|'||AZIMUTH,',') within GROUP (order by LONGITUDE,LATITUDE) sectorId  from p_lte_sector  subpartition ("+part+") group by LONGITUDE,LATITUDE";
//		System.out.println(sqlString);
		return commonservice.dynamicSql(sqlString);
	}
	
	/** 地图专用的sql */
	@RequestMapping("/dynamicSqlGsmMap")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> dynamicSqlGsmMap(String cityCode,
			String Date, String Lng, String Lat) throws Exception {
		Object part = null;
		String sqlString = " select subpartition_name p  from  user_tab_subpartitions  where table_name='P_GSM_SECTOR' and subpartition_name like 'P"
				+ cityCode
				+ "_%' and subpartition_name<='P"
				+ cityCode
				+ "_"
				+ Date + "' order by  subpartition_name desc";
		System.out.println(sqlString);
		List<LinkedHashMap<String, Object>> locHashMaps = commonservice
				.dynamicSql(sqlString);
		if (locHashMaps != null && locHashMaps.size() > 0) {
			for (LinkedHashMap<String, Object> k : locHashMaps) {
				System.out.println("select count(1) from P_GSM_SECTOR subpartition ("+ k.get("P") + ") where rownum<2");
				if (commonservice
						.dynamicSqltoInt("select count(1) from P_GSM_SECTOR subpartition ("
								+ k.get("P") + ") where rownum<2") > 0) {
					part = k.get("P");
					break;
				}
			}
		}
		if (part != null) {
			if (Lng == null || Lng.isEmpty()) {
				sqlString = "select LONGITUDE,LATITUDE,listagg(SECTOR_ID||'|'||AZIMUTH,',') within GROUP (order by LONGITUDE,LATITUDE) sectorId  from P_GSM_SECTOR  subpartition ("
						+ part + ") where LONGITUDE is not null and LATITUDE is not null and AZIMUTH>=0 and AZIMUTH<360 group by LONGITUDE,LATITUDE";
			} else {
				sqlString = "select LONGITUDE,LATITUDE,listagg(SECTOR_ID||'|'||AZIMUTH,',') within GROUP (order by LONGITUDE,LATITUDE) sectorId  from P_GSM_SECTOR  subpartition ("
						+ part
						+ ")  where  LONGITUDE is not null and LATITUDE is not null and AZIMUTH>=0 and AZIMUTH<360 and FN_GET_DISTANCE(longitude,latitude,"
						+ Lng
						+ "," + Lat + ")<=10 group by LONGITUDE,LATITUDE";
			}
		}
		// String part="P"+cityCode+"_"+Date;
		// String sql =
		// " select LONGITUDE,LATITUDE,listagg(SECTOR_ID||'|'||AZIMUTH,',') within GROUP (order by LONGITUDE,LATITUDE) sectorId  from p_lte_sector  subpartition ("+part+") group by LONGITUDE,LATITUDE";
//		System.out.println(sqlString);
		return commonservice.dynamicSql(sqlString);
	}
	
	@RequestMapping("/getSiteName")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> getSiteName(String cityCode,String Date) throws Exception {
		String part="P"+cityCode+"_"+Date;
		String sql = " select distinct ENODEBID,ENODEB_NAME from  p_lte_sector  subpartition ("+part+") where LONGITUDE is not null and LATITUDE is not null ";
		return commonservice.dynamicSql(sql);
	}
	
	@RequestMapping("/getSiteNameNew")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> getSiteNameNew(@RequestBody Map<String, Object> map) throws Exception {
	    if(!map.containsKey("citycode"))return null;
	    String where  = " city_code='"+map.get("citycode")+"' ";
	    if(map.containsKey("sdate") && map.containsKey("edate")){
		where += " and version_date>=to_date('"+map.get("sdate")+"','YYYYMMDD') and version_date<=to_date('"+map.get("edate")+"','YYYYMMDD')  ";
	    }
	    if(map.containsKey("mdate") ){
		where += " and version_date=to_date('"+map.get("mdate")+"','YYYYMMDD')  ";
	    }
	    if(map.containsKey("lat") && map.containsKey("lng")){
		String lat = map.get("lat").toString();
		String lng = map.get("lng").toString();
	 	where += " LONGITUDE-"+lng+">-0.1 and LONGITUDE-"+lng+"<0.1  and LATITUDE-"+lat+">-0.1 and LATITUDE-"+lat+"<0.1  ";
	    }
		String sql = " select distinct ENODEBID,ENODEB_NAME from  p_lte_sector  where "+where+" LONGITUDE is not null and LATITUDE is not null";
		return commonservice.dynamicSql(sql);
	}
	
	/** 分页的动态sql查询 在这里组装查询的sql */
	@RequestMapping("/dynamicSqlforpage")
	@ResponseBody
	public PageInfo<LinkedHashMap<String, Object>> dynamicSqlforpage(
			Integer pageNo, Integer pageSize) throws Exception {
		String sql = "";
		return commonservice.dynamicSqlforpage(sql, pageNo, pageSize);
	}

	/** 返回行政区号 */
	public PartitionPojo getDepartmentCode(PartitionPojo pojo) {
		try {
			DepartmentPojo dpojo = new DepartmentPojo();
			dpojo.setDeptname(pojo.getDeptName());
			List<DepartmentPojo> dpojos = departmentservice.query(dpojo);
			if (dpojos != null && dpojos.size() == 1) {
				pojo.setCityCode(dpojos.get(0).getDeptcode());
				pojo.setDeptName("");
			}
			return pojo;
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping("/QuerySite")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> QuerySite(String cityCode,
														 String Date, String City, String Query) {
		try {
			if (Query == null || Query.equals("") || Query.equals("undefined"))
				return null;
			if (cityCode == null || cityCode.equals("")
					|| cityCode.equals("undefined")) {
				cityCode = commonservice
						.dynamicSql(
								"select FN_GET_PARTITION_NAME('" + City
										+ "') CITY_CODE from dual").get(0)
						.get("CITY_CODE").toString();
			}
			String sql = "select  distinct LONGITUDE LNG, LATITUDE LAT, AZIMUTH DIR from "
					+ " (select  LONGITUDE, LATITUDE, AZIMUTH from P_lte_sector where SECTOR_NAME = '%s' and CITY_code='%s' and VERSION_DATE= TO_DATE('%s', 'YYYYMMDD')  "
					+ " union  "
					+ " select  LONGITUDE, LATITUDE, AZIMUTH from P_lte_sector where SECTOR_ID = '%s' and CITY_code='%s' and VERSION_DATE= TO_DATE('%s', 'YYYYMMDD')   )"
					+ " where rownum<=2";

			return commonservice.dynamicSql(String.format(sql, Query, cityCode,
					Date, Query, cityCode, Date));
		} catch (Exception e) {
			e.printStackTrace();
//			logger.info("QuerySite-->" + e.getMessage());
			return null;
		}

	}


}
