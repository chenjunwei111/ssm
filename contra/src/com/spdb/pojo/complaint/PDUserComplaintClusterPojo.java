package com.spdb.pojo.complaint;
import java.sql.Date;

/**
 * 热点监控区域

 * @author Chan
*/

public class PDUserComplaintClusterPojo {

private String cityCode;
private String city;
private Date versionDate;
private String id;
private Double longitude;
private Double latitude;
private Integer clusterid;
private Double cLongitude;
private Double cLatitude;
private Integer enodebNum;
private Integer complaintNum;
private String usernum;
private String clustername;

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

public void setId(String id) {
		this.id = id;
}

public String getId() {
		return id;
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

public void setClusterid(Integer clusterid) {
		this.clusterid = clusterid;
}

public Integer getClusterid() {
		return clusterid;
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

public void setUsernum(String usernum) {
		this.usernum = usernum;
}

public String getUsernum() {
		return usernum;
}

public void setClustername(String clustername) {
		this.clustername = clustername;
}

public String getClustername() {
		return clustername;
}

}
