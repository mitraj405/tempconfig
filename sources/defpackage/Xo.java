package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Xo  reason: default package */
/* compiled from: PasswordDTO */
public final class Xo implements Serializable {
    private static final long serialVersionUID = 1;
    private String captcha;
    private E4 captchaDto;
    private String confPassword;
    private ArrayList<String> errorList;
    private String ip;
    private Integer loginCounterRequested;
    private String newPassword;
    private boolean nlpFlagToStopLoop;
    private Boolean nonOTPcaptchaStatus;
    private String oldPassword;
    private Boolean otpLogin;
    private String otpType;
    private String seqAns;
    private String seqQuestion;
    private String seqType;
    private String serverId;
    private Integer source = 4;
    private String status;
    private Date timeStamp;
    private boolean twoPhaseAuthRequired;
    private String txnId;
    private Boolean updateFlag;
    private String userId;

    public String getCaptcha() {
        return this.captcha;
    }

    public E4 getCaptchaDto() {
        return this.captchaDto;
    }

    public String getConfPassword() {
        return this.confPassword;
    }

    public ArrayList<String> getErrorList() {
        return this.errorList;
    }

    public String getIp() {
        return this.ip;
    }

    public Integer getLoginCounterRequested() {
        return this.loginCounterRequested;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public Boolean getNonOTPcaptchaStatus() {
        return this.nonOTPcaptchaStatus;
    }

    public String getOldPassword() {
        return this.oldPassword;
    }

    public Boolean getOtpLogin() {
        return this.otpLogin;
    }

    public String getOtpType() {
        return this.otpType;
    }

    public String getSeqAns() {
        return this.seqAns;
    }

    public String getSeqQuestion() {
        return this.seqQuestion;
    }

    public String getSeqType() {
        return this.seqType;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Integer getSource() {
        return this.source;
    }

    public String getStatus() {
        return this.status;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public Boolean getUpdateFlag() {
        return this.updateFlag;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isNlpFlagToStopLoop() {
        return this.nlpFlagToStopLoop;
    }

    public boolean isTwoPhaseAuthRequired() {
        return this.twoPhaseAuthRequired;
    }

    public void setCaptcha(String str) {
        this.captcha = str;
    }

    public void setCaptchaDto(E4 e4) {
        this.captchaDto = e4;
    }

    public void setConfPassword(String str) {
        this.confPassword = str;
    }

    public void setErrorList(ArrayList<String> arrayList) {
        this.errorList = arrayList;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setLoginCounterRequested(Integer num) {
        this.loginCounterRequested = num;
    }

    public void setNewPassword(String str) {
        this.newPassword = str;
    }

    public void setNlpFlagToStopLoop(boolean z) {
        this.nlpFlagToStopLoop = z;
    }

    public void setNonOTPcaptchaStatus(Boolean bool) {
        this.nonOTPcaptchaStatus = bool;
    }

    public void setOldPassword(String str) {
        this.oldPassword = str;
    }

    public void setOtpLogin(Boolean bool) {
        this.otpLogin = bool;
    }

    public void setOtpType(String str) {
        this.otpType = str;
    }

    public void setSeqAns(String str) {
        this.seqAns = str;
    }

    public void setSeqQuestion(String str) {
        this.seqQuestion = str;
    }

    public void setSeqType(String str) {
        this.seqType = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setSource(Integer num) {
        this.source = num;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setTwoPhaseAuthRequired(boolean z) {
        this.twoPhaseAuthRequired = z;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public void setUpdateFlag(Boolean bool) {
        this.updateFlag = bool;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PasswordDTO [txnId=");
        sb.append(this.txnId);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", seqQuestion=");
        sb.append(this.seqQuestion);
        sb.append(", seqType=");
        sb.append(this.seqType);
        sb.append(", seqAns=");
        sb.append(this.seqAns);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", updateFlag=");
        sb.append(this.updateFlag);
        sb.append(", source=");
        sb.append(this.source);
        sb.append(", captcha=");
        return C0709Uj.j(sb, this.captcha, "]");
    }
}
