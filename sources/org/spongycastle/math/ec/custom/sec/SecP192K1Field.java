package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;

public class SecP192K1Field {
    public static final int[] a = {-4553, -2, -1, -1, -1, -1};
    public static final int[] b = {20729809, 9106, 1, 0, 0, 0, -9106, -3, -1, -1, -1, -1};
    public static final int[] c = {-20729809, -9107, -2, -1, -1, -1, 9105, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[12];
        Nat192.m(iArr, iArr2, iArr4);
        b(iArr4, iArr3);
    }

    public static void b(int[] iArr, int[] iArr2) {
        int i;
        int[] iArr3 = iArr2;
        long j = ((long) 4553) & 4294967295L;
        long j2 = ((long) iArr[6]) & 4294967295L;
        long j3 = (j * j2) + (((long) iArr[0]) & 4294967295L) + 0;
        int i2 = (int) j3;
        iArr3[0] = i2;
        long j4 = ((long) iArr[7]) & 4294967295L;
        long j5 = (j * j4) + j2 + (((long) iArr[1]) & 4294967295L) + (j3 >>> 32);
        int i3 = (int) j5;
        iArr3[1] = i3;
        long j6 = ((long) iArr[8]) & 4294967295L;
        long j7 = (j * j6) + j4 + (((long) iArr[2]) & 4294967295L) + (j5 >>> 32);
        int i4 = (int) j7;
        iArr3[2] = i4;
        long j8 = ((long) iArr[9]) & 4294967295L;
        long j9 = j;
        long j10 = (j * j8) + j6 + (((long) iArr[3]) & 4294967295L) + (j7 >>> 32);
        int i5 = (int) j10;
        iArr3[3] = i5;
        long j11 = ((long) iArr[10]) & 4294967295L;
        long j12 = (j9 * j11) + j8 + (((long) iArr[4]) & 4294967295L) + (j10 >>> 32);
        iArr3[4] = (int) j12;
        long j13 = ((long) iArr[11]) & 4294967295L;
        long j14 = (j9 * j13) + j11 + (((long) iArr[5]) & 4294967295L) + (j12 >>> 32);
        iArr3[5] = (int) j14;
        long j15 = (j14 >>> 32) + j13;
        long j16 = j15 & 4294967295L;
        long j17 = (j9 * j16) + (((long) i2) & 4294967295L) + 0;
        iArr3[0] = (int) j17;
        long j18 = j15 >>> 32;
        long j19 = (j9 * j18) + j16 + (((long) i3) & 4294967295L) + (j17 >>> 32);
        iArr3[1] = (int) j19;
        long j20 = j18 + (((long) i4) & 4294967295L) + (j19 >>> 32);
        iArr3[2] = (int) j20;
        long j21 = (j20 >>> 32) + (((long) i5) & 4294967295L);
        iArr3[3] = (int) j21;
        if ((j21 >>> 32) == 0) {
            i = 0;
        } else {
            i = Nat.o(6, 4, iArr3);
        }
        if (i != 0 || (iArr3[5] == -1 && Nat192.i(iArr3, a))) {
            Nat.b(6, 4553, iArr3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003e, code lost:
        if (r14 == 0) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(int r14, int[] r15) {
        /*
            r0 = 6
            r1 = 4553(0x11c9, float:6.38E-42)
            if (r14 == 0) goto L_0x0040
            long r2 = (long) r1
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            long r6 = (long) r14
            long r6 = r6 & r4
            long r2 = r2 * r6
            r14 = 0
            r8 = r15[r14]
            long r8 = (long) r8
            long r8 = r8 & r4
            long r2 = r2 + r8
            r8 = 0
            long r2 = r2 + r8
            int r10 = (int) r2
            r15[r14] = r10
            r10 = 32
            long r2 = r2 >>> r10
            r11 = 1
            r12 = r15[r11]
            long r12 = (long) r12
            long r12 = r12 & r4
            long r6 = r6 + r12
            long r6 = r6 + r2
            int r2 = (int) r6
            r15[r11] = r2
            long r2 = r6 >>> r10
            r6 = 2
            r7 = r15[r6]
            long r11 = (long) r7
            long r4 = r4 & r11
            long r2 = r2 + r4
            int r4 = (int) r2
            r15[r6] = r4
            long r2 = r2 >>> r10
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0039
            goto L_0x003e
        L_0x0039:
            r14 = 3
            int r14 = org.spongycastle.math.raw.Nat.o(r0, r14, r15)
        L_0x003e:
            if (r14 != 0) goto L_0x004e
        L_0x0040:
            r14 = 5
            r14 = r15[r14]
            r2 = -1
            if (r14 != r2) goto L_0x0051
            int[] r14 = a
            boolean r14 = org.spongycastle.math.raw.Nat192.i(r15, r14)
            if (r14 == 0) goto L_0x0051
        L_0x004e:
            org.spongycastle.math.raw.Nat.b(r0, r1, r15)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.sec.SecP192K1Field.c(int, int[]):void");
    }

    public static void d(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[12];
        Nat192.o(iArr, iArr3);
        b(iArr3, iArr2);
    }

    public static void e(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[12];
        Nat192.o(iArr, iArr3);
        b(iArr3, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat192.o(iArr2, iArr3);
                b(iArr3, iArr2);
            } else {
                return;
            }
        }
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat192.p(iArr, iArr2, iArr3) != 0) {
            Nat.v(6, 4553, iArr3);
        }
    }
}
