package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdlb implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzdlb(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzdla(((zzdju) this.zza).zza(), ((zzdid) this.zzb).zzb(), (Executor) this.zzc.zzb(), zzgcu);
    }
}
