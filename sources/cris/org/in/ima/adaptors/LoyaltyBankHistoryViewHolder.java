package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class LoyaltyBankHistoryViewHolder extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(LoyaltyBankHistoryViewHolder.class);
    Context mContext;
    private ArrayList<C0471CB> userConfigurablesDTOS;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362626)
        LinearLayout expend_layout;
        @BindView(2131363822)
        RecyclerView rv_loyalty_bank_detail;
        @BindView(2131364473)
        TextView tv_loyalty_bank;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131363114})
        public void onTicketClick(View view) {
            if (this.expend_layout.getVisibility() == 8) {
                this.expend_layout.setVisibility(0);
            } else {
                this.expend_layout.setVisibility(8);
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a052a;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.tv_loyalty_bank = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_loyalty_bank, "field 'tv_loyalty_bank'", TextView.class);
            viewHolder.expend_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.expend_layout, "field 'expend_layout'", LinearLayout.class);
            viewHolder.rv_loyalty_bank_detail = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_loyalty_bank_detail, "field 'rv_loyalty_bank_detail'", RecyclerView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.loyalty_bank_rl, "method 'onTicketClick'");
            this.view7f0a052a = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.onTicketClick(view);
                }
            });
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.tv_loyalty_bank = null;
                viewHolder.expend_layout = null;
                viewHolder.rv_loyalty_bank_detail = null;
                this.view7f0a052a.setOnClickListener((View.OnClickListener) null);
                this.view7f0a052a = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public LoyaltyBankHistoryViewHolder(Context context, ArrayList<C0471CB> arrayList) {
        this.userConfigurablesDTOS = arrayList;
        this.mContext = context;
    }

    public int getItemCount() {
        ArrayList<C0471CB> arrayList = this.userConfigurablesDTOS;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_loyalty_bank_history, (ViewGroup) null);
        this.mContext = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tv_loyalty_bank.setText(this.userConfigurablesDTOS.get(i).getSoftAccountSummaryDTO().getBankName());
        viewHolder.rv_loyalty_bank_detail.setLayoutManager(new LinearLayoutManager(this.mContext));
        viewHolder.rv_loyalty_bank_detail.setAdapter(new LoyaltyProfileDetailViewHolder(this.mContext, this.userConfigurablesDTOS));
    }
}
