package defpackage;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import cris.org.in.ima.activities.RegistrationPage3Activity;

/* renamed from: et  reason: default package and case insensitive filesystem */
/* compiled from: RegistrationPage3Activity */
public final class C1094et extends InterstitialAdLoadCallback {
    public final /* synthetic */ FullScreenContentCallback a;

    public C1094et(C1076dt dtVar) {
        this.a = dtVar;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        super.onAdFailedToLoad(loadAdError);
        RegistrationPage3Activity.a = null;
        InterstitialAd interstitialAd = RegistrationPage3Activity.a;
        loadAdError.getMessage();
    }

    public final void onAdLoaded(Object obj) {
        InterstitialAd interstitialAd = (InterstitialAd) obj;
        super.onAdLoaded(interstitialAd);
        RegistrationPage3Activity.a = interstitialAd;
        interstitialAd.setFullScreenContentCallback(this.a);
    }
}
