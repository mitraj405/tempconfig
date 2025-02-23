package defpackage;

import java.io.Serializable;

/* renamed from: d2  reason: default package and case insensitive filesystem */
/* compiled from: AvailablityDTO */
public final class C1060d2 implements Serializable {
    private static final long serialVersionUID = 1;
    private String availablityDate = "";
    private String availablityStatus = "";
    private short availablityType = -1;
    private String currentBkgFlag = "";
    private Short delay;
    private String delayFlag;
    private Double probability = null;
    private String reason = "";
    private String reasonType = "";
    private short wlType = -1;

    public String getAvailablityDate() {
        return this.availablityDate;
    }

    public String getAvailablityStatus() {
        return this.availablityStatus;
    }

    public short getAvailablityType() {
        return this.availablityType;
    }

    public String getCurrentBkgFlag() {
        return this.currentBkgFlag;
    }

    public Short getDelay() {
        return this.delay;
    }

    public String getDelayFlag() {
        return this.delayFlag;
    }

    public Double getProbability() {
        return this.probability;
    }

    public String getReason() {
        return this.reason;
    }

    public String getReasonType() {
        return this.reasonType;
    }

    public short getWlType() {
        return this.wlType;
    }

    public void setAvailablityDate(String str) {
        this.availablityDate = str;
    }

    public void setAvailablityStatus(String str) {
        this.availablityStatus = str;
    }

    public void setAvailablityType(short s) {
        this.availablityType = s;
    }

    public void setCurrentBkgFlag(String str) {
        this.currentBkgFlag = str;
    }

    public void setDelay(Short sh) {
        this.delay = sh;
    }

    public void setDelayFlag(String str) {
        this.delayFlag = str;
    }

    public void setProbability(Double d) {
        this.probability = d;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setReasonType(String str) {
        this.reasonType = str;
    }

    public void setWlType(short s) {
        this.wlType = s;
    }

    public String toString() {
        return "AvailablityDTO [availablityDate=" + this.availablityDate + ", availablityStatus=" + this.availablityStatus + ", reasonType=" + this.reasonType + ", reason=" + this.reason + ", availablityType=" + this.availablityType + ", currentBkgFlag=" + this.currentBkgFlag + ", wlType=" + this.wlType + ", probability=" + this.probability + ", delayFlag=" + this.delayFlag + ", delay=" + this.delay + "]";
    }
}
