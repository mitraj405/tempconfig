package cris.org.in.ima.activities;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class RegistrationPage2Activity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public RegistrationPage2Activity f4331a;

    /* renamed from: a  reason: collision with other field name */
    public l f4332a;
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

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public a(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void doClick(View view) {
            this.a.onPostOfficeClick(view);
        }
    }

    public class b implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public b(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_landline_no(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public c(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void doClick(View view) {
            this.a.sameOfficeAddress();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public d(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void doClick(View view) {
            this.a.onRegisterBtnClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public e(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void doClick(View view) {
            this.a.loginCaptchaRefresh();
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public f(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void doClick(View view) {
            this.a.onUserGuideClick();
        }
    }

    public class g implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public g(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_address(view);
        }
    }

    public class h implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public h(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_street(view);
        }
    }

    public class i implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public i(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_area(view);
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public j(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void doClick(View view) {
            this.a.onCountryClick(view);
        }
    }

    public class k implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public k(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_pincode(view);
        }
    }

    public class m implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public m(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_state_other(view);
        }
    }

    public class n extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public n(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void doClick(View view) {
            this.a.onCityClick(view);
        }
    }

    public class o implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationPage2Activity a;

        public o(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_other_city(view);
        }
    }

    public RegistrationPage2Activity_ViewBinding(RegistrationPage2Activity registrationPage2Activity, View view) {
        this.f4331a = registrationPage2Activity;
        View findRequiredView = Utils.findRequiredView(view, R.id.et_address_reg, "field 'address' and method 'et_address'");
        Class cls = EditText.class;
        registrationPage2Activity.address = (EditText) Utils.castView(findRequiredView, R.id.et_address_reg, "field 'address'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnFocusChangeListener(new g(registrationPage2Activity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.et_street_reg, "field 'street' and method 'et_street'");
        registrationPage2Activity.street = (EditText) Utils.castView(findRequiredView2, R.id.et_street_reg, "field 'street'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnFocusChangeListener(new h(registrationPage2Activity));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.et_area_reg, "field 'area' and method 'et_area'");
        registrationPage2Activity.area = (EditText) Utils.castView(findRequiredView3, R.id.et_area_reg, "field 'area'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnFocusChangeListener(new i(registrationPage2Activity));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.country_reg, "field 'country' and method 'onCountryClick'");
        Class cls2 = TextView.class;
        registrationPage2Activity.country = (TextView) Utils.castView(findRequiredView4, R.id.country_reg, "field 'country'", cls2);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new j(registrationPage2Activity));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.et_pincode_reg, "field 'pincode', method 'et_pincode', and method 'onPinCodeTextChanged'");
        registrationPage2Activity.pincode = (EditText) Utils.castView(findRequiredView5, R.id.et_pincode_reg, "field 'pincode'", cls);
        this.e = findRequiredView5;
        findRequiredView5.setOnFocusChangeListener(new k(registrationPage2Activity));
        l lVar = new l(registrationPage2Activity);
        this.f4332a = lVar;
        ((TextView) findRequiredView5).addTextChangedListener(lVar);
        registrationPage2Activity.state = (TextView) Utils.findRequiredViewAsType(view, R.id.et_state_reg, "field 'state'", cls2);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.et_state_other_reg, "field 'otherState' and method 'et_state_other'");
        registrationPage2Activity.otherState = (EditText) Utils.castView(findRequiredView6, R.id.et_state_other_reg, "field 'otherState'", cls);
        this.f = findRequiredView6;
        findRequiredView6.setOnFocusChangeListener(new m(registrationPage2Activity));
        View findRequiredView7 = Utils.findRequiredView(view, R.id.city_reg, "field 'city' and method 'onCityClick'");
        registrationPage2Activity.city = (TextView) Utils.castView(findRequiredView7, R.id.city_reg, "field 'city'", cls2);
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new n(registrationPage2Activity));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.et_other_city_reg, "field 'othercity' and method 'et_other_city'");
        registrationPage2Activity.othercity = (EditText) Utils.castView(findRequiredView8, R.id.et_other_city_reg, "field 'othercity'", cls);
        this.h = findRequiredView8;
        findRequiredView8.setOnFocusChangeListener(new o(registrationPage2Activity));
        View findRequiredView9 = Utils.findRequiredView(view, R.id.post_office_reg, "field 'postoffice' and method 'onPostOfficeClick'");
        registrationPage2Activity.postoffice = (TextView) Utils.castView(findRequiredView9, R.id.post_office_reg, "field 'postoffice'", cls2);
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new a(registrationPage2Activity));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.et_landline_no_reg, "field 'landline' and method 'et_landline_no'");
        registrationPage2Activity.landline = (EditText) Utils.castView(findRequiredView10, R.id.et_landline_no_reg, "field 'landline'", cls);
        this.j = findRequiredView10;
        findRequiredView10.setOnFocusChangeListener(new b(registrationPage2Activity));
        View findRequiredView11 = Utils.findRequiredView(view, R.id.cb_same_office, "field 'sameoffice' and method 'sameOfficeAddress'");
        registrationPage2Activity.sameoffice = (CheckBox) Utils.castView(findRequiredView11, R.id.cb_same_office, "field 'sameoffice'", CheckBox.class);
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new c(registrationPage2Activity));
        View findRequiredView12 = Utils.findRequiredView(view, R.id.tv_next_2, "field 'nextBtn' and method 'onRegisterBtnClick'");
        registrationPage2Activity.nextBtn = (TextView) Utils.castView(findRequiredView12, R.id.tv_next_2, "field 'nextBtn'", cls2);
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new d(registrationPage2Activity));
        registrationPage2Activity.captch_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.captch_ll, "field 'captch_ll'", LinearLayout.class);
        registrationPage2Activity.loading_captcha = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_loading_captcha, "field 'loading_captcha'", cls2);
        Class cls3 = ImageView.class;
        registrationPage2Activity.captcha = (ImageView) Utils.findRequiredViewAsType(view, R.id.captcha, "field 'captcha'", cls3);
        registrationPage2Activity.captchaInputValue = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_captcha_input, "field 'captchaInputValue'", cls);
        View findRequiredView13 = Utils.findRequiredView(view, R.id.loginCaptchaRefresh, "field 'loginCaptchaRefresh' and method 'loginCaptchaRefresh'");
        registrationPage2Activity.loginCaptchaRefresh = (ImageView) Utils.castView(findRequiredView13, R.id.loginCaptchaRefresh, "field 'loginCaptchaRefresh'", cls3);
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new e(registrationPage2Activity));
        registrationPage2Activity.registration_bottom_ads = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.registration_bottom_ads, "field 'registration_bottom_ads'", AdManagerAdView.class);
        View findRequiredView14 = Utils.findRequiredView(view, R.id.tv_user_guide, "method 'onUserGuideClick'");
        this.n = findRequiredView14;
        findRequiredView14.setOnClickListener(new f(registrationPage2Activity));
    }

    public final void unbind() {
        RegistrationPage2Activity registrationPage2Activity = this.f4331a;
        if (registrationPage2Activity != null) {
            this.f4331a = null;
            registrationPage2Activity.address = null;
            registrationPage2Activity.street = null;
            registrationPage2Activity.area = null;
            registrationPage2Activity.country = null;
            registrationPage2Activity.pincode = null;
            registrationPage2Activity.state = null;
            registrationPage2Activity.otherState = null;
            registrationPage2Activity.city = null;
            registrationPage2Activity.othercity = null;
            registrationPage2Activity.postoffice = null;
            registrationPage2Activity.landline = null;
            registrationPage2Activity.sameoffice = null;
            registrationPage2Activity.nextBtn = null;
            registrationPage2Activity.captch_ll = null;
            registrationPage2Activity.loading_captcha = null;
            registrationPage2Activity.captcha = null;
            registrationPage2Activity.captchaInputValue = null;
            registrationPage2Activity.loginCaptchaRefresh = null;
            registrationPage2Activity.registration_bottom_ads = null;
            this.a.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.a = null;
            this.b.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.b = null;
            this.c.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            this.e.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            ((TextView) this.e).removeTextChangedListener(this.f4332a);
            this.f4332a = null;
            this.e = null;
            this.f.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.f = null;
            this.g.setOnClickListener((View.OnClickListener) null);
            this.g = null;
            this.h.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.h = null;
            this.i.setOnClickListener((View.OnClickListener) null);
            this.i = null;
            this.j.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.j = null;
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
            this.l.setOnClickListener((View.OnClickListener) null);
            this.l = null;
            this.m.setOnClickListener((View.OnClickListener) null);
            this.m = null;
            this.n.setOnClickListener((View.OnClickListener) null);
            this.n = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    public class l implements TextWatcher {
        public final /* synthetic */ RegistrationPage2Activity a;

        public l(RegistrationPage2Activity registrationPage2Activity) {
            this.a = registrationPage2Activity;
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
