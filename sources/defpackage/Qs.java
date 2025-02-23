package defpackage;

import defpackage.C0613Ns;
import java.util.Comparator;

/* renamed from: Qs  reason: default package */
/* compiled from: RefundTxnHistoryFragment */
public final class Qs implements Comparator<C0613Ns.a> {
    public final int compare(Object obj, Object obj2) {
        return -((C0613Ns.a) obj).getTransactionDate().compareTo(((C0613Ns.a) obj2).getTransactionDate());
    }
}
