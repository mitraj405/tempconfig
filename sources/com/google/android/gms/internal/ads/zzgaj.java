package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgaj {
    public static long zza(long j, long j2) {
        boolean z;
        boolean z2 = true;
        if ((j ^ j2) < 0) {
            z = true;
        } else {
            z = false;
        }
        long j3 = j + j2;
        if ((j ^ j3) < 0) {
            z2 = false;
        }
        if (z || z2) {
            return j3;
        }
        StringBuilder sb = new StringBuilder("overflow: checkedAdd(");
        sb.append(j);
        sb.append(", ");
        throw new ArithmeticException(lf.l(sb, j2, ")"));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (r8 > 0) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r8 < 0) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r9 != false) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long zzb(long r8, long r10, java.math.RoundingMode r12) {
        /*
            r12.getClass()
            long r0 = r8 / r10
            long r2 = r10 * r0
            long r2 = r8 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0010
            goto L_0x0059
        L_0x0010:
            long r8 = r8 ^ r10
            int[] r6 = com.google.android.gms.internal.ads.zzgai.zza
            int r7 = r12.ordinal()
            r6 = r6[r7]
            r7 = 63
            long r8 = r8 >> r7
            int r8 = (int) r8
            r9 = 1
            r8 = r8 | r9
            r7 = 0
            switch(r6) {
                case 1: goto L_0x0056;
                case 2: goto L_0x0059;
                case 3: goto L_0x004d;
                case 4: goto L_0x0053;
                case 5: goto L_0x004a;
                case 6: goto L_0x0029;
                case 7: goto L_0x0029;
                case 8: goto L_0x0029;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L_0x0029:
            long r2 = java.lang.Math.abs(r2)
            long r10 = java.lang.Math.abs(r10)
            long r10 = r10 - r2
            long r2 = r2 - r10
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x0047
            java.math.RoundingMode r10 = java.math.RoundingMode.HALF_UP
            if (r12 == r10) goto L_0x0051
            java.math.RoundingMode r10 = java.math.RoundingMode.HALF_EVEN
            if (r12 != r10) goto L_0x0050
            r10 = 1
            long r10 = r10 & r0
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0050
            goto L_0x0051
        L_0x0047:
            if (r10 <= 0) goto L_0x0050
            goto L_0x0051
        L_0x004a:
            if (r8 <= 0) goto L_0x0050
            goto L_0x0051
        L_0x004d:
            if (r8 >= 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r9 = r7
        L_0x0051:
            if (r9 == 0) goto L_0x0059
        L_0x0053:
            long r8 = (long) r8
            long r0 = r0 + r8
            return r0
        L_0x0056:
            com.google.android.gms.internal.ads.zzgak.zzb(r7)
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgaj.zzb(long, long, java.math.RoundingMode):long");
    }

    public static long zzc(long j, long j2) {
        zzgak.zza("a", j);
        zzgak.zza("b", j2);
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long j3 = j >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j2);
        long j4 = j2 >> numberOfTrailingZeros2;
        while (j3 != j4) {
            long j5 = j3 - j4;
            long j6 = (j5 >> 63) & j5;
            long j7 = (j5 - j6) - j6;
            j3 = j7 >> Long.numberOfTrailingZeros(j7);
            j4 += j6;
        }
        return j3 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static long zzd(long j, long j2) {
        boolean z;
        boolean z2;
        long j3 = ~j;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(j3) + Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j4 = j ^ j2;
        boolean z3 = true;
        if (numberOfLeadingZeros < 64) {
            z = true;
        } else {
            z = false;
        }
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (j2 != Long.MIN_VALUE) {
            z3 = false;
        }
        long j5 = (j4 >>> 63) + Long.MAX_VALUE;
        if (z || (z3 & z2)) {
            return j5;
        }
        long j6 = j * j2;
        if (i == 0 || j6 / j == j2) {
            return j6;
        }
        return j5;
    }
}
