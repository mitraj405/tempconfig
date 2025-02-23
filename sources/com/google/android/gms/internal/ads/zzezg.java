package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzezg implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzezg(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5, zzhfu zzhfu6, zzhfu zzhfu7) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
        this.zzd = zzhfu6;
        this.zze = zzhfu7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        boolean booleanValue = ((zzeyu) this.zzb).zzb().booleanValue();
        boolean booleanValue2 = ((zzeyv) this.zzc).zzb().booleanValue();
        zzbyt zzbyt = new zzbyt();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzeze((zzbze) this.zza.zzb(), booleanValue, booleanValue2, zzbyt, zzgcu, ((zzeyr) this.zzd).zza(), (ScheduledExecutorService) this.zze.zzb());
    }
}
