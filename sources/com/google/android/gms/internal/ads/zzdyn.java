package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdyn implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdyn(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3) {
        this.zza = zzhfu;
        this.zzb = zzhfu3;
    }

    /* renamed from: zza */
    public final zzdym zzb() {
        Map zzd = ((zzhfj) this.zza).zzd();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzdym(zzd, zzgcu, ((zzczn) this.zzb).zzb());
    }
}
