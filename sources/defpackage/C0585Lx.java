package defpackage;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: Lx  reason: default package and case insensitive filesystem */
/* compiled from: SpscAtomicArrayQueue */
public final class C0585Lx<E> extends X1<E> {
    public static final Integer a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: a  reason: collision with other field name */
    public long f3701a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicLong f3702a = new AtomicLong();
    public final AtomicLong b = new AtomicLong();
    public final int d;

    public C0585Lx(int i) {
        super(i);
        this.d = Math.min(i / 4, a.intValue());
    }

    public final boolean isEmpty() {
        if (this.f3702a.get() == this.b.get()) {
            return true;
        }
        return false;
    }

    public final boolean offer(E e) {
        if (e != null) {
            AtomicReferenceArray<E> atomicReferenceArray = this.a;
            AtomicLong atomicLong = this.f3702a;
            long j = atomicLong.get();
            int i = this.c;
            int i2 = ((int) j) & i;
            if (j >= this.f3701a) {
                long j2 = ((long) this.d) + j;
                if (atomicReferenceArray.get(i & ((int) j2)) == null) {
                    this.f3701a = j2;
                } else if (atomicReferenceArray.get(i2) != null) {
                    return false;
                }
            }
            atomicReferenceArray.lazySet(i2, e);
            atomicLong.lazySet(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public final E peek() {
        return this.a.get(((int) this.b.get()) & this.c);
    }

    public final E poll() {
        AtomicLong atomicLong = this.b;
        long j = atomicLong.get();
        int i = ((int) j) & this.c;
        AtomicReferenceArray<E> atomicReferenceArray = this.a;
        E e = atomicReferenceArray.get(i);
        if (e == null) {
            return null;
        }
        atomicReferenceArray.lazySet(i, (Object) null);
        atomicLong.lazySet(j + 1);
        return e;
    }

    public final int size() {
        AtomicLong atomicLong = this.b;
        long j = atomicLong.get();
        while (true) {
            long j2 = this.f3702a.get();
            long j3 = atomicLong.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }
}
