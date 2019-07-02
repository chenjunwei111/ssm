package com.spdb.pojo.complaint;
import java.sql.Date;

/**
 * KPI

 * @author Chan
*/

public class PRstKpiTargetsPojo {

private Integer legacyErabQci1Cnt;
private Integer erabHandoverQci1Cnt;
private Integer enbS1SucQci1Cnt;
private Integer enbX2SucQci1Cnt;
private Integer enbHandoverSucQci1Cnt;
private Integer enbS1ReqQci1Cnt;
private Integer enbX2ReqQci1Cnt;
private Integer enbHandoverReqQci1Cnt;
private Integer erabQci2SucCnt;
private Integer erabQci2ReqCnt;
private Integer enbReleaseErabQci2Cnt;
private Integer enbReleaseNormErabQci2Cnt;
private Integer erabFailQci2Cnt;
private Integer legacyErabQci2Cnt;
private Integer erabHandoverQci2Cnt;
private Integer enbS1SucQci2Cnt;
private Integer enbX2SucQci2Cnt;
private Integer enbHandoverSucQci2Cnt;
private Integer enbS1ReqQci2Cnt;
private Integer enbX2ReqQci2Cnt;
private Integer enbHandoverReqQci2Cnt;
private Integer erabFailCnt;
private Integer legacyErabCnt;
private Integer erabHandoverCnt;
private Integer rrcReconnectCnt;
private Integer enbS1SucCnt;
private Integer enbX2SucCnt;
private Integer enbHandoverSucCnt;
private Integer enbS1ReqCnt;
private Integer enbX2ReqCnt;
private Integer enbHandoverReqCnt;
private Integer gsmHandoverSucCnt;
private Integer gsmHandoverReqCnt;
private Integer tdHandoverSucCnt;
private Integer tdHandoverReqCnt;
private Integer upPacketLossCnt;
private Integer upPacketCnt;
private Integer downPacketLossCnt;
private Integer downPacketCnt;
private Integer downPacketDropCnt;
private Double avgUpPrbCnt;
private Double avgDownPrbCnt;
private Integer pagingDropCnt;
private Integer pagingReceiveCnt;
private Integer upLegacyTb;
private Integer upTransIniTb;
private Integer downLegacyTb;
private Integer downTransIniTb;
private Integer upTransTb;
private Integer qpskUpIniTb;
private Integer qam16UpIniTb;
private Integer qam64UpIniTb;
private Integer qpskDownIniTb;
private Integer qam16DownIniTb;
private Integer qam64DownIniTb;
private Integer tm2DownTb;
private Integer tm1DownTb;
private Integer tm3DownTb;
private Integer tm4DownTb;
private Integer tm5DownTb;
private Integer tm6DownTb;
private Integer tm7DownTb;
private Integer tm8DownTb;
private Double avgPuschPrbCnt;
private Double avgPuschPrbOccupy;
private Double avgPdschPrbCnt;
private Double avgPdschPrbOccupy;
private Integer puschTtiCnt;
private Integer pdschTtiCnt;
private Double pdcchCceRatio;
private Double avgRrcConnectCnt;
private Integer maxRrcConnectCnt;
private Integer pdcchCceOccupy;
private Integer pdcchCceCnt;
private Double erabQci1Ratio;
private Double connectedQci1Ratio;
private Double erabDropQci1Ratio;
private Double volteHandoverRatio;
private Double esrvccRatio;
private Double esrvccDelay;
private Double volteUpPrbCnt;
private Double volteDownPrbCnt;
private Double volteUpTtiCnt;
private Double volteDownTtiCnt;
private Double volteDownIblerCnt;
private Double volteUpIblerCnt;
private Double volteDownDelay;
private Double upMobilizeRatio;
private Double downMobilizeRatio;
private Double volteFlow;
private Double volteTraffic;
private Integer volteUsersNum;
private Double erabQci2Ratio;
private Double connectedQci2Ratio;
private Double erabDropQci2Ratio;
private Double handoverQci2Ratio;
private Double volteVideoFlow;
private Double volteVideoTraffic;
private Integer volteVideoUsersNum;
private Integer erabQci1SucCnt;
private Integer erabQci1ReqCnt;
private Integer enbReleaseErabQci1Cnt;
private Integer enbReleaseNormErabQci1Cnt;
private Integer erabFailQci1Cnt;
private String cityCode;
private Date versionDate;
private String province;
private String city;
private String area;
private String cgi;
private String equimentState;
private Double rrcRatio;
private Double erabRatio;
private Double connectedRatio;
private Double dropRatio;
private Double erabDropRatio;
private Double rrcReconnectRatio;
private Double hanoverSucRatio;
private Double l2gHandoverSucRatio;
private Double l2tHandoverSucRatio;
private Double difSysHandoverRatio;
private Double customerUpLossRatio;
private Double customerDownLossRatio;
private Double customerDownDropRatio;
private Double customerDownDelay;
private Double upFlow;
private Double downFlow;
public Integer getLegacyErabQci1Cnt() {
    return legacyErabQci1Cnt;
}

public void setLegacyErabQci1Cnt(Integer legacyErabQci1Cnt) {
    this.legacyErabQci1Cnt = legacyErabQci1Cnt;
}

public Integer getErabHandoverQci1Cnt() {
    return erabHandoverQci1Cnt;
}

public void setErabHandoverQci1Cnt(Integer erabHandoverQci1Cnt) {
    this.erabHandoverQci1Cnt = erabHandoverQci1Cnt;
}

public Integer getEnbS1SucQci1Cnt() {
    return enbS1SucQci1Cnt;
}

public void setEnbS1SucQci1Cnt(Integer enbS1SucQci1Cnt) {
    this.enbS1SucQci1Cnt = enbS1SucQci1Cnt;
}

public Integer getEnbX2SucQci1Cnt() {
    return enbX2SucQci1Cnt;
}

public void setEnbX2SucQci1Cnt(Integer enbX2SucQci1Cnt) {
    this.enbX2SucQci1Cnt = enbX2SucQci1Cnt;
}

public Integer getEnbHandoverSucQci1Cnt() {
    return enbHandoverSucQci1Cnt;
}

public void setEnbHandoverSucQci1Cnt(Integer enbHandoverSucQci1Cnt) {
    this.enbHandoverSucQci1Cnt = enbHandoverSucQci1Cnt;
}

public Integer getEnbS1ReqQci1Cnt() {
    return enbS1ReqQci1Cnt;
}

public void setEnbS1ReqQci1Cnt(Integer enbS1ReqQci1Cnt) {
    this.enbS1ReqQci1Cnt = enbS1ReqQci1Cnt;
}

public Integer getEnbX2ReqQci1Cnt() {
    return enbX2ReqQci1Cnt;
}

public void setEnbX2ReqQci1Cnt(Integer enbX2ReqQci1Cnt) {
    this.enbX2ReqQci1Cnt = enbX2ReqQci1Cnt;
}

public Integer getEnbHandoverReqQci1Cnt() {
    return enbHandoverReqQci1Cnt;
}

public void setEnbHandoverReqQci1Cnt(Integer enbHandoverReqQci1Cnt) {
    this.enbHandoverReqQci1Cnt = enbHandoverReqQci1Cnt;
}

public Integer getErabQci2SucCnt() {
    return erabQci2SucCnt;
}

public void setErabQci2SucCnt(Integer erabQci2SucCnt) {
    this.erabQci2SucCnt = erabQci2SucCnt;
}

public Integer getErabQci2ReqCnt() {
    return erabQci2ReqCnt;
}

public void setErabQci2ReqCnt(Integer erabQci2ReqCnt) {
    this.erabQci2ReqCnt = erabQci2ReqCnt;
}

public Integer getEnbReleaseErabQci2Cnt() {
    return enbReleaseErabQci2Cnt;
}

public void setEnbReleaseErabQci2Cnt(Integer enbReleaseErabQci2Cnt) {
    this.enbReleaseErabQci2Cnt = enbReleaseErabQci2Cnt;
}

public Integer getEnbReleaseNormErabQci2Cnt() {
    return enbReleaseNormErabQci2Cnt;
}

public void setEnbReleaseNormErabQci2Cnt(Integer enbReleaseNormErabQci2Cnt) {
    this.enbReleaseNormErabQci2Cnt = enbReleaseNormErabQci2Cnt;
}

public Integer getErabFailQci2Cnt() {
    return erabFailQci2Cnt;
}

public void setErabFailQci2Cnt(Integer erabFailQci2Cnt) {
    this.erabFailQci2Cnt = erabFailQci2Cnt;
}

public Integer getLegacyErabQci2Cnt() {
    return legacyErabQci2Cnt;
}

public void setLegacyErabQci2Cnt(Integer legacyErabQci2Cnt) {
    this.legacyErabQci2Cnt = legacyErabQci2Cnt;
}

public Integer getErabHandoverQci2Cnt() {
    return erabHandoverQci2Cnt;
}

public void setErabHandoverQci2Cnt(Integer erabHandoverQci2Cnt) {
    this.erabHandoverQci2Cnt = erabHandoverQci2Cnt;
}

public Integer getEnbS1SucQci2Cnt() {
    return enbS1SucQci2Cnt;
}

public void setEnbS1SucQci2Cnt(Integer enbS1SucQci2Cnt) {
    this.enbS1SucQci2Cnt = enbS1SucQci2Cnt;
}

public Integer getEnbX2SucQci2Cnt() {
    return enbX2SucQci2Cnt;
}

public void setEnbX2SucQci2Cnt(Integer enbX2SucQci2Cnt) {
    this.enbX2SucQci2Cnt = enbX2SucQci2Cnt;
}

public Integer getEnbHandoverSucQci2Cnt() {
    return enbHandoverSucQci2Cnt;
}

public void setEnbHandoverSucQci2Cnt(Integer enbHandoverSucQci2Cnt) {
    this.enbHandoverSucQci2Cnt = enbHandoverSucQci2Cnt;
}

public Integer getEnbS1ReqQci2Cnt() {
    return enbS1ReqQci2Cnt;
}

public void setEnbS1ReqQci2Cnt(Integer enbS1ReqQci2Cnt) {
    this.enbS1ReqQci2Cnt = enbS1ReqQci2Cnt;
}

public Integer getEnbX2ReqQci2Cnt() {
    return enbX2ReqQci2Cnt;
}

public void setEnbX2ReqQci2Cnt(Integer enbX2ReqQci2Cnt) {
    this.enbX2ReqQci2Cnt = enbX2ReqQci2Cnt;
}

public Integer getEnbHandoverReqQci2Cnt() {
    return enbHandoverReqQci2Cnt;
}

public void setEnbHandoverReqQci2Cnt(Integer enbHandoverReqQci2Cnt) {
    this.enbHandoverReqQci2Cnt = enbHandoverReqQci2Cnt;
}

public Integer getErabFailCnt() {
    return erabFailCnt;
}

public void setErabFailCnt(Integer erabFailCnt) {
    this.erabFailCnt = erabFailCnt;
}

public Integer getLegacyErabCnt() {
    return legacyErabCnt;
}

public void setLegacyErabCnt(Integer legacyErabCnt) {
    this.legacyErabCnt = legacyErabCnt;
}

public Integer getErabHandoverCnt() {
    return erabHandoverCnt;
}

public void setErabHandoverCnt(Integer erabHandoverCnt) {
    this.erabHandoverCnt = erabHandoverCnt;
}

public Integer getRrcReconnectCnt() {
    return rrcReconnectCnt;
}

public void setRrcReconnectCnt(Integer rrcReconnectCnt) {
    this.rrcReconnectCnt = rrcReconnectCnt;
}

public Integer getEnbS1SucCnt() {
    return enbS1SucCnt;
}

public void setEnbS1SucCnt(Integer enbS1SucCnt) {
    this.enbS1SucCnt = enbS1SucCnt;
}

public Integer getEnbX2SucCnt() {
    return enbX2SucCnt;
}

public void setEnbX2SucCnt(Integer enbX2SucCnt) {
    this.enbX2SucCnt = enbX2SucCnt;
}

public Integer getEnbHandoverSucCnt() {
    return enbHandoverSucCnt;
}

public void setEnbHandoverSucCnt(Integer enbHandoverSucCnt) {
    this.enbHandoverSucCnt = enbHandoverSucCnt;
}

public Integer getEnbS1ReqCnt() {
    return enbS1ReqCnt;
}

public void setEnbS1ReqCnt(Integer enbS1ReqCnt) {
    this.enbS1ReqCnt = enbS1ReqCnt;
}

public Integer getEnbX2ReqCnt() {
    return enbX2ReqCnt;
}

public void setEnbX2ReqCnt(Integer enbX2ReqCnt) {
    this.enbX2ReqCnt = enbX2ReqCnt;
}

public Integer getEnbHandoverReqCnt() {
    return enbHandoverReqCnt;
}

public void setEnbHandoverReqCnt(Integer enbHandoverReqCnt) {
    this.enbHandoverReqCnt = enbHandoverReqCnt;
}

public Integer getGsmHandoverSucCnt() {
    return gsmHandoverSucCnt;
}

public void setGsmHandoverSucCnt(Integer gsmHandoverSucCnt) {
    this.gsmHandoverSucCnt = gsmHandoverSucCnt;
}

public Integer getGsmHandoverReqCnt() {
    return gsmHandoverReqCnt;
}

public void setGsmHandoverReqCnt(Integer gsmHandoverReqCnt) {
    this.gsmHandoverReqCnt = gsmHandoverReqCnt;
}

public Integer getTdHandoverSucCnt() {
    return tdHandoverSucCnt;
}

public void setTdHandoverSucCnt(Integer tdHandoverSucCnt) {
    this.tdHandoverSucCnt = tdHandoverSucCnt;
}

public Integer getTdHandoverReqCnt() {
    return tdHandoverReqCnt;
}

public void setTdHandoverReqCnt(Integer tdHandoverReqCnt) {
    this.tdHandoverReqCnt = tdHandoverReqCnt;
}

public Integer getUpPacketLossCnt() {
    return upPacketLossCnt;
}

public void setUpPacketLossCnt(Integer upPacketLossCnt) {
    this.upPacketLossCnt = upPacketLossCnt;
}

public Integer getUpPacketCnt() {
    return upPacketCnt;
}

public void setUpPacketCnt(Integer upPacketCnt) {
    this.upPacketCnt = upPacketCnt;
}

public Integer getDownPacketLossCnt() {
    return downPacketLossCnt;
}

public void setDownPacketLossCnt(Integer downPacketLossCnt) {
    this.downPacketLossCnt = downPacketLossCnt;
}

public Integer getDownPacketCnt() {
    return downPacketCnt;
}

public void setDownPacketCnt(Integer downPacketCnt) {
    this.downPacketCnt = downPacketCnt;
}

public Integer getDownPacketDropCnt() {
    return downPacketDropCnt;
}

public void setDownPacketDropCnt(Integer downPacketDropCnt) {
    this.downPacketDropCnt = downPacketDropCnt;
}

public Double getAvgUpPrbCnt() {
    return avgUpPrbCnt;
}

public void setAvgUpPrbCnt(Double avgUpPrbCnt) {
    this.avgUpPrbCnt = avgUpPrbCnt;
}

public Double getAvgDownPrbCnt() {
    return avgDownPrbCnt;
}

public void setAvgDownPrbCnt(Double avgDownPrbCnt) {
    this.avgDownPrbCnt = avgDownPrbCnt;
}

public Integer getPagingDropCnt() {
    return pagingDropCnt;
}

public void setPagingDropCnt(Integer pagingDropCnt) {
    this.pagingDropCnt = pagingDropCnt;
}

public Integer getPagingReceiveCnt() {
    return pagingReceiveCnt;
}

public void setPagingReceiveCnt(Integer pagingReceiveCnt) {
    this.pagingReceiveCnt = pagingReceiveCnt;
}

public Integer getUpLegacyTb() {
    return upLegacyTb;
}

public void setUpLegacyTb(Integer upLegacyTb) {
    this.upLegacyTb = upLegacyTb;
}

public Integer getUpTransIniTb() {
    return upTransIniTb;
}

public void setUpTransIniTb(Integer upTransIniTb) {
    this.upTransIniTb = upTransIniTb;
}

public Integer getDownLegacyTb() {
    return downLegacyTb;
}

public void setDownLegacyTb(Integer downLegacyTb) {
    this.downLegacyTb = downLegacyTb;
}

public Integer getDownTransIniTb() {
    return downTransIniTb;
}

public void setDownTransIniTb(Integer downTransIniTb) {
    this.downTransIniTb = downTransIniTb;
}

public Integer getUpTransTb() {
    return upTransTb;
}

public void setUpTransTb(Integer upTransTb) {
    this.upTransTb = upTransTb;
}

public Integer getQpskUpIniTb() {
    return qpskUpIniTb;
}

public void setQpskUpIniTb(Integer qpskUpIniTb) {
    this.qpskUpIniTb = qpskUpIniTb;
}

public Integer getQam16UpIniTb() {
    return qam16UpIniTb;
}

public void setQam16UpIniTb(Integer qam16UpIniTb) {
    this.qam16UpIniTb = qam16UpIniTb;
}

public Integer getQam64UpIniTb() {
    return qam64UpIniTb;
}

public void setQam64UpIniTb(Integer qam64UpIniTb) {
    this.qam64UpIniTb = qam64UpIniTb;
}

public Integer getQpskDownIniTb() {
    return qpskDownIniTb;
}

public void setQpskDownIniTb(Integer qpskDownIniTb) {
    this.qpskDownIniTb = qpskDownIniTb;
}

public Integer getQam16DownIniTb() {
    return qam16DownIniTb;
}

public void setQam16DownIniTb(Integer qam16DownIniTb) {
    this.qam16DownIniTb = qam16DownIniTb;
}

public Integer getQam64DownIniTb() {
    return qam64DownIniTb;
}

public void setQam64DownIniTb(Integer qam64DownIniTb) {
    this.qam64DownIniTb = qam64DownIniTb;
}

public Integer getTm2DownTb() {
    return tm2DownTb;
}

public void setTm2DownTb(Integer tm2DownTb) {
    this.tm2DownTb = tm2DownTb;
}

public Integer getTm1DownTb() {
    return tm1DownTb;
}

public void setTm1DownTb(Integer tm1DownTb) {
    this.tm1DownTb = tm1DownTb;
}

public Integer getTm3DownTb() {
    return tm3DownTb;
}

public void setTm3DownTb(Integer tm3DownTb) {
    this.tm3DownTb = tm3DownTb;
}

public Integer getTm4DownTb() {
    return tm4DownTb;
}

public void setTm4DownTb(Integer tm4DownTb) {
    this.tm4DownTb = tm4DownTb;
}

public Integer getTm5DownTb() {
    return tm5DownTb;
}

public void setTm5DownTb(Integer tm5DownTb) {
    this.tm5DownTb = tm5DownTb;
}

public Integer getTm6DownTb() {
    return tm6DownTb;
}

public void setTm6DownTb(Integer tm6DownTb) {
    this.tm6DownTb = tm6DownTb;
}

public Integer getTm7DownTb() {
    return tm7DownTb;
}

public void setTm7DownTb(Integer tm7DownTb) {
    this.tm7DownTb = tm7DownTb;
}

public Integer getTm8DownTb() {
    return tm8DownTb;
}

public void setTm8DownTb(Integer tm8DownTb) {
    this.tm8DownTb = tm8DownTb;
}

public Double getAvgPuschPrbCnt() {
    return avgPuschPrbCnt;
}

public void setAvgPuschPrbCnt(Double avgPuschPrbCnt) {
    this.avgPuschPrbCnt = avgPuschPrbCnt;
}

public Double getAvgPuschPrbOccupy() {
    return avgPuschPrbOccupy;
}

public void setAvgPuschPrbOccupy(Double avgPuschPrbOccupy) {
    this.avgPuschPrbOccupy = avgPuschPrbOccupy;
}

public Double getAvgPdschPrbCnt() {
    return avgPdschPrbCnt;
}

public void setAvgPdschPrbCnt(Double avgPdschPrbCnt) {
    this.avgPdschPrbCnt = avgPdschPrbCnt;
}

public Double getAvgPdschPrbOccupy() {
    return avgPdschPrbOccupy;
}

public void setAvgPdschPrbOccupy(Double avgPdschPrbOccupy) {
    this.avgPdschPrbOccupy = avgPdschPrbOccupy;
}

public Integer getPuschTtiCnt() {
    return puschTtiCnt;
}

public void setPuschTtiCnt(Integer puschTtiCnt) {
    this.puschTtiCnt = puschTtiCnt;
}

public Integer getPdschTtiCnt() {
    return pdschTtiCnt;
}

public void setPdschTtiCnt(Integer pdschTtiCnt) {
    this.pdschTtiCnt = pdschTtiCnt;
}

public Double getPdcchCceRatio() {
    return pdcchCceRatio;
}

public void setPdcchCceRatio(Double pdcchCceRatio) {
    this.pdcchCceRatio = pdcchCceRatio;
}

public Double getAvgRrcConnectCnt() {
    return avgRrcConnectCnt;
}

public void setAvgRrcConnectCnt(Double avgRrcConnectCnt) {
    this.avgRrcConnectCnt = avgRrcConnectCnt;
}

public Integer getMaxRrcConnectCnt() {
    return maxRrcConnectCnt;
}

public void setMaxRrcConnectCnt(Integer maxRrcConnectCnt) {
    this.maxRrcConnectCnt = maxRrcConnectCnt;
}

public Integer getPdcchCceOccupy() {
    return pdcchCceOccupy;
}

public void setPdcchCceOccupy(Integer pdcchCceOccupy) {
    this.pdcchCceOccupy = pdcchCceOccupy;
}

public Integer getPdcchCceCnt() {
    return pdcchCceCnt;
}

public void setPdcchCceCnt(Integer pdcchCceCnt) {
    this.pdcchCceCnt = pdcchCceCnt;
}

public Double getErabQci1Ratio() {
    return erabQci1Ratio;
}

public void setErabQci1Ratio(Double erabQci1Ratio) {
    this.erabQci1Ratio = erabQci1Ratio;
}

public Double getConnectedQci1Ratio() {
    return connectedQci1Ratio;
}

public void setConnectedQci1Ratio(Double connectedQci1Ratio) {
    this.connectedQci1Ratio = connectedQci1Ratio;
}

public Double getErabDropQci1Ratio() {
    return erabDropQci1Ratio;
}

public void setErabDropQci1Ratio(Double erabDropQci1Ratio) {
    this.erabDropQci1Ratio = erabDropQci1Ratio;
}

public Double getVolteHandoverRatio() {
    return volteHandoverRatio;
}

public void setVolteHandoverRatio(Double volteHandoverRatio) {
    this.volteHandoverRatio = volteHandoverRatio;
}

public Double getEsrvccRatio() {
    return esrvccRatio;
}

public void setEsrvccRatio(Double esrvccRatio) {
    this.esrvccRatio = esrvccRatio;
}

public Double getEsrvccDelay() {
    return esrvccDelay;
}

public void setEsrvccDelay(Double esrvccDelay) {
    this.esrvccDelay = esrvccDelay;
}

public Double getVolteUpPrbCnt() {
    return volteUpPrbCnt;
}

public void setVolteUpPrbCnt(Double volteUpPrbCnt) {
    this.volteUpPrbCnt = volteUpPrbCnt;
}

public Double getVolteDownPrbCnt() {
    return volteDownPrbCnt;
}

public void setVolteDownPrbCnt(Double volteDownPrbCnt) {
    this.volteDownPrbCnt = volteDownPrbCnt;
}

public Double getVolteUpTtiCnt() {
    return volteUpTtiCnt;
}

public void setVolteUpTtiCnt(Double volteUpTtiCnt) {
    this.volteUpTtiCnt = volteUpTtiCnt;
}

public Double getVolteDownTtiCnt() {
    return volteDownTtiCnt;
}

public void setVolteDownTtiCnt(Double volteDownTtiCnt) {
    this.volteDownTtiCnt = volteDownTtiCnt;
}

public Double getVolteDownIblerCnt() {
    return volteDownIblerCnt;
}

public void setVolteDownIblerCnt(Double volteDownIblerCnt) {
    this.volteDownIblerCnt = volteDownIblerCnt;
}

public Double getVolteUpIblerCnt() {
    return volteUpIblerCnt;
}

public void setVolteUpIblerCnt(Double volteUpIblerCnt) {
    this.volteUpIblerCnt = volteUpIblerCnt;
}

public Double getVolteDownDelay() {
    return volteDownDelay;
}

public void setVolteDownDelay(Double volteDownDelay) {
    this.volteDownDelay = volteDownDelay;
}

public Double getUpMobilizeRatio() {
    return upMobilizeRatio;
}

public void setUpMobilizeRatio(Double upMobilizeRatio) {
    this.upMobilizeRatio = upMobilizeRatio;
}

public Double getDownMobilizeRatio() {
    return downMobilizeRatio;
}

public void setDownMobilizeRatio(Double downMobilizeRatio) {
    this.downMobilizeRatio = downMobilizeRatio;
}

public Double getVolteFlow() {
    return volteFlow;
}

public void setVolteFlow(Double volteFlow) {
    this.volteFlow = volteFlow;
}

public Double getVolteTraffic() {
    return volteTraffic;
}

public void setVolteTraffic(Double volteTraffic) {
    this.volteTraffic = volteTraffic;
}

public Integer getVolteUsersNum() {
    return volteUsersNum;
}

public void setVolteUsersNum(Integer volteUsersNum) {
    this.volteUsersNum = volteUsersNum;
}

public Double getErabQci2Ratio() {
    return erabQci2Ratio;
}

public void setErabQci2Ratio(Double erabQci2Ratio) {
    this.erabQci2Ratio = erabQci2Ratio;
}

public Double getConnectedQci2Ratio() {
    return connectedQci2Ratio;
}

public void setConnectedQci2Ratio(Double connectedQci2Ratio) {
    this.connectedQci2Ratio = connectedQci2Ratio;
}

public Double getErabDropQci2Ratio() {
    return erabDropQci2Ratio;
}

public void setErabDropQci2Ratio(Double erabDropQci2Ratio) {
    this.erabDropQci2Ratio = erabDropQci2Ratio;
}

public Double getHandoverQci2Ratio() {
    return handoverQci2Ratio;
}

public void setHandoverQci2Ratio(Double handoverQci2Ratio) {
    this.handoverQci2Ratio = handoverQci2Ratio;
}

public Double getVolteVideoFlow() {
    return volteVideoFlow;
}

public void setVolteVideoFlow(Double volteVideoFlow) {
    this.volteVideoFlow = volteVideoFlow;
}

public Double getVolteVideoTraffic() {
    return volteVideoTraffic;
}

public void setVolteVideoTraffic(Double volteVideoTraffic) {
    this.volteVideoTraffic = volteVideoTraffic;
}

public Integer getVolteVideoUsersNum() {
    return volteVideoUsersNum;
}

public void setVolteVideoUsersNum(Integer volteVideoUsersNum) {
    this.volteVideoUsersNum = volteVideoUsersNum;
}

public Integer getErabQci1SucCnt() {
    return erabQci1SucCnt;
}

public void setErabQci1SucCnt(Integer erabQci1SucCnt) {
    this.erabQci1SucCnt = erabQci1SucCnt;
}

public Integer getErabQci1ReqCnt() {
    return erabQci1ReqCnt;
}

public void setErabQci1ReqCnt(Integer erabQci1ReqCnt) {
    this.erabQci1ReqCnt = erabQci1ReqCnt;
}

public Integer getEnbReleaseErabQci1Cnt() {
    return enbReleaseErabQci1Cnt;
}

public void setEnbReleaseErabQci1Cnt(Integer enbReleaseErabQci1Cnt) {
    this.enbReleaseErabQci1Cnt = enbReleaseErabQci1Cnt;
}

public Integer getEnbReleaseNormErabQci1Cnt() {
    return enbReleaseNormErabQci1Cnt;
}

public void setEnbReleaseNormErabQci1Cnt(Integer enbReleaseNormErabQci1Cnt) {
    this.enbReleaseNormErabQci1Cnt = enbReleaseNormErabQci1Cnt;
}

public Integer getErabFailQci1Cnt() {
    return erabFailQci1Cnt;
}

public void setErabFailQci1Cnt(Integer erabFailQci1Cnt) {
    this.erabFailQci1Cnt = erabFailQci1Cnt;
}

public String getCityCode() {
    return cityCode;
}

public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
}

