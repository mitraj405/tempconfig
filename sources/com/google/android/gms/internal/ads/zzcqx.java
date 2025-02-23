package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcqx implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzcqx(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    /* renamed from: zza */
    public final zzcqw zzb() {
        return new zzcqw(((zzcqg) this.zza).zza(), (Executor) this.zzb.zzb());
    }
}
