package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Y2  reason: default package */
/* compiled from: BoardingPointChangeDTO */
public final class Y2 implements Serializable {
    private static final long serialVersionUID = 1;
    private String error;
    private Date newBoardingDate;
    private String newBoardingPoint;
    private String oldBoardingPoint;
    private String pnr;
    private String serverId;
    private String status;
    private Boolean success;
    private Date timeStamp;

    public String getError() {
        return this.error;
    }

    public Date getNewBoardingDate() {
        return this.newBoardingDate;
    }

    public String getNewBoardingPoint() {
        return this.newBoardingPoint;
    }

    public String getOldBoardingPoint() {
        return this.oldBoardingPoint;
    }

    public String getPnr() {
        return this.pnr;
    }

    public String getServerId() {
        return this.serverId;
    }

    public String getStatus() {
        return this.status;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setNewBoardingDate(Date date) {
        this.newBoardingDate = date;
    }

    public void setNewBoardingPoint(String str) {
        this.newBoardingPoint = str;
    }

    public void setOldBoardingPoint(String str) {
        this.oldBoardingPoint = str;
    }

    public void setPnr(String str) {
        this.pnr = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public String toString() {
        return "BoardingPointChangeDTO [pnr=" + this.pnr + ", status=" + this.status + ", error=" + this.error + ", success=" + this.success + ", newBoardingPoint=" + this.newBoardingPoint + ", OldBoardingPoint=" + this.oldBoardingPoint + ", newBoardingDate=" + this.newBoardingDate + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + "]";
    }
}
