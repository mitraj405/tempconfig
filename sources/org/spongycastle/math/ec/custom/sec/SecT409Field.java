package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.raw.Interleave;

public class SecT409Field {
    public static void a(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        jArr2[0] = j & 576460752303423487L;
        jArr2[1] = ((j >>> 59) ^ (j2 << 5)) & 576460752303423487L;
        jArr2[2] = ((j2 >>> 54) ^ (j3 << 10)) & 576460752303423487L;
        jArr2[3] = ((j3 >>> 49) ^ (j4 << 15)) & 576460752303423487L;
        jArr2[4] = ((j4 >>> 44) ^ (j5 << 20)) & 576460752303423487L;
        jArr2[5] = ((j5 >>> 39) ^ (j6 << 25)) & 576460752303423487L;
        jArr2[6] = (j6 >>> 34) ^ (j7 << 30);
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        int i = 7;
        long[] jArr4 = new long[7];
        long[] jArr5 = new long[7];
        a(jArr, jArr4);
        a(jArr2, jArr5);
        int i2 = 0;
        while (i2 < i) {
            long j = jArr5[i2];
            long[] jArr6 = new long[8];
            jArr6[1] = j;
            long j2 = j << 1;
            jArr6[2] = j2;
            long j3 = j2 ^ j;
            jArr6[3] = j3;
            long j4 = j2 << 1;
            jArr6[4] = j4;
            jArr6[5] = j4 ^ j;
            long j5 = j3 << 1;
            jArr6[6] = j5;
            jArr6[i] = j5 ^ j;
            int i3 = 0;
            while (i3 < i) {
                long j6 = jArr4[i3];
                int i4 = (int) j6;
                long j7 = jArr6[i4 & 7] ^ (jArr6[(i4 >>> 3) & i] << 3);
                int i5 = 54;
                long j8 = 0;
                while (true) {
                    int i6 = (int) (j6 >>> i5);
                    long j9 = jArr6[i6 & 7] ^ (jArr6[(i6 >>> 3) & i] << 3);
                    j7 ^= j9 << i5;
                    j8 ^= j9 >>> (-i5);
                    i5 -= 6;
                    if (i5 <= 0) {
                        break;
                    }
                    i = 7;
                }
                int i7 = i2 + i3;
                jArr3[i7] = jArr3[i7] ^ (576460752303423487L & j7);
                int i8 = i7 + 1;
                jArr3[i8] = jArr3[i8] ^ ((j8 << 5) ^ (j7 >>> 59));
                i3++;
                i = 7;
            }
            i2++;
            i = 7;
        }
        long j10 = jArr3[0];
        long j11 = jArr3[1];
        long j12 = jArr3[2];
        long j13 = jArr3[3];
        long j14 = jArr3[4];
        long j15 = jArr3[5];
        long j16 = jArr3[6];
        long j17 = jArr3[7];
        long j18 = jArr3[8];
        long j19 = jArr3[9];
        long j20 = jArr3[10];
        long j21 = jArr3[11];
        long j22 = jArr3[12];
        long j23 = jArr3[13];
        jArr3[0] = j10 ^ (j11 << 59);
        jArr3[1] = (j11 >>> 5) ^ (j12 << 54);
        jArr3[2] = (j12 >>> 10) ^ (j13 << 49);
        jArr3[3] = (j13 >>> 15) ^ (j14 << 44);
        jArr3[4] = (j14 >>> 20) ^ (j15 << 39);
        jArr3[5] = (j15 >>> 25) ^ (j16 << 34);
        jArr3[6] = (j16 >>> 30) ^ (j17 << 29);
        jArr3[7] = (j17 >>> 35) ^ (j18 << 24);
        jArr3[8] = (j18 >>> 40) ^ (j19 << 19);
        jArr3[9] = (j19 >>> 45) ^ (j20 << 14);
        jArr3[10] = (j20 >>> 50) ^ (j21 << 9);
        jArr3[11] = ((j21 >>> 55) ^ (j22 << 4)) ^ (j23 << 63);
        jArr3[12] = (j22 >>> 60) ^ (j23 >>> 1);
        jArr3[13] = 0;
    }

    public static void c(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 6; i++) {
            Interleave.c(i << 1, jArr[i], jArr2);
        }
        jArr2[12] = Interleave.b((int) jArr[6]);
    }

    public static void d(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[14];
        b(jArr, jArr2, jArr4);
        e(jArr4, jArr3);
    }

    public static void e(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[12];
        long j10 = j7 ^ ((j9 >>> 25) ^ (j9 << 62));
        long j11 = j8 ^ (j9 >>> 2);
        long j12 = jArr[11];
        long j13 = j5 ^ (j12 << 39);
        long j14 = (j6 ^ (j9 << 39)) ^ ((j12 >>> 25) ^ (j12 << 62));
        long j15 = j10 ^ (j12 >>> 2);
        long j16 = jArr[10];
        long j17 = j4 ^ (j16 << 39);
        long j18 = j13 ^ ((j16 >>> 25) ^ (j16 << 62));
        long j19 = j14 ^ (j16 >>> 2);
        long j20 = jArr[9];
        long j21 = j3 ^ (j20 << 39);
        long j22 = j17 ^ ((j20 >>> 25) ^ (j20 << 62));
        long j23 = j18 ^ (j20 >>> 2);
        long j24 = jArr[8];
        long j25 = j ^ (j11 << 39);
        long j26 = (j21 ^ ((j24 >>> 25) ^ (j24 << 62))) ^ (j11 >>> 2);
        long j27 = j15 >>> 25;
        jArr2[0] = j25 ^ j27;
        long j28 = j27 << 23;
        jArr2[1] = j28 ^ ((j2 ^ (j24 << 39)) ^ ((j11 >>> 25) ^ (j11 << 62)));
        jArr2[2] = j26;
        jArr2[3] = j22 ^ (j24 >>> 2);
        jArr2[4] = j23;
        jArr2[5] = j19;
        jArr2[6] = j15 & 33554431;
    }

    public static void f(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[13];
        c(jArr, jArr3);
        e(jArr3, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                c(jArr2, jArr3);
                e(jArr3, jArr2);
            } else {
                return;
            }
        }
    }
}
