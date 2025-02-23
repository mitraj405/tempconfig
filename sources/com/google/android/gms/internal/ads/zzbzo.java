package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbzo {
    public static final zzgcu zza;
    public static final zzgcu zzb;
    public static final zzgcu zzc;
    public static final ScheduledExecutorService zzd = new zzbzj(3, new zzbzk("Schedule"));
    public static final zzgcu zze = new zzbzn(new zzbzl(), (zzbzm) null);
    public static final zzgcu zzf = new zzbzn(zzgda.zzb(), (zzbzm) null);

    /* JADX WARNING: type inference failed for: r0v11, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: type inference failed for: r0v14, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: type inference failed for: r0v30, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            java.lang.String r1 = "Default"
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzfrt.zza()
            com.google.android.gms.internal.ads.zzbzk r0 = new com.google.android.gms.internal.ads.zzbzk
            r0.<init>(r1)
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newCachedThreadPool(r0)
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.unconfigurableExecutorService(r0)
            goto L_0x00a9
        L_0x001a:
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzkr
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r2.zzb(r0)
            if (r2 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzks
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r2.zzb(r0)
            if (r2 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzkt
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r3.zzb(r2)
            if (r3 == 0) goto L_0x0091
            java.util.concurrent.ThreadPoolExecutor r3 = new java.util.concurrent.ThreadPoolExecutor
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r4.zzb(r0)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r5 = r4.intValue()
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r4.zzb(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r6 = r0.intValue()
            r7 = 10
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            com.google.android.gms.internal.ads.zzbzk r11 = new com.google.android.gms.internal.ads.zzbzk
            r11.<init>(r1)
            r4 = r3
            r4.<init>(r5, r6, r7, r9, r10, r11)
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r0.zzb(r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r3.allowCoreThreadTimeOut(r0)
            r0 = r3
            goto L_0x00a9
        L_0x0091:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            r5 = 2
            r6 = 2147483647(0x7fffffff, float:NaN)
            r7 = 10
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.SynchronousQueue r10 = new java.util.concurrent.SynchronousQueue
            r10.<init>()
            com.google.android.gms.internal.ads.zzbzk r11 = new com.google.android.gms.internal.ads.zzbzk
            r11.<init>(r1)
            r4 = r0
            r4.<init>(r5, r6, r7, r9, r10, r11)
        L_0x00a9:
            com.google.android.gms.internal.ads.zzbzn r1 = new com.google.android.gms.internal.ads.zzbzn
            r2 = 0
            r1.<init>(r0, r2)
            zza = r1
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            java.lang.String r1 = "Loader"
            r3 = 1
            if (r0 == 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzfrq r0 = com.google.android.gms.internal.ads.zzfrt.zza()
            com.google.android.gms.internal.ads.zzbzk r4 = new com.google.android.gms.internal.ads.zzbzk
            r4.<init>(r1)
            r1 = 5
            java.util.concurrent.ExecutorService r0 = r0.zzc(r1, r4, r3)
            goto L_0x00e2
        L_0x00c9:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            r5 = 5
            r6 = 5
            r7 = 10
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            com.google.android.gms.internal.ads.zzbzk r11 = new com.google.android.gms.internal.ads.zzbzk
            r11.<init>(r1)
            r4 = r0
            r4.<init>(r5, r6, r7, r9, r10, r11)
            r0.allowCoreThreadTimeOut(r3)
        L_0x00e2:
            com.google.android.gms.internal.ads.zzbzn r1 = new com.google.android.gms.internal.ads.zzbzn
            r1.<init>(r0, r2)
            zzb = r1
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            java.lang.String r1 = "Activeview"
            if (r0 == 0) goto L_0x00ff
            com.google.android.gms.internal.ads.zzfrq r0 = com.google.android.gms.internal.ads.zzfrt.zza()
            com.google.android.gms.internal.ads.zzbzk r4 = new com.google.android.gms.internal.ads.zzbzk
            r4.<init>(r1)
            java.util.concurrent.ExecutorService r0 = r0.zzb(r4, r3)
            goto L_0x0118
        L_0x00ff:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            r5 = 1
            r6 = 1
            r7 = 10
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            com.google.android.gms.internal.ads.zzbzk r11 = new com.google.android.gms.internal.ads.zzbzk
            r11.<init>(r1)
            r4 = r0
            r4.<init>(r5, r6, r7, r9, r10, r11)
            r0.allowCoreThreadTimeOut(r3)
        L_0x0118:
            com.google.android.gms.internal.ads.zzbzn r1 = new com.google.android.gms.internal.ads.zzbzn
            r1.<init>(r0, r2)
            zzc = r1
            com.google.android.gms.internal.ads.zzbzj r0 = new com.google.android.gms.internal.ads.zzbzj
            com.google.android.gms.internal.ads.zzbzk r1 = new com.google.android.gms.internal.ads.zzbzk
            java.lang.String r3 = "Schedule"
            r1.<init>(r3)
            r3 = 3
            r0.<init>(r3, r1)
            zzd = r0
            com.google.android.gms.internal.ads.zzbzl r0 = new com.google.android.gms.internal.ads.zzbzl
            r0.<init>()
            com.google.android.gms.internal.ads.zzbzn r1 = new com.google.android.gms.internal.ads.zzbzn
            r1.<init>(r0, r2)
            zze = r1
            java.util.concurrent.Executor r0 = com.google.android.gms.internal.ads.zzgda.zzb()
            com.google.android.gms.internal.ads.zzbzn r1 = new com.google.android.gms.internal.ads.zzbzn
            r1.<init>(r0, r2)
            zzf = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzo.<clinit>():void");
    }
}
