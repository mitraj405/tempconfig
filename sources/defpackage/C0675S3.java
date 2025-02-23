package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: S3  reason: default package and case insensitive filesystem */
/* compiled from: CanChargeEnqOutputDTO */
public final class C0675S3 implements Serializable {
    private static final long serialVersionUID = 1;
    private int amtDeducted;
    private int amtPending;
    private int amtRefunded;
    private String canSlab;
    private int cashPaid;
    private String enqFlag;
    private String enqMessage;
    private String informationMessage;
    private String pnrNumber;
    private long reasonIndex;
    private String reasonType;

    public int getAmtDeducted() {
        return this.amtDeducted;
    }

    public int getAmtPending() {
        return this.amtPending;
    }

    public int getAmtRefunded() {
        return this.amtRefunded;
    }

    public String getCanSlab() {
        return this.canSlab;
    }

    public int getCashPaid() {
        return this.cashPaid;
    }

    public String getEnqFlag() {
        return this.enqFlag;
    }

    public String getEnqMessage() {
        return this.enqMessage;
    }

    public String getInformationMessage() {
        return this.informationMessage;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public long getReasonIndex() {
        return this.reasonIndex;
    }

    public String getReasonType() {
        return this.reasonType;
    }

    public void setAmtDeducted(int i) {
        this.amtDeducted = i;
    }

    public void setAmtPending(int i) {
        this.amtPending = i;
    }

    public void setAmtRefunded(int i) {
        this.amtRefunded = i;
    }

    public void setCanSlab(String str) {
        this.canSlab = str;
    }

    public void setCashPaid(int i) {
        this.cashPaid = i;
    }

    public void setEnqFlag(String str) {
        this.enqFlag = str;
    }

    public void setEnqMessage(String str) {
        this.enqMessage = str;
    }

    public void setInformationMessage(String str) {
        this.informationMessage = str;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public void setReasonIndex(long j) {
        this.reasonIndex = j;
    }

    public void setReasonType(String str) {
        this.reasonType = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CanChargeEnqOutputDTO [pnrNumber=");
        sb.append(this.pnrNumber);
        sb.append(", reasonIndex=");
        sb.append(this.reasonIndex);
        sb.append(", cashPaid=");
        sb.append(this.cashPaid);
        sb.append(", amtDeducted=");
        sb.append(this.amtDeducted);
        sb.append(", amtRefunded=");
        sb.append(this.amtRefunded);
        sb.append(", amtPending=");
        sb.append(this.amtPending);
        sb.append(", enqFlag=");
        sb.append(this.enqFlag);
        sb.append(", canSlab=");
        sb.append(this.canSlab);
        sb.append(", reasonType=");
        sb.append(this.reasonType);
        sb.append(", informationMessage=");
        sb.append(this.informationMessage);
        sb.append(", enqMessage=");
        return C0709Uj.j(sb, this.enqMessage, "]");
    }
}
