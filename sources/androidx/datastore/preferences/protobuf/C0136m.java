package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.p;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.m  reason: case insensitive filesystem */
/* compiled from: FloatArrayList */
public final class C0136m extends C0126c<Float> implements RandomAccess, qq {
    public float[] a;
    public int c;

    static {
        new C0136m(new float[0], 0).a = false;
    }

    public C0136m() {
        this(new float[10], 0);
    }

    public final void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        a();
        if (i < 0 || i > (i2 = this.c)) {
            StringBuilder m = lf.m("Index:", i, ", Size:");
            m.append(this.c);
            throw new IndexOutOfBoundsException(m.toString());
        }
        float[] fArr = this.a;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[C1058d.L(i2, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.a, i, fArr2, i + 1, this.c - i);
            this.a = fArr2;
        }
        this.a[i] = floatValue;
        this.c++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        a();
        Charset charset = p.a;
        collection.getClass();
        if (!(collection instanceof C0136m)) {
            return super.addAll(collection);
        }
        C0136m mVar = (C0136m) collection;
        int i = mVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.a;
            if (i3 > fArr.length) {
                this.a = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(mVar.a, 0, this.a, this.c, mVar.c);
            this.c = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addFloat(float f) {
        a();
        int i = this.c;
        float[] fArr = this.a;
        if (i == fArr.length) {
            float[] fArr2 = new float[C1058d.L(i, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.a = fArr2;
        }
        float[] fArr3 = this.a;
        int i2 = this.c;
        this.c = i2 + 1;
        fArr3[i2] = f;
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
        if (!(obj instanceof C0136m)) {
            return super.equals(obj);
        }
        C0136m mVar = (C0136m) obj;
        if (this.c != mVar.c) {
            return false;
        }
        float[] fArr = mVar.a;
        for (int i = 0; i < this.c; i++) {
            if (Float.floatToIntBits(this.a[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final Object get(int i) {
        b(i);
        return Float.valueOf(this.a[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.a[i2]);
        }
        return i;
    }

    public final p.c l(int i) {
        if (i >= this.c) {
            return new C0136m(Arrays.copyOf(this.a, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Float.valueOf(this.a[i]))) {
                float[] fArr = this.a;
                System.arraycopy(fArr, i + 1, fArr, i, (this.c - i) - 1);
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
            float[] fArr = this.a;
            System.arraycopy(fArr, i2, fArr, i, this.c - i2);
            this.c -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        a();
        b(i);
        float[] fArr = this.a;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    public final int size() {
        return this.c;
    }

    public C0136m(float[] fArr, int i) {
        this.a = fArr;
        this.c = i;
    }

    public final Object remove(int i) {
        a();
        b(i);
        float[] fArr = this.a;
        float f = fArr[i];
        int i2 = this.c;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final boolean add(Object obj) {
        addFloat(((Float) obj).floatValue());
        return true;
    }
}
