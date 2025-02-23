package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;
import org.spongycastle.util.Arrays;

public class SecP224K1FieldElement extends ECFieldElement {
    public static final int[] b = {868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};
    public static final BigInteger g = SecP224K1Curve.c;
    public final int[] a;

    public SecP224K1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        int[] e = Nat224.e(bigInteger);
        if (e[6] == -1 && Nat224.f(e, SecP224K1Field.a)) {
            Nat.b(7, 6803, e);
        }
        this.a = e;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        int[] iArr = new int[7];
        if (Nat224.a(this.a, ((SecP224K1FieldElement) eCFieldElement).a, iArr) != 0 || (iArr[6] == -1 && Nat224.f(iArr, SecP224K1Field.a))) {
            Nat.b(7, 6803, iArr);
        }
        return new SecP224K1FieldElement(iArr);
    }

    public final ECFieldElement b() {
        int[] iArr = new int[7];
        if (Nat.m(this.a, 7, iArr) != 0 || (iArr[6] == -1 && Nat224.f(iArr, SecP224K1Field.a))) {
            Nat.b(7, 6803, iArr);
        }
        return new SecP224K1FieldElement(iArr);
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        int[] iArr = new int[7];
        Mod.b(SecP224K1Field.a, ((SecP224K1FieldElement) eCFieldElement).a, iArr);
        SecP224K1Field.a(iArr, this.a, iArr);
        return new SecP224K1FieldElement(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP224K1FieldElement)) {
            return false;
        }
        return Nat224.d(this.a, ((SecP224K1FieldElement) obj).a);
    }

    public final int f() {
        return g.bitLength();
    }

    public final ECFieldElement g() {
        int[] iArr = new int[7];
        Mod.b(SecP224K1Field.a, this.a, iArr);
        return new SecP224K1FieldElement(iArr);
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
        SecP224K1Field.a(this.a, ((SecP224K1FieldElement) eCFieldElement).a, iArr);
        return new SecP224K1FieldElement(iArr);
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
            Nat224.l(SecP224K1Field.a, iArr2, iArr);
        }
        return new SecP224K1FieldElement(iArr);
    }

    public final ECFieldElement n() {
        int[] iArr = this.a;
        if (Nat224.h(iArr) || Nat224.g(iArr)) {
            return this;
        }
        int[] iArr2 = new int[7];
        SecP224K1Field.d(iArr, iArr2);
        SecP224K1Field.a(iArr2, iArr, iArr2);
        SecP224K1Field.d(iArr2, iArr2);
        SecP224K1Field.a(iArr2, iArr, iArr2);
        int[] iArr3 = new int[7];
        SecP224K1Field.d(iArr2, iArr3);
        SecP224K1Field.a(iArr3, iArr, iArr3);
        int[] iArr4 = new int[7];
        SecP224K1Field.e(iArr3, 4, iArr4);
        SecP224K1Field.a(iArr4, iArr3, iArr4);
        int[] iArr5 = new int[7];
        SecP224K1Field.e(iArr4, 3, iArr5);
        SecP224K1Field.a(iArr5, iArr2, iArr5);
        SecP224K1Field.e(iArr5, 8, iArr5);
        SecP224K1Field.a(iArr5, iArr4, iArr5);
        SecP224K1Field.e(iArr5, 4, iArr4);
        SecP224K1Field.a(iArr4, iArr3, iArr4);
        SecP224K1Field.e(iArr4, 19, iArr3);
        SecP224K1Field.a(iArr3, iArr5, iArr3);
        int[] iArr6 = new int[7];
        SecP224K1Field.e(iArr3, 42, iArr6);
        SecP224K1Field.a(iArr6, iArr3, iArr6);
        SecP224K1Field.e(iArr6, 23, iArr3);
        SecP224K1Field.a(iArr3, iArr4, iArr3);
        SecP224K1Field.e(iArr3, 84, iArr4);
        SecP224K1Field.a(iArr4, iArr6, iArr4);
        SecP224K1Field.e(iArr4, 20, iArr4);
        SecP224K1Field.a(iArr4, iArr5, iArr4);
        SecP224K1Field.e(iArr4, 3, iArr4);
        SecP224K1Field.a(iArr4, iArr, iArr4);
        SecP224K1Field.e(iArr4, 2, iArr4);
        SecP224K1Field.a(iArr4, iArr, iArr4);
        SecP224K1Field.e(iArr4, 4, iArr4);
        SecP224K1Field.a(iArr4, iArr2, iArr4);
        SecP224K1Field.d(iArr4, iArr4);
        SecP224K1Field.d(iArr4, iArr6);
        if (Nat224.d(iArr, iArr6)) {
            return new SecP224K1FieldElement(iArr4);
        }
        SecP224K1Field.a(iArr4, b, iArr4);
        SecP224K1Field.d(iArr4, iArr6);
        if (Nat224.d(iArr, iArr6)) {
            return new SecP224K1FieldElement(iArr4);
        }
        return null;
    }

    public final ECFieldElement o() {
        int[] iArr = new int[7];
        SecP224K1Field.d(this.a, iArr);
        return new SecP224K1FieldElement(iArr);
    }

    public final ECFieldElement r(ECFieldElement eCFieldElement) {
        int[] iArr = new int[7];
        SecP224K1Field.f(this.a, ((SecP224K1FieldElement) eCFieldElement).a, iArr);
        return new SecP224K1FieldElement(iArr);
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

    public SecP224K1FieldElement() {
        this.a = new int[7];
    }

    public SecP224K1FieldElement(int[] iArr) {
        this.a = iArr;
    }
}
