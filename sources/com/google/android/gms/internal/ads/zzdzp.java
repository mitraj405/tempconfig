package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdzp implements zzful {
    public final /* synthetic */ zzbvb zza;

    public /* synthetic */ zzdzp(zzbvb zzbvb) {
        this.zza = zzbvb;
    }

    public final Object apply(Object obj) {
        zzbvb zzbvb = this.zza;
        String zzc = zzfvj.zzc(zzbvb.zza.getString("ms"));
        ApplicationInfo applicationInfo = zzbvb.zzc;
        String str = zzbvb.zzh;
        return new zzbuc(applicationInfo, zzbvb.zzd, zzbvb.zzf, zzc, -1, str, zzbvb.zze, zzbvb.zzk, zzbvb.zzl);
    }
}
