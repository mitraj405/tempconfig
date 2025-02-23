package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.raw.Interleave;
import org.spongycastle.math.raw.Nat256;
import org.spongycastle.util.Arrays;

public class SecT239FieldElement extends ECFieldElement {
    public final long[] a;

    public SecT239FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        long[] i = Nat256.i(bigInteger);
        long j = i[3];
        long j2 = j >>> 47;
        i[0] = i[0] ^ j2;
        i[2] = (j2 << 30) ^ i[2];
        i[3] = j & 140737488355327L;
        this.a = i;
    }

    public final ECFieldElement a(ECFieldElement eCFieldElement) {
        long[] jArr = ((SecT239FieldElement) eCFieldElement).a;
        long[] jArr2 = this.a;
        return new SecT239FieldElement(new long[]{jArr2[0] ^ jArr[0], jArr2[1] ^ jArr[1], jArr2[2] ^ jArr[2], jArr2[3] ^ jArr[3]});
    }

    public final ECFieldElement b() {
        long[] jArr = this.a;
        return new SecT239FieldElement(new long[]{jArr[0] ^ 1, jArr[1], jArr[2], jArr[3]});
    }

    public final ECFieldElement d(ECFieldElement eCFieldElement) {
        return j(eCFieldElement.g());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT239FieldElement)) {
            return false;
        }
        return Nat256.g(this.a, ((SecT239FieldElement) obj).a);
    }

    public final int f() {
        return 239;
    }

    public final ECFieldElement g() {
        long[] jArr = new long[4];
        long[] jArr2 = this.a;
        if (!Nat256.n(jArr2)) {
            long[] jArr3 = new long[4];
            long[] jArr4 = new long[4];
            SecT239Field.h(jArr2, jArr3);
            SecT239Field.f(jArr3, jArr2, jArr3);
            SecT239Field.h(jArr3, jArr3);
            SecT239Field.f(jArr3, jArr2, jArr3);
            SecT239Field.i(jArr3, 3, jArr4);
            SecT239Field.f(jArr4, jArr3, jArr4);
            SecT239Field.h(jArr4, jArr4);
            SecT239Field.f(jArr4, jArr2, jArr4);
            SecT239Field.i(jArr4, 7, jArr3);
            SecT239Field.f(jArr3, jArr4, jArr3);
            SecT239Field.i(jArr3, 14, jArr4);
            SecT239Field.f(jArr4, jArr3, jArr4);
            SecT239Field.h(jArr4, jArr4);
            SecT239Field.f(jArr4, jArr2, jArr4);
            SecT239Field.i(jArr4, 29, jArr3);
            SecT239Field.f(jArr3, jArr4, jArr3);
            SecT239Field.h(jArr3, jArr3);
            SecT239Field.f(jArr3, jArr2, jArr3);
            SecT239Field.i(jArr3, 59, jArr4);
            SecT239Field.f(jArr4, jArr3, jArr4);
            SecT239Field.h(jArr4, jArr4);
            SecT239Field.f(jArr4, jArr2, jArr4);
            SecT239Field.i(jArr4, 119, jArr3);
            SecT239Field.f(jArr3, jArr4, jArr3);
            SecT239Field.h(jArr3, jArr);
            return new SecT239FieldElement(jArr);
        }
        throw new IllegalStateException();
    }

    public final boolean h() {
        return Nat256.l(this.a);
    }

    public final int hashCode() {
        return Arrays.v(this.a, 4) ^ 23900158;
    }

    public final boolean i() {
        return Nat256.n(this.a);
    }

    public final ECFieldElement j(ECFieldElement eCFieldElement) {
        long[] jArr = new long[4];
        SecT239Field.f(this.a, ((SecT239FieldElement) eCFieldElement).a, jArr);
        return new SecT239FieldElement(jArr);
    }

    public final ECFieldElement k(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return l(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public final ECFieldElement l(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = ((SecT239FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT239FieldElement) eCFieldElement2).a;
        long[] jArr3 = ((SecT239FieldElement) eCFieldElement3).a;
        long[] jArr4 = new long[8];
        long[] jArr5 = new long[8];
        SecT239Field.c(this.a, jArr, jArr5);
        SecT239Field.a(jArr4, jArr5, jArr4);
        long[] jArr6 = new long[8];
        SecT239Field.c(jArr2, jArr3, jArr6);
        SecT239Field.a(jArr4, jArr6, jArr4);
        long[] jArr7 = new long[4];
        SecT239Field.g(jArr4, jArr7);
        return new SecT239FieldElement(jArr7);
    }

    public final ECFieldElement n() {
        long[] jArr = new long[4];
        long[] jArr2 = this.a;
        long d = Interleave.d(jArr2[0]);
        long d2 = Interleave.d(jArr2[1]);
        long j = (d & 4294967295L) | (d2 << 32);
        long j2 = (d >>> 32) | (d2 & -4294967296L);
        long d3 = Interleave.d(jArr2[2]);
        long d4 = Interleave.d(jArr2[3]);
        long j3 = (d3 & 4294967295L) | (d4 << 32);
        long j4 = (d4 & -4294967296L) | (d3 >>> 32);
        long j5 = j4 >>> 49;
        long j6 = (j2 >>> 49) | (j4 << 15);
        long j7 = j4 ^ (j2 << 15);
        long[] jArr3 = new long[8];
        int[] iArr = {39, 120};
        int i = 0;
        for (int i2 = 2; i < i2; i2 = 2) {
            int i3 = iArr[i];
            int i4 = i3 >>> 6;
            int i5 = i3 & 63;
            jArr3[i4] = jArr3[i4] ^ (j2 << i5);
            int i6 = i4 + 1;
            int i7 = -i5;
            jArr3[i6] = jArr3[i6] ^ ((j7 << i5) | (j2 >>> i7));
            int i8 = i4 + 2;
            jArr3[i8] = jArr3[i8] ^ ((j6 << i5) | (j7 >>> i7));
            int i9 = i4 + 3;
            jArr3[i9] = jArr3[i9] ^ ((j5 << i5) | (j6 >>> i7));
            int i10 = i4 + 4;
            jArr3[i10] = jArr3[i10] ^ (j5 >>> i7);
            i++;
        }
        SecT239Field.g(jArr3, jArr);
        jArr[0] = jArr[0] ^ j;
        jArr[1] = jArr[1] ^ j3;
        return new SecT239FieldElement(jArr);
    }

    public final ECFieldElement o() {
        long[] jArr = new long[4];
        SecT239Field.h(this.a, jArr);
        return new SecT239FieldElement(jArr);
    }

    public final ECFieldElement p(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = ((SecT239FieldElement) eCFieldElement).a;
        long[] jArr2 = ((SecT239FieldElement) eCFieldElement2).a;
        long[] jArr3 = new long[8];
        long[] jArr4 = new long[8];
        SecT239Field.e(this.a, jArr4);
        SecT239Field.a(jArr3, jArr4, jArr3);
        long[] jArr5 = new long[8];
        SecT239Field.c(jArr, jArr2, jArr5);
        SecT239Field.a(jArr3, jArr5, jArr3);
        long[] jArr6 = new long[4];
        SecT239Field.g(jArr3, jArr6);
        return new SecT239FieldElement(jArr6);
    }

    public final ECFieldElement q(int i) {
        if (i < 1) {
            return this;
        }
        long[] jArr = new long[4];
        SecT239Field.i(this.a, i, jArr);
        return new SecT239FieldElement(jArr);
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

    public SecT239FieldElement() {
        this.a = new long[4];
    }

    public SecT239FieldElement(long[] jArr) {
        this.a = jArr;
    }

    public final ECFieldElement m() {
        return this;
    }
}
