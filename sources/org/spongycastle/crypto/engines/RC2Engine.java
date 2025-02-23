package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.RC2Parameters;

public class RC2Engine implements BlockCipher {
    public static final byte[] a = {-39, 120, -7, -60, Ascii.EM, -35, -75, -19, 40, -23, -3, 121, 74, -96, -40, -99, -58, 126, 55, -125, 43, 118, 83, -114, 98, 76, 100, -120, 68, -117, -5, -94, Ascii.ETB, -102, 89, -11, -121, -77, 79, 19, 97, 69, 109, -115, 9, -127, 125, 50, -67, -113, SignedBytes.MAX_POWER_OF_TWO, -21, -122, -73, 123, Ascii.VT, -16, -107, 33, 34, 92, 107, 78, -126, 84, -42, 101, -109, -50, 96, -78, Ascii.FS, 115, 86, -64, Ascii.DC4, -89, -116, -15, -36, Ascii.DC2, 117, -54, Ascii.US, 59, -66, -28, -47, 66, 61, -44, 48, -93, 60, -74, 38, 111, -65, Ascii.SO, -38, 70, 105, 7, 87, 39, -14, Ascii.GS, -101, -68, -108, 67, 3, -8, 17, -57, -10, -112, -17, 62, -25, 6, -61, -43, 47, -56, 102, Ascii.RS, -41, 8, -24, -22, -34, UnsignedBytes.MAX_POWER_OF_TWO, 82, -18, -9, -124, -86, 114, -84, 53, 77, 106, 42, -106, Ascii.SUB, -46, 113, 90, Ascii.NAK, 73, 116, 75, -97, -48, 94, 4, Ascii.CAN, -92, -20, -62, -32, 65, 110, Ascii.SI, 81, -53, -52, 36, -111, -81, 80, -95, -12, 112, 57, -103, 124, 58, -123, 35, -72, -76, 122, -4, 2, 54, 91, 37, 85, -105, 49, 45, 93, -6, -104, -29, -118, -110, -82, 5, -33, 41, Ascii.DLE, 103, 108, -70, -55, -45, 0, -26, -49, -31, -98, -88, 44, 99, Ascii.SYN, 1, 63, 88, -30, -119, -87, Ascii.CR, 56, 52, Ascii.ESC, -85, 51, -1, -80, -69, 72, Ascii.FF, 95, -71, -79, -51, 46, -59, -13, -37, 71, -27, -91, -100, 119, 10, -90, 32, 104, -2, Ascii.DEL, -63, -83};

    /* renamed from: a  reason: collision with other field name */
    public boolean f6001a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6002a;

