package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdsk;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ zzdsk zza;
    public final /* synthetic */ Long zzb;

    public /* synthetic */ zze(zzf zzf, zzdsk zzdsk, Long l) {
        this.zza = zzdsk;
        this.zzb = l;
    }

    public final void run() {
        zzf.zzf(this.zza, "cld_r", zzu.zzB().elapsedRealtime() - this.zzb.longValue());
    }
}
