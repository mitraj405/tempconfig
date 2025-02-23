package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: kp  reason: default package and case insensitive filesystem */
/* compiled from: PaymentDetailDTO */
public final class C1225kp implements Serializable {
    private static final long serialVersionUID = 1;
    private double amount;
    private String apiName;
    private int bankId;
    private E4 captchaDto;
    private String errorMsg;
    private C0824ch juspayLoadDTO;
    private long loyaltyNum;
    private ArrayList<Do> paramList;
    private String paymentId;
    private String paymentType;
    private double remainingBalance;
    private String serverId;
    private Date timeStamp;
    private long transationId;
    private Date txnDate;
    private int txnStatus;
    private int txnType;
    private int upiModeOpted;
    private boolean withoutOTP;

    public double getAmount() {
        return this.amount;
    }

    public String getApiName() {
        return this.apiName;
    }

    public int getBankId() {
        return this.bankId;
    }

    public E4 getCaptchaDto() {
        return this.captchaDto;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public C0824ch getJuspayLoadDTO() {
        return this.juspayLoadDTO;
    }

    public long getLoyaltyNum() {
        return this.loyaltyNum;
    }

    public ArrayList<Do> getParamList() {
        return this.paramList;
    }

    public String getPaymentId() {
        return this.paymentId;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public double getRemainingBalance() {
        return this.remainingBalance;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public long getTransationId() {
        return this.transationId;
    }

    public Date getTxnDate() {
        return this.txnDate;
    }

    public int getTxnStatus() {
        return this.txnStatus;
    }

    public int getTxnType() {
        return this.txnType;
    }

    public int getUpiModeOpted() {
        return this.upiModeOpted;
    }

    public boolean isWithoutOTP() {
        return this.withoutOTP;
    }

    public void setAmount(double d) {
        this.amount = d;
    }

    public void setApiName(String str) {
        this.apiName = str;
    }

    public void setBankId(int i) {
        this.bankId = i;
    }

    public void setCaptchaDto(E4 e4) {
        this.captchaDto = e4;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setJuspayLoadDTO(C0824ch chVar) {
        this.juspayLoadDTO = chVar;
    }

    public void setLoyaltyNum(long j) {
        this.loyaltyNum = j;
    }

    public void setParamList(ArrayList<Do> arrayList) {
        this.paramList = arrayList;
    }

    public void setPaymentId(String str) {
        this.paymentId = str;
    }

    public void setPaymentType(String str) {
        this.paymentType = str;
    }

    public void setRemainingBalance(double d) {
        this.remainingBalance = d;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setTransationId(long j) {
        this.transationId = j;
    }

    public void setTxnDate(Date date) {
        this.txnDate = date;
    }

    public void setTxnStatus(int i) {
        this.txnStatus = i;
    }

    public void setTxnType(int i) {
        this.txnType = i;
    }

    public void setUpiModeOpted(int i) {
        this.upiModeOpted = i;
    }

    public void setWithoutOTP(boolean z) {
        this.withoutOTP = z;
    }

    public String toString() {
        return "PaymentDetailDTO [transationId=" + this.transationId + ", bankId=" + this.bankId + ", txnType=" + this.txnType + ", txnStatus=" + this.txnStatus + ", txnDate=" + this.txnDate + ", errorMsg=" + this.errorMsg + ", amount=" + this.amount + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + ", apiName=" + this.apiName + ", captchaDto=" + this.captchaDto + ", upiModeOpted=" + this.upiModeOpted + ", remainingBalance=" + this.remainingBalance + ", loyaltyNum=" + this.loyaltyNum + ", juspayLoadDTO=" + this.juspayLoadDTO + ", withoutOTP=" + this.withoutOTP + ", paymentId=" + this.paymentId + ", paymentType=" + this.paymentType + ", paramList=" + this.paramList + "]";
    }
}
