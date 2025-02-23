package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzetn implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzetn(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu2;
        this.zzb = zzhfu3;
        this.zzc = zzhfu4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzetl(zzgcu, ((zzcwh) this.zza).zza(), (PackageInfo) this.zzb.zzb(), ((zzcgn) this.zzc).zzb());
    }
}
