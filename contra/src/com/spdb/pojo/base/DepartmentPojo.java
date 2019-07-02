package com.spdb.pojo.base;

import java.sql.Date;

/**
 * 部门信息
 * 
 * @author Chan
 */

public class DepartmentPojo {

	private String deptName;
	private String parentDeptCode;
	private String description;
	private Integer isvalid;
	private String deptCode;
	private Integer areaCode;
	private Double longitude;
	private Double latitude;
	private Integer sequence;

	public void setDeptname(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptname() {
		return deptName;
	}

	public void setParentdeptcode(String parentDeptCode) {
		this.parentDeptCode = parentDeptCode;
	}

	public String getParentdeptcode() {
		return parentDeptCode;
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

	public void setDeptcode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptcode() {
		return deptCode;
	}

	public void setAreacode(Integer areaCode) {
		this.areaCode = areaCode;
	}

	public Integer getAreacode() {
		return areaCode;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getSequence() {
		return sequence;
	}

}
