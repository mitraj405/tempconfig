package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcrf implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzcrf(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
        this.zzd = zzhfu4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcra(((zzcue) this.zza).zzb(), ((zzcre) this.zzb).zza(), ((zzcrd) this.zzc).zza(), (Executor) this.zzd.zzb());
    }
}
