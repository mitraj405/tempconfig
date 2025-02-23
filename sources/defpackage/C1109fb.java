package defpackage;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: fb  reason: default package and case insensitive filesystem */
/* compiled from: EwalletDepositHistory */
public final class C1109fb {
    private ArrayList<C1465ws> depositList;
    private Boolean nextFlag;

    public ArrayList<C1465ws> getDepositList() {
        return this.depositList;
    }

    public Boolean getNextFlag() {
        return this.nextFlag;
    }

    public void setDepositList(ArrayList<C1465ws> arrayList) {
        this.depositList = arrayList;
    }

    public void setNextFlag(Boolean bool) {
        this.nextFlag = bool;
    }
}
