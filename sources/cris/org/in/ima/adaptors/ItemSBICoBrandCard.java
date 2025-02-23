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

public class ItemSBICoBrandCard extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(ItemSBICoBrandCard.class);
    static DateFormat format;
    private Context mContext;
    private ArrayList<C1377rx> softIRCTCTxnDetailsDTOList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131363140)
        TextView details;
        @BindView(2131363149)
        TextView points;
        @BindView(2131363156)
        TextView status;
        @BindView(2131363160)
        TextView txnDate;

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
            viewHolder.points = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_points, "field 'points'", cls);
            viewHolder.status = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_status, "field 'status'", cls);
            viewHolder.txnDate = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_txndate, "field 'txnDate'", cls);
            viewHolder.details = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_details, "field 'details'", cls);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.points = null;
                viewHolder.status = null;
                viewHolder.txnDate = null;
                viewHolder.details = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public ItemSBICoBrandCard(Context context, ArrayList<C1377rx> arrayList) {
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
        View s = C1058d.s(viewGroup, R.layout.item_sbi_cobrand_card, viewGroup, false);
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            format = new SimpleDateFormat("dd MMM yyyy", new Locale("hi", "IN"));
        } else {
            format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        }
        return new ViewHolder(s);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C1377rx rxVar = this.softIRCTCTxnDetailsDTOList.get(i);
        if (rxVar != null) {
            if (rxVar.getTxnDate() != null) {
                viewHolder.txnDate.setText(format.format(Long.valueOf(rxVar.getTxnDate().getTime())));
            } else {
                viewHolder.txnDate.setText("");
            }
            viewHolder.status.setText(rxVar.getTxnStatus());
            viewHolder.details.setText(rxVar.getTxnDescription());
            viewHolder.points.setText(String.valueOf(rxVar.getPoints()));
        }
    }
}
