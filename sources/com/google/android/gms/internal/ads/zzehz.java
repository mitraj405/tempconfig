package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzehz implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzehz(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5) {
        this.zza = zzhfu2;
        this.zzb = zzhfu3;
        this.zzc = zzhfu4;
        this.zzd = zzhfu5;
    }

    /* renamed from: zza */
    public final zzehx zzb() {
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzehx(zzgcu, (ScheduledExecutorService) this.zza.zzb(), (zzcrx) this.zzb.zzb(), (zzein) this.zzc.zzb(), (zzflh) this.zzd.zzb());
    }
}
