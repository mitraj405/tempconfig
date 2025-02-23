package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class SecP256K1Field {
    public static final int[] a = {-977, -2, -1, -1, -1, -1, -1, -1};
    public static final int[] b = {954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};
    public static final int[] c = {-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[16];
        Nat256.o(iArr, iArr2, iArr4);
        b(iArr4, iArr3);
    }

    public static void b(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) 977) & 4294967295L;
        long j2 = ((long) iArr[8]) & 4294967295L;
        long j3 = (j * j2) + (((long) iArr[0]) & 4294967295L) + 0;
        int i = (int) j3;
        iArr3[0] = i;
        long j4 = ((long) iArr[9]) & 4294967295L;
        long j5 = (j * j4) + j2 + (((long) iArr[1]) & 4294967295L) + (j3 >>> 32);
        int i2 = (int) j5;
        iArr3[1] = i2;
        long j6 = ((long) iArr[10]) & 4294967295L;
        long j7 = (j * j6) + j4 + (((long) iArr[2]) & 4294967295L) + (j5 >>> 32);
        int i3 = (int) j7;
        iArr3[2] = i3;
        int i4 = i2;
        long j8 = ((long) iArr[11]) & 4294967295L;
        long j9 = j;
        long j10 = (j * j8) + j6 + (((long) iArr[3]) & 4294967295L) + (j7 >>> 32);
        int i5 = (int) j10;
        iArr3[3] = i5;
        long j11 = ((long) iArr[12]) & 4294967295L;
        long j12 = (j9 * j11) + j8 + (((long) iArr[4]) & 4294967295L) + (j10 >>> 32);
        iArr3[4] = (int) j12;
        long j13 = ((long) iArr[13]) & 4294967295L;
        long j14 = (j9 * j13) + j11 + (((long) iArr[5]) & 4294967295L) + (j12 >>> 32);
        iArr3[5] = (int) j14;
        long j15 = ((long) iArr[14]) & 4294967295L;
        long j16 = (j9 * j15) + j13 + (((long) iArr[6]) & 4294967295L) + (j14 >>> 32);
        iArr3[6] = (int) j16;
        long j17 = ((long) iArr[15]) & 4294967295L;
        long j18 = (j9 * j17) + j15 + (((long) iArr[7]) & 4294967295L) + (j16 >>> 32);
        iArr3[7] = (int) j18;
        long j19 = (j18 >>> 32) + j17;
        long j20 = j19 & 4294967295L;
        long j21 = (j9 * j20) + (((long) i) & 4294967295L) + 0;
        int i6 = 0;
        iArr3[0] = (int) j21;
        long j22 = j19 >>> 32;
        long j23 = (j9 * j22) + j20 + (((long) i4) & 4294967295L) + (j21 >>> 32);
        iArr3[1] = (int) j23;
        long j24 = j22 + (((long) i3) & 4294967295L) + (j23 >>> 32);
        iArr3[2] = (int) j24;
        long j25 = (j24 >>> 32) + (((long) i5) & 4294967295L);
        iArr3[3] = (int) j25;
        if ((j25 >>> 32) != 0) {
            i6 = Nat.o(8, 4, iArr3);
        }
        if (i6 != 0 || (iArr3[7] == -1 && Nat256.j(iArr3, a))) {
            Nat.b(8, 977, iArr3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003f, code lost:
        if (r14 == 0) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(int r14, int[] r15) {
        /*
            r0 = 8
            r1 = 977(0x3d1, float:1.369E-42)
            if (r14 == 0) goto L_0x0041
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
            if (r2 != 0) goto L_0x003a
            goto L_0x003f
        L_0x003a:
            r14 = 3
            int r14 = org.spongycastle.math.raw.Nat.o(r0, r14, r15)
        L_0x003f:
            if (r14 != 0) goto L_0x004f
        L_0x0041:
            r14 = 7
            r14 = r15[r14]
            r2 = -1
            if (r14 != r2) goto L_0x0052
            int[] r14 = a
            boolean r14 = org.spongycastle.math.raw.Nat256.j(r15, r14)
            if (r14 == 0) goto L_0x0052
        L_0x004f:
            org.spongycastle.math.raw.Nat.b(r0, r1, r15)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.sec.SecP256K1Field.c(int, int[]):void");
    }

    public static void d(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        Nat256.q(iArr, iArr3);
        b(iArr3, iArr2);
    }

    public static void e(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[16];
        Nat256.q(iArr, iArr3);
        b(iArr3, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                Nat256.q(iArr2, iArr3);
                b(iArr3, iArr2);
            } else {
                return;
            }
        }
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (Nat256.r(iArr, iArr2, iArr3) != 0) {
            Nat.v(8, 977, iArr3);
        }
    }
}
