package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeqp implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzeqp(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeqg(((zzeqb) this.zza).zzb(), 10000, (Clock) this.zzb.zzb());
    }
}
