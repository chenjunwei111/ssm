package com.spdb.pojo.base;
import java.sql.Date;

/**
 * 地图栅格参数信息

 * @author Chan
*/

public class GROUPGridsPojo {

private String cityCode;
private String city;
private Integer gridId;
private String gridName;
private String gridType;
private Double leftDownX;
private Double leftDownY;
private Double rightUpX;
private Double rightUpY;
private Double sY;
private String flag;
private Double sX;
private Integer nX;
private Integer nY;

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

public void setGridid(Integer gridId) {
		this.gridId = gridId;
}

public Integer getGridid() {
		return gridId;
}

public void setGridname(String gridName) {
		this.gridName = gridName;
}

public String getGridname() {
		return gridName;
}

public void setGridtype(String gridType) {
		this.gridType = gridType;
}

public String getGridtype() {
		return gridType;
}

public void setLeftdownx(Double leftDownX) {
		this.leftDownX = leftDownX;
}

public Double getLeftdownx() {
		return leftDownX;
}

public void setLeftdowny(Double leftDownY) {
		this.leftDownY = leftDownY;
}

public Double getLeftdowny() {
		return leftDownY;
}

public void setRightupx(Double rightUpX) {
		this.rightUpX = rightUpX;
}

public Double getRightupx() {
		return rightUpX;
}

public void setRightupy(Double rightUpY) {
		this.rightUpY = rightUpY;
}

public Double getRightupy() {
		return rightUpY;
}

public void setSy(Double sY) {
		this.sY = sY;
}

public Double getSy() {
		return sY;
}

public void setFlag(String flag) {
		this.flag = flag;
}

public String getFlag() {
		return flag;
}

public void setSx(Double sX) {
		this.sX = sX;
}

public Double getSx() {
		return sX;
}

public void setNx(Integer nX) {
		this.nX = nX;
}

public Integer getNx() {
		return nX;
}

public void setNy(Integer nY) {
		this.nY = nY;
}

public Integer getNy() {
		return nY;
}

}
