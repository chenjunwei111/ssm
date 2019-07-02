package com.spdb.web.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.spdb.common.ExportTxtUtil;
import com.spdb.service.generator.CommonService;

@Controller
@RequestMapping("/base/CommonController")
public class CommonController {

	public static Logger logger = Logger.getLogger(CommonController.class);

	@Resource
	CommonService commonservice;

	/**
	 * 模糊搜索工单号 原表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/AnalySelectOrder")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> queryLikeOrderNum(@RequestBody Map<String, Object> map)
			throws Exception {
		try {

//			String cityCode=map.get("CITY_CODE")==null?"":" AND CITY_CODE="+map.get("CITY_CODE").toString();
			String orderNum = map.get("ORDERNUM") == null ? "" : map.get("ORDERNUM").toString();

			String sql = "select * from( select distinct ORDERNUM from P_LTE_PARMETER_COMPLAINT_STATE  where state in(5,10,30) and instr(ORDERNUM,'"
					+ orderNum + "')> 0    ) where  rownum <=6";
			// System.out.println(sql);
			return commonservice.dynamicSql(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 模糊搜索电话号码
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryPhone")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> queryPhone(@RequestBody Map<String, Object> map) throws Exception {
		try {

//			String MONTH=map.get("MONTH")==null?"":map.get("MONTH").toString();
			String PHONE = map.get("PHONE") == null ? "" : map.get("PHONE").toString();

			String sql = " SELECT MSISDN AS PHONE FROM  ( select MSISDN from MYD_TEMP_ANALYSIS_TABLE_V10 where instr(msisdn,'"
					+ PHONE + "')> 0 ) where rownum<6 ";
			// System.out.println(sql);
			return commonservice.dynamicSql(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 改变侧边栏坐标
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/changeIcon")
	@ResponseBody
	public String changeIcon(String name, String iconName) throws Exception {
		try {

			String reset = "select * from COC.cfunction where FUNCTION_NAME='" + name + "' ";
			List<LinkedHashMap<String, Object>> listser = commonservice.dynamicSql(reset);
			String resiconCode = "";
			if (listser.size() != 0) {
				resiconCode = listser.get(0).get("FUNCTION_ICON").toString();
			}
			String sql = " update COC.cfunction set FUNCTION_ICON='" + iconName + "' where FUNCTION_NAME='" + name
					+ "'";
			if (commonservice.dynamicSqlUpdate(sql) != 0) {

				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String date = df.format(new Date());

//				跟新SQL
				String updateSql = "\n\n\n\n--更新菜单图标样式 " + date + " \n" + "DECLARE \n" + "TAB_NUM NUMBER(4,0);\n"
						+ "TABLE_CLOB CLOB;\n" + "BEGIN\n" + "TABLE_CLOB:= 'update COC.cfunction set FUNCTION_ICON=''"
						+ iconName + "'' where FUNCTION_NAME=''" + name + "'' ';\n"
						+ "SELECT COUNT(*) INTO TAB_NUM  from COC.cfunction where FUNCTION_NAME='" + name + "';\n"
						+ "IF TAB_NUM!=0 THEN\n" + "EXECUTE IMMEDIATE TABLE_CLOB ;\n" + "COMMIT;\n" + "END IF;\n"
						+ "END;";
				ExportTxtUtil.writeTxtFile(updateSql, "D:\\versionController\\userperce20190514_OYXW.sql");

				// 还原SQL
				String sql2 = " ";
				String resetSql = "\n\n\n\n--还原菜单图标样式 " + date + " \n" + "DECLARE \n" + "TAB_NUM NUMBER(4,0);\n"
						+ "TABLE_CLOB CLOB;\n" + "BEGIN\n" + "TABLE_CLOB:= 'update COC.cfunction set FUNCTION_ICON=''"
						+ resiconCode + "'' where FUNCTION_NAME=''" + name + "'' ';\n"
						+ "SELECT COUNT(*) INTO TAB_NUM  from COC.cfunction where FUNCTION_NAME='" + name + "';\n"
						+ "IF TAB_NUM!=0 THEN\n" + "EXECUTE IMMEDIATE TABLE_CLOB ;\n" + "COMMIT;\n" + "END IF;\n"
						+ "END;";
				ExportTxtUtil.writeTxtFile(resetSql, "D:\\versionController\\userperce20190514_OYXW_RESET.sql");
				return "修改成功";
			} else {
				return "修改失败";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * 获取Active_mq入库记录
	 * 
	 * @return
	 */
	@RequestMapping("/getMqLogData")
	@ResponseBody
	public Map<String, Object> getMqLogData(String selectType, String tableName, String yyyymmdd, Integer pageNo,
			Integer pageSize) {
		Map<String, Object> maps = new HashMap<String, Object>();// 定义指定的分页数据
		try {

			String typeSql = "";
			String taleNameSql = "";
//		if(!selectType.equals("ALL") && !selectType.equals("null")){
//			if(selectType.equals(",")){
//				String type[]=selectType.split(",");
//				typeSql=" and data_table_name like '%"+type[0]+"%' or data_table_name like '%"+type[1]+"%'  ";
//			}else{
//				typeSql=" and data_table_name like '%"+selectType+"%' ";
//			}
//			
//		}
//		
			if (!StringUtils.isBlank(tableName) && !tableName.equals("null")) {
				taleNameSql = " and TARGET_TABLE = '" + tableName + "' ";
			}

//		String sql="select to_char(DATA_INSERT_DATE,'yyyy-mm-dd hh24:mi:ss') DATA_INSERT_DATE,DATA_TABLE_NAME,DATA_TYPE,DATA_PARTITION,DATA_STATE,DATA_NUM,DATA_NUM_SUC,DATA_NUM_FAIL,DATA_COMPLETE_TIME/1000/60 as DATA_COMPLETE_TIME,DATA_CASE,DATA_TABLE_CHINA_NANE "
//				+ "from ACTIVE_MQ_LOG where 1=1 "+typeSql+" "+taleNameSql+" and to_char(DATA_INSERT_DATE,'yyyymmdd')='"+yyyymmdd+"'  ORDER BY DATA_INSERT_DATE desc ";

			String sql = "select TARGET_TABLE as DATA_TABLE_NAME,to_char(CAPTURE_MSG_TIME,'yyyy-mm-dd hh24:mi:ss') as DATA_INSERT_DATE , "
					+ "to_char(END_IMPDB_TIME,'yyyy-mm-dd hh24:mi:ss') as  END_IMPDB_TIME, SOURCE_TYPE as DATA_TYPE, decode(ACTION_STATUE,1,'成功','失败') as DATA_STATE, "
					+ " SUCCESS_NUMBER as DATA_NUM_SUC   , FAILURE_NUMBER as DATA_NUM_FAIL,FILE_SIZE    "
					+ " , round( (END_IMPDB_TIME-CAPTURE_MSG_TIME)*24*60*60) as DATA_COMPLETE_TIME,FAILURE_REASON as DATA_CASE "
					+ " from DATA_DOCKING_LOG where 1=1 and to_char(CAPTURE_MSG_TIME,'yyyymmdd')='" + yyyymmdd + "' "
					+ taleNameSql + "   order by  DATA_INSERT_DATE desc";

//		System.out.println(sql);
			PageInfo<LinkedHashMap<String, Object>> list = commonservice.dynamicSqlforpage(sql, pageNo, pageSize);

			maps.put("code", 0);
			maps.put("msg", "请求成功");
			maps.put("total", list.getTotal());// 数据总量
			maps.put("list", list.getList());
			return maps;
		} catch (Exception e) {
			logger.error(" 错误信息：" + e.getMessage(), e);
			maps.put("code", 100);
			maps.put("msg", "失败原因：" + e.getCause());
			maps.put("total", 0);// 数据总量
			maps.put("list", null);
			return maps;
		}
	}

