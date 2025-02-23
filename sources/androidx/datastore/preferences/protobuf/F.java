package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.p;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: ProtobufArrayList */
public final class F<E> extends C0126c<E> implements RandomAccess {
    public static final F<Object> a;

    /* renamed from: a  reason: collision with other field name */
    public E[] f1911a;
    public int c;

    static {
        F<Object> f = new F<>(new Object[0], 0);
        a = f;
        f.a = false;
    }

    public F(E[] eArr, int i) {
        this.f1911a = eArr;
        this.c = i;
    }

    public final boolean add(E e) {
        a();
        int i = this.c;
        E[] eArr = this.f1911a;
        if (i == eArr.length) {
            this.f1911a = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f1911a;
        int i2 = this.c;
        this.c = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    public final void b(int i) {
        if (i < 0 || i >= this.c) {
            StringBuilder m = lf.m("Index:", i, ", Size:");
            m.append(this.c);
            throw new IndexOutOfBoundsException(m.toString());
        }
    }

    public final E get(int i) {
        b(i);
        return this.f1911a[i];
    }

    public final p.c l(int i) {
        if (i >= this.c) {
            return new F(Arrays.copyOf(this.f1911a, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public final E remove(int i) {
        a();
        b(i);
        E[] eArr = this.f1911a;
        E e = eArr[i];
        int i2 = this.c;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return e;
    }

    public final E set(int i, E e) {
        a();
        b(i);
        E[] eArr = this.f1911a;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.c;
    }

    public final void add(int i, E e) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.c)) {
            StringBuilder m = lf.m("Index:", i, ", Size:");
            m.append(this.c);
            throw new IndexOutOfBoundsException(m.toString());
        }
        E[] eArr = this.f1911a;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[C1058d.L(i2, 3, 2, 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.f1911a, i, eArr2, i + 1, this.c - i);
            this.f1911a = eArr2;
        }
        this.f1911a[i] = e;
        this.c++;
        this.modCount++;
    }
}
