package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;

public class SecP192R1Field {
    public static final int[] a = {-1, -1, -2, -1, -1, -1};
    public static final int[] b = {1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};
    public static final int[] c = {-1, -1, -3, -1, -2, -1, 1, 0, 2};

    public static void a(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = (4294967295L & ((long) iArr[2])) + 1 + j2;
        iArr[2] = (int) j4;
        if ((j4 >> 32) != 0) {
            Nat.n(6, 3, iArr);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[12];
        Nat192.m(iArr, iArr2, iArr4);
        c(iArr4, iArr3);
    }

    public static void c(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[6]) & 4294967295L;
        long j2 = ((long) iArr[7]) & 4294967295L;
        long j3 = (((long) iArr[10]) & 4294967295L) + j;
        long j4 = (((long) iArr[11]) & 4294967295L) + j2;
        long j5 = j2;
        long j6 = (((long) iArr[0]) & 4294967295L) + j3 + 0;
        int i = (int) j6;
        long j7 = (((long) iArr[1]) & 4294967295L) + j4 + (j6 >> 32);
        int i2 = (int) j7;
        iArr3[1] = i2;
        long j8 = j3 + (((long) iArr[8]) & 4294967295L);
        long j9 = j4 + (((long) iArr[9]) & 4294967295L);
        long j10 = (((long) iArr[2]) & 4294967295L) + j8 + (j7 >> 32);
        long j11 = j10 & 4294967295L;
        long j12 = (((long) iArr[3]) & 4294967295L) + j9 + (j10 >> 32);
        iArr3[3] = (int) j12;
        long j13 = (((long) iArr[4]) & 4294967295L) + (j8 - j) + (j12 >> 32);
        iArr3[4] = (int) j13;
        long j14 = (((long) iArr[5]) & 4294967295L) + (j9 - j5) + (j13 >> 32);
        iArr3[5] = (int) j14;
        long j15 = j14 >> 32;
        long j16 = j11 + j15;
        long j17 = j15 + (((long) i) & 4294967295L);
        iArr3[0] = (int) j17;
        long j18 = j17 >> 32;
        if (j18 != 0) {
            long j19 = j18 + (((long) i2) & 4294967295L);
            iArr3[1] = (int) j19;
            j16 += j19 >> 32;
        }
        iArr3[2] = (int) j16;
        if (((j16 >> 32) != 0 && Nat.n(6, 3, iArr3) != 0) || (iArr3[5] == -1 && Nat192.i(iArr3, a))) {
            a(iArr2);
        }
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
            long j6 = (4294967295L & ((long) iArr[2])) + j2 + j4;
            iArr[2] = (int) j6;
            j = j6 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && Nat.n(6, 3, iArr) != 0) || (iArr[5] == -1 && Nat192.i(iArr, a))) {
            a(iArr);
        }
    }

    public static void e(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[12];
        Nat192.o(iArr, iArr3);
        c(iArr3, iArr2);
    }

    public static void f(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[12];
        Nat192.o(iArr, iArr3);
        c(iArr3, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat192.o(iArr2, iArr3);
                c(iArr3, iArr2);
            } else {
                return;
            }
        }
    }

    public static void g(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat192.p(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & 4294967295L) - 1;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                long j3 = j2 + (((long) iArr3[1]) & 4294967295L);
                iArr3[1] = (int) j3;
                j2 = j3 >> 32;
            }
            long j4 = ((4294967295L & ((long) iArr3[2])) - 1) + j2;
            iArr3[2] = (int) j4;
            if ((j4 >> 32) != 0) {
                Nat.h(6, 3, iArr3);
            }
        }
    }
}
