package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbxr implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzbxr(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    /* renamed from: zza */
    public final zzbxq zzb() {
        return new zzbxq((Clock) this.zza.zzb(), (zzbxo) this.zzb.zzb());
    }
}
