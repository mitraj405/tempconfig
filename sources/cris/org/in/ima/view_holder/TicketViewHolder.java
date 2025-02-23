package cris.org.in.ima.view_holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.fragment.BookingHistoryFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public final class TicketViewHolder extends RecyclerView.Adapter<ViewHolder> {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public final a f5421a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<BookingResponseDTO> f5422a;

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with other field name */
        public BookingResponseDTO f5423a;
        @BindView(2131362060)
        TextView bookingdate;
        @BindView(2131362715)
        TextView fromcitycode;
        @BindView(2131362920)
        TextView jrnyDate;
        @BindView(2131363220)
        LinearLayout metroTicketLl;
        @BindView(2131363282)
        AdManagerAdView my_booking_center;
        @BindView(2131363506)
        TextView pnr;
        @BindView(2131364138)
        CardView ticketDetails;
        @BindView(2131364660)
        TextView ticketStatus;
        @BindView(2131364142)
        TextView ticketStatusLable;
        @BindView(2131364143)
        RelativeLayout ticket_status_rl;
        @BindView(2131364169)
        TextView tocitycode;
        @BindView(2131364201)
        TextView trainName;
        @BindView(2131364203)
        TextView trainno;
        @BindView(2131364532)
        TextView tv_pnr;
        @BindView(2131364828)
        TextView view_dmrc_tickets_detail;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131364138})
        public void onClick(View view) {
            a aVar = TicketViewHolder.this.f5421a;
            if (aVar != null) {
                aVar.a(this.f5423a);
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public View a;

        /* renamed from: a  reason: collision with other field name */
        public ViewHolder f5424a;

        /* compiled from: TicketViewHolder$ViewHolder_ViewBinding */
        public class a extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public a(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.onClick(view);
            }
        }

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f5424a = viewHolder;
            Class cls = TextView.class;
            viewHolder.pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnr'", cls);
            View findRequiredView = Utils.findRequiredView(view, R.id.ticket_details, "field 'ticketDetails' and method 'onClick'");
            viewHolder.ticketDetails = (CardView) Utils.castView(findRequiredView, R.id.ticket_details, "field 'ticketDetails'", CardView.class);
            this.a = findRequiredView;
            findRequiredView.setOnClickListener(new a(viewHolder));
            viewHolder.trainno = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainno'", cls);
            viewHolder.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
            viewHolder.jrnyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'jrnyDate'", cls);
            viewHolder.tocitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'tocitycode'", cls);
            viewHolder.fromcitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcidtycode, "field 'fromcitycode'", cls);
            viewHolder.bookingdate = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_date, "field 'bookingdate'", cls);
            viewHolder.ticketStatusLable = (TextView) Utils.findRequiredViewAsType(view, R.id.ticket_status_l, "field 'ticketStatusLable'", cls);
            viewHolder.ticketStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ticket_status, "field 'ticketStatus'", cls);
            viewHolder.tv_pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pnr, "field 'tv_pnr'", cls);
            viewHolder.ticket_status_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ticket_status_rl, "field 'ticket_status_rl'", RelativeLayout.class);
            viewHolder.my_booking_center = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.my_booking_center, "field 'my_booking_center'", AdManagerAdView.class);
            viewHolder.metroTicketLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.metro_ticket_ll, "field 'metroTicketLl'", LinearLayout.class);
            viewHolder.view_dmrc_tickets_detail = (TextView) Utils.findRequiredViewAsType(view, R.id.view_dmrc_tickets_detail, "field 'view_dmrc_tickets_detail'", cls);
        }

        public final void unbind() {
            ViewHolder viewHolder = this.f5424a;
            if (viewHolder != null) {
                this.f5424a = null;
                viewHolder.pnr = null;
                viewHolder.ticketDetails = null;
                viewHolder.trainno = null;
                viewHolder.trainName = null;
                viewHolder.jrnyDate = null;
                viewHolder.tocitycode = null;
                viewHolder.fromcitycode = null;
                viewHolder.bookingdate = null;
                viewHolder.ticketStatusLable = null;
                viewHolder.ticketStatus = null;
                viewHolder.tv_pnr = null;
                viewHolder.ticket_status_rl = null;
                viewHolder.my_booking_center = null;
                viewHolder.metroTicketLl = null;
                viewHolder.view_dmrc_tickets_detail = null;
                this.a.setOnClickListener((View.OnClickListener) null);
                this.a = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface a {
        void a(BookingResponseDTO bookingResponseDTO);
    }

    static {
        C1354qp.R(TicketViewHolder.class);
    }

    public TicketViewHolder(Context context, ArrayList<BookingResponseDTO> arrayList, a aVar) {
        this.a = context;
        this.f5422a = arrayList;
        this.f5421a = aVar;
    }

    public final int getItemCount() {
        ArrayList<BookingResponseDTO> arrayList = this.f5422a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        BookingResponseDTO bookingResponseDTO = this.f5422a.get(i);
        viewHolder2.f5423a = bookingResponseDTO;
        StationDb stationDb = C0793b1.a.f3911a;
        if (bookingResponseDTO.isMultiLapFlag()) {
            viewHolder2.ticket_status_rl.setVisibility(8);
            viewHolder2.trainno.setVisibility(8);
            viewHolder2.pnr.setText(bookingResponseDTO.getTransactionId());
            viewHolder2.tv_pnr.setText("TXN: ");
            TextView textView = viewHolder2.trainName;
            textView.setText("VIA- " + stationDb.m(bookingResponseDTO.getDestStn()) + "(" + bookingResponseDTO.getDestStn() + ")");
            TextView textView2 = viewHolder2.tocitycode;
            textView2.setText(stationDb.m(bookingResponseDTO.getMlJourneyTo()) + "(" + bookingResponseDTO.getMlJourneyTo() + ")");
        } else {
            TextView textView3 = viewHolder2.trainno;
            textView3.setText("(" + bookingResponseDTO.getTrainNumber() + ")");
            viewHolder2.trainName.setText(bookingResponseDTO.getTrainName());
            viewHolder2.pnr.setText(bookingResponseDTO.getPnrNumber());
            TextView textView4 = viewHolder2.tocitycode;
            textView4.setText(stationDb.m(bookingResponseDTO.getDestStn()) + "(" + bookingResponseDTO.getDestStn() + ")");
            viewHolder2.ticket_status_rl.setVisibility(0);
        }
        if (bookingResponseDTO.isMetroServiceOpted()) {
            viewHolder2.metroTicketLl.setVisibility(0);
            viewHolder2.view_dmrc_tickets_detail.setText(this.a.getString(R.string.view_dmrc_ticket_detail));
        } else if (!bookingResponseDTO.isEligibleForMetro() || bookingResponseDTO.isMetroServiceOpted() || bookingResponseDTO.getReservationStatus().equalsIgnoreCase("WL Cancellation") || bookingResponseDTO.getReservationStatus().equalsIgnoreCase("cancelled") || bookingResponseDTO.getReservationStatus().equalsIgnoreCase("रद्द")) {
            viewHolder2.metroTicketLl.setVisibility(8);
        } else {
            viewHolder2.view_dmrc_tickets_detail.setText(this.a.getString(R.string.eligible_for_dmrc_ticket_detail));
        }
        viewHolder2.jrnyDate.setText(C0535I5.l(bookingResponseDTO.getJourneyDate()));
        TextView textView5 = viewHolder2.fromcitycode;
        textView5.setText(stationDb.m(bookingResponseDTO.getFromStn()) + "(" + bookingResponseDTO.getFromStn() + ")");
        viewHolder2.bookingdate.setText(C0535I5.k(bookingResponseDTO.getBookingDate()));
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        googleAdParamDTO.setSource(bookingResponseDTO.getFromStn());
        googleAdParamDTO.setDestination(bookingResponseDTO.getDestStn());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
        try {
            googleAdParamDTO.setDepartureDate(simpleDateFormat.format(bookingResponseDTO.getBoardingDate()));
            googleAdParamDTO.setArrivalDate(simpleDateFormat.format(bookingResponseDTO.getDestArrvDate()));
        } catch (Exception e) {
            e.getMessage();
        }
        googleAdParamDTO.setjClass(bookingResponseDTO.getJourneyClass());
        if (H9.f(bookingResponseDTO.getJourneyQuota()) != null) {
            googleAdParamDTO.setQuata(H9.f(bookingResponseDTO.getJourneyQuota()).f3610c);
        }
        googleAdParamDTO.setTrainType(bookingResponseDTO.getTrainTypeCode());
        viewHolder2.my_booking_center.setVisibility(8);
        if (i == 0 || (i + 1) % 3 != 0) {
            viewHolder2.my_booking_center.setVisibility(8);
        } else {
            viewHolder2.my_booking_center.setVisibility(0);
            C0535I5.Y(BookingHistoryFragment.a, viewHolder2.my_booking_center, googleAdParamDTO);
        }
        if (bookingResponseDTO.getReservationStatus().equalsIgnoreCase("cancelled") || bookingResponseDTO.getReservationStatus().equalsIgnoreCase("रद्द")) {
            viewHolder2.ticketStatus.setText(this.a.getString(R.string.Cancelled));
            viewHolder2.ticketStatusLable.setVisibility(0);
            viewHolder2.ticketStatus.setVisibility(0);
            C1058d.H(this.a, R.color.dark_red, viewHolder2.ticketStatus);
        } else if (bookingResponseDTO.getReservationStatus().equalsIgnoreCase("Booked") || bookingResponseDTO.getReservationStatus().equalsIgnoreCase("आरक्षित")) {
            viewHolder2.ticketStatus.setText(this.a.getString(R.string.BOOKED));
            C1058d.H(this.a, R.color.green, viewHolder2.ticketStatus);
            viewHolder2.ticketStatusLable.setVisibility(0);
            viewHolder2.ticketStatus.setVisibility(0);
        } else if (bookingResponseDTO.getReservationStatus().equalsIgnoreCase("Partial Cancelled") || bookingResponseDTO.getReservationStatus().equalsIgnoreCase("आंशिक रद्द")) {
            viewHolder2.ticketStatus.setText(this.a.getString(R.string.Partial_Cancelled));
            viewHolder2.ticketStatusLable.setVisibility(0);
            viewHolder2.ticketStatus.setVisibility(0);
            C1058d.H(this.a, R.color.dark_red, viewHolder2.ticketStatus);
        } else if (bookingResponseDTO.getReservationStatus() != null && (bookingResponseDTO.getReservationStatus().equalsIgnoreCase("TDR Entered") || bookingResponseDTO.getReservationStatus().equalsIgnoreCase("टीडीआर लिखा"))) {
            viewHolder2.ticketStatus.setText(R.string.TDR_ENTERED);
            viewHolder2.ticketStatusLable.setVisibility(0);
            viewHolder2.ticketStatus.setVisibility(0);
            C1058d.H(this.a, R.color.bg_passenger_transgender1, viewHolder2.ticketStatus);
        } else if (bookingResponseDTO.getReservationStatus() == null || !bookingResponseDTO.getReservationStatus().equalsIgnoreCase("WL Cancellation")) {
            viewHolder2.ticketStatusLable.setVisibility(4);
            viewHolder2.ticketStatus.setVisibility(4);
        } else {
            viewHolder2.ticketStatus.setText(this.a.getString(R.string.Cancelled));
            viewHolder2.ticketStatusLable.setVisibility(0);
            viewHolder2.ticketStatus.setVisibility(0);
            C1058d.H(this.a, R.color.dark_red, viewHolder2.ticketStatus);
        }
        if (bookingResponseDTO.isMultiLapFlag()) {
            viewHolder2.ticketStatusLable.setVisibility(8);
            viewHolder2.ticketStatus.setVisibility(8);
            return;
        }
        viewHolder2.ticketStatusLable.setVisibility(0);
        viewHolder2.ticketStatus.setVisibility(0);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_my_booking_history, (ViewGroup) null);
        this.a = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