	/**
	 * 获取Active_mq入库记录
	 * 
	 * @return
	 */
	@RequestMapping("/getMqLogData1")
	@ResponseBody
	public Map<String, Object> getMqLogData1(String selectType, String tableName, Integer pageNo, Integer pageSize) {
		Map<String, Object> maps = new HashMap<String, Object>();// 定义指定的分页数据
		try {

			String typeSql = "";
			String taleNameSql = "";
			if (!selectType.equals("ALL") && !selectType.equals("null")) {
				if (selectType.equals(",")) {
					String type[] = selectType.split(",");
					typeSql = " and TARGET_TABLE like '%" + type[0] + "%' or data_table_name like '%" + type[1]
							+ "%'  ";
				} else {
					typeSql = " and TARGET_TABLE like '%" + selectType + "%' ";
				}

			}
//		
			if (!StringUtils.isBlank(tableName) && !tableName.equals("null")) {
				taleNameSql = " and TARGET_TABLE = '" + tableName + "' ";
			}

//		String sql="with t1 as ( select to_char(DATA_INSERT_DATE,'yyyymmdd') yyyymmdd, DATA_TABLE_NAME,DATA_TABLE_CHINA_NANE,DATA_CASE,DATA_STATE,DATA_TYPE from ACTIVE_MQ_LOG  where 1=1 "+typeSql+" "+taleNameSql+" "
//                   +" ),t2 as (  select YYY YMMDD,DATA_TABLE_NAME,(CASE WHEN sum(case when DATA_STATE='失败' then 1 else 0 end)=0 THEN '是' else '否' end) IS_SUC "
//                   +" ,sum(case when DATA_STATE='成功' then 1 else 0 end) SUC_NUM  , "
//                   +" sum(case when DATA_STATE='失败' then 1 else 0 end) FAIL_NUM  from t1 group by YYYYMMDD ,DATA_TABLE_NAME order by YYYYMMDD) "
//                   +" select distinct  t2.yyyymmdd,t2.DATA_TABLE_NAME,t2.IS_SUC,t2.SUC_NUM,t2.FAIL_NUM,t1. DATA_TYPE,t1.DATA_TABLE_CHINA_NANE  "
//                   +" from t2 inner join t1 on t1.DATA_TABLE_NAME=t2.DATA_TABLE_NAME  order by yyyymmdd desc ";

			String sql = "with t1 as ( "
					+ " select to_char(RECORD_TIME, 'yyyymmdd') AS yyyymmdd,TARGET_TABLE as DATA_TABLE_NAME,FILE_SIZE   "
					+ " ,FAILURE_NUMBER, SUCCESS_NUMBER, decode(ACTION_STATUE,1,'成功','失败') as DATA_STATE,SOURCE_TYPE,FAILURE_REASON as DATA_CASE "
					+ " from DATA_DOCKING_LOG where 1=1 " + taleNameSql + ") "
					+ " ,t2 as (		SELECT YYYYMMDD, DATA_TABLE_NAME			, CASE 				WHEN SUM(CASE 					WHEN DATA_STATE = '失败' THEN 1 "
					+ " ELSE 0				END) = 0 THEN '是'				ELSE '否'			END AS IS_SUC, SUM(CASE 				WHEN DATA_STATE = '成功' THEN 1 "
					+ " ELSE 0			END) AS SUC_NUM, SUM(CASE 				WHEN DATA_STATE = '失败' THEN 1				ELSE 0			END) AS FAIL_NUM "
					+ " FROM t1		GROUP BY YYYYMMDD, DATA_TABLE_NAME		ORDER BY YYYYMMDD) "
					+ " select *from t2 order by yyyymmdd desc ";
//		System.out.println(sql);
			PageInfo<LinkedHashMap<String, Object>> list = commonservice.dynamicSqlforpage(sql, pageNo, pageSize);

			maps.put("code", 0);
			maps.put("msg", "请求成功");
			maps.put("total", list.getTotal());// 数据总量
			maps.put("list", list.getList());
			return maps;
		} catch (Exception e) {
			logger.error(" 错误信息：" + e.getMessage(), e);
			maps.put("code", 100);
			maps.put("msg", "失败原因：" + e.getCause());
			maps.put("total", 0);// 数据总量
			maps.put("list", null);
			return maps;
		}
	}

