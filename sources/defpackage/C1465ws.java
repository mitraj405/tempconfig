package defpackage;

import java.io.Serializable;
import java.util.Date;

/* renamed from: ws  reason: default package and case insensitive filesystem */
/* compiled from: RdsDepositView */
public final class C1465ws implements Serializable {
    private static final long serialVersionUID = 1;
    private Double amount;
    private String bankDepRefNo;
    private String bankDepositRealisationDate;
    private String depIntrfaceName;
    private Date depositDate;
    private Date depositdate;
    private String paymentBankName;
    private String paymentOption;
    private String rechargeStatus;
    private String refundStatus;
    private Integer rstatus;
    private String transactionStatus;
    private Long txnId;
    private Long txnid;

    public Double getAmount() {
        return this.amount;
    }

    public String getBankDepRefNo() {
        return this.bankDepRefNo;
    }

    public String getBankDepositRealisationDate() {
        return this.bankDepositRealisationDate;
    }

    public String getDepIntrfaceName() {
        return this.depIntrfaceName;
    }

    public Date getDepositDate() {
        return this.depositDate;
    }

    public Date getDepositdate() {
        return this.depositdate;
    }

    public String getPaymentBankName() {
        return this.paymentBankName;
    }

    public String getPaymentOption() {
        return this.paymentOption;
    }

    public String getRechargeStatus() {
        return this.rechargeStatus;
    }

    public String getRefundStatus() {
        return this.refundStatus;
    }

    public Integer getRstatus() {
        return this.rstatus;
    }

    public String getTransactionStatus() {
        return this.transactionStatus;
    }

    public Long getTxnId() {
        return this.txnId;
    }

    public Long getTxnid() {
        return this.txnid;
    }

    public void setAmount(Double d) {
        this.amount = d;
    }

    public void setBankDepRefNo(String str) {
        this.bankDepRefNo = str;
    }

    public void setBankDepositRealisationDate(String str) {
        this.bankDepositRealisationDate = str;
    }

    public void setDepIntrfaceName(String str) {
        this.depIntrfaceName = str;
    }

    public void setDepositDate(Date date) {
        this.depositDate = date;
    }

    public void setDepositdate(Date date) {
        this.depositdate = date;
    }

    public void setPaymentBankName(String str) {
        this.paymentBankName = str;
    }

    public void setPaymentOption(String str) {
        this.paymentOption = str;
    }

    public void setRechargeStatus(String str) {
        this.rechargeStatus = str;
    }

    public void setRefundStatus(String str) {
        this.refundStatus = str;
    }

    public void setRstatus(Integer num) {
        this.rstatus = num;
    }

    public void setTransactionStatus(String str) {
        this.transactionStatus = str;
    }

    public void setTxnId(Long l) {
        this.txnId = l;
    }

    public void setTxnid(Long l) {
        this.txnid = l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RdsDepositView [txnId=");
        sb.append(this.txnId);
        sb.append(", paymentOption=");
        sb.append(this.paymentOption);
        sb.append(", rechargeStatus=");
        sb.append(this.rechargeStatus);
        sb.append(", depositDate=");
        sb.append(this.depositDate);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", transactionStatus=");
        sb.append(this.transactionStatus);
        sb.append(", refundStatus=");
        sb.append(this.refundStatus);
        sb.append(", txnid=");
        sb.append(this.txnid);
        sb.append(", rstatus=");
        sb.append(this.rstatus);
        sb.append(", depositdate=");
        sb.append(this.depositdate);
        sb.append(", bankDepRefNo=");
        sb.append(this.bankDepRefNo);
        sb.append(", paymentBankName=");
        sb.append(this.paymentBankName);
        sb.append(", depIntrfaceName=");
        sb.append(this.depIntrfaceName);
        sb.append(", bankDepositRealisationDate=");
        return C0709Uj.j(sb, this.bankDepositRealisationDate, "]");
    }
}
