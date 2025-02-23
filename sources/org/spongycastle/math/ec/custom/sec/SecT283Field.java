package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.raw.Interleave;

public class SecT283Field {
    public static final long[] a = {878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042};

    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr[7] ^ jArr2[7];
        jArr3[8] = jArr2[8] ^ jArr[8];
    }

    public static void b(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        jArr2[0] = j & 144115188075855871L;
        jArr2[1] = ((j >>> 57) ^ (j2 << 7)) & 144115188075855871L;
        jArr2[2] = ((j2 >>> 50) ^ (j3 << 14)) & 144115188075855871L;
        jArr2[3] = ((j3 >>> 43) ^ (j4 << 21)) & 144115188075855871L;
        jArr2[4] = (j4 >>> 36) ^ (j5 << 28);
    }

    public static void c(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[5];
        b(jArr, jArr4);
        b(jArr2, jArr5);
        long[] jArr6 = new long[26];
        long[] jArr7 = jArr6;
        d(jArr4[0], jArr5[0], jArr7, 0);
        d(jArr4[1], jArr5[1], jArr7, 2);
        d(jArr4[2], jArr5[2], jArr7, 4);
        d(jArr4[3], jArr5[3], jArr7, 6);
        d(jArr4[4], jArr5[4], jArr7, 8);
        long j = jArr4[0];
        long j2 = j ^ jArr4[1];
        long j3 = jArr5[0];
        long j4 = j3 ^ jArr5[1];
        long j5 = jArr4[2];
        long j6 = j ^ j5;
        long j7 = jArr5[2];
        long j8 = j3 ^ j7;
        long j9 = jArr4[4];
        long j10 = j5 ^ j9;
        long j11 = jArr5[4];
        long j12 = j7 ^ j11;
        long j13 = jArr4[3];
        long j14 = j13 ^ j9;
        long j15 = jArr5[3];
        long j16 = j15 ^ j11;
        long[] jArr8 = jArr6;
        d(j6 ^ j13, j8 ^ j15, jArr8, 18);
        d(j10 ^ jArr4[1], j12 ^ jArr5[1], jArr8, 20);
        long j17 = j2 ^ j14;
        long j18 = j4 ^ j16;
        long j19 = j17 ^ jArr4[2];
        long[] jArr9 = jArr6;
        d(j17, j18, jArr9, 22);
        d(j19, jArr5[2] ^ j18, jArr9, 24);
        d(j2, j4, jArr9, 10);
        d(j6, j8, jArr9, 12);
        d(j10, j12, jArr9, 14);
        d(j14, j16, jArr9, 16);
        long j20 = jArr6[0];
        jArr3[0] = j20;
        long j21 = jArr6[9];
        jArr3[9] = j21;
        long j22 = jArr6[0];
        long j23 = jArr6[1] ^ j22;
        long j24 = j23 ^ jArr6[2];
        long j25 = j24 ^ jArr6[10];
        jArr3[1] = j25;
        long j26 = jArr6[3] ^ jArr6[4];
        long j27 = j24 ^ (j26 ^ (jArr6[11] ^ jArr6[12]));
        jArr3[2] = j27;
        long j28 = j23 ^ j26;
        long j29 = jArr6[5] ^ jArr6[6];
        long j30 = jArr6[8];
        long j31 = (j28 ^ j29) ^ j30;
        long j32 = jArr6[13] ^ jArr6[14];
        long j33 = jArr6[18];
        long j34 = jArr6[22];
        long j35 = jArr6[24];
        long j36 = (j31 ^ j32) ^ ((j33 ^ j34) ^ j35);
        jArr3[3] = j36;
        long j37 = jArr6[7] ^ j30;
        long j38 = jArr6[9];
        long j39 = j37 ^ j38;
        long j40 = j39 ^ jArr6[17];
        jArr3[8] = j40;
        long j41 = (j39 ^ j29) ^ (jArr6[15] ^ jArr6[16]);
        jArr3[7] = j41;
        long j42 = jArr6[19] ^ jArr6[20];
        long j43 = jArr6[25];
        long j44 = jArr6[23];
        long j45 = j42 ^ (j43 ^ j35);
        long j46 = (j45 ^ (j33 ^ j44)) ^ (j41 ^ j25);
        jArr3[4] = j46;
        long j47 = jArr6[21];
        long j48 = (j45 ^ (j27 ^ j40)) ^ (j47 ^ j34);
        jArr3[5] = j48;
        long j49 = (((((j22 ^ j31) ^ j38) ^ j32) ^ j47) ^ j44) ^ j43;
        jArr3[6] = j49;
        jArr3[0] = j20 ^ (j25 << 57);
        jArr3[1] = (j25 >>> 7) ^ (j27 << 50);
        jArr3[2] = (j27 >>> 14) ^ (j36 << 43);
        jArr3[3] = (j36 >>> 21) ^ (j46 << 36);
        jArr3[4] = (j46 >>> 28) ^ (j48 << 29);
        jArr3[5] = (j48 >>> 35) ^ (j49 << 22);
        jArr3[6] = (j49 >>> 42) ^ (j41 << 15);
        jArr3[7] = (j41 >>> 49) ^ (j40 << 8);
        jArr3[8] = (j40 >>> 56) ^ (j21 << 1);
        jArr3[9] = j21 >>> 63;
    }

    public static void d(long j, long j2, long[] jArr, int i) {
        long j3 = j;
        long[] jArr2 = new long[8];
        jArr2[1] = j2;
        long j4 = j2 << 1;
        jArr2[2] = j4;
        long j5 = j4 ^ j2;
        jArr2[3] = j5;
        long j6 = j4 << 1;
        jArr2[4] = j6;
        jArr2[5] = j6 ^ j2;
        long j7 = j5 << 1;
        jArr2[6] = j7;
        jArr2[7] = j7 ^ j2;
        long j8 = jArr2[((int) j3) & 7];
        long j9 = 0;
        int i2 = 48;
        do {
            int i3 = (int) (j3 >>> i2);
            long j10 = (jArr2[i3 & 7] ^ (jArr2[(i3 >>> 3) & 7] << 3)) ^ (jArr2[(i3 >>> 6) & 7] << 6);
            j8 ^= j10 << i2;
            j9 ^= j10 >>> (-i2);
            i2 -= 9;
        } while (i2 > 0);
        jArr[i] = 144115188075855871L & j8;
        jArr[i + 1] = (((((j3 & 72198606942111744L) & ((j2 << 7) >> 63)) >>> 8) ^ j9) << 7) ^ (j8 >>> 57);
    }

    public static void e(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 4; i++) {
            Interleave.c(i << 1, jArr[i], jArr2);
        }
        jArr2[8] = Interleave.b((int) jArr[4]);
    }

    public static void f(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[10];
        c(jArr, jArr2, jArr4);
        g(jArr4, jArr3);
    }

    public static void g(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        long j10 = j5 ^ ((((j9 >>> 27) ^ (j9 >>> 22)) ^ (j9 >>> 20)) ^ (j9 >>> 15));
        long j11 = j ^ ((((j6 << 37) ^ (j6 << 42)) ^ (j6 << 44)) ^ (j6 << 49));
        long j12 = (j2 ^ ((((j7 << 37) ^ (j7 << 42)) ^ (j7 << 44)) ^ (j7 << 49))) ^ ((((j6 >>> 27) ^ (j6 >>> 22)) ^ (j6 >>> 20)) ^ (j6 >>> 15));
        long j13 = j10 >>> 27;
        jArr2[0] = (((j11 ^ j13) ^ (j13 << 5)) ^ (j13 << 7)) ^ (j13 << 12);
        jArr2[1] = j12;
        jArr2[2] = (j3 ^ ((((j8 << 37) ^ (j8 << 42)) ^ (j8 << 44)) ^ (j8 << 49))) ^ ((((j7 >>> 27) ^ (j7 >>> 22)) ^ (j7 >>> 20)) ^ (j7 >>> 15));
        jArr2[3] = (j4 ^ ((((j9 << 37) ^ (j9 << 42)) ^ (j9 << 44)) ^ (j9 << 49))) ^ ((((j8 >>> 27) ^ (j8 >>> 22)) ^ (j8 >>> 20)) ^ (j8 >>> 15));
        jArr2[4] = 134217727 & j10;
    }

    public static void h(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[9];
        e(jArr, jArr3);
        g(jArr3, jArr2);
    }

    public static void i(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[9];
        e(jArr, jArr3);
        g(jArr3, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                e(jArr2, jArr3);
                g(jArr3, jArr2);
            } else {
                return;
            }
        }
    }
}
