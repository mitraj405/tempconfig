package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.c;
import kotlinx.coroutines.k;

/* renamed from: Z4  reason: default package */
/* compiled from: JobSupport.kt */
public final class Z4 extends Lg {
    public final c<?> a;

    public Z4(c<?> cVar) {
        this.a = cVar;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        l((Throwable) obj);
        return Unit.a;
    }

    public final void l(Throwable th) {
        boolean z;
        k m = m();
        c<?> cVar = this.a;
        Throwable q = cVar.q(m);
        boolean z2 = false;
        if (cVar.v()) {
            Continuation<T> continuation = cVar.f5562a;
            C1177ig.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            C1173i9 i9Var = (C1173i9) continuation;
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1173i9.a;
                Object obj = atomicReferenceFieldUpdater.get(i9Var);
                C0422zD zDVar = r1.e;
                boolean z3 = true;
                if (C1177ig.a(obj, zDVar)) {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(i9Var, zDVar, q)) {
                            if (atomicReferenceFieldUpdater.get(i9Var) != zDVar) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        break;
                    }
                } else if (obj instanceof Throwable) {
                    break;
                } else {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(i9Var, obj, (Object) null)) {
                            if (atomicReferenceFieldUpdater.get(i9Var) != obj) {
                                z3 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z3) {
                        break;
                    }
                }
            }
            z2 = true;
        }
        if (!z2) {
            cVar.p(q);
            if (!cVar.v()) {
                cVar.n();
            }
        }
    }
}
