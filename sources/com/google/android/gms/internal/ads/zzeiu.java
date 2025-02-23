package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeiu implements zzgbq {
    private final zzfjl zza;
    private final zzcws zzb;
    private final zzflh zzc;
    private final zzfll zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcrx zzg;
    private final zzein zzh;
    private final zzeey zzi;
    private final Context zzj;
    private final zzfkf zzk;
    private final zzehx zzl;
    private final zzdsf zzm;

    public zzeiu(Context context, zzfjl zzfjl, zzein zzein, zzcws zzcws, zzflh zzflh, zzfll zzfll, zzcrx zzcrx, Executor executor, ScheduledExecutorService scheduledExecutorService, zzeey zzeey, zzfkf zzfkf, zzehx zzehx, zzdsf zzdsf) {
        this.zzj = context;
        this.zza = zzfjl;
        this.zzh = zzein;
        this.zzb = zzcws;
        this.zzc = zzflh;
        this.zzd = zzfll;
        this.zzg = zzcrx;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzeey;
        this.zzk = zzfkf;
        this.zzl = zzehx;
        this.zzm = zzdsf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzeR)).booleanValue() == false) goto L_0x004d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zzc(com.google.android.gms.internal.ads.zzfex r5) {
        /*
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzeS
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.String r1 = "No fill."
            r2 = 1
            if (r2 == r0) goto L_0x0018
            java.lang.String r0 = "No ad config."
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            com.google.android.gms.internal.ads.zzfew r2 = r5.zzb
            com.google.android.gms.internal.ads.zzfeo r2 = r2.zzb
            int r2 = r2.zzf
            if (r2 == 0) goto L_0x004c
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 < r3) goto L_0x003c
            if (r2 >= r4) goto L_0x003c
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzeR
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x004c
            goto L_0x004d
        L_0x003c:
            if (r2 < r4) goto L_0x0045
            r0 = 400(0x190, float:5.6E-43)
            if (r2 >= r0) goto L_0x0045
            java.lang.String r1 = "No location header to follow redirect or too many redirects."
            goto L_0x004d
        L_0x0045:
            java.lang.String r0 = "Received error HTTP response code: "
            java.lang.String r1 = defpackage.lf.h(r0, r2)
            goto L_0x004d
        L_0x004c:
            r1 = r0
        L_0x004d:
            com.google.android.gms.internal.ads.zzfew r5 = r5.zzb
            com.google.android.gms.internal.ads.zzfeo r5 = r5.zzb
            com.google.android.gms.internal.ads.zzfen r5 = r5.zzj
            if (r5 == 0) goto L_0x005a
            java.lang.String r5 = r5.zza()
            return r5
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiu.zzc(com.google.android.gms.internal.ads.zzfex):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture zza(java.lang.Object r9) throws java.lang.Exception {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzfex r9 = (com.google.android.gms.internal.ads.zzfex) r9
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzbS
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzfew r0 = r9.zzb
            com.google.android.gms.internal.ads.zzbvb r0 = r0.zzd
            if (r0 == 0) goto L_0x0027
            android.os.Bundle r0 = r0.zzm
            if (r0 == 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzdsf r1 = r8.zzm
            android.os.Bundle r1 = r1.zza()
            r1.putAll(r0)
        L_0x0027:
            java.lang.String r0 = zzc(r9)
            com.google.android.gms.internal.ads.zzeey r1 = r8.zzi
            com.google.android.gms.internal.ads.zzfew r2 = r9.zzb
            com.google.android.gms.internal.ads.zzfeo r2 = r2.zzb
            r1.zzi(r2)
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzhx
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r2 = 3
            if (r1 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzfew r1 = r9.zzb
            com.google.android.gms.internal.ads.zzfeo r1 = r1.zzb
            int r1 = r1.zzf
            if (r1 == 0) goto L_0x0062
            r3 = 200(0xc8, float:2.8E-43)
            if (r1 < r3) goto L_0x0057
            r3 = 300(0x12c, float:4.2E-43)
            if (r1 < r3) goto L_0x0062
        L_0x0057:
            com.google.android.gms.internal.ads.zzeir r9 = new com.google.android.gms.internal.ads.zzeir
            r9.<init>(r2, r0)
            com.google.common.util.concurrent.ListenableFuture r9 = com.google.android.gms.internal.ads.zzgcj.zzg(r9)
            goto L_0x018d
        L_0x0062:
            com.google.android.gms.internal.ads.zzfew r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfeo r0 = r0.zzb
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzdi
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r3.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r3 = 1
            if (r1 == 0) goto L_0x008b
            java.lang.String r0 = r0.zzq
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x008b
            com.google.android.gms.internal.ads.zzeey r1 = r8.zzi
            com.google.android.gms.internal.ads.zzfew r4 = r9.zzb
            java.util.List r4 = r4.zza
            r1.zzh(r0, r4)
            goto L_0x00d4
        L_0x008b:
            com.google.android.gms.internal.ads.zzfew r0 = r9.zzb
            java.util.List r0 = r0.zza
            java.util.Iterator r0 = r0.iterator()
        L_0x0093:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00d4
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.ads.zzfel r1 = (com.google.android.gms.internal.ads.zzfel) r1
            com.google.android.gms.internal.ads.zzeey r4 = r8.zzi
            r4.zzd(r1)
            java.util.List r4 = r1.zza
            java.util.Iterator r4 = r4.iterator()
        L_0x00aa:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00c7
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzcrx r6 = r8.zzg
            int r7 = r1.zzb
            com.google.android.gms.internal.ads.zzeet r5 = r6.zza(r7, r5)
            if (r5 == 0) goto L_0x00aa
            boolean r5 = r5.zzb(r9, r1)
            if (r5 == 0) goto L_0x00aa
            goto L_0x0093
        L_0x00c7:
            com.google.android.gms.internal.ads.zzeey r4 = r8.zzi
            r5 = 0
            r7 = 0
            com.google.android.gms.ads.internal.client.zze r7 = com.google.android.gms.internal.ads.zzfgi.zzd(r3, r7, r7)
            r4.zzf(r1, r5, r7)
            goto L_0x0093
        L_0x00d4:
            com.google.android.gms.internal.ads.zzcws r0 = r8.zzb
            com.google.android.gms.internal.ads.zzfll r1 = r8.zzd
            com.google.android.gms.internal.ads.zzflh r4 = r8.zzc
            com.google.android.gms.internal.ads.zzcnm r5 = new com.google.android.gms.internal.ads.zzcnm
            r5.<init>(r9, r1, r4)
            java.util.concurrent.Executor r1 = r8.zze
            r0.zzo(r5, r1)
            com.google.android.gms.internal.ads.zzfew r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfeo r0 = r0.zzb
            int r0 = r0.zzr
            if (r0 <= r3) goto L_0x00f4
            com.google.android.gms.internal.ads.zzehx r0 = r8.zzl
            com.google.common.util.concurrent.ListenableFuture r9 = r0.zzb(r9)
            goto L_0x018d
        L_0x00f4:
            java.lang.String r0 = zzc(r9)
            com.google.android.gms.internal.ads.zzfjl r1 = r8.zza
            com.google.android.gms.internal.ads.zzfjf r3 = com.google.android.gms.internal.ads.zzfjf.RENDER_CONFIG_INIT
            com.google.android.gms.internal.ads.zzeir r4 = new com.google.android.gms.internal.ads.zzeir
            r4.<init>(r2, r0)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzg(r4)
            com.google.android.gms.internal.ads.zzfjc r0 = com.google.android.gms.internal.ads.zzfiv.zzc(r0, r3, r1)
            com.google.android.gms.internal.ads.zzfiq r0 = r0.zza()
            com.google.android.gms.internal.ads.zzein r1 = r8.zzh
            r1.zzl()
            com.google.android.gms.internal.ads.zzfew r1 = r9.zzb
            java.util.List r1 = r1.zza
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x011b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x017d
            java.lang.Object r3 = r1.next()
            com.google.android.gms.internal.ads.zzfel r3 = (com.google.android.gms.internal.ads.zzfel) r3
            java.util.List r4 = r3.zza
            java.util.Iterator r4 = r4.iterator()
        L_0x012d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x017a
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzcrx r6 = r8.zzg
            int r7 = r3.zzb
            com.google.android.gms.internal.ads.zzeet r6 = r6.zza(r7, r5)
            if (r6 == 0) goto L_0x012d
            boolean r7 = r6.zzb(r9, r3)
            if (r7 == 0) goto L_0x012d
            com.google.android.gms.internal.ads.zzfjl r4 = r8.zza
            com.google.android.gms.internal.ads.zzfjf r7 = com.google.android.gms.internal.ads.zzfjf.RENDER_CONFIG_WATERFALL
            com.google.android.gms.internal.ads.zzfjc r0 = r4.zzb(r7, r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r7 = "render-config-"
            r4.<init>(r7)
            r4.append(r2)
            java.lang.String r7 = "-"
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.google.android.gms.internal.ads.zzfjc r0 = r0.zzh(r4)
            com.google.android.gms.internal.ads.zzeis r4 = new com.google.android.gms.internal.ads.zzeis
            r4.<init>(r8, r3, r9, r6)
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            com.google.android.gms.internal.ads.zzfjc r0 = r0.zzc(r3, r4)
            com.google.android.gms.internal.ads.zzfiq r0 = r0.zza()
        L_0x017a:
            int r2 = r2 + 1
            goto L_0x011b
        L_0x017d:
            com.google.android.gms.internal.ads.zzein r9 = r8.zzh
            java.util.Objects.requireNonNull(r9)
            com.google.android.gms.internal.ads.zzeit r1 = new com.google.android.gms.internal.ads.zzeit
            r1.<init>(r9)
            java.util.concurrent.Executor r9 = r8.zze
            r0.addListener(r1, r9)
            r9 = r0
        L_0x018d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiu.zza(java.lang.Object):com.google.common.util.concurrent.ListenableFuture");
    }

    public final /* synthetic */ ListenableFuture zzb(zzfel zzfel, zzfex zzfex, zzeet zzeet, Throwable th) throws Exception {
        zzfju zza2 = zzfjt.zza(this.zzj, 12);
        zza2.zzd(zzfel.zzE);
        zza2.zzi();
        ListenableFuture zzo = zzgcj.zzo(zzeet.zza(zzfex, zzfel), (long) zzfel.zzR, TimeUnit.MILLISECONDS, this.zzf);
        this.zzh.zzf(zzfex, zzfel, zzo, this.zzc);
        zzfke.zza(zzo, this.zzk, zza2);
        return zzo;
    }
}
