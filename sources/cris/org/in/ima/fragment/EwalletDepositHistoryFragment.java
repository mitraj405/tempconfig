package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cris.org.in.prs.ima.R;

public class EwalletDepositHistoryFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4606a;
    @BindView(2131362592)
    TextView emptyList;
    @BindView(2131364162)
    RecyclerView txnList;

    static {
        C1354qp.R(EwalletDepositHistoryFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_ewallet_deposit_history, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4606a = getContext();
        this.a = ProgressDialog.show(getActivity(), getString(R.string.fetching_ewallet_deposit_history), getString(R.string.please_wait_text), true, false);
        String g = C0657Qt.g();
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).z0(g + "depositList", -1).c(C1181iv.a()).a(E0.a()).b(new N(this));
        return inflate;
    }

    public final void onStart() {
        super.onStart();
    }
}
