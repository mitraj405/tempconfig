package defpackage;

import java.io.Serializable;

/* renamed from: Ez  reason: default package and case insensitive filesystem */
/* compiled from: TdrReasonDTO */
public final class C0502Ez implements Serializable {
    private static final long serialVersionUID = 2874502688657773414L;
    private int eftFlag = 0;
    private int reasonIndex = 0;
    private String tdrReason = null;

    public int getEftFlag() {
        return this.eftFlag;
    }

    public int getReasonIndex() {
        return this.reasonIndex;
    }

    public String getTdrReason() {
        return this.tdrReason;
    }

    public void setEftFlag(int i) {
        this.eftFlag = i;
    }

    public void setReasonIndex(int i) {
        this.reasonIndex = i;
    }

    public void setTdrReason(String str) {
        this.tdrReason = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TdrReasonDTO [reasonIndex=");
        sb.append(this.reasonIndex);
        sb.append(", tdrReason=");
        sb.append(this.tdrReason);
        sb.append(", eftFlag=");
        return lf.k(sb, this.eftFlag, "]");
    }
}
