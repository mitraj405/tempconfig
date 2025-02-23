package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzetw implements zzevo {
    private final zzevo zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzetw(zzevo zzevo, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzevo;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final ListenableFuture zzb() {
        ListenableFuture zzb2 = this.zza.zzb();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbX)).booleanValue()) {
            timeUnit = TimeUnit.MICROSECONDS;
        }
        long j = this.zzb;
        if (j > 0) {
            zzb2 = zzgcj.zzo(zzb2, j, timeUnit, this.zzc);
        }
        return zzgcj.zzf(zzb2, Throwable.class, new zzetv(this), zzbzo.zzf);
    }

    public final /* synthetic */ ListenableFuture zzc(Throwable th) throws Exception {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbW)).booleanValue()) {
            zzevo zzevo = this.zza;
            zzbze zzo = zzu.zzo();
            int zza2 = zzevo.zza();
            zzo.zzw(th, "OptionalSignalTimeout:" + zza2);
        }
        return zzgcj.zzh((Object) null);
    }
}
