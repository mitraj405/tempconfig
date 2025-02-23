package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat128;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class SecP128R1FieldElement extends ECFieldElement {
    public static final BigInteger g = SecP128R1Curve.c;
    public final int[] a;

    public SecP128R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        } else if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        } else {
            int[] iArr = new int[4];
            int i = 0;
            while (bigInteger.signum() != 0) {
                iArr[i] = bigInteger.intValue();
                bigInteger = bigInteger.shiftRight(32);
                i++;
            }
            if ((iArr[3] >>> 1) >= 2147483646) {
                int[] iArr2 = SecP128R1Field.a;
                if (Nat128.b(iArr, iArr2)) {
                    long j = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
                    iArr[0] = (int) j;
                    long j2 = ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L)) + (j >> 32);
                    iArr[1] = (int) j2;
                    long j3 = ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L)) + (j2 >> 32);
                    iArr[2] = (int) j3;
                    iArr[3] = (int) (((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L)) + (j3 >> 32));
                }
            }
            this.a = iArr;
        }
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        int[] iArr = new int[4];
        SecP128R1Field.a(this.a, ((SecP128R1FieldElement) eCFieldElement).a, iArr);
        return new SecP128R1FieldElement(iArr);
    }

    public final ECFieldElement b() {
        int[] iArr = new int[4];
        if (Nat.m(this.a, 4, iArr) != 0 || ((iArr[3] >>> 1) >= 2147483646 && Nat128.b(iArr, SecP128R1Field.a))) {
            SecP128R1Field.b(iArr);
        }
        return new SecP128R1FieldElement(iArr);
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        int[] iArr = new int[4];
        Mod.b(SecP128R1Field.a, ((SecP128R1FieldElement) eCFieldElement).a, iArr);
        SecP128R1Field.c(iArr, this.a, iArr);
        return new SecP128R1FieldElement(iArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP128R1FieldElement)) {
            return false;
        }
        int[] iArr = ((SecP128R1FieldElement) obj).a;
        for (int i = 3; i >= 0; i--) {
            if (this.a[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int f() {
        return g.bitLength();
    }

    public final ECFieldElement g() {
        int[] iArr = new int[4];
        Mod.b(SecP128R1Field.a, this.a, iArr);
        return new SecP128R1FieldElement(iArr);
    }

    public final boolean h() {
        int[] iArr = this.a;
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return g.hashCode() ^ Arrays.s(4, this.a);
    }

    public final boolean i() {
        return Nat128.c(this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        int[] iArr = new int[4];
        SecP128R1Field.c(this.a, ((SecP128R1FieldElement) eCFieldElement).a, iArr);
        return new SecP128R1FieldElement(iArr);
    }

    public final ECFieldElement m() {
        int[] iArr = new int[4];
        int[] iArr2 = this.a;
        if (Nat128.c(iArr2)) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
        } else {
            Nat128.f(SecP128R1Field.a, iArr2, iArr);
        }
        return new SecP128R1FieldElement(iArr);
    }

    public final ECFieldElement n() {
        boolean z;
        int[] iArr = this.a;
        if (!Nat128.c(iArr)) {
            boolean z2 = false;
            if (iArr[0] == 1) {
                int i = 1;
                while (true) {
                    if (i >= 4) {
                        z = true;
                        break;
                    } else if (iArr[i] != 0) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            z = false;
            if (!z) {
                int[] iArr2 = new int[4];
                SecP128R1Field.f(iArr, iArr2);
                SecP128R1Field.c(iArr2, iArr, iArr2);
                int[] iArr3 = new int[4];
                SecP128R1Field.g(iArr2, 2, iArr3);
                SecP128R1Field.c(iArr3, iArr2, iArr3);
                int[] iArr4 = new int[4];
                SecP128R1Field.g(iArr3, 4, iArr4);
                SecP128R1Field.c(iArr4, iArr3, iArr4);
                SecP128R1Field.g(iArr4, 2, iArr3);
                SecP128R1Field.c(iArr3, iArr2, iArr3);
                SecP128R1Field.g(iArr3, 10, iArr2);
                SecP128R1Field.c(iArr2, iArr3, iArr2);
                SecP128R1Field.g(iArr2, 10, iArr4);
                SecP128R1Field.c(iArr4, iArr3, iArr4);
                SecP128R1Field.f(iArr4, iArr3);
                SecP128R1Field.c(iArr3, iArr, iArr3);
                SecP128R1Field.g(iArr3, 95, iArr3);
                SecP128R1Field.f(iArr3, iArr4);
                int i2 = 3;
                while (true) {
                    if (i2 < 0) {
                        z2 = true;
                        break;
                    } else if (iArr[i2] != iArr4[i2]) {
                        break;
                    } else {
                        i2--;
                    }
                }
                if (z2) {
                    return new SecP128R1FieldElement(iArr3);
                }
                return null;
            }
        }
        return this;
    }

    public final ECFieldElement o() {
        int[] iArr = new int[4];
        SecP128R1Field.f(this.a, iArr);
        return new SecP128R1FieldElement(iArr);
    }

    public final ECFieldElement r(ECFieldElement eCFieldElement) {
        int[] iArr = new int[4];
        SecP128R1Field.h(this.a, ((SecP128R1FieldElement) eCFieldElement).a, iArr);
        return new SecP128R1FieldElement(iArr);
    }

    public final boolean s() {
        if ((this.a[0] & 1) == 1) {
            return true;
        }
        return false;
    }

    public final BigInteger t() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 4; i++) {
            int i2 = this.a[i];
            if (i2 != 0) {
                Pack.c(i2, bArr, (3 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public SecP128R1FieldElement() {
        this.a = new int[4];
    }

    public SecP128R1FieldElement(int[] iArr) {
        this.a = iArr;
    }
}
