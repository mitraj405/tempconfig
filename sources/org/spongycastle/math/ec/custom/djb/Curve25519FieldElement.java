package org.spongycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class Curve25519FieldElement extends ECFieldElement {
    public static final int[] b = {1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};
    public static final BigInteger g = Curve25519.c;
    public final int[] a;

    public Curve25519FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }
        int[] h = Nat256.h(bigInteger);
        while (true) {
            int[] iArr = Curve25519Field.a;
            if (Nat256.j(h, iArr)) {
                Nat256.t(iArr, h);
            } else {
                this.a = h;
                return;
            }
        }
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        int[] iArr = new int[8];
        Nat256.a(this.a, ((Curve25519FieldElement) eCFieldElement).a, iArr);
        if (Nat256.j(iArr, Curve25519Field.a)) {
            Curve25519Field.f(iArr);
        }
        return new Curve25519FieldElement(iArr);
    }

    public final ECFieldElement b() {
        int[] iArr = new int[8];
        Nat.m(this.a, 8, iArr);
        if (Nat256.j(iArr, Curve25519Field.a)) {
            Curve25519Field.f(iArr);
        }
        return new Curve25519FieldElement(iArr);
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        int[] iArr = new int[8];
        Mod.b(Curve25519Field.a, ((Curve25519FieldElement) eCFieldElement).a, iArr);
        Curve25519Field.a(iArr, this.a, iArr);
        return new Curve25519FieldElement(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Curve25519FieldElement)) {
            return false;
        }
        return Nat256.f(this.a, ((Curve25519FieldElement) obj).a);
    }

    public final int f() {
        return g.bitLength();
    }

    public final ECFieldElement g() {
        int[] iArr = new int[8];
        Mod.b(Curve25519Field.a, this.a, iArr);
        return new Curve25519FieldElement(iArr);
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
        Curve25519Field.a(this.a, ((Curve25519FieldElement) eCFieldElement).a, iArr);
        return new Curve25519FieldElement(iArr);
    }

    public final ECFieldElement m() {
        int[] iArr = new int[8];
        int[] iArr2 = this.a;
        if (Nat256.m(iArr2)) {
            Nat256.w(iArr);
        } else {
            Nat256.r(Curve25519Field.a, iArr2, iArr);
        }
        return new Curve25519FieldElement(iArr);
    }

    public final ECFieldElement n() {
        int[] iArr = this.a;
        if (Nat256.m(iArr) || Nat256.k(iArr)) {
            return this;
        }
        int[] iArr2 = new int[8];
        Curve25519Field.d(iArr, iArr2);
        Curve25519Field.a(iArr2, iArr, iArr2);
        Curve25519Field.d(iArr2, iArr2);
        Curve25519Field.a(iArr2, iArr, iArr2);
        int[] iArr3 = new int[8];
        Curve25519Field.d(iArr2, iArr3);
        Curve25519Field.a(iArr3, iArr, iArr3);
        int[] iArr4 = new int[8];
        Curve25519Field.e(iArr3, 3, iArr4);
        Curve25519Field.a(iArr4, iArr2, iArr4);
        Curve25519Field.e(iArr4, 4, iArr2);
        Curve25519Field.a(iArr2, iArr3, iArr2);
        Curve25519Field.e(iArr2, 4, iArr4);
        Curve25519Field.a(iArr4, iArr3, iArr4);
        Curve25519Field.e(iArr4, 15, iArr3);
        Curve25519Field.a(iArr3, iArr4, iArr3);
        Curve25519Field.e(iArr3, 30, iArr4);
        Curve25519Field.a(iArr4, iArr3, iArr4);
        Curve25519Field.e(iArr4, 60, iArr3);
        Curve25519Field.a(iArr3, iArr4, iArr3);
        Curve25519Field.e(iArr3, 11, iArr4);
        Curve25519Field.a(iArr4, iArr2, iArr4);
        Curve25519Field.e(iArr4, 120, iArr2);
        Curve25519Field.a(iArr2, iArr3, iArr2);
        Curve25519Field.d(iArr2, iArr2);
        Curve25519Field.d(iArr2, iArr3);
        if (Nat256.f(iArr, iArr3)) {
            return new Curve25519FieldElement(iArr2);
        }
        Curve25519Field.a(iArr2, b, iArr2);
        Curve25519Field.d(iArr2, iArr3);
        if (Nat256.f(iArr, iArr3)) {
            return new Curve25519FieldElement(iArr2);
        }
        return null;
    }

    public final ECFieldElement o() {
        int[] iArr = new int[8];
        Curve25519Field.d(this.a, iArr);
        return new Curve25519FieldElement(iArr);
    }

    public final ECFieldElement r(ECFieldElement eCFieldElement) {
        int[] iArr = new int[8];
        Curve25519Field.g(this.a, ((Curve25519FieldElement) eCFieldElement).a, iArr);
        return new Curve25519FieldElement(iArr);
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

    public Curve25519FieldElement() {
        this.a = new int[8];
    }

    public Curve25519FieldElement(int[] iArr) {
        this.a = iArr;
    }
}
