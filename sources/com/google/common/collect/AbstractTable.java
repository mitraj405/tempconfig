package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractTable<R, C, V> implements Table<R, C, V> {
    @LazyInit
    private transient Set<Table.Cell<R, C, V>> cellSet;
    @LazyInit
    private transient Collection<V> values;

    public class CellSet extends AbstractSet<Table.Cell<R, C, V>> {
        public CellSet() {
        }

        public void clear() {
            AbstractTable.this.clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Map map = (Map) Maps.safeGet(AbstractTable.this.rowMap(), cell.getRowKey());
            if (map == null || !Collections2.safeContains(map.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue()))) {
                return false;
            }
            return true;
        }

        public Iterator<Table.Cell<R, C, V>> iterator() {
            return AbstractTable.this.cellIterator();
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Map map = (Map) Maps.safeGet(AbstractTable.this.rowMap(), cell.getRowKey());
            if (map == null || !Collections2.safeRemove(map.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue()))) {
                return false;
            }
            return true;
        }

        public int size() {
            return AbstractTable.this.size();
        }
    }

    public class Values extends AbstractCollection<V> {
        public Values() {
        }

        public void clear() {
            AbstractTable.this.clear();
        }

        public boolean contains(Object obj) {
            return AbstractTable.this.containsValue(obj);
        }

        public Iterator<V> iterator() {
            return AbstractTable.this.valuesIterator();
        }

        public int size() {
            return AbstractTable.this.size();
        }
    }

    public abstract Iterator<Table.Cell<R, C, V>> cellIterator();

    public Set<Table.Cell<R, C, V>> cellSet() {
        Set<Table.Cell<R, C, V>> set = this.cellSet;
        if (set != null) {
            return set;
        }
        Set<Table.Cell<R, C, V>> createCellSet = createCellSet();
        this.cellSet = createCellSet;
        return createCellSet;
    }

    public void clear() {
        Iterators.clear(cellSet().iterator());
    }

    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    public boolean contains(Object obj, Object obj2) {
        Map map = (Map) Maps.safeGet(rowMap(), obj);
        if (map == null || !Maps.safeContainsKey(map, obj2)) {
            return false;
        }
        return true;
    }

    public boolean containsColumn(Object obj) {
        return Maps.safeContainsKey(columnMap(), obj);
    }

    public boolean containsRow(Object obj) {
        return Maps.safeContainsKey(rowMap(), obj);
    }

    public boolean containsValue(Object obj) {
        for (Map containsValue : rowMap().values()) {
            if (containsValue.containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set<Table.Cell<R, C, V>> createCellSet() {
        return new CellSet();
    }

    public Collection<V> createValues() {
        return new Values();
    }

    public boolean equals(Object obj) {
        return Tables.equalsImpl(this, obj);
    }

    public V get(Object obj, Object obj2) {
        Map map = (Map) Maps.safeGet(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return Maps.safeGet(map, obj2);
    }

    public int hashCode() {
        return cellSet().hashCode();
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @CanIgnoreReturnValue
    public V put(@ParametricNullness R r, @ParametricNullness C c, @ParametricNullness V v) {
        return row(r).put(c, v);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        for (Table.Cell next : table.cellSet()) {
            put(next.getRowKey(), next.getColumnKey(), next.getValue());
        }
    }

    @CanIgnoreReturnValue
    public V remove(Object obj, Object obj2) {
        Map map = (Map) Maps.safeGet(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return Maps.safeRemove(map, obj2);
    }

    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public String toString() {
        return rowMap().toString();
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    public Iterator<V> valuesIterator() {
        return new TransformedIterator<Table.Cell<R, C, V>, V>(this, cellSet().iterator()) {
            @ParametricNullness
            public V transform(Table.Cell<R, C, V> cell) {
                return cell.getValue();
            }
        };
    }
}
