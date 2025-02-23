package org.spongycastle.math.raw;

public abstract class Nat384 {
    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        int i;
        int[] iArr4 = iArr2;
        int[] iArr5 = iArr3;
        Nat192.m(iArr, iArr2, iArr3);
        long j = ((long) iArr4[6]) & 4294967295L;
        long j2 = ((long) iArr4[7]) & 4294967295L;
        long j3 = ((long) iArr4[8]) & 4294967295L;
        long j4 = ((long) iArr4[9]) & 4294967295L;
        long j5 = ((long) iArr4[10]) & 4294967295L;
        long j6 = ((long) iArr4[11]) & 4294967295L;
        long j7 = ((long) iArr[6]) & 4294967295L;
        long j8 = (j7 * j) + 0;
        long j9 = j;
        iArr5[12] = (int) j8;
        long j10 = (j7 * j2) + (j8 >>> 32);
        iArr5[13] = (int) j10;
        long j11 = (j7 * j3) + (j10 >>> 32);
        iArr5[14] = (int) j11;
        long j12 = (j7 * j4) + (j11 >>> 32);
        iArr5[15] = (int) j12;
        long j13 = (j7 * j5) + (j12 >>> 32);
        iArr5[16] = (int) j13;
        long j14 = (j7 * j6) + (j13 >>> 32);
        iArr5[17] = (int) j14;
        iArr5[18] = (int) (j14 >>> 32);
        int i2 = 1;
        int i3 = 1;
        int i4 = 12;
        while (i3 < 6) {
            i4 += i2;
            long j15 = ((long) iArr[6 + i3]) & 4294967295L;
            int i5 = i4 + 0;
            int i6 = i3;
            long j16 = (j15 * j9) + (((long) iArr5[i5]) & 4294967295L) + 0;
            iArr5[i5] = (int) j16;
            int i7 = i4 + 1;
            long j17 = j2;
            long j18 = (j15 * j2) + (((long) iArr5[i7]) & 4294967295L) + (j16 >>> 32);
            iArr5[i7] = (int) j18;
            int i8 = i4 + 2;
            long j19 = (j15 * j3) + (((long) iArr5[i8]) & 4294967295L) + (j18 >>> 32);
            iArr5[i8] = (int) j19;
            int i9 = i4 + 3;
            long j20 = (j15 * j4) + (((long) iArr5[i9]) & 4294967295L) + (j19 >>> 32);
            iArr5[i9] = (int) j20;
            int i10 = i4 + 4;
            long j21 = (j15 * j5) + (((long) iArr5[i10]) & 4294967295L) + (j20 >>> 32);
            iArr5[i10] = (int) j21;
            int i11 = i4 + 5;
            long j22 = (j15 * j6) + (((long) iArr5[i11]) & 4294967295L) + (j21 >>> 32);
            iArr5[i11] = (int) j22;
            iArr5[i4 + 6] = (int) (j22 >>> 32);
            i3 = i6 + 1;
            j3 = j3;
            j2 = j17;
            i2 = 1;
        }
        int d = Nat192.d(iArr5, iArr5);
        boolean z = false;
        int c = Nat192.c(18, 12, Nat192.c(0, 6, 0, iArr5, iArr5) + d, iArr5, iArr5) + d;
        int[] iArr6 = new int[6];
        int[] iArr7 = new int[6];
        int[] iArr8 = iArr;
        int[] iArr9 = iArr2;
        if (Nat192.e(iArr8, iArr8, iArr6) != Nat192.e(iArr9, iArr9, iArr7)) {
            z = true;
        }
        int[] iArr10 = new int[12];
        Nat192.m(iArr6, iArr7, iArr10);
        if (z) {
            i = Nat.e(12, 6, iArr10, iArr5);
        } else {
            i = Nat.w(12, 6, iArr10, iArr5);
        }
        Nat.f(24, c + i, 18, iArr5);
    }

    public static void b(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        Nat192.o(iArr, iArr2);
        long j = 4294967295L;
        long j2 = ((long) iArr3[6]) & 4294967295L;
        int i = 5;
        int i2 = 0;
        int i3 = 12;
        while (true) {
            int i4 = i - 1;
            long j3 = j & ((long) iArr3[i + 6]);
            long j4 = j3 * j3;
            int i5 = i3 - 1;
            iArr4[12 + i5] = (i2 << 31) | ((int) (j4 >>> 33));
            i3 = i5 - 1;
            iArr4[12 + i3] = (int) (j4 >>> 1);
            int i6 = (int) j4;
            if (i4 <= 0) {
                long j5 = j2 * j2;
                long j6 = (((long) (i6 << 31)) & 4294967295L) | (j5 >>> 33);
                iArr4[12] = (int) j5;
                long j7 = ((long) iArr3[7]) & 4294967295L;
                long j8 = 4294967295L & ((long) iArr4[14]);
                long j9 = (j7 * j2) + j6;
                int i7 = (int) j9;
                iArr4[13] = (i7 << 1) | (((int) (j5 >>> 32)) & 1);
                long j10 = ((long) iArr3[8]) & 4294967295L;
                long j11 = ((long) iArr4[15]) & 4294967295L;
                long j12 = ((long) iArr4[16]) & 4294967295L;
                long j13 = (j10 * j2) + j8 + (j9 >>> 32);
                int i8 = (int) j13;
                iArr4[14] = (i7 >>> 31) | (i8 << 1);
                long a = C0437ME.a(j10, j7, j13 >>> 32, j11);
                long j14 = j12 + (a >>> 32);
                long j15 = j2;
                long j16 = ((long) iArr3[9]) & 4294967295L;
                long j17 = (((long) iArr4[17]) & 4294967295L) + (j14 >>> 32);
                long j18 = j14 & 4294967295L;
                long j19 = j10;
                long j20 = (((long) iArr4[18]) & 4294967295L) + (j17 >>> 32);
                long j21 = j17 & 4294967295L;
                long j22 = (j16 * j15) + (a & 4294967295L);
                int i9 = (int) j22;
                iArr4[15] = (i8 >>> 31) | (i9 << 1);
                long a2 = C0437ME.a(j16, j7, j22 >>> 32, j18);
                long a3 = C0437ME.a(j16, j19, a2 >>> 32, j21);
                long j23 = j20 + (a3 >>> 32);
                long j24 = a3 & 4294967295L;
                long j25 = ((long) iArr3[10]) & 4294967295L;
                long j26 = (((long) iArr4[19]) & 4294967295L) + (j23 >>> 32);
                long j27 = j23 & 4294967295L;
                long j28 = (((long) iArr4[20]) & 4294967295L) + (j26 >>> 32);
                long j29 = j26 & 4294967295L;
                long j30 = (j25 * j15) + (a2 & 4294967295L);
                int i10 = (int) j30;
                iArr4[16] = (i10 << 1) | (i9 >>> 31);
                long a4 = C0437ME.a(j25, j7, j30 >>> 32, j24);
                long a5 = C0437ME.a(j25, j19, a4 >>> 32, j27);
                long j31 = j16;
                long a6 = C0437ME.a(j25, j31, a5 >>> 32, j29);
                long j32 = a5 & 4294967295L;
                long j33 = j28 + (a6 >>> 32);
                long j34 = ((long) iArr3[11]) & 4294967295L;
                long j35 = (((long) iArr4[21]) & 4294967295L) + (j33 >>> 32);
                long j36 = j35 & 4294967295L;
                long j37 = (j15 * j34) + (a4 & 4294967295L);
                int i11 = (int) j37;
                iArr4[17] = (i10 >>> 31) | (i11 << 1);
                int i12 = i11 >>> 31;
                long a7 = C0437ME.a(j7, j34, j37 >>> 32, j32);
                long a8 = C0437ME.a(j19, j34, a7 >>> 32, a6 & 4294967295L);
                long j38 = j34;
                long a9 = C0437ME.a(j38, j31, a8 >>> 32, j33 & 4294967295L);
                long a10 = C0437ME.a(j38, j25, a9 >>> 32, j36);
                long j39 = (((long) iArr4[22]) & 4294967295L) + (j35 >>> 32) + (a10 >>> 32);
                int i13 = (int) a7;
                iArr4[18] = i12 | (i13 << 1);
                int i14 = i13 >>> 31;
                int i15 = (int) a8;
                iArr4[19] = i14 | (i15 << 1);
                int i16 = (int) a9;
                iArr4[20] = (i16 << 1) | (i15 >>> 31);
                int i17 = (int) a10;
                iArr4[21] = (i16 >>> 31) | (i17 << 1);
                int i18 = i17 >>> 31;
                int i19 = (int) j39;
                iArr4[22] = i18 | (i19 << 1);
                iArr4[23] = (i19 >>> 31) | ((iArr4[23] + ((int) (j39 >>> 32))) << 1);
                int d = Nat192.d(iArr4, iArr4);
                int c = Nat192.c(18, 12, Nat192.c(0, 6, 0, iArr4, iArr4) + d, iArr4, iArr4) + d;
                int[] iArr5 = new int[6];
                Nat192.e(iArr3, iArr3, iArr5);
                int[] iArr6 = new int[12];
                Nat192.o(iArr5, iArr6);
                Nat.f(24, Nat.w(12, 6, iArr6, iArr4) + c, 18, iArr4);
                return;
            }
            i2 = i6;
            i = i4;
            j = 4294967295L;
            j2 = j2;
        }
    }
}
