package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdll implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdll(zzdle zzdle, zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdei(((zzdol) this.zza).zzb(), (Executor) this.zzb.zzb());
    }
}
