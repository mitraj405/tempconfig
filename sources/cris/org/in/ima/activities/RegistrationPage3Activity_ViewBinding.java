package cris.org.in.ima.activities;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class RegistrationPage3Activity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public RegistrationPage3Activity f4348a;

    /* renamed from: a  reason: collision with other field name */
    public j f4349a;
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

    public class a implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public a(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_landline_no(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public b(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void doClick(View view) {
            this.a.onRegisterBtnClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public c(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void doClick(View view) {
            this.a.loginCaptchaRefresh();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public d(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void doClick(View view) {
            this.a.onOKClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public e(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void doClick(View view) {
            this.a.onUserGuideClick();
        }
    }

    public class f implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public f(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_address(view);
        }
    }

    public class g implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public g(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_street(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public h(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void doClick(View view) {
            this.a.onCountryClick(view);
        }
    }

    public class i implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public i(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_pincode(view);
        }
    }

    public class k implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public k(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_state_other(view);
        }
    }

    public class l extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public l(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void doClick(View view) {
            this.a.onCityClick(view);
        }
    }

    public class m implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public m(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_other_city(view);
        }
    }

    public class n extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage3Activity a;

        public n(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void doClick(View view) {
            this.a.onPostOfficeClick(view);
        }
    }

    public RegistrationPage3Activity_ViewBinding(RegistrationPage3Activity registrationPage3Activity, View view) {
        this.f4348a = registrationPage3Activity;
        View findRequiredView = Utils.findRequiredView(view, R.id.et_office_address_reg, "field 'address' and method 'et_address'");
        Class cls = EditText.class;
        registrationPage3Activity.address = (EditText) Utils.castView(findRequiredView, R.id.et_office_address_reg, "field 'address'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnFocusChangeListener(new f(registrationPage3Activity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.et_office_street_reg, "field 'street' and method 'et_street'");
        registrationPage3Activity.street = (EditText) Utils.castView(findRequiredView2, R.id.et_office_street_reg, "field 'street'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnFocusChangeListener(new g(registrationPage3Activity));
        registrationPage3Activity.area = (EditText) Utils.findRequiredViewAsType(view, R.id.et_office_area_reg, "field 'area'", cls);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.office_country_reg, "field 'country' and method 'onCountryClick'");
        Class cls2 = TextView.class;
        registrationPage3Activity.country = (TextView) Utils.castView(findRequiredView3, R.id.office_country_reg, "field 'country'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new h(registrationPage3Activity));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.et_office_pincode_reg, "field 'pincode', method 'et_pincode', and method 'onPinCodeTextChanged'");
        registrationPage3Activity.pincode = (EditText) Utils.castView(findRequiredView4, R.id.et_office_pincode_reg, "field 'pincode'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnFocusChangeListener(new i(registrationPage3Activity));
        j jVar = new j(registrationPage3Activity);
        this.f4349a = jVar;
        ((TextView) findRequiredView4).addTextChangedListener(jVar);
        registrationPage3Activity.state = (TextView) Utils.findRequiredViewAsType(view, R.id.et_office_state_reg, "field 'state'", cls2);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.et_office_state_other_reg, "field 'otherState' and method 'et_state_other'");
        registrationPage3Activity.otherState = (EditText) Utils.castView(findRequiredView5, R.id.et_office_state_other_reg, "field 'otherState'", cls);
        this.e = findRequiredView5;
        findRequiredView5.setOnFocusChangeListener(new k(registrationPage3Activity));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.office_city_reg, "field 'city' and method 'onCityClick'");
        registrationPage3Activity.city = (TextView) Utils.castView(findRequiredView6, R.id.office_city_reg, "field 'city'", cls2);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new l(registrationPage3Activity));
        View findRequiredView7 = Utils.findRequiredView(view, R.id.et_office_other_city_reg, "field 'othercity' and method 'et_other_city'");
        registrationPage3Activity.othercity = (EditText) Utils.castView(findRequiredView7, R.id.et_office_other_city_reg, "field 'othercity'", cls);
        this.g = findRequiredView7;
        findRequiredView7.setOnFocusChangeListener(new m(registrationPage3Activity));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.office_post_office_reg, "field 'postoffice' and method 'onPostOfficeClick'");
        registrationPage3Activity.postoffice = (TextView) Utils.castView(findRequiredView8, R.id.office_post_office_reg, "field 'postoffice'", cls2);
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new n(registrationPage3Activity));
        View findRequiredView9 = Utils.findRequiredView(view, R.id.et_office_landline_no_reg, "field 'landline' and method 'et_landline_no'");
        registrationPage3Activity.landline = (EditText) Utils.castView(findRequiredView9, R.id.et_office_landline_no_reg, "field 'landline'", cls);
        this.i = findRequiredView9;
        findRequiredView9.setOnFocusChangeListener(new a(registrationPage3Activity));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.tv_register, "field 'nextBtn' and method 'onRegisterBtnClick'");
        registrationPage3Activity.nextBtn = (TextView) Utils.castView(findRequiredView10, R.id.tv_register, "field 'nextBtn'", cls2);
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new b(registrationPage3Activity));
        Class cls3 = LinearLayout.class;
        registrationPage3Activity.residence = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.residence, "field 'residence'", cls3);
        registrationPage3Activity.residence_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.residence_ll, "field 'residence_ll'", cls3);
        registrationPage3Activity.userStatusverify = (TextView) Utils.findRequiredViewAsType(view, R.id.userStatusverify, "field 'userStatusverify'", cls2);
        Class cls4 = AdManagerAdView.class;
        registrationPage3Activity.mPublisherAdview = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.multiple_ad_sizes_view, "field 'mPublisherAdview'", cls4);
        registrationPage3Activity.captch_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.captch_ll, "field 'captch_ll'", cls3);
        registrationPage3Activity.loading_captcha = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_loading_captcha, "field 'loading_captcha'", cls2);
        Class cls5 = ImageView.class;
        registrationPage3Activity.captcha = (ImageView) Utils.findRequiredViewAsType(view, R.id.captcha, "field 'captcha'", cls5);
        registrationPage3Activity.captchaInputValue = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_captcha_input, "field 'captchaInputValue'", cls);
        View findRequiredView11 = Utils.findRequiredView(view, R.id.loginCaptchaRefresh, "field 'loginCaptchaRefresh' and method 'loginCaptchaRefresh'");
        registrationPage3Activity.loginCaptchaRefresh = (ImageView) Utils.castView(findRequiredView11, R.id.loginCaptchaRefresh, "field 'loginCaptchaRefresh'", cls5);
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new c(registrationPage3Activity));
        registrationPage3Activity.registration_bottom_ads = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.registration_bottom_ads, "field 'registration_bottom_ads'", cls4);
        View findRequiredView12 = Utils.findRequiredView(view, R.id.ok, "method 'onOKClick'");
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new d(registrationPage3Activity));
        View findRequiredView13 = Utils.findRequiredView(view, R.id.tv_user_guide, "method 'onUserGuideClick'");
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new e(registrationPage3Activity));
    }

    public final void unbind() {
        RegistrationPage3Activity registrationPage3Activity = this.f4348a;
        if (registrationPage3Activity != null) {
            this.f4348a = null;
            registrationPage3Activity.address = null;
            registrationPage3Activity.street = null;
            registrationPage3Activity.area = null;
            registrationPage3Activity.country = null;
            registrationPage3Activity.pincode = null;
            registrationPage3Activity.state = null;
            registrationPage3Activity.otherState = null;
            registrationPage3Activity.city = null;
            registrationPage3Activity.othercity = null;
            registrationPage3Activity.postoffice = null;
            registrationPage3Activity.landline = null;
            registrationPage3Activity.nextBtn = null;
            registrationPage3Activity.residence = null;
            registrationPage3Activity.residence_ll = null;
            registrationPage3Activity.userStatusverify = null;
            registrationPage3Activity.mPublisherAdview = null;
            registrationPage3Activity.captch_ll = null;
            registrationPage3Activity.loading_captcha = null;
            registrationPage3Activity.captcha = null;
            registrationPage3Activity.captchaInputValue = null;
            registrationPage3Activity.loginCaptchaRefresh = null;
            registrationPage3Activity.registration_bottom_ads = null;
            this.a.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.a = null;
            this.b.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            this.d.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            ((TextView) this.d).removeTextChangedListener(this.f4349a);
            this.f4349a = null;
            this.d = null;
            this.e.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.e = null;
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
            this.g.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.g = null;
            this.h.setOnClickListener((View.OnClickListener) null);
            this.h = null;
            this.i.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.i = null;
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j = null;
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
            this.l.setOnClickListener((View.OnClickListener) null);
            this.l = null;
            this.m.setOnClickListener((View.OnClickListener) null);
            this.m = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    public class j implements TextWatcher {
        public final /* synthetic */ RegistrationPage3Activity a;

        public j(RegistrationPage3Activity registrationPage3Activity) {
            this.a = registrationPage3Activity;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.onPinCodeTextChanged(charSequence, i, i2, i3);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
