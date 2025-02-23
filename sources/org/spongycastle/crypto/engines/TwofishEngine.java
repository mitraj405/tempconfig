package org.spongycastle.crypto.engines;

import com.google.android.gms.ads.AdRequest;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public final class TwofishEngine implements BlockCipher {
    public static final byte[][] a = {new byte[]{-87, 103, -77, -24, 4, -3, -93, 118, -102, -110, UnsignedBytes.MAX_POWER_OF_TWO, 120, -28, -35, -47, 56, Ascii.CR, -58, 53, -104, Ascii.CAN, -9, -20, 108, 67, 117, 55, 38, -6, 19, -108, 72, -14, -48, -117, 48, -124, 84, -33, 35, Ascii.EM, 91, 61, 89, -13, -82, -94, -126, 99, 1, -125, 46, -39, 81, -101, 124, -90, -21, -91, -66, Ascii.SYN, Ascii.FF, -29, 97, -64, -116, 58, -11, 115, 44, 37, Ascii.VT, -69, 78, -119, 107, 83, 106, -76, -15, -31, -26, -67, 69, -30, -12, -74, 102, -52, -107, 3, 86, -44, Ascii.FS, Ascii.RS, -41, -5, -61, -114, -75, -23, -49, -65, -70, -22, 119, 57, -81, 51, -55, 98, 113, -127, 121, 9, -83, 36, -51, -7, -40, -27, -59, -71, 77, 68, 8, -122, -25, -95, Ascii.GS, -86, -19, 6, 112, -78, -46, 65, 123, -96, 17, 49, -62, 39, -112, 32, -10, 96, -1, -106, 92, -79, -85, -98, -100, 82, Ascii.ESC, 95, -109, 10, -17, -111, -123, 73, -18, 45, 79, -113, 59, 71, -121, 109, 70, -42, 62, 105, 100, 42, -50, -53, 47, -4, -105, 5, 122, -84, Ascii.DEL, -43, Ascii.SUB, 75, Ascii.SO, -89, 90, 40, Ascii.DC4, 63, 41, -120, 60, 76, 2, -72, -38, -80, Ascii.ETB, 85, Ascii.US, -118, 125, 87, -57, -115, 116, -73, -60, -97, 114, 126, Ascii.NAK, 34, Ascii.DC2, 88, 7, -103, 52, 110, 80, -34, 104, 101, -68, -37, -8, -56, -88, 43, SignedBytes.MAX_POWER_OF_TWO, -36, -2, 50, -92, -54, Ascii.DLE, 33, -16, -45, 93, Ascii.SI, 0, 111, -99, 54, 66, 74, 94, -63, -32}, new byte[]{117, -13, -58, -12, -37, 123, -5, -56, 74, -45, -26, 107, 69, 125, -24, 75, -42, 50, -40, -3, 55, 113, -15, -31, 48, Ascii.SI, -8, Ascii.ESC, -121, -6, 6, 63, 94, -70, -82, 91, -118, 0, -68, -99, 109, -63, -79, Ascii.SO, UnsignedBytes.MAX_POWER_OF_TWO, 93, -46, -43, -96, -124, 7, Ascii.DC4, -75, -112, 44, -93, -78, 115, 76, 84, -110, 116, 54, 81, 56, -80, -67, 90, -4, 96, 98, -106, 108, 66, -9, Ascii.DLE, 124, 40, 39, -116, 19, -107, -100, -57, 36, 70, 59, 112, -54, -29, -123, -53, 17, -48, -109, -72, -90, -125, 32, -1, -97, 119, -61, -52, 3, 111, 8, -65, SignedBytes.MAX_POWER_OF_TWO, -25, 43, -30, 121, Ascii.FF, -86, -126, 65, 58, -22, -71, -28, -102, -92, -105, 126, -38, 122, Ascii.ETB, 102, -108, -95, Ascii.GS, 61, -16, -34, -77, Ascii.VT, 114, -89, Ascii.FS, -17, -47, 83, 62, -113, 51, 38, 95, -20, 118, 42, 73, -127, -120, -18, 33, -60, Ascii.SUB, -21, -39, -59, 57, -103, -51, -83, 49, -117, 1, Ascii.CAN, 35, -35, Ascii.US, 78, 45, -7, 72, 79, -14, 101, -114, 120, 92, 88, Ascii.EM, -115, -27, -104, 87, 103, Ascii.DEL, 5, 100, -81, 99, -74, -2, -11, -73, 60, -91, -50, -23, 104, 68, -32, 77, 67, 105, 41, 46, -84, Ascii.NAK, 89, -88, 10, -98, 110, 71, -33, 52, 53, 106, -49, -36, 34, -55, -64, -101, -119, -44, -19, -85, Ascii.DC2, -94, Ascii.CR, 82, -69, 2, 47, -87, -41, 97, Ascii.RS, -76, 80, 4, -10, -62, Ascii.SYN, 37, -122, 86, 85, 9, -66, -111}};

    /* renamed from: a  reason: collision with other field name */
    public int f6064a = 0;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6065a = false;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6066a = null;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f6067a = new int[256];
    public final int[] b = new int[256];
    public final int[] c = new int[256];
    public final int[] d = new int[256];
    public int[] e;
    public int[] f;

    public TwofishEngine() {
        int i;
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        for (int i2 = 0; i2 < 256; i2++) {
            byte[][] bArr = a;
            int i3 = bArr[0][i2] & UnsignedBytes.MAX_VALUE;
            iArr[0] = i3;
            iArr2[0] = (j(i3) ^ i3) & Constants.MAX_HOST_LENGTH;
            int i4 = i3 >> 1;
            int i5 = 180;
            if ((i3 & 1) != 0) {
                i = 180;
            } else {
                i = 0;
            }
            iArr3[0] = (j(i3) ^ ((i4 ^ i) ^ i3)) & Constants.MAX_HOST_LENGTH;
            int i6 = bArr[1][i2] & UnsignedBytes.MAX_VALUE;
            iArr[1] = i6;
            iArr2[1] = (j(i6) ^ i6) & Constants.MAX_HOST_LENGTH;
            int i7 = i6 >> 1;
            if ((i6 & 1) == 0) {
                i5 = 0;
            }
            int j = (j(i6) ^ ((i7 ^ i5) ^ i6)) & Constants.MAX_HOST_LENGTH;
            iArr3[1] = j;
            this.f6067a[i2] = (j << 24) | iArr[1] | (iArr2[1] << 8) | (j << 16);
            int[] iArr4 = this.b;
            int i8 = iArr3[0];
            iArr4[i2] = i8 | (i8 << 8) | (iArr2[0] << 16) | (iArr[0] << 24);
            int[] iArr5 = this.c;
            int i9 = iArr2[1];
            int i10 = iArr3[1];
            iArr5[i2] = (iArr[1] << 16) | i9 | (i10 << 8) | (i10 << 24);
            int[] iArr6 = this.d;
            int i11 = iArr2[0];
            iArr6[i2] = (i11 << 24) | (iArr[0] << 8) | i11 | (iArr3[0] << 16);
        }
    }

    public static int f(int i, byte[] bArr) {
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
    }

    public static int j(int i) {
        int i2;
        int i3 = i >> 2;
        int i4 = 0;
        if ((i & 2) != 0) {
            i2 = 180;
        } else {
            i2 = 0;
        }
        int i5 = i3 ^ i2;
        if ((i & 1) != 0) {
            i4 = 90;
        }
        return i5 ^ i4;
    }

    public static int k(int i) {
        int i2;
        int i3 = (i >>> 24) & Constants.MAX_HOST_LENGTH;
        int i4 = i3 << 1;
        int i5 = 0;
        if ((i3 & 128) != 0) {
            i2 = 333;
        } else {
            i2 = 0;
        }
        int i6 = (i4 ^ i2) & Constants.MAX_HOST_LENGTH;
        int i7 = i3 >>> 1;
        if ((i3 & 1) != 0) {
            i5 = 166;
        }
        int i8 = (i7 ^ i5) ^ i6;
        return ((((i << 8) ^ (i8 << 24)) ^ (i6 << 16)) ^ (i8 << 8)) ^ i3;
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.f6065a = z;
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            this.f6066a = bArr;
            this.f6064a = bArr.length / 8;
            l(bArr);
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to Twofish init - "));
    }

    public final String b() {
        return "Twofish";
    }

    public final int c() {
        return 16;
    }

    public final void d(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        int i3 = i;
        int i4 = i2;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (this.f6066a == null) {
            throw new IllegalStateException("Twofish not initialised");
        } else if (i3 + 16 > bArr3.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i4 + 16 <= bArr4.length) {
            if (this.f6065a) {
                int f2 = f(i3, bArr3) ^ this.e[0];
                int f3 = this.e[1] ^ f(i3 + 4, bArr3);
                int f4 = f(i3 + 12, bArr3) ^ this.e[3];
                int i5 = 8;
                int f5 = f(i3 + 8, bArr3) ^ this.e[2];
                int i6 = f3;
                int i7 = 0;
                for (int i8 = 16; i7 < i8; i8 = 16) {
                    int h = h(f2);
                    int i9 = i(i6);
                    int[] iArr = this.e;
                    int i10 = i5 + 1;
                    int i11 = f5 ^ ((h + i9) + iArr[i5]);
                    f5 = (i11 >>> 1) | (i11 << 31);
                    int i12 = i10 + 1;
                    f4 = ((f4 >>> 31) | (f4 << 1)) ^ (((i9 * 2) + h) + iArr[i10]);
                    int h2 = h(f5);
                    int i13 = i(f4);
                    int[] iArr2 = this.e;
                    int i14 = i12 + 1;
                    int i15 = f2 ^ ((h2 + i13) + iArr2[i12]);
                    f2 = (i15 >>> 1) | (i15 << 31);
                    i6 = ((i6 << 1) | (i6 >>> 31)) ^ (((i13 * 2) + h2) + iArr2[i14]);
                    i7 += 2;
                    i5 = i14 + 1;
                }
                d(this.e[4] ^ f5, bArr4, i4);
                d(f4 ^ this.e[5], bArr4, i4 + 4);
                d(this.e[6] ^ f2, bArr4, i4 + 8);
                d(this.e[7] ^ i6, bArr4, i4 + 12);
                return 16;
            }
            int f6 = f(i3, bArr3) ^ this.e[4];
            int f7 = f(i3 + 4, bArr3) ^ this.e[5];
            int f8 = f(i3 + 8, bArr3) ^ this.e[6];
            int f9 = f(i3 + 12, bArr3) ^ this.e[7];
            int i16 = 39;
            int i17 = 0;
            int i18 = 16;
            while (i17 < i18) {
                int h3 = h(f6);
                int i19 = i(f7);
                int[] iArr3 = this.e;
                int i20 = i16 - 1;
                int i21 = f9 ^ (((i19 * 2) + h3) + iArr3[i16]);
                int i22 = (f8 << 1) | (f8 >>> 31);
                int i23 = i20 - 1;
                int i24 = i22 ^ ((h3 + i19) + iArr3[i20]);
                f9 = (i21 << 31) | (i21 >>> 1);
                int h4 = h(i24);
                int i25 = i(f9);
                int[] iArr4 = this.e;
                int i26 = i23 - 1;
                int i27 = f7 ^ (((i25 * 2) + h4) + iArr4[i23]);
                f6 = ((f6 >>> 31) | (f6 << 1)) ^ ((h4 + i25) + iArr4[i26]);
                f7 = (i27 << 31) | (i27 >>> 1);
                i17 += 2;
                i18 = 16;
                f8 = i24;
                i16 = i26 - 1;
            }
            d(this.e[0] ^ f8, bArr4, i4);
            d(f9 ^ this.e[1], bArr4, i4 + 4);
            d(this.e[2] ^ f6, bArr4, i4 + 8);
            d(this.e[3] ^ f7, bArr4, i4 + 12);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final int g(int i, int[] iArr) {
        int i2;
        int i3;
        int i4 = i;
        byte b2 = i4 & UnsignedBytes.MAX_VALUE;
        byte b3 = (i4 >>> 8) & UnsignedBytes.MAX_VALUE;
        byte b4 = (i4 >>> 16) & UnsignedBytes.MAX_VALUE;
        byte b5 = (i4 >>> 24) & UnsignedBytes.MAX_VALUE;
        int i5 = iArr[0];
        char c2 = 1;
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        int i9 = this.f6064a & 3;
        byte[][] bArr = a;
        int[] iArr2 = this.d;
        int[] iArr3 = this.c;
        int[] iArr4 = this.b;
        int[] iArr5 = this.f6067a;
        if (i9 == 0) {
            byte[] bArr2 = bArr[1];
            b2 = (bArr2[b2] & UnsignedBytes.MAX_VALUE) ^ (i8 & UnsignedBytes.MAX_VALUE);
            byte[] bArr3 = bArr[0];
            b3 = (bArr3[b3] & UnsignedBytes.MAX_VALUE) ^ ((i8 >>> 8) & UnsignedBytes.MAX_VALUE);
            b4 = (bArr3[b4] & UnsignedBytes.MAX_VALUE) ^ ((i8 >>> 16) & UnsignedBytes.MAX_VALUE);
            b5 = (bArr2[b5] & UnsignedBytes.MAX_VALUE) ^ ((i8 >>> 24) & UnsignedBytes.MAX_VALUE);
            c2 = 1;
        } else if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 3) {
                    return 0;
                }
            }
            byte[] bArr4 = bArr[0];
            int i10 = iArr5[(bArr4[(bArr4[b2] & UnsignedBytes.MAX_VALUE) ^ (i6 & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ (i5 & UnsignedBytes.MAX_VALUE)];
            byte[] bArr5 = bArr[1];
            i2 = (i10 ^ iArr4[(bArr4[(bArr5[b3] & UnsignedBytes.MAX_VALUE) ^ ((i6 >>> 8) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i5 >>> 8) & UnsignedBytes.MAX_VALUE)]) ^ iArr3[(bArr5[(bArr4[b4] & UnsignedBytes.MAX_VALUE) ^ ((i6 >>> 16) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i5 >>> 16) & UnsignedBytes.MAX_VALUE)];
            i3 = iArr2[(bArr5[(bArr5[b5] & UnsignedBytes.MAX_VALUE) ^ ((i6 >>> 24) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i5 >>> 24) & UnsignedBytes.MAX_VALUE)];
            return i2 ^ i3;
        } else {
            byte[] bArr6 = bArr[0];
            int i11 = iArr5[(bArr6[b2] & UnsignedBytes.MAX_VALUE) ^ (i5 & UnsignedBytes.MAX_VALUE)] ^ iArr4[(bArr6[b3] & UnsignedBytes.MAX_VALUE) ^ ((i5 >>> 8) & UnsignedBytes.MAX_VALUE)];
            byte[] bArr7 = bArr[1];
            i2 = i11 ^ iArr3[(bArr7[b4] & UnsignedBytes.MAX_VALUE) ^ ((i5 >>> 16) & UnsignedBytes.MAX_VALUE)];
            i3 = iArr2[(bArr7[b5] & UnsignedBytes.MAX_VALUE) ^ ((i5 >>> 24) & UnsignedBytes.MAX_VALUE)];
            return i2 ^ i3;
        }
        byte[] bArr8 = bArr[c2];
        b2 = (bArr8[b2] & UnsignedBytes.MAX_VALUE) ^ (i7 & UnsignedBytes.MAX_VALUE);
        b3 = (bArr8[b3] & UnsignedBytes.MAX_VALUE) ^ ((i7 >>> 8) & UnsignedBytes.MAX_VALUE);
        byte[] bArr9 = bArr[0];
        b4 = (bArr9[b4] & UnsignedBytes.MAX_VALUE) ^ ((i7 >>> 16) & UnsignedBytes.MAX_VALUE);
        b5 = (bArr9[b5] & UnsignedBytes.MAX_VALUE) ^ ((i7 >>> 24) & UnsignedBytes.MAX_VALUE);
        byte[] bArr42 = bArr[0];
        int i102 = iArr5[(bArr42[(bArr42[b2] & UnsignedBytes.MAX_VALUE) ^ (i6 & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ (i5 & UnsignedBytes.MAX_VALUE)];
        byte[] bArr52 = bArr[1];
        i2 = (i102 ^ iArr4[(bArr42[(bArr52[b3] & UnsignedBytes.MAX_VALUE) ^ ((i6 >>> 8) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i5 >>> 8) & UnsignedBytes.MAX_VALUE)]) ^ iArr3[(bArr52[(bArr42[b4] & UnsignedBytes.MAX_VALUE) ^ ((i6 >>> 16) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i5 >>> 16) & UnsignedBytes.MAX_VALUE)];
        i3 = iArr2[(bArr52[(bArr52[b5] & UnsignedBytes.MAX_VALUE) ^ ((i6 >>> 24) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i5 >>> 24) & UnsignedBytes.MAX_VALUE)];
        return i2 ^ i3;
    }

    public final int h(int i) {
        int[] iArr = this.f;
        return iArr[(((i >>> 24) & Constants.MAX_HOST_LENGTH) * 2) + 513] ^ ((iArr[((i & Constants.MAX_HOST_LENGTH) * 2) + 0] ^ iArr[(((i >>> 8) & Constants.MAX_HOST_LENGTH) * 2) + 1]) ^ iArr[(((i >>> 16) & Constants.MAX_HOST_LENGTH) * 2) + AdRequest.MAX_CONTENT_URL_LENGTH]);
    }

    public final int i(int i) {
        int[] iArr = this.f;
        return iArr[(((i >>> 16) & Constants.MAX_HOST_LENGTH) * 2) + 513] ^ ((iArr[(((i >>> 24) & Constants.MAX_HOST_LENGTH) * 2) + 0] ^ iArr[((i & Constants.MAX_HOST_LENGTH) * 2) + 1]) ^ iArr[(((i >>> 8) & Constants.MAX_HOST_LENGTH) * 2) + AdRequest.MAX_CONTENT_URL_LENGTH]);
    }

    public final void l(byte[] bArr) {
        int i;
        char c2;
        int i2;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        int i3;
        byte b7;
        byte b8;
        byte b9;
        TwofishEngine twofishEngine = this;
        byte[] bArr2 = bArr;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        twofishEngine.e = new int[40];
        int i4 = twofishEngine.f6064a;
        int i5 = 1;
        if (i4 < 1) {
            throw new IllegalArgumentException("Key size less than 64 bits");
        } else if (i4 <= 4) {
            char c3 = 0;
            for (int i6 = 0; i6 < twofishEngine.f6064a; i6++) {
                int i7 = i6 * 8;
                iArr[i6] = f(i7, bArr2);
                int f2 = f(i7 + 4, bArr2);
                iArr2[i6] = f2;
                int i8 = (twofishEngine.f6064a - 1) - i6;
                int i9 = iArr[i6];
                for (int i10 = 0; i10 < 4; i10++) {
                    f2 = k(f2);
                }
                int i11 = f2 ^ i9;
                for (int i12 = 0; i12 < 4; i12++) {
                    i11 = k(i11);
                }
                iArr3[i8] = i11;
            }
            for (int i13 = 0; i13 < 20; i13++) {
                int i14 = 33686018 * i13;
                int g = twofishEngine.g(i14, iArr);
                int g2 = twofishEngine.g(i14 + 16843009, iArr2);
                int i15 = (g2 >>> 24) | (g2 << 8);
                int i16 = g + i15;
                int[] iArr4 = twofishEngine.e;
                int i17 = i13 * 2;
                iArr4[i17] = i16;
                int i18 = i16 + i15;
                iArr4[i17 + 1] = (i18 << 9) | (i18 >>> 23);
            }
            int i19 = iArr3[0];
            int i20 = iArr3[1];
            int i21 = 2;
            int i22 = iArr3[2];
            int i23 = 3;
            int i24 = iArr3[3];
            twofishEngine.f = new int[UserMetadata.MAX_ATTRIBUTE_SIZE];
            int i25 = 0;
            while (i25 < 256) {
                int i26 = twofishEngine.f6064a & i23;
                byte[][] bArr3 = a;
                int[] iArr5 = twofishEngine.d;
                int[] iArr6 = twofishEngine.c;
                int[] iArr7 = twofishEngine.b;
                int[] iArr8 = twofishEngine.f6067a;
                if (i26 != 0) {
                    if (i26 == i5) {
                        int[] iArr9 = twofishEngine.f;
                        int i27 = i25 * 2;
                        byte b10 = bArr3[c3][i25] & UnsignedBytes.MAX_VALUE;
                        iArr9[i27] = iArr8[(i19 & UnsignedBytes.MAX_VALUE) ^ b10];
                        iArr9[i27 + 1] = iArr7[b10 ^ ((i19 >>> 8) & UnsignedBytes.MAX_VALUE)];
                        int i28 = i27 + AdRequest.MAX_CONTENT_URL_LENGTH;
                        byte b11 = bArr3[i5][i25] & UnsignedBytes.MAX_VALUE;
                        iArr9[i28] = iArr6[((i19 >>> 16) & UnsignedBytes.MAX_VALUE) ^ b11];
                        iArr9[i27 + 513] = iArr5[((i19 >>> 24) & UnsignedBytes.MAX_VALUE) ^ b11];
                        i = i22;
                        i2 = i5;
                        c2 = 0;
                    } else if (i26 == i21) {
                        b5 = i25;
                        b4 = b5;
                        b3 = b4;
                        b2 = b3;
                        int[] iArr10 = twofishEngine.f;
                        int i29 = i25 * 2;
                        c2 = 0;
                        byte[] bArr4 = bArr3[0];
                        i = i22;
                        iArr10[i29] = iArr8[(bArr4[(i20 & UnsignedBytes.MAX_VALUE) ^ (bArr4[b4] & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ (i19 & UnsignedBytes.MAX_VALUE)];
                        i2 = 1;
                        byte[] bArr5 = bArr3[1];
                        iArr10[i29 + 1] = iArr7[(bArr4[(bArr5[b2] & UnsignedBytes.MAX_VALUE) ^ ((i20 >>> 8) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i19 >>> 8) & UnsignedBytes.MAX_VALUE)];
                        iArr10[i29 + AdRequest.MAX_CONTENT_URL_LENGTH] = iArr6[(bArr5[(bArr4[b3] & UnsignedBytes.MAX_VALUE) ^ ((i20 >>> 16) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i19 >>> 16) & UnsignedBytes.MAX_VALUE)];
                        iArr10[i29 + 513] = iArr5[(bArr5[(bArr5[b5] & UnsignedBytes.MAX_VALUE) ^ ((i20 >>> 24) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i19 >>> 24) & UnsignedBytes.MAX_VALUE)];
                    } else if (i26 != i23) {
                        i = i22;
                        c2 = c3;
                        i2 = i5;
                    } else {
                        i3 = i5;
                        b9 = i25;
                        b8 = b9;
                        b7 = b8;
                        b6 = b7;
                    }
                    i25++;
                    twofishEngine = this;
                    i5 = i2;
                    c3 = c2;
                    i22 = i;
                    i21 = 2;
                    i23 = 3;
                } else {
                    byte b12 = bArr3[i5][i25] & UnsignedBytes.MAX_VALUE;
                    b8 = (i24 & UnsignedBytes.MAX_VALUE) ^ b12;
                    byte b13 = bArr3[0][i25] & UnsignedBytes.MAX_VALUE;
                    b6 = ((i24 >>> 8) & UnsignedBytes.MAX_VALUE) ^ b13;
                    b7 = ((i24 >>> 16) & UnsignedBytes.MAX_VALUE) ^ b13;
                    b9 = b12 ^ ((i24 >>> 24) & UnsignedBytes.MAX_VALUE);
                    i3 = 1;
                }
                byte[] bArr6 = bArr3[i3];
                b4 = (bArr6[b8] & UnsignedBytes.MAX_VALUE) ^ (i22 & UnsignedBytes.MAX_VALUE);
                b2 = (bArr6[b6] & UnsignedBytes.MAX_VALUE) ^ ((i22 >>> 8) & UnsignedBytes.MAX_VALUE);
                byte[] bArr7 = bArr3[0];
                b3 = (bArr7[b7] & UnsignedBytes.MAX_VALUE) ^ ((i22 >>> 16) & UnsignedBytes.MAX_VALUE);
                b5 = (bArr7[b9] & UnsignedBytes.MAX_VALUE) ^ ((i22 >>> 24) & UnsignedBytes.MAX_VALUE);
                int[] iArr102 = twofishEngine.f;
                int i292 = i25 * 2;
                c2 = 0;
                byte[] bArr42 = bArr3[0];
                i = i22;
                iArr102[i292] = iArr8[(bArr42[(i20 & UnsignedBytes.MAX_VALUE) ^ (bArr42[b4] & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ (i19 & UnsignedBytes.MAX_VALUE)];
                i2 = 1;
                byte[] bArr52 = bArr3[1];
                iArr102[i292 + 1] = iArr7[(bArr42[(bArr52[b2] & UnsignedBytes.MAX_VALUE) ^ ((i20 >>> 8) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i19 >>> 8) & UnsignedBytes.MAX_VALUE)];
                iArr102[i292 + AdRequest.MAX_CONTENT_URL_LENGTH] = iArr6[(bArr52[(bArr42[b3] & UnsignedBytes.MAX_VALUE) ^ ((i20 >>> 16) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i19 >>> 16) & UnsignedBytes.MAX_VALUE)];
                iArr102[i292 + 513] = iArr5[(bArr52[(bArr52[b5] & UnsignedBytes.MAX_VALUE) ^ ((i20 >>> 24) & UnsignedBytes.MAX_VALUE)] & UnsignedBytes.MAX_VALUE) ^ ((i19 >>> 24) & UnsignedBytes.MAX_VALUE)];
                i25++;
                twofishEngine = this;
                i5 = i2;
                c3 = c2;
                i22 = i;
                i21 = 2;
                i23 = 3;
            }
        } else {
            throw new IllegalArgumentException("Key size larger than 256 bits");
        }
    }

    public final void reset() {
        byte[] bArr = this.f6066a;
        if (bArr != null) {
            l(bArr);
        }
    }
}
