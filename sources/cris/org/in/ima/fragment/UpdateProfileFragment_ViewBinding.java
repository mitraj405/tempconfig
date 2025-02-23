package cris.org.in.ima.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class UpdateProfileFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public UpdateProfileFragment f5196a;

    /* renamed from: a  reason: collision with other field name */
    public b f5197a;
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

    public class a implements View.OnFocusChangeListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public a(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_pincode(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public c(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.onUpdateProfileClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public d(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.onMaleBtnClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public e(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.onFemaleBtnClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public f(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.onTransgender(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public g(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.onPostOfficeClick(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public h(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.generateOtp(view);
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public i(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.onCancelClick();
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public j(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.confirmOtp(view);
        }
    }

    public class k extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public k(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.onDobClick();
        }
    }

    public class l implements View.OnFocusChangeListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public l(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.checkEmail(view);
        }
    }

    public class m implements View.OnFocusChangeListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public m(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.checkMobile(view);
        }
    }

    public class n extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public n(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.validateMobile(view);
        }
    }

    public class o extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public o(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.validateEmail(view);
        }
    }

    public class p implements View.OnFocusChangeListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public p(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_address(view);
        }
    }

    public class q extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public q(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.onGenderClick();
        }
    }

    public class r implements View.OnFocusChangeListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public r(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_area(view);
        }
    }

    public class s extends DebouncingOnClickListener {
        public final /* synthetic */ UpdateProfileFragment a;

        public s(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
        }

        public final void doClick(View view) {
            this.a.onCityClick(view);
        }
    }

    public UpdateProfileFragment_ViewBinding(UpdateProfileFragment updateProfileFragment, View view) {
        this.f5196a = updateProfileFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.et_dob, "field 'dob' and method 'onDobClick'");
        Class cls = TextView.class;
        updateProfileFragment.dob = (TextView) Utils.castView(findRequiredView, R.id.et_dob, "field 'dob'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new k(updateProfileFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.bt_edit_email, "field 'email' and method 'checkEmail'");
        Class cls2 = EditText.class;
        updateProfileFragment.email = (EditText) Utils.castView(findRequiredView2, R.id.bt_edit_email, "field 'email'", cls2);
        this.b = findRequiredView2;
        findRequiredView2.setOnFocusChangeListener(new l(updateProfileFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.bt_edit_mobile, "field 'mobile' and method 'checkMobile'");
        updateProfileFragment.mobile = (EditText) Utils.castView(findRequiredView3, R.id.bt_edit_mobile, "field 'mobile'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnFocusChangeListener(new m(updateProfileFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.bt_update_mobile, "field 'updateMobile' and method 'validateMobile'");
        updateProfileFragment.updateMobile = (TextView) Utils.castView(findRequiredView4, R.id.bt_update_mobile, "field 'updateMobile'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new n(updateProfileFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.bt_update_email, "field 'updateEmail' and method 'validateEmail'");
        updateProfileFragment.updateEmail = (TextView) Utils.castView(findRequiredView5, R.id.bt_update_email, "field 'updateEmail'", cls);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new o(updateProfileFragment));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.tv_address, "field 'address' and method 'et_address'");
        updateProfileFragment.address = (EditText) Utils.castView(findRequiredView6, R.id.tv_address, "field 'address'", cls2);
        this.f = findRequiredView6;
        findRequiredView6.setOnFocusChangeListener(new p(updateProfileFragment));
        updateProfileFragment.userName = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_username, "field 'userName'", cls2);
        updateProfileFragment.userInput = (EditText) Utils.findRequiredViewAsType(view, R.id.et_input, "field 'userInput'", cls2);
        updateProfileFragment.fullName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_full_name, "field 'fullName'", cls2);
        View findRequiredView7 = Utils.findRequiredView(view, R.id.tv_gender, "field 'gender_tv' and method 'onGenderClick'");
        updateProfileFragment.gender_tv = (TextView) Utils.castView(findRequiredView7, R.id.tv_gender, "field 'gender_tv'", cls);
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new q(updateProfileFragment));
        updateProfileFragment.gender_radiobtn = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.ll_gender, "field 'gender_radiobtn'", RadioGroup.class);
        View findRequiredView8 = Utils.findRequiredView(view, R.id.et_address2, "field 'address2' and method 'et_area'");
        updateProfileFragment.address2 = (EditText) Utils.castView(findRequiredView8, R.id.et_address2, "field 'address2'", cls2);
        this.h = findRequiredView8;
        findRequiredView8.setOnFocusChangeListener(new r(updateProfileFragment));
        Class cls3 = CheckBox.class;
        updateProfileFragment.promotionalChkbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.promotional_chkbox, "field 'promotionalChkbox'", cls3);
        updateProfileFragment.tandcChkbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.tandc_chkbox, "field 'tandcChkbox'", cls3);
        View findRequiredView9 = Utils.findRequiredView(view, R.id.city_reg, "field 'city' and method 'onCityClick'");
        updateProfileFragment.city = (TextView) Utils.castView(findRequiredView9, R.id.city_reg, "field 'city'", cls);
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new s(updateProfileFragment));
        updateProfileFragment.tandcTv = (TextView) Utils.findRequiredViewAsType(view, R.id.tandc_tv, "field 'tandcTv'", cls);
        updateProfileFragment.resendMobTimmer = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_resend_mob_timmer, "field 'resendMobTimmer'", cls);
        View findRequiredView10 = Utils.findRequiredView(view, R.id.et_pincode_reg, "field 'pincode', method 'et_pincode', and method 'onPinCodeTextChanged'");
        updateProfileFragment.pincode = (EditText) Utils.castView(findRequiredView10, R.id.et_pincode_reg, "field 'pincode'", cls2);
        this.j = findRequiredView10;
        findRequiredView10.setOnFocusChangeListener(new a(updateProfileFragment));
        b bVar = new b(updateProfileFragment);
        this.f5197a = bVar;
        ((TextView) findRequiredView10).addTextChangedListener(bVar);
        updateProfileFragment.state = (TextView) Utils.findRequiredViewAsType(view, R.id.et_state_reg, "field 'state'", cls);
        updateProfileFragment.otpInputLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.input_label, "field 'otpInputLabel'", cls);
        View findRequiredView11 = Utils.findRequiredView(view, R.id.update_profile, "field 'updateProfileBtn' and method 'onUpdateProfileClick'");
        updateProfileFragment.updateProfileBtn = (TextView) Utils.castView(findRequiredView11, R.id.update_profile, "field 'updateProfileBtn'", cls);
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new c(updateProfileFragment));
        updateProfileFragment.isd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_isd, "field 'isd'", cls);
        updateProfileFragment.editEmailMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_edit_email_msg, "field 'editEmailMsg'", cls);
        updateProfileFragment.editMobileMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_edit_mobile_msg, "field 'editMobileMsg'", cls);
        View findRequiredView12 = Utils.findRequiredView(view, R.id.tv_male, "field 'male' and method 'onMaleBtnClick'");
        Class cls4 = RadioButton.class;
        updateProfileFragment.male = (RadioButton) Utils.castView(findRequiredView12, R.id.tv_male, "field 'male'", cls4);
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new d(updateProfileFragment));
        View findRequiredView13 = Utils.findRequiredView(view, R.id.tv_female, "field 'female' and method 'onFemaleBtnClick'");
        updateProfileFragment.female = (RadioButton) Utils.castView(findRequiredView13, R.id.tv_female, "field 'female'", cls4);
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new e(updateProfileFragment));
        View findRequiredView14 = Utils.findRequiredView(view, R.id.tv_transgender, "field 'transGender' and method 'onTransgender'");
        updateProfileFragment.transGender = (RadioButton) Utils.castView(findRequiredView14, R.id.tv_transgender, "field 'transGender'", cls4);
        this.n = findRequiredView14;
        findRequiredView14.setOnClickListener(new f(updateProfileFragment));
        View findRequiredView15 = Utils.findRequiredView(view, R.id.post_office_reg, "field 'postoffice' and method 'onPostOfficeClick'");
        updateProfileFragment.postoffice = (TextView) Utils.castView(findRequiredView15, R.id.post_office_reg, "field 'postoffice'", cls);
        this.o = findRequiredView15;
        findRequiredView15.setOnClickListener(new g(updateProfileFragment));
        View findRequiredView16 = Utils.findRequiredView(view, R.id.generate_otp, "field 'generateOtp' and method 'generateOtp'");
        updateProfileFragment.generateOtp = (TextView) Utils.castView(findRequiredView16, R.id.generate_otp, "field 'generateOtp'", cls);
        this.p = findRequiredView16;
        findRequiredView16.setOnClickListener(new h(updateProfileFragment));
        updateProfileFragment.otpLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.otpLayout, "field 'otpLayout'", RelativeLayout.class);
        updateProfileFragment.parentLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.parentLayout, "field 'parentLayout'", FrameLayout.class);
        View findRequiredView17 = Utils.findRequiredView(view, R.id.cancel_otp, "method 'onCancelClick'");
        this.q = findRequiredView17;
        findRequiredView17.setOnClickListener(new i(updateProfileFragment));
        View findRequiredView18 = Utils.findRequiredView(view, R.id.confirm_otp, "method 'confirmOtp'");
        this.r = findRequiredView18;
        findRequiredView18.setOnClickListener(new j(updateProfileFragment));
    }

    public final void unbind() {
        UpdateProfileFragment updateProfileFragment = this.f5196a;
        if (updateProfileFragment != null) {
            this.f5196a = null;
            updateProfileFragment.dob = null;
            updateProfileFragment.email = null;
            updateProfileFragment.mobile = null;
            updateProfileFragment.updateMobile = null;
            updateProfileFragment.updateEmail = null;
            updateProfileFragment.address = null;
            updateProfileFragment.userName = null;
            updateProfileFragment.userInput = null;
            updateProfileFragment.fullName = null;
            updateProfileFragment.gender_tv = null;
            updateProfileFragment.gender_radiobtn = null;
            updateProfileFragment.address2 = null;
            updateProfileFragment.promotionalChkbox = null;
            updateProfileFragment.tandcChkbox = null;
            updateProfileFragment.city = null;
            updateProfileFragment.tandcTv = null;
            updateProfileFragment.resendMobTimmer = null;
            updateProfileFragment.pincode = null;
            updateProfileFragment.state = null;
            updateProfileFragment.otpInputLabel = null;
            updateProfileFragment.updateProfileBtn = null;
            updateProfileFragment.isd = null;
            updateProfileFragment.editEmailMsg = null;
            updateProfileFragment.editMobileMsg = null;
            updateProfileFragment.male = null;
            updateProfileFragment.female = null;
            updateProfileFragment.transGender = null;
            updateProfileFragment.postoffice = null;
            updateProfileFragment.generateOtp = null;
            updateProfileFragment.otpLayout = null;
            updateProfileFragment.parentLayout = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.b = null;
            this.c.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            this.e.setOnClickListener((View.OnClickListener) null);
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
            ((TextView) this.j).removeTextChangedListener(this.f5197a);
            this.f5197a = null;
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
            this.p.setOnClickListener((View.OnClickListener) null);
            this.p = null;
            this.q.setOnClickListener((View.OnClickListener) null);
            this.q = null;
            this.r.setOnClickListener((View.OnClickListener) null);
            this.r = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    public class b implements TextWatcher {
        public final /* synthetic */ UpdateProfileFragment a;

        public b(UpdateProfileFragment updateProfileFragment) {
            this.a = updateProfileFragment;
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
