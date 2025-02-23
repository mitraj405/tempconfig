package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbda implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzbda(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu4;
    }

    public final /* synthetic */ Object zzb() {
        return new zzbcz(((zzcgp) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb(), new zzbdb(), (zzfkf) this.zzc.zzb());
    }
}
