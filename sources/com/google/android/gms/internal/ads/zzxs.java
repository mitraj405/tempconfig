package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzxs extends zzxp {
    private final boolean zze;
    private final zzxi zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;
    private final int zzo;
    private final boolean zzp;
    private final boolean zzq;
    private final int zzr;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x00ab A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzxs(int r5, com.google.android.gms.internal.ads.zzcd r6, int r7, com.google.android.gms.internal.ads.zzxi r8, int r9, int r10, boolean r11) {
        /*
            r4 = this;
            r4.<init>(r5, r6, r7)
            r4.zzf = r8
            boolean r5 = r8.zzE
            r6 = 1
            if (r6 == r5) goto L_0x000d
            r5 = 16
            goto L_0x000f
        L_0x000d:
            r5 = 24
        L_0x000f:
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r10 = 0
            if (r11 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzaf r0 = r4.zzd
            int r1 = r0.zzr
            float r0 = r0.zzt
            int r1 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0024
            r1 = 1325400064(0x4f000000, float:2.14748365E9)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0026
        L_0x0024:
            r0 = r6
            goto L_0x0027
        L_0x0026:
            r0 = r10
        L_0x0027:
            r4.zze = r0
            r0 = -1
            if (r11 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzaf r11 = r4.zzd
            int r1 = r11.zzr
            if (r1 == r0) goto L_0x0034
            if (r1 < 0) goto L_0x004d
        L_0x0034:
            int r1 = r11.zzs
            if (r1 == r0) goto L_0x003a
            if (r1 < 0) goto L_0x004d
        L_0x003a:
            float r1 = r11.zzt
            int r2 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0045
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x004d
        L_0x0045:
            int r11 = r11.zzi
            if (r11 == r0) goto L_0x004b
            if (r11 < 0) goto L_0x004d
        L_0x004b:
            r11 = r6
            goto L_0x004e
        L_0x004d:
            r11 = r10
        L_0x004e:
            r4.zzg = r11
            boolean r11 = com.google.android.gms.internal.ads.zzlf.zza(r9, r10)
            r4.zzh = r11
            com.google.android.gms.internal.ads.zzaf r11 = r4.zzd
            float r1 = r11.zzt
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0066
            r7 = 1092616192(0x41200000, float:10.0)
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x0066
            r7 = r6
            goto L_0x0067
        L_0x0066:
            r7 = r10
        L_0x0067:
            r4.zzi = r7
            int r7 = r11.zzi
            r4.zzj = r7
            int r7 = r11.zza()
            r4.zzk = r7
            com.google.android.gms.internal.ads.zzaf r7 = r4.zzd
            int r7 = r7.zzf
            int r7 = com.google.android.gms.internal.ads.zzxt.zzb(r7, r10)
            r4.zzm = r7
            com.google.android.gms.internal.ads.zzaf r7 = r4.zzd
            int r7 = r7.zzf
            if (r7 == 0) goto L_0x0089
            r7 = r7 & r6
            if (r7 == 0) goto L_0x0087
            goto L_0x0089
        L_0x0087:
            r7 = r10
            goto L_0x008a
        L_0x0089:
            r7 = r6
        L_0x008a:
            r4.zzn = r7
            r7 = r10
        L_0x008d:
            com.google.android.gms.internal.ads.zzfxr r11 = r8.zzl
            int r11 = r11.size()
            if (r7 >= r11) goto L_0x00ab
            com.google.android.gms.internal.ads.zzaf r11 = r4.zzd
            java.lang.String r11 = r11.zzm
            if (r11 == 0) goto L_0x00a8
            com.google.android.gms.internal.ads.zzfxr r1 = r8.zzl
            java.lang.Object r1 = r1.get(r7)
            boolean r11 = r11.equals(r1)
            if (r11 == 0) goto L_0x00a8
            goto L_0x00ae
        L_0x00a8:
            int r7 = r7 + 1
            goto L_0x008d
        L_0x00ab:
            r7 = 2147483647(0x7fffffff, float:NaN)
        L_0x00ae:
            r4.zzl = r7
            r7 = r9 & 384(0x180, float:5.38E-43)
            r8 = 128(0x80, float:1.794E-43)
            if (r7 != r8) goto L_0x00b8
            r7 = r6
            goto L_0x00b9
        L_0x00b8:
            r7 = r10
        L_0x00b9:
            r4.zzp = r7
            r7 = r9 & 64
            r8 = 64
            if (r7 != r8) goto L_0x00c3
            r7 = r6
            goto L_0x00c4
        L_0x00c3:
            r7 = r10
        L_0x00c4:
            r4.zzq = r7
            com.google.android.gms.internal.ads.zzaf r7 = r4.zzd
            java.lang.String r8 = r7.zzm
            r11 = 2
            if (r8 != 0) goto L_0x00d0
        L_0x00cd:
            r2 = r10
            goto L_0x011f
        L_0x00d0:
            int r1 = r8.hashCode()
            r2 = 4
            r3 = 3
            switch(r1) {
                case -1851077871: goto L_0x0102;
                case -1662735862: goto L_0x00f8;
                case -1662541442: goto L_0x00ee;
                case 1331836730: goto L_0x00e4;
                case 1599127257: goto L_0x00da;
                default: goto L_0x00d9;
            }
        L_0x00d9:
            goto L_0x010c
        L_0x00da:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x010c
            r8 = r3
            goto L_0x010d
        L_0x00e4:
            java.lang.String r1 = "video/avc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x010c
            r8 = r2
            goto L_0x010d
        L_0x00ee:
            java.lang.String r1 = "video/hevc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x010c
            r8 = r11
            goto L_0x010d
        L_0x00f8:
            java.lang.String r1 = "video/av01"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x010c
            r8 = r6
            goto L_0x010d
        L_0x0102:
            java.lang.String r1 = "video/dolby-vision"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x010c
            r8 = r10
            goto L_0x010d
        L_0x010c:
            r8 = r0
        L_0x010d:
            if (r8 == 0) goto L_0x011e
            if (r8 == r6) goto L_0x011f
            if (r8 == r11) goto L_0x011c
            if (r8 == r3) goto L_0x011a
            if (r8 == r2) goto L_0x0118
            goto L_0x00cd
        L_0x0118:
            r2 = r6
            goto L_0x011f
        L_0x011a:
            r2 = r11
            goto L_0x011f
        L_0x011c:
            r2 = r3
            goto L_0x011f
        L_0x011e:
            r2 = 5
        L_0x011f:
            r4.zzr = r2
            int r8 = r7.zzf
            r8 = r8 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x0129
        L_0x0127:
            r6 = r10
            goto L_0x0151
        L_0x0129:
            com.google.android.gms.internal.ads.zzxi r8 = r4.zzf
            boolean r1 = r8.zzN
            boolean r1 = com.google.android.gms.internal.ads.zzlf.zza(r9, r1)
            if (r1 != 0) goto L_0x0134
            goto L_0x0127
        L_0x0134:
            boolean r1 = r4.zze
            if (r1 != 0) goto L_0x013d
            boolean r8 = r8.zzC
            if (r8 != 0) goto L_0x013d
            goto L_0x0127
        L_0x013d:
            boolean r8 = com.google.android.gms.internal.ads.zzlf.zza(r9, r10)
            if (r8 == 0) goto L_0x0151
            boolean r8 = r4.zzg
            if (r8 == 0) goto L_0x0151
            if (r1 == 0) goto L_0x0151
            int r7 = r7.zzi
            if (r7 == r0) goto L_0x0151
            r5 = r5 & r9
            if (r5 == 0) goto L_0x0151
            r6 = r11
        L_0x0151:
            r4.zzo = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxs.<init>(int, com.google.android.gms.internal.ads.zzcd, int, com.google.android.gms.internal.ads.zzxi, int, int, boolean):void");
    }

    public static /* synthetic */ int zza(zzxs zzxs, zzxs zzxs2) {
        zzfzc zzfzc;
        if (!zzxs.zze || !zzxs.zzh) {
            zzfzc = zzxt.zzb.zza();
        } else {
            zzfzc = zzxt.zzb;
        }
        zzfxg zzj2 = zzfxg.zzj();
        boolean z = zzxs.zzf.zzy;
        return zzj2.zzc(Integer.valueOf(zzxs.zzk), Integer.valueOf(zzxs2.zzk), zzfzc).zzc(Integer.valueOf(zzxs.zzj), Integer.valueOf(zzxs2.zzj), zzfzc).zza();
    }

    public static /* synthetic */ int zzd(zzxs zzxs, zzxs zzxs2) {
        zzfxg zzc = zzfxg.zzj().zzd(zzxs.zzh, zzxs2.zzh).zzb(zzxs.zzm, zzxs2.zzm).zzd(zzxs.zzn, zzxs2.zzn).zzd(zzxs.zzi, zzxs2.zzi).zzd(zzxs.zze, zzxs2.zze).zzd(zzxs.zzg, zzxs2.zzg).zzc(Integer.valueOf(zzxs.zzl), Integer.valueOf(zzxs2.zzl), zzfzc.zzc().zza());
        boolean z = zzxs.zzp;
        zzfxg zzd = zzc.zzd(z, zzxs2.zzp);
        boolean z2 = zzxs.zzq;
        zzfxg zzd2 = zzd.zzd(z2, zzxs2.zzq);
        if (z && z2) {
            zzd2 = zzd2.zzb(zzxs.zzr, zzxs2.zzr);
        }
        return zzd2.zza();
    }

    public final int zzb() {
        return this.zzo;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzxp zzxp) {
        zzxs zzxs = (zzxs) zzxp;
        if (!zzet.zzG(this.zzd.zzm, zzxs.zzd.zzm)) {
            return false;
        }
        boolean z = this.zzf.zzF;
        if (this.zzp == zzxs.zzp && this.zzq == zzxs.zzq) {
            return true;
        }
        return false;
    }
}
