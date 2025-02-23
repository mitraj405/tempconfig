package org.spongycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;

public final class GoppaCode {

    public static class MaMaPe {
        public final GF2Matrix a;

        /* renamed from: a  reason: collision with other field name */
        public final Permutation f6850a;

        public MaMaPe(GF2Matrix gF2Matrix, Permutation permutation) {
            this.a = gF2Matrix;
            this.f6850a = permutation;
        }
    }

    public static class MatrixSet {
    }

    private GoppaCode() {
    }

    public static MaMaPe a(GF2Matrix gF2Matrix, SecureRandom secureRandom) {
        Permutation permutation;
        GF2Matrix g;
        boolean z;
        int i;
        GF2Matrix gF2Matrix2 = gF2Matrix;
        int i2 = gF2Matrix2.b;
        GF2Matrix gF2Matrix3 = null;
        do {
            permutation = new Permutation(i2, secureRandom);
            g = gF2Matrix2.g(permutation);
            int i3 = g.b;
            int i4 = g.a;
            if (i3 > i4) {
                int i5 = (i4 + 31) >> 5;
                int[] iArr = new int[2];
                z = true;
                iArr[1] = i5;
                iArr[0] = i4;
                int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
                int i6 = g.a;
                int i7 = (1 << (i6 & 31)) - 1;
                if (i7 == 0) {
                    i7 = -1;
                }
                while (true) {
                    i6--;
                    if (i6 < 0) {
                        break;
                    }
                    System.arraycopy(g.a[i6], 0, iArr2[i6], 0, i5);
                    int[] iArr3 = iArr2[i6];
                    int i8 = i5 - 1;
                    iArr3[i8] = iArr3[i8] & i7;
                }
                try {
                    gF2Matrix3 = new GF2Matrix(g.a, iArr2).b();
                    continue;
                } catch (ArithmeticException unused) {
                    z = false;
                    continue;
                }
            } else {
                throw new ArithmeticException("empty submatrix");
            }
        } while (!z);
        GF2Matrix f = gF2Matrix3.f(g);
        int i9 = f.b;
        int i10 = f.a;
        if (i9 > i10) {
            int i11 = i10 >> 5;
            int i12 = i10 & 31;
            GF2Matrix gF2Matrix4 = new GF2Matrix(i10, i9 - i10);
            for (int i13 = f.a - 1; i13 >= 0; i13--) {
                if (i12 != 0) {
                    int i14 = i11;
                    int i15 = 0;
                    while (true) {
                        i = gF2Matrix4.c - 1;
                        if (i15 >= i) {
                            break;
                        }
                        int[] iArr4 = gF2Matrix4.a[i13];
                        int[] iArr5 = f.a[i13];
                        int i16 = i14 + 1;
                        iArr4[i15] = (iArr5[i14] >>> i12) | (iArr5[i16] << (32 - i12));
                        i15++;
                        i14 = i16;
                    }
                    int[] iArr6 = gF2Matrix4.a[i13];
                    int[] iArr7 = f.a[i13];
                    int i17 = i14 + 1;
                    int i18 = iArr7[i14] >>> i12;
                    iArr6[i] = i18;
                    if (i17 < f.c) {
                        iArr6[i] = i18 | (iArr7[i17] << (32 - i12));
                    }
                } else {
                    System.arraycopy(f.a[i13], i11, gF2Matrix4.a[i13], 0, gF2Matrix4.c);
                }
            }
            return new MaMaPe(gF2Matrix4, permutation);
        }
        throw new ArithmeticException("empty submatrix");
    }

