package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.p;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.c  reason: case insensitive filesystem */
/* compiled from: AbstractProtobufList */
public abstract class C0126c<E> extends AbstractList<E> implements p.c<E> {
    public boolean a = true;

    public final void a() {
        if (!this.a) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean add(E e) {
        a();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        a();
        return super.addAll(collection);
    }

    public void clear() {
        a();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public final boolean isModifiable() {
        return this.a;
    }

    public final void makeImmutable() {
        this.a = false;
    }

    public boolean remove(Object obj) {
        a();
        return super.remove(obj);
    }

    public final boolean removeAll(Collection<?> collection) {
        a();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection<?> collection) {
        a();
        return super.retainAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        a();
        return super.addAll(i, collection);
    }
}
