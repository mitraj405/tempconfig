package defpackage;

import defpackage.C1473x6;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: x6  reason: default package and case insensitive filesystem */
/* compiled from: ConcurrentLinkedList.kt */
public abstract class C1473x6<N extends C1473x6<N>> {
    public static final AtomicReferenceFieldUpdater a;
    public static final AtomicReferenceFieldUpdater b;
    private volatile Object _next;
    private volatile Object _prev;

    static {
        Class<C1473x6> cls = C1473x6.class;
        Class<Object> cls2 = Object.class;
        a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
    }

    public C1473x6(N n) {
        this._prev = n;
    }

    public final void a() {
        b.lazySet(this, (Object) null);
    }

    public final N b() {
        N n = a.get(this);
        if (n == r1.f3215c) {
            return null;
        }
        return (C1473x6) n;
    }

    public abstract boolean c();

    public final void d() {
        boolean z;
        C1473x6 x6Var;
        boolean z2;
        boolean z3;
        C1473x6 b2;
        if (b() == null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
                C1473x6 x6Var2 = (C1473x6) atomicReferenceFieldUpdater.get(this);
                while (x6Var2 != null && x6Var2.c()) {
                    x6Var2 = (C1473x6) atomicReferenceFieldUpdater.get(x6Var2);
                }
                C1473x6 b3 = b();
                C1177ig.c(b3);
                while (b3.c() && (b2 = b3.b()) != null) {
                    b3 = b2;
                }
                do {
                    Object obj = atomicReferenceFieldUpdater.get(b3);
                    if (((C1473x6) obj) == null) {
                        x6Var = null;
                    } else {
                        x6Var = x6Var2;
                    }
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(b3, obj, x6Var)) {
                            if (atomicReferenceFieldUpdater.get(b3) != obj) {
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
                } while (!z2);
                if (x6Var2 != null) {
                    a.set(x6Var2, b3);
                }
                if (b3.c()) {
                    if (b3.b() == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        continue;
                    }
                }
                if (x6Var2 == null || !x6Var2.c()) {
                    return;
                }
            }
        }
    }
}
