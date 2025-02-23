package cris.org.in.ima.activities;

import android.os.CountDownTimer;
import android.widget.TextView;
import cris.org.in.prs.ima.R;

/* compiled from: LoginActivity */
public final class t extends CountDownTimer {
    public final /* synthetic */ u a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(u uVar) {
        super(60000, 1000);
        this.a = uVar;
    }

    public final void onFinish() {
        u uVar = this.a;
        uVar.a.send_otp_tv.setEnabled(true);
        LoginActivity loginActivity = uVar.a;
        loginActivity.send_otp_tv.setBackgroundTintList(loginActivity.getResources().getColorStateList(R.color.red));
        uVar.a.otpTimmer.setText("");
    }

    public final void onTick(long j) {
        u uVar = this.a;
        uVar.a.send_otp_tv.setText("Resend OTP");
        uVar.a.send_otp_tv.setEnabled(false);
        LoginActivity loginActivity = uVar.a;
        loginActivity.send_otp_tv.setBackgroundTintList(loginActivity.getResources().getColorStateList(R.color.red_light));
        TextView textView = uVar.a.otpTimmer;
        textView.setText(" in " + (j / 1000) + " Sec.");
    }
}
