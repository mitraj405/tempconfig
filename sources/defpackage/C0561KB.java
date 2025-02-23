package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: KB  reason: default package and case insensitive filesystem */
/* compiled from: UserServiceStatusDTO */
public final class C0561KB implements Serializable {
    private static final long serialVersionUID = 1;
    private E4 captchaDTO = null;
    private String error;
    private long errorIndex;
    private ArrayList<String> errorList;
    private String flag;
    private boolean infoFlag = false;
    private String message;
    private String messageInfo = "";
    private Boolean regFlag;
    private String reqTxnId;
    private Integer resend_OTP_Left;
    private String responseTxnId;
    private ArrayList<String> rolesList;
    private String serverId;
    private String status;
    private Date timeStamp;
    private C1106fA tokenDTO;
    private Boolean updateFlag;
    private String userId;
    private C0538IB userProfiles;
    private String userrequestId;

    public E4 getCaptchaDTO() {
        return this.captchaDTO;
    }

    public String getError() {
        return this.error;
    }

    public long getErrorIndex() {
        return this.errorIndex;
    }

    public ArrayList<String> getErrorList() {
        return this.errorList;
    }

    public String getFlag() {
        return this.flag;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessageInfo() {
        return this.messageInfo;
    }

    public Boolean getRegFlag() {
        return this.regFlag;
    }

    public String getReqTxnId() {
        return this.reqTxnId;
    }

    public Integer getResend_OTP_Left() {
        return this.resend_OTP_Left;
    }

    public String getResponseTxnId() {
        return this.responseTxnId;
    }

    public ArrayList<String> getRolesList() {
        return this.rolesList;
    }

    public String getServerId() {
        return this.serverId;
    }

    public String getStatus() {
        return this.status;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public C1106fA getTokenDTO() {
        return this.tokenDTO;
    }

    public Boolean getUpdateFlag() {
        return this.updateFlag;
    }

    public String getUserId() {
        return this.userId;
    }

    public C0538IB getUserProfiles() {
        return this.userProfiles;
    }

    public String getUserrequestId() {
        return this.userrequestId;
    }

    public boolean isInfoFlag() {
        return this.infoFlag;
    }

    public void setCaptchaDTO(E4 e4) {
        this.captchaDTO = e4;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setErrorIndex(long j) {
        this.errorIndex = j;
    }

    public void setErrorList(ArrayList<String> arrayList) {
        this.errorList = arrayList;
    }

    public void setFlag(String str) {
        this.flag = str;
    }

    public void setInfoFlag(boolean z) {
        this.infoFlag = z;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMessageInfo(String str) {
        this.messageInfo = str;
    }

    public void setRegFlag(Boolean bool) {
        this.regFlag = bool;
    }

    public void setReqTxnId(String str) {
        this.reqTxnId = str;
    }

    public void setResend_OTP_Left(Integer num) {
        this.resend_OTP_Left = num;
    }

    public void setResponseTxnId(String str) {
        this.responseTxnId = str;
    }

    public void setRolesList(ArrayList<String> arrayList) {
        this.rolesList = arrayList;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setTokenDTO(C1106fA fAVar) {
        this.tokenDTO = fAVar;
    }

    public void setUpdateFlag(Boolean bool) {
        this.updateFlag = bool;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserProfiles(C0538IB ib) {
        this.userProfiles = ib;
    }

    public void setUserrequestId(String str) {
        this.userrequestId = str;
    }

    public String toString() {
        return "UserServiceStatusDTO [userId=" + this.userId + ", userrequestId=" + this.userrequestId + ", status=" + this.status + ", error=" + this.error + ", flag=" + this.flag + ", message=" + this.message + ", updateFlag=" + this.updateFlag + ", regFlag=" + this.regFlag + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + ", infoFlag=" + this.infoFlag + ", messageInfo=" + this.messageInfo + ", captchaDTO=" + this.captchaDTO + ", errorIndex=" + this.errorIndex + ", resend_OTP_Left=" + this.resend_OTP_Left + ", reqTxnId=" + this.reqTxnId + ", rolesList=" + this.rolesList + ", errorList=" + this.errorList + ", responseTxnId=" + this.responseTxnId + ", userProfiles=" + this.userProfiles + ", tokenDTO=" + this.tokenDTO + "]";
    }
}
