package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Builders.common.kt */
public final class f<T> extends C1266mv<T> {
    public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(f.class, "_decision");
    private volatile int _decision;

    public f(Continuation continuation, CoroutineContext coroutineContext) {
        super(continuation, coroutineContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n0(java.lang.Object r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = a
            int r1 = r0.get(r4)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0019
            if (r1 != r3) goto L_0x000d
            goto L_0x0021
        L_0x000d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Already resumed"
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0019:
            r1 = 2
            boolean r0 = r0.compareAndSet(r4, r2, r1)
            if (r0 == 0) goto L_0x0000
            r2 = r3
        L_0x0021:
            if (r2 == 0) goto L_0x0024
            return
        L_0x0024:
            kotlin.coroutines.Continuation<T> r0 = r4.a
            kotlin.coroutines.Continuation r0 = defpackage.r1.B(r0)
            java.lang.Object r5 = defpackage.C1354qp.r0(r5)
            r1 = 0
            defpackage.r1.M(r0, r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.f.n0(java.lang.Object):void");
    }

    public final void v(Object obj) {
        n0(obj);
    }
}
