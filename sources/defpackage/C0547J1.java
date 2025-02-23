package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: J1  reason: default package and case insensitive filesystem */
/* compiled from: ArrayIterator.kt */
public final class C0547J1<T> implements Iterator<T> {
    public final T[] a;
    public int c;

    public C0547J1(T[] tArr) {
        this.a = tArr;
    }

    public final boolean hasNext() {
        if (this.c < this.a.length) {
            return true;
        }
        return false;
    }

    public final T next() {
        try {
            T[] tArr = this.a;
            int i = this.c;
            this.c = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.c--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
