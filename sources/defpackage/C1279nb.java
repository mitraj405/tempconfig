package defpackage;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: nb  reason: default package and case insensitive filesystem */
/* compiled from: EwalletStatementData */
public final class C1279nb {
    private C1066db accountDetail;
    private ArrayList<C1486xs> transactionList;

    public C1066db getAccountDetail() {
        return this.accountDetail;
    }

    public ArrayList<C1486xs> getTransactionList() {
        return this.transactionList;
    }

    public void setAccountDetail(C1066db dbVar) {
        this.accountDetail = dbVar;
    }

    public void setTransactionList(ArrayList<C1486xs> arrayList) {
        this.transactionList = arrayList;
    }
}
