package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        @Weak
        final ImmutableMultimap<K, V> multimap;

        public EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        public int size() {
            return this.multimap.size();
        }

        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    @GwtIncompatible
    public static class FieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER;
        static final Serialization.FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER;

        static {
            Class<ImmutableMultimap> cls = ImmutableMultimap.class;
            MAP_FIELD_SETTER = Serialization.getFieldSetter(cls, "map");
            SIZE_FIELD_SETTER = Serialization.getFieldSetter(cls, "size");
        }
    }

    public class Keys extends ImmutableMultiset<K> {
        public Keys() {
        }

        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        public int count(Object obj) {
            Collection collection = (Collection) ImmutableMultimap.this.map.get(obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        public Multiset.Entry<K> getEntry(int i) {
            Map.Entry entry = ImmutableMultimap.this.map.entrySet().asList().get(i);
            return Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size());
        }

        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return ImmutableMultimap.this.size();
        }

        @GwtIncompatible
        public Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }

        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }
    }

    @GwtIncompatible
    public static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        public KeysSerializedForm(ImmutableMultimap<?, ?> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public Object readResolve() {
            return this.multimap.keys();
        }
    }

    public static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        @Weak
        private final transient ImmutableMultimap<K, V> multimap;

        public Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public boolean contains(Object obj) {
            return this.multimap.containsValue(obj);
        }

        @GwtIncompatible
        public int copyIntoArray(Object[] objArr, int i) {
            UnmodifiableIterator<? extends ImmutableCollection<V>> it = this.multimap.map.values().iterator();
            while (it.hasNext()) {
                i = ((ImmutableCollection) it.next()).copyIntoArray(objArr, i);
            }
            return i;
        }

        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.multimap.size();
        }

        public UnmodifiableIterator<V> iterator() {
            return this.multimap.valueIterator();
        }
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.map = immutableMap;
        this.size = i;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) multimap;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf(multimap);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        if (obj == null || !super.containsValue(obj)) {
            return false;
        }
        return true;
    }

    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public abstract ImmutableCollection<V> get(K k);

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.size;
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @DoNotMock
    public static class Builder<K, V> {
        final Map<K, Collection<V>> builderMap = Platform.preservesInsertionOrderOnPutsMap();
        Comparator<? super K> keyComparator;
        Comparator<? super V> valueComparator;

        public ImmutableMultimap<K, V> build() {
            Collection entrySet = this.builderMap.entrySet();
            Comparator comparator = this.keyComparator;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return ImmutableListMultimap.fromMapEntries(entrySet, this.valueComparator);
        }

        @CanIgnoreReturnValue
        public Builder<K, V> combine(Builder<K, V> builder) {
            for (Map.Entry next : builder.builderMap.entrySet()) {
                putAll(next.getKey(), (Iterable) next.getValue());
            }
            return this;
        }

        public Collection<V> newMutableValueCollection() {
            return new ArrayList();
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator<? super K> comparator) {
            this.keyComparator = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator<? super V> comparator) {
            this.valueComparator = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            CollectPreconditions.checkEntryNotNull(k, v);
            Collection collection = this.builderMap.get(k);
            if (collection == null) {
                Map<K, Collection<V>> map = this.builderMap;
                Collection newMutableValueCollection = newMutableValueCollection();
                map.put(k, newMutableValueCollection);
                collection = newMutableValueCollection;
            }
            collection.add(v);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            for (Map.Entry put : iterable) {
                put(put);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k, Iterable<? extends V> iterable) {
            if (k == null) {
                String valueOf = String.valueOf(Iterables.toString(iterable));
                throw new NullPointerException(valueOf.length() != 0 ? "null key in entry: null=".concat(valueOf) : new String("null key in entry: null="));
            }
            Collection collection = this.builderMap.get(k);
            if (collection != null) {
                for (Object next : iterable) {
                    CollectPreconditions.checkEntryNotNull(k, next);
                    collection.add(next);
                }
                return this;
            }
            Iterator<? extends V> it = iterable.iterator();
            if (!it.hasNext()) {
                return this;
            }
            Collection newMutableValueCollection = newMutableValueCollection();
            while (it.hasNext()) {
                Object next2 = it.next();
                CollectPreconditions.checkEntryNotNull(k, next2);
                newMutableValueCollection.add(next2);
            }
            this.builderMap.put(k, newMutableValueCollection);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k, V... vArr) {
            return putAll(k, Arrays.asList(vArr));
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry next : multimap.asMap().entrySet()) {
                putAll(next.getKey(), (Iterable) next.getValue());
            }
            return this;
        }
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v) {
        return ImmutableListMultimap.of(k, v);
    }

    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    public ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    public UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        return new UnmodifiableIterator<Map.Entry<K, V>>() {
            final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> asMapItr;
            K currentKey = null;
            Iterator<V> valueItr = Iterators.emptyIterator();

            {
                this.asMapItr = ImmutableMultimap.this.map.entrySet().iterator();
            }

            public boolean hasNext() {
                if (this.valueItr.hasNext() || this.asMapItr.hasNext()) {
                    return true;
                }
                return false;
            }

            public Map.Entry<K, V> next() {
                if (!this.valueItr.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.asMapItr.next();
                    this.currentKey = entry.getKey();
                    this.valueItr = ((ImmutableCollection) entry.getValue()).iterator();
                }
                K k = this.currentKey;
                Objects.requireNonNull(k);
                return Maps.immutableEntry(k, this.valueItr.next());
            }
        };
    }

    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public UnmodifiableIterator<V> valueIterator() {
        return new UnmodifiableIterator<V>() {
            Iterator<? extends ImmutableCollection<V>> valueCollectionItr;
            Iterator<V> valueItr = Iterators.emptyIterator();

            {
                this.valueCollectionItr = ImmutableMultimap.this.map.values().iterator();
            }

            public boolean hasNext() {
                if (this.valueItr.hasNext() || this.valueCollectionItr.hasNext()) {
                    return true;
                }
                return false;
            }

            public V next() {
                if (!this.valueItr.hasNext()) {
                    this.valueItr = ((ImmutableCollection) this.valueCollectionItr.next()).iterator();
                }
                return this.valueItr.next();
            }
        };
    }

    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2) {
        return ImmutableListMultimap.of(k, v, k2, v2);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.of(k, v, k2, v2, k3, v3);
    }

    @Beta
    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf(iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.of(k, v, k2, v2, k3, v3, k4, v4);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.of(k, v, k2, v2, k3, v3, k4, v4, k5, v5);
    }
}
