package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;

public class SecP521R1FieldElement extends ECFieldElement {
    public static final BigInteger g = SecP521R1Curve.c;
    public final int[] a;

    public SecP521R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        int[] j = Nat.j(521, bigInteger);
        if (Nat.i(j, 17, SecP521R1Field.a)) {
            for (int i = 0; i < 17; i++) {
                j[i] = 0;
            }
        }
        this.a = j;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        int[] iArr = new int[17];
        SecP521R1Field.a(this.a, ((SecP521R1FieldElement) eCFieldElement).a, iArr);
        return new SecP521R1FieldElement(iArr);
    }

    public final ECFieldElement b() {
        int[] iArr = new int[17];
        int[] iArr2 = this.a;
        int m = Nat.m(iArr2, 16, iArr) + iArr2[16];
        if (m > 511 || (m == 511 && Nat.i(iArr, 16, SecP521R1Field.a))) {
            m = (Nat.l(iArr) + m) & 511;
        }
        iArr[16] = m;
        return new SecP521R1FieldElement(iArr);
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        int[] iArr = new int[17];
        Mod.b(SecP521R1Field.a, ((SecP521R1FieldElement) eCFieldElement).a, iArr);
        SecP521R1Field.c(iArr, this.a, iArr);
        return new SecP521R1FieldElement(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP521R1FieldElement)) {
            return false;
        }
        return Nat.i(this.a, 17, ((SecP521R1FieldElement) obj).a);
    }

    public final int f() {
        return g.bitLength();
    }

    public final ECFieldElement g() {
        int[] iArr = new int[17];
        Mod.b(SecP521R1Field.a, this.a, iArr);
        return new SecP521R1FieldElement(iArr);
    }

    public final boolean h() {
        return Nat.p(17, this.a);
    }

    public final int hashCode() {
        return g.hashCode() ^ Arrays.s(17, this.a);
    }

    public final boolean i() {
        return Nat.q(17, this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        int[] iArr = new int[17];
        SecP521R1Field.c(this.a, ((SecP521R1FieldElement) eCFieldElement).a, iArr);
        return new SecP521R1FieldElement(iArr);
    }

    public final ECFieldElement m() {
        int[] iArr = new int[17];
        int[] iArr2 = this.a;
        if (Nat.q(17, iArr2)) {
            for (int i = 0; i < 17; i++) {
                iArr[i] = 0;
            }
        } else {
            Nat.u(17, SecP521R1Field.a, iArr2, iArr);
        }
        return new SecP521R1FieldElement(iArr);
    }

    public final ECFieldElement n() {
        int[] iArr = this.a;
        if (Nat.q(17, iArr) || Nat.p(17, iArr)) {
            return this;
        }
        int[] iArr2 = new int[17];
        int[] iArr3 = new int[17];
        int[] iArr4 = new int[33];
        SecP521R1Field.b(iArr, iArr4);
        SecP521R1Field.d(iArr4, iArr2);
        int i = 519;
        while (true) {
            i--;
            if (i <= 0) {
                break;
            }
            SecP521R1Field.b(iArr2, iArr4);
            SecP521R1Field.d(iArr4, iArr2);
        }
        SecP521R1Field.f(iArr2, iArr3);
        if (Nat.i(iArr, 17, iArr3)) {
            return new SecP521R1FieldElement(iArr2);
        }
        return null;
    }

    public final ECFieldElement o() {
        int[] iArr = new int[17];
        SecP521R1Field.f(this.a, iArr);
        return new SecP521R1FieldElement(iArr);
    }

    public final ECFieldElement r(ECFieldElement eCFieldElement) {
        int[] iArr = new int[17];
        SecP521R1Field.g(this.a, ((SecP521R1FieldElement) eCFieldElement).a, iArr);
        return new SecP521R1FieldElement(iArr);
    }

    public final boolean s() {
        if ((this.a[0] & 1) == 1) {
            return true;
        }
        return false;
    }

    public final BigInteger t() {
        return Nat.y(17, this.a);
    }

    public SecP521R1FieldElement() {
        this.a = new int[17];
    }

    public SecP521R1FieldElement(int[] iArr) {
        this.a = iArr;
    }
}
