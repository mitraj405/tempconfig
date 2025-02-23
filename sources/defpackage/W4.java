package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* renamed from: W4  reason: default package */
/* compiled from: BufferedChannel.kt */
public final class W4<E> extends Pv<W4<E>> {
    public final AtomicReferenceArray a = new AtomicReferenceArray(C1361r3.a * 2);

    /* renamed from: a  reason: collision with other field name */
    public final C1296o3<E> f3824a;

    public W4(long j, W4<E> w4, C1296o3<E> o3Var, int i) {
        super(j, w4, i);
        this.f3824a = o3Var;
    }

    public final int f() {
        return C1361r3.a;
    }

    public final void g(int i, CoroutineContext coroutineContext) {
        boolean z;
        C1296o3<E> o3Var;
        C0422zD zDVar;
        int i2 = C1361r3.a;
        if (i >= i2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i -= i2;
        }
        Object obj = this.a.get(i * 2);
        while (true) {
            Object k = k(i);
            boolean z2 = k instanceof C1256mD;
            o3Var = this.f3824a;
            if (z2 || (k instanceof C1278nD)) {
                if (z) {
                    zDVar = C1361r3.g;
                } else {
                    zDVar = C1361r3.h;
                }
                if (j(i, k, zDVar)) {
                    m(i, (Object) null);
                    l(i, !z);
                    if (z) {
                        C1177ig.c(o3Var);
                        Function1<E, Unit> function1 = o3Var.f5614a;
                        if (function1 != null) {
                            r1.h(function1, obj, coroutineContext);
                            return;
                        }
                        return;
                    }
                    return;
                }
            } else if (k == C1361r3.g || k == C1361r3.h) {
                m(i, (Object) null);
            } else if (!(k == C1361r3.d || k == C1361r3.c)) {
                if (k != C1361r3.f && k != C1361r3.f6940a && k != C1361r3.i) {
                    throw new IllegalStateException(("unexpected state: " + k).toString());
                }
                return;
            }
        }
        m(i, (Object) null);
        if (z) {
            C1177ig.c(o3Var);
            Function1<E, Unit> function12 = o3Var.f5614a;
            if (function12 != null) {
                r1.h(function12, obj, coroutineContext);
            }
        }
    }

    public final boolean j(int i, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.a;
        int i2 = (i * 2) + 1;
        while (!atomicReferenceArray.compareAndSet(i2, obj, obj2)) {
            if (atomicReferenceArray.get(i2) != obj) {
                return false;
            }
        }
        return true;
    }

    public final Object k(int i) {
        return this.a.get((i * 2) + 1);
    }

    public final void l(int i, boolean z) {
        if (z) {
            C1296o3<E> o3Var = this.f3824a;
            C1177ig.c(o3Var);
            o3Var.J((this.f3758a * ((long) C1361r3.a)) + ((long) i));
        }
        h();
    }

    public final void m(int i, Object obj) {
        this.a.lazySet(i * 2, obj);
    }

    public final void n(int i, C0422zD zDVar) {
        this.a.set((i * 2) + 1, zDVar);
    }
}
