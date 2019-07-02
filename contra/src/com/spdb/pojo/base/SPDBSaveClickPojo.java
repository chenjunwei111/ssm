package com.spdb.pojo.base;
import java.sql.Timestamp;

/**
 * 用户点击记录

 * @author Chan
*/

public class SPDBSaveClickPojo {

private	String yyyymm;
private String city;
private String userName;
private Timestamp clickDate;
private String functionParent ;
private String functionName;
private String userIp;
private String macIp;
private String functionParamete;
private String functionUri;
private long specDate;


public void setYyyymm(String yyyymm) {
	this.yyyymm = yyyymm;
}

public String getYyyymm() {
	return yyyymm;
}


public void setCity(String city) {
		this.city = city;
}

public String getCity() {
		return city;
}

public void setUsername(String userName) {
		this.userName = userName;
}

public String getUsername() {
		return userName;
}

public void setClickdate(Timestamp time) {
		this.clickDate = time;
}

public Timestamp getClickdate() {
		return clickDate;
}

public void setParnetname(String functionParent) {
		this.functionParent = functionParent;
}

public String getParnetname() {
		return functionParent;
}

public void setChildrenname(String functionName) {
		this.functionName = functionName;
}

public String getChildrenname() {
		return functionName;
}

public void setUserip(String userIp) {
		this.userIp = userIp;
}

public String getUserip() {
		return userIp;
}

public void setUmacip(String macIp) {
	this.macIp = macIp;
}

public String getUmacip() {
	return macIp;
}


public void setFunctionParamete(String functionParamete) {
	this.functionParamete = functionParamete;
}

public String getFunctionParamete() {
	return functionParamete;
}


public void setFunctionUri(String functionUri) {
	this.functionUri = functionUri;
}

public String getFunctionUri() {
	return functionUri;
}

public void setSpecDate(long specDate) {
	this.specDate = specDate;
}

public long getSpecDate() {
	return specDate;
}



public SPDBSaveClickPojo(String yyyymm, String city, String userName,
		Timestamp clickDate, String functionParent, String functionName,
		String userIp, String macIp, String functionParamete,
		String functionUri, long specDate) {
	super();
	this.yyyymm = yyyymm;
	this.city = city;
	this.userName = userName;
	this.clickDate = clickDate;
	this.functionParent = functionParent;
	this.functionName = functionName;
	this.userIp = userIp;
	this.macIp = macIp;
	this.functionParamete = functionParamete;
	this.functionUri = functionUri;
	this.specDate = specDate;
}

@Override
public String toString() {
	return "SPDBSaveClickPojo [yyyymm=" + yyyymm + ", city=" + city
			+ ", userName=" + userName + ", clickDate=" + clickDate
			+ ", functionParent=" + functionParent + ", functionName="
			+ functionName + ", userIp=" + userIp + ", macIp=" + macIp
			+ ", functionParamete=" + functionParamete + ", functionUri="
			+ functionUri + ", specDate=" + specDate + "]";
}



}
