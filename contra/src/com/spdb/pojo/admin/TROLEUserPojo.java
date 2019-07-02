package com.spdb.pojo.admin;
import java.sql.Date;

/**
 * 用户权限

 * @author Chan
*/

public class TROLEUserPojo {

private String roleId;
private String userCode;



public TROLEUserPojo() {
	super();
}

public TROLEUserPojo(String roleId, String userCode) {
	super();
	this.roleId = roleId;
	this.userCode = userCode;
}

public void setRoleid(String roleId) {
		this.roleId = roleId;
}

public String getRoleid() {
		return roleId;
}

public void setUsercode(String userCode) {
		this.userCode = userCode;
}

public String getUsercode() {
		return userCode;
}

@Override
public String toString() {
	return "TROLEUserPojo [roleId=" + roleId + ", userCode=" + userCode + "]";
}



}
