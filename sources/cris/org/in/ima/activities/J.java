package cris.org.in.ima.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import java.util.Iterator;
import rx.Subscriber;

/* compiled from: RegistrationPage2Activity */
public final class J extends Subscriber<StatusDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RegistrationPage2Activity f4204a;

    public J(RegistrationPage2Activity registrationPage2Activity, ProgressDialog progressDialog) {
        this.f4204a = registrationPage2Activity;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        InterstitialAd interstitialAd = RegistrationPage2Activity.a;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        InterstitialAd interstitialAd = RegistrationPage2Activity.a;
        xx.S(th, false, th);
    }

    public final void onNext(Object obj) {
        String next;
        StringBuilder sb;
        StatusDTO statusDTO = (StatusDTO) obj;
        InterstitialAd interstitialAd = RegistrationPage2Activity.a;
        RegistrationPage2Activity registrationPage2Activity = this.f4204a;
        if (statusDTO == null) {
            C0535I5.m(registrationPage2Activity, false, "Error occurred while processing request. Please try after some time.", registrationPage2Activity.getString(R.string.error), registrationPage2Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (statusDTO.getError() == null && (statusDTO.getErrorList() == null || statusDTO.getErrorList().size() == 0)) {
            statusDTO.getUserId();
            RegistrationPage2Activity registrationPage2Activity2 = registrationPage2Activity.f4321a;
            C0535I5.p(registrationPage2Activity2, false, statusDTO.getStatus() + "\n\n* " + registrationPage2Activity.getString(R.string.Please_login_to_verify_your_account), registrationPage2Activity.getString(R.string.Congratulations), registrationPage2Activity.getString(R.string.OK), new C0788at(this), (String) null, (DialogInterface.OnClickListener) null).show();
        } else if (statusDTO.getErrorList() != null && statusDTO.getErrorList().size() > 0) {
            Iterator<String> it = statusDTO.getErrorList().iterator();
            String str = "";
            while (it.hasNext() && (next = it.next()) != null) {
                if (!next.equals("")) {
                    if (str.equals("")) {
                        sb = new StringBuilder();
                    } else {
                        sb = xx.J(str);
                        str = "* ";
                    }
                    str = C1058d.B(sb, str, next, "\n");
                }
            }
            InterstitialAd interstitialAd2 = RegistrationPage2Activity.a;
            C0535I5.m(registrationPage2Activity, false, str, registrationPage2Activity.getString(R.string.error), registrationPage2Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (statusDTO.getError() != null) {
            registrationPage2Activity.captchaInputValue.setText("");
            C1450w1.f7025d = System.currentTimeMillis();
            this.a.dismiss();
            if (statusDTO.getError().contains("Invalid Captcha.")) {
                String string = registrationPage2Activity.getString(R.string.Invalid_Captcha);
                C0535I5.m(registrationPage2Activity, false, string, registrationPage2Activity.getString(R.string.error), registrationPage2Activity.getString(R.string.OK), new C0809bt(this, statusDTO)).show();
                return;
            }
            C0535I5.m(this.f4204a, false, statusDTO.getError(), registrationPage2Activity.getString(R.string.error), registrationPage2Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else {
            C0535I5.m(registrationPage2Activity, false, "Error occurred while processing request. Please try after some time.", registrationPage2Activity.getString(R.string.error), registrationPage2Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
