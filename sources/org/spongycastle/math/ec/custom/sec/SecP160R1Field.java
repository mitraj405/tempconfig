package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat160;

public class SecP160R1Field {
    public static final int[] a = {Integer.MAX_VALUE, -1, -1, -1, -1};
    public static final int[] b = {1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};
    public static final int[] c = {-1, -1073741826, -1, -1, -1, 1, 1};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[10];
        Nat160.h(iArr, iArr2, iArr4);
        b(iArr4, iArr3);
    }

    public static void b(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[5]) & 4294967295L;
        long j2 = ((long) iArr[6]) & 4294967295L;
        long j3 = ((long) iArr[7]) & 4294967295L;
        long j4 = ((long) iArr[8]) & 4294967295L;
        long j5 = ((long) iArr[9]) & 4294967295L;
        long j6 = (((long) iArr[0]) & 4294967295L) + j + (j << 31) + 0;
        iArr3[0] = (int) j6;
        long j7 = (((long) iArr[1]) & 4294967295L) + j2 + (j2 << 31) + (j6 >>> 32);
        iArr3[1] = (int) j7;
        long j8 = (((long) iArr[2]) & 4294967295L) + j3 + (j3 << 31) + (j7 >>> 32);
        iArr3[2] = (int) j8;
        long j9 = (((long) iArr[3]) & 4294967295L) + j4 + (j4 << 31) + (j8 >>> 32);
        iArr3[3] = (int) j9;
        long j10 = (4294967295L & ((long) iArr[4])) + j5 + (j5 << 31) + (j9 >>> 32);
        iArr3[4] = (int) j10;
        c((int) (j10 >>> 32), iArr3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0034, code lost:
        if (r12 == 0) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(int r12, int[] r13) {
        /*
            r0 = 5
            r1 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            if (r12 == 0) goto L_0x0036
            long r2 = (long) r1
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            long r6 = (long) r12
            long r6 = r6 & r4
            long r6 = r6 * r2
            r12 = 0
            r2 = r13[r12]
            long r2 = (long) r2
            long r2 = r2 & r4
            long r6 = r6 + r2
            r2 = 0
            long r6 = r6 + r2
            int r8 = (int) r6
            r13[r12] = r8
            r8 = 32
            long r6 = r6 >>> r8
            r9 = 1
            r10 = r13[r9]
            long r10 = (long) r10
            long r4 = r4 & r10
            long r6 = r6 + r4
            int r4 = (int) r6
            r13[r9] = r4
            long r4 = r6 >>> r8
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x002f
            goto L_0x0034
        L_0x002f:
            r12 = 2
            int r12 = org.spongycastle.math.raw.Nat.o(r0, r12, r13)
        L_0x0034:
            if (r12 != 0) goto L_0x0044
        L_0x0036:
            r12 = 4
            r12 = r13[r12]
            r2 = -1
            if (r12 != r2) goto L_0x0047
            int[] r12 = a
            boolean r12 = org.spongycastle.math.raw.Nat160.e(r13, r12)
            if (r12 == 0) goto L_0x0047
        L_0x0044:
            org.spongycastle.math.raw.Nat.g(r0, r1, r13)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.sec.SecP160R1Field.c(int, int[]):void");
    }

    public static void d(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        Nat160.j(iArr, iArr3);
        b(iArr3, iArr2);
    }

    public static void e(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[10];
        Nat160.j(iArr, iArr3);
        b(iArr3, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat160.j(iArr2, iArr3);
                b(iArr3, iArr2);
            } else {
                return;
            }
        }
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat160.k(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & 4294967295L) - (4294967295L & ((long) -2147483647));
            iArr3[0] = (int) j;
            if ((j >> 32) != 0) {
                Nat.h(5, 1, iArr3);
            }
        }
    }
}
