package com.spdb.pojo.complaint;

import java.sql.Date;

/**
 * 工单投诉
 * 
 * @author Chan
 */

public class PLteParmeterComplaintPojo {

//	private String yearmonth;
	private String cityCode;
	private String city;
	private Date versionDate;
	private Date endDate;
	private String ordernum;
	private String businesstype;
	private String complainttype1;
	private String complainttype2;
	private String complainttype3;
	private String phonenum;
	private String compliantplace;
	private String ruralcity;
	private String inorout;
	private String bussinesscontent;
	private String sendtime;
	private String bsendtime;
	private String esendtime;
	private String property;
	private Double latitude;
	private Double longitude;
	private Double ue_x;
	private Double ue_y;
	private String ue_date;
	private Integer gridNo;
	private Integer state;
	private Double dis;
	private String comlevel;
	private String ue_address;
	private String seltime;
    private String IMSI;


	private String order_source;
	private String  lon_lat_locate_type;
	private String  complaint_level;
	private String  ue_property;
	private String exact_state;

	private String pre_treatment_man;
	private String pre_treatment_organizations;
	private Date pre_treatment_time;

	private String operate;//用于判断是更新还是插入 update/commit

	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public String getPre_treatment_man() {
		return pre_treatment_man;
	}
	public void setPre_treatment_man(String pre_treatment_man) {
		this.pre_treatment_man = pre_treatment_man;
	}
	public String getPre_treatment_organizations() {
		return pre_treatment_organizations;
	}
	public void setPre_treatment_organizations(String pre_treatment_organizations) {
		this.pre_treatment_organizations = pre_treatment_organizations;
	}
	public Date getPre_treatment_time() {
		return pre_treatment_time;
	}
	public void setPre_treatment_time(Date pre_treatment_time) {
		this.pre_treatment_time = pre_treatment_time;
	}
	public String getBsendtime() {
		return bsendtime;
	}
	public void setBsendtime(String bsendtime) {
		this.bsendtime = bsendtime;
	}
	public String getEsendtime() {
		return esendtime;
	}
	public void setEsendtime(String esendtime) {
		this.esendtime = esendtime;
	}
	public String getExact_state() {
		return exact_state;
	}
	public void setExact_state(String exact_state) {
		this.exact_state = exact_state;
	}
	public String getOrder_source() {
		return order_source;
	}

	public void setOrder_source(String order_source) {
		this.order_source = order_source;
	}

	public String getLon_lat_locate_type() {
		return lon_lat_locate_type;
	}

	public void setLon_lat_locate_type(String lon_lat_locate_type) {
		this.lon_lat_locate_type = lon_lat_locate_type;
	}

	public String getComplaint_level() {
		return complaint_level;
	}

	public void setComplaint_level(String complaint_level) {
		this.complaint_level = complaint_level;
	}

	public String getUe_property() {
		return ue_property;
	}

	public void setUe_property(String ue_property) {
		this.ue_property = ue_property;
	}