    public static int[] d(int i, byte[] bArr) {
        int[] iArr = new int[128];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            iArr[i2] = bArr[i2] & UnsignedBytes.MAX_VALUE;
        }
        int length = bArr.length;
        byte[] bArr2 = a;
        if (length < 128) {
            int i3 = iArr[length - 1];
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                i3 = bArr2[(i3 + iArr[i4]) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE;
                int i6 = length + 1;
                iArr[length] = i3;
                if (i6 >= 128) {
                    break;
                }
                length = i6;
                i4 = i5;
            }
        }
        int i7 = (i + 7) >> 3;
        int i8 = 128 - i7;
        int i9 = bArr2[(Constants.MAX_HOST_LENGTH >> ((-i) & 7)) & iArr[i8]] & UnsignedBytes.MAX_VALUE;
        iArr[i8] = i9;
        while (true) {
            i8--;
            if (i8 < 0) {
                break;
            }
            i9 = bArr2[i9 ^ iArr[i8 + i7]] & UnsignedBytes.MAX_VALUE;
            iArr[i8] = i9;
        }
        int[] iArr2 = new int[64];
        for (int i10 = 0; i10 != 64; i10++) {
            int i11 = i10 * 2;
            iArr2[i10] = iArr[i11] + (iArr[i11 + 1] << 8);
        }
        return iArr2;
    }

    public static int f(int i, int i2) {
        int i3 = i & 65535;
        return (i3 >> (16 - i2)) | (i3 << i2);
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f6001a = z;
        if (cipherParameters instanceof RC2Parameters) {
            RC2Parameters rC2Parameters = (RC2Parameters) cipherParameters;
            this.f6002a = d(rC2Parameters.c, rC2Parameters.a);
        } else if (cipherParameters instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            this.f6002a = d(bArr.length * 8, bArr);
        } else {
            throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to RC2 init - "));
        }
    }

    public final String b() {
        return "RC2";
    }

    public final int c() {
        return 8;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (this.f6002a == null) {
            throw new IllegalStateException("RC2 engine not initialised");
        } else if (i + 8 > bArr3.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr4.length) {
            int i3 = 0;
            if (this.f6001a) {
                int i4 = ((bArr3[i + 7] & UnsignedBytes.MAX_VALUE) << 8) + (bArr3[i + 6] & UnsignedBytes.MAX_VALUE);
                int i5 = ((bArr3[i + 5] & UnsignedBytes.MAX_VALUE) << 8) + (bArr3[i + 4] & UnsignedBytes.MAX_VALUE);
                int i6 = ((bArr3[i + 3] & UnsignedBytes.MAX_VALUE) << 8) + (bArr3[i + 2] & UnsignedBytes.MAX_VALUE);
                int i7 = ((bArr3[i + 1] & UnsignedBytes.MAX_VALUE) << 8) + (bArr3[i + 0] & UnsignedBytes.MAX_VALUE);
                for (int i8 = 16; i3 <= i8; i8 = 16) {
                    i7 = f(i7 + ((~i4) & i6) + (i5 & i4) + this.f6002a[i3], 1);
                    i6 = f(i6 + ((~i7) & i5) + (i4 & i7) + this.f6002a[i3 + 1], 2);
                    i5 = f(i5 + ((~i6) & i4) + (i7 & i6) + this.f6002a[i3 + 2], 3);
                    i4 = f(i4 + ((~i5) & i7) + (i6 & i5) + this.f6002a[i3 + 3], 5);
                    i3 += 4;
                }
                int[] iArr = this.f6002a;
                int i9 = i7 + iArr[i4 & 63];
                int i10 = i6 + iArr[i9 & 63];
                int i11 = i5 + iArr[i10 & 63];
                int i12 = i4 + iArr[i11 & 63];
                for (int i13 = 20; i13 <= 40; i13 += 4) {
                    i9 = f(i9 + ((~i12) & i10) + (i11 & i12) + this.f6002a[i13], 1);
                    i10 = f(i10 + ((~i9) & i11) + (i12 & i9) + this.f6002a[i13 + 1], 2);
                    i11 = f(i11 + ((~i10) & i12) + (i9 & i10) + this.f6002a[i13 + 2], 3);
                    i12 = f(i12 + ((~i11) & i9) + (i10 & i11) + this.f6002a[i13 + 3], 5);
                }
                int[] iArr2 = this.f6002a;
                int i14 = i9 + iArr2[i12 & 63];
                int i15 = i10 + iArr2[i14 & 63];
                int i16 = i11 + iArr2[i15 & 63];
                int i17 = i12 + iArr2[i16 & 63];
                for (int i18 = 44; i18 < 64; i18 += 4) {
                    i14 = f(i14 + ((~i17) & i15) + (i16 & i17) + this.f6002a[i18], 1);
                    i15 = f(i15 + ((~i14) & i16) + (i17 & i14) + this.f6002a[i18 + 1], 2);
                    i16 = f(i16 + ((~i15) & i17) + (i14 & i15) + this.f6002a[i18 + 2], 3);
                    i17 = f(i17 + ((~i16) & i14) + (i15 & i16) + this.f6002a[i18 + 3], 5);
                }
                bArr4[i2 + 0] = (byte) i14;
                bArr4[i2 + 1] = (byte) (i14 >> 8);
                bArr4[i2 + 2] = (byte) i15;
                bArr4[i2 + 3] = (byte) (i15 >> 8);
                bArr4[i2 + 4] = (byte) i16;
                bArr4[i2 + 5] = (byte) (i16 >> 8);
                bArr4[i2 + 6] = (byte) i17;
                bArr4[i2 + 7] = (byte) (i17 >> 8);
            } else {
                int i19 = ((bArr3[i + 7] & UnsignedBytes.MAX_VALUE) << 8) + (bArr3[i + 6] & UnsignedBytes.MAX_VALUE);
                int i20 = ((bArr3[i + 5] & UnsignedBytes.MAX_VALUE) << 8) + (bArr3[i + 4] & UnsignedBytes.MAX_VALUE);
                int i21 = ((bArr3[i + 3] & UnsignedBytes.MAX_VALUE) << 8) + (bArr3[i + 2] & UnsignedBytes.MAX_VALUE);
                int i22 = ((bArr3[i + 1] & UnsignedBytes.MAX_VALUE) << 8) + (bArr3[i + 0] & UnsignedBytes.MAX_VALUE);
                for (int i23 = 60; i23 >= 44; i23 -= 4) {
                    i19 = f(i19, 11) - ((((~i20) & i22) + (i21 & i20)) + this.f6002a[i23 + 3]);
                    i20 = f(i20, 13) - ((((~i21) & i19) + (i22 & i21)) + this.f6002a[i23 + 2]);
                    i21 = f(i21, 14) - ((((~i22) & i20) + (i19 & i22)) + this.f6002a[i23 + 1]);
                    i22 = f(i22, 15) - ((((~i19) & i21) + (i20 & i19)) + this.f6002a[i23]);
                }
                int[] iArr3 = this.f6002a;
                int i24 = i19 - iArr3[i20 & 63];
                int i25 = i20 - iArr3[i21 & 63];
                int i26 = i21 - iArr3[i22 & 63];
                int i27 = i22 - iArr3[i24 & 63];
                for (int i28 = 40; i28 >= 20; i28 -= 4) {
                    i24 = f(i24, 11) - ((((~i25) & i27) + (i26 & i25)) + this.f6002a[i28 + 3]);
                    i25 = f(i25, 13) - ((((~i26) & i24) + (i27 & i26)) + this.f6002a[i28 + 2]);
                    i26 = f(i26, 14) - ((((~i27) & i25) + (i24 & i27)) + this.f6002a[i28 + 1]);
                    i27 = f(i27, 15) - ((((~i24) & i26) + (i25 & i24)) + this.f6002a[i28]);
                }
                int[] iArr4 = this.f6002a;
                int i29 = i24 - iArr4[i25 & 63];
                int i30 = i25 - iArr4[i26 & 63];
                int i31 = i26 - iArr4[i27 & 63];
                int i32 = i27 - iArr4[i29 & 63];
                int i33 = i30;
                for (int i34 = 16; i34 >= 0; i34 -= 4) {
                    i29 = f(i29, 11) - ((((~i33) & i32) + (i31 & i33)) + this.f6002a[i34 + 3]);
                    i33 = f(i33, 13) - ((((~i31) & i29) + (i32 & i31)) + this.f6002a[i34 + 2]);
                    i31 = f(i31, 14) - ((((~i32) & i33) + (i29 & i32)) + this.f6002a[i34 + 1]);
                    i32 = f(i32, 15) - ((((~i29) & i31) + (i33 & i29)) + this.f6002a[i34]);
                }
                bArr4[i2 + 0] = (byte) i32;
                bArr4[i2 + 1] = (byte) (i32 >> 8);
                bArr4[i2 + 2] = (byte) i31;
                bArr4[i2 + 3] = (byte) (i31 >> 8);
                bArr4[i2 + 4] = (byte) i33;
                bArr4[i2 + 5] = (byte) (i33 >> 8);
                bArr4[i2 + 6] = (byte) i29;
                bArr4[i2 + 7] = (byte) (i29 >> 8);
            }
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void reset() {
    }
}
