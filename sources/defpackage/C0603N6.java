package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: N6  reason: default package and case insensitive filesystem */
/* compiled from: SequencesJVM.kt */
public final class C0603N6<T> implements C0810bw<T> {
    public final AtomicReference<C0810bw<T>> a;

    public C0603N6(C1120fw fwVar) {
        this.a = new AtomicReference<>(fwVar);
    }

    public final Iterator<T> iterator() {
        C0810bw andSet = this.a.getAndSet((Object) null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
