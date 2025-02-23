package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat192;
import org.spongycastle.util.Arrays;

public class SecT131FieldElement extends ECFieldElement {
    public final long[] a;

    public SecT131FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        long[] h = Nat192.h(bigInteger);
        long j = h[2];
        long j2 = j >>> 3;
        h[0] = h[0] ^ ((((j2 << 2) ^ j2) ^ (j2 << 3)) ^ (j2 << 8));
        h[1] = (j2 >>> 56) ^ h[1];
        h[2] = j & 7;
        this.a = h;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        long[] jArr = ((SecT131FieldElement) eCFieldElement).a;
        long[] jArr2 = this.a;
        return new SecT131FieldElement(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2]});
    }

    public final ECFieldElement b() {
        long[] jArr = this.a;
        return new SecT131FieldElement(new long[]{jArr[0] ^ 1, jArr[1], jArr[2]});
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        return j(eCFieldElement.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT131FieldElement)) {
            return false;
        }
        long[] jArr = ((SecT131FieldElement) obj).a;
        for (int i = 2; i >= 0; i--) {
            if (this.a[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int f() {
        return 131;
    }

    public final ECFieldElement g() {
        long[] jArr = new long[3];
        long[] jArr2 = this.a;
        if (!Nat192.l(jArr2)) {
            long[] jArr3 = new long[3];
            long[] jArr4 = new long[3];
            long[] jArr5 = new long[5];
            SecT131Field.d(jArr2, jArr5);
            SecT131Field.f(jArr5, jArr3);
            SecT131Field.e(jArr3, jArr2, jArr3);
            SecT131Field.g(jArr3, 2, jArr4);
            SecT131Field.e(jArr4, jArr3, jArr4);
            SecT131Field.g(jArr4, 4, jArr3);
            SecT131Field.e(jArr3, jArr4, jArr3);
            SecT131Field.g(jArr3, 8, jArr4);
            SecT131Field.e(jArr4, jArr3, jArr4);
            SecT131Field.g(jArr4, 16, jArr3);
            SecT131Field.e(jArr3, jArr4, jArr3);
            SecT131Field.g(jArr3, 32, jArr4);
            SecT131Field.e(jArr4, jArr3, jArr4);
            long[] jArr6 = new long[5];
            SecT131Field.d(jArr4, jArr6);
            SecT131Field.f(jArr6, jArr4);
            SecT131Field.e(jArr4, jArr2, jArr4);
            SecT131Field.g(jArr4, 65, jArr3);
            SecT131Field.e(jArr3, jArr4, jArr3);
            long[] jArr7 = new long[5];
            SecT131Field.d(jArr3, jArr7);
            SecT131Field.f(jArr7, jArr);
            return new SecT131FieldElement(jArr);
        }
        throw new IllegalStateException();
    }

    public final boolean h() {
        long[] jArr = this.a;
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 3; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.v(this.a, 3) ^ 131832;
    }

    public final boolean i() {
        return Nat192.l(this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        long[] jArr = new long[3];
        SecT131Field.e(this.a, ((SecT131FieldElement) eCFieldElement).a, jArr);
        return new SecT131FieldElement(jArr);
    }

    public final ECFieldElement k(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return l(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public final ECFieldElement l(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = ((SecT131FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT131FieldElement) eCFieldElement2).a;
        long[] jArr3 = ((SecT131FieldElement) eCFieldElement3).a;
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[6];
        SecT131Field.b(this.a, jArr, jArr5);
        SecT131Field.a(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[6];
        SecT131Field.b(jArr2, jArr3, jArr6);
        SecT131Field.a(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[3];
        SecT131Field.f(jArr4, jArr7);
        return new SecT131FieldElement(jArr7);
    }

    public final ECFieldElement n() {
        long[] jArr = new long[3];
        long[] jArr2 = new long[3];
        long[] jArr3 = this.a;
        long d = Interleave.d(jArr3[0]);
        long d2 = Interleave.d(jArr3[1]);
        jArr2[0] = (d >>> 32) | (d2 & -4294967296L);
        long d3 = Interleave.d(jArr3[2]);
        long j = d3 & 4294967295L;
        jArr2[1] = d3 >>> 32;
        SecT131Field.e(jArr2, SecT131Field.a, jArr);
        jArr[0] = jArr[0] ^ ((d & 4294967295L) | (d2 << 32));
        jArr[1] = jArr[1] ^ j;
        return new SecT131FieldElement(jArr);
    }

    public final ECFieldElement o() {
        long[] jArr = new long[3];
        long[] jArr2 = new long[5];
        SecT131Field.d(this.a, jArr2);
        SecT131Field.f(jArr2, jArr);
        return new SecT131FieldElement(jArr);
    }

    public final ECFieldElement p(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = ((SecT131FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT131FieldElement) eCFieldElement2).a;
        long[] jArr3 = new long[5];
        long[] jArr4 = new long[5];
        SecT131Field.d(this.a, jArr4);
        SecT131Field.a(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[6];
        SecT131Field.b(jArr, jArr2, jArr5);
        SecT131Field.a(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[3];
        SecT131Field.f(jArr3, jArr6);
        return new SecT131FieldElement(jArr6);
    }

    public final ECFieldElement q(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArr = new long[3];
        SecT131Field.g(this.a, i, jArr);
        return new SecT131FieldElement(jArr);
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
        return Nat192.t(this.a);
    }

    public SecT131FieldElement() {
        this.a = new long[3];
    }

    public SecT131FieldElement(long[] jArr) {
        this.a = jArr;
    }

    public final ECFieldElement m() {
        return this;
    }
}
