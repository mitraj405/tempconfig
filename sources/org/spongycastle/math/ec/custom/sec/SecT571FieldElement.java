package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat576;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class SecT571FieldElement extends ECFieldElement {
    public final long[] a;

    public SecT571FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 571) {
            throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
        } else if (bigInteger.signum() < 0 || bigInteger.bitLength() > 576) {
            throw new IllegalArgumentException();
        } else {
            long[] jArr = new long[9];
            int i = 0;
            while (bigInteger.signum() != 0) {
                jArr[i] = bigInteger.longValue();
                bigInteger = bigInteger.shiftRight(64);
                i++;
            }
            SecT571Field.j(jArr, 0);
            this.a = jArr;
        }
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        long[] jArr = new long[9];
        SecT571Field.a(this.a, ((SecT571FieldElement) eCFieldElement).a, jArr);
        return new SecT571FieldElement(jArr);
    }

    public final ECFieldElement b() {
        long[] jArr = new long[9];
        long[] jArr2 = this.a;
        jArr[0] = jArr2[0] ^ 1;
        for (int i = 1; i < 9; i++) {
            jArr[i] = jArr2[i];
        }
        return new SecT571FieldElement(jArr);
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        return j(eCFieldElement.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT571FieldElement)) {
            return false;
        }
        long[] jArr = ((SecT571FieldElement) obj).a;
        for (int i = 8; i >= 0; i--) {
            if (this.a[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int f() {
        return 571;
    }

    public final ECFieldElement g() {
        long[] jArr = new long[9];
        long[] jArr2 = this.a;
        if (!Nat576.a(jArr2)) {
            long[] jArr3 = new long[9];
            long[] jArr4 = new long[9];
            long[] jArr5 = new long[9];
            SecT571Field.k(jArr2, jArr5);
            SecT571Field.k(jArr5, jArr3);
            SecT571Field.k(jArr3, jArr4);
            SecT571Field.e(jArr3, jArr4, jArr3);
            SecT571Field.l(jArr3, 2, jArr4);
            SecT571Field.e(jArr3, jArr4, jArr3);
            SecT571Field.e(jArr3, jArr5, jArr3);
            SecT571Field.l(jArr3, 5, jArr4);
            SecT571Field.e(jArr3, jArr4, jArr3);
            SecT571Field.l(jArr4, 5, jArr4);
            SecT571Field.e(jArr3, jArr4, jArr3);
            SecT571Field.l(jArr3, 15, jArr4);
            SecT571Field.e(jArr3, jArr4, jArr5);
            SecT571Field.l(jArr5, 30, jArr3);
            SecT571Field.l(jArr3, 30, jArr4);
            SecT571Field.e(jArr3, jArr4, jArr3);
            SecT571Field.l(jArr3, 60, jArr4);
            SecT571Field.e(jArr3, jArr4, jArr3);
            SecT571Field.l(jArr4, 60, jArr4);
            SecT571Field.e(jArr3, jArr4, jArr3);
            SecT571Field.l(jArr3, 180, jArr4);
            SecT571Field.e(jArr3, jArr4, jArr3);
            SecT571Field.l(jArr4, 180, jArr4);
            SecT571Field.e(jArr3, jArr4, jArr3);
            SecT571Field.e(jArr3, jArr5, jArr);
            return new SecT571FieldElement(jArr);
        }
        throw new IllegalStateException();
    }

    public final boolean h() {
        long[] jArr = this.a;
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 9; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.v(this.a, 9) ^ 5711052;
    }

    public final boolean i() {
        return Nat576.a(this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        long[] jArr = new long[9];
        SecT571Field.e(this.a, ((SecT571FieldElement) eCFieldElement).a, jArr);
        return new SecT571FieldElement(jArr);
    }

    public final ECFieldElement k(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return l(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public final ECFieldElement l(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = ((SecT571FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT571FieldElement) eCFieldElement2).a;
        long[] jArr3 = ((SecT571FieldElement) eCFieldElement3).a;
        long[] jArr4 = new long[18];
        SecT571Field.f(this.a, jArr, jArr4);
        SecT571Field.f(jArr2, jArr3, jArr4);
        long[] jArr5 = new long[9];
        SecT571Field.i(jArr4, jArr5);
        return new SecT571FieldElement(jArr5);
    }

    public final ECFieldElement n() {
        long[] jArr = new long[9];
        long[] jArr2 = new long[9];
        long[] jArr3 = new long[9];
        int i = 0;
        int i2 = 0;
        while (true) {
            long[] jArr4 = this.a;
            if (i < 4) {
                int i3 = i2 + 1;
                long d = Interleave.d(jArr4[i2]);
                i2 = i3 + 1;
                long d2 = Interleave.d(jArr4[i3]);
                jArr2[i] = (d & 4294967295L) | (d2 << 32);
                jArr3[i] = (d >>> 32) | (-4294967296L & d2);
                i++;
            } else {
                long d3 = Interleave.d(jArr4[i2]);
                jArr2[4] = d3 & 4294967295L;
                jArr3[4] = d3 >>> 32;
                SecT571Field.e(jArr3, SecT571Field.a, jArr);
                SecT571Field.a(jArr, jArr2, jArr);
                return new SecT571FieldElement(jArr);
            }
        }
    }

    public final ECFieldElement o() {
        long[] jArr = new long[9];
        SecT571Field.k(this.a, jArr);
        return new SecT571FieldElement(jArr);
    }

    public final ECFieldElement p(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = ((SecT571FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT571FieldElement) eCFieldElement2).a;
        long[] jArr3 = new long[18];
        long[] jArr4 = new long[18];
        SecT571Field.d(this.a, jArr4);
        for (int i = 0; i < 18; i++) {
            jArr3[i] = jArr3[i] ^ jArr4[i];
        }
        SecT571Field.f(jArr, jArr2, jArr3);
        long[] jArr5 = new long[9];
        SecT571Field.i(jArr3, jArr5);
        return new SecT571FieldElement(jArr5);
    }

    public final ECFieldElement q(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArr = new long[9];
        SecT571Field.l(this.a, i, jArr);
        return new SecT571FieldElement(jArr);
    }

    public final ECFieldElement r(ECFieldElement eCFieldElement) {
        return a(eCFieldElement);
    }

    public final boolean s() {
        if ((this.a[0] & 1) != 0) {
            return true;
        }
        return false;
    }

    public final BigInteger t() {
        byte[] bArr = new byte[72];
        for (int i = 0; i < 9; i++) {
            long j = this.a[i];
            if (j != 0) {
                Pack.j(j, bArr, (8 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public SecT571FieldElement() {
        this.a = new long[9];
    }

    public SecT571FieldElement(long[] jArr) {
        this.a = jArr;
    }

    public final ECFieldElement m() {
        return this;
    }
}
