package defpackage;

import java.io.Serializable;
import java.util.Date;

/* renamed from: R1  reason: default package and case insensitive filesystem */
/* compiled from: AtasPnrBuffer */
public final class C0660R1 implements Serializable {
    private static final long serialVersionUID = 1;
    private int Otp;
    private int OtpCount;
    private String fromStaion;
    private String journeyClass;
    private String journeyDate;
    private String mobileNumber;
    private String pnrNumber;
    private String toStation;
    private String trainName;
    private String trainNumber;
    private Date utilJourneyDate;

    public String getFromStaion() {
        return this.fromStaion;
    }

    public String getJourneyClass() {
        return this.journeyClass;
    }

    public String getJourneyDate() {
        return this.journeyDate;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public int getOtp() {
        return this.Otp;
    }

    public int getOtpCount() {
        return this.OtpCount;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public String getToStation() {
        return this.toStation;
    }

    public String getTrainName() {
        return this.trainName;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public Date getUtilJourneyDate() {
        return this.utilJourneyDate;
    }

    public void setFromStaion(String str) {
        this.fromStaion = str;
    }

    public void setJourneyClass(String str) {
        this.journeyClass = str;
    }

    public void setJourneyDate(String str) {
        this.journeyDate = str;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public void setOtp(int i) {
        this.Otp = i;
    }

    public void setOtpCount(int i) {
        this.OtpCount = i;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public void setToStation(String str) {
        this.toStation = str;
    }

    public void setTrainName(String str) {
        this.trainName = str;
    }

    public void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public void setUtilJourneyDate(Date date) {
        this.utilJourneyDate = date;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AtasPnrBuffer [fromStaion=");
        sb.append(this.fromStaion);
        sb.append(", toStation=");
        sb.append(this.toStation);
        sb.append(", journeyDate=");
        sb.append(this.journeyDate);
        sb.append(", trainNumber=");
        sb.append(this.trainNumber);
        sb.append(", trainName=");
        sb.append(this.trainName);
        sb.append(", pnrNumber=");
        sb.append(this.pnrNumber);
        sb.append(", journeyClass=");
        sb.append(this.journeyClass);
        sb.append(", Otp=");
        sb.append(this.Otp);
        sb.append(", OtpCount=");
        sb.append(this.OtpCount);
        sb.append(", utilJourneyDate=");
        sb.append(this.utilJourneyDate);
        sb.append(", mobileNumber=");
        return C0709Uj.j(sb, this.mobileNumber, "]");
    }
}
