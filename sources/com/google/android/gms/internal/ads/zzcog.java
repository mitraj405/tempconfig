package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcog implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzcog(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
        this.zzd = zzhfu4;
        this.zze = zzhfu5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcof((zzbnx) this.zza.zzb(), (zzcob) this.zzb.zzb(), (Executor) this.zzc.zzb(), (zzcoa) this.zzd.zzb(), (Clock) this.zze.zzb());
    }
}
