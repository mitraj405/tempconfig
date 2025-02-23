package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SM3Digest extends GeneralDigest {
    public static final int[] e = new int[64];
    public final int[] a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f5858b;
    public final int[] c;
    public final int[] d;

    static {
        int i;
        int i2 = 0;
        while (true) {
            if (i2 >= 16) {
                break;
            }
            e[i2] = (2043430169 >>> (32 - i2)) | (2043430169 << i2);
            i2++;
        }
        for (i = 16; i < 64; i++) {
            int i3 = i % 32;
            e[i] = (2055708042 >>> (32 - i3)) | (2055708042 << i3);
        }
    }

    public SM3Digest() {
        this.a = new int[8];
        this.f5858b = new int[16];
        this.c = new int[68];
        this.d = new int[64];
        reset();
    }

    public final Memoable a() {
        return new SM3Digest(this);
    }

    public final String b() {
        return "SM3";
    }

    public final int c(int i, byte[] bArr) {
        j();
        int[] iArr = this.a;
        Pack.c(iArr[0], bArr, i + 0);
        Pack.c(iArr[1], bArr, i + 4);
        Pack.c(iArr[2], bArr, i + 8);
        Pack.c(iArr[3], bArr, i + 12);
        Pack.c(iArr[4], bArr, i + 16);
        Pack.c(iArr[5], bArr, i + 20);
        Pack.c(iArr[6], bArr, i + 24);
        Pack.c(iArr[7], bArr, i + 28);
        reset();
        return 32;
    }

    public final void e(Memoable memoable) {
        SM3Digest sM3Digest = (SM3Digest) memoable;
        i(sM3Digest);
        int[] iArr = this.a;
        System.arraycopy(sM3Digest.a, 0, iArr, 0, iArr.length);
        int[] iArr2 = this.f5858b;
        System.arraycopy(sM3Digest.f5858b, 0, iArr2, 0, iArr2.length);
        this.b = sM3Digest.b;
    }

    public final int f() {
        return 32;
    }

    public final void k() {
        int i;
        int[] iArr;
        int i2;
        int[] iArr2;
        int[] iArr3;
        int i3 = 0;
        while (true) {
            i = 16;
            iArr = this.c;
            if (i3 >= 16) {
                break;
            }
            iArr[i3] = this.f5858b[i3];
            i3++;
        }
        for (int i4 = 16; i4 < 68; i4++) {
            int i5 = iArr[i4 - 3];
            int i6 = iArr[i4 - 13];
            int i7 = ((i5 >>> 17) | (i5 << 15)) ^ (iArr[i4 - 16] ^ iArr[i4 - 9]);
            iArr[i4] = (((i7 ^ ((i7 << 15) | (i7 >>> 17))) ^ ((i7 << 23) | (i7 >>> 9))) ^ ((i6 >>> 25) | (i6 << 7))) ^ iArr[i4 - 6];
        }
        int i8 = 0;
        while (true) {
            i2 = 64;
            iArr2 = this.d;
            if (i8 >= 64) {
                break;
            }
            iArr2[i8] = iArr[i8] ^ iArr[i8 + 4];
            i8++;
        }
        int[] iArr4 = this.a;
        int i9 = iArr4[0];
        int i10 = iArr4[1];
        int i11 = iArr4[2];
        int i12 = iArr4[3];
        int i13 = iArr4[4];
        int i14 = iArr4[5];
        int i15 = iArr4[6];
        int i16 = iArr4[7];
        int i17 = 0;
        while (true) {
            iArr3 = e;
            if (i17 >= 16) {
                break;
            }
            int i18 = (i9 << 12) | (i9 >>> 20);
            int i19 = i18 + i13 + iArr3[i17];
            int i20 = (i19 << 7) | (i19 >>> 25);
            int i21 = ((i9 ^ i10) ^ i11) + i12 + (i20 ^ i18) + iArr2[i17];
            int i22 = ((i13 ^ i14) ^ i15) + i16 + i20 + iArr[i17];
            i17++;
            int i23 = (i10 << 9) | (i10 >>> 23);
            i10 = i9;
            i9 = i21;
            i12 = i11;
            i11 = i23;
            int i24 = (i14 << 19) | (i14 >>> 13);
            i14 = i13;
            i13 = (i22 ^ ((i22 << 9) | (i22 >>> 23))) ^ ((i22 << 17) | (i22 >>> 15));
            i16 = i15;
            i15 = i24;
        }
        while (i < i2) {
            int i25 = (i9 << 12) | (i9 >>> 20);
            int i26 = i25 + i13 + iArr3[i];
            int i27 = (i26 << 7) | (i26 >>> 25);
            int i28 = ((i9 & i11) | (i9 & i10) | (i10 & i11)) + i12;
            int i29 = (((~i13) & i15) | (i14 & i13)) + i16 + i27 + iArr[i];
            int i30 = (i14 << 19) | (i14 >>> 13);
            i++;
            i14 = i13;
            i16 = i15;
            i13 = (i29 ^ ((i29 << 9) | (i29 >>> 23))) ^ ((i29 << 17) | (i29 >>> 15));
            i15 = i30;
            i2 = 64;
            int i31 = (i10 >>> 23) | (i10 << 9);
            i10 = i9;
            i9 = i28 + (i27 ^ i25) + iArr2[i];
            i12 = i11;
            i11 = i31;
        }
        iArr4[0] = iArr4[0] ^ i9;
        iArr4[1] = iArr4[1] ^ i10;
        iArr4[2] = iArr4[2] ^ i11;
        iArr4[3] = iArr4[3] ^ i12;
        iArr4[4] = iArr4[4] ^ i13;
        iArr4[5] = iArr4[5] ^ i14;
        iArr4[6] = iArr4[6] ^ i15;
        iArr4[7] = iArr4[7] ^ i16;
        this.b = 0;
    }

    public final void l(long j) {
        int i = this.b;
        int[] iArr = this.f5858b;
        if (i > 14) {
            iArr[i] = 0;
            this.b = i + 1;
            k();
        }
        while (true) {
            int i2 = this.b;
            if (i2 < 14) {
                iArr[i2] = 0;
                this.b = i2 + 1;
            } else {
                int i3 = i2 + 1;
                iArr[i2] = (int) (j >>> 32);
                this.b = i3 + 1;
                iArr[i3] = (int) j;
                return;
            }
        }
    }

    public final void m(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) | ((bArr[i] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << 8);
        int i5 = this.b;
        this.f5858b[i5] = i4;
        int i6 = i5 + 1;
        this.b = i6;
        if (i6 >= 16) {
            k();
        }
    }

    public final void reset() {
        super.reset();
        int[] iArr = this.a;
        iArr[0] = 1937774191;
        iArr[1] = 1226093241;
        iArr[2] = 388252375;
        iArr[3] = -628488704;
        iArr[4] = -1452330820;
        iArr[5] = 372324522;
        iArr[6] = -477237683;
        iArr[7] = -1325724082;
        this.b = 0;
    }

    public SM3Digest(SM3Digest sM3Digest) {
        super(sM3Digest);
        int[] iArr = new int[8];
        this.a = iArr;
        int[] iArr2 = new int[16];
        this.f5858b = iArr2;
        this.c = new int[68];
        this.d = new int[64];
        System.arraycopy(sM3Digest.a, 0, iArr, 0, iArr.length);
        System.arraycopy(sM3Digest.f5858b, 0, iArr2, 0, iArr2.length);
        this.b = sM3Digest.b;
    }
}
