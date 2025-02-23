package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbbc;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdqk implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzdqk(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
        this.zzd = zzhfu4;
        this.zze = zzhfu5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        int i;
        Context zza2 = ((zzcgp) this.zza).zza();
        String zza3 = ((zzdxd) this.zzb).zzb();
        VersionInfoParcel zza4 = ((zzchc) this.zzc).zza();
        zzbbc.zza.C0034zza zza5 = (zzbbc.zza.C0034zza) this.zzd.zzb();
        String str = (String) this.zze.zzb();
        zzbav zzbav = new zzbav(new zzbbb(zza2));
        zzbbc.zzar.zza zzd2 = zzbbc.zzar.zzd();
        zzd2.zzg(zza4.buddyApkVersion);
        zzd2.zzi(zza4.clientJarVersion);
        if (true != zza4.isClientJar) {
            i = 2;
        } else {
            i = 0;
        }
        zzd2.zzh(i);
        zzbav.zzb(new zzdqj(zza5, zza3, (zzbbc.zzar) zzd2.zzbr(), str));
        return zzbav;
    }
}