public Date getVersionDate() {
    return versionDate;
}

public void setVersionDate(Date versionDate) {
    this.versionDate = versionDate;
}

public String getEquimentState() {
    return equimentState;
}

public void setEquimentState(String equimentState) {
    this.equimentState = equimentState;
}

public Double getRrcRatio() {
    return rrcRatio;
}

public void setRrcRatio(Double rrcRatio) {
    this.rrcRatio = rrcRatio;
}

public Double getErabRatio() {
    return erabRatio;
}

public void setErabRatio(Double erabRatio) {
    this.erabRatio = erabRatio;
}

public Double getConnectedRatio() {
    return connectedRatio;
}

public void setConnectedRatio(Double connectedRatio) {
    this.connectedRatio = connectedRatio;
}

public Double getDropRatio() {
    return dropRatio;
}

public void setDropRatio(Double dropRatio) {
    this.dropRatio = dropRatio;
}

public Double getErabDropRatio() {
    return erabDropRatio;
}

public void setErabDropRatio(Double erabDropRatio) {
    this.erabDropRatio = erabDropRatio;
}

public Double getRrcReconnectRatio() {
    return rrcReconnectRatio;
}

public void setRrcReconnectRatio(Double rrcReconnectRatio) {
    this.rrcReconnectRatio = rrcReconnectRatio;
}

