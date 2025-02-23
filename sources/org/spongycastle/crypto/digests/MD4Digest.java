package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.util.Memoable;

public class MD4Digest extends GeneralDigest {
    public final int[] a = new int[16];
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public MD4Digest() {
        reset();
    }

    public final Memoable a() {
        return new MD4Digest(this);
    }

    public final String b() {
        return "MD4";
    }

    public final int c(int i, byte[] bArr) {
        j();
        q(this.b, bArr, i);
        q(this.c, bArr, i + 4);
        q(this.d, bArr, i + 8);
        q(this.e, bArr, i + 12);
        reset();
        return 16;
    }

    public final void e(Memoable memoable) {
        o((MD4Digest) memoable);
    }

    public final int f() {
        return 16;
    }

    public final void k() {
        int i = this.b;
        int i2 = this.c;
        int i3 = this.d;
        int i4 = this.e;
        int i5 = i + ((i3 & i2) | ((~i2) & i4));
        int[] iArr = this.a;
        int p = p(i5 + iArr[0], 3);
        int p2 = p(i4 + ((i2 & p) | ((~p) & i3)) + iArr[1], 7);
        int p3 = p(i3 + ((p & p2) | ((~p2) & i2)) + iArr[2], 11);
        int p4 = p(i2 + ((p2 & p3) | ((~p3) & p)) + iArr[3], 19);
        int p5 = p(p + ((p3 & p4) | ((~p4) & p2)) + iArr[4], 3);
        int p6 = p(p2 + ((p4 & p5) | ((~p5) & p3)) + iArr[5], 7);
        int p7 = p(p3 + ((p5 & p6) | ((~p6) & p4)) + iArr[6], 11);
        int p8 = p(p4 + ((p6 & p7) | ((~p7) & p5)) + iArr[7], 19);
        int p9 = p(p5 + ((p7 & p8) | ((~p8) & p6)) + iArr[8], 3);
        int p10 = p(p6 + ((p8 & p9) | ((~p9) & p7)) + iArr[9], 7);
        int p11 = p(p7 + ((p9 & p10) | ((~p10) & p8)) + iArr[10], 11);
        int p12 = p(p8 + ((p10 & p11) | ((~p11) & p9)) + iArr[11], 19);
        int p13 = p(p9 + ((p11 & p12) | ((~p12) & p10)) + iArr[12], 3);
        int p14 = p(p10 + ((p12 & p13) | ((~p13) & p11)) + iArr[13], 7);
        int p15 = p(p11 + ((p13 & p14) | ((~p14) & p12)) + iArr[14], 11);
        int p16 = p(p12 + ((p14 & p15) | ((~p15) & p13)) + iArr[15], 19);
        int b2 = lf.b(n(p16, p15, p14) + p13, iArr[0], 1518500249, this, 3);
        int b3 = lf.b(n(b2, p16, p15) + p14, iArr[4], 1518500249, this, 5);
        int b4 = lf.b(n(b3, b2, p16) + p15, iArr[8], 1518500249, this, 9);
        int b5 = lf.b(n(b4, b3, b2) + p16, iArr[12], 1518500249, this, 13);
        int b6 = lf.b(n(b5, b4, b3) + b2, iArr[1], 1518500249, this, 3);
        int b7 = lf.b(n(b6, b5, b4) + b3, iArr[5], 1518500249, this, 5);
        int b8 = lf.b(n(b7, b6, b5) + b4, iArr[9], 1518500249, this, 9);
        int b9 = lf.b(n(b8, b7, b6) + b5, iArr[13], 1518500249, this, 13);
        int b10 = lf.b(n(b9, b8, b7) + b6, iArr[2], 1518500249, this, 3);
        int b11 = lf.b(n(b10, b9, b8) + b7, iArr[6], 1518500249, this, 5);
        int b12 = lf.b(n(b11, b10, b9) + b8, iArr[10], 1518500249, this, 9);
        int b13 = lf.b(n(b12, b11, b10) + b9, iArr[14], 1518500249, this, 13);
        int b14 = lf.b(n(b13, b12, b11) + b10, iArr[3], 1518500249, this, 3);
        int b15 = lf.b(n(b14, b13, b12) + b11, iArr[7], 1518500249, this, 5);
        int b16 = lf.b(n(b15, b14, b13) + b12, iArr[11], 1518500249, this, 9);
        int b17 = lf.b(n(b16, b15, b14) + b13, iArr[15], 1518500249, this, 13);
        int b18 = lf.b(b14 + ((b17 ^ b16) ^ b15), iArr[0], 1859775393, this, 3);
        int b19 = lf.b(b15 + ((b18 ^ b17) ^ b16), iArr[8], 1859775393, this, 9);
        int b20 = lf.b(b16 + ((b19 ^ b18) ^ b17), iArr[4], 1859775393, this, 11);
        int b21 = lf.b(b17 + ((b20 ^ b19) ^ b18), iArr[12], 1859775393, this, 15);
        int b22 = lf.b(b18 + ((b21 ^ b20) ^ b19), iArr[2], 1859775393, this, 3);
        int b23 = lf.b(b19 + ((b22 ^ b21) ^ b20), iArr[10], 1859775393, this, 9);
        int b24 = lf.b(b20 + ((b23 ^ b22) ^ b21), iArr[6], 1859775393, this, 11);
        int b25 = lf.b(b21 + ((b24 ^ b23) ^ b22), iArr[14], 1859775393, this, 15);
        int b26 = lf.b(b22 + ((b25 ^ b24) ^ b23), iArr[1], 1859775393, this, 3);
        int b27 = lf.b(b23 + ((b26 ^ b25) ^ b24), iArr[9], 1859775393, this, 9);
        int b28 = lf.b(b24 + ((b27 ^ b26) ^ b25), iArr[5], 1859775393, this, 11);
        int b29 = lf.b(b25 + ((b28 ^ b27) ^ b26), iArr[13], 1859775393, this, 15);
        int b30 = lf.b(b26 + ((b29 ^ b28) ^ b27), iArr[3], 1859775393, this, 3);
        int b31 = lf.b(b27 + ((b30 ^ b29) ^ b28), iArr[11], 1859775393, this, 9);
        int b32 = lf.b(b28 + ((b31 ^ b30) ^ b29), iArr[7], 1859775393, this, 11);
        int b33 = lf.b(b29 + ((b32 ^ b31) ^ b30), iArr[15], 1859775393, this, 15);
        this.b += b30;
        this.c += b33;
        this.d += b32;
        this.e += b31;
        this.f = 0;
        for (int i6 = 0; i6 != iArr.length; i6++) {
            iArr[i6] = 0;
        }
    }

    public final void l(long j) {
        if (this.f > 14) {
            k();
        }
        int[] iArr = this.a;
        iArr[14] = (int) (-1 & j);
        iArr[15] = (int) (j >>> 32);
    }

    public final void m(int i, byte[] bArr) {
        int i2 = this.f;
        int i3 = i2 + 1;
        this.f = i3;
        int i4 = (bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN;
        this.a[i2] = i4 | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        if (i3 == 16) {
            k();
        }
    }

    public final int n(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    public final void o(MD4Digest mD4Digest) {
        i(mD4Digest);
        this.b = mD4Digest.b;
        this.c = mD4Digest.c;
        this.d = mD4Digest.d;
        this.e = mD4Digest.e;
        int[] iArr = this.a;
        int[] iArr2 = mD4Digest.a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.f = mD4Digest.f;
    }

    public final int p(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public final void q(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public final void reset() {
        super.reset();
        this.b = 1732584193;
        this.c = -271733879;
        this.d = -1732584194;
        this.e = 271733878;
        this.f = 0;
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

    public MD4Digest(MD4Digest mD4Digest) {
        super(mD4Digest);
        o(mD4Digest);
    }
}
