package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgdg extends zzgbz {
    /* access modifiers changed from: private */
    public ListenableFuture zza;
    /* access modifiers changed from: private */
    public ScheduledFuture zzb;

    private zzgdg(ListenableFuture listenableFuture) {
        listenableFuture.getClass();
        this.zza = listenableFuture;
    }

    public static ListenableFuture zzf(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzgdg zzgdg = new zzgdg(listenableFuture);
        zzgdd zzgdd = new zzgdd(zzgdg);
        zzgdg.zzb = scheduledExecutorService.schedule(zzgdd, j, timeUnit);
        listenableFuture.addListener(zzgdd, zzgbx.INSTANCE);
        return zzgdg;
    }

    public final String zza() {
        ListenableFuture listenableFuture = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (listenableFuture == null) {
            return null;
        }
        String j = lf.j("inputFuture=[", listenableFuture.toString(), "]");
        if (scheduledFuture == null) {
            return j;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return j;
        }
        return j + ", remaining delay=[" + delay + " ms]";
    }

    public final void zzb() {
        zzr(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
