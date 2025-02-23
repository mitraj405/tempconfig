package cris.org.in.ima.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.FeedbackActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.TicketStatusPassengerAdapter;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TicketStatusFragment extends Fragment {
    public static int d = 0;
    public final Context a = getContext();

    /* renamed from: a  reason: collision with other field name */
    public ImageView f5154a;

    /* renamed from: a  reason: collision with other field name */
    public final TicketStatusFragment f5155a = this;

    /* renamed from: a  reason: collision with other field name */
    public BookingResponseDTO f5156a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f5157a;
    public ImageView b;

    /* renamed from: b  reason: collision with other field name */
    public BookingResponseDTO f5158b;
    @BindView(2131362056)
    TextView booking_amnt;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public ImageView f5159c;

    /* renamed from: c  reason: collision with other field name */
    public final String f5160c = String.valueOf(2);
    @BindView(2131362109)
    AdManagerAdView camcel_tkt_status_bottom;

    /* renamed from: d  reason: collision with other field name */
    public ImageView f5161d;

    /* renamed from: d  reason: collision with other field name */
    public String f5162d = "";
    @BindView(2131362403)
    TextView destArrDate;
    @BindView(2131362404)
    TextView destArrTime;
    @BindView(2131362418)
    TextView dmrcJdate;
    @BindView(2131362419)
    TextView dmrc_cancel_status;
    public ImageView e;

    /* renamed from: e  reason: collision with other field name */
    public String f5163e;
    public String f;
    @BindView(2131362643)
    LinearLayout feedback_ll;
    @BindView(2131362715)
    TextView fromStation;
    @BindView(2131362714)
    TextView fromcdmrcstn;
    public String g;
    @BindView(2131362920)
    TextView journeyDate;
    @BindView(2131362925)
    TextView journeyTime;
    @BindView(2131362994)
    TextView linked_pnr;
    @BindView(2131363219)
    LinearLayout metro_ticket;
    @BindView(2131363330)
    TextView no_of_can_psgn;
    @BindView(2131363334)
    TextView no_of_psgn;
    @BindView(2131363556)
    RecyclerView passengerList;
    @BindView(2131363506)
    TextView pnrNumber;
    @BindView(2131363609)
    TextView refundAmount;
    @BindView(2131363608)
    TextView refund_amnt;
    @BindView(2131363612)
    RelativeLayout refund_amount_rl;
    @BindView(2131363626)
    TextView refund_subject;
    @BindView(2131364156)
    TextView tktDetails;
    @BindView(2131364169)
    TextView toStation;
    @BindView(2131364170)
    TextView todmrcstn;
    @BindView(2131364201)
    TextView trainName;
    @BindView(2131364203)
    TextView trainNumber;
    @BindView(2131364243)
    RelativeLayout travel_insurance_rl;
    @BindView(2131364247)
    TextView traveltime;
    @BindView(2131364404)
    ImageView tvFavpnricon;
    @BindView(2131364446)
    TextView tv_it_refund_amount;
    @BindView(2131364542)
    LinearLayout tv_psgn_detail_ll;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            TicketStatusFragment ticketStatusFragment = TicketStatusFragment.this;
            ticketStatusFragment.f5162d = C0515Ga.AVLBLTY_ONLY;
            ticketStatusFragment.f(1);
            Intent intent = new Intent(ticketStatusFragment.getActivity(), FeedbackActivity.class);
            intent.putExtra("message_key", ticketStatusFragment.f5162d);
            intent.putExtra("camefrompage", ticketStatusFragment.f5160c);
            ticketStatusFragment.startActivity(intent);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public final void onClick(View view) {
            TicketStatusFragment ticketStatusFragment = TicketStatusFragment.this;
            ticketStatusFragment.f5162d = C0515Ga.FARE_ONLY;
            ticketStatusFragment.f(2);
            Intent intent = new Intent(ticketStatusFragment.getActivity(), FeedbackActivity.class);
            intent.putExtra("message_key", ticketStatusFragment.f5162d);
            intent.putExtra("camefrompage", ticketStatusFragment.f5160c);
            ticketStatusFragment.startActivity(intent);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public final void onClick(View view) {
            TicketStatusFragment ticketStatusFragment = TicketStatusFragment.this;
            ticketStatusFragment.f5162d = C0515Ga.FARE_AVLBLTY;
            ticketStatusFragment.f(3);
            Intent intent = new Intent(ticketStatusFragment.getActivity(), FeedbackActivity.class);
            intent.putExtra("message_key", ticketStatusFragment.f5162d);
            intent.putExtra("camefrompage", ticketStatusFragment.f5160c);
            ticketStatusFragment.startActivity(intent);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public final void onClick(View view) {
            TicketStatusFragment ticketStatusFragment = TicketStatusFragment.this;
            ticketStatusFragment.f5162d = "4";
            ticketStatusFragment.f(4);
            Intent intent = new Intent(ticketStatusFragment.getActivity(), FeedbackActivity.class);
            intent.putExtra("message_key", ticketStatusFragment.f5162d);
            intent.putExtra("camefrompage", ticketStatusFragment.f5160c);
            ticketStatusFragment.startActivity(intent);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public final void onClick(View view) {
            TicketStatusFragment ticketStatusFragment = TicketStatusFragment.this;
            ticketStatusFragment.f5162d = "5";
            ticketStatusFragment.f(5);
            Intent intent = new Intent(ticketStatusFragment.getActivity(), FeedbackActivity.class);
            intent.putExtra("message_key", ticketStatusFragment.f5162d);
            intent.putExtra("camefrompage", ticketStatusFragment.f5160c);
            ticketStatusFragment.startActivity(intent);
        }
    }

    static {
        C1354qp.R(TicketStatusFragment.class);
        new SimpleDateFormat("HH:mm");
    }

    public final void f(int i) {
        this.f5154a.setImageResource(R.drawable.star_outline);
        this.b.setImageResource(R.drawable.star_outline);
        this.f5159c.setImageResource(R.drawable.star_outline);
        this.f5161d.setImageResource(R.drawable.star_outline);
        this.e.setImageResource(R.drawable.star_outline);
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            this.e.setImageResource(R.drawable.star_filled);
                        } else {
                            return;
                        }
                    }
                    this.f5161d.setImageResource(R.drawable.star_filled);
                }
                this.f5159c.setImageResource(R.drawable.star_filled);
            }
            this.b.setImageResource(R.drawable.star_filled);
        }
        this.f5154a.setImageResource(R.drawable.star_filled);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = null;
        View inflate = layoutInflater.inflate(R.layout.activity_ticket_status, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        if (C1450w1.f7028d) {
            this.feedback_ll.setVisibility(0);
        } else {
            this.feedback_ll.setVisibility(8);
        }
        Bundle arguments = getArguments();
        StationDb stationDb = C0793b1.a.f3911a;
        this.f5156a = (BookingResponseDTO) arguments.getSerializable("cantkt");
        this.f5158b = (BookingResponseDTO) arguments.getSerializable("arrDepDate");
        this.f5163e = (String) arguments.getSerializable("dmrcFromStn");
        this.f = (String) arguments.getSerializable("dmrcToStn");
        this.g = (String) arguments.getSerializable("pnrNumber");
        this.c = arguments.getInt("dmrcPsgn");
        this.tvFavpnricon.setVisibility(4);
        this.passengerList.setLayoutManager(new LinearLayoutManager(this.a));
        this.pnrNumber.setText(this.f5156a.getPnrNumber());
        this.trainName.setText(this.f5156a.getTrainName());
        TextView textView = this.trainNumber;
        textView.setText("(" + this.f5156a.getTrainNumber() + ")");
        HomeActivity.x();
        if (((double) this.f5156a.getTravelnsuranceRefundAmount()) == 0.0d) {
            this.travel_insurance_rl.setVisibility(8);
            TextView textView2 = this.tv_it_refund_amount;
            textView2.setText(getResources().getString(R.string.rupees) + this.f5156a.getTravelnsuranceRefundAmount());
        } else {
            this.travel_insurance_rl.setVisibility(0);
            TextView textView3 = this.tv_it_refund_amount;
            textView3.setText(getResources().getString(R.string.rupees) + this.f5156a.getTravelnsuranceRefundAmount());
        }
        if (this.f5156a.getBoardingDate() == null || this.f5156a.getDestArrvDate() == null) {
            this.journeyDate.setText("*N.A.");
            this.journeyTime.setText("*N.A.");
            this.destArrTime.setText("*N.A.");
            this.traveltime.setText("       ");
            this.destArrDate.setText("*N.A.");
        } else if (this.f5156a.getScheduleArrivalFlag().booleanValue() && this.f5156a.getScheduleDepartureFlag().booleanValue()) {
            this.journeyDate.setText(C0535I5.U(this.f5156a.getBoardingDate()));
            this.journeyTime.setText(C0535I5.V(this.f5156a.getBoardingDate()));
            this.destArrDate.setText(C0535I5.U(this.f5156a.getDestArrvDate()));
            this.destArrTime.setText(C0535I5.V(this.f5156a.getDestArrvDate()));
            this.traveltime.setText(C0535I5.A(this.f5156a.getBoardingDate(), this.f5156a.getDestArrvDate()));
        } else if (this.f5156a.getScheduleArrivalFlag().booleanValue()) {
            this.journeyDate.setText(C0535I5.U(this.f5156a.getBoardingDate()));
            this.journeyTime.setText(C0535I5.V(this.f5156a.getBoardingDate()));
            this.destArrDate.setText("*N.A.");
            this.destArrTime.setText("*N.A.");
            this.traveltime.setText("       ");
        } else if (this.f5156a.getScheduleDepartureFlag().booleanValue()) {
            this.journeyDate.setText("*N.A.");
            this.journeyTime.setText("*N.A.");
            this.traveltime.setText("       ");
            this.destArrDate.setText(C0535I5.U(this.f5156a.getDestArrvDate()));
            this.destArrTime.setText(C0535I5.V(this.f5156a.getDestArrvDate()));
        } else {
            this.journeyDate.setText("*N.A.");
            this.journeyTime.setText("*N.A.");
            this.destArrTime.setText("*N.A.");
            this.traveltime.setText("       ");
            this.destArrDate.setText("*N.A.");
        }
        this.f5157a = this.f5156a.getPsgnDtlList();
        if (this.f5158b.getBoardingDate() != null) {
            C0535I5.f3621a.format(this.f5158b.getBoardingDate());
        }
        if (this.f5158b.getDestArrvDate() != null) {
            C0535I5.f3621a.format(this.f5158b.getDestArrvDate());
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.camcel_tkt_status_bottom, googleAdParamDTO);
        if (this.f5157a != null) {
            this.tv_psgn_detail_ll.setVisibility(0);
            this.refund_amount_rl.setVisibility(0);
            this.fromStation.setText(stationDb.m(this.f5156a.getFromStn()));
            this.toStation.setText(stationDb.m(this.f5156a.getDestStn()));
            TextView textView4 = this.tktDetails;
            textView4.setText(this.f5156a.getPsgnDtlList().size() + " Passengers | " + this.f5156a.getBookedQuota() + " | " + this.f5156a.getJourneyClass() + " | " + this.f5156a.getBoardingStn());
            this.passengerList.setAdapter(new TicketStatusPassengerAdapter(this.f5155a, this.f5157a));
            TextView textView5 = this.refundAmount;
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString(R.string.rupees));
            sb.append(this.f5156a.getCancellationDetails().get(0).getRefundAmount().toString());
            textView5.setText(sb.toString());
        } else {
            this.tv_psgn_detail_ll.setVisibility(8);
            this.refund_amount_rl.setVisibility(8);
        }
        if (this.f5156a.getCancellationDetails().get(0).getMessage() != null && !this.f5156a.getCancellationDetails().get(0).getMessage().trim().equals("")) {
            C0535I5.p(getActivity(), false, this.f5156a.getCancellationDetails().get(0).getMessage(), getString(R.string.info), getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
        }
        TicketHistoryUtil.c();
        if (this.f5156a.getCancellationDetails() != null) {
            this.metro_ticket.setVisibility(0);
            TextView textView6 = this.no_of_psgn;
            textView6.setText(String.valueOf("Total Passengers: " + this.c));
            TextView textView7 = this.no_of_can_psgn;
            textView7.setText("Cancelled Passengers: " + this.f5156a.getCancellationDetails().get(0).getTotalCanCountMetro());
            TextView textView8 = this.booking_amnt;
            textView8.setText(String.valueOf(": ₹ " + this.f5156a.getCancellationDetails().get(0).getMetroBookingAmnt()));
            TextView textView9 = this.refund_amnt;
            textView9.setText(String.valueOf("₹ " + this.f5156a.getCancellationDetails().get(0).getRefundAmntMetro()));
            this.fromcdmrcstn.setText(this.f5163e);
            this.todmrcstn.setText(this.f);
            if (this.f5156a.getCancellationDetails().get(0).getDmrcCanStatus() != null) {
                this.dmrc_cancel_status.setText(this.f5156a.getCancellationDetails().get(0).getDmrcCanStatus());
            }
            if (this.f5156a.getCancellationDetails().get(0).getCancelledDate() != null) {
                TextView textView10 = this.dmrcJdate;
                Date cancelledDate = this.f5156a.getCancellationDetails().get(0).getCancelledDate();
                if (cancelledDate != null) {
                    str = new SimpleDateFormat("EEE dd MMM").format(cancelledDate);
                }
                textView10.setText(str);
            }
            if (this.f5156a.getCancellationDetails().get(0).getDmrcCanStatus() == null || !this.f5156a.getCancellationDetails().get(0).getDmrcCanStatus().equalsIgnoreCase("pending")) {
                this.refund_subject.setVisibility(8);
            } else {
                this.refund_subject.setVisibility(0);
                this.refund_subject.setText(getString(R.string.refund_subject));
                this.linked_pnr.setText(this.g);
            }
        }
        this.f5154a = (ImageView) inflate.findViewById(R.id.star_1);
        this.b = (ImageView) inflate.findViewById(R.id.star_2);
        this.f5159c = (ImageView) inflate.findViewById(R.id.star_3);
        this.f5161d = (ImageView) inflate.findViewById(R.id.star_4);
        this.e = (ImageView) inflate.findViewById(R.id.star_5);
        this.f5154a.setOnClickListener(new a());
        this.b.setOnClickListener(new b());
        this.f5159c.setOnClickListener(new c());
        this.f5161d.setOnClickListener(new d());
        this.e.setOnClickListener(new e());
        int i = getArguments().getInt("submittedfeedback");
        if (i <= 5 || i >= 1) {
            f(i);
            this.feedback_ll.setClickable(false);
        }
        return inflate;
    }

    public final void onResume() {
        super.onResume();
        int i = d;
        if (i <= 5 || i >= 1) {
            f(i);
            String.valueOf(d);
        }
    }
}
