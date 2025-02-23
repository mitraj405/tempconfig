package cris.org.in.ima.activities;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class UserVerificationActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public UserVerificationActivity f4371a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ UserVerificationActivity a;

        public a(UserVerificationActivity userVerificationActivity) {
            this.a = userVerificationActivity;
        }

        public final void doClick(View view) {
            this.a.editMobile();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ UserVerificationActivity a;

        public b(UserVerificationActivity userVerificationActivity) {
            this.a = userVerificationActivity;
        }

        public final void doClick(View view) {
            this.a.editEmail();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ UserVerificationActivity a;

        public c(UserVerificationActivity userVerificationActivity) {
            this.a = userVerificationActivity;
        }

        public final void doClick(View view) {
            this.a.generateMobileOTPClick();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ UserVerificationActivity a;

        public d(UserVerificationActivity userVerificationActivity) {
            this.a = userVerificationActivity;
        }

        public final void doClick(View view) {
            this.a.generateEmailOTPClick();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ UserVerificationActivity a;

        public e(UserVerificationActivity userVerificationActivity) {
            this.a = userVerificationActivity;
        }

        public final void doClick(View view) {
            this.a.submitOTPClick();
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ UserVerificationActivity a;

        public f(UserVerificationActivity userVerificationActivity) {
            this.a = userVerificationActivity;
        }

        public final void doClick(View view) {
            this.a.onBackArrowClick();
        }
    }

    public UserVerificationActivity_ViewBinding(UserVerificationActivity userVerificationActivity, View view) {
        this.f4371a = userVerificationActivity;
        Class cls = TextView.class;
        userVerificationActivity.titleName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title_name, "field 'titleName'", cls);
        userVerificationActivity.userNameTv = (TextView) Utils.findRequiredViewAsType(view, R.id.username, "field 'userNameTv'", cls);
        Class cls2 = EditText.class;
        userVerificationActivity.et_isd = (EditText) Utils.findRequiredViewAsType(view, R.id.et_isd, "field 'et_isd'", cls2);
        userVerificationActivity.et_mobile = (EditText) Utils.findRequiredViewAsType(view, R.id.et_mobile, "field 'et_mobile'", cls2);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_mobile_edit, "field 'tv_mobile_edit' and method 'editMobile'");
        userVerificationActivity.tv_mobile_edit = (TextView) Utils.castView(findRequiredView, R.id.tv_mobile_edit, "field 'tv_mobile_edit'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(userVerificationActivity));
        userVerificationActivity.verifyMobileTv = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_verify_mobile, "field 'verifyMobileTv'", cls);
        userVerificationActivity.et_email = (EditText) Utils.findRequiredViewAsType(view, R.id.et_email, "field 'et_email'", cls2);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_email_edit, "field 'tv_email_edit' and method 'editEmail'");
        userVerificationActivity.tv_email_edit = (TextView) Utils.castView(findRequiredView2, R.id.tv_email_edit, "field 'tv_email_edit'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(userVerificationActivity));
        userVerificationActivity.verifyEmailTv = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_verify_email, "field 'verifyEmailTv'", cls);
        userVerificationActivity.mobileInputOTP = (EditText) Utils.findRequiredViewAsType(view, R.id.et_mobile_otp, "field 'mobileInputOTP'", cls2);
        userVerificationActivity.emailInputOTP = (EditText) Utils.findRequiredViewAsType(view, R.id.et_email_otp, "field 'emailInputOTP'", cls2);
        userVerificationActivity.mobile_verify = (TextView) Utils.findRequiredViewAsType(view, R.id.mobile_verify, "field 'mobile_verify'", cls);
        userVerificationActivity.email_verify = (TextView) Utils.findRequiredViewAsType(view, R.id.email_verify, "field 'email_verify'", cls);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.bt_gen_mobile_otp, "field 'bt_gen_mobile_otp' and method 'generateMobileOTPClick'");
        userVerificationActivity.bt_gen_mobile_otp = (TextView) Utils.castView(findRequiredView3, R.id.bt_gen_mobile_otp, "field 'bt_gen_mobile_otp'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(userVerificationActivity));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.bt_gen_email_otp, "field 'bt_gen_email_otp' and method 'generateEmailOTPClick'");
        userVerificationActivity.bt_gen_email_otp = (TextView) Utils.castView(findRequiredView4, R.id.bt_gen_email_otp, "field 'bt_gen_email_otp'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(userVerificationActivity));
        userVerificationActivity.resendMobTimmer = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_resend_mob_timmer, "field 'resendMobTimmer'", cls);
        userVerificationActivity.resendMailTimmer = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_resend_mail_timmer, "field 'resendMailTimmer'", cls);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.verify, "method 'submitOTPClick'");
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(userVerificationActivity));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.iv_back_arrow, "method 'onBackArrowClick'");
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new f(userVerificationActivity));
    }

    public final void unbind() {
        UserVerificationActivity userVerificationActivity = this.f4371a;
        if (userVerificationActivity != null) {
            this.f4371a = null;
            userVerificationActivity.titleName = null;
            userVerificationActivity.userNameTv = null;
            userVerificationActivity.et_isd = null;
            userVerificationActivity.et_mobile = null;
            userVerificationActivity.tv_mobile_edit = null;
            userVerificationActivity.verifyMobileTv = null;
            userVerificationActivity.et_email = null;
            userVerificationActivity.tv_email_edit = null;
            userVerificationActivity.verifyEmailTv = null;
            userVerificationActivity.mobileInputOTP = null;
            userVerificationActivity.emailInputOTP = null;
            userVerificationActivity.mobile_verify = null;
            userVerificationActivity.email_verify = null;
            userVerificationActivity.bt_gen_mobile_otp = null;
            userVerificationActivity.bt_gen_email_otp = null;
            userVerificationActivity.resendMobTimmer = null;
            userVerificationActivity.resendMailTimmer = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            this.e.setOnClickListener((View.OnClickListener) null);
            this.e = null;
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
