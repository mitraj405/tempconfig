package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class ForgotTxnPasswordFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public ForgotTxnPasswordFragment f4646a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ForgotTxnPasswordFragment a;

        public a(ForgotTxnPasswordFragment forgotTxnPasswordFragment) {
            this.a = forgotTxnPasswordFragment;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ForgotTxnPasswordFragment a;

        public b(ForgotTxnPasswordFragment forgotTxnPasswordFragment) {
            this.a = forgotTxnPasswordFragment;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide1();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ForgotTxnPasswordFragment a;

        public c(ForgotTxnPasswordFragment forgotTxnPasswordFragment) {
            this.a = forgotTxnPasswordFragment;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide2();
        }
    }

    public ForgotTxnPasswordFragment_ViewBinding(ForgotTxnPasswordFragment forgotTxnPasswordFragment, View view) {
        this.f4646a = forgotTxnPasswordFragment;
        Class cls = LinearLayout.class;
        forgotTxnPasswordFragment.ll_send_otp = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_send_otp, "field 'll_send_otp'", cls);
        Class cls2 = EditText.class;
        forgotTxnPasswordFragment.et_forgot_pwd_email = (EditText) Utils.findRequiredViewAsType(view, R.id.et_forgot_pwd_email, "field 'et_forgot_pwd_email'", cls2);
        forgotTxnPasswordFragment.et_forgot_pwd_login_pwd = (EditText) Utils.findRequiredViewAsType(view, R.id.et_forgot_pwd_login_pwd, "field 'et_forgot_pwd_login_pwd'", cls2);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_forgot_pwd_login_pwd_show_hide, "field 'tv_forgot_pwd_login_pwd_show_hide' and method 'pwdShowHide'");
        Class cls3 = TextView.class;
        forgotTxnPasswordFragment.tv_forgot_pwd_login_pwd_show_hide = (TextView) Utils.castView(findRequiredView, R.id.tv_forgot_pwd_login_pwd_show_hide, "field 'tv_forgot_pwd_login_pwd_show_hide'", cls3);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(forgotTxnPasswordFragment));
        forgotTxnPasswordFragment.ll_forgot_pass = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_forgot_pass, "field 'll_forgot_pass'", cls);
        forgotTxnPasswordFragment.verify_OTP = (EditText) Utils.findRequiredViewAsType(view, R.id.verify_OTP, "field 'verify_OTP'", cls2);
        forgotTxnPasswordFragment.newPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.new_Password, "field 'newPassword'", cls2);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.newPass_Visibi, "field 'newPass_Visibi' and method 'pwdShowHide1'");
        forgotTxnPasswordFragment.newPass_Visibi = (TextView) Utils.castView(findRequiredView2, R.id.newPass_Visibi, "field 'newPass_Visibi'", cls3);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(forgotTxnPasswordFragment));
        forgotTxnPasswordFragment.confirmPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.et_confirm_password, "field 'confirmPassword'", cls2);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.conPass_Visibi, "field 'conPassVisibi' and method 'pwdShowHide2'");
        forgotTxnPasswordFragment.conPassVisibi = (TextView) Utils.castView(findRequiredView3, R.id.conPass_Visibi, "field 'conPassVisibi'", cls3);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(forgotTxnPasswordFragment));
        forgotTxnPasswordFragment.mPublisherAdview = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.multiple_ad_sizes_view, "field 'mPublisherAdview'", AdManagerAdView.class);
    }

    public final void unbind() {
        ForgotTxnPasswordFragment forgotTxnPasswordFragment = this.f4646a;
        if (forgotTxnPasswordFragment != null) {
            this.f4646a = null;
            forgotTxnPasswordFragment.ll_send_otp = null;
            forgotTxnPasswordFragment.et_forgot_pwd_email = null;
            forgotTxnPasswordFragment.et_forgot_pwd_login_pwd = null;
            forgotTxnPasswordFragment.tv_forgot_pwd_login_pwd_show_hide = null;
            forgotTxnPasswordFragment.ll_forgot_pass = null;
            forgotTxnPasswordFragment.verify_OTP = null;
            forgotTxnPasswordFragment.newPassword = null;
            forgotTxnPasswordFragment.newPass_Visibi = null;
            forgotTxnPasswordFragment.confirmPassword = null;
            forgotTxnPasswordFragment.conPassVisibi = null;
            forgotTxnPasswordFragment.mPublisherAdview = null;
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
