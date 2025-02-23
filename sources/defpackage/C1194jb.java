package defpackage;

import java.io.Serializable;
import java.util.Date;

/* renamed from: jb  reason: default package and case insensitive filesystem */
/* compiled from: EwalletRefundView */
public final class C1194jb implements Serializable {
    private static final long serialVersionUID = 1;
    private Double amount;
    private String payStatus;
    private String reason;
    private Date refundDate;
    private String refundStatus;
    private Long txnId;

    public Double getAmount() {
        return this.amount;
    }

    public String getPayStatus() {
        return this.payStatus;
    }

    public String getReason() {
        return this.reason;
    }

    public Date getRefundDate() {
        return this.refundDate;
    }

    public String getRefundStatus() {
        return this.refundStatus;
    }

    public Long getTxnId() {
        return this.txnId;
    }

    public void setAmount(Double d) {
        this.amount = d;
    }

    public void setPayStatus(String str) {
        this.payStatus = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setRefundDate(Date date) {
        this.refundDate = date;
    }

    public void setRefundStatus(String str) {
        this.refundStatus = str;
    }

    public void setTxnId(Long l) {
        this.txnId = l;
    }

    public String toString() {
        return "EwalletRefundView [txnId=" + this.txnId + ", amount=" + this.amount + ", payStatus=" + this.payStatus + ", reason=" + this.reason + ", refundStatus=" + this.refundStatus + ", refundDate=" + this.refundDate + "]";
    }
}
