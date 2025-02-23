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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ItemIRCTCTransactionDetails extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(ItemIRCTCTransactionDetails.class);
    private Context mContext;
    private ArrayList<C1377rx> softIRCTCTxnDetailsDTOList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131363141)
        TextView dBooking;
        @BindView(2131363154)
        TextView fromStation;
        @BindView(2131363143)
        TextView jDate;
        @BindView(2131363147)
        TextView pnr;
        @BindView(2131363149)
        TextView points;
        @BindView(2131363156)
        TextView status;
        @BindView(2131363155)
        TextView toStation;
        @BindView(2131363157)
        TextView trainNo;

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
            viewHolder.pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_pnr, "field 'pnr'", cls);
            viewHolder.trainNo = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_train_no, "field 'trainNo'", cls);
            viewHolder.jDate = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_journey_date, "field 'jDate'", cls);
            viewHolder.toStation = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_station_to, "field 'toStation'", cls);
            viewHolder.fromStation = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_station_from, "field 'fromStation'", cls);
            viewHolder.points = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_points, "field 'points'", cls);
            viewHolder.status = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_status, "field 'status'", cls);
            viewHolder.dBooking = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_dobooking, "field 'dBooking'", cls);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.pnr = null;
                viewHolder.trainNo = null;
                viewHolder.jDate = null;
                viewHolder.toStation = null;
                viewHolder.fromStation = null;
                viewHolder.points = null;
                viewHolder.status = null;
                viewHolder.dBooking = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public ItemIRCTCTransactionDetails(Context context, ArrayList<C1377rx> arrayList) {
        this.mContext = context;
        this.softIRCTCTxnDetailsDTOList = arrayList;
    }

    public int getItemCount() {
        ArrayList<C1377rx> arrayList = this.softIRCTCTxnDetailsDTOList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s = C1058d.s(viewGroup, R.layout.item_irctc_transaction_details, viewGroup, false);
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            ItemSBICoBrandCard.format = new SimpleDateFormat("dd MMM yyyy", new Locale("hi", "IN"));
        } else {
            ItemSBICoBrandCard.format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        }
        return new ViewHolder(s);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C1377rx rxVar = this.softIRCTCTxnDetailsDTOList.get(i);
        if (rxVar != null) {
            rxVar.toString();
            viewHolder.pnr.setText(rxVar.getPnrNumber());
            viewHolder.trainNo.setText(rxVar.getTrainNumber());
            viewHolder.jDate.setText(ItemSBICoBrandCard.format.format(Long.valueOf(rxVar.getJourneyDate().getTime())));
            viewHolder.fromStation.setText(rxVar.getFromStation());
            viewHolder.toStation.setText(rxVar.getToStation());
            viewHolder.points.setText(rxVar.getPoints().toString());
            viewHolder.status.setText(rxVar.getTxnStatus());
            viewHolder.dBooking.setText(ItemSBICoBrandCard.format.format(Long.valueOf(rxVar.getTxnDate().getTime())));
        }
    }
}
