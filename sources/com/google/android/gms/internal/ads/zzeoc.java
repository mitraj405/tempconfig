package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeoc implements zzevo {
    private final ListenableFuture zza;
    private final Executor zzb;
    private final ScheduledExecutorService zzc;

    public zzeoc(ListenableFuture listenableFuture, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = listenableFuture;
        this.zzb = executor;
        this.zzc = scheduledExecutorService;
    }

    public final int zza() {
        return 6;
    }

    public final ListenableFuture zzb() {
        ListenableFuture zzn = zzgcj.zzn(this.zza, new zzeny(), this.zzb);
        zzbbn zzbbn = zzbbw.zzlz;
        if (((Integer) zzba.zzc().zza(zzbbn)).intValue() > 0) {
            zzn = zzgcj.zzo(zzn, (long) ((Integer) zzba.zzc().zza(zzbbn)).intValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgcj.zzf(zzn, Throwable.class, new zzenz(), this.zzb);
    }
}
