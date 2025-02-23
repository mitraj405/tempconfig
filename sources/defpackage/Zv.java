package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;

/* renamed from: Zv  reason: default package */
/* compiled from: Semaphore.kt */
public final class Zv extends Pv<Zv> {
    public final AtomicReferenceArray a = new AtomicReferenceArray(Yv.b);

    public Zv(long j, Zv zv, int i) {
        super(j, zv, i);
    }

    public final int f() {
        return Yv.b;
    }

    public final void g(int i, CoroutineContext coroutineContext) {
        this.a.set(i, Yv.d);
        h();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f3758a + ", hashCode=" + hashCode() + ']';
    }
}