	/**
	 * 获取功能使用次数
	 * 
	 * @return
	 */
	@RequestMapping("/getFunUseData")
	@ResponseBody
	public Map<String, Object> getFunUseData(String peoPle, Integer pageNo, Integer pageSize) {
		Map<String, Object> maps = new HashMap<String, Object>();// 定义指定的分页数据
		try {

			String whereSql = "";

			String sql = "with  t1 as(select FUNCTION_URI, FUNCTION_PARENT, FUNCTION_NAME,FUNCTION_PEOPLE from P_LTE_USERPERCE_REFECT)\n"
					+ ",a1 as(SELECT  DECODE(t2.FUNCTION_PARENT,'其他','登录',t2.FUNCTION_PARENT ) FUNCTION_PARENT,\n"
					+ " FUNCTION_NAME,t1.CLICK_DATE FROM P_LTE_USERPERCE_XDRLOG t1 INNER JOIN P_LTE_USERPERCE_REFECT t2\n"
					+ "  ON t1. CHILDREN_NAME=t2.FUNCTION_NAME  WHERE PARENT_NAME!='其他' ),a2 as(\n"
					+ " SELECT MAX(CLICK_DATE) last_date, SUM((CASE WHEN TO_CHAR(CLICK_DATE,'yyyymm')=TO_CHAR(sysdate,'yyyymm') THEN 1 ELSE 0 END )) month_count,\n"
					+ "FUNCTION_NAME FROM a1  GROUP BY FUNCTION_NAME),  a3 AS\n"
					+ "(SELECT FUNCTION_NAME,COUNT(0) AS use_num FROM a1 GROUP BY FUNCTION_NAME)\n"
					+ "SELECT  t1.FUNCTION_PARENT,t1.FUNCTION_PEOPLE,a3.FUNCTION_NAME,a3.use_num, TO_CHAR(a2.last_date ,'yyyy-mm-dd hh24:mi:ss') last_date,\n"
					+ "  a2.month_count FROM a2 inner join  a3 on a2.FUNCTION_NAME=a3.FUNCTION_NAME \n"
					+ "left join t1 on a2.FUNCTION_NAME=t1.FUNCTION_NAME\n" + "order by MONTH_COUNT desc ";

//		System.out.println(sql);
			PageInfo<LinkedHashMap<String, Object>> list = commonservice.dynamicSqlforpage(sql, pageNo, pageSize);

			maps.put("code", 0);
			maps.put("msg", "请求成功");
			maps.put("total", list.getTotal());// 数据总量
			maps.put("list", list.getList());
			return maps;
		} catch (Exception e) {
			logger.error(" 错误信息：" + e.getMessage(), e);
			maps.put("code", 100);
			maps.put("msg", "失败原因：" + e.getCause());
			maps.put("total", 0);// 数据总量
			maps.put("list", null);
			return maps;
		}
	}

