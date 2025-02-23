package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: g  reason: default package and case insensitive filesystem */
/* compiled from: AadharKYCDTO */
public final class C1122g implements Serializable {
    private static final long serialVersionUID = 1;
    private String aadhaarName;
    private String aadhaarNumber;
    private String aadhaarRefNumId;
    private String address;
    private String colony;
    private Date dateOfBirth;
    private String district;
    private String dlCardholderName;
    private String dlDob;
    private String dlNumber;
    private String errorMessage;
    private String gender;
    private int kycMode;
    private String otp;
    private boolean otpFlag;
    private boolean otpNotRequired;
    private String otpTransactionId;
    private String pincode;
    private String postOffice;
    private String serverId;
    private String state;
    private String status;
    private String status1;
    private String status2;
    private String street;
    private Date timeStamp;
    private Boolean update;

    public String getAadhaarName() {
        return this.aadhaarName;
    }

    public String getAadhaarNumber() {
        return this.aadhaarNumber;
    }

    public String getAadhaarRefNumId() {
        return this.aadhaarRefNumId;
    }

    public String getAddress() {
        return this.address;
    }

    public String getColony() {
        return this.colony;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getDlCardholderName() {
        return this.dlCardholderName;
    }

    public String getDlDob() {
        return this.dlDob;
    }

    public String getDlNumber() {
        return this.dlNumber;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getGender() {
        return this.gender;
    }

    public int getKycMode() {
        return this.kycMode;
    }

    public String getOtp() {
        return this.otp;
    }

    public String getOtpTransactionId() {
        return this.otpTransactionId;
    }

    public String getPincode() {
        return this.pincode;
    }

    public String getPostOffice() {
        return this.postOffice;
    }

    public String getServerId() {
        return this.serverId;
    }

    public String getState() {
        return this.state;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatus1() {
        return this.status1;
    }

    public String getStatus2() {
        return this.status2;
    }

    public String getStreet() {
        return this.street;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public Boolean getUpdate() {
        return this.update;
    }

    public boolean isOtpFlag() {
        return this.otpFlag;
    }

    public boolean isOtpNotRequired() {
        return this.otpNotRequired;
    }

    public void setAadhaarName(String str) {
        this.aadhaarName = str;
    }

    public void setAadhaarNumber(String str) {
        this.aadhaarNumber = str;
    }

    public void setAadhaarRefNumId(String str) {
        this.aadhaarRefNumId = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setColony(String str) {
        this.colony = str;
    }

    public void setDateOfBirth(Date date) {
        this.dateOfBirth = date;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public void setDlCardholderName(String str) {
        this.dlCardholderName = str;
    }

    public void setDlDob(String str) {
        this.dlDob = str;
    }

    public void setDlNumber(String str) {
        this.dlNumber = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setKycMode(int i) {
        this.kycMode = i;
    }

    public void setOtp(String str) {
        this.otp = str;
    }

    public void setOtpFlag(boolean z) {
        this.otpFlag = z;
    }

    public void setOtpNotRequired(boolean z) {
        this.otpNotRequired = z;
    }

    public void setOtpTransactionId(String str) {
        this.otpTransactionId = str;
    }

    public void setPincode(String str) {
        this.pincode = str;
    }

    public void setPostOffice(String str) {
        this.postOffice = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setStatus1(String str) {
        this.status1 = str;
    }

    public void setStatus2(String str) {
        this.status2 = str;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setUpdate(Boolean bool) {
        this.update = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AadharKYCDTO [aadhaarNumber=");
        sb.append(this.aadhaarNumber);
        sb.append(", aadhaarName=");
        sb.append(this.aadhaarName);
        sb.append(", otp=");
        sb.append(this.otp);
        sb.append(", update=");
        sb.append(this.update);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(", dateOfBirth=");
        sb.append(this.dateOfBirth);
        sb.append(", gender=");
        sb.append(this.gender);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", street=");
        sb.append(this.street);
        sb.append(", colony=");
        sb.append(this.colony);
        sb.append(", pincode=");
        sb.append(this.pincode);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", district=");
        sb.append(this.district);
        sb.append(", postOffice=");
        sb.append(this.postOffice);
        sb.append(", serverId=");
        sb.append(this.serverId);
        sb.append(", timeStamp=");
        sb.append(this.timeStamp);
        sb.append(", otpTransactionId=");
        sb.append(this.otpTransactionId);
        sb.append(", otpNotRequired=");
        sb.append(this.otpNotRequired);
        sb.append(", kycMode=");
        sb.append(this.kycMode);
        sb.append(", dlNumber=");
        sb.append(this.dlNumber);
        sb.append(", dlCardholderName=");
        sb.append(this.dlCardholderName);
        sb.append(", dlDob=");
        sb.append(this.dlDob);
        sb.append(", otpFlag=");
        sb.append(this.otpFlag);
        sb.append(", aadhaarRefNumId=");
        return C0709Uj.j(sb, this.aadhaarRefNumId, "]");
    }
}
