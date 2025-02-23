package defpackage;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import cris.org.in.ima.activities.RegistrationPage2Activity;

/* renamed from: Ys  reason: default package and case insensitive filesystem */
/* compiled from: RegistrationPage2Activity */
public final class C0761Ys extends InterstitialAdLoadCallback {
    public final /* synthetic */ FullScreenContentCallback a;

    public C0761Ys(C1055ct ctVar) {
        this.a = ctVar;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        super.onAdFailedToLoad(loadAdError);
        RegistrationPage2Activity.a = null;
        InterstitialAd interstitialAd = RegistrationPage2Activity.a;
        loadAdError.getMessage();
    }

    public final void onAdLoaded(Object obj) {
        InterstitialAd interstitialAd = (InterstitialAd) obj;
        super.onAdLoaded(interstitialAd);
        RegistrationPage2Activity.a = interstitialAd;
        interstitialAd.setFullScreenContentCallback(this.a);
    }
}
