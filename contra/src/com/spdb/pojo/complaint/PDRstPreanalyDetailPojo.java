package com.spdb.pojo.complaint;

/**
 * 预分析结果
 * 
 * @author Chan
 */

public class PDRstPreanalyDetailPojo {
	
	private String tag;
	private String centers;
	private String cityName;
	private String sizeProper;
	private String acreage;
	private String smonth;
	private String YYorSJ;
	
	private String communityId;
	private String ueProperty;// 区县
	private String communityName;// 场景
	private String voice_data_classify;// 业务类型
	private String business_classify;// 234G;
	
	private String business_classify2;//
	
	
	
	public String getBusiness_classify2() {
		return business_classify2;
	}

	public void setBusiness_classify2(String business_classify2) {
		this.business_classify2 = business_classify2;
	}

	private String isHotArea;
	private String lteDepartment;
	private String lteSuggestions;
	private String lteSuggestionsDetail;
	private String gsmProblemSectorCnt;
	private String gsmAreaSector;
	private String gsmAreaSectorName;
	private String gsmNearProblemSite;
	private String gsmNearProblemSector;
	private String gsmNearProblemSectorName;
	private String dis;
	private String faultRatio;
	private String interfereRatio;
	private String channelLowuseRatio;
	private String highloadRatio;
	private String accessRatio;
	private String dlWeakRatio;
	private String ulWeakRatio;
	private String moveRatio;
	private String keepRatio;
	private String gsmAlarmId;
	private String gsmAlarmTitle;
	private String gsmOutserviceAlarmNum;
	private String gsmOutcapabilityAlarmNum;
	private String gsmOutserviceAlarmTimes;
	private String gsmOutcapabilityAlarmTimes;
	private String gsmAlarmTimes;
	private String gsmSectorAlarmDetail;
	private String gsmUnqualifiedSummary;
	private String gsmProblemSummaryClassify;
	private String gsmProblemSummaryClassify1;
	private String gsmDepartment;
	private String gsmSuggestions;
	private String isInterceptComplaint;
	private String isOldLocation;
	private String cityCode;
	private String sdate;
	private String city;
	private String area;
	private String ordernum;
	private String phonenum;
	private String userProperty;
	private String siteProperty;
	private String property;
	private String businesstype;
	private String voiceDataClassify;
	private String businessClassify;
	private String problemClassify;
	private String problemDetail;
	private String bussinesscontent;
	private String compliantplace;
	private String longitude;
	private String latitude;
	private String preciseDate;
	private String locationProperty;
	private String isPreciseComplaint;
	private String lteProblemSite;
	private String lteProblemSector;
	private String lteProblemCgi;
	private String lteProblemEarfcn;
	private String lteProblemSectorType;
	private String lteProblemSectorDis;
	private String lteAreaCgi;
	private String lteAreaSector;
	private String lteProblemSectorCnt;
	private String lteCoverRatio;
	private String lteFaultRatio;
	private String lteInterfereRatio;
	private String lteHighloadRatio;
	private String volteRatio;
	private String csfbRatio;
	private String lteQuotaBadRatio;
	private String ltePlanSiteCnt;
	private String demandSummary;
	private String planSiteSummary;
	private String planCoverSiteCnt;
	private String planCapacitySiteCnt;
	private String planOutdoorSiteCnt;
	private String planIndoorSiteCnt;
	private String planFlySiteCnt;
	private String planSkinSiteCnt;
	private String isPlanSite;
	private String lteFaultSiteId;
	private String lteFaultSiteName;
	private String lteAlarmId;
	private String lteAlarmDetail;
	private String lteAlarmSmallType;
	private String lteOutserviceAlarmNum;
	private String lteOutcapabilityAlarmNum;
	private String lteOutserviceAlarmRatio;
	private String lteOutcapabilityAlarmRatio;
	private String lteOutserviceAlarmTimes;
	private String lteOutcapabilityAlarmTimes;
	private String lteAlarmTimes;
	private String lteSectorAlarmDetail;
	private String lteProblemSummary;
	private String lteProblemSummaryClassify;
	private String lteProblemSummaryClassify1;
	private String lteWeakSectorCnt;
	private String lteWeakDays;
	private String lteVoltePerceptionRatio;
	private String lteNetPerceptionRatio;
	private String lteLowspeedRatio;
	private String seqReasonsClassify;
	private String seqProblemSummary;
	private String seqMainProblemClassify;
	private String seqProblemDetail;
	private String clusterId;
	
