package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class NullsLastOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> ordering;

    public NullsLastOrdering(Ordering<? super T> ordering2) {
        this.ordering = ordering2;
    }

    public int compare(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return 1;
        }
        if (t2 == null) {
            return -1;
        }
        return this.ordering.compare(t, t2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsLastOrdering) {
            return this.ordering.equals(((NullsLastOrdering) obj).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ -921210296;
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return this.ordering.nullsFirst();
    }

    public <S extends T> Ordering<S> reverse() {
        return this.ordering.reverse().nullsFirst();
    }

    public String toString() {
        String valueOf = String.valueOf(this.ordering);
        return C1058d.v(valueOf.length() + 12, valueOf, ".nullsLast()");
    }

    public <S extends T> Ordering<S> nullsLast() {
        return this;
    }
}
