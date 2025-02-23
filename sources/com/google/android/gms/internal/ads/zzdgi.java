package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdgi implements zzhfc {
    private final zzdfs zza;
    private final zzhfu zzb;

    public zzdgi(zzdfs zzdfs, zzhfu zzhfu) {
        this.zza = zzdfs;
        this.zzb = zzhfu;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return this.zza.zzd((Executor) this.zzb.zzb());
    }
}
