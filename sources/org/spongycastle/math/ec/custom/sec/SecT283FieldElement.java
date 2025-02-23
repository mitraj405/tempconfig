package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class SecT283FieldElement extends ECFieldElement {
    public final long[] a;

    public SecT283FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 283) {
            throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
        } else if (bigInteger.signum() < 0 || bigInteger.bitLength() > 320) {
            throw new IllegalArgumentException();
        } else {
            long[] jArr = new long[5];
            int i = 0;
            while (bigInteger.signum() != 0) {
                jArr[i] = bigInteger.longValue();
                bigInteger = bigInteger.shiftRight(64);
                i++;
            }
            long j = jArr[4];
            long j2 = j >>> 27;
            jArr[0] = ((j2 << 12) ^ (((j2 << 5) ^ j2) ^ (j2 << 7))) ^ jArr[0];
            jArr[4] = j & 134217727;
            this.a = jArr;
        }
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        long[] jArr = ((SecT283FieldElement) eCFieldElement).a;
        long[] jArr2 = this.a;
        return new SecT283FieldElement(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3], jArr2[4] ^ jArr[4]});
    }

    public final ECFieldElement b() {
        long[] jArr = this.a;
        return new SecT283FieldElement(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3], jArr[4]});
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        return j(eCFieldElement.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT283FieldElement)) {
            return false;
        }
        long[] jArr = ((SecT283FieldElement) obj).a;
        for (int i = 4; i >= 0; i--) {
            if (this.a[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int f() {
        return 283;
    }

    public final ECFieldElement g() {
        long[] jArr;
        long[] jArr2 = new long[5];
        boolean z = false;
        int i = 0;
        while (true) {
            jArr = this.a;
            if (i >= 5) {
                z = true;
                break;
            } else if (jArr[i] != 0) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            long[] jArr3 = new long[5];
            long[] jArr4 = new long[5];
            SecT283Field.h(jArr, jArr3);
            SecT283Field.f(jArr3, jArr, jArr3);
            SecT283Field.i(jArr3, 2, jArr4);
            SecT283Field.f(jArr4, jArr3, jArr4);
            SecT283Field.i(jArr4, 4, jArr3);
            SecT283Field.f(jArr3, jArr4, jArr3);
            SecT283Field.i(jArr3, 8, jArr4);
            SecT283Field.f(jArr4, jArr3, jArr4);
            SecT283Field.h(jArr4, jArr4);
            SecT283Field.f(jArr4, jArr, jArr4);
            SecT283Field.i(jArr4, 17, jArr3);
            SecT283Field.f(jArr3, jArr4, jArr3);
            SecT283Field.h(jArr3, jArr3);
            SecT283Field.f(jArr3, jArr, jArr3);
            SecT283Field.i(jArr3, 35, jArr4);
            SecT283Field.f(jArr4, jArr3, jArr4);
            SecT283Field.i(jArr4, 70, jArr3);
            SecT283Field.f(jArr3, jArr4, jArr3);
            SecT283Field.h(jArr3, jArr3);
            SecT283Field.f(jArr3, jArr, jArr3);
            SecT283Field.i(jArr3, 141, jArr4);
            SecT283Field.f(jArr4, jArr3, jArr4);
            SecT283Field.h(jArr4, jArr2);
            return new SecT283FieldElement(jArr2);
        }
        throw new IllegalStateException();
    }

    public final boolean h() {
        long[] jArr = this.a;
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 5; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.v(this.a, 5) ^ 2831275;
    }

    public final boolean i() {
        for (int i = 0; i < 5; i++) {
            if (this.a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        long[] jArr = new long[5];
        SecT283Field.f(this.a, ((SecT283FieldElement) eCFieldElement).a, jArr);
        return new SecT283FieldElement(jArr);
    }

    public final ECFieldElement k(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return l(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public final ECFieldElement l(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = ((SecT283FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT283FieldElement) eCFieldElement2).a;
        long[] jArr3 = ((SecT283FieldElement) eCFieldElement3).a;
        long[] jArr4 = new long[9];
        long[] jArr5 = new long[10];
        SecT283Field.c(this.a, jArr, jArr5);
        SecT283Field.a(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[10];
        SecT283Field.c(jArr2, jArr3, jArr6);
        SecT283Field.a(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[5];
        SecT283Field.g(jArr4, jArr7);
        return new SecT283FieldElement(jArr7);
    }

    public final ECFieldElement n() {
        long[] jArr = new long[5];
        long[] jArr2 = new long[5];
        long[] jArr3 = this.a;
        long d = Interleave.d(jArr3[0]);
        long d2 = Interleave.d(jArr3[1]);
        long j = (d & 4294967295L) | (d2 << 32);
        jArr2[0] = (d >>> 32) | (d2 & -4294967296L);
        long d3 = Interleave.d(jArr3[2]);
        long d4 = Interleave.d(jArr3[3]);
        jArr2[1] = (d3 >>> 32) | (d4 & -4294967296L);
        long d5 = Interleave.d(jArr3[4]);
        jArr2[2] = d5 >>> 32;
        SecT283Field.f(jArr2, SecT283Field.a, jArr);
        jArr[0] = jArr[0] ^ j;
        jArr[1] = jArr[1] ^ ((d3 & 4294967295L) | (d4 << 32));
        jArr[2] = jArr[2] ^ (4294967295L & d5);
        return new SecT283FieldElement(jArr);
    }

    public final ECFieldElement o() {
        long[] jArr = new long[5];
        SecT283Field.h(this.a, jArr);
        return new SecT283FieldElement(jArr);
    }

    public final ECFieldElement p(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = ((SecT283FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT283FieldElement) eCFieldElement2).a;
        long[] jArr3 = new long[9];
        long[] jArr4 = new long[9];
        SecT283Field.e(this.a, jArr4);
        SecT283Field.a(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[10];
        SecT283Field.c(jArr, jArr2, jArr5);
        SecT283Field.a(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[5];
        SecT283Field.g(jArr3, jArr6);
        return new SecT283FieldElement(jArr6);
    }

    public final ECFieldElement q(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArr = new long[5];
        SecT283Field.i(this.a, i, jArr);
        return new SecT283FieldElement(jArr);
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
        byte[] bArr = new byte[40];
        for (int i = 0; i < 5; i++) {
            long j = this.a[i];
            if (j != 0) {
                Pack.j(j, bArr, (4 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public SecT283FieldElement() {
        this.a = new long[5];
    }

    public SecT283FieldElement(long[] jArr) {
        this.a = jArr;
    }

    public final ECFieldElement m() {
        return this;
    }
}