    public static GF2Matrix b(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        GF2mField gF2mField2 = gF2mField;
        PolynomialGF2mSmallM polynomialGF2mSmallM2 = polynomialGF2mSmallM;
        int i = gF2mField2.a;
        int i2 = 1 << i;
        int[] iArr = polynomialGF2mSmallM2.f6852a;
        int length = iArr.length - 1;
        if (iArr[length] == 0) {
            length = -1;
        }
        int[] iArr2 = new int[2];
        iArr2[1] = i2;
        int i3 = 0;
        iArr2[0] = length;
        Class cls = Integer.TYPE;
        int[][] iArr3 = (int[][]) Array.newInstance(cls, iArr2);
        int[] iArr4 = new int[2];
        iArr4[1] = i2;
        iArr4[0] = length;
        int[][] iArr5 = (int[][]) Array.newInstance(cls, iArr4);
        for (int i4 = 0; i4 < i2; i4++) {
            int[] iArr6 = iArr5[0];
            int[] iArr7 = polynomialGF2mSmallM2.f6852a;
            int i5 = polynomialGF2mSmallM2.a;
            int i6 = iArr7[i5];
            for (int i7 = i5 - 1; i7 >= 0; i7--) {
                i6 = polynomialGF2mSmallM2.f6851a.d(i6, i4) ^ polynomialGF2mSmallM2.f6852a[i7];
            }
            iArr6[i4] = gF2mField2.b(i6);
        }
        for (int i8 = 1; i8 < length; i8++) {
            for (int i9 = 0; i9 < i2; i9++) {
                iArr5[i8][i9] = gF2mField2.d(iArr5[i8 - 1][i9], i9);
            }
        }
        int i10 = 0;
        while (i10 < length) {
            int i11 = i3;
            while (i11 < i2) {
                for (int i12 = i3; i12 <= i10; i12++) {
                    int[] iArr8 = iArr3[i10];
                    iArr8[i11] = gF2mField2.d(iArr5[i12][i11], polynomialGF2mSmallM2.e((length + i12) - i10)) ^ iArr8[i11];
                }
                i11++;
                i3 = 0;
            }
            i10++;
            i3 = 0;
        }
        int[] iArr9 = new int[2];
        iArr9[1] = (i2 + 31) >>> 5;
        iArr9[0] = length * i;
        int[][] iArr10 = (int[][]) Array.newInstance(Integer.TYPE, iArr9);
        for (int i13 = 0; i13 < i2; i13++) {
            int i14 = i13 >>> 5;
            int i15 = 1 << (i13 & 31);
            for (int i16 = 0; i16 < length; i16++) {
                int i17 = iArr3[i16][i13];
                for (int i18 = 0; i18 < i; i18++) {
                    if (((i17 >>> i18) & 1) != 0) {
                        int[] iArr11 = iArr10[(((i16 + 1) * i) - i18) - 1];
                        iArr11[i14] = iArr11[i14] ^ i15;
                    }
                }
            }
        }
        return new GF2Matrix(i2, iArr10);
    }

