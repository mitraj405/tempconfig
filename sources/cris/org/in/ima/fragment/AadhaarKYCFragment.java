package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.EwalletProfileDTO;
import defpackage.C1421u9;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import rx.Subscriber;

public class AadhaarKYCFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public final Jh a = new Jh();

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4383a;

    /* renamed from: a  reason: collision with other field name */
    public Context f4384a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f4385a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4386a;

    /* renamed from: a  reason: collision with other field name */
    public EwalletProfileDTO f4387a = new EwalletProfileDTO();

    /* renamed from: a  reason: collision with other field name */
    public C1122g f4388a = new C1122g();

    /* renamed from: a  reason: collision with other field name */
    public Boolean f4389a = Boolean.FALSE;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4390a = new ArrayList<>();
    @BindView(2131362511)
    EditText aadhaarName;
    @BindView(2131362512)
    EditText aadhaarNumber;
    @BindView(2131361819)
    TextView aadharDob;
    @BindView(2131361820)
    TextView aadharGender;
    @BindView(2131361821)
    AdManagerAdView aadharkyc_otp;
    @BindView(2131361920)
    AdManagerAdView adharkycbottom;
    @BindView(2131361921)
    LinearLayout adharverifyll;

    /* renamed from: c  reason: collision with other field name */
    public String f4391c = "";
    @BindView(2131362138)
    RelativeLayout card_type_rl;
    public String d = null;
    public String e = "";
    @BindView(2131362560)
    EditText et_otp;
    @BindView(2131362561)
    EditText et_pan_card_name;
    @BindView(2131362562)
    EditText et_pan_card_number;
    @BindView(2131362563)
    EditText et_pan_dob;
    public String f = "";
    @BindView(2131364517)
    RelativeLayout otpLayout;
    @BindView(2131363429)
    LinearLayout pan_card_ll;
    @BindView(2131363677)
    TextView resendOtp;
    @BindView(2131363693)
    Button reverifyAadhaar;
    @BindView(2131364329)
    TextView selected_card_type;
    @BindView(2131363929)
    CheckBox tAndcKYC;
    @BindView(2131363060)
    LinearLayout tAndckycLayout;
    @BindView(2131364793)
    TextView updation_title_tv;
    @BindView(2131364807)
    TextView verifyFlag;
    @BindView(2131364812)
    LinearLayout veryFlag_ll;

    public class a extends C1421u9.a {
        public a(EditText editText) {
            super(editText);
        }

        public final void a() {
            AadhaarKYCFragment aadhaarKYCFragment = AadhaarKYCFragment.this;
            if (aadhaarKYCFragment.aadhaarNumber.getInputType() != 18) {
                aadhaarKYCFragment.aadhaarNumber.setInputType(18);
                EditText editText = aadhaarKYCFragment.aadhaarNumber;
                editText.setSelection(editText.getText().length());
                aadhaarKYCFragment.aadhaarNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility_off, 0);
                return;
            }
            aadhaarKYCFragment.aadhaarNumber.setInputType(2);
            EditText editText2 = aadhaarKYCFragment.aadhaarNumber;
            editText2.setSelection(editText2.getText().length());
            aadhaarKYCFragment.aadhaarNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility, 0);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public final void onClick(View view) {
            AadhaarKYCFragment aadhaarKYCFragment = AadhaarKYCFragment.this;
            aadhaarKYCFragment.d = "SEND_OTP";
            aadhaarKYCFragment.f();
        }
    }

    public class c implements OnSelectionListener {
        public c() {
        }

        public final void onClick(String str) {
            AadhaarKYCFragment aadhaarKYCFragment = AadhaarKYCFragment.this;
            aadhaarKYCFragment.selected_card_type.setText(str);
            aadhaarKYCFragment.f4386a.dismiss();
            if (str != null && !str.equals("")) {
                aadhaarKYCFragment.e = str;
            }
            aadhaarKYCFragment.getClass();
            String str2 = C1450w1.f7031f;
            if (str2 == null || !str2.equals("N#N#N")) {
                String str3 = C1450w1.f7031f;
                if (str3 != null && str3.equals("N#Y#N")) {
                    if (aadhaarKYCFragment.e.equalsIgnoreCase("PAN CARD")) {
                        aadhaarKYCFragment.veryFlag_ll.setVisibility(0);
                        aadhaarKYCFragment.verifyFlag.setText(aadhaarKYCFragment.getString(R.string.panverify_user));
                        aadhaarKYCFragment.adharverifyll.setVisibility(8);
                        HomeActivity.G("");
                        return;
                    }
                    aadhaarKYCFragment.pan_card_ll.setVisibility(8);
                    aadhaarKYCFragment.veryFlag_ll.setVisibility(8);
                    aadhaarKYCFragment.adharverifyll.setVisibility(0);
                    HomeActivity.G(aadhaarKYCFragment.getString(R.string.send_otp));
                    HomeActivity.f4190d.setContentDescription("send o t p");
                    aadhaarKYCFragment.aadhaarNumber.requestFocus();
                }
            } else if (aadhaarKYCFragment.e.equalsIgnoreCase("PAN CARD")) {
                aadhaarKYCFragment.adharverifyll.setVisibility(8);
                aadhaarKYCFragment.reverifyAadhaar.setVisibility(8);
                aadhaarKYCFragment.veryFlag_ll.setVisibility(8);
                aadhaarKYCFragment.pan_card_ll.setVisibility(0);
                HomeActivity.G(aadhaarKYCFragment.getString(R.string.send_otp));
                HomeActivity.f4190d.setContentDescription("send o t p");
                aadhaarKYCFragment.et_pan_card_number.requestFocus();
            } else {
                aadhaarKYCFragment.pan_card_ll.setVisibility(8);
                aadhaarKYCFragment.veryFlag_ll.setVisibility(8);
                aadhaarKYCFragment.adharverifyll.setVisibility(0);
                HomeActivity.G(aadhaarKYCFragment.getString(R.string.send_otp));
                HomeActivity.f4190d.setContentDescription("send o t p");
                aadhaarKYCFragment.aadhaarNumber.requestFocus();
            }
        }
    }

    public class e extends Subscriber<C1122g> {
        public e() {
        }

        public final void onCompleted() {
            AadhaarKYCFragment.this.f4383a.dismiss();
            int i = AadhaarKYCFragment.c;
        }

        public final void onError(Throwable th) {
            int i = AadhaarKYCFragment.c;
            xx.S(th, true, th);
        }

        public final void onNext(Object obj) {
            C1122g gVar = (C1122g) obj;
            if (gVar != null) {
                String errorMessage = gVar.getErrorMessage();
                AadhaarKYCFragment aadhaarKYCFragment = AadhaarKYCFragment.this;
                if (errorMessage != null) {
                    C0535I5.m(aadhaarKYCFragment.getActivity(), false, gVar.getErrorMessage(), aadhaarKYCFragment.getString(R.string.error), aadhaarKYCFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    aadhaarKYCFragment.resendOtp.setVisibility(0);
                    aadhaarKYCFragment.et_otp.setText("");
                } else if (aadhaarKYCFragment.d.equalsIgnoreCase("SEND_OTP")) {
                    aadhaarKYCFragment.updation_title_tv.setText(aadhaarKYCFragment.getString(R.string.aadhaar_Updation_OTP));
                    aadhaarKYCFragment.otpLayout.setVisibility(0);
                    HomeActivity.t();
                    aadhaarKYCFragment.et_otp.setFocusable(true);
                    HomeActivity.b.setClickable(true);
                    HomeActivity.f4190d.setClickable(false);
                    new Handler();
                    aadhaarKYCFragment.resendOtp.setVisibility(8);
                    String otpTransactionId = gVar.getOtpTransactionId();
                    aadhaarKYCFragment.f4391c = otpTransactionId;
                    if (!otpTransactionId.isEmpty()) {
                        new Handler().postDelayed(new C1013b(this), 30000);
                    }
                } else if (aadhaarKYCFragment.d.equalsIgnoreCase("VERIFY_OTP")) {
                    C0535I5.I(aadhaarKYCFragment.getActivity());
                    Bundle bundle = new Bundle();
                    AdhaarKYCUpdateFragment adhaarKYCUpdateFragment = new AdhaarKYCUpdateFragment();
                    gVar.setOtpTransactionId(aadhaarKYCFragment.f4388a.getOtpTransactionId());
                    gVar.setAadhaarName(aadhaarKYCFragment.f4388a.getAadhaarName());
                    gVar.setAadhaarNumber(aadhaarKYCFragment.f4388a.getAadhaarNumber());
                    bundle.putSerializable("AadharKYCDTO", gVar);
                    adhaarKYCUpdateFragment.setArguments(bundle);
                    HomeActivity.n(aadhaarKYCFragment.getActivity(), adhaarKYCUpdateFragment, aadhaarKYCFragment.getResources().getString(R.string.update_aadhaarkyc), Boolean.TRUE, Boolean.FALSE);
                }
            }
        }
    }

    static {
        C1354qp.R(AadhaarKYCFragment.class);
    }

    @OnClick({2131361819})
    public void AddharDobOnClick() {
        C0535I5.t0(this.f4384a, getString(R.string.dob_change_msg));
    }

    @OnClick({2131361820})
    public void AddharGenderOnClick() {
        C0535I5.t0(this.f4384a, getString(R.string.gender_change_msg));
    }

    @OnClick({2131362563})
    public void PanDobOnClick() {
        AddharDobOnClick();
    }

    public final void f() {
        String str;
        Date date;
        if (this.e.equalsIgnoreCase("PAN CARD")) {
            this.f4387a.setPancardNumber(this.et_pan_card_number.getText().toString());
            this.f4387a.setCardHolderName(this.et_pan_card_name.getText().toString());
            this.f4387a.setPanDob(this.et_pan_dob.getText().toString());
            this.f4387a.setOtpFlag(true);
            C0535I5.I(getActivity());
            if (this.f4387a.getPancardNumber() == null || this.f4387a.getPancardNumber().equals("") || this.f4387a.getCardHolderName() == null || this.f4387a.getCardHolderName().equals("")) {
                C0535I5.m(getActivity(), false, getString(R.string.please_enter_details), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                return;
            }
            this.f4383a = ProgressDialog.show(getContext(), getString(R.string.sending_otp), getString(R.string.please_wait_text));
            if (C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
                ((Om) C0657Qt.c(C0793b1.a.f3912a)).Q0(C1058d.z(C0657Qt.g(), "ewalletRegister"), this.f4387a).c(C1181iv.a()).a(E0.a()).b(new C1079e(this));
            }
        } else if (this.e.equalsIgnoreCase("AADHAAR CARD/ VID")) {
            this.f4388a.setAadhaarNumber(this.aadhaarNumber.getText().toString());
            this.f4388a.setAadhaarName(this.aadhaarName.getText().toString());
            if (C1450w1.a == 3) {
                C1122g gVar = this.f4388a;
                String str2 = C1450w1.f7016b;
                AlertDialog alertDialog = C0535I5.f3619a;
                try {
                    date = new SimpleDateFormat("dd-MM-yyyy").parse(str2);
                } catch (ParseException e2) {
                    e2.printStackTrace();
                    date = null;
                }
                gVar.setDateOfBirth(date);
                this.f4388a.setGender(this.aadharGender.getText().toString());
            }
            this.f4388a.setOtp((String) null);
            this.f4388a.setOtpTransactionId((String) null);
            C0535I5.I(getActivity());
            if (!this.tAndcKYC.isChecked()) {
                this.tAndcKYC.setSelected(false);
                C0535I5.o(getContext(), getString(R.string.term_and_condition), getString(R.string.ok), (DialogInterface.OnClickListener) null);
            } else {
                this.tAndcKYC.setSelected(true);
            }
            if (this.f4388a.getAadhaarNumber() == null || this.f4388a.getAadhaarNumber().equals("") || this.f4388a.getAadhaarName() == null || this.f4388a.getAadhaarName().equals("")) {
                C0535I5.m(getActivity(), false, getString(R.string.please_enter_details), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                return;
            }
            if (!this.tAndcKYC.isChecked() && !this.tAndcKYC.isChecked()) {
                str = getString(R.string.confirm_checkbox);
            } else {
                str = "ok";
            }
            if (!str.equals("ok")) {
                C0535I5.t0(getActivity(), str);
                return;
            }
            this.f4383a = ProgressDialog.show(getContext(), getString(R.string.sending_otp), getString(R.string.please_wait_text));
            g();
        }
    }

    public final void g() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f4384a)) {
            new Handler().postDelayed(new d(), 5000);
        } else {
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).x(C1058d.z(C0657Qt.l(), "updateKYC"), this.f4388a).c(C1181iv.a()).a(E0.a()).b(new e());
        }
    }

    @OnClick({2131362138})
    public void onCardTypeClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4386a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4386a.show(getActivity().getSupportFragmentManager(), "");
        this.f4386a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f4390a, new c());
        this.f4386a.g().setText(getString(R.string.select_authentication_type));
        this.f4386a.f().setAdapter(customAdapter);
    }

    @OnClick({2131363406})
    public void onClickWalletView(View view) {
        this.otpLayout.setVisibility(0);
        HomeActivity.t();
        HomeActivity.b.setClickable(true);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        View inflate = layoutInflater.inflate(R.layout.activity_adhar_kyc, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4384a = getContext();
        this.f4385a = getActivity();
        Bundle arguments = getArguments();
        this.aadhaarNumber.setInputType(18);
        if (arguments != null) {
            getArguments().getString("type");
            this.f4389a = Boolean.valueOf(getArguments().getBoolean("isUpdateProfileFlow"));
            this.f = getArguments().getString("updateProfileDob");
        }
        this.otpLayout.setVisibility(8);
        this.f4388a = new C1122g();
        EditText editText = this.aadhaarNumber;
        editText.setOnTouchListener(new a(editText));
        this.f4387a = new EwalletProfileDTO();
        C0535I5.H(getActivity(), getView());
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.aadharkyc_otp, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.adharkycbottom, googleAdParamDTO);
        this.tAndcKYC.setChecked(false);
        HomeActivity.f4190d.setOnClickListener(new b());
        HomeActivity.J();
        Bw e2 = Bw.e(this.f4384a);
        EditText editText2 = this.aadhaarName;
        if (e2.g() == null || e2.g() == "") {
            str = e2.d();
        } else {
            str = e2.d() + " " + e2.g();
        }
        editText2.setText(str);
        EditText editText3 = this.et_pan_card_name;
        if (e2.g() == null || e2.g() == "") {
            str2 = e2.d();
        } else {
            str2 = e2.d() + " " + e2.g();
        }
        editText3.setText(str2);
        this.et_pan_dob.setText(C1450w1.f7016b);
        if (C1450w1.a == 3) {
            this.aadharDob.setVisibility(0);
            this.aadharGender.setVisibility(0);
            this.aadharDob.setText(C1450w1.f7016b);
            this.aadharGender.setText(C1450w1.f7021c);
        }
        String str3 = C1450w1.f7031f;
        if (str3 != null && (str3.equals("N#N#Y") || C1450w1.f7031f.equals("N#Y#Y"))) {
            this.veryFlag_ll.setVisibility(0);
            this.card_type_rl.setVisibility(8);
            this.verifyFlag.setText(getString(R.string.adharverify_user));
            if (C1450w1.f7019b) {
                this.reverifyAadhaar.setVisibility(0);
            } else {
                this.reverifyAadhaar.setVisibility(8);
            }
        }
        String str4 = C1450w1.f7031f;
        if (str4 == null || str4.equals("")) {
            this.card_type_rl.setVisibility(8);
            this.adharverifyll.setVisibility(0);
            HomeActivity.G(getString(R.string.send_otp));
            HomeActivity.f4190d.setContentDescription("send o t p");
            this.e = "AADHAAR CARD/ VID";
        } else {
            ArrayList<String> arrayList = this.f4390a;
            arrayList.clear();
            arrayList.add("PAN CARD");
            arrayList.add("AADHAAR CARD/ VID");
        }
        if (this.f4389a.booleanValue()) {
            this.aadharDob.setText(this.f);
            this.et_pan_dob.setText(this.f);
        }
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4383a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4383a.dismiss();
        }
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f4383a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4383a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363677})
    public void onResendClick() {
        this.d = "SEND_OTP";
        f();
    }

    @OnClick({2131363693})
    public void onReverifyAadhaarClick() {
        C0535I5.t0(this.f4384a, getString(R.string.aadhaar_already_verified));
        this.reverifyAadhaar.setVisibility(8);
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4383a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4383a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364040})
    public void onSubmitOtpClick() {
        this.d = "VERIFY_OTP";
        C0535I5.I(getActivity());
        String obj = this.et_otp.getText().toString();
        if (obj == null || obj.length() == 0) {
            C0535I5.m(getActivity(), false, getString(R.string.Please_Enter_OTP), getString(R.string.error), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            this.et_otp.setText("");
            this.f4383a.dismiss();
            this.resendOtp.setVisibility(0);
            return;
        }
        this.f4388a.setOtp(obj);
        this.f4388a.setOtpTransactionId(this.f4391c);
        if (this.e.equalsIgnoreCase("PAN CARD")) {
            Jh jh = this.a;
            jh.setKycOtpType("panKyc");
            jh.setKycCardId(this.et_pan_card_number.getText().toString());
            jh.setKycUserDOB(this.et_pan_dob.getText().toString());
            jh.setKycUserName(this.et_pan_card_name.getText().toString());
            jh.setOtp(this.et_otp.getText().toString());
            this.f4383a = ProgressDialog.show(getContext(), getString(R.string.submiting_otp), getString(R.string.please_wait_text));
            if (C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
                String l = C0657Qt.l();
                ((Om) C0657Qt.c(C0793b1.a.f3912a)).w1(l + "verifyKyc", jh).c(C1181iv.a()).a(E0.a()).b(new C1098f(this));
            }
        } else if (this.e.equalsIgnoreCase("AADHAAR CARD/ VID")) {
            this.f4383a = ProgressDialog.show(getContext(), getString(R.string.submiting_otp), getString(R.string.please_wait_text));
            g();
        }
    }

    public class d implements Runnable {
        public final void run() {
        }
    }
}
