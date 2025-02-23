package defpackage;

import java.io.Serializable;
import java.util.Date;

/* renamed from: xs  reason: default package and case insensitive filesystem */
/* compiled from: RdsTransactionView */
public final class C1486xs implements Serializable {
    private static final long serialVersionUID = 1;
    private Double amount;
    private String bankCode;
    private String bankTxnNumber;
    private String bankTxnNumber2;
    private Double closingBalance;
    private String cmacIP = "0.0.0.0";
    private String debitType;
    private String description;
    private Long entityId;
    private String filerefId = "null";
    private Long masterUserId;
    private Double openingBalance;
    private String operatorId = "null";
    private Long rdsAccountId;
    private Long rdsTxnId;
    private Long refundId;
    private Double txnBalnceLimit;
    private Date txnDate;
    private String txnType;
    private Long userId;
    private String userName = "null";

    public Double getAmount() {
        return this.amount;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getBankTxnNumber() {
        return this.bankTxnNumber;
    }

    public String getBankTxnNumber2() {
        return this.bankTxnNumber2;
    }

    public Double getClosingBalance() {
        return this.closingBalance;
    }

    public String getCmacIP() {
        return this.cmacIP;
    }

    public String getDebitType() {
        return this.debitType;
    }

    public String getDescription() {
        return this.description;
    }

    public Long getEntityId() {
        return this.entityId;
    }

    public String getFilerefId() {
        return this.filerefId;
    }

    public Long getMasterUserId() {
        return this.masterUserId;
    }

    public Double getOpeningBalance() {
        return this.openingBalance;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public Long getRdsAccountId() {
        return this.rdsAccountId;
    }

    public Long getRdsTxnId() {
        return this.rdsTxnId;
    }

    public Long getRefundId() {
        return this.refundId;
    }

    public Double getTxnBalnceLimit() {
        return this.txnBalnceLimit;
    }

    public Date getTxnDate() {
        return this.txnDate;
    }

    public String getTxnType() {
        return this.txnType;
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setAmount(Double d) {
        this.amount = d;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public void setBankTxnNumber(String str) {
        this.bankTxnNumber = str;
    }

    public void setBankTxnNumber2(String str) {
        this.bankTxnNumber2 = str;
    }

    public void setClosingBalance(Double d) {
        this.closingBalance = d;
    }

    public void setCmacIP(String str) {
        this.cmacIP = str;
    }

    public void setDebitType(String str) {
        this.debitType = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setEntityId(Long l) {
        this.entityId = l;
    }

    public void setFilerefId(String str) {
        this.filerefId = str;
    }

    public void setMasterUserId(Long l) {
        this.masterUserId = l;
    }

    public void setOpeningBalance(Double d) {
        this.openingBalance = d;
    }

    public void setOperatorId(String str) {
        this.operatorId = str;
    }

    public void setRdsAccountId(Long l) {
        this.rdsAccountId = l;
    }

    public void setRdsTxnId(Long l) {
        this.rdsTxnId = l;
    }

    public void setRefundId(Long l) {
        this.refundId = l;
    }

    public void setTxnBalnceLimit(Double d) {
        this.txnBalnceLimit = d;
    }

    public void setTxnDate(Date date) {
        this.txnDate = date;
    }

    public void setTxnType(String str) {
        this.txnType = str;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "RdsTransactionView [rdsTxnId=" + this.rdsTxnId + ", rdsAccountId=" + this.rdsAccountId + ", entityId=" + this.entityId + ", txnType=" + this.txnType + ", userId=" + this.userId + ", amount=" + this.amount + ", openingBalance=" + this.openingBalance + ", closingBalance=" + this.closingBalance + ", txnDate=" + this.txnDate + ", refundId=" + this.refundId + ", description=" + this.description + ", debitType=" + this.debitType + ", userName=" + this.userName + ", operatorId=" + this.operatorId + ", filerefId=" + this.filerefId + ", cmacIP=" + this.cmacIP + ", masterUserId=" + this.masterUserId + ", bankCode=" + this.bankCode + ", bankTxnNumber=" + this.bankTxnNumber + ", bankTxnNumber2=" + this.bankTxnNumber2 + ", txnBalnceLimit=" + this.txnBalnceLimit + "]";
    }
}
