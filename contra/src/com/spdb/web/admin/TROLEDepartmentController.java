package com.spdb.web.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spdb.pojo.admin.TROLEDepartmentPojo;
import com.spdb.pojo.base.RoleObjPojo;
import com.spdb.service.generator.CommonService;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spdb.service.admin.TROLEDepartmentService;

/**
 * 角色部门
 * 
 * @author Chan
 */

@Controller
@RequestMapping("/TROLEDepartment")
public class TROLEDepartmentController {
    @Resource
    TROLEDepartmentService service;
    @Resource
    CommonService commonservice;
    
	public static Logger logger=Logger.getLogger(TROLEDepartmentController.class);


    /** 批量插入角色部门表 */
    // /TROLEDepartment/insertListRoleDept
    @RequestMapping("/insertListRoleDept")
    @ResponseBody
    public String insertListRoleDept(@RequestBody RoleObjPojo pojo) {
	if (pojo == null)
	    return "error";
	try {
	    List<TROLEDepartmentPojo> tfList = new ArrayList<TROLEDepartmentPojo>();
	    for (int i = 0; i < pojo.getVs().length; i++) {
		tfList.add(new TROLEDepartmentPojo(pojo.getRoleid(), pojo.getVs()[i]));
	    }
	    int res = service.insetListDept(tfList, pojo.getRoleid(), pojo.getVs());
	    if (res > 0) {
		return "ok";
	    } else {
		return "error";
	    }
	} catch (Exception e) {
		logger.error("错误信息："+e.getMessage(),e);
	    return "error";
	}
    }
    
    

