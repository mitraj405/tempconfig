package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: GA  reason: default package and case insensitive filesystem */
/* compiled from: TransactionDTO */
public final class C0514GA implements Serializable {
    private static final long serialVersionUID = 1;
    private String agentUserId;
    private String mobileNumber;
    private Integer noOfTicket;
    private String paymentType;
    private String refundStatusRes;
    private String reservationId;
    private String reservationMode;
    private String reservationStatus;
    private Double totalAmntRes;
    private String transactionDate;
    private String userId;
    private String userRetryChoice;

    public String getAgentUserId() {
        return this.agentUserId;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public Integer getNoOfTicket() {
        return this.noOfTicket;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public String getRefundStatusRes() {
        return this.refundStatusRes;
    }

    public String getReservationId() {
        return this.reservationId;
    }

    public String getReservationMode() {
        return this.reservationMode;
    }

    public String getReservationStatus() {
        return this.reservationStatus;
    }

    public Double getTotalAmntRes() {
        return this.totalAmntRes;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserRetryChoice() {
        return this.userRetryChoice;
    }

    public void setAgentUserId(String str) {
        this.agentUserId = str;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public void setNoOfTicket(Integer num) {
        this.noOfTicket = num;
    }

    public void setPaymentType(String str) {
        this.paymentType = str;
    }

    public void setRefundStatusRes(String str) {
        this.refundStatusRes = str;
    }

    public void setReservationId(String str) {
        this.reservationId = str;
    }

    public void setReservationMode(String str) {
        this.reservationMode = str;
    }

    public void setReservationStatus(String str) {
        this.reservationStatus = str;
    }

    public void setTotalAmntRes(Double d) {
        this.totalAmntRes = d;
    }

    public void setTransactionDate(String str) {
        this.transactionDate = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserRetryChoice(String str) {
        this.userRetryChoice = str;
    }
}
