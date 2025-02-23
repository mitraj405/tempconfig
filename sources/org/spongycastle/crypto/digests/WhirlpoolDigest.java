package org.spongycastle.crypto.digests;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import com.google.logging.type.LogSeverity;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;

public final class WhirlpoolDigest implements ExtendedDigest, Memoable {
    public static final int[] a = {24, 35, 198, 232, 135, 184, 1, 79, 54, 166, 210, 245, 121, 111, 145, 82, 96, 188, 155, 142, 163, 12, 123, 53, 29, 224, 215, 194, 46, 75, 254, 87, 21, 119, 55, 229, 159, 240, 74, 218, 88, 201, 41, 10, 177, 160, 107, 133, 189, 93, 16, 244, 203, 62, 5, 103, 228, 39, 65, 139, 167, 125, 149, 216, 251, 238, 124, 102, 221, 23, 71, 158, 202, 45, 191, 7, 173, 90, 131, 51, 99, 2, 170, 113, LogSeverity.INFO_VALUE, 25, 73, 217, 242, 227, 91, 136, 154, 38, 50, 176, 233, 15, 213, 128, 190, 205, 52, 72, Constants.MAX_HOST_LENGTH, 122, 144, 95, 32, 104, 26, 174, 180, 84, 147, 34, 100, 241, 115, 18, 64, 8, 195, 236, 219, 161, 141, 61, 151, 0, 207, 43, 118, 130, 214, 27, 181, 175, 106, 80, 69, 243, 48, 239, 63, 85, 162, 234, 101, 186, 47, 192, 222, 28, 253, 77, 146, 117, 6, 138, 178, 230, 14, 31, 98, 212, 168, 150, 249, 197, 37, 89, 132, 114, 57, 76, 94, 120, 56, 140, 209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 252, 4, 81, 153, 109, 13, 250, 223, 126, 36, 59, 171, 206, 17, 143, 78, 183, 235, 60, 129, 148, 247, 185, 19, 44, 211, 231, 110, 196, 3, 86, 68, 127, 169, 42, 187, 193, 83, 220, 11, 157, 108, 49, 116, 246, 70, 172, 137, 20, 225, 22, 58, 105, 9, 112, 182, 208, 237, 204, 66, 152, 164, 40, 92, 248, 134};
    public static final short[] b;
    public static final long[] g = new long[256];
    public static final long[] h = new long[256];
    public static final long[] i = new long[256];
    public static final long[] j = new long[256];
    public static final long[] k = new long[256];
    public static final long[] l = new long[256];
    public static final long[] m = new long[256];
    public static final long[] n = new long[256];

    /* renamed from: a  reason: collision with other field name */
    public int f5880a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5881a = new byte[64];

    /* renamed from: a  reason: collision with other field name */
    public final long[] f5882a = new long[11];

    /* renamed from: a  reason: collision with other field name */
    public final short[] f5883a = new short[32];

    /* renamed from: b  reason: collision with other field name */
    public final long[] f5884b = new long[8];
    public final long[] c = new long[8];
    public final long[] d = new long[8];
    public final long[] e = new long[8];
    public final long[] f = new long[8];

    static {
        short[] sArr = new short[32];
        b = sArr;
        sArr[31] = 8;
    }

