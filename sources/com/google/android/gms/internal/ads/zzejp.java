package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzejp implements zzdgx {
    private final Context zza;
    private final zzdpl zzb;
    private final zzffg zzc;
    private final VersionInfoParcel zzd;
    private final zzfel zze;
    private final ListenableFuture zzf;
    private final zzcej zzg;
    private final zzbja zzh;
    private final boolean zzi;
    private final zzeds zzj;

    public zzejp(Context context, zzdpl zzdpl, zzffg zzffg, VersionInfoParcel versionInfoParcel, zzfel zzfel, ListenableFuture listenableFuture, zzcej zzcej, zzbja zzbja, boolean z, zzeds zzeds) {
        this.zza = context;
        this.zzb = zzdpl;
        this.zzc = zzffg;
        this.zzd = versionInfoParcel;
        this.zze = zzfel;
        this.zzf = listenableFuture;
        this.zzg = zzcej;
        this.zzh = zzbja;
        this.zzi = z;
        this.zzj = zzeds;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r22, android.content.Context r23, com.google.android.gms.internal.ads.zzcxd r24) {
        /*
            r21 = this;
            r1 = r21
            com.google.common.util.concurrent.ListenableFuture r0 = r1.zzf
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzgcj.zzq(r0)
            com.google.android.gms.internal.ads.zzdoq r0 = (com.google.android.gms.internal.ads.zzdoq) r0
            com.google.android.gms.internal.ads.zzfel r2 = r1.zze     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzcej r3 = r1.zzg     // Catch:{ zzcev -> 0x0105 }
            boolean r3 = r3.zzaG()     // Catch:{ zzcev -> 0x0105 }
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzcej r2 = r1.zzg     // Catch:{ zzcev -> 0x0105 }
        L_0x0018:
            r11 = r2
            goto L_0x007e
        L_0x001a:
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzaE     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzbbu r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzcev -> 0x0105 }
            java.lang.Object r3 = r6.zza(r3)     // Catch:{ zzcev -> 0x0105 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzcev -> 0x0105 }
            boolean r3 = r3.booleanValue()     // Catch:{ zzcev -> 0x0105 }
            if (r3 != 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzcej r2 = r1.zzg     // Catch:{ zzcev -> 0x0105 }
            goto L_0x0018
        L_0x002f:
            com.google.android.gms.internal.ads.zzdpl r3 = r1.zzb     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzffg r6 = r1.zzc     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.ads.internal.client.zzq r6 = r6.zze     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzcej r3 = r3.zza(r6, r5, r5)     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzdez r6 = r0.zzg()     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzbjp.zzb(r3, r6)     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzdpp r6 = new com.google.android.gms.internal.ads.zzdpp     // Catch:{ zzcev -> 0x0105 }
            r6.<init>()     // Catch:{ zzcev -> 0x0105 }
            android.content.Context r7 = r1.zza     // Catch:{ zzcev -> 0x0105 }
            r8 = r3
            android.view.View r8 = (android.view.View) r8     // Catch:{ zzcev -> 0x0105 }
            r6.zza(r7, r8)     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzdpk r7 = r0.zzl()     // Catch:{ zzcev -> 0x0105 }
            boolean r8 = r1.zzi     // Catch:{ zzcev -> 0x0105 }
            if (r8 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzbja r8 = r1.zzh     // Catch:{ zzcev -> 0x0105 }
            goto L_0x0059
        L_0x0058:
            r8 = r5
        L_0x0059:
            r7.zzi(r3, r4, r8)     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzcgb r7 = r3.zzN()     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzejn r8 = new com.google.android.gms.internal.ads.zzejn     // Catch:{ zzcev -> 0x0105 }
            r8.<init>(r6, r3)     // Catch:{ zzcev -> 0x0105 }
            r7.zzB(r8)     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzcgb r6 = r3.zzN()     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzejo r7 = new com.google.android.gms.internal.ads.zzejo     // Catch:{ zzcev -> 0x0105 }
            r7.<init>(r3)     // Catch:{ zzcev -> 0x0105 }
            r6.zzH(r7)     // Catch:{ zzcev -> 0x0105 }
            com.google.android.gms.internal.ads.zzfeq r2 = r2.zzs     // Catch:{ zzcev -> 0x0105 }
            java.lang.String r6 = r2.zzb     // Catch:{ zzcev -> 0x0105 }
            java.lang.String r2 = r2.zza     // Catch:{ zzcev -> 0x0105 }
            r3.zzae(r6, r2, r5)     // Catch:{ zzcev -> 0x0105 }
            r11 = r3
        L_0x007e:
            r11.zzaq(r4)
            boolean r2 = r1.zzi
            com.google.android.gms.ads.internal.zzk r3 = new com.google.android.gms.ads.internal.zzk
            r6 = 0
            if (r2 == 0) goto L_0x0090
            com.google.android.gms.internal.ads.zzbja r2 = r1.zzh
            boolean r2 = r2.zze(r6)
            r13 = r2
            goto L_0x0091
        L_0x0090:
            r13 = r6
        L_0x0091:
            com.google.android.gms.ads.internal.zzu.zzp()
            android.content.Context r2 = r1.zza
            boolean r7 = r1.zzi
            boolean r14 = com.google.android.gms.ads.internal.util.zzt.zzI(r2)
            if (r7 == 0) goto L_0x00a6
            com.google.android.gms.internal.ads.zzbja r2 = r1.zzh
            boolean r2 = r2.zzd()
            r15 = r2
            goto L_0x00a7
        L_0x00a6:
            r15 = r6
        L_0x00a7:
            boolean r2 = r1.zzi
            if (r2 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzbja r2 = r1.zzh
            float r2 = r2.zza()
            goto L_0x00b3
        L_0x00b2:
            r2 = 0
        L_0x00b3:
            r16 = r2
            com.google.android.gms.internal.ads.zzfel r2 = r1.zze
            r17 = -1
            boolean r6 = r2.zzO
            boolean r2 = r2.zzP
            r12 = r3
            r18 = r22
            r19 = r6
            r20 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
            if (r24 == 0) goto L_0x00cc
            r24.zzf()
        L_0x00cc:
            com.google.android.gms.ads.internal.zzu.zzi()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r2 = new com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
            com.google.android.gms.internal.ads.zzdgm r9 = r0.zzh()
            com.google.android.gms.internal.ads.zzfel r0 = r1.zze
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r13 = r1.zzd
            int r12 = r0.zzQ
            java.lang.String r14 = r0.zzB
            com.google.android.gms.internal.ads.zzfeq r6 = r0.zzs
            java.lang.String r15 = r6.zzb
            java.lang.String r6 = r6.zza
            com.google.android.gms.internal.ads.zzffg r7 = r1.zzc
            boolean r0 = r0.zzai
            if (r0 == 0) goto L_0x00eb
            com.google.android.gms.internal.ads.zzeds r5 = r1.zzj
        L_0x00eb:
            r20 = r5
            r8 = 0
            r10 = 0
            java.lang.String r0 = r7.zzf
            r7 = r2
            r5 = r15
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r0
            r19 = r24
            r7.<init>((com.google.android.gms.ads.internal.client.zza) r8, (com.google.android.gms.ads.internal.overlay.zzp) r9, (com.google.android.gms.ads.internal.overlay.zzaa) r10, (com.google.android.gms.internal.ads.zzcej) r11, (int) r12, (com.google.android.gms.ads.internal.util.client.VersionInfoParcel) r13, (java.lang.String) r14, (com.google.android.gms.ads.internal.zzk) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (com.google.android.gms.internal.ads.zzcxd) r19, (com.google.android.gms.internal.ads.zzbsg) r20)
            r0 = r23
            com.google.android.gms.ads.internal.overlay.zzn.zza(r0, r2, r4)
            return
        L_0x0105:
            r0 = move-exception
            java.lang.String r2 = ""
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejp.zza(boolean, android.content.Context, com.google.android.gms.internal.ads.zzcxd):void");
    }
}
