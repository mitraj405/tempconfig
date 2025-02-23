package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSet<E> extends ForwardingCollection<E> implements Set<E> {
    public abstract Set<E> delegate();

    public boolean equals(Object obj) {
        if (obj == this || delegate().equals(obj)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean standardEquals(Object obj) {
        return Sets.equalsImpl(this, obj);
    }

    public int standardHashCode() {
        return Sets.hashCodeImpl(this);
    }

    public boolean standardRemoveAll(Collection<?> collection) {
        return Sets.removeAllImpl((Set<?>) this, (Collection<?>) (Collection) Preconditions.checkNotNull(collection));
    }
}
