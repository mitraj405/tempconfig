package defpackage;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: X1  reason: default package */
/* compiled from: AtomicReferenceArrayQueue */
public abstract class X1<E> extends AbstractQueue<E> {
    public final AtomicReferenceArray<E> a;
    public final int c;

    public X1(int i) {
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
        this.c = numberOfLeadingZeros - 1;
        this.a = new AtomicReferenceArray<>(numberOfLeadingZeros);
    }

    public final void clear() {
        while (true) {
            if (((C0585Lx) this).poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
