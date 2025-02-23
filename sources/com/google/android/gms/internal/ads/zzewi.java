package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzewi implements zzevo {
    private final zzg zza;
    private final Context zzb;
    private final zzgcu zzc;
    private final ScheduledExecutorService zzd;
    private final zzeer zze;
    private final zzffg zzf;
    private final VersionInfoParcel zzg;

    public zzewi(zzg zzg2, Context context, zzgcu zzgcu, ScheduledExecutorService scheduledExecutorService, zzeer zzeer, zzffg zzffg, VersionInfoParcel versionInfoParcel) {
        this.zza = zzg2;
        this.zzb = context;
        this.zzc = zzgcu;
        this.zzd = scheduledExecutorService;
        this.zze = zzeer;
        this.zzf = zzffg;
        this.zzg = versionInfoParcel;
    }

    public final int zza() {
        return 56;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009e, code lost:
        if (java.util.Arrays.asList(r0.split(",")).contains(r5.zzb.getPackageName()) == false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
        if (r0.zzd.zzy != com.google.android.gms.ads.RequestConfiguration.PublisherPrivacyPersonalizationState.DISABLED.getValue()) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.common.util.concurrent.ListenableFuture zzb() {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzjz
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00fc
            com.google.android.gms.ads.internal.util.zzg r0 = r5.zza
            boolean r0 = r0.zzT()
            if (r0 == 0) goto L_0x00fc
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzjD
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzffg r0 = r5.zzf
            com.google.android.gms.ads.RequestConfiguration$PublisherPrivacyPersonalizationState r1 = com.google.android.gms.ads.RequestConfiguration.PublisherPrivacyPersonalizationState.DISABLED
            int r1 = r1.getValue()
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zzd
            int r0 = r0.zzy
            if (r0 == r1) goto L_0x00fc
        L_0x003a:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r5.zzg
            int r0 = r0.clientJarVersion
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzjx
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r0 < r1) goto L_0x00fc
            int r0 = android.os.Build.VERSION.SDK_INT
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzjy
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r0 < r1) goto L_0x00fc
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzjv
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0077
            goto L_0x00a0
        L_0x0077:
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzjw
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x008a
            goto L_0x00fc
        L_0x008a:
            java.lang.String r1 = ","
            java.lang.String[] r0 = r0.split(r1)
            java.util.List r0 = java.util.Arrays.asList(r0)
            android.content.Context r1 = r5.zzb
            java.lang.String r1 = r1.getPackageName()
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x00fc
        L_0x00a0:
            com.google.android.gms.internal.ads.zzeer r0 = r5.zze     // Catch:{ Exception -> 0x00c1 }
            r1 = 0
            com.google.common.util.concurrent.ListenableFuture r0 = r0.zza(r1)     // Catch:{ Exception -> 0x00c1 }
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzjB     // Catch:{ Exception -> 0x00c1 }
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x00c1 }
            java.lang.Object r1 = r2.zza(r1)     // Catch:{ Exception -> 0x00c1 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x00c1 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x00c1 }
            long r1 = (long) r1     // Catch:{ Exception -> 0x00c1 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x00c1 }
            java.util.concurrent.ScheduledExecutorService r4 = r5.zzd     // Catch:{ Exception -> 0x00c1 }
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzo(r0, r1, r3, r4)     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00c6
        L_0x00c1:
            r0 = move-exception
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzg(r0)
        L_0x00c6:
            com.google.android.gms.internal.ads.zzgca r0 = com.google.android.gms.internal.ads.zzgca.zzu(r0)
            com.google.android.gms.internal.ads.zzewg r1 = new com.google.android.gms.internal.ads.zzewg
            r1.<init>()
            com.google.android.gms.internal.ads.zzgcu r2 = r5.zzc
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzn(r0, r1, r2)
            com.google.android.gms.internal.ads.zzewh r1 = new com.google.android.gms.internal.ads.zzewh
            r1.<init>(r5)
            com.google.android.gms.internal.ads.zzgcu r2 = r5.zzc
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzf(r0, r3, r1, r2)
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzjB
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            long r1 = (long) r1
            java.util.concurrent.ScheduledExecutorService r3 = r5.zzd
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzo(r0, r1, r4, r3)
            return r0
        L_0x00fc:
            com.google.android.gms.internal.ads.zzewk r0 = new com.google.android.gms.internal.ads.zzewk
            r1 = -1
            r2 = 0
            java.lang.String r3 = ""
            r0.<init>(r3, r1, r2)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzh(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewi.zzb():com.google.common.util.concurrent.ListenableFuture");
    }

    public final /* synthetic */ ListenableFuture zzc(Throwable th) throws Exception {
        zzewk zzewk;
        this.zzc.zza(new zzewf(th));
        if (th instanceof SecurityException) {
            zzewk = new zzewk("", 2, (zzewj) null);
        } else if (th instanceof IllegalStateException) {
            zzewk = new zzewk("", 3, (zzewj) null);
        } else if (th instanceof IllegalArgumentException) {
            zzewk = new zzewk("", 4, (zzewj) null);
        } else if (th instanceof TimeoutException) {
            zzewk = new zzewk("", 5, (zzewj) null);
        } else {
            zzewk = new zzewk("", 0, (zzewj) null);
        }
        return zzgcj.zzh(zzewk);
    }
}
