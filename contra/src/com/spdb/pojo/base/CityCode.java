package com.spdb.pojo.base;


/**
 * 该实体类用于提供分区查询的对象，因为分区查询与一般的Mybaits查询方式不一样，所以需要提供一个对象作为查询条件
 * 需要多少个参数来进行查询就需要在 该实体类内 NEW 多少个参数进去
 * @author chenjunwei
 *
 */
public class CityCode {

	private String cityCode;
    private String condition;
    
    
	public CityCode() {
		super();
	}
	
	
	/**
	 * 单的cityCode实例化
	 * @param cityCode
	 */
	public CityCode(String cityCode) {
		super();
		this.cityCode = cityCode;
	}


	/**
	 * 带有两个参的实例化
	 * @param cityCode
	 * @param condition
	 */
	public CityCode(String cityCode, String condition) {
		super();
		this.cityCode = cityCode;
		this.condition = condition;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
    
	
	
}
