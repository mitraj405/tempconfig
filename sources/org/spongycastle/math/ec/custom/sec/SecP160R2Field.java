package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat160;

public class SecP160R2Field {
    public static final int[] a = {-21389, -2, -1, -1, -1};
    public static final int[] b = {457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};
    public static final int[] c = {-457489321, -42779, -2, -1, -1, 42777, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[10];
        Nat160.h(iArr, iArr2, iArr4);
        c(iArr4, iArr3);
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if ((Nat160.i(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && Nat.k(iArr3, 10, b))) && Nat.d(c, 7, iArr3) != 0) {
            Nat.n(10, 7, iArr3);
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        int i;
        int[] iArr3 = iArr2;
        long j = ((long) 21389) & 4294967295L;
        long j2 = ((long) iArr[5]) & 4294967295L;
        long j3 = (j * j2) + (((long) iArr[0]) & 4294967295L) + 0;
        int i2 = (int) j3;
        iArr3[0] = i2;
        long j4 = ((long) iArr[6]) & 4294967295L;
        long j5 = (j * j4) + j2 + (((long) iArr[1]) & 4294967295L) + (j3 >>> 32);
        int i3 = (int) j5;
        iArr3[1] = i3;
        long j6 = ((long) iArr[7]) & 4294967295L;
        long j7 = (j * j6) + j4 + (((long) iArr[2]) & 4294967295L) + (j5 >>> 32);
        int i4 = (int) j7;
        iArr3[2] = i4;
        int i5 = i3;
        long j8 = ((long) iArr[8]) & 4294967295L;
        long j9 = j;
        long j10 = (j * j8) + j6 + (((long) iArr[3]) & 4294967295L) + (j7 >>> 32);
        int i6 = (int) j10;
        iArr3[3] = i6;
        long j11 = ((long) iArr[9]) & 4294967295L;
        long j12 = (j9 * j11) + j8 + (((long) iArr[4]) & 4294967295L) + (j10 >>> 32);
        iArr3[4] = (int) j12;
        long j13 = (j12 >>> 32) + j11;
        long j14 = j13 & 4294967295L;
        long j15 = (j9 * j14) + (((long) i2) & 4294967295L) + 0;
        iArr3[0] = (int) j15;
        long j16 = j13 >>> 32;
        long j17 = (j9 * j16) + j14 + (((long) i5) & 4294967295L) + (j15 >>> 32);
        iArr3[1] = (int) j17;
        long j18 = j16 + (((long) i4) & 4294967295L) + (j17 >>> 32);
        iArr3[2] = (int) j18;
        long j19 = (j18 >>> 32) + (((long) i6) & 4294967295L);
        iArr3[3] = (int) j19;
        if ((j19 >>> 32) == 0) {
            i = 0;
        } else {
            i = Nat.o(5, 4, iArr3);
        }
        if (i != 0 || (iArr3[4] == -1 && Nat160.e(iArr3, a))) {
            Nat.b(5, 21389, iArr3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003e, code lost:
        if (r14 == 0) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(int r14, int[] r15) {
        /*
            r0 = 5
            r1 = 21389(0x538d, float:2.9972E-41)
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
            r14 = 4
            r14 = r15[r14]
            r2 = -1
            if (r14 != r2) goto L_0x0051
            int[] r14 = a
            boolean r14 = org.spongycastle.math.raw.Nat160.e(r15, r14)
            if (r14 == 0) goto L_0x0051
        L_0x004e:
            org.spongycastle.math.raw.Nat.b(r0, r1, r15)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.sec.SecP160R2Field.d(int, int[]):void");
    }

    public static void e(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        Nat160.j(iArr, iArr3);
        c(iArr3, iArr2);
    }

    public static void f(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[10];
        Nat160.j(iArr, iArr3);
        c(iArr3, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat160.j(iArr2, iArr3);
                c(iArr3, iArr2);
            } else {
                return;
            }
        }
    }

    public static void g(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat160.k(iArr, iArr2, iArr3) != 0) {
            Nat.v(5, 21389, iArr3);
        }
    }
}
