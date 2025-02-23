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

public class CamelliaLightEngine implements BlockCipher {
    public static final byte[] a = {112, -126, 44, -20, -77, 39, -64, -27, -28, -123, 87, 53, -22, Ascii.FF, -82, 65, 35, -17, 107, -109, 69, Ascii.EM, -91, 33, -19, Ascii.SO, 79, 78, Ascii.GS, 101, -110, -67, -122, -72, -81, -113, 124, -21, Ascii.US, -50, 62, 48, -36, 95, 94, -59, Ascii.VT, Ascii.SUB, -90, -31, 57, -54, -43, 71, 93, 61, -39, 1, 90, -42, 81, 86, 108, 77, -117, Ascii.CR, -102, 102, -5, -52, -80, 45, 116, Ascii.DC2, 43, 32, -16, -79, -124, -103, -33, 76, -53, -62, 52, 126, 118, 5, 109, -73, -87, 49, -47, Ascii.ETB, 4, -41, Ascii.DC4, 88, 58, 97, -34, Ascii.ESC, 17, Ascii.FS, 50, Ascii.SI, -100, Ascii.SYN, 83, Ascii.CAN, -14, 34, -2, 68, -49, -78, -61, -75, 122, -111, 36, 8, -24, -88, 96, -4, 105, 80, -86, -48, -96, 125, -95, -119, 98, -105, 84, 91, Ascii.RS, -107, -32, -1, 100, -46, Ascii.DLE, -60, 0, 72, -93, -9, 117, -37, -118, 3, -26, -38, 9, 63, -35, -108, -121, 92, -125, 2, -51, 74, -112, 51, 115, 103, -10, -13, -99, Ascii.DEL, -65, -30, 82, -101, -40, 38, -56, 55, -58, 59, -127, -106, 111, 75, 19, -66, 99, 46, -23, 121, -89, -116, -97, 110, -68, -114, 41, -11, -7, -74, 47, -3, -76, 89, 120, -104, 6, 106, -25, 70, 113, -70, -44, 37, -85, 66, -120, -94, -115, -6, 114, 7, -71, 85, -8, -18, -84, 10, 54, 73, 42, 104, 60, 56, -15, -92, SignedBytes.MAX_POWER_OF_TWO, 40, -45, 123, -69, -55, 67, -63, Ascii.NAK, -29, -83, -12, 119, -57, UnsignedBytes.MAX_POWER_OF_TWO, -98};
    public static final int[] e = {-1600231809, 1003262091, -1233459112, 1286239154, -957401297, -380665154, 1426019237, -237801700, 283453434, -563598051, -1336506174, -1276722691};

    /* renamed from: a  reason: collision with other field name */
    public boolean f5930a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f5931a = new int[96];
    public boolean b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f5932b = new int[8];
    public final int[] c = new int[12];
    public final int[] d = new int[4];

