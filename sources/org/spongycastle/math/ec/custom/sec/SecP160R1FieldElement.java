package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat160;
import org.spongycastle.util.Arrays;

public class SecP160R1FieldElement extends ECFieldElement {
    public static final BigInteger g = SecP160R1Curve.c;
    public final int[] a;

    public SecP160R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
        }
        int[] d = Nat160.d(bigInteger);
        if (d[4] == -1) {
            int[] iArr = SecP160R1Field.a;
            if (Nat160.e(d, iArr)) {
                Nat160.l(iArr, d);
            }
        }
        this.a = d;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        int[] iArr = new int[5];
        if (Nat160.a(this.a, ((SecP160R1FieldElement) eCFieldElement).a, iArr) != 0 || (iArr[4] == -1 && Nat160.e(iArr, SecP160R1Field.a))) {
            Nat.g(5, -2147483647, iArr);
        }
        return new SecP160R1FieldElement(iArr);
    }

    public final ECFieldElement b() {
        int[] iArr = new int[5];
        if (Nat.m(this.a, 5, iArr) != 0 || (iArr[4] == -1 && Nat160.e(iArr, SecP160R1Field.a))) {
            Nat.g(5, -2147483647, iArr);
        }
        return new SecP160R1FieldElement(iArr);
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        int[] iArr = new int[5];
        Mod.b(SecP160R1Field.a, ((SecP160R1FieldElement) eCFieldElement).a, iArr);
        SecP160R1Field.a(iArr, this.a, iArr);
        return new SecP160R1FieldElement(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP160R1FieldElement)) {
            return false;
        }
        return Nat160.c(this.a, ((SecP160R1FieldElement) obj).a);
    }

    public final int f() {
        return g.bitLength();
    }

    public final ECFieldElement g() {
        int[] iArr = new int[5];
        Mod.b(SecP160R1Field.a, this.a, iArr);
        return new SecP160R1FieldElement(iArr);
    }

    public final boolean h() {
        return Nat160.f(this.a);
    }

    public final int hashCode() {
        return g.hashCode() ^ Arrays.s(5, this.a);
    }

    public final boolean i() {
        return Nat160.g(this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        int[] iArr = new int[5];
        SecP160R1Field.a(this.a, ((SecP160R1FieldElement) eCFieldElement).a, iArr);
        return new SecP160R1FieldElement(iArr);
    }

    public final ECFieldElement m() {
        int[] iArr = new int[5];
        int[] iArr2 = this.a;
        if (Nat160.g(iArr2)) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
        } else {
            Nat160.k(SecP160R1Field.a, iArr2, iArr);
        }
        return new SecP160R1FieldElement(iArr);
    }

    public final ECFieldElement n() {
        int[] iArr = this.a;
        if (Nat160.g(iArr) || Nat160.f(iArr)) {
            return this;
        }
        int[] iArr2 = new int[5];
        SecP160R1Field.d(iArr, iArr2);
        SecP160R1Field.a(iArr2, iArr, iArr2);
        int[] iArr3 = new int[5];
        SecP160R1Field.e(iArr2, 2, iArr3);
        SecP160R1Field.a(iArr3, iArr2, iArr3);
        SecP160R1Field.e(iArr3, 4, iArr2);
        SecP160R1Field.a(iArr2, iArr3, iArr2);
        SecP160R1Field.e(iArr2, 8, iArr3);
        SecP160R1Field.a(iArr3, iArr2, iArr3);
        SecP160R1Field.e(iArr3, 16, iArr2);
        SecP160R1Field.a(iArr2, iArr3, iArr2);
        SecP160R1Field.e(iArr2, 32, iArr3);
        SecP160R1Field.a(iArr3, iArr2, iArr3);
        SecP160R1Field.e(iArr3, 64, iArr2);
        SecP160R1Field.a(iArr2, iArr3, iArr2);
        SecP160R1Field.d(iArr2, iArr3);
        SecP160R1Field.a(iArr3, iArr, iArr3);
        SecP160R1Field.e(iArr3, 29, iArr3);
        SecP160R1Field.d(iArr3, iArr2);
        if (Nat160.c(iArr, iArr2)) {
            return new SecP160R1FieldElement(iArr3);
        }
        return null;
    }

    public final ECFieldElement o() {
        int[] iArr = new int[5];
        SecP160R1Field.d(this.a, iArr);
        return new SecP160R1FieldElement(iArr);
    }

    public final ECFieldElement r(ECFieldElement eCFieldElement) {
        int[] iArr = new int[5];
        SecP160R1Field.f(this.a, ((SecP160R1FieldElement) eCFieldElement).a, iArr);
        return new SecP160R1FieldElement(iArr);
    }

    public final boolean s() {
        if ((this.a[0] & 1) == 1) {
            return true;
        }
        return false;
    }

    public final BigInteger t() {
        return Nat160.m(this.a);
    }

    public SecP160R1FieldElement() {
        this.a = new int[5];
    }

    public SecP160R1FieldElement(int[] iArr) {
        this.a = iArr;
    }
}
