package com.spdb.pojo.generator;

import java.sql.Date;

/**
 * 分区信息对象
 * 
 * @author Chan
 * 
 */
public class PartitionPojo {

	private Date versionDate;
	private String cityCode;
	private String tableName;
	private String partitionName;
	private String subpartitionName;
	private Integer areaCode;
	private String deptName;
	private String deptCode;
	private Integer nums;

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public Date getVersionDate() {
		return versionDate;
	}

	public void setVersionDate(Date versionDate) {
		this.versionDate = versionDate;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPartitionName() {
		return partitionName;
	}

	public void setPartitionName(String partitionName) {
		this.partitionName = partitionName;
	}

	public String getSubpartitionName() {
		return subpartitionName;
	}

	public void setSubpartitionName(String subpartitionName) {
		this.subpartitionName = subpartitionName;
	}

	public Integer getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

}
