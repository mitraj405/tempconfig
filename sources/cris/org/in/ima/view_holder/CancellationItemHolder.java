package cris.org.in.ima.view_holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.adaptors.MetroCancelDetailsListAdaptor;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.fragment.CancellationHistoryFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.ArrayList;

public final class CancellationItemHolder extends RecyclerView.Adapter<ViewHolder> {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Context f5377a;

    /* renamed from: a  reason: collision with other field name */
    public final a f5378a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<BookingResponseDTO> f5379a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5380a = false;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131361806)
        TextView No_of_passengers;

        /* renamed from: a  reason: collision with other field name */
        public BookingResponseDTO f5381a;
        @BindView(2131362120)
        TextView cancellationId;
        @BindView(2131362426)
        LinearLayout dmrc_no_of_cancelled_psng;
        @BindView(2131362428)
        LinearLayout dmrc_status;
        @BindView(2131362429)
        TextView dmrc_status_pending;
        @BindView(2131362436)
        TextView dmrc_total_fare;
        @BindView(2131362624)
        LinearLayout expandLayout;
        @BindView(2131362716)
        TextView fromCity;
        @BindView(2131362920)
        TextView journeyDate;
        @BindView(2131362926)
        TextView journy_date;
        @BindView(2131363824)
        RecyclerView metroCancelDetailsList;
        @BindView(2131363217)
        TextView metro_sercive_opted;
        @BindView(2131363218)
        LinearLayout metro_service_details;
        @BindView(2131363331)
        TextView no_of_cancelled_psng;
        @BindView(2131363825)
        RecyclerView psgnList;
        @BindView(2131363609)
        TextView refundAmount;
        @BindView(2131363947)
        TextView service_id;
        @BindView(2131364131)
        TextView ti_refund_amount;
        @BindView(2131364132)
        LinearLayout ti_refund_amount_layout;
        @BindView(2131364133)
        TextView ticketAmount;
        @BindView(2131364135)
        LinearLayout ticket_amount_paid;
        @BindView(2131364138)
        CardView tktDetails;
        @BindView(2131364157)
        TextView tktdetails1;
        @BindView(2131364169)
        TextView toCity;
        @BindView(2131364201)
        TextView trainName;
        @BindView(2131364203)
        TextView trainNumber;
        @BindView(2131364215)
        TextView transactionIdBot;
        @BindView(2131364839)
        View viewline;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131364138})
        public void TicketDtls(View view) {
            CancellationItemHolder cancellationItemHolder = CancellationItemHolder.this;
            if (cancellationItemHolder.f5380a) {
                this.expandLayout.setVisibility(8);
                this.psgnList.setVisibility(8);
                cancellationItemHolder.f5380a = false;
                int i = CancellationItemHolder.a;
                return;
            }
            a aVar = cancellationItemHolder.f5378a;
            if (aVar != null) {
                ((CancellationHistoryFragment.a) aVar).a(this.f5381a, view);
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public View a;

        /* renamed from: a  reason: collision with other field name */
        public ViewHolder f5382a;

        /* compiled from: CancellationItemHolder$ViewHolder_ViewBinding */
        public class a extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public a(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.TicketDtls(view);
            }
        }

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f5382a = viewHolder;
            Class cls = TextView.class;
            viewHolder.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
            viewHolder.metro_sercive_opted = (TextView) Utils.findRequiredViewAsType(view, R.id.metro_sercive_opted, "field 'metro_sercive_opted'", cls);
            viewHolder.dmrc_status_pending = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_status_pending, "field 'dmrc_status_pending'", cls);
            viewHolder.trainNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainNumber'", cls);
            viewHolder.fromCity = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcitycode, "field 'fromCity'", cls);
            viewHolder.toCity = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'toCity'", cls);
            Class cls2 = LinearLayout.class;
            viewHolder.expandLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.expand_layout, "field 'expandLayout'", cls2);
            viewHolder.journeyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'journeyDate'", cls);
            viewHolder.cancellationId = (TextView) Utils.findRequiredViewAsType(view, R.id.cancellation_id, "field 'cancellationId'", cls);
            viewHolder.ticketAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.ticket_amount, "field 'ticketAmount'", cls);
            viewHolder.ticket_amount_paid = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ticket_amount_paid, "field 'ticket_amount_paid'", cls2);
            viewHolder.refundAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_amount, "field 'refundAmount'", cls);
            viewHolder.transactionIdBot = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_id_bot, "field 'transactionIdBot'", cls);
            viewHolder.journy_date = (TextView) Utils.findRequiredViewAsType(view, R.id.journy_date, "field 'journy_date'", cls);
            viewHolder.dmrc_total_fare = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_total_fare, "field 'dmrc_total_fare'", cls);
            viewHolder.service_id = (TextView) Utils.findRequiredViewAsType(view, R.id.service_id, "field 'service_id'", cls);
            viewHolder.No_of_passengers = (TextView) Utils.findRequiredViewAsType(view, R.id.No_of_passengers, "field 'No_of_passengers'", cls);
            viewHolder.no_of_cancelled_psng = (TextView) Utils.findRequiredViewAsType(view, R.id.no_of_cancelled_psng, "field 'no_of_cancelled_psng'", cls);
            viewHolder.dmrc_status = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.dmrc_status, "field 'dmrc_status'", cls2);
            viewHolder.viewline = Utils.findRequiredView(view, R.id.viewline, "field 'viewline'");
            viewHolder.dmrc_no_of_cancelled_psng = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.dmrc_no_of_cancelled_psng, "field 'dmrc_no_of_cancelled_psng'", cls2);
            viewHolder.metro_service_details = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.metro_service_details, "field 'metro_service_details'", cls2);
            viewHolder.tktdetails1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tkt_details1, "field 'tktdetails1'", cls);
            Class cls3 = RecyclerView.class;
            viewHolder.psgnList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_passenger_list, "field 'psgnList'", cls3);
            View findRequiredView = Utils.findRequiredView(view, R.id.ticket_details, "field 'tktDetails' and method 'TicketDtls'");
            viewHolder.tktDetails = (CardView) Utils.castView(findRequiredView, R.id.ticket_details, "field 'tktDetails'", CardView.class);
            this.a = findRequiredView;
            findRequiredView.setOnClickListener(new a(viewHolder));
            viewHolder.ti_refund_amount = (TextView) Utils.findRequiredViewAsType(view, R.id.ti_refund_amount, "field 'ti_refund_amount'", cls);
            viewHolder.ti_refund_amount_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ti_refund_amount_layout, "field 'ti_refund_amount_layout'", cls2);
            viewHolder.metroCancelDetailsList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_metro_cancel_details_list, "field 'metroCancelDetailsList'", cls3);
        }

        public final void unbind() {
            ViewHolder viewHolder = this.f5382a;
            if (viewHolder != null) {
                this.f5382a = null;
                viewHolder.trainName = null;
                viewHolder.metro_sercive_opted = null;
                viewHolder.dmrc_status_pending = null;
                viewHolder.trainNumber = null;
                viewHolder.fromCity = null;
                viewHolder.toCity = null;
                viewHolder.expandLayout = null;
                viewHolder.journeyDate = null;
                viewHolder.cancellationId = null;
                viewHolder.ticketAmount = null;
                viewHolder.ticket_amount_paid = null;
                viewHolder.refundAmount = null;
                viewHolder.transactionIdBot = null;
                viewHolder.journy_date = null;
                viewHolder.dmrc_total_fare = null;
                viewHolder.service_id = null;
                viewHolder.No_of_passengers = null;
                viewHolder.no_of_cancelled_psng = null;
                viewHolder.dmrc_status = null;
                viewHolder.viewline = null;
                viewHolder.dmrc_no_of_cancelled_psng = null;
                viewHolder.metro_service_details = null;
                viewHolder.tktdetails1 = null;
                viewHolder.psgnList = null;
                viewHolder.tktDetails = null;
                viewHolder.ti_refund_amount = null;
                viewHolder.ti_refund_amount_layout = null;
                viewHolder.metroCancelDetailsList = null;
                this.a.setOnClickListener((View.OnClickListener) null);
                this.a = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface a {
    }

    static {
        C1354qp.R(CancellationItemHolder.class);
    }

    public CancellationItemHolder(a aVar, ArrayList arrayList) {
        this.f5378a = aVar;
        this.f5379a = arrayList;
    }

    public final int getItemCount() {
        ArrayList<BookingResponseDTO> arrayList = this.f5379a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        StationDb stationDb = C0793b1.a.f3911a;
        BookingResponseDTO bookingResponseDTO = this.f5379a.get(i);
        viewHolder2.f5381a = bookingResponseDTO;
        viewHolder2.trainName.setText(bookingResponseDTO.getTrainName());
        viewHolder2.trainNumber.setText("");
        TextView textView = viewHolder2.fromCity;
        textView.setText(stationDb.m(bookingResponseDTO.getFromStn()) + "(" + bookingResponseDTO.getFromStn() + ")");
        TextView textView2 = viewHolder2.toCity;
        textView2.setText(stationDb.m(bookingResponseDTO.getDestStn()) + "(" + bookingResponseDTO.getDestStn() + ")");
        viewHolder2.journeyDate.setText(C0535I5.l(bookingResponseDTO.getJourneyDate()));
        viewHolder2.cancellationId.setText(bookingResponseDTO.getCancellationId());
        if (!bookingResponseDTO.getRetryBooking().booleanValue() || this.f5380a) {
            viewHolder2.expandLayout.setVisibility(8);
            viewHolder2.psgnList.setVisibility(8);
            this.f5380a = false;
        } else {
            viewHolder2.expandLayout.setVisibility(0);
            this.f5380a = true;
            if (bookingResponseDTO.getMetroServiceDetail() != null) {
                int intValue = bookingResponseDTO.getMetroServiceDetail().getMetroTicketFare().intValue();
                viewHolder2.metro_service_details.setVisibility(0);
                viewHolder2.dmrc_status.setVisibility(0);
                viewHolder2.viewline.setVisibility(8);
                viewHolder2.dmrc_no_of_cancelled_psng.setVisibility(0);
                viewHolder2.ticket_amount_paid.setVisibility(8);
                TextView textView3 = viewHolder2.journy_date;
                textView3.setText(" " + C0535I5.l(bookingResponseDTO.getMetroServiceDetail().getMetroJourneyDate()));
                TextView textView4 = viewHolder2.dmrc_total_fare;
                textView4.setText(" " + this.f5377a.getString(R.string.rupees) + " " + (bookingResponseDTO.getMetroServiceDetail().getMetroGstCharge().floatValue() + ((float) (bookingResponseDTO.getMetroServiceDetail().getDmrcServiceCharge().shortValue() + intValue))));
                TextView textView5 = viewHolder2.service_id;
                StringBuilder sb = new StringBuilder(" ");
                sb.append(bookingResponseDTO.getMetroServiceDetail().getDmrcServiceId());
                textView5.setText(sb.toString());
                TextView textView6 = viewHolder2.No_of_passengers;
                textView6.setText(": " + bookingResponseDTO.getMetroServiceDetail().getNumberOfPassengerOpted());
                TextView textView7 = viewHolder2.no_of_cancelled_psng;
                textView7.setText(" " + bookingResponseDTO.getMetroServiceDetail().getNumberOfCancelPsgn());
                TextView textView8 = viewHolder2.tktdetails1;
                textView8.setText(this.f5377a.getString(R.string.cancellation_date) + " :" + C0535I5.e(bookingResponseDTO.getCancellationDate().replace("HRS", "")));
                viewHolder2.metroCancelDetailsList.setLayoutManager(new LinearLayoutManager(this.f5377a));
                viewHolder2.metroCancelDetailsList.setAdapter(new MetroCancelDetailsListAdaptor(this.f5377a, bookingResponseDTO.getMetroServiceDetail().getMetroPassengerList()));
            } else {
                viewHolder2.metro_service_details.setVisibility(8);
                viewHolder2.dmrc_status.setVisibility(8);
                viewHolder2.dmrc_no_of_cancelled_psng.setVisibility(8);
                viewHolder2.ticket_amount_paid.setVisibility(0);
                viewHolder2.viewline.setVisibility(0);
                TextView textView9 = viewHolder2.tktdetails1;
                textView9.setText(this.f5377a.getString(R.string.cancellation_date) + " :" + C0535I5.e(bookingResponseDTO.getCancellationDate().replace("HRS", "")) + " | " + bookingResponseDTO.getQuota().split("\\(")[0] + " | " + bookingResponseDTO.getJourneyClass().split("\\(")[1].replace(")", ""));
                viewHolder2.ticketAmount.setText(String.valueOf(bookingResponseDTO.getTicketAmount()));
            }
            viewHolder2.refundAmount.setText(String.valueOf(bookingResponseDTO.getRefundAmount()));
            if (bookingResponseDTO.getTravelnsuranceRefundAmount() == 0.0f) {
                viewHolder2.ti_refund_amount_layout.setVisibility(8);
            } else {
                viewHolder2.ti_refund_amount_layout.setVisibility(0);
                viewHolder2.ti_refund_amount.setText(String.valueOf(bookingResponseDTO.getTravelnsuranceRefundAmount()));
            }
            viewHolder2.transactionIdBot.setText(bookingResponseDTO.getPnrNumber());
            if (bookingResponseDTO.getPsgnDtlList() != null && bookingResponseDTO.getPsgnDtlList().size() > 0) {
                viewHolder2.psgnList.setVisibility(0);
                CancelPassangerViewHolder cancelPassangerViewHolder = new CancelPassangerViewHolder(this.f5377a, bookingResponseDTO.getPsgnDtlList());
                viewHolder2.psgnList.setLayoutManager(new LinearLayoutManager(this.f5377a));
                viewHolder2.psgnList.setAdapter(cancelPassangerViewHolder);
                viewHolder2.psgnList.getAdapter().notifyDataSetChanged();
            }
            if (!bookingResponseDTO.isMetroServiceOpted() || !bookingResponseDTO.getCancellationStatus().equalsIgnoreCase("Pending")) {
                viewHolder2.dmrc_status_pending.setVisibility(8);
            } else {
                viewHolder2.dmrc_status_pending.setVisibility(0);
                viewHolder2.dmrc_status_pending.setText(this.f5377a.getString(R.string.status_pending));
            }
        }
        if (bookingResponseDTO.isMetroServiceOpted()) {
            viewHolder2.metro_sercive_opted.setVisibility(0);
        } else {
            viewHolder2.metro_sercive_opted.setVisibility(8);
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_canceled_ticket, (ViewGroup) null);
        this.f5377a = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
