package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdlo implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdlo(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzdln((zzbo) this.zza.zzb(), (Clock) this.zzb.zzb(), zzgcu);
    }
}
