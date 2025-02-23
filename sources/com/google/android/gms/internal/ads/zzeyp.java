package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeyp implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzeyp(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3) {
        this.zza = zzhfu2;
        this.zzb = zzhfu3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeyn(new zzbsr(), (ScheduledExecutorService) this.zza.zzb(), ((zzcgp) this.zzb).zza());
    }
}
