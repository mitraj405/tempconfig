package defpackage;

import java.io.Serializable;
import java.util.Date;

/* renamed from: db  reason: default package and case insensitive filesystem */
/* compiled from: EwalletAccountDetailsView */
public final class C1066db implements Serializable {
    private static final long serialVersionUID = 5763893519725827799L;
    private String activeStatus;
    private Double amount;
    private Integer bankId;
    private String bankName;
    private Double cgst_charge;
    private Date deactivateDate;
    private Double eWalletClosingBalance;
    private Double eWalletRegdAmount;
    private Date eWalletRegdDate;
    private Long eWalletRegdTxnId;
    private Double igst_charge;
    private String offlineReason;
    private String paymentMode;
    private Double sgst_charge;
    private Double total_gst;
    private Double ugst_charge;
    private String userFullName;
    private String userId;

    public String getActiveStatus() {
        return this.activeStatus;
    }

    public Double getAmount() {
        return this.amount;
    }

    public int getBankId() {
        return this.bankId.intValue();
    }

    public String getBankName() {
        return this.bankName;
    }

    public Double getCgst_charge() {
        return this.cgst_charge;
    }

    public Date getDeactivateDate() {
        return this.deactivateDate;
    }

    public Double getIgst_charge() {
        return this.igst_charge;
    }

    public String getOfflineReason() {
        return this.offlineReason;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public Double getSgst_charge() {
        return this.sgst_charge;
    }

    public Double getTotal_gst() {
        return this.total_gst;
    }

    public Double getUgst_charge() {
        return this.ugst_charge;
    }

    public String getUserFullName() {
        return this.userFullName;
    }

    public String getUserId() {
        return this.userId;
    }

    public Double geteWalletClosingBalance() {
        return this.eWalletClosingBalance;
    }

    public Double geteWalletRegdAmount() {
        return this.eWalletRegdAmount;
    }

    public Date geteWalletRegdDate() {
        return this.eWalletRegdDate;
    }

    public Long geteWalletRegdTxnId() {
        return this.eWalletRegdTxnId;
    }

    public void setActiveStatus(String str) {
        this.activeStatus = str;
    }

    public void setAmount(Double d) {
        this.amount = d;
    }

    public void setBankId(int i) {
        this.bankId = Integer.valueOf(i);
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setCgst_charge(Double d) {
        this.cgst_charge = d;
    }

    public void setDeactivateDate(Date date) {
        this.deactivateDate = date;
    }

    public void setIgst_charge(Double d) {
        this.igst_charge = d;
    }

    public void setOfflineReason(String str) {
        this.offlineReason = str;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public void setSgst_charge(Double d) {
        this.sgst_charge = d;
    }

    public void setTotal_gst(Double d) {
        this.total_gst = d;
    }

    public void setUgst_charge(Double d) {
        this.ugst_charge = d;
    }

    public void setUserFullName(String str) {
        this.userFullName = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void seteWalletClosingBalance(Double d) {
        this.eWalletClosingBalance = d;
    }

    public void seteWalletRegdAmount(Double d) {
        this.eWalletRegdAmount = d;
    }

    public void seteWalletRegdDate(Date date) {
        this.eWalletRegdDate = date;
    }

    public void seteWalletRegdTxnId(Long l) {
        this.eWalletRegdTxnId = l;
    }
}
