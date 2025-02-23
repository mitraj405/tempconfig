package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.k;

/* renamed from: Ng  reason: default package and case insensitive filesystem */
/* compiled from: JobSupport.kt */
public abstract class C0610Ng extends U5 implements C1276n9, C0449Af {
    public k a;

    public final Rm b() {
        return null;
    }

    public final void h() {
        boolean z;
        C1302oi oiVar;
        boolean z2;
        k m = m();
        do {
            Object S = m.S();
            z = false;
            if (S instanceof C0610Ng) {
                if (S == this) {
                    C1402ta taVar = C1354qp.b;
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k.a;
                        if (!atomicReferenceFieldUpdater.compareAndSet(m, S, taVar)) {
                            if (atomicReferenceFieldUpdater.get(m) != S) {
                                continue;
                                break;
                            }
                        } else {
                            z = true;
                            continue;
                            break;
                        }
                    }
                } else {
                    return;
                }
            } else if ((S instanceof C0449Af) && ((C0449Af) S).b() != null) {
                do {
                    Object g = g();
                    if (!(g instanceof C1374rt)) {
                        if (g != this) {
                            C1177ig.d(g, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                            oiVar = (C1302oi) g;
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C1302oi.c;
                            C1374rt rtVar = (C1374rt) atomicReferenceFieldUpdater2.get(oiVar);
                            if (rtVar == null) {
                                rtVar = new C1374rt(oiVar);
                                atomicReferenceFieldUpdater2.lazySet(oiVar, rtVar);
                            }
                            while (true) {
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = C1302oi.a;
                                if (!atomicReferenceFieldUpdater3.compareAndSet(this, g, rtVar)) {
                                    if (atomicReferenceFieldUpdater3.get(this) != g) {
                                        z2 = false;
                                        continue;
                                        break;
                                    }
                                } else {
                                    z2 = true;
                                    continue;
                                    break;
                                }
                            }
                        } else {
                            C1302oi oiVar2 = (C1302oi) g;
                            return;
                        }
                    } else {
                        C1302oi oiVar3 = ((C1374rt) g).a;
                        return;
                    }
                } while (!z2);
                oiVar.d();
                return;
            } else {
                return;
            }
        } while (!z);
    }

    public final boolean isActive() {
        return true;
    }

    public final k m() {
        k kVar = this.a;
        if (kVar != null) {
            return kVar;
        }
        C1177ig.l("job");
        throw null;
    }

    public final String toString() {
        return getClass().getSimpleName() + '@' + C1149h8.a(this) + "[job@" + C1149h8.a(m()) + ']';
    }
}
