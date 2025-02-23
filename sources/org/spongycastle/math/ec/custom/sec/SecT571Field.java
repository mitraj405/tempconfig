package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.raw.Interleave;

public class SecT571Field {
    public static final long[] a = {3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 9; i++) {
            jArr3[i] = jArr[i] ^ jArr2[i];
        }
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 9; i++) {
            jArr3[i] = jArr3[i] ^ (jArr[i] ^ jArr2[i]);
        }
    }

    public static void c(long[] jArr, long[] jArr2, long[] jArr3) {
        int i = 56;
        while (true) {
            long j = 0;
            if (i < 0) {
                break;
            }
            for (int i2 = 1; i2 < 9; i2 += 2) {
                int i3 = (int) (jArr[i2] >>> i);
                int i4 = (i3 & 15) * 9;
                int i5 = (((i3 >>> 4) & 15) + 16) * 9;
                int i6 = i2 - 1;
                for (int i7 = 0; i7 < 9; i7++) {
                    int i8 = i6 + i7;
                    jArr3[i8] = jArr3[i8] ^ (jArr2[i4 + i7] ^ jArr2[i5 + i7]);
                }
            }
            int i9 = 0;
            while (i9 < 16) {
                int i10 = 0 + i9;
                long j2 = jArr3[i10];
                jArr3[i10] = (j >>> -8) | (j2 << 8);
                i9++;
                j = j2;
            }
            i -= 8;
        }
        for (int i11 = 56; i11 >= 0; i11 -= 8) {
            for (int i12 = 0; i12 < 9; i12 += 2) {
                int i13 = (int) (jArr[i12] >>> i11);
                int i14 = (i13 & 15) * 9;
                int i15 = (((i13 >>> 4) & 15) + 16) * 9;
                for (int i16 = 0; i16 < 9; i16++) {
                    int i17 = i12 + i16;
                    jArr3[i17] = jArr3[i17] ^ (jArr2[i14 + i16] ^ jArr2[i15 + i16]);
                }
            }
            if (i11 > 0) {
                long j3 = 0;
                int i18 = 0;
                while (i18 < 18) {
                    int i19 = 0 + i18;
                    long j4 = jArr3[i19];
                    jArr3[i19] = (j3 >>> -8) | (j4 << 8);
                    i18++;
                    j3 = j4;
                }
            }
        }
    }

    public static void d(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 9; i++) {
            Interleave.c(i << 1, jArr[i], jArr2);
        }
    }

    public static void e(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[18];
        c(jArr, h(jArr2), jArr4);
        i(jArr4, jArr3);
    }

    public static void f(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[18];
        c(jArr, h(jArr2), jArr4);
        for (int i = 0; i < 18; i++) {
            jArr3[i] = jArr3[i] ^ jArr4[i];
        }
    }

    public static void g(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[18];
        c(jArr, jArr2, jArr4);
        i(jArr4, jArr3);
    }

    public static long[] h(long[] jArr) {
        long j;
        long[] jArr2 = new long[288];
        System.arraycopy(jArr, 0, jArr2, 9, 9);
        int i = 7;
        int i2 = 0;
        while (true) {
            j = 0;
            if (i <= 0) {
                break;
            }
            i2 += 18;
            int i3 = i2 >>> 1;
            int i4 = 0;
            while (i4 < 9) {
                long j2 = jArr2[i3 + i4];
                jArr2[i2 + i4] = (j >>> 63) | (j2 << 1);
                i4++;
                j = j2;
            }
            j(jArr2, i2);
            int i5 = i2 + 9;
            for (int i6 = 0; i6 < 9; i6++) {
                jArr2[i5 + i6] = jArr2[9 + i6] ^ jArr2[i2 + i6];
            }
            i--;
        }
        int i7 = 0;
        while (i7 < 144) {
            long j3 = jArr2[0 + i7];
            jArr2[144 + i7] = (j >>> -4) | (j3 << 4);
            i7++;
            j = j3;
        }
        return jArr2;
    }

    public static void i(long[] jArr, long[] jArr2) {
        long j = jArr[9];
        long j2 = jArr[17];
        long j3 = (((j ^ (j2 >>> 59)) ^ (j2 >>> 57)) ^ (j2 >>> 54)) ^ (j2 >>> 49);
        long j4 = (j2 << 15) ^ (((jArr[8] ^ (j2 << 5)) ^ (j2 << 7)) ^ (j2 << 10));
        for (int i = 16; i >= 10; i--) {
            long j5 = jArr[i];
            jArr2[i - 8] = (((j4 ^ (j5 >>> 59)) ^ (j5 >>> 57)) ^ (j5 >>> 54)) ^ (j5 >>> 49);
            j4 = (((jArr[i - 9] ^ (j5 << 5)) ^ (j5 << 7)) ^ (j5 << 10)) ^ (j5 << 15);
        }
        jArr2[1] = (((j4 ^ (j3 >>> 59)) ^ (j3 >>> 57)) ^ (j3 >>> 54)) ^ (j3 >>> 49);
        long j6 = (j3 << 15) ^ (((jArr[0] ^ (j3 << 5)) ^ (j3 << 7)) ^ (j3 << 10));
        long j7 = jArr2[8];
        long j8 = j7 >>> 59;
        jArr2[0] = (((j6 ^ j8) ^ (j8 << 2)) ^ (j8 << 5)) ^ (j8 << 10);
        jArr2[8] = 576460752303423487L & j7;
    }

    public static void j(long[] jArr, int i) {
        int i2 = i + 8;
        long j = jArr[i2];
        long j2 = j >>> 59;
        jArr[i] = ((j2 << 10) ^ (((j2 << 2) ^ j2) ^ (j2 << 5))) ^ jArr[i];
        jArr[i2] = j & 576460752303423487L;
    }

    public static void k(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[18];
        d(jArr, jArr3);
        i(jArr3, jArr2);
    }

    public static void l(long[] jArr, int i, long[] jArr2) {
        long[] jArr3 = new long[18];
        d(jArr, jArr3);
        i(jArr3, jArr2);
        while (true) {
            i--;
            if (i > 0) {
                d(jArr2, jArr3);
                i(jArr3, jArr2);
            } else {
                return;
            }
        }
    }
}
