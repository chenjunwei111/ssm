package com.spdb.pojo.base;

import java.io.Serializable;

public class RoleObjPojo  implements Serializable{
	private String roleid;
	private String[] vs;
	
	public String getRoleid() {
	    return roleid;
	}
	public void setRoleid(String roleid) {
	    this.roleid = roleid;
	}
	public String[] getVs() {
	    return vs;
	}
	public void setVs(String[] vs) {
	    this.vs = vs;
	}
	
}
