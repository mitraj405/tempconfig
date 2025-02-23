package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdij implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzdij(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
        this.zzd = zzhfu4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcop((Executor) this.zzb.zzb(), new zzcob((Context) this.zzc.zzb(), (zzaxs) this.zza.zzb()), (Clock) this.zzd.zzb());
    }
}
