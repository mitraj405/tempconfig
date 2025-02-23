package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: BB  reason: default package and case insensitive filesystem */
/* compiled from: UserAvailablityDTO */
public final class C0459BB implements Serializable {
    private static final long serialVersionUID = 1;
    private String agentPanAvailable;
    private String agentpan;
    private String certid;
    private String certidAvailable;
    private String disposableEmail;
    private String email;
    private String emailAvailable;
    private String isd;
    private String mobile;
    private String mobileAvailable;
    private int monthlyBookingCount;
    private boolean userAadharKycStatus;
    private String userPanAvailable;
    private String userid;
    private String useridAvailable;
    private String userpan;

    public String getAgentPanAvailable() {
        return this.agentPanAvailable;
    }

    public String getAgentpan() {
        return this.agentpan;
    }

    public String getCertid() {
        return this.certid;
    }

    public String getCertidAvailable() {
        return this.certidAvailable;
    }

    public String getDisposableEmail() {
        return this.disposableEmail;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEmailAvailable() {
        return this.emailAvailable;
    }

    public String getIsd() {
        return this.isd;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getMobileAvailable() {
        return this.mobileAvailable;
    }

    public int getMonthlyBookingCount() {
        return this.monthlyBookingCount;
    }

    public String getUserPanAvailable() {
        return this.userPanAvailable;
    }

    public String getUserid() {
        return this.userid;
    }

    public String getUseridAvailable() {
        return this.useridAvailable;
    }

    public String getUserpan() {
        return this.userpan;
    }

    public boolean isUserAadharKycStatus() {
        return this.userAadharKycStatus;
    }

    public void setAgentPanAvailable(String str) {
        this.agentPanAvailable = str;
    }

    public void setAgentpan(String str) {
        this.agentpan = str;
    }

    public void setCertid(String str) {
        this.certid = str;
    }

    public void setCertidAvailable(String str) {
        this.certidAvailable = str;
    }

    public void setDisposableEmail(String str) {
        this.disposableEmail = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEmailAvailable(String str) {
        this.emailAvailable = str;
    }

    public void setIsd(String str) {
        this.isd = str;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setMobileAvailable(String str) {
        this.mobileAvailable = str;
    }

    public void setMonthlyBookingCount(int i) {
        this.monthlyBookingCount = i;
    }

    public void setUserAadharKycStatus(boolean z) {
        this.userAadharKycStatus = z;
    }

    public void setUserPanAvailable(String str) {
        this.userPanAvailable = str;
    }

    public void setUserid(String str) {
        this.userid = str;
    }

    public void setUseridAvailable(String str) {
        this.useridAvailable = str;
    }

    public void setUserpan(String str) {
        this.userpan = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserAvailablityDTO [emailAvailable=");
        sb.append(this.emailAvailable);
        sb.append(", mobileAvailable=");
        sb.append(this.mobileAvailable);
        sb.append(", userPanAvailable=");
        sb.append(this.userPanAvailable);
        sb.append(", agentPanAvailable=");
        sb.append(this.agentPanAvailable);
        sb.append(", certidAvailable=");
        sb.append(this.certidAvailable);
        sb.append(", useridAvailable=");
        sb.append(this.useridAvailable);
        sb.append(", disposableEmail=");
        sb.append(this.disposableEmail);
        sb.append(", monthlyBookingCount=");
        sb.append(this.monthlyBookingCount);
        sb.append(", userAadharKycStatus=");
        sb.append(this.userAadharKycStatus);
        sb.append(", mobile=");
        sb.append(this.mobile);
        sb.append(", email=");
        sb.append(this.email);
        sb.append(", userid=");
        sb.append(this.userid);
        sb.append(", isd=");
        sb.append(this.isd);
        sb.append(", userpan=");
        sb.append(this.userpan);
        sb.append(", agentpan=");
        sb.append(this.agentpan);
        sb.append(", certid=");
        return C0709Uj.j(sb, this.certid, "]");
    }
}
