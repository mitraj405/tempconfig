package androidx.collection;

public final class SparseArrayCompat<E> implements Cloneable {
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public int[] f1329a;

    /* renamed from: a  reason: collision with other field name */
    public Object[] f1330a;
    public int c;

    public SparseArrayCompat() {
        int i;
        int i2 = 4;
        while (true) {
            i = 40;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (40 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 4;
        this.f1329a = new int[i4];
        this.f1330a = new Object[i4];
    }

    public final void a(int i, E e) {
        int i2 = this.c;
        if (i2 == 0 || i > this.f1329a[i2 - 1]) {
            if (i2 >= this.f1329a.length) {
                int i3 = (i2 + 1) * 4;
                int i4 = 4;
                while (true) {
                    if (i4 >= 32) {
                        break;
                    }
                    int i5 = (1 << i4) - 12;
                    if (i3 <= i5) {
                        i3 = i5;
                        break;
                    }
                    i4++;
                }
                int i6 = i3 / 4;
                int[] iArr = new int[i6];
                Object[] objArr = new Object[i6];
                int[] iArr2 = this.f1329a;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f1330a;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1329a = iArr;
                this.f1330a = objArr;
            }
            this.f1329a[i2] = i;
            this.f1330a[i2] = e;
            this.c = i2 + 1;
            return;
        }
        d(i, e);
    }

    /* renamed from: b */
    public final SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.f1329a = (int[]) this.f1329a.clone();
            sparseArrayCompat.f1330a = (Object[]) this.f1330a.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final Object c(int i, Integer num) {
        Object obj;
        int j = C1354qp.j(this.c, i, this.f1329a);
        if (j < 0 || (obj = this.f1330a[j]) == a) {
            return num;
        }
        return obj;
    }

    public final void d(int i, E e) {
        int j = C1354qp.j(this.c, i, this.f1329a);
        if (j >= 0) {
            this.f1330a[j] = e;
            return;
        }
        int i2 = ~j;
        int i3 = this.c;
        if (i2 < i3) {
            Object[] objArr = this.f1330a;
            if (objArr[i2] == a) {
                this.f1329a[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (i3 >= this.f1329a.length) {
            int i4 = (i3 + 1) * 4;
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
            int i7 = i4 / 4;
            int[] iArr = new int[i7];
            Object[] objArr2 = new Object[i7];
            int[] iArr2 = this.f1329a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1330a;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1329a = iArr;
            this.f1330a = objArr2;
        }
        int i8 = this.c - i2;
        if (i8 != 0) {
            int[] iArr3 = this.f1329a;
            int i9 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i9, i8);
            Object[] objArr4 = this.f1330a;
            System.arraycopy(objArr4, i2, objArr4, i9, this.c - i2);
        }
        this.f1329a[i2] = i;
        this.f1330a[i2] = e;
        this.c++;
    }

    public final int e() {
        return this.c;
    }

    public final String toString() {
        int i = this.c;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(this.f1329a[i2]);
            sb.append('=');
            Object obj = this.f1330a[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
