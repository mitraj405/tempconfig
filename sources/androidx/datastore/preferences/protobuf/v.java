package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.p;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: LongArrayList */
public final class v extends C0126c<Long> implements RandomAccess, qq {
    public long[] a;
    public int c;

    static {
        new v(new long[0], 0).a = false;
    }

    public v() {
        this(new long[10], 0);
    }

    public final void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        a();
        if (i < 0 || i > (i2 = this.c)) {
            StringBuilder m = lf.m("Index:", i, ", Size:");
            m.append(this.c);
            throw new IndexOutOfBoundsException(m.toString());
        }
        long[] jArr = this.a;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[C1058d.L(i2, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.a, i, jArr2, i + 1, this.c - i);
            this.a = jArr2;
        }
        this.a[i] = longValue;
        this.c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        a();
        Charset charset = p.a;
        collection.getClass();
        if (!(collection instanceof v)) {
            return super.addAll(collection);
        }
        v vVar = (v) collection;
        int i = vVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.a;
            if (i3 > jArr.length) {
                this.a = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(vVar.a, 0, this.a, this.c, vVar.c);
            this.c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addLong(long j) {
        a();
        int i = this.c;
        long[] jArr = this.a;
        if (i == jArr.length) {
            long[] jArr2 = new long[C1058d.L(i, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.a = jArr2;
        }
        long[] jArr3 = this.a;
        int i2 = this.c;
        this.c = i2 + 1;
        jArr3[i2] = j;
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
        if (!(obj instanceof v)) {
            return super.equals(obj);
        }
        v vVar = (v) obj;
        if (this.c != vVar.c) {
            return false;
        }
        long[] jArr = vVar.a;
        for (int i = 0; i < this.c; i++) {
            if (this.a[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final Object get(int i) {
        b(i);
        return Long.valueOf(this.a[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + p.a(this.a[i2]);
        }
        return i;
    }

    public final p.c l(int i) {
        if (i >= this.c) {
            return new v(Arrays.copyOf(this.a, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Long.valueOf(this.a[i]))) {
                long[] jArr = this.a;
                System.arraycopy(jArr, i + 1, jArr, i, (this.c - i) - 1);
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
            long[] jArr = this.a;
            System.arraycopy(jArr, i2, jArr, i, this.c - i2);
            this.c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        a();
        b(i);
        long[] jArr = this.a;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.c;
    }

    public v(long[] jArr, int i) {
        this.a = jArr;
        this.c = i;
    }

    public final Object remove(int i) {
        a();
        b(i);
        long[] jArr = this.a;
        long j = jArr[i];
        int i2 = this.c;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final boolean add(Object obj) {
        addLong(((Long) obj).longValue());
        return true;
    }
}
