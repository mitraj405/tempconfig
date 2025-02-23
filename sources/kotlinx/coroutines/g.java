package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* compiled from: DispatchedTask.kt */
public abstract class g<T> extends C1433uz {
    public int c;

    public g(int i) {
        this.c = i;
    }

    public abstract Continuation<T> c();

    public Throwable d(Object obj) {
        C0677S5 s5;
        if (obj instanceof C0677S5) {
            s5 = (C0677S5) obj;
        } else {
            s5 = null;
        }
        if (s5 != null) {
            return s5.f3789a;
        }
        return null;
    }

    public final void f(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                C1354qp.g(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            C1177ig.c(th);
            C1399t7.a(c().getContext(), new C1454w7("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public abstract Object h();

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007a, code lost:
        if (r4.r0() != false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0098, code lost:
        if (r4.r0() != false) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[Catch:{ all -> 0x005f, all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061 A[Catch:{ all -> 0x005f, all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076 A[SYNTHETIC, Splitter:B:29:0x0076] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r12 = this;
            vz r0 = r12.f6993a
            kotlin.coroutines.Continuation r1 = r12.c()     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            defpackage.C1177ig.d(r1, r2)     // Catch:{ all -> 0x009e }
            i9 r1 = (defpackage.C1173i9) r1     // Catch:{ all -> 0x009e }
            kotlin.coroutines.Continuation<T> r2 = r1.f5486a     // Catch:{ all -> 0x009e }
            java.lang.Object r1 = r1.b     // Catch:{ all -> 0x009e }
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch:{ all -> 0x009e }
            java.lang.Object r1 = defpackage.C0673Rz.b(r3, r1)     // Catch:{ all -> 0x009e }
            zD r4 = defpackage.C0673Rz.f3788a     // Catch:{ all -> 0x009e }
            r5 = 0
            if (r1 == r4) goto L_0x0023
            gB r4 = defpackage.C1320p7.c(r2, r3, r1)     // Catch:{ all -> 0x009e }
            goto L_0x0024
        L_0x0023:
            r4 = r5
        L_0x0024:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch:{ all -> 0x005f }
            java.lang.Object r7 = r12.h()     // Catch:{ all -> 0x005f }
            java.lang.Throwable r8 = r12.d(r7)     // Catch:{ all -> 0x005f }
            if (r8 != 0) goto L_0x0047
            int r9 = r12.c     // Catch:{ all -> 0x005f }
            r10 = 1
            if (r9 == r10) goto L_0x003c
            r11 = 2
            if (r9 != r11) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r10 = 0
        L_0x003c:
            if (r10 == 0) goto L_0x0047
            kotlinx.coroutines.Job$b r9 = kotlinx.coroutines.Job.b.a     // Catch:{ all -> 0x005f }
            kotlin.coroutines.CoroutineContext$b r6 = r6.b(r9)     // Catch:{ all -> 0x005f }
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6     // Catch:{ all -> 0x005f }
            goto L_0x0048
        L_0x0047:
            r6 = r5
        L_0x0048:
            if (r6 == 0) goto L_0x0061
            boolean r9 = r6.isActive()     // Catch:{ all -> 0x005f }
            if (r9 != 0) goto L_0x0061
            java.util.concurrent.CancellationException r6 = r6.e()     // Catch:{ all -> 0x005f }
            r12.a(r7, r6)     // Catch:{ all -> 0x005f }
            Tt$a r6 = defpackage.r1.n(r6)     // Catch:{ all -> 0x005f }
            r2.resumeWith(r6)     // Catch:{ all -> 0x005f }
            goto L_0x0072
        L_0x005f:
            r2 = move-exception
            goto L_0x0092
        L_0x0061:
            if (r8 == 0) goto L_0x006b
            Tt$a r6 = defpackage.r1.n(r8)     // Catch:{ all -> 0x005f }
            r2.resumeWith(r6)     // Catch:{ all -> 0x005f }
            goto L_0x0072
        L_0x006b:
            java.lang.Object r6 = r12.e(r7)     // Catch:{ all -> 0x005f }
            r2.resumeWith(r6)     // Catch:{ all -> 0x005f }
        L_0x0072:
            kotlin.Unit r2 = kotlin.Unit.a     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x007c
            boolean r2 = r4.r0()     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x007f
        L_0x007c:
            defpackage.C0673Rz.a(r3, r1)     // Catch:{ all -> 0x009e }
        L_0x007f:
            r0.a()     // Catch:{ all -> 0x0085 }
            kotlin.Unit r0 = kotlin.Unit.a     // Catch:{ all -> 0x0085 }
            goto L_0x008a
        L_0x0085:
            r0 = move-exception
            Tt$a r0 = defpackage.r1.n(r0)
        L_0x008a:
            java.lang.Throwable r0 = defpackage.C0698Tt.a(r0)
            r12.f(r5, r0)
            goto L_0x00b1
        L_0x0092:
            if (r4 == 0) goto L_0x009a
            boolean r4 = r4.r0()     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x009d
        L_0x009a:
            defpackage.C0673Rz.a(r3, r1)     // Catch:{ all -> 0x009e }
        L_0x009d:
            throw r2     // Catch:{ all -> 0x009e }
        L_0x009e:
            r1 = move-exception
            r0.a()     // Catch:{ all -> 0x00a5 }
            kotlin.Unit r0 = kotlin.Unit.a     // Catch:{ all -> 0x00a5 }
            goto L_0x00aa
        L_0x00a5:
            r0 = move-exception
            Tt$a r0 = defpackage.r1.n(r0)
        L_0x00aa:
            java.lang.Throwable r0 = defpackage.C0698Tt.a(r0)
            r12.f(r1, r0)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.g.run():void");
    }

    public <T> T e(Object obj) {
        return obj;
    }

    public void a(Object obj, CancellationException cancellationException) {
    }
}