public Double getHanoverSucRatio() {
    return hanoverSucRatio;
}

public void setHanoverSucRatio(Double hanoverSucRatio) {
    this.hanoverSucRatio = hanoverSucRatio;
}

public Double getL2gHandoverSucRatio() {
    return l2gHandoverSucRatio;
}

public void setL2gHandoverSucRatio(Double l2gHandoverSucRatio) {
    this.l2gHandoverSucRatio = l2gHandoverSucRatio;
}

public Double getL2tHandoverSucRatio() {
    return l2tHandoverSucRatio;
}

public void setL2tHandoverSucRatio(Double l2tHandoverSucRatio) {
    this.l2tHandoverSucRatio = l2tHandoverSucRatio;
}

public Double getDifSysHandoverRatio() {
    return difSysHandoverRatio;
}

public void setDifSysHandoverRatio(Double difSysHandoverRatio) {
    this.difSysHandoverRatio = difSysHandoverRatio;
}

public Double getCustomerUpLossRatio() {
    return customerUpLossRatio;
}

public void setCustomerUpLossRatio(Double customerUpLossRatio) {
    this.customerUpLossRatio = customerUpLossRatio;
}

public Double getCustomerDownLossRatio() {
    return customerDownLossRatio;
}

public void setCustomerDownLossRatio(Double customerDownLossRatio) {
    this.customerDownLossRatio = customerDownLossRatio;
}

