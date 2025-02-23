package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdwc extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdwf zzb;

    public zzdwc(zzdwf zzdwf, String str) {
        this.zza = str;
        this.zzb = zzdwf;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.zzm(zzdwf.zzl(loadAdError), this.zza);
    }
}
