package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class IDEAEngine implements BlockCipher {
    public int[] a = null;

    public static int d(int i) {
        return (0 - i) & 65535;
    }

    public static int h(int i, int i2) {
        int i3;
        int i4;
        if (i == 0) {
            i3 = 65537 - i2;
        } else if (i2 == 0) {
            i3 = 65537 - i;
        } else {
            int i5 = i * i2;
            int i6 = i5 & 65535;
            int i7 = i5 >>> 16;
            int i8 = i6 - i7;
            if (i6 < i7) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            i3 = i8 + i4;
        }
        return i3 & 65535;
    }

    public static int i(int i) {
        if (i < 2) {
            return i;
        }
        int i2 = 65537 / i;
        int i3 = 65537 % i;
        int i4 = 1;
        while (i3 != 1) {
            int i5 = i / i3;
            i %= i3;
            i4 = ((i5 * i2) + i4) & 65535;
            if (i == 1) {
                return i4;
            }
            int i6 = i3 / i;
            i3 %= i;
            i2 = ((i6 * i4) + i2) & 65535;
        }
        return (1 - i2) & 65535;
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        int[] iArr;
        if (cipherParameters instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            if (z) {
                iArr = g(bArr);
            } else {
                int[] g = g(bArr);
                int[] iArr2 = new int[52];
                int i = i(g[0]);
                int i2 = 1;
                int d = d(g[1]);
                int d2 = d(g[2]);
                iArr2[51] = i(g[3]);
                iArr2[50] = d2;
                iArr2[49] = d;
                int i3 = 48;
                iArr2[48] = i;
                int i4 = 4;
                while (i2 < 8) {
                    int i5 = i4 + 1;
                    int i6 = g[i4];
                    int i7 = i5 + 1;
                    int i8 = i3 - 1;
                    iArr2[i8] = g[i5];
                    int i9 = i8 - 1;
                    iArr2[i9] = i6;
                    int i10 = i7 + 1;
                    int i11 = i(g[i7]);
                    int i12 = i10 + 1;
                    int d3 = d(g[i10]);
                    int i13 = i12 + 1;
                    int d4 = d(g[i12]);
                    int i14 = i9 - 1;
                    iArr2[i14] = i(g[i13]);
                    int i15 = i14 - 1;
                    iArr2[i15] = d3;
                    int i16 = i15 - 1;
                    iArr2[i16] = d4;
                    i3 = i16 - 1;
                    iArr2[i3] = i11;
                    i2++;
                    i4 = i13 + 1;
                }
                int i17 = i4 + 1;
                int i18 = g[i4];
                int i19 = i17 + 1;
                int i20 = i3 - 1;
                iArr2[i20] = g[i17];
                int i21 = i20 - 1;
                iArr2[i21] = i18;
                int i22 = i19 + 1;
                int i23 = i(g[i19]);
                int i24 = i22 + 1;
                int d5 = d(g[i22]);
                int i25 = i24 + 1;
                int d6 = d(g[i24]);
                int i26 = i21 - 1;
                iArr2[i26] = i(g[i25]);
                int i27 = i26 - 1;
                iArr2[i27] = d6;
                int i28 = i27 - 1;
                iArr2[i28] = d5;
                iArr2[i28 - 1] = i23;
                iArr = iArr2;
            }
            this.a = iArr;
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to IDEA init - "));
    }

    public final String b() {
        return "IDEA";
    }

    public final int c() {
        return 8;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        int[] iArr = this.a;
        if (iArr == null) {
            throw new IllegalStateException("IDEA engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            int f = f(i, bArr);
            int f2 = f(i + 2, bArr);
            int f3 = f(i + 4, bArr);
            int f4 = f(i + 6, bArr);
            int i3 = 0;
            int i4 = f3;
            int i5 = f2;
            int i6 = f;
            int i7 = 0;
            while (i3 < 8) {
                int i8 = i7 + 1;
                int h = h(i6, iArr[i7]);
                int i9 = i8 + 1;
                int i10 = (i5 + iArr[i8]) & 65535;
                int i11 = i9 + 1;
                int i12 = (i4 + iArr[i9]) & 65535;
                int i13 = i11 + 1;
                int h2 = h(f4, iArr[i11]);
                int i14 = i13 + 1;
                int h3 = h(i12 ^ h, iArr[i13]);
                int h4 = h(((i10 ^ h2) + h3) & 65535, iArr[i14]);
                int i15 = (h3 + h4) & 65535;
                f4 = h2 ^ i15;
                i4 = i15 ^ i10;
                i3++;
                i5 = i12 ^ h4;
                i6 = h ^ h4;
                i7 = i14 + 1;
            }
            int i16 = i7 + 1;
            int h5 = h(i6, iArr[i7]);
            bArr2[i2] = (byte) (h5 >>> 8);
            bArr2[i2 + 1] = (byte) h5;
            int i17 = i16 + 1;
            int i18 = i4 + iArr[i16];
            int i19 = i2 + 2;
            bArr2[i19] = (byte) (i18 >>> 8);
            bArr2[i19 + 1] = (byte) i18;
            int i20 = i17 + 1;
            int i21 = i5 + iArr[i17];
            int i22 = i2 + 4;
            bArr2[i22] = (byte) (i21 >>> 8);
            bArr2[i22 + 1] = (byte) i21;
            int h6 = h(f4, iArr[i20]);
            int i23 = i2 + 6;
            bArr2[i23] = (byte) (h6 >>> 8);
            bArr2[i23 + 1] = (byte) h6;
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final int f(int i, byte[] bArr) {
        return ((bArr[i] << 8) & Ascii.NUL) + (bArr[i + 1] & UnsignedBytes.MAX_VALUE);
    }

    public final int[] g(byte[] bArr) {
        int i;
        int[] iArr = new int[52];
        int i2 = 0;
        if (bArr.length < 16) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
            bArr = bArr2;
        }
        while (true) {
            if (i2 >= 8) {
                break;
            }
            iArr[i2] = f(i2 * 2, bArr);
            i2++;
        }
        for (i = 8; i < 52; i++) {
            int i3 = i & 7;
            if (i3 < 6) {
                iArr[i] = (((iArr[i - 7] & 127) << 9) | (iArr[i - 6] >> 7)) & 65535;
            } else if (i3 == 6) {
                iArr[i] = (((iArr[i - 7] & 127) << 9) | (iArr[i - 14] >> 7)) & 65535;
            } else {
                iArr[i] = (((iArr[i - 15] & 127) << 9) | (iArr[i - 14] >> 7)) & 65535;
            }
        }
        return iArr;
    }

    public final void reset() {
    }
}
