package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> forwardOrder;

    public ReverseOrdering(Ordering<? super T> ordering) {
        this.forwardOrder = (Ordering) Preconditions.checkNotNull(ordering);
    }

    public int compare(@ParametricNullness T t, @ParametricNullness T t2) {
        return this.forwardOrder.compare(t2, t);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    public <E extends T> E max(@ParametricNullness E e, @ParametricNullness E e2) {
        return this.forwardOrder.min(e, e2);
    }

    public <E extends T> E min(@ParametricNullness E e, @ParametricNullness E e2) {
        return this.forwardOrder.max(e, e2);
    }

    public <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        String valueOf = String.valueOf(this.forwardOrder);
        return C1058d.v(valueOf.length() + 10, valueOf, ".reverse()");
    }

    public <E extends T> E max(@ParametricNullness E e, @ParametricNullness E e2, @ParametricNullness E e3, E... eArr) {
        return this.forwardOrder.min(e, e2, e3, eArr);
    }

    public <E extends T> E min(@ParametricNullness E e, @ParametricNullness E e2, @ParametricNullness E e3, E... eArr) {
        return this.forwardOrder.max(e, e2, e3, eArr);
    }

    public <E extends T> E max(Iterator<E> it) {
        return this.forwardOrder.min(it);
    }

    public <E extends T> E min(Iterator<E> it) {
        return this.forwardOrder.max(it);
    }

    public <E extends T> E max(Iterable<E> iterable) {
        return this.forwardOrder.min(iterable);
    }

    public <E extends T> E min(Iterable<E> iterable) {
        return this.forwardOrder.max(iterable);
    }
}
