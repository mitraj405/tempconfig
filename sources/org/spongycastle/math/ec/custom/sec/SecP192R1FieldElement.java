package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;
import org.spongycastle.util.Arrays;

public class SecP192R1FieldElement extends ECFieldElement {
    public static final BigInteger g = SecP192R1Curve.c;
    public final int[] a;

    public SecP192R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        int[] g2 = Nat192.g(bigInteger);
        if (g2[5] == -1) {
            int[] iArr = SecP192R1Field.a;
            if (Nat192.i(g2, iArr)) {
                Nat192.r(iArr, g2);
            }
        }
        this.a = g2;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        int[] iArr = new int[6];
        if (Nat192.a(this.a, ((SecP192R1FieldElement) eCFieldElement).a, iArr) != 0 || (iArr[5] == -1 && Nat192.i(iArr, SecP192R1Field.a))) {
            SecP192R1Field.a(iArr);
        }
        return new SecP192R1FieldElement(iArr);
    }

    public final ECFieldElement b() {
        int[] iArr = new int[6];
        if (Nat.m(this.a, 6, iArr) != 0 || (iArr[5] == -1 && Nat192.i(iArr, SecP192R1Field.a))) {
            SecP192R1Field.a(iArr);
        }
        return new SecP192R1FieldElement(iArr);
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        int[] iArr = new int[6];
        Mod.b(SecP192R1Field.a, ((SecP192R1FieldElement) eCFieldElement).a, iArr);
        SecP192R1Field.b(iArr, this.a, iArr);
        return new SecP192R1FieldElement(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP192R1FieldElement)) {
            return false;
        }
        return Nat192.f(this.a, ((SecP192R1FieldElement) obj).a);
    }

    public final int f() {
        return g.bitLength();
    }

    public final ECFieldElement g() {
        int[] iArr = new int[6];
        Mod.b(SecP192R1Field.a, this.a, iArr);
        return new SecP192R1FieldElement(iArr);
    }

    public final boolean h() {
        return Nat192.j(this.a);
    }

    public final int hashCode() {
        return g.hashCode() ^ Arrays.s(6, this.a);
    }

    public final boolean i() {
        return Nat192.k(this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        int[] iArr = new int[6];
        SecP192R1Field.b(this.a, ((SecP192R1FieldElement) eCFieldElement).a, iArr);
        return new SecP192R1FieldElement(iArr);
    }

    public final ECFieldElement m() {
        int[] iArr = new int[6];
        int[] iArr2 = this.a;
        if (Nat192.k(iArr2)) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            iArr[5] = 0;
        } else {
            Nat192.p(SecP192R1Field.a, iArr2, iArr);
        }
        return new SecP192R1FieldElement(iArr);
    }

    public final ECFieldElement n() {
        int[] iArr = this.a;
        if (Nat192.k(iArr) || Nat192.j(iArr)) {
            return this;
        }
        int[] iArr2 = new int[6];
        int[] iArr3 = new int[6];
        SecP192R1Field.e(iArr, iArr2);
        SecP192R1Field.b(iArr2, iArr, iArr2);
        SecP192R1Field.f(iArr2, 2, iArr3);
        SecP192R1Field.b(iArr3, iArr2, iArr3);
        SecP192R1Field.f(iArr3, 4, iArr2);
        SecP192R1Field.b(iArr2, iArr3, iArr2);
        SecP192R1Field.f(iArr2, 8, iArr3);
        SecP192R1Field.b(iArr3, iArr2, iArr3);
        SecP192R1Field.f(iArr3, 16, iArr2);
        SecP192R1Field.b(iArr2, iArr3, iArr2);
        SecP192R1Field.f(iArr2, 32, iArr3);
        SecP192R1Field.b(iArr3, iArr2, iArr3);
        SecP192R1Field.f(iArr3, 64, iArr2);
        SecP192R1Field.b(iArr2, iArr3, iArr2);
        SecP192R1Field.f(iArr2, 62, iArr2);
        SecP192R1Field.e(iArr2, iArr3);
        if (Nat192.f(iArr, iArr3)) {
            return new SecP192R1FieldElement(iArr2);
        }
        return null;
    }

    public final ECFieldElement o() {
        int[] iArr = new int[6];
        SecP192R1Field.e(this.a, iArr);
        return new SecP192R1FieldElement(iArr);
    }

    public final ECFieldElement r(ECFieldElement eCFieldElement) {
        int[] iArr = new int[6];
        SecP192R1Field.g(this.a, ((SecP192R1FieldElement) eCFieldElement).a, iArr);
        return new SecP192R1FieldElement(iArr);
    }

    public final boolean s() {
        if ((this.a[0] & 1) == 1) {
            return true;
        }
        return false;
    }

    public final BigInteger t() {
        return Nat192.s(this.a);
    }

    public SecP192R1FieldElement() {
        this.a = new int[6];
    }

    public SecP192R1FieldElement(int[] iArr) {
        this.a = iArr;
    }
}