    /**
     * @param pojo
     * @return
     */
    @RequestMapping("/getSelectCity")
    @ResponseBody
    public List<LinkedHashMap<String, Object>> getSelectCity(String roleId) {
	   String sql=null;
	try {
	   sql="select  DISTINCT t3.DEPT_NAME,t1.DEPT_CODE from trole_department t1 "
               +" inner join trole t2 on t1.ROLE_ID=t2.ROLE_ID "
               +" and t1.role_id IN ('"+roleId.replace("/", "','")+"')"
               +" inner join department t3 on t1.DEPT_CODE =t3.AREA_CODE and t3.ISVALID=1 "
               + "and t3.PARENT_DEPT_CODE not in (select DEPT_CODE from department where PARENT_DEPT_CODE='YUNNAN') "
               + "and PARENT_DEPT_CODE！='ROOT' ORDER BY DEPT_CODE";
//	 System.out.println("获取地市下拉列表"+sql);
	  return commonservice.dynamicSql(sql);
	} catch (Exception e) {
		logger.error("查询SQL："+sql+"\n 错误信息："+e.getMessage(),e);
	    return null;
	}
    }
    
    
    /**
     * APP获取地市下拉列表
     * @param 
     * @return
     */
    @RequestMapping("/getSelectCityList")
    @ResponseBody
    public Map<String, Object> getSelectCityList(String deptCode,
    		HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> maps = new HashMap<String, Object>();// 定义指定的分页数据
    	 String sql=null;
    try {
      Object token=request.getHeader("token");
      if(!token.equals("1")){
    		maps.put("return", false);
    		maps.put("status", 300);
    		maps.put("msg", "令牌错误");
    		maps.put("data", null);
    		return maps;
      }
	   sql="select  area_code city_code,dept_name city_name  from department where  ISVALID=1 and "
                +" PARENT_DEPT_CODE=(select DEPT_CODE from department where area_code="+deptCode+")";
	    List<LinkedHashMap<String, Object>>  list=commonservice.dynamicSql(sql);
	    System.out.println("获取APP地市下拉列表："+sql);
		maps.put("return", true);
		maps.put("status", 200);
		maps.put("msg", "请求成功");
		maps.put("data", list);
		return maps;
	} catch (Exception e) {
		logger.error("查询SQL："+sql+"\n 错误信息："+e.getMessage(),e);
		maps.put("return", false);
		maps.put("status", 100);
		maps.put("msg", "失败原因：" + e.getCause());
		maps.put("data", null);
		return maps;
	}
	}
    
     
    /**
     * APP获取地市下拉列表
     * @param pojo
     * @return
     */
    @RequestMapping("/getSelectPropertyList")
    @ResponseBody
    public Map<String, Object> getSelectPropertyList(String deptCode
    		,HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> maps = new HashMap<String, Object>();// 定义指定的分页数据
    	String sql=null;
    	try {
		 Object token=request.getHeader("token");
	      if(!token.equals("1")){
	    		maps.put("return", false);
	    		maps.put("status", 300);
	    		maps.put("msg", "令牌错误");
	    		maps.put("data", null);
	    		return maps;
	      }	
	      
	   sql="select  area_code RPOPERTY_CODE,dept_name RPOPERTY_NAME  from department where  ISVALID=1 and "
                +" PARENT_DEPT_CODE=(select DEPT_CODE from department where area_code="+deptCode+")";
	    List<LinkedHashMap<String, Object>>  list=commonservice.dynamicSql(sql);
//	    System.out.println("获取APP区县下拉列表："+sql);
		maps.put("return", true);
		maps.put("status", 200);
		maps.put("msg", "请求成功");
		maps.put("data", list);
		return maps;
	} catch (Exception e) {
		logger.error("查询SQL："+sql+"\n 错误信息："+e.getMessage(),e);
		maps.put("return", false);
		maps.put("status", 100);
		maps.put("msg", "失败原因：" + e.getCause());
		maps.put("data", null);
		return maps;
	}
	}
    
    
    /**
     * 传cityCode判断地市、区县、省份 级别
     * @param pojo
     * @return
     */
    @RequestMapping("/decideCityLevel")
    @ResponseBody
    public Map<String, Object> decideCityLevel(String cityCode,String token) {
    	Map<String, Object> maps = new HashMap<String, Object>();// 定义指定的分页数据
    	 String sql=null;
    	 if(cityCode==null || cityCode.equals("")){
    			maps.put("return", false);
    			maps.put("status", 100);
    			maps.put("msg", "cityCode为空");
    			maps.put("data", null); 
    	 }
    	try {
	    sql="with t1 as( SELECT  distinct PARENT_DEPT_CODE,dept_name,area_code FROM department where ISVALID=1 "
                +" and  area_code="+cityCode+" ) select t1.dept_name,t1.area_code, (case when  t1.PARENT_DEPT_CODE ='ROOT' then 'province' else  "
                +" (case when ( SELECT  distinct PARENT_DEPT_CODE FROM department where ISVALID=1 "
                +" and  DEPT_CODE=t1.PARENT_DEPT_CODE)!='YUNNAN' then 'city' else 'property' end ) end "
                +" )  levelgrade,(select AREA_CODE from department where DEPT_CODE=t1.PARENT_DEPT_CODE)  "
                +" PARENT_AREA_CODE from  t1";
	    List<LinkedHashMap<String, Object>>  list=commonservice.dynamicSql(sql);
//	    System.out.println(" 传cityCode判断 级别："+sql);
		maps.put("return", true);
		maps.put("status", 200);
		maps.put("msg", "请求成功");
		maps.put("data", list);
		return maps;
	} catch (Exception e) {
		logger.error("查询SQL："+sql+"\n 错误信息："+e.getMessage(),e);
		maps.put("return", false);
		maps.put("status", 100);
		maps.put("msg", "失败原因：" + e.getCause());
		maps.put("data", null);
		return maps;
	}
	}
   
    
    /**
     * 查询所有地市
     * @param pojo
     * @return
     */
    @RequestMapping("/getSelectAllCity")
    @ResponseBody
    public List<LinkedHashMap<String, Object>> getSelectAllCity() {
		try {
		  String sql= "SELECT t.dept_name,t.area_code  FROM department t where t.parent_dept_code='YUNNAN'";
		  return commonservice.dynamicSql(sql);
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
    }
    
    
    
    /**
     * @param pojo
     * @return
     */
    @RequestMapping("/getSelectArea")
    @ResponseBody
    public List<LinkedHashMap<String, Object>> getSelectArea(String cityCode) {
		try {
		  String sql=
				  "\n" +
						  "select t1.DEPT_NAME, T1.AREA_CODE\n" + 
						  "  from department t1\n" + 
						  " where t1.parent_dept_code =\n" + 
						  "       (SELECT dept_code FROM department t where t.area_code = '"+cityCode+"')";
	
		  return commonservice.dynamicSql(sql);
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
    }
    
    /**
     * @param cityCode
     * @return
     * @author spdb_jys
     */
    @RequestMapping("/getSelectAreaByLevel")
    @ResponseBody
    public List<LinkedHashMap<String, Object>> getSelectAreaByLevel(String cityCode) {
		try {
		  String sql="select * from (SELECT distinct t.DISTRICT_NAME,t.DISTRICT_CODE,t.DISTRICT_SEQUENCE  "
		  		+ "FROM department_level t where t.CITY_CODE='"+cityCode+"') order by DISTRICT_SEQUENCE";

		  return commonservice.dynamicSql(sql);
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
    }
    
    /**
     * 查询所有地市
     * @return
     * @author spdb_jys
     */
    @RequestMapping("/getSelectAllCityByLevel")
    @ResponseBody
    public List<LinkedHashMap<String, Object>> getSelectAllCityByLevel() {
		try {
		  String sql= "select * from (SELECT distinct t.CITY_NAME,t.CITY_CODE,t.CITY_SEQUENCE  FROM department_level t where t.PROVINCE_CODE='530000') order by CITY_SEQUENCE";
		  return commonservice.dynamicSql(sql);
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
    }

}
