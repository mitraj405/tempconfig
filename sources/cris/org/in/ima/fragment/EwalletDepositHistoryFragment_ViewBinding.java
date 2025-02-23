package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class EwalletDepositHistoryFragment_ViewBinding implements Unbinder {
    public EwalletDepositHistoryFragment a;

    public EwalletDepositHistoryFragment_ViewBinding(EwalletDepositHistoryFragment ewalletDepositHistoryFragment, View view) {
        this.a = ewalletDepositHistoryFragment;
        ewalletDepositHistoryFragment.txnList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.tnx_list, "field 'txnList'", RecyclerView.class);
        ewalletDepositHistoryFragment.emptyList = (TextView) Utils.findRequiredViewAsType(view, R.id.ewalet_empty_list, "field 'emptyList'", TextView.class);
    }

    public final void unbind() {
        EwalletDepositHistoryFragment ewalletDepositHistoryFragment = this.a;
        if (ewalletDepositHistoryFragment != null) {
            this.a = null;
            ewalletDepositHistoryFragment.txnList = null;
            ewalletDepositHistoryFragment.emptyList = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
