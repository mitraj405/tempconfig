package cris.org.in.ima.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.TextView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import java.util.Iterator;
import rx.Subscriber;

/* compiled from: RegistrationPage3Activity */
public final class M extends Subscriber<StatusDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ RegistrationPage3Activity f4232a;

    public M(RegistrationPage3Activity registrationPage3Activity, ProgressDialog progressDialog) {
        this.f4232a = registrationPage3Activity;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        InterstitialAd interstitialAd = RegistrationPage3Activity.a;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        InterstitialAd interstitialAd = RegistrationPage3Activity.a;
        xx.S(th, false, th);
    }

    public final void onNext(Object obj) {
        String next;
        StringBuilder sb;
        StatusDTO statusDTO = (StatusDTO) obj;
        InterstitialAd interstitialAd = RegistrationPage3Activity.a;
        RegistrationPage3Activity registrationPage3Activity = this.f4232a;
        if (statusDTO == null) {
            C0535I5.m(registrationPage3Activity, false, "Error occurred while processing request. Please try after some time.", registrationPage3Activity.getString(R.string.error), registrationPage3Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (statusDTO.getError() == null && (statusDTO.getErrorList() == null || statusDTO.getErrorList().size() == 0)) {
            statusDTO.getUserId();
            registrationPage3Activity.residence.setVisibility(0);
            registrationPage3Activity.residence_ll.setVisibility(8);
            registrationPage3Activity.f4346d = true;
            TextView textView = registrationPage3Activity.userStatusverify;
            textView.setText(statusDTO.getStatus() + " \n\n* " + registrationPage3Activity.getString(R.string.Please_login_to_verify_your_account));
            GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
            googleAdParamDTO.setAge(C1450w1.f7009a);
            googleAdParamDTO.setGender(C1450w1.f7021c);
            C0535I5.Y(registrationPage3Activity.b, registrationPage3Activity.mPublisherAdview, googleAdParamDTO);
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
            InterstitialAd interstitialAd2 = RegistrationPage3Activity.a;
            C0535I5.m(registrationPage3Activity, false, str, registrationPage3Activity.getString(R.string.error), registrationPage3Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (statusDTO.getError() != null) {
            registrationPage3Activity.captchaInputValue.setText("");
            C1450w1.f7025d = System.currentTimeMillis();
            this.a.dismiss();
            C0535I5.m(this.f4232a, false, statusDTO.getError(), registrationPage3Activity.getString(R.string.error), registrationPage3Activity.getString(R.string.OK), new C1140gt(this, statusDTO)).show();
        } else {
            C0535I5.m(registrationPage3Activity, false, "Error occurred while processing request. Please try after some time.", registrationPage3Activity.getString(R.string.error), registrationPage3Activity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
