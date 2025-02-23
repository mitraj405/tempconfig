package defpackage;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.j;

/* renamed from: s8  reason: default package and case insensitive filesystem */
/* compiled from: Dispatcher.kt */
public final class C1382s8 extends j implements Executor {
    public static final CoroutineDispatcher a;

    /* renamed from: a  reason: collision with other field name */
    public static final C1382s8 f6951a = new C1382s8();

    /* JADX WARNING: type inference failed for: r2v3, types: [bi] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            s8 r0 = new s8
            r0.<init>()
            f6951a = r0
            jB r0 = defpackage.C1193jB.a
            int r1 = defpackage.C1121fz.a
            r2 = 64
            if (r2 >= r1) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r1 = r2
        L_0x0011:
            r2 = 12
            java.lang.String r3 = "kotlinx.coroutines.io.parallelism"
            r4 = 0
            int r1 = defpackage.C1354qp.B0(r3, r1, r4, r4, r2)
            r0.getClass()
            defpackage.C1354qp.u(r1)
            int r2 = defpackage.C1524zz.b
            if (r1 < r2) goto L_0x0025
            goto L_0x002e
        L_0x0025:
            defpackage.C1354qp.u(r1)
            bi r2 = new bi
            r2.<init>(r0, r1)
            r0 = r2
        L_0x002e:
            a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1382s8.<clinit>():void");
    }

    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public final void execute(Runnable runnable) {
        h(C1440va.a, runnable);
    }

    public final void h(CoroutineContext coroutineContext, Runnable runnable) {
        a.h(coroutineContext, runnable);
    }

    public final String toString() {
        return "Dispatchers.IO";
    }
}
