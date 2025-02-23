package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdxl implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzdxl(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5) {
        this.zza = zzhfu;
        this.zzb = zzhfu4;
        this.zzc = zzhfu5;
    }

    /* renamed from: zza */
    public final zzdxk zzb() {
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        zzgcu zzgcu2 = zzbzo.zzb;
        zzhfk.zzb(zzgcu2);
        return new zzdxk((ScheduledExecutorService) this.zza.zzb(), zzgcu, zzgcu2, ((zzdyd) this.zzb).zzb(), zzhfb.zza(zzhfn.zza(this.zzc)));
    }
}
