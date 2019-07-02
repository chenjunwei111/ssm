package com.spdb.pojo.admin;

import java.sql.Date;

/**
 * 用户权限
 * 
 * @author Chan
 */

public class UsersPojo {

	private String userCode;
	private String userName;
	private String password;
	private String phone;
	private String deptCode;
	private String deptName;
	private Integer isvalid;
	private Integer islogin;
	private java.sql.Timestamp  lastlogin;
	private String email;
	private String organizations;

	
	
	public UsersPojo() {
		super();
	}

	public UsersPojo(String userCode, String userName, String password,
			String phone, String deptCode, String deptName, Integer isvalid,
			Integer islogin, java.sql.Timestamp lastlogin, String email, String organizations) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.isvalid = isvalid;
		this.islogin = islogin;
		this.lastlogin = lastlogin;
		this.email = email;
		this.organizations = organizations;
	}

	public void setUsercode(String userCode) {
		this.userCode = userCode;
	}

	public String getUsercode() {
		return userCode;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getUsername() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setDeptcode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptcode() {
		return deptCode;
	}

	public void setDeptname(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptname() {
		return deptName;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIslogin(Integer islogin) {
		this.islogin = islogin;
	}

	public Integer getIslogin() {
		return islogin;
	}

	public void setLastlogin(java.sql.Timestamp  lastlogin) {
		this.lastlogin = lastlogin;
	}

	public java.sql.Timestamp  getLastlogin() {
		return lastlogin;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setOrganizations(String organizations) {
		this.organizations = organizations;
	}

	public String getOrganizations() {
		return organizations;
	}

	@Override
	public String toString() {
		return "UsersPojo [userCode=" + userCode + ", userName=" + userName
				+ ", password=" + password + ", phone=" + phone + ", deptCode="
				+ deptCode + ", deptName=" + deptName + ", isvalid=" + isvalid
				+ ", islogin=" + islogin + ", lastlogin=" + lastlogin
				+ ", email=" + email + ", organizations=" + organizations + "]";
	}

}
