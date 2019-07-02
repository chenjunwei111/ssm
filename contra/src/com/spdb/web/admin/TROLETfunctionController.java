package com.spdb.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;
import com.spdb.service.generator.CommonService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.spdb.pojo.admin.TROLETfunctionPojo;
import com.spdb.pojo.base.RoleObjPojo;
import com.spdb.service.admin.TROLETfunctionService;

/**
 * 用户权限
 * 
 * @author Chan
 */

@Controller
@RequestMapping("/TROLETfunction")
public class TROLETfunctionController {

    @Resource
    TROLETfunctionService service;
    @Resource
    CommonService commonservice;

    /** 用户权限插入语句 */
    @RequestMapping("/insert")
    @ResponseBody
    public Integer insert(@RequestBody TROLETfunctionPojo pojo) {
	try {
	    service.insert(pojo);
	    return 1;
	} catch (Exception e) {
	    return 0;
	}
    }

    /** 用户权限删除语句 */
    @RequestMapping("/delete")
    @ResponseBody
    public Integer delete(@RequestBody TROLETfunctionPojo pojo) {
	try {
	    service.delete(pojo);
	    return 1;
	} catch (Exception e) {
	    return 0;
	}
    }

    /** 用户权限更新语句 */
    @RequestMapping("/update")
    @ResponseBody
    public Integer update(@RequestBody TROLETfunctionPojo pojo) {
	try {
	    service.update(pojo);
	    return 1;
	} catch (Exception e) {
	    return 0;
	}
    }

    /** 用户权限查询语句(参数form),根据条件查询出所有的数据集 */
    @RequestMapping("/query")
    @ResponseBody
    public List<TROLETfunctionPojo> query(@RequestBody TROLETfunctionPojo pojo) {
	try {
	    return service.query(pojo);
	} catch (Exception e) {
	    return null;
	}
    }

    /** 用户权限查询分页语句(参数form),根据条件查询出每页的数据集 */
    @RequestMapping("/queryforpage")
    @ResponseBody
    public PageInfo<TROLETfunctionPojo> queryforpage(@RequestBody TROLETfunctionPojo pojo, String field, String sort, Integer pageNo, Integer pageSize) {
	try {
	    return service.queryforpage(pojo, field, sort, pageNo, pageSize);
	} catch (Exception e) {
	    return null;
	}
    }

    /** 批量插入角色功能表 */
    // /TROLETfunction/insertListRoidFun
    @RequestMapping("/insertListRoidFun")
    @ResponseBody
    public String insertListRoidFun(@RequestBody RoleObjPojo pojo) {
	if (pojo == null)
	    return "error";
	try {
	    List<TROLETfunctionPojo> tfList = new ArrayList<TROLETfunctionPojo>();
	    for (int i = 0; i < pojo.getVs().length; i++) {
		tfList.add(new TROLETfunctionPojo(pojo.getRoleid(), pojo.getVs()[i]));
	    }
	    int res = service.insetListFun(tfList, pojo.getVs(), pojo.getRoleid());
	    if (res > 0) {
		return "ok";
	    } else {
		return "error";
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    return "error";
	}
    }

}
