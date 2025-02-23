package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: kx  reason: default package and case insensitive filesystem */
/* compiled from: SmsEmailDTO */
public final class C1229kx implements Serializable {
    private static final long serialVersionUID = 1;
    private String country;
    private int countrycode;
    private String email;
    private String emailCode;
    private String isd;
    private int isdCode;
    private String newEmail;
    private String newMobile;
    private String otpType;
    private String smsCode;
    private String txnId;
    private String userId;
    private String userLoginId;
    private String username;

    public static long getSerialversionuid() {
        return 1;
    }

    public String getCountry() {
        return this.country;
    }

    public int getCountrycode() {
        return this.countrycode;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEmailCode() {
        return this.emailCode;
    }

    public String getIsd() {
        return this.isd;
    }

    public int getIsdCode() {
        return this.isdCode;
    }

    public String getNewEmail() {
        return this.newEmail;
    }

    public String getNewMobile() {
        return this.newMobile;
    }

    public String getOtpType() {
        return this.otpType;
    }

    public String getSmsCode() {
        return this.smsCode;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserLoginId() {
        return this.userLoginId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCountrycode(int i) {
        this.countrycode = i;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEmailCode(String str) {
        this.emailCode = str;
    }

    public void setIsd(String str) {
        this.isd = str;
    }

    public void setIsdCode(int i) {
        this.isdCode = i;
    }

    public void setNewEmail(String str) {
        this.newEmail = str;
    }

    public void setNewMobile(String str) {
        this.newMobile = str;
    }

    public void setOtpType(String str) {
        this.otpType = str;
    }

    public void setSmsCode(String str) {
        this.smsCode = str;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserLoginId(String str) {
        this.userLoginId = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PostSmsEmailDTO [userId=");
        sb.append(this.userId);
        sb.append(", txnId=");
        sb.append(this.txnId);
        sb.append(", email=");
        sb.append(this.email);
        sb.append(", otpType=");
        sb.append(this.otpType);
        sb.append(", newMobile=");
        sb.append(this.newMobile);
        sb.append(", newEmail=");
        sb.append(this.newEmail);
        sb.append(", isd=");
        sb.append(this.isd);
        sb.append(", country=");
        sb.append(this.country);
        sb.append(", emailCode=");
        sb.append(this.emailCode);
        sb.append(", smsCode=");
        sb.append(this.smsCode);
        sb.append(", username=");
        sb.append(this.username);
        sb.append(", isdCode=");
        sb.append(this.isdCode);
        sb.append(", countrycode=");
        sb.append(this.countrycode);
        sb.append(", userLoginId=");
        sb.append(this.userLoginId);
        sb.append(", getUserLoginId()=");
        sb.append(getUserLoginId());
        sb.append(", getCountrycode()=");
        sb.append(getCountrycode());
        sb.append(", getIsdCode()=");
        sb.append(getIsdCode());
        sb.append(", getUserId()=");
        sb.append(getUserId());
        sb.append(", getTxnId()=");
        sb.append(getTxnId());
        sb.append(", getEmail()=");
        sb.append(getEmail());
        sb.append(", getOtpType()=");
        sb.append(getOtpType());
        sb.append(", getNewMobile()=");
        sb.append(getNewMobile());
        sb.append(", getNewEmail()=");
        sb.append(getNewEmail());
        sb.append(", getIsd()=");
        sb.append(getIsd());
        sb.append(", getCountry()=");
        sb.append(getCountry());
        sb.append(", getEmailCode()=");
        sb.append(getEmailCode());
        sb.append(", getSmsCode()=");
        sb.append(getSmsCode());
        sb.append(", getUsername()=");
        sb.append(getUsername());
        sb.append(", getClass()=");
        sb.append(C1229kx.class);
        sb.append(", hashCode()=");
        sb.append(hashCode());
        sb.append(", toString()=");
        return C0709Uj.j(sb, super.toString(), "]");
    }
}
