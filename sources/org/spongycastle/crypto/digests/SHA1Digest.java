package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SHA1Digest extends GeneralDigest implements EncodableDigest {
    public final int[] a = new int[80];
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public SHA1Digest() {
        reset();
    }

    public final Memoable a() {
        return new SHA1Digest(this);
    }

    public final String b() {
        return "SHA-1";
    }

    public final int c(int i, byte[] bArr) {
        j();
        Pack.c(this.b, bArr, i);
        Pack.c(this.c, bArr, i + 4);
        Pack.c(this.d, bArr, i + 8);
        Pack.c(this.e, bArr, i + 12);
        Pack.c(this.f, bArr, i + 16);
        reset();
        return 20;
    }

    public final void e(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        i(sHA1Digest);
        n(sHA1Digest);
    }

    public final int f() {
        return 20;
    }

    public final void k() {
        int[] iArr;
        int i = 16;
        while (true) {
            iArr = this.a;
            if (i >= 80) {
                break;
            }
            int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
            iArr[i] = (i2 >>> 31) | (i2 << 1);
            i++;
        }
        int i3 = this.b;
        int i4 = this.c;
        int i5 = this.d;
        int i6 = this.e;
        int i7 = this.f;
        int i8 = 0;
        int i9 = 0;
        while (i8 < 4) {
            int i10 = i9 + 1;
            int q = C1058d.q(((i3 << 5) | (i3 >>> 27)) + ((i5 & i4) | ((~i4) & i6)), iArr[i9], 1518500249, i7);
            int i11 = (i4 >>> 2) | (i4 << 30);
            int i12 = i10 + 1;
            int q2 = C1058d.q(((q << 5) | (q >>> 27)) + ((i11 & i3) | ((~i3) & i5)), iArr[i10], 1518500249, i6);
            int i13 = (i3 >>> 2) | (i3 << 30);
            int i14 = i12 + 1;
            int q3 = C1058d.q(((q2 << 5) | (q2 >>> 27)) + ((i13 & q) | ((~q) & i11)), iArr[i12], 1518500249, i5);
            i7 = (q >>> 2) | (q << 30);
            int i15 = i14 + 1;
            i4 = C1058d.q(((q3 << 5) | (q3 >>> 27)) + ((i7 & q2) | ((~q2) & i13)), iArr[i14], 1518500249, i11);
            i6 = (q2 >>> 2) | (q2 << 30);
            i3 = C1058d.q(((i4 << 5) | (i4 >>> 27)) + ((i6 & q3) | ((~q3) & i7)), iArr[i15], 1518500249, i13);
            i5 = (q3 >>> 2) | (q3 << 30);
            i8++;
            i9 = i15 + 1;
        }
        int i16 = 0;
        while (i16 < 4) {
            int i17 = i9 + 1;
            int q4 = C1058d.q(((i3 << 5) | (i3 >>> 27)) + ((i4 ^ i5) ^ i6), iArr[i9], 1859775393, i7);
            int i18 = (i4 >>> 2) | (i4 << 30);
            int i19 = i17 + 1;
            int q5 = C1058d.q(((q4 << 5) | (q4 >>> 27)) + ((i3 ^ i18) ^ i5), iArr[i17], 1859775393, i6);
            int i20 = (i3 >>> 2) | (i3 << 30);
            int i21 = i19 + 1;
            int q6 = C1058d.q(((q5 << 5) | (q5 >>> 27)) + ((q4 ^ i20) ^ i18), iArr[i19], 1859775393, i5);
            i7 = (q4 >>> 2) | (q4 << 30);
            int i22 = i21 + 1;
            i4 = C1058d.q(((q6 << 5) | (q6 >>> 27)) + ((q5 ^ i7) ^ i20), iArr[i21], 1859775393, i18);
            i6 = (q5 >>> 2) | (q5 << 30);
            i3 = C1058d.q(((i4 << 5) | (i4 >>> 27)) + ((q6 ^ i6) ^ i7), iArr[i22], 1859775393, i20);
            i5 = (q6 >>> 2) | (q6 << 30);
            i16++;
            i9 = i22 + 1;
        }
        int i23 = 0;
        while (i23 < 4) {
            int i24 = i9 + 1;
            int q7 = C1058d.q(((i4 & i5) | (i4 & i6) | (i5 & i6)) + ((i3 << 5) | (i3 >>> 27)), iArr[i9], -1894007588, i7);
            int i25 = (i4 >>> 2) | (i4 << 30);
            int i26 = i24 + 1;
            int q8 = C1058d.q(((i3 & i25) | (i3 & i5) | (i25 & i5)) + ((q7 << 5) | (q7 >>> 27)), iArr[i24], -1894007588, i6);
            int i27 = (i3 >>> 2) | (i3 << 30);
            int i28 = i26 + 1;
            int q9 = C1058d.q(((q7 & i27) | (q7 & i25) | (i27 & i25)) + ((q8 << 5) | (q8 >>> 27)), iArr[i26], -1894007588, i5);
            i7 = (q7 >>> 2) | (q7 << 30);
            int i29 = i28 + 1;
            i4 = C1058d.q(((q8 & i7) | (q8 & i27) | (i7 & i27)) + ((q9 << 5) | (q9 >>> 27)), iArr[i28], -1894007588, i25);
            i6 = (q8 >>> 2) | (q8 << 30);
            i3 = C1058d.q(((q9 & i6) | (q9 & i7) | (i6 & i7)) + ((i4 << 5) | (i4 >>> 27)), iArr[i29], -1894007588, i27);
            i5 = (q9 >>> 2) | (q9 << 30);
            i23++;
            i9 = i29 + 1;
        }
        int i30 = 0;
        while (i30 <= 3) {
            int i31 = i9 + 1;
            int q10 = C1058d.q(((i3 << 5) | (i3 >>> 27)) + ((i4 ^ i5) ^ i6), iArr[i9], -899497514, i7);
            int i32 = (i4 >>> 2) | (i4 << 30);
            int i33 = i31 + 1;
            int q11 = C1058d.q(((q10 << 5) | (q10 >>> 27)) + ((i3 ^ i32) ^ i5), iArr[i31], -899497514, i6);
            int i34 = (i3 >>> 2) | (i3 << 30);
            int i35 = i33 + 1;
            int q12 = C1058d.q(((q11 << 5) | (q11 >>> 27)) + ((q10 ^ i34) ^ i32), iArr[i33], -899497514, i5);
            i7 = (q10 >>> 2) | (q10 << 30);
            int i36 = i35 + 1;
            i4 = C1058d.q(((q12 << 5) | (q12 >>> 27)) + ((q11 ^ i7) ^ i34), iArr[i35], -899497514, i32);
            i6 = (q11 >>> 2) | (q11 << 30);
            i3 = C1058d.q(((i4 << 5) | (i4 >>> 27)) + ((q12 ^ i6) ^ i7), iArr[i36], -899497514, i34);
            i5 = (q12 >>> 2) | (q12 << 30);
            i30++;
            i9 = i36 + 1;
        }
        this.b += i3;
        this.c += i4;
        this.d += i5;
        this.e += i6;
        this.f += i7;
        this.g = 0;
        for (int i37 = 0; i37 < 16; i37++) {
            iArr[i37] = 0;
        }
    }

    public final void l(long j) {
        if (this.g > 14) {
            k();
        }
        int[] iArr = this.a;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & -1);
    }

    public final void m(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) | (bArr[i] << Ascii.CAN) | ((bArr[i2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << 8);
        int i5 = this.g;
        this.a[i5] = i4;
        int i6 = i5 + 1;
        this.g = i6;
        if (i6 == 16) {
            k();
        }
    }

    public final void n(SHA1Digest sHA1Digest) {
        this.b = sHA1Digest.b;
        this.c = sHA1Digest.c;
        this.d = sHA1Digest.d;
        this.e = sHA1Digest.e;
        this.f = sHA1Digest.f;
        int[] iArr = this.a;
        int[] iArr2 = sHA1Digest.a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.g = sHA1Digest.g;
    }

    public final void reset() {
        super.reset();
        this.b = 1732584193;
        this.c = -271733879;
        this.d = -1732584194;
        this.e = 271733878;
        this.f = -1009589776;
        this.g = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super(sHA1Digest);
        n(sHA1Digest);
    }
}
