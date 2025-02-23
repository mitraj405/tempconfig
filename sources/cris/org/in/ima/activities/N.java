package cris.org.in.ima.activities;

import android.os.CountDownTimer;
import android.widget.TextView;
import cris.org.in.ima.activities.UserVerificationActivity;
import cris.org.in.prs.ima.R;

/* compiled from: UserVerificationActivity */
public final class N extends CountDownTimer {
    public final /* synthetic */ UserVerificationActivity.b a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public N(UserVerificationActivity.b bVar) {
        super(60000, 1000);
        this.a = bVar;
    }

    public final void onFinish() {
        UserVerificationActivity.b bVar = this.a;
        UserVerificationActivity.this.bt_gen_mobile_otp.setEnabled(true);
        UserVerificationActivity userVerificationActivity = UserVerificationActivity.this;
        userVerificationActivity.bt_gen_mobile_otp.setBackgroundTintList(userVerificationActivity.getResources().getColorStateList(R.color.red));
        UserVerificationActivity.this.resendMobTimmer.setText("");
    }

    public final void onTick(long j) {
        UserVerificationActivity.b bVar = this.a;
        UserVerificationActivity.this.bt_gen_mobile_otp.setEnabled(false);
        UserVerificationActivity userVerificationActivity = UserVerificationActivity.this;
        userVerificationActivity.bt_gen_mobile_otp.setBackgroundTintList(userVerificationActivity.getResources().getColorStateList(R.color.red_light));
        UserVerificationActivity.this.resendMobTimmer.setVisibility(0);
        TextView textView = UserVerificationActivity.this.resendMobTimmer;
        textView.setText(UserVerificationActivity.this.getString(R.string.you_allowed_resend_otp_After) + " " + (j / 1000) + " Sec.");
    }
}
