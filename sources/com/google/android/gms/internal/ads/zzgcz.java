package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgcz extends zzgcw implements ScheduledExecutorService {
    final ScheduledExecutorService zza;

    public zzgcz(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzgdj zze = zzgdj.zze(runnable, (Object) null);
        return new zzgcx(zze, scheduledExecutorService.schedule(zze, j, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzgcy zzgcy = new zzgcy(runnable);
        return new zzgcx(zzgcy, this.zza.scheduleAtFixedRate(zzgcy, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzgcy zzgcy = new zzgcy(runnable);
        return new zzgcx(zzgcy, this.zza.scheduleWithFixedDelay(zzgcy, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzgdj zzgdj = new zzgdj(callable);
        return new zzgcx(zzgdj, this.zza.schedule(zzgdj, j, timeUnit));
    }
}
