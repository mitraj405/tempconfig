package cris.org.in.ima.payment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import cris.org.in.prs.ima.R;
import java.text.DecimalFormat;

public class DepositDataFragment extends Fragment {
    public O8 a;

    /* renamed from: a  reason: collision with other field name */
    public Context f5357a;
    @BindView(2131361943)
    TextView amountDeposited;
    @BindView(2131362392)
    TextView depositDate;
    @BindView(2131363597)
    TextView rechargeStatus;
    @BindView(2131364214)
    TextView transactionId;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ewallet_deposit_data, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f5357a = getContext();
        O8 o8 = (O8) getArguments().getSerializable("statusDTO");
        this.a = o8;
        this.transactionId.setText(Long.toString(o8.getTxnId()));
        this.depositDate.setText(C0535I5.j(this.a.getTimestamp()));
        this.amountDeposited.setText(new DecimalFormat(getString(R.string.format_int_rupees)).format((long) this.a.getAmount()));
        this.rechargeStatus.setText(Short.toString(this.a.getStatus()));
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        C0535I5.u();
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }
}
