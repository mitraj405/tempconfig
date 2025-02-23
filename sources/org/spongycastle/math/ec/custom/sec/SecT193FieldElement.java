package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class SecT193FieldElement extends ECFieldElement {
    public final long[] a;

    public SecT193FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        long[] i = Nat256.i(bigInteger);
        long j = i[3];
        long j2 = j >>> 1;
        i[0] = i[0] ^ ((j2 << 15) ^ j2);
        i[1] = (j2 >>> 49) ^ i[1];
        i[3] = j & 1;
        this.a = i;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        long[] jArr = ((SecT193FieldElement) eCFieldElement).a;
        long[] jArr2 = this.a;
        return new SecT193FieldElement(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3]});
    }

    public final ECFieldElement b() {
        long[] jArr = this.a;
        return new SecT193FieldElement(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3]});
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        return j(eCFieldElement.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT193FieldElement)) {
            return false;
        }
        return Nat256.g(this.a, ((SecT193FieldElement) obj).a);
    }

    public final int f() {
        return 193;
    }

    public final ECFieldElement g() {
        long[] jArr = new long[4];
        long[] jArr2 = this.a;
        if (!Nat256.n(jArr2)) {
            long[] jArr3 = new long[4];
            long[] jArr4 = new long[4];
            long[] jArr5 = new long[8];
            SecT193Field.e(jArr2, jArr5);
            SecT193Field.g(jArr5, jArr3);
            SecT193Field.h(jArr3, 1, jArr4);
            SecT193Field.f(jArr3, jArr4, jArr3);
            SecT193Field.h(jArr4, 1, jArr4);
            SecT193Field.f(jArr3, jArr4, jArr3);
            SecT193Field.h(jArr3, 3, jArr4);
            SecT193Field.f(jArr3, jArr4, jArr3);
            SecT193Field.h(jArr3, 6, jArr4);
            SecT193Field.f(jArr3, jArr4, jArr3);
            SecT193Field.h(jArr3, 12, jArr4);
            SecT193Field.f(jArr3, jArr4, jArr3);
            SecT193Field.h(jArr3, 24, jArr4);
            SecT193Field.f(jArr3, jArr4, jArr3);
            SecT193Field.h(jArr3, 48, jArr4);
            SecT193Field.f(jArr3, jArr4, jArr3);
            SecT193Field.h(jArr3, 96, jArr4);
            SecT193Field.f(jArr3, jArr4, jArr);
            return new SecT193FieldElement(jArr);
        }
        throw new IllegalStateException();
    }

    public final boolean h() {
        return Nat256.l(this.a);
    }

    public final int hashCode() {
        return Arrays.v(this.a, 4) ^ 1930015;
    }

    public final boolean i() {
        return Nat256.n(this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        long[] jArr = new long[4];
        SecT193Field.f(this.a, ((SecT193FieldElement) eCFieldElement).a, jArr);
        return new SecT193FieldElement(jArr);
    }

    public final ECFieldElement k(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return l(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public final ECFieldElement l(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = ((SecT193FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT193FieldElement) eCFieldElement2).a;
        long[] jArr3 = ((SecT193FieldElement) eCFieldElement3).a;
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[8];
        SecT193Field.c(this.a, jArr, jArr5);
        SecT193Field.a(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        SecT193Field.c(jArr2, jArr3, jArr6);
        SecT193Field.a(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[4];
        SecT193Field.g(jArr4, jArr7);
        return new SecT193FieldElement(jArr7);
    }

    public final ECFieldElement n() {
        long[] jArr = this.a;
        long d = Interleave.d(jArr[0]);
        long d2 = Interleave.d(jArr[1]);
        long j = (d & 4294967295L) | (d2 << 32);
        long j2 = (d >>> 32) | (d2 & -4294967296L);
        long d3 = Interleave.d(jArr[2]);
        long j3 = d3 >>> 32;
        return new SecT193FieldElement(new long[]{j ^ (j2 << 8), (((j3 << 8) ^ ((d3 & 4294967295L) ^ (jArr[3] << 32))) ^ (j2 >>> 56)) ^ (j2 << 33), ((j3 >>> 56) ^ (j3 << 33)) ^ (j2 >>> 31), j3 >>> 31});
    }

    public final ECFieldElement o() {
        long[] jArr = new long[4];
        long[] jArr2 = new long[8];
        SecT193Field.e(this.a, jArr2);
        SecT193Field.g(jArr2, jArr);
        return new SecT193FieldElement(jArr);
    }

    public final ECFieldElement p(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = ((SecT193FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT193FieldElement) eCFieldElement2).a;
        long[] jArr3 = new long[8];
        long[] jArr4 = new long[8];
        SecT193Field.e(this.a, jArr4);
        SecT193Field.a(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[8];
        SecT193Field.c(jArr, jArr2, jArr5);
        SecT193Field.a(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[4];
        SecT193Field.g(jArr3, jArr6);
        return new SecT193FieldElement(jArr6);
    }

    public final ECFieldElement q(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArr = new long[4];
        SecT193Field.h(this.a, i, jArr);
        return new SecT193FieldElement(jArr);
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
        return Nat256.v(this.a);
    }

    public SecT193FieldElement() {
        this.a = new long[4];
    }

    public SecT193FieldElement(long[] jArr) {
        this.a = jArr;
    }

    public final ECFieldElement m() {
        return this;
    }
}
