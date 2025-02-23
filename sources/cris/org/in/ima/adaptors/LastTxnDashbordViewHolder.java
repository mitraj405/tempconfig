package cris.org.in.ima.adaptors;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.RecentTransactionsDTO;
import defpackage.d7;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LastTxnDashbordViewHolder extends RecyclerView.Adapter<LastTxnDashbordItemHolder> {
    private static final String TAG = C1354qp.R(LastTxnDashbordViewHolder.class);
    private ArrayList<RecentTransactionsDTO> lasttxnlist;
    /* access modifiers changed from: private */
    public LasttxnrHolderListener listener;
    private Context mContext;

    public class LastTxnDashbordItemHolder extends RecyclerView.ViewHolder {
        RecentTransactionsDTO item;
        @BindView(2131364461)
        TextView tv_lasttxn_heading;
        @BindView(2131364628)
        TextView tv_tab_lasttxn_bookingdate_value;
        @BindView(2131364632)
        TextView tv_tab_lasttxn_date_value;
        @BindView(2131364634)
        TextView tv_tab_lasttxn_from_value;
        @BindView(2131364636)
        TextView tv_tab_lasttxn_pnr_value;
        @BindView(2131364638)
        TextView tv_tab_lasttxn_status_value;
        @BindView(2131364640)
        TextView tv_tab_lasttxn_to_value;
        @BindView(2131364642)
        TextView tv_tab_lasttxn_txnid_value;
        @BindView(2131364643)
        TextView tv_tab_lasttxn_view_details;

        public LastTxnDashbordItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131364643})
        public void ViewDetal(View view) {
            if (LastTxnDashbordViewHolder.this.listener != null) {
                LastTxnDashbordViewHolder.this.listener.onViewDetailClick(this.item, (Integer) view.getTag());
            }
        }
    }

    public class LastTxnDashbordItemHolder_ViewBinding implements Unbinder {
        private LastTxnDashbordItemHolder target;
        private View view7f0a0b23;

        public LastTxnDashbordItemHolder_ViewBinding(final LastTxnDashbordItemHolder lastTxnDashbordItemHolder, View view) {
            this.target = lastTxnDashbordItemHolder;
            Class cls = TextView.class;
            lastTxnDashbordItemHolder.tv_tab_lasttxn_pnr_value = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_lasttxn_pnr_value, "field 'tv_tab_lasttxn_pnr_value'", cls);
            lastTxnDashbordItemHolder.tv_tab_lasttxn_txnid_value = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_lasttxn_txnid_value, "field 'tv_tab_lasttxn_txnid_value'", cls);
            lastTxnDashbordItemHolder.tv_tab_lasttxn_status_value = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_lasttxn_status_value, "field 'tv_tab_lasttxn_status_value'", cls);
            lastTxnDashbordItemHolder.tv_tab_lasttxn_date_value = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_lasttxn_date_value, "field 'tv_tab_lasttxn_date_value'", cls);
            lastTxnDashbordItemHolder.tv_tab_lasttxn_bookingdate_value = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_lasttxn_bookingdate_value, "field 'tv_tab_lasttxn_bookingdate_value'", cls);
            lastTxnDashbordItemHolder.tv_tab_lasttxn_from_value = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_lasttxn_from_value, "field 'tv_tab_lasttxn_from_value'", cls);
            lastTxnDashbordItemHolder.tv_tab_lasttxn_to_value = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_lasttxn_to_value, "field 'tv_tab_lasttxn_to_value'", cls);
            View findRequiredView = Utils.findRequiredView(view, R.id.tv_tab_lasttxn_view_details, "field 'tv_tab_lasttxn_view_details' and method 'ViewDetal'");
            lastTxnDashbordItemHolder.tv_tab_lasttxn_view_details = (TextView) Utils.castView(findRequiredView, R.id.tv_tab_lasttxn_view_details, "field 'tv_tab_lasttxn_view_details'", cls);
            this.view7f0a0b23 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    lastTxnDashbordItemHolder.ViewDetal(view);
                }
            });
            lastTxnDashbordItemHolder.tv_lasttxn_heading = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_lasttxn_heading, "field 'tv_lasttxn_heading'", cls);
        }

        public void unbind() {
            LastTxnDashbordItemHolder lastTxnDashbordItemHolder = this.target;
            if (lastTxnDashbordItemHolder != null) {
                this.target = null;
                lastTxnDashbordItemHolder.tv_tab_lasttxn_pnr_value = null;
                lastTxnDashbordItemHolder.tv_tab_lasttxn_txnid_value = null;
                lastTxnDashbordItemHolder.tv_tab_lasttxn_status_value = null;
                lastTxnDashbordItemHolder.tv_tab_lasttxn_date_value = null;
                lastTxnDashbordItemHolder.tv_tab_lasttxn_bookingdate_value = null;
                lastTxnDashbordItemHolder.tv_tab_lasttxn_from_value = null;
                lastTxnDashbordItemHolder.tv_tab_lasttxn_to_value = null;
                lastTxnDashbordItemHolder.tv_tab_lasttxn_view_details = null;
                lastTxnDashbordItemHolder.tv_lasttxn_heading = null;
                this.view7f0a0b23.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0b23 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface LasttxnrHolderListener {
        void onViewDetailClick(RecentTransactionsDTO recentTransactionsDTO, Integer num);
    }

    public LastTxnDashbordViewHolder(Context context, ArrayList<RecentTransactionsDTO> arrayList, LasttxnrHolderListener lasttxnrHolderListener) {
        this.mContext = context;
        this.listener = lasttxnrHolderListener;
        this.lasttxnlist = arrayList;
    }

    public static String valueOf(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.toString();
    }

    public int getItemCount() {
        return this.lasttxnlist.size();
    }

    public LastTxnDashbordItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_last_txn_dashboard, (ViewGroup) null);
        LastTxnDashbordItemHolder lastTxnDashbordItemHolder = new LastTxnDashbordItemHolder(r);
        xx.O(-1, -2, r);
        return lastTxnDashbordItemHolder;
    }

    public void onBindViewHolder(LastTxnDashbordItemHolder lastTxnDashbordItemHolder, int i) {
        RecentTransactionsDTO recentTransactionsDTO = this.lasttxnlist.get(i);
        lastTxnDashbordItemHolder.item = recentTransactionsDTO;
        if (this.lasttxnlist.size() > 1) {
            lastTxnDashbordItemHolder.tv_lasttxn_heading.setVisibility(0);
            TextView textView = lastTxnDashbordItemHolder.tv_lasttxn_heading;
            textView.setText("Transaction Detail For LAP-" + (i + 1));
        } else {
            lastTxnDashbordItemHolder.tv_lasttxn_heading.setVisibility(8);
        }
        lastTxnDashbordItemHolder.tv_tab_lasttxn_txnid_value.setText(recentTransactionsDTO.getReservationId().toString());
        lastTxnDashbordItemHolder.tv_tab_lasttxn_txnid_value.setContentDescription(recentTransactionsDTO.getReservationId().toString().replace("", " ").trim());
        if (recentTransactionsDTO.getPnrNumber() != null) {
            TextView textView2 = lastTxnDashbordItemHolder.tv_tab_lasttxn_date_value;
            Date boardingDate = recentTransactionsDTO.getBoardingDate();
            AlertDialog alertDialog = C0535I5.f3619a;
            textView2.setText(new SimpleDateFormat("dd MMM, yyyy | HH:mm").format(boardingDate));
        } else {
            lastTxnDashbordItemHolder.tv_tab_lasttxn_date_value.setText(C0535I5.F(recentTransactionsDTO.getBoardingDate()));
        }
        lastTxnDashbordItemHolder.tv_tab_lasttxn_from_value.setText(recentTransactionsDTO.getFromStation());
        lastTxnDashbordItemHolder.tv_tab_lasttxn_to_value.setText(recentTransactionsDTO.getToStation());
        if (recentTransactionsDTO.getBookingStatus().equalsIgnoreCase("Booked")) {
            lastTxnDashbordItemHolder.tv_tab_lasttxn_status_value.setText("Booked");
            TextView textView3 = lastTxnDashbordItemHolder.tv_tab_lasttxn_status_value;
            Context context = this.mContext;
            Object obj = d7.a;
            textView3.setTextColor(d7.b.a(context, R.color.green));
        } else {
            lastTxnDashbordItemHolder.tv_tab_lasttxn_status_value.setText(recentTransactionsDTO.getBookingStatus());
            TextView textView4 = lastTxnDashbordItemHolder.tv_tab_lasttxn_status_value;
            Context context2 = this.mContext;
            Object obj2 = d7.a;
            textView4.setTextColor(d7.b.a(context2, R.color.red));
        }
        if (recentTransactionsDTO.getPnrNumber() != null) {
            lastTxnDashbordItemHolder.tv_tab_lasttxn_pnr_value.setText(recentTransactionsDTO.getPnrNumber());
            lastTxnDashbordItemHolder.tv_tab_lasttxn_pnr_value.setContentDescription(recentTransactionsDTO.getPnrNumber().replace("", " ").trim());
        } else {
            lastTxnDashbordItemHolder.tv_tab_lasttxn_pnr_value.setText("N/A");
        }
        if (recentTransactionsDTO.getBookingDate() != null) {
            lastTxnDashbordItemHolder.tv_tab_lasttxn_bookingdate_value.setText(new SimpleDateFormat("dd MMM, yyyy | HH:mm").format(recentTransactionsDTO.getBookingDate()));
        }
        if (i == this.lasttxnlist.size() - 1) {
            lastTxnDashbordItemHolder.tv_tab_lasttxn_view_details.setVisibility(8);
        } else {
            lastTxnDashbordItemHolder.tv_tab_lasttxn_view_details.setVisibility(8);
        }
    }
}
