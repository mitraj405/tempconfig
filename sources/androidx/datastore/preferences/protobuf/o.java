package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.p;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: IntArrayList */
public final class o extends C0126c<Integer> implements RandomAccess, qq {
    public int[] a;
    public int c;

    static {
        new o(new int[0], 0).a = false;
    }

    public o() {
        this(new int[10], 0);
    }

    public final void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i2 = this.c)) {
            StringBuilder m = lf.m("Index:", i, ", Size:");
            m.append(this.c);
            throw new IndexOutOfBoundsException(m.toString());
        }
        int[] iArr = this.a;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[C1058d.L(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.a, i, iArr2, i + 1, this.c - i);
            this.a = iArr2;
        }
        this.a[i] = intValue;
        this.c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        a();
        Charset charset = p.a;
        collection.getClass();
        if (!(collection instanceof o)) {
            return super.addAll(collection);
        }
        o oVar = (o) collection;
        int i = oVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.a;
            if (i3 > iArr.length) {
                this.a = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(oVar.a, 0, this.a, this.c, oVar.c);
            this.c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addInt(int i) {
        a();
        int i2 = this.c;
        int[] iArr = this.a;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[C1058d.L(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.a = iArr2;
        }
        int[] iArr3 = this.a;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr3[i3] = i;
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
        if (!(obj instanceof o)) {
            return super.equals(obj);
        }
        o oVar = (o) obj;
        if (this.c != oVar.c) {
            return false;
        }
        int[] iArr = oVar.a;
        for (int i = 0; i < this.c; i++) {
            if (this.a[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final Object get(int i) {
        b(i);
        return Integer.valueOf(this.a[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + this.a[i2];
        }
        return i;
    }

    public final p.c l(int i) {
        if (i >= this.c) {
            return new o(Arrays.copyOf(this.a, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Integer.valueOf(this.a[i]))) {
                int[] iArr = this.a;
                System.arraycopy(iArr, i + 1, iArr, i, (this.c - i) - 1);
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
            int[] iArr = this.a;
            System.arraycopy(iArr, i2, iArr, i, this.c - i2);
            this.c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        a();
        b(i);
        int[] iArr = this.a;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.c;
    }

    public o(int[] iArr, int i) {
        this.a = iArr;
        this.c = i;
    }

    public final Object remove(int i) {
        a();
        b(i);
        int[] iArr = this.a;
        int i2 = iArr[i];
        int i3 = this.c;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final boolean add(Object obj) {
        addInt(((Integer) obj).intValue());
        return true;
    }
}
