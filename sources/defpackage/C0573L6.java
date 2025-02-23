package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: L6  reason: default package and case insensitive filesystem */
/* compiled from: ConnectedPNRJourneyDTO */
public final class C0573L6 implements Serializable {
    private static final long serialVersionUID = 1;
    private String arrivalTime;
    private Boolean connectedJounreny;
    private String departureTime;
    private String fromStation;
    private String journeyClass;
    private String journeyDate;
    private String journeyQuota;
    private Integer journeyType = 0;
    private Boolean linkEligible;
    private Boolean mainJounrney;
    private String message;
    private String otpCode;
    private Integer otpResend = 0;
    private String pnrNumber;
    private long pnrTicketid;
    private String ticketType;
    private String toStation;
    private String trainNo;
    private String userid;

    public C0573L6() {
        Boolean bool = Boolean.FALSE;
        this.linkEligible = bool;
        this.mainJounrney = bool;
        this.connectedJounreny = bool;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public Boolean getConnectedJounreny() {
        return this.connectedJounreny;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public String getFromStation() {
        return this.fromStation;
    }

    public String getJourneyClass() {
        return this.journeyClass;
    }

    public String getJourneyDate() {
        return this.journeyDate;
    }

    public String getJourneyQuota() {
        return this.journeyQuota;
    }

    public Integer getJourneyType() {
        return this.journeyType;
    }

    public Boolean getLinkEligible() {
        return this.linkEligible;
    }

    public Boolean getMainJounrney() {
        return this.mainJounrney;
    }

    public String getMessage() {
        return this.message;
    }

    public String getOtpCode() {
        return this.otpCode;
    }

    public Integer getOtpResend() {
        return this.otpResend;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public long getPnrTicketid() {
        return this.pnrTicketid;
    }

    public String getTicketType() {
        return this.ticketType;
    }

    public String getToStation() {
        return this.toStation;
    }

    public String getTrainNo() {
        return this.trainNo;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setArrivalTime(String str) {
        this.arrivalTime = str;
    }

    public void setConnectedJounreny(Boolean bool) {
        this.connectedJounreny = bool;
    }

    public void setDepartureTime(String str) {
        this.departureTime = str;
    }

    public void setFromStation(String str) {
        this.fromStation = str;
    }

    public void setJourneyClass(String str) {
        this.journeyClass = str;
    }

    public void setJourneyDate(String str) {
        this.journeyDate = str;
    }

    public void setJourneyQuota(String str) {
        this.journeyQuota = str;
    }

    public void setJourneyType(Integer num) {
        this.journeyType = num;
    }

    public void setLinkEligible(Boolean bool) {
        this.linkEligible = bool;
    }

    public void setMainJounrney(Boolean bool) {
        this.mainJounrney = bool;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOtpCode(String str) {
        this.otpCode = str;
    }

    public void setOtpResend(Integer num) {
        this.otpResend = num;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public void setPnrTicketid(long j) {
        this.pnrTicketid = j;
    }

    public void setTicketType(String str) {
        this.ticketType = str;
    }

    public void setToStation(String str) {
        this.toStation = str;
    }

    public void setTrainNo(String str) {
        this.trainNo = str;
    }

    public void setUserid(String str) {
        this.userid = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConnectedPNRJourneyDTO [journeyDate=");
        sb.append(this.journeyDate);
        sb.append(", fromStation=");
        sb.append(this.fromStation);
        sb.append(", toStation=");
        sb.append(this.toStation);
        sb.append(", journeyQuota=");
        sb.append(this.journeyQuota);
        sb.append(", journeyClass=");
        sb.append(this.journeyClass);
        sb.append(", pnrNumber=");
        sb.append(this.pnrNumber);
        sb.append(", otpResend=");
        sb.append(this.otpResend);
        sb.append(", otpCode=");
        sb.append(this.otpCode);
        sb.append(", journeyType=");
        sb.append(this.journeyType);
        sb.append(", linkEligible=");
        sb.append(this.linkEligible);
        sb.append(", trainNo=");
        sb.append(this.trainNo);
        sb.append(", arrivalTime=");
        sb.append(this.arrivalTime);
        sb.append(", departureTime=");
        sb.append(this.departureTime);
        sb.append(", mainJounrney=");
        sb.append(this.mainJounrney);
        sb.append(", connectedJounreny=");
        sb.append(this.connectedJounreny);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", ticketType=");
        sb.append(this.ticketType);
        sb.append(", userid=");
        sb.append(this.userid);
        sb.append(", pnrTicketid=");
        return lf.l(sb, this.pnrTicketid, "]");
    }
}
