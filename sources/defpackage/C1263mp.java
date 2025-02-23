package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: mp  reason: default package and case insensitive filesystem */
/* compiled from: PaymentReponseNonBkg */
public final class C1263mp implements Serializable {
    private static final long serialVersionUID = 1;
    private int entityCodeValue;
    private String errorMessage;
    private String serverId;
    private Date timeStamp;
    private long transationId;
    private int txnStatus;

    public int getEntityCodeValue() {
        return this.entityCodeValue;
    }

    public String getErrorMessage() {
        return this.errorMessage;
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

    public int getTxnStatus() {
        return this.txnStatus;
    }

    public void setEntityCodeValue(int i) {
        this.entityCodeValue = i;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
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

    public void setTxnStatus(int i) {
        this.txnStatus = i;
    }

    public String toString() {
        return "PaymentReponseNonBkg [transationId=" + this.transationId + ", entityCodeValue=" + this.entityCodeValue + ", txnStatus=" + this.txnStatus + ", errorMessage=" + this.errorMessage + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + "]";
    }
}
