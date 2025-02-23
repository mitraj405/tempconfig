package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzewq implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzewq(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5, zzhfu zzhfu6, zzhfu zzhfu7) {
        this.zza = zzhfu2;
        this.zzb = zzhfu3;
        this.zzc = zzhfu5;
        this.zzd = zzhfu6;
        this.zze = zzhfu7;
    }

    public static zzewo zza(zzbyv zzbyv, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        return new zzewo(zzbyv, context, scheduledExecutorService, executor, i, z, z2);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzewo(new zzbyv(), ((zzcgp) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb(), zzgcu, ((zzeys) this.zzc).zzb().intValue(), ((zzeyt) this.zzd).zzb().booleanValue(), ((zzeyv) this.zze).zzb().booleanValue());
    }
}
