package defpackage;

import defpackage.Pv;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;

/* renamed from: Pv  reason: default package */
/* compiled from: ConcurrentLinkedList.kt */
public abstract class Pv<S extends Pv<S>> extends C1473x6<S> implements C0696Tm {
    public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(Pv.class, "cleanedAndPointers");

    /* renamed from: a  reason: collision with other field name */
    public final long f3758a;
    private volatile int cleanedAndPointers;

    public Pv(long j, S s, int i) {
        super(s);
        this.f3758a = j;
        this.cleanedAndPointers = i << 16;
    }

    public final boolean c() {
        boolean z;
        if (a.get(this) != f()) {
            return false;
        }
        if (b() == null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        boolean z;
        if (a.addAndGet(this, -65536) != f()) {
            return false;
        }
        if (b() == null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return true;
        }
        return false;
    }

    public abstract int f();

    public abstract void g(int i, CoroutineContext coroutineContext);

    public final void h() {
        if (a.incrementAndGet(this) == f()) {
            d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i() {
        /*
            r5 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = a
            int r1 = r0.get(r5)
            int r2 = r5.f()
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x001c
            x6 r2 = r5.b()
            if (r2 != 0) goto L_0x0016
            r2 = r3
            goto L_0x0017
        L_0x0016:
            r2 = r4
        L_0x0017:
            if (r2 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r2 = r4
            goto L_0x001d
        L_0x001c:
            r2 = r3
        L_0x001d:
            if (r2 != 0) goto L_0x0021
            r3 = r4
            goto L_0x002a
        L_0x0021:
            r2 = 65536(0x10000, float:9.18355E-41)
            int r2 = r2 + r1
            boolean r0 = r0.compareAndSet(r5, r1, r2)
            if (r0 == 0) goto L_0x0000
        L_0x002a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Pv.i():boolean");
    }
}
