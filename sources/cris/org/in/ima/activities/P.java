package cris.org.in.ima.activities;

import android.content.DialogInterface;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* compiled from: UserVerificationActivity */
public final class P extends Subscriber<StatusDTO> {
    public final /* synthetic */ UserVerificationActivity a;
    public final /* synthetic */ String c;

    public P(UserVerificationActivity userVerificationActivity, String str) {
        this.a = userVerificationActivity;
        this.c = str;
    }

    public final void onCompleted() {
        int i = UserVerificationActivity.c;
        this.a.a.dismiss();
    }

    public final void onError(Throwable th) {
        this.a.a.dismiss();
        int i = UserVerificationActivity.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        StatusDTO statusDTO = (StatusDTO) obj;
        UserVerificationActivity userVerificationActivity = this.a;
        userVerificationActivity.a.dismiss();
        if (statusDTO != null) {
            if (statusDTO.getError() == null) {
                int i = UserVerificationActivity.c;
                statusDTO.getStatus();
                String str = this.c;
                if (str.equals("M")) {
                    userVerificationActivity.mobileInputOTP.setText((CharSequence) null);
                    userVerificationActivity.b = true;
                    userVerificationActivity.mobile_verify.setText(userVerificationActivity.getString(R.string.mobile_number_verified));
                    userVerificationActivity.mobile_verify.setTextColor(userVerificationActivity.getResources().getColor(R.color.green));
                    userVerificationActivity.mobileInputOTP.setVisibility(8);
                    userVerificationActivity.bt_gen_mobile_otp.setVisibility(8);
                    userVerificationActivity.verifyMobileTv.setVisibility(8);
                    userVerificationActivity.et_isd.setVisibility(8);
                    userVerificationActivity.et_mobile.setVisibility(8);
                    userVerificationActivity.tv_mobile_edit.setVisibility(8);
                } else if (str.equals("E")) {
                    userVerificationActivity.emailInputOTP.setText((CharSequence) null);
                    userVerificationActivity.f4367a = true;
                    userVerificationActivity.email_verify.setText(userVerificationActivity.getString(R.string.emial_id_verified));
                    userVerificationActivity.email_verify.setTextColor(userVerificationActivity.getResources().getColor(R.color.green));
                    userVerificationActivity.emailInputOTP.setVisibility(8);
                    userVerificationActivity.bt_gen_email_otp.setVisibility(8);
                    userVerificationActivity.verifyEmailTv.setVisibility(8);
                    userVerificationActivity.et_email.setVisibility(8);
                    userVerificationActivity.tv_email_edit.setVisibility(8);
                } else {
                    userVerificationActivity.f4367a = true;
                    userVerificationActivity.b = true;
                }
                if (!userVerificationActivity.f4367a || !userVerificationActivity.b) {
                    userVerificationActivity.init();
                    if (str.equals("M")) {
                        C0535I5.o(userVerificationActivity, "Mob " + statusDTO.getStatus().replace("OTP", "otp"), "OK", (DialogInterface.OnClickListener) null).show();
                    } else if (str.equals("E")) {
                        C0535I5.o(userVerificationActivity, "Email " + statusDTO.getStatus().replace("OTP", "otp"), "OK", (DialogInterface.OnClickListener) null).show();
                    }
                    if (str.equals("M")) {
                        userVerificationActivity.mobile_verify.setText("Mobile Number Verified");
                        userVerificationActivity.mobile_verify.setTextColor(userVerificationActivity.getResources().getColor(R.color.green));
                        userVerificationActivity.mobileInputOTP.setVisibility(8);
                        userVerificationActivity.bt_gen_mobile_otp.setVisibility(8);
                        userVerificationActivity.verifyMobileTv.setVisibility(8);
                        userVerificationActivity.et_isd.setVisibility(8);
                        userVerificationActivity.et_mobile.setVisibility(8);
                        userVerificationActivity.tv_mobile_edit.setVisibility(8);
                    }
                    if (str.equals("E")) {
                        userVerificationActivity.email_verify.setText(userVerificationActivity.getString(R.string.emial_id_verified));
                        userVerificationActivity.email_verify.setTextColor(userVerificationActivity.getResources().getColor(R.color.green));
                        userVerificationActivity.emailInputOTP.setVisibility(8);
                        userVerificationActivity.bt_gen_email_otp.setVisibility(8);
                        userVerificationActivity.verifyEmailTv.setVisibility(8);
                        userVerificationActivity.et_email.setVisibility(8);
                        userVerificationActivity.tv_email_edit.setVisibility(8);
                    }
                } else {
                    C0535I5.p(userVerificationActivity.f4366a, false, statusDTO.getStatus(), userVerificationActivity.getString(R.string.Congratulations), userVerificationActivity.getString(R.string.OK), new NB(this), (String) null, (DialogInterface.OnClickListener) null).show();
                }
            } else {
                C0535I5.m(this.a, false, statusDTO.getError(), userVerificationActivity.getString(R.string.error), userVerificationActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                userVerificationActivity.mobileInputOTP.setText((CharSequence) null);
                userVerificationActivity.emailInputOTP.setText((CharSequence) null);
            }
            userVerificationActivity.a.dismiss();
            return;
        }
        C0535I5.m(userVerificationActivity, false, "Unable To Process Your Request.\nPlease Try After Sometime.", userVerificationActivity.getString(R.string.error), userVerificationActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        userVerificationActivity.a.dismiss();
    }
}
