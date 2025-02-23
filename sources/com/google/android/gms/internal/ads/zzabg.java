package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzabg {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzabf zza(byte[] bArr) throws zzbo {
        return zzb(new zzej(bArr, bArr.length), false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a6, code lost:
        if (r11 != 3) goto L_0x00c3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzabf zzb(com.google.android.gms.internal.ads.zzej r11, boolean r12) throws com.google.android.gms.internal.ads.zzbo {
        /*
            int r0 = zzc(r11)
            int r1 = zzd(r11)
            r2 = 4
            int r3 = r11.zzd(r2)
            java.lang.String r4 = "mp4a.40."
            java.lang.String r4 = defpackage.lf.h(r4, r0)
            r5 = 5
            r6 = 22
            if (r0 == r5) goto L_0x001c
            r5 = 29
            if (r0 != r5) goto L_0x002a
        L_0x001c:
            int r1 = zzd(r11)
            int r0 = zzc(r11)
            if (r0 != r6) goto L_0x002a
            int r3 = r11.zzd(r2)
        L_0x002a:
            if (r12 == 0) goto L_0x00c3
            r12 = 17
            r5 = 6
            r7 = 1
            r8 = 2
            r9 = 3
            if (r0 == r7) goto L_0x0057
            if (r0 == r8) goto L_0x0057
            if (r0 == r9) goto L_0x0057
            if (r0 == r2) goto L_0x0057
            if (r0 == r5) goto L_0x0057
            r2 = 7
            if (r0 == r2) goto L_0x0057
            if (r0 == r12) goto L_0x0057
            switch(r0) {
                case 19: goto L_0x0057;
                case 20: goto L_0x0057;
                case 21: goto L_0x0057;
                case 22: goto L_0x0057;
                case 23: goto L_0x0057;
                default: goto L_0x0044;
            }
        L_0x0044:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Unsupported audio object type: "
            r11.<init>(r12)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.google.android.gms.internal.ads.zzbo r11 = com.google.android.gms.internal.ads.zzbo.zzc(r11)
            throw r11
        L_0x0057:
            boolean r2 = r11.zzp()
            if (r2 == 0) goto L_0x0064
            java.lang.String r2 = "AacUtil"
            java.lang.String r10 = "Unexpected frameLengthFlag = 1"
            com.google.android.gms.internal.ads.zzea.zzf(r2, r10)
        L_0x0064:
            boolean r2 = r11.zzp()
            if (r2 == 0) goto L_0x006f
            r2 = 14
            r11.zzn(r2)
        L_0x006f:
            boolean r2 = r11.zzp()
            if (r3 == 0) goto L_0x00bd
            r10 = 20
            if (r0 == r5) goto L_0x007c
            if (r0 != r10) goto L_0x007f
            r0 = r10
        L_0x007c:
            r11.zzn(r9)
        L_0x007f:
            if (r2 == 0) goto L_0x009c
            if (r0 != r6) goto L_0x0089
            r2 = 16
            r11.zzn(r2)
            goto L_0x008a
        L_0x0089:
            r6 = r0
        L_0x008a:
            if (r6 == r12) goto L_0x0096
            r12 = 19
            if (r6 == r12) goto L_0x0096
            if (r6 == r10) goto L_0x0096
            r12 = 23
            if (r6 != r12) goto L_0x0099
        L_0x0096:
            r11.zzn(r9)
        L_0x0099:
            r11.zzn(r7)
        L_0x009c:
            switch(r0) {
                case 17: goto L_0x00a0;
                case 18: goto L_0x009f;
                case 19: goto L_0x00a0;
                case 20: goto L_0x00a0;
                case 21: goto L_0x00a0;
                case 22: goto L_0x00a0;
                case 23: goto L_0x00a0;
                default: goto L_0x009f;
            }
        L_0x009f:
            goto L_0x00c3
        L_0x00a0:
            int r11 = r11.zzd(r8)
            if (r11 == r8) goto L_0x00a9
            if (r11 == r9) goto L_0x00aa
            goto L_0x00c3
        L_0x00a9:
            r9 = r11
        L_0x00aa:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Unsupported epConfig: "
            r11.<init>(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            com.google.android.gms.internal.ads.zzbo r11 = com.google.android.gms.internal.ads.zzbo.zzc(r11)
            throw r11
        L_0x00bd:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            r11.<init>()
            throw r11
        L_0x00c3:
            int[] r11 = zzc
            r11 = r11[r3]
            r12 = -1
            r0 = 0
            if (r11 == r12) goto L_0x00d1
            com.google.android.gms.internal.ads.zzabf r12 = new com.google.android.gms.internal.ads.zzabf
            r12.<init>(r1, r11, r4, r0)
            return r12
        L_0x00d1:
            com.google.android.gms.internal.ads.zzbo r11 = com.google.android.gms.internal.ads.zzbo.zza(r0, r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabg.zzb(com.google.android.gms.internal.ads.zzej, boolean):com.google.android.gms.internal.ads.zzabf");
    }

    private static int zzc(zzej zzej) {
        int zzd = zzej.zzd(5);
        if (zzd == 31) {
            return zzej.zzd(6) + 32;
        }
        return zzd;
    }

    private static int zzd(zzej zzej) throws zzbo {
        int zzd = zzej.zzd(4);
        if (zzd == 15) {
            if (zzej.zza() >= 24) {
                return zzej.zzd(24);
            }
            throw zzbo.zza("AAC header insufficient data", (Throwable) null);
        } else if (zzd < 13) {
            return zzb[zzd];
        } else {
            throw zzbo.zza("AAC header wrong Sampling Frequency Index", (Throwable) null);
        }
    }
}
