package org.spongycastle.pqc.math.linearalgebra;

public class PolynomialRingGF2m {
    public final GF2mField a;

    /* renamed from: a  reason: collision with other field name */
    public final PolynomialGF2mSmallM f6853a;

    /* renamed from: a  reason: collision with other field name */
    public PolynomialGF2mSmallM[] f6854a;
    public PolynomialGF2mSmallM[] b;

    public PolynomialRingGF2m(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int i;
        GF2mField gF2mField2;
        GF2mField gF2mField3;
        int e;
        this.a = gF2mField;
        this.f6853a = polynomialGF2mSmallM;
        int[] iArr = polynomialGF2mSmallM.f6852a;
        int i2 = -1;
        int length = iArr.length - 1;
        length = iArr[length] == 0 ? -1 : length;
        this.f6854a = new PolynomialGF2mSmallM[length];
        int i3 = 0;
        while (true) {
            i = length >> 1;
            gF2mField2 = this.a;
            if (i3 >= i) {
                break;
            }
            int i4 = i3 << 1;
            int[] iArr2 = new int[(i4 + 1)];
            iArr2[i4] = 1;
            this.f6854a[i3] = new PolynomialGF2mSmallM(gF2mField2, iArr2);
            i3++;
        }
        while (i < length) {
            int i5 = i << 1;
            int[] iArr3 = new int[(i5 + 1)];
            iArr3[i5] = 1;
            PolynomialGF2mSmallM polynomialGF2mSmallM2 = new PolynomialGF2mSmallM(gF2mField2, iArr3);
            this.f6854a[i] = new PolynomialGF2mSmallM(gF2mField2, polynomialGF2mSmallM2.h(polynomialGF2mSmallM2.f6852a, polynomialGF2mSmallM.f6852a));
            i++;
        }
        int[] iArr4 = this.f6853a.f6852a;
        int length2 = iArr4.length - 1;
        i2 = iArr4[length2] != 0 ? length2 : i2;
        PolynomialGF2mSmallM[] polynomialGF2mSmallMArr = new PolynomialGF2mSmallM[i2];
        int i6 = i2 - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            polynomialGF2mSmallMArr[i7] = new PolynomialGF2mSmallM(this.f6854a[i7]);
        }
        this.b = new PolynomialGF2mSmallM[i2];
        while (true) {
            gF2mField3 = this.a;
            if (i6 < 0) {
                break;
            }
            this.b[i6] = new PolynomialGF2mSmallM(gF2mField3, i6);
            i6--;
        }
        int i8 = 0;
        while (i8 < i2) {
            if (polynomialGF2mSmallMArr[i8].e(i8) == 0) {
                int i9 = i8 + 1;
                boolean z = false;
                while (i9 < i2) {
                    if (polynomialGF2mSmallMArr[i9].e(i8) != 0) {
                        PolynomialGF2mSmallM polynomialGF2mSmallM3 = polynomialGF2mSmallMArr[i8];
                        polynomialGF2mSmallMArr[i8] = polynomialGF2mSmallMArr[i9];
                        polynomialGF2mSmallMArr[i9] = polynomialGF2mSmallM3;
                        PolynomialGF2mSmallM[] polynomialGF2mSmallMArr2 = this.b;
                        PolynomialGF2mSmallM polynomialGF2mSmallM4 = polynomialGF2mSmallMArr2[i8];
                        polynomialGF2mSmallMArr2[i8] = polynomialGF2mSmallMArr2[i9];
                        polynomialGF2mSmallMArr2[i9] = polynomialGF2mSmallM4;
                        i9 = i2;
                        z = true;
                    }
                    i9++;
                }
                if (!z) {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            int b2 = gF2mField3.b(polynomialGF2mSmallMArr[i8].e(i8));
            PolynomialGF2mSmallM polynomialGF2mSmallM5 = polynomialGF2mSmallMArr[i8];
            if (polynomialGF2mSmallM5.f6851a.c(b2)) {
                polynomialGF2mSmallM5.f6852a = polynomialGF2mSmallM5.j(b2, polynomialGF2mSmallM5.f6852a);
                polynomialGF2mSmallM5.c();
                PolynomialGF2mSmallM polynomialGF2mSmallM6 = this.b[i8];
                if (polynomialGF2mSmallM6.f6851a.c(b2)) {
                    polynomialGF2mSmallM6.f6852a = polynomialGF2mSmallM6.j(b2, polynomialGF2mSmallM6.f6852a);
                    polynomialGF2mSmallM6.c();
                    for (int i10 = 0; i10 < i2; i10++) {
                        if (!(i10 == i8 || (e = polynomialGF2mSmallMArr[i10].e(i8)) == 0)) {
                            PolynomialGF2mSmallM i11 = polynomialGF2mSmallMArr[i8].i(e);
                            PolynomialGF2mSmallM i12 = this.b[i8].i(e);
                            PolynomialGF2mSmallM polynomialGF2mSmallM7 = polynomialGF2mSmallMArr[i10];
                            polynomialGF2mSmallM7.f6852a = polynomialGF2mSmallM7.a(polynomialGF2mSmallM7.f6852a, i11.f6852a);
                            polynomialGF2mSmallM7.c();
                            PolynomialGF2mSmallM polynomialGF2mSmallM8 = this.b[i10];
                            polynomialGF2mSmallM8.f6852a = polynomialGF2mSmallM8.a(polynomialGF2mSmallM8.f6852a, i12.f6852a);
                            polynomialGF2mSmallM8.c();
                        }
                    }
                    i8++;
                } else {
                    throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
                }
            } else {
                throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
            }
        }
    }
}