    public WhirlpoolDigest() {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        long[] jArr4;
        long[] jArr5;
        long[] jArr6;
        long[] jArr7;
        long[] jArr8;
        int i2 = 0;
        while (true) {
            jArr = n;
            jArr2 = m;
            jArr3 = l;
            jArr4 = k;
            jArr5 = j;
            jArr6 = i;
            jArr7 = h;
            jArr8 = g;
            if (i2 >= 256) {
                break;
            }
            int i3 = a[i2];
            int i4 = i3 << 1;
            int i5 = ((long) i4) >= 256 ? i4 ^ 285 : i4;
            int i6 = i5 << 1;
            int i7 = ((long) i6) >= 256 ? i6 ^ 285 : i6;
            int i8 = i7 ^ i3;
            int i9 = i7 << 1;
            if (((long) i9) >= 256) {
                i9 ^= 285;
            }
            int i10 = i9;
            int i11 = i10 ^ i3;
            jArr8[i2] = i(i3, i3, i7, i3, i10, i8, i5, i11);
            int i12 = i3;
            jArr7[i2] = i(i11, i3, i12, i7, i3, i10, i8, i5);
            int i13 = i3;
            jArr6[i2] = i(i5, i11, i12, i13, i7, i3, i10, i8);
            int i14 = i3;
            jArr5[i2] = i(i8, i5, i11, i13, i14, i7, i3, i10);
            int i15 = i3;
            jArr4[i2] = i(i10, i8, i5, i11, i14, i15, i7, i3);
            int i16 = i3;
            jArr3[i2] = i(i3, i10, i8, i5, i11, i15, i16, i7);
            int i17 = i3;
            jArr2[i2] = i(i7, i3, i10, i8, i5, i11, i16, i17);
            jArr[i2] = i(i3, i7, i3, i10, i8, i5, i11, i17);
            i2++;
        }
        this.f5882a[0] = 0;
        for (int i18 = 1; i18 <= 10; i18++) {
            int i19 = (i18 - 1) * 8;
            this.f5882a[i18] = (((((((jArr8[i19] & -72057594037927936L) ^ (jArr7[i19 + 1] & 71776119061217280L)) ^ (jArr6[i19 + 2] & 280375465082880L)) ^ (jArr5[i19 + 3] & 1095216660480L)) ^ (jArr4[i19 + 4] & 4278190080L)) ^ (jArr3[i19 + 5] & 16711680)) ^ (jArr2[i19 + 6] & 65280)) ^ (jArr[i19 + 7] & 255);
        }
    }

    public static long i(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return (((((((((long) i3) << 48) ^ (((long) i2) << 56)) ^ (((long) i4) << 40)) ^ (((long) i5) << 32)) ^ (((long) i6) << 24)) ^ (((long) i7) << 16)) ^ (((long) i8) << 8)) ^ ((long) i9);
    }

    public final Memoable a() {
        return new WhirlpoolDigest(this);
    }

    public final String b() {
        return "Whirlpool";
    }

    public final int c(int i2, byte[] bArr) {
        byte[] bArr2 = new byte[32];
        for (int i3 = 0; i3 < 32; i3++) {
            bArr2[i3] = (byte) (this.f5883a[i3] & 255);
        }
        int i4 = this.f5880a;
        int i5 = i4 + 1;
        this.f5880a = i5;
        byte[] bArr3 = this.f5881a;
        bArr3[i4] = (byte) (bArr3[i4] | UnsignedBytes.MAX_POWER_OF_TWO);
        if (i5 == bArr3.length) {
            j();
        }
        if (this.f5880a > 32) {
            while (this.f5880a != 0) {
                d((byte) 0);
            }
        }
        while (this.f5880a <= 32) {
            d((byte) 0);
        }
        System.arraycopy(bArr2, 0, bArr3, 32, 32);
        j();
        for (int i6 = 0; i6 < 8; i6++) {
            long j2 = this.f5884b[i6];
            int i7 = (i6 * 8) + i2;
            for (int i8 = 0; i8 < 8; i8++) {
                bArr[i7 + i8] = (byte) ((int) ((j2 >> (56 - (i8 * 8))) & 255));
            }
        }
        reset();
        return 64;
    }

    public final void d(byte b2) {
        int i2 = this.f5880a;
        byte[] bArr = this.f5881a;
        bArr[i2] = b2;
        int i3 = i2 + 1;
        this.f5880a = i3;
        if (i3 == bArr.length) {
            j();
        }
        short[] sArr = this.f5883a;
        int length = sArr.length;
        int i4 = 0;
        while (true) {
            length--;
            if (length >= 0) {
                int i5 = (sArr[length] & 255) + b[length] + i4;
                i4 = i5 >>> 8;
                sArr[length] = (short) (i5 & Constants.MAX_HOST_LENGTH);
            } else {
                return;
            }
        }
    }

