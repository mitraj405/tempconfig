package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class AadhaarKYCFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public AadhaarKYCFragment f4392a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ AadhaarKYCFragment a;

        public a(AadhaarKYCFragment aadhaarKYCFragment) {
            this.a = aadhaarKYCFragment;
        }

        public final void doClick(View view) {
            this.a.onResendClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ AadhaarKYCFragment a;

        public b(AadhaarKYCFragment aadhaarKYCFragment) {
            this.a = aadhaarKYCFragment;
        }

        public final void doClick(View view) {
            this.a.onCardTypeClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ AadhaarKYCFragment a;

        public c(AadhaarKYCFragment aadhaarKYCFragment) {
            this.a = aadhaarKYCFragment;
        }

        public final void doClick(View view) {
            this.a.AddharDobOnClick();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ AadhaarKYCFragment a;

        public d(AadhaarKYCFragment aadhaarKYCFragment) {
            this.a = aadhaarKYCFragment;
        }

        public final void doClick(View view) {
            this.a.AddharGenderOnClick();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ AadhaarKYCFragment a;

        public e(AadhaarKYCFragment aadhaarKYCFragment) {
            this.a = aadhaarKYCFragment;
        }

        public final void doClick(View view) {
            this.a.onReverifyAadhaarClick();
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ AadhaarKYCFragment a;

        public f(AadhaarKYCFragment aadhaarKYCFragment) {
            this.a = aadhaarKYCFragment;
        }

        public final void doClick(View view) {
            this.a.PanDobOnClick();
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ AadhaarKYCFragment a;

        public g(AadhaarKYCFragment aadhaarKYCFragment) {
            this.a = aadhaarKYCFragment;
        }

        public final void doClick(View view) {
            this.a.onSubmitOtpClick();
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ AadhaarKYCFragment a;

        public h(AadhaarKYCFragment aadhaarKYCFragment) {
            this.a = aadhaarKYCFragment;
        }

        public final void doClick(View view) {
            this.a.onClickWalletView(view);
        }
    }

    public AadhaarKYCFragment_ViewBinding(AadhaarKYCFragment aadhaarKYCFragment, View view) {
        this.f4392a = aadhaarKYCFragment;
        Class cls = EditText.class;
        aadhaarKYCFragment.aadhaarNumber = (EditText) Utils.findRequiredViewAsType(view, R.id.et_aadhar_number, "field 'aadhaarNumber'", cls);
        aadhaarKYCFragment.aadhaarName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_aadhar_name, "field 'aadhaarName'", cls);
        aadhaarKYCFragment.tAndcKYC = (CheckBox) Utils.findRequiredViewAsType(view, R.id.select_tandc_kyc, "field 'tAndcKYC'", CheckBox.class);
        Class cls2 = RelativeLayout.class;
        aadhaarKYCFragment.otpLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.tv_opt_layout, "field 'otpLayout'", cls2);
        Class cls3 = LinearLayout.class;
        aadhaarKYCFragment.tAndckycLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_select_kyc, "field 'tAndckycLayout'", cls3);
        aadhaarKYCFragment.et_otp = (EditText) Utils.findRequiredViewAsType(view, R.id.et_otp, "field 'et_otp'", cls);
        Class cls4 = AdManagerAdView.class;
        aadhaarKYCFragment.aadharkyc_otp = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.aadhar_kyc_otp, "field 'aadharkyc_otp'", cls4);
        aadhaarKYCFragment.adharkycbottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.adhar_kyc_bottom, "field 'adharkycbottom'", cls4);
        View findRequiredView = Utils.findRequiredView(view, R.id.resendOtp, "field 'resendOtp' and method 'onResendClick'");
        Class cls5 = TextView.class;
        aadhaarKYCFragment.resendOtp = (TextView) Utils.castView(findRequiredView, R.id.resendOtp, "field 'resendOtp'", cls5);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(aadhaarKYCFragment));
        aadhaarKYCFragment.verifyFlag = (TextView) Utils.findRequiredViewAsType(view, R.id.verifyFlag, "field 'verifyFlag'", cls5);
        aadhaarKYCFragment.adharverifyll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.adharverify_ll, "field 'adharverifyll'", cls3);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.card_type_rl, "field 'card_type_rl' and method 'onCardTypeClick'");
        aadhaarKYCFragment.card_type_rl = (RelativeLayout) Utils.castView(findRequiredView2, R.id.card_type_rl, "field 'card_type_rl'", cls2);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(aadhaarKYCFragment));
        aadhaarKYCFragment.veryFlag_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.veryFlag_ll, "field 'veryFlag_ll'", cls3);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.aadhar_dob, "field 'aadharDob' and method 'AddharDobOnClick'");
        aadhaarKYCFragment.aadharDob = (TextView) Utils.castView(findRequiredView3, R.id.aadhar_dob, "field 'aadharDob'", cls5);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(aadhaarKYCFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.aadhar_gender, "field 'aadharGender' and method 'AddharGenderOnClick'");
        aadhaarKYCFragment.aadharGender = (TextView) Utils.castView(findRequiredView4, R.id.aadhar_gender, "field 'aadharGender'", cls5);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(aadhaarKYCFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.reverify_aadhaar, "field 'reverifyAadhaar' and method 'onReverifyAadhaarClick'");
        aadhaarKYCFragment.reverifyAadhaar = (Button) Utils.castView(findRequiredView5, R.id.reverify_aadhaar, "field 'reverifyAadhaar'", Button.class);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(aadhaarKYCFragment));
        aadhaarKYCFragment.selected_card_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_card_type, "field 'selected_card_type'", cls5);
        aadhaarKYCFragment.pan_card_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pan_card_ll, "field 'pan_card_ll'", cls3);
        aadhaarKYCFragment.et_pan_card_number = (EditText) Utils.findRequiredViewAsType(view, R.id.et_pan_card_number, "field 'et_pan_card_number'", cls);
        aadhaarKYCFragment.et_pan_card_name = (EditText) Utils.findRequiredViewAsType(view, R.id.et_pan_card_name, "field 'et_pan_card_name'", cls);
        aadhaarKYCFragment.updation_title_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.updation_title_tv, "field 'updation_title_tv'", cls5);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.et_pan_dob, "field 'et_pan_dob' and method 'PanDobOnClick'");
        aadhaarKYCFragment.et_pan_dob = (EditText) Utils.castView(findRequiredView6, R.id.et_pan_dob, "field 'et_pan_dob'", cls);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new f(aadhaarKYCFragment));
        View findRequiredView7 = Utils.findRequiredView(view, R.id.submit_otp, "method 'onSubmitOtpClick'");
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new g(aadhaarKYCFragment));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.otp_layout_view, "method 'onClickWalletView'");
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new h(aadhaarKYCFragment));
    }

    public final void unbind() {
        AadhaarKYCFragment aadhaarKYCFragment = this.f4392a;
        if (aadhaarKYCFragment != null) {
            this.f4392a = null;
            aadhaarKYCFragment.aadhaarNumber = null;
            aadhaarKYCFragment.aadhaarName = null;
            aadhaarKYCFragment.tAndcKYC = null;
            aadhaarKYCFragment.otpLayout = null;
            aadhaarKYCFragment.tAndckycLayout = null;
            aadhaarKYCFragment.et_otp = null;
            aadhaarKYCFragment.aadharkyc_otp = null;
            aadhaarKYCFragment.adharkycbottom = null;
            aadhaarKYCFragment.resendOtp = null;
            aadhaarKYCFragment.verifyFlag = null;
            aadhaarKYCFragment.adharverifyll = null;
            aadhaarKYCFragment.card_type_rl = null;
            aadhaarKYCFragment.veryFlag_ll = null;
            aadhaarKYCFragment.aadharDob = null;
            aadhaarKYCFragment.aadharGender = null;
            aadhaarKYCFragment.reverifyAadhaar = null;
            aadhaarKYCFragment.selected_card_type = null;
            aadhaarKYCFragment.pan_card_ll = null;
            aadhaarKYCFragment.et_pan_card_number = null;
            aadhaarKYCFragment.et_pan_card_name = null;
            aadhaarKYCFragment.updation_title_tv = null;
            aadhaarKYCFragment.et_pan_dob = null;
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
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
