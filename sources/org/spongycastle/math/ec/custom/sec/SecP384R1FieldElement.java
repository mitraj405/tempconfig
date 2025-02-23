package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;

public class SecP384R1FieldElement extends ECFieldElement {
    public static final BigInteger g = SecP384R1Curve.c;
    public final int[] a;

    public SecP384R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        int[] j = Nat.j(384, bigInteger);
        if (j[11] == -1) {
            int[] iArr = SecP384R1Field.a;
            if (Nat.k(j, 12, iArr)) {
                Nat.x(iArr, 12, j);
            }
        }
        this.a = j;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        int[] iArr = new int[12];
        if (Nat.a(12, this.a, ((SecP384R1FieldElement) eCFieldElement).a, iArr) != 0 || (iArr[11] == -1 && Nat.k(iArr, 12, SecP384R1Field.a))) {
            SecP384R1Field.a(iArr);
        }
        return new SecP384R1FieldElement(iArr);
    }

    public final ECFieldElement b() {
        int[] iArr = new int[12];
        if (Nat.m(this.a, 12, iArr) != 0 || (iArr[11] == -1 && Nat.k(iArr, 12, SecP384R1Field.a))) {
            SecP384R1Field.a(iArr);
        }
        return new SecP384R1FieldElement(iArr);
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        int[] iArr = new int[12];
        Mod.b(SecP384R1Field.a, ((SecP384R1FieldElement) eCFieldElement).a, iArr);
        SecP384R1Field.b(iArr, this.a, iArr);
        return new SecP384R1FieldElement(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP384R1FieldElement)) {
            return false;
        }
        return Nat.i(this.a, 12, ((SecP384R1FieldElement) obj).a);
    }

    public final int f() {
        return g.bitLength();
    }

    public final ECFieldElement g() {
        int[] iArr = new int[12];
        Mod.b(SecP384R1Field.a, this.a, iArr);
        return new SecP384R1FieldElement(iArr);
    }

    public final boolean h() {
        return Nat.p(12, this.a);
    }

    public final int hashCode() {
        return g.hashCode() ^ Arrays.s(12, this.a);
    }

    public final boolean i() {
        return Nat.q(12, this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        int[] iArr = new int[12];
        SecP384R1Field.b(this.a, ((SecP384R1FieldElement) eCFieldElement).a, iArr);
        return new SecP384R1FieldElement(iArr);
    }

    public final ECFieldElement m() {
        int[] iArr = new int[12];
        int[] iArr2 = this.a;
        if (Nat.q(12, iArr2)) {
            for (int i = 0; i < 12; i++) {
                iArr[i] = 0;
            }
        } else {
            Nat.u(12, SecP384R1Field.a, iArr2, iArr);
        }
        return new SecP384R1FieldElement(iArr);
    }

    public final ECFieldElement n() {
        int[] iArr = this.a;
        if (Nat.q(12, iArr) || Nat.p(12, iArr)) {
            return this;
        }
        int[] iArr2 = new int[12];
        int[] iArr3 = new int[12];
        int[] iArr4 = new int[12];
        int[] iArr5 = new int[12];
        SecP384R1Field.e(iArr, iArr2);
        SecP384R1Field.b(iArr2, iArr, iArr2);
        SecP384R1Field.f(iArr2, 2, iArr3);
        SecP384R1Field.b(iArr3, iArr2, iArr3);
        SecP384R1Field.e(iArr3, iArr3);
        SecP384R1Field.b(iArr3, iArr, iArr3);
        SecP384R1Field.f(iArr3, 5, iArr4);
        SecP384R1Field.b(iArr4, iArr3, iArr4);
        SecP384R1Field.f(iArr4, 5, iArr5);
        SecP384R1Field.b(iArr5, iArr3, iArr5);
        SecP384R1Field.f(iArr5, 15, iArr3);
        SecP384R1Field.b(iArr3, iArr5, iArr3);
        SecP384R1Field.f(iArr3, 2, iArr4);
        SecP384R1Field.b(iArr2, iArr4, iArr2);
        SecP384R1Field.f(iArr4, 28, iArr4);
        SecP384R1Field.b(iArr3, iArr4, iArr3);
        SecP384R1Field.f(iArr3, 60, iArr4);
        SecP384R1Field.b(iArr4, iArr3, iArr4);
        SecP384R1Field.f(iArr4, 120, iArr3);
        SecP384R1Field.b(iArr3, iArr4, iArr3);
        SecP384R1Field.f(iArr3, 15, iArr3);
        SecP384R1Field.b(iArr3, iArr5, iArr3);
        SecP384R1Field.f(iArr3, 33, iArr3);
        SecP384R1Field.b(iArr3, iArr2, iArr3);
        SecP384R1Field.f(iArr3, 64, iArr3);
        SecP384R1Field.b(iArr3, iArr, iArr3);
        SecP384R1Field.f(iArr3, 30, iArr2);
        SecP384R1Field.e(iArr2, iArr3);
        if (Nat.i(iArr, 12, iArr3)) {
            return new SecP384R1FieldElement(iArr2);
        }
        return null;
    }

    public final ECFieldElement o() {
        int[] iArr = new int[12];
        SecP384R1Field.e(this.a, iArr);
        return new SecP384R1FieldElement(iArr);
    }

    public final ECFieldElement r(ECFieldElement eCFieldElement) {
        int[] iArr = new int[12];
        SecP384R1Field.g(this.a, ((SecP384R1FieldElement) eCFieldElement).a, iArr);
        return new SecP384R1FieldElement(iArr);
    }

    public final boolean s() {
        if ((this.a[0] & 1) == 1) {
            return true;
        }
        return false;
    }

    public final BigInteger t() {
        return Nat.y(12, this.a);
    }

    public SecP384R1FieldElement() {
        this.a = new int[12];
    }

    public SecP384R1FieldElement(int[] iArr) {
        this.a = iArr;
    }
}
