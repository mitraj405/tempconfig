package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class SecP256K1FieldElement extends ECFieldElement {
    public static final BigInteger g = SecP256K1Curve.c;
    public final int[] a;

    public SecP256K1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
        }
        int[] h = Nat256.h(bigInteger);
        if (h[7] == -1) {
            int[] iArr = SecP256K1Field.a;
            if (Nat256.j(h, iArr)) {
                Nat256.t(iArr, h);
            }
        }
        this.a = h;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        int[] iArr = new int[8];
        if (Nat256.a(this.a, ((SecP256K1FieldElement) eCFieldElement).a, iArr) != 0 || (iArr[7] == -1 && Nat256.j(iArr, SecP256K1Field.a))) {
            Nat.b(8, 977, iArr);
        }
        return new SecP256K1FieldElement(iArr);
    }

    public final ECFieldElement b() {
        int[] iArr = new int[8];
        if (Nat.m(this.a, 8, iArr) != 0 || (iArr[7] == -1 && Nat256.j(iArr, SecP256K1Field.a))) {
            Nat.b(8, 977, iArr);
        }
        return new SecP256K1FieldElement(iArr);
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        int[] iArr = new int[8];
        Mod.b(SecP256K1Field.a, ((SecP256K1FieldElement) eCFieldElement).a, iArr);
        SecP256K1Field.a(iArr, this.a, iArr);
        return new SecP256K1FieldElement(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP256K1FieldElement)) {
            return false;
        }
        return Nat256.f(this.a, ((SecP256K1FieldElement) obj).a);
    }

    public final int f() {
        return g.bitLength();
    }

    public final ECFieldElement g() {
        int[] iArr = new int[8];
        Mod.b(SecP256K1Field.a, this.a, iArr);
        return new SecP256K1FieldElement(iArr);
    }

    public final boolean h() {
        return Nat256.k(this.a);
    }

    public final int hashCode() {
        return g.hashCode() ^ Arrays.s(8, this.a);
    }

    public final boolean i() {
        return Nat256.m(this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        int[] iArr = new int[8];
        SecP256K1Field.a(this.a, ((SecP256K1FieldElement) eCFieldElement).a, iArr);
        return new SecP256K1FieldElement(iArr);
    }

    public final ECFieldElement m() {
        int[] iArr = new int[8];
        int[] iArr2 = this.a;
        if (Nat256.m(iArr2)) {
            Nat256.w(iArr);
        } else {
            Nat256.r(SecP256K1Field.a, iArr2, iArr);
        }
        return new SecP256K1FieldElement(iArr);
    }

    public final ECFieldElement n() {
        int[] iArr = this.a;
        if (Nat256.m(iArr) || Nat256.k(iArr)) {
            return this;
        }
        int[] iArr2 = new int[8];
        SecP256K1Field.d(iArr, iArr2);
        SecP256K1Field.a(iArr2, iArr, iArr2);
        int[] iArr3 = new int[8];
        SecP256K1Field.d(iArr2, iArr3);
        SecP256K1Field.a(iArr3, iArr, iArr3);
        int[] iArr4 = new int[8];
        SecP256K1Field.e(iArr3, 3, iArr4);
        SecP256K1Field.a(iArr4, iArr3, iArr4);
        SecP256K1Field.e(iArr4, 3, iArr4);
        SecP256K1Field.a(iArr4, iArr3, iArr4);
        SecP256K1Field.e(iArr4, 2, iArr4);
        SecP256K1Field.a(iArr4, iArr2, iArr4);
        int[] iArr5 = new int[8];
        SecP256K1Field.e(iArr4, 11, iArr5);
        SecP256K1Field.a(iArr5, iArr4, iArr5);
        SecP256K1Field.e(iArr5, 22, iArr4);
        SecP256K1Field.a(iArr4, iArr5, iArr4);
        int[] iArr6 = new int[8];
        SecP256K1Field.e(iArr4, 44, iArr6);
        SecP256K1Field.a(iArr6, iArr4, iArr6);
        int[] iArr7 = new int[8];
        SecP256K1Field.e(iArr6, 88, iArr7);
        SecP256K1Field.a(iArr7, iArr6, iArr7);
        SecP256K1Field.e(iArr7, 44, iArr6);
        SecP256K1Field.a(iArr6, iArr4, iArr6);
        SecP256K1Field.e(iArr6, 3, iArr4);
        SecP256K1Field.a(iArr4, iArr3, iArr4);
        SecP256K1Field.e(iArr4, 23, iArr4);
        SecP256K1Field.a(iArr4, iArr5, iArr4);
        SecP256K1Field.e(iArr4, 6, iArr4);
        SecP256K1Field.a(iArr4, iArr2, iArr4);
        SecP256K1Field.e(iArr4, 2, iArr4);
        SecP256K1Field.d(iArr4, iArr2);
        if (Nat256.f(iArr, iArr2)) {
            return new SecP256K1FieldElement(iArr4);
        }
        return null;
    }

    public final ECFieldElement o() {
        int[] iArr = new int[8];
        SecP256K1Field.d(this.a, iArr);
        return new SecP256K1FieldElement(iArr);
    }

    public final ECFieldElement r(ECFieldElement eCFieldElement) {
        int[] iArr = new int[8];
        SecP256K1Field.f(this.a, ((SecP256K1FieldElement) eCFieldElement).a, iArr);
        return new SecP256K1FieldElement(iArr);
    }

    public final boolean s() {
        if ((this.a[0] & 1) == 1) {
            return true;
        }
        return false;
    }

    public final BigInteger t() {
        return Nat256.u(this.a);
    }

    public SecP256K1FieldElement() {
        this.a = new int[8];
    }

    public SecP256K1FieldElement(int[] iArr) {
        this.a = iArr;
    }
}
