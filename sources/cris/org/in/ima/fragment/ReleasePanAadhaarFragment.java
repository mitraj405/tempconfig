package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;

public class ReleasePanAadhaarFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public C1215kb f5071a;

    /* renamed from: a  reason: collision with other field name */
    public C1223kn f5072a;
    @BindView(2131361818)
    TextView aadhaar_tv;
    @BindView(2131362018)
    TextView balance_tv;
    @BindView(2131362151)
    CheckBox cb_tnc;
    @BindView(2131362542)
    EditText et_login_pass;
    @BindView(2131363277)
    AdManagerAdView mPublisherAdview;
    @BindView(2131363432)
    TextView pan_tv;
    @BindView(2131364798)
    TextView user_name_tv;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ReleasePanAadhaarFragment releasePanAadhaarFragment = ReleasePanAadhaarFragment.this;
            String obj = releasePanAadhaarFragment.et_login_pass.getText().toString();
            if (!C0535I5.O((ConnectivityManager) releasePanAadhaarFragment.getActivity().getSystemService("connectivity"), releasePanAadhaarFragment.getActivity())) {
                new Handler().postDelayed(new C1226kt(), 5000);
                return;
            }
            releasePanAadhaarFragment.a = ProgressDialog.show(releasePanAadhaarFragment.getActivity(), "", releasePanAadhaarFragment.getString(R.string.please_wait_text));
            C1223kn knVar = C0793b1.a.f3912a;
            releasePanAadhaarFragment.f5072a = knVar;
            if (knVar == null) {
                C0535I5.t0(releasePanAadhaarFragment.getActivity(), releasePanAadhaarFragment.getString(R.string.error));
                return;
            }
            try {
                releasePanAadhaarFragment.f5071a.setTxnPassword(obj);
                String g = C0657Qt.g();
                ((Om) C0657Qt.c(releasePanAadhaarFragment.f5072a)).r(g + "ewalletDeactivateAccount", releasePanAadhaarFragment.f5071a).c(C1181iv.a()).a(E0.a()).b(new C1289nt(releasePanAadhaarFragment));
            } catch (Exception e) {
                e.getMessage();
                releasePanAadhaarFragment.a.dismiss();
                C0535I5.t0(releasePanAadhaarFragment.getActivity(), releasePanAadhaarFragment.getString(R.string.please_try_again));
            }
        }
    }

    static {
        C1354qp.R(ReleasePanAadhaarFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_release_pan_aadhaar, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getActivity())) {
            new Handler().postDelayed(new C1161ht(), 5000);
        } else {
            this.a = ProgressDialog.show(getActivity(), getString(R.string.fetch_user_data), getString(R.string.please_wait_text));
            C1223kn knVar = C0793b1.a.f3912a;
            this.f5072a = knVar;
            if (knVar == null) {
                C0535I5.t0(getActivity(), getString(R.string.error));
            } else {
                try {
                    String g = C0657Qt.g();
                    ((Om) C0657Qt.c(knVar)).l1(g + "eWalletAccountDetail").c(C1181iv.a()).a(E0.a()).b(new C1026h0(this));
                } catch (Exception e) {
                    e.getMessage();
                    this.a.dismiss();
                    C0535I5.t0(getActivity(), getString(R.string.please_try_again));
                }
            }
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.mPublisherAdview, googleAdParamDTO);
        HomeActivity.J();
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364562})
    public void tv_release_pan_aadhaar_click() {
        if (lf.e(this.et_login_pass) > 0) {
            C0535I5.I(getActivity());
            if (this.cb_tnc.isChecked()) {
                a aVar = new a();
                C0535I5.p(getActivity(), false, getString(R.string.aadhaar_confirm_message), getString(R.string.confirm), getString(R.string.no), new b(), getString(R.string.yes), aVar).show();
                return;
            }
            C0535I5.m(getActivity(), false, getString(R.string.please_accept_Term_Conditions), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        C0535I5.m(getActivity(), false, getString(R.string.enter_Login_Password), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        this.et_login_pass.requestFocus();
    }

    @OnClick({2131364666})
    public void tv_tnc_click() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://contents.irctc.co.in/en/deactivateEWalletTermsAndConditions.pdf"));
        startActivity(intent);
    }

    public class b implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
