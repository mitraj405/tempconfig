package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeag implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzeag(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    /* renamed from: zza */
    public final zzeaf zzb() {
        return new zzeaf(((zzcgp) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
