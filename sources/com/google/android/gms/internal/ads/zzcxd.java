package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcxd extends zzdch implements zzcwu {
    private final ScheduledExecutorService zzb;
    private ScheduledFuture zzc;
    private boolean zzd = false;

    public zzcxd(zzcxc zzcxc, Set set, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        super(set);
        this.zzb = scheduledExecutorService;
        zzo(zzcxc, executor);
    }

    public final void zza(zze zze) {
        zzq(new zzcwv(zze));
    }

    public final void zzb() {
        zzq(new zzcww());
    }

    public final void zzc(zzdgw zzdgw) {
        if (!this.zzd) {
            ScheduledFuture scheduledFuture = this.zzc;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            zzq(new zzcwy(zzdgw));
        }
    }

    public final /* synthetic */ void zzd() {
        synchronized (this) {
            zzm.zzg("Timeout waiting for show call succeed to be called.");
            zzc(new zzdgw("Timeout for show call succeed."));
            this.zzd = true;
        }
    }

    public final synchronized void zze() {
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public final void zzf() {
        int intValue = ((Integer) zzba.zzc().zza(zzbbw.zzjO)).intValue();
        this.zzc = this.zzb.schedule(new zzcwx(this), (long) intValue, TimeUnit.MILLISECONDS);
    }
}