	public String getIMSI() {
		return IMSI;
	}

	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}

	public String getSeltime() {
		return seltime;
	}

	public void setSeltime(String seltime) {
		this.seltime = seltime;
	}

	public PLteParmeterComplaintPojo() {
		super();
	}

	public PLteParmeterComplaintPojo(String complainttype1,
			String complainttype2, String complainttype3, String ruralcity,
			String inorout, String property, Double ue_x, Double ue_y,
			String ue_date, String ue_address,Double dis) {
		super();
		this.complainttype1 = complainttype1;
		this.complainttype2 = complainttype2;
		this.complainttype3 = complainttype3;
		this.ruralcity = ruralcity;
		this.inorout = inorout;
		this.property = property;
		this.ue_x = ue_x;
		this.ue_y = ue_y;
		this.ue_date = ue_date;
		this.ue_address = ue_address;
		this.dis = dis;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Date getVersionDate() {
		return versionDate;
	}

	public void setVersionDate(Date versionDate) {
		this.versionDate = versionDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}




	public Double getDis() {
		return dis;
	}

	public void setDis(Double dis) {
		this.dis = dis;
	}

	public String getComlevel() {
		return comlevel;
	}

	public void setComlevel(String comlevel) {
		this.comlevel = comlevel;
	}

	public String getUe_address() {
		return ue_address;
	}

	public void setUe_address(String ue_address) {
		this.ue_address = ue_address;
	}

	public Integer getGridNo() {
		return gridNo;
	}

	public void setGridNo(Integer gridNo) {
		this.gridNo = gridNo;
	}
//
//	public void setYearmonth(String yearmonth) {
//		this.yearmonth = yearmonth;
//	}
//
//	public String getYearmonth() {
//		return yearmonth;
//	}

	public void setCitycode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCitycode() {
		return cityCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setVersiondate(Date versionDate) {
		this.versionDate = versionDate;
	}

	public Date getVersiondate() {
		return versionDate;
	}

	public void setEnddate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEnddate() {
		return endDate;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}

	public String getBusinesstype() {
		return businesstype;
	}

	public void setComplainttype1(String complainttype1) {
		this.complainttype1 = complainttype1;
	}

	public String getComplainttype1() {
		return complainttype1;
	}

	public void setComplainttype2(String complainttype2) {
		this.complainttype2 = complainttype2;
	}

	public String getComplainttype2() {
		return complainttype2;
	}

	public void setComplainttype3(String complainttype3) {
		this.complainttype3 = complainttype3;
	}

	public String getComplainttype3() {
		return complainttype3;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setCompliantplace(String compliantplace) {
		this.compliantplace = compliantplace;
	}

	public String getCompliantplace() {
		return compliantplace;
	}

	public void setRuralcity(String ruralcity) {
		this.ruralcity = ruralcity;
	}

	public String getRuralcity() {
		return ruralcity;
	}

	public void setInorout(String inorout) {
		this.inorout = inorout;
	}

	public String getInorout() {
		return inorout;
	}

	public void setBussinesscontent(String bussinesscontent) {
		this.bussinesscontent = bussinesscontent;
	}

	public String getBussinesscontent() {
		return bussinesscontent;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getProperty() {
		return property;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setUe_x(Double ue_x) {
		this.ue_x = ue_x;
	}

	public Double getUe_x() {
		return ue_x;
	}

	public void setUe_y(Double ue_y) {
		this.ue_y = ue_y;
	}

	public Double getUe_y() {
		return ue_y;
	}

	public void setUe_date(String ue_date) {
		this.ue_date = ue_date;
	}

	public String getUe_date() {
		return ue_date;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getState() {
		return state;
	}
	@Override
	public String toString() {
		return "PLteParmeterComplaintPojo [cityCode=" + cityCode + ", city="
				+ city + ", versionDate=" + versionDate + ", endDate="
				+ endDate + ", ordernum=" + ordernum + ", businesstype="
				+ businesstype + ", complainttype1=" + complainttype1
				+ ", complainttype2=" + complainttype2 + ", complainttype3="
				+ complainttype3 + ", phonenum=" + phonenum
				+ ", compliantplace=" + compliantplace + ", ruralcity="
				+ ruralcity + ", inorout=" + inorout + ", bussinesscontent="
				+ bussinesscontent + ", sendtime=" + sendtime + ", bsendtime="
				+ bsendtime + ", esendtime=" + esendtime + ", property="
				+ property + ", latitude=" + latitude + ", longitude="
				+ longitude + ", ue_x=" + ue_x + ", ue_y=" + ue_y
				+ ", ue_date=" + ue_date + ", gridNo=" + gridNo + ", state="
				+ state + ", dis=" + dis + ", comlevel=" + comlevel
				+ ", ue_address=" + ue_address + ", seltime=" + seltime
				+ ", IMSI=" + IMSI + ", order_source=" + order_source
				+ ", lon_lat_locate_type=" + lon_lat_locate_type
				+ ", complaint_level=" + complaint_level + ", ue_property="
				+ ue_property + ", exact_state=" + exact_state + "]";
	}

 
	
	
}