public Double getCustomerDownDropRatio() {
    return customerDownDropRatio;
}

public void setCustomerDownDropRatio(Double customerDownDropRatio) {
    this.customerDownDropRatio = customerDownDropRatio;
}

public Double getCustomerDownDelay() {
    return customerDownDelay;
}

public void setCustomerDownDelay(Double customerDownDelay) {
    this.customerDownDelay = customerDownDelay;
}

public Double getUpFlow() {
    return upFlow;
}

public void setUpFlow(Double upFlow) {
    this.upFlow = upFlow;
}

public Double getDownFlow() {
    return downFlow;
}

public void setDownFlow(Double downFlow) {
    this.downFlow = downFlow;
}

public Double getUpPrbRatio() {
    return upPrbRatio;
}

public void setUpPrbRatio(Double upPrbRatio) {
    this.upPrbRatio = upPrbRatio;
}

public Double getUpControlPrbRatio() {
    return upControlPrbRatio;
}

public void setUpControlPrbRatio(Double upControlPrbRatio) {
    this.upControlPrbRatio = upControlPrbRatio;
}

public Double getDownPrbRatio() {
    return downPrbRatio;
}

public void setDownPrbRatio(Double downPrbRatio) {
    this.downPrbRatio = downPrbRatio;
}

public Double getDownControlPrbRatio() {
    return downControlPrbRatio;
}

public void setDownControlPrbRatio(Double downControlPrbRatio) {
    this.downControlPrbRatio = downControlPrbRatio;
}

public Double getAvgUpPrbRatio() {
    return avgUpPrbRatio;
}

public void setAvgUpPrbRatio(Double avgUpPrbRatio) {
    this.avgUpPrbRatio = avgUpPrbRatio;
}

public Double getAvgDownPrbRatio() {
    return avgDownPrbRatio;
}

public void setAvgDownPrbRatio(Double avgDownPrbRatio) {
    this.avgDownPrbRatio = avgDownPrbRatio;
}

public Double getLinkRatio() {
    return linkRatio;
}

public void setLinkRatio(Double linkRatio) {
    this.linkRatio = linkRatio;
}

public Double getEnodebBusyRatio() {
    return enodebBusyRatio;
}

public void setEnodebBusyRatio(Double enodebBusyRatio) {
    this.enodebBusyRatio = enodebBusyRatio;
}

public Double getAvgUpPrbFlow() {
    return avgUpPrbFlow;
}

public void setAvgUpPrbFlow(Double avgUpPrbFlow) {
    this.avgUpPrbFlow = avgUpPrbFlow;
}

public Double getAvgDownPrbFlow() {
    return avgDownPrbFlow;
}

public void setAvgDownPrbFlow(Double avgDownPrbFlow) {
    this.avgDownPrbFlow = avgDownPrbFlow;
}

public Double getAvgRrcCnt() {
    return avgRrcCnt;
}

public void setAvgRrcCnt(Double avgRrcCnt) {
    this.avgRrcCnt = avgRrcCnt;
}

public Double getMaxRrcCnt() {
    return maxRrcCnt;
}

public void setMaxRrcCnt(Double maxRrcCnt) {
    this.maxRrcCnt = maxRrcCnt;
}

public Double getAvgErabCnt() {
    return avgErabCnt;
}

public void setAvgErabCnt(Double avgErabCnt) {
    this.avgErabCnt = avgErabCnt;
}

public Double getAvgRrcDelay() {
    return avgRrcDelay;
}

public void setAvgRrcDelay(Double avgRrcDelay) {
    this.avgRrcDelay = avgRrcDelay;
}

public Double getAvgErabDelay() {
    return avgErabDelay;
}

public void setAvgErabDelay(Double avgErabDelay) {
    this.avgErabDelay = avgErabDelay;
}

public Double getMacUpBlockErrorRatio() {
    return macUpBlockErrorRatio;
}

public void setMacUpBlockErrorRatio(Double macUpBlockErrorRatio) {
    this.macUpBlockErrorRatio = macUpBlockErrorRatio;
}

public Double getMacDownBlockErrorRatio() {
    return macDownBlockErrorRatio;
}

public void setMacDownBlockErrorRatio(Double macDownBlockErrorRatio) {
    this.macDownBlockErrorRatio = macDownBlockErrorRatio;
}

public Double getUpHarqRetransRatio() {
    return upHarqRetransRatio;
}

public void setUpHarqRetransRatio(Double upHarqRetransRatio) {
    this.upHarqRetransRatio = upHarqRetransRatio;
}

public Double getDownHarqRetransRatio() {
    return downHarqRetransRatio;
}

public void setDownHarqRetransRatio(Double downHarqRetransRatio) {
    this.downHarqRetransRatio = downHarqRetransRatio;
}

public Double getUpQpskRatio() {
    return upQpskRatio;
}

public void setUpQpskRatio(Double upQpskRatio) {
    this.upQpskRatio = upQpskRatio;
}

public Double getUp16qamRatio() {
    return up16qamRatio;
}

public void setUp16qamRatio(Double up16qamRatio) {
    this.up16qamRatio = up16qamRatio;
}

public Double getUp64qamRatio() {
    return up64qamRatio;
}

public void setUp64qamRatio(Double up64qamRatio) {
    this.up64qamRatio = up64qamRatio;
}

public Double getDownQpskRatio() {
    return downQpskRatio;
}

public void setDownQpskRatio(Double downQpskRatio) {
    this.downQpskRatio = downQpskRatio;
}

public Double getDown16qamRatio() {
    return down16qamRatio;
}

public void setDown16qamRatio(Double down16qamRatio) {
    this.down16qamRatio = down16qamRatio;
}

public Double getDown64qamRatio() {
    return down64qamRatio;
}

public void setDown64qamRatio(Double down64qamRatio) {
    this.down64qamRatio = down64qamRatio;
}

public Double getRank1DownTb() {
    return rank1DownTb;
}

public void setRank1DownTb(Double rank1DownTb) {
    this.rank1DownTb = rank1DownTb;
}

public Double getRank2DownTb() {
    return rank2DownTb;
}

public void setRank2DownTb(Double rank2DownTb) {
    this.rank2DownTb = rank2DownTb;
}

public Double getDownTb() {
    return downTb;
}

public void setDownTb(Double downTb) {
    this.downTb = downTb;
}

public Double getDownDoubleFlowRatio() {
    return downDoubleFlowRatio;
}

public void setDownDoubleFlowRatio(Double downDoubleFlowRatio) {
    this.downDoubleFlowRatio = downDoubleFlowRatio;
}

public Double getTm2Ratio() {
    return tm2Ratio;
}

public void setTm2Ratio(Double tm2Ratio) {
    this.tm2Ratio = tm2Ratio;
}

public Double getTm3Ratio() {
    return tm3Ratio;
}

public void setTm3Ratio(Double tm3Ratio) {
    this.tm3Ratio = tm3Ratio;
}

public Double getTm7Ratio() {
    return tm7Ratio;
}

public void setTm7Ratio(Double tm7Ratio) {
    this.tm7Ratio = tm7Ratio;
}

public Double getTm8Ratio() {
    return tm8Ratio;
}

public void setTm8Ratio(Double tm8Ratio) {
    this.tm8Ratio = tm8Ratio;
}

public Integer getRrcSucCnt() {
    return rrcSucCnt;
}

