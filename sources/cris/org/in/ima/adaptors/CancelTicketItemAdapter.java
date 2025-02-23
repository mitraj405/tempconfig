package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.listener.CancelTicketListener;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CancelTicketItemAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(CancelTicketItemAdapter.class);
    private ArrayList<BookingResponseDTO> cancelTktList;
    /* access modifiers changed from: private */
    public CancelTicketListener mCancelTicketListener;
    Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362060)
        TextView bookingdate;
        @BindView(2131364324)
        CardView cancelTicket;
        @BindView(2131362715)
        TextView fromcitycode;
        @BindView(2131362920)
        TextView jrnyDate;
        @BindView(2131363220)
        LinearLayout metroTicketLl;
        @BindView(2131363506)
        TextView pnr;
        BookingResponseDTO tkt;
        @BindView(2131364169)
        TextView tocitycode;
        @BindView(2131364201)
        TextView trainName;
        @BindView(2131364203)
        TextView trainno;
        @BindView(2131364828)
        TextView view_dmrc_tickets_detail;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
            this.cancelTicket.setVisibility(0);
        }

        @OnClick({2131364324})
        public void onCancelClick(View view) {
            CancelTicketItemAdapter.this.mCancelTicketListener.a(this.tkt);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a09e4;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            Class cls = TextView.class;
            viewHolder.pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnr'", cls);
            viewHolder.trainno = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainno'", cls);
            viewHolder.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
            View findRequiredView = Utils.findRequiredView(view, R.id.tv_cancel_ticket, "field 'cancelTicket' and method 'onCancelClick'");
            viewHolder.cancelTicket = (CardView) Utils.castView(findRequiredView, R.id.tv_cancel_ticket, "field 'cancelTicket'", CardView.class);
            this.view7f0a09e4 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.onCancelClick(view);
                }
            });
            viewHolder.jrnyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'jrnyDate'", cls);
            viewHolder.tocitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'tocitycode'", cls);
            viewHolder.fromcitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcidtycode, "field 'fromcitycode'", cls);
            viewHolder.bookingdate = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_date, "field 'bookingdate'", cls);
            viewHolder.view_dmrc_tickets_detail = (TextView) Utils.findRequiredViewAsType(view, R.id.view_dmrc_tickets_detail, "field 'view_dmrc_tickets_detail'", cls);
            viewHolder.metroTicketLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.metro_ticket_ll, "field 'metroTicketLl'", LinearLayout.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.pnr = null;
                viewHolder.trainno = null;
                viewHolder.trainName = null;
                viewHolder.cancelTicket = null;
                viewHolder.jrnyDate = null;
                viewHolder.tocitycode = null;
                viewHolder.fromcitycode = null;
                viewHolder.bookingdate = null;
                viewHolder.view_dmrc_tickets_detail = null;
                viewHolder.metroTicketLl = null;
                this.view7f0a09e4.setOnClickListener((View.OnClickListener) null);
                this.view7f0a09e4 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public CancelTicketItemAdapter(Context context, CancelTicketListener cancelTicketListener, ArrayList<BookingResponseDTO> arrayList) {
        this.mContext = context;
        this.mCancelTicketListener = cancelTicketListener;
        this.cancelTktList = arrayList;
    }

    public int getItemCount() {
        ArrayList<BookingResponseDTO> arrayList = this.cancelTktList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_cancel_booking, (ViewGroup) null);
        this.mContext = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String str;
        StationDb stationDb = C0793b1.a.f3911a;
        viewHolder.tkt = this.cancelTktList.get(i);
        viewHolder.pnr.setText(this.cancelTktList.get(i).getPnrNumber());
        viewHolder.trainno.setText(this.cancelTktList.get(i).getTrainNumber());
        viewHolder.trainName.setText(this.cancelTktList.get(i).getTrainName());
        viewHolder.jrnyDate.setText(C0535I5.U(this.cancelTktList.get(i).getJourneyDate()));
        viewHolder.fromcitycode.setText(stationDb.m(this.cancelTktList.get(i).getFromStn()));
        viewHolder.tocitycode.setText(stationDb.m(this.cancelTktList.get(i).getDestStn()));
        TextView textView = viewHolder.bookingdate;
        Date bookingDate = this.cancelTktList.get(i).getBookingDate();
        if (bookingDate == null) {
            str = "";
        } else {
            new SimpleDateFormat("yyyy-MM-dd");
            str = new SimpleDateFormat("dd, EEE, MMM, yyyy").format(bookingDate);
        }
        textView.setText(str);
        if (viewHolder.tkt.isMetroServiceOpted()) {
            viewHolder.metroTicketLl.setVisibility(0);
            viewHolder.view_dmrc_tickets_detail.setText(this.mContext.getString(R.string.view_dmrc_ticket_detail));
        } else if (!viewHolder.tkt.isEligibleForMetro() || viewHolder.tkt.isMetroServiceOpted()) {
            viewHolder.metroTicketLl.setVisibility(8);
        } else {
            viewHolder.view_dmrc_tickets_detail.setText(this.mContext.getString(R.string.eligible_for_dmrc_ticket_detail));
        }
    }
}
