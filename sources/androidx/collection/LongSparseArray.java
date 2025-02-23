package androidx.collection;

public final class LongSparseArray<E> implements Cloneable {
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public boolean f1324a;

    /* renamed from: a  reason: collision with other field name */
    public long[] f1325a;

    /* renamed from: a  reason: collision with other field name */
    public Object[] f1326a;
    public int c;

    public LongSparseArray() {
        this(10);
    }

    public final void a() {
        int i = this.c;
        Object[] objArr = this.f1326a;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.c = 0;
        this.f1324a = false;
    }

    /* renamed from: b */
    public final LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.f1325a = (long[]) this.f1325a.clone();
            longSparseArray.f1326a = (Object[]) this.f1326a.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void c() {
        int i = this.c;
        long[] jArr = this.f1325a;
        Object[] objArr = this.f1326a;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1324a = false;
        this.c = i2;
    }

    public final Object d(long j, Long l) {
        Object obj;
        int k = C1354qp.k(this.c, j, this.f1325a);
        if (k < 0 || (obj = this.f1326a[k]) == a) {
            return l;
        }
        return obj;
    }

    public final void e(long j, E e) {
        int k = C1354qp.k(this.c, j, this.f1325a);
        if (k >= 0) {
            this.f1326a[k] = e;
            return;
        }
        int i = ~k;
        int i2 = this.c;
        if (i < i2) {
            Object[] objArr = this.f1326a;
            if (objArr[i] == a) {
                this.f1325a[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f1324a && i2 >= this.f1325a.length) {
            c();
            i = ~C1354qp.k(this.c, j, this.f1325a);
        }
        int i3 = this.c;
        if (i3 >= this.f1325a.length) {
            int i4 = (i3 + 1) * 8;
            int i5 = 4;
            while (true) {
                if (i5 >= 32) {
                    break;
                }
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
                i5++;
            }
            int i7 = i4 / 8;
            long[] jArr = new long[i7];
            Object[] objArr2 = new Object[i7];
            long[] jArr2 = this.f1325a;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1326a;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1325a = jArr;
            this.f1326a = objArr2;
        }
        int i8 = this.c - i;
        if (i8 != 0) {
            long[] jArr3 = this.f1325a;
            int i9 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i9, i8);
            Object[] objArr4 = this.f1326a;
            System.arraycopy(objArr4, i, objArr4, i9, this.c - i);
        }
        this.f1325a[i] = j;
        this.f1326a[i] = e;
        this.c++;
    }

    public final int f() {
        if (this.f1324a) {
            c();
        }
        return this.c;
    }

    public final E g(int i) {
        if (this.f1324a) {
            c();
        }
        return this.f1326a[i];
    }

    public final String toString() {
        if (f() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append('{');
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (this.f1324a) {
                c();
            }
            sb.append(this.f1325a[i]);
            sb.append('=');
            Object g = g(i);
            if (g != this) {
                sb.append(g);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public LongSparseArray(int i) {
        this.f1324a = false;
        if (i == 0) {
            this.f1325a = C1354qp.f6919a;
            this.f1326a = C1354qp.f6924b;
            return;
        }
        int i2 = i * 8;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 8;
        this.f1325a = new long[i5];
        this.f1326a = new Object[i5];
    }
}
