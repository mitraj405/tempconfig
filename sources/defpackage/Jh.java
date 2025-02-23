package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Jh  reason: default package */
/* compiled from: KycOtpDTO */
public final class Jh implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<String> errorList;
    private String errorMessage;
    private String kycCardId;
    private String kycOtpType;
    private String kycUserDOB;
    private String kycUserName;
    private String otp;
    private String serverId;
    private String status;
    private Boolean successFlag;
    private Date timeStamp;
    private String userId;

    public ArrayList<String> getErrorList() {
        return this.errorList;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getKycCardId() {
        return this.kycCardId;
    }

    public String getKycOtpType() {
        return this.kycOtpType;
    }

    public String getKycUserDOB() {
        return this.kycUserDOB;
    }

    public String getKycUserName() {
        return this.kycUserName;
    }

    public String getOtp() {
        return this.otp;
    }

    public String getServerId() {
        return this.serverId;
    }

    public String getStatus() {
        return this.status;
    }

    public Boolean getSuccessFlag() {
        return this.successFlag;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setErrorList(ArrayList<String> arrayList) {
        this.errorList = arrayList;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setKycCardId(String str) {
        this.kycCardId = str;
    }

    public void setKycOtpType(String str) {
        this.kycOtpType = str;
    }

    public void setKycUserDOB(String str) {
        this.kycUserDOB = str;
    }

    public void setKycUserName(String str) {
        this.kycUserName = str;
    }

    public void setOtp(String str) {
        this.otp = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSuccessFlag(Boolean bool) {
        this.successFlag = bool;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KycOtpDTO [userId=");
        sb.append(this.userId);
        sb.append(", otp=");
        sb.append(this.otp);
        sb.append(", kycOtpType=");
        sb.append(this.kycOtpType);
        sb.append(", kycCardId=");
        sb.append(this.kycCardId);
        sb.append(", kycUserName=");
        sb.append(this.kycUserName);
        sb.append(", kycUserDOB=");
        sb.append(this.kycUserDOB);
        sb.append(", errorList=");
        sb.append(this.errorList);
        sb.append(", serverId=");
        sb.append(this.serverId);
        sb.append(", timeStamp=");
        sb.append(this.timeStamp);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", successFlag=");
        sb.append(this.successFlag);
        sb.append(", errorMessage=");
        return C0709Uj.j(sb, this.errorMessage, "]");
    }
}
