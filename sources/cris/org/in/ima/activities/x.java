package cris.org.in.ima.activities;

import android.os.CountDownTimer;
import android.widget.TextView;
import cris.org.in.prs.ima.R;

/* compiled from: LoginWaitActivity */
public final class x implements Runnable {
    public final /* synthetic */ JB a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Si f4377a;

    /* compiled from: LoginWaitActivity */
    public class a extends CountDownTimer {
        public a() {
            super(60000, 1000);
        }

        public final void onFinish() {
            x xVar = x.this;
            xVar.f4377a.a.resend_opt.setEnabled(true);
            LoginWaitActivity loginWaitActivity = xVar.f4377a.a;
            loginWaitActivity.resend_opt.setBackgroundTintList(loginWaitActivity.getResources().getColorStateList(R.color.red));
            xVar.f4377a.a.resendTimmer.setText("");
        }

        public final void onTick(long j) {
            x xVar = x.this;
            xVar.f4377a.a.resend_opt.setEnabled(false);
            LoginWaitActivity loginWaitActivity = xVar.f4377a.a;
            loginWaitActivity.resend_opt.setBackgroundTintList(loginWaitActivity.getResources().getColorStateList(R.color.red_light));
            xVar.f4377a.a.resendTimmer.setVisibility(0);
            TextView textView = xVar.f4377a.a.resendTimmer;
            textView.setText(xVar.f4377a.a.getString(R.string.you_allowed_resend_otp_After) + " " + (j / 1000) + " Sec.");
        }
    }

    public x(Si si, JB jb) {
        this.f4377a = si;
        this.a = jb;
    }

    public final void run() {
        Si si = this.f4377a;
        si.a.otp_verify.setVisibility(0);
        si.a.header_msg.setText(this.a.getStatus());
        new a().start();
    }
}
