package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.util.Memoable;

public class MD5Digest extends GeneralDigest implements EncodableDigest {
    public final int[] a = new int[16];
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public MD5Digest() {
        reset();
    }

    public final Memoable a() {
        return new MD5Digest(this);
    }

    public final String b() {
        return "MD5";
    }

    public final int c(int i, byte[] bArr) {
        j();
        p(this.b, bArr, i);
        p(this.c, bArr, i + 4);
        p(this.d, bArr, i + 8);
        p(this.e, bArr, i + 12);
        reset();
        return 16;
    }

    public final void e(Memoable memoable) {
        n((MD5Digest) memoable);
    }

    public final int f() {
        return 16;
    }

    public final void k() {
        int i = this.b;
        int i2 = this.c;
        int i3 = this.d;
        int i4 = this.e;
        int[] iArr = this.a;
        int y = xx.y(i + ((i3 & i2) | ((~i2) & i4)), iArr[0], -680876936, this, 7, i2);
        int y2 = xx.y(((i2 & y) | ((~y) & i3)) + i4, iArr[1], -389564586, this, 12, y);
        int y3 = xx.y(((y & y2) | ((~y2) & i2)) + i3, iArr[2], 606105819, this, 17, y2);
        int y4 = xx.y(((y2 & y3) | ((~y3) & y)) + i2, iArr[3], -1044525330, this, 22, y3);
        int i5 = y4;
        int y5 = xx.y(((y3 & y4) | ((~y4) & y2)) + y, iArr[4], -176418897, this, 7, y4);
        int i6 = y5;
        int y6 = xx.y(((i5 & y5) | ((~y5) & y3)) + y2, iArr[5], 1200080426, this, 12, y5);
        int i7 = y6;
        int y7 = xx.y(((i6 & y6) | ((~y6) & i5)) + y3, iArr[6], -1473231341, this, 17, y6);
        int i8 = y7;
        int y8 = xx.y(((i7 & y7) | ((~y7) & i6)) + i5, iArr[7], -45705983, this, 22, y7);
        int i9 = y8;
        int y9 = xx.y(i6 + ((i8 & y8) | ((~y8) & i7)), iArr[8], 1770035416, this, 7, y8);
        int i10 = y9;
        int y10 = xx.y(i7 + ((i9 & y9) | ((~y9) & i8)), iArr[9], -1958414417, this, 12, y9);
        int i11 = y10;
        int y11 = xx.y(((i10 & y10) | ((~y10) & i9)) + i8, iArr[10], -42063, this, 17, y10);
        int i12 = y11;
        int y12 = xx.y(i9 + ((i11 & y11) | ((~y11) & i10)), iArr[11], -1990404162, this, 22, y11);
        int i13 = y12;
        int y13 = xx.y(i10 + ((i12 & y12) | ((~y12) & i11)), iArr[12], 1804603682, this, 7, y12);
        int i14 = y13;
        int y14 = xx.y(((i13 & y13) | ((~y13) & i12)) + i11, iArr[13], -40341101, this, 12, y13);
        int i15 = ~y14;
        int i16 = i15;
        int i17 = y14;
        int y15 = xx.y(i12 + ((i14 & y14) | (i15 & i13)), iArr[14], -1502002290, this, 17, y14);
        int i18 = ~y15;
        int i19 = y15;
        int y16 = xx.y(((i17 & y15) | (i18 & i14)) + i13, iArr[15], 1236535329, this, 22, y15);
        int i20 = y16;
        int y17 = xx.y(((y16 & i17) | (i16 & i19)) + i14, iArr[1], -165796510, this, 5, y16);
        int i21 = y17;
        int y18 = xx.y(((y17 & i19) | (i18 & i20)) + i17, iArr[6], -1069501632, this, 9, y17);
        int i22 = y18;
        int y19 = xx.y(((y18 & i20) | ((~i20) & i21)) + i19, iArr[11], 643717713, this, 14, y18);
        int i23 = y19;
        int y20 = xx.y(((y19 & i21) | ((~i21) & i22)) + i20, iArr[0], -373897302, this, 20, y19);
        int i24 = i23;
        int i25 = i24;
        int i26 = y20;
        int y21 = xx.y(((y20 & i22) | ((~i22) & i24)) + i21, iArr[5], -701558691, this, 5, y20);
        int i27 = i26;
        int i28 = i27;
        int i29 = y21;
        int y22 = xx.y(((y21 & i25) | ((~i25) & i27)) + i22, iArr[10], 38016083, this, 9, y21);
        int i30 = i29;
        int i31 = i30;
        int i32 = y22;
        int y23 = xx.y(((y22 & i28) | ((~i28) & i30)) + i25, iArr[15], -660478335, this, 14, y22);
        int i33 = i32;
        int i34 = i33;
        int i35 = y23;
        int y24 = xx.y(((y23 & i31) | ((~i31) & i33)) + i28, iArr[4], -405537848, this, 20, y23);
        int i36 = i35;
        int i37 = i36;
        int i38 = y24;
        int y25 = xx.y(((y24 & i34) | ((~i34) & i36)) + i31, iArr[9], 568446438, this, 5, y24);
        int i39 = i38;
        int i40 = i39;
        int i41 = y25;
        int y26 = xx.y(((y25 & i37) | ((~i37) & i39)) + i34, iArr[14], -1019803690, this, 9, y25);
        int i42 = i41;
        int i43 = i42;
        int i44 = y26;
        int y27 = xx.y(((y26 & i40) | ((~i40) & i42)) + i37, iArr[3], -187363961, this, 14, y26);
        int i45 = i44;
        int i46 = i45;
        int i47 = y27;
        int y28 = xx.y(((y27 & i43) | ((~i43) & i45)) + i40, iArr[8], 1163531501, this, 20, y27);
        int i48 = i47;
        int i49 = i48;
        int i50 = y28;
        int y29 = xx.y(((y28 & i46) | ((~i46) & i48)) + i43, iArr[13], -1444681467, this, 5, y28);
        int i51 = i50;
        int i52 = i51;
        int i53 = y29;
        int y30 = xx.y(((y29 & i49) | ((~i49) & i51)) + i46, iArr[2], -51403784, this, 9, y29);
        int i54 = y29;
        int y31 = xx.y(((y30 & i52) | ((~i52) & y29)) + i49, iArr[7], 1735328473, this, 14, y30);
        int y32 = xx.y(((y31 & i54) | ((~i54) & y30)) + i52, iArr[12], -1926607734, this, 20, y31);
        int y33 = xx.y(((y32 ^ y31) ^ y30) + i54, iArr[5], -378558, this, 4, y32);
        int y34 = xx.y(y30 + ((y33 ^ y32) ^ y31), iArr[8], -2022574463, this, 11, y33);
        int y35 = xx.y(y31 + ((y34 ^ y33) ^ y32), iArr[11], 1839030562, this, 16, y34);
        int y36 = xx.y(((y35 ^ y34) ^ y33) + y32, iArr[14], -35309556, this, 23, y35);
        int y37 = xx.y(((y36 ^ y35) ^ y34) + y33, iArr[1], -1530992060, this, 4, y36);
        int y38 = xx.y(y34 + ((y37 ^ y36) ^ y35), iArr[4], 1272893353, this, 11, y37);
        int y39 = xx.y(y35 + ((y38 ^ y37) ^ y36), iArr[7], -155497632, this, 16, y38);
        int y40 = xx.y(y36 + ((y39 ^ y38) ^ y37), iArr[10], -1094730640, this, 23, y39);
        int y41 = xx.y(y37 + ((y40 ^ y39) ^ y38), iArr[13], 681279174, this, 4, y40);
        int y42 = xx.y(((y41 ^ y40) ^ y39) + y38, iArr[0], -358537222, this, 11, y41);
        int y43 = xx.y(y39 + ((y42 ^ y41) ^ y40), iArr[3], -722521979, this, 16, y42);
        int y44 = xx.y(y40 + ((y43 ^ y42) ^ y41), iArr[6], 76029189, this, 23, y43);
        int y45 = xx.y(y41 + ((y44 ^ y43) ^ y42), iArr[9], -640364487, this, 4, y44);
        int y46 = xx.y(((y45 ^ y44) ^ y43) + y42, iArr[12], -421815835, this, 11, y45);
        int y47 = xx.y(y43 + ((y46 ^ y45) ^ y44), iArr[15], 530742520, this, 16, y46);
        int y48 = xx.y(y44 + ((y47 ^ y46) ^ y45), iArr[2], -995338651, this, 23, y47);
        int y49 = xx.y(y45 + (((~y46) | y48) ^ y47), iArr[0], -198630844, this, 6, y48);
        int i55 = y49;
        int y50 = xx.y((((~y47) | y49) ^ y48) + y46, iArr[7], 1126891415, this, 10, y49);
        int i56 = y50;
        int y51 = xx.y((((~y48) | y50) ^ i55) + y47, iArr[14], -1416354905, this, 15, y50);
        int i57 = y51;
        int y52 = xx.y((((~i55) | y51) ^ i56) + y48, iArr[5], -57434055, this, 21, y51);
        int y53 = xx.y((((~i56) | y52) ^ i57) + i55, iArr[12], 1700485571, this, 6, y52);
        int y54 = xx.y((((~i57) | y53) ^ y52) + i56, iArr[3], -1894986606, this, 10, y53);
        int i58 = y54;
        int y55 = xx.y((((~y52) | y54) ^ y53) + i57, iArr[10], -1051523, this, 15, y54);
        int y56 = xx.y((((~y53) | y55) ^ i58) + y52, iArr[1], -2054922799, this, 21, y55);
        int y57 = xx.y((((~i58) | y56) ^ y55) + y53, iArr[8], 1873313359, this, 6, y56);
        int y58 = xx.y((((~y55) | y57) ^ y56) + i58, iArr[15], -30611744, this, 10, y57);
        int y59 = xx.y((((~y56) | y58) ^ y57) + y55, iArr[6], -1560198380, this, 15, y58);
        int y60 = xx.y((((~y57) | y59) ^ y58) + y56, iArr[13], 1309151649, this, 21, y59);
        int y61 = xx.y((((~y58) | y60) ^ y59) + y57, iArr[4], -145523070, this, 6, y60);
        int y62 = xx.y((((~y59) | y61) ^ y60) + y58, iArr[11], -1120210379, this, 10, y61);
        int y63 = xx.y((((~y60) | y62) ^ y61) + y59, iArr[2], 718787259, this, 15, y62);
        int y64 = xx.y((((~y61) | y63) ^ y62) + y60, iArr[9], -343485551, this, 21, y63);
        this.b += y61;
        this.c += y64;
        this.d += y63;
        this.e += y62;
        this.f = 0;
        for (int i59 = 0; i59 != iArr.length; i59++) {
            iArr[i59] = 0;
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

    public final void n(MD5Digest mD5Digest) {
        i(mD5Digest);
        this.b = mD5Digest.b;
        this.c = mD5Digest.c;
        this.d = mD5Digest.d;
        this.e = mD5Digest.e;
        int[] iArr = this.a;
        int[] iArr2 = mD5Digest.a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.f = mD5Digest.f;
    }

    public final int o(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public final void p(int i, byte[] bArr, int i2) {
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

    public MD5Digest(MD5Digest mD5Digest) {
        super(mD5Digest);
        n(mD5Digest);
    }
}
