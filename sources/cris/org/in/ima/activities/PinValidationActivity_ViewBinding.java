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

public class PinValidationActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public PinValidationActivity f4297a;
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

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public a(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onUserGuideClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public b(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onBackClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public c(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onAirAppClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public d(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onCateringAppClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public e(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onTourismAppClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public f(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onUtsAppClick(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public g(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onAgentLoginClick(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public h(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onCheckOtpBookingClick();
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public i(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onbusClick(view);
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public j(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onhotelAppClick(view);
        }
    }

    public class k extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public k(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.fingerprintIconOnCLick();
        }
    }

    public class l extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public l(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onClickPin(view);
        }
    }

    public class m extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public m(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onClickOtp(view);
        }
    }

    public class n extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public n(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.onClickSendOtp(view);
        }
    }

    public class o extends DebouncingOnClickListener {
        public final /* synthetic */ PinValidationActivity a;

        public o(PinValidationActivity pinValidationActivity) {
            this.a = pinValidationActivity;
        }

        public final void doClick(View view) {
            this.a.loginCaptchaRefresh();
        }
    }

    public PinValidationActivity_ViewBinding(PinValidationActivity pinValidationActivity, View view) {
        this.f4297a = pinValidationActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.agent_login, "field 'agent_login' and method 'onAgentLoginClick'");
        Class cls = TextView.class;
        pinValidationActivity.agent_login = (TextView) Utils.castView(findRequiredView, R.id.agent_login, "field 'agent_login'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new g(pinValidationActivity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.cb_check_otp_booking, "field 'bkgWithOTP' and method 'onCheckOtpBookingClick'");
        pinValidationActivity.bkgWithOTP = (CheckBox) Utils.castView(findRequiredView2, R.id.cb_check_otp_booking, "field 'bkgWithOTP'", CheckBox.class);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new h(pinValidationActivity));
        pinValidationActivity.search = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_pin_login, "field 'search'", RelativeLayout.class);
        Class cls2 = LinearLayout.class;
        pinValidationActivity.captchaLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.captch_ll, "field 'captchaLayout'", cls2);
        pinValidationActivity.otp_message = (TextView) Utils.findRequiredViewAsType(view, R.id.otp_message, "field 'otp_message'", cls);
        pinValidationActivity.captcha = (ImageView) Utils.findRequiredViewAsType(view, R.id.captcha, "field 'captcha'", ImageView.class);
        pinValidationActivity.loading_Captcha = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_loading_captcha, "field 'loading_Captcha'", cls);
        pinValidationActivity.captchaInputValue = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_captcha_input, "field 'captchaInputValue'", EditText.class);
        pinValidationActivity.pinvalidation_bottom_ads = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.pinvalidation_bottom_ads, "field 'pinvalidation_bottom_ads'", AdManagerAdView.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.ll_bus, "field 'll_bus' and method 'onbusClick'");
        pinValidationActivity.ll_bus = (LinearLayout) Utils.castView(findRequiredView3, R.id.ll_bus, "field 'll_bus'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new i(pinValidationActivity));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.rl_hotel, "field 'rl_hotel' and method 'onhotelAppClick'");
        pinValidationActivity.rl_hotel = (LinearLayout) Utils.castView(findRequiredView4, R.id.rl_hotel, "field 'rl_hotel'", cls2);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new j(pinValidationActivity));
        pinValidationActivity.fingerPrintMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fingerprint_msg, "field 'fingerPrintMsg'", cls);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.ll_fingerprint_icon, "field 'fingerprintIcon' and method 'fingerprintIconOnCLick'");
        pinValidationActivity.fingerprintIcon = (LinearLayout) Utils.castView(findRequiredView5, R.id.ll_fingerprint_icon, "field 'fingerprintIcon'", cls2);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new k(pinValidationActivity));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.with_pin_tv, "field 'with_pin_tv' and method 'onClickPin'");
        pinValidationActivity.with_pin_tv = (TextView) Utils.castView(findRequiredView6, R.id.with_pin_tv, "field 'with_pin_tv'", cls);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new l(pinValidationActivity));
        View findRequiredView7 = Utils.findRequiredView(view, R.id.with_otp_tv, "field 'with_otp_tv' and method 'onClickOtp'");
        pinValidationActivity.with_otp_tv = (TextView) Utils.castView(findRequiredView7, R.id.with_otp_tv, "field 'with_otp_tv'", cls);
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new m(pinValidationActivity));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.send_otp_tv, "field 'sendOtpTv' and method 'onClickSendOtp'");
        pinValidationActivity.sendOtpTv = (TextView) Utils.castView(findRequiredView8, R.id.send_otp_tv, "field 'sendOtpTv'", cls);
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new n(pinValidationActivity));
        pinValidationActivity.sendOtp = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_send_otp, "field 'sendOtp'", cls2);
        pinValidationActivity.otpTimmer = (TextView) Utils.findRequiredViewAsType(view, R.id.send_otp_timmer_tv, "field 'otpTimmer'", cls);
        pinValidationActivity.otp_send_msg = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.otp_send_msg, "field 'otp_send_msg'", cls2);
        View findRequiredView9 = Utils.findRequiredView(view, R.id.loginCaptchaRefresh, "method 'loginCaptchaRefresh'");
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new o(pinValidationActivity));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.tv_user_guide, "method 'onUserGuideClick'");
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new a(pinValidationActivity));
        View findRequiredView11 = Utils.findRequiredView(view, R.id.tv_back, "method 'onBackClick'");
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new b(pinValidationActivity));
        View findRequiredView12 = Utils.findRequiredView(view, R.id.rl_air_ticket, "method 'onAirAppClick'");
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new c(pinValidationActivity));
        View findRequiredView13 = Utils.findRequiredView(view, R.id.rl_book_meal, "method 'onCateringAppClick'");
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new d(pinValidationActivity));
        View findRequiredView14 = Utils.findRequiredView(view, R.id.rl_irctc_tourism, "method 'onTourismAppClick'");
        this.n = findRequiredView14;
        findRequiredView14.setOnClickListener(new e(pinValidationActivity));
        View findRequiredView15 = Utils.findRequiredView(view, R.id.rl_uts_ticket, "method 'onUtsAppClick'");
        this.o = findRequiredView15;
        findRequiredView15.setOnClickListener(new f(pinValidationActivity));
    }

    public final void unbind() {
        PinValidationActivity pinValidationActivity = this.f4297a;
        if (pinValidationActivity != null) {
            this.f4297a = null;
            pinValidationActivity.agent_login = null;
            pinValidationActivity.bkgWithOTP = null;
            pinValidationActivity.search = null;
            pinValidationActivity.captchaLayout = null;
            pinValidationActivity.otp_message = null;
            pinValidationActivity.captcha = null;
            pinValidationActivity.loading_Captcha = null;
            pinValidationActivity.captchaInputValue = null;
            pinValidationActivity.pinvalidation_bottom_ads = null;
            pinValidationActivity.ll_bus = null;
            pinValidationActivity.rl_hotel = null;
            pinValidationActivity.fingerPrintMsg = null;
            pinValidationActivity.fingerprintIcon = null;
            pinValidationActivity.with_pin_tv = null;
            pinValidationActivity.with_otp_tv = null;
            pinValidationActivity.sendOtpTv = null;
            pinValidationActivity.sendOtp = null;
            pinValidationActivity.otpTimmer = null;
            pinValidationActivity.otp_send_msg = null;
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
            this.h.setOnClickListener((View.OnClickListener) null);
            this.h = null;
            this.i.setOnClickListener((View.OnClickListener) null);
            this.i = null;
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j = null;
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
            this.l.setOnClickListener((View.OnClickListener) null);
            this.l = null;
            this.m.setOnClickListener((View.OnClickListener) null);
            this.m = null;
            this.n.setOnClickListener((View.OnClickListener) null);
            this.n = null;
            this.o.setOnClickListener((View.OnClickListener) null);
            this.o = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
