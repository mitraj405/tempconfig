package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.prs.ima.R;

public class AadharRegistraionFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public Context f4393a;

    /* renamed from: a  reason: collision with other field name */
    public C1122g f4394a = new C1122g();

    /* renamed from: a  reason: collision with other field name */
    public short f4395a = 0;
    @BindView(2131362511)
    EditText aadhaarName;
    @BindView(2131362512)
    EditText aadhaarNumber;
    @BindView(2131363005)
    LinearLayout aadharLayout;
    @BindView(2131364283)
    TextView addressUid;
    @BindView(2131362069)
    LinearLayout botAdLayout;
    @BindView(2131364345)
    TextView colonyUid;
    @BindView(2131364709)
    LinearLayout detailsLayout;
    @BindView(2131364257)
    TextView districtUid;
    @BindView(2131364379)
    TextView dobUid;
    @BindView(2131364428)
    TextView genderUid;
    @BindView(2131362558)
    EditText otp;
    @BindView(2131364517)
    LinearLayout otpLayout;
    @BindView(2131364531)
    TextView pinUid;
    @BindView(2131364581)
    TextView sendOTP;
    @BindView(2131364613)
    TextView stateUid;
    @BindView(2131363797)
    TextView status;
    @BindView(2131363929)
    CheckBox tAndcKYC;
    @BindView(2131363060)
    LinearLayout tAndckycLayout;
    @BindView(2131364708)
    LinearLayout uidDisplay;
    @BindView(2131364710)
    TextView uidNumber;

    static {
        C1354qp.R(AadhaarKYCFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_aadhar_kyc, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4393a = getContext();
        C0535I5.a(this.aadhaarNumber, 12);
        C1408tl tlVar = C1450w1.f7012a;
        this.f4395a = 0;
        this.sendOTP.setText(getString(R.string.send_otp));
        this.otpLayout.setVisibility(8);
        this.detailsLayout.setVisibility(8);
        this.f4394a = new C1122g();
        this.aadhaarNumber.setInputType(2);
        this.otp.setInputType(2);
        C0535I5.H(getActivity(), getView());
        this.otp.addTextChangedListener(new C0479D5(getActivity(), 6));
        this.botAdLayout.setVisibility(0);
        this.aadhaarName.requestFocus();
        return inflate;
    }

    @OnClick({2131364581})
    public void onSearchClick() {
        String str;
        C0535I5.I(getActivity());
        String str2 = "Please Select Terms and Conditions to proceed";
        if (!this.tAndcKYC.isChecked()) {
            this.tAndcKYC.setSelected(false);
            C0535I5.o(getContext(), str2, "OK", (DialogInterface.OnClickListener) null);
        } else {
            this.tAndcKYC.setSelected(true);
        }
        if (this.aadhaarNumber.getText().toString().equalsIgnoreCase("")) {
            str2 = "Please Enter Aadhaar number";
        } else if (this.tAndcKYC.isChecked()) {
            if (this.tAndcKYC.isChecked()) {
                this.a = ProgressDialog.show(getContext(), "KYC Update", getString(R.string.please_wait));
                if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
                    new Handler().postDelayed(new C1143h(), 5000);
                } else {
                    Om om = (Om) C0657Qt.c(C0793b1.a.f3912a);
                    short s = this.f4395a;
                    if (s == 0) {
                        String obj = this.aadhaarNumber.getText().toString();
                        String str3 = "Please enter Aadhaar card number";
                        if (obj != null) {
                            try {
                                if (obj.length() != 0) {
                                    if (obj.length() == 12) {
                                        if (C1488xu.k(obj)) {
                                            str3 = "ok";
                                        }
                                    }
                                    str3 = getString(R.string.invalid_Aadhaar_card);
                                }
                            } catch (Exception e) {
                                e.getMessage();
                                str = str3 + e;
                            }
                        }
                        str = str3;
                        if (str != "ok") {
                            C0535I5.m(getActivity(), false, str, getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                            this.a.dismiss();
                        } else if (this.aadhaarName.getText().toString() == null || xx.T(this.aadhaarName, "")) {
                            C0535I5.m(getActivity(), false, getActivity().getResources().getString(R.string.enter_aadhar_name), getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                            this.a.dismiss();
                        } else {
                            this.f4394a.setAadhaarNumber(this.aadhaarNumber.getText().toString());
                            this.f4394a.setAadhaarName(this.aadhaarName.getText().toString());
                        }
                    } else if (s == 1) {
                        if (this.otp.getText().toString() == null) {
                            C0535I5.m(getActivity(), false, "Invalid OTP", getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                            this.a.dismiss();
                        } else {
                            this.aadhaarNumber.setEnabled(false);
                            this.aadhaarName.setEnabled(false);
                            this.aadhaarNumber.setFocusable(false);
                            this.f4394a.setOtp(this.otp.getText().toString());
                        }
                    } else if (s == 2) {
                        this.f4394a.setOtp((String) null);
                        this.f4394a.setUpdate(Boolean.TRUE);
                    }
                    om.x(C1058d.z(C0657Qt.l(), "updateKYC"), this.f4394a).c(C1181iv.a()).a(E0.a()).b(new C1015c(this));
                }
            }
            str2 = "";
        }
        if (!str2.equals("")) {
            C0535I5.t0(getActivity(), str2);
        }
    }
}
