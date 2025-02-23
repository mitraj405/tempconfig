package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    @Beta
    public class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        public StandardDescendingMap() {
        }

        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new Iterator<Map.Entry<K, V>>() {
                private Map.Entry<K, V> nextOrNull;
                private Map.Entry<K, V> toRemove = null;

                {
                    this.nextOrNull = StandardDescendingMap.this.forward().lastEntry();
                }

                public boolean hasNext() {
                    if (this.nextOrNull != null) {
                        return true;
                    }
                    return false;
                }

                public void remove() {
                    if (this.toRemove != null) {
                        StandardDescendingMap.this.forward().remove(this.toRemove.getKey());
                        this.toRemove = null;
                        return;
                    }
                    throw new IllegalStateException("no calls to next() since the last call to remove()");
                }

                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> entry = this.nextOrNull;
                    if (entry != null) {
                        this.toRemove = entry;
                        this.nextOrNull = StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
                        return entry;
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        public NavigableMap<K, V> forward() {
            return ForwardingNavigableMap.this;
        }
    }

    @Beta
    public class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        public StandardNavigableKeySet(ForwardingNavigableMap forwardingNavigableMap) {
            super(forwardingNavigableMap);
        }
    }

    public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k) {
        return delegate().ceilingEntry(k);
    }

    public K ceilingKey(@ParametricNullness K k) {
        return delegate().ceilingKey(k);
    }

    public abstract NavigableMap<K, V> delegate();

    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    public Map.Entry<K, V> floorEntry(@ParametricNullness K k) {
        return delegate().floorEntry(k);
    }

    public K floorKey(@ParametricNullness K k) {
        return delegate().floorKey(k);
    }

    public NavigableMap<K, V> headMap(@ParametricNullness K k, boolean z) {
        return delegate().headMap(k, z);
    }

    public Map.Entry<K, V> higherEntry(@ParametricNullness K k) {
        return delegate().higherEntry(k);
    }

    public K higherKey(@ParametricNullness K k) {
        return delegate().higherKey(k);
    }

    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    public Map.Entry<K, V> lowerEntry(@ParametricNullness K k) {
        return delegate().lowerEntry(k);
    }

    public K lowerKey(@ParametricNullness K k) {
        return delegate().lowerKey(k);
    }

    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    public Map.Entry<K, V> standardCeilingEntry(@ParametricNullness K k) {
        return tailMap(k, true).firstEntry();
    }

    public K standardCeilingKey(@ParametricNullness K k) {
        return Maps.keyOrNull(ceilingEntry(k));
    }

    @Beta
    public NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    public K standardFirstKey() {
        Map.Entry firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public Map.Entry<K, V> standardFloorEntry(@ParametricNullness K k) {
        return headMap(k, true).lastEntry();
    }

    public K standardFloorKey(@ParametricNullness K k) {
        return Maps.keyOrNull(floorEntry(k));
    }

    public SortedMap<K, V> standardHeadMap(@ParametricNullness K k) {
        return headMap(k, false);
    }

    public Map.Entry<K, V> standardHigherEntry(@ParametricNullness K k) {
        return tailMap(k, false).firstEntry();
    }

    public K standardHigherKey(@ParametricNullness K k) {
        return Maps.keyOrNull(higherEntry(k));
    }

    public Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    public K standardLastKey() {
        Map.Entry lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public Map.Entry<K, V> standardLowerEntry(@ParametricNullness K k) {
        return headMap(k, false).lastEntry();
    }

    public K standardLowerKey(@ParametricNullness K k) {
        return Maps.keyOrNull(lowerEntry(k));
    }

    public Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entrySet().iterator());
    }

    public Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingMap().entrySet().iterator());
    }

    public SortedMap<K, V> standardSubMap(@ParametricNullness K k, @ParametricNullness K k2) {
        return subMap(k, true, k2, false);
    }

    public SortedMap<K, V> standardTailMap(@ParametricNullness K k) {
        return tailMap(k, true);
    }

    public NavigableMap<K, V> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
        return delegate().subMap(k, z, k2, z2);
    }

    public NavigableMap<K, V> tailMap(@ParametricNullness K k, boolean z) {
        return delegate().tailMap(k, z);
    }
}
