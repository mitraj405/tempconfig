package cris.org.in.ima.view_holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public final class AccStatementViewHolder extends RecyclerView.Adapter<ViewHolder> {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<C1486xs> f5375a;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362050)
        TextView bookTxnId;
        @BindView(2131362261)
        TextView closingBalance;
        @BindView(2131364212)
        TextView transactionAmount;
        @BindView(2131364213)
        TextView transactionDate;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            Class cls = TextView.class;
            viewHolder.transactionDate = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_date, "field 'transactionDate'", cls);
            viewHolder.closingBalance = (TextView) Utils.findRequiredViewAsType(view, R.id.closing_balance, "field 'closingBalance'", cls);
            viewHolder.bookTxnId = (TextView) Utils.findRequiredViewAsType(view, R.id.bookTxnId, "field 'bookTxnId'", cls);
            viewHolder.transactionAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_amount, "field 'transactionAmount'", cls);
        }

        public final void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder != null) {
                this.a = null;
                viewHolder.transactionDate = null;
                viewHolder.closingBalance = null;
                viewHolder.bookTxnId = null;
                viewHolder.transactionAmount = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    static {
        C1354qp.R(AccStatementViewHolder.class);
    }

    public AccStatementViewHolder(Context context, ArrayList<C1486xs> arrayList) {
        this.a = context;
        this.f5375a = arrayList;
    }

    public final int getItemCount() {
        ArrayList<C1486xs> arrayList = this.f5375a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        C1486xs xsVar = this.f5375a.get(i);
        if (xsVar.getDebitType().equalsIgnoreCase("D")) {
            viewHolder2.transactionAmount.setText(String.format(this.a.getResources().getString(R.string.format_credit_debit_rupees), new Object[]{"-", xsVar.getAmount()}));
            viewHolder2.transactionAmount.setTextColor(-65536);
        } else if (xsVar.getDebitType().equalsIgnoreCase("C")) {
            viewHolder2.transactionAmount.setText(String.format(this.a.getResources().getString(R.string.format_credit_debit_rupees), new Object[]{"+", xsVar.getAmount()}));
            viewHolder2.transactionAmount.setTextColor(-16711936);
        } else {
            viewHolder2.transactionAmount.setText(String.format(this.a.getResources().getString(R.string.format_credit_debit_rupees), new Object[]{"", xsVar.getAmount()}));
        }
        viewHolder2.transactionDate.setText(C0535I5.j(xsVar.getTxnDate()));
        viewHolder2.bookTxnId.setText(String.valueOf(xsVar.getDescription()));
        viewHolder2.closingBalance.setText(String.format(this.a.getResources().getString(R.string.format_credit_debit_rupees), new Object[]{"", xsVar.getClosingBalance()}));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.fragment_item_detail, (ViewGroup) null);
        this.a = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
