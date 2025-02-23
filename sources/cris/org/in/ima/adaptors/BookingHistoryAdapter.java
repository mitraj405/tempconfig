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

public class BookingHistoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131364324)
        TextView cancelTicket;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
            this.cancelTicket.setVisibility(8);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.cancelTicket = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel_ticket, "field 'cancelTicket'", TextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.cancelTicket = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public BookingHistoryAdapter(Context context) {
        this.mContext = context;
    }

    public int getItemCount() {
        return 10;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(C1058d.r(viewGroup, R.layout.item_my_booking_history, (ViewGroup) null));
    }
}
