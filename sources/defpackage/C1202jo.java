package defpackage;

import defpackage.C1224ko;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

/* renamed from: jo  reason: default package and case insensitive filesystem */
/* compiled from: OperatorObserveOn */
public final class C1202jo implements Producer {
    public final /* synthetic */ C1224ko.a a;

    public C1202jo(C1224ko.a aVar) {
        this.a = aVar;
    }

    public final void request(long j) {
        long j2;
        long j3;
        if (j > 0) {
            C1224ko.a aVar = this.a;
            AtomicLong atomicLong = aVar.f5554a;
            do {
                j2 = atomicLong.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!atomicLong.compareAndSet(j2, j3));
            aVar.c();
        }
    }
}
