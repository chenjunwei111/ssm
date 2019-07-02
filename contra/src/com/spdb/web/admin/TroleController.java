package com.spdb.web.admin;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.UUID;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;
import com.spdb.pojo.base.PLteSectorPojo;
import com.spdb.service.base.DepartmentService;
import com.spdb.service.generator.CommonService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.spdb.pojo.admin.TrolePojo;
import com.spdb.service.admin.TroleService;

/**
 * 用户权限
 * 
 * @author Chan
 */

/**
 * @author MMC
 * 
 */
@Controller
@RequestMapping("/Trole")
public class TroleController {
    @Resource
    TroleService service;
    @Resource
    CommonService commonservice;
    @Resource
    DepartmentService departmentservice;

    /**
     * 角色列表 --所有查询
     * 
     * @param pojo
     * @param field
     * @param sort
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/getRoleList")
    @ResponseBody
    public Map<String, Object> getRoleList(@RequestBody PLteSectorPojo pojo, String field, String sort, Integer pageNo, Integer pageSize) {
	Map<String, Object> maps = new LinkedHashMap<String, Object>();
	try {
	    String sql = "";
	    sql = "Select * from trole  ";
	    if (pojo != null && pojo.getSectorid() != null) {
		sql = sql + " where ROLE_NAME like '%" + pojo.getSectorid() + "%'";
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

    /**
     * 获取单个角色
     * 
     * @param pojo
     * @return
     */
    @RequestMapping("/getOneRole")
    @ResponseBody
    public Map<String, Object> getOneRole(@RequestBody PLteSectorPojo pojo) {
	Map<String, Object> maps = new LinkedHashMap<String, Object>();
	try {
	    String sql = "";
	    sql = "Select * from trole where  ROLE_ID='" + pojo.getCellid() + "'";
	    List<LinkedHashMap<String, Object>> list = commonservice.dynamicSql(sql);
	    if (list == null) {
		return maps;
	    }
	    maps = list.get(0);
	    return maps;
	} catch (Exception ex) {
	    return maps;
	}
    }

    /**
     * 编辑角色
     * 
     * @param pojo
     * @return
     */
    @RequestMapping("/editOneRole")
    @ResponseBody
    public String editOneRole(@RequestBody TrolePojo pojo) {
	if(pojo==null||pojo.getRoleid()=="")return "error";
	try {
	    int res = service.updateRole(pojo);
	    if (res == 1) {
		return "ok";
	    } else {
		return "error";
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    return "error";
	}
    }

    // 添加角色
    @RequestMapping("/addOneRole")
    @ResponseBody
    public String addOneRole(@RequestBody TrolePojo pojo) {
	if (pojo == null || pojo.getRolename() == null) {
	    return "数据为空";
	}
	if (hasRoleName(pojo.getRolename())) {
	    return "角色名：" + pojo.getRolename() + " 已存在";
	}
	try {
	    UUID roleId = java.util.UUID.randomUUID();
	    String sql = "select count(0) RCOUNT from trole where ROLE_ID='" + roleId.toString().replace("-", "") + "'";
	    List<LinkedHashMap<String, Object>> list = commonservice.dynamicSql(sql);
	    if (Integer.parseInt(list.get(0).get("RCOUNT").toString()) > 0) {
		roleId = java.util.UUID.randomUUID();
	    }
	    pojo.setRoleid(roleId.toString().replace("-", ""));
	    Integer res = service.insert(pojo);
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

    // 插入数据时，判断角色名是否存在
    public boolean hasRoleName(String name) {
	try {
	    String sql = "Select count(0) cnt from TRole where ROLE_NAME='" + name + "'";
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
