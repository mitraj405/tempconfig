package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: H1  reason: default package and case insensitive filesystem */
/* compiled from: Collections.kt */
public final class C0525H1<T> implements Collection<T> {
    public final boolean a;

    /* renamed from: a  reason: collision with other field name */
    public final T[] f3603a;

    public C0525H1(T[] tArr, boolean z) {
        this.f3603a = tArr;
        this.a = z;
    }

    public final boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object obj) {
        int i;
        T[] tArr = this.f3603a;
        C1177ig.f(tArr, "<this>");
        if (obj != null) {
            int length = tArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (C1177ig.a(obj, tArr[i2])) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            int length2 = tArr.length;
            i = 0;
            while (true) {
                if (i >= length2) {
                    break;
                } else if (tArr[i] == null) {
                    break;
                } else {
                    i++;
                }
            }
        }
        i = -1;
        if (i >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsAll(Collection<? extends Object> collection) {
        C1177ig.f(collection, "elements");
        Iterable<Object> iterable = collection;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        if (this.f3603a.length == 0) {
            return true;
        }
        return false;
    }

    public final Iterator<T> iterator() {
        T[] tArr = this.f3603a;
        C1177ig.f(tArr, "array");
        return new C0547J1(tArr);
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.f3603a.length;
    }

    public final Object[] toArray() {
        T[] tArr = this.f3603a;
        C1177ig.f(tArr, "<this>");
        Class<Object[]> cls = Object[].class;
        if (this.a && C1177ig.a(tArr.getClass(), cls)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, cls);
        C1177ig.e(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    public final <T> T[] toArray(T[] tArr) {
        C1177ig.f(tArr, "array");
        return C1354qp.G0(this, tArr);
    }
}
