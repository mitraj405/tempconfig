package defpackage;

import java.util.Comparator;

/* renamed from: oq  reason: default package and case insensitive filesystem */
/* compiled from: PreviewScalingStrategy */
public final class C1308oq implements Comparator<C1205jx> {
    public final /* synthetic */ C1205jx a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1333pq f5652a;

    public C1308oq(C1333pq pqVar, C1205jx jxVar) {
        this.f5652a = pqVar;
        this.a = jxVar;
    }

    public final int compare(Object obj, Object obj2) {
        C1333pq pqVar = this.f5652a;
        C1205jx jxVar = this.a;
        return Float.compare(pqVar.a((C1205jx) obj2, jxVar), pqVar.a((C1205jx) obj, jxVar));
    }
}
