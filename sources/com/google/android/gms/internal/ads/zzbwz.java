package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbwz extends zzbwm {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzbxa zzb;

    public zzbwz(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzbxa zzbxa) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzbxa;
    }

    public final void zzf(zze zze) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zze.zzb());
        }
    }

    public final void zzg() {
        zzbxa zzbxa;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null && (zzbxa = this.zzb) != null) {
            rewardedInterstitialAdLoadCallback.onAdLoaded(zzbxa);
        }
    }

    public final void zze(int i) {
    }
}
