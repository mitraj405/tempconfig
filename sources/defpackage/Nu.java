package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: Nu  reason: default package */
/* compiled from: SafeIterableMap */
public class Nu<K, V> implements Iterable<Map.Entry<K, V>> {
    public c<K, V> a;

    /* renamed from: a  reason: collision with other field name */
    public final WeakHashMap<f<K, V>, Boolean> f453a = new WeakHashMap<>();
    public c<K, V> b;
    public int c = 0;

    /* renamed from: Nu$a */
    /* compiled from: SafeIterableMap */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        public final c<K, V> b(c<K, V> cVar) {
            return cVar.b;
        }

        public final c<K, V> c(c<K, V> cVar) {
            return cVar.a;
        }
    }

    /* renamed from: Nu$b */
    /* compiled from: SafeIterableMap */
    public static class b<K, V> extends e<K, V> {
        public b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        public final c<K, V> b(c<K, V> cVar) {
            return cVar.a;
        }

        public final c<K, V> c(c<K, V> cVar) {
            return cVar.b;
        }
    }

    /* renamed from: Nu$c */
    /* compiled from: SafeIterableMap */
    public static class c<K, V> implements Map.Entry<K, V> {
        public c<K, V> a;

        /* renamed from: a  reason: collision with other field name */
        public final K f454a;
        public c<K, V> b;

        /* renamed from: b  reason: collision with other field name */
        public final V f455b;

        public c(K k, V v) {
            this.f454a = k;
            this.f455b = v;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f454a.equals(cVar.f454a) || !this.f455b.equals(cVar.f455b)) {
                return false;
            }
            return true;
        }

        public final K getKey() {
            return this.f454a;
        }

        public final V getValue() {
            return this.f455b;
        }

        public final int hashCode() {
            return this.f454a.hashCode() ^ this.f455b.hashCode();
        }

        public final V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.f454a + "=" + this.f455b;
        }
    }

    /* renamed from: Nu$d */
    /* compiled from: SafeIterableMap */
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {
        public c<K, V> a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f457a = true;

        public d() {
        }

        public final void a(c<K, V> cVar) {
            boolean z;
            c<K, V> cVar2 = this.a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.b;
                this.a = cVar3;
                if (cVar3 == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.f457a = z;
            }
        }

        public final boolean hasNext() {
            if (!this.f457a) {
                c<K, V> cVar = this.a;
                if (cVar == null || cVar.a == null) {
                    return false;
                }
                return true;
            } else if (Nu.this.a != null) {
                return true;
            } else {
                return false;
            }
        }

        public final Object next() {
            c<K, V> cVar;
            if (this.f457a) {
                this.f457a = false;
                this.a = Nu.this.a;
            } else {
                c<K, V> cVar2 = this.a;
                if (cVar2 != null) {
                    cVar = cVar2.a;
                } else {
                    cVar = null;
                }
                this.a = cVar;
            }
            return this.a;
        }
    }

    /* renamed from: Nu$e */
    /* compiled from: SafeIterableMap */
    public static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {
        public c<K, V> a;
        public c<K, V> b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.a = cVar2;
            this.b = cVar;
        }

        public final void a(c<K, V> cVar) {
            c<K, V> cVar2 = null;
            if (this.a == cVar && cVar == this.b) {
                this.b = null;
                this.a = null;
            }
            c<K, V> cVar3 = this.a;
            if (cVar3 == cVar) {
                this.a = b(cVar3);
            }
            c<K, V> cVar4 = this.b;
            if (cVar4 == cVar) {
                c<K, V> cVar5 = this.a;
                if (!(cVar4 == cVar5 || cVar5 == null)) {
                    cVar2 = c(cVar4);
                }
                this.b = cVar2;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        public final boolean hasNext() {
            if (this.b != null) {
                return true;
            }
            return false;
        }

        public final Object next() {
            c<K, V> cVar;
            c<K, V> cVar2 = this.b;
            c<K, V> cVar3 = this.a;
            if (cVar2 == cVar3 || cVar3 == null) {
                cVar = null;
            } else {
                cVar = c(cVar2);
            }
            this.b = cVar;
            return cVar2;
        }
    }

    /* renamed from: Nu$f */
    /* compiled from: SafeIterableMap */
    public static abstract class f<K, V> {
        public abstract void a(c<K, V> cVar);
    }

    public c<K, V> a(K k) {
        c<K, V> cVar = this.a;
        while (cVar != null && !cVar.f454a.equals(k)) {
            cVar = cVar.a;
        }
        return cVar;
    }

    public V b(K k, V v) {
        c a2 = a(k);
        if (a2 != null) {
            return a2.f455b;
        }
        c<K, V> cVar = new c<>(k, v);
        this.c++;
        c<K, V> cVar2 = this.b;
        if (cVar2 == null) {
            this.a = cVar;
            this.b = cVar;
            return null;
        }
        cVar2.a = cVar;
        cVar.b = cVar2;
        this.b = cVar;
        return null;
    }

    public V c(K k) {
        c a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.c--;
        WeakHashMap<f<K, V>, Boolean> weakHashMap = this.f453a;
        if (!weakHashMap.isEmpty()) {
            for (f<K, V> a3 : weakHashMap.keySet()) {
                a3.a(a2);
            }
        }
        c<K, V> cVar = a2.b;
        if (cVar != null) {
            cVar.a = a2.a;
        } else {
            this.a = a2.a;
        }
        c<K, V> cVar2 = a2.a;
        if (cVar2 != null) {
            cVar2.b = cVar;
        } else {
            this.b = cVar;
        }
        a2.a = null;
        a2.b = null;
        return a2.f455b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r3.hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (((defpackage.Nu.e) r7).hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof defpackage.Nu
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            Nu r7 = (defpackage.Nu) r7
            int r1 = r6.c
            int r3 = r7.c
            if (r1 == r3) goto L_0x0013
            return r2
        L_0x0013:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L_0x001b:
            r3 = r1
            Nu$e r3 = (defpackage.Nu.e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0044
            r4 = r7
            Nu$e r4 = (defpackage.Nu.e) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0044
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L_0x003b
            if (r4 != 0) goto L_0x0043
        L_0x003b:
            if (r3 == 0) goto L_0x001b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x001b
        L_0x0043:
            return r2
        L_0x0044:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L_0x0053
            Nu$e r7 = (defpackage.Nu.e) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r0 = r2
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Nu.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return i;
            }
            i += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.a, this.b);
        this.f453a.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                sb.append(((Map.Entry) eVar.next()).toString());
                if (eVar.hasNext()) {
                    sb.append(", ");
                }
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
