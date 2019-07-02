package com.spdb.common.generator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Form基类
 * 
 */
public class BasePageForm {

	/** 总页数 */
	private long recordCount;

	/** 当前页 */
	private int pageNo;

	/** 每页行数 */
	private int pageRowNum = 10;

	/** 版本号 */
	private String versionID = null;

	/** 记录列表 */
	private List recordList;

	/** 开始时间 **/
	private String startDate;
	/** 结束时间 **/
	private String endDate;
	/** 关键字 **/
	private String keyword;
	/** 自定义查询条件 and 开始 **/
	private String condition;

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/** 克隆 */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	/**
	 * 方法说明: 总页数
	 * 
	 * 
	 * @return
	 */
	public long getRecordCount() {
		return this.recordCount;
	}

	/**
	 * 方法说明: 当前页
	 * 
	 * 
	 * @return
	 */
	public int getPageNo() {
		return this.pageNo;
	}

	/**
	 * 方法说明: 总页数
	 * 
	 * 
	 * @param pageCount
	 */
	public void setRecordCount(long pageCount) {
		this.recordCount = pageCount;
	}

	/**
	 * 方法说明: 当前页
	 * 
	 * 
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		// if(pageNo == 0)
		// this.pageNo = 1;
		// else
		this.pageNo = pageNo - 1;
	}

	public int getPageRowNum() {
		return this.pageRowNum;
	}

	public void setPageRowNum(int i) {
		if (i == 0) {
			this.pageRowNum = 10;
		} else {
			this.pageRowNum = i;
		}

	}

	public String getVersionID() {
		return versionID;
	}

	public void setVersionID(String string) {
		versionID = string;
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public String toString() {

		Class c = this.getClass();

		StringBuffer sb = new StringBuffer();

		for (Field field : c.getDeclaredFields()) {
			String fieldName = field.getName();
			String stringLetter = fieldName.substring(0, 1).toUpperCase();

			String getName = "get" + stringLetter + fieldName.substring(1);

			Method getMethod = null;
			Object value = null;
			try {
				getMethod = c.getMethod(getName, new Class[] {});
				value = getMethod.invoke(this, new Object[] {});
				sb.append(fieldName).append(":").append(value).append(";");
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return sb.toString();
	}

}
