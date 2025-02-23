package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSetMultimap<K, V> extends ForwardingMultimap<K, V> implements SetMultimap<K, V> {
    public abstract SetMultimap<K, V> delegate();

    public Set<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    public Set<V> get(@ParametricNullness K k) {
        return delegate().get((Object) k);
    }

    @CanIgnoreReturnValue
    public Set<V> removeAll(Object obj) {
        return delegate().removeAll(obj);
    }

    @CanIgnoreReturnValue
    public Set<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
        return delegate().replaceValues((Object) k, (Iterable) iterable);
    }
}
