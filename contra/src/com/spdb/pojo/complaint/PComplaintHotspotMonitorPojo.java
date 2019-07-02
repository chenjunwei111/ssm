package com.spdb.pojo.complaint;

/**
 * 热点监控区域

 * @author Chan
*/

public class PComplaintHotspotMonitorPojo {

private String cityCode;
private String city;
private String yyyymm;
private String hotspotName;
private Double cLongitude;
private Double cLatitude;
private Integer enodebNum;
private Integer complaintNum;
private String startMonth;
private Integer areaId;

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

public void setYyyymm(String yyyymm) {
		this.yyyymm = yyyymm;
}

public String getYyyymm() {
		return yyyymm;
}

public void setHotspotname(String hotspotName) {
		this.hotspotName = hotspotName;
}

public String getHotspotname() {
		return hotspotName;
}

public void setClongitude(Double cLongitude) {
		this.cLongitude = cLongitude;
}

public Double getClongitude() {
		return cLongitude;
}

public void setClatitude(Double cLatitude) {
		this.cLatitude = cLatitude;
}

public Double getClatitude() {
		return cLatitude;
}

public void setEnodebnum(Integer enodebNum) {
		this.enodebNum = enodebNum;
}

public Integer getEnodebnum() {
		return enodebNum;
}

public void setComplaintnum(Integer complaintNum) {
		this.complaintNum = complaintNum;
}

public Integer getComplaintnum() {
		return complaintNum;
}

public void setStartmonth(String startMonth) {
		this.startMonth = startMonth;
}

public String getStartmonth() {
		return startMonth;
}

public void setAreaid(Integer areaId) {
		this.areaId = areaId;
}

public Integer getAreaid() {
		return areaId;
}

}
