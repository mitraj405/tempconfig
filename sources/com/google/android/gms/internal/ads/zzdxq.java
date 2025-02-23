package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdxq implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;
    private final zzhfu zzf;

    public zzdxq(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5, zzhfu zzhfu6, zzhfu zzhfu7) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
        this.zzd = zzhfu5;
        this.zze = zzhfu6;
        this.zzf = zzhfu7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcgp) this.zza).zza();
        zzffg zza3 = ((zzcwh) this.zzb).zza();
        zzdwq zza4 = ((zzdwr) this.zzc).zzb();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzdxp(zza2, zza3, zza4, zzgcu, (ScheduledExecutorService) this.zzd.zzb(), (zzecd) this.zze.zzb(), (zzfkf) this.zzf.zzb());
    }
}
