package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    transient ObjectCountHashMap<E> backingMap;
    transient long size;

    public abstract class Itr<T> implements Iterator<T> {
        int entryIndex;
        int expectedModCount;
        int toRemove = -1;

        public Itr() {
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.firstIndex();
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        private void checkForConcurrentModification() {
            if (AbstractMapBasedMultiset.this.backingMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.entryIndex >= 0) {
                return true;
            }
            return false;
        }

        @ParametricNullness
        public T next() {
            if (hasNext()) {
                T result = result(this.entryIndex);
                int i = this.entryIndex;
                this.toRemove = i;
                this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndex(i);
                return result;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            boolean z;
            checkForConcurrentModification();
            if (this.toRemove != -1) {
                z = true;
            } else {
                z = false;
            }
            CollectPreconditions.checkRemove(z);
            AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
            abstractMapBasedMultiset.size -= (long) abstractMapBasedMultiset.backingMap.removeEntry(this.toRemove);
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndexAfterRemove(this.entryIndex, this.toRemove);
            this.toRemove = -1;
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        @ParametricNullness
        public abstract T result(int i);
    }

    public AbstractMapBasedMultiset(int i) {
        this.backingMap = newBackingMap(i);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        this.backingMap = newBackingMap(3);
        Serialization.populateMultiset(this, objectInputStream, readCount);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @CanIgnoreReturnValue
    public final int add(@ParametricNullness E e, int i) {
        boolean z;
        if (i == 0) {
            return count(e);
        }
        boolean z2 = true;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "occurrences cannot be negative: %s", i);
        int indexOf = this.backingMap.indexOf(e);
        if (indexOf == -1) {
            this.backingMap.put(e, i);
            this.size += (long) i;
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        long j = (long) i;
        long j2 = ((long) value) + j;
        if (j2 > 2147483647L) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "too many occurrences: %s", j2);
        this.backingMap.setValue(indexOf, (int) j2);
        this.size += j;
        return value;
    }

    public void addTo(Multiset<? super E> multiset) {
        Preconditions.checkNotNull(multiset);
        int firstIndex = this.backingMap.firstIndex();
        while (firstIndex >= 0) {
            multiset.add(this.backingMap.getKey(firstIndex), this.backingMap.getValue(firstIndex));
            firstIndex = this.backingMap.nextIndex(firstIndex);
        }
    }

    public final void clear() {
        this.backingMap.clear();
        this.size = 0;
    }

    public final int count(Object obj) {
        return this.backingMap.get(obj);
    }

    public final int distinctElements() {
        return this.backingMap.size();
    }

    public final Iterator<E> elementIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() {
            @ParametricNullness
            public E result(int i) {
                return AbstractMapBasedMultiset.this.backingMap.getKey(i);
            }
        };
    }

    public final Iterator<Multiset.Entry<E>> entryIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() {
            public Multiset.Entry<E> result(int i) {
                return AbstractMapBasedMultiset.this.backingMap.getEntry(i);
            }
        };
    }

    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    public abstract ObjectCountHashMap<E> newBackingMap(int i);

    @CanIgnoreReturnValue
    public final int remove(Object obj, int i) {
        boolean z;
        if (i == 0) {
            return count(obj);
        }
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "occurrences cannot be negative: %s", i);
        int indexOf = this.backingMap.indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        if (value > i) {
            this.backingMap.setValue(indexOf, value - i);
        } else {
            this.backingMap.removeEntry(indexOf);
            i = value;
        }
        this.size -= (long) i;
        return value;
    }

    @CanIgnoreReturnValue
    public final int setCount(@ParametricNullness E e, int i) {
        CollectPreconditions.checkNonnegative(i, "count");
        ObjectCountHashMap<E> objectCountHashMap = this.backingMap;
        int remove = i == 0 ? objectCountHashMap.remove(e) : objectCountHashMap.put(e, i);
        this.size += (long) (i - remove);
        return remove;
    }

    public final int size() {
        return Ints.saturatedCast(this.size);
    }

    public final boolean setCount(@ParametricNullness E e, int i, int i2) {
        CollectPreconditions.checkNonnegative(i, "oldCount");
        CollectPreconditions.checkNonnegative(i2, "newCount");
        int indexOf = this.backingMap.indexOf(e);
        if (indexOf == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.backingMap.put(e, i2);
                this.size += (long) i2;
            }
            return true;
        } else if (this.backingMap.getValue(indexOf) != i) {
            return false;
        } else {
            if (i2 == 0) {
                this.backingMap.removeEntry(indexOf);
                this.size -= (long) i;
            } else {
                this.backingMap.setValue(indexOf, i2);
                this.size += (long) (i2 - i);
            }
            return true;
        }
    }
}
