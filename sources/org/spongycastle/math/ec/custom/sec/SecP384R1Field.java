package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat384;

public class SecP384R1Field {
    public static final int[] a = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
    public static final int[] b = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
    public static final int[] c = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    public static void a(int[] iArr) {
        long j = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = ((((long) iArr[1]) & 4294967295L) - 1) + (j >> 32);
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = (((long) iArr[3]) & 4294967295L) + 1 + j3;
        iArr[3] = (int) j5;
        long j6 = (4294967295L & ((long) iArr[4])) + 1 + (j5 >> 32);
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            Nat.n(12, 5, iArr);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[24];
        Nat384.a(iArr, iArr2, iArr4);
        c(iArr4, iArr3);
    }

    public static void c(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[17]) & 4294967295L;
        long j2 = ((long) iArr[20]) & 4294967295L;
        long j3 = ((long) iArr[21]) & 4294967295L;
        long j4 = ((long) iArr[19]) & 4294967295L;
        long j5 = ((long) iArr[22]) & 4294967295L;
        long j6 = ((long) iArr[18]) & 4294967295L;
        long j7 = ((long) iArr[23]) & 4294967295L;
        long j8 = ((long) iArr[16]) & 4294967295L;
        long j9 = ((((long) iArr[12]) & 4294967295L) + j2) - 1;
        long j10 = j2;
        long j11 = (((long) iArr[13]) & 4294967295L) + j5;
        long j12 = (((long) iArr[14]) & 4294967295L) + j5 + j7;
        long j13 = (((long) iArr[15]) & 4294967295L) + j7;
        long j14 = j + j3;
        long j15 = j3 - j7;
        long j16 = j9 + j15;
        long j17 = j5 - j7;
        long j18 = (((long) iArr[0]) & 4294967295L) + j16 + 0;
        iArr3[0] = (int) j18;
        long j19 = (((((long) iArr[1]) & 4294967295L) + j7) - j9) + j11 + (j18 >> 32);
        iArr3[1] = (int) j19;
        long j20 = (((((long) iArr[2]) & 4294967295L) - j3) - j11) + j12 + (j19 >> 32);
        iArr3[2] = (int) j20;
        long j21 = ((((long) iArr[3]) & 4294967295L) - j12) + j13 + j16 + (j20 >> 32);
        iArr3[3] = (int) j21;
        long j22 = (((((((long) iArr[4]) & 4294967295L) + j8) + j3) + j11) - j13) + j16 + (j21 >> 32);
        iArr3[4] = (int) j22;
        long j23 = ((((long) iArr[5]) & 4294967295L) - j8) + j11 + j12 + j14 + (j22 >> 32);
        iArr3[5] = (int) j23;
        long j24 = (((((long) iArr[6]) & 4294967295L) + j6) - j) + j12 + j13 + (j23 >> 32);
        iArr3[6] = (int) j24;
        long j25 = ((((((long) iArr[7]) & 4294967295L) + j8) + j4) - j6) + j13 + (j24 >> 32);
        iArr3[7] = (int) j25;
        long j26 = (((((((long) iArr[8]) & 4294967295L) + j8) + j) + j10) - j4) + (j25 >> 32);
        iArr3[8] = (int) j26;
        long j27 = (((((long) iArr[9]) & 4294967295L) + j6) - j10) + j14 + (j26 >> 32);
        iArr3[9] = (int) j27;
        long j28 = ((((((long) iArr[10]) & 4294967295L) + j6) + j4) - j15) + j17 + (j27 >> 32);
        iArr3[10] = (int) j28;
        long j29 = ((((((long) iArr[11]) & 4294967295L) + j4) + j10) - j17) + (j28 >> 32);
        iArr3[11] = (int) j29;
        d((int) ((j29 >> 32) + 1), iArr3);
    }

    public static void d(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = ((long) i) & 4294967295L;
            long j3 = (((long) iArr[0]) & 4294967295L) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = ((((long) iArr[1]) & 4294967295L) - j2) + (j3 >> 32);
            iArr[1] = (int) j4;
            long j5 = j4 >> 32;
            if (j5 != 0) {
                long j6 = j5 + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j6;
                j5 = j6 >> 32;
            }
            long j7 = (((long) iArr[3]) & 4294967295L) + j2 + j5;
            iArr[3] = (int) j7;
            long j8 = (4294967295L & ((long) iArr[4])) + j2 + (j7 >> 32);
            iArr[4] = (int) j8;
            j = j8 >> 32;
        } else {
            j = 0;
        }
        if ((j != 0 && Nat.n(12, 5, iArr) != 0) || (iArr[11] == -1 && Nat.k(iArr, 12, a))) {
            a(iArr);
        }
    }

    public static void e(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[24];
        Nat384.b(iArr, iArr3);
        c(iArr3, iArr2);
    }

    public static void f(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[24];
        Nat384.b(iArr, iArr3);
        c(iArr3, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat384.b(iArr2, iArr3);
                c(iArr3, iArr2);
            } else {
                return;
            }
        }
    }

    public static void g(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat.u(12, iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & 4294967295L) - 1;
            iArr3[0] = (int) j;
            long j2 = (((long) iArr3[1]) & 4294967295L) + 1 + (j >> 32);
            iArr3[1] = (int) j2;
            long j3 = j2 >> 32;
            if (j3 != 0) {
                long j4 = j3 + (((long) iArr3[2]) & 4294967295L);
                iArr3[2] = (int) j4;
                j3 = j4 >> 32;
            }
            long j5 = ((((long) iArr3[3]) & 4294967295L) - 1) + j3;
            iArr3[3] = (int) j5;
            long j6 = ((4294967295L & ((long) iArr3[4])) - 1) + (j5 >> 32);
            iArr3[4] = (int) j6;
            if ((j6 >> 32) != 0) {
                Nat.h(12, 5, iArr3);
            }
        }
    }
}
