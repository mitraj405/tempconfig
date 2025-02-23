package defpackage;

import rx.internal.util.unsafe.a;
import rx.internal.util.unsafe.b;

/* renamed from: Hx  reason: default package */
/* compiled from: SpscArrayQueue */
public final class Hx<E> extends Kx<E> {
    public Hx(int i) {
        super(i);
    }

    public final long c() {
        return C1255mB.a.getLongVolatile(this, a.d);
    }

    public final long d() {
        return C1255mB.a.getLongVolatile(this, b.c);
    }

    public final void e(long j) {
        C1255mB.a.putOrderedLong(this, a.d, j);
    }

    public final void f(long j) {
        C1255mB.a.putOrderedLong(this, b.c, j);
    }

    public final boolean isEmpty() {
        if (d() == c()) {
            return true;
        }
        return false;
    }

    public final boolean offer(E e) {
        if (e != null) {
            long j = this.producerIndex;
            long j2 = C1419u6.b + ((this.a & j) << C1419u6.d);
            E[] eArr = this.f6971a;
            if (C1419u6.a(eArr, j2) != null) {
                return false;
            }
            C1419u6.b(eArr, j2, e);
            f(j + 1);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public final E peek() {
        return C1419u6.a(this.f6971a, C1419u6.b + ((this.consumerIndex & this.a) << C1419u6.d));
    }

    public final E poll() {
        long j = this.consumerIndex;
        long j2 = C1419u6.b + ((this.a & j) << C1419u6.d);
        E[] eArr = this.f6971a;
        E a = C1419u6.a(eArr, j2);
        if (a == null) {
            return null;
        }
        C1419u6.b(eArr, j2, (Object) null);
        e(j + 1);
        return a;
    }

    public final int size() {
        long c = c();
        while (true) {
            long d = d();
            long c2 = c();
            if (c == c2) {
                return (int) (d - c2);
            }
            c = c2;
        }
    }
}
