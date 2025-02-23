package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface SortedSetMultimap<K, V> extends SetMultimap<K, V> {
    Map<K, Collection<V>> asMap();

    SortedSet<V> get(@ParametricNullness K k);

    @CanIgnoreReturnValue
    SortedSet<V> removeAll(Object obj);

    @CanIgnoreReturnValue
    SortedSet<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable);

    Comparator<? super V> valueComparator();
}
