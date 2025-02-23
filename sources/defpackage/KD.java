package defpackage;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: KD  reason: default package */
/* compiled from: WlPredictionReqDTO */
public final class KD {
    private String bookingDate;
    private String currentStatus;
    private Integer currentStatusNumber;
    private String fromStnCode;
    private String journeyClass;
    private String journeyDate;
    private String quota;
    private String runningStatus;
    private Integer runningStatusNumber;
    private String siteId;
    private String toStnCode;
    private String trainNumber;
    private Integer wlType;

    public String getBookingDate() {
        return this.bookingDate;
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public Integer getCurrentStatusNumber() {
        return this.currentStatusNumber;
    }

    public String getFromStnCode() {
        return this.fromStnCode;
    }

    public String getJourneyClass() {
        return this.journeyClass;
    }

    public String getJourneyDate() {
        return this.journeyDate;
    }

    public String getQuota() {
        return this.quota;
    }

    public String getRunningStatus() {
        return this.runningStatus;
    }

    public Integer getRunningStatusNumber() {
        return this.runningStatusNumber;
    }

    public String getSiteId() {
        return this.siteId;
    }

    public String getToStnCode() {
        return this.toStnCode;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public Integer getWlType() {
        return this.wlType;
    }

    public void setBookingDate(String str) {
        this.bookingDate = str;
    }

    public void setCurrentStatus(String str) {
        this.currentStatus = str;
    }

    public void setCurrentStatusNumber(Integer num) {
        this.currentStatusNumber = num;
    }

    public void setFromStnCode(String str) {
        this.fromStnCode = str;
    }

    public void setJourneyClass(String str) {
        this.journeyClass = str;
    }

    public void setJourneyDate(String str) {
        this.journeyDate = str;
    }

    public void setQuota(String str) {
        this.quota = str;
    }

    public void setRunningStatus(String str) {
        this.runningStatus = str;
    }

    public void setRunningStatusNumber(Integer num) {
        this.runningStatusNumber = num;
    }

    public void setSiteId(String str) {
        this.siteId = str;
    }

    public void setToStnCode(String str) {
        this.toStnCode = str;
    }

    public void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public void setWlType(Integer num) {
        this.wlType = num;
    }

    public String toString() {
        return "WlPredictionReqDTO [bookingDate=" + this.bookingDate + ", currentStatus=" + this.currentStatus + ", currentStatusNumber=" + this.currentStatusNumber + ", fromStnCode=" + this.fromStnCode + ", journeyClass=" + this.journeyClass + ", journeyDate=" + this.journeyDate + ", quota=" + this.quota + ", runningStatus=" + this.runningStatus + ", runningStatusNumber=" + this.runningStatusNumber + ", siteId=" + this.siteId + ", toStnCode=" + this.toStnCode + ", trainNumber=" + this.trainNumber + ", wlType=" + this.wlType + "]";
    }
}
