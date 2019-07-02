package com.spdb.pojo.complaint;

/**
 * 热点监控区域

 * @author Chan
*/

public class PComplaintHotspotPojo {

private String cityCode;
private String city;
private String yyyymm;
private String hotspotName;
private Double longitude;
private Double latitude;
private Integer enodebNum;
private Integer complaintNum;
private Integer deteriorateDays;
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

public void setDeterioratedays(Integer deteriorateDays) {
		this.deteriorateDays = deteriorateDays;
}

public Integer getDeterioratedays() {
		return deteriorateDays;
}

public void setAreaid(Integer areaId) {
		this.areaId = areaId;
}

public Integer getAreaid() {
		return areaId;
}

}
