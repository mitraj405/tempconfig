package org.spongycastle.pqc.math.linearalgebra;

import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;

public class PolynomialGF2mSmallM {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final GF2mField f6851a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6852a;

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i, SecureRandom secureRandom) {
        int i2;
        boolean z;
        int[] iArr;
        GF2mField gF2mField2 = gF2mField;
        int i3 = i;
        SecureRandom secureRandom2 = secureRandom;
        this.f6851a = gF2mField2;
        int[] iArr2 = new int[(i3 + 1)];
        iArr2[i3] = 1;
        iArr2[0] = gF2mField2.a(secureRandom2);
        int i4 = 1;
        while (true) {
            i2 = gF2mField2.a;
            if (i4 >= i3) {
                break;
            }
            iArr2[i4] = RandUtils.a(1 << i2, secureRandom2);
            i4++;
        }
        while (true) {
            if (iArr2[0] != 0) {
                int b = b(iArr2) >> 1;
                int[] iArr3 = {0, 1};
                int[] iArr4 = {0, 1};
                int i5 = 0;
                while (true) {
                    if (i5 >= b) {
                        z = true;
                        break;
                    }
                    for (int i6 = i2 - 1; i6 >= 0; i6--) {
                        iArr3 = h(l(iArr3, iArr3), iArr2);
                    }
                    iArr3 = m(iArr3);
                    int[] a2 = a(iArr3, iArr4);
                    if (b(a2) == -1) {
                        iArr = iArr2;
                    } else {
                        int[] iArr5 = iArr2;
                        for (int i7 = -1; b(iArr5) != i7; i7 = -1) {
                            int[] h = h(a2, iArr5);
                            int length = iArr5.length;
                            int[] iArr6 = new int[length];
                            System.arraycopy(iArr5, 0, iArr6, 0, length);
                            int length2 = h.length;
                            int[] iArr7 = new int[length2];
                            System.arraycopy(h, 0, iArr7, 0, length2);
                            a2 = iArr6;
                            iArr5 = iArr7;
                        }
                        iArr = j(gF2mField2.b(g(a2)), a2);
                    }
                    if (b(iArr) != 0) {
                        break;
                    }
                    i5++;
                }
            }
            z = false;
            if (!z) {
                int a3 = RandUtils.a(i, secureRandom);
                if (a3 == 0) {
                    iArr2[0] = gF2mField2.a(secureRandom2);
                } else {
                    iArr2[a3] = RandUtils.a(1 << i2, secureRandom2);
                }
            } else {
                this.f6852a = iArr2;
                c();
                return;
            }
        }
    }

    public static int b(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    public static int g(int[] iArr) {
        int b = b(iArr);
        if (b == -1) {
            return 0;
        }
        return iArr[b];
    }

    public static int[] k(int i, int[] iArr) {
        int b = b(iArr);
        if (b == -1) {
            return new int[1];
        }
        int[] iArr2 = new int[(b + i + 1)];
        System.arraycopy(iArr, 0, iArr2, i, b + 1);
        return iArr2;
    }

    public static int[] m(int[] iArr) {
        int b = b(iArr);
        if (b == -1) {
            return new int[1];
        }
        int i = b + 1;
        if (iArr.length == i) {
            int[] iArr2 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        int[] iArr3 = new int[i];
        System.arraycopy(iArr, 0, iArr3, 0, i);
        return iArr3;
    }

    public final int[] a(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            int i = iArr3[length];
            int i2 = iArr[length];
            this.f6851a.getClass();
            iArr3[length] = i ^ i2;
        }
        return iArr3;
    }

    public final void c() {
        this.a = this.f6852a.length - 1;
        while (true) {
            int i = this.a;
            if (i >= 0 && this.f6852a[i] == 0) {
                this.a = i - 1;
            } else {
                return;
            }
        }
    }

    public final int[][] d(int[] iArr, int[] iArr2) {
        int b = b(iArr2);
        int b2 = b(iArr) + 1;
        if (b != -1) {
            int[][] iArr3 = {new int[1], new int[b2]};
            int g = g(iArr2);
            GF2mField gF2mField = this.f6851a;
            int b3 = gF2mField.b(g);
            iArr3[0][0] = 0;
            int[] iArr4 = iArr3[1];
            System.arraycopy(iArr, 0, iArr4, 0, iArr4.length);
            while (b <= b(iArr3[1])) {
                int d = gF2mField.d(g(iArr3[1]), b3);
                int[] iArr5 = {d};
                int[] j = j(d, iArr2);
                int b4 = b(iArr3[1]) - b;
                int[] k = k(b4, j);
                iArr3[0] = a(k(b4, iArr5), iArr3[0]);
                iArr3[1] = a(k, iArr3[1]);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero.");
    }

    public final int e(int i) {
        if (i < 0 || i > this.a) {
            return 0;
        }
        return this.f6852a[i];
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x003c
            boolean r1 = r8 instanceof org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM
            if (r1 != 0) goto L_0x0008
            goto L_0x003c
        L_0x0008:
            org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM r8 = (org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM) r8
            org.spongycastle.pqc.math.linearalgebra.GF2mField r1 = r7.f6851a
            org.spongycastle.pqc.math.linearalgebra.GF2mField r2 = r8.f6851a
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003c
            int r1 = r7.a
            int r2 = r8.a
            if (r1 != r2) goto L_0x003c
            int[] r1 = r7.f6852a
            int[] r8 = r8.f6852a
            int r2 = b(r1)
            int r3 = b(r8)
            r4 = 1
            if (r2 == r3) goto L_0x002b
        L_0x0029:
            r8 = r0
            goto L_0x0039
        L_0x002b:
            r3 = r0
        L_0x002c:
            if (r3 > r2) goto L_0x0038
            r5 = r1[r3]
            r6 = r8[r3]
            if (r5 == r6) goto L_0x0035
            goto L_0x0029
        L_0x0035:
            int r3 = r3 + 1
            goto L_0x002c
        L_0x0038:
            r8 = r4
        L_0x0039:
            if (r8 == 0) goto L_0x003c
            return r4
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM.equals(java.lang.Object):boolean");
    }

    public final byte[] f() {
        int i = 8;
        int i2 = 1;
        while (this.f6851a.a > i) {
            i2++;
            i += 8;
        }
        byte[] bArr = new byte[(this.f6852a.length * i2)];
        int i3 = 0;
        for (int i4 = 0; i4 < this.f6852a.length; i4++) {
            int i5 = 0;
            while (i5 < i) {
                bArr[i3] = (byte) (this.f6852a[i4] >>> i5);
                i5 += 8;
                i3++;
            }
        }
        return bArr;
    }

    public final int[] h(int[] iArr, int[] iArr2) {
        int b = b(iArr2);
        if (b != -1) {
            int length = iArr.length;
            int[] iArr3 = new int[length];
            int g = g(iArr2);
            GF2mField gF2mField = this.f6851a;
            int b2 = gF2mField.b(g);
            System.arraycopy(iArr, 0, iArr3, 0, length);
            while (b <= b(iArr3)) {
                iArr3 = a(j(gF2mField.d(g(iArr3), b2), k(b(iArr3) - b, iArr2)), iArr3);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero");
    }

    public final int hashCode() {
        int hashCode = this.f6851a.hashCode();
        int i = 0;
        while (true) {
            int[] iArr = this.f6852a;
            if (i >= iArr.length) {
                return hashCode;
            }
            hashCode = (hashCode * 31) + iArr[i];
            i++;
        }
    }

    public final PolynomialGF2mSmallM i(int i) {
        GF2mField gF2mField = this.f6851a;
        if (gF2mField.c(i)) {
            return new PolynomialGF2mSmallM(gF2mField, j(i, this.f6852a));
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public final int[] j(int i, int[] iArr) {
        int b = b(iArr);
        if (b == -1 || i == 0) {
            return new int[1];
        }
        if (i == 1) {
            int[] iArr2 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        int[] iArr3 = new int[(b + 1)];
        while (b >= 0) {
            iArr3[b] = this.f6851a.d(iArr[b], i);
            b--;
        }
        return iArr3;
    }

    public final int[] l(int[] iArr, int[] iArr2) {
        if (b(iArr) < b(iArr2)) {
            int[] iArr3 = iArr2;
            iArr2 = iArr;
            iArr = iArr3;
        }
        int[] m = m(iArr);
        int[] m2 = m(iArr2);
        if (m2.length == 1) {
            return j(m2[0], m);
        }
        int length = m.length;
        int length2 = m2.length;
        int[] iArr4 = new int[((length + length2) - 1)];
        if (length2 != length) {
            int[] iArr5 = new int[length2];
            int i = length - length2;
            int[] iArr6 = new int[i];
            System.arraycopy(m, 0, iArr5, 0, length2);
            System.arraycopy(m, length2, iArr6, 0, i);
            return a(l(iArr5, m2), k(length2, l(iArr6, m2)));
        }
        int i2 = (length + 1) >>> 1;
        int i3 = length - i2;
        int[] iArr7 = new int[i2];
        int[] iArr8 = new int[i2];
        int[] iArr9 = new int[i3];
        int[] iArr10 = new int[i3];
        System.arraycopy(m, 0, iArr7, 0, i2);
        System.arraycopy(m, i2, iArr9, 0, i3);
        System.arraycopy(m2, 0, iArr8, 0, i2);
        System.arraycopy(m2, i2, iArr10, 0, i3);
        int[] a2 = a(iArr7, iArr9);
        int[] a3 = a(iArr8, iArr10);
        int[] l = l(iArr7, iArr8);
        int[] l2 = l(a2, a3);
        int[] l3 = l(iArr9, iArr10);
        return a(k(i2, a(a(a(l2, l), l3), k(i2, l3))), l);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" Polynomial over ");
        GF2mField gF2mField = this.f6851a;
        sb.append(gF2mField.toString());
        sb.append(": \n");
        String sb2 = sb.toString();
        for (int i = 0; i < this.f6852a.length; i++) {
            StringBuilder J = xx.J(sb2);
            int i2 = this.f6852a[i];
            String str = "";
            for (int i3 = 0; i3 < gF2mField.a; i3++) {
                if ((((byte) i2) & 1) == 0) {
                    str = C0709Uj.i("0", str);
                } else {
                    str = C0709Uj.i(C0515Ga.AVLBLTY_ONLY, str);
                }
                i2 >>>= 1;
            }
            J.append(str);
            J.append("Y^");
            J.append(i);
            J.append("+");
            sb2 = J.toString();
        }
        return C1058d.z(sb2, ";");
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i) {
        this.f6851a = gF2mField;
        this.a = i;
        int[] iArr = new int[(i + 1)];
        this.f6852a = iArr;
        iArr[i] = 1;
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int[] iArr) {
        this.f6851a = gF2mField;
        this.f6852a = m(iArr);
        c();
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, byte[] bArr) {
        this.f6851a = gF2mField;
        int i = 8;
        int i2 = 1;
        while (gF2mField.a > i) {
            i2++;
            i += 8;
        }
        if (bArr.length % i2 == 0) {
            this.f6852a = new int[(bArr.length / i2)];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int[] iArr = this.f6852a;
                if (i3 < iArr.length) {
                    int i5 = 0;
                    while (i5 < i) {
                        int[] iArr2 = this.f6852a;
                        iArr2[i3] = ((bArr[i4] & UnsignedBytes.MAX_VALUE) << i5) ^ iArr2[i3];
                        i5 += 8;
                        i4++;
                    }
                    if (this.f6851a.c(this.f6852a[i3])) {
                        i3++;
                    } else {
                        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                    }
                } else if (iArr.length == 1 || iArr[iArr.length - 1] != 0) {
                    c();
                    return;
                } else {
                    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                }
            }
        } else {
            throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
        }
    }

    public PolynomialGF2mSmallM(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.f6851a = polynomialGF2mSmallM.f6851a;
        this.a = polynomialGF2mSmallM.a;
        this.f6852a = IntUtils.a(polynomialGF2mSmallM.f6852a);
    }
}
