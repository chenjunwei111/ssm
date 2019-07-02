package com.spdb.pojo.generator;

/**
 * 表字段名称和类型
 * 
 * @author Chan
 * 
 */
public class TablePojo {

	private String column_name; // 字段名
	private String data_type; // 字段类型
	private Integer data_length;// 字段类型的长度
	private Integer data_precision;
	private Integer data_scale;

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public Integer getData_length() {
		return data_length;
	}

	public void setData_length(Integer data_length) {
		this.data_length = data_length;
	}

	public Integer getData_precision() {
		return data_precision;
	}

	public void setData_precision(Integer data_precision) {
		this.data_precision = data_precision;
	}

	public Integer getData_scale() {
		return data_scale;
	}

	public void setData_scale(Integer data_scale) {
		this.data_scale = data_scale;
	}

}