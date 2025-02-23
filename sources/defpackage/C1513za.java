package defpackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: za  reason: default package and case insensitive filesystem */
/* compiled from: Sets.kt */
public final class C1513za implements Set, Serializable {
    public static final C1513za a = new C1513za();
    private static final long serialVersionUID = 3406603774387020532L;

    private final Object readResolve() {
        return a;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        C1177ig.f((Void) obj, "element");
        return false;
    }

    public final boolean containsAll(Collection collection) {
        C1177ig.f(collection, "elements");
        return collection.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Set) || !((Set) obj).isEmpty()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final Iterator iterator() {
        return C1458wa.a;
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return 0;
    }

    public final Object[] toArray() {
        return C1354qp.F0(this);
    }

    public final String toString() {
        return "[]";
    }

    public final <T> T[] toArray(T[] tArr) {
        C1177ig.f(tArr, "array");
        return C1354qp.G0(this, tArr);
    }
}
