package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
@Keep
public class AbstractAdListener implements InterstitialAdExtendedListener, RewardedVideoAdExtendedListener, RewardedInterstitialAdExtendedListener {
    public void onInterstitialActivityDestroyed() {
    }

    public void onRewardedAdCompleted() {
    }

    public void onRewardedAdServerFailed() {
    }

    public void onRewardedAdServerSucceeded() {
    }

    public void onRewardedInterstitialActivityDestroyed() {
    }

    public void onRewardedInterstitialClosed() {
    }

    public void onRewardedInterstitialCompleted() {
    }

    public void onRewardedVideoActivityDestroyed() {
    }

    public void onRewardedVideoClosed() {
    }

    public void onRewardedVideoCompleted() {
    }

    public void onAdClicked(Ad ad) {
    }

    public void onAdLoaded(Ad ad) {
    }

    public void onInterstitialDismissed(Ad ad) {
    }

    public void onInterstitialDisplayed(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onError(Ad ad, AdError adError) {
    }
}
