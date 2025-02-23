package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcxf implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzcxf(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcxc zza2 = ((zzcxe) this.zza).zzb();
        Set zzc2 = ((zzhfq) this.zzb).zzb();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzcxd(zza2, zzc2, zzgcu, (ScheduledExecutorService) this.zzc.zzb());
    }
}
