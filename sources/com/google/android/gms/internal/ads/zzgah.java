package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgah {
    public static int zza(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        int i3 = (int) j;
        if (j == ((long) i3)) {
            return i3;
        }
        throw new ArithmeticException("overflow: checkedAdd(" + i + ", " + i2 + ")");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if ((r7 & (r6 & 1)) != 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r0 > 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r5 > 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        if (r5 < 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (r3 != false) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(int r5, int r6, java.math.RoundingMode r7) {
        /*
            r7.getClass()
            int r6 = r5 / 8
            int r0 = r6 * 8
            int r0 = r5 - r0
            if (r0 != 0) goto L_0x000c
            goto L_0x0053
        L_0x000c:
            r1 = 8
            r5 = r5 ^ r1
            int[] r2 = com.google.android.gms.internal.ads.zzgag.zza
            int r3 = r7.ordinal()
            r2 = r2[r3]
            int r5 = r5 >> 31
            r3 = 1
            r5 = r5 | r3
            r4 = 0
            switch(r2) {
                case 1: goto L_0x0050;
                case 2: goto L_0x0053;
                case 3: goto L_0x0048;
                case 4: goto L_0x004e;
                case 5: goto L_0x0045;
                case 6: goto L_0x0025;
                case 7: goto L_0x0025;
                case 8: goto L_0x0025;
                default: goto L_0x001f;
            }
        L_0x001f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L_0x0025:
            int r0 = java.lang.Math.abs(r0)
            int r1 = java.lang.Math.abs(r1)
            int r1 = r1 - r0
            int r0 = r0 - r1
            if (r0 != 0) goto L_0x0042
            java.math.RoundingMode r0 = java.math.RoundingMode.HALF_UP
            if (r7 == r0) goto L_0x004c
            java.math.RoundingMode r0 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r0) goto L_0x003b
            r7 = r3
            goto L_0x003c
        L_0x003b:
            r7 = r4
        L_0x003c:
            r0 = r6 & 1
            r7 = r7 & r0
            if (r7 == 0) goto L_0x004b
            goto L_0x004c
        L_0x0042:
            if (r0 <= 0) goto L_0x004b
            goto L_0x004c
        L_0x0045:
            if (r5 <= 0) goto L_0x004b
            goto L_0x004c
        L_0x0048:
            if (r5 >= 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r3 = r4
        L_0x004c:
            if (r3 == 0) goto L_0x0053
        L_0x004e:
            int r6 = r6 + r5
            return r6
        L_0x0050:
            com.google.android.gms.internal.ads.zzgak.zzb(r4)
        L_0x0053:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgah.zzb(int, int, java.math.RoundingMode):int");
    }
}
