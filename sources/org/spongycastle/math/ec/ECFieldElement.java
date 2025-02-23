package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public abstract class ECFieldElement implements ECConstants {

    public static class Fp extends ECFieldElement {
        public final BigInteger g;
        public final BigInteger h;
        public final BigInteger i;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.g = bigInteger;
            this.h = bigInteger2;
            this.i = bigInteger3;
        }

        public static BigInteger u(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return ECConstants.b.shiftLeft(bitLength).subtract(bigInteger);
        }

        public final ECFieldElement a(ECFieldElement eCFieldElement) {
            BigInteger add = this.i.add(eCFieldElement.t());
            BigInteger bigInteger = this.g;
            if (add.compareTo(bigInteger) >= 0) {
                add = add.subtract(bigInteger);
            }
            return new Fp(bigInteger, this.h, add);
        }

        public final ECFieldElement b() {
            BigInteger add = this.i.add(ECConstants.b);
            BigInteger bigInteger = this.g;
            if (add.compareTo(bigInteger) == 0) {
                add = ECConstants.a;
            }
            return new Fp(bigInteger, this.h, add);
        }

        public final ECFieldElement d(ECFieldElement eCFieldElement) {
            BigInteger t = eCFieldElement.t();
            int f = f();
            int i2 = (f + 31) >> 5;
            BigInteger bigInteger = this.g;
            int[] j = Nat.j(f, bigInteger);
            int[] j2 = Nat.j(f, t);
            int[] iArr = new int[i2];
            Mod.b(j, j2, iArr);
            return new Fp(bigInteger, this.h, v(this.i, Nat.y(i2, iArr)));
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Fp)) {
                return false;
            }
            Fp fp = (Fp) obj;
            if (!this.g.equals(fp.g) || !this.i.equals(fp.i)) {
                return false;
            }
            return true;
        }

        public final int f() {
            return this.g.bitLength();
        }

        public final ECFieldElement g() {
            int f = f();
            int i2 = (f + 31) >> 5;
            BigInteger bigInteger = this.g;
            int[] iArr = new int[i2];
            Mod.b(Nat.j(f, bigInteger), Nat.j(f, this.i), iArr);
            return new Fp(bigInteger, this.h, Nat.y(i2, iArr));
        }

        public final int hashCode() {
            return this.g.hashCode() ^ this.i.hashCode();
        }

        public final ECFieldElement j(ECFieldElement eCFieldElement) {
            return new Fp(this.g, this.h, v(this.i, eCFieldElement.t()));
        }

        public final ECFieldElement k(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return new Fp(this.g, this.h, w(this.i.multiply(eCFieldElement.t()).subtract(eCFieldElement2.t().multiply(eCFieldElement3.t()))));
        }

        public final ECFieldElement l(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return new Fp(this.g, this.h, w(this.i.multiply(eCFieldElement.t()).add(eCFieldElement2.t().multiply(eCFieldElement3.t()))));
        }

        public final ECFieldElement m() {
            BigInteger bigInteger = this.i;
            if (bigInteger.signum() == 0) {
                return this;
            }
            BigInteger bigInteger2 = this.h;
            BigInteger bigInteger3 = this.g;
            return new Fp(bigInteger3, bigInteger2, bigInteger3.subtract(bigInteger));
        }

        public final ECFieldElement n() {
            BigInteger bigInteger;
            Random random;
            BigInteger bigInteger2;
            BigInteger bigInteger3;
            int i2;
            Object obj;
            boolean z;
            BigInteger bigInteger4;
            BigInteger bigInteger5;
            if (i() || h()) {
                return this;
            }
            BigInteger bigInteger6 = this.g;
            boolean z2 = false;
            if (bigInteger6.testBit(0)) {
                int i3 = 1;
                boolean testBit = bigInteger6.testBit(1);
                Object obj2 = null;
                BigInteger bigInteger7 = this.h;
                BigInteger bigInteger8 = this.i;
                BigInteger bigInteger9 = ECConstants.b;
                if (testBit) {
                    Fp fp = new Fp(bigInteger6, bigInteger7, bigInteger8.modPow(bigInteger6.shiftRight(2).add(bigInteger9), bigInteger6));
                    if (fp.o().equals(this)) {
                        return fp;
                    }
                    return null;
                }
                boolean testBit2 = bigInteger6.testBit(2);
                BigInteger bigInteger10 = ECConstants.c;
                if (testBit2) {
                    BigInteger modPow = bigInteger8.modPow(bigInteger6.shiftRight(3), bigInteger6);
                    BigInteger v = v(modPow, bigInteger8);
                    if (v(v, modPow).equals(bigInteger9)) {
                        Fp fp2 = new Fp(bigInteger6, bigInteger7, v);
                        if (fp2.o().equals(this)) {
                            return fp2;
                        }
                        return null;
                    }
                    Fp fp3 = new Fp(bigInteger6, bigInteger7, w(v.multiply(bigInteger10.modPow(bigInteger6.shiftRight(2), bigInteger6))));
                    if (fp3.o().equals(this)) {
                        return fp3;
                    }
                    return null;
                }
                BigInteger shiftRight = bigInteger6.shiftRight(1);
                if (!bigInteger8.modPow(shiftRight, bigInteger6).equals(bigInteger9)) {
                    return null;
                }
                BigInteger shiftLeft = bigInteger8.shiftLeft(1);
                if (shiftLeft.compareTo(bigInteger6) >= 0) {
                    shiftLeft = shiftLeft.subtract(bigInteger6);
                }
                BigInteger shiftLeft2 = shiftLeft.shiftLeft(1);
                if (shiftLeft2.compareTo(bigInteger6) >= 0) {
                    shiftLeft2 = shiftLeft2.subtract(bigInteger6);
                }
                BigInteger add = shiftRight.add(bigInteger9);
                BigInteger subtract = bigInteger6.subtract(bigInteger9);
                Random random2 = new Random();
                while (true) {
                    BigInteger bigInteger11 = new BigInteger(bigInteger6.bitLength(), random2);
                    if (bigInteger11.compareTo(bigInteger6) >= 0 || !w(bigInteger11.multiply(bigInteger11).subtract(shiftLeft2)).modPow(shiftRight, bigInteger6).equals(subtract)) {
                        bigInteger3 = shiftRight;
                        obj = obj2;
                        bigInteger2 = bigInteger;
                        random = random2;
                        i2 = i3;
                        z = z2;
                        bigInteger4 = subtract;
                    } else {
                        int bitLength = add.bitLength();
                        int lowestSetBit = add.getLowestSetBit();
                        int i4 = bitLength - i3;
                        bigInteger3 = shiftRight;
                        BigInteger bigInteger12 = bigInteger9;
                        BigInteger bigInteger13 = bigInteger12;
                        BigInteger bigInteger14 = bigInteger13;
                        bigInteger2 = bigInteger;
                        random = random2;
                        BigInteger bigInteger15 = bigInteger11;
                        while (true) {
                            bigInteger5 = subtract;
                            if (i4 < lowestSetBit + 1) {
                                break;
                            }
                            bigInteger12 = v(bigInteger12, bigInteger13);
                            if (add.testBit(i4)) {
                                bigInteger13 = v(bigInteger12, bigInteger8);
                                BigInteger v2 = v(bigInteger14, bigInteger15);
                                bigInteger = w(bigInteger15.multiply(bigInteger).subtract(bigInteger11.multiply(bigInteger12)));
                                bigInteger15 = w(bigInteger15.multiply(bigInteger15).subtract(bigInteger13.shiftLeft(1)));
                                bigInteger14 = v2;
                            } else {
                                BigInteger w = w(bigInteger14.multiply(bigInteger).subtract(bigInteger12));
                                BigInteger w2 = w(bigInteger15.multiply(bigInteger).subtract(bigInteger11.multiply(bigInteger12)));
                                bigInteger = w(bigInteger.multiply(bigInteger).subtract(bigInteger12.shiftLeft(1)));
                                bigInteger15 = w2;
                                bigInteger14 = w;
                                bigInteger13 = bigInteger12;
                            }
                            i4--;
                            subtract = bigInteger5;
                        }
                        BigInteger v3 = v(bigInteger12, bigInteger13);
                        BigInteger v4 = v(v3, bigInteger8);
                        BigInteger w3 = w(bigInteger14.multiply(bigInteger).subtract(v3));
                        BigInteger w4 = w(bigInteger15.multiply(bigInteger).subtract(bigInteger11.multiply(v3)));
                        BigInteger w5 = w(v3.multiply(v4));
                        for (int i5 = 1; i5 <= lowestSetBit; i5++) {
                            w3 = v(w3, w4);
                            w4 = w(w4.multiply(w4).subtract(w5.shiftLeft(1)));
                            w5 = w(w5.multiply(w5));
                        }
                        if (v(w4, w4).equals(shiftLeft2)) {
                            if (w4.testBit(0)) {
                                w4 = bigInteger6.subtract(w4);
                            }
                            return new Fp(bigInteger6, bigInteger7, w4.shiftRight(1));
                        }
                        z = false;
                        i2 = 1;
                        if (!w3.equals(bigInteger9)) {
                            bigInteger4 = bigInteger5;
                            if (!w3.equals(bigInteger4)) {
                                return null;
                            }
                        } else {
                            bigInteger4 = bigInteger5;
                        }
                        obj = null;
                    }
                    subtract = bigInteger4;
                    z2 = z;
                    i3 = i2;
                    bigInteger10 = bigInteger2;
                    random2 = random;
                    obj2 = obj;
                    shiftRight = bigInteger3;
                }
            } else {
                throw new RuntimeException("not done yet");
            }
        }

        public final ECFieldElement o() {
            BigInteger bigInteger = this.i;
            return new Fp(this.g, this.h, v(bigInteger, bigInteger));
        }

        public final ECFieldElement p(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger t = eCFieldElement.t();
            BigInteger t2 = eCFieldElement2.t();
            BigInteger bigInteger = this.i;
            return new Fp(this.g, this.h, w(bigInteger.multiply(bigInteger).add(t.multiply(t2))));
        }

        public final ECFieldElement r(ECFieldElement eCFieldElement) {
            BigInteger subtract = this.i.subtract(eCFieldElement.t());
            int signum = subtract.signum();
            BigInteger bigInteger = this.g;
            if (signum < 0) {
                subtract = subtract.add(bigInteger);
            }
            return new Fp(bigInteger, this.h, subtract);
        }

        public final BigInteger t() {
            return this.i;
        }

        public final BigInteger v(BigInteger bigInteger, BigInteger bigInteger2) {
            return w(bigInteger.multiply(bigInteger2));
        }

        public final BigInteger w(BigInteger bigInteger) {
            boolean z;
            BigInteger bigInteger2 = this.g;
            BigInteger bigInteger3 = this.h;
            if (bigInteger3 == null) {
                return bigInteger.mod(bigInteger2);
            }
            if (bigInteger.signum() < 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = bigInteger2.bitLength();
            boolean equals = bigInteger3.equals(ECConstants.b);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(bigInteger3);
                }
                bigInteger = shiftRight.add(subtract);
            }
            while (bigInteger.compareTo(bigInteger2) >= 0) {
                bigInteger = bigInteger.subtract(bigInteger2);
            }
            if (!z || bigInteger.signum() == 0) {
                return bigInteger;
            }
            return bigInteger2.subtract(bigInteger);
        }
    }

    public abstract ECFieldElement a(ECFieldElement eCFieldElement);

    public abstract ECFieldElement b();

    public int c() {
        return t().bitLength();
    }

    public abstract ECFieldElement d(ECFieldElement eCFieldElement);

    public final byte[] e() {
        return BigIntegers.a((f() + 7) / 8, t());
    }

    public abstract int f();

    public abstract ECFieldElement g();

    public boolean h() {
        if (c() == 1) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (t().signum() == 0) {
            return true;
        }
        return false;
    }

    public abstract ECFieldElement j(ECFieldElement eCFieldElement);

    public ECFieldElement k(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return j(eCFieldElement).r(eCFieldElement2.j(eCFieldElement3));
    }

    public ECFieldElement l(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return j(eCFieldElement).a(eCFieldElement2.j(eCFieldElement3));
    }

    public abstract ECFieldElement m();

    public abstract ECFieldElement n();

    public abstract ECFieldElement o();

    public ECFieldElement p(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return o().a(eCFieldElement.j(eCFieldElement2));
    }

    public ECFieldElement q(int i) {
        ECFieldElement eCFieldElement = this;
        for (int i2 = 0; i2 < i; i2++) {
            eCFieldElement = eCFieldElement.o();
        }
        return eCFieldElement;
    }

    public abstract ECFieldElement r(ECFieldElement eCFieldElement);

    public boolean s() {
        return t().testBit(0);
    }

    public abstract BigInteger t();

    public final String toString() {
        return t().toString(16);
    }

    public static class F2m extends ECFieldElement {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final LongArray f6618a;

        /* renamed from: a  reason: collision with other field name */
        public final int[] f6619a;
        public final int b;

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i3 == 0 && i4 == 0) {
                this.a = 2;
                this.f6619a = new int[]{i2};
            } else if (i3 >= i4) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i3 > 0) {
                this.a = 3;
                this.f6619a = new int[]{i2, i3, i4};
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            this.b = i;
            this.f6618a = new LongArray(bigInteger);
        }

        public static void u(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if (!(eCFieldElement instanceof F2m) || !(eCFieldElement2 instanceof F2m)) {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            F2m f2m = (F2m) eCFieldElement;
            F2m f2m2 = (F2m) eCFieldElement2;
            if (f2m.a != f2m2.a) {
                throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
            } else if (f2m.b != f2m2.b || !Arrays.b(f2m.f6619a, f2m2.f6619a)) {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            }
        }

        public final ECFieldElement a(ECFieldElement eCFieldElement) {
            LongArray longArray = (LongArray) this.f6618a.clone();
            longArray.c(((F2m) eCFieldElement).f6618a);
            return new F2m(this.b, longArray, this.f6619a);
        }

        public final ECFieldElement b() {
            LongArray longArray;
            LongArray longArray2 = this.f6618a;
            if (longArray2.f6629a.length == 0) {
                longArray = new LongArray(new long[]{1});
            } else {
                int max = Math.max(1, longArray2.i());
                long[] jArr = new long[max];
                long[] jArr2 = longArray2.f6629a;
                System.arraycopy(jArr2, 0, jArr, 0, Math.min(jArr2.length, max));
                jArr[0] = jArr[0] ^ 1;
                longArray = new LongArray(jArr);
            }
            return new F2m(this.b, longArray, this.f6619a);
        }

        public final int c() {
            return this.f6618a.f();
        }

        public final ECFieldElement d(ECFieldElement eCFieldElement) {
            return j(eCFieldElement.g());
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            if (this.b != f2m.b || this.a != f2m.a || !Arrays.b(this.f6619a, f2m.f6619a) || !this.f6618a.equals(f2m.f6618a)) {
                return false;
            }
            return true;
        }

        public final int f() {
            return this.b;
        }

        public final ECFieldElement g() {
            int i;
            int i2;
            LongArray longArray = this.f6618a;
            int f = longArray.f();
            if (f != 0) {
                int i3 = 1;
                int i4 = this.b;
                int[] iArr = this.f6619a;
                if (f != 1) {
                    LongArray longArray2 = (LongArray) longArray.clone();
                    int i5 = (i4 + 63) >>> 6;
                    LongArray longArray3 = new LongArray(i5);
                    long[] jArr = longArray3.f6629a;
                    int i6 = (i4 >>> 6) + 0;
                    jArr[i6] = (1 << (i4 & 63)) ^ jArr[i6];
                    int i7 = i4 - i4;
                    int length = iArr.length;
                    while (true) {
                        length--;
                        if (length < 0) {
                            break;
                        }
                        int i8 = iArr[length] + i7;
                        int i9 = (i8 >>> 6) + 0;
                        jArr[i9] = (1 << (i8 & 63)) ^ jArr[i9];
                    }
                    int i10 = (i7 >>> 6) + 0;
                    jArr[i10] = (1 << (i7 & 63)) ^ jArr[i10];
                    LongArray longArray4 = new LongArray(i5);
                    longArray4.f6629a[0] = 1;
                    int i11 = i4 + 1;
                    int[] iArr2 = {f, i11};
                    LongArray[] longArrayArr = {longArray2, longArray3};
                    int[] iArr3 = {1, 0};
                    LongArray[] longArrayArr2 = {longArray4, new LongArray(i5)};
                    int i12 = iArr3[1];
                    int i13 = i11 - f;
                    while (true) {
                        if (i13 < 0) {
                            i13 = -i13;
                            iArr2[i3] = i11;
                            iArr3[i3] = i12;
                            i3 = 1 - i3;
                            i11 = iArr2[i3];
                            i12 = iArr3[i3];
                        }
                        i = 1 - i3;
                        longArrayArr[i3].b(longArrayArr[i], iArr2[i], i13);
                        LongArray longArray5 = longArrayArr[i3];
                        int i14 = (i11 + 62) >>> 6;
                        while (true) {
                            if (i14 != 0) {
                                i14--;
                                long j = longArray5.f6629a[i14];
                                if (j != 0) {
                                    i2 = (i14 << 6) + LongArray.e(j);
                                    break;
                                }
                            } else {
                                longArray5.getClass();
                                i2 = 0;
                                break;
                            }
                        }
                        if (i2 == 0) {
                            break;
                        }
                        int i15 = iArr3[i];
                        longArrayArr2[i3].b(longArrayArr2[i], i15, i13);
                        int i16 = i15 + i13;
                        if (i16 > i12) {
                            i12 = i16;
                        } else if (i16 == i12) {
                            LongArray longArray6 = longArrayArr2[i3];
                            int i17 = (i12 + 62) >>> 6;
                            while (true) {
                                if (i17 != 0) {
                                    i17--;
                                    long j2 = longArray6.f6629a[i17];
                                    if (j2 != 0) {
                                        i12 = (i17 << 6) + LongArray.e(j2);
                                        break;
                                    }
                                } else {
                                    longArray6.getClass();
                                    i12 = 0;
                                    break;
                                }
                            }
                        }
                        i13 += i2 - i11;
                        i11 = i2;
                    }
                    longArray = longArrayArr2[i];
                }
                return new F2m(i4, longArray, iArr);
            }
            throw new IllegalStateException();
        }

        public final boolean h() {
            return this.f6618a.k();
        }

        public final int hashCode() {
            return (this.f6618a.hashCode() ^ this.b) ^ Arrays.u(this.f6619a);
        }

        public final boolean i() {
            long[] jArr = this.f6618a.f6629a;
            for (long j : jArr) {
                if (j != 0) {
                    return false;
                }
            }
            return true;
        }

        public final ECFieldElement j(ECFieldElement eCFieldElement) {
            long[] jArr;
            int i;
            long[] jArr2;
            int i2;
            int[] iArr;
            int i3;
            LongArray longArray = ((F2m) eCFieldElement).f6618a;
            LongArray longArray2 = this.f6618a;
            int f = longArray2.f();
            int i4 = this.b;
            int[] iArr2 = this.f6619a;
            if (f != 0) {
                int f2 = longArray.f();
                if (f2 != 0) {
                    if (f > f2) {
                        LongArray longArray3 = longArray2;
                        longArray2 = longArray;
                        longArray = longArray3;
                        int i5 = f2;
                        f2 = f;
                        f = i5;
                    }
                    int i6 = (f + 63) >>> 6;
                    int i7 = (f2 + 63) >>> 6;
                    int i8 = ((f + f2) + 62) >>> 6;
                    if (i6 == 1) {
                        long j = longArray2.f6629a[0];
                        if (j != 1) {
                            long[] jArr3 = new long[i8];
                            LongArray.m(j, longArray.f6629a, i7, jArr3);
                            longArray = new LongArray(jArr3, LongArray.n(jArr3, i8, i4, iArr2));
                        }
                    } else {
                        int i9 = ((f2 + 7) + 63) >>> 6;
                        int i10 = 16;
                        int[] iArr3 = new int[16];
                        int i11 = i9 << 4;
                        long[] jArr4 = new long[i11];
                        iArr3[1] = i9;
                        System.arraycopy(longArray.f6629a, 0, jArr4, i9, i7);
                        int i12 = 2;
                        int i13 = i9;
                        while (i12 < i10) {
                            i13 += i9;
                            iArr3[i12] = i13;
                            if ((i12 & 1) == 0) {
                                jArr2 = jArr4;
                                i3 = i11;
                                iArr = iArr3;
                                i2 = i10;
                                LongArray.o(jArr4, i13 >>> 1, jArr2, i13, i9, 1);
                            } else {
                                jArr2 = jArr4;
                                i3 = i11;
                                iArr = iArr3;
                                i2 = i10;
                                int i14 = i13 - i9;
                                for (int i15 = 0; i15 < i9; i15++) {
                                    jArr2[i13 + i15] = jArr2[i9 + i15] ^ jArr2[i14 + i15];
                                }
                            }
                            i12++;
                            i11 = i3;
                            iArr3 = iArr;
                            i10 = i2;
                            jArr4 = jArr2;
                        }
                        long[] jArr5 = jArr4;
                        int i16 = i11;
                        int[] iArr4 = iArr3;
                        long[] jArr6 = new long[i16];
                        LongArray.o(jArr5, 0, jArr6, 0, i16, 4);
                        long[] jArr7 = longArray2.f6629a;
                        int i17 = i8 << 3;
                        long[] jArr8 = new long[i17];
                        int i18 = 0;
                        while (i18 < i6) {
                            long j2 = jArr7[i18];
                            int i19 = i18;
                            while (true) {
                                long j3 = j2 >>> 4;
                                jArr = jArr7;
                                int i20 = iArr4[((int) j2) & 15];
                                int i21 = iArr4[((int) j3) & 15];
                                i = i6;
                                for (int i22 = 0; i22 < i9; i22++) {
                                    int i23 = i19 + i22;
                                    jArr8[i23] = jArr8[i23] ^ (jArr5[i20 + i22] ^ jArr6[i21 + i22]);
                                }
                                j2 = j3 >>> 4;
                                if (j2 == 0) {
                                    break;
                                }
                                i19 += i8;
                                jArr7 = jArr;
                                i6 = i;
                            }
                            i18++;
                            jArr7 = jArr;
                            i6 = i;
                        }
                        while (true) {
                            i17 -= i8;
                            if (i17 == 0) {
                                break;
                            }
                            LongArray.d(jArr8, i17 - i8, jArr8, i17, i8, 8);
                            jArr8 = jArr8;
                        }
                        long[] jArr9 = jArr8;
                        longArray2 = new LongArray(jArr9, LongArray.n(jArr9, i8, i4, iArr2));
                    }
                }
                return new F2m(i4, longArray, iArr2);
            }
            longArray = longArray2;
            return new F2m(i4, longArray, iArr2);
        }

        public final ECFieldElement k(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return l(eCFieldElement, eCFieldElement2, eCFieldElement3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: org.spongycastle.math.ec.LongArray} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final org.spongycastle.math.ec.ECFieldElement l(org.spongycastle.math.ec.ECFieldElement r5, org.spongycastle.math.ec.ECFieldElement r6, org.spongycastle.math.ec.ECFieldElement r7) {
            /*
                r4 = this;
                org.spongycastle.math.ec.ECFieldElement$F2m r5 = (org.spongycastle.math.ec.ECFieldElement.F2m) r5
                org.spongycastle.math.ec.LongArray r5 = r5.f6618a
                org.spongycastle.math.ec.ECFieldElement$F2m r6 = (org.spongycastle.math.ec.ECFieldElement.F2m) r6
                org.spongycastle.math.ec.LongArray r6 = r6.f6618a
                org.spongycastle.math.ec.ECFieldElement$F2m r7 = (org.spongycastle.math.ec.ECFieldElement.F2m) r7
                org.spongycastle.math.ec.LongArray r7 = r7.f6618a
                org.spongycastle.math.ec.LongArray r0 = r4.f6618a
                org.spongycastle.math.ec.LongArray r1 = r0.l(r5)
                org.spongycastle.math.ec.LongArray r6 = r6.l(r7)
                if (r1 == r0) goto L_0x001a
                if (r1 != r5) goto L_0x0021
            L_0x001a:
                java.lang.Object r5 = r1.clone()
                r1 = r5
                org.spongycastle.math.ec.LongArray r1 = (org.spongycastle.math.ec.LongArray) r1
            L_0x0021:
                r1.c(r6)
                long[] r5 = r1.f6629a
                int r6 = r5.length
                int r7 = r4.b
                int[] r0 = r4.f6619a
                int r6 = org.spongycastle.math.ec.LongArray.n(r5, r6, r7, r0)
                int r2 = r5.length
                if (r6 >= r2) goto L_0x003a
                long[] r2 = new long[r6]
                r1.f6629a = r2
                r3 = 0
                java.lang.System.arraycopy(r5, r3, r2, r3, r6)
            L_0x003a:
                org.spongycastle.math.ec.ECFieldElement$F2m r5 = new org.spongycastle.math.ec.ECFieldElement$F2m
                r5.<init>(r7, r1, r0)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.ECFieldElement.F2m.l(org.spongycastle.math.ec.ECFieldElement, org.spongycastle.math.ec.ECFieldElement, org.spongycastle.math.ec.ECFieldElement):org.spongycastle.math.ec.ECFieldElement");
        }

        public final ECFieldElement n() {
            LongArray longArray = this.f6618a;
            long[] jArr = longArray.f6629a;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= jArr.length) {
                    z = true;
                    break;
                } else if (jArr[i] != 0) {
                    break;
                } else {
                    i++;
                }
            }
            if (z || longArray.k()) {
                return this;
            }
            return q(this.b - 1);
        }

        public final ECFieldElement o() {
            LongArray longArray = this.f6618a;
            int i = longArray.i();
            int i2 = this.b;
            int[] iArr = this.f6619a;
            if (i != 0) {
                int i3 = i << 1;
                long[] jArr = new long[i3];
                int i4 = 0;
                while (i4 < i3) {
                    long j = longArray.f6629a[i4 >>> 1];
                    int i5 = i4 + 1;
                    jArr[i4] = LongArray.j((int) j);
                    i4 = i5 + 1;
                    jArr[i5] = LongArray.j((int) (j >>> 32));
                }
                longArray = new LongArray(jArr, LongArray.n(jArr, i3, i2, iArr));
            }
            return new F2m(i2, longArray, iArr);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: org.spongycastle.math.ec.LongArray} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final org.spongycastle.math.ec.ECFieldElement p(org.spongycastle.math.ec.ECFieldElement r11, org.spongycastle.math.ec.ECFieldElement r12) {
            /*
                r10 = this;
                org.spongycastle.math.ec.ECFieldElement$F2m r11 = (org.spongycastle.math.ec.ECFieldElement.F2m) r11
                org.spongycastle.math.ec.LongArray r11 = r11.f6618a
                org.spongycastle.math.ec.ECFieldElement$F2m r12 = (org.spongycastle.math.ec.ECFieldElement.F2m) r12
                org.spongycastle.math.ec.LongArray r12 = r12.f6618a
                org.spongycastle.math.ec.LongArray r0 = r10.f6618a
                int r1 = r0.i()
                r2 = 0
                if (r1 != 0) goto L_0x0013
                r4 = r0
                goto L_0x003b
            L_0x0013:
                int r1 = r1 << 1
                long[] r3 = new long[r1]
                r4 = r2
            L_0x0018:
                if (r4 >= r1) goto L_0x0036
                long[] r5 = r0.f6629a
                int r6 = r4 >>> 1
                r6 = r5[r6]
                int r5 = r4 + 1
                int r8 = (int) r6
                long r8 = org.spongycastle.math.ec.LongArray.j(r8)
                r3[r4] = r8
                int r4 = r5 + 1
                r8 = 32
                long r6 = r6 >>> r8
                int r6 = (int) r6
                long r6 = org.spongycastle.math.ec.LongArray.j(r6)
                r3[r5] = r6
                goto L_0x0018
            L_0x0036:
                org.spongycastle.math.ec.LongArray r4 = new org.spongycastle.math.ec.LongArray
                r4.<init>(r3, r1)
            L_0x003b:
                org.spongycastle.math.ec.LongArray r11 = r11.l(r12)
                if (r4 != r0) goto L_0x0048
                java.lang.Object r12 = r4.clone()
                r4 = r12
                org.spongycastle.math.ec.LongArray r4 = (org.spongycastle.math.ec.LongArray) r4
            L_0x0048:
                r4.c(r11)
                long[] r11 = r4.f6629a
                int r12 = r11.length
                int r0 = r10.b
                int[] r1 = r10.f6619a
                int r12 = org.spongycastle.math.ec.LongArray.n(r11, r12, r0, r1)
                int r3 = r11.length
                if (r12 >= r3) goto L_0x0060
                long[] r3 = new long[r12]
                r4.f6629a = r3
                java.lang.System.arraycopy(r11, r2, r3, r2, r12)
            L_0x0060:
                org.spongycastle.math.ec.ECFieldElement$F2m r11 = new org.spongycastle.math.ec.ECFieldElement$F2m
                r11.<init>(r0, r4, r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.ECFieldElement.F2m.p(org.spongycastle.math.ec.ECFieldElement, org.spongycastle.math.ec.ECFieldElement):org.spongycastle.math.ec.ECFieldElement");
        }

        public final ECFieldElement q(int i) {
            if (i < 1) {
                return this;
            }
            LongArray longArray = this.f6618a;
            int i2 = longArray.i();
            int i3 = this.b;
            int[] iArr = this.f6619a;
            if (i2 != 0) {
                int i4 = ((i3 + 63) >>> 6) << 1;
                long[] jArr = new long[i4];
                System.arraycopy(longArray.f6629a, 0, jArr, 0, i2);
                while (true) {
                    i--;
                    if (i < 0) {
                        break;
                    }
                    int i5 = i2 << 1;
                    while (true) {
                        i2--;
                        if (i2 < 0) {
                            break;
                        }
                        long j = jArr[i2];
                        int i6 = i5 - 1;
                        jArr[i6] = LongArray.j((int) (j >>> 32));
                        i5 = i6 - 1;
                        jArr[i5] = LongArray.j((int) j);
                    }
                    i2 = LongArray.n(jArr, i4, i3, iArr);
                }
                longArray = new LongArray(jArr, i2);
            }
            return new F2m(i3, longArray, iArr);
        }

        public final ECFieldElement r(ECFieldElement eCFieldElement) {
            return a(eCFieldElement);
        }

        public final boolean s() {
            long[] jArr = this.f6618a.f6629a;
            if (jArr.length <= 0 || (1 & jArr[0]) == 0) {
                return false;
            }
            return true;
        }

        public final BigInteger t() {
            LongArray longArray = this.f6618a;
            int i = longArray.i();
            if (i == 0) {
                return ECConstants.a;
            }
            int i2 = i - 1;
            long j = longArray.f6629a[i2];
            byte[] bArr = new byte[8];
            int i3 = 0;
            boolean z = false;
            for (int i4 = 7; i4 >= 0; i4--) {
                byte b2 = (byte) ((int) (j >>> (i4 * 8)));
                if (z || b2 != 0) {
                    bArr[i3] = b2;
                    i3++;
                    z = true;
                }
            }
            byte[] bArr2 = new byte[((i2 * 8) + i3)];
            for (int i5 = 0; i5 < i3; i5++) {
                bArr2[i5] = bArr[i5];
            }
            for (int i6 = i - 2; i6 >= 0; i6--) {
                long j2 = longArray.f6629a[i6];
                int i7 = 7;
                while (i7 >= 0) {
                    bArr2[i3] = (byte) ((int) (j2 >>> (i7 * 8)));
                    i7--;
                    i3++;
                }
            }
            return new BigInteger(1, bArr2);
        }

        public F2m(int i, LongArray longArray, int[] iArr) {
            this.b = i;
            this.a = iArr.length == 1 ? 2 : 3;
            this.f6619a = iArr;
            this.f6618a = longArray;
        }

        public final ECFieldElement m() {
            return this;
        }
    }
}
