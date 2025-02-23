package cris.org.in.ima.activities;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class RegistrationActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public RegistrationActivity f4317a;
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

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public a(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.onMaleBtnClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public b(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.onFemaleBtnClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public c(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.onTransgender(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public d(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.onSecretQuestionClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public e(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.onOccupationClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public f(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.onMaritalStatusClick(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public g(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.doNext();
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public h(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.onNationalityClick(view);
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public i(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.pwdShowHide();
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public j(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.confPwdShowHide();
        }
    }

    public class k implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationActivity a;

        public k(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.validateMobile(view);
        }
    }

    public class l extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public l(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            RegistrationActivity registrationActivity = this.a;
            registrationActivity.onUserGuideClick(view);
            registrationActivity.onUserGuideClick();
        }
    }

    public class m extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public m(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.onDobClick();
        }
    }

    public class n implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationActivity a;

        public n(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.validateEmail(view);
        }
    }

    public class o implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationActivity a;

        public o(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.searchUser(view);
        }
    }

    public class p extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public p(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.passwordval(view);
        }
    }

    public class q extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public q(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.cnfPasswordval(view);
        }
    }

    public class r implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationActivity a;

        public r(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.fnameval(view);
        }
    }

    public class s implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationActivity a;

        public s(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.mnameval(view);
        }
    }

    public class t implements View.OnFocusChangeListener {
        public final /* synthetic */ RegistrationActivity a;

        public t(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.lnameval(view);
        }
    }

    public class u extends DebouncingOnClickListener {
        public final /* synthetic */ RegistrationActivity a;

        public u(RegistrationActivity registrationActivity) {
            this.a = registrationActivity;
        }

        public final void doClick(View view) {
            this.a.dobClick(view);
        }
    }

    public RegistrationActivity_ViewBinding(RegistrationActivity registrationActivity, View view) {
        this.f4317a = registrationActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.et_mobile_no, "field 'mobile' and method 'validateMobile'");
        Class cls = EditText.class;
        registrationActivity.mobile = (EditText) Utils.castView(findRequiredView, R.id.et_mobile_no, "field 'mobile'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnFocusChangeListener(new k(registrationActivity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.et_email, "field 'email' and method 'validateEmail'");
        registrationActivity.email = (EditText) Utils.castView(findRequiredView2, R.id.et_email, "field 'email'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnFocusChangeListener(new n(registrationActivity));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.et_user_name, "field 'userName' and method 'searchUser'");
        registrationActivity.userName = (EditText) Utils.castView(findRequiredView3, R.id.et_user_name, "field 'userName'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnFocusChangeListener(new o(registrationActivity));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.et_password, "field 'password' and method 'passwordval'");
        registrationActivity.password = (EditText) Utils.castView(findRequiredView4, R.id.et_password, "field 'password'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new p(registrationActivity));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.et_confirm_password, "field 'confirmpassword' and method 'cnfPasswordval'");
        registrationActivity.confirmpassword = (EditText) Utils.castView(findRequiredView5, R.id.et_confirm_password, "field 'confirmpassword'", cls);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new q(registrationActivity));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.et_first_name, "field 'fname' and method 'fnameval'");
        registrationActivity.fname = (EditText) Utils.castView(findRequiredView6, R.id.et_first_name, "field 'fname'", cls);
        this.f = findRequiredView6;
        findRequiredView6.setOnFocusChangeListener(new r(registrationActivity));
        View findRequiredView7 = Utils.findRequiredView(view, R.id.et_middle_name, "field 'mname' and method 'mnameval'");
        registrationActivity.mname = (EditText) Utils.castView(findRequiredView7, R.id.et_middle_name, "field 'mname'", cls);
        this.g = findRequiredView7;
        findRequiredView7.setOnFocusChangeListener(new s(registrationActivity));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.et_last_name, "field 'lname' and method 'lnameval'");
        registrationActivity.lname = (EditText) Utils.castView(findRequiredView8, R.id.et_last_name, "field 'lname'", cls);
        this.h = findRequiredView8;
        findRequiredView8.setOnFocusChangeListener(new t(registrationActivity));
        View findRequiredView9 = Utils.findRequiredView(view, R.id.et_dob, "field 'dob' and method 'dobClick'");
        Class cls2 = TextView.class;
        registrationActivity.dob = (TextView) Utils.castView(findRequiredView9, R.id.et_dob, "field 'dob'", cls2);
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new u(registrationActivity));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.tv_male, "field 'male' and method 'onMaleBtnClick'");
        Class cls3 = RadioButton.class;
        registrationActivity.male = (RadioButton) Utils.castView(findRequiredView10, R.id.tv_male, "field 'male'", cls3);
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new a(registrationActivity));
        View findRequiredView11 = Utils.findRequiredView(view, R.id.tv_female, "field 'female' and method 'onFemaleBtnClick'");
        registrationActivity.female = (RadioButton) Utils.castView(findRequiredView11, R.id.tv_female, "field 'female'", cls3);
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new b(registrationActivity));
        View findRequiredView12 = Utils.findRequiredView(view, R.id.tv_transgender, "field 'transGender' and method 'onTransgender'");
        registrationActivity.transGender = (RadioButton) Utils.castView(findRequiredView12, R.id.tv_transgender, "field 'transGender'", cls3);
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new c(registrationActivity));
        View findRequiredView13 = Utils.findRequiredView(view, R.id.secret_question, "field 'secQuestion' and method 'onSecretQuestionClick'");
        registrationActivity.secQuestion = (TextView) Utils.castView(findRequiredView13, R.id.secret_question, "field 'secQuestion'", cls2);
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new d(registrationActivity));
        registrationActivity.secAnswer = (EditText) Utils.findRequiredViewAsType(view, R.id.et_security_answer, "field 'secAnswer'", cls);
        View findRequiredView14 = Utils.findRequiredView(view, R.id.occupation, "field 'occupation' and method 'onOccupationClick'");
        registrationActivity.occupation = (TextView) Utils.castView(findRequiredView14, R.id.occupation, "field 'occupation'", cls2);
        this.n = findRequiredView14;
        findRequiredView14.setOnClickListener(new e(registrationActivity));
        View findRequiredView15 = Utils.findRequiredView(view, R.id.marital_status, "field 'maritalStatus' and method 'onMaritalStatusClick'");
        registrationActivity.maritalStatus = (TextView) Utils.castView(findRequiredView15, R.id.marital_status, "field 'maritalStatus'", cls2);
        this.o = findRequiredView15;
        findRequiredView15.setOnClickListener(new f(registrationActivity));
        View findRequiredView16 = Utils.findRequiredView(view, R.id.tv_next, "field 'next' and method 'doNext'");
        registrationActivity.next = (TextView) Utils.castView(findRequiredView16, R.id.tv_next, "field 'next'", cls2);
        this.p = findRequiredView16;
        findRequiredView16.setOnClickListener(new g(registrationActivity));
        View findRequiredView17 = Utils.findRequiredView(view, R.id.nationality, "field 'nationality' and method 'onNationalityClick'");
        registrationActivity.nationality = (TextView) Utils.castView(findRequiredView17, R.id.nationality, "field 'nationality'", cls2);
        this.q = findRequiredView17;
        findRequiredView17.setOnClickListener(new h(registrationActivity));
        View findRequiredView18 = Utils.findRequiredView(view, R.id.tv_pwd_show_hide, "field 'tvPwdShowHide' and method 'pwdShowHide'");
        registrationActivity.tvPwdShowHide = (TextView) Utils.castView(findRequiredView18, R.id.tv_pwd_show_hide, "field 'tvPwdShowHide'", cls2);
        this.r = findRequiredView18;
        findRequiredView18.setOnClickListener(new i(registrationActivity));
        View findRequiredView19 = Utils.findRequiredView(view, R.id.tv_conf_pwd_show_hide, "field 'tvConfPwdShowHide' and method 'confPwdShowHide'");
        registrationActivity.tvConfPwdShowHide = (TextView) Utils.castView(findRequiredView19, R.id.tv_conf_pwd_show_hide, "field 'tvConfPwdShowHide'", cls2);
        this.s = findRequiredView19;
        findRequiredView19.setOnClickListener(new j(registrationActivity));
        registrationActivity.registration_bottom_ads = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.registration_bottom_ads, "field 'registration_bottom_ads'", AdManagerAdView.class);
        View findRequiredView20 = Utils.findRequiredView(view, R.id.tv_user_guide, "method 'onUserGuideClick' and method 'onUserGuideClick'");
        this.t = findRequiredView20;
        findRequiredView20.setOnClickListener(new l(registrationActivity));
        View findRequiredView21 = Utils.findRequiredView(view, R.id.dob_clender, "method 'onDobClick'");
        this.u = findRequiredView21;
        findRequiredView21.setOnClickListener(new m(registrationActivity));
    }

    public final void unbind() {
        RegistrationActivity registrationActivity = this.f4317a;
        if (registrationActivity != null) {
            this.f4317a = null;
            registrationActivity.mobile = null;
            registrationActivity.email = null;
            registrationActivity.userName = null;
            registrationActivity.password = null;
            registrationActivity.confirmpassword = null;
            registrationActivity.fname = null;
            registrationActivity.mname = null;
            registrationActivity.lname = null;
            registrationActivity.dob = null;
            registrationActivity.male = null;
            registrationActivity.female = null;
            registrationActivity.transGender = null;
            registrationActivity.secQuestion = null;
            registrationActivity.secAnswer = null;
            registrationActivity.occupation = null;
            registrationActivity.maritalStatus = null;
            registrationActivity.next = null;
            registrationActivity.nationality = null;
            registrationActivity.tvPwdShowHide = null;
            registrationActivity.tvConfPwdShowHide = null;
            registrationActivity.registration_bottom_ads = null;
            this.a.setOnFocusChangeListener((View.OnFocusChangeListener) null);
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
            this.g.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.g = null;
            this.h.setOnFocusChangeListener((View.OnFocusChangeListener) null);
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
            this.p.setOnClickListener((View.OnClickListener) null);
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
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
