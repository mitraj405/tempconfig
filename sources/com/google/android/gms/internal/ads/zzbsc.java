package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbsc extends zzbgq {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbsc(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    public final void zze(zzbha zzbha) {
        this.zza.onNativeAdLoaded(new zzbrv(zzbha));
    }
}
