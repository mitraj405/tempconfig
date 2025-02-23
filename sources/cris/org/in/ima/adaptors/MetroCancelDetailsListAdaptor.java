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
import cris.org.in.prs.ima.R;
import java.util.List;

public class MetroCancelDetailsListAdaptor extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    private final List<C1283nl> metroPassengerList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362120)
        TextView cancellation_id;
        @BindView(2131362332)
        TextView current_status;
        @BindView(2131363572)
        TextView qrTicket_no;

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
            viewHolder.qrTicket_no = (TextView) Utils.findRequiredViewAsType(view, R.id.qrTicket_no, "field 'qrTicket_no'", cls);
            viewHolder.current_status = (TextView) Utils.findRequiredViewAsType(view, R.id.current_status, "field 'current_status'", cls);
            viewHolder.cancellation_id = (TextView) Utils.findRequiredViewAsType(view, R.id.cancellation_id, "field 'cancellation_id'", cls);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.qrTicket_no = null;
                viewHolder.current_status = null;
                viewHolder.cancellation_id = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public MetroCancelDetailsListAdaptor(Context context2, List<C1283nl> list) {
        this.context = context2;
        this.metroPassengerList = list;
    }

    public int getItemCount() {
        return this.metroPassengerList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.metro_cancel_details_item, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C1283nl nlVar = this.metroPassengerList.get(i);
        viewHolder.qrTicket_no.setText(nlVar.getMetroQrTicketNo());
        nlVar.getCancellationId();
        if (nlVar.getCancelStatusString() != null) {
            viewHolder.current_status.setText(nlVar.getCancelStatusString());
            viewHolder.cancellation_id.setText(String.valueOf(nlVar.getCancellationId()));
            return;
        }
        viewHolder.current_status.setText("CNF");
        viewHolder.cancellation_id.setText("");
    }
}
