package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcsj {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final ListenableFuture zzc;
    private volatile boolean zzd = true;

    public zzcsj(Executor executor, ScheduledExecutorService scheduledExecutorService, ListenableFuture listenableFuture) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = listenableFuture;
    }

    public static /* bridge */ /* synthetic */ void zzb(zzcsj zzcsj, List list, zzgcf zzgcf) {
        if (list == null || list.isEmpty()) {
            zzcsj.zza.execute(new zzcse(zzgcf));
            return;
        }
        ListenableFuture zzh = zzgcj.zzh((Object) null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzh = zzgcj.zzn(zzgcj.zzf(zzh, Throwable.class, new zzcsf(zzgcf), zzcsj.zza), new zzcsg(zzcsj, zzgcf, (ListenableFuture) it.next()), zzcsj.zza);
        }
        zzgcj.zzr(zzh, new zzcsi(zzcsj, zzgcf), zzcsj.zza);
    }

    public final /* synthetic */ ListenableFuture zza(zzgcf zzgcf, ListenableFuture listenableFuture, zzcru zzcru) throws Exception {
        if (zzcru != null) {
            zzgcf.zzb(zzcru);
        }
        return zzgcj.zzo(listenableFuture, ((Long) zzbef.zza.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzgcf zzgcf) {
        zzgcj.zzr(this.zzc, new zzcsh(this, zzgcf), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