    public final void e(Memoable memoable) {
        WhirlpoolDigest whirlpoolDigest = (WhirlpoolDigest) memoable;
        long[] jArr = whirlpoolDigest.f5882a;
        long[] jArr2 = this.f5882a;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        byte[] bArr = this.f5881a;
        System.arraycopy(whirlpoolDigest.f5881a, 0, bArr, 0, bArr.length);
        this.f5880a = whirlpoolDigest.f5880a;
        short[] sArr = this.f5883a;
        System.arraycopy(whirlpoolDigest.f5883a, 0, sArr, 0, sArr.length);
        long[] jArr3 = this.f5884b;
        System.arraycopy(whirlpoolDigest.f5884b, 0, jArr3, 0, jArr3.length);
        long[] jArr4 = this.c;
        System.arraycopy(whirlpoolDigest.c, 0, jArr4, 0, jArr4.length);
        long[] jArr5 = this.d;
        System.arraycopy(whirlpoolDigest.d, 0, jArr5, 0, jArr5.length);
        long[] jArr6 = this.e;
        System.arraycopy(whirlpoolDigest.e, 0, jArr6, 0, jArr6.length);
        long[] jArr7 = this.f;
        System.arraycopy(whirlpoolDigest.f, 0, jArr7, 0, jArr7.length);
    }

    public final int f() {
        return 64;
    }

    public final int h() {
        return 64;
    }

