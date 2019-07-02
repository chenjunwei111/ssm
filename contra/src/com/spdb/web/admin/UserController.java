package com.spdb.web.admin;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.spdb.common.MD5Util;
import com.spdb.pojo.admin.UsersPojo;
import com.spdb.pojo.base.PLteSectorPojo;
import com.spdb.service.admin.UsersService;
import com.spdb.service.base.DepartmentService;
import com.spdb.service.generator.CommonService;

@Controller
@RequestMapping("/User")
public class UserController {

    @Resource
    CommonService commonservice;

    @Resource
    DepartmentService departmentservice;

    @Resource
    UsersService usersService;

    // 用户列表
    @RequestMapping("/getUserList")
    @ResponseBody
    public Map<String, Object> getUserList(@RequestBody PLteSectorPojo pojo, String field, String sort, Integer pageNo, Integer pageSize) {
	Map<String, Object> maps = new LinkedHashMap<String, Object>();
	try {
	    String sql = "";
	    sql = "Select USER_CODE, USER_NAME, PASSWORD, PHONE, DEPT_CODE, DEPT_NAME, ISVALID,  ISLOGIN, to_char(LASTLOGIN,'YYYY-MM-DD hh24:mi:ss') LASTLOGIN, EMAIL from USERS  where 1=1 ";
	    if (pojo != null && pojo.getSectorid() != null &&  !"".equals(pojo.getSectorid())) {
		sql = sql + " and PHONE like '%" + pojo.getSectorid() + "%' ";
	    } 
	    if (pojo != null && pojo.getCity() != null&&  !"".equals(pojo.getCity())) {
		sql = sql + " and USER_NAME like '%" + pojo.getCity() + "%' ";
	    }

	    PageInfo<LinkedHashMap<String, Object>> list = commonservice.dynamicSqlforpage(sql, pageNo, pageSize);
	    if (list == null) {
		maps.clear();
		maps.put("code", 0);// 成功返回代码
		maps.put("msg", "success");// 返回信息
		maps.put("total", 0);// 数据总量
		maps.put("list", null);// 返回数据的list集合
		return maps;
	    }
	    maps.put("code", 0);// 成功返回代码
	    maps.put("msg", "success");// 返回信息
	    maps.put("total", list.getTotal());// 数据总量
	    List<LinkedHashMap<String, Object>> listold = list.getList();
	    maps.put("list", listold);// 返回数据的list集合
	    return maps;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    maps.clear();
	    maps.put("code", 0);// 成功返回代码
	    maps.put("msg", "success");// 返回信息
	    maps.put("total", 0);// 数据总量
	    maps.put("list", null);// 返回数据的list集合
	    return maps;
	}
    }

    // 角色添加用户-->用户列表
    @RequestMapping("/getUserListByCheckBox")
    @ResponseBody
    public Map<String, Object> getUserListByCheckBox(@RequestBody PLteSectorPojo pojo, String field, String sort, Integer pageNo, Integer pageSize) {
	Map<String, Object> maps = new LinkedHashMap<String, Object>();
	try {
	    String roleid = pojo.getSectorid();
	    String sql = " Select c.user_code, c.user_name, nvl2(t.ROLE_ID,1,0) LAY_CHECKED,c.DEPT_NAME,c.DEPT_CODE,c.ISVALID " +
	    " from users c left join (select * from  TROLE_user where ROLE_ID='" + roleid + "') t  " + " on c.user_code=t.user_code where 1=1 and c.ISVALID =1  ";
	    //cellid:省的city_code,citycode:地市的city_code
	    if (pojo.getCitycode() != null && "不限".equals(pojo.getCitycode()) == false) {
		sql = sql + " and DEPT_CODE in (Select  dept_code from department where parent_dept_code in (    Select dept_code from department where area_code="+pojo.getCitycode()+") ) " ;
	    }
	    else if (pojo.getCellid() != null && "不限".equals(pojo.getCellid()) == false) {
		sql = sql + " and DEPT_CODE in (Select DEPT_CODE from department where PARENT_DEPT_CODE='" + pojo.getCellid() + "') ";
	    }
	    
	    sql=sql+" order by LAY_CHECKED desc";
	    
	    System.out.println("查询用户："+sql);
	    PageInfo<LinkedHashMap<String, Object>> list = commonservice.dynamicSqlforpage(sql, pageNo, pageSize);
	    
	    List<LinkedHashMap<String, Object>> AllList = commonservice.dynamicSql(sql);

	    
	    
	    if (list == null) {
		maps.clear();
		maps.put("code", 0);// 成功返回代码
		maps.put("msg", "success");// 返回信息
		maps.put("total", 0);// 数据总量
		maps.put("list", null);// 返回数据的list集合
		return maps;
	    }
	    maps.put("code", 0);// 成功返回代码
	    maps.put("msg", "success");// 返回信息
	    maps.put("total", list.getTotal());// 数据总量	    
	    List<LinkedHashMap<String, Object>> ll = list.getList();
	    List<LinkedHashMap<String, Object>> lnew = getCheckBoxList(ll);
	    maps.put("list", lnew);// 返回数据的list集合
	    maps.put("allTotal", getCheckBoxList(AllList));
	    return maps;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    maps.clear();
	    maps.put("code", 0);// 成功返回代码
	    maps.put("msg", "success");// 返回信息
	    maps.put("total", 0);// 数据总量
	    maps.put("list", null);// 返回数据的list集合
	    return maps;
	}
    }

