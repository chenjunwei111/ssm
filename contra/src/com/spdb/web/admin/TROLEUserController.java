package com.spdb.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.spdb.service.generator.CommonService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spdb.pojo.admin.TROLEUserPojo;
import com.spdb.pojo.base.RoleObjPojo;
import com.spdb.service.admin.TROLEUserService;

/**
 * 用户权限
 * 
 * @author Chan
 */

@Controller
@RequestMapping("/TROLEUser")
public class TROLEUserController {
	@Resource
	TROLEUserService service;
	@Resource
	CommonService commonservice;

	

	/** 批量插入角色用户表 */
//	/TROLEUser/insertListRoleUser
	@RequestMapping("/insertListRoleUser")
	@ResponseBody
	public String  insertListRoidFun(@RequestBody RoleObjPojo pojo) {
		try {
		    if(pojo==null || pojo.getRoleid()==null||"".equals(pojo.getRoleid())){
			return	"error";
		    }
		    if(pojo.getVs()==null || (pojo.getVs().length==1 && "".equals(pojo.getVs()[0]))){
			int res=service.insetListUser(null,pojo.getVs(),pojo.getRoleid());
			if(res>0){
				return	"ok";
			}else {
				return	"error";
			}
		    }		    
			List<TROLEUserPojo> tfList=new ArrayList<TROLEUserPojo>();
			   for (int i = 0; i < pojo.getVs().length; i++) {
				tfList.add(new TROLEUserPojo(pojo.getRoleid(), pojo.getVs()[i])); 
			}
			int res=service.insetListUser(tfList,pojo.getVs(),pojo.getRoleid());
			if(res>0){
				return	"ok";
			}else {
				return	"error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return	"error";
		}
	}


}
