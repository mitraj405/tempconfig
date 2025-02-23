package defpackage;

import java.io.Serializable;

/* renamed from: eb  reason: default package and case insensitive filesystem */
/* compiled from: EwalletDTO */
public final class C1087eb implements Serializable {
    private static final long serialVersionUID = 1;
    private String balance;
    private String currentBalance;
    private String totalAmount;
    private String txnCharge;
    private String txnPwdFlag = "false";

    public String getBalance() {
        return this.balance;
    }

    public String getCurrentBalance() {
        return this.currentBalance;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public String getTxnCharge() {
        return this.txnCharge;
    }

    public String getTxnPwdFlag() {
        return this.txnPwdFlag;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public void setCurrentBalance(String str) {
        this.currentBalance = str;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public void setTxnCharge(String str) {
        this.txnCharge = str;
    }

    public void setTxnPwdFlag(String str) {
        this.txnPwdFlag = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EwalletDTO [txnCharge=");
        sb.append(this.txnCharge);
        sb.append(", currentBalance=");
        sb.append(this.currentBalance);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", balance=");
        sb.append(this.balance);
        sb.append(", txnPwdFlag=");
        return C0709Uj.j(sb, this.txnPwdFlag, "]");
    }
}
