package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.p;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.h  reason: case insensitive filesystem */
/* compiled from: DoubleArrayList */
public final class C0131h extends C0126c<Double> implements RandomAccess, qq {
    public double[] a;
    public int c;

    static {
        new C0131h(new double[0], 0).a = false;
    }

    public C0131h() {
        this(new double[10], 0);
    }

    public final void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        a();
        if (i < 0 || i > (i2 = this.c)) {
            StringBuilder m = lf.m("Index:", i, ", Size:");
            m.append(this.c);
            throw new IndexOutOfBoundsException(m.toString());
        }
        double[] dArr = this.a;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[C1058d.L(i2, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.a, i, dArr2, i + 1, this.c - i);
            this.a = dArr2;
        }
        this.a[i] = doubleValue;
        this.c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        a();
        Charset charset = p.a;
        collection.getClass();
        if (!(collection instanceof C0131h)) {
            return super.addAll(collection);
        }
        C0131h hVar = (C0131h) collection;
        int i = hVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.a;
            if (i3 > dArr.length) {
                this.a = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(hVar.a, 0, this.a, this.c, hVar.c);
            this.c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addDouble(double d) {
        a();
        int i = this.c;
        double[] dArr = this.a;
        if (i == dArr.length) {
            double[] dArr2 = new double[C1058d.L(i, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.a = dArr2;
        }
        double[] dArr3 = this.a;
        int i2 = this.c;
        this.c = i2 + 1;
        dArr3[i2] = d;
    }

    public final void b(int i) {
        if (i < 0 || i >= this.c) {
            StringBuilder m = lf.m("Index:", i, ", Size:");
            m.append(this.c);
            throw new IndexOutOfBoundsException(m.toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0131h)) {
            return super.equals(obj);
        }
        C0131h hVar = (C0131h) obj;
        if (this.c != hVar.c) {
            return false;
        }
        double[] dArr = hVar.a;
        for (int i = 0; i < this.c; i++) {
            if (Double.doubleToLongBits(this.a[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final Object get(int i) {
        b(i);
        return Double.valueOf(this.a[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + p.a(Double.doubleToLongBits(this.a[i2]));
        }
        return i;
    }

    public final p.c l(int i) {
        if (i >= this.c) {
            return new C0131h(Arrays.copyOf(this.a, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Double.valueOf(this.a[i]))) {
                double[] dArr = this.a;
                System.arraycopy(dArr, i + 1, dArr, i, (this.c - i) - 1);
                this.c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i, int i2) {
        a();
        if (i2 >= i) {
            double[] dArr = this.a;
            System.arraycopy(dArr, i2, dArr, i, this.c - i2);
            this.c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        a();
        b(i);
        double[] dArr = this.a;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final int size() {
        return this.c;
    }

    public C0131h(double[] dArr, int i) {
        this.a = dArr;
        this.c = i;
    }

    public final Object remove(int i) {
        a();
        b(i);
        double[] dArr = this.a;
        double d = dArr[i];
        int i2 = this.c;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final boolean add(Object obj) {
        addDouble(((Double) obj).doubleValue());
        return true;
    }
}
