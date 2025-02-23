package cris.org.in.ima.activities;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class LoginActivity_ViewBinding implements Unbinder {
    public View A;
    public View B;
    public View C;
    public View D;
    public View E;
    public View F;
    public View G;
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public LoginActivity f4223a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;
    public View l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public View v;
    public View w;
    public View x;
    public View y;
    public View z;

    public class A extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public A(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.refreshCaptcha(view);
        }
    }

    public class B extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public B(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onSubmitUser();
        }
    }

    public class C extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public C(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.dobCalender();
        }
    }

    public class D extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public D(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onClickSpinnerDisable(view);
        }
    }

    public class E extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public E(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onCheckOtpBookingClick();
        }
    }

    public class F implements View.OnFocusChangeListener {
        public final /* synthetic */ LoginActivity a;

        public F(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.validateUser(view);
        }
    }

    public class G extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public G(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onForgotPasswordClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.activities.LoginActivity_ViewBinding$a  reason: case insensitive filesystem */
    public class C0837a extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public C0837a(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onClickforgotPwdSpinnerGone(view);
        }
    }

    /* renamed from: cris.org.in.ima.activities.LoginActivity_ViewBinding$b  reason: case insensitive filesystem */
    public class C0838b extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public C0838b(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onClickforgotPwdCnfSpinnerGone(view);
        }
    }

    /* renamed from: cris.org.in.ima.activities.LoginActivity_ViewBinding$c  reason: case insensitive filesystem */
    public class C0839c implements View.OnFocusChangeListener {
        public final /* synthetic */ LoginActivity a;

        public C0839c(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            LoginActivity loginActivity = this.a;
            loginActivity.validUserChangePwd(view);
            loginActivity.validateCaptcha(view);
        }
    }

    /* renamed from: cris.org.in.ima.activities.LoginActivity_ViewBinding$d  reason: case insensitive filesystem */
    public class C0840d extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public C0840d(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.refreshCaptchaPwd(view);
        }
    }

    /* renamed from: cris.org.in.ima.activities.LoginActivity_ViewBinding$e  reason: case insensitive filesystem */
    public class C0841e extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public C0841e(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onGenerateClick();
        }
    }

    /* renamed from: cris.org.in.ima.activities.LoginActivity_ViewBinding$f  reason: case insensitive filesystem */
    public class C0842f implements View.OnFocusChangeListener {
        public final /* synthetic */ LoginActivity a;

        public C0842f(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.passwordval(view);
        }
    }

    /* renamed from: cris.org.in.ima.activities.LoginActivity_ViewBinding$g  reason: case insensitive filesystem */
    public class C0843g implements View.OnFocusChangeListener {
        public final /* synthetic */ LoginActivity a;

        public C0843g(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.cnfPasswordval(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public h(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.refreshCaptchaCNFPwd(view);
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public i(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onConfirmClick();
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public j(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide();
        }
    }

    public class k extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public k(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onAgentLoginClick(view);
        }
    }

    public class l extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public l(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.confPwdShowHide();
        }
    }

    public class m extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public m(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onbusClick(view);
        }
    }

    public class n extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public n(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onhotelClick(view);
        }
    }

    public class o extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public o(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onClickWithOtp(view);
        }
    }

    public class p extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public p(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onClickWithPassword(view);
        }
    }

    public class q extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public q(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onClickSendOtp(view);
        }
    }

    public class r extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public r(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.loginCaptchaRefresh();
        }
    }

    public class s extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public s(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onSubmitPwd();
        }
    }

    public class t extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public t(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onUserGuideClick();
        }
    }

    public class u extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public u(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onTourismAppClick(view);
        }
    }

    public class v extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public v(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onLoginClick(view);
        }
    }

    public class w extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public w(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onCateringAppClick(view);
        }
    }

    public class x extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public x(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onUtsAppClick(view);
        }
    }

    public class y extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public y(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onAirAppClick(view);
        }
    }

    public class z extends DebouncingOnClickListener {
        public final /* synthetic */ LoginActivity a;

        public z(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        public final void doClick(View view) {
            this.a.onBackClick();
        }
    }

    public LoginActivity_ViewBinding(LoginActivity loginActivity, View view) {
        this.f4223a = loginActivity;
        Class cls = EditText.class;
        loginActivity.userName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_username, "field 'userName'", cls);
        loginActivity.password = (EditText) Utils.findRequiredViewAsType(view, R.id.et_password, "field 'password'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.agent_login, "field 'agent_login' and method 'onAgentLoginClick'");
        Class cls2 = TextView.class;
        loginActivity.agent_login = (TextView) Utils.castView(findRequiredView, R.id.agent_login, "field 'agent_login'", cls2);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new k(loginActivity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.rl_login_layout, "field 'loginButtonLo' and method 'onLoginClick'");
        Class cls3 = RelativeLayout.class;
        loginActivity.loginButtonLo = (RelativeLayout) Utils.castView(findRequiredView2, R.id.rl_login_layout, "field 'loginButtonLo'", cls3);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new v(loginActivity));
        loginActivity.registerUser = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_register, "field 'registerUser'", cls2);
        Class cls4 = LinearLayout.class;
        loginActivity.captchaLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.captch_ll, "field 'captchaLayout'", cls4);
        Class cls5 = ImageView.class;
        loginActivity.captcha = (ImageView) Utils.findRequiredViewAsType(view, R.id.captcha, "field 'captcha'", cls5);
        loginActivity.loading_Captcha = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_loading_captcha, "field 'loading_Captcha'", cls2);
        loginActivity.captchaInputValue = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_captcha_input, "field 'captchaInputValue'", cls);
        loginActivity.etCaptcha = (EditText) Utils.findRequiredViewAsType(view, R.id.captcha_input, "field 'etCaptcha'", cls);
        loginActivity.resendMobTimmer = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_resend_mob_timmer, "field 'resendMobTimmer'", cls2);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.captchaRefresh, "field 'refreshCaptcha' and method 'refreshCaptcha'");
        loginActivity.refreshCaptcha = (ImageView) Utils.castView(findRequiredView3, R.id.captchaRefresh, "field 'refreshCaptcha'", cls5);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new A(loginActivity));
        loginActivity.captchaForgotUserId = (ImageView) Utils.findRequiredViewAsType(view, R.id.captcha_forgot_user, "field 'captchaForgotUserId'", cls5);
        loginActivity.loadingCaptcha = (TextView) Utils.findRequiredViewAsType(view, R.id.loading_captcha, "field 'loadingCaptcha'", cls2);
        loginActivity.submitForgotId = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.submit_forgot_id, "field 'submitForgotId'", cls3);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.submit_userid, "field 'submitUserId' and method 'onSubmitUser'");
        loginActivity.submitUserId = (TextView) Utils.castView(findRequiredView4, R.id.submit_userid, "field 'submitUserId'", cls2);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new B(loginActivity));
        loginActivity.user_dob = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_user_dob, "field 'user_dob'", cls);
        loginActivity.useremail = (EditText) Utils.findRequiredViewAsType(view, R.id.useremail, "field 'useremail'", cls);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.calender, "field 'calender' and method 'dobCalender'");
        loginActivity.calender = (ImageView) Utils.castView(findRequiredView5, R.id.calender, "field 'calender'", cls5);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new C(loginActivity));
        loginActivity.message = (TextView) Utils.findRequiredViewAsType(view, R.id.message, "field 'message'", cls2);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.forgot_userId_ll, "field 'forgotUserId' and method 'onClickSpinnerDisable'");
        loginActivity.forgotUserId = (RelativeLayout) Utils.castView(findRequiredView6, R.id.forgot_userId_ll, "field 'forgotUserId'", cls3);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new D(loginActivity));
        View findRequiredView7 = Utils.findRequiredView(view, R.id.cb_check_otp_booking, "field 'bookingWithOtp' and method 'onCheckOtpBookingClick'");
        loginActivity.bookingWithOtp = (CheckBox) Utils.castView(findRequiredView7, R.id.cb_check_otp_booking, "field 'bookingWithOtp'", CheckBox.class);
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new E(loginActivity));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.forgot_user_detail, "field 'forgot_userdetail' and method 'validateUser'");
        loginActivity.forgot_userdetail = (EditText) Utils.castView(findRequiredView8, R.id.forgot_user_detail, "field 'forgot_userdetail'", cls);
        this.h = findRequiredView8;
        findRequiredView8.setOnFocusChangeListener(new F(loginActivity));
        View findRequiredView9 = Utils.findRequiredView(view, R.id.forgotuser_pass, "field 'forgotPasswordOnclick' and method 'onForgotPasswordClick'");
        loginActivity.forgotPasswordOnclick = (TextView) Utils.castView(findRequiredView9, R.id.forgotuser_pass, "field 'forgotPasswordOnclick'", cls2);
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new G(loginActivity));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.forgot_pass_rl, "field 'forgotUserPwd' and method 'onClickforgotPwdSpinnerGone'");
        loginActivity.forgotUserPwd = (RelativeLayout) Utils.castView(findRequiredView10, R.id.forgot_pass_rl, "field 'forgotUserPwd'", cls3);
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new C0837a(loginActivity));
        View findRequiredView11 = Utils.findRequiredView(view, R.id.forgot_pass_change2, "field 'changePwdlayout' and method 'onClickforgotPwdCnfSpinnerGone'");
        loginActivity.changePwdlayout = (RelativeLayout) Utils.castView(findRequiredView11, R.id.forgot_pass_change2, "field 'changePwdlayout'", cls3);
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new C0838b(loginActivity));
        View findRequiredView12 = Utils.findRequiredView(view, R.id.et_enter_captcha, "field 'ChangePwdetCaptcha', method 'validUserChangePwd', and method 'validateCaptcha'");
        loginActivity.ChangePwdetCaptcha = (EditText) Utils.castView(findRequiredView12, R.id.et_enter_captcha, "field 'ChangePwdetCaptcha'", cls);
        this.l = findRequiredView12;
        findRequiredView12.setOnFocusChangeListener(new C0839c(loginActivity));
        View findRequiredView13 = Utils.findRequiredView(view, R.id.change_pwd_refreshcaptcha, "field 'ChangePwdrefreshCaptcha' and method 'refreshCaptchaPwd'");
        loginActivity.ChangePwdrefreshCaptcha = (ImageView) Utils.castView(findRequiredView13, R.id.change_pwd_refreshcaptcha, "field 'ChangePwdrefreshCaptcha'", cls5);
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new C0840d(loginActivity));
        loginActivity.captchaChangePwd = (ImageView) Utils.findRequiredViewAsType(view, R.id.change_pwd_captcha, "field 'captchaChangePwd'", cls5);
        loginActivity.loadingCaptchaChangePwd = (TextView) Utils.findRequiredViewAsType(view, R.id.et_captcha_forgot_pwd, "field 'loadingCaptchaChangePwd'", cls2);
        loginActivity.userNameShow = (EditText) Utils.findRequiredViewAsType(view, R.id.change_pwd_username, "field 'userNameShow'", cls);
        View findRequiredView14 = Utils.findRequiredView(view, R.id.generate_otp, "field 'reSendOtp' and method 'onGenerateClick'");
        loginActivity.reSendOtp = (TextView) Utils.castView(findRequiredView14, R.id.generate_otp, "field 'reSendOtp'", cls2);
        this.n = findRequiredView14;
        findRequiredView14.setOnClickListener(new C0841e(loginActivity));
        View findRequiredView15 = Utils.findRequiredView(view, R.id.new_password, "field 'newPassword' and method 'passwordval'");
        loginActivity.newPassword = (EditText) Utils.castView(findRequiredView15, R.id.new_password, "field 'newPassword'", cls);
        this.o = findRequiredView15;
        findRequiredView15.setOnFocusChangeListener(new C0842f(loginActivity));
        View findRequiredView16 = Utils.findRequiredView(view, R.id.confirm_password, "field 'confirmPassword' and method 'cnfPasswordval'");
        loginActivity.confirmPassword = (EditText) Utils.castView(findRequiredView16, R.id.confirm_password, "field 'confirmPassword'", cls);
        this.p = findRequiredView16;
        findRequiredView16.setOnFocusChangeListener(new C0843g(loginActivity));
        loginActivity.CnfCaptchaEnter = (EditText) Utils.findRequiredViewAsType(view, R.id.cnf_pwd_captchaenter, "field 'CnfCaptchaEnter'", cls);
        View findRequiredView17 = Utils.findRequiredView(view, R.id.cnf_pwd_captchaRefresh, "field 'CnfPwdrefreshCaptcha' and method 'refreshCaptchaCNFPwd'");
        loginActivity.CnfPwdrefreshCaptcha = (ImageView) Utils.castView(findRequiredView17, R.id.cnf_pwd_captchaRefresh, "field 'CnfPwdrefreshCaptcha'", cls5);
        this.q = findRequiredView17;
        findRequiredView17.setOnClickListener(new h(loginActivity));
        loginActivity.captchaCnfPwd = (ImageView) Utils.findRequiredViewAsType(view, R.id.cnf_pwd_captcha, "field 'captchaCnfPwd'", cls5);
        loginActivity.loadingCaptchaCnfPwd = (TextView) Utils.findRequiredViewAsType(view, R.id.cnf_pwd_loading_captcha, "field 'loadingCaptchaCnfPwd'", cls2);
        View findRequiredView18 = Utils.findRequiredView(view, R.id.confirm_pwd, "field 'submitPwd' and method 'onConfirmClick'");
        loginActivity.submitPwd = (TextView) Utils.castView(findRequiredView18, R.id.confirm_pwd, "field 'submitPwd'", cls2);
        this.r = findRequiredView18;
        findRequiredView18.setOnClickListener(new i(loginActivity));
        loginActivity.otpMsgsShow = (TextView) Utils.findRequiredViewAsType(view, R.id.otp_sent_msgs, "field 'otpMsgsShow'", cls2);
        View findRequiredView19 = Utils.findRequiredView(view, R.id.tv_pwd_show_hide, "field 'tvPwdShowHide' and method 'pwdShowHide'");
        loginActivity.tvPwdShowHide = (TextView) Utils.castView(findRequiredView19, R.id.tv_pwd_show_hide, "field 'tvPwdShowHide'", cls2);
        this.s = findRequiredView19;
        findRequiredView19.setOnClickListener(new j(loginActivity));
        View findRequiredView20 = Utils.findRequiredView(view, R.id.tv_conf_pwd_show_hide, "field 'tvConfPwdShowHide' and method 'confPwdShowHide'");
        loginActivity.tvConfPwdShowHide = (TextView) Utils.castView(findRequiredView20, R.id.tv_conf_pwd_show_hide, "field 'tvConfPwdShowHide'", cls2);
        this.t = findRequiredView20;
        findRequiredView20.setOnClickListener(new l(loginActivity));
        Class cls6 = AdManagerAdView.class;
        loginActivity.login_bottom_ads = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.login_bottom_ads, "field 'login_bottom_ads'", cls6);
        loginActivity.forgot_pass_bottom_ads = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.forgot_pass_bottom_ads, "field 'forgot_pass_bottom_ads'", cls6);
        loginActivity.forgot_pass2_bottom_ads = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.forgot_pass2_bottom_ads, "field 'forgot_pass2_bottom_ads'", cls6);
        loginActivity.et_otp = (EditText) Utils.findRequiredViewAsType(view, R.id.et_otp, "field 'et_otp'", cls);
        View findRequiredView21 = Utils.findRequiredView(view, R.id.ll_bus, "field 'll_bus' and method 'onbusClick'");
        loginActivity.ll_bus = (LinearLayout) Utils.castView(findRequiredView21, R.id.ll_bus, "field 'll_bus'", cls4);
        this.u = findRequiredView21;
        findRequiredView21.setOnClickListener(new m(loginActivity));
        View findRequiredView22 = Utils.findRequiredView(view, R.id.rl_hotel, "field 'rl_hotel' and method 'onhotelClick'");
        loginActivity.rl_hotel = (LinearLayout) Utils.castView(findRequiredView22, R.id.rl_hotel, "field 'rl_hotel'", cls4);
        this.v = findRequiredView22;
        findRequiredView22.setOnClickListener(new n(loginActivity));
        View findRequiredView23 = Utils.findRequiredView(view, R.id.with_otp_tv, "field 'with_otp_tv' and method 'onClickWithOtp'");
        loginActivity.with_otp_tv = (TextView) Utils.castView(findRequiredView23, R.id.with_otp_tv, "field 'with_otp_tv'", cls2);
        this.w = findRequiredView23;
        findRequiredView23.setOnClickListener(new o(loginActivity));
        View findRequiredView24 = Utils.findRequiredView(view, R.id.with_password, "field 'with_password' and method 'onClickWithPassword'");
        loginActivity.with_password = (TextView) Utils.castView(findRequiredView24, R.id.with_password, "field 'with_password'", cls2);
        this.x = findRequiredView24;
        findRequiredView24.setOnClickListener(new p(loginActivity));
        loginActivity.sendOtp = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_send_otp, "field 'sendOtp'", cls4);
        View findRequiredView25 = Utils.findRequiredView(view, R.id.send_otp_tv, "field 'send_otp_tv' and method 'onClickSendOtp'");
        loginActivity.send_otp_tv = (TextView) Utils.castView(findRequiredView25, R.id.send_otp_tv, "field 'send_otp_tv'", cls2);
        this.y = findRequiredView25;
        findRequiredView25.setOnClickListener(new q(loginActivity));
        loginActivity.otp_message = (TextView) Utils.findRequiredViewAsType(view, R.id.otp_message, "field 'otp_message'", cls2);
        loginActivity.otpTimmer = (TextView) Utils.findRequiredViewAsType(view, R.id.send_otp_timmer_tv, "field 'otpTimmer'", cls2);
        View findRequiredView26 = Utils.findRequiredView(view, R.id.loginCaptchaRefresh, "method 'loginCaptchaRefresh'");
        this.z = findRequiredView26;
        findRequiredView26.setOnClickListener(new r(loginActivity));
        View findRequiredView27 = Utils.findRequiredView(view, R.id.submit_password, "method 'onSubmitPwd'");
        this.A = findRequiredView27;
        findRequiredView27.setOnClickListener(new s(loginActivity));
        View findRequiredView28 = Utils.findRequiredView(view, R.id.tv_user_guide, "method 'onUserGuideClick'");
        this.B = findRequiredView28;
        findRequiredView28.setOnClickListener(new t(loginActivity));
        View findRequiredView29 = Utils.findRequiredView(view, R.id.rl_irctc_tourism, "method 'onTourismAppClick'");
        this.C = findRequiredView29;
        findRequiredView29.setOnClickListener(new u(loginActivity));
        View findRequiredView30 = Utils.findRequiredView(view, R.id.rl_book_meal, "method 'onCateringAppClick'");
        this.D = findRequiredView30;
        findRequiredView30.setOnClickListener(new w(loginActivity));
        View findRequiredView31 = Utils.findRequiredView(view, R.id.rl_uts_ticket, "method 'onUtsAppClick'");
        this.E = findRequiredView31;
        findRequiredView31.setOnClickListener(new x(loginActivity));
        View findRequiredView32 = Utils.findRequiredView(view, R.id.rl_air_ticket, "method 'onAirAppClick'");
        this.F = findRequiredView32;
        findRequiredView32.setOnClickListener(new y(loginActivity));
        View findRequiredView33 = Utils.findRequiredView(view, R.id.tv_back, "method 'onBackClick'");
        this.G = findRequiredView33;
        findRequiredView33.setOnClickListener(new z(loginActivity));
    }

    public final void unbind() {
        LoginActivity loginActivity = this.f4223a;
        if (loginActivity != null) {
            this.f4223a = null;
            loginActivity.userName = null;
            loginActivity.password = null;
            loginActivity.agent_login = null;
            loginActivity.loginButtonLo = null;
            loginActivity.registerUser = null;
            loginActivity.captchaLayout = null;
            loginActivity.captcha = null;
            loginActivity.loading_Captcha = null;
            loginActivity.captchaInputValue = null;
            loginActivity.etCaptcha = null;
            loginActivity.resendMobTimmer = null;
            loginActivity.refreshCaptcha = null;
            loginActivity.captchaForgotUserId = null;
            loginActivity.loadingCaptcha = null;
            loginActivity.submitForgotId = null;
            loginActivity.submitUserId = null;
            loginActivity.user_dob = null;
            loginActivity.useremail = null;
            loginActivity.calender = null;
            loginActivity.message = null;
            loginActivity.forgotUserId = null;
            loginActivity.bookingWithOtp = null;
            loginActivity.forgot_userdetail = null;
            loginActivity.forgotPasswordOnclick = null;
            loginActivity.forgotUserPwd = null;
            loginActivity.changePwdlayout = null;
            loginActivity.ChangePwdetCaptcha = null;
            loginActivity.ChangePwdrefreshCaptcha = null;
            loginActivity.captchaChangePwd = null;
            loginActivity.loadingCaptchaChangePwd = null;
            loginActivity.userNameShow = null;
            loginActivity.reSendOtp = null;
            loginActivity.newPassword = null;
            loginActivity.confirmPassword = null;
            loginActivity.CnfCaptchaEnter = null;
            loginActivity.CnfPwdrefreshCaptcha = null;
            loginActivity.captchaCnfPwd = null;
            loginActivity.loadingCaptchaCnfPwd = null;
            loginActivity.submitPwd = null;
            loginActivity.otpMsgsShow = null;
            loginActivity.tvPwdShowHide = null;
            loginActivity.tvConfPwdShowHide = null;
            loginActivity.login_bottom_ads = null;
            loginActivity.forgot_pass_bottom_ads = null;
            loginActivity.forgot_pass2_bottom_ads = null;
            loginActivity.et_otp = null;
            loginActivity.ll_bus = null;
            loginActivity.rl_hotel = null;
            loginActivity.with_otp_tv = null;
            loginActivity.with_password = null;
            loginActivity.sendOtp = null;
            loginActivity.send_otp_tv = null;
            loginActivity.otp_message = null;
            loginActivity.otpTimmer = null;
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
            this.g.setOnClickListener((View.OnClickListener) null);
            this.g = null;
            this.h.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.h = null;
            this.i.setOnClickListener((View.OnClickListener) null);
            this.i = null;
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j = null;
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
            this.l.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.l = null;
            this.m.setOnClickListener((View.OnClickListener) null);
            this.m = null;
            this.n.setOnClickListener((View.OnClickListener) null);
            this.n = null;
            this.o.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.o = null;
            this.p.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.p = null;
            this.q.setOnClickListener((View.OnClickListener) null);
            this.q = null;
            this.r.setOnClickListener((View.OnClickListener) null);
            this.r = null;
            this.s.setOnClickListener((View.OnClickListener) null);
            this.s = null;
            this.t.setOnClickListener((View.OnClickListener) null);
            this.t = null;
            this.u.setOnClickListener((View.OnClickListener) null);
            this.u = null;
            this.v.setOnClickListener((View.OnClickListener) null);
            this.v = null;
            this.w.setOnClickListener((View.OnClickListener) null);
            this.w = null;
            this.x.setOnClickListener((View.OnClickListener) null);
            this.x = null;
            this.y.setOnClickListener((View.OnClickListener) null);
            this.y = null;
            this.z.setOnClickListener((View.OnClickListener) null);
            this.z = null;
            this.A.setOnClickListener((View.OnClickListener) null);
            this.A = null;
            this.B.setOnClickListener((View.OnClickListener) null);
            this.B = null;
            this.C.setOnClickListener((View.OnClickListener) null);
            this.C = null;
            this.D.setOnClickListener((View.OnClickListener) null);
            this.D = null;
            this.E.setOnClickListener((View.OnClickListener) null);
            this.E = null;
            this.F.setOnClickListener((View.OnClickListener) null);
            this.F = null;
            this.G.setOnClickListener((View.OnClickListener) null);
            this.G = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
