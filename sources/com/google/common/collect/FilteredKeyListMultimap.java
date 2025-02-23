package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.List;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class FilteredKeyListMultimap<K, V> extends FilteredKeyMultimap<K, V> implements ListMultimap<K, V> {
    public FilteredKeyListMultimap(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        super(listMultimap, predicate);
    }

    public List<V> get(@ParametricNullness K k) {
        return (List) super.get(k);
    }

    public List<V> removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    public List<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
        return (List) super.replaceValues(k, iterable);
    }

    public ListMultimap<K, V> unfiltered() {
        return (ListMultimap) super.unfiltered();
    }
}
