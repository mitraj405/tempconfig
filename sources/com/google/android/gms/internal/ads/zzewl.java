package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzewl implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;
    private final zzhfu zzf;

    public zzewl(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5, zzhfu zzhfu6, zzhfu zzhfu7) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu4;
        this.zzd = zzhfu5;
        this.zze = zzhfu6;
        this.zzf = zzhfu7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzg zza2 = ((zzcgn) this.zza).zzb();
        Context zza3 = ((zzcgp) this.zzb).zza();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzewi(zza2, zza3, zzgcu, (ScheduledExecutorService) this.zzc.zzb(), ((zzees) this.zzd).zzb(), ((zzcwh) this.zze).zza(), ((zzchc) this.zzf).zza());
    }
}
