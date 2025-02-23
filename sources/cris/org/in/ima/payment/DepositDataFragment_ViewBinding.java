package cris.org.in.ima.payment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class DepositDataFragment_ViewBinding implements Unbinder {
    public DepositDataFragment a;

    public DepositDataFragment_ViewBinding(DepositDataFragment depositDataFragment, View view) {
        this.a = depositDataFragment;
        Class cls = TextView.class;
        depositDataFragment.transactionId = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_id, "field 'transactionId'", cls);
        depositDataFragment.depositDate = (TextView) Utils.findRequiredViewAsType(view, R.id.deposit_date, "field 'depositDate'", cls);
        depositDataFragment.amountDeposited = (TextView) Utils.findRequiredViewAsType(view, R.id.amount_deposited, "field 'amountDeposited'", cls);
        depositDataFragment.rechargeStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.recharge_status, "field 'rechargeStatus'", cls);
    }

    public final void unbind() {
        DepositDataFragment depositDataFragment = this.a;
        if (depositDataFragment != null) {
            this.a = null;
            depositDataFragment.transactionId = null;
            depositDataFragment.depositDate = null;
            depositDataFragment.amountDeposited = null;
            depositDataFragment.rechargeStatus = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
