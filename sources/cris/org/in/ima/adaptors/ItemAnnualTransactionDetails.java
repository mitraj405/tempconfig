package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.prs.ima.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ItemAnnualTransactionDetails extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(ItemAnnualTransactionDetails.class);
    static DateFormat format;
    private Context mContext;
    private ArrayList<C1336px> softAnnualSummaryDTOList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131363131)
        TextView accountEnd;
        @BindView(2131363132)
        TextView accountStart;
        @BindView(2131363133)
        TextView annaulExpiredPoint;
        @BindView(2131363134)
        TextView annualPartnerPoint;
        @BindView(2131363135)
        TextView annualPurchasePoint;
        @BindView(2131363136)
        TextView annualTravelPoint;
        @BindView(2131363142)
        TextView expiryPoint;
        @BindView(2131363152)
        TextView redeemPoint;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            Class cls = TextView.class;
            viewHolder.accountStart = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_account_start, "field 'accountStart'", cls);
            viewHolder.accountEnd = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_account_end, "field 'accountEnd'", cls);
            viewHolder.annualTravelPoint = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_annual_travel_point, "field 'annualTravelPoint'", cls);
            viewHolder.annualPartnerPoint = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_annual_partner_point, "field 'annualPartnerPoint'", cls);
            viewHolder.annualPurchasePoint = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_annual_purchase_point, "field 'annualPurchasePoint'", cls);
            viewHolder.redeemPoint = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_redeem_point, "field 'redeemPoint'", cls);
            viewHolder.annaulExpiredPoint = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_annual_expired_point, "field 'annaulExpiredPoint'", cls);
            viewHolder.expiryPoint = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_expiry_point, "field 'expiryPoint'", cls);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.accountStart = null;
                viewHolder.accountEnd = null;
                viewHolder.annualTravelPoint = null;
                viewHolder.annualPartnerPoint = null;
                viewHolder.annualPurchasePoint = null;
                viewHolder.redeemPoint = null;
                viewHolder.annaulExpiredPoint = null;
                viewHolder.expiryPoint = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public ItemAnnualTransactionDetails(Context context, ArrayList<C1336px> arrayList) {
        this.mContext = context;
        this.softAnnualSummaryDTOList = arrayList;
    }

    public int getItemCount() {
        ArrayList<C1336px> arrayList = this.softAnnualSummaryDTOList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s = C1058d.s(viewGroup, R.layout.item_annual_loyality_transaction_details, viewGroup, false);
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            format = new SimpleDateFormat("dd MMM yyyy", new Locale("hi", "IN"));
        } else {
            format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        }
        return new ViewHolder(s);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C1336px pxVar = this.softAnnualSummaryDTOList.get(i);
        if (pxVar != null) {
            pxVar.toString();
            if (pxVar.getYearStartDate() != null) {
                viewHolder.accountStart.setText(format.format(Long.valueOf(pxVar.getYearStartDate().getTime())));
            } else {
                viewHolder.accountStart.setVisibility(8);
            }
            if (pxVar.getYearEndDate() != null) {
                viewHolder.accountEnd.setText(format.format(Long.valueOf(pxVar.getYearEndDate().getTime())));
            } else {
                viewHolder.accountEnd.setVisibility(8);
            }
            viewHolder.annualTravelPoint.setText(String.valueOf(pxVar.getTravelPointsRedeemed().toString()));
            viewHolder.annualPartnerPoint.setText(String.valueOf(pxVar.getPartnerPointsRedeemed().toString()));
            viewHolder.annualPurchasePoint.setText(String.valueOf(pxVar.getPurchasedPoints().toString()));
            viewHolder.redeemPoint.setText(String.valueOf(pxVar.getTotalPointsRedeemedInCurrentYear().toString()));
            viewHolder.annaulExpiredPoint.setText(String.valueOf(pxVar.getAnnualPointsExpired().toString()));
            if (pxVar.getAnnualExpiryDate() != null) {
                viewHolder.expiryPoint.setText(format.format(Long.valueOf(pxVar.getAnnualExpiryDate().getTime())));
            } else {
                viewHolder.expiryPoint.setVisibility(8);
            }
        }
    }
}
