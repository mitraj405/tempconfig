package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class SecT113FieldElement extends ECFieldElement {
    public final long[] a;

    public SecT113FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        } else if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        } else {
            long[] jArr = new long[2];
            int i = 0;
            while (bigInteger.signum() != 0) {
                jArr[i] = bigInteger.longValue();
                bigInteger = bigInteger.shiftRight(64);
                i++;
            }
            long j = jArr[1];
            long j2 = j >>> 49;
            jArr[0] = (j2 ^ (j2 << 9)) ^ jArr[0];
            jArr[1] = j & 562949953421311L;
            this.a = jArr;
        }
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        long[] jArr = ((SecT113FieldElement) eCFieldElement).a;
        long[] jArr2 = this.a;
        return new SecT113FieldElement(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1]});
    }

    public final ECFieldElement b() {
        long[] jArr = this.a;
        return new SecT113FieldElement(new long[]{jArr[0] ^ 1, jArr[1]});
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        return j(eCFieldElement.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT113FieldElement)) {
            return false;
        }
        long[] jArr = ((SecT113FieldElement) obj).a;
        for (int i = 1; i >= 0; i--) {
            if (this.a[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int f() {
        return 113;
    }

    public final ECFieldElement g() {
        long[] jArr;
        long[] jArr2 = new long[2];
        boolean z = false;
        int i = 0;
        while (true) {
            jArr = this.a;
            if (i >= 2) {
                z = true;
                break;
            } else if (jArr[i] != 0) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            long[] jArr3 = new long[2];
            long[] jArr4 = new long[2];
            long[] jArr5 = new long[4];
            SecT113Field.d(jArr, jArr5);
            SecT113Field.f(jArr5, jArr3);
            SecT113Field.e(jArr3, jArr, jArr3);
            long[] jArr6 = new long[4];
            SecT113Field.d(jArr3, jArr6);
            SecT113Field.f(jArr6, jArr3);
            SecT113Field.e(jArr3, jArr, jArr3);
            SecT113Field.g(jArr3, 3, jArr4);
            SecT113Field.e(jArr4, jArr3, jArr4);
            long[] jArr7 = new long[4];
            SecT113Field.d(jArr4, jArr7);
            SecT113Field.f(jArr7, jArr4);
            SecT113Field.e(jArr4, jArr, jArr4);
            SecT113Field.g(jArr4, 7, jArr3);
            SecT113Field.e(jArr3, jArr4, jArr3);
            SecT113Field.g(jArr3, 14, jArr4);
            SecT113Field.e(jArr4, jArr3, jArr4);
            SecT113Field.g(jArr4, 28, jArr3);
            SecT113Field.e(jArr3, jArr4, jArr3);
            SecT113Field.g(jArr3, 56, jArr4);
            SecT113Field.e(jArr4, jArr3, jArr4);
            long[] jArr8 = new long[4];
            SecT113Field.d(jArr4, jArr8);
            SecT113Field.f(jArr8, jArr2);
            return new SecT113FieldElement(jArr2);
        }
        throw new IllegalStateException();
    }

    public final boolean h() {
        long[] jArr = this.a;
        if (jArr[0] == 1 && jArr[1] == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.v(this.a, 2) ^ 113009;
    }

    public final boolean i() {
        for (int i = 0; i < 2; i++) {
            if (this.a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        long[] jArr = new long[2];
        SecT113Field.e(this.a, ((SecT113FieldElement) eCFieldElement).a, jArr);
        return new SecT113FieldElement(jArr);
    }

    public final ECFieldElement k(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return l(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public final ECFieldElement l(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = ((SecT113FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT113FieldElement) eCFieldElement2).a;
        long[] jArr3 = ((SecT113FieldElement) eCFieldElement3).a;
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        SecT113Field.b(this.a, jArr, jArr5);
        SecT113Field.a(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[4];
        SecT113Field.b(jArr2, jArr3, jArr6);
        SecT113Field.a(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[2];
        SecT113Field.f(jArr4, jArr7);
        return new SecT113FieldElement(jArr7);
    }

    public final ECFieldElement n() {
        long[] jArr = this.a;
        long d = Interleave.d(jArr[0]);
        long d2 = Interleave.d(jArr[1]);
        long j = (d >>> 32) | (d2 & -4294967296L);
        return new SecT113FieldElement(new long[]{((j << 57) ^ ((4294967295L & d) | (d2 << 32))) ^ (j << 5), (j >>> 7) ^ (j >>> 59)});
    }

    public final ECFieldElement o() {
        long[] jArr = new long[2];
        long[] jArr2 = new long[4];
        SecT113Field.d(this.a, jArr2);
        SecT113Field.f(jArr2, jArr);
        return new SecT113FieldElement(jArr);
    }

    public final ECFieldElement p(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = ((SecT113FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT113FieldElement) eCFieldElement2).a;
        long[] jArr3 = new long[4];
        long[] jArr4 = new long[4];
        SecT113Field.d(this.a, jArr4);
        SecT113Field.a(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[4];
        SecT113Field.b(jArr, jArr2, jArr5);
        SecT113Field.a(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[2];
        SecT113Field.f(jArr3, jArr6);
        return new SecT113FieldElement(jArr6);
    }

    public final ECFieldElement q(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArr = new long[2];
        SecT113Field.g(this.a, i, jArr);
        return new SecT113FieldElement(jArr);
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
        byte[] bArr = new byte[16];
        for (int i = 0; i < 2; i++) {
            long j = this.a[i];
            if (j != 0) {
                Pack.j(j, bArr, (1 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public SecT113FieldElement() {
        this.a = new long[2];
    }

    public SecT113FieldElement(long[] jArr) {
        this.a = jArr;
    }

    public final ECFieldElement m() {
        return this;
    }
}