	/**
	 * 获取用户使用次数
	 * 
	 * @return
	 */
	@RequestMapping("/getFunPeopleData")
	@ResponseBody
	public Map<String, Object> getFunPeopleData(Integer pageNo, Integer pageSize) {
		Map<String, Object> maps = new HashMap<String, Object>();// 定义指定的分页数据
		try {

			String sql = " with a1 as (  SELECT  t1.USER_NAME,DECODE(t2.FUNCTION_PARENT,'其他','登录',t2.FUNCTION_PARENT ) FUNCTION_PARENT,\n"
					+ "FUNCTION_NAME,t1.CLICK_DATE FROM P_LTE_USERPERCE_XDRLOG t1 INNER JOIN P_LTE_USERPERCE_REFECT t2\n"
					+ "  ON t1. CHILDREN_NAME=t2.FUNCTION_NAME  WHERE PARENT_NAME!='其他' and user_name!='匿名访问'  ),  \n"
					+ " a2 as(  select max(CLICK_DATE) last_date,sum((case when to_char(CLICK_DATE,'yyyymm')=\n"
					+ " to_char(sysdate,'yyyymm') then 1 else 0 end )) month_count,USER_NAME  from a1 group by USER_NAME  ), \n"
					+ " a3 as (select  USER_NAME,count(0) as use_num  from  a1 group by USER_NAME)   \n"
					+ " select a3.USER_NAME,a3.use_num,to_char(a2.last_date ,'yyyy-mm-dd hh24:mi:ss') last_date,a2.month_count  \n"
					+ " from a2,a3 where a2.USER_NAME=a3.USER_NAME order by month_count desc";

//		System.out.println(sql);
			PageInfo<LinkedHashMap<String, Object>> list = commonservice.dynamicSqlforpage(sql, pageNo, pageSize);

			maps.put("code", 0);
			maps.put("msg", "请求成功");
			maps.put("total", list.getTotal());// 数据总量
			maps.put("list", list.getList());
			return maps;
		} catch (Exception e) {
			logger.error(" 错误信息：" + e.getMessage(), e);
			maps.put("code", 100);
			maps.put("msg", "失败原因：" + e.getCause());
			maps.put("total", 0);// 数据总量
			maps.put("list", null);
			return maps;
		}
	}

