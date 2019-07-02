package com.spdb.pojo.admin;


/**
 * 用户权限
 * 
 * @author Chan
 */

public class TrolePojo {

	private String roleName;
	private String description;
	private Integer isvalid;
	private String roleId;

	
	
	public TrolePojo(String roleName, String description, Integer isvalid,
			String roleId) {
		super();
		this.roleName = roleName;
		this.description = description;
		this.isvalid = isvalid;
		this.roleId = roleId;
	}

	public TrolePojo() {
		super();
	}

	public void setRolename(String roleName) {
		this.roleName = roleName;
	}

	public String getRolename() {
		return roleName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setRoleid(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleid() {
		return roleId;
	}

	@Override
	public String toString() {
		return "TrolePojo [roleName=" + roleName + ", description="
				+ description + ", isvalid=" + isvalid + ", roleId=" + roleId
				+ "]";
	}
	
	

}
