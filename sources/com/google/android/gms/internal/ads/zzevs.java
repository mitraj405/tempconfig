package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzevs implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzevs(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5) {
        this.zza = zzhfu;
        this.zzb = zzhfu3;
        this.zzc = zzhfu4;
        this.zzd = zzhfu5;
    }

    /* renamed from: zza */
    public final zzevr zzb() {
        Context zza2 = ((zzcgp) this.zza).zza();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzevr(zza2, zzgcu, ((zzhfq) this.zzb).zzb(), (zzfkf) this.zzc.zzb(), (zzdsk) this.zzd.zzb());
    }
}
