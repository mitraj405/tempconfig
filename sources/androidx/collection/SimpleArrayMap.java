package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V> {
    public static Object[] b;
    public static Object[] c;
    public static int d;
    public static int e;
    public int[] a;

    /* renamed from: a  reason: collision with other field name */
    public Object[] f1327a;

    /* renamed from: c  reason: collision with other field name */
    public int f1328c;

    public SimpleArrayMap() {
        this.a = C1354qp.f6918a;
        this.f1327a = C1354qp.f6924b;
        this.f1328c = 0;
    }

    private void a(int i) {
        if (i == 8) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr = c;
                if (objArr != null) {
                    this.f1327a = objArr;
                    c = (Object[]) objArr[0];
                    this.a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr2 = b;
                if (objArr2 != null) {
                    this.f1327a = objArr2;
                    b = (Object[]) objArr2[0];
                    this.a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    d--;
                    return;
                }
            }
        }
        this.a = new int[i];
        this.f1327a = new Object[(i << 1)];
    }

    public static void c(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (e < 10) {
                    objArr[0] = c;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    c = objArr;
                    e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                if (d < 10) {
                    objArr[0] = b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    b = objArr;
                    d++;
                }
            }
        }
    }

    public final void b(int i) {
        int i2 = this.f1328c;
        int[] iArr = this.a;
        if (iArr.length < i) {
            Object[] objArr = this.f1327a;
            a(i);
            if (this.f1328c > 0) {
                System.arraycopy(iArr, 0, this.a, 0, i2);
                System.arraycopy(objArr, 0, this.f1327a, 0, i2 << 1);
            }
            c(iArr, objArr, i2);
        }
        if (this.f1328c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public final void clear() {
        int i = this.f1328c;
        if (i > 0) {
            int[] iArr = this.a;
            Object[] objArr = this.f1327a;
            this.a = C1354qp.f6918a;
            this.f1327a = C1354qp.f6924b;
            this.f1328c = 0;
            c(iArr, objArr, i);
        }
        if (this.f1328c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        if (e(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsValue(Object obj) {
        if (g(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final int d(int i, Object obj) {
        int i2 = this.f1328c;
        if (i2 == 0) {
            return -1;
        }
        try {
            int j = C1354qp.j(i2, i, this.a);
            if (j < 0 || obj.equals(this.f1327a[j << 1])) {
                return j;
            }
            int i3 = j + 1;
            while (i3 < i2 && this.a[i3] == i) {
                if (obj.equals(this.f1327a[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            int i4 = j - 1;
            while (i4 >= 0 && this.a[i4] == i) {
                if (obj.equals(this.f1327a[i4 << 1])) {
                    return i4;
                }
                i4--;
            }
            return ~i3;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(Object obj) {
        if (obj == null) {
            return f();
        }
        return d(obj.hashCode(), obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            int i = 0;
            while (i < this.f1328c) {
                try {
                    Object h = h(i);
                    Object j = j(i);
                    Object obj2 = simpleArrayMap.get(h);
                    if (j == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(h)) {
                            return false;
                        }
                    } else if (!j.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f1328c) {
                try {
                    Object h2 = h(i2);
                    Object j2 = j(i2);
                    Object obj3 = map.get(h2);
                    if (j2 == null) {
                        if (obj3 != null || !map.containsKey(h2)) {
                            return false;
                        }
                    } else if (!j2.equals(obj3)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i = this.f1328c;
        if (i == 0) {
            return -1;
        }
        try {
            int j = C1354qp.j(i, 0, this.a);
            if (j < 0 || this.f1327a[j << 1] == null) {
                return j;
            }
            int i2 = j + 1;
            while (i2 < i && this.a[i2] == 0) {
                if (this.f1327a[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            int i3 = j - 1;
            while (i3 >= 0 && this.a[i3] == 0) {
                if (this.f1327a[i3 << 1] == null) {
                    return i3;
                }
                i3--;
            }
            return ~i2;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* access modifiers changed from: package-private */
    public final int g(Object obj) {
        int i = this.f1328c * 2;
        Object[] objArr = this.f1327a;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public final V getOrDefault(Object obj, V v) {
        int e2 = e(obj);
        if (e2 >= 0) {
            return this.f1327a[(e2 << 1) + 1];
        }
        return v;
    }

    public final K h(int i) {
        return this.f1327a[i << 1];
    }

    public final int hashCode() {
        int i;
        int[] iArr = this.a;
        Object[] objArr = this.f1327a;
        int i2 = this.f1328c;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            int i6 = iArr[i4];
            if (obj == null) {
                i = 0;
            } else {
                i = obj.hashCode();
            }
            i5 += i ^ i6;
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public final V i(int i) {
        V[] vArr = this.f1327a;
        int i2 = i << 1;
        V v = vArr[i2 + 1];
        int i3 = this.f1328c;
        int i4 = 0;
        if (i3 <= 1) {
            c(this.a, vArr, i3);
            this.a = C1354qp.f6918a;
            this.f1327a = C1354qp.f6924b;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.a;
            int i6 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(iArr, i7, iArr, i, i8);
                    Object[] objArr = this.f1327a;
                    System.arraycopy(objArr, i7 << 1, objArr, i2, i8 << 1);
                }
                Object[] objArr2 = this.f1327a;
                int i9 = i5 << 1;
                objArr2[i9] = null;
                objArr2[i9 + 1] = null;
            } else {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                a(i6);
                if (i3 == this.f1328c) {
                    if (i > 0) {
                        System.arraycopy(iArr, 0, this.a, 0, i);
                        System.arraycopy(vArr, 0, this.f1327a, 0, i2);
                    }
                    if (i < i5) {
                        int i10 = i + 1;
                        int i11 = i5 - i;
                        System.arraycopy(iArr, i10, this.a, i, i11);
                        System.arraycopy(vArr, i10 << 1, this.f1327a, i2, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i4 = i5;
        }
        if (i3 == this.f1328c) {
            this.f1328c = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public final boolean isEmpty() {
        if (this.f1328c <= 0) {
            return true;
        }
        return false;
    }

    public final V j(int i) {
        return this.f1327a[(i << 1) + 1];
    }

    public final V put(K k, V v) {
        int i;
        int i2;
        int i3 = this.f1328c;
        if (k == null) {
            i2 = f();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            i2 = d(hashCode, k);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V[] vArr = this.f1327a;
            V v2 = vArr[i4];
            vArr[i4] = v;
            return v2;
        }
        int i5 = ~i2;
        int[] iArr = this.a;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            Object[] objArr = this.f1327a;
            a(i6);
            if (i3 == this.f1328c) {
                int[] iArr2 = this.a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f1327a, 0, objArr.length);
                }
                c(iArr, objArr, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr3 = this.a;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr2 = this.f1327a;
            System.arraycopy(objArr2, i5 << 1, objArr2, i7 << 1, (this.f1328c - i5) << 1);
        }
        int i8 = this.f1328c;
        if (i3 == i8) {
            int[] iArr4 = this.a;
            if (i5 < iArr4.length) {
                iArr4[i5] = i;
                Object[] objArr3 = this.f1327a;
                int i9 = i5 << 1;
                objArr3[i9] = k;
                objArr3[i9 + 1] = v;
                this.f1328c = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final V putIfAbsent(K k, V v) {
        V v2 = get(k);
        if (v2 == null) {
            return put(k, v);
        }
        return v2;
    }

    public final V remove(Object obj) {
        int e2 = e(obj);
        if (e2 >= 0) {
            return i(e2);
        }
        return null;
    }

    public final V replace(K k, V v) {
        int e2 = e(k);
        if (e2 < 0) {
            return null;
        }
        int i = (e2 << 1) + 1;
        V[] vArr = this.f1327a;
        V v2 = vArr[i];
        vArr[i] = v;
        return v2;
    }

    public final int size() {
        return this.f1328c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1328c * 28);
        sb.append('{');
        for (int i = 0; i < this.f1328c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object h = h(i);
            if (h != this) {
                sb.append(h);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object j = j(i);
            if (j != this) {
                sb.append(j);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean remove(Object obj, Object obj2) {
        int e2 = e(obj);
        if (e2 < 0) {
            return false;
        }
        Object j = j(e2);
        if (obj2 != j && (obj2 == null || !obj2.equals(j))) {
            return false;
        }
        i(e2);
        return true;
    }

    public final boolean replace(K k, V v, V v2) {
        int e2 = e(k);
        if (e2 < 0) {
            return false;
        }
        V j = j(e2);
        if (j != v && (v == null || !v.equals(j))) {
            return false;
        }
        int i = (e2 << 1) + 1;
        Object[] objArr = this.f1327a;
        Object obj = objArr[i];
        objArr[i] = v2;
        return true;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.a = C1354qp.f6918a;
            this.f1327a = C1354qp.f6924b;
        } else {
            a(i);
        }
        this.f1328c = 0;
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            int i = simpleArrayMap.f1328c;
            b(this.f1328c + i);
            if (this.f1328c != 0) {
                for (int i2 = 0; i2 < i; i2++) {
                    put(simpleArrayMap.h(i2), simpleArrayMap.j(i2));
                }
            } else if (i > 0) {
                System.arraycopy(simpleArrayMap.a, 0, this.a, 0, i);
                System.arraycopy(simpleArrayMap.f1327a, 0, this.f1327a, 0, i << 1);
                this.f1328c = i;
            }
        }
    }
}
