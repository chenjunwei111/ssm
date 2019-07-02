package com.spdb.pojo.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 小区工参信息
 * 
 * @author Chan
 */

public class PLteSectorPojo implements Serializable {

	private static final long serialVersionUID = -5594909328738531083L;
	private String cityCode;
	private String city;
	private java.sql.Date versionDate;
	private String sectorId;
	private String sectorName;
	private String enodebid;
	private String enodebName;
	private String ecellId;
	private Integer freqband;
	private Double frequency;
	private Integer earfcn;
	private Integer pci;
	private Integer pss;
	private Integer sss;
	private Integer tac;
	private String vendor;
	private Integer azimuth;
	private Double longitude;
	private Double latitude;
	private String style;
	private String grade;
	private Integer rootsequenceidx;
	private Integer height;
	private Integer electtilt;
	private Integer mechtilt;
	private Integer totletilt;
	private Integer status;
	private Integer bandwidth;
	private Integer prachindex;
	private Integer tddspecsubfconf;
	private Integer tddframeconf;
	private String cellid;
	private Double distance;

	public PLteSectorPojo() {

	}

	public PLteSectorPojo(String enodebid, Double longitude, Double latitude,
			Double distance) {
		this.enodebid = enodebid;
		this.longitude = longitude;
		this.latitude = latitude;
		this.distance = distance;
	}

	// 用于传参数
	public PLteSectorPojo(String sectorId, String enodebid, Double longitude,
			Double latitude, Integer azimuth) {
		this.sectorId = sectorId;
		this.enodebid = enodebid;
		this.longitude = longitude;
		this.latitude = latitude;
		this.azimuth = azimuth;
	}

	// sector.setSectorid("567114-22");
	// sector.setEarfcn(38400);
	// sector.setPci(125);
	// sector.setLongitude(102.70739);
	// sector.setLatitude(24.93403);
	// sector.setEnodebid("567114");
	// sector.setAzimuth(0);

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
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

	public void setVersiondate(java.sql.Date versionDate) {
		this.versionDate = versionDate;
	}

	public java.sql.Date getVersiondate() {
		return versionDate;
	}

	public void setSectorid(String sectorId) {
		this.sectorId = sectorId;
	}

	public String getSectorid() {
		return sectorId;
	}

	public void setSectorname(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getSectorname() {
		return sectorName;
	}

	public void setEnodebid(String enodebid) {
		this.enodebid = enodebid;
	}

	public String getEnodebid() {
		return enodebid;
	}

	public void setEnodebname(String enodebName) {
		this.enodebName = enodebName;
	}

	public String getEnodebname() {
		return enodebName;
	}

	public void setEcellid(String ecellId) {
		this.ecellId = ecellId;
	}

	public String getEcellid() {
		return ecellId;
	}

	public void setFreqband(Integer freqband) {
		this.freqband = freqband;
	}

	public Integer getFreqband() {
		return freqband;
	}

	public void setFrequency(Double frequency) {
		this.frequency = frequency;
	}

	public Double getFrequency() {
		return frequency;
	}

	public void setEarfcn(Integer earfcn) {
		this.earfcn = earfcn;
	}

	public Integer getEarfcn() {
		return earfcn;
	}

	public void setPci(Integer pci) {
		this.pci = pci;
	}

	public Integer getPci() {
		return pci;
	}

	public void setPss(Integer pss) {
		this.pss = pss;
	}

	public Integer getPss() {
		return pss;
	}

	public void setSss(Integer sss) {
		this.sss = sss;
	}

	public Integer getSss() {
		return sss;
	}

	public void setTac(Integer tac) {
		this.tac = tac;
	}

	public Integer getTac() {
		return tac;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendor() {
		return vendor;
	}

	public void setAzimuth(Integer azimuth) {
		this.azimuth = azimuth;
	}

	public Integer getAzimuth() {
		return azimuth;
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

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyle() {
		return style;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setRootsequenceidx(Integer rootsequenceidx) {
		this.rootsequenceidx = rootsequenceidx;
	}

	public Integer getRootsequenceidx() {
		return rootsequenceidx;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getHeight() {
		return height;
	}

	public void setElecttilt(Integer electtilt) {
		this.electtilt = electtilt;
	}

	public Integer getElecttilt() {
		return electtilt;
	}

	public void setMechtilt(Integer mechtilt) {
		this.mechtilt = mechtilt;
	}

	public Integer getMechtilt() {
		return mechtilt;
	}

	public void setTotletilt(Integer totletilt) {
		this.totletilt = totletilt;
	}

	public Integer getTotletilt() {
		return totletilt;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setBandwidth(Integer bandwidth) {
		this.bandwidth = bandwidth;
	}

	public Integer getBandwidth() {
		return bandwidth;
	}

	public void setPrachindex(Integer prachindex) {
		this.prachindex = prachindex;
	}

	public Integer getPrachindex() {
		return prachindex;
	}

	public void setTddspecsubfconf(Integer tddspecsubfconf) {
		this.tddspecsubfconf = tddspecsubfconf;
	}

	public Integer getTddspecsubfconf() {
		return tddspecsubfconf;
	}

	public void setTddframeconf(Integer tddframeconf) {
		this.tddframeconf = tddframeconf;
	}

	public Integer getTddframeconf() {
		return tddframeconf;
	}

	public void setCellid(String cellid) {
		this.cellid = cellid;
	}

	public String getCellid() {
		return cellid;
	}
	
	
	

	@Override
	public String toString() {
		return "PLteSectorPojo [cityCode=" + cityCode + ", city=" + city
				+ ", versionDate=" + versionDate + ", sectorId=" + sectorId
				+ ", sectorName=" + sectorName + ", frequency=" + frequency
				+ ", longitude=" + longitude + ", latitude=" + latitude
				+ ", cellid=" + cellid + ", distance=" + distance + "]";
	}

	/**
	 * 通过序列化的方式进行深度拷贝，cloneable方式亦可
	 * 
	 * @return 返回复制对象
	 */
	public PLteSectorPojo cloneS() {
		PLteSectorPojo pojo = null;
		try { // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			// 将流序列化成对象
			ByteArrayInputStream bais = new ByteArrayInputStream(
					baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			pojo = (PLteSectorPojo) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pojo;
	}

}
