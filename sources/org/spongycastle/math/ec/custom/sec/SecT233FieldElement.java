package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class SecT233FieldElement extends ECFieldElement {
    public final long[] a;

    public SecT233FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        long[] i = Nat256.i(bigInteger);
        long j = i[3];
        long j2 = j >>> 41;
        i[0] = i[0] ^ j2;
        i[1] = (j2 << 10) ^ i[1];
        i[3] = j & 2199023255551L;
        this.a = i;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        long[] jArr = ((SecT233FieldElement) eCFieldElement).a;
        long[] jArr2 = this.a;
        return new SecT233FieldElement(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3]});
    }

    public final ECFieldElement b() {
        long[] jArr = this.a;
        return new SecT233FieldElement(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3]});
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        return j(eCFieldElement.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT233FieldElement)) {
            return false;
        }
        return Nat256.g(this.a, ((SecT233FieldElement) obj).a);
    }

    public final int f() {
        return 233;
    }

    public final ECFieldElement g() {
        long[] jArr = new long[4];
        long[] jArr2 = this.a;
        if (!Nat256.n(jArr2)) {
            long[] jArr3 = new long[4];
            long[] jArr4 = new long[4];
            SecT233Field.h(jArr2, jArr3);
            SecT233Field.f(jArr3, jArr2, jArr3);
            SecT233Field.h(jArr3, jArr3);
            SecT233Field.f(jArr3, jArr2, jArr3);
            SecT233Field.i(jArr3, 3, jArr4);
            SecT233Field.f(jArr4, jArr3, jArr4);
            SecT233Field.h(jArr4, jArr4);
            SecT233Field.f(jArr4, jArr2, jArr4);
            SecT233Field.i(jArr4, 7, jArr3);
            SecT233Field.f(jArr3, jArr4, jArr3);
            SecT233Field.i(jArr3, 14, jArr4);
            SecT233Field.f(jArr4, jArr3, jArr4);
            SecT233Field.h(jArr4, jArr4);
            SecT233Field.f(jArr4, jArr2, jArr4);
            SecT233Field.i(jArr4, 29, jArr3);
            SecT233Field.f(jArr3, jArr4, jArr3);
            SecT233Field.i(jArr3, 58, jArr4);
            SecT233Field.f(jArr4, jArr3, jArr4);
            SecT233Field.i(jArr4, 116, jArr3);
            SecT233Field.f(jArr3, jArr4, jArr3);
            SecT233Field.h(jArr3, jArr);
            return new SecT233FieldElement(jArr);
        }
        throw new IllegalStateException();
    }

    public final boolean h() {
        return Nat256.l(this.a);
    }

    public final int hashCode() {
        return Arrays.v(this.a, 4) ^ 2330074;
    }

    public final boolean i() {
        return Nat256.n(this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        long[] jArr = new long[4];
        SecT233Field.f(this.a, ((SecT233FieldElement) eCFieldElement).a, jArr);
        return new SecT233FieldElement(jArr);
    }

    public final ECFieldElement k(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return l(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public final ECFieldElement l(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = ((SecT233FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT233FieldElement) eCFieldElement2).a;
        long[] jArr3 = ((SecT233FieldElement) eCFieldElement3).a;
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[8];
        SecT233Field.c(this.a, jArr, jArr5);
        SecT233Field.a(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        SecT233Field.c(jArr2, jArr3, jArr6);
        SecT233Field.a(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[4];
        SecT233Field.g(jArr4, jArr7);
        return new SecT233FieldElement(jArr7);
    }

    public final ECFieldElement n() {
        long[] jArr = new long[4];
        long[] jArr2 = this.a;
        int i = 0;
        long d = Interleave.d(jArr2[0]);
        long d2 = Interleave.d(jArr2[1]);
        long j = (d & 4294967295L) | (d2 << 32);
        long j2 = (d >>> 32) | (d2 & -4294967296L);
        long d3 = Interleave.d(jArr2[2]);
        int i2 = 3;
        long d4 = Interleave.d(jArr2[3]);
        long j3 = (4294967295L & d3) | (d4 << 32);
        long j4 = (d3 >>> 32) | (d4 & -4294967296L);
        long j5 = j4 >>> 27;
        long j6 = j4 ^ ((j2 >>> 27) | (j4 << 37));
        long j7 = j2 ^ (j2 << 37);
        long[] jArr3 = new long[8];
        int[] iArr = {32, 117, 191};
        while (i < i2) {
            int i3 = iArr[i];
            int i4 = i3 >>> 6;
            int i5 = i3 & 63;
            jArr3[i4] = jArr3[i4] ^ (j7 << i5);
            int i6 = i4 + 1;
            int i7 = -i5;
            jArr3[i6] = jArr3[i6] ^ ((j6 << i5) | (j7 >>> i7));
            int i8 = i4 + 2;
            jArr3[i8] = jArr3[i8] ^ ((j5 << i5) | (j6 >>> i7));
            i2 = 3;
            int i9 = i4 + 3;
            jArr3[i9] = jArr3[i9] ^ (j5 >>> i7);
            i++;
        }
        SecT233Field.g(jArr3, jArr);
        jArr[0] = jArr[0] ^ j;
        jArr[1] = jArr[1] ^ j3;
        return new SecT233FieldElement(jArr);
    }

    public final ECFieldElement o() {
        long[] jArr = new long[4];
        SecT233Field.h(this.a, jArr);
        return new SecT233FieldElement(jArr);
    }

    public final ECFieldElement p(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = ((SecT233FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT233FieldElement) eCFieldElement2).a;
        long[] jArr3 = new long[8];
        long[] jArr4 = new long[8];
        SecT233Field.e(this.a, jArr4);
        SecT233Field.a(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[8];
        SecT233Field.c(jArr, jArr2, jArr5);
        SecT233Field.a(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[4];
        SecT233Field.g(jArr3, jArr6);
        return new SecT233FieldElement(jArr6);
    }

    public final ECFieldElement q(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArr = new long[4];
        SecT233Field.i(this.a, i, jArr);
        return new SecT233FieldElement(jArr);
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

    public SecT233FieldElement() {
        this.a = new long[4];
    }

    public SecT233FieldElement(long[] jArr) {
        this.a = jArr;
    }

    public final ECFieldElement m() {
        return this;
    }
}
