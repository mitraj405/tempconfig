package androidx.collection;

import defpackage.C0282nk;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
    public static final int[] b = new int[0];

    /* renamed from: b  reason: collision with other field name */
    public static final Object[] f1318b = new Object[0];
    public static Object[] c;
    public static int d;

    /* renamed from: d  reason: collision with other field name */
    public static Object[] f1319d;
    public static int e;
    public M1 a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f1320a;

    /* renamed from: a  reason: collision with other field name */
    public Object[] f1321a;

    /* renamed from: c  reason: collision with other field name */
    public int f1322c;

    public ArraySet() {
        this(0);
    }

    public static void b(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (e < 10) {
                    objArr[0] = f1319d;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1319d = objArr;
                    e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (d < 10) {
                    objArr[0] = c;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    c = objArr;
                    d++;
                }
            }
        }
    }

    public final void a(int i) {
        if (i == 8) {
            synchronized (ArraySet.class) {
                Object[] objArr = f1319d;
                if (objArr != null) {
                    this.f1321a = objArr;
                    f1319d = (Object[]) objArr[0];
                    this.f1320a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                Object[] objArr2 = c;
                if (objArr2 != null) {
                    this.f1321a = objArr2;
                    c = (Object[]) objArr2[0];
                    this.f1320a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    d--;
                    return;
                }
            }
        }
        this.f1320a = new int[i];
        this.f1321a = new Object[i];
    }

    public final boolean add(E e2) {
        int i;
        int i2;
        if (e2 == null) {
            i2 = d();
            i = 0;
        } else {
            int hashCode = e2.hashCode();
            i = hashCode;
            i2 = c(hashCode, e2);
        }
        if (i2 >= 0) {
            return false;
        }
        int i3 = ~i2;
        int i4 = this.f1322c;
        int[] iArr = this.f1320a;
        if (i4 >= iArr.length) {
            int i5 = 8;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i5 = 4;
            }
            Object[] objArr = this.f1321a;
            a(i5);
            int[] iArr2 = this.f1320a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1321a, 0, objArr.length);
            }
            b(iArr, objArr, this.f1322c);
        }
        int i6 = this.f1322c;
        if (i3 < i6) {
            int[] iArr3 = this.f1320a;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f1321a;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f1322c - i3);
        }
        this.f1320a[i3] = i;
        this.f1321a[i3] = e2;
        this.f1322c++;
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.f1322c;
        int[] iArr = this.f1320a;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.f1321a;
            a(size);
            int i = this.f1322c;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f1320a, 0, i);
                System.arraycopy(objArr, 0, this.f1321a, 0, this.f1322c);
            }
            b(iArr, objArr, this.f1322c);
        }
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public final int c(int i, Object obj) {
        int i2 = this.f1322c;
        if (i2 == 0) {
            return -1;
        }
        int j = C1354qp.j(i2, i, this.f1320a);
        if (j < 0 || obj.equals(this.f1321a[j])) {
            return j;
        }
        int i3 = j + 1;
        while (i3 < i2 && this.f1320a[i3] == i) {
            if (obj.equals(this.f1321a[i3])) {
                return i3;
            }
            i3++;
        }
        int i4 = j - 1;
        while (i4 >= 0 && this.f1320a[i4] == i) {
            if (obj.equals(this.f1321a[i4])) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public final void clear() {
        int i = this.f1322c;
        if (i != 0) {
            b(this.f1320a, this.f1321a, i);
            this.f1320a = b;
            this.f1321a = f1318b;
            this.f1322c = 0;
        }
    }

    public final boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
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

    public final int d() {
        int i = this.f1322c;
        if (i == 0) {
            return -1;
        }
        int j = C1354qp.j(i, 0, this.f1320a);
        if (j < 0 || this.f1321a[j] == null) {
            return j;
        }
        int i2 = j + 1;
        while (i2 < i && this.f1320a[i2] == 0) {
            if (this.f1321a[i2] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = j - 1;
        while (i3 >= 0 && this.f1320a[i3] == 0) {
            if (this.f1321a[i3] == null) {
                return i3;
            }
            i3--;
        }
        return ~i2;
    }

    public final void e(int i) {
        Object[] objArr = this.f1321a;
        Object obj = objArr[i];
        int i2 = this.f1322c;
        if (i2 <= 1) {
            b(this.f1320a, objArr, i2);
            this.f1320a = b;
            this.f1321a = f1318b;
            this.f1322c = 0;
            return;
        }
        int[] iArr = this.f1320a;
        int i3 = 8;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            int i4 = i2 - 1;
            this.f1322c = i4;
            if (i < i4) {
                int i5 = i + 1;
                System.arraycopy(iArr, i5, iArr, i, i4 - i);
                Object[] objArr2 = this.f1321a;
                System.arraycopy(objArr2, i5, objArr2, i, this.f1322c - i);
            }
            this.f1321a[this.f1322c] = null;
            return;
        }
        if (i2 > 8) {
            i3 = i2 + (i2 >> 1);
        }
        a(i3);
        this.f1322c--;
        if (i > 0) {
            System.arraycopy(iArr, 0, this.f1320a, 0, i);
            System.arraycopy(objArr, 0, this.f1321a, 0, i);
        }
        int i6 = this.f1322c;
        if (i < i6) {
            int i7 = i + 1;
            System.arraycopy(iArr, i7, this.f1320a, i, i6 - i);
            System.arraycopy(objArr, i7, this.f1321a, i, this.f1322c - i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f1322c != set.size()) {
                return false;
            }
            int i = 0;
            while (i < this.f1322c) {
                try {
                    if (!set.contains(this.f1321a[i])) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int[] iArr = this.f1320a;
        int i = this.f1322c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (obj == null) {
            return d();
        }
        return c(obj.hashCode(), obj);
    }

    public final boolean isEmpty() {
        if (this.f1322c <= 0) {
            return true;
        }
        return false;
    }

    public final Iterator<E> iterator() {
        if (this.a == null) {
            this.a = new M1(this);
        }
        M1 m1 = this.a;
        if (m1.f3113a == null) {
            m1.f3113a = new C0282nk.c();
        }
        return m1.f3113a.iterator();
    }

    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        e(indexOf);
        return true;
    }

    public final boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public final boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f1322c - 1; i >= 0; i--) {
            if (!collection.contains(this.f1321a[i])) {
                e(i);
                z = true;
            }
        }
        return z;
    }

    public final int size() {
        return this.f1322c;
    }

    public final Object[] toArray() {
        int i = this.f1322c;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f1321a, 0, objArr, 0, i);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1322c * 14);
        sb.append('{');
        for (int i = 0; i < this.f1322c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object obj = this.f1321a[i];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public ArraySet(int i) {
        if (i == 0) {
            this.f1320a = b;
            this.f1321a = f1318b;
        } else {
            a(i);
        }
        this.f1322c = 0;
    }

    public final <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1322c) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1322c);
        }
        System.arraycopy(this.f1321a, 0, tArr, 0, this.f1322c);
        int length = tArr.length;
        int i = this.f1322c;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }
}
