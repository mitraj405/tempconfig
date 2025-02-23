package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import defpackage.x3;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: androidx.datastore.preferences.protobuf.e  reason: case insensitive filesystem */
/* compiled from: CodedInputStream */
public abstract class C0128e {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public C0129f f1926a;
    public final int b = 100;
    public final int c = Integer.MAX_VALUE;

    /* renamed from: androidx.datastore.preferences.protobuf.e$a */
    /* compiled from: CodedInputStream */
    public static final class a extends C0128e {
        public final byte[] a;
        public int d;
        public int e;
        public int f;
        public final int g;
        public int h;
        public int i = Integer.MAX_VALUE;

        public a(byte[] bArr, int i2, int i3, boolean z) {
            this.a = bArr;
            this.d = i3 + i2;
            this.f = i2;
            this.g = i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r3[r2] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int A() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f
                int r1 = r5.d
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                int r2 = r0 + 1
                byte[] r3 = r5.a
                byte r0 = r3[r0]
                if (r0 < 0) goto L_0x0012
                r5.f = r2
                return r0
            L_0x0012:
                int r1 = r1 - r2
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r2 + 1
                byte r2 = r3[r2]
                int r2 = r2 << 7
                r0 = r0 ^ r2
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r2 = r1 + 1
                byte r1 = r3[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r2
                goto L_0x0070
            L_0x0031:
                int r1 = r2 + 1
                byte r2 = r3[r2]
                int r2 = r2 << 21
                r0 = r0 ^ r2
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r2 = r1 + 1
                byte r1 = r3[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r2 + 1
                byte r2 = r3[r2]
                if (r2 >= 0) goto L_0x0070
                int r2 = r1 + 1
                byte r1 = r3[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r2 + 1
                byte r2 = r3[r2]
                if (r2 >= 0) goto L_0x0070
                int r2 = r1 + 1
                byte r1 = r3[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r2 + 1
                byte r2 = r3[r2]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.C()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.f = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C0128e.a.A():int");
        }

        public final long B() throws IOException {
            long j;
            long j2;
            long j3;
            byte b;
            int i2 = this.f;
            int i3 = this.d;
            if (i3 != i2) {
                int i4 = i2 + 1;
                byte[] bArr = this.a;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.f = i4;
                    return (long) b2;
                } else if (i3 - i4 >= 9) {
                    int i5 = i4 + 1;
                    byte b3 = b2 ^ (bArr[i4] << 7);
                    if (b3 < 0) {
                        b = b3 ^ UnsignedBytes.MAX_POWER_OF_TWO;
                    } else {
                        int i6 = i5 + 1;
                        byte b4 = b3 ^ (bArr[i5] << Ascii.SO);
                        if (b4 >= 0) {
                            j2 = (long) (b4 ^ UnsignedBytes.MAX_POWER_OF_TWO);
                        } else {
                            i5 = i6 + 1;
                            byte b5 = b4 ^ (bArr[i6] << Ascii.NAK);
                            if (b5 < 0) {
                                b = b5 ^ UnsignedBytes.MAX_POWER_OF_TWO;
                            } else {
                                long j4 = (long) b5;
                                int i7 = i5 + 1;
                                long j5 = (((long) bArr[i5]) << 28) ^ j4;
                                if (j5 >= 0) {
                                    j = j5 ^ 266354560;
                                    i5 = i7;
                                } else {
                                    int i8 = i7 + 1;
                                    long j6 = j5 ^ (((long) bArr[i7]) << 35);
                                    if (j6 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i6 = i8 + 1;
                                        long j7 = j6 ^ (((long) bArr[i8]) << 42);
                                        if (j7 >= 0) {
                                            j2 = j7 ^ 4363953127296L;
                                        } else {
                                            i8 = i6 + 1;
                                            j6 = j7 ^ (((long) bArr[i6]) << 49);
                                            if (j6 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i6 = i8 + 1;
                                                j2 = (j6 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                                if (j2 < 0) {
                                                    i8 = i6 + 1;
                                                    if (((long) bArr[i6]) >= 0) {
                                                        j = j2;
                                                        i5 = i8;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j = j3 ^ j6;
                                    i5 = i8;
                                }
                                this.f = i5;
                                return j;
                            }
                        }
                        i5 = i6;
                        j = j2;
                        this.f = i5;
                        return j;
                    }
                    j = (long) b;
                    this.f = i5;
                    return j;
                }
            }
            return C();
        }

        public final long C() throws IOException {
            long j = 0;
            int i2 = 0;
            while (i2 < 64) {
                int i3 = this.f;
                if (i3 != this.d) {
                    this.f = i3 + 1;
                    byte b = this.a[i3];
                    j |= ((long) (b & Ascii.DEL)) << i2;
                    if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                        return j;
                    }
                    i2 += 7;
                } else {
                    throw q.f();
                }
            }
            throw q.c();
        }

        public final void D(int i2) throws IOException {
            if (i2 >= 0) {
                int i3 = this.d;
                int i4 = this.f;
                if (i2 <= i3 - i4) {
                    this.f = i4 + i2;
                    return;
                }
            }
            if (i2 < 0) {
                throw q.d();
            }
            throw q.f();
        }

        public final void a(int i2) throws q {
            if (this.h != i2) {
                throw new q("Protocol message end-group tag did not match expected tag.");
            }
        }

        public final int b() {
            return this.f - this.g;
        }

        public final boolean c() throws IOException {
            if (this.f == this.d) {
                return true;
            }
            return false;
        }

        public final void d(int i2) {
            this.i = i2;
            int i3 = this.d + this.e;
            this.d = i3;
            int i4 = i3 - this.g;
            if (i4 > i2) {
                int i5 = i4 - i2;
                this.e = i5;
                this.d = i3 - i5;
                return;
            }
            this.e = 0;
        }

        public final int e(int i2) throws q {
            if (i2 >= 0) {
                int i3 = this.f;
                int i4 = this.g;
                int i5 = (i3 - i4) + i2;
                int i6 = this.i;
                if (i5 <= i6) {
                    this.i = i5;
                    int i7 = this.d + this.e;
                    this.d = i7;
                    int i8 = i7 - i4;
                    if (i8 > i5) {
                        int i9 = i8 - i5;
                        this.e = i9;
                        this.d = i7 - i9;
                    } else {
                        this.e = 0;
                    }
                    return i6;
                }
                throw q.f();
            }
            throw q.d();
        }

        public final boolean f() throws IOException {
            if (B() != 0) {
                return true;
            }
            return false;
        }

        public final x3.e g() throws IOException {
            byte[] bArr;
            int A = A();
            byte[] bArr2 = this.a;
            if (A > 0) {
                int i2 = this.d;
                int i3 = this.f;
                if (A <= i2 - i3) {
                    x3.e c = x3.c(i3, bArr2, A);
                    this.f += A;
                    return c;
                }
            }
            if (A == 0) {
                return x3.f3407a;
            }
            if (A > 0) {
                int i4 = this.d;
                int i5 = this.f;
                if (A <= i4 - i5) {
                    int i6 = A + i5;
                    this.f = i6;
                    bArr = Arrays.copyOfRange(bArr2, i5, i6);
                    x3.e eVar = x3.f3407a;
                    return new x3.e(bArr);
                }
            }
            if (A > 0) {
                throw q.f();
            } else if (A == 0) {
                bArr = p.f1935a;
                x3.e eVar2 = x3.f3407a;
                return new x3.e(bArr);
            } else {
                throw q.d();
            }
        }

        public final double h() throws IOException {
            return Double.longBitsToDouble(z());
        }

        public final int i() throws IOException {
            return A();
        }

        public final int j() throws IOException {
            return y();
        }

        public final long k() throws IOException {
            return z();
        }

        public final float l() throws IOException {
            return Float.intBitsToFloat(y());
        }

        public final int m() throws IOException {
            return A();
        }

        public final long n() throws IOException {
            return B();
        }

        public final int o() throws IOException {
            return y();
        }

        public final long p() throws IOException {
            return z();
        }

        public final int q() throws IOException {
            int A = A();
            return (-(A & 1)) ^ (A >>> 1);
        }

        public final long r() throws IOException {
            long B = B();
            return (-(B & 1)) ^ (B >>> 1);
        }

        public final String s() throws IOException {
            int A = A();
            if (A > 0) {
                int i2 = this.d;
                int i3 = this.f;
                if (A <= i2 - i3) {
                    String str = new String(this.a, i3, A, p.a);
                    this.f += A;
                    return str;
                }
            }
            if (A == 0) {
                return "";
            }
            if (A < 0) {
                throw q.d();
            }
            throw q.f();
        }

        public final String t() throws IOException {
            int A = A();
            if (A > 0) {
                int i2 = this.d;
                int i3 = this.f;
                if (A <= i2 - i3) {
                    String a2 = OB.a.a(this.a, i3, A);
                    this.f += A;
                    return a2;
                }
            }
            if (A == 0) {
                return "";
            }
            if (A <= 0) {
                throw q.d();
            }
            throw q.f();
        }

        public final int u() throws IOException {
            if (c()) {
                this.h = 0;
                return 0;
            }
            int A = A();
            this.h = A;
            if ((A >>> 3) != 0) {
                return A;
            }
            throw new q("Protocol message contained an invalid tag (zero).");
        }

        public final int v() throws IOException {
            return A();
        }

        public final long w() throws IOException {
            return B();
        }

        public final boolean x(int i2) throws IOException {
            int u;
            int i3 = i2 & 7;
            int i4 = 0;
            if (i3 == 0) {
                int i5 = this.d - this.f;
                byte[] bArr = this.a;
                if (i5 >= 10) {
                    while (i4 < 10) {
                        int i6 = this.f;
                        this.f = i6 + 1;
                        if (bArr[i6] < 0) {
                            i4++;
                        }
                    }
                    throw q.c();
                }
                while (i4 < 10) {
                    int i7 = this.f;
                    if (i7 != this.d) {
                        this.f = i7 + 1;
                        if (bArr[i7] < 0) {
                            i4++;
                        }
                    } else {
                        throw q.f();
                    }
                }
                throw q.c();
                return true;
            } else if (i3 == 1) {
                D(8);
                return true;
            } else if (i3 == 2) {
                D(A());
                return true;
            } else if (i3 == 3) {
                do {
                    u = u();
                    if (u == 0 || !x(u)) {
                        a(((i2 >>> 3) << 3) | 4);
                    }
                    u = u();
                    break;
                } while (!x(u));
                a(((i2 >>> 3) << 3) | 4);
                return true;
            } else if (i3 == 4) {
                return false;
            } else {
                if (i3 == 5) {
                    D(4);
                    return true;
                }
                int i8 = q.c;
                throw new q.a();
            }
        }

        public final int y() throws IOException {
            int i2 = this.f;
            if (this.d - i2 >= 4) {
                this.f = i2 + 4;
                byte[] bArr = this.a;
                return ((bArr[i2 + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[i2] & UnsignedBytes.MAX_VALUE) | ((bArr[i2 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i2 + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
            }
            throw q.f();
        }

        public final long z() throws IOException {
            int i2 = this.f;
            if (this.d - i2 >= 8) {
                this.f = i2 + 8;
                byte[] bArr = this.a;
                return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            }
            throw q.f();
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.e$b */
    /* compiled from: CodedInputStream */
    public static final class b extends C0128e {
        public final InputStream a;

        /* renamed from: a  reason: collision with other field name */
        public final byte[] f1927a;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i = Integer.MAX_VALUE;

        public b(FileInputStream fileInputStream) {
            Charset charset = p.a;
            this.a = fileInputStream;
            this.f1927a = new byte[4096];
            this.d = 0;
            this.f = 0;
            this.h = 0;
        }

        public final ArrayList A(int i2) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                int min = Math.min(i2, 4096);
                byte[] bArr = new byte[min];
                int i3 = 0;
                while (i3 < min) {
                    int read = this.a.read(bArr, i3, min - i3);
                    if (read != -1) {
                        this.h += read;
                        i3 += read;
                    } else {
                        throw q.f();
                    }
                }
                i2 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public final int B() throws IOException {
            int i2 = this.f;
            if (this.d - i2 < 4) {
                H(4);
                i2 = this.f;
            }
            this.f = i2 + 4;
            byte[] bArr = this.f1927a;
            return ((bArr[i2 + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[i2] & UnsignedBytes.MAX_VALUE) | ((bArr[i2 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i2 + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        }

        public final long C() throws IOException {
            int i2 = this.f;
            if (this.d - i2 < 8) {
                H(8);
                i2 = this.f;
            }
            this.f = i2 + 8;
            byte[] bArr = this.f1927a;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
            if (r3[r2] < 0) goto L_0x006a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int D() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f
                int r1 = r5.d
                if (r1 != r0) goto L_0x0007
                goto L_0x006a
            L_0x0007:
                int r2 = r0 + 1
                byte[] r3 = r5.f1927a
                byte r0 = r3[r0]
                if (r0 < 0) goto L_0x0012
                r5.f = r2
                return r0
            L_0x0012:
                int r1 = r1 - r2
                r4 = 9
                if (r1 >= r4) goto L_0x0018
                goto L_0x006a
            L_0x0018:
                int r1 = r2 + 1
                byte r2 = r3[r2]
                int r2 = r2 << 7
                r0 = r0 ^ r2
                if (r0 >= 0) goto L_0x0024
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0070
            L_0x0024:
                int r2 = r1 + 1
                byte r1 = r3[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0031
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002f:
                r1 = r2
                goto L_0x0070
            L_0x0031:
                int r1 = r2 + 1
                byte r2 = r3[r2]
                int r2 = r2 << 21
                r0 = r0 ^ r2
                if (r0 >= 0) goto L_0x003f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0070
            L_0x003f:
                int r2 = r1 + 1
                byte r1 = r3[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002f
                int r1 = r2 + 1
                byte r2 = r3[r2]
                if (r2 >= 0) goto L_0x0070
                int r2 = r1 + 1
                byte r1 = r3[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r2 + 1
                byte r2 = r3[r2]
                if (r2 >= 0) goto L_0x0070
                int r2 = r1 + 1
                byte r1 = r3[r1]
                if (r1 >= 0) goto L_0x002f
                int r1 = r2 + 1
                byte r2 = r3[r2]
                if (r2 >= 0) goto L_0x0070
            L_0x006a:
                long r0 = r5.F()
                int r0 = (int) r0
                return r0
            L_0x0070:
                r5.f = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C0128e.b.D():int");
        }

        public final long E() throws IOException {
            long j;
            long j2;
            long j3;
            byte b;
            int i2 = this.f;
            int i3 = this.d;
            if (i3 != i2) {
                int i4 = i2 + 1;
                byte[] bArr = this.f1927a;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.f = i4;
                    return (long) b2;
                } else if (i3 - i4 >= 9) {
                    int i5 = i4 + 1;
                    byte b3 = b2 ^ (bArr[i4] << 7);
                    if (b3 < 0) {
                        b = b3 ^ UnsignedBytes.MAX_POWER_OF_TWO;
                    } else {
                        int i6 = i5 + 1;
                        byte b4 = b3 ^ (bArr[i5] << Ascii.SO);
                        if (b4 >= 0) {
                            j2 = (long) (b4 ^ UnsignedBytes.MAX_POWER_OF_TWO);
                        } else {
                            i5 = i6 + 1;
                            byte b5 = b4 ^ (bArr[i6] << Ascii.NAK);
                            if (b5 < 0) {
                                b = b5 ^ UnsignedBytes.MAX_POWER_OF_TWO;
                            } else {
                                long j4 = (long) b5;
                                int i7 = i5 + 1;
                                long j5 = (((long) bArr[i5]) << 28) ^ j4;
                                if (j5 >= 0) {
                                    j = j5 ^ 266354560;
                                    i5 = i7;
                                } else {
                                    int i8 = i7 + 1;
                                    long j6 = j5 ^ (((long) bArr[i7]) << 35);
                                    if (j6 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i6 = i8 + 1;
                                        long j7 = j6 ^ (((long) bArr[i8]) << 42);
                                        if (j7 >= 0) {
                                            j2 = j7 ^ 4363953127296L;
                                        } else {
                                            i8 = i6 + 1;
                                            j6 = j7 ^ (((long) bArr[i6]) << 49);
                                            if (j6 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i6 = i8 + 1;
                                                j2 = (j6 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                                if (j2 < 0) {
                                                    i8 = i6 + 1;
                                                    if (((long) bArr[i6]) >= 0) {
                                                        j = j2;
                                                        i5 = i8;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j = j3 ^ j6;
                                    i5 = i8;
                                }
                                this.f = i5;
                                return j;
                            }
                        }
                        i5 = i6;
                        j = j2;
                        this.f = i5;
                        return j;
                    }
                    j = (long) b;
                    this.f = i5;
                    return j;
                }
            }
            return F();
        }

        public final long F() throws IOException {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                if (this.f == this.d) {
                    H(1);
                }
                int i3 = this.f;
                this.f = i3 + 1;
                byte b = this.f1927a[i3];
                j |= ((long) (b & Ascii.DEL)) << i2;
                if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    return j;
                }
            }
            throw q.c();
        }

        public final void G() {
            int i2 = this.d + this.e;
            this.d = i2;
            int i3 = this.h + i2;
            int i4 = this.i;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.e = i5;
                this.d = i2 - i5;
                return;
            }
            this.e = 0;
        }

        public final void H(int i2) throws IOException {
            if (J(i2)) {
                return;
            }
            if (i2 > (this.c - this.h) - this.f) {
                throw new q("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw q.f();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
            throw new java.lang.IllegalStateException(r2.getClass() + "#skip returned invalid result: " + r5 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void I(int r10) throws java.io.IOException {
            /*
                r9 = this;
                int r0 = r9.d
                int r1 = r9.f
                int r2 = r0 - r1
                if (r10 > r2) goto L_0x000f
                if (r10 < 0) goto L_0x000f
                int r1 = r1 + r10
                r9.f = r1
                goto L_0x0090
            L_0x000f:
                java.io.InputStream r2 = r9.a
                if (r10 < 0) goto L_0x009b
                int r3 = r9.h
                int r4 = r3 + r1
                int r5 = r4 + r10
                int r6 = r9.i
                if (r5 > r6) goto L_0x0091
                r9.h = r4
                int r0 = r0 - r1
                r1 = 0
                r9.d = r1
                r9.f = r1
            L_0x0025:
                if (r0 >= r10) goto L_0x006b
                int r1 = r10 - r0
                long r3 = (long) r1
                long r5 = r2.skip(r3)     // Catch:{ all -> 0x0061 }
                r7 = 0
                int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r1 < 0) goto L_0x003e
                int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r3 > 0) goto L_0x003e
                if (r1 != 0) goto L_0x003b
                goto L_0x006b
            L_0x003b:
                int r1 = (int) r5     // Catch:{ all -> 0x0061 }
                int r0 = r0 + r1
                goto L_0x0025
            L_0x003e:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r1.<init>()     // Catch:{ all -> 0x0061 }
                java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x0061 }
                r1.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = "#skip returned invalid result: "
                r1.append(r2)     // Catch:{ all -> 0x0061 }
                r1.append(r5)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = "\nThe InputStream implementation is buggy."
                r1.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0061 }
                r10.<init>(r1)     // Catch:{ all -> 0x0061 }
                throw r10     // Catch:{ all -> 0x0061 }
            L_0x0061:
                r10 = move-exception
                int r1 = r9.h
                int r1 = r1 + r0
                r9.h = r1
                r9.G()
                throw r10
            L_0x006b:
                int r1 = r9.h
                int r1 = r1 + r0
                r9.h = r1
                r9.G()
                if (r0 >= r10) goto L_0x0090
                int r0 = r9.d
                int r1 = r9.f
                int r1 = r0 - r1
                r9.f = r0
                r0 = 1
                r9.H(r0)
            L_0x0081:
                int r2 = r10 - r1
                int r3 = r9.d
                if (r2 <= r3) goto L_0x008e
                int r1 = r1 + r3
                r9.f = r3
                r9.H(r0)
                goto L_0x0081
            L_0x008e:
                r9.f = r2
            L_0x0090:
                return
            L_0x0091:
                int r6 = r6 - r3
                int r6 = r6 - r1
                r9.I(r6)
                androidx.datastore.preferences.protobuf.q r10 = androidx.datastore.preferences.protobuf.q.f()
                throw r10
            L_0x009b:
                androidx.datastore.preferences.protobuf.q r10 = androidx.datastore.preferences.protobuf.q.d()
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C0128e.b.I(int):void");
        }

        public final boolean J(int i2) throws IOException {
            int i3 = this.f;
            int i4 = i3 + i2;
            int i5 = this.d;
            if (i4 > i5) {
                int i6 = this.h;
                int i7 = this.c;
                if (i2 > (i7 - i6) - i3 || i6 + i3 + i2 > this.i) {
                    return false;
                }
                byte[] bArr = this.f1927a;
                if (i3 > 0) {
                    if (i5 > i3) {
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.h += i3;
                    this.d -= i3;
                    this.f = 0;
                }
                int i8 = this.d;
                int min = Math.min(bArr.length - i8, (i7 - this.h) - i8);
                InputStream inputStream = this.a;
                int read = inputStream.read(bArr, i8, min);
                if (read == 0 || read < -1 || read > bArr.length) {
                    throw new IllegalStateException(inputStream.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.d += read;
                    G();
                    if (this.d >= i2) {
                        return true;
                    }
                    return J(i2);
                }
            } else {
                throw new IllegalStateException(C1058d.y("refillBuffer() called when ", i2, " bytes were already available in buffer"));
            }
        }

        public final void a(int i2) throws q {
            if (this.g != i2) {
                throw new q("Protocol message end-group tag did not match expected tag.");
            }
        }

        public final int b() {
            return this.h + this.f;
        }

        public final boolean c() throws IOException {
            if (this.f != this.d || J(1)) {
                return false;
            }
            return true;
        }

        public final void d(int i2) {
            this.i = i2;
            G();
        }

        public final int e(int i2) throws q {
            if (i2 >= 0) {
                int i3 = this.h + this.f + i2;
                int i4 = this.i;
                if (i3 <= i4) {
                    this.i = i3;
                    G();
                    return i4;
                }
                throw q.f();
            }
            throw q.d();
        }

        public final boolean f() throws IOException {
            if (E() != 0) {
                return true;
            }
            return false;
        }

        public final x3.e g() throws IOException {
            int D = D();
            int i2 = this.d;
            int i3 = this.f;
            int i4 = i2 - i3;
            byte[] bArr = this.f1927a;
            if (D <= i4 && D > 0) {
                x3.e c = x3.c(i3, bArr, D);
                this.f += D;
                return c;
            } else if (D == 0) {
                return x3.f3407a;
            } else {
                byte[] z = z(D);
                if (z != null) {
                    return x3.c(0, z, z.length);
                }
                int i5 = this.f;
                int i6 = this.d;
                int i7 = i6 - i5;
                this.h += i6;
                this.f = 0;
                this.d = 0;
                ArrayList A = A(D - i7);
                byte[] bArr2 = new byte[D];
                System.arraycopy(bArr, i5, bArr2, 0, i7);
                Iterator it = A.iterator();
                while (it.hasNext()) {
                    byte[] bArr3 = (byte[]) it.next();
                    System.arraycopy(bArr3, 0, bArr2, i7, bArr3.length);
                    i7 += bArr3.length;
                }
                x3.e eVar = x3.f3407a;
                return new x3.e(bArr2);
            }
        }

        public final double h() throws IOException {
            return Double.longBitsToDouble(C());
        }

        public final int i() throws IOException {
            return D();
        }

        public final int j() throws IOException {
            return B();
        }

        public final long k() throws IOException {
            return C();
        }

        public final float l() throws IOException {
            return Float.intBitsToFloat(B());
        }

        public final int m() throws IOException {
            return D();
        }

        public final long n() throws IOException {
            return E();
        }

        public final int o() throws IOException {
            return B();
        }

        public final long p() throws IOException {
            return C();
        }

        public final int q() throws IOException {
            int D = D();
            return (-(D & 1)) ^ (D >>> 1);
        }

        public final long r() throws IOException {
            long E = E();
            return (-(E & 1)) ^ (E >>> 1);
        }

        public final String s() throws IOException {
            int D = D();
            byte[] bArr = this.f1927a;
            if (D > 0) {
                int i2 = this.d;
                int i3 = this.f;
                if (D <= i2 - i3) {
                    String str = new String(bArr, i3, D, p.a);
                    this.f += D;
                    return str;
                }
            }
            if (D == 0) {
                return "";
            }
            if (D > this.d) {
                return new String(y(D), p.a);
            }
            H(D);
            String str2 = new String(bArr, this.f, D, p.a);
            this.f += D;
            return str2;
        }

        public final String t() throws IOException {
            int D = D();
            int i2 = this.f;
            int i3 = this.d;
            int i4 = i3 - i2;
            byte[] bArr = this.f1927a;
            if (D <= i4 && D > 0) {
                this.f = i2 + D;
            } else if (D == 0) {
                return "";
            } else {
                i2 = 0;
                if (D <= i3) {
                    H(D);
                    this.f = D + 0;
                } else {
                    bArr = y(D);
                }
            }
            return OB.a.a(bArr, i2, D);
        }

        public final int u() throws IOException {
            if (c()) {
                this.g = 0;
                return 0;
            }
            int D = D();
            this.g = D;
            if ((D >>> 3) != 0) {
                return D;
            }
            throw new q("Protocol message contained an invalid tag (zero).");
        }

        public final int v() throws IOException {
            return D();
        }

        public final long w() throws IOException {
            return E();
        }

        public final boolean x(int i2) throws IOException {
            int u;
            int i3 = i2 & 7;
            int i4 = 0;
            if (i3 == 0) {
                int i5 = this.d - this.f;
                byte[] bArr = this.f1927a;
                if (i5 >= 10) {
                    while (i4 < 10) {
                        int i6 = this.f;
                        this.f = i6 + 1;
                        if (bArr[i6] < 0) {
                            i4++;
                        }
                    }
                    throw q.c();
                }
                while (i4 < 10) {
                    if (this.f == this.d) {
                        H(1);
                    }
                    int i7 = this.f;
                    this.f = i7 + 1;
                    if (bArr[i7] < 0) {
                        i4++;
                    }
                }
                throw q.c();
                return true;
            } else if (i3 == 1) {
                I(8);
                return true;
            } else if (i3 == 2) {
                I(D());
                return true;
            } else if (i3 == 3) {
                do {
                    u = u();
                    if (u == 0 || !x(u)) {
                        a(((i2 >>> 3) << 3) | 4);
                    }
                    u = u();
                    break;
                } while (!x(u));
                a(((i2 >>> 3) << 3) | 4);
                return true;
            } else if (i3 == 4) {
                return false;
            } else {
                if (i3 == 5) {
                    I(4);
                    return true;
                }
                int i8 = q.c;
                throw new q.a();
            }
        }

        public final byte[] y(int i2) throws IOException {
            byte[] z = z(i2);
            if (z != null) {
                return z;
            }
            int i3 = this.f;
            int i4 = this.d;
            int i5 = i4 - i3;
            this.h += i4;
            this.f = 0;
            this.d = 0;
            ArrayList A = A(i2 - i5);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f1927a, i3, bArr, 0, i5);
            Iterator it = A.iterator();
            while (it.hasNext()) {
                byte[] bArr2 = (byte[]) it.next();
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return bArr;
        }

        public final byte[] z(int i2) throws IOException {
            if (i2 == 0) {
                return p.f1935a;
            }
            if (i2 >= 0) {
                int i3 = this.h;
                int i4 = this.f;
                int i5 = i3 + i4 + i2;
                if (i5 - this.c <= 0) {
                    int i6 = this.i;
                    if (i5 <= i6) {
                        int i7 = this.d - i4;
                        int i8 = i2 - i7;
                        InputStream inputStream = this.a;
                        if (i8 >= 4096 && i8 > inputStream.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i2];
                        System.arraycopy(this.f1927a, this.f, bArr, 0, i7);
                        this.h += this.d;
                        this.f = 0;
                        this.d = 0;
                        while (i7 < i2) {
                            int read = inputStream.read(bArr, i7, i2 - i7);
                            if (read != -1) {
                                this.h += read;
                                i7 += read;
                            } else {
                                throw q.f();
                            }
                        }
                        return bArr;
                    }
                    I((i6 - i3) - i4);
                    throw q.f();
                }
                throw new q("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw q.d();
        }
    }

    public abstract void a(int i) throws q;

    public abstract int b();

    public abstract boolean c() throws IOException;

    public abstract void d(int i);

    public abstract int e(int i) throws q;

    public abstract boolean f() throws IOException;

    public abstract x3.e g() throws IOException;

    public abstract double h() throws IOException;

    public abstract int i() throws IOException;

    public abstract int j() throws IOException;

    public abstract long k() throws IOException;

    public abstract float l() throws IOException;

    public abstract int m() throws IOException;

    public abstract long n() throws IOException;

    public abstract int o() throws IOException;

    public abstract long p() throws IOException;

    public abstract int q() throws IOException;

    public abstract long r() throws IOException;

    public abstract String s() throws IOException;

    public abstract String t() throws IOException;

    public abstract int u() throws IOException;

    public abstract int v() throws IOException;

    public abstract long w() throws IOException;

    public abstract boolean x(int i) throws IOException;
}
