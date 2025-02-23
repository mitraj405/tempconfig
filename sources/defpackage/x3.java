package defpackage;

import androidx.datastore.preferences.protobuf.p;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: x3  reason: default package */
/* compiled from: ByteString */
public abstract class x3 implements Iterable<Byte>, Serializable {
    public static final c a;

    /* renamed from: a  reason: collision with other field name */
    public static final e f3407a = new e(p.f1935a);
    public int c = 0;

    /* renamed from: x3$a */
    /* compiled from: ByteString */
    public static abstract class a implements Iterator {
        public final Object next() {
            w3 w3Var = (w3) this;
            int i = w3Var.c;
            if (i < w3Var.d) {
                w3Var.c = i + 1;
                return Byte.valueOf(w3Var.a.d(i));
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: x3$b */
    /* compiled from: ByteString */
    public static final class b implements c {
        public final byte[] copyFrom(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    /* renamed from: x3$c */
    /* compiled from: ByteString */
    public interface c {
        byte[] copyFrom(byte[] bArr, int i, int i2);
    }

    /* renamed from: x3$d */
    /* compiled from: ByteString */
    public static abstract class d extends x3 {
        public final Iterator iterator() {
            return new w3(this);
        }
    }

    /* renamed from: x3$e */
    /* compiled from: ByteString */
    public static class e extends d {
        private static final long serialVersionUID = 1;
        public final byte[] a;

        public e(byte[] bArr) {
            bArr.getClass();
            this.a = bArr;
        }

        public byte a(int i) {
            return this.a[i];
        }

        public byte d(int i) {
            return this.a[i];
        }

        public final boolean e() {
            int k = k();
            if (OB.a.c(this.a, k, size() + k) == 0) {
                return true;
            }
            return false;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof x3) || size() != ((x3) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof e)) {
                return obj.equals(this);
            }
            e eVar = (e) obj;
            int i = this.c;
            int i2 = eVar.c;
            if (i != 0 && i2 != 0 && i != i2) {
                return false;
            }
            int size = size();
            if (size > eVar.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            } else if (0 + size <= eVar.size()) {
                int k = k() + size;
                int k2 = k();
                int k3 = eVar.k() + 0;
                while (k2 < k) {
                    if (this.a[k2] != eVar.a[k3]) {
                        return false;
                    }
                    k2++;
                    k3++;
                }
                return true;
            } else {
                StringBuilder m = lf.m("Ran off end of other: 0, ", size, ", ");
                m.append(eVar.size());
                throw new IllegalArgumentException(m.toString());
            }
        }

        public final int f(int i, int i2) {
            int k = k() + 0;
            Charset charset = p.a;
            for (int i3 = k; i3 < k + i2; i3++) {
                i = (i * 31) + this.a[i3];
            }
            return i;
        }

        public final String g(Charset charset) {
            return new String(this.a, k(), size(), charset);
        }

        public final void i(v3 v3Var) throws IOException {
            v3Var.c(this.a, k(), size());
        }

        public int k() {
            return 0;
        }

        public int size() {
            return this.a.length;
        }
    }

    /* renamed from: x3$f */
    /* compiled from: ByteString */
    public static final class f implements c {
        public final byte[] copyFrom(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
    }

    static {
        c cVar;
        if (A0.a()) {
            cVar = new f();
        } else {
            cVar = new b();
        }
        a = cVar;
    }

    public static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(C1058d.y("Beginning index: ", i, " < 0"));
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(lf.i("Beginning index larger than ending index: ", i, ", ", i2));
        } else {
            throw new IndexOutOfBoundsException(lf.i("End index: ", i2, " >= ", i3));
        }
    }

    public static e c(int i, byte[] bArr, int i2) {
        b(i, i + i2, bArr.length);
        return new e(a.copyFrom(bArr, i, i2));
    }

    public abstract byte a(int i);

    public abstract byte d(int i);

    public abstract boolean e();

    public abstract boolean equals(Object obj);

    public abstract int f(int i, int i2);

    public abstract String g(Charset charset);

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            int size = size();
            i = f(size, size);
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }

    public abstract void i(v3 v3Var) throws IOException;

    public Iterator iterator() {
        return new w3(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }
}
