package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat224;

public class SecP224R1Field {
    public static final int[] a = {1, 0, 0, -1, -1, -1, -1};
    public static final int[] b = {1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};
    public static final int[] c = {-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.a(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && Nat224.f(iArr3, a))) {
            b(iArr3);
        }
    }

    public static void b(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        long j5 = (4294967295L & ((long) iArr[3])) + 1 + j2;
        iArr[3] = (int) j5;
        if ((j5 >> 32) != 0) {
            Nat.n(7, 4, iArr);
        }
    }

    public static void c(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[14];
        Nat224.i(iArr, iArr2, iArr4);
        d(iArr4, iArr3);
    }

    public static void d(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[10]) & 4294967295L;
        long j2 = ((long) iArr[11]) & 4294967295L;
        long j3 = ((long) iArr[12]) & 4294967295L;
        long j4 = ((long) iArr[13]) & 4294967295L;
        long j5 = ((((long) iArr[7]) & 4294967295L) + j2) - 1;
        long j6 = (((long) iArr[8]) & 4294967295L) + j3;
        long j7 = j3;
        long j8 = (((long) iArr[9]) & 4294967295L) + j4;
        long j9 = j4;
        long j10 = ((((long) iArr[0]) & 4294967295L) - j5) + 0;
        long j11 = j10 & 4294967295L;
        long j12 = j2;
        long j13 = ((((long) iArr[1]) & 4294967295L) - j6) + (j10 >> 32);
        int i = (int) j13;
        iArr3[1] = i;
        long j14 = ((((long) iArr[2]) & 4294967295L) - j8) + (j13 >> 32);
        int i2 = (int) j14;
        iArr3[2] = i2;
        int i3 = i2;
        long j15 = (((((long) iArr[3]) & 4294967295L) + j5) - j) + (j14 >> 32);
        long j16 = j15 & 4294967295L;
        long j17 = (((((long) iArr[4]) & 4294967295L) + j6) - j12) + (j15 >> 32);
        iArr3[4] = (int) j17;
        long j18 = (((((long) iArr[5]) & 4294967295L) + j8) - j7) + (j17 >> 32);
        iArr3[5] = (int) j18;
        long j19 = (((((long) iArr[6]) & 4294967295L) + j) - j9) + (j18 >> 32);
        iArr3[6] = (int) j19;
        long j20 = (j19 >> 32) + 1;
        long j21 = j16 + j20;
        long j22 = j11 - j20;
        iArr3[0] = (int) j22;
        long j23 = j22 >> 32;
        if (j23 != 0) {
            long j24 = j23 + (((long) i) & 4294967295L);
            iArr3[1] = (int) j24;
            long j25 = (j24 >> 32) + (4294967295L & ((long) i3));
            iArr3[2] = (int) j25;
            j21 += j25 >> 32;
        }
        iArr3[3] = (int) j21;
        if (((j21 >> 32) != 0 && Nat.n(7, 4, iArr3) != 0) || (iArr3[6] == -1 && Nat224.f(iArr3, a))) {
            b(iArr2);
        }
    }

    public static void e(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = ((long) i) & 4294967295L;
            long j3 = ((((long) iArr[0]) & 4294967295L) - j2) + 0;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (((long) iArr[1]) & 4294967295L);
                iArr[1] = (int) j5;
                long j6 = (j5 >> 32) + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j6;
                j4 = j6 >> 32;
            }
            long j7 = (4294967295L & ((long) iArr[3])) + j2 + j4;
            iArr[3] = (int) j7;
            j = j7 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && Nat.n(7, 4, iArr) != 0) || (iArr[6] == -1 && Nat224.f(iArr, a))) {
            b(iArr);
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[14];
        Nat224.k(iArr, iArr3);
        d(iArr3, iArr2);
    }

    public static void g(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat224.l(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & 4294967295L) + 1;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                long j3 = j2 + (((long) iArr3[1]) & 4294967295L);
                iArr3[1] = (int) j3;
                long j4 = (j3 >> 32) + (((long) iArr3[2]) & 4294967295L);
                iArr3[2] = (int) j4;
                j2 = j4 >> 32;
            }
            long j5 = ((4294967295L & ((long) iArr3[3])) - 1) + j2;
            iArr3[3] = (int) j5;
            if ((j5 >> 32) != 0) {
                Nat.h(7, 4, iArr3);
            }
        }
    }
}
