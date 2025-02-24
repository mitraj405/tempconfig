package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.ads.mediation.facebook.MetaFactory;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

public class FacebookRtbInterstitialAd implements MediationInterstitialAd, InterstitialAdExtendedListener {
    private final MediationInterstitialAdConfiguration adConfiguration;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> callback;
    private final AtomicBoolean didInterstitialAdClose = new AtomicBoolean();
    private MediationInterstitialAdCallback interstitalAdCallback;
    private InterstitialAd interstitialAd;
    private final MetaFactory metaFactory;
    private final AtomicBoolean showAdCalled = new AtomicBoolean();

    public FacebookRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, MetaFactory metaFactory2) {
        this.adConfiguration = mediationInterstitialAdConfiguration;
        this.callback = mediationAdLoadCallback;
        this.metaFactory = metaFactory2;
    }

    public void onAdClicked(Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitalAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.reportAdClicked();
            this.interstitalAdCallback.onAdLeftApplication();
        }
    }

    public void onAdLoaded(Ad ad) {
        this.interstitalAdCallback = this.callback.onSuccess(this);
    }

    public void onError(Ad ad, AdError adError) {
        com.google.android.gms.ads.AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        adError2.getMessage();
        if (this.showAdCalled.get()) {
            MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitalAdCallback;
            if (mediationInterstitialAdCallback != null) {
                mediationInterstitialAdCallback.onAdFailedToShow(adError2);
                return;
            }
            return;
        }
        this.callback.onFailure(adError2);
    }

    public void onInterstitialActivityDestroyed() {
        MediationInterstitialAdCallback mediationInterstitialAdCallback;
        if (!this.didInterstitialAdClose.getAndSet(true) && (mediationInterstitialAdCallback = this.interstitalAdCallback) != null) {
            mediationInterstitialAdCallback.onAdClosed();
        }
    }

    public void onInterstitialDismissed(Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback;
        if (!this.didInterstitialAdClose.getAndSet(true) && (mediationInterstitialAdCallback = this.interstitalAdCallback) != null) {
            mediationInterstitialAdCallback.onAdClosed();
        }
    }

    public void onInterstitialDisplayed(Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitalAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
    }

    public void onLoggingImpression(Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitalAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.reportAdImpression();
        }
    }

    public void render() {
        String placementID = FacebookMediationAdapter.getPlacementID(this.adConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            com.google.android.gms.ads.AdError adError = new com.google.android.gms.ads.AdError(101, "Failed to request ad. PlacementID is null or empty. ", "com.google.ads.mediation.facebook");
            adError.getMessage();
            this.callback.onFailure(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(this.adConfiguration);
        this.interstitialAd = this.metaFactory.createInterstitialAd(this.adConfiguration.getContext(), placementID);
        if (!TextUtils.isEmpty(this.adConfiguration.getWatermark())) {
            this.interstitialAd.setExtraHints(new ExtraHints.Builder().mediationData(this.adConfiguration.getWatermark()).build());
        }
        InterstitialAd interstitialAd2 = this.interstitialAd;
        interstitialAd2.loadAd(interstitialAd2.buildLoadAdConfig().withBid(this.adConfiguration.getBidResponse()).withAdListener(this).build());
    }

    public void showAd(Context context) {
        this.showAdCalled.set(true);
        if (!this.interstitialAd.show()) {
            com.google.android.gms.ads.AdError adError = new com.google.android.gms.ads.AdError(110, "Failed to present interstitial ad.", "com.google.ads.mediation.facebook");
            String str = FacebookMediationAdapter.TAG;
            adError.toString();
            MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitalAdCallback;
            if (mediationInterstitialAdCallback != null) {
                mediationInterstitialAdCallback.onAdFailedToShow(adError);
            }
        }
    }

    public void onRewardedAdCompleted() {
    }

    public void onRewardedAdServerFailed() {
    }

    public void onRewardedAdServerSucceeded() {
    }
}
