package defpackage;

import cris.prs.webservices.dto.c;
import java.util.ArrayList;

/* renamed from: V1  reason: default package and case insensitive filesystem */
/* compiled from: AtasTrainEnqRespDTO */
public final class C0716V1 extends C0750Xx {
    private ArrayList<c> alreadyOptedVikalpList;
    private C0660R1 atasPnrBuffer;
    private C1475xA atasTrainList;

    public ArrayList<c> getAlreadyOptedVikalpList() {
        return this.alreadyOptedVikalpList;
    }

    public C0660R1 getAtasPnrBuffer() {
        return this.atasPnrBuffer;
    }

    public C1475xA getAtasTrainList() {
        return this.atasTrainList;
    }

    public void setAlreadyOptedVikalpList(ArrayList<c> arrayList) {
        this.alreadyOptedVikalpList = arrayList;
    }

    public void setAtasPnrBuffer(C0660R1 r1) {
        this.atasPnrBuffer = r1;
    }

    public void setAtasTrainList(C1475xA xAVar) {
        this.atasTrainList = xAVar;
    }

    public String toString() {
        return "AtasTrainEnqRespDTO [atasTrainList=" + this.atasTrainList + ", atasPnrBuffer=" + this.atasPnrBuffer + ", alreadyOptedVikalpList=" + this.alreadyOptedVikalpList + ", isErrorFlag()=" + isErrorFlag() + ", getErrorMsg()=" + getErrorMsg() + "]";
    }
}
