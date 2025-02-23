package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: O8  reason: default package */
/* compiled from: DepositStatusDTO */
public final class O8 implements Serializable {
    private static final long serialVersionUID = 1;
    private int amount;
    private double balance;
    private String message;
    private short status;
    private Date timestamp;
    private long txnId;
    private JB userDetail;

    public int getAmount() {
        return this.amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getMessage() {
        return this.message;
    }

    public short getStatus() {
        return this.status;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public long getTxnId() {
        return this.txnId;
    }

    public JB getUserDetail() {
        return this.userDetail;
    }

    public void setAmount(int i) {
        this.amount = i;
    }

    public void setBalance(double d) {
        this.balance = d;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(short s) {
        this.status = s;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public void setTxnId(long j) {
        this.txnId = j;
    }

    public void setUserDetail(JB jb) {
        this.userDetail = jb;
    }

    public String toString() {
        return "DepositStatusDTO [balance=" + this.balance + ", amount=" + this.amount + ", status=" + this.status + ", message=" + this.message + ", txnId=" + this.txnId + ", timestamp=" + this.timestamp + "]";
    }
}
