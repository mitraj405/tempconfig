package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeyn implements zzevo {
    final ScheduledExecutorService zza;

    public zzeyn(zzbsr zzbsr, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zza = scheduledExecutorService;
    }

    public final int zza() {
        return 49;
    }

    public final ListenableFuture zzb() {
        return zzgcj.zzm(zzgcj.zzo(zzgcj.zzh(new Bundle()), ((Long) zzba.zzc().zza(zzbbw.zzdK)).longValue(), TimeUnit.MILLISECONDS, this.zza), new zzeym(), zzbzo.zza);
    }
}