    public static GF2Vector c(GF2Vector gF2Vector, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int i;
        boolean z;
        GF2mField gF2mField2;
        int i2;
        GF2Vector gF2Vector2 = gF2Vector;
        GF2mField gF2mField3 = gF2mField;
        PolynomialGF2mSmallM polynomialGF2mSmallM2 = polynomialGF2mSmallM;
        PolynomialGF2mSmallM[] polynomialGF2mSmallMArr2 = polynomialGF2mSmallMArr;
        int i3 = 1 << gF2mField3.a;
        GF2Vector gF2Vector3 = new GF2Vector(i3);
        int[] iArr = gF2Vector2.a;
        int length = iArr.length - 1;
        while (true) {
            if (length < 0) {
                z = true;
                break;
            } else if (iArr[length] != 0) {
                z = false;
                break;
            } else {
                length--;
            }
        }
        if (!z) {
            int i4 = gF2Vector2.a;
            int i5 = gF2mField3.a;
            if (i4 % i5 == 0) {
                int i6 = i4 / i5;
                int[] iArr2 = new int[i6];
                int i7 = 0;
                for (int i8 = i6 - 1; i8 >= 0; i8--) {
                    for (int i9 = -1 + i5; i9 >= 0; i9--) {
                        if (((iArr[i7 >>> 5] >>> (i7 & 31)) & 1) == 1) {
                            iArr2[i8] = iArr2[i8] ^ (1 << i9);
                        }
                        i7++;
                    }
                }
                GF2mVector gF2mVector = new GF2mVector(gF2mField3, iArr2);
                PolynomialGF2mSmallM polynomialGF2mSmallM3 = new PolynomialGF2mSmallM(gF2mVector.a, IntUtils.a(gF2mVector.f6849a));
                int[] iArr3 = polynomialGF2mSmallM3.f6852a;
                int[] iArr4 = polynomialGF2mSmallM2.f6852a;
                int[] m = PolynomialGF2mSmallM.m(iArr4);
                int[] h = polynomialGF2mSmallM3.h(iArr3, iArr4);
                int[] iArr5 = {0};
                int[] h2 = polynomialGF2mSmallM3.h(new int[]{1}, iArr4);
                while (PolynomialGF2mSmallM.b(h) != -1) {
                    int[][] d = polynomialGF2mSmallM3.d(m, h);
                    int[] m2 = PolynomialGF2mSmallM.m(h);
                    int[] m3 = PolynomialGF2mSmallM.m(d[1]);
                    int[] a = polynomialGF2mSmallM3.a(iArr5, polynomialGF2mSmallM3.h(polynomialGF2mSmallM3.l(d[0], h2), iArr4));
                    iArr5 = PolynomialGF2mSmallM.m(h2);
                    h2 = PolynomialGF2mSmallM.m(a);
                    m = m2;
                    h = m3;
                }
                int g = PolynomialGF2mSmallM.g(m);
                GF2mField gF2mField4 = polynomialGF2mSmallM3.f6851a;
                PolynomialGF2mSmallM polynomialGF2mSmallM4 = new PolynomialGF2mSmallM(gF2mField4, polynomialGF2mSmallM3.j(gF2mField4.b(g), iArr5));
                int[] iArr6 = new int[2];
                iArr6[1] = 1;
                PolynomialGF2mSmallM polynomialGF2mSmallM5 = new PolynomialGF2mSmallM(gF2mField4, polynomialGF2mSmallM4.a(polynomialGF2mSmallM4.f6852a, iArr6));
                int length2 = polynomialGF2mSmallMArr2.length;
                int[] iArr7 = new int[length2];
                int i10 = 0;
                while (true) {
                    gF2mField2 = polynomialGF2mSmallM5.f6851a;
                    if (i10 >= length2) {
                        break;
                    }
                    for (int i11 = 0; i11 < length2; i11++) {
                        int[] iArr8 = polynomialGF2mSmallMArr2[i11].f6852a;
                        if (i10 < iArr8.length) {
                            int[] iArr9 = polynomialGF2mSmallM5.f6852a;
                            if (i11 < iArr9.length) {
                                iArr7[i10] = gF2mField2.d(iArr8[i10], iArr9[i11]) ^ iArr7[i10];
                            }
                        }
                    }
                    i10++;
                }
                for (int i12 = 0; i12 < length2; i12++) {
                    int i13 = iArr7[i12];
                    for (int i14 = 1; i14 < gF2mField2.a; i14++) {
                        i13 = gF2mField2.d(i13, i13);
                    }
                    iArr7[i12] = i13;
                }
                PolynomialGF2mSmallM polynomialGF2mSmallM6 = new PolynomialGF2mSmallM(gF2mField2, iArr7);
                int i15 = polynomialGF2mSmallM2.a >> 1;
                int[] m4 = PolynomialGF2mSmallM.m(polynomialGF2mSmallM2.f6852a);
                int[] iArr10 = m4;
                int[] h3 = polynomialGF2mSmallM6.h(polynomialGF2mSmallM6.f6852a, polynomialGF2mSmallM2.f6852a);
                int[] iArr11 = {0};
                int[] iArr12 = {1};
                while (PolynomialGF2mSmallM.b(h3) > i15) {
                    int[][] d2 = polynomialGF2mSmallM6.d(iArr10, h3);
                    int[] iArr13 = d2[1];
                    int[] a2 = polynomialGF2mSmallM6.a(iArr11, polynomialGF2mSmallM6.h(polynomialGF2mSmallM6.l(d2[0], iArr12), polynomialGF2mSmallM2.f6852a));
                    iArr11 = iArr12;
                    iArr12 = a2;
                    iArr10 = h3;
                    h3 = iArr13;
                }
                GF2mField gF2mField5 = polynomialGF2mSmallM6.f6851a;
                PolynomialGF2mSmallM[] polynomialGF2mSmallMArr3 = {new PolynomialGF2mSmallM(gF2mField5, h3), new PolynomialGF2mSmallM(gF2mField5, iArr12)};
                PolynomialGF2mSmallM polynomialGF2mSmallM7 = polynomialGF2mSmallMArr3[0];
                int[] iArr14 = polynomialGF2mSmallM7.f6852a;
                int[] l = polynomialGF2mSmallM7.l(iArr14, iArr14);
                GF2mField gF2mField6 = polynomialGF2mSmallM7.f6851a;
                PolynomialGF2mSmallM polynomialGF2mSmallM8 = new PolynomialGF2mSmallM(gF2mField6, l);
                PolynomialGF2mSmallM polynomialGF2mSmallM9 = polynomialGF2mSmallMArr3[1];
                int[] iArr15 = polynomialGF2mSmallM9.f6852a;
                int[] l2 = polynomialGF2mSmallM9.l(iArr15, iArr15);
                GF2mField gF2mField7 = polynomialGF2mSmallM9.f6851a;
                PolynomialGF2mSmallM polynomialGF2mSmallM10 = new PolynomialGF2mSmallM(gF2mField6, polynomialGF2mSmallM8.a(polynomialGF2mSmallM8.f6852a, new PolynomialGF2mSmallM(gF2mField7, PolynomialGF2mSmallM.k(1, new PolynomialGF2mSmallM(gF2mField7, l2).f6852a)).f6852a));
                int i16 = polynomialGF2mSmallM10.a;
                if (i16 == -1) {
                    i2 = 0;
                } else {
                    i2 = polynomialGF2mSmallM10.f6852a[i16];
                }
                PolynomialGF2mSmallM i17 = polynomialGF2mSmallM10.i(gF2mField3.b(i2));
                for (i = 0; i < i3; i++) {
                    int[] iArr16 = i17.f6852a;
                    int i18 = i17.a;
                    int i19 = iArr16[i18];
                    for (int i20 = i18 - 1; i20 >= 0; i20--) {
                        i19 = i17.f6851a.d(i19, i) ^ i17.f6852a[i20];
                    }
                    if (i19 == 0) {
                        gF2Vector3.f(i);
                    }
                }
            } else {
                throw new ArithmeticException("conversion is impossible");
            }
        }
        return gF2Vector3;
    }
}
