package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class StatusDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private E4 captchaDTO = null;
    private String error;
    private long errorIndex;
    private ArrayList<String> errorList;
    private String flag;
    private boolean infoFlag = false;
    private String message;
    private String messageInfo = "";
    private String payOnDelivery;
    private String pnrNumber;
    private Boolean regFlag;
    private String reqTxnId;
    private Integer resend_OTP_Left;
    private String reservationId;
    private ArrayList<String> rolesList;
    private String serverId;
    private String status;
    private String status1;
    private String status2;
    private Date timeStamp;
    private Boolean updateFlag;
    private String userId;

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

    public String getPayOnDelivery() {
        return this.payOnDelivery;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
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

    public String getReservationId() {
        return this.reservationId;
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

    public String getStatus1() {
        return this.status1;
    }

    public String getStatus2() {
        return this.status2;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public Boolean getUpdateFlag() {
        return this.updateFlag;
    }

    public String getUserId() {
        return this.userId;
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

    public void setPayOnDelivery(String str) {
        this.payOnDelivery = str;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
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

    public void setReservationId(String str) {
        this.reservationId = str;
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

    public void setStatus1(String str) {
        this.status1 = str;
    }

    public void setStatus2(String str) {
        this.status2 = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setUpdateFlag(Boolean bool) {
        this.updateFlag = bool;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "StatusDTO [userId=" + this.userId + ", status=" + this.status + ", error=" + this.error + ", updateFlag=" + this.updateFlag + ", regFlag=" + this.regFlag + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + ", infoFlag=" + this.infoFlag + ", messageInfo=" + this.messageInfo + ", captchaDTO=" + this.captchaDTO + ", payOnDelivery=" + this.payOnDelivery + ", errorIndex=" + this.errorIndex + ", resend_OTP_Left=" + this.resend_OTP_Left + ", errorList=" + this.errorList + "]";
    }
}
