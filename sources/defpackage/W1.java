package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: W1  reason: default package */
/* compiled from: Atomic.kt */
public abstract class W1<T> extends C1138go {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(W1.class, Object.class, "_consensus");
    private volatile Object _consensus = r1.f3208a;

    public final Object a(Object obj) {
        boolean z;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        C0422zD zDVar = r1.f3208a;
        if (obj2 == zDVar) {
            C0422zD c = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == zDVar) {
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, zDVar, c)) {
                        if (atomicReferenceFieldUpdater.get(this) != zDVar) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    obj2 = c;
                } else {
                    obj2 = atomicReferenceFieldUpdater.get(this);
                }
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(T t, Object obj);

    public abstract C0422zD c(Object obj);
}
