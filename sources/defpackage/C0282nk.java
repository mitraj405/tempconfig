package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: nk  reason: default package and case insensitive filesystem */
/* compiled from: MapCollections */
public abstract class C0282nk<K, V> {
    public C0282nk<K, V>.C0791b a;

    /* renamed from: a  reason: collision with other field name */
    public C0282nk<K, V>.C0811c f3113a;

    /* renamed from: a  reason: collision with other field name */
    public C0282nk<K, V>.C1079e f3114a;

    /* renamed from: nk$a */
    /* compiled from: MapCollections */
    public final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with other field name */
        public boolean f3115a = false;
        public final int c;
        public int d;
        public int e;

        public a(int i) {
            this.c = i;
            this.d = C0282nk.this.d();
        }

        public final boolean hasNext() {
            if (this.e < this.d) {
                return true;
            }
            return false;
        }

        public final T next() {
            if (hasNext()) {
                T b = C0282nk.this.b(this.e, this.c);
                this.e++;
                this.f3115a = true;
                return b;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            if (this.f3115a) {
                int i = this.e - 1;
                this.e = i;
                this.d--;
                this.f3115a = false;
                C0282nk.this.h(i);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: nk$b */
    /* compiled from: MapCollections */
    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
        }

        public final boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            C0282nk nkVar = C0282nk.this;
            int d = nkVar.d();
            for (Map.Entry entry : collection) {
                nkVar.g(entry.getKey(), entry.getValue());
            }
            if (d != nkVar.d()) {
                return true;
            }
            return false;
        }

        public final void clear() {
            C0282nk.this.a();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
            r5 = (java.util.Map.Entry) r5;
            r0 = r5.getKey();
            r2 = r4.a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean contains(java.lang.Object r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                java.lang.Object r0 = r5.getKey()
                nk r2 = defpackage.C0282nk.this
                int r0 = r2.e(r0)
                if (r0 >= 0) goto L_0x0015
                return r1
            L_0x0015:
                r3 = 1
                java.lang.Object r0 = r2.b(r0, r3)
                java.lang.Object r5 = r5.getValue()
                if (r0 == r5) goto L_0x0028
                if (r0 == 0) goto L_0x0029
                boolean r5 = r0.equals(r5)
                if (r5 == 0) goto L_0x0029
            L_0x0028:
                r1 = r3
            L_0x0029:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C0282nk.b.contains(java.lang.Object):boolean");
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean equals(Object obj) {
            return C0282nk.j(this, obj);
        }

        public final int hashCode() {
            int i;
            int i2;
            C0282nk nkVar = C0282nk.this;
            int i3 = 0;
            for (int d = nkVar.d() - 1; d >= 0; d--) {
                Object b = nkVar.b(d, 0);
                Object b2 = nkVar.b(d, 1);
                if (b == null) {
                    i = 0;
                } else {
                    i = b.hashCode();
                }
                if (b2 == null) {
                    i2 = 0;
                } else {
                    i2 = b2.hashCode();
                }
                i3 += i ^ i2;
            }
            return i3;
        }

        public final boolean isEmpty() {
            if (C0282nk.this.d() == 0) {
                return true;
            }
            return false;
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return C0282nk.this.d();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: nk$c */
    /* compiled from: MapCollections */
    public final class c implements Set<K> {
        public c() {
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            C0282nk.this.a();
        }

        public final boolean contains(Object obj) {
            if (C0282nk.this.e(obj) >= 0) {
                return true;
            }
            return false;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map c = C0282nk.this.c();
            for (Object containsKey : collection) {
                if (!c.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean equals(Object obj) {
            return C0282nk.j(this, obj);
        }

        public final int hashCode() {
            int i;
            C0282nk nkVar = C0282nk.this;
            int i2 = 0;
            for (int d = nkVar.d() - 1; d >= 0; d--) {
                Object b = nkVar.b(d, 0);
                if (b == null) {
                    i = 0;
                } else {
                    i = b.hashCode();
                }
                i2 += i;
            }
            return i2;
        }

        public final boolean isEmpty() {
            if (C0282nk.this.d() == 0) {
                return true;
            }
            return false;
        }

        public final Iterator<K> iterator() {
            return new a(0);
        }

        public final boolean remove(Object obj) {
            C0282nk nkVar = C0282nk.this;
            int e = nkVar.e(obj);
            if (e < 0) {
                return false;
            }
            nkVar.h(e);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map c = C0282nk.this.c();
            int size = c.size();
            for (Object remove : collection) {
                c.remove(remove);
            }
            if (size != c.size()) {
                return true;
            }
            return false;
        }

        public final boolean retainAll(Collection<?> collection) {
            return C0282nk.k(C0282nk.this.c(), collection);
        }

        public final int size() {
            return C0282nk.this.d();
        }

        public final <T> T[] toArray(T[] tArr) {
            return C0282nk.this.l(tArr, 0);
        }

        public final Object[] toArray() {
            C0282nk nkVar = C0282nk.this;
            int d = nkVar.d();
            Object[] objArr = new Object[d];
            for (int i = 0; i < d; i++) {
                objArr[i] = nkVar.b(i, 0);
            }
            return objArr;
        }
    }

    /* renamed from: nk$d */
    /* compiled from: MapCollections */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with other field name */
        public boolean f3116a = false;
        public int c;
        public int d;

        public d() {
            this.c = C0282nk.this.d() - 1;
            this.d = -1;
        }

        public final boolean equals(Object obj) {
            boolean z;
            boolean z2;
            if (!this.f3116a) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                int i = this.d;
                C0282nk nkVar = C0282nk.this;
                Object b = nkVar.b(i, 0);
                if (key == b || (key != null && key.equals(b))) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return false;
                }
                Object value = entry.getValue();
                Object b2 = nkVar.b(this.d, 1);
                if (value == b2 || (value != null && value.equals(b2))) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    return true;
                }
                return false;
            }
        }

        public final K getKey() {
            if (this.f3116a) {
                return C0282nk.this.b(this.d, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.f3116a) {
                return C0282nk.this.b(this.d, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean hasNext() {
            if (this.d < this.c) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i;
            if (this.f3116a) {
                int i2 = this.d;
                C0282nk nkVar = C0282nk.this;
                int i3 = 0;
                Object b = nkVar.b(i2, 0);
                Object b2 = nkVar.b(this.d, 1);
                if (b == null) {
                    i = 0;
                } else {
                    i = b.hashCode();
                }
                if (b2 != null) {
                    i3 = b2.hashCode();
                }
                return i ^ i3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final Object next() {
            if (hasNext()) {
                this.d++;
                this.f3116a = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            if (this.f3116a) {
                C0282nk.this.h(this.d);
                this.d--;
                this.c--;
                this.f3116a = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final V setValue(V v) {
            if (this.f3116a) {
                return C0282nk.this.i(this.d, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: nk$e */
    /* compiled from: MapCollections */
    public final class e implements Collection<V> {
        public e() {
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            C0282nk.this.a();
        }

        public final boolean contains(Object obj) {
            if (C0282nk.this.f(obj) >= 0) {
                return true;
            }
            return false;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            if (C0282nk.this.d() == 0) {
                return true;
            }
            return false;
        }

        public final Iterator<V> iterator() {
            return new a(1);
        }

        public final boolean remove(Object obj) {
            C0282nk nkVar = C0282nk.this;
            int f = nkVar.f(obj);
            if (f < 0) {
                return false;
            }
            nkVar.h(f);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            C0282nk nkVar = C0282nk.this;
            int d = nkVar.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (collection.contains(nkVar.b(i, 1))) {
                    nkVar.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            C0282nk nkVar = C0282nk.this;
            int d = nkVar.d();
            int i = 0;
            boolean z = false;
            while (i < d) {
                if (!collection.contains(nkVar.b(i, 1))) {
                    nkVar.h(i);
                    i--;
                    d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return C0282nk.this.d();
        }

        public final <T> T[] toArray(T[] tArr) {
            return C0282nk.this.l(tArr, 1);
        }

        public final Object[] toArray() {
            C0282nk nkVar = C0282nk.this;
            int d = nkVar.d();
            Object[] objArr = new Object[d];
            for (int i = 0; i < d; i++) {
                objArr[i] = nkVar.b(i, 1);
            }
            return objArr;
        }
    }

    public static <T> boolean j(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean k(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public abstract void a();

    public abstract Object b(int i, int i2);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k, V v);

    public abstract void h(int i);

    public abstract V i(int i, V v);

    public final <T> T[] l(T[] tArr, int i) {
        int d2 = d();
        if (tArr.length < d2) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), d2);
        }
        for (int i2 = 0; i2 < d2; i2++) {
            tArr[i2] = b(i2, i);
        }
        if (tArr.length > d2) {
            tArr[d2] = null;
        }
        return tArr;
    }
}