public void setRrcSucCnt(Integer rrcSucCnt) {
    this.rrcSucCnt = rrcSucCnt;
}

public Integer getRrcReqCnt() {
    return rrcReqCnt;
}

public void setRrcReqCnt(Integer rrcReqCnt) {
    this.rrcReqCnt = rrcReqCnt;
}

public Integer getErabSucCnt() {
    return erabSucCnt;
}

public void setErabSucCnt(Integer erabSucCnt) {
    this.erabSucCnt = erabSucCnt;
}

public Integer getErabReqCnt() {
    return erabReqCnt;
}

public void setErabReqCnt(Integer erabReqCnt) {
    this.erabReqCnt = erabReqCnt;
}

public Integer getEnbReleaseCnt() {
    return enbReleaseCnt;
}

public void setEnbReleaseCnt(Integer enbReleaseCnt) {
    this.enbReleaseCnt = enbReleaseCnt;
}

public Integer getEnbReleaseNormalCnt() {
    return enbReleaseNormalCnt;
}

public void setEnbReleaseNormalCnt(Integer enbReleaseNormalCnt) {
    this.enbReleaseNormalCnt = enbReleaseNormalCnt;
}

public Integer getIniEstblishCnt() {
    return iniEstblishCnt;
}

public void setIniEstblishCnt(Integer iniEstblishCnt) {
    this.iniEstblishCnt = iniEstblishCnt;
}

public Integer getLegacyCnt() {
    return legacyCnt;
}

public void setLegacyCnt(Integer legacyCnt) {
    this.legacyCnt = legacyCnt;
}

public Integer getEnbReleaseErabCnt() {
    return enbReleaseErabCnt;
}

public void setEnbReleaseErabCnt(Integer enbReleaseErabCnt) {
    this.enbReleaseErabCnt = enbReleaseErabCnt;
}

public Integer getEnbReleaseNormalErabCnt() {
    return enbReleaseNormalErabCnt;
}

public void setEnbReleaseNormalErabCnt(Integer enbReleaseNormalErabCnt) {
    this.enbReleaseNormalErabCnt = enbReleaseNormalErabCnt;
}

private Double upPrbRatio;
private Double upControlPrbRatio;
private Double downPrbRatio;
private Double downControlPrbRatio;
private Double avgUpPrbRatio;
private Double avgDownPrbRatio;
private Double linkRatio;
private Double enodebBusyRatio;
private Double avgUpPrbFlow;
private Double avgDownPrbFlow;
private Double avgRrcCnt;
private Double maxRrcCnt;
private Double avgErabCnt;
private Double avgRrcDelay;
private Double avgErabDelay;
private Double macUpBlockErrorRatio;
private Double macDownBlockErrorRatio;
private Double upHarqRetransRatio;
private Double downHarqRetransRatio;
private Double upQpskRatio;
private Double up16qamRatio;
private Double up64qamRatio;
private Double downQpskRatio;
private Double down16qamRatio;
private Double down64qamRatio;
private Double rank1DownTb;
private Double rank2DownTb;
private Double downTb;
private Double downDoubleFlowRatio;
private Double tm2Ratio;
private Double tm3Ratio;
private Double tm7Ratio;
private Double tm8Ratio;
private Integer rrcSucCnt;
private Integer rrcReqCnt;
private Integer erabSucCnt;
private Integer erabReqCnt;
private Integer enbReleaseCnt;
private Integer enbReleaseNormalCnt;
private Integer iniEstblishCnt;
private Integer legacyCnt;
private Integer enbReleaseErabCnt;
private Integer enbReleaseNormalErabCnt;

public void setLegacyerabqci1cnt(Integer legacyErabQci1Cnt) {
		this.legacyErabQci1Cnt = legacyErabQci1Cnt;
}

public Integer getLegacyerabqci1cnt() {
		return legacyErabQci1Cnt;
}

public void setErabhandoverqci1cnt(Integer erabHandoverQci1Cnt) {
		this.erabHandoverQci1Cnt = erabHandoverQci1Cnt;
}

public Integer getErabhandoverqci1cnt() {
		return erabHandoverQci1Cnt;
}

public void setEnbs1sucqci1cnt(Integer enbS1SucQci1Cnt) {
		this.enbS1SucQci1Cnt = enbS1SucQci1Cnt;
}

public Integer getEnbs1sucqci1cnt() {
		return enbS1SucQci1Cnt;
}

public void setEnbx2sucqci1cnt(Integer enbX2SucQci1Cnt) {
		this.enbX2SucQci1Cnt = enbX2SucQci1Cnt;
}

public Integer getEnbx2sucqci1cnt() {
		return enbX2SucQci1Cnt;
}

public void setEnbhandoversucqci1cnt(Integer enbHandoverSucQci1Cnt) {
		this.enbHandoverSucQci1Cnt = enbHandoverSucQci1Cnt;
}

public Integer getEnbhandoversucqci1cnt() {
		return enbHandoverSucQci1Cnt;
}

public void setEnbs1reqqci1cnt(Integer enbS1ReqQci1Cnt) {
		this.enbS1ReqQci1Cnt = enbS1ReqQci1Cnt;
}

public Integer getEnbs1reqqci1cnt() {
		return enbS1ReqQci1Cnt;
}

public void setEnbx2reqqci1cnt(Integer enbX2ReqQci1Cnt) {
		this.enbX2ReqQci1Cnt = enbX2ReqQci1Cnt;
}

public Integer getEnbx2reqqci1cnt() {
		return enbX2ReqQci1Cnt;
}

public void setEnbhandoverreqqci1cnt(Integer enbHandoverReqQci1Cnt) {
		this.enbHandoverReqQci1Cnt = enbHandoverReqQci1Cnt;
}

public Integer getEnbhandoverreqqci1cnt() {
		return enbHandoverReqQci1Cnt;
}

public void setErabqci2succnt(Integer erabQci2SucCnt) {
		this.erabQci2SucCnt = erabQci2SucCnt;
}

public Integer getErabqci2succnt() {
		return erabQci2SucCnt;
}

public void setErabqci2reqcnt(Integer erabQci2ReqCnt) {
		this.erabQci2ReqCnt = erabQci2ReqCnt;
}

public Integer getErabqci2reqcnt() {
		return erabQci2ReqCnt;
}

public void setEnbreleaseerabqci2cnt(Integer enbReleaseErabQci2Cnt) {
		this.enbReleaseErabQci2Cnt = enbReleaseErabQci2Cnt;
}

public Integer getEnbreleaseerabqci2cnt() {
		return enbReleaseErabQci2Cnt;
}

public void setEnbreleasenormerabqci2cnt(Integer enbReleaseNormErabQci2Cnt) {
		this.enbReleaseNormErabQci2Cnt = enbReleaseNormErabQci2Cnt;
}

public Integer getEnbreleasenormerabqci2cnt() {
		return enbReleaseNormErabQci2Cnt;
}

public void setErabfailqci2cnt(Integer erabFailQci2Cnt) {
		this.erabFailQci2Cnt = erabFailQci2Cnt;
}

public Integer getErabfailqci2cnt() {
		return erabFailQci2Cnt;
}

public void setLegacyerabqci2cnt(Integer legacyErabQci2Cnt) {
		this.legacyErabQci2Cnt = legacyErabQci2Cnt;
}

public Integer getLegacyerabqci2cnt() {
		return legacyErabQci2Cnt;
}

public void setErabhandoverqci2cnt(Integer erabHandoverQci2Cnt) {
		this.erabHandoverQci2Cnt = erabHandoverQci2Cnt;
}

public Integer getErabhandoverqci2cnt() {
		return erabHandoverQci2Cnt;
}

public void setEnbs1sucqci2cnt(Integer enbS1SucQci2Cnt) {
		this.enbS1SucQci2Cnt = enbS1SucQci2Cnt;
}

public Integer getEnbs1sucqci2cnt() {
		return enbS1SucQci2Cnt;
}

public void setEnbx2sucqci2cnt(Integer enbX2SucQci2Cnt) {
		this.enbX2SucQci2Cnt = enbX2SucQci2Cnt;
}

public Integer getEnbx2sucqci2cnt() {
		return enbX2SucQci2Cnt;
}

public void setEnbhandoversucqci2cnt(Integer enbHandoverSucQci2Cnt) {
		this.enbHandoverSucQci2Cnt = enbHandoverSucQci2Cnt;
}

public Integer getEnbhandoversucqci2cnt() {
		return enbHandoverSucQci2Cnt;
}

public void setEnbs1reqqci2cnt(Integer enbS1ReqQci2Cnt) {
		this.enbS1ReqQci2Cnt = enbS1ReqQci2Cnt;
}

public Integer getEnbs1reqqci2cnt() {
		return enbS1ReqQci2Cnt;
}

public void setEnbx2reqqci2cnt(Integer enbX2ReqQci2Cnt) {
		this.enbX2ReqQci2Cnt = enbX2ReqQci2Cnt;
}

public Integer getEnbx2reqqci2cnt() {
		return enbX2ReqQci2Cnt;
}

public void setEnbhandoverreqqci2cnt(Integer enbHandoverReqQci2Cnt) {
		this.enbHandoverReqQci2Cnt = enbHandoverReqQci2Cnt;
}

public Integer getEnbhandoverreqqci2cnt() {
		return enbHandoverReqQci2Cnt;
}

public void setErabfailcnt(Integer erabFailCnt) {
		this.erabFailCnt = erabFailCnt;
}

public Integer getErabfailcnt() {
		return erabFailCnt;
}

public void setLegacyerabcnt(Integer legacyErabCnt) {
		this.legacyErabCnt = legacyErabCnt;
}

public Integer getLegacyerabcnt() {
		return legacyErabCnt;
}

