package com.spdb.pojo.complaint;
import java.sql.Date;

/**
 * 覆盖类左上表

 * @author Chan
*/

public class TMPWEBOnekeyCoverLeftupPojo {

private String cityCode;
private Date versionDate;
private String imsi;
private String cellId;
private Integer allSamples;
private Integer samples110;
private Integer lte2gsmRedirectCnt;

public void setCitycode(String cityCode) {
		this.cityCode = cityCode;
}

public String getCitycode() {
		return cityCode;
}

public void setVersiondate(Date versionDate) {
		this.versionDate = versionDate;
}

public Date getVersiondate() {
		return versionDate;
}

public void setImsi(String imsi) {
		this.imsi = imsi;
}

public String getImsi() {
		return imsi;
}

public void setCellid(String cellId) {
		this.cellId = cellId;
}

public String getCellid() {
		return cellId;
}

public void setAllsamples(Integer allSamples) {
		this.allSamples = allSamples;
}

public Integer getAllsamples() {
		return allSamples;
}

public void setSamples110(Integer samples110) {
		this.samples110 = samples110;
}

public Integer getSamples110() {
		return samples110;
}

public void setLte2gsmredirectcnt(Integer lte2gsmRedirectCnt) {
		this.lte2gsmRedirectCnt = lte2gsmRedirectCnt;
}

public Integer getLte2gsmredirectcnt() {
		return lte2gsmRedirectCnt;
}

}