	private String isLastMonth;//是否是上个月

	public String getIsLastMonth() {
		return isLastMonth;
	}

	public void setIsLastMonth(String isLastMonth) {
		this.isLastMonth = isLastMonth;
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getUeProperty() {
		return ueProperty;
	}

	public void setUeProperty(String ueProperty) {
		this.ueProperty = ueProperty;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getVoice_data_classify() {
		return voice_data_classify;
	}

	public void setVoice_data_classify(String voice_data_classify) {
		this.voice_data_classify = voice_data_classify;
	}

	public String getBusiness_classify() {
		return business_classify;
	}

	public void setBusiness_classify(String business_classify) {
		this.business_classify = business_classify;
	}

	public String getIsHotArea() {
		return isHotArea;
	}

	public void setIsHotArea(String isHotArea) {
		this.isHotArea = isHotArea;
	}

	public String getLteDepartment() {
		return lteDepartment;
	}

	public void setLteDepartment(String lteDepartment) {
		this.lteDepartment = lteDepartment;
	}

	public String getLteSuggestions() {
		return lteSuggestions;
	}

	public void setLteSuggestions(String lteSuggestions) {
		this.lteSuggestions = lteSuggestions;
	}

	public String getLteSuggestionsDetail() {
		return lteSuggestionsDetail;
	}

	public void setLteSuggestionsDetail(String lteSuggestionsDetail) {
		this.lteSuggestionsDetail = lteSuggestionsDetail;
	}

	public String getGsmProblemSectorCnt() {
		return gsmProblemSectorCnt;
	}

	public void setGsmProblemSectorCnt(String gsmProblemSectorCnt) {
		this.gsmProblemSectorCnt = gsmProblemSectorCnt;
	}

	public String getGsmAreaSector() {
		return gsmAreaSector;
	}

	public void setGsmAreaSector(String gsmAreaSector) {
		this.gsmAreaSector = gsmAreaSector;
	}

	public String getGsmAreaSectorName() {
		return gsmAreaSectorName;
	}

	public void setGsmAreaSectorName(String gsmAreaSectorName) {
		this.gsmAreaSectorName = gsmAreaSectorName;
	}

	public String getGsmNearProblemSite() {
		return gsmNearProblemSite;
	}

	public void setGsmNearProblemSite(String gsmNearProblemSite) {
		this.gsmNearProblemSite = gsmNearProblemSite;
	}

	public String getGsmNearProblemSector() {
		return gsmNearProblemSector;
	}

	public void setGsmNearProblemSector(String gsmNearProblemSector) {
		this.gsmNearProblemSector = gsmNearProblemSector;
	}

	public String getGsmNearProblemSectorName() {
		return gsmNearProblemSectorName;
	}

	public void setGsmNearProblemSectorName(String gsmNearProblemSectorName) {
		this.gsmNearProblemSectorName = gsmNearProblemSectorName;
	}

	public String getDis() {
		return dis;
	}

	public void setDis(String dis) {
		this.dis = dis;
	}

	public String getFaultRatio() {
		return faultRatio;
	}

	public void setFaultRatio(String faultRatio) {
		this.faultRatio = faultRatio;
	}

	public String getInterfereRatio() {
		return interfereRatio;
	}

	public void setInterfereRatio(String interfereRatio) {
		this.interfereRatio = interfereRatio;
	}

	public String getChannelLowuseRatio() {
		return channelLowuseRatio;
	}

	public void setChannelLowuseRatio(String channelLowuseRatio) {
		this.channelLowuseRatio = channelLowuseRatio;
	}

	public String getHighloadRatio() {
		return highloadRatio;
	}

	public void setHighloadRatio(String highloadRatio) {
		this.highloadRatio = highloadRatio;
	}

	public String getAccessRatio() {
		return accessRatio;
	}

	public void setAccessRatio(String accessRatio) {
		this.accessRatio = accessRatio;
	}

	public String getDlWeakRatio() {
		return dlWeakRatio;
	}

	public void setDlWeakRatio(String dlWeakRatio) {
		this.dlWeakRatio = dlWeakRatio;
	}

	public String getUlWeakRatio() {
		return ulWeakRatio;
	}

	public void setUlWeakRatio(String ulWeakRatio) {
		this.ulWeakRatio = ulWeakRatio;
	}

	public String getMoveRatio() {
		return moveRatio;
	}

	public void setMoveRatio(String moveRatio) {
		this.moveRatio = moveRatio;
	}

	public String getKeepRatio() {
		return keepRatio;
	}

	public void setKeepRatio(String keepRatio) {
		this.keepRatio = keepRatio;
	}

	public String getGsmAlarmId() {
		return gsmAlarmId;
	}

	public void setGsmAlarmId(String gsmAlarmId) {
		this.gsmAlarmId = gsmAlarmId;
	}

	public String getGsmAlarmTitle() {
		return gsmAlarmTitle;
	}

	public void setGsmAlarmTitle(String gsmAlarmTitle) {
		this.gsmAlarmTitle = gsmAlarmTitle;
	}

	public String getGsmOutserviceAlarmNum() {
		return gsmOutserviceAlarmNum;
	}

	public void setGsmOutserviceAlarmNum(String gsmOutserviceAlarmNum) {
		this.gsmOutserviceAlarmNum = gsmOutserviceAlarmNum;
	}

	public String getGsmOutcapabilityAlarmNum() {
		return gsmOutcapabilityAlarmNum;
	}

	public void setGsmOutcapabilityAlarmNum(String gsmOutcapabilityAlarmNum) {
		this.gsmOutcapabilityAlarmNum = gsmOutcapabilityAlarmNum;
	}

	public String getGsmOutserviceAlarmTimes() {
		return gsmOutserviceAlarmTimes;
	}

	public void setGsmOutserviceAlarmTimes(String gsmOutserviceAlarmTimes) {
		this.gsmOutserviceAlarmTimes = gsmOutserviceAlarmTimes;
	}

	public String getGsmOutcapabilityAlarmTimes() {
		return gsmOutcapabilityAlarmTimes;
	}

	public void setGsmOutcapabilityAlarmTimes(String gsmOutcapabilityAlarmTimes) {
		this.gsmOutcapabilityAlarmTimes = gsmOutcapabilityAlarmTimes;
	}

	public String getGsmAlarmTimes() {
		return gsmAlarmTimes;
	}

	public void setGsmAlarmTimes(String gsmAlarmTimes) {
		this.gsmAlarmTimes = gsmAlarmTimes;
	}

	public String getGsmSectorAlarmDetail() {
		return gsmSectorAlarmDetail;
	}

	public void setGsmSectorAlarmDetail(String gsmSectorAlarmDetail) {
		this.gsmSectorAlarmDetail = gsmSectorAlarmDetail;
	}

	public String getGsmUnqualifiedSummary() {
		return gsmUnqualifiedSummary;
	}

	public void setGsmUnqualifiedSummary(String gsmUnqualifiedSummary) {
		this.gsmUnqualifiedSummary = gsmUnqualifiedSummary;
	}

	public String getGsmProblemSummaryClassify() {
		return gsmProblemSummaryClassify;
	}

	public void setGsmProblemSummaryClassify(String gsmProblemSummaryClassify) {
		this.gsmProblemSummaryClassify = gsmProblemSummaryClassify;
	}

	public String getGsmProblemSummaryClassify1() {
		return gsmProblemSummaryClassify1;
	}

	public void setGsmProblemSummaryClassify1(String gsmProblemSummaryClassify1) {
		this.gsmProblemSummaryClassify1 = gsmProblemSummaryClassify1;
	}

	public String getGsmDepartment() {
		return gsmDepartment;
	}

	public void setGsmDepartment(String gsmDepartment) {
		this.gsmDepartment = gsmDepartment;
	}

	public String getGsmSuggestions() {
		return gsmSuggestions;
	}

	public void setGsmSuggestions(String gsmSuggestions) {
		this.gsmSuggestions = gsmSuggestions;
	}

	public String getIsInterceptComplaint() {
		return isInterceptComplaint;
	}

	public void setIsInterceptComplaint(String isInterceptComplaint) {
		this.isInterceptComplaint = isInterceptComplaint;
	}

	public String getIsOldLocation() {
		return isOldLocation;
	}

	public void setIsOldLocation(String isOldLocation) {
		this.isOldLocation = isOldLocation;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getUserProperty() {
		return userProperty;
	}

	public void setUserProperty(String userProperty) {
		this.userProperty = userProperty;
	}

	public String getSiteProperty() {
		return siteProperty;
	}

	public void setSiteProperty(String siteProperty) {
		this.siteProperty = siteProperty;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getBusinesstype() {
		return businesstype;
	}

	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}

	public String getVoiceDataClassify() {
		return voiceDataClassify;
	}

	public void setVoiceDataClassify(String voiceDataClassify) {
		this.voiceDataClassify = voiceDataClassify;
	}

	public String getBusinessClassify() {
		return businessClassify;
	}

	public void setBusinessClassify(String businessClassify) {
		this.businessClassify = businessClassify;
	}

	public String getProblemClassify() {
		return problemClassify;
	}

	public void setProblemClassify(String problemClassify) {
		this.problemClassify = problemClassify;
	}

	public String getProblemDetail() {
		return problemDetail;
	}

	public void setProblemDetail(String problemDetail) {
		this.problemDetail = problemDetail;
	}

	public String getBussinesscontent() {
		return bussinesscontent;
	}

	public void setBussinesscontent(String bussinesscontent) {
		this.bussinesscontent = bussinesscontent;
	}

	public String getCompliantplace() {
		return compliantplace;
	}

	public void setCompliantplace(String compliantplace) {
		this.compliantplace = compliantplace;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getPreciseDate() {
		return preciseDate;
	}

	public void setPreciseDate(String preciseDate) {
		this.preciseDate = preciseDate;
	}

	public String getLocationProperty() {
		return locationProperty;
	}

	public void setLocationProperty(String locationProperty) {
		this.locationProperty = locationProperty;
	}

	public String getIsPreciseComplaint() {
		return isPreciseComplaint;
	}

	public void setIsPreciseComplaint(String isPreciseComplaint) {
		this.isPreciseComplaint = isPreciseComplaint;
	}

	public String getLteProblemSite() {
		return lteProblemSite;
	}

	public void setLteProblemSite(String lteProblemSite) {
		this.lteProblemSite = lteProblemSite;
	}

	public String getLteProblemSector() {
		return lteProblemSector;
	}

	public void setLteProblemSector(String lteProblemSector) {
		this.lteProblemSector = lteProblemSector;
	}

	public String getLteProblemCgi() {
		return lteProblemCgi;
	}

	public void setLteProblemCgi(String lteProblemCgi) {
		this.lteProblemCgi = lteProblemCgi;
	}

	public String getLteProblemEarfcn() {
		return lteProblemEarfcn;
	}

	public void setLteProblemEarfcn(String lteProblemEarfcn) {
		this.lteProblemEarfcn = lteProblemEarfcn;
	}

	public String getLteProblemSectorType() {
		return lteProblemSectorType;
	}

	public void setLteProblemSectorType(String lteProblemSectorType) {
		this.lteProblemSectorType = lteProblemSectorType;
	}

	public String getLteProblemSectorDis() {
		return lteProblemSectorDis;
	}

	public void setLteProblemSectorDis(String lteProblemSectorDis) {
		this.lteProblemSectorDis = lteProblemSectorDis;
	}

	public String getLteAreaCgi() {
		return lteAreaCgi;
	}

	public void setLteAreaCgi(String lteAreaCgi) {
		this.lteAreaCgi = lteAreaCgi;
	}

	public String getLteAreaSector() {
		return lteAreaSector;
	}

	public void setLteAreaSector(String lteAreaSector) {
		this.lteAreaSector = lteAreaSector;
	}

	public String getLteProblemSectorCnt() {
		return lteProblemSectorCnt;
	}

	public void setLteProblemSectorCnt(String lteProblemSectorCnt) {
		this.lteProblemSectorCnt = lteProblemSectorCnt;
	}

	public String getLteCoverRatio() {
		return lteCoverRatio;
	}

	public void setLteCoverRatio(String lteCoverRatio) {
		this.lteCoverRatio = lteCoverRatio;
	}

	public String getLteFaultRatio() {
		return lteFaultRatio;
	}

	public void setLteFaultRatio(String lteFaultRatio) {
		this.lteFaultRatio = lteFaultRatio;
	}

	public String getLteInterfereRatio() {
		return lteInterfereRatio;
	}

	public void setLteInterfereRatio(String lteInterfereRatio) {
		this.lteInterfereRatio = lteInterfereRatio;
	}

	public String getLteHighloadRatio() {
		return lteHighloadRatio;
	}

	public void setLteHighloadRatio(String lteHighloadRatio) {
		this.lteHighloadRatio = lteHighloadRatio;
	}

	public String getVolteRatio() {
		return volteRatio;
	}

	public void setVolteRatio(String volteRatio) {
		this.volteRatio = volteRatio;
	}

	public String getCsfbRatio() {
		return csfbRatio;
	}

	public void setCsfbRatio(String csfbRatio) {
		this.csfbRatio = csfbRatio;
	}

	public String getLteQuotaBadRatio() {
		return lteQuotaBadRatio;
	}

	public void setLteQuotaBadRatio(String lteQuotaBadRatio) {
		this.lteQuotaBadRatio = lteQuotaBadRatio;
	}

	public String getLtePlanSiteCnt() {
		return ltePlanSiteCnt;
	}

	public void setLtePlanSiteCnt(String ltePlanSiteCnt) {
		this.ltePlanSiteCnt = ltePlanSiteCnt;
	}

	public String getDemandSummary() {
		return demandSummary;
	}

	public void setDemandSummary(String demandSummary) {
		this.demandSummary = demandSummary;
	}

	public String getPlanSiteSummary() {
		return planSiteSummary;
	}

	public void setPlanSiteSummary(String planSiteSummary) {
		this.planSiteSummary = planSiteSummary;
	}

	public String getPlanCoverSiteCnt() {
		return planCoverSiteCnt;
	}

	public void setPlanCoverSiteCnt(String planCoverSiteCnt) {
		this.planCoverSiteCnt = planCoverSiteCnt;
	}

	public String getPlanCapacitySiteCnt() {
		return planCapacitySiteCnt;
	}

	public void setPlanCapacitySiteCnt(String planCapacitySiteCnt) {
		this.planCapacitySiteCnt = planCapacitySiteCnt;
	}

	public String getPlanOutdoorSiteCnt() {
		return planOutdoorSiteCnt;
	}

	public void setPlanOutdoorSiteCnt(String planOutdoorSiteCnt) {
		this.planOutdoorSiteCnt = planOutdoorSiteCnt;
	}

	public String getPlanIndoorSiteCnt() {
		return planIndoorSiteCnt;
	}

	public void setPlanIndoorSiteCnt(String planIndoorSiteCnt) {
		this.planIndoorSiteCnt = planIndoorSiteCnt;
	}

	public String getPlanFlySiteCnt() {
		return planFlySiteCnt;
	}

	public void setPlanFlySiteCnt(String planFlySiteCnt) {
		this.planFlySiteCnt = planFlySiteCnt;
	}

	public String getPlanSkinSiteCnt() {
		return planSkinSiteCnt;
	}

	public void setPlanSkinSiteCnt(String planSkinSiteCnt) {
		this.planSkinSiteCnt = planSkinSiteCnt;
	}

	public String getIsPlanSite() {
		return isPlanSite;
	}

	public void setIsPlanSite(String isPlanSite) {
		this.isPlanSite = isPlanSite;
	}

	public String getLteFaultSiteId() {
		return lteFaultSiteId;
	}

	public void setLteFaultSiteId(String lteFaultSiteId) {
		this.lteFaultSiteId = lteFaultSiteId;
	}

	public String getLteFaultSiteName() {
		return lteFaultSiteName;
	}

	public void setLteFaultSiteName(String lteFaultSiteName) {
		this.lteFaultSiteName = lteFaultSiteName;
	}

	public String getLteAlarmId() {
		return lteAlarmId;
	}

	public void setLteAlarmId(String lteAlarmId) {
		this.lteAlarmId = lteAlarmId;
	}

	public String getLteAlarmDetail() {
		return lteAlarmDetail;
	}

	public void setLteAlarmDetail(String lteAlarmDetail) {
		this.lteAlarmDetail = lteAlarmDetail;
	}

	public String getLteAlarmSmallType() {
		return lteAlarmSmallType;
	}

	public void setLteAlarmSmallType(String lteAlarmSmallType) {
		this.lteAlarmSmallType = lteAlarmSmallType;
	}

	public String getLteOutserviceAlarmNum() {
		return lteOutserviceAlarmNum;
	}

	public void setLteOutserviceAlarmNum(String lteOutserviceAlarmNum) {
		this.lteOutserviceAlarmNum = lteOutserviceAlarmNum;
	}

	public String getLteOutcapabilityAlarmNum() {
		return lteOutcapabilityAlarmNum;
	}

	public void setLteOutcapabilityAlarmNum(String lteOutcapabilityAlarmNum) {
		this.lteOutcapabilityAlarmNum = lteOutcapabilityAlarmNum;
	}

	public String getLteOutserviceAlarmRatio() {
		return lteOutserviceAlarmRatio;
	}

	public void setLteOutserviceAlarmRatio(String lteOutserviceAlarmRatio) {
		this.lteOutserviceAlarmRatio = lteOutserviceAlarmRatio;
	}

	public String getLteOutcapabilityAlarmRatio() {
		return lteOutcapabilityAlarmRatio;
	}

	public void setLteOutcapabilityAlarmRatio(String lteOutcapabilityAlarmRatio) {
		this.lteOutcapabilityAlarmRatio = lteOutcapabilityAlarmRatio;
	}

	public String getLteOutserviceAlarmTimes() {
		return lteOutserviceAlarmTimes;
	}

	public void setLteOutserviceAlarmTimes(String lteOutserviceAlarmTimes) {
		this.lteOutserviceAlarmTimes = lteOutserviceAlarmTimes;
	}

	public String getLteOutcapabilityAlarmTimes() {
		return lteOutcapabilityAlarmTimes;
	}

	public void setLteOutcapabilityAlarmTimes(String lteOutcapabilityAlarmTimes) {
		this.lteOutcapabilityAlarmTimes = lteOutcapabilityAlarmTimes;
	}

	public String getLteAlarmTimes() {
		return lteAlarmTimes;
	}

	public void setLteAlarmTimes(String lteAlarmTimes) {
		this.lteAlarmTimes = lteAlarmTimes;
	}

	public String getLteSectorAlarmDetail() {
		return lteSectorAlarmDetail;
	}

	public void setLteSectorAlarmDetail(String lteSectorAlarmDetail) {
		this.lteSectorAlarmDetail = lteSectorAlarmDetail;
	}

	public String getLteProblemSummary() {
		return lteProblemSummary;
	}

	public void setLteProblemSummary(String lteProblemSummary) {
		this.lteProblemSummary = lteProblemSummary;
	}

	public String getLteProblemSummaryClassify() {
		return lteProblemSummaryClassify;
	}

	public void setLteProblemSummaryClassify(String lteProblemSummaryClassify) {
		this.lteProblemSummaryClassify = lteProblemSummaryClassify;
	}

	public String getLteProblemSummaryClassify1() {
		return lteProblemSummaryClassify1;
	}

	public void setLteProblemSummaryClassify1(String lteProblemSummaryClassify1) {
		this.lteProblemSummaryClassify1 = lteProblemSummaryClassify1;
	}

	public String getLteWeakSectorCnt() {
		return lteWeakSectorCnt;
	}

	public void setLteWeakSectorCnt(String lteWeakSectorCnt) {
		this.lteWeakSectorCnt = lteWeakSectorCnt;
	}

	public String getLteWeakDays() {
		return lteWeakDays;
	}

	public void setLteWeakDays(String lteWeakDays) {
		this.lteWeakDays = lteWeakDays;
	}

	public String getLteVoltePerceptionRatio() {
		return lteVoltePerceptionRatio;
	}

	public void setLteVoltePerceptionRatio(String lteVoltePerceptionRatio) {
		this.lteVoltePerceptionRatio = lteVoltePerceptionRatio;
	}

	public String getLteNetPerceptionRatio() {
		return lteNetPerceptionRatio;
	}

	public void setLteNetPerceptionRatio(String lteNetPerceptionRatio) {
		this.lteNetPerceptionRatio = lteNetPerceptionRatio;
	}

	public String getLteLowspeedRatio() {
		return lteLowspeedRatio;
	}

	public void setLteLowspeedRatio(String lteLowspeedRatio) {
		this.lteLowspeedRatio = lteLowspeedRatio;
	}

	public String getSeqReasonsClassify() {
		return seqReasonsClassify;
	}

	public void setSeqReasonsClassify(String seqReasonsClassify) {
		this.seqReasonsClassify = seqReasonsClassify;
	}

	public String getSeqProblemSummary() {
		return seqProblemSummary;
	}

	public void setSeqProblemSummary(String seqProblemSummary) {
		this.seqProblemSummary = seqProblemSummary;
	}

	public String getSeqMainProblemClassify() {
		return seqMainProblemClassify;
	}

	public void setSeqMainProblemClassify(String seqMainProblemClassify) {
		this.seqMainProblemClassify = seqMainProblemClassify;
	}

	public String getSeqProblemDetail() {
		return seqProblemDetail;
	}

	public void setSeqProblemDetail(String seqProblemDetail) {
		this.seqProblemDetail = seqProblemDetail;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCenters() {
		return centers;
	}

	public void setCenters(String centers) {
		this.centers = centers;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getSizeProper() {
		return sizeProper;
	}

	public void setSizeProper(String sizeProper) {
		this.sizeProper = sizeProper;
	}

	public String getAcreage() {
		return acreage;
	}

	public void setAcreage(String acreage) {
		this.acreage = acreage;
	}

	public String getSmonth() {
		return smonth;
	}

	public void setSmonth(String smonth) {
		this.smonth = smonth;
	}

	public String getYYorSJ() {
		return YYorSJ;
	}

	public void setYYorSJ(String yYorSJ) {
		YYorSJ = yYorSJ;
	}

}
