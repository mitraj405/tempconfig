package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzexn implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzexn(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5) {
        this.zza = zzhfu;
        this.zzb = zzhfu3;
        this.zzc = zzhfu4;
    }

    public static zzexl zza(String str, zzazy zzazy, zzbze zzbze, ScheduledExecutorService scheduledExecutorService, zzgcu zzgcu) {
        return new zzexl(str, zzazy, zzbze, scheduledExecutorService, zzgcu);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzexl(((zzeyr) this.zza).zza(), new zzazy(), (zzbze) this.zzb.zzb(), (ScheduledExecutorService) this.zzc.zzb(), zzgcu);
    }
}
