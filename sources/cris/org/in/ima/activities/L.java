package cris.org.in.ima.activities;

import android.content.DialogInterface;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: RegistrationPage3Activity */
public final class L extends Subscriber<C0812c0> {
    public final /* synthetic */ RegistrationPage3Activity a;
    public final /* synthetic */ String c;

    public L(RegistrationPage3Activity registrationPage3Activity, String str) {
        this.a = registrationPage3Activity;
        this.c = str;
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
            c0Var.toString();
            String error = c0Var.getError();
            String str = this.c;
            if (error == null) {
                registrationPage3Activity.f4338a.clear();
                registrationPage3Activity.f4344c.clear();
                for (int i = 0; i < c0Var.getCityList().size(); i++) {
                    registrationPage3Activity.f4338a.add(c0Var.getCityList().get(i));
                }
                registrationPage3Activity.g = str;
            } else {
                registrationPage3Activity.g = str;
                registrationPage3Activity.f4338a.clear();
                registrationPage3Activity.f4344c.clear();
                registrationPage3Activity.state.setText((CharSequence) null);
                registrationPage3Activity.pincode.setError(c0Var.getError());
                registrationPage3Activity.f4334a.dismiss();
                C0535I5.m(registrationPage3Activity.f4336a, true, c0Var.getError(), registrationPage3Activity.getString(R.string.error), registrationPage3Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        } else {
            registrationPage3Activity.pincode.setError("");
        }
        registrationPage3Activity.f4334a.dismiss();
    }
}
