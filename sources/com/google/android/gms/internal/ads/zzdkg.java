package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdkg implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdkg(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkf(((zzdif) this.zza).zza(), (Clock) this.zzb.zzb());
    }
}
