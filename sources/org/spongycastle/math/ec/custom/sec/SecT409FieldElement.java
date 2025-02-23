package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class SecT409FieldElement extends ECFieldElement {
    public final long[] a;

    public SecT409FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        } else if (bigInteger.signum() < 0 || bigInteger.bitLength() > 448) {
            throw new IllegalArgumentException();
        } else {
            long[] jArr = new long[7];
            int i = 0;
            while (bigInteger.signum() != 0) {
                jArr[i] = bigInteger.longValue();
                bigInteger = bigInteger.shiftRight(64);
                i++;
            }
            long j = jArr[6];
            long j2 = j >>> 25;
            jArr[0] = jArr[0] ^ j2;
            jArr[1] = (j2 << 23) ^ jArr[1];
            jArr[6] = j & 33554431;
            this.a = jArr;
        }
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        long[] jArr = ((SecT409FieldElement) eCFieldElement).a;
        long[] jArr2 = this.a;
        return new SecT409FieldElement(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3], jArr2[4] ^ jArr[4], jArr2[5] ^ jArr[5], jArr2[6] ^ jArr[6]});
    }

    public final ECFieldElement b() {
        long[] jArr = this.a;
        return new SecT409FieldElement(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3], jArr[4], jArr[5], jArr[6]});
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        return j(eCFieldElement.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT409FieldElement)) {
            return false;
        }
        long[] jArr = ((SecT409FieldElement) obj).a;
        for (int i = 6; i >= 0; i--) {
            if (this.a[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int f() {
        return 409;
    }

    public final ECFieldElement g() {
        long[] jArr;
        long[] jArr2 = new long[7];
        boolean z = false;
        int i = 0;
        while (true) {
            jArr = this.a;
            if (i >= 7) {
                z = true;
                break;
            } else if (jArr[i] != 0) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            long[] jArr3 = new long[7];
            long[] jArr4 = new long[7];
            long[] jArr5 = new long[7];
            long[] jArr6 = new long[13];
            SecT409Field.c(jArr, jArr6);
            SecT409Field.e(jArr6, jArr3);
            SecT409Field.f(jArr3, 1, jArr4);
            SecT409Field.d(jArr3, jArr4, jArr3);
            SecT409Field.f(jArr4, 1, jArr4);
            SecT409Field.d(jArr3, jArr4, jArr3);
            SecT409Field.f(jArr3, 3, jArr4);
            SecT409Field.d(jArr3, jArr4, jArr3);
            SecT409Field.f(jArr3, 6, jArr4);
            SecT409Field.d(jArr3, jArr4, jArr3);
            SecT409Field.f(jArr3, 12, jArr4);
            SecT409Field.d(jArr3, jArr4, jArr5);
            SecT409Field.f(jArr5, 24, jArr3);
            SecT409Field.f(jArr3, 24, jArr4);
            SecT409Field.d(jArr3, jArr4, jArr3);
            SecT409Field.f(jArr3, 48, jArr4);
            SecT409Field.d(jArr3, jArr4, jArr3);
            SecT409Field.f(jArr3, 96, jArr4);
            SecT409Field.d(jArr3, jArr4, jArr3);
            SecT409Field.f(jArr3, 192, jArr4);
            SecT409Field.d(jArr3, jArr4, jArr3);
            SecT409Field.d(jArr3, jArr5, jArr2);
            return new SecT409FieldElement(jArr2);
        }
        throw new IllegalStateException();
    }

    public final boolean h() {
        long[] jArr = this.a;
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 7; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.v(this.a, 7) ^ 4090087;
    }

    public final boolean i() {
        for (int i = 0; i < 7; i++) {
            if (this.a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        long[] jArr = new long[7];
        SecT409Field.d(this.a, ((SecT409FieldElement) eCFieldElement).a, jArr);
        return new SecT409FieldElement(jArr);
    }

    public final ECFieldElement k(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return l(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public final ECFieldElement l(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = ((SecT409FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT409FieldElement) eCFieldElement2).a;
        long[] jArr3 = ((SecT409FieldElement) eCFieldElement3).a;
        long[] jArr4 = new long[13];
        long[] jArr5 = new long[14];
        SecT409Field.b(this.a, jArr, jArr5);
        for (int i = 0; i < 13; i++) {
            jArr4[i] = jArr4[i] ^ jArr5[i];
        }
        long[] jArr6 = new long[14];
        SecT409Field.b(jArr2, jArr3, jArr6);
        for (int i2 = 0; i2 < 13; i2++) {
            jArr4[i2] = jArr4[i2] ^ jArr6[i2];
        }
        long[] jArr7 = new long[7];
        SecT409Field.e(jArr4, jArr7);
        return new SecT409FieldElement(jArr7);
    }

    public final ECFieldElement n() {
        long[] jArr = this.a;
        long d = Interleave.d(jArr[0]);
        long d2 = Interleave.d(jArr[1]);
        long j = (d & 4294967295L) | (d2 << 32);
        long j2 = (d >>> 32) | (d2 & -4294967296L);
        long d3 = Interleave.d(jArr[2]);
        long d4 = Interleave.d(jArr[3]);
        long j3 = (d3 & 4294967295L) | (d4 << 32);
        long j4 = (d3 >>> 32) | (d4 & -4294967296L);
        long d5 = Interleave.d(jArr[4]);
        long d6 = Interleave.d(jArr[5]);
        long j5 = (d5 >>> 32) | (d6 & -4294967296L);
        long d7 = Interleave.d(jArr[6]);
        long j6 = d7 & 4294967295L;
        long j7 = d7 >>> 32;
        return new SecT409FieldElement(new long[]{j ^ (j2 << 44), (j3 ^ (j4 << 44)) ^ (j2 >>> 20), (((d5 & 4294967295L) | (d6 << 32)) ^ (j5 << 44)) ^ (j4 >>> 20), (((j7 << 44) ^ j6) ^ (j5 >>> 20)) ^ (j2 << 13), (j2 >>> 51) ^ ((j7 >>> 20) ^ (j4 << 13)), (j5 << 13) ^ (j4 >>> 51), (j5 >>> 51) ^ (j7 << 13)});
    }

    public final ECFieldElement o() {
        long[] jArr = new long[7];
        long[] jArr2 = new long[13];
        SecT409Field.c(this.a, jArr2);
        SecT409Field.e(jArr2, jArr);
        return new SecT409FieldElement(jArr);
    }

    public final ECFieldElement p(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = ((SecT409FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT409FieldElement) eCFieldElement2).a;
        long[] jArr3 = new long[13];
        long[] jArr4 = new long[13];
        SecT409Field.c(this.a, jArr4);
        for (int i = 0; i < 13; i++) {
            jArr3[i] = jArr3[i] ^ jArr4[i];
        }
        long[] jArr5 = new long[14];
        SecT409Field.b(jArr, jArr2, jArr5);
        for (int i2 = 0; i2 < 13; i2++) {
            jArr3[i2] = jArr3[i2] ^ jArr5[i2];
        }
        long[] jArr6 = new long[7];
        SecT409Field.e(jArr3, jArr6);
        return new SecT409FieldElement(jArr6);
    }

    public final ECFieldElement q(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArr = new long[7];
        SecT409Field.f(this.a, i, jArr);
        return new SecT409FieldElement(jArr);
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
        byte[] bArr = new byte[56];
        for (int i = 0; i < 7; i++) {
            long j = this.a[i];
            if (j != 0) {
                Pack.j(j, bArr, (6 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public SecT409FieldElement() {
        this.a = new long[7];
    }

    public SecT409FieldElement(long[] jArr) {
        this.a = jArr;
    }

    public final ECFieldElement m() {
        return this;
    }
}
