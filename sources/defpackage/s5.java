package defpackage;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.C0124a;
import androidx.datastore.preferences.protobuf.C0130g;
import androidx.datastore.preferences.protobuf.p;
import androidx.datastore.preferences.protobuf.s;
import com.google.firebase.perf.util.Constants;
import defpackage.OB;
import defpackage.Ww;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: s5  reason: default package */
/* compiled from: CodedOutputStream */
public abstract class s5 extends v3 {
    public static final Logger a = Logger.getLogger(s5.class.getName());

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f3247a = C0285oB.b;

    /* renamed from: a  reason: collision with other field name */
    public C0130g f3248a;

    /* renamed from: s5$a */
    /* compiled from: CodedOutputStream */
    public static abstract class a extends s5 {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final byte[] f3249a;
        public int b;

        public a(int i) {
            if (i >= 0) {
                byte[] bArr = new byte[Math.max(i, 20)];
                this.f3249a = bArr;
                this.a = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final void X(int i) {
            int i2 = this.b;
            int i3 = i2 + 1;
            byte[] bArr = this.f3249a;
            bArr[i2] = (byte) (i & Constants.MAX_HOST_LENGTH);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i >> 8) & Constants.MAX_HOST_LENGTH);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i >> 16) & Constants.MAX_HOST_LENGTH);
            this.b = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & Constants.MAX_HOST_LENGTH);
        }

        public final void Y(long j) {
            int i = this.b;
            int i2 = i + 1;
            byte[] bArr = this.f3249a;
            bArr[i] = (byte) ((int) (j & 255));
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((int) ((j >> 8) & 255));
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((int) ((j >> 16) & 255));
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((int) (255 & (j >> 24)));
            int i6 = i5 + 1;
            bArr[i5] = (byte) (((int) (j >> 32)) & Constants.MAX_HOST_LENGTH);
            int i7 = i6 + 1;
            bArr[i6] = (byte) (((int) (j >> 40)) & Constants.MAX_HOST_LENGTH);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (((int) (j >> 48)) & Constants.MAX_HOST_LENGTH);
            this.b = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & Constants.MAX_HOST_LENGTH);
        }

        public final void Z(int i, int i2) {
            a0((i << 3) | i2);
        }

        public final void a0(int i) {
            boolean z = s5.f3247a;
            byte[] bArr = this.f3249a;
            if (z) {
                while ((i & -128) != 0) {
                    int i2 = this.b;
                    this.b = i2 + 1;
                    C0285oB.p(bArr, (long) i2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                int i3 = this.b;
                this.b = i3 + 1;
                C0285oB.p(bArr, (long) i3, (byte) i);
                return;
            }
            while ((i & -128) != 0) {
                int i4 = this.b;
                this.b = i4 + 1;
                bArr[i4] = (byte) ((i & 127) | 128);
                i >>>= 7;
            }
            int i5 = this.b;
            this.b = i5 + 1;
            bArr[i5] = (byte) i;
        }

        public final void b0(long j) {
            boolean z = s5.f3247a;
            byte[] bArr = this.f3249a;
            if (z) {
                while ((j & -128) != 0) {
                    int i = this.b;
                    this.b = i + 1;
                    C0285oB.p(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                int i2 = this.b;
                this.b = i2 + 1;
                C0285oB.p(bArr, (long) i2, (byte) ((int) j));
                return;
            }
            while ((j & -128) != 0) {
                int i3 = this.b;
                this.b = i3 + 1;
                bArr[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            }
            int i4 = this.b;
            this.b = i4 + 1;
            bArr[i4] = (byte) ((int) j);
        }
    }

    /* renamed from: s5$b */
    /* compiled from: CodedOutputStream */
    public static class b extends s5 {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final byte[] f3250a;
        public int b;

        public b(byte[] bArr, int i) {
            int i2 = 0 + i;
            if ((0 | i | (bArr.length - i2)) >= 0) {
                this.f3250a = bArr;
                this.b = 0;
                this.a = i2;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i)}));
        }

        public final void B(byte b2) throws IOException {
            try {
                byte[] bArr = this.f3250a;
                int i = this.b;
                this.b = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.a), 1}), e);
            }
        }

        public final void C(int i, boolean z) throws IOException {
            S(i, 0);
            B(z ? (byte) 1 : 0);
        }

        public final void D(byte[] bArr, int i) throws IOException {
            U(i);
            X(bArr, 0, i);
        }

        public final void E(int i, x3 x3Var) throws IOException {
            S(i, 2);
            F(x3Var);
        }

        public final void F(x3 x3Var) throws IOException {
            U(x3Var.size());
            x3Var.i(this);
        }

        public final void G(int i, int i2) throws IOException {
            S(i, 5);
            H(i2);
        }

        public final void H(int i) throws IOException {
            try {
                byte[] bArr = this.f3250a;
                int i2 = this.b;
                int i3 = i2 + 1;
                bArr[i2] = (byte) (i & Constants.MAX_HOST_LENGTH);
                int i4 = i3 + 1;
                bArr[i3] = (byte) ((i >> 8) & Constants.MAX_HOST_LENGTH);
                int i5 = i4 + 1;
                bArr[i4] = (byte) ((i >> 16) & Constants.MAX_HOST_LENGTH);
                this.b = i5 + 1;
                bArr[i5] = (byte) ((i >> 24) & Constants.MAX_HOST_LENGTH);
            } catch (IndexOutOfBoundsException e) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.a), 1}), e);
            }
        }

        public final void I(int i, long j) throws IOException {
            S(i, 1);
            J(j);
        }

        public final void J(long j) throws IOException {
            try {
                byte[] bArr = this.f3250a;
                int i = this.b;
                int i2 = i + 1;
                bArr[i] = (byte) (((int) j) & Constants.MAX_HOST_LENGTH);
                int i3 = i2 + 1;
                bArr[i2] = (byte) (((int) (j >> 8)) & Constants.MAX_HOST_LENGTH);
                int i4 = i3 + 1;
                bArr[i3] = (byte) (((int) (j >> 16)) & Constants.MAX_HOST_LENGTH);
                int i5 = i4 + 1;
                bArr[i4] = (byte) (((int) (j >> 24)) & Constants.MAX_HOST_LENGTH);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((int) (j >> 32)) & Constants.MAX_HOST_LENGTH);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((int) (j >> 40)) & Constants.MAX_HOST_LENGTH);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (((int) (j >> 48)) & Constants.MAX_HOST_LENGTH);
                this.b = i8 + 1;
                bArr[i8] = (byte) (((int) (j >> 56)) & Constants.MAX_HOST_LENGTH);
            } catch (IndexOutOfBoundsException e) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.a), 1}), e);
            }
        }

        public final void K(int i, int i2) throws IOException {
            S(i, 0);
            L(i2);
        }

        public final void L(int i) throws IOException {
            if (i >= 0) {
                U(i);
            } else {
                W((long) i);
            }
        }

        public final void M(int i, A a2, kv kvVar) throws IOException {
            S(i, 2);
            U(((C0124a) a2).g(kvVar));
            kvVar.b(a2, this.f3248a);
        }

        public final void N(A a2) throws IOException {
            U(a2.getSerializedSize());
            a2.e(this);
        }

        public final void O(int i, A a2) throws IOException {
            S(1, 3);
            T(2, i);
            S(3, 2);
            N(a2);
            S(1, 4);
        }

        public final void P(int i, x3 x3Var) throws IOException {
            S(1, 3);
            T(2, i);
            E(3, x3Var);
            S(1, 4);
        }

        public final void Q(int i, String str) throws IOException {
            S(i, 2);
            R(str);
        }

        public final void R(String str) throws IOException {
            int i = this.b;
            try {
                int x = s5.x(str.length() * 3);
                int x2 = s5.x(str.length());
                int i2 = this.a;
                byte[] bArr = this.f3250a;
                if (x2 == x) {
                    int i3 = i + x2;
                    this.b = i3;
                    int b2 = OB.a.b(str, bArr, i3, i2 - i3);
                    this.b = i;
                    U((b2 - i) - x2);
                    this.b = b2;
                    return;
                }
                U(OB.b(str));
                int i4 = this.b;
                this.b = OB.a.b(str, bArr, i4, i2 - i4);
            } catch (OB.d e) {
                this.b = i;
                A(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new c(e2);
            }
        }

        public final void S(int i, int i2) throws IOException {
            U((i << 3) | i2);
        }

        public final void T(int i, int i2) throws IOException {
            S(i, 0);
            U(i2);
        }

        public final void U(int i) throws IOException {
            boolean z = s5.f3247a;
            int i2 = this.a;
            byte[] bArr = this.f3250a;
            if (z && !A0.a()) {
                int i3 = this.b;
                if (i2 - i3 >= 5) {
                    if ((i & -128) == 0) {
                        this.b = i3 + 1;
                        C0285oB.p(bArr, (long) i3, (byte) i);
                        return;
                    }
                    this.b = i3 + 1;
                    C0285oB.p(bArr, (long) i3, (byte) (i | 128));
                    int i4 = i >>> 7;
                    if ((i4 & -128) == 0) {
                        int i5 = this.b;
                        this.b = i5 + 1;
                        C0285oB.p(bArr, (long) i5, (byte) i4);
                        return;
                    }
                    int i6 = this.b;
                    this.b = i6 + 1;
                    C0285oB.p(bArr, (long) i6, (byte) (i4 | 128));
                    int i7 = i4 >>> 7;
                    if ((i7 & -128) == 0) {
                        int i8 = this.b;
                        this.b = i8 + 1;
                        C0285oB.p(bArr, (long) i8, (byte) i7);
                        return;
                    }
                    int i9 = this.b;
                    this.b = i9 + 1;
                    C0285oB.p(bArr, (long) i9, (byte) (i7 | 128));
                    int i10 = i7 >>> 7;
                    if ((i10 & -128) == 0) {
                        int i11 = this.b;
                        this.b = i11 + 1;
                        C0285oB.p(bArr, (long) i11, (byte) i10);
                        return;
                    }
                    int i12 = this.b;
                    this.b = i12 + 1;
                    C0285oB.p(bArr, (long) i12, (byte) (i10 | 128));
                    int i13 = this.b;
                    this.b = i13 + 1;
                    C0285oB.p(bArr, (long) i13, (byte) (i10 >>> 7));
                    return;
                }
            }
            while ((i & -128) != 0) {
                int i14 = this.b;
                this.b = i14 + 1;
                bArr[i14] = (byte) ((i & 127) | 128);
                i >>>= 7;
            }
            try {
                int i15 = this.b;
                this.b = i15 + 1;
                bArr[i15] = (byte) i;
            } catch (IndexOutOfBoundsException e) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.b), Integer.valueOf(i2), 1}), e);
            }
        }

        public final void V(int i, long j) throws IOException {
            S(i, 0);
            W(j);
        }

        public final void W(long j) throws IOException {
            boolean z = s5.f3247a;
            int i = this.a;
            byte[] bArr = this.f3250a;
            if (!z || i - this.b < 10) {
                while ((j & -128) != 0) {
                    int i2 = this.b;
                    this.b = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    int i3 = this.b;
                    this.b = i3 + 1;
                    bArr[i3] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.b), Integer.valueOf(i), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    int i4 = this.b;
                    this.b = i4 + 1;
                    C0285oB.p(bArr, (long) i4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                int i5 = this.b;
                this.b = i5 + 1;
                C0285oB.p(bArr, (long) i5, (byte) ((int) j));
            }
        }

        public final void X(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f3250a, this.b, i2);
                this.b += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.a), Integer.valueOf(i2)}), e);
            }
        }

        public final void c(byte[] bArr, int i, int i2) throws IOException {
            X(bArr, i, i2);
        }
    }

    /* renamed from: s5$d */
    /* compiled from: CodedOutputStream */
    public static final class d extends a {
        public final OutputStream a;

        public d(Ww.b bVar, int i) {
            super(i);
            this.a = bVar;
        }

        public final void B(byte b) throws IOException {
            if (this.b == this.a) {
                c0();
            }
            int i = this.b;
            this.b = i + 1;
            this.f3249a[i] = b;
        }

        public final void C(int i, boolean z) throws IOException {
            d0(11);
            Z(i, 0);
            byte b = z ? (byte) 1 : 0;
            int i2 = this.b;
            this.b = i2 + 1;
            this.f3249a[i2] = b;
        }

        public final void D(byte[] bArr, int i) throws IOException {
            U(i);
            e0(bArr, 0, i);
        }

        public final void E(int i, x3 x3Var) throws IOException {
            S(i, 2);
            F(x3Var);
        }

        public final void F(x3 x3Var) throws IOException {
            U(x3Var.size());
            x3Var.i(this);
        }

        public final void G(int i, int i2) throws IOException {
            d0(14);
            Z(i, 5);
            X(i2);
        }

        public final void H(int i) throws IOException {
            d0(4);
            X(i);
        }

        public final void I(int i, long j) throws IOException {
            d0(18);
            Z(i, 1);
            Y(j);
        }

        public final void J(long j) throws IOException {
            d0(8);
            Y(j);
        }

        public final void K(int i, int i2) throws IOException {
            d0(20);
            Z(i, 0);
            if (i2 >= 0) {
                a0(i2);
            } else {
                b0((long) i2);
            }
        }

        public final void L(int i) throws IOException {
            if (i >= 0) {
                U(i);
            } else {
                W((long) i);
            }
        }

        public final void M(int i, A a2, kv kvVar) throws IOException {
            S(i, 2);
            U(((C0124a) a2).g(kvVar));
            kvVar.b(a2, this.f3248a);
        }

        public final void N(A a2) throws IOException {
            U(a2.getSerializedSize());
            a2.e(this);
        }

        public final void O(int i, A a2) throws IOException {
            S(1, 3);
            T(2, i);
            S(3, 2);
            N(a2);
            S(1, 4);
        }

        public final void P(int i, x3 x3Var) throws IOException {
            S(1, 3);
            T(2, i);
            E(3, x3Var);
            S(1, 4);
        }

        public final void Q(int i, String str) throws IOException {
            S(i, 2);
            R(str);
        }

        public final void R(String str) throws IOException {
            int i;
            try {
                int length = str.length() * 3;
                int x = s5.x(length);
                int i2 = x + length;
                int i3 = this.a;
                if (i2 > i3) {
                    byte[] bArr = new byte[length];
                    int b = OB.a.b(str, bArr, 0, length);
                    U(b);
                    e0(bArr, 0, b);
                    return;
                }
                if (i2 > i3 - this.b) {
                    c0();
                }
                int x2 = s5.x(str.length());
                i = this.b;
                byte[] bArr2 = this.f3249a;
                if (x2 == x) {
                    int i4 = i + x2;
                    this.b = i4;
                    int b2 = OB.a.b(str, bArr2, i4, i3 - i4);
                    this.b = i;
                    a0((b2 - i) - x2);
                    this.b = b2;
                    return;
                }
                int b3 = OB.b(str);
                a0(b3);
                this.b = OB.a.b(str, bArr2, this.b, b3);
            } catch (OB.d e) {
                this.b = i;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new c(e2);
            } catch (OB.d e3) {
                A(str, e3);
            }
        }

        public final void S(int i, int i2) throws IOException {
            U((i << 3) | i2);
        }

        public final void T(int i, int i2) throws IOException {
            d0(20);
            Z(i, 0);
            a0(i2);
        }

        public final void U(int i) throws IOException {
            d0(5);
            a0(i);
        }

        public final void V(int i, long j) throws IOException {
            d0(20);
            Z(i, 0);
            b0(j);
        }

        public final void W(long j) throws IOException {
            d0(10);
            b0(j);
        }

        public final void c(byte[] bArr, int i, int i2) throws IOException {
            e0(bArr, i, i2);
        }

        public final void c0() throws IOException {
            this.a.write(this.f3249a, 0, this.b);
            this.b = 0;
        }

        public final void d0(int i) throws IOException {
            if (this.a - this.b < i) {
                c0();
            }
        }

        public final void e0(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.b;
            int i4 = this.a;
            int i5 = i4 - i3;
            byte[] bArr2 = this.f3249a;
            if (i5 >= i2) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.b += i2;
                return;
            }
            System.arraycopy(bArr, i, bArr2, i3, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.b = i4;
            c0();
            if (i7 <= i4) {
                System.arraycopy(bArr, i6, bArr2, 0, i7);
                this.b = i7;
                return;
            }
            this.a.write(bArr, i6, i7);
        }
    }

    public static int d(int i) {
        return v(i) + 1;
    }

    public static int e(int i, x3 x3Var) {
        int v = v(i);
        int size = x3Var.size();
        return x(size) + size + v;
    }

    public static int f(int i) {
        return v(i) + 8;
    }

    public static int g(int i, int i2) {
        return m(i2) + v(i);
    }

    public static int h(int i) {
        return v(i) + 4;
    }

    public static int i(int i) {
        return v(i) + 8;
    }

    public static int j(int i) {
        return v(i) + 4;
    }

    @Deprecated
    public static int k(int i, A a2, kv kvVar) {
        return ((C0124a) a2).g(kvVar) + (v(i) * 2);
    }

    public static int l(int i, int i2) {
        return m(i2) + v(i);
    }

    public static int m(int i) {
        if (i >= 0) {
            return x(i);
        }
        return 10;
    }

    public static int n(int i, long j) {
        return z(j) + v(i);
    }

    public static int o(s sVar) {
        int i;
        if (sVar.f1936a != null) {
            i = sVar.f1936a.size();
        } else if (sVar.a != null) {
            i = sVar.a.getSerializedSize();
        } else {
            i = 0;
        }
        return x(i) + i;
    }

    public static int p(int i) {
        return v(i) + 4;
    }

    public static int q(int i) {
        return v(i) + 8;
    }

    public static int r(int i, int i2) {
        return x((i2 >> 31) ^ (i2 << 1)) + v(i);
    }

    public static int s(int i, long j) {
        return z((j >> 63) ^ (j << 1)) + v(i);
    }

    public static int t(int i, String str) {
        return u(str) + v(i);
    }

    public static int u(String str) {
        int i;
        try {
            i = OB.b(str);
        } catch (OB.d unused) {
            i = str.getBytes(p.a).length;
        }
        return x(i) + i;
    }

    public static int v(int i) {
        return x((i << 3) | 0);
    }

    public static int w(int i, int i2) {
        return x(i2) + v(i);
    }

    public static int x(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((i & -268435456) == 0) {
            return 4;
        }
        return 5;
    }

    public static int y(int i, long j) {
        return z(j) + v(i);
    }

    public static int z(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        if ((j & -16384) != 0) {
            return i + 1;
        }
        return i;
    }

    public final void A(String str, OB.d dVar) throws IOException {
        a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", dVar);
        byte[] bytes = str.getBytes(p.a);
        try {
            U(bytes.length);
            c(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new c(e);
        } catch (c e2) {
            throw e2;
        }
    }

    public abstract void B(byte b2) throws IOException;

    public abstract void C(int i, boolean z) throws IOException;

    public abstract void D(byte[] bArr, int i) throws IOException;

    public abstract void E(int i, x3 x3Var) throws IOException;

    public abstract void F(x3 x3Var) throws IOException;

    public abstract void G(int i, int i2) throws IOException;

    public abstract void H(int i) throws IOException;

    public abstract void I(int i, long j) throws IOException;

    public abstract void J(long j) throws IOException;

    public abstract void K(int i, int i2) throws IOException;

    public abstract void L(int i) throws IOException;

    public abstract void M(int i, A a2, kv kvVar) throws IOException;

    public abstract void N(A a2) throws IOException;

    public abstract void O(int i, A a2) throws IOException;

    public abstract void P(int i, x3 x3Var) throws IOException;

    public abstract void Q(int i, String str) throws IOException;

    public abstract void R(String str) throws IOException;

    public abstract void S(int i, int i2) throws IOException;

    public abstract void T(int i, int i2) throws IOException;

    public abstract void U(int i) throws IOException;

    public abstract void V(int i, long j) throws IOException;

    public abstract void W(long j) throws IOException;

    /* renamed from: s5$c */
    /* compiled from: CodedOutputStream */
    public static class c extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        public c(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
            super(C0709Uj.i("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), indexOutOfBoundsException);
        }

        public c(IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
        }
    }
}
