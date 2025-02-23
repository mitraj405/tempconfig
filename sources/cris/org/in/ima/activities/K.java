package cris.org.in.ima.activities;

import com.google.android.gms.ads.interstitial.InterstitialAd;
import rx.Subscriber;

/* compiled from: RegistrationPage3Activity */
public final class K extends Subscriber<C0812c0> {
    public final /* synthetic */ RegistrationPage3Activity a;

    public K(RegistrationPage3Activity registrationPage3Activity) {
        this.a = registrationPage3Activity;
    }

    public final void onCompleted() {
        InterstitialAd interstitialAd = RegistrationPage3Activity.a;
        this.a.f4334a.dismiss();
    }

    public final void onError(Throwable th) {
        InterstitialAd interstitialAd = RegistrationPage3Activity.a;
        th.getClass();
        th.getMessage();
        this.a.f4334a.dismiss();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        C0812c0 c0Var = (C0812c0) obj;
        InterstitialAd interstitialAd = RegistrationPage3Activity.a;
        RegistrationPage3Activity registrationPage3Activity = this.a;
        if (c0Var != null) {
            c0Var.getPostofficeList().toString();
            registrationPage3Activity.f4344c.clear();
            for (int i = 0; i < c0Var.getPostofficeList().size(); i++) {
                registrationPage3Activity.f4344c.add(c0Var.getPostofficeList().get(i));
                registrationPage3Activity.state.setText(c0Var.getState());
            }
        }
        registrationPage3Activity.f4334a.dismiss();
    }
}
