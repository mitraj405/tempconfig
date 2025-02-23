package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Array;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

public class AESLightEngine implements BlockCipher {
    public static final byte[] a = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, Ascii.NAK, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, Ascii.DC2, UnsignedBytes.MAX_POWER_OF_TWO, -30, -21, 39, -78, 117, 9, -125, 44, Ascii.SUB, Ascii.ESC, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Ascii.DEL, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, -68, -74, -38, 33, Ascii.DLE, -1, -13, -46, -51, Ascii.FF, 19, -20, 95, -105, 68, Ascii.ETB, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, Ascii.DC4, -34, 94, Ascii.VT, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, Ascii.FS, -90, -76, -58, -24, -35, 116, Ascii.US, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, Ascii.SO, 97, 53, 87, -71, -122, -63, Ascii.GS, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, Ascii.RS, -121, -23, -50, 85, 40, -33, -116, -95, -119, Ascii.CR, -65, -26, 66, 104, 65, -103, 45, Ascii.SI, -80, 84, -69, Ascii.SYN};

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f5916a = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};
    public static final byte[] b = {82, 9, 106, -43, 48, 54, -91, 56, -65, SignedBytes.MAX_POWER_OF_TWO, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, Ascii.VT, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, Ascii.SYN, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, Ascii.NAK, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, -68, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, Ascii.RS, -113, -54, 63, Ascii.SI, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, Ascii.FS, 117, -33, 110, 71, -15, Ascii.SUB, 113, Ascii.GS, 41, -59, -119, 111, -73, 98, Ascii.SO, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, Ascii.US, -35, -88, 51, -120, 7, -57, 49, -79, Ascii.DC2, Ascii.DLE, 89, 39, UnsignedBytes.MAX_POWER_OF_TWO, -20, 95, 96, 81, Ascii.DEL, -87, Ascii.EM, -75, 74, Ascii.CR, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, Ascii.ETB, 43, 4, 126, -70, 119, -42, 38, -31, 105, Ascii.DC4, 99, 85, 33, Ascii.FF, 125};

    /* renamed from: a  reason: collision with other field name */
    public int f5917a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5918a;

    /* renamed from: a  reason: collision with other field name */
    public int[][] f5919a = null;

    /* renamed from: b  reason: collision with other field name */
    public int f5920b;
    public int c;
    public int d;
    public int e;

    public static int d(int i) {
        int i2 = ((i >>> 8) | (i << -8)) ^ i;
        int i3 = i ^ (((2139062143 & i2) << 1) ^ (((-2139062144 & i2) >>> 7) * 27));
        int i4 = -1061109568 & i3;
        int i5 = i4 ^ (i4 >>> 1);
        int i6 = i2 ^ ((((1061109567 & i3) << 2) ^ (i5 >>> 2)) ^ (i5 >>> 5));
        return i3 ^ (i6 ^ ((i6 >>> 16) | (i6 << -16)));
    }

    public static int f(int i) {
        int i2 = (i >>> 8) | (i << -8);
        int i3 = i ^ i2;
        return ((((i3 & -2139062144) >>> 7) * 27) ^ ((2139062143 & i3) << 1)) ^ (i2 ^ ((i3 >>> 16) | (i3 << -16)));
    }

    public static int h(int i) {
        byte[] bArr = a;
        return (bArr[(i >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN) | (bArr[i & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) | ((bArr[(i >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[(i >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        boolean z2 = z;
        CipherParameters cipherParameters2 = cipherParameters;
        if (cipherParameters2 instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters2).a;
            int length = bArr.length;
            if (length < 16 || length > 32 || (length & 7) != 0) {
                throw new IllegalArgumentException("Key length not 128/192/256 bits.");
            }
            int i = length >> 2;
            int i2 = i + 6;
            this.f5917a = i2;
            int[] iArr = new int[2];
            iArr[1] = 4;
            iArr[0] = i2 + 1;
            int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
            if (i == 4) {
                int f = Pack.f(0, bArr);
                iArr2[0][0] = f;
                int f2 = Pack.f(4, bArr);
                iArr2[0][1] = f2;
                int f3 = Pack.f(8, bArr);
                iArr2[0][2] = f3;
                int f4 = Pack.f(12, bArr);
                iArr2[0][3] = f4;
                for (int i3 = 1; i3 <= 10; i3++) {
                    f ^= h((f4 >>> 8) | (f4 << -8)) ^ f5916a[i3 - 1];
                    int[] iArr3 = iArr2[i3];
                    iArr3[0] = f;
                    f2 ^= f;
                    iArr3[1] = f2;
                    f3 ^= f2;
                    iArr3[2] = f3;
                    f4 ^= f3;
                    iArr3[3] = f4;
                }
            } else if (i == 6) {
                int f5 = Pack.f(0, bArr);
                iArr2[0][0] = f5;
                int f6 = Pack.f(4, bArr);
                iArr2[0][1] = f6;
                int f7 = Pack.f(8, bArr);
                iArr2[0][2] = f7;
                int f8 = Pack.f(12, bArr);
                iArr2[0][3] = f8;
                int f9 = Pack.f(16, bArr);
                iArr2[1][0] = f9;
                int f10 = Pack.f(20, bArr);
                iArr2[1][1] = f10;
                int h = f5 ^ (h((f10 >>> 8) | (f10 << -8)) ^ 1);
                int[] iArr4 = iArr2[1];
                iArr4[2] = h;
                int i4 = f6 ^ h;
                iArr4[3] = i4;
                int i5 = f7 ^ i4;
                int[] iArr5 = iArr2[2];
                iArr5[0] = i5;
                int i6 = f8 ^ i5;
                iArr5[1] = i6;
                int i7 = f9 ^ i6;
                iArr5[2] = i7;
                int i8 = f10 ^ i7;
                iArr5[3] = i8;
                int i9 = i6;
                int i10 = i5;
                int i11 = i4;
                int i12 = i7;
                int i13 = h;
                int i14 = i8;
                int i15 = 2;
                for (int i16 = 3; i16 < 12; i16 += 3) {
                    int h2 = h((i14 >>> 8) | (i14 << -8)) ^ i15;
                    int i17 = i15 << 1;
                    int i18 = i13 ^ h2;
                    int[] iArr6 = iArr2[i16];
                    iArr6[0] = i18;
                    int i19 = i11 ^ i18;
                    iArr6[1] = i19;
                    int i20 = i10 ^ i19;
                    iArr6[2] = i20;
                    int i21 = i9 ^ i20;
                    iArr6[3] = i21;
                    int i22 = i12 ^ i21;
                    int i23 = i16 + 1;
                    int[] iArr7 = iArr2[i23];
                    iArr7[0] = i22;
                    int i24 = i14 ^ i22;
                    iArr7[1] = i24;
                    int h3 = h((i24 << -8) | (i24 >>> 8)) ^ i17;
                    i15 = i17 << 1;
                    i13 = i18 ^ h3;
                    int[] iArr8 = iArr2[i23];
                    iArr8[2] = i13;
                    i11 = i19 ^ i13;
                    iArr8[3] = i11;
                    i10 = i20 ^ i11;
                    int[] iArr9 = iArr2[i16 + 2];
                    iArr9[0] = i10;
                    i9 = i21 ^ i10;
                    iArr9[1] = i9;
                    i12 = i22 ^ i9;
                    iArr9[2] = i12;
                    i14 = i24 ^ i12;
                    iArr9[3] = i14;
                }
                int h4 = (i15 ^ h((i14 << -8) | (i14 >>> 8))) ^ i13;
                int[] iArr10 = iArr2[12];
                iArr10[0] = h4;
                int i25 = h4 ^ i11;
                iArr10[1] = i25;
                int i26 = i25 ^ i10;
                iArr10[2] = i26;
                iArr10[3] = i26 ^ i9;
            } else if (i == 8) {
                int f11 = Pack.f(0, bArr);
                iArr2[0][0] = f11;
                int f12 = Pack.f(4, bArr);
                iArr2[0][1] = f12;
                int f13 = Pack.f(8, bArr);
                iArr2[0][2] = f13;
                int f14 = Pack.f(12, bArr);
                iArr2[0][3] = f14;
                int f15 = Pack.f(16, bArr);
                iArr2[1][0] = f15;
                int f16 = Pack.f(20, bArr);
                iArr2[1][1] = f16;
                int f17 = Pack.f(24, bArr);
                iArr2[1][2] = f17;
                int f18 = Pack.f(28, bArr);
                iArr2[1][3] = f18;
                int i27 = 1;
                for (int i28 = 2; i28 < 14; i28 += 2) {
                    int h5 = h((f18 << -8) | (f18 >>> 8)) ^ i27;
                    i27 <<= 1;
                    f11 ^= h5;
                    int[] iArr11 = iArr2[i28];
                    iArr11[0] = f11;
                    f12 ^= f11;
                    iArr11[1] = f12;
                    f13 ^= f12;
                    iArr11[2] = f13;
                    f14 ^= f13;
                    iArr11[3] = f14;
                    f15 ^= h(f14);
                    int[] iArr12 = iArr2[i28 + 1];
                    iArr12[0] = f15;
                    f16 ^= f15;
                    iArr12[1] = f16;
                    f17 ^= f16;
                    iArr12[2] = f17;
                    f18 ^= f17;
                    iArr12[3] = f18;
                }
                int h6 = (h((f18 << -8) | (f18 >>> 8)) ^ i27) ^ f11;
                int[] iArr13 = iArr2[14];
                iArr13[0] = h6;
                int i29 = h6 ^ f12;
                iArr13[1] = i29;
                int i30 = i29 ^ f13;
                iArr13[2] = i30;
                iArr13[3] = i30 ^ f14;
            } else {
                throw new IllegalStateException("Should never get here");
            }
            if (!z2) {
                for (int i31 = 1; i31 < this.f5917a; i31++) {
                    for (int i32 = 0; i32 < 4; i32++) {
                        int[] iArr14 = iArr2[i31];
                        iArr14[i32] = d(iArr14[i32]);
                    }
                }
            }
            this.f5919a = iArr2;
            this.f5918a = z2;
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters2, "invalid parameter passed to AES init - "));
    }

    public final String b() {
        return "AES";
    }

    public final int c() {
        return 16;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        byte[] bArr4;
        int i3 = i;
        int i4 = i2;
        byte[] bArr5 = bArr;
        byte[] bArr6 = bArr2;
        if (this.f5919a == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i3 + 16 > bArr5.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i4 + 16 <= bArr6.length) {
            char c2 = 0;
            int i5 = 1;
            if (this.f5918a) {
                i(i3, bArr5);
                int[][] iArr = this.f5919a;
                int i6 = this.f5920b;
                int[] iArr2 = iArr[0];
                int i7 = i6 ^ iArr2[0];
                int i8 = this.c ^ iArr2[1];
                int i9 = this.d ^ iArr2[2];
                int i10 = iArr2[3] ^ this.e;
                int i11 = 1;
                while (true) {
                    int i12 = this.f5917a - i5;
                    bArr4 = a;
                    if (i11 >= i12) {
                        break;
                    }
                    int f = f(((((bArr4[(i8 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8) ^ (bArr4[i7 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE)) ^ ((bArr4[(i9 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(i10 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr[i11][c2];
                    int f2 = f(((((bArr4[(i9 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8) ^ (bArr4[i8 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE)) ^ ((bArr4[(i10 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(i7 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr[i11][i5];
                    int f3 = f(((((bArr4[(i10 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8) ^ (bArr4[i9 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE)) ^ ((bArr4[(i7 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(i8 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr[i11][2];
                    byte b2 = bArr4[i10 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE;
                    int i13 = i11 + 1;
                    int f4 = f(((((bArr4[(i7 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8) ^ b2) ^ ((bArr4[(i8 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(i9 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr[i11][3];
                    int f5 = f((((bArr4[f & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr4[(f2 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr4[(f3 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(f4 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr[i13][0];
                    int f6 = f((((bArr4[f2 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr4[(f3 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr4[(f4 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(f >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr[i13][1];
                    int f7 = f((((bArr4[f4 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr4[(f >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr4[(f2 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(f3 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN));
                    int i14 = i13 + 1;
                    i10 = iArr[i13][3] ^ f7;
                    i7 = f5;
                    i8 = f6;
                    i9 = f((((bArr4[f3 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr4[(f4 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr4[(f >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(f2 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr[i13][2];
                    c2 = 0;
                    i5 = 1;
                    i11 = i14;
                }
                int f8 = f((((bArr4[i7 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr4[(i8 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr4[(i9 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(i10 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr[i11][0];
                int f9 = f((((bArr4[i8 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr4[(i9 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr4[(i10 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(i7 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr[i11][1];
                int f10 = f((((bArr4[i9 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr4[(i10 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr4[(i7 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(i8 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr[i11][2];
                int f11 = f(((((bArr4[(i7 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8) ^ (bArr4[i10 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE)) ^ ((bArr4[(i8 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(i9 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr[i11][3];
                int[] iArr3 = iArr[i11 + 1];
                this.f5920b = iArr3[0] ^ ((((bArr4[f8 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr4[(f9 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr4[(f10 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(f11 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN));
                this.c = ((((bArr4[f9 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr4[(f10 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr4[(f11 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(f8 >> 24) & 255] << Ascii.CAN)) ^ iArr3[1];
                this.d = ((((bArr4[f10 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr4[(f11 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr4[(f8 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(f9 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr3[2];
                this.e = iArr3[3] ^ ((((bArr4[f11 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr4[(f8 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr4[(f9 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr4[(f10 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN));
                g(i4, bArr6);
            } else {
                i(i3, bArr5);
                int[][] iArr4 = this.f5919a;
                int i15 = this.f5920b;
                int i16 = this.f5917a;
                int[] iArr5 = iArr4[i16];
                int i17 = i15 ^ iArr5[0];
                int i18 = 1;
                int i19 = this.c ^ iArr5[1];
                int i20 = this.d ^ iArr5[2];
                int i21 = i16 - 1;
                int i22 = iArr5[3] ^ this.e;
                while (true) {
                    bArr3 = b;
                    if (i21 <= i18) {
                        break;
                    }
                    int d2 = d((((bArr3[i17 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(i22 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(i20 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(i19 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr4[i21][0];
                    int d3 = d((((bArr3[i19 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(i17 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(i22 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(i20 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr4[i21][1];
                    int d4 = d((((bArr3[i20 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(i19 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(i17 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(i22 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr4[i21][2];
                    int i23 = i21 - 1;
                    int d5 = d((bArr3[(i17 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN) ^ (((bArr3[i22 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(i20 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(i19 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE))) ^ iArr4[i21][3];
                    int d6 = d((((bArr3[d2 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(d5 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(d4 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(d3 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr4[i23][0];
                    i19 = d((((bArr3[d3 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(d2 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(d5 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(d4 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr4[i23][1];
                    i20 = d((((bArr3[d4 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(d3 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(d2 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(d5 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr4[i23][2];
                    int d7 = d((((bArr3[d5 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(d4 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(d3 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(d2 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN));
                    int i24 = i23 - 1;
                    i22 = iArr4[i23][3] ^ d7;
                    i17 = d6;
                    i21 = i24;
                    i18 = 1;
                }
                int d8 = d((((bArr3[i17 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(i22 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(i20 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(i19 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr4[i21][0];
                int d9 = d((((bArr3[i19 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(i17 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(i22 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(i20 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr4[i21][1];
                int d10 = d((((bArr3[i20 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(i19 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(i17 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(i22 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr4[i21][2];
                int d11 = d((bArr3[(i17 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN) ^ (((bArr3[i22 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(i20 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(i19 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE))) ^ iArr4[i21][3];
                int[] iArr6 = iArr4[0];
                this.f5920b = ((((bArr3[d8 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(d11 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(d10 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(d9 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr6[0];
                this.c = ((((bArr3[d9 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(d8 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(d11 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(d10 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr6[1];
                this.d = ((((bArr3[d10 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(d9 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(d8 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(d11 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN)) ^ iArr6[2];
                this.e = iArr6[3] ^ ((((bArr3[d11 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) ^ ((bArr3[(d10 >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8)) ^ ((bArr3[(d9 >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE)) ^ (bArr3[(d8 >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN));
                g(i4, bArr6);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void g(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = this.f5920b;
        bArr[i] = (byte) i3;
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i3 >> 24);
        int i7 = i6 + 1;
        int i8 = this.c;
        bArr[i6] = (byte) i8;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i8 >> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i8 >> 24);
        int i12 = i11 + 1;
        int i13 = this.d;
        bArr[i11] = (byte) i13;
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 >> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i13 >> 16);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i13 >> 24);
        int i17 = i16 + 1;
        int i18 = this.e;
        bArr[i16] = (byte) i18;
        int i19 = i17 + 1;
        bArr[i17] = (byte) (i18 >> 8);
        bArr[i19] = (byte) (i18 >> 16);
        bArr[i19 + 1] = (byte) (i18 >> 24);
    }

    public final void i(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        byte b2 = (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i2] & UnsignedBytes.MAX_VALUE) << 8);
        int i4 = i3 + 1;
        byte b3 = b2 | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        int i5 = i4 + 1;
        this.f5920b = b3 | (bArr[i4] << Ascii.CAN);
        int i6 = i5 + 1;
        byte b4 = bArr[i5] & UnsignedBytes.MAX_VALUE;
        int i7 = i6 + 1;
        byte b5 = ((bArr[i6] & UnsignedBytes.MAX_VALUE) << 8) | b4;
        int i8 = i7 + 1;
        byte b6 = b5 | ((bArr[i7] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        int i9 = i8 + 1;
        this.c = b6 | (bArr[i8] << Ascii.CAN);
        int i10 = i9 + 1;
        byte b7 = bArr[i9] & UnsignedBytes.MAX_VALUE;
        int i11 = i10 + 1;
        byte b8 = ((bArr[i10] & UnsignedBytes.MAX_VALUE) << 8) | b7;
        int i12 = i11 + 1;
        byte b9 = b8 | ((bArr[i11] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        int i13 = i12 + 1;
        this.d = b9 | (bArr[i12] << Ascii.CAN);
        int i14 = i13 + 1;
        byte b10 = bArr[i13] & UnsignedBytes.MAX_VALUE;
        int i15 = i14 + 1;
        this.e = ((bArr[i14] & UnsignedBytes.MAX_VALUE) << 8) | b10 | ((bArr[i15] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | (bArr[i15 + 1] << Ascii.CAN);
    }

    public final void reset() {
    }
}
