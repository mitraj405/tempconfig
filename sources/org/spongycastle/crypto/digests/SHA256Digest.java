package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SHA256Digest extends GeneralDigest implements EncodableDigest {
    public static final int[] b = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    public final int[] a = new int[64];

    /* renamed from: b  reason: collision with other field name */
    public int f5857b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    public SHA256Digest() {
        reset();
    }

    public final Memoable a() {
        return new SHA256Digest(this);
    }

    public final String b() {
        return "SHA-256";
    }

    public final int c(int i2, byte[] bArr) {
        j();
        Pack.c(this.f5857b, bArr, i2);
        Pack.c(this.c, bArr, i2 + 4);
        Pack.c(this.d, bArr, i2 + 8);
        Pack.c(this.e, bArr, i2 + 12);
        Pack.c(this.f, bArr, i2 + 16);
        Pack.c(this.g, bArr, i2 + 20);
        Pack.c(this.h, bArr, i2 + 24);
        Pack.c(this.i, bArr, i2 + 28);
        reset();
        return 32;
    }

    public final void e(Memoable memoable) {
        q((SHA256Digest) memoable);
    }

    public final int f() {
        return 32;
    }

    public final void k() {
        int[] iArr;
        int i2 = 16;
        while (true) {
            iArr = this.a;
            if (i2 > 63) {
                break;
            }
            int i3 = iArr[i2 - 2];
            int i4 = ((i3 >>> 10) ^ (((i3 >>> 17) | (i3 << 15)) ^ ((i3 >>> 19) | (i3 << 13)))) + iArr[i2 - 7];
            int i5 = iArr[i2 - 15];
            iArr[i2] = i4 + ((i5 >>> 3) ^ (((i5 >>> 7) | (i5 << 25)) ^ ((i5 >>> 18) | (i5 << 14)))) + iArr[i2 - 16];
            i2++;
        }
        int i6 = this.f5857b;
        int i7 = this.c;
        int i8 = this.d;
        int i9 = this.e;
        int i10 = this.f;
        int i11 = this.g;
        int i12 = this.h;
        int i13 = this.i;
        int i14 = 0;
        int i15 = 0;
        while (i14 < 8) {
            int p = p(i10) + (((~i10) & i12) ^ (i11 & i10));
            int[] iArr2 = b;
            int i16 = p + iArr2[i15] + iArr[i15] + i13;
            int i17 = i9 + i16;
            int n = n(i6, i7, i8) + o(i6) + i16;
            int i18 = i15 + 1;
            int p2 = p(i17) + (((~i17) & i11) ^ (i10 & i17)) + iArr2[i18] + iArr[i18] + i12;
            int i19 = i8 + p2;
            int n2 = n(n, i6, i7) + o(n) + p2;
            int i20 = i18 + 1;
            int p3 = p(i19) + ((i17 & i19) ^ ((~i19) & i10)) + iArr2[i20] + iArr[i20] + i11;
            int i21 = i7 + p3;
            int n3 = n(n2, n, i6) + o(n2) + p3;
            int i22 = i20 + 1;
            int p4 = p(i21) + ((i19 & i21) ^ ((~i21) & i17)) + iArr2[i22] + iArr[i22] + i10;
            int i23 = i6 + p4;
            int n4 = n(n3, n2, n) + o(n3) + p4;
            int i24 = i22 + 1;
            int p5 = p(i23) + ((i21 & i23) ^ ((~i23) & i19)) + iArr2[i24] + iArr[i24] + i17;
            int i25 = n + p5;
            int n5 = p5 + n(n4, n3, n2) + o(n4);
            int i26 = i24 + 1;
            int p6 = p(i25) + ((i23 & i25) ^ ((~i25) & i21)) + iArr2[i26] + iArr[i26] + i19;
            int i27 = n2 + p6;
            int n6 = p6 + n(n5, n4, n3) + o(n5);
            int i28 = i26 + 1;
            int p7 = p(i27) + ((i25 & i27) ^ ((~i27) & i23)) + iArr2[i28] + iArr[i28] + i21;
            int i29 = n3 + p7;
            int n7 = n(n6, n5, n4) + o(n6) + p7;
            int i30 = i28 + 1;
            int p8 = p(i29) + ((i27 & i29) ^ ((~i29) & i25)) + iArr2[i30] + iArr[i30] + i23;
            int i31 = n4 + p8;
            i6 = n(n7, n6, n5) + o(n7) + p8;
            i15 = i30 + 1;
            i14++;
            i12 = i27;
            i8 = n6;
            i11 = i29;
            i7 = n7;
            i13 = i25;
            i9 = n5;
            i10 = i31;
        }
        this.f5857b += i6;
        this.c += i7;
        this.d += i8;
        this.e += i9;
        this.f += i10;
        this.g += i11;
        this.h += i12;
        this.i += i13;
        this.j = 0;
        for (int i32 = 0; i32 < 16; i32++) {
            iArr[i32] = 0;
        }
    }

    public final void l(long j2) {
        if (this.j > 14) {
            k();
        }
        int[] iArr = this.a;
        iArr[14] = (int) (j2 >>> 32);
        iArr[15] = (int) (j2 & -1);
    }

    public final void m(int i2, byte[] bArr) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = (bArr[i4 + 1] & UnsignedBytes.MAX_VALUE) | (bArr[i2] << Ascii.CAN) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i4] & UnsignedBytes.MAX_VALUE) << 8);
        int i6 = this.j;
        this.a[i6] = i5;
        int i7 = i6 + 1;
        this.j = i7;
        if (i7 == 16) {
            k();
        }
    }

    public final int n(int i2, int i3, int i4) {
        return ((i2 & i4) ^ (i2 & i3)) ^ (i3 & i4);
    }

    public final int o(int i2) {
        return ((i2 << 10) | (i2 >>> 22)) ^ (((i2 >>> 2) | (i2 << 30)) ^ ((i2 >>> 13) | (i2 << 19)));
    }

    public final int p(int i2) {
        return ((i2 << 7) | (i2 >>> 25)) ^ (((i2 >>> 6) | (i2 << 26)) ^ ((i2 >>> 11) | (i2 << 21)));
    }

    public final void q(SHA256Digest sHA256Digest) {
        i(sHA256Digest);
        this.f5857b = sHA256Digest.f5857b;
        this.c = sHA256Digest.c;
        this.d = sHA256Digest.d;
        this.e = sHA256Digest.e;
        this.f = sHA256Digest.f;
        this.g = sHA256Digest.g;
        this.h = sHA256Digest.h;
        this.i = sHA256Digest.i;
        int[] iArr = this.a;
        int[] iArr2 = sHA256Digest.a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.j = sHA256Digest.j;
    }

    public final void reset() {
        super.reset();
        this.f5857b = 1779033703;
        this.c = -1150833019;
        this.d = 1013904242;
        this.e = -1521486534;
        this.f = 1359893119;
        this.g = -1694144372;
        this.h = 528734635;
        this.i = 1541459225;
        this.j = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 != iArr.length) {
                iArr[i2] = 0;
                i2++;
            } else {
                return;
            }
        }
    }

    public SHA256Digest(SHA256Digest sHA256Digest) {
        super(sHA256Digest);
        q(sHA256Digest);
    }
}
