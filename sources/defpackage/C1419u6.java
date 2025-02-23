package defpackage;

import java.util.Iterator;
import sun.misc.Unsafe;

/* renamed from: u6  reason: default package and case insensitive filesystem */
/* compiled from: ConcurrentCircularArrayQueue */
public abstract class C1419u6<E> extends C1437v6<E> {
    public static final long b;
    public static final int c;
    public static final int d;
    public final long a;

    /* renamed from: a  reason: collision with other field name */
    public final E[] f6971a;

    static {
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        c = intValue;
        Unsafe unsafe = C1255mB.a;
        Class<Object[]> cls = Object[].class;
        int arrayIndexScale = unsafe.arrayIndexScale(cls);
        if (4 == arrayIndexScale) {
            d = intValue + 2;
        } else if (8 == arrayIndexScale) {
            d = intValue + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        b = (long) (unsafe.arrayBaseOffset(cls) + (32 << (d - intValue)));
    }

    public C1419u6(int i) {
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
        this.a = (long) (numberOfLeadingZeros - 1);
        this.f6971a = new Object[((numberOfLeadingZeros << c) + 64)];
    }

    public static Object a(Object[] objArr, long j) {
        return C1255mB.a.getObjectVolatile(objArr, j);
    }

    public static void b(Object[] objArr, long j, Object obj) {
        C1255mB.a.putOrderedObject(objArr, j, obj);
    }

    public final void clear() {
        while (true) {
            if (((Hx) this).poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
