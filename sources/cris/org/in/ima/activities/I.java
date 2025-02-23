package cris.org.in.ima.activities;

import android.content.DialogInterface;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: RegistrationPage2Activity */
public final class I extends Subscriber<C0812c0> {
    public final /* synthetic */ RegistrationPage2Activity a;
    public final /* synthetic */ String c;

    public I(RegistrationPage2Activity registrationPage2Activity, String str) {
        this.a = registrationPage2Activity;
        this.c = str;
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
            c0Var.toString();
            String error = c0Var.getError();
            String str = this.c;
            if (error == null) {
                registrationPage2Activity.f4323a.clear();
                registrationPage2Activity.f4328c.clear();
                for (int i = 0; i < c0Var.getCityList().size(); i++) {
                    registrationPage2Activity.f4323a.add(c0Var.getCityList().get(i));
                }
                registrationPage2Activity.g = str;
                registrationPage2Activity.state.setFocusable(true);
            } else {
                registrationPage2Activity.g = str;
                registrationPage2Activity.f4323a.clear();
                registrationPage2Activity.f4328c.clear();
                registrationPage2Activity.state.setText((CharSequence) null);
                registrationPage2Activity.pincode.setError(c0Var.getError());
                registrationPage2Activity.f4319a.dismiss();
                C0535I5.m(registrationPage2Activity.f4321a, true, registrationPage2Activity.getString(R.string.enter_valid_pincode), registrationPage2Activity.getString(R.string.error), registrationPage2Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                registrationPage2Activity.pincode.setText("");
            }
        } else {
            registrationPage2Activity.pincode.setError("");
        }
        registrationPage2Activity.f4319a.dismiss();
    }
}
