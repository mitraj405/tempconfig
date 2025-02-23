package defpackage;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* renamed from: gB  reason: default package and case insensitive filesystem */
/* compiled from: CoroutineContext.kt */
public final class C1129gB<T> extends C1266mv<T> {
    public final ThreadLocal<Pair<CoroutineContext, Object>> a;
    private volatile boolean threadLocalIsSet;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1129gB(kotlin.coroutines.Continuation r3, kotlin.coroutines.CoroutineContext r4) {
        /*
            r2 = this;
            hB r0 = defpackage.C1151hB.a
            kotlin.coroutines.CoroutineContext$b r1 = r4.b(r0)
            if (r1 != 0) goto L_0x000d
            kotlin.coroutines.CoroutineContext r0 = r4.j(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r4
        L_0x000e:
            r2.<init>(r3, r0)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.a = r0
            kotlin.coroutines.CoroutineContext r3 = r3.getContext()
            i7$a r0 = defpackage.C1171i7.a.a
            kotlin.coroutines.CoroutineContext$b r3 = r3.b(r0)
            boolean r3 = r3 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r3 != 0) goto L_0x0031
            r3 = 0
            java.lang.Object r3 = defpackage.C0673Rz.b(r4, r3)
            defpackage.C0673Rz.a(r4, r3)
            r2.s0(r4, r3)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1129gB.<init>(kotlin.coroutines.Continuation, kotlin.coroutines.CoroutineContext):void");
    }

    public final void n0(Object obj) {
        if (this.threadLocalIsSet) {
            Pair pair = this.a.get();
            if (pair != null) {
                C0673Rz.a((CoroutineContext) pair.a, pair.b);
            }
            this.a.remove();
        }
        Object r0 = C1354qp.r0(obj);
        Continuation<T> continuation = this.a;
        CoroutineContext context = continuation.getContext();
        C1129gB<?> gBVar = null;
        Object b = C0673Rz.b(context, gBVar);
        if (b != C0673Rz.f3788a) {
            gBVar = C1320p7.c(continuation, context, b);
        }
        try {
            this.a.resumeWith(r0);
            Unit unit = Unit.a;
        } finally {
            if (gBVar == null || gBVar.r0()) {
                C0673Rz.a(context, b);
            }
        }
    }

    public final boolean r0() {
        boolean z;
        if (!this.threadLocalIsSet || this.a.get() != null) {
            z = false;
        } else {
            z = true;
        }
        this.a.remove();
        return !z;
    }

    public final void s0(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.a.set(new Pair(coroutineContext, obj));
    }
}