public void setErabhandovercnt(Integer erabHandoverCnt) {
		this.erabHandoverCnt = erabHandoverCnt;
}

public Integer getErabhandovercnt() {
		return erabHandoverCnt;
}

public void setRrcreconnectcnt(Integer rrcReconnectCnt) {
		this.rrcReconnectCnt = rrcReconnectCnt;
}

public Integer getRrcreconnectcnt() {
		return rrcReconnectCnt;
}

public void setEnbs1succnt(Integer enbS1SucCnt) {
		this.enbS1SucCnt = enbS1SucCnt;
}

public Integer getEnbs1succnt() {
		return enbS1SucCnt;
}

public void setEnbx2succnt(Integer enbX2SucCnt) {
		this.enbX2SucCnt = enbX2SucCnt;
}

public Integer getEnbx2succnt() {
		return enbX2SucCnt;
}

public void setEnbhandoversuccnt(Integer enbHandoverSucCnt) {
		this.enbHandoverSucCnt = enbHandoverSucCnt;
}

public Integer getEnbhandoversuccnt() {
		return enbHandoverSucCnt;
}

public void setEnbs1reqcnt(Integer enbS1ReqCnt) {
		this.enbS1ReqCnt = enbS1ReqCnt;
}

public Integer getEnbs1reqcnt() {
		return enbS1ReqCnt;
}

public void setEnbx2reqcnt(Integer enbX2ReqCnt) {
		this.enbX2ReqCnt = enbX2ReqCnt;
}

public Integer getEnbx2reqcnt() {
		return enbX2ReqCnt;
}

public void setEnbhandoverreqcnt(Integer enbHandoverReqCnt) {
		this.enbHandoverReqCnt = enbHandoverReqCnt;
}

public Integer getEnbhandoverreqcnt() {
		return enbHandoverReqCnt;
}

public void setGsmhandoversuccnt(Integer gsmHandoverSucCnt) {
		this.gsmHandoverSucCnt = gsmHandoverSucCnt;
}

public Integer getGsmhandoversuccnt() {
		return gsmHandoverSucCnt;
}

public void setGsmhandoverreqcnt(Integer gsmHandoverReqCnt) {
		this.gsmHandoverReqCnt = gsmHandoverReqCnt;
}

public Integer getGsmhandoverreqcnt() {
		return gsmHandoverReqCnt;
}

public void setTdhandoversuccnt(Integer tdHandoverSucCnt) {
		this.tdHandoverSucCnt = tdHandoverSucCnt;
}

public Integer getTdhandoversuccnt() {
		return tdHandoverSucCnt;
}

public void setTdhandoverreqcnt(Integer tdHandoverReqCnt) {
		this.tdHandoverReqCnt = tdHandoverReqCnt;
}

public Integer getTdhandoverreqcnt() {
		return tdHandoverReqCnt;
}

public void setUppacketlosscnt(Integer upPacketLossCnt) {
		this.upPacketLossCnt = upPacketLossCnt;
}

public Integer getUppacketlosscnt() {
		return upPacketLossCnt;
}

public void setUppacketcnt(Integer upPacketCnt) {
		this.upPacketCnt = upPacketCnt;
}

public Integer getUppacketcnt() {
		return upPacketCnt;
}

public void setDownpacketlosscnt(Integer downPacketLossCnt) {
		this.downPacketLossCnt = downPacketLossCnt;
}

public Integer getDownpacketlosscnt() {
		return downPacketLossCnt;
}

public void setDownpacketcnt(Integer downPacketCnt) {
		this.downPacketCnt = downPacketCnt;
}

public Integer getDownpacketcnt() {
		return downPacketCnt;
}

public void setDownpacketdropcnt(Integer downPacketDropCnt) {
		this.downPacketDropCnt = downPacketDropCnt;
}

public Integer getDownpacketdropcnt() {
		return downPacketDropCnt;
}

public void setAvgupprbcnt(Double avgUpPrbCnt) {
		this.avgUpPrbCnt = avgUpPrbCnt;
}

public Double getAvgupprbcnt() {
		return avgUpPrbCnt;
}

public void setAvgdownprbcnt(Double avgDownPrbCnt) {
		this.avgDownPrbCnt = avgDownPrbCnt;
}

public Double getAvgdownprbcnt() {
		return avgDownPrbCnt;
}

public void setPagingdropcnt(Integer pagingDropCnt) {
		this.pagingDropCnt = pagingDropCnt;
}

public Integer getPagingdropcnt() {
		return pagingDropCnt;
}

public void setPagingreceivecnt(Integer pagingReceiveCnt) {
		this.pagingReceiveCnt = pagingReceiveCnt;
}

public Integer getPagingreceivecnt() {
		return pagingReceiveCnt;
}

public void setUplegacytb(Integer upLegacyTb) {
		this.upLegacyTb = upLegacyTb;
}

public Integer getUplegacytb() {
		return upLegacyTb;
}

public void setUptransinitb(Integer upTransIniTb) {
		this.upTransIniTb = upTransIniTb;
}

public Integer getUptransinitb() {
		return upTransIniTb;
}

public void setDownlegacytb(Integer downLegacyTb) {
		this.downLegacyTb = downLegacyTb;
}

public Integer getDownlegacytb() {
		return downLegacyTb;
}

public void setDowntransinitb(Integer downTransIniTb) {
		this.downTransIniTb = downTransIniTb;
}

public Integer getDowntransinitb() {
		return downTransIniTb;
}

public void setUptranstb(Integer upTransTb) {
		this.upTransTb = upTransTb;
}

public Integer getUptranstb() {
		return upTransTb;
}

public void setQpskupinitb(Integer qpskUpIniTb) {
		this.qpskUpIniTb = qpskUpIniTb;
}

public Integer getQpskupinitb() {
		return qpskUpIniTb;
}

public void setQam16upinitb(Integer qam16UpIniTb) {
		this.qam16UpIniTb = qam16UpIniTb;
}

public Integer getQam16upinitb() {
		return qam16UpIniTb;
}

public void setQam64upinitb(Integer qam64UpIniTb) {
		this.qam64UpIniTb = qam64UpIniTb;
}

public Integer getQam64upinitb() {
		return qam64UpIniTb;
}

public void setQpskdowninitb(Integer qpskDownIniTb) {
		this.qpskDownIniTb = qpskDownIniTb;
}

public Integer getQpskdowninitb() {
		return qpskDownIniTb;
}

public void setQam16downinitb(Integer qam16DownIniTb) {
		this.qam16DownIniTb = qam16DownIniTb;
}

public Integer getQam16downinitb() {
		return qam16DownIniTb;
}

public void setQam64downinitb(Integer qam64DownIniTb) {
		this.qam64DownIniTb = qam64DownIniTb;
}

public Integer getQam64downinitb() {
		return qam64DownIniTb;
}

public void setTm2downtb(Integer tm2DownTb) {
		this.tm2DownTb = tm2DownTb;
}

public Integer getTm2downtb() {
		return tm2DownTb;
}

public void setTm1downtb(Integer tm1DownTb) {
		this.tm1DownTb = tm1DownTb;
}

public Integer getTm1downtb() {
		return tm1DownTb;
}

public void setTm3downtb(Integer tm3DownTb) {
		this.tm3DownTb = tm3DownTb;
}

public Integer getTm3downtb() {
		return tm3DownTb;
}

public void setTm4downtb(Integer tm4DownTb) {
		this.tm4DownTb = tm4DownTb;
}

public Integer getTm4downtb() {
		return tm4DownTb;
}

public void setTm5downtb(Integer tm5DownTb) {
		this.tm5DownTb = tm5DownTb;
}

public Integer getTm5downtb() {
		return tm5DownTb;
}

public void setTm6downtb(Integer tm6DownTb) {
		this.tm6DownTb = tm6DownTb;
}

public Integer getTm6downtb() {
		return tm6DownTb;
}

public void setTm7downtb(Integer tm7DownTb) {
		this.tm7DownTb = tm7DownTb;
}

public Integer getTm7downtb() {
		return tm7DownTb;
}

public void setTm8downtb(Integer tm8DownTb) {
		this.tm8DownTb = tm8DownTb;
}

public Integer getTm8downtb() {
		return tm8DownTb;
}

public void setAvgpuschprbcnt(Double avgPuschPrbCnt) {
		this.avgPuschPrbCnt = avgPuschPrbCnt;
}

public Double getAvgpuschprbcnt() {
		return avgPuschPrbCnt;
}

public void setAvgpuschprboccupy(Double avgPuschPrbOccupy) {
		this.avgPuschPrbOccupy = avgPuschPrbOccupy;
}

public Double getAvgpuschprboccupy() {
		return avgPuschPrbOccupy;
}

public void setAvgpdschprbcnt(Double avgPdschPrbCnt) {
		this.avgPdschPrbCnt = avgPdschPrbCnt;
}

public Double getAvgpdschprbcnt() {
		return avgPdschPrbCnt;
}

public void setAvgpdschprboccupy(Double avgPdschPrbOccupy) {
		this.avgPdschPrbOccupy = avgPdschPrbOccupy;
}

public Double getAvgpdschprboccupy() {
		return avgPdschPrbOccupy;
}

public void setPuschtticnt(Integer puschTtiCnt) {
		this.puschTtiCnt = puschTtiCnt;
}

public Integer getPuschtticnt() {
		return puschTtiCnt;
}

public void setPdschtticnt(Integer pdschTtiCnt) {
		this.pdschTtiCnt = pdschTtiCnt;
}

public Integer getPdschtticnt() {
		return pdschTtiCnt;
}

public void setPdcchcceratio(Double pdcchCceRatio) {
		this.pdcchCceRatio = pdcchCceRatio;
}

