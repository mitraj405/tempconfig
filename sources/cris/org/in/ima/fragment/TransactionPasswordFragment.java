package cris.org.in.ima.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import java.io.Serializable;
import java.util.ArrayList;

public class TransactionPasswordFragment extends Fragment {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<C1187j2> f5178a;

    /* renamed from: a  reason: collision with other field name */
    public final C1215kb f5179a = new C1215kb();
    public int c;
    @BindView(2131362270)
    EditText cnfTxnPassword;
    @BindView(2131364581)
    TextView submit;
    @BindView(2131364741)
    EditText txnPw;

    public class a implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    static {
        C1354qp.R(TransactionPasswordFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_txn_pwd, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.a = getContext();
        C1087eb ebVar = (C1087eb) getArguments().getSerializable("ewallet");
        this.c = getArguments().getInt("TotalFare");
        this.f5178a = (ArrayList) getArguments().getSerializable("BankDetailDto");
        getArguments().getString("ClientTxnId");
        GoogleAdParamDTO googleAdParamDTO = (GoogleAdParamDTO) getArguments().getSerializable("googleAd");
        return inflate;
    }

    @OnClick({2131364581})
    public void onRegisterClick() {
        C0535I5.I(getActivity());
        if (xx.T(this.txnPw, "")) {
            C0535I5.m(this.a, false, getString(R.string.enter_txn_pw), getString(R.string.error), getString(R.string.OK), new a());
        } else if (xx.T(this.cnfTxnPassword, "")) {
            C0535I5.m(this.a, false, getString(R.string.enter_cnf_txn_pw), getString(R.string.error), getString(R.string.OK), new b());
        } else if (!this.cnfTxnPassword.getText().toString().equals(this.txnPw.getText().toString())) {
            C0535I5.m(this.a, false, getString(R.string.txn_pw_cnf_pw_not_match), getString(R.string.error), getString(R.string.OK), new c());
        } else {
            String obj = this.txnPw.getText().toString();
            C1215kb kbVar = this.f5179a;
            kbVar.setTxnPassword(obj);
            kbVar.setTxnPasswordConfirm(this.cnfTxnPassword.getText().toString());
            ArrayList<C1187j2> arrayList = this.f5178a;
            FragmentActivity activity = getActivity();
            int i = this.c;
            Bundle bundle = new Bundle();
            MakePaymentNewFragment makePaymentNewFragment = new MakePaymentNewFragment();
            bundle.putString("TotalFare", String.valueOf(i));
            bundle.putSerializable("BankDetailDto", arrayList);
            bundle.putSerializable("paymentDTO", kbVar);
            bundle.putSerializable("eWalletDto", (Serializable) null);
            bundle.putString("ClientTxnId", (String) null);
            bundle.putSerializable("googleAd", new GoogleAdParamDTO());
            makePaymentNewFragment.setArguments(bundle);
            HomeActivity.n(activity, makePaymentNewFragment, activity.getResources().getString(R.string.make_payment_title), Boolean.TRUE, Boolean.FALSE);
        }
    }
}
