package cris.org.in.ima.activities;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class MasterPassengerNewActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public MasterPassengerNewActivity f4262a;
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

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public a(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.dobCalender();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public b(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onNormalPassClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public c(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onDivyaangClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public d(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onJournalistClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public e(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onNationalityClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public f(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onSpecialConcession(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public g(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onMaleLableClick(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public h(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onFemaleLableClick(view);
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public i(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onTransgenderLableClick(view);
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public j(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onClickOutSide();
        }
    }

    public class k extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public k(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onMaleBtnClick(view);
        }
    }

    public class l extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public l(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onFemaleBtnClick(view);
        }
    }

    public class m extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public m(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onTransgenderBtnClick(view);
        }
    }

    public class n extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public n(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onBerthPreferenceClick(view);
        }
    }

    public class o extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public o(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onFoodChoiceClick(view);
        }
    }

    public class p extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public p(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onIdCardClick(view);
        }
    }

    public class q implements View.OnFocusChangeListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public q(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.idCardValidate(view);
        }
    }

    public class r extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public r(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onSeniorCtznConcessionClick(view);
        }
    }

    public class s extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerNewActivity a;

        public s(MasterPassengerNewActivity masterPassengerNewActivity) {
            this.a = masterPassengerNewActivity;
        }

        public final void doClick(View view) {
            this.a.onDoneClick();
        }
    }

    public MasterPassengerNewActivity_ViewBinding(MasterPassengerNewActivity masterPassengerNewActivity, View view) {
        this.f4262a = masterPassengerNewActivity;
        Class cls = TextView.class;
        masterPassengerNewActivity.titleName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_heading, "field 'titleName'", cls);
        masterPassengerNewActivity.delete = (TextView) Utils.findRequiredViewAsType(view, R.id.delete, "field 'delete'", cls);
        Class cls2 = EditText.class;
        masterPassengerNewActivity.passengerName = (EditText) Utils.findRequiredViewAsType(view, R.id.passenger_name, "field 'passengerName'", cls2);
        Class cls3 = RelativeLayout.class;
        masterPassengerNewActivity.passenger_dob_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.passenger_dob_rl, "field 'passenger_dob_rl'", cls3);
        masterPassengerNewActivity.passengerDob = (EditText) Utils.findRequiredViewAsType(view, R.id.passenger_dob, "field 'passengerDob'", cls2);
        Class cls4 = RadioGroup.class;
        masterPassengerNewActivity.llPassengerGender = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.ll_passenger_gender, "field 'llPassengerGender'", cls4);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_male, "field 'tvMale' and method 'onMaleBtnClick'");
        Class cls5 = RadioButton.class;
        masterPassengerNewActivity.tvMale = (RadioButton) Utils.castView(findRequiredView, R.id.tv_male, "field 'tvMale'", cls5);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new k(masterPassengerNewActivity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_female, "field 'tvFemale' and method 'onFemaleBtnClick'");
        masterPassengerNewActivity.tvFemale = (RadioButton) Utils.castView(findRequiredView2, R.id.tv_female, "field 'tvFemale'", cls5);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new l(masterPassengerNewActivity));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_transgender, "field 'tvTransgender' and method 'onTransgenderBtnClick'");
        masterPassengerNewActivity.tvTransgender = (RadioButton) Utils.castView(findRequiredView3, R.id.tv_transgender, "field 'tvTransgender'", cls5);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new m(masterPassengerNewActivity));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.rv_berth_pref, "field 'rvBerthPref' and method 'onBerthPreferenceClick'");
        masterPassengerNewActivity.rvBerthPref = (RelativeLayout) Utils.castView(findRequiredView4, R.id.rv_berth_pref, "field 'rvBerthPref'", cls3);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new n(masterPassengerNewActivity));
        masterPassengerNewActivity.tvBerthPreference = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_berth_preference, "field 'tvBerthPreference'", cls);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.rv_food_pref, "field 'rvFoodPref' and method 'onFoodChoiceClick'");
        masterPassengerNewActivity.rvFoodPref = (RelativeLayout) Utils.castView(findRequiredView5, R.id.rv_food_pref, "field 'rvFoodPref'", cls3);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new o(masterPassengerNewActivity));
        masterPassengerNewActivity.tvFoodPref = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_food_pref, "field 'tvFoodPref'", cls);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.rv_card_type, "field 'rvCardType', method 'onIdCardClick', and method 'idCardValidate'");
        masterPassengerNewActivity.rvCardType = (RelativeLayout) Utils.castView(findRequiredView6, R.id.rv_card_type, "field 'rvCardType'", cls3);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new p(masterPassengerNewActivity));
        findRequiredView6.setOnFocusChangeListener(new q(masterPassengerNewActivity));
        masterPassengerNewActivity.tvCardType = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_card_type, "field 'tvCardType'", cls);
        masterPassengerNewActivity.cardNumber = (EditText) Utils.findRequiredViewAsType(view, R.id.card_number, "field 'cardNumber'", cls2);
        Class cls6 = LinearLayout.class;
        masterPassengerNewActivity.llSrctznConcession = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_srctzn_concession, "field 'llSrctznConcession'", cls6);
        View findRequiredView7 = Utils.findRequiredView(view, R.id.rv_srctzn_concession, "field 'rvSrctznConcession' and method 'onSeniorCtznConcessionClick'");
        masterPassengerNewActivity.rvSrctznConcession = (RelativeLayout) Utils.castView(findRequiredView7, R.id.rv_srctzn_concession, "field 'rvSrctznConcession'", cls3);
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new r(masterPassengerNewActivity));
        masterPassengerNewActivity.tvSrctznConcession = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_srctzn_concession, "field 'tvSrctznConcession'", cls);
        masterPassengerNewActivity.id_card_number11 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.id_card_number11, "field 'id_card_number11'", cls6);
        View findRequiredView8 = Utils.findRequiredView(view, R.id.submit, "field 'submit' and method 'onDoneClick'");
        masterPassengerNewActivity.submit = (TextView) Utils.castView(findRequiredView8, R.id.submit, "field 'submit'", cls);
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new s(masterPassengerNewActivity));
        View findRequiredView9 = Utils.findRequiredView(view, R.id.calender, "field 'calender' and method 'dobCalender'");
        Class cls7 = ImageView.class;
        masterPassengerNewActivity.calender = (ImageView) Utils.castView(findRequiredView9, R.id.calender, "field 'calender'", cls7);
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new a(masterPassengerNewActivity));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.tv_normal, "field 'normal_pasg' and method 'onNormalPassClick'");
        masterPassengerNewActivity.normal_pasg = (RadioButton) Utils.castView(findRequiredView10, R.id.tv_normal, "field 'normal_pasg'", cls5);
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new b(masterPassengerNewActivity));
        View findRequiredView11 = Utils.findRequiredView(view, R.id.tv_divyaang, "field 'divyaang_pasg' and method 'onDivyaangClick'");
        masterPassengerNewActivity.divyaang_pasg = (RadioButton) Utils.castView(findRequiredView11, R.id.tv_divyaang, "field 'divyaang_pasg'", cls5);
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new c(masterPassengerNewActivity));
        View findRequiredView12 = Utils.findRequiredView(view, R.id.tv_journalist, "field 'journalist_pasg' and method 'onJournalistClick'");
        masterPassengerNewActivity.journalist_pasg = (RadioButton) Utils.castView(findRequiredView12, R.id.tv_journalist, "field 'journalist_pasg'", cls5);
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new d(masterPassengerNewActivity));
        masterPassengerNewActivity.spc_concession_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.spc_concession_layout, "field 'spc_concession_ll'", cls6);
        masterPassengerNewActivity.spc_card_number = (EditText) Utils.findRequiredViewAsType(view, R.id.spc_card_number, "field 'spc_card_number'", cls2);
        masterPassengerNewActivity.conc_dob = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_conc_dob, "field 'conc_dob'", cls2);
        masterPassengerNewActivity.conc_cardvalidity = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_conc_cardvalidity, "field 'conc_cardvalidity'", cls2);
        masterPassengerNewActivity.govt_card_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.govt_card_ll, "field 'govt_card_ll'", cls6);
        masterPassengerNewActivity.nationality_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.nationality_ll, "field 'nationality_ll'", cls6);
        masterPassengerNewActivity.nationality_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.nationality_rl, "field 'nationality_rl'", cls3);
        View findRequiredView13 = Utils.findRequiredView(view, R.id.nationality, "field 'nationality' and method 'onNationalityClick'");
        masterPassengerNewActivity.nationality = (TextView) Utils.castView(findRequiredView13, R.id.nationality, "field 'nationality'", cls);
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new e(masterPassengerNewActivity));
        masterPassengerNewActivity.specialConcesionType = (TextView) Utils.findRequiredViewAsType(view, R.id.special_concession_list, "field 'specialConcesionType'", cls);
        View findRequiredView14 = Utils.findRequiredView(view, R.id.special_concession_rl, "field 'special_concession_rl' and method 'onSpecialConcession'");
        masterPassengerNewActivity.special_concession_rl = (RelativeLayout) Utils.castView(findRequiredView14, R.id.special_concession_rl, "field 'special_concession_rl'", cls3);
        this.n = findRequiredView14;
        findRequiredView14.setOnClickListener(new f(masterPassengerNewActivity));
        masterPassengerNewActivity.valid_carddate_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.valid_carddate_rl, "field 'valid_carddate_rl'", cls3);
        masterPassengerNewActivity.calendervaliddate = (ImageView) Utils.findRequiredViewAsType(view, R.id.calendervaliddate, "field 'calendervaliddate'", cls7);
        masterPassengerNewActivity.conc_dob_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.conc_dob_rl, "field 'conc_dob_rl'", cls3);
        masterPassengerNewActivity.calender_carddob_rl = (ImageView) Utils.findRequiredViewAsType(view, R.id.calender_carddob_rl, "field 'calender_carddob_rl'", cls7);
        masterPassengerNewActivity.et_aadhar_vid = (EditText) Utils.findRequiredViewAsType(view, R.id.et_aadhar_vid, "field 'et_aadhar_vid'", cls2);
        masterPassengerNewActivity.ll_divyaang_fecility = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.ll_divyaang_fecility, "field 'll_divyaang_fecility'", cls4);
        masterPassengerNewActivity.tv_info_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_info_msg, "field 'tv_info_msg'", cls);
        masterPassengerNewActivity.cardBorder = Utils.findRequiredView(view, R.id.card_number_border, "field 'cardBorder'");
        View findRequiredView15 = Utils.findRequiredView(view, R.id.tv_male_lable, "method 'onMaleLableClick'");
        this.o = findRequiredView15;
        findRequiredView15.setOnClickListener(new g(masterPassengerNewActivity));
        View findRequiredView16 = Utils.findRequiredView(view, R.id.tv_female_lable, "method 'onFemaleLableClick'");
        this.p = findRequiredView16;
        findRequiredView16.setOnClickListener(new h(masterPassengerNewActivity));
        View findRequiredView17 = Utils.findRequiredView(view, R.id.tv_transgender_lable, "method 'onTransgenderLableClick'");
        this.q = findRequiredView17;
        findRequiredView17.setOnClickListener(new i(masterPassengerNewActivity));
        View findRequiredView18 = Utils.findRequiredView(view, R.id.trans_view, "method 'onClickOutSide'");
        this.r = findRequiredView18;
        findRequiredView18.setOnClickListener(new j(masterPassengerNewActivity));
    }

    public final void unbind() {
        MasterPassengerNewActivity masterPassengerNewActivity = this.f4262a;
        if (masterPassengerNewActivity != null) {
            this.f4262a = null;
            masterPassengerNewActivity.titleName = null;
            masterPassengerNewActivity.delete = null;
            masterPassengerNewActivity.passengerName = null;
            masterPassengerNewActivity.passenger_dob_rl = null;
            masterPassengerNewActivity.passengerDob = null;
            masterPassengerNewActivity.llPassengerGender = null;
            masterPassengerNewActivity.tvMale = null;
            masterPassengerNewActivity.tvFemale = null;
            masterPassengerNewActivity.tvTransgender = null;
            masterPassengerNewActivity.rvBerthPref = null;
            masterPassengerNewActivity.tvBerthPreference = null;
            masterPassengerNewActivity.rvFoodPref = null;
            masterPassengerNewActivity.tvFoodPref = null;
            masterPassengerNewActivity.rvCardType = null;
            masterPassengerNewActivity.tvCardType = null;
            masterPassengerNewActivity.cardNumber = null;
            masterPassengerNewActivity.llSrctznConcession = null;
            masterPassengerNewActivity.rvSrctznConcession = null;
            masterPassengerNewActivity.tvSrctznConcession = null;
            masterPassengerNewActivity.id_card_number11 = null;
            masterPassengerNewActivity.submit = null;
            masterPassengerNewActivity.calender = null;
            masterPassengerNewActivity.normal_pasg = null;
            masterPassengerNewActivity.divyaang_pasg = null;
            masterPassengerNewActivity.journalist_pasg = null;
            masterPassengerNewActivity.spc_concession_ll = null;
            masterPassengerNewActivity.spc_card_number = null;
            masterPassengerNewActivity.conc_dob = null;
            masterPassengerNewActivity.conc_cardvalidity = null;
            masterPassengerNewActivity.govt_card_ll = null;
            masterPassengerNewActivity.nationality_ll = null;
            masterPassengerNewActivity.nationality_rl = null;
            masterPassengerNewActivity.nationality = null;
            masterPassengerNewActivity.specialConcesionType = null;
            masterPassengerNewActivity.special_concession_rl = null;
            masterPassengerNewActivity.valid_carddate_rl = null;
            masterPassengerNewActivity.calendervaliddate = null;
            masterPassengerNewActivity.conc_dob_rl = null;
            masterPassengerNewActivity.calender_carddob_rl = null;
            masterPassengerNewActivity.et_aadhar_vid = null;
            masterPassengerNewActivity.ll_divyaang_fecility = null;
            masterPassengerNewActivity.tv_info_msg = null;
            masterPassengerNewActivity.cardBorder = null;
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
            this.f.setOnFocusChangeListener((View.OnFocusChangeListener) null);
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
}
