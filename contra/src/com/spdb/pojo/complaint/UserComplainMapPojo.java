package com.spdb.pojo.complaint;

/**
 * 工单投诉

 * @author Chan
*/

public class UserComplainMapPojo {

private String Sector_id;
private Double Longitude ;
private Double Latitude;
private Double Distance;


public void setSector_id(String Sector_id) {
		this.Sector_id = Sector_id;
}

public String getSector_id() {
		return Sector_id;
}

public void setLongitude(Double Longitude) {
		this.Longitude = Longitude;
}

public Double getLongitude() {
		return Longitude;
}

public void setLatitude(Double Latitude) {
	this.Latitude = Latitude;
}

public Double getLatitude() {
	return Latitude;
}

public void setDistance(Double Distance) {
	this.Distance = Distance;
}

public Double getDistance() {
	return Distance;
}


}
