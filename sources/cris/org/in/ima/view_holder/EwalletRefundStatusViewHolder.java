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

public final class EwalletRefundStatusViewHolder extends RecyclerView.Adapter<ViewHolder> {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<C1194jb> f5395a;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131363788)
        RelativeLayout rs_reason_rl;
        @BindView(2131363789)
        TextView rs_reason_tv;
        @BindView(2131363790)
        RelativeLayout rs_refund_amount_rl;
        @BindView(2131363791)
        TextView rs_refund_amount_tv;
        @BindView(2131363792)
        RelativeLayout rs_refund_date_rl;
        @BindView(2131363793)
        TextView rs_refund_date_tv;
        @BindView(2131363794)
        RelativeLayout rs_refund_status_rl;
        @BindView(2131363795)
        TextView rs_refund_status_tv;
        @BindView(2131363799)
        RelativeLayout rs_transaction_id_rl;
        @BindView(2131363800)
        TextView rs_transaction_id_tv;

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
            viewHolder.rs_transaction_id_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rs_transaction_id_rl, "field 'rs_transaction_id_rl'", cls);
            Class cls2 = TextView.class;
            viewHolder.rs_transaction_id_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.rs_transaction_id_tv, "field 'rs_transaction_id_tv'", cls2);
            viewHolder.rs_refund_amount_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rs_refund_amount_rl, "field 'rs_refund_amount_rl'", cls);
            viewHolder.rs_refund_amount_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.rs_refund_amount_tv, "field 'rs_refund_amount_tv'", cls2);
            viewHolder.rs_reason_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rs_reason_rl, "field 'rs_reason_rl'", cls);
            viewHolder.rs_reason_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.rs_reason_tv, "field 'rs_reason_tv'", cls2);
            viewHolder.rs_refund_status_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rs_refund_status_rl, "field 'rs_refund_status_rl'", cls);
            viewHolder.rs_refund_status_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.rs_refund_status_tv, "field 'rs_refund_status_tv'", cls2);
            viewHolder.rs_refund_date_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rs_refund_date_rl, "field 'rs_refund_date_rl'", cls);
            viewHolder.rs_refund_date_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.rs_refund_date_tv, "field 'rs_refund_date_tv'", cls2);
        }

        public final void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder != null) {
                this.a = null;
                viewHolder.rs_transaction_id_rl = null;
                viewHolder.rs_transaction_id_tv = null;
                viewHolder.rs_refund_amount_rl = null;
                viewHolder.rs_refund_amount_tv = null;
                viewHolder.rs_reason_rl = null;
                viewHolder.rs_reason_tv = null;
                viewHolder.rs_refund_status_rl = null;
                viewHolder.rs_refund_status_tv = null;
                viewHolder.rs_refund_date_rl = null;
                viewHolder.rs_refund_date_tv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    static {
        C1354qp.R(EwalletRefundStatusViewHolder.class);
    }

    public EwalletRefundStatusViewHolder(Context context, ArrayList<C1194jb> arrayList) {
        this.a = context;
        this.f5395a = arrayList;
    }

    public final int getItemCount() {
        ArrayList<C1194jb> arrayList = this.f5395a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        C1194jb jbVar = this.f5395a.get(i);
        if (jbVar.getTxnId() != null) {
            viewHolder2.rs_transaction_id_tv.setText(jbVar.getTxnId().toString());
        }
        if (jbVar.getAmount() != null) {
            viewHolder2.rs_refund_amount_tv.setText(String.format(this.a.getResources().getString(R.string.format_credit_debit_rupees), new Object[]{"", jbVar.getAmount()}));
        }
        if (jbVar.getReason() != null) {
            viewHolder2.rs_reason_tv.setText(jbVar.getReason());
        }
        if (jbVar.getRefundStatus() != null) {
            viewHolder2.rs_refund_status_tv.setText(jbVar.getRefundStatus());
        }
        if (jbVar.getRefundDate() != null) {
            viewHolder2.rs_refund_date_tv.setText(C0535I5.j(jbVar.getRefundDate()));
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.fragment_ewalletrefundstatus_item, (ViewGroup) null);
        this.a = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
