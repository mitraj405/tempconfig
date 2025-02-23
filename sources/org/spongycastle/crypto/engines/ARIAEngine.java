package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.lang.reflect.Array;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.encoders.Hex;

public class ARIAEngine implements BlockCipher {
    public static final byte[] a = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, Ascii.NAK, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, Ascii.DC2, UnsignedBytes.MAX_POWER_OF_TWO, -30, -21, 39, -78, 117, 9, -125, 44, Ascii.SUB, Ascii.ESC, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Ascii.DEL, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, -68, -74, -38, 33, Ascii.DLE, -1, -13, -46, -51, Ascii.FF, 19, -20, 95, -105, 68, Ascii.ETB, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, Ascii.DC4, -34, 94, Ascii.VT, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, Ascii.FS, -90, -76, -58, -24, -35, 116, Ascii.US, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, Ascii.SO, 97, 53, 87, -71, -122, -63, Ascii.GS, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, Ascii.RS, -121, -23, -50, 85, 40, -33, -116, -95, -119, Ascii.CR, -65, -26, 66, 104, 65, -103, 45, Ascii.SI, -80, 84, -69, Ascii.SYN};
    public static final byte[] b = {-30, 78, 84, -4, -108, -62, 74, -52, 98, Ascii.CR, 106, 70, 60, 77, -117, -47, 94, -6, 100, -53, -76, -105, -66, 43, -68, 119, 46, 3, -45, Ascii.EM, 89, -63, Ascii.GS, 6, 65, 107, 85, -16, -103, 105, -22, -100, Ascii.CAN, -82, 99, -33, -25, -69, 0, 115, 102, -5, -106, 76, -123, -28, 58, 9, 69, -86, Ascii.SI, -18, Ascii.DLE, -21, 45, Ascii.DEL, -12, 41, -84, -49, -83, -111, -115, 120, -56, -107, -7, 47, -50, -51, 8, 122, -120, 56, 92, -125, 42, 40, 71, -37, -72, -57, -109, -92, Ascii.DC2, 83, -1, -121, Ascii.SO, 49, 54, 33, 88, 72, 1, -114, 55, 116, 50, -54, -23, -79, -73, -85, Ascii.FF, -41, -60, 86, 66, 38, 7, -104, 96, -39, -74, -71, 17, SignedBytes.MAX_POWER_OF_TWO, -20, 32, -116, -67, -96, -55, -124, 4, 73, 35, -15, 79, 80, Ascii.US, 19, -36, -40, -64, -98, 87, -29, -61, 123, 101, 59, 2, -113, 62, -24, 37, -110, -27, Ascii.NAK, -35, -3, Ascii.ETB, -87, -65, -44, -102, 126, -59, 57, 103, -2, 118, -99, 67, -89, -31, -48, -11, 104, -14, Ascii.ESC, 52, 112, 5, -93, -118, -43, 121, -122, -88, 48, -58, 81, 75, Ascii.RS, -90, 39, -10, 53, -46, 110, 36, Ascii.SYN, -126, 95, -38, -26, 117, -94, -17, 44, -78, Ascii.FS, -97, 93, 111, UnsignedBytes.MAX_POWER_OF_TWO, 10, 114, 68, -101, 108, -112, Ascii.VT, 91, 51, 125, 90, 82, -13, 97, -95, -9, -80, -42, 63, 124, 109, -19, Ascii.DC4, -32, -91, 61, 34, -77, -8, -119, -34, 113, Ascii.SUB, -81, -70, -75, -127};

    /* renamed from: b  reason: collision with other field name */
    public static final byte[][] f5921b = {Hex.a("517cc1b727220a94fe13abe8fa9a6ee0"), Hex.a("6db14acc9e21c820ff28b1d5ef5de2b0"), Hex.a("db92371d2126e9700324977504e8c90e")};
    public static final byte[] c = {82, 9, 106, -43, 48, 54, -91, 56, -65, SignedBytes.MAX_POWER_OF_TWO, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, Ascii.VT, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, Ascii.SYN, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, Ascii.NAK, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, -68, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, Ascii.RS, -113, -54, 63, Ascii.SI, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, Ascii.FS, 117, -33, 110, 71, -15, Ascii.SUB, 113, Ascii.GS, 41, -59, -119, 111, -73, 98, Ascii.SO, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, Ascii.US, -35, -88, 51, -120, 7, -57, 49, -79, Ascii.DC2, Ascii.DLE, 89, 39, UnsignedBytes.MAX_POWER_OF_TWO, -20, 95, 96, 81, Ascii.DEL, -87, Ascii.EM, -75, 74, Ascii.CR, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, Ascii.ETB, 43, 4, 126, -70, 119, -42, 38, -31, 105, Ascii.DC4, 99, 85, 33, Ascii.FF, 125};
    public static final byte[] d = {48, 104, -103, Ascii.ESC, -121, -71, 33, 120, 80, 57, -37, -31, 114, 9, 98, 60, 62, 126, 94, -114, -15, -96, -52, -93, 42, Ascii.GS, -5, -74, -42, 32, -60, -115, -127, 101, -11, -119, -53, -99, 119, -58, 87, 67, 86, Ascii.ETB, -44, SignedBytes.MAX_POWER_OF_TWO, Ascii.SUB, 77, -64, 99, 108, -29, -73, -56, 100, 106, 83, -86, 56, -104, Ascii.FF, -12, -101, -19, Ascii.DEL, 34, 118, -81, -35, 58, Ascii.VT, 88, 103, -120, 6, -61, 53, Ascii.CR, 1, -117, -116, -62, -26, 95, 2, 36, 117, -109, 102, Ascii.RS, -27, -30, 84, -40, Ascii.DLE, -50, 122, -24, 8, 44, Ascii.DC2, -105, 50, -85, -76, 39, 10, 35, -33, -17, -54, -39, -72, -6, -36, 49, 107, -47, -83, Ascii.EM, 73, -67, 81, -106, -18, -28, -88, 65, -38, -1, -51, 85, -122, 54, -66, 97, 82, -8, -69, Ascii.SO, -126, 72, 105, -102, -32, 71, -98, 92, 4, 75, 52, Ascii.NAK, 121, 38, -89, -34, 41, -82, -110, -41, -124, -23, -46, -70, 93, -13, -59, -80, -65, -92, 59, 113, 68, 70, 43, -4, -21, 111, -43, -10, Ascii.DC4, -2, 124, 112, 90, 125, -3, 47, Ascii.CAN, -125, Ascii.SYN, -91, -111, Ascii.US, 5, -107, 116, -87, -63, 91, 74, -123, 109, 19, 7, 79, 78, 69, -78, Ascii.SI, -55, Ascii.FS, -90, -68, -20, 115, -112, 123, -49, 89, -113, -95, -7, 45, -14, -79, 0, -108, 55, -97, -48, 46, -100, 110, 40, 63, UnsignedBytes.MAX_POWER_OF_TWO, -16, 61, -45, 37, -118, -75, -25, 66, -77, -57, -22, -9, 76, 17, 51, 3, -94, -84, 96};

    /* renamed from: a  reason: collision with other field name */
    public byte[][] f5922a;

    public static void d(byte[] bArr) {
        byte b2 = bArr[0];
        byte b3 = bArr[1];
        byte b4 = bArr[2];
        byte b5 = bArr[3];
        byte b6 = bArr[4];
        byte b7 = bArr[5];
        byte b8 = bArr[6];
        byte b9 = bArr[7];
        byte b10 = bArr[8];
        byte b11 = bArr[9];
        byte b12 = bArr[10];
        byte b13 = bArr[11];
        byte b14 = bArr[12];
        byte b15 = bArr[13];
        byte b16 = bArr[14];
        byte b17 = bArr[15];
        bArr[0] = (byte) ((((((b5 ^ b6) ^ b8) ^ b10) ^ b11) ^ b15) ^ b16);
        bArr[1] = (byte) ((((((b4 ^ b7) ^ b9) ^ b10) ^ b11) ^ b14) ^ b17);
        bArr[2] = (byte) ((((((b3 ^ b6) ^ b8) ^ b12) ^ b13) ^ b14) ^ b17);
        bArr[3] = (byte) ((((((b2 ^ b7) ^ b9) ^ b12) ^ b13) ^ b15) ^ b16);
        byte b18 = b2 ^ b4;
        bArr[4] = (byte) (((((b18 ^ b7) ^ b10) ^ b13) ^ b16) ^ b17);
        byte b19 = b3 ^ b5;
        bArr[5] = (byte) (((((b19 ^ b6) ^ b11) ^ b12) ^ b16) ^ b17);
        bArr[6] = (byte) (((((b18 ^ b9) ^ b11) ^ b12) ^ b14) ^ b15);
        bArr[7] = (byte) (((((b19 ^ b8) ^ b10) ^ b13) ^ b14) ^ b15);
        byte b20 = b2 ^ b3;
        bArr[8] = (byte) (((((b20 ^ b6) ^ b9) ^ b12) ^ b15) ^ b17);
        bArr[9] = (byte) (((((b20 ^ b7) ^ b8) ^ b13) ^ b14) ^ b16);
        byte b21 = b4 ^ b5;
        bArr[10] = (byte) (((((b21 ^ b7) ^ b8) ^ b10) ^ b15) ^ b17);
        bArr[11] = (byte) (((((b21 ^ b6) ^ b9) ^ b11) ^ b14) ^ b16);
        byte b22 = b3 ^ b4;
        bArr[12] = (byte) (((((b22 ^ b8) ^ b9) ^ b11) ^ b13) ^ b14);
        byte b23 = b2 ^ b5;
        bArr[13] = (byte) (((((b23 ^ b8) ^ b9) ^ b10) ^ b12) ^ b15);
        bArr[14] = (byte) (((((b23 ^ b6) ^ b7) ^ b11) ^ b13) ^ b16);
        bArr[15] = (byte) (((((b22 ^ b6) ^ b7) ^ b10) ^ b12) ^ b17);
    }

    public static void f(byte[] bArr, byte[] bArr2) {
        m(bArr, bArr2);
        bArr[0] = g(bArr[0]);
        bArr[1] = h(bArr[1]);
        bArr[2] = i(bArr[2]);
        bArr[3] = j(bArr[3]);
        bArr[4] = g(bArr[4]);
        bArr[5] = h(bArr[5]);
        bArr[6] = i(bArr[6]);
        bArr[7] = j(bArr[7]);
        bArr[8] = g(bArr[8]);
        bArr[9] = h(bArr[9]);
        bArr[10] = i(bArr[10]);
        bArr[11] = j(bArr[11]);
        bArr[12] = g(bArr[12]);
        bArr[13] = h(bArr[13]);
        bArr[14] = i(bArr[14]);
        bArr[15] = j(bArr[15]);
        d(bArr);
    }

    public static byte g(byte b2) {
        return a[b2 & UnsignedBytes.MAX_VALUE];
    }

    public static byte h(byte b2) {
        return b[b2 & UnsignedBytes.MAX_VALUE];
    }

    public static byte i(byte b2) {
        return c[b2 & UnsignedBytes.MAX_VALUE];
    }

    public static byte j(byte b2) {
        return d[b2 & UnsignedBytes.MAX_VALUE];
    }

    public static void k(byte[] bArr) {
        bArr[0] = i(bArr[0]);
        bArr[1] = j(bArr[1]);
        bArr[2] = g(bArr[2]);
        bArr[3] = h(bArr[3]);
        bArr[4] = i(bArr[4]);
        bArr[5] = j(bArr[5]);
        bArr[6] = g(bArr[6]);
        bArr[7] = h(bArr[7]);
        bArr[8] = i(bArr[8]);
        bArr[9] = j(bArr[9]);
        bArr[10] = g(bArr[10]);
        bArr[11] = h(bArr[11]);
        bArr[12] = i(bArr[12]);
        bArr[13] = j(bArr[13]);
        bArr[14] = g(bArr[14]);
        bArr[15] = h(bArr[15]);
    }

    public static void l(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i2 = i >>> 3;
        byte b2 = i & 7;
        int i3 = 8 - b2;
        byte b3 = bArr3[15 - i2] & UnsignedBytes.MAX_VALUE;
        int i4 = 0;
        while (i4 < 16) {
            byte b4 = bArr3[(i4 - i2) & 15] & UnsignedBytes.MAX_VALUE;
            bArr[i4] = (byte) (((b3 << i3) | (b4 >>> b2)) ^ (bArr2[i4] & UnsignedBytes.MAX_VALUE));
            i4++;
            b3 = b4;
        }
    }

    public static void m(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            int length = bArr.length;
            if (length < 16 || length > 32 || (length & 7) != 0) {
                throw new IllegalArgumentException("Key length not 128/192/256 bits.");
            }
            int i = (length >>> 3) - 2;
            byte[][] bArr2 = f5921b;
            byte[] bArr3 = bArr2[i];
            byte[] bArr4 = bArr2[(i + 1) % 3];
            byte[] bArr5 = bArr2[(i + 2) % 3];
            byte[] bArr6 = new byte[16];
            byte[] bArr7 = new byte[16];
            System.arraycopy(bArr, 0, bArr6, 0, 16);
            System.arraycopy(bArr, 16, bArr7, 0, length - 16);
            byte[] bArr8 = new byte[16];
            byte[] bArr9 = new byte[16];
            byte[] bArr10 = new byte[16];
            byte[] bArr11 = new byte[16];
            System.arraycopy(bArr6, 0, bArr8, 0, 16);
            System.arraycopy(bArr8, 0, bArr9, 0, 16);
            f(bArr9, bArr3);
            m(bArr9, bArr7);
            System.arraycopy(bArr9, 0, bArr10, 0, 16);
            m(bArr10, bArr4);
            k(bArr10);
            d(bArr10);
            m(bArr10, bArr8);
            System.arraycopy(bArr10, 0, bArr11, 0, 16);
            f(bArr11, bArr5);
            m(bArr11, bArr9);
            int i2 = (i * 2) + 12;
            int[] iArr = new int[2];
            iArr[1] = 16;
            iArr[0] = i2 + 1;
            byte[][] bArr12 = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
            l(19, bArr12[0], bArr8, bArr9);
            l(19, bArr12[1], bArr9, bArr10);
            l(19, bArr12[2], bArr10, bArr11);
            l(19, bArr12[3], bArr11, bArr8);
            l(31, bArr12[4], bArr8, bArr9);
            l(31, bArr12[5], bArr9, bArr10);
            l(31, bArr12[6], bArr10, bArr11);
            l(31, bArr12[7], bArr11, bArr8);
            l(67, bArr12[8], bArr8, bArr9);
            l(67, bArr12[9], bArr9, bArr10);
            l(67, bArr12[10], bArr10, bArr11);
            l(67, bArr12[11], bArr11, bArr8);
            l(97, bArr12[12], bArr8, bArr9);
            if (i2 > 12) {
                l(97, bArr12[13], bArr9, bArr10);
                l(97, bArr12[14], bArr10, bArr11);
                if (i2 > 14) {
                    l(97, bArr12[15], bArr11, bArr8);
                    l(109, bArr12[16], bArr8, bArr9);
                }
            }
            if (!z) {
                int length2 = bArr12.length;
                int i3 = length2 / 2;
                int i4 = length2 - 1;
                for (int i5 = 0; i5 < i3; i5++) {
                    byte[] bArr13 = bArr12[i5];
                    int i6 = i4 - i5;
                    bArr12[i5] = bArr12[i6];
                    bArr12[i6] = bArr13;
                }
                for (int i7 = 1; i7 < i2; i7++) {
                    d(bArr12[i7]);
                }
            }
            this.f5922a = bArr12;
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to ARIA init - "));
    }

    public final String b() {
        return "ARIA";
    }

    public final int c() {
        return 16;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        if (this.f5922a == null) {
            throw new IllegalStateException("ARIA engine not initialised");
        } else if (i > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 <= bArr2.length - 16) {
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr, i, bArr3, 0, 16);
            int length = this.f5922a.length - 3;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                f(bArr3, this.f5922a[i3]);
                m(bArr3, this.f5922a[i4]);
                k(bArr3);
                d(bArr3);
                i3 = i4 + 1;
            }
            int i5 = i3 + 1;
            f(bArr3, this.f5922a[i3]);
            m(bArr3, this.f5922a[i5]);
            k(bArr3);
            m(bArr3, this.f5922a[i5 + 1]);
            System.arraycopy(bArr3, 0, bArr2, i2, 16);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void reset() {
    }
}
