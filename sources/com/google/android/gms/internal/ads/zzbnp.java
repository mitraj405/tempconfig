package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbnp implements zzbzx {
    final /* synthetic */ zzbmu zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzbzt zzc;
    final /* synthetic */ zzbns zzd;

    public zzbnp(zzbns zzbns, zzbmu zzbmu, Object obj, zzbzt zzbzt) {
        this.zza = zzbmu;
        this.zzb = obj;
        this.zzc = zzbzt;
        this.zzd = zzbns;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zze.zza("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzbzt zzbzt = this.zzc;
        zzbns.zzd(this.zzd, this.zza, (zzbnb) obj, obj2, zzbzt);
    }
}