    private List<LinkedHashMap<String, Object>> getCheckBoxList(List<LinkedHashMap<String, Object>> ll) {
	if(ll==null||ll.size()==0)return null;
	List<LinkedHashMap<String, Object>> list = new ArrayList<LinkedHashMap<String, Object>>();
	for (LinkedHashMap<String, Object> map : ll) {
	    String LAY_CHECKED = map.get("LAY_CHECKED").toString();
	    LinkedHashMap<String, Object> m=new LinkedHashMap<String, Object>();
	    m.put("USER_CODE", map.get("USER_CODE"));
	    m.put("USER_NAME", map.get("USER_NAME"));	   
	    m.put("DEPT_NAME", map.get("DEPT_NAME"));
	    m.put("DEPT_CODE", map.get("DEPT_CODE"));
	    m.put("ISVALID", map.get("ISVALID"));	   
	    
	    if ("1".equals(LAY_CHECKED)) {
		m.put("LAY_CHECKED", true);	
	    }else{
	    m.put("LAY_CHECKED", null);	
	    }
	    list.add(m);
	}
	return list;
    }
    
    // 角色添加用户-->用户列表,左右切换选择列表
    @RequestMapping("/getUserListByDoubleCheckBox")
    @ResponseBody
    public List<LinkedHashMap<String, Object>> getUserListByDoubleCheckBox(@RequestBody PLteSectorPojo pojo) {	
	try {
	    String roleid = pojo.getSectorid();
	    String sql = " Select c.user_code, c.user_name, c.phone,nvl2(t.ROLE_ID,1,0) LAY_CHECKED,c.DEPT_NAME,c.DEPT_CODE,c.ISVALID " +
	    " from users c left join (select * from  TROLE_user where ROLE_ID='" + roleid + "') t  " + " on c.user_code=t.user_code where 1=1 and c.ISVALID =1  ";
	    sql=sql+" order by c.user_code";	  
	    List<LinkedHashMap<String, Object>> list = commonservice.dynamicSql(sql) ;	
	    return list;	  
	} catch (Exception ex) {
	    ex.printStackTrace();	   
	    return null;
	}
    }

    // 获取单个用户
    @RequestMapping("/getOneUser")
    @ResponseBody
    public Map<String, Object> getOneUser(@RequestBody PLteSectorPojo pojo) {
	Map<String, Object> maps = new LinkedHashMap<String, Object>();
	try {
	    String sql = "";
	    sql = "Select * from Users where  USER_CODE='" + pojo.getCellid() + "'";
	    List<LinkedHashMap<String, Object>> list = commonservice.dynamicSql(sql);
	    if (list == null) {
		return maps;
	    }
//	    解密
	    String pwd=list.get(0).get("PASSWORD").toString();
	    pwd=MD5Util.convertMD5(pwd);
	    list.get(0).put("PASSWORD", pwd);
	    maps = list.get(0);
	    return maps;
	} catch (Exception ex) {
	    return maps;
	}
    }

    // 编辑用户
    @RequestMapping("/editOneUser")
    @ResponseBody
    public String editOneUser(@RequestBody UsersPojo pojo) {
	if (pojo == null || pojo.getUsername() == null)
	    return "error";
	try {
//		密码加密
	    String pwd=pojo.getPassword();
	    pwd=MD5Util.convertMD5(pwd);
	    pojo.setPassword(pwd); 
		
	    int res = usersService.update(pojo);
	    if (res == 1) {
		return "ok";
	    } else {
		return "error";
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return "error";
	}
    }

    // 添加用户
    @RequestMapping("/addOneUser")
    @ResponseBody
    public String addOneUser(@RequestBody UsersPojo pojo) {
	if(pojo==null||pojo.getUsername()==null){
	    return "数据为空";
	}
	if(hasUserName(pojo.getUsername())){
	    return "用户名："+pojo.getUsername()+" 已存在";
	}
	try {
	    // 根据Code判断是否已存在该角色
	    String sql = "select count(0) COUNTCODE from users where USER_NAME='" + pojo.getUsername() + "'";
	    List<LinkedHashMap<String, Object>> list = commonservice.dynamicSql(sql);
	    if (Integer.parseInt(list.get(0).get("COUNTCODE").toString()) > 0) {
		return "error";
	    }
	    pojo.setUsercode(java.util.UUID.randomUUID().toString().replace("-", ""));
//	    密码加密
	    String pwd=pojo.getPassword();
	    pwd=MD5Util.convertMD5(pwd);
	    pojo.setPassword(pwd); 
	    int res = usersService.insert(pojo);
	    if (res == 1) {
		return "ok";
	    } else {
		return "error";
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return "error";
	}
    }
    
    //用户名是否存在 
    public boolean hasUserName( String name) {
	try {
	  
	    String sql = "Select count(0) cnt from USERS where USER_NAME='" + name + "'";
	    Integer cnt = commonservice.dynamicSqltoInt(sql);
	    if (cnt > 0) {
		return true;
	    }
	    return false;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return false;
	}
    }

}
