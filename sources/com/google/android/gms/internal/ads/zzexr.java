package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzexr implements zzevo {
    private final zzbze zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;

    public zzexr(zzbyv zzbyv, int i, Context context, zzbze zzbze, ScheduledExecutorService scheduledExecutorService, Executor executor, String str) {
        this.zza = zzbze;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
    }

    public final int zza() {
        return 44;
    }

    public final ListenableFuture zzb() {
        return zzgcj.zze((zzgca) zzgcj.zzo(zzgcj.zzm(zzgca.zzu(zzgcj.zzk(new zzexo(this), this.zzc)), new zzexp(), this.zzc), ((Long) zzba.zzc().zza(zzbbw.zzaM)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Exception.class, new zzexq(this), zzgda.zzb());
    }

    public final /* synthetic */ zzexs zzc(Exception exc) {
        this.zza.zzw(exc, "AttestationTokenSignal");
        return null;
    }
}
