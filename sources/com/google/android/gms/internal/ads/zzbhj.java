package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzbhj implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ zzbu zzb;
    final /* synthetic */ zzbhk zzc;

    public zzbhj(zzbhk zzbhk, AdManagerAdView adManagerAdView, zzbu zzbu) {
        this.zza = adManagerAdView;
        this.zzb = zzbu;
        this.zzc = zzbhk;
    }

    public final void run() {
        if (this.zza.zzb(this.zzb)) {
            zzbhk zzbhk = this.zzc;
            zzbhk.zza.onAdManagerAdViewLoaded(this.zza);
            return;
        }
        zzm.zzj("Could not bind.");
    }
}