	/**
	 * 获取功能使用次数
	 * 
	 * @return
	 */
	@RequestMapping("/getLteCount")
	@ResponseBody
	public Integer getLteCount(String city, String yyyymmdd) {
		try {
			String citySql = "";
			if (!"全省".equals(city)) {
				citySql = " and city='" + city + "' ";
			}
			String sql = "select count(0) CNT from P_LTE_SECTOR where  version_date=to_date('" + yyyymmdd
					+ "','yyyymmdd')  " + citySql + " ";
			List<LinkedHashMap<String, Object>> list = commonservice.dynamicSql(sql);
			return Integer.parseInt(list.get(0).get("CNT").toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("错误信息：", e);
			return 0;
		}

	}

	/**
	 * WEB获取下拉地市
	 * 
	 * @param pojo
	 * @return
	 */
	@RequestMapping("/getSelectCityAndProperty")
	@ResponseBody
	public Map<String, Object> getSelectCityAndProperty(String cityCode) {
		Map<String, Object> maps = new HashMap<String, Object>();// 定义指定的分页数据
		try {

			String sql = "with t1 as( select * from department "
					+ "	),t2 as (select  dept_name,area_code,dept_code from t1 where t1.area_code=" + cityCode + ") "
					+ "	select  dept_name,area_code from t2 union all "
					+ "	select t1.dept_name,t1.AREA_CODE from t1,t2 where t1.PARENT_DEPT_CODE=t2.dept_code ";
			List<LinkedHashMap<String, Object>> list = commonservice.dynamicSql(sql);
			// System.out.println("获取地市下拉列表，包含本市："+sql);
			maps.put("return", true);
			maps.put("status", 200);
			maps.put("msg", "请求成功");
			maps.put("data", list);
			return maps;
		} catch (Exception e) {
			logger.error(" 错误信息：" + e.getMessage(), e);
			maps.put("return", false);
			maps.put("status", 100);
			maps.put("msg", "失败原因：" + e.getCause());
			maps.put("data", null);
			return maps;
		}
	}

}
