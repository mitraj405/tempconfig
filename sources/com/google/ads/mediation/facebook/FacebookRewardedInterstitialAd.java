package com.google.ads.mediation.facebook;

import com.facebook.ads.AdExperienceType;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;

public class FacebookRewardedInterstitialAd extends FacebookRewardedAd {
    public FacebookRewardedInterstitialAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, MetaFactory metaFactory) {
        super(mediationRewardedAdConfiguration, mediationAdLoadCallback, metaFactory);
    }

    public AdExperienceType getAdExperienceType() {
        return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL;
    }
}
