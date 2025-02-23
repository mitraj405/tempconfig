package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;
import org.spongycastle.util.Arrays;

public class SecP224R1FieldElement extends ECFieldElement {
    public static final BigInteger g = SecP224R1Curve.c;
    public final int[] a;

    public SecP224R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        int[] e = Nat224.e(bigInteger);
        if (e[6] == -1) {
            int[] iArr = SecP224R1Field.a;
            if (Nat224.f(e, iArr)) {
                long j = ((((long) e[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
                e[0] = (int) j;
                long j2 = ((((long) e[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) + (j >> 32);
                e[1] = (int) j2;
                long j3 = ((((long) e[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) + (j2 >> 32);
                e[2] = (int) j3;
                long j4 = ((((long) e[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) + (j3 >> 32);
                e[3] = (int) j4;
                long j5 = ((((long) e[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) + (j4 >> 32);
                e[4] = (int) j5;
                long j6 = ((((long) e[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L)) + (j5 >> 32);
                e[5] = (int) j6;
                e[6] = (int) (((((long) e[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L)) + (j6 >> 32));
            }
        }
        this.a = e;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        int[] iArr = new int[7];
        SecP224R1Field.a(this.a, ((SecP224R1FieldElement) eCFieldElement).a, iArr);
        return new SecP224R1FieldElement(iArr);
    }

    public final ECFieldElement b() {
        int[] iArr = new int[7];
        if (Nat.m(this.a, 7, iArr) != 0 || (iArr[6] == -1 && Nat224.f(iArr, SecP224R1Field.a))) {
            SecP224R1Field.b(iArr);
        }
        return new SecP224R1FieldElement(iArr);
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        int[] iArr = new int[7];
        Mod.b(SecP224R1Field.a, ((SecP224R1FieldElement) eCFieldElement).a, iArr);
        SecP224R1Field.c(iArr, this.a, iArr);
        return new SecP224R1FieldElement(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP224R1FieldElement)) {
            return false;
        }
        return Nat224.d(this.a, ((SecP224R1FieldElement) obj).a);
    }

    public final int f() {
        return g.bitLength();
    }

    public final ECFieldElement g() {
        int[] iArr = new int[7];
        Mod.b(SecP224R1Field.a, this.a, iArr);
        return new SecP224R1FieldElement(iArr);
    }

    public final boolean h() {
        return Nat224.g(this.a);
    }

    public final int hashCode() {
        return g.hashCode() ^ Arrays.s(7, this.a);
    }

    public final boolean i() {
        return Nat224.h(this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        int[] iArr = new int[7];
        SecP224R1Field.c(this.a, ((SecP224R1FieldElement) eCFieldElement).a, iArr);
        return new SecP224R1FieldElement(iArr);
    }

    public final ECFieldElement m() {
        int[] iArr = new int[7];
        int[] iArr2 = this.a;
        if (Nat224.h(iArr2)) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            iArr[5] = 0;
            iArr[6] = 0;
        } else {
            Nat224.l(SecP224R1Field.a, iArr2, iArr);
        }
        return new SecP224R1FieldElement(iArr);
    }

    public final ECFieldElement n() {
        boolean z;
        char c;
        int[] iArr = this.a;
        if (Nat224.h(iArr) || Nat224.g(iArr)) {
            return this;
        }
        int[] iArr2 = new int[7];
        boolean h = Nat224.h(iArr);
        int i = 0;
        int[] iArr3 = SecP224R1Field.a;
        int i2 = 1;
        if (h) {
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            iArr2[4] = 0;
            iArr2[5] = 0;
            iArr2[6] = 0;
        } else {
            Nat224.l(iArr3, iArr, iArr2);
        }
        Random random = new Random();
        int[] iArr4 = new int[7];
        int i3 = iArr3[6];
        int i4 = i3 | (i3 >>> 1);
        int i5 = i4 | (i4 >>> 2);
        int i6 = i5 | (i5 >>> 4);
        int i7 = i6 | (i6 >>> 8);
        int i8 = i7 | (i7 >>> 16);
        do {
            for (int i9 = 0; i9 != 7; i9++) {
                iArr4[i9] = random.nextInt();
            }
            iArr4[6] = iArr4[6] & i8;
        } while (Nat.k(iArr4, 7, iArr3));
        int[] iArr5 = new int[7];
        int[] iArr6 = new int[7];
        int[] iArr7 = new int[7];
        Nat224.c(iArr, iArr6);
        for (int i10 = 0; i10 < 7; i10++) {
            Nat224.c(iArr6, iArr7);
            int i11 = 1 << i10;
            int[] iArr8 = new int[14];
            Nat224.k(iArr6, iArr8);
            SecP224R1Field.d(iArr8, iArr6);
            while (true) {
                i11--;
                if (i11 <= 0) {
                    break;
                }
                Nat224.k(iArr6, iArr8);
                SecP224R1Field.d(iArr8, iArr6);
            }
            SecP224R1Field.c(iArr6, iArr7, iArr6);
        }
        int[] iArr9 = new int[14];
        Nat224.k(iArr6, iArr9);
        SecP224R1Field.d(iArr9, iArr6);
        int i12 = 95;
        while (true) {
            i12--;
            if (i12 <= 0) {
                break;
            }
            Nat224.k(iArr6, iArr9);
            SecP224R1Field.d(iArr9, iArr6);
        }
        if (!Nat224.g(iArr6)) {
            return null;
        }
        while (true) {
            int[] iArr10 = new int[7];
            Nat224.c(iArr4, iArr10);
            int[] iArr11 = new int[7];
            iArr11[i] = i2;
            int[] iArr12 = new int[7];
            Nat224.c(iArr2, iArr12);
            int[] iArr13 = new int[7];
            int[] iArr14 = new int[7];
            int i13 = i;
            while (i13 < 7) {
                Nat224.c(iArr10, iArr13);
                Nat224.c(iArr11, iArr14);
                int i14 = i2 << i13;
                while (true) {
                    i14--;
                    if (i14 < 0) {
                        break;
                    }
                    SecP224R1Field.c(iArr11, iArr10, iArr11);
                    if (Nat.r(7, i, iArr11, iArr11) != 0 || (iArr11[6] == -1 && Nat224.f(iArr11, iArr3))) {
                        SecP224R1Field.b(iArr11);
                    }
                    SecP224R1Field.f(iArr10, iArr5);
                    SecP224R1Field.a(iArr12, iArr5, iArr10);
                    SecP224R1Field.c(iArr12, iArr5, iArr12);
                    SecP224R1Field.e(Nat.s(7, iArr12), iArr12);
                }
                SecP224R1Field.c(iArr11, iArr14, iArr5);
                SecP224R1Field.c(iArr5, iArr2, iArr5);
                SecP224R1Field.c(iArr10, iArr13, iArr12);
                SecP224R1Field.a(iArr12, iArr5, iArr12);
                SecP224R1Field.c(iArr10, iArr14, iArr5);
                Nat224.c(iArr12, iArr10);
                SecP224R1Field.c(iArr11, iArr13, iArr11);
                SecP224R1Field.a(iArr11, iArr5, iArr11);
                SecP224R1Field.f(iArr11, iArr12);
                SecP224R1Field.c(iArr12, iArr2, iArr12);
                i13++;
                i2 = 1;
            }
            int[] iArr15 = new int[7];
            int[] iArr16 = new int[7];
            int i15 = 1;
            while (true) {
                if (i15 >= 96) {
                    z = false;
                    break;
                }
                Nat224.c(iArr10, iArr15);
                Nat224.c(iArr11, iArr16);
                SecP224R1Field.c(iArr11, iArr10, iArr11);
                if (Nat.r(7, i, iArr11, iArr11) != 0 || (iArr11[6] == -1 && Nat224.f(iArr11, iArr3))) {
                    SecP224R1Field.b(iArr11);
                }
                SecP224R1Field.f(iArr10, iArr5);
                SecP224R1Field.a(iArr12, iArr5, iArr10);
                SecP224R1Field.c(iArr12, iArr5, iArr12);
                SecP224R1Field.e(Nat.s(7, iArr12), iArr12);
                if (Nat224.h(iArr10)) {
                    Mod.b(iArr3, iArr16, iArr5);
                    SecP224R1Field.c(iArr5, iArr15, iArr5);
                    z = true;
                    break;
                }
                i15++;
                i = 0;
            }
            if (z) {
                break;
            }
            if (Nat.m(iArr4, 7, iArr4) == 0) {
                c = 6;
                if (iArr4[6] == -1) {
                    if (!Nat224.f(iArr4, iArr3)) {
                    }
                }
                char c2 = c;
                i = 0;
                i2 = 1;
            } else {
                c = 6;
            }
            SecP224R1Field.b(iArr4);
            char c22 = c;
            i = 0;
            i2 = 1;
        }
        SecP224R1Field.f(iArr5, iArr4);
        if (Nat224.d(iArr, iArr4)) {
            return new SecP224R1FieldElement(iArr5);
        }
        return null;
    }

    public final ECFieldElement o() {
        int[] iArr = new int[7];
        SecP224R1Field.f(this.a, iArr);
        return new SecP224R1FieldElement(iArr);
    }

    public final ECFieldElement r(ECFieldElement eCFieldElement) {
        int[] iArr = new int[7];
        SecP224R1Field.g(this.a, ((SecP224R1FieldElement) eCFieldElement).a, iArr);
        return new SecP224R1FieldElement(iArr);
    }

    public final boolean s() {
        if ((this.a[0] & 1) == 1) {
            return true;
        }
        return false;
    }

    public final BigInteger t() {
        return Nat224.m(this.a);
    }

    public SecP224R1FieldElement() {
        this.a = new int[7];
    }

    public SecP224R1FieldElement(int[] iArr) {
        this.a = iArr;
    }
}
