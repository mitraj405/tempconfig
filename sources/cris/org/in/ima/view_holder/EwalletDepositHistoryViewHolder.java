package cris.org.in.ima.view_holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public final class EwalletDepositHistoryViewHolder extends RecyclerView.Adapter<ViewHolder> {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<C1465ws> f5394a;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131361860)
        RelativeLayout account_recharge_status_rl;
        @BindView(2131361861)
        TextView account_recharge_status_tv;
        @BindView(2131361944)
        RelativeLayout amount_deposited_rl;
        @BindView(2131361945)
        TextView amount_deposited_tv;
        @BindView(2131362393)
        RelativeLayout deposit_date_rl;
        @BindView(2131362394)
        TextView deposit_date_tv;
        @BindView(2131363470)
        RelativeLayout pay_refund_status_rl;
        @BindView(2131363471)
        TextView pay_refund_status_tv;
        @BindView(2131363487)
        RelativeLayout payment_option_rl;
        @BindView(2131363488)
        TextView payment_option_tv;
        @BindView(2131364217)
        RelativeLayout transaction_id_rl;
        @BindView(2131364218)
        TextView transaction_id_tv;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            Class cls = RelativeLayout.class;
            viewHolder.transaction_id_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.transaction_id_rl, "field 'transaction_id_rl'", cls);
            Class cls2 = TextView.class;
            viewHolder.transaction_id_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_id_tv, "field 'transaction_id_tv'", cls2);
            viewHolder.payment_option_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.payment_option_rl, "field 'payment_option_rl'", cls);
            viewHolder.payment_option_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.payment_option_tv, "field 'payment_option_tv'", cls2);
            viewHolder.account_recharge_status_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.account_recharge_status_rl, "field 'account_recharge_status_rl'", cls);
            viewHolder.account_recharge_status_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.account_recharge_status_tv, "field 'account_recharge_status_tv'", cls2);
            viewHolder.deposit_date_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.deposit_date_rl, "field 'deposit_date_rl'", cls);
            viewHolder.deposit_date_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.deposit_date_tv, "field 'deposit_date_tv'", cls2);
            viewHolder.amount_deposited_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.amount_deposited_rl, "field 'amount_deposited_rl'", cls);
            viewHolder.amount_deposited_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.amount_deposited_tv, "field 'amount_deposited_tv'", cls2);
            viewHolder.pay_refund_status_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.pay_refund_status_rl, "field 'pay_refund_status_rl'", cls);
            viewHolder.pay_refund_status_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.pay_refund_status_tv, "field 'pay_refund_status_tv'", cls2);
        }

        public final void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder != null) {
                this.a = null;
                viewHolder.transaction_id_rl = null;
                viewHolder.transaction_id_tv = null;
                viewHolder.payment_option_rl = null;
                viewHolder.payment_option_tv = null;
                viewHolder.account_recharge_status_rl = null;
                viewHolder.account_recharge_status_tv = null;
                viewHolder.deposit_date_rl = null;
                viewHolder.deposit_date_tv = null;
                viewHolder.amount_deposited_rl = null;
                viewHolder.amount_deposited_tv = null;
                viewHolder.pay_refund_status_rl = null;
                viewHolder.pay_refund_status_tv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    static {
        C1354qp.R(EwalletDepositHistoryViewHolder.class);
    }

    public EwalletDepositHistoryViewHolder(Context context, ArrayList<C1465ws> arrayList) {
        this.a = context;
        this.f5394a = arrayList;
    }

    public final int getItemCount() {
        ArrayList<C1465ws> arrayList = this.f5394a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        C1465ws wsVar = this.f5394a.get(i);
        if (wsVar.getTxnId() != null) {
            viewHolder2.transaction_id_tv.setText(wsVar.getTxnId().toString());
        }
        if (wsVar.getPaymentOption() != null) {
            viewHolder2.payment_option_tv.setText(wsVar.getPaymentOption());
        }
        if (wsVar.getRechargeStatus() != null) {
            if (wsVar.getRechargeStatus().contains("rechargeSuccess")) {
                xx.P(this.a, R.string.dh_recharge_success, viewHolder2.account_recharge_status_tv);
            } else if (wsVar.getRechargeStatus().contains("rechargeFail")) {
                xx.P(this.a, R.string.dh_recharge_failed, viewHolder2.account_recharge_status_tv);
            } else {
                viewHolder2.account_recharge_status_tv.setText(wsVar.getRechargeStatus());
            }
        }
        if (wsVar.getDepositDate().toString() != null) {
            viewHolder2.deposit_date_tv.setText(C0535I5.j(wsVar.getDepositDate()));
        }
        if (wsVar.getAmount() != null) {
            viewHolder2.amount_deposited_tv.setText(String.format(this.a.getResources().getString(R.string.format_credit_debit_rupees), new Object[]{"", wsVar.getAmount()}));
        }
        if (wsVar.getRefundStatus() != null) {
            viewHolder2.pay_refund_status_tv.setText(wsVar.getRefundStatus());
        } else {
            viewHolder2.pay_refund_status_tv.setText("---");
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.fragment_ewalletdeposithistory_item, (ViewGroup) null);
        this.a = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
