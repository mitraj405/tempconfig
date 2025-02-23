package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdmf implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;
    private final zzhfu zzf;
    private final zzhfu zzg;
    private final zzhfu zzh;
    private final zzhfu zzi;
    private final zzhfu zzj;
    private final zzhfu zzk;
    private final zzhfu zzl;
    private final zzhfu zzm;
    private final zzhfu zzn;
    private final zzhfu zzo;

    public zzdmf(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5, zzhfu zzhfu6, zzhfu zzhfu7, zzhfu zzhfu8, zzhfu zzhfu9, zzhfu zzhfu10, zzhfu zzhfu11, zzhfu zzhfu12, zzhfu zzhfu13, zzhfu zzhfu14, zzhfu zzhfu15, zzhfu zzhfu16, zzhfu zzhfu17) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
        this.zzd = zzhfu4;
        this.zze = zzhfu6;
        this.zzf = zzhfu8;
        this.zzg = zzhfu9;
        this.zzh = zzhfu10;
        this.zzi = zzhfu11;
        this.zzj = zzhfu12;
        this.zzk = zzhfu13;
        this.zzl = zzhfu14;
        this.zzm = zzhfu15;
        this.zzn = zzhfu16;
        this.zzo = zzhfu17;
    }

    /* renamed from: zza */
    public final zzdme zzb() {
        VersionInfoParcel zza2 = ((zzchc) this.zzd).zza();
        zzhfu zzhfu = this.zze;
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzdme((Context) this.zza.zzb(), (zzdln) this.zzb.zzb(), (zzauo) this.zzc.zzb(), zza2, zza.zza(), (zzbav) zzhfu.zzb(), zzgcu, ((zzcwh) this.zzf).zza(), (zzdmw) this.zzg.zzb(), (zzdpl) this.zzh.zzb(), (ScheduledExecutorService) this.zzi.zzb(), (zzdsk) this.zzj.zzb(), (zzfll) this.zzk.zzb(), (zzedh) this.zzl.zzb(), (zzdog) this.zzm.zzb(), (zzeds) this.zzn.zzb(), (zzffk) this.zzo.zzb());
    }
}
