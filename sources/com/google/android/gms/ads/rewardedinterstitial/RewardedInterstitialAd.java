package com.google.android.gms.ads.rewardedinterstitial;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdq;
import com.google.android.gms.internal.ads.zzbxa;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class RewardedInterstitialAd {
    public static void load(Context context, String str, AdRequest adRequest, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbw.zza(context);
        if (((Boolean) zzbdq.zzk.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzkl)).booleanValue()) {
                zzb.zzb.execute(new zzb(context, str, adRequest, rewardedInterstitialAdLoadCallback));
                return;
            }
        }
        new zzbxa(context, str).zza(adRequest.zza(), rewardedInterstitialAdLoadCallback);
    }

    public abstract Bundle getAdMetadata();

    public abstract String getAdUnitId();

    public abstract FullScreenContentCallback getFullScreenContentCallback();

    public abstract OnAdMetadataChangedListener getOnAdMetadataChangedListener();

    public abstract OnPaidEventListener getOnPaidEventListener();

    public abstract ResponseInfo getResponseInfo();

    public abstract RewardItem getRewardItem();

    public abstract void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback);

    public abstract void setImmersiveMode(boolean z);

    public abstract void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener);

    public abstract void setOnPaidEventListener(OnPaidEventListener onPaidEventListener);

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener);

    public static void load(Context context, String str, AdManagerAdRequest adManagerAdRequest, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbw.zza(context);
        if (((Boolean) zzbdq.zzk.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzkl)).booleanValue()) {
                zzb.zzb.execute(new zza(context, str, adManagerAdRequest, rewardedInterstitialAdLoadCallback));
                return;
            }
        }
        new zzbxa(context, str).zza(adManagerAdRequest.zza(), rewardedInterstitialAdLoadCallback);
    }
}
