package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class SecP521R1Field {
    public static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 511};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        int a2 = Nat.a(16, iArr, iArr2, iArr3) + iArr[16] + iArr2[16];
        if (a2 > 511 || (a2 == 511 && Nat.i(iArr3, 16, a))) {
            a2 = (Nat.l(iArr3) + a2) & 511;
        }
        iArr3[16] = a2;
    }

    public static void b(int[] iArr, int[] iArr2) {
        int i;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        Nat256.q(iArr, iArr2);
        long j = 4294967295L;
        long j2 = ((long) iArr3[8]) & 4294967295L;
        int i2 = 7;
        int i3 = 0;
        int i4 = 16;
        while (true) {
            int i5 = i2 - 1;
            long j3 = j & ((long) iArr3[i2 + 8]);
            long j4 = j3 * j3;
            int i6 = i4 - 1;
            iArr4[16 + i6] = (i3 << 31) | ((int) (j4 >>> 33));
            i4 = i6 - 1;
            iArr4[16 + i4] = (int) (j4 >>> 1);
            i = (int) j4;
            if (i5 <= 0) {
                break;
            }
            i3 = i;
            i2 = i5;
            j = 4294967295L;
            j2 = j2;
        }
        long j5 = j2 * j2;
        long j6 = (((long) (i << 31)) & 4294967295L) | (j5 >>> 33);
        iArr4[16] = (int) j5;
        long j7 = ((long) iArr3[9]) & 4294967295L;
        long j8 = 4294967295L & ((long) iArr4[18]);
        long j9 = (j7 * j2) + j6;
        int i7 = (int) j9;
        iArr4[17] = (i7 << 1) | (((int) (j5 >>> 32)) & 1);
        long j10 = ((long) iArr3[10]) & 4294967295L;
        long j11 = ((long) iArr4[19]) & 4294967295L;
        long j12 = ((long) iArr4[20]) & 4294967295L;
        long j13 = (j10 * j2) + j8 + (j9 >>> 32);
        int i8 = (int) j13;
        iArr4[18] = (i7 >>> 31) | (i8 << 1);
        int i9 = i8 >>> 31;
        long a2 = C0437ME.a(j10, j7, j13 >>> 32, j11);
        long j14 = j12 + (a2 >>> 32);
        long j15 = j2;
        long j16 = ((long) iArr3[11]) & 4294967295L;
        long j17 = (((long) iArr4[21]) & 4294967295L) + (j14 >>> 32);
        long j18 = j14 & 4294967295L;
        long j19 = j10;
        long j20 = (((long) iArr4[22]) & 4294967295L) + (j17 >>> 32);
        long j21 = j17 & 4294967295L;
        long j22 = (j16 * j15) + (a2 & 4294967295L);
        int i10 = (int) j22;
        iArr4[19] = (i10 << 1) | i9;
        long a3 = C0437ME.a(j16, j7, j22 >>> 32, j18);
        long a4 = C0437ME.a(j16, j19, a3 >>> 32, j21);
        long j23 = j20 + (a4 >>> 32);
        long j24 = a4 & 4294967295L;
        long j25 = ((long) iArr3[12]) & 4294967295L;
        long j26 = (((long) iArr4[23]) & 4294967295L) + (j23 >>> 32);
        long j27 = j26 & 4294967295L;
        long j28 = (j25 * j15) + (a3 & 4294967295L);
        int i11 = (int) j28;
        iArr4[20] = (i11 << 1) | (i10 >>> 31);
        long a5 = C0437ME.a(j25, j7, j28 >>> 32, j24);
        long a6 = C0437ME.a(j25, j19, a5 >>> 32, j23 & 4294967295L);
        long j29 = j16;
        long a7 = C0437ME.a(j25, j29, a6 >>> 32, j27);
        long j30 = a6 & 4294967295L;
        long j31 = (((long) iArr4[24]) & 4294967295L) + (j26 >>> 32) + (a7 >>> 32);
        long j32 = ((long) iArr3[13]) & 4294967295L;
        long j33 = (((long) iArr4[25]) & 4294967295L) + (j31 >>> 32);
        long j34 = j31 & 4294967295L;
        long j35 = (((long) iArr4[26]) & 4294967295L) + (j33 >>> 32);
        long j36 = j33 & 4294967295L;
        long j37 = (j32 * j15) + (a5 & 4294967295L);
        int i12 = (int) j37;
        iArr4[21] = (i11 >>> 31) | (i12 << 1);
        int i13 = i12 >>> 31;
        long a8 = C0437ME.a(j32, j7, j37 >>> 32, j30);
        long a9 = C0437ME.a(j32, j19, a8 >>> 32, a7 & 4294967295L);
        long a10 = C0437ME.a(j32, j29, a9 >>> 32, j34);
        long j38 = a9 & 4294967295L;
        long j39 = j25;
        long a11 = C0437ME.a(j32, j39, a10 >>> 32, j36);
        long j40 = j35 + (a11 >>> 32);
        long j41 = a11 & 4294967295L;
        long j42 = ((long) iArr3[14]) & 4294967295L;
        long j43 = (((long) iArr4[27]) & 4294967295L) + (j40 >>> 32);
        long j44 = j40 & 4294967295L;
        long j45 = (((long) iArr4[28]) & 4294967295L) + (j43 >>> 32);
        long j46 = j43 & 4294967295L;
        long j47 = (j42 * j15) + (a8 & 4294967295L);
        int i14 = (int) j47;
        iArr4[22] = i13 | (i14 << 1);
        int i15 = i14 >>> 31;
        long a12 = C0437ME.a(j42, j7, j47 >>> 32, j38);
        long a13 = C0437ME.a(j42, j19, a12 >>> 32, a10 & 4294967295L);
        long j48 = j42;
        long a14 = C0437ME.a(j48, j29, a13 >>> 32, j41);
        long j49 = a13 & 4294967295L;
        long a15 = C0437ME.a(j42, j39, a14 >>> 32, j44);
        long j50 = a14 & 4294967295L;
        long a16 = C0437ME.a(j48, j32, a15 >>> 32, j46);
        long j51 = a15 & 4294967295L;
        long j52 = j45 + (a16 >>> 32);
        long j53 = ((long) iArr3[15]) & 4294967295L;
        long j54 = (((long) iArr4[29]) & 4294967295L) + (j52 >>> 32);
        long j55 = (((long) iArr4[30]) & 4294967295L) + (j54 >>> 32);
        long j56 = j54 & 4294967295L;
        long j57 = (j15 * j53) + (a12 & 4294967295L);
        int i16 = (int) j57;
        iArr4[23] = i15 | (i16 << 1);
        int i17 = i16 >>> 31;
        long j58 = j53;
        long a17 = C0437ME.a(j7, j58, j57 >>> 32, j49);
        long a18 = C0437ME.a(j58, j19, a17 >>> 32, j50);
        long j59 = j53;
        long a19 = C0437ME.a(j59, j16, a18 >>> 32, j51);
        long j60 = j53;
        long a20 = C0437ME.a(j60, j39, a19 >>> 32, a16 & 4294967295L);
        long a21 = C0437ME.a(j59, j32, a20 >>> 32, j52 & 4294967295L);
        long j61 = a21;
        long a22 = C0437ME.a(j60, j42, a21 >>> 32, j56);
        long j62 = j55 + (a22 >>> 32);
        int i18 = (int) a17;
        iArr4[24] = i17 | (i18 << 1);
        int i19 = (int) a18;
        iArr4[25] = (i18 >>> 31) | (i19 << 1);
        int i20 = (int) a19;
        iArr4[26] = (i20 << 1) | (i19 >>> 31);
        int i21 = (int) a20;
        iArr4[27] = (i20 >>> 31) | (i21 << 1);
        int i22 = i21 >>> 31;
        int i23 = (int) j61;
        iArr4[28] = i22 | (i23 << 1);
        int i24 = i23 >>> 31;
        int i25 = (int) a22;
        iArr4[29] = i24 | (i25 << 1);
        int i26 = i25 >>> 31;
        int i27 = (int) j62;
        iArr4[30] = i26 | (i27 << 1);
        iArr4[31] = (i27 >>> 31) | ((iArr4[31] + ((int) (j62 >>> 32))) << 1);
        int d = Nat256.d(iArr4, iArr4);
        int c = Nat256.c(24, 16, Nat256.c(0, 8, 0, iArr4, iArr4) + d, iArr4, iArr4) + d;
        int[] iArr5 = new int[8];
        Nat256.e(iArr3, iArr3, iArr5);
        int[] iArr6 = new int[16];
        Nat256.q(iArr5, iArr6);
        Nat.f(32, Nat.w(16, 8, iArr6, iArr4) + c, 24, iArr4);
        int i28 = iArr3[16];
        long j63 = ((long) (i28 << 1)) & 4294967295L;
        long j64 = 0;
        int i29 = 0;
        while (true) {
            int i30 = i29 + 16;
            long j65 = ((((long) iArr3[0 + i29]) & 4294967295L) * j63) + (((long) iArr4[i30]) & 4294967295L) + j64;
            iArr4[i30] = (int) j65;
            long j66 = j65 >>> 32;
            i29++;
            if (i29 >= 16) {
                iArr4[32] = (i28 * i28) + ((int) j66);
                return;
            }
            j64 = j66;
        }
    }

    public static void c(int[] iArr, int[] iArr2, int[] iArr3) {
        boolean z;
        int i;
        int[] iArr4 = iArr;
        int[] iArr5 = iArr2;
        int[] iArr6 = new int[33];
        Nat256.o(iArr4, iArr5, iArr6);
        long j = ((long) iArr5[8]) & 4294967295L;
        long j2 = ((long) iArr5[9]) & 4294967295L;
        long j3 = ((long) iArr5[10]) & 4294967295L;
        long j4 = ((long) iArr5[11]) & 4294967295L;
        long j5 = ((long) iArr5[12]) & 4294967295L;
        long j6 = ((long) iArr5[13]) & 4294967295L;
        long j7 = ((long) iArr5[14]) & 4294967295L;
        long j8 = ((long) iArr5[15]) & 4294967295L;
        long j9 = ((long) iArr4[8]) & 4294967295L;
        long j10 = 0;
        long j11 = (j9 * j) + 0;
        long j12 = j;
        iArr6[16] = (int) j11;
        long j13 = (j9 * j2) + (j11 >>> 32);
        iArr6[17] = (int) j13;
        long j14 = (j9 * j3) + (j13 >>> 32);
        iArr6[18] = (int) j14;
        long j15 = (j9 * j4) + (j14 >>> 32);
        iArr6[19] = (int) j15;
        long j16 = (j9 * j5) + (j15 >>> 32);
        iArr6[20] = (int) j16;
        long j17 = (j9 * j6) + (j16 >>> 32);
        iArr6[21] = (int) j17;
        long j18 = (j9 * j7) + (j17 >>> 32);
        iArr6[22] = (int) j18;
        long j19 = (j9 * j8) + (j18 >>> 32);
        iArr6[23] = (int) j19;
        iArr6[24] = (int) (j19 >>> 32);
        int i2 = 1;
        int i3 = 1;
        int i4 = 16;
        while (i3 < 8) {
            i4 += i2;
            long j20 = ((long) iArr[i3 + 8]) & 4294967295L;
            int i5 = i4 + 0;
            long j21 = j8;
            long j22 = (j20 * j12) + (((long) iArr6[i5]) & 4294967295L) + 0;
            iArr6[i5] = (int) j22;
            int i6 = i4 + 1;
            long j23 = j2;
            long j24 = (j20 * j2) + (((long) iArr6[i6]) & 4294967295L) + (j22 >>> 32);
            iArr6[i6] = (int) j24;
            int i7 = i4 + 2;
            long j25 = j3;
            long j26 = (j20 * j3) + (((long) iArr6[i7]) & 4294967295L) + (j24 >>> 32);
            iArr6[i7] = (int) j26;
            int i8 = i4 + 3;
            long j27 = (j20 * j4) + (((long) iArr6[i8]) & 4294967295L) + (j26 >>> 32);
            iArr6[i8] = (int) j27;
            int i9 = i4 + 4;
            long j28 = (j20 * j5) + (((long) iArr6[i9]) & 4294967295L) + (j27 >>> 32);
            iArr6[i9] = (int) j28;
            int i10 = i4 + 5;
            long j29 = (j20 * j6) + (((long) iArr6[i10]) & 4294967295L) + (j28 >>> 32);
            iArr6[i10] = (int) j29;
            int i11 = i4 + 6;
            long j30 = (j20 * j7) + (((long) iArr6[i11]) & 4294967295L) + (j29 >>> 32);
            iArr6[i11] = (int) j30;
            int i12 = i4 + 7;
            long j31 = (j20 * j21) + (((long) iArr6[i12]) & 4294967295L) + (j30 >>> 32);
            iArr6[i12] = (int) j31;
            iArr6[i4 + 8] = (int) (j31 >>> 32);
            i3++;
            j3 = j25;
            j8 = j21;
            j2 = j23;
            i2 = 1;
        }
        int[] iArr7 = iArr;
        int d = Nat256.d(iArr6, iArr6);
        int i13 = 0;
        int c = Nat256.c(24, 16, Nat256.c(0, 8, 0, iArr6, iArr6) + d, iArr6, iArr6) + d;
        int[] iArr8 = new int[8];
        int[] iArr9 = new int[8];
        int[] iArr10 = iArr2;
        if (Nat256.e(iArr7, iArr7, iArr8) != Nat256.e(iArr10, iArr10, iArr9)) {
            z = true;
        } else {
            z = false;
        }
        int[] iArr11 = new int[16];
        Nat256.o(iArr8, iArr9, iArr11);
        if (z) {
            i = Nat.e(16, 8, iArr11, iArr6);
        } else {
            i = Nat.w(16, 8, iArr11, iArr6);
        }
        Nat.f(32, c + i, 24, iArr6);
        int i14 = iArr7[16];
        int i15 = iArr10[16];
        long j32 = ((long) i14) & 4294967295L;
        long j33 = ((long) i15) & 4294967295L;
        while (true) {
            long j34 = j32;
            int i16 = 16 + i13;
            long j35 = ((((long) iArr7[i13]) & 4294967295L) * j33) + ((((long) iArr10[i13]) & 4294967295L) * j32) + (((long) iArr6[i16]) & 4294967295L) + j10;
            iArr6[i16] = (int) j35;
            long j36 = j35 >>> 32;
            i13++;
            if (i13 >= 16) {
                iArr6[32] = (i14 * i15) + ((int) j36);
                d(iArr6, iArr3);
                return;
            }
            int[] iArr12 = iArr3;
            j10 = j36;
            j32 = j34;
        }
    }

    public static void d(int[] iArr, int[] iArr2) {
        int i = iArr[32];
        int i2 = i;
        int i3 = 16;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            int i4 = iArr[16 + i3];
            iArr2[i3 + 0] = (i2 << -9) | (i4 >>> 9);
            i2 = i4;
        }
        int d = Nat.d(iArr, 16, iArr2) + ((i2 << -9) >>> 23) + (i >>> 9);
        if (d > 511 || (d == 511 && Nat.i(iArr2, 16, a))) {
            d = (Nat.l(iArr2) + d) & 511;
        }
        iArr2[16] = d;
    }

    public static void e(int[] iArr) {
        int i = iArr[16];
        int g = Nat.g(16, i >>> 9, iArr) + (i & 511);
        if (g > 511 || (g == 511 && Nat.i(iArr, 16, a))) {
            g = (Nat.l(iArr) + g) & 511;
        }
        iArr[16] = g;
    }

    public static void f(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[33];
        b(iArr, iArr3);
        d(iArr3, iArr2);
    }

    public static void g(int[] iArr, int[] iArr2, int[] iArr3) {
        int u = (Nat.u(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (u < 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= 16) {
                    i = -1;
                    break;
                }
                int i3 = iArr3[i2] - 1;
                iArr3[i2] = i3;
                if (i3 != -1) {
                    break;
                }
                i2++;
            }
            u = (u + i) & 511;
        }
        iArr3[16] = u;
    }
}
