package com.spdb.pojo.generator;

import com.spdb.common.generator.GeneratorObject;

public class TableForm {

	private String table_name; // 字段中文名称
	private String owner;// 数据库用户名
	private String column_name; // 字段名
	private String data_type; // 字段类型
	private Integer data_length;// 字段类型的长度
	private String xqxxSort; // 详情信息排序号
	private String isCxxx; // 是否作为查询条件
	private String cxxxSort; // 查询条件排序号
	private String gridSort; // datagrid字段排序
	private String isGrid; // 是否datagrid显示内容
	private String bak1;// 表名
	private String bak2;// 用户名
	private String bak3;// 是否详情内容
	private String bak4;// datagrid中的字段是否需要超连接
	private String bak5;// 数据库类型
	private String bak6;// 数据库中原有字段名称
	private String layer;// 业务包层
	private String title;// 业务信息

	private Integer data_precision;
	private Integer data_scale;
	private String javaName; // java属性名
	private String javaType; // java属性类型
	private String jdbcType;

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJavaType() {
		if (getData_type().equals(GeneratorObject.INT)) {
			setJavaType(GeneratorObject.Integer);
			setJdbcType(GeneratorObject.INTEGER);
		} else if (getData_type().equals(GeneratorObject.NUMBER)) {
			if (getData_precision() != null && getData_precision() > 0
					&& getData_scale() > 0) {
				setJavaType(GeneratorObject.Double);
				setJdbcType(GeneratorObject.DOUBLE);
			} else {
				setJavaType(GeneratorObject.Integer);
				setJdbcType(GeneratorObject.INTEGER);
			}
		} else if (getData_type().equals(GeneratorObject.TIMESTAMP)) {
			setJavaType(GeneratorObject.javasqlTimestamp);
			setJdbcType(GeneratorObject.TIMESTAMP);
		} else if (getData_type().equals(GeneratorObject.FLOAT)) {
			setJavaType(GeneratorObject.Float);
			setJdbcType(GeneratorObject.FLOAT);
		} else if (getData_type().equals(GeneratorObject.LONG)) {
			setJavaType(GeneratorObject.Integer);
			setJdbcType(GeneratorObject.INTEGER);
		} else if (getData_type().equals(GeneratorObject.DATE)) {
			setJavaType(GeneratorObject.javasqldate);
			setJdbcType(GeneratorObject.DATE);
		} else if (getData_type().equals(GeneratorObject.VARCHAR2)) {
			setJavaType(GeneratorObject.str);
			setJdbcType(GeneratorObject.VARCHAR);
		} else {
			setJavaType(GeneratorObject.str);
			setJdbcType(GeneratorObject.VARCHAR);
		}
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaName() {
		return javaName;
	}

	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public String getBak6() {
		return bak6;
	}

	public void setBak6(String bak6) {
		this.bak6 = bak6;
	}

	public String getBak5() {
		return bak5;
	}

	public void setBak5(String bak5) {
		this.bak5 = bak5;
	}

	public String getBak4() {
		return bak4;
	}

	public void setBak4(String bak4) {
		if (bak4 == null || bak4.equals("")) {
			this.bak4 = "0";
		} else {
			this.bak4 = bak4;
		}
	}

	public String getBak3() {
		return bak3;
	}

	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}

	public String getBak2() {
		return bak2;
	}

	public void setBak2(String bak2) {
		this.bak2 = bak2;
	}

	public String getBak1() {
		return bak1;
	}

	public void setBak1(String bak1) {
		this.bak1 = bak1;
	}

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

	public String getIsCxxx() {
		return isCxxx;
	}

	public void setIsCxxx(String isCxxx) {
		this.isCxxx = isCxxx;
	}

	public String getXqxxSort() {
		return xqxxSort;
	}

	public void setXqxxSort(String xqxxSort) {
		if (xqxxSort == null || xqxxSort.equals("")) {
			this.xqxxSort = "0";
		} else {
			this.xqxxSort = xqxxSort;
		}
	}

	public String getCxxxSort() {
		return cxxxSort;
	}

	public void setCxxxSort(String cxxxSort) {
		if (cxxxSort == null || cxxxSort.equals("")) {
			this.cxxxSort = "0";
		} else {
			this.cxxxSort = cxxxSort;
		}

	}

	public String getGridSort() {
		return gridSort;
	}

	public void setGridSort(String gridSort) {
		if (gridSort == null || gridSort.equals("")) {
			this.gridSort = "0";
		} else {
			this.gridSort = gridSort;
		}

	}

	public String getIsGrid() {
		return isGrid;
	}

	public void setIsGrid(String isGrid) {
		if (isGrid == null || isGrid.equals("")) {
			this.isGrid = "0";
		} else {
			this.isGrid = isGrid;
		}
	}

	public Integer getData_length() {
		return data_length;
	}

	public void setData_length(Integer data_length) {
		this.data_length = data_length;
	}

}