package com.spdb.pojo.admin;

import java.sql.Date;

/**
 * 用户权限
 * 
 * @author Chan
 */

public class TROLETfunctionPojo {

	private String roleId;
	private String functionCode;

	
	
	public TROLETfunctionPojo() {
		super();
	}

	public TROLETfunctionPojo(String roleId, String functionCode) {
		super();
		this.roleId = roleId;
		this.functionCode = functionCode;
	}

	public void setRoleid(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleid() {
		return roleId;
	}

	public void setFunctioncode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getFunctioncode() {
		return functionCode;
	}

	@Override
	public String toString() {
		return "TROLETfunctionPojo [roleId=" + roleId + ", functionCode="
				+ functionCode + "]";
	}

	
}
