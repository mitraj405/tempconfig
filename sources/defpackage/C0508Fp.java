package defpackage;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import cris.org.in.ima.fragment.PnrEnquiryFragment;

/* renamed from: Fp  reason: default package and case insensitive filesystem */
/* compiled from: PnrEnquiryFragment */
public final class C0508Fp extends InterstitialAdLoadCallback {
    public final /* synthetic */ FullScreenContentCallback a;

    public C0508Fp(C0499Ep ep) {
        this.a = ep;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        super.onAdFailedToLoad(loadAdError);
        PnrEnquiryFragment.a = null;
        InterstitialAd interstitialAd = PnrEnquiryFragment.a;
        loadAdError.getMessage();
    }

    public final void onAdLoaded(Object obj) {
        InterstitialAd interstitialAd = (InterstitialAd) obj;
        super.onAdLoaded(interstitialAd);
        PnrEnquiryFragment.a = interstitialAd;
        interstitialAd.setFullScreenContentCallback(this.a);
    }
}