public Double getPdcchcceratio() {
		return pdcchCceRatio;
}

public void setAvgrrcconnectcnt(Double avgRrcConnectCnt) {
		this.avgRrcConnectCnt = avgRrcConnectCnt;
}

public Double getAvgrrcconnectcnt() {
		return avgRrcConnectCnt;
}

public void setMaxrrcconnectcnt(Integer maxRrcConnectCnt) {
		this.maxRrcConnectCnt = maxRrcConnectCnt;
}

public Integer getMaxrrcconnectcnt() {
		return maxRrcConnectCnt;
}

public void setPdcchcceoccupy(Integer pdcchCceOccupy) {
		this.pdcchCceOccupy = pdcchCceOccupy;
}

public Integer getPdcchcceoccupy() {
		return pdcchCceOccupy;
}

public void setPdcchccecnt(Integer pdcchCceCnt) {
		this.pdcchCceCnt = pdcchCceCnt;
}

public Integer getPdcchccecnt() {
		return pdcchCceCnt;
}

public void setErabqci1ratio(Double erabQci1Ratio) {
		this.erabQci1Ratio = erabQci1Ratio;
}

public Double getErabqci1ratio() {
		return erabQci1Ratio;
}

public void setConnectedqci1ratio(Double connectedQci1Ratio) {
		this.connectedQci1Ratio = connectedQci1Ratio;
}

public Double getConnectedqci1ratio() {
		return connectedQci1Ratio;
}

public void setErabdropqci1ratio(Double erabDropQci1Ratio) {
		this.erabDropQci1Ratio = erabDropQci1Ratio;
}

public Double getErabdropqci1ratio() {
		return erabDropQci1Ratio;
}

public void setVoltehandoverratio(Double volteHandoverRatio) {
		this.volteHandoverRatio = volteHandoverRatio;
}

public Double getVoltehandoverratio() {
		return volteHandoverRatio;
}

public void setEsrvccratio(Double esrvccRatio) {
		this.esrvccRatio = esrvccRatio;
}

public Double getEsrvccratio() {
		return esrvccRatio;
}

public void setEsrvccdelay(Double esrvccDelay) {
		this.esrvccDelay = esrvccDelay;
}

public Double getEsrvccdelay() {
		return esrvccDelay;
}

public void setVolteupprbcnt(Double volteUpPrbCnt) {
		this.volteUpPrbCnt = volteUpPrbCnt;
}

public Double getVolteupprbcnt() {
		return volteUpPrbCnt;
}

public void setVoltedownprbcnt(Double volteDownPrbCnt) {
		this.volteDownPrbCnt = volteDownPrbCnt;
}

public Double getVoltedownprbcnt() {
		return volteDownPrbCnt;
}

public void setVolteuptticnt(Double volteUpTtiCnt) {
		this.volteUpTtiCnt = volteUpTtiCnt;
}

public Double getVolteuptticnt() {
		return volteUpTtiCnt;
}

public void setVoltedowntticnt(Double volteDownTtiCnt) {
		this.volteDownTtiCnt = volteDownTtiCnt;
}

public Double getVoltedowntticnt() {
		return volteDownTtiCnt;
}

public void setVoltedowniblercnt(Double volteDownIblerCnt) {
		this.volteDownIblerCnt = volteDownIblerCnt;
}

public Double getVoltedowniblercnt() {
		return volteDownIblerCnt;
}

public void setVolteupiblercnt(Double volteUpIblerCnt) {
		this.volteUpIblerCnt = volteUpIblerCnt;
}

public Double getVolteupiblercnt() {
		return volteUpIblerCnt;
}

public void setVoltedowndelay(Double volteDownDelay) {
		this.volteDownDelay = volteDownDelay;
}

public Double getVoltedowndelay() {
		return volteDownDelay;
}

public void setUpmobilizeratio(Double upMobilizeRatio) {
		this.upMobilizeRatio = upMobilizeRatio;
}

public Double getUpmobilizeratio() {
		return upMobilizeRatio;
}

public void setDownmobilizeratio(Double downMobilizeRatio) {
		this.downMobilizeRatio = downMobilizeRatio;
}

public Double getDownmobilizeratio() {
		return downMobilizeRatio;
}

public void setVolteflow(Double volteFlow) {
		this.volteFlow = volteFlow;
}

public Double getVolteflow() {
		return volteFlow;
}

public void setVoltetraffic(Double volteTraffic) {
		this.volteTraffic = volteTraffic;
}

public Double getVoltetraffic() {
		return volteTraffic;
}

public void setVolteusersnum(Integer volteUsersNum) {
		this.volteUsersNum = volteUsersNum;
}

public Integer getVolteusersnum() {
		return volteUsersNum;
}

public void setErabqci2ratio(Double erabQci2Ratio) {
		this.erabQci2Ratio = erabQci2Ratio;
}

public Double getErabqci2ratio() {
		return erabQci2Ratio;
}

public void setConnectedqci2ratio(Double connectedQci2Ratio) {
		this.connectedQci2Ratio = connectedQci2Ratio;
}

public Double getConnectedqci2ratio() {
		return connectedQci2Ratio;
}

public void setErabdropqci2ratio(Double erabDropQci2Ratio) {
		this.erabDropQci2Ratio = erabDropQci2Ratio;
}

public Double getErabdropqci2ratio() {
		return erabDropQci2Ratio;
}

public void setHandoverqci2ratio(Double handoverQci2Ratio) {
		this.handoverQci2Ratio = handoverQci2Ratio;
}

public Double getHandoverqci2ratio() {
		return handoverQci2Ratio;
}

public void setVoltevideoflow(Double volteVideoFlow) {
		this.volteVideoFlow = volteVideoFlow;
}

public Double getVoltevideoflow() {
		return volteVideoFlow;
}

public void setVoltevideotraffic(Double volteVideoTraffic) {
		this.volteVideoTraffic = volteVideoTraffic;
}

public Double getVoltevideotraffic() {
		return volteVideoTraffic;
}

public void setVoltevideousersnum(Integer volteVideoUsersNum) {
		this.volteVideoUsersNum = volteVideoUsersNum;
}

public Integer getVoltevideousersnum() {
		return volteVideoUsersNum;
}

public void setErabqci1succnt(Integer erabQci1SucCnt) {
		this.erabQci1SucCnt = erabQci1SucCnt;
}

public Integer getErabqci1succnt() {
		return erabQci1SucCnt;
}

public void setErabqci1reqcnt(Integer erabQci1ReqCnt) {
		this.erabQci1ReqCnt = erabQci1ReqCnt;
}

public Integer getErabqci1reqcnt() {
		return erabQci1ReqCnt;
}

public void setEnbreleaseerabqci1cnt(Integer enbReleaseErabQci1Cnt) {
		this.enbReleaseErabQci1Cnt = enbReleaseErabQci1Cnt;
}

public Integer getEnbreleaseerabqci1cnt() {
		return enbReleaseErabQci1Cnt;
}

public void setEnbreleasenormerabqci1cnt(Integer enbReleaseNormErabQci1Cnt) {
		this.enbReleaseNormErabQci1Cnt = enbReleaseNormErabQci1Cnt;
}

public Integer getEnbreleasenormerabqci1cnt() {
		return enbReleaseNormErabQci1Cnt;
}

public void setErabfailqci1cnt(Integer erabFailQci1Cnt) {
		this.erabFailQci1Cnt = erabFailQci1Cnt;
}

public Integer getErabfailqci1cnt() {
		return erabFailQci1Cnt;
}

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

public void setProvince(String province) {
		this.province = province;
}

public String getProvince() {
		return province;
}

public void setCity(String city) {
		this.city = city;
}

public String getCity() {
		return city;
}

public void setArea(String area) {
		this.area = area;
}

public String getArea() {
		return area;
}

public void setCgi(String cgi) {
		this.cgi = cgi;
}

public String getCgi() {
		return cgi;
}

public void setEquimentstate(String equimentState) {
		this.equimentState = equimentState;
}

public String getEquimentstate() {
		return equimentState;
}

public void setRrcratio(Double rrcRatio) {
		this.rrcRatio = rrcRatio;
}

public Double getRrcratio() {
		return rrcRatio;
}

public void setErabratio(Double erabRatio) {
		this.erabRatio = erabRatio;
}

public Double getErabratio() {
		return erabRatio;
}

public void setConnectedratio(Double connectedRatio) {
		this.connectedRatio = connectedRatio;
}

public Double getConnectedratio() {
		return connectedRatio;
}

public void setDropratio(Double dropRatio) {
		this.dropRatio = dropRatio;
}

public Double getDropratio() {
		return dropRatio;
}

public void setErabdropratio(Double erabDropRatio) {
		this.erabDropRatio = erabDropRatio;
}

public Double getErabdropratio() {
		return erabDropRatio;
}

public void setRrcreconnectratio(Double rrcReconnectRatio) {
		this.rrcReconnectRatio = rrcReconnectRatio;
}

public Double getRrcreconnectratio() {
		return rrcReconnectRatio;
}

public void setHanoversucratio(Double hanoverSucRatio) {
		this.hanoverSucRatio = hanoverSucRatio;
}

public Double getHanoversucratio() {
		return hanoverSucRatio;
}

public void setL2ghandoversucratio(Double l2gHandoverSucRatio) {
		this.l2gHandoverSucRatio = l2gHandoverSucRatio;
}

public Double getL2ghandoversucratio() {
		return l2gHandoverSucRatio;
}

public void setL2thandoversucratio(Double l2tHandoverSucRatio) {
		this.l2tHandoverSucRatio = l2tHandoverSucRatio;
}

public Double getL2thandoversucratio() {
		return l2tHandoverSucRatio;
}

public void setDifsyshandoverratio(Double difSysHandoverRatio) {
		this.difSysHandoverRatio = difSysHandoverRatio;
}

