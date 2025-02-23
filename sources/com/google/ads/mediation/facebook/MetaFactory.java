package com.google.ads.mediation.facebook;

import android.content.Context;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.MediaView;
import com.facebook.ads.RewardedVideoAd;

public class MetaFactory {
    public InterstitialAd createInterstitialAd(Context context, String str) {
        return new InterstitialAd(context, str);
    }

    public MediaView createMediaView(Context context) {
        return new MediaView(context);
    }

    public AdView createMetaAdView(Context context, String str, String str2) throws Exception {
        return new AdView(context, str, str2);
    }

    public RewardedVideoAd createRewardedAd(Context context, String str) {
        return new RewardedVideoAd(context, str);
    }
}
