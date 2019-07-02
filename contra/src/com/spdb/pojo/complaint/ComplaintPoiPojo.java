package com.spdb.pojo.complaint;

import java.util.HashMap;

public class ComplaintPoiPojo {
	private String communityId;
	private String cityCode;// 地市
	private String ueProperty;// 区县
	private String communityName;// 场景
	private String voice_data_classify;// 业务类型
	private String business_classify;// 234G;
	private Integer g2;
	private Integer g3;
	private Integer g4;

	private Integer YYg2 = 0; // 语言 2g
	private Integer YYg3 = 0;// 语言 2g
	private Integer YYg4 = 0;// 语言 2g
	private Integer SJg2 = 0;// 数据2g
	private Integer SJg3 = 0;// 数据3g
	private Integer SJg4 = 0;// 数据4g

	private Integer gall; // 总投诉量
	private Integer days;// 累计出现投诉天数
	private Integer longdays;// 最长持续出现天数
	private Integer months;// 最长持续出现月数
	private String sendtime;
	private HashMap<String, Integer> monthMap;
	private String ordernum;

	public Integer getYYg2() {
		return YYg2;
	}

	public void setYYg2(Integer yYg2) {
		YYg2 = yYg2;
	}

	public Integer getYYg3() {
		return YYg3;
	}

	public void setYYg3(Integer yYg3) {
		YYg3 = yYg3;
	}

	public Integer getYYg4() {
		return YYg4;
	}

	public void setYYg4(Integer yYg4) {
		YYg4 = yYg4;
	}

	public Integer getSJg2() {
		return SJg2;
	}

	public void setSJg2(Integer sJg2) {
		SJg2 = sJg2;
	}

	public Integer getSJg3() {
		return SJg3;
	}

	public void setSJg3(Integer sJg3) {
		SJg3 = sJg3;
	}

	public Integer getSJg4() {
		return SJg4;
	}

	public void setSJg4(Integer sJg4) {
		SJg4 = sJg4;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public HashMap<String, Integer> getMonthMap() {
		return monthMap;
	}

	public void setMonthMap(HashMap<String, Integer> monthMap) {
		this.monthMap = monthMap;
	}

	public String getBusiness_classify() {
		return business_classify;
	}

	public void setBusiness_classify(String business_classify) {
		this.business_classify = business_classify;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getUeProperty() {
		return ueProperty;
	}

	public void setUeProperty(String ueProperty) {
		this.ueProperty = ueProperty;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getVoice_data_classify() {
		return voice_data_classify;
	}

	public void setVoice_data_classify(String voice_data_classify) {
		this.voice_data_classify = voice_data_classify;
	}

	public Integer getG2() {
		return g2;
	}

	public void setG2(Integer g2) {
		this.g2 = g2;
	}

	public Integer getG3() {
		return g3;
	}

	public void setG3(Integer g3) {
		this.g3 = g3;
	}

	public Integer getG4() {
		return g4;
	}

	public void setG4(Integer g4) {
		this.g4 = g4;
	}

	public Integer getGall() {
		return gall;
	}

	public void setGall(Integer gall) {
		this.gall = gall;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Integer getLongdays() {
		return longdays;
	}

	public void setLongdays(Integer longdays) {
		this.longdays = longdays;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

}
