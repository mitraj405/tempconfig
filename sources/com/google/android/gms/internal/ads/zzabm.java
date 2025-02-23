package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.perf.util.Constants;
import com.google.logging.type.LogSeverity;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzabm {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {AdError.CACHE_ERROR_CODE, 2000, 1920, 1601, 1600, AdError.NO_FILL_ERROR_CODE, 1000, 960, LogSeverity.EMERGENCY_VALUE, LogSeverity.EMERGENCY_VALUE, 480, LogSeverity.WARNING_VALUE, LogSeverity.WARNING_VALUE, 2048};

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0091, code lost:
        if (r12 != 11) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0096, code lost:
        if (r12 != 11) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009b, code lost:
        if (r12 != 8) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzabl zza(com.google.android.gms.internal.ads.zzej r12) {
        /*
            r0 = 16
            int r1 = r12.zzd(r0)
            int r0 = r12.zzd(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L_0x0018
            r0 = 24
            int r0 = r12.zzd(r0)
            r2 = 7
            goto L_0x0019
        L_0x0018:
            r2 = r3
        L_0x0019:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L_0x0021
            int r0 = r0 + 2
        L_0x0021:
            r8 = r0
            r0 = 2
            int r1 = r12.zzd(r0)
            r2 = 0
            r4 = 3
            if (r1 != r4) goto L_0x003e
            r1 = r2
        L_0x002c:
            int r5 = r12.zzd(r0)
            int r5 = r5 + r1
            boolean r1 = r12.zzp()
            if (r1 != 0) goto L_0x0039
            int r5 = r5 + r4
            goto L_0x003f
        L_0x0039:
            int r5 = r5 + 1
            int r1 = r5 << 2
            goto L_0x002c
        L_0x003e:
            r5 = r1
        L_0x003f:
            r1 = 10
            int r1 = r12.zzd(r1)
            boolean r6 = r12.zzp()
            if (r6 == 0) goto L_0x0054
            int r6 = r12.zzd(r4)
            if (r6 <= 0) goto L_0x0054
            r12.zzn(r0)
        L_0x0054:
            boolean r6 = r12.zzp()
            r7 = 44100(0xac44, float:6.1797E-41)
            r9 = 48000(0xbb80, float:6.7262E-41)
            r10 = 1
            if (r10 == r6) goto L_0x0063
            r11 = r7
            goto L_0x0064
        L_0x0063:
            r11 = r9
        L_0x0064:
            int r12 = r12.zzd(r3)
            if (r11 != r7) goto L_0x0074
            r6 = 13
            if (r12 != r6) goto L_0x0074
            int[] r12 = zzb
            r12 = r12[r6]
            r9 = r12
            goto L_0x00a0
        L_0x0074:
            if (r11 != r9) goto L_0x009f
            r6 = 14
            if (r12 >= r6) goto L_0x009f
            int[] r2 = zzb
            r2 = r2[r12]
            int r1 = r1 % 5
            r6 = 8
            if (r1 == r10) goto L_0x0099
            r7 = 11
            if (r1 == r0) goto L_0x0094
            if (r1 == r4) goto L_0x0099
            if (r1 == r3) goto L_0x008d
            goto L_0x009f
        L_0x008d:
            if (r12 == r4) goto L_0x009d
            if (r12 == r6) goto L_0x009d
            if (r12 != r7) goto L_0x009f
            goto L_0x009d
        L_0x0094:
            if (r12 == r6) goto L_0x009d
            if (r12 != r7) goto L_0x009f
            goto L_0x009d
        L_0x0099:
            if (r12 == r4) goto L_0x009d
            if (r12 != r6) goto L_0x009f
        L_0x009d:
            int r2 = r2 + 1
        L_0x009f:
            r9 = r2
        L_0x00a0:
            com.google.android.gms.internal.ads.zzabl r12 = new com.google.android.gms.internal.ads.zzabl
            r6 = 2
            r10 = 0
            r4 = r12
            r7 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabm.zza(com.google.android.gms.internal.ads.zzej):com.google.android.gms.internal.ads.zzabl");
    }

    public static void zzb(int i, zzek zzek) {
        zzek.zzH(7);
        byte[] zzM = zzek.zzM();
        zzM[0] = -84;
        zzM[1] = SignedBytes.MAX_POWER_OF_TWO;
        zzM[2] = -1;
        zzM[3] = -1;
        zzM[4] = (byte) ((i >> 16) & Constants.MAX_HOST_LENGTH);
        zzM[5] = (byte) ((i >> 8) & Constants.MAX_HOST_LENGTH);
        zzM[6] = (byte) (i & Constants.MAX_HOST_LENGTH);
    }
}
