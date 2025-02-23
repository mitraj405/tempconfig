package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzalq {
    public long zza = 0;
    public long zzb = 0;
    public CharSequence zzc;
    public int zzd = 2;
    public float zze = -3.4028235E38f;
    public int zzf = 1;
    public int zzg = 0;
    public float zzh = -3.4028235E38f;
    public int zzi = Integer.MIN_VALUE;
    public float zzj = 1.0f;
    public int zzk = Integer.MIN_VALUE;

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006f, code lost:
        if (r6 == 0) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzcz zza() {
        /*
            r13 = this;
            float r0 = r13.zzh
            r1 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r3 = 1056964608(0x3f000000, float:0.5)
            r4 = 0
            r5 = 5
            r6 = 4
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x0011
            goto L_0x001c
        L_0x0011:
            int r0 = r13.zzd
            if (r0 == r6) goto L_0x001b
            if (r0 == r5) goto L_0x0019
            r0 = r3
            goto L_0x001c
        L_0x0019:
            r0 = r7
            goto L_0x001c
        L_0x001b:
            r0 = r4
        L_0x001c:
            int r2 = r13.zzi
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = 3
            r10 = 2
            r11 = 1
            if (r2 == r8) goto L_0x0026
            goto L_0x0035
        L_0x0026:
            int r2 = r13.zzd
            if (r2 == r11) goto L_0x0034
            if (r2 == r9) goto L_0x0032
            if (r2 == r6) goto L_0x0034
            if (r2 == r5) goto L_0x0032
            r2 = r11
            goto L_0x0035
        L_0x0032:
            r2 = r10
            goto L_0x0035
        L_0x0034:
            r2 = 0
        L_0x0035:
            com.google.android.gms.internal.ads.zzcz r8 = new com.google.android.gms.internal.ads.zzcz
            r8.<init>()
            int r12 = r13.zzd
            if (r12 == r11) goto L_0x0055
            if (r12 == r10) goto L_0x0052
            if (r12 == r9) goto L_0x004f
            if (r12 == r6) goto L_0x0055
            if (r12 == r5) goto L_0x004f
            java.lang.String r5 = "Unknown textAlignment: "
            java.lang.String r6 = "WebvttCueParser"
            defpackage.C0709Uj.t(r5, r12, r6)
            r5 = 0
            goto L_0x0057
        L_0x004f:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            goto L_0x0057
        L_0x0052:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_CENTER
            goto L_0x0057
        L_0x0055:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
        L_0x0057:
            r8.zzm(r5)
            float r5 = r13.zze
            int r6 = r13.zzf
            int r9 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r9 == 0) goto L_0x006d
            if (r6 != 0) goto L_0x006d
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x0071
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x006d
            goto L_0x0071
        L_0x006d:
            if (r9 != 0) goto L_0x0073
            if (r6 != 0) goto L_0x0074
        L_0x0071:
            r1 = r7
            goto L_0x0074
        L_0x0073:
            r1 = r5
        L_0x0074:
            r8.zze(r1, r6)
            int r1 = r13.zzg
            r8.zzf(r1)
            r8.zzh(r0)
            r8.zzi(r2)
            float r1 = r13.zzj
            if (r2 == 0) goto L_0x009f
            if (r2 == r11) goto L_0x0095
            if (r2 != r10) goto L_0x008b
            goto L_0x00a1
        L_0x008b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r0.<init>(r1)
            throw r0
        L_0x0095:
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x009b
            float r0 = r0 + r0
            goto L_0x00a1
        L_0x009b:
            float r7 = r7 - r0
            float r0 = r7 + r7
            goto L_0x00a1
        L_0x009f:
            float r0 = r7 - r0
        L_0x00a1:
            float r0 = java.lang.Math.min(r1, r0)
            r8.zzk(r0)
            int r0 = r13.zzk
            r8.zzo(r0)
            java.lang.CharSequence r0 = r13.zzc
            if (r0 == 0) goto L_0x00b4
            r8.zzl(r0)
        L_0x00b4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalq.zza():com.google.android.gms.internal.ads.zzcz");
    }
}
