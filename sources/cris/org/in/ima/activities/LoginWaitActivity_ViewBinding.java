package cris.org.in.ima.activities;

import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class LoginWaitActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public LoginWaitActivity f4231a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ LoginWaitActivity a;

        public a(LoginWaitActivity loginWaitActivity) {
            this.a = loginWaitActivity;
        }

        public final void doClick(View view) {
            this.a.VerifyOtp();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ LoginWaitActivity a;

        public b(LoginWaitActivity loginWaitActivity) {
            this.a = loginWaitActivity;
        }

        public final void doClick(View view) {
            this.a.resendOtp();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ LoginWaitActivity a;

        public c(LoginWaitActivity loginWaitActivity) {
            this.a = loginWaitActivity;
        }

        public final void doClick(View view) {
            this.a.otpVerifyLayoutClick();
        }
    }

    public LoginWaitActivity_ViewBinding(LoginWaitActivity loginWaitActivity, View view) {
        this.f4231a = loginWaitActivity;
        loginWaitActivity.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progressBarLoginWait, "field 'progressBar'", ProgressBar.class);
        Class cls = TextView.class;
        loginWaitActivity.progressStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.progressStatus, "field 'progressStatus'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.otp_verify_ll, "field 'otp_verify_ll' and method 'VerifyOtp'");
        loginWaitActivity.otp_verify_ll = (TextView) Utils.castView(findRequiredView, R.id.otp_verify_ll, "field 'otp_verify_ll'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(loginWaitActivity));
        loginWaitActivity.mAdView = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.multiple_ad_sizes_view, "field 'mAdView'", AdManagerAdView.class);
        loginWaitActivity.otpInput = (EditText) Utils.findRequiredViewAsType(view, R.id.otp_input, "field 'otpInput'", EditText.class);
        loginWaitActivity.header_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.header_msg, "field 'header_msg'", cls);
        loginWaitActivity.resendTimmer = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_resend_timmer, "field 'resendTimmer'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.resend_opt, "field 'resend_opt' and method 'resendOtp'");
        loginWaitActivity.resend_opt = (TextView) Utils.castView(findRequiredView2, R.id.resend_opt, "field 'resend_opt'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(loginWaitActivity));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.otp_verify, "field 'otp_verify' and method 'otpVerifyLayoutClick'");
        loginWaitActivity.otp_verify = (RelativeLayout) Utils.castView(findRequiredView3, R.id.otp_verify, "field 'otp_verify'", RelativeLayout.class);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(loginWaitActivity));
    }

    public final void unbind() {
        LoginWaitActivity loginWaitActivity = this.f4231a;
        if (loginWaitActivity != null) {
            this.f4231a = null;
            loginWaitActivity.progressBar = null;
            loginWaitActivity.progressStatus = null;
            loginWaitActivity.otp_verify_ll = null;
            loginWaitActivity.mAdView = null;
            loginWaitActivity.otpInput = null;
            loginWaitActivity.header_msg = null;
            loginWaitActivity.resendTimmer = null;
            loginWaitActivity.resend_opt = null;
            loginWaitActivity.otp_verify = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
