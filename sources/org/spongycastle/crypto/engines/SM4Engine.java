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
import org.spongycastle.util.Pack;

public class SM4Engine implements BlockCipher {
    public static final byte[] a = {-42, -112, -23, -2, -52, -31, 61, -73, Ascii.SYN, -74, Ascii.DC4, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, Ascii.VT, 67, -19, -49, -84, 98, -28, -77, Ascii.FS, -87, -55, 8, -24, -107, UnsignedBytes.MAX_POWER_OF_TWO, -33, -108, -6, 117, -113, 63, -90, 71, 7, -89, -4, -13, 115, Ascii.ETB, -70, -125, 89, 60, Ascii.EM, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, Ascii.SI, 75, 112, 86, -99, 53, Ascii.RS, 36, Ascii.SO, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, SignedBytes.MAX_POWER_OF_TWO, -57, 56, -75, -93, -9, -14, -50, -7, 97, Ascii.NAK, -95, -32, -82, 93, -92, -101, 52, Ascii.SUB, 85, -83, -109, 50, 48, -11, -116, -79, -29, Ascii.GS, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, Ascii.CR, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, Ascii.ESC, -81, -110, -69, -35, -68, Ascii.DEL, 17, -39, 92, 65, Ascii.US, Ascii.DLE, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, Ascii.DC2, -72, -27, -76, -80, -119, 105, -105, 74, Ascii.FF, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, Ascii.CAN, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};
    public static final int[] c = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};
    public static final int[] d = {-1548633402, 1453994832, 1736282519, -1301273892};

    /* renamed from: a  reason: collision with other field name */
    public final int[] f6044a = new int[4];
    public int[] b;

    public static int d(int i) {
        int g = g(i);
        return ((g >>> -24) | (g << 24)) ^ (((((g << 2) | (g >>> -2)) ^ g) ^ ((g << 10) | (g >>> -10))) ^ ((g << 18) | (g >>> -18)));
    }

    public static int f(int i) {
        int g = g(i);
        return ((g >>> -23) | (g << 23)) ^ (((g << 13) | (g >>> -13)) ^ g);
    }

    public static int g(int i) {
        byte[] bArr = a;
        return (bArr[i & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) | ((bArr[(i >> 24) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[(i >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[(i >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            if (bArr.length == 16) {
                int[] iArr = new int[32];
                int a2 = Pack.a(12, bArr);
                int[] iArr2 = {Pack.a(0, bArr), Pack.a(4, bArr), Pack.a(8, bArr), a2};
                int i = iArr2[0];
                int[] iArr3 = d;
                int i2 = i ^ iArr3[0];
                int i3 = iArr2[1] ^ iArr3[1];
                int i4 = iArr2[2] ^ iArr3[2];
                int i5 = a2 ^ iArr3[3];
                int[] iArr4 = {i2, i3, i4, i5};
                int[] iArr5 = c;
                if (z) {
                    int f = f(((i3 ^ i4) ^ i5) ^ iArr5[0]) ^ i2;
                    iArr[0] = f;
                    int f2 = f((f ^ (iArr4[2] ^ iArr4[3])) ^ iArr5[1]) ^ iArr4[1];
                    iArr[1] = f2;
                    int f3 = f((f2 ^ (iArr4[3] ^ iArr[0])) ^ iArr5[2]) ^ iArr4[2];
                    iArr[2] = f3;
                    iArr[3] = f((f3 ^ (iArr[0] ^ iArr[1])) ^ iArr5[3]) ^ iArr4[3];
                    for (int i6 = 4; i6 < 32; i6++) {
                        iArr[i6] = iArr[i6 - 4] ^ f(((iArr[i6 - 3] ^ iArr[i6 - 2]) ^ iArr[i6 - 1]) ^ iArr5[i6]);
                    }
                } else {
                    int f4 = f(((i3 ^ i4) ^ i5) ^ iArr5[0]) ^ i2;
                    iArr[31] = f4;
                    int f5 = f((f4 ^ (iArr4[2] ^ iArr4[3])) ^ iArr5[1]) ^ iArr4[1];
                    iArr[30] = f5;
                    int f6 = f((f5 ^ (iArr4[3] ^ iArr[31])) ^ iArr5[2]) ^ iArr4[2];
                    iArr[29] = f6;
                    iArr[28] = f((f6 ^ (iArr[31] ^ iArr[30])) ^ iArr5[3]) ^ iArr4[3];
                    for (int i7 = 27; i7 >= 0; i7--) {
                        iArr[i7] = iArr[i7 + 4] ^ f(((iArr[i7 + 3] ^ iArr[i7 + 2]) ^ iArr[i7 + 1]) ^ iArr5[31 - i7]);
                    }
                }
                this.b = iArr;
                return;
            }
            throw new IllegalArgumentException("SM4 requires a 128 bit key");
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to SM4 init - "));
    }

    public final String b() {
        return "SM4";
    }

    public final int c() {
        return 16;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        if (this.b == null) {
            throw new IllegalStateException("SM4 not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            int a2 = Pack.a(i, bArr);
            int[] iArr = this.f6044a;
            iArr[0] = a2;
            iArr[1] = Pack.a(i + 4, bArr);
            iArr[2] = Pack.a(i + 8, bArr);
            iArr[3] = Pack.a(i + 12, bArr);
            for (int i3 = 0; i3 < 32; i3 += 4) {
                int d2 = d(this.b[i3] ^ ((iArr[1] ^ iArr[2]) ^ iArr[3])) ^ iArr[0];
                iArr[0] = d2;
                int d3 = d((d2 ^ (iArr[2] ^ iArr[3])) ^ this.b[i3 + 1]) ^ iArr[1];
                iArr[1] = d3;
                int d4 = d((d3 ^ (iArr[3] ^ iArr[0])) ^ this.b[i3 + 2]) ^ iArr[2];
                iArr[2] = d4;
                iArr[3] = d((d4 ^ (iArr[0] ^ iArr[1])) ^ this.b[i3 + 3]) ^ iArr[3];
            }
            int i4 = iArr[0];
            int i5 = iArr[3];
            int i6 = i4 ^ i5;
            iArr[0] = i6;
            int i7 = i5 ^ i6;
            iArr[3] = i7;
            int i8 = i6 ^ i7;
            iArr[0] = i8;
            int i9 = iArr[1];
            int i10 = iArr[2];
            int i11 = i9 ^ i10;
            iArr[1] = i11;
            int i12 = i10 ^ i11;
            iArr[2] = i12;
            iArr[1] = i11 ^ i12;
            Pack.c(i8, bArr2, i2);
            Pack.c(iArr[1], bArr2, i2 + 4);
            Pack.c(iArr[2], bArr2, i2 + 8);
            Pack.c(iArr[3], bArr2, i2 + 12);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void reset() {
    }
}
