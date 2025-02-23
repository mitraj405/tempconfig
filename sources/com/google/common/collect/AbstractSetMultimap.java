package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    public AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public abstract Set<V> createCollection();

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public boolean put(@ParametricNullness K k, @ParametricNullness V v) {
        return super.put(k, v);
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    public Collection<V> wrapCollection(@ParametricNullness K k, Collection<V> collection) {
        return new AbstractMapBasedMultimap.WrappedSet(k, (Set) collection);
    }

    public Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    public Set<V> get(@ParametricNullness K k) {
        return (Set) super.get(k);
    }

    @CanIgnoreReturnValue
    public Set<V> removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    @CanIgnoreReturnValue
    public Set<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues(k, iterable);
    }
}
