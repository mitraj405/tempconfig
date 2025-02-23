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

public class RijndaelEngine implements BlockCipher {
    public static final int[] a = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};

    /* renamed from: a  reason: collision with other field name */
    public static final byte[][] f6030a = {new byte[]{0, 8, Ascii.DLE, Ascii.CAN}, new byte[]{0, 8, Ascii.DLE, Ascii.CAN}, new byte[]{0, 8, Ascii.DLE, Ascii.CAN}, new byte[]{0, 8, Ascii.DLE, 32}, new byte[]{0, 8, Ascii.CAN, 32}};
    public static final byte[][] b = {new byte[]{0, Ascii.CAN, Ascii.DLE, 8}, new byte[]{0, 32, Ascii.CAN, Ascii.DLE}, new byte[]{0, 40, 32, Ascii.CAN}, new byte[]{0, 48, 40, Ascii.CAN}, new byte[]{0, 56, 40, 32}};
    public static final byte[] c = {0, 0, Ascii.EM, 1, 50, 2, Ascii.SUB, -58, 75, -57, Ascii.ESC, 104, 51, -18, -33, 3, 100, 4, -32, Ascii.SO, 52, -115, -127, -17, 76, 113, 8, -56, -8, 105, Ascii.FS, -63, 125, -62, Ascii.GS, -75, -7, -71, 39, 106, 77, -28, -90, 114, -102, -55, 9, 120, 101, 47, -118, 5, 33, Ascii.SI, -31, 36, Ascii.DC2, -16, -126, 69, 53, -109, -38, -114, -106, -113, -37, -67, 54, -48, -50, -108, 19, 92, -46, -15, SignedBytes.MAX_POWER_OF_TWO, 70, -125, 56, 102, -35, -3, 48, -65, 6, -117, 98, -77, 37, -30, -104, 34, -120, -111, Ascii.DLE, 126, 110, 72, -61, -93, -74, Ascii.RS, 66, 58, 107, 40, 84, -6, -123, 61, -70, 43, 121, 10, Ascii.NAK, -101, -97, 94, -54, 78, -44, -84, -27, -13, 115, -89, 87, -81, 88, -88, 80, -12, -22, -42, 116, 79, -82, -23, -43, -25, -26, -83, -24, 44, -41, 117, 122, -21, Ascii.SYN, Ascii.VT, -11, 89, -53, 95, -80, -100, -87, 81, -96, Ascii.DEL, Ascii.FF, -10, 111, Ascii.ETB, -60, 73, -20, -40, 67, Ascii.US, 45, -92, 118, 123, -73, -52, -69, 62, 90, -5, 96, -79, -122, 59, 82, -95, 108, -86, 85, 41, -99, -105, -78, -121, -112, 97, -66, -36, -4, -68, -107, -49, -51, 55, 63, 91, -47, 83, 57, -124, 60, 65, -94, 109, 71, Ascii.DC4, 42, -98, 93, 86, -14, -45, -85, 68, 17, -110, -39, 35, 32, 46, -119, -76, 124, -72, 38, 119, -103, -29, -91, 103, 74, -19, -34, -59, 49, -2, Ascii.CAN, Ascii.CR, 99, -116, UnsignedBytes.MAX_POWER_OF_TWO, -64, -9, 112, 7};
    public static final byte[] d = {0, 3, 5, Ascii.SI, 17, 51, 85, -1, Ascii.SUB, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, Ascii.RS, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, Ascii.FF, Ascii.DC4, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, Ascii.CAN, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, Ascii.DEL, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, Ascii.DLE, 48, 80, -16, Ascii.VT, Ascii.GS, 39, 105, -69, -42, 97, -93, -2, Ascii.EM, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, Ascii.SYN, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, Ascii.NAK, 63, 65, -61, 94, -30, 61, 71, -55, SignedBytes.MAX_POWER_OF_TWO, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, -68, -33, 122, -114, -119, UnsignedBytes.MAX_POWER_OF_TWO, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, Ascii.US, 33, 99, -91, -12, 7, 9, Ascii.ESC, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, Ascii.SO, Ascii.DC2, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, Ascii.CR, Ascii.ETB, 57, 75, -35, 124, -124, -105, -94, -3, Ascii.FS, 36, 108, -76, -57, 82, -10, 1, 3, 5, Ascii.SI, 17, 51, 85, -1, Ascii.SUB, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, Ascii.RS, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, Ascii.FF, Ascii.DC4, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, Ascii.CAN, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, Ascii.DEL, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, Ascii.DLE, 48, 80, -16, Ascii.VT, Ascii.GS, 39, 105, -69, -42, 97, -93, -2, Ascii.EM, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, Ascii.SYN, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, Ascii.NAK, 63, 65, -61, 94, -30, 61, 71, -55, SignedBytes.MAX_POWER_OF_TWO, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, -68, -33, 122, -114, -119, UnsignedBytes.MAX_POWER_OF_TWO, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, Ascii.US, 33, 99, -91, -12, 7, 9, Ascii.ESC, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, Ascii.SO, Ascii.DC2, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, Ascii.CR, Ascii.ETB, 57, 75, -35, 124, -124, -105, -94, -3, Ascii.FS, 36, 108, -76, -57, 82, -10, 1};
    public static final byte[] e = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, Ascii.NAK, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, Ascii.DC2, UnsignedBytes.MAX_POWER_OF_TWO, -30, -21, 39, -78, 117, 9, -125, 44, Ascii.SUB, Ascii.ESC, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Ascii.DEL, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, -68, -74, -38, 33, Ascii.DLE, -1, -13, -46, -51, Ascii.FF, 19, -20, 95, -105, 68, Ascii.ETB, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, Ascii.DC4, -34, 94, Ascii.VT, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, Ascii.FS, -90, -76, -58, -24, -35, 116, Ascii.US, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, Ascii.SO, 97, 53, 87, -71, -122, -63, Ascii.GS, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, Ascii.RS, -121, -23, -50, 85, 40, -33, -116, -95, -119, Ascii.CR, -65, -26, 66, 104, 65, -103, 45, Ascii.SI, -80, 84, -69, Ascii.SYN};
    public static final byte[] f = {82, 9, 106, -43, 48, 54, -91, 56, -65, SignedBytes.MAX_POWER_OF_TWO, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, Ascii.VT, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, Ascii.SYN, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, Ascii.NAK, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, -68, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, Ascii.RS, -113, -54, 63, Ascii.SI, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, Ascii.FS, 117, -33, 110, 71, -15, Ascii.SUB, 113, Ascii.GS, 41, -59, -119, 111, -73, 98, Ascii.SO, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, Ascii.US, -35, -88, 51, -120, 7, -57, 49, -79, Ascii.DC2, Ascii.DLE, 89, 39, UnsignedBytes.MAX_POWER_OF_TWO, -20, 95, 96, 81, Ascii.DEL, -87, Ascii.EM, -75, 74, Ascii.CR, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, Ascii.ETB, 43, 4, 126, -70, 119, -42, 38, -31, 105, Ascii.DC4, 99, 85, 33, Ascii.FF, 125};

    /* renamed from: a  reason: collision with other field name */
    public final int f6031a = 32;

    /* renamed from: a  reason: collision with other field name */
    public final long f6032a = 4294967295L;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6033a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6034a;

    /* renamed from: a  reason: collision with other field name */
    public long[][] f6035a;

    /* renamed from: b  reason: collision with other field name */
    public int f6036b;

    /* renamed from: b  reason: collision with other field name */
    public long f6037b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6038b;

    /* renamed from: c  reason: collision with other field name */
    public final int f6039c;

    /* renamed from: c  reason: collision with other field name */
    public long f6040c;

    /* renamed from: d  reason: collision with other field name */
    public long f6041d;

    /* renamed from: e  reason: collision with other field name */
    public long f6042e;

    public RijndaelEngine() {
        byte[][] bArr = b;
        byte[][] bArr2 = f6030a;
        this.f6034a = bArr2[0];
        this.f6038b = bArr[0];
        this.f6039c = 128;
    }

    public static byte i(int i) {
        if (i != 0) {
            return d[(c[i] & UnsignedBytes.MAX_VALUE) + Ascii.EM];
        }
        return 0;
    }

    public static byte j(int i) {
        if (i != 0) {
            return d[(c[i] & UnsignedBytes.MAX_VALUE) + 1];
        }
        return 0;
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        int i;
        byte[] bArr;
        CipherParameters cipherParameters2 = cipherParameters;
        if (cipherParameters2 instanceof KeyParameter) {
            byte[] bArr2 = ((KeyParameter) cipherParameters2).a;
            int i2 = 8;
            int length = bArr2.length * 8;
            byte[][] bArr3 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{4, 64});
            long[][] jArr = (long[][]) Array.newInstance(Long.TYPE, new int[]{15, 4});
            int i3 = 6;
            if (length == 128) {
                i2 = 4;
            } else if (length == 160) {
                i2 = 5;
            } else if (length == 192) {
                i2 = 6;
            } else if (length == 224) {
                i2 = 7;
            } else if (length != 256) {
                throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
            }
            int i4 = this.f6039c;
            int i5 = this.f6031a;
            if (length >= i4) {
                this.f6036b = i2 + 6;
            } else {
                this.f6036b = (i5 / 8) + 6;
            }
            int i6 = 0;
            int i7 = 0;
            while (i6 < bArr2.length) {
                bArr3[i6 % 4][i6 / 4] = bArr2[i7];
                i6++;
                i7++;
            }
            int i8 = 0;
            int i9 = 0;
            while (true) {
                i = 1;
                if (i8 >= i2) {
                    break;
                }
                int i10 = i5 / 8;
                if (i9 >= (this.f6036b + 1) * i10) {
                    break;
                }
                for (int i11 = 0; i11 < 4; i11++) {
                    long[] jArr2 = jArr[i9 / i10];
                    jArr2[i11] = jArr2[i11] | (((long) (bArr3[i11][i8] & UnsignedBytes.MAX_VALUE)) << ((i9 * 8) % i5));
                }
                i8++;
                i9++;
            }
            int i12 = 0;
            while (true) {
                int i13 = i5 / 8;
                if (i9 < (this.f6036b + i) * i13) {
                    int i14 = 0;
                    while (true) {
                        bArr = e;
                        if (i14 >= 4) {
                            break;
                        }
                        byte[] bArr4 = bArr3[i14];
                        i14++;
                        bArr4[0] = (byte) (bArr[bArr3[i14 % 4][i2 - 1] & UnsignedBytes.MAX_VALUE] ^ bArr4[0]);
                    }
                    byte[] bArr5 = bArr3[0];
                    int i15 = i12 + 1;
                    bArr5[0] = (byte) (a[i12] ^ bArr5[0]);
                    if (i2 <= i3) {
                        for (int i16 = i; i16 < i2; i16++) {
                            for (int i17 = 0; i17 < 4; i17++) {
                                byte[] bArr6 = bArr3[i17];
                                bArr6[i16] = (byte) (bArr6[i16] ^ bArr6[i16 - 1]);
                            }
                        }
                    } else {
                        for (int i18 = i; i18 < 4; i18++) {
                            for (int i19 = 0; i19 < 4; i19++) {
                                byte[] bArr7 = bArr3[i19];
                                bArr7[i18] = (byte) (bArr7[i18] ^ bArr7[i18 - 1]);
                            }
                        }
                        for (int i20 = 0; i20 < 4; i20++) {
                            byte[] bArr8 = bArr3[i20];
                            bArr8[4] = (byte) (bArr8[4] ^ bArr[bArr8[3] & UnsignedBytes.MAX_VALUE]);
                        }
                        for (int i21 = 5; i21 < i2; i21++) {
                            for (int i22 = 0; i22 < 4; i22++) {
                                byte[] bArr9 = bArr3[i22];
                                bArr9[i21] = (byte) (bArr9[i21] ^ bArr9[i21 - 1]);
                            }
                        }
                    }
                    int i23 = 0;
                    while (i23 < i2 && i9 < (this.f6036b + i) * i13) {
                        for (int i24 = 0; i24 < 4; i24++) {
                            long[] jArr3 = jArr[i9 / i13];
                            jArr3[i24] = jArr3[i24] | (((long) (bArr3[i24][i23] & UnsignedBytes.MAX_VALUE)) << ((i9 * 8) % i5));
                        }
                        i23++;
                        i9++;
                        i = 1;
                    }
                    i3 = 6;
                    i = 1;
                    i12 = i15;
                } else {
                    this.f6035a = jArr;
                    this.f6033a = z;
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException(xx.H(cipherParameters2, "invalid parameter passed to Rijndael init - "));
        }
    }

    public final String b() {
        return "Rijndael";
    }

    public final int c() {
        return this.f6031a / 2;
    }

    public final void d(long[] jArr) {
        this.f6037b ^= jArr[0];
        this.f6040c ^= jArr[1];
        this.f6041d ^= jArr[2];
        this.f6042e ^= jArr[3];
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        long[][] jArr;
        byte b6;
        byte b7;
        byte[] bArr3;
        byte b8;
        byte b9;
        byte b10;
        byte b11;
        byte b12;
        byte b13;
        byte b14;
        byte b15;
        byte b16;
        byte b17;
        byte b18;
        byte b19;
        byte b20;
        byte b21;
        int i3 = i;
        int i4 = i2;
        byte[] bArr4 = bArr;
        byte[] bArr5 = bArr2;
        if (this.f6035a != null) {
            int i5 = this.f6031a;
            int i6 = i5 / 2;
            if (i6 + i3 > bArr4.length) {
                throw new DataLengthException("input buffer too short");
            } else if (i6 + i4 <= bArr5.length) {
                long j = 255;
                int i7 = 0;
                if (this.f6033a) {
                    l(i3, bArr4);
                    long[][] jArr2 = this.f6035a;
                    d(jArr2[0]);
                    int i8 = 1;
                    while (true) {
                        int i9 = this.f6036b;
                        byte[] bArr6 = e;
                        byte[] bArr7 = this.f6034a;
                        if (i8 < i9) {
                            g(bArr6);
                            f(bArr7);
                            int i10 = i7;
                            long j2 = 0;
                            long j3 = 0;
                            long j4 = 0;
                            long j5 = 0;
                            while (i10 < i5) {
                                int i11 = (int) ((this.f6037b >> i10) & j);
                                int i12 = i5;
                                int i13 = i6;
                                int i14 = (int) ((this.f6040c >> i10) & j);
                                long[][] jArr3 = jArr2;
                                int i15 = (int) ((this.f6041d >> i10) & j);
                                int i16 = (int) ((this.f6042e >> i10) & j);
                                j2 |= ((long) ((((i(i11) ^ j(i14)) ^ i15) ^ i16) & UnsignedBytes.MAX_VALUE)) << i10;
                                j3 |= ((long) ((((i(i14) ^ j(i15)) ^ i16) ^ i11) & UnsignedBytes.MAX_VALUE)) << i10;
                                j4 |= ((long) ((((i(i15) ^ j(i16)) ^ i11) ^ i14) & UnsignedBytes.MAX_VALUE)) << i10;
                                j5 = (((long) ((i15 ^ ((i(i16) ^ j(i11)) ^ i14)) & UnsignedBytes.MAX_VALUE)) << i10) | j5;
                                i10 += 8;
                                i8 = i8;
                                int i17 = i2;
                                jArr2 = jArr3;
                                i5 = i12;
                                i6 = i13;
                                j = 255;
                            }
                            int i18 = i8;
                            int i19 = i5;
                            int i20 = i6;
                            long[][] jArr4 = jArr2;
                            this.f6037b = j2;
                            this.f6040c = j3;
                            this.f6041d = j4;
                            this.f6042e = j5;
                            d(jArr4[i18]);
                            i8 = i18 + 1;
                            int i21 = i2;
                            jArr2 = jArr4;
                            i6 = i20;
                            j = 255;
                            i7 = 0;
                        } else {
                            int i22 = i6;
                            g(bArr6);
                            f(bArr7);
                            d(jArr2[this.f6036b]);
                            k(i2, bArr5);
                            return i22;
                        }
                    }
                } else {
                    int i23 = i5;
                    int i24 = i6;
                    l(i3, bArr4);
                    long[][] jArr5 = this.f6035a;
                    d(jArr5[this.f6036b]);
                    byte[] bArr8 = f;
                    g(bArr8);
                    byte[] bArr9 = this.f6038b;
                    f(bArr9);
                    int i25 = this.f6036b - 1;
                    while (i25 > 0) {
                        d(jArr5[i25]);
                        int i26 = i23;
                        int i27 = 0;
                        long j6 = 0;
                        long j7 = 0;
                        long j8 = 0;
                        long[][] jArr6 = jArr5;
                        long j9 = 0;
                        while (i27 < i26) {
                            int i28 = i25;
                            int i29 = i26;
                            int i30 = (int) ((this.f6037b >> i27) & 255);
                            byte[] bArr10 = bArr9;
                            int i31 = (int) ((this.f6040c >> i27) & 255);
                            long j10 = j9;
                            int i32 = (int) ((this.f6041d >> i27) & 255);
                            byte[] bArr11 = bArr8;
                            int i33 = (int) ((this.f6042e >> i27) & 255);
                            byte[] bArr12 = c;
                            if (i30 != 0) {
                                b2 = bArr12[i30 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE;
                            } else {
                                b2 = -1;
                            }
                            if (i31 != 0) {
                                b3 = bArr12[i31 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE;
                            } else {
                                b3 = -1;
                            }
                            if (i32 != 0) {
                                b4 = bArr12[i32 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE;
                            } else {
                                b4 = -1;
                            }
                            if (i33 != 0) {
                                b5 = bArr12[i33 & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE;
                            } else {
                                b5 = -1;
                            }
                            byte[] bArr13 = d;
                            if (b2 >= 0) {
                                jArr = jArr6;
                                b6 = bArr13[b2 + 223];
                            } else {
                                jArr = jArr6;
                                b6 = 0;
                            }
                            if (b3 >= 0) {
                                b7 = bArr13[b3 + 104];
                            } else {
                                b7 = 0;
                            }
                            byte b22 = b6 ^ b7;
                            if (b4 >= 0) {
                                bArr3 = bArr10;
                                b8 = bArr13[b4 + 238];
                            } else {
                                bArr3 = bArr10;
                                b8 = 0;
                            }
                            byte b23 = b8 ^ b22;
                            if (b5 >= 0) {
                                b9 = bArr13[b5 + 199];
                            } else {
                                b9 = 0;
                            }
                            long j11 = j7;
                            j8 |= ((long) ((b23 ^ b9) & UnsignedBytes.MAX_VALUE)) << i27;
                            if (b3 >= 0) {
                                b10 = bArr13[b3 + 223];
                            } else {
                                b10 = 0;
                            }
                            if (b4 >= 0) {
                                b11 = bArr13[b4 + 104];
                            } else {
                                b11 = 0;
                            }
                            byte b24 = b10 ^ b11;
                            if (b5 >= 0) {
                                b12 = bArr13[b5 + 238];
                            } else {
                                b12 = 0;
                            }
                            byte b25 = b24 ^ b12;
                            if (b2 >= 0) {
                                b13 = bArr13[b2 + 199];
                            } else {
                                b13 = 0;
                            }
                            j6 |= ((long) ((b25 ^ b13) & UnsignedBytes.MAX_VALUE)) << i27;
                            if (b4 >= 0) {
                                b14 = bArr13[b4 + 223];
                            } else {
                                b14 = 0;
                            }
                            if (b5 >= 0) {
                                b15 = bArr13[b5 + 104];
                            } else {
                                b15 = 0;
                            }
                            byte b26 = b14 ^ b15;
                            if (b2 >= 0) {
                                b16 = bArr13[b2 + 238];
                            } else {
                                b16 = 0;
                            }
                            byte b27 = b26 ^ b16;
                            if (b3 >= 0) {
                                b17 = bArr13[b3 + 199];
                            } else {
                                b17 = 0;
                            }
                            j7 = j11 | (((long) ((b27 ^ b17) & UnsignedBytes.MAX_VALUE)) << i27);
                            if (b5 >= 0) {
                                b18 = bArr13[b5 + 223];
                            } else {
                                b18 = 0;
                            }
                            if (b2 >= 0) {
                                b19 = bArr13[b2 + 104];
                            } else {
                                b19 = 0;
                            }
                            byte b28 = b18 ^ b19;
                            if (b3 >= 0) {
                                b20 = bArr13[b3 + 238];
                            } else {
                                b20 = 0;
                            }
                            byte b29 = b28 ^ b20;
                            if (b4 >= 0) {
                                b21 = bArr13[b4 + 199];
                            } else {
                                b21 = 0;
                            }
                            j9 = j10 | (((long) ((b21 ^ b29) & UnsignedBytes.MAX_VALUE)) << i27);
                            i27 += 8;
                            i25 = i28;
                            byte[] bArr14 = bArr2;
                            bArr8 = bArr11;
                            i26 = i29;
                            jArr6 = jArr;
                            bArr9 = bArr3;
                        }
                        long j12 = j9;
                        long j13 = j7;
                        long[][] jArr7 = jArr6;
                        this.f6037b = j8;
                        this.f6040c = j6;
                        this.f6041d = j7;
                        this.f6042e = j9;
                        g(bArr8);
                        byte[] bArr15 = bArr9;
                        f(bArr15);
                        i25--;
                        int i34 = i2;
                        byte[] bArr16 = bArr2;
                        i23 = i26;
                        bArr9 = bArr15;
                        jArr5 = jArr7;
                    }
                    d(jArr5[0]);
                    k(i2, bArr2);
                    return i24;
                }
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            throw new IllegalStateException("Rijndael engine not initialised");
        }
    }

    public final void f(byte[] bArr) {
        long j = this.f6040c;
        byte b2 = bArr[1];
        long j2 = j >>> b2;
        int i = this.f6031a;
        long j3 = this.f6032a;
        this.f6040c = ((j << (i - b2)) | j2) & j3;
        long j4 = this.f6041d;
        byte b3 = bArr[2];
        this.f6041d = ((j4 << (i - b3)) | (j4 >>> b3)) & j3;
        long j5 = this.f6042e;
        byte b4 = bArr[3];
        this.f6042e = ((j5 << (i - b4)) | (j5 >>> b4)) & j3;
    }

    public final void g(byte[] bArr) {
        this.f6037b = h(bArr, this.f6037b);
        this.f6040c = h(bArr, this.f6040c);
        this.f6041d = h(bArr, this.f6041d);
        this.f6042e = h(bArr, this.f6042e);
    }

    public final long h(byte[] bArr, long j) {
        long j2 = 0;
        for (int i = 0; i < this.f6031a; i += 8) {
            j2 |= ((long) (bArr[(int) ((j >> i) & 255)] & UnsignedBytes.MAX_VALUE)) << i;
        }
        return j2;
    }

    public final void k(int i, byte[] bArr) {
        for (int i2 = 0; i2 != this.f6031a; i2 += 8) {
            int i3 = i + 1;
            bArr[i] = (byte) ((int) (this.f6037b >> i2));
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((int) (this.f6040c >> i2));
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((int) (this.f6041d >> i2));
            i = i5 + 1;
            bArr[i5] = (byte) ((int) (this.f6042e >> i2));
        }
    }

    public final void l(int i, byte[] bArr) {
        int i2 = i + 1;
        this.f6037b = (long) (bArr[i] & UnsignedBytes.MAX_VALUE);
        int i3 = i2 + 1;
        this.f6040c = (long) (bArr[i2] & UnsignedBytes.MAX_VALUE);
        int i4 = i3 + 1;
        this.f6041d = (long) (bArr[i3] & UnsignedBytes.MAX_VALUE);
        int i5 = i4 + 1;
        this.f6042e = (long) (bArr[i4] & UnsignedBytes.MAX_VALUE);
        for (int i6 = 8; i6 != this.f6031a; i6 += 8) {
            int i7 = i5 + 1;
            this.f6037b |= ((long) (bArr[i5] & UnsignedBytes.MAX_VALUE)) << i6;
            int i8 = i7 + 1;
            this.f6040c |= ((long) (bArr[i7] & UnsignedBytes.MAX_VALUE)) << i6;
            int i9 = i8 + 1;
            this.f6041d |= ((long) (bArr[i8] & UnsignedBytes.MAX_VALUE)) << i6;
            i5 = i9 + 1;
            this.f6042e |= ((long) (bArr[i9] & UnsignedBytes.MAX_VALUE)) << i6;
        }
    }

    public final void reset() {
    }
}