    public final void j() {
        long[] jArr;
        byte[] bArr;
        int i2;
        long[] jArr2;
        char c2;
        long[] jArr3;
        long[] jArr4;
        long[] jArr5;
        long[] jArr6;
        long[] jArr7;
        long[] jArr8;
        long[] jArr9;
        long[] jArr10;
        long[] jArr11;
        long[] jArr12;
        long[] jArr13;
        int i3 = 0;
        while (true) {
            jArr = this.f;
            int length = jArr.length;
            bArr = this.f5881a;
            i2 = 8;
            jArr2 = this.e;
            c2 = '0';
            if (i3 >= length) {
                break;
            }
            int i4 = i3 * 8;
            int i5 = i3;
            jArr2[i5] = ((((long) bArr[i4 + 1]) & 255) << 48) | ((((long) bArr[i4 + 0]) & 255) << 56) | ((((long) bArr[i4 + 2]) & 255) << 40) | ((((long) bArr[i4 + 3]) & 255) << 32) | ((((long) bArr[i4 + 4]) & 255) << 24) | ((((long) bArr[i4 + 5]) & 255) << 16) | ((((long) bArr[i4 + 6]) & 255) << 8) | (((long) bArr[i4 + 7]) & 255);
            i3 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            jArr3 = this.f5884b;
            jArr4 = this.c;
            if (i6 >= 8) {
                break;
            }
            long j2 = jArr2[i6];
            long j3 = jArr3[i6];
            jArr4[i6] = j3;
            jArr[i6] = j2 ^ j3;
            i6++;
        }
        int i7 = 1;
        while (i7 <= 10) {
            int i8 = 0;
            while (true) {
                jArr5 = k;
                jArr6 = j;
                jArr7 = i;
                jArr8 = h;
                jArr9 = g;
                jArr10 = n;
                jArr11 = m;
                jArr12 = l;
                jArr13 = this.d;
                if (i8 >= i2) {
                    break;
                }
                jArr13[i8] = 0;
                long j4 = jArr9[((int) (jArr4[(i8 + 0) & 7] >>> 56)) & Constants.MAX_HOST_LENGTH] ^ 0;
                jArr13[i8] = j4;
                long j5 = j4 ^ jArr8[((int) (jArr4[(i8 - 1) & 7] >>> c2)) & Constants.MAX_HOST_LENGTH];
                jArr13[i8] = j5;
                long j6 = j5 ^ jArr7[((int) (jArr4[(i8 - 2) & 7] >>> 40)) & Constants.MAX_HOST_LENGTH];
                jArr13[i8] = j6;
                long j7 = j6 ^ jArr6[((int) (jArr4[(i8 - 3) & 7] >>> 32)) & Constants.MAX_HOST_LENGTH];
                jArr13[i8] = j7;
                long j8 = j7 ^ jArr5[((int) (jArr4[(i8 - 4) & 7] >>> 24)) & Constants.MAX_HOST_LENGTH];
                jArr13[i8] = j8;
                long j9 = j8 ^ jArr12[((int) (jArr4[(i8 - 5) & 7] >>> 16)) & Constants.MAX_HOST_LENGTH];
                jArr13[i8] = j9;
                long j10 = j9 ^ jArr11[((int) (jArr4[(i8 - 6) & 7] >>> 8)) & Constants.MAX_HOST_LENGTH];
                jArr13[i8] = j10;
                jArr13[i8] = j10 ^ jArr10[((int) jArr4[(i8 - 7) & 7]) & Constants.MAX_HOST_LENGTH];
                i8++;
                jArr2 = jArr2;
                i2 = 8;
            }
            long[] jArr14 = jArr2;
            System.arraycopy(jArr13, 0, jArr4, 0, jArr4.length);
            jArr4[0] = jArr4[0] ^ this.f5882a[i7];
            int i9 = 0;
            while (i9 < 8) {
                long j11 = jArr4[i9];
                jArr13[i9] = j11;
                long j12 = j11 ^ jArr9[((int) (jArr[(i9 + 0) & 7] >>> 56)) & Constants.MAX_HOST_LENGTH];
                jArr13[i9] = j12;
                long j13 = j12 ^ jArr8[((int) (jArr[(i9 - 1) & 7] >>> 48)) & Constants.MAX_HOST_LENGTH];
                jArr13[i9] = j13;
                long j14 = j13 ^ jArr7[((int) (jArr[(i9 - 2) & 7] >>> 40)) & Constants.MAX_HOST_LENGTH];
                jArr13[i9] = j14;
                long j15 = j14 ^ jArr6[((int) (jArr[(i9 - 3) & 7] >>> 32)) & Constants.MAX_HOST_LENGTH];
                jArr13[i9] = j15;
                long j16 = j15 ^ jArr5[((int) (jArr[(i9 - 4) & 7] >>> 24)) & Constants.MAX_HOST_LENGTH];
                jArr13[i9] = j16;
                long j17 = j16 ^ jArr12[((int) (jArr[(i9 - 5) & 7] >>> 16)) & Constants.MAX_HOST_LENGTH];
                jArr13[i9] = j17;
                long j18 = j17 ^ jArr11[((int) (jArr[(i9 - 6) & 7] >>> 8)) & Constants.MAX_HOST_LENGTH];
                jArr13[i9] = j18;
                jArr13[i9] = j18 ^ jArr10[((int) jArr[(i9 - 7) & 7]) & Constants.MAX_HOST_LENGTH];
                i9++;
                c2 = '0';
            }
            char c3 = c2;
            System.arraycopy(jArr13, 0, jArr, 0, jArr.length);
            i7++;
            jArr2 = jArr14;
            i2 = 8;
        }
        long[] jArr15 = jArr2;
        int i10 = i2;
        for (int i11 = 0; i11 < i10; i11++) {
            jArr3[i11] = jArr3[i11] ^ (jArr[i11] ^ jArr15[i11]);
        }
        this.f5880a = 0;
        Arrays.p(bArr, (byte) 0);
    }

    public final void reset() {
        this.f5880a = 0;
        int i2 = 0;
        while (true) {
            short[] sArr = this.f5883a;
            if (i2 < sArr.length) {
                sArr[i2] = 0;
                i2++;
            } else {
                Arrays.p(this.f5881a, (byte) 0);
                Arrays.q(this.f5884b);
                Arrays.q(this.c);
                Arrays.q(this.d);
                Arrays.q(this.e);
                Arrays.q(this.f);
                return;
            }
        }
    }

    public final void update(byte[] bArr, int i2, int i3) {
        while (i3 > 0) {
            d(bArr[i2]);
            i2++;
            i3--;
        }
    }

    public WhirlpoolDigest(WhirlpoolDigest whirlpoolDigest) {
        e(whirlpoolDigest);
    }
}
