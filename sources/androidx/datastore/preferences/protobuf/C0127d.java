package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.p;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.d  reason: case insensitive filesystem */
/* compiled from: BooleanArrayList */
public final class C0127d extends C0126c<Boolean> implements RandomAccess, qq {
    public boolean[] a;
    public int c;

    static {
        new C0127d(new boolean[0], 0).a = false;
    }

    public C0127d() {
        this(new boolean[10], 0);
    }

    public final void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        a();
        if (i < 0 || i > (i2 = this.c)) {
            StringBuilder m = lf.m("Index:", i, ", Size:");
            m.append(this.c);
            throw new IndexOutOfBoundsException(m.toString());
        }
        boolean[] zArr = this.a;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[C1058d.L(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.a, i, zArr2, i + 1, this.c - i);
            this.a = zArr2;
        }
        this.a[i] = booleanValue;
        this.c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        a();
        Charset charset = p.a;
        collection.getClass();
        if (!(collection instanceof C0127d)) {
            return super.addAll(collection);
        }
        C0127d dVar = (C0127d) collection;
        int i = dVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.a;
            if (i3 > zArr.length) {
                this.a = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(dVar.a, 0, this.a, this.c, dVar.c);
            this.c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z) {
        a();
        int i = this.c;
        boolean[] zArr = this.a;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[C1058d.L(i, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.a = zArr2;
        }
        boolean[] zArr3 = this.a;
        int i2 = this.c;
        this.c = i2 + 1;
        zArr3[i2] = z;
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
        if (!(obj instanceof C0127d)) {
            return super.equals(obj);
        }
        C0127d dVar = (C0127d) obj;
        if (this.c != dVar.c) {
            return false;
        }
        boolean[] zArr = dVar.a;
        for (int i = 0; i < this.c; i++) {
            if (this.a[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final Object get(int i) {
        b(i);
        return Boolean.valueOf(this.a[i]);
    }

    public final int hashCode() {
        int i;
        int i2 = 1;
        for (int i3 = 0; i3 < this.c; i3++) {
            int i4 = i2 * 31;
            boolean z = this.a[i3];
            Charset charset = p.a;
            if (z) {
                i = 1231;
            } else {
                i = 1237;
            }
            i2 = i4 + i;
        }
        return i2;
    }

    public final p.c l(int i) {
        if (i >= this.c) {
            return new C0127d(Arrays.copyOf(this.a, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Boolean.valueOf(this.a[i]))) {
                boolean[] zArr = this.a;
                System.arraycopy(zArr, i + 1, zArr, i, (this.c - i) - 1);
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
            boolean[] zArr = this.a;
            System.arraycopy(zArr, i2, zArr, i, this.c - i2);
            this.c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        a();
        b(i);
        boolean[] zArr = this.a;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.c;
    }

    public C0127d(boolean[] zArr, int i) {
        this.a = zArr;
        this.c = i;
    }

    public final Object remove(int i) {
        a();
        b(i);
        boolean[] zArr = this.a;
        boolean z = zArr[i];
        int i2 = this.c;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }
}
