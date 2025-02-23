package androidx.datastore.preferences.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: SmallSortedMap */
public class J<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public static final /* synthetic */ int d = 0;
    public volatile J<K, V>.C1058d a;

    /* renamed from: a  reason: collision with other field name */
    public List<J<K, V>.C0791b> f1914a = Collections.emptyList();

    /* renamed from: a  reason: collision with other field name */
    public Map<K, V> f1915a = Collections.emptyMap();

    /* renamed from: a  reason: collision with other field name */
    public boolean f1916a;
    public Map<K, V> b = Collections.emptyMap();
    public final int c;

    /* compiled from: SmallSortedMap */
    public static class a {
        public static final C0014a a = new C0014a();

        /* renamed from: a  reason: collision with other field name */
        public static final b f1917a = new b();

        /* renamed from: androidx.datastore.preferences.protobuf.J$a$a  reason: collision with other inner class name */
        /* compiled from: SmallSortedMap */
        public static class C0014a implements Iterator<Object> {
            public final boolean hasNext() {
                return false;
            }

            public final Object next() {
                throw new NoSuchElementException();
            }

            public final void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* compiled from: SmallSortedMap */
        public static class b implements Iterable<Object> {
            public final Iterator<Object> iterator() {
                return a.a;
            }
        }
    }

    /* compiled from: SmallSortedMap */
    public class b implements Map.Entry<K, V>, Comparable<J<K, V>.C0791b> {

        /* renamed from: a  reason: collision with other field name */
        public final K f1918a;

        /* renamed from: a  reason: collision with other field name */
        public V f1919a;

        public b() {
            throw null;
        }

        public b(K k, V v) {
            this.f1918a = k;
            this.f1919a = v;
        }

        public final int compareTo(Object obj) {
            return this.f1918a.compareTo(((b) obj).f1918a);
        }

        public final boolean equals(Object obj) {
            boolean z;
            boolean z2;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            K k = this.f1918a;
            if (k != null) {
                z = k.equals(key);
            } else if (key == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                V v = this.f1919a;
                Object value = entry.getValue();
                if (v != null) {
                    z2 = v.equals(value);
                } else if (value == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    return true;
                }
            }
            return false;
        }

        public final Object getKey() {
            return this.f1918a;
        }

        public final V getValue() {
            return this.f1919a;
        }

        public final int hashCode() {
            int i;
            int i2 = 0;
            K k = this.f1918a;
            if (k == null) {
                i = 0;
            } else {
                i = k.hashCode();
            }
            V v = this.f1919a;
            if (v != null) {
                i2 = v.hashCode();
            }
            return i2 ^ i;
        }

        public final V setValue(V v) {
            int i = J.d;
            J.this.b();
            V v2 = this.f1919a;
            this.f1919a = v;
            return v2;
        }

        public final String toString() {
            return this.f1918a + "=" + this.f1919a;
        }
    }

    /* compiled from: SmallSortedMap */
    public class c implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with other field name */
        public Iterator<Map.Entry<K, V>> f1920a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1921a;
        public int c = -1;

        public c() {
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f1920a == null) {
                this.f1920a = J.this.f1915a.entrySet().iterator();
            }
            return this.f1920a;
        }

        public final boolean hasNext() {
            int i = this.c + 1;
            J j = J.this;
            if (i < j.f1914a.size()) {
                return true;
            }
            if (j.f1915a.isEmpty() || !a().hasNext()) {
                return false;
            }
            return true;
        }

        public final Object next() {
            this.f1921a = true;
            int i = this.c + 1;
            this.c = i;
            J j = J.this;
            if (i < j.f1914a.size()) {
                return j.f1914a.get(this.c);
            }
            return (Map.Entry) a().next();
        }

        public final void remove() {
            if (this.f1921a) {
                this.f1921a = false;
                int i = J.d;
                J j = J.this;
                j.b();
                if (this.c < j.f1914a.size()) {
                    int i2 = this.c;
                    this.c = i2 - 1;
                    j.i(i2);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    /* compiled from: SmallSortedMap */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        public final boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            Object value = entry.getValue();
            J.this.put((Comparable) entry.getKey(), value);
            return true;
        }

        public final void clear() {
            J.this.clear();
        }

        public final boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = J.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 == value || (obj2 != null && obj2.equals(value))) {
                return true;
            }
            return false;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new c();
        }

        public final boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            J.this.remove(entry.getKey());
            return true;
        }

        public final int size() {
            return J.this.size();
        }
    }

    public J(int i) {
        this.c = i;
    }

    public final int a(K k) {
        int size = this.f1914a.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f1914a.get(size).f1918a);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.f1914a.get(i2).f1918a);
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public final void b() {
        if (this.f1916a) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry<K, V> c(int i) {
        return this.f1914a.get(i);
    }

    public final void clear() {
        b();
        if (!this.f1914a.isEmpty()) {
            this.f1914a.clear();
        }
        if (!this.f1915a.isEmpty()) {
            this.f1915a.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (a(comparable) >= 0 || this.f1915a.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public final int d() {
        return this.f1914a.size();
    }

    public final Iterable<Map.Entry<K, V>> e() {
        if (this.f1915a.isEmpty()) {
            return a.f1917a;
        }
        return this.f1915a.entrySet();
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.a == null) {
            this.a = new d();
        }
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof J)) {
            return super.equals(obj);
        }
        J j = (J) obj;
        int size = size();
        if (size != j.size()) {
            return false;
        }
        int d2 = d();
        if (d2 != j.d()) {
            return entrySet().equals(j.entrySet());
        }
        for (int i = 0; i < d2; i++) {
            if (!c(i).equals(j.c(i))) {
                return false;
            }
        }
        if (d2 != size) {
            return this.f1915a.equals(j.f1915a);
        }
        return true;
    }

    public final SortedMap<K, V> f() {
        b();
        if (this.f1915a.isEmpty() && !(this.f1915a instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f1915a = treeMap;
            this.b = treeMap.descendingMap();
        }
        return (SortedMap) this.f1915a;
    }

    public void g() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f1916a) {
            if (this.f1915a.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f1915a);
            }
            this.f1915a = map;
            if (this.b.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.b);
            }
            this.b = map2;
            this.f1916a = true;
        }
    }

    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f1914a.get(a2).f1919a;
        }
        return this.f1915a.get(comparable);
    }

    /* renamed from: h */
    public final V put(K k, V v) {
        b();
        int a2 = a(k);
        if (a2 >= 0) {
            return this.f1914a.get(a2).setValue(v);
        }
        b();
        boolean isEmpty = this.f1914a.isEmpty();
        int i = this.c;
        if (isEmpty && !(this.f1914a instanceof ArrayList)) {
            this.f1914a = new ArrayList(i);
        }
        int i2 = -(a2 + 1);
        if (i2 >= i) {
            return f().put(k, v);
        }
        if (this.f1914a.size() == i) {
            b remove = this.f1914a.remove(i - 1);
            f().put(remove.f1918a, remove.f1919a);
        }
        this.f1914a.add(i2, new b(k, v));
        return null;
    }

    public final int hashCode() {
        int d2 = d();
        int i = 0;
        for (int i2 = 0; i2 < d2; i2++) {
            i += this.f1914a.get(i2).hashCode();
        }
        if (this.f1915a.size() > 0) {
            return i + this.f1915a.hashCode();
        }
        return i;
    }

    public final V i(int i) {
        b();
        V v = this.f1914a.remove(i).f1919a;
        if (!this.f1915a.isEmpty()) {
            Iterator it = f().entrySet().iterator();
            List<J<K, V>.C0791b> list = this.f1914a;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new b((Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return v;
    }

    public final V remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return i(a2);
        }
        if (this.f1915a.isEmpty()) {
            return null;
        }
        return this.f1915a.remove(comparable);
    }

    public final int size() {
        return this.f1915a.size() + this.f1914a.size();
    }
}
