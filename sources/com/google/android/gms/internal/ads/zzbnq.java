package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbnq implements zzbzv {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzbmu zzb;

    public zzbnq(zzbns zzbns, zzbzt zzbzt, zzbmu zzbmu) {
        this.zza = zzbzt;
        this.zzb = zzbmu;
    }

    public final void zza() {
        zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbnd("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}
