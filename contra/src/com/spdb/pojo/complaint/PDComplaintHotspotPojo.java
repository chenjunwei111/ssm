package com.spdb.pojo.complaint;
import java.sql.Date;

/**
 * 热点监控区域

 * @author Chan
*/

public class PDComplaintHotspotPojo {

private Integer areaId;
private String cityCode;
private String city;
private Date versionDate;
private String hotspotName;
private Double longitude;
private Double latitude;
private String areaName;
private Integer enodebNum;
private Integer complaintNum;

public void setAreaid(Integer areaId) {
		this.areaId = areaId;
}

public Integer getAreaid() {
		return areaId;
}

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

public void setAreaname(String areaName) {
		this.areaName = areaName;
}

public String getAreaname() {
		return areaName;
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

}