public Double getDifsyshandoverratio() {
		return difSysHandoverRatio;
}

public void setCustomeruplossratio(Double customerUpLossRatio) {
		this.customerUpLossRatio = customerUpLossRatio;
}

public Double getCustomeruplossratio() {
		return customerUpLossRatio;
}

public void setCustomerdownlossratio(Double customerDownLossRatio) {
		this.customerDownLossRatio = customerDownLossRatio;
}

public Double getCustomerdownlossratio() {
		return customerDownLossRatio;
}

public void setCustomerdowndropratio(Double customerDownDropRatio) {
		this.customerDownDropRatio = customerDownDropRatio;
}

public Double getCustomerdowndropratio() {
		return customerDownDropRatio;
}

public void setCustomerdowndelay(Double customerDownDelay) {
		this.customerDownDelay = customerDownDelay;
}

public Double getCustomerdowndelay() {
		return customerDownDelay;
}

public void setUpflow(Double upFlow) {
		this.upFlow = upFlow;
}

public Double getUpflow() {
		return upFlow;
}

public void setDownflow(Double downFlow) {
		this.downFlow = downFlow;
}

public Double getDownflow() {
		return downFlow;
}

public void setUpprbratio(Double upPrbRatio) {
		this.upPrbRatio = upPrbRatio;
}

public Double getUpprbratio() {
		return upPrbRatio;
}

public void setUpcontrolprbratio(Double upControlPrbRatio) {
		this.upControlPrbRatio = upControlPrbRatio;
}

public Double getUpcontrolprbratio() {
		return upControlPrbRatio;
}

public void setDownprbratio(Double downPrbRatio) {
		this.downPrbRatio = downPrbRatio;
}

public Double getDownprbratio() {
		return downPrbRatio;
}

public void setDowncontrolprbratio(Double downControlPrbRatio) {
		this.downControlPrbRatio = downControlPrbRatio;
}

public Double getDowncontrolprbratio() {
		return downControlPrbRatio;
}

public void setAvgupprbratio(Double avgUpPrbRatio) {
		this.avgUpPrbRatio = avgUpPrbRatio;
}

public Double getAvgupprbratio() {
		return avgUpPrbRatio;
}

public void setAvgdownprbratio(Double avgDownPrbRatio) {
		this.avgDownPrbRatio = avgDownPrbRatio;
}

public Double getAvgdownprbratio() {
		return avgDownPrbRatio;
}

public void setLinkratio(Double linkRatio) {
		this.linkRatio = linkRatio;
}

public Double getLinkratio() {
		return linkRatio;
}

public void setEnodebbusyratio(Double enodebBusyRatio) {
		this.enodebBusyRatio = enodebBusyRatio;
}

public Double getEnodebbusyratio() {
		return enodebBusyRatio;
}

public void setAvgupprbflow(Double avgUpPrbFlow) {
		this.avgUpPrbFlow = avgUpPrbFlow;
}

public Double getAvgupprbflow() {
		return avgUpPrbFlow;
}

public void setAvgdownprbflow(Double avgDownPrbFlow) {
		this.avgDownPrbFlow = avgDownPrbFlow;
}

public Double getAvgdownprbflow() {
		return avgDownPrbFlow;
}

public void setAvgrrccnt(Double avgRrcCnt) {
		this.avgRrcCnt = avgRrcCnt;
}

public Double getAvgrrccnt() {
		return avgRrcCnt;
}

public void setMaxrrccnt(Double maxRrcCnt) {
		this.maxRrcCnt = maxRrcCnt;
}

public Double getMaxrrccnt() {
		return maxRrcCnt;
}

public void setAvgerabcnt(Double avgErabCnt) {
		this.avgErabCnt = avgErabCnt;
}

public Double getAvgerabcnt() {
		return avgErabCnt;
}

public void setAvgrrcdelay(Double avgRrcDelay) {
		this.avgRrcDelay = avgRrcDelay;
}

public Double getAvgrrcdelay() {
		return avgRrcDelay;
}

public void setAvgerabdelay(Double avgErabDelay) {
		this.avgErabDelay = avgErabDelay;
}

public Double getAvgerabdelay() {
		return avgErabDelay;
}

public void setMacupblockerrorratio(Double macUpBlockErrorRatio) {
		this.macUpBlockErrorRatio = macUpBlockErrorRatio;
}

public Double getMacupblockerrorratio() {
		return macUpBlockErrorRatio;
}

public void setMacdownblockerrorratio(Double macDownBlockErrorRatio) {
		this.macDownBlockErrorRatio = macDownBlockErrorRatio;
}

public Double getMacdownblockerrorratio() {
		return macDownBlockErrorRatio;
}

public void setUpharqretransratio(Double upHarqRetransRatio) {
		this.upHarqRetransRatio = upHarqRetransRatio;
}

public Double getUpharqretransratio() {
		return upHarqRetransRatio;
}

public void setDownharqretransratio(Double downHarqRetransRatio) {
		this.downHarqRetransRatio = downHarqRetransRatio;
}

public Double getDownharqretransratio() {
		return downHarqRetransRatio;
}

public void setUpqpskratio(Double upQpskRatio) {
		this.upQpskRatio = upQpskRatio;
}

public Double getUpqpskratio() {
		return upQpskRatio;
}

public void setUp16qamratio(Double up16qamRatio) {
		this.up16qamRatio = up16qamRatio;
}

public Double getUp16qamratio() {
		return up16qamRatio;
}

public void setUp64qamratio(Double up64qamRatio) {
		this.up64qamRatio = up64qamRatio;
}

public Double getUp64qamratio() {
		return up64qamRatio;
}

public void setDownqpskratio(Double downQpskRatio) {
		this.downQpskRatio = downQpskRatio;
}

public Double getDownqpskratio() {
		return downQpskRatio;
}

public void setDown16qamratio(Double down16qamRatio) {
		this.down16qamRatio = down16qamRatio;
}

public Double getDown16qamratio() {
		return down16qamRatio;
}

public void setDown64qamratio(Double down64qamRatio) {
		this.down64qamRatio = down64qamRatio;
}

public Double getDown64qamratio() {
		return down64qamRatio;
}

public void setRank1downtb(Double rank1DownTb) {
		this.rank1DownTb = rank1DownTb;
}

public Double getRank1downtb() {
		return rank1DownTb;
}

public void setRank2downtb(Double rank2DownTb) {
		this.rank2DownTb = rank2DownTb;
}

public Double getRank2downtb() {
		return rank2DownTb;
}

public void setDowntb(Double downTb) {
		this.downTb = downTb;
}

public Double getDowntb() {
		return downTb;
}

public void setDowndoubleflowratio(Double downDoubleFlowRatio) {
		this.downDoubleFlowRatio = downDoubleFlowRatio;
}

public Double getDowndoubleflowratio() {
		return downDoubleFlowRatio;
}

public void setTm2ratio(Double tm2Ratio) {
		this.tm2Ratio = tm2Ratio;
}

public Double getTm2ratio() {
		return tm2Ratio;
}

public void setTm3ratio(Double tm3Ratio) {
		this.tm3Ratio = tm3Ratio;
}

public Double getTm3ratio() {
		return tm3Ratio;
}

public void setTm7ratio(Double tm7Ratio) {
		this.tm7Ratio = tm7Ratio;
}

public Double getTm7ratio() {
		return tm7Ratio;
}

public void setTm8ratio(Double tm8Ratio) {
		this.tm8Ratio = tm8Ratio;
}

public Double getTm8ratio() {
		return tm8Ratio;
}

public void setRrcsuccnt(Integer rrcSucCnt) {
		this.rrcSucCnt = rrcSucCnt;
}

public Integer getRrcsuccnt() {
		return rrcSucCnt;
}

public void setRrcreqcnt(Integer rrcReqCnt) {
		this.rrcReqCnt = rrcReqCnt;
}

public Integer getRrcreqcnt() {
		return rrcReqCnt;
}

public void setErabsuccnt(Integer erabSucCnt) {
		this.erabSucCnt = erabSucCnt;
}

public Integer getErabsuccnt() {
		return erabSucCnt;
}

public void setErabreqcnt(Integer erabReqCnt) {
		this.erabReqCnt = erabReqCnt;
}

public Integer getErabreqcnt() {
		return erabReqCnt;
}

public void setEnbreleasecnt(Integer enbReleaseCnt) {
		this.enbReleaseCnt = enbReleaseCnt;
}

public Integer getEnbreleasecnt() {
		return enbReleaseCnt;
}

public void setEnbreleasenormalcnt(Integer enbReleaseNormalCnt) {
		this.enbReleaseNormalCnt = enbReleaseNormalCnt;
}

public Integer getEnbreleasenormalcnt() {
		return enbReleaseNormalCnt;
}

public void setIniestblishcnt(Integer iniEstblishCnt) {
		this.iniEstblishCnt = iniEstblishCnt;
}

public Integer getIniestblishcnt() {
		return iniEstblishCnt;
}

public void setLegacycnt(Integer legacyCnt) {
		this.legacyCnt = legacyCnt;
}

public Integer getLegacycnt() {
		return legacyCnt;
}

public void setEnbreleaseerabcnt(Integer enbReleaseErabCnt) {
		this.enbReleaseErabCnt = enbReleaseErabCnt;
}

public Integer getEnbreleaseerabcnt() {
		return enbReleaseErabCnt;
}

public void setEnbreleasenormalerabcnt(Integer enbReleaseNormalErabCnt) {
		this.enbReleaseNormalErabCnt = enbReleaseNormalErabCnt;
}

public Integer getEnbreleasenormalerabcnt() {
		return enbReleaseNormalErabCnt;
}

}
