package cris.org.in.ima.activities;

import com.google.android.gms.ads.interstitial.InterstitialAd;
import rx.Subscriber;

/* compiled from: RegistrationPage2Activity */
public final class H extends Subscriber<C0812c0> {
    public final /* synthetic */ RegistrationPage2Activity a;

    public H(RegistrationPage2Activity registrationPage2Activity) {
        this.a = registrationPage2Activity;
    }

    public final void onCompleted() {
        InterstitialAd interstitialAd = RegistrationPage2Activity.a;
        this.a.f4319a.dismiss();
    }

    public final void onError(Throwable th) {
        InterstitialAd interstitialAd = RegistrationPage2Activity.a;
        th.getClass();
        th.getMessage();
        this.a.f4319a.dismiss();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        C0812c0 c0Var = (C0812c0) obj;
        InterstitialAd interstitialAd = RegistrationPage2Activity.a;
        RegistrationPage2Activity registrationPage2Activity = this.a;
        if (c0Var != null) {
            c0Var.getPostofficeList().toString();
            registrationPage2Activity.f4328c.clear();
            for (int i = 0; i < c0Var.getPostofficeList().size(); i++) {
                registrationPage2Activity.f4328c.add(c0Var.getPostofficeList().get(i));
                registrationPage2Activity.state.setText(c0Var.getState());
            }
        }
        registrationPage2Activity.f4319a.dismiss();
    }
}
