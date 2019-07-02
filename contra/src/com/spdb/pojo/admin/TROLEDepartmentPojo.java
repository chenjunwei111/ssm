package com.spdb.pojo.admin;


/**
 * 角色部门
 * 
 * @author Chan
 */

public class TROLEDepartmentPojo {

	private String roleId;
	private String deptCode;

	
	
	public TROLEDepartmentPojo() {
		super();
	}

	public TROLEDepartmentPojo(String roleId, String deptCode) {
		super();
		this.roleId = roleId;
		this.deptCode = deptCode;
	}

	public void setRoleid(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleid() {
		return roleId;
	}

	public void setDeptcode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptcode() {
		return deptCode;
	}

	@Override
	public String toString() {
		return "TROLEDepartmentPojo [roleId=" + roleId + ", deptCode="
				+ deptCode + "]";
	}
}
