package cris.org.in.ima.view_holder;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
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
import com.google.android.gms.ads.RequestConfiguration;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.fragment.TdrHistoryFragment;
import cris.org.in.ima.fragment.x0;
import cris.org.in.ima.fragment.y0;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.ArrayList;

public final class TDRItemHolder extends RecyclerView.Adapter<ViewHolder> {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public final a f5417a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<BookingResponseDTO> f5418a;

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with other field name */
        public BookingResponseDTO f5419a;
        @BindView(2131362060)
        TextView bookingDate;
        @BindView(2131362062)
        TextView bookingDateLabel;
        @BindView(2131362716)
        TextView fromCity;
        @BindView(2131362920)
        TextView journeyDate;
        @BindView(2131363506)
        TextView pnr;
        @BindView(2131364138)
        CardView ticketDetails;
        @BindView(2131364142)
        TextView ticket_status_l;
        @BindView(2131364143)
        RelativeLayout ticket_status_rl;
        @BindView(2131364169)
        TextView toCity;
        @BindView(2131364201)
        TextView trainName;
        @BindView(2131364203)
        TextView trainNumber;
        @BindView(2131364660)
        TextView tv_ticket_status;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131364138})
        public void onClick(View view) {
            a aVar = TDRItemHolder.this.f5417a;
            if (aVar != null) {
                BookingResponseDTO bookingResponseDTO = this.f5419a;
                TdrHistoryFragment.d dVar = (TdrHistoryFragment.d) aVar;
                TdrHistoryFragment tdrHistoryFragment = TdrHistoryFragment.this;
                if (!C0535I5.O((ConnectivityManager) tdrHistoryFragment.getActivity().getSystemService("connectivity"), tdrHistoryFragment.f5148a)) {
                    new Handler().postDelayed(new x0(), 5000);
                    return;
                }
                ProgressDialog show = ProgressDialog.show(tdrHistoryFragment.getActivity(), tdrHistoryFragment.getString(R.string.fetching_transaction_Details), tdrHistoryFragment.getString(R.string.please_wait_text));
                tdrHistoryFragment.a = show;
                C1223kn knVar = C0793b1.a.f3912a;
                tdrHistoryFragment.f5152a = knVar;
                if (knVar != null) {
                    try {
                        show.show();
                        String f = C0657Qt.f();
                        String format = String.format("/%s/%s", new Object[]{bookingResponseDTO.getCancellationId(), RequestConfiguration.MAX_AD_CONTENT_RATING_T});
                        ((Om) C0657Qt.c(tdrHistoryFragment.f5152a)).n(f + "cancellationAndTdrDetailByCanId" + format).c(C1181iv.a()).a(E0.a()).b(new y0(dVar, bookingResponseDTO));
                    } catch (Exception e) {
                        tdrHistoryFragment.a.dismiss();
                        int i = TdrHistoryFragment.c;
                        e.getMessage();
                        C0535I5.t0(tdrHistoryFragment.getActivity(), tdrHistoryFragment.getString(R.string.please_try_again));
                    }
                } else {
                    C0535I5.m(tdrHistoryFragment.getActivity(), false, tdrHistoryFragment.getResources().getString(R.string.unable_process_message), tdrHistoryFragment.getString(R.string.error), tdrHistoryFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public View a;

        /* renamed from: a  reason: collision with other field name */
        public ViewHolder f5420a;

        /* compiled from: TDRItemHolder$ViewHolder_ViewBinding */
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
            this.f5420a = viewHolder;
            View findRequiredView = Utils.findRequiredView(view, R.id.ticket_details, "field 'ticketDetails' and method 'onClick'");
            viewHolder.ticketDetails = (CardView) Utils.castView(findRequiredView, R.id.ticket_details, "field 'ticketDetails'", CardView.class);
            this.a = findRequiredView;
            findRequiredView.setOnClickListener(new a(viewHolder));
            Class cls = TextView.class;
            viewHolder.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
            viewHolder.trainNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainNumber'", cls);
            viewHolder.fromCity = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcitycode, "field 'fromCity'", cls);
            viewHolder.toCity = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'toCity'", cls);
            viewHolder.pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnr'", cls);
            viewHolder.journeyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'journeyDate'", cls);
            viewHolder.bookingDate = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_date, "field 'bookingDate'", cls);
            viewHolder.bookingDateLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_date_label, "field 'bookingDateLabel'", cls);
            viewHolder.ticket_status_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ticket_status_rl, "field 'ticket_status_rl'", RelativeLayout.class);
            viewHolder.ticket_status_l = (TextView) Utils.findRequiredViewAsType(view, R.id.ticket_status_l, "field 'ticket_status_l'", cls);
            viewHolder.tv_ticket_status = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ticket_status, "field 'tv_ticket_status'", cls);
        }

        public final void unbind() {
            ViewHolder viewHolder = this.f5420a;
            if (viewHolder != null) {
                this.f5420a = null;
                viewHolder.ticketDetails = null;
                viewHolder.trainName = null;
                viewHolder.trainNumber = null;
                viewHolder.fromCity = null;
                viewHolder.toCity = null;
                viewHolder.pnr = null;
                viewHolder.journeyDate = null;
                viewHolder.bookingDate = null;
                viewHolder.bookingDateLabel = null;
                viewHolder.ticket_status_rl = null;
                viewHolder.ticket_status_l = null;
                viewHolder.tv_ticket_status = null;
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
        C1354qp.R(TDRItemHolder.class);
    }

    public TDRItemHolder(Context context, ArrayList arrayList, TdrHistoryFragment.d dVar) {
        this.a = context;
        this.f5418a = arrayList;
        this.f5417a = dVar;
    }

    public final int getItemCount() {
        ArrayList<BookingResponseDTO> arrayList = this.f5418a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        BookingResponseDTO bookingResponseDTO = this.f5418a.get(i);
        viewHolder2.f5419a = bookingResponseDTO;
        StationDb stationDb = C0793b1.a.f3911a;
        viewHolder2.pnr.setText(bookingResponseDTO.getPnrNumber());
        viewHolder2.trainName.setText(bookingResponseDTO.getTrainName());
        TextView textView = viewHolder2.trainNumber;
        textView.setText("(" + bookingResponseDTO.getTrainNumber() + ")");
        viewHolder2.fromCity.setText(stationDb.m(bookingResponseDTO.getFromStn()));
        viewHolder2.toCity.setText(stationDb.m(bookingResponseDTO.getDestStn()));
        if (bookingResponseDTO.getTdrFilingDate() != null) {
            viewHolder2.bookingDate.setText(bookingResponseDTO.getTdrFilingDate().replace(" HRS", ""));
        }
        viewHolder2.journeyDate.setText(C0535I5.l(bookingResponseDTO.getJourneyDate()));
        viewHolder2.bookingDateLabel.setText(this.a.getResources().getString(R.string.tdr_filing_date));
        if (bookingResponseDTO.getReservationStatus() == null || !bookingResponseDTO.getReservationStatus().equalsIgnoreCase("TDR Entered")) {
            viewHolder2.ticket_status_rl.setVisibility(8);
            return;
        }
        viewHolder2.ticket_status_rl.setVisibility(0);
        viewHolder2.tv_ticket_status.setText(R.string.TDR_ENTERED);
        C1058d.H(this.a, R.color.bg_passenger_transgender1, viewHolder2.tv_ticket_status);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_tdr_ticket, (ViewGroup) null);
        this.a = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
