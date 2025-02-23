package defpackage;

import defpackage.C0613Ns;
import java.util.Comparator;

/* renamed from: Ps  reason: default package and case insensitive filesystem */
/* compiled from: RefundTxnHistoryFragment */
public final class C0643Ps implements Comparator<C0613Ns.a> {
    public final int compare(Object obj, Object obj2) {
        return -((C0613Ns.a) obj).getJourneyDate().compareTo(((C0613Ns.a) obj2).getJourneyDate());
    }
}
