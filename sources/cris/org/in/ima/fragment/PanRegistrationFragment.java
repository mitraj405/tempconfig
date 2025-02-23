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
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.EwalletProfileDTO;

public class PanRegistrationFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public EwalletProfileDTO f4884a;
    @BindView(2131363430)
    EditText panName;
    @BindView(2131363431)
    EditText panNumber;
    @BindView(2131363069)
    LinearLayout submit;

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

    static {
        C1354qp.R(PanRegistrationFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pan_verify, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.a = getContext();
        this.f4884a = (EwalletProfileDTO) getArguments().getSerializable("ewallet");
        return inflate;
    }

    @OnClick({2131364581})
    public void onRegisterClick() {
        C0535I5.I(getActivity());
        if (xx.T(this.panName, "")) {
            C0535I5.m(this.a, false, getString(R.string.invalid_pan_name), getString(R.string.error), getString(R.string.OK), new a());
        } else if (xx.T(this.panName, "")) {
            C0535I5.m(this.a, false, getString(R.string.invalid_pan_number), getString(R.string.error), getString(R.string.OK), new b());
        } else if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.a)) {
            new Handler().postDelayed(new Ao(), 5000);
        } else {
            ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.loading), getString(R.string.please_wait_text));
            C1223kn knVar = C0793b1.a.f3912a;
            this.f4884a.setPancardNumber(this.panNumber.getText().toString().toUpperCase());
            this.f4884a.setCardHolderName(this.panName.getText().toString().toUpperCase());
            ((Om) C0657Qt.c(knVar)).F(C1058d.z(C0657Qt.g(), "ewalletRegister"), this.f4884a).c(C1181iv.a()).a(E0.a()).b(new Co(this, show));
        }
    }
}
