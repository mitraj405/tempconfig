package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: Tx  reason: default package */
/* compiled from: StateFlow.kt */
public final class Tx extends C1378s<Sx<?>> {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(Tx.class, Object.class, "_state");
    private volatile Object _state;

    public final boolean a(Object obj) {
        Sx sx = (Sx) obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, r1.l);
        return true;
    }

    public final void b(Sx sx) {
        a.set(this, (Object) null);
    }
}
