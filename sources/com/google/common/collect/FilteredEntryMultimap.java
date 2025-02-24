package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
class FilteredEntryMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    final Predicate<? super Map.Entry<K, V>> predicate;
    final Multimap<K, V> unfiltered;

    public class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        public AsMap() {
        }

        public void clear() {
            FilteredEntryMultimap.this.clear();
        }

        public boolean containsKey(Object obj) {
            if (get(obj) != null) {
                return true;
            }
            return false;
        }

        public Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new Maps.EntrySet<K, Collection<V>>() {
                public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                    return new AbstractIterator<Map.Entry<K, Collection<V>>>() {
                        final Iterator<Map.Entry<K, Collection<V>>> backingIterator;

                        {
                            this.backingIterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                        }

                        public Map.Entry<K, Collection<V>> computeNext() {
                            while (this.backingIterator.hasNext()) {
                                Map.Entry next = this.backingIterator.next();
                                Object key = next.getKey();
                                Collection filterCollection = FilteredEntryMultimap.filterCollection((Collection) next.getValue(), new ValuePredicate(key));
                                if (!filterCollection.isEmpty()) {
                                    return Maps.immutableEntry(key, filterCollection);
                                }
                            }
                            return (Map.Entry) endOfData();
                        }
                    };
                }

                public Map<K, Collection<V>> map() {
                    return AsMap.this;
                }

                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Predicates.in(collection));
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Predicates.not(Predicates.in(collection)));
                }

                public int size() {
                    return Iterators.size(iterator());
                }
            };
        }

        public Set<K> createKeySet() {
            return new Maps.KeySet<K, Collection<V>>() {
                public boolean remove(Object obj) {
                    if (AsMap.this.remove(obj) != null) {
                        return true;
                    }
                    return false;
                }

                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(collection)));
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
                }
            };
        }

        public Collection<Collection<V>> createValues() {
            return new Maps.Values<K, Collection<V>>() {
                public boolean remove(Object obj) {
                    if (!(obj instanceof Collection)) {
                        return false;
                    }
                    Collection collection = (Collection) obj;
                    Iterator<Map.Entry<K, Collection<V>>> it = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        Collection filterCollection = FilteredEntryMultimap.filterCollection((Collection) next.getValue(), new ValuePredicate(next.getKey()));
                        if (!filterCollection.isEmpty() && collection.equals(filterCollection)) {
                            if (filterCollection.size() == ((Collection) next.getValue()).size()) {
                                it.remove();
                                return true;
                            }
                            filterCollection.clear();
                            return true;
                        }
                    }
                    return false;
                }

                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(collection)));
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
                }
            };
        }

        public Collection<V> get(Object obj) {
            Collection collection = FilteredEntryMultimap.this.unfiltered.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> filterCollection = FilteredEntryMultimap.filterCollection(collection, new ValuePredicate(obj));
            if (filterCollection.isEmpty()) {
                return null;
            }
            return filterCollection;
        }

        public Collection<V> remove(Object obj) {
            Collection collection = FilteredEntryMultimap.this.unfiltered.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            ArrayList newArrayList = Lists.newArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (FilteredEntryMultimap.this.satisfies(obj, next)) {
                    it.remove();
                    newArrayList.add(next);
                }
            }
            if (newArrayList.isEmpty()) {
                return null;
            }
            if (FilteredEntryMultimap.this.unfiltered instanceof SetMultimap) {
                return Collections.unmodifiableSet(Sets.newLinkedHashSet(newArrayList));
            }
            return Collections.unmodifiableList(newArrayList);
        }
    }

    public class Keys extends Multimaps.Keys<K, V> {
        public Keys() {
            super(FilteredEntryMultimap.this);
        }

        public Set<Multiset.Entry<K>> entrySet() {
            return new Multisets.EntrySet<K>() {
                private boolean removeEntriesIf(Predicate<? super Multiset.Entry<K>> predicate) {
                    return FilteredEntryMultimap.this.removeEntriesIf(new a(predicate));
                }

                public Iterator<Multiset.Entry<K>> iterator() {
                    return Keys.this.entryIterator();
                }

                public Multiset<K> multiset() {
                    return Keys.this;
                }

                public boolean removeAll(Collection<?> collection) {
                    return removeEntriesIf(Predicates.in(collection));
                }

                public boolean retainAll(Collection<?> collection) {
                    return removeEntriesIf(Predicates.not(Predicates.in(collection)));
                }

                public int size() {
                    return FilteredEntryMultimap.this.keySet().size();
                }
            };
        }

        public int remove(Object obj, int i) {
            CollectPreconditions.checkNonnegative(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = FilteredEntryMultimap.this.unfiltered.asMap().get(obj);
            int i2 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (FilteredEntryMultimap.this.satisfies(obj, it.next()) && (i2 = i2 + 1) <= i) {
                    it.remove();
                }
            }
            return i2;
        }
    }

    public final class ValuePredicate implements Predicate<V> {
        @ParametricNullness
        private final K key;

        public ValuePredicate(@ParametricNullness K k) {
            this.key = k;
        }

        public boolean apply(@ParametricNullness V v) {
            return FilteredEntryMultimap.this.satisfies(this.key, v);
        }
    }

    public FilteredEntryMultimap(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate2) {
        this.unfiltered = (Multimap) Preconditions.checkNotNull(multimap);
        this.predicate = (Predicate) Preconditions.checkNotNull(predicate2);
    }

    public static <E> Collection<E> filterCollection(Collection<E> collection, Predicate<? super E> predicate2) {
        if (collection instanceof Set) {
            return Sets.filter((Set) collection, predicate2);
        }
        return Collections2.filter(collection, predicate2);
    }

    /* access modifiers changed from: private */
    public boolean satisfies(@ParametricNullness K k, @ParametricNullness V v) {
        return this.predicate.apply(Maps.immutableEntry(k, v));
    }

    public void clear() {
        entries().clear();
    }

    public boolean containsKey(Object obj) {
        if (asMap().get(obj) != null) {
            return true;
        }
        return false;
    }

    public Map<K, Collection<V>> createAsMap() {
        return new AsMap();
    }

    public Collection<Map.Entry<K, V>> createEntries() {
        return filterCollection(this.unfiltered.entries(), this.predicate);
    }

    public Set<K> createKeySet() {
        return asMap().keySet();
    }

    public Multiset<K> createKeys() {
        return new Keys();
    }

    public Collection<V> createValues() {
        return new FilteredMultimapValues(this);
    }

    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    public Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return this.predicate;
    }

    public Collection<V> get(@ParametricNullness K k) {
        return filterCollection(this.unfiltered.get(k), new ValuePredicate(k));
    }

    public Collection<V> removeAll(Object obj) {
        return (Collection) MoreObjects.firstNonNull((Collection) asMap().remove(obj), unmodifiableEmptyCollection());
    }

    public boolean removeEntriesIf(Predicate<? super Map.Entry<K, Collection<V>>> predicate2) {
        Iterator<Map.Entry<K, Collection<V>>> it = this.unfiltered.asMap().entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry next = it.next();
            Object key = next.getKey();
            Collection filterCollection = filterCollection((Collection) next.getValue(), new ValuePredicate(key));
            if (!filterCollection.isEmpty() && predicate2.apply(Maps.immutableEntry(key, filterCollection))) {
                if (filterCollection.size() == ((Collection) next.getValue()).size()) {
                    it.remove();
                } else {
                    filterCollection.clear();
                }
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return entries().size();
    }

    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }

    public Collection<V> unmodifiableEmptyCollection() {
        if (this.unfiltered instanceof SetMultimap) {
            return Collections.emptySet();
        }
        return Collections.emptyList();
    }
}
