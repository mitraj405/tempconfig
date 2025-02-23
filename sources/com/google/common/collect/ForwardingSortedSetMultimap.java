package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedSetMultimap<K, V> extends ForwardingSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    public abstract SortedSetMultimap<K, V> delegate();

    public Comparator<? super V> valueComparator() {
        return delegate().valueComparator();
    }

    public SortedSet<V> get(@ParametricNullness K k) {
        return delegate().get((Object) k);
    }

    public SortedSet<V> removeAll(Object obj) {
        return delegate().removeAll(obj);
    }

    public SortedSet<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
        return delegate().replaceValues((Object) k, (Iterable) iterable);
    }
}
