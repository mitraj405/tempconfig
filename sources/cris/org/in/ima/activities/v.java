package cris.org.in.ima.activities;

import android.os.CountDownTimer;
import android.widget.TextView;
import cris.org.in.ima.activities.LoginWaitActivity;
import cris.org.in.prs.ima.R;

/* compiled from: LoginWaitActivity */
public final class v extends CountDownTimer {
    public final /* synthetic */ LoginWaitActivity.d a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(LoginWaitActivity.d dVar) {
        super(60000, 1000);
        this.a = dVar;
    }

    public final void onFinish() {
        LoginWaitActivity.d dVar = this.a;
        LoginWaitActivity.this.resend_opt.setEnabled(true);
        LoginWaitActivity loginWaitActivity = LoginWaitActivity.this;
        loginWaitActivity.resend_opt.setBackgroundTintList(loginWaitActivity.getResources().getColorStateList(R.color.red));
        LoginWaitActivity.this.resendTimmer.setText("");
    }

    public final void onTick(long j) {
        LoginWaitActivity.d dVar = this.a;
        LoginWaitActivity.this.resend_opt.setEnabled(false);
        LoginWaitActivity loginWaitActivity = LoginWaitActivity.this;
        loginWaitActivity.resend_opt.setBackgroundTintList(loginWaitActivity.getResources().getColorStateList(R.color.red_light));
        LoginWaitActivity.this.resendTimmer.setVisibility(0);
        TextView textView = LoginWaitActivity.this.resendTimmer;
        textView.setText(LoginWaitActivity.this.getString(R.string.you_allowed_resend_otp_After) + " " + (j / 1000) + " Sec.");
    }
}
