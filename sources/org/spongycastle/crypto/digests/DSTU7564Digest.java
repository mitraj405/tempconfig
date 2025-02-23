package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class DSTU7564Digest implements ExtendedDigest, Memoable {
    public static final byte[][] d = {new byte[]{1, 1, 5, 1, 8, 6, 7, 4}, new byte[]{4, 1, 1, 5, 1, 8, 6, 7}, new byte[]{7, 4, 1, 1, 5, 1, 8, 6}, new byte[]{6, 7, 4, 1, 1, 5, 1, 8}, new byte[]{8, 6, 7, 4, 1, 1, 5, 1}, new byte[]{1, 8, 6, 7, 4, 1, 1, 5}, new byte[]{5, 1, 8, 6, 7, 4, 1, 1}, new byte[]{1, 5, 1, 8, 6, 7, 4, 1}};
    public static final byte[][] e = {new byte[]{-88, 67, 95, 6, 107, 117, 108, 89, 113, -33, -121, -107, Ascii.ETB, -16, -40, 9, 109, -13, Ascii.GS, -53, -55, 77, 44, -81, 121, -32, -105, -3, 111, 75, 69, 57, 62, -35, -93, 79, -76, -74, -102, Ascii.SO, Ascii.US, -65, Ascii.NAK, -31, 73, -46, -109, -58, -110, 114, -98, 97, -47, 99, -6, -18, -12, Ascii.EM, -43, -83, 88, -92, -69, -95, -36, -14, -125, 55, 66, -28, 122, 50, -100, -52, -85, 74, -113, 110, 4, 39, 46, -25, -30, 90, -106, Ascii.SYN, 35, 43, -62, 101, 102, Ascii.SI, -68, -87, 71, 65, 52, 72, -4, -73, 106, -120, -91, 83, -122, -7, 91, -37, 56, 123, -61, Ascii.RS, 34, 51, 36, 40, 54, -57, -78, 59, -114, 119, -70, -11, Ascii.DC4, -97, 8, 85, -101, 76, -2, 96, 92, -38, Ascii.CAN, 70, -51, 125, 33, -80, 63, Ascii.ESC, -119, -1, -21, -124, 105, 58, -99, -41, -45, 112, 103, SignedBytes.MAX_POWER_OF_TWO, -75, -34, 93, 48, -111, -79, 120, 17, 1, -27, 0, 104, -104, -96, -59, 2, -90, 116, 45, Ascii.VT, -94, 118, -77, -66, -50, -67, -82, -23, -118, 49, Ascii.FS, -20, -15, -103, -108, -86, -10, 38, 47, -17, -24, -116, 53, 3, -44, Ascii.DEL, -5, 5, -63, 94, -112, 32, 61, -126, -9, -22, 10, Ascii.CR, 126, -8, 80, Ascii.SUB, -60, 7, 87, -72, 60, 98, -29, -56, -84, 82, 100, Ascii.DLE, -48, -39, 19, Ascii.FF, Ascii.DC2, 41, 81, -71, -49, -42, 115, -115, -127, 84, -64, -19, 78, 68, -89, 42, -123, 37, -26, -54, 124, -117, 86, UnsignedBytes.MAX_POWER_OF_TWO}, new byte[]{-50, -69, -21, -110, -22, -53, 19, -63, -23, 58, -42, -78, -46, -112, Ascii.ETB, -8, 66, Ascii.NAK, 86, -76, 101, Ascii.FS, -120, 67, -59, 92, 54, -70, -11, 87, 103, -115, 49, -10, 100, 88, -98, -12, 34, -86, 117, Ascii.SI, 2, -79, -33, 109, 115, 77, 124, 38, 46, -9, 8, 93, 68, 62, -97, Ascii.DC4, -56, -82, 84, Ascii.DLE, -40, -68, Ascii.SUB, 107, 105, -13, -67, 51, -85, -6, -47, -101, 104, 78, Ascii.SYN, -107, -111, -18, 76, 99, -114, 91, -52, 60, Ascii.EM, -95, -127, 73, 123, -39, 111, 55, 96, -54, -25, 43, 72, -3, -106, 69, -4, 65, Ascii.DC2, Ascii.CR, 121, -27, -119, -116, -29, 32, 48, -36, -73, 108, 74, -75, 63, -105, -44, 98, 45, 6, -92, -91, -125, 95, 42, -38, -55, 0, 126, -94, 85, -65, 17, -43, -100, -49, Ascii.SO, 10, 61, 81, 125, -109, Ascii.ESC, -2, -60, 71, 9, -122, Ascii.VT, -113, -99, 106, 7, -71, -80, -104, Ascii.CAN, 50, 113, 75, -17, 59, 112, -96, -28, SignedBytes.MAX_POWER_OF_TWO, -1, -61, -87, -26, 120, -7, -117, 70, UnsignedBytes.MAX_POWER_OF_TWO, Ascii.RS, 56, -31, -72, -88, -32, Ascii.FF, 35, 118, Ascii.GS, 37, 36, 5, -15, 110, -108, 40, -102, -124, -24, -93, 79, 119, -45, -123, -30, 82, -14, -126, 80, 122, 47, 116, 83, -77, 97, -81, 57, 53, -34, -51, Ascii.US, -103, -84, -83, 114, 44, -35, -48, -121, -66, 94, -90, -20, 4, -58, 3, 52, -5, -37, 89, -74, -62, 1, -16, 90, -19, -89, 102, 33, Ascii.DEL, -118, 39, -57, -64, 41, -41}, new byte[]{-109, -39, -102, -75, -104, 34, 69, -4, -70, 106, -33, 2, -97, -36, 81, 89, 74, Ascii.ETB, 43, -62, -108, -12, -69, -93, 98, -28, 113, -44, -51, 112, Ascii.SYN, -31, 73, 60, -64, -40, 92, -101, -83, -123, 83, -95, 122, -56, 45, -32, -47, 114, -90, 44, -60, -29, 118, 120, -73, -76, 9, 59, Ascii.SO, 65, 76, -34, -78, -112, 37, -91, -41, 3, 17, 0, -61, 46, -110, -17, 78, Ascii.DC2, -99, 125, -53, 53, Ascii.DLE, -43, 79, -98, 77, -87, 85, -58, -48, 123, Ascii.CAN, -105, -45, 54, -26, 72, 86, -127, -113, 119, -52, -100, -71, -30, -84, -72, 47, Ascii.NAK, -92, 124, -38, 56, Ascii.RS, Ascii.VT, 5, -42, Ascii.DC4, 110, 108, 126, 102, -3, -79, -27, 96, -81, 94, 51, -121, -55, -16, 93, 109, 63, -120, -115, -57, -9, Ascii.GS, -23, -20, -19, UnsignedBytes.MAX_POWER_OF_TWO, 41, 39, -49, -103, -88, 80, Ascii.SI, 55, 36, 40, 48, -107, -46, 62, 91, SignedBytes.MAX_POWER_OF_TWO, -125, -77, 105, 87, Ascii.US, 7, Ascii.FS, -118, -68, 32, -21, -50, -114, -85, -18, 49, -94, 115, -7, -54, 58, Ascii.SUB, -5, Ascii.CR, -63, -2, -6, -14, 111, -67, -106, -35, 67, 82, -74, 8, -13, -82, -66, Ascii.EM, -119, 50, 38, -80, -22, 75, 100, -124, -126, 107, -11, 121, -65, 1, 95, 117, 99, Ascii.ESC, 35, 61, 104, 42, 101, -24, -111, -10, -1, 19, 88, -15, 71, 10, Ascii.DEL, -59, -89, -25, 97, 90, 6, 70, 68, 66, 4, -96, -37, 57, -122, 84, -86, -116, 52, 33, -117, -8, Ascii.FF, 116, 103}, new byte[]{104, -115, -54, 77, 115, 75, 78, 42, -44, 82, 38, -77, 84, Ascii.RS, Ascii.EM, Ascii.US, 34, 3, 70, 61, 45, 74, 83, -125, 19, -118, -73, -43, 37, 121, -11, -67, 88, 47, Ascii.CR, 2, -19, 81, -98, 17, -14, 62, 85, 94, -47, Ascii.SYN, 60, 102, 112, 93, -13, 69, SignedBytes.MAX_POWER_OF_TWO, -52, -24, -108, 86, 8, -50, Ascii.SUB, 58, -46, -31, -33, -75, 56, 110, Ascii.SO, -27, -12, -7, -122, -23, 79, -42, -123, 35, -49, 50, -103, 49, Ascii.DC4, -82, -18, -56, 72, -45, 48, -95, -110, 65, -79, Ascii.CAN, -60, 44, 113, 114, 68, Ascii.NAK, -3, 55, -66, 95, -86, -101, -120, -40, -85, -119, -100, -6, 96, -22, -68, 98, Ascii.FF, 36, -90, -88, -20, 103, 32, -37, 124, 40, -35, -84, 91, 52, 126, Ascii.DLE, -15, 123, -113, 99, -96, 5, -102, 67, 119, 33, -65, 39, 9, -61, -97, -74, -41, 41, -62, -21, -64, -92, -117, -116, Ascii.GS, -5, -1, -63, -78, -105, 46, -8, 101, -10, 117, 7, 4, 73, 51, -28, -39, -71, -48, 66, -57, 108, -112, 0, -114, 111, 80, 1, -59, -38, 71, 63, -51, 105, -94, -30, 122, -89, -58, -109, Ascii.SI, 10, 6, -26, 43, -106, -93, Ascii.FS, -81, 106, Ascii.DC2, -124, 57, -25, -80, -126, -9, -2, -99, -121, 92, -127, 53, -34, -76, -91, -4, UnsignedBytes.MAX_POWER_OF_TWO, -17, -53, -69, 107, 118, -70, 90, 125, 120, Ascii.VT, -107, -29, -83, 116, -104, 59, 54, 100, 109, -36, -16, 89, -87, 76, Ascii.ETB, Ascii.DEL, -111, -72, -55, 87, Ascii.ESC, -32, 97}};
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f5822a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5823a;

    /* renamed from: a  reason: collision with other field name */
    public long[] f5824a;

    /* renamed from: a  reason: collision with other field name */
    public byte[][] f5825a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f5826b;

    /* renamed from: b  reason: collision with other field name */
    public byte[][] f5827b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f5828c;

    /* renamed from: c  reason: collision with other field name */
    public byte[][] f5829c;

    /* renamed from: d  reason: collision with other field name */
    public int f5830d;

    /* renamed from: d  reason: collision with other field name */
    public byte[] f5831d;

    /* renamed from: e  reason: collision with other field name */
    public int f5832e;

    public DSTU7564Digest(DSTU7564Digest dSTU7564Digest) {
        i(dSTU7564Digest);
    }

    public static byte j(byte b2, byte b3) {
        byte b4 = 0;
        for (int i = 0; i < 8; i++) {
            if ((b3 & 1) == 1) {
                b4 = (byte) (b4 ^ b2);
            }
            byte b5 = (byte) (b2 & UnsignedBytes.MAX_POWER_OF_TWO);
            b2 = (byte) (b2 << 1);
            if (b5 == Byte.MIN_VALUE) {
                b2 = (byte) (b2 ^ Ascii.GS);
            }
            b3 = (byte) (b3 >> 1);
        }
        return b4;
    }

    public final Memoable a() {
        return new DSTU7564Digest(this);
    }

    public final String b() {
        return "DSTU7564";
    }

    public final int c(int i, byte[] bArr) {
        byte[] bArr2;
        byte[] bArr3 = this.f5831d;
        int i2 = this.f5832e;
        int i3 = this.b;
        if (i3 - i2 < 13) {
            bArr2 = new byte[(i3 * 2)];
        } else {
            bArr2 = new byte[i3];
        }
        System.arraycopy(bArr3, 0, bArr2, 0, i2);
        bArr2[i2] = UnsignedBytes.MAX_POWER_OF_TWO;
        Pack.l(this.f5822a * 8, bArr2, bArr2.length - 12);
        this.f5823a = bArr2;
        int length = bArr2.length;
        int i4 = 0;
        while (length != 0) {
            k(i4, this.f5823a);
            int i5 = this.b;
            i4 += i5;
            length -= i5;
        }
        byte[][] bArr4 = new byte[128][];
        int i6 = 0;
        while (true) {
            byte[][] bArr5 = this.f5825a;
            if (i6 >= bArr5.length) {
                break;
            }
            byte[] bArr6 = new byte[8];
            bArr4[i6] = bArr6;
            System.arraycopy(bArr5[i6], 0, bArr6, 0, 8);
            i6++;
        }
        for (int i7 = 0; i7 < this.f5830d; i7++) {
            for (int i8 = 0; i8 < this.c; i8++) {
                byte[] bArr7 = bArr4[i8];
                bArr7[0] = (byte) (bArr7[0] ^ ((byte) ((i8 * 16) ^ i7)));
            }
            for (int i9 = 0; i9 < 8; i9++) {
                for (int i10 = 0; i10 < this.c; i10++) {
                    byte[] bArr8 = bArr4[i10];
                    bArr8[i9] = e[i9 % 4][bArr8[i9] & UnsignedBytes.MAX_VALUE];
                }
            }
            int i11 = -1;
            for (int i12 = 0; i12 < 8; i12++) {
                if (i12 == 7 && this.c == 16) {
                    i11 = 11;
                } else {
                    i11++;
                }
                int i13 = 0;
                while (true) {
                    int i14 = this.c;
                    if (i13 >= i14) {
                        break;
                    }
                    this.f5826b[(i13 + i11) % i14] = bArr4[i13][i12];
                    i13++;
                }
                for (int i15 = 0; i15 < this.c; i15++) {
                    bArr4[i15][i12] = this.f5826b[i15];
                }
            }
            for (int i16 = 0; i16 < this.c; i16++) {
                Arrays.p(this.f5828c, (byte) 0);
                for (int i17 = 7; i17 >= 0; i17--) {
                    byte b2 = 0;
                    for (int i18 = 7; i18 >= 0; i18--) {
                        b2 = (byte) (b2 ^ j(bArr4[i16][i18], d[i17][i18]));
                    }
                    this.f5828c[i17] = b2;
                }
                for (int i19 = 0; i19 < 8; i19++) {
                    bArr4[i16][i19] = this.f5828c[i19];
                }
            }
        }
        for (int i20 = 0; i20 < 8; i20++) {
            for (int i21 = 0; i21 < this.c; i21++) {
                byte[] bArr9 = this.f5825a[i21];
                bArr9[i20] = (byte) (bArr9[i20] ^ bArr4[i21][i20]);
            }
        }
        int i22 = this.c * 8;
        byte[] bArr10 = new byte[i22];
        int i23 = 0;
        for (int i24 = 0; i24 < this.c; i24++) {
            for (int i25 = 0; i25 < 8; i25++) {
                bArr10[i23] = this.f5825a[i24][i25];
                i23++;
            }
        }
        int i26 = this.a;
        System.arraycopy(bArr10, i22 - i26, bArr, i, i26);
        reset();
        return this.a;
    }

    public final void d(byte b2) {
        byte[] bArr = this.f5831d;
        int i = this.f5832e;
        int i2 = i + 1;
        this.f5832e = i2;
        bArr[i] = b2;
        if (i2 == this.b) {
            k(0, bArr);
            this.f5832e = 0;
        }
        this.f5822a++;
    }

    public final void e(Memoable memoable) {
        i((DSTU7564Digest) memoable);
    }

    public final int f() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    public final void i(DSTU7564Digest dSTU7564Digest) {
        this.a = dSTU7564Digest.a;
        this.b = dSTU7564Digest.b;
        this.c = dSTU7564Digest.c;
        this.f5830d = dSTU7564Digest.f5830d;
        this.f5823a = Arrays.c(dSTU7564Digest.f5823a);
        this.f5825a = Arrays.h(dSTU7564Digest.f5825a);
        this.f5827b = Arrays.h(dSTU7564Digest.f5827b);
        this.f5829c = Arrays.h(dSTU7564Digest.f5829c);
        this.f5826b = Arrays.c(dSTU7564Digest.f5826b);
        this.f5828c = Arrays.c(dSTU7564Digest.f5828c);
        this.f5824a = Arrays.e(dSTU7564Digest.f5824a);
        this.f5822a = dSTU7564Digest.f5822a;
        this.f5832e = dSTU7564Digest.f5832e;
        this.f5831d = Arrays.c(dSTU7564Digest.f5831d);
    }

    public final void k(int i, byte[] bArr) {
        byte[][] bArr2;
        byte[][] bArr3;
        int i2;
        for (int i3 = 0; i3 < this.f5825a.length; i3++) {
            Arrays.p(this.f5827b[i3], (byte) 0);
            Arrays.p(this.f5829c[i3], (byte) 0);
        }
        for (int i4 = 0; i4 < 8; i4++) {
            for (int i5 = 0; i5 < this.c; i5++) {
                int i6 = (i5 * 8) + i4 + i;
                this.f5827b[i5][i4] = (byte) (this.f5825a[i5][i4] ^ bArr[i6]);
                this.f5829c[i5][i4] = bArr[i6];
            }
        }
        int i7 = 0;
        while (true) {
            int i8 = this.f5830d;
            bArr2 = d;
            bArr3 = e;
            i2 = -1;
            if (i7 >= i8) {
                break;
            }
            for (int i9 = 0; i9 < this.c; i9++) {
                byte[] bArr4 = this.f5827b[i9];
                bArr4[0] = (byte) (bArr4[0] ^ ((byte) ((i9 * 16) ^ i7)));
            }
            for (int i10 = 0; i10 < 8; i10++) {
                for (int i11 = 0; i11 < this.c; i11++) {
                    byte[] bArr5 = this.f5827b[i11];
                    bArr5[i10] = bArr3[i10 % 4][bArr5[i10] & UnsignedBytes.MAX_VALUE];
                }
            }
            for (int i12 = 0; i12 < 8; i12++) {
                if (i12 == 7 && this.c == 16) {
                    i2 = 11;
                } else {
                    i2++;
                }
                int i13 = 0;
                while (true) {
                    int i14 = this.c;
                    if (i13 >= i14) {
                        break;
                    }
                    this.f5826b[(i13 + i2) % i14] = this.f5827b[i13][i12];
                    i13++;
                }
                for (int i15 = 0; i15 < this.c; i15++) {
                    this.f5827b[i15][i12] = this.f5826b[i15];
                }
            }
            for (int i16 = 0; i16 < this.c; i16++) {
                Arrays.p(this.f5828c, (byte) 0);
                for (int i17 = 7; i17 >= 0; i17--) {
                    byte b2 = 0;
                    for (int i18 = 7; i18 >= 0; i18--) {
                        b2 = (byte) (b2 ^ j(this.f5827b[i16][i18], bArr2[i17][i18]));
                    }
                    this.f5828c[i17] = b2;
                }
                for (int i19 = 0; i19 < 8; i19++) {
                    this.f5827b[i16][i19] = this.f5828c[i19];
                }
            }
            i7++;
        }
        int i20 = 0;
        while (i20 < this.f5830d) {
            int i21 = 0;
            while (i21 < this.c) {
                this.f5824a[i21] = Pack.h(0, this.f5829c[i21]);
                long[] jArr = this.f5824a;
                long j = jArr[i21] + (((((long) i20) ^ (((long) ((this.c - i21) + i2)) * 16)) << 56) ^ 67818912035696883L);
                jArr[i21] = j;
                Pack.l(j, this.f5829c[i21], 0);
                i21++;
                i2 = -1;
            }
            for (int i22 = 0; i22 < 8; i22++) {
                for (int i23 = 0; i23 < this.c; i23++) {
                    byte[] bArr6 = this.f5829c[i23];
                    bArr6[i22] = bArr3[i22 % 4][bArr6[i22] & UnsignedBytes.MAX_VALUE];
                }
            }
            int i24 = -1;
            for (int i25 = 0; i25 < 8; i25++) {
                if (i25 == 7 && this.c == 16) {
                    i24 = 11;
                } else {
                    i24++;
                }
                int i26 = 0;
                while (true) {
                    int i27 = this.c;
                    if (i26 >= i27) {
                        break;
                    }
                    this.f5826b[(i26 + i24) % i27] = this.f5829c[i26][i25];
                    i26++;
                }
                for (int i28 = 0; i28 < this.c; i28++) {
                    this.f5829c[i28][i25] = this.f5826b[i28];
                }
            }
            for (int i29 = 0; i29 < this.c; i29++) {
                Arrays.p(this.f5828c, (byte) 0);
                for (int i30 = 7; i30 >= 0; i30--) {
                    byte b3 = 0;
                    for (int i31 = 7; i31 >= 0; i31--) {
                        b3 = (byte) (b3 ^ j(this.f5829c[i29][i31], bArr2[i30][i31]));
                    }
                    this.f5828c[i30] = b3;
                }
                for (int i32 = 0; i32 < 8; i32++) {
                    this.f5829c[i29][i32] = this.f5828c[i32];
                }
            }
            i20++;
            i2 = -1;
        }
        for (int i33 = 0; i33 < 8; i33++) {
            for (int i34 = 0; i34 < this.c; i34++) {
                byte[] bArr7 = this.f5825a[i34];
                bArr7[i33] = (byte) (bArr7[i33] ^ ((byte) (this.f5827b[i34][i33] ^ this.f5829c[i34][i33])));
            }
        }
    }

    public final void reset() {
        byte[][] bArr;
        int i = 0;
        while (true) {
            bArr = this.f5825a;
            if (i >= bArr.length) {
                break;
            }
            bArr[i] = new byte[this.c];
            i++;
        }
        bArr[0][0] = (byte) bArr.length;
        this.f5822a = 0;
        this.f5832e = 0;
        Arrays.p(this.f5831d, (byte) 0);
        byte[] bArr2 = this.f5823a;
        if (bArr2 != null) {
            Arrays.p(bArr2, (byte) 0);
        }
    }

    public final void update(byte[] bArr, int i, int i2) {
        while (this.f5832e != 0 && i2 > 0) {
            d(bArr[i]);
            i2--;
            i++;
        }
        if (i2 > 0) {
            while (i2 > this.b) {
                k(i, bArr);
                int i3 = this.b;
                i += i3;
                this.f5822a += (long) i3;
                i2 -= i3;
            }
            while (i2 > 0) {
                d(bArr[i]);
                i2--;
                i++;
            }
        }
    }

    public DSTU7564Digest(int i) {
        byte[][] bArr;
        if (i == 256 || i == 384 || i == 512) {
            this.a = i / 8;
            if (i > 256) {
                this.b = 128;
                this.c = 16;
                this.f5830d = 14;
                this.f5825a = new byte[128][];
            } else {
                this.b = 64;
                this.c = 8;
                this.f5830d = 10;
                this.f5825a = new byte[64][];
            }
            int i2 = 0;
            while (true) {
                bArr = this.f5825a;
                if (i2 >= bArr.length) {
                    break;
                }
                bArr[i2] = new byte[this.c];
                i2++;
            }
            bArr[0][0] = (byte) bArr.length;
            this.f5823a = null;
            this.f5827b = new byte[128][];
            this.f5829c = new byte[128][];
            for (int i3 = 0; i3 < this.f5825a.length; i3++) {
                this.f5827b[i3] = new byte[8];
                this.f5829c[i3] = new byte[8];
            }
            this.f5826b = new byte[16];
            this.f5828c = new byte[8];
            this.f5824a = new long[this.c];
            this.f5831d = new byte[this.b];
            return;
        }
        throw new IllegalArgumentException("Hash size is not recommended. Use 256/384/512 instead");
    }
}
