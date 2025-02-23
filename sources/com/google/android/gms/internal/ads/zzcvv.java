package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcvv implements zzhfc {
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

    public zzcvv(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5, zzhfu zzhfu6, zzhfu zzhfu7, zzhfu zzhfu8, zzhfu zzhfu9, zzhfu zzhfu10, zzhfu zzhfu11, zzhfu zzhfu12) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
        this.zzd = zzhfu4;
        this.zze = zzhfu6;
        this.zzf = zzhfu7;
        this.zzg = zzhfu8;
        this.zzh = zzhfu9;
        this.zzi = zzhfu10;
        this.zzj = zzhfu11;
        this.zzk = zzhfu12;
    }

    /* renamed from: zza */
    public final zzcvu zzb() {
        VersionInfoParcel zza2 = ((zzchc) this.zzb).zza();
        ApplicationInfo zza3 = ((zzdwy) this.zzc).zzb();
        String zza4 = ((zzdxd) this.zzd).zzb();
        zzbbn zzbbn = zzbbw.zza;
        return new zzcvu((zzfjl) this.zza.zzb(), zza2, zza3, zza4, zzba.zza().zza(), (PackageInfo) this.zze.zzb(), zzhfb.zza(zzhfn.zza(this.zzf)), ((zzcgn) this.zzg).zzb(), (String) this.zzh.zzb(), ((zzevs) this.zzi).zzb(), ((zzcwh) this.zzj).zza(), (zzdcc) this.zzk.zzb());
    }
}
