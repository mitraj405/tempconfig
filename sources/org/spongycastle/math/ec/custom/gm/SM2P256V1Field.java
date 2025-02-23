package org.spongycastle.math.ec.custom.gm;

import org.spongycastle.math.raw.Nat256;

public class SM2P256V1Field {
    public static final int[] a = {-1, -1, 0, -1, -1, -1, -1, -2};
    public static final int[] b = {1, 0, -2, 1, 1, -2, 0, 2, -2, -3, 3, -2, -1, -1, 0, -2};

    public static void a(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = ((((long) iArr[2]) & 4294967295L) - 1) + j2;
        iArr[2] = (int) j4;
        long j5 = (((long) iArr[3]) & 4294967295L) + 1 + (j4 >> 32);
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (((long) iArr[4]) & 4294967295L);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j8;
            long j9 = (j8 >> 32) + (((long) iArr[6]) & 4294967295L);
            iArr[6] = (int) j9;
            j6 = j9 >> 32;
        }
        iArr[7] = (int) ((4294967295L & ((long) iArr[7])) + 1 + j6);
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[16];
        Nat256.o(iArr, iArr2, iArr4);
        c(iArr4, iArr3);
    }

    public static void c(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[8]) & 4294967295L;
        long j2 = ((long) iArr[9]) & 4294967295L;
        long j3 = ((long) iArr[10]) & 4294967295L;
        long j4 = ((long) iArr[11]) & 4294967295L;
        long j5 = ((long) iArr[12]) & 4294967295L;
        long j6 = ((long) iArr[13]) & 4294967295L;
        long j7 = ((long) iArr[14]) & 4294967295L;
        long j8 = ((long) iArr[15]) & 4294967295L;
        long j9 = j3 + j4;
        long j10 = j6 + j7;
        long j11 = j10 + (j8 << 1);
        long j12 = j + j2 + j10;
        long j13 = j9 + j5 + j8 + j12;
        long j14 = j5;
        long j15 = (((long) iArr[0]) & 4294967295L) + j13 + j6 + j7 + j8 + 0;
        iArr3[0] = (int) j15;
        long j16 = j4;
        long j17 = (((((long) iArr[1]) & 4294967295L) + j13) - j) + j7 + j8 + (j15 >> 32);
        iArr3[1] = (int) j17;
        long j18 = ((((long) iArr[2]) & 4294967295L) - j12) + (j17 >> 32);
        iArr3[2] = (int) j18;
        long j19 = ((((((long) iArr[3]) & 4294967295L) + j13) - j2) - j3) + j6 + (j18 >> 32);
        iArr3[3] = (int) j19;
        long j20 = ((((((long) iArr[4]) & 4294967295L) + j13) - j9) - j) + j7 + (j19 >> 32);
        iArr3[4] = (int) j20;
        long j21 = (((long) iArr[5]) & 4294967295L) + j11 + j3 + (j20 >> 32);
        iArr3[5] = (int) j21;
        long j22 = (((long) iArr[6]) & 4294967295L) + j16 + j7 + j8 + (j21 >> 32);
        iArr3[6] = (int) j22;
        long j23 = (4294967295L & ((long) iArr[7])) + j13 + j11 + j14 + (j22 >> 32);
        iArr3[7] = (int) j23;
        d((int) (j23 >> 32), iArr3);
    }

    public static void d(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = ((long) i) & 4294967295L;
            long j3 = (((long) iArr[0]) & 4294967295L) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (((long) iArr[1]) & 4294967295L);
                iArr[1] = (int) j5;
                j4 = j5 >> 32;
            }
            long j6 = ((((long) iArr[2]) & 4294967295L) - j2) + j4;
            iArr[2] = (int) j6;
            long j7 = (((long) iArr[3]) & 4294967295L) + j2 + (j6 >> 32);
            iArr[3] = (int) j7;
            long j8 = j7 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (((long) iArr[4]) & 4294967295L);
                iArr[4] = (int) j9;
                long j10 = (j9 >> 32) + (((long) iArr[5]) & 4294967295L);
                iArr[5] = (int) j10;
                long j11 = (j10 >> 32) + (((long) iArr[6]) & 4294967295L);
                iArr[6] = (int) j11;
                j8 = j11 >> 32;
            }
            long j12 = (4294967295L & ((long) iArr[7])) + j2 + j8;
            iArr[7] = (int) j12;
            j = j12 >> 32;
        } else {
            j = 0;
        }
        if (j != 0 || ((iArr[7] >>> 1) >= Integer.MAX_VALUE && Nat256.j(iArr, a))) {
            a(iArr);
        }
    }

    public static void e(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        Nat256.q(iArr, iArr3);
        c(iArr3, iArr2);
    }

    public static void f(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[16];
        Nat256.q(iArr, iArr3);
        c(iArr3, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat256.q(iArr2, iArr3);
                c(iArr3, iArr2);
            } else {
                return;
            }
        }
    }

    public static void g(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.r(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & 4294967295L) - 1;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                long j3 = j2 + (((long) iArr3[1]) & 4294967295L);
                iArr3[1] = (int) j3;
                j2 = j3 >> 32;
            }
            long j4 = (((long) iArr3[2]) & 4294967295L) + 1 + j2;
            iArr3[2] = (int) j4;
            long j5 = ((((long) iArr3[3]) & 4294967295L) - 1) + (j4 >> 32);
            iArr3[3] = (int) j5;
            long j6 = j5 >> 32;
            if (j6 != 0) {
                long j7 = j6 + (((long) iArr3[4]) & 4294967295L);
                iArr3[4] = (int) j7;
                long j8 = (j7 >> 32) + (((long) iArr3[5]) & 4294967295L);
                iArr3[5] = (int) j8;
                long j9 = (j8 >> 32) + (((long) iArr3[6]) & 4294967295L);
                iArr3[6] = (int) j9;
                j6 = j9 >> 32;
            }
            iArr3[7] = (int) (((4294967295L & ((long) iArr3[7])) - 1) + j6);
        }
    }
}
