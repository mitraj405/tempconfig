package org.spongycastle.math.ec.custom.gm;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class SM2P256V1FieldElement extends ECFieldElement {
    public static final BigInteger g = SM2P256V1Curve.c;
    public final int[] a;

    public SM2P256V1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
        }
        int[] h = Nat256.h(bigInteger);
        if ((h[7] >>> 1) >= Integer.MAX_VALUE) {
            int[] iArr = SM2P256V1Field.a;
            if (Nat256.j(h, iArr)) {
                Nat256.t(iArr, h);
            }
        }
        this.a = h;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        int[] iArr = new int[8];
        if (Nat256.a(this.a, ((SM2P256V1FieldElement) eCFieldElement).a, iArr) != 0 || ((iArr[7] >>> 1) >= Integer.MAX_VALUE && Nat256.j(iArr, SM2P256V1Field.a))) {
            SM2P256V1Field.a(iArr);
        }
        return new SM2P256V1FieldElement(iArr);
    }

    public final ECFieldElement b() {
        int[] iArr = new int[8];
        if (Nat.m(this.a, 8, iArr) != 0 || ((iArr[7] >>> 1) >= Integer.MAX_VALUE && Nat256.j(iArr, SM2P256V1Field.a))) {
            SM2P256V1Field.a(iArr);
        }
        return new SM2P256V1FieldElement(iArr);
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        int[] iArr = new int[8];
        Mod.b(SM2P256V1Field.a, ((SM2P256V1FieldElement) eCFieldElement).a, iArr);
        SM2P256V1Field.b(iArr, this.a, iArr);
        return new SM2P256V1FieldElement(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SM2P256V1FieldElement)) {
            return false;
        }
        return Nat256.f(this.a, ((SM2P256V1FieldElement) obj).a);
    }

    public final int f() {
        return g.bitLength();
    }

    public final ECFieldElement g() {
        int[] iArr = new int[8];
        Mod.b(SM2P256V1Field.a, this.a, iArr);
        return new SM2P256V1FieldElement(iArr);
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
        SM2P256V1Field.b(this.a, ((SM2P256V1FieldElement) eCFieldElement).a, iArr);
        return new SM2P256V1FieldElement(iArr);
    }

    public final ECFieldElement m() {
        int[] iArr = new int[8];
        int[] iArr2 = this.a;
        if (Nat256.m(iArr2)) {
            Nat256.w(iArr);
        } else {
            Nat256.r(SM2P256V1Field.a, iArr2, iArr);
        }
        return new SM2P256V1FieldElement(iArr);
    }

    public final ECFieldElement n() {
        int[] iArr = this.a;
        if (Nat256.m(iArr) || Nat256.k(iArr)) {
            return this;
        }
        int[] iArr2 = new int[8];
        SM2P256V1Field.e(iArr, iArr2);
        SM2P256V1Field.b(iArr2, iArr, iArr2);
        int[] iArr3 = new int[8];
        SM2P256V1Field.f(iArr2, 2, iArr3);
        SM2P256V1Field.b(iArr3, iArr2, iArr3);
        int[] iArr4 = new int[8];
        SM2P256V1Field.f(iArr3, 2, iArr4);
        SM2P256V1Field.b(iArr4, iArr2, iArr4);
        SM2P256V1Field.f(iArr4, 6, iArr2);
        SM2P256V1Field.b(iArr2, iArr4, iArr2);
        int[] iArr5 = new int[8];
        SM2P256V1Field.f(iArr2, 12, iArr5);
        SM2P256V1Field.b(iArr5, iArr2, iArr5);
        SM2P256V1Field.f(iArr5, 6, iArr2);
        SM2P256V1Field.b(iArr2, iArr4, iArr2);
        SM2P256V1Field.e(iArr2, iArr4);
        SM2P256V1Field.b(iArr4, iArr, iArr4);
        SM2P256V1Field.f(iArr4, 31, iArr5);
        SM2P256V1Field.b(iArr5, iArr4, iArr2);
        SM2P256V1Field.f(iArr5, 32, iArr5);
        SM2P256V1Field.b(iArr5, iArr2, iArr5);
        SM2P256V1Field.f(iArr5, 62, iArr5);
        SM2P256V1Field.b(iArr5, iArr2, iArr5);
        SM2P256V1Field.f(iArr5, 4, iArr5);
        SM2P256V1Field.b(iArr5, iArr3, iArr5);
        SM2P256V1Field.f(iArr5, 32, iArr5);
        SM2P256V1Field.b(iArr5, iArr, iArr5);
        SM2P256V1Field.f(iArr5, 62, iArr5);
        SM2P256V1Field.e(iArr5, iArr3);
        if (Nat256.f(iArr, iArr3)) {
            return new SM2P256V1FieldElement(iArr5);
        }
        return null;
    }

    public final ECFieldElement o() {
        int[] iArr = new int[8];
        SM2P256V1Field.e(this.a, iArr);
        return new SM2P256V1FieldElement(iArr);
    }

    public final ECFieldElement r(ECFieldElement eCFieldElement) {
        int[] iArr = new int[8];
        SM2P256V1Field.g(this.a, ((SM2P256V1FieldElement) eCFieldElement).a, iArr);
        return new SM2P256V1FieldElement(iArr);
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

    public SM2P256V1FieldElement() {
        this.a = new int[8];
    }

    public SM2P256V1FieldElement(int[] iArr) {
        this.a = iArr;
    }
}
