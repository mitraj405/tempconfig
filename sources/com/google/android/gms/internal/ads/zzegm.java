package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzegm implements zzgcf {
    final /* synthetic */ zzegn zza;

    public zzegm(zzegn zzegn) {
        this.zza = zzegn;
    }

    public final void zza(Throwable th) {
        zze zza2 = this.zza.zza.zzd().zza(th);
        this.zza.zzd.zzdB(zza2);
        zzfgd.zzb(zza2.zza, th, "DelayedBannerAd.onFailure");
    }

    public final /* synthetic */ void zzb(Object obj) {
        ((zzcpk) obj).zzk();
    }
}
