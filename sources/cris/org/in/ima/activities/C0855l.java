package cris.org.in.ima.activities;

import android.os.CountDownTimer;
import android.widget.TextView;
import cris.org.in.prs.ima.R;

/* renamed from: cris.org.in.ima.activities.l  reason: case insensitive filesystem */
/* compiled from: LoginActivity */
public final class C0855l extends CountDownTimer {
    public final /* synthetic */ LoginActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0855l(LoginActivity loginActivity) {
        super(60000, 1000);
        this.a = loginActivity;
    }

    public final void onFinish() {
        LoginActivity loginActivity = this.a;
        loginActivity.reSendOtp.setEnabled(true);
        loginActivity.reSendOtp.setTextColor(loginActivity.getResources().getColorStateList(R.color.blue));
        loginActivity.resendMobTimmer.setText("");
    }

    public final void onTick(long j) {
        LoginActivity loginActivity = this.a;
        loginActivity.reSendOtp.setEnabled(false);
        loginActivity.reSendOtp.setTextColor(loginActivity.getResources().getColorStateList(R.color.darkGrey));
        loginActivity.resendMobTimmer.setVisibility(0);
        TextView textView = loginActivity.resendMobTimmer;
        textView.setText(loginActivity.getString(R.string.you_allowed_resend_otp_After) + " " + (j / 1000) + " Sec.");
    }
}
