package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcuj implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzcuj(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        VersionInfoParcel zza2 = ((zzchc) this.zzc).zza();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzcui(((zzcgp) this.zza).zza(), (zzfki) this.zzb.zzb(), zza2, zzgcu);
    }
}