    public static void h(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        int i4 = i3 + 2;
        int i5 = i2 + 0;
        int i6 = i2 + 1;
        int i7 = 32 - i;
        iArr2[i4] = (iArr[i5] << i) | (iArr[i6] >>> i7);
        int i8 = i3 + 3;
        int i9 = i2 + 2;
        iArr2[i8] = (iArr[i6] << i) | (iArr[i9] >>> i7);
        int i10 = i3 + 0;
        int i11 = i2 + 3;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i11] >>> i7);
        int i12 = i3 + 1;
        iArr2[i12] = (iArr[i11] << i) | (iArr[i5] >>> i7);
        iArr[i5] = iArr2[i4];
        iArr[i6] = iArr2[i8];
        iArr[i9] = iArr2[i10];
        iArr[i11] = iArr2[i12];
    }

    public static void i(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        int i4 = i3 + 2;
        int i5 = i2 + 1;
        int i6 = i - 32;
        int i7 = i2 + 2;
        int i8 = 64 - i;
        iArr2[i4] = (iArr[i5] << i6) | (iArr[i7] >>> i8);
        int i9 = i3 + 3;
        int i10 = i2 + 3;
        iArr2[i9] = (iArr[i7] << i6) | (iArr[i10] >>> i8);
        int i11 = i3 + 0;
        int i12 = i2 + 0;
        iArr2[i11] = (iArr[i10] << i6) | (iArr[i12] >>> i8);
        int i13 = i3 + 1;
        iArr2[i13] = (iArr[i5] >>> i8) | (iArr[i12] << i6);
        iArr[i12] = iArr2[i4];
        iArr[i5] = iArr2[i9];
        iArr[i7] = iArr2[i11];
        iArr[i10] = iArr2[i13];
    }

    public static int k(int i, int i2) {
        return (i << i2) + (i >>> (32 - i2));
    }

    public static void l(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        int i4 = i3 + 0;
        int i5 = i2 + 0;
        int i6 = i2 + 1;
        int i7 = 32 - i;
        iArr2[i4] = (iArr[i5] << i) | (iArr[i6] >>> i7);
        int i8 = i3 + 1;
        int i9 = i2 + 2;
        iArr2[i8] = (iArr[i6] << i) | (iArr[i9] >>> i7);
        int i10 = i3 + 2;
        int i11 = i2 + 3;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i11] >>> i7);
        int i12 = i3 + 3;
        iArr2[i12] = (iArr[i11] << i) | (iArr[i5] >>> i7);
        iArr[i5] = iArr2[i4];
        iArr[i6] = iArr2[i8];
        iArr[i9] = iArr2[i10];
        iArr[i11] = iArr2[i12];
    }

    public static void m(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        int i4 = i3 + 0;
        int i5 = i2 + 1;
        int i6 = i - 32;
        int i7 = i2 + 2;
        int i8 = 64 - i;
        iArr2[i4] = (iArr[i5] << i6) | (iArr[i7] >>> i8);
        int i9 = i3 + 1;
        int i10 = i2 + 3;
        iArr2[i9] = (iArr[i7] << i6) | (iArr[i10] >>> i8);
        int i11 = i3 + 2;
        int i12 = i2 + 0;
        iArr2[i11] = (iArr[i10] << i6) | (iArr[i12] >>> i8);
        int i13 = i3 + 3;
        iArr2[i13] = (iArr[i5] >>> i8) | (iArr[i12] << i6);
        iArr[i12] = iArr2[i4];
        iArr[i5] = iArr2[i9];
        iArr[i7] = iArr2[i11];
        iArr[i10] = iArr2[i13];
    }

    public static int n(int i) {
        byte b2 = (byte) i;
        return a[((byte) (((b2 & UnsignedBytes.MAX_VALUE) >>> 7) | (b2 << 1))) & UnsignedBytes.MAX_VALUE] & UnsignedBytes.MAX_VALUE;
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        CipherParameters cipherParameters2 = cipherParameters;
        if (cipherParameters2 instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters2).a;
            int[] iArr = new int[8];
            int[] iArr2 = new int[4];
            int[] iArr3 = new int[4];
            int[] iArr4 = new int[4];
            int length = bArr.length;
            if (length == 16) {
                this.b = true;
                iArr[0] = d(0, bArr);
                iArr[1] = d(4, bArr);
                iArr[2] = d(8, bArr);
                iArr[3] = d(12, bArr);
                iArr[7] = 0;
                iArr[6] = 0;
                iArr[5] = 0;
                iArr[4] = 0;
            } else if (length == 24) {
                iArr[0] = d(0, bArr);
                iArr[1] = d(4, bArr);
                iArr[2] = d(8, bArr);
                iArr[3] = d(12, bArr);
                iArr[4] = d(16, bArr);
                int d2 = d(20, bArr);
                iArr[5] = d2;
                iArr[6] = ~iArr[4];
                iArr[7] = ~d2;
                this.b = false;
            } else if (length == 32) {
                iArr[0] = d(0, bArr);
                iArr[1] = d(4, bArr);
                iArr[2] = d(8, bArr);
                iArr[3] = d(12, bArr);
                iArr[4] = d(16, bArr);
                iArr[5] = d(20, bArr);
                iArr[6] = d(24, bArr);
                iArr[7] = d(28, bArr);
                this.b = false;
            } else {
                throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
            }
            for (int i = 0; i < 4; i++) {
                iArr2[i] = iArr[i] ^ iArr[i + 4];
            }
            int[] iArr5 = e;
            f(iArr2, 0, iArr5);
            for (int i2 = 0; i2 < 4; i2++) {
                iArr2[i2] = iArr2[i2] ^ iArr[i2];
            }
            f(iArr2, 4, iArr5);
            boolean z2 = this.b;
            int[] iArr6 = this.f5932b;
            int[] iArr7 = this.c;
            int[] iArr8 = this.f5931a;
            if (!z2) {
                for (int i3 = 0; i3 < 4; i3++) {
                    iArr3[i3] = iArr2[i3] ^ iArr[i3 + 4];
                }
                f(iArr3, 8, iArr5);
                if (z) {
                    iArr6[0] = iArr[0];
                    iArr6[1] = iArr[1];
                    iArr6[2] = iArr[2];
                    iArr6[3] = iArr[3];
                    m(45, 0, 16, iArr, iArr8);
                    l(15, 0, 4, iArr, iArr7);
                    l(17, 0, 32, iArr, iArr8);
                    m(34, 0, 44, iArr, iArr8);
                    l(15, 4, 4, iArr, iArr8);
                    l(15, 4, 0, iArr, iArr7);
                    l(30, 4, 24, iArr, iArr8);
                    m(34, 4, 36, iArr, iArr8);
                    l(15, 0, 8, iArr2, iArr8);
                    l(30, 0, 20, iArr2, iArr8);
                    iArr7[8] = iArr2[1];
                    iArr7[9] = iArr2[2];
                    iArr7[10] = iArr2[3];
                    iArr7[11] = iArr2[0];
                    m(49, 0, 40, iArr2, iArr8);
                    iArr8[0] = iArr3[0];
                    iArr8[1] = iArr3[1];
                    iArr8[2] = iArr3[2];
                    iArr8[3] = iArr3[3];
                    l(30, 0, 12, iArr3, iArr8);
                    l(30, 0, 28, iArr3, iArr8);
                    m(51, 0, 4, iArr3, iArr6);
                } else {
                    iArr6[4] = iArr[0];
                    iArr6[5] = iArr[1];
                    iArr6[6] = iArr[2];
                    iArr6[7] = iArr[3];
                    i(45, 0, 28, iArr, iArr8);
                    h(15, 0, 4, iArr, iArr7);
                    h(17, 0, 12, iArr, iArr8);
                    i(34, 0, 0, iArr, iArr8);
                    h(15, 4, 40, iArr, iArr8);
                    h(15, 4, 8, iArr, iArr7);
                    h(30, 4, 20, iArr, iArr8);
                    i(34, 4, 8, iArr, iArr8);
                    h(15, 0, 36, iArr2, iArr8);
                    h(30, 0, 24, iArr2, iArr8);
                    iArr7[2] = iArr2[1];
                    iArr7[3] = iArr2[2];
                    iArr7[0] = iArr2[3];
                    iArr7[1] = iArr2[0];
                    i(49, 0, 4, iArr2, iArr8);
                    iArr8[46] = iArr3[0];
                    iArr8[47] = iArr3[1];
                    iArr8[44] = iArr3[2];
                    iArr8[45] = iArr3[3];
                    h(30, 0, 32, iArr3, iArr8);
                    h(30, 0, 16, iArr3, iArr8);
                    m(51, 0, 0, iArr3, iArr6);
                }
            } else if (z) {
                iArr6[0] = iArr[0];
                iArr6[1] = iArr[1];
                iArr6[2] = iArr[2];
                iArr6[3] = iArr[3];
                l(15, 0, 4, iArr, iArr8);
                l(30, 0, 12, iArr, iArr8);
                l(15, 0, 0, iArr, iArr4);
                iArr8[18] = iArr4[2];
                iArr8[19] = iArr4[3];
                l(17, 0, 4, iArr, iArr7);
                l(17, 0, 24, iArr, iArr8);
                l(17, 0, 32, iArr, iArr8);
                iArr8[0] = iArr2[0];
                iArr8[1] = iArr2[1];
                iArr8[2] = iArr2[2];
                iArr8[3] = iArr2[3];
                l(15, 0, 8, iArr2, iArr8);
                l(15, 0, 0, iArr2, iArr7);
                l(15, 0, 0, iArr2, iArr4);
                iArr8[16] = iArr4[0];
                iArr8[17] = iArr4[1];
                l(15, 0, 20, iArr2, iArr8);
                m(34, 0, 28, iArr2, iArr8);
                l(17, 0, 4, iArr2, iArr6);
            } else {
                iArr6[4] = iArr[0];
                iArr6[5] = iArr[1];
                iArr6[6] = iArr[2];
                iArr6[7] = iArr[3];
                h(15, 0, 28, iArr, iArr8);
                h(30, 0, 20, iArr, iArr8);
                h(15, 0, 0, iArr, iArr4);
                iArr8[16] = iArr4[0];
                iArr8[17] = iArr4[1];
                h(17, 0, 0, iArr, iArr7);
                h(17, 0, 8, iArr, iArr8);
                h(17, 0, 0, iArr, iArr8);
                iArr8[34] = iArr2[0];
                iArr8[35] = iArr2[1];
                iArr8[32] = iArr2[2];
                iArr8[33] = iArr2[3];
                h(15, 0, 24, iArr2, iArr8);
                h(15, 0, 4, iArr2, iArr7);
                h(15, 0, 0, iArr2, iArr4);
                iArr8[18] = iArr4[2];
                iArr8[19] = iArr4[3];
                h(15, 0, 12, iArr2, iArr8);
                i(34, 0, 4, iArr2, iArr8);
                l(17, 0, 0, iArr2, iArr6);
            }
            this.f5930a = true;
            return;
        }
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    public final String b() {
        return "Camellia";
    }

    public final int c() {
        return 16;
    }

    public final int d(int i, byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = (i2 << 8) + (bArr[i3 + i] & UnsignedBytes.MAX_VALUE);
        }
        return i2;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws IllegalStateException {
        int i3 = i2;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (!this.f5930a) {
            throw new IllegalStateException("Camellia is not initialized");
        } else if (i + 16 > bArr3.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + 16 <= bArr4.length) {
            boolean z = this.b;
            int[] iArr = this.c;
            int[] iArr2 = this.f5931a;
            int[] iArr3 = this.d;
            int[] iArr4 = this.f5932b;
            if (z) {
                for (int i4 = 0; i4 < 4; i4++) {
                    int d2 = d((i4 * 4) + i, bArr3);
                    iArr3[i4] = d2;
                    iArr3[i4] = iArr4[i4] ^ d2;
                }
                f(iArr3, 0, iArr2);
                f(iArr3, 4, iArr2);
                f(iArr3, 8, iArr2);
                g(iArr3, 0, iArr);
                f(iArr3, 12, iArr2);
                f(iArr3, 16, iArr2);
                f(iArr3, 20, iArr2);
                g(iArr3, 4, iArr);
                f(iArr3, 24, iArr2);
                f(iArr3, 28, iArr2);
                f(iArr3, 32, iArr2);
                int i5 = iArr3[2] ^ iArr4[4];
                iArr3[2] = i5;
                iArr3[3] = iArr3[3] ^ iArr4[5];
                iArr3[0] = iArr3[0] ^ iArr4[6];
                iArr3[1] = iArr3[1] ^ iArr4[7];
                j(i5, bArr4, i3);
                j(iArr3[3], bArr4, i3 + 4);
                j(iArr3[0], bArr4, i3 + 8);
                j(iArr3[1], bArr4, i3 + 12);
                return 16;
            }
            for (int i6 = 0; i6 < 4; i6++) {
                int d3 = d((i6 * 4) + i, bArr3);
                iArr3[i6] = d3;
                iArr3[i6] = iArr4[i6] ^ d3;
            }
            f(iArr3, 0, iArr2);
            f(iArr3, 4, iArr2);
            f(iArr3, 8, iArr2);
            g(iArr3, 0, iArr);
            f(iArr3, 12, iArr2);
            f(iArr3, 16, iArr2);
            f(iArr3, 20, iArr2);
            g(iArr3, 4, iArr);
            f(iArr3, 24, iArr2);
            f(iArr3, 28, iArr2);
            f(iArr3, 32, iArr2);
            g(iArr3, 8, iArr);
            f(iArr3, 36, iArr2);
            f(iArr3, 40, iArr2);
            f(iArr3, 44, iArr2);
            int i7 = iArr3[2] ^ iArr4[4];
            iArr3[2] = i7;
            iArr3[3] = iArr3[3] ^ iArr4[5];
            iArr3[0] = iArr3[0] ^ iArr4[6];
            iArr3[1] = iArr3[1] ^ iArr4[7];
            j(i7, bArr4, i3);
            j(iArr3[3], bArr4, i3 + 4);
            j(iArr3[0], bArr4, i3 + 8);
            j(iArr3[1], bArr4, i3 + 12);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void f(int[] iArr, int i, int[] iArr2) {
        int i2 = iArr[0] ^ iArr2[i + 0];
        int n = n(i2 & Constants.MAX_HOST_LENGTH);
        int i3 = (i2 >>> 8) & Constants.MAX_HOST_LENGTH;
        byte[] bArr = a;
        byte b2 = bArr[i3];
        int i4 = n | ((((byte) (((b2 & UnsignedBytes.MAX_VALUE) >>> 1) | (b2 << 7))) & UnsignedBytes.MAX_VALUE) << 8);
        byte b3 = bArr[(i2 >>> 16) & Constants.MAX_HOST_LENGTH];
        int i5 = (bArr[(i2 >>> 24) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.CAN;
        int i6 = i5 | i4 | ((((byte) (((b3 & UnsignedBytes.MAX_VALUE) >>> 7) | (b3 << 1))) & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        int i7 = iArr[1] ^ iArr2[i + 1];
        byte n2 = (bArr[i7 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) | (n((i7 >>> 8) & Constants.MAX_HOST_LENGTH) << 8);
        byte b4 = bArr[(i7 >>> 16) & Constants.MAX_HOST_LENGTH];
        byte b5 = n2 | ((((byte) (((b4 & UnsignedBytes.MAX_VALUE) >>> 1) | (b4 << 7))) & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        byte b6 = bArr[(i7 >>> 24) & Constants.MAX_HOST_LENGTH];
        int k = k(((((byte) (((b6 & UnsignedBytes.MAX_VALUE) >>> 7) | (b6 << 1))) & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | b5, 8);
        int i8 = i6 ^ k;
        int k2 = k(k, 8) ^ i8;
        int i9 = ((i8 >>> 8) + (i8 << 24)) ^ k2;
        iArr[2] = (k(k2, 16) ^ i9) ^ iArr[2];
        iArr[3] = k(i9, 8) ^ iArr[3];
        int i10 = iArr[2] ^ iArr2[i + 2];
        int n3 = n(i10 & Constants.MAX_HOST_LENGTH);
        byte b7 = bArr[(i10 >>> 8) & Constants.MAX_HOST_LENGTH];
        int i11 = n3 | ((((byte) (((b7 & UnsignedBytes.MAX_VALUE) >>> 1) | (b7 << 7))) & UnsignedBytes.MAX_VALUE) << 8);
        byte b8 = bArr[(i10 >>> 16) & Constants.MAX_HOST_LENGTH];
        int i12 = (bArr[(i10 >>> 24) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.CAN;
        int i13 = i12 | i11 | ((((byte) (((b8 & UnsignedBytes.MAX_VALUE) >>> 7) | (b8 << 1))) & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        int i14 = iArr2[i + 3] ^ iArr[3];
        byte n4 = (bArr[i14 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) | (n((i14 >>> 8) & Constants.MAX_HOST_LENGTH) << 8);
        byte b9 = bArr[(i14 >>> 16) & Constants.MAX_HOST_LENGTH];
        byte b10 = n4 | ((((byte) (((b9 & UnsignedBytes.MAX_VALUE) >>> 1) | (b9 << 7))) & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        byte b11 = bArr[(i14 >>> 24) & Constants.MAX_HOST_LENGTH];
        int k3 = k(((((byte) (((b11 & UnsignedBytes.MAX_VALUE) >>> 7) | (b11 << 1))) & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | b10, 8);
        int i15 = i13 ^ k3;
        int k4 = k(k3, 8) ^ i15;
        int i16 = ((i15 >>> 8) + (i15 << 24)) ^ k4;
        iArr[0] = (k(k4, 16) ^ i16) ^ iArr[0];
        iArr[1] = iArr[1] ^ k(i16, 8);
    }

    public final void g(int[] iArr, int i, int[] iArr2) {
        int k = iArr[1] ^ k(iArr[0] & iArr2[i + 0], 1);
        iArr[1] = k;
        iArr[0] = (k | iArr2[i + 1]) ^ iArr[0];
        int i2 = iArr[2];
        int i3 = iArr2[i + 3];
        int i4 = iArr[3];
        int i5 = i2 ^ (i3 | i4);
        iArr[2] = i5;
        iArr[3] = k(iArr2[i + 2] & i5, 1) ^ i4;
    }

    public final void j(int i, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[(3 - i3) + i2] = (byte) i;
            i >>>= 8;
        }
    }

    public final void reset() {
    }
}
