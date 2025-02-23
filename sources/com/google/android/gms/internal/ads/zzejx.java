package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzejx implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzejx(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzejw((Context) this.zza.zzb(), (Executor) this.zzb.zzb(), (zzdou) this.zzc.zzb());
    }
}
