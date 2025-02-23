package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.CancelTicketPassengerAdapter;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CancelTicketDetailsFragment extends Fragment {
    public static final /* synthetic */ int f = 0;
    public long a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4478a = null;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f4479a;

    /* renamed from: a  reason: collision with other field name */
    public CancelTicketPassengerAdapter f4480a;

    /* renamed from: a  reason: collision with other field name */
    public final StationDb f4481a = C0793b1.a.f3911a;

    /* renamed from: a  reason: collision with other field name */
    public final CancelTicketDetailsFragment f4482a = this;

    /* renamed from: a  reason: collision with other field name */
    public BookingResponseDTO f4483a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f4484a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4485a = false;
    public BookingResponseDTO b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4486b = false;
    @BindView(2131362056)
    TextView booking_amnt;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public BookingResponseDTO f4487c;

    /* renamed from: c  reason: collision with other field name */
    public String f4488c;
    @BindView(2131362110)
    TextView cancel;
    @BindView(2131362114)
    AdManagerAdView cancel_detail_bottom;
    @BindView(2131362119)
    TextView cancellationCharge;
    @BindView(2131362295)
    TextView connectingPnr;
    @BindView(2131362297)
    LinearLayout connectingPnrLayout;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public String f4489d;
    @BindView(2131362403)
    TextView destArrDate;
    @BindView(2131362404)
    TextView destArrTime;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public String f4490e = "0";
    @BindView(2131362499)
    TextView errmessage;
    @BindView(2131362710)
    TextView fromStnDmrc;
    @BindView(2131362714)
    TextView fromcdmrcstn;
    @BindView(2131362715)
    TextView fromcitycode;
    @BindView(2131362886)
    ImageView ivdmrcmin;
    @BindView(2131362887)
    ImageView ivdmrcplus;
    @BindView(2131362920)
    TextView journeyDate;
    @BindView(2131362925)
    TextView journeyTime;
    @BindView(2131362942)
    TextView lapType;
    @BindView(2131363219)
    LinearLayout metro_ticket;
    @BindView(2131363332)
    TextView noOfPassenger;
    @BindView(2131363330)
    TextView no_of_can_psgn;
    @BindView(2131363333)
    LinearLayout no_of_passenger_ll;
    @BindView(2131363334)
    TextView no_of_psgn;
    @BindView(2131363825)
    RecyclerView passengerList;
    @BindView(2131363506)
    TextView pnr;
    @BindView(2131363519)
    TextView pnrNumber;
    @BindView(2131363613)
    TextView refundAmountTime;
    @BindView(2131363609)
    TextView refundAmt;
    @BindView(2131363608)
    TextView refund_amnt;
    @BindView(2131363619)
    RelativeLayout refund_enquiry_bottom_ll;
    @BindView(2131363883)
    CheckBox selectAllDmrcTicket;
    @BindView(2131363902)
    LinearLayout selectAlllayout;
    @BindView(2131362149)
    CheckBox selectall;
    @BindView(2131363935)
    TextView selected_psgn;
    @BindView(2131363941)
    LinearLayout selection_checkbox_ll;
    @BindView(2131364156)
    TextView tktDetails;
    @BindView(2131364165)
    TextView toStnDmrc;
    @BindView(2131364169)
    TextView tocitycode;
    @BindView(2131364170)
    TextView todmrcstn;
    @BindView(2131364201)
    TextView trainName;
    @BindView(2131364203)
    TextView trainno;
    @BindView(2131364214)
    TextView transactionId;
    @BindView(2131364247)
    TextView travel_time;
    @BindView(2131364248)
    LinearLayout traveltime2;
    @BindView(2131364404)
    ImageView tvFavpnricon;
    @BindView(2131364337)
    TextView tv_chart_status;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            CancelTicketDetailsFragment cancelTicketDetailsFragment = CancelTicketDetailsFragment.this;
            CancelTicketDetailsFragment.f(cancelTicketDetailsFragment, cancelTicketDetailsFragment.b.getReservationId(), cancelTicketDetailsFragment.f4480a.getPassengerToken(), cancelTicketDetailsFragment.f4490e);
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            CancelTicketDetailsFragment cancelTicketDetailsFragment = CancelTicketDetailsFragment.this;
            CancelTicketDetailsFragment.f(cancelTicketDetailsFragment, cancelTicketDetailsFragment.b.getReservationId(), cancelTicketDetailsFragment.f4480a.getPassengerToken(), cancelTicketDetailsFragment.f4490e);
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            CancelTicketDetailsFragment cancelTicketDetailsFragment = CancelTicketDetailsFragment.this;
            CancelTicketDetailsFragment.f(cancelTicketDetailsFragment, cancelTicketDetailsFragment.b.getReservationId(), cancelTicketDetailsFragment.f4480a.getPassengerToken(), cancelTicketDetailsFragment.f4490e);
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            CancelTicketDetailsFragment cancelTicketDetailsFragment = CancelTicketDetailsFragment.this;
            CancelTicketDetailsFragment.f(cancelTicketDetailsFragment, cancelTicketDetailsFragment.b.getReservationId(), cancelTicketDetailsFragment.f4480a.getPassengerToken(), cancelTicketDetailsFragment.f4490e);
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            CancelTicketDetailsFragment cancelTicketDetailsFragment = CancelTicketDetailsFragment.this;
            cancelTicketDetailsFragment.selectAllDmrcTicket.setChecked(false);
            cancelTicketDetailsFragment.noOfPassenger.setText("No. of Passenger");
            dialogInterface.dismiss();
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        public final void onClick(View view) {
            int i = CancelTicketDetailsFragment.f;
            CancelTicketDetailsFragment cancelTicketDetailsFragment = CancelTicketDetailsFragment.this;
            CancelTicketPassengerAdapter cancelTicketPassengerAdapter = cancelTicketDetailsFragment.f4480a;
            if (cancelTicketPassengerAdapter != null) {
                cancelTicketPassengerAdapter.setSelectAll(cancelTicketDetailsFragment.selectall.isChecked());
            }
            if (cancelTicketDetailsFragment.b.getMetroServiceDetail() == null) {
                return;
            }
            if (cancelTicketDetailsFragment.selectall.isChecked()) {
                cancelTicketDetailsFragment.selectAllDmrcTicket.setChecked(true);
                cancelTicketDetailsFragment.noOfPassenger.setText(String.valueOf(cancelTicketDetailsFragment.d - cancelTicketDetailsFragment.e));
                TextView textView = cancelTicketDetailsFragment.selected_psgn;
                textView.setText("(" + ((cancelTicketDetailsFragment.d - cancelTicketDetailsFragment.e) + cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfCancelPsgn().shortValue()) + RemoteSettings.FORWARD_SLASH_STRING + cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfPassengerOpted() + ")");
                return;
            }
            cancelTicketDetailsFragment.selectAllDmrcTicket.setChecked(false);
            cancelTicketDetailsFragment.noOfPassenger.setText("No. of Passenger");
            TextView textView2 = cancelTicketDetailsFragment.selected_psgn;
            textView2.setText("(" + cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfCancelPsgn() + RemoteSettings.FORWARD_SLASH_STRING + cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfPassengerOpted() + ")");
        }
    }

    public class k implements View.OnClickListener {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                k kVar = k.this;
                CancelTicketDetailsFragment.this.selectAllDmrcTicket.setChecked(false);
                CancelTicketDetailsFragment.this.noOfPassenger.setText("No. of Passenger");
                dialogInterface.dismiss();
            }
        }

        public k() {
        }

        public final void onClick(View view) {
            int i = CancelTicketDetailsFragment.f;
            CancelTicketDetailsFragment cancelTicketDetailsFragment = CancelTicketDetailsFragment.this;
            if (cancelTicketDetailsFragment.selectAllDmrcTicket.isChecked()) {
                cancelTicketDetailsFragment.noOfPassenger.setText(String.valueOf(cancelTicketDetailsFragment.d - cancelTicketDetailsFragment.e));
                TextView textView = cancelTicketDetailsFragment.selected_psgn;
                textView.setText("(" + (cancelTicketDetailsFragment.d - cancelTicketDetailsFragment.e) + RemoteSettings.FORWARD_SLASH_STRING + cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfPassengerOpted() + ")");
                if (cancelTicketDetailsFragment.noOfPassenger.getText().toString().equalsIgnoreCase("0")) {
                    C0535I5.m(cancelTicketDetailsFragment.getActivity(), false, cancelTicketDetailsFragment.getString(R.string.dmrc_tkt_already_cancelled), cancelTicketDetailsFragment.getString(R.string.error), cancelTicketDetailsFragment.getString(R.string.OK), new a()).show();
                    return;
                }
                return;
            }
            cancelTicketDetailsFragment.noOfPassenger.setText("No. of Passenger");
            TextView textView2 = cancelTicketDetailsFragment.selected_psgn;
            textView2.setText("(" + cancelTicketDetailsFragment.e + RemoteSettings.FORWARD_SLASH_STRING + cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfPassengerOpted() + ")");
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class o implements DialogInterface.OnClickListener {
        public o() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            CancelTicketDetailsFragment cancelTicketDetailsFragment = CancelTicketDetailsFragment.this;
            CancelTicketDetailsFragment.f(cancelTicketDetailsFragment, cancelTicketDetailsFragment.b.getReservationId(), cancelTicketDetailsFragment.f4480a.getPassengerToken(), cancelTicketDetailsFragment.f4490e);
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    static {
        C1354qp.R(CancelTicketDetailsFragment.class);
    }

    public static void f(CancelTicketDetailsFragment cancelTicketDetailsFragment, String str, String str2, String str3) {
        if (!C0535I5.O((ConnectivityManager) cancelTicketDetailsFragment.getActivity().getSystemService("connectivity"), cancelTicketDetailsFragment.getContext())) {
            new Handler().postDelayed(new C0717V3(), 5000);
            return;
        }
        cancelTicketDetailsFragment.f4478a = ProgressDialog.show(cancelTicketDetailsFragment.f4479a, cancelTicketDetailsFragment.getString(R.string.Cancelling_Ticket), cancelTicketDetailsFragment.getString(R.string.please_wait_text));
        String f2 = C0657Qt.f();
        String format = String.format("/%s/%s", new Object[]{str, str2});
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).J0(f2 + "cancelTkt" + format, str3).c(C1181iv.a()).a(E0.a()).b(new Z3(cancelTicketDetailsFragment));
    }

    public final void g(boolean z) {
        this.selectall.setChecked(z);
        if (this.b.getMetroServiceDetail() != null) {
            this.selectAllDmrcTicket.setChecked(z);
            if (this.selectAllDmrcTicket.isChecked()) {
                this.f4490e = String.valueOf(this.d - this.e);
                if (this.noOfPassenger.getText().toString().equalsIgnoreCase("0")) {
                    C0535I5.m(getActivity(), false, getString(R.string.dmrc_tkt_already_cancelled), getString(R.string.error), getString(R.string.OK), new i()).show();
                } else {
                    TextView textView = this.selected_psgn;
                    textView.setText("(" + this.f4490e + RemoteSettings.FORWARD_SLASH_STRING + this.b.getMetroServiceDetail().getNumberOfPassengerOpted() + ")");
                }
                this.noOfPassenger.setText(String.valueOf(this.d - this.e));
                return;
            }
            this.noOfPassenger.setText("No. of Passenger");
            TextView textView2 = this.selected_psgn;
            textView2.setText("(" + this.b.getMetroServiceDetail().getNumberOfCancelPsgn() + RemoteSettings.FORWARD_SLASH_STRING + this.b.getMetroServiceDetail().getNumberOfPassengerOpted() + ")");
        }
    }

    @OnClick({2131362110})
    public void hj() {
        String.valueOf(this.noOfPassenger.getText());
        if (String.valueOf(this.noOfPassenger.getText()).length() != 1) {
            this.f4490e = "0";
        } else if (this.selectAllDmrcTicket.isChecked()) {
            this.f4490e = String.valueOf(this.d - this.e);
        } else {
            this.f4490e = String.valueOf(this.noOfPassenger.getText());
        }
        CancelTicketPassengerAdapter cancelTicketPassengerAdapter = this.f4480a;
        if (cancelTicketPassengerAdapter == null) {
            C0535I5.t0(getActivity(), getString(R.string.Unable_process_request));
        } else if (cancelTicketPassengerAdapter.isCantegency() && this.f4480a.isCantegency() && !this.f4480a.isAllPassengersSelected()) {
            FragmentActivity activity = getActivity();
            C0535I5.m(activity, false, "* " + this.b.getErrorMessage() + "\n* Please select all Passengers.", getString(R.string.error), getString(R.string.OK), new l()).show();
        } else if (this.b.getReservationId() == null) {
            C0535I5.m(getActivity(), false, getString(R.string.invalid_transaction_id), getString(R.string.error), getString(R.string.OK), new m()).show();
        } else if (this.f4480a.getPassengerToken().equalsIgnoreCase("NNNNNN") && (this.noOfPassenger.getText().toString().equalsIgnoreCase("") || this.noOfPassenger.getText().toString().equalsIgnoreCase("0") || this.noOfPassenger.getText().toString().equalsIgnoreCase("No. of Passenger"))) {
            C0535I5.m(getActivity(), false, getString(R.string.Please_select_passengers_for_cancellation), getString(R.string.error), getString(R.string.OK), new n()).show();
        } else if (this.f4480a.getPassengerToken().equalsIgnoreCase("NNNNNN") && (!this.noOfPassenger.getText().toString().equalsIgnoreCase("") || !this.noOfPassenger.getText().toString().equalsIgnoreCase("0") || !this.noOfPassenger.getText().toString().equalsIgnoreCase("No. of Passenger"))) {
            C0535I5.p(getActivity(), false, getString(R.string.cancel_only_dmrc_tkt), getString(R.string.CONFIRM_CANCELLATIONS), getString(R.string.confirm), new o(), getString(R.string.cancel), new p()).show();
        } else if (this.f4486b) {
            C0535I5.p(getActivity(), false, getString(R.string.Your_Connecting_Journey_delinked), getString(R.string.CONFIRM_CANCELLATIONS), getString(R.string.yes), new a(), getString(R.string.no), new b()).show();
        } else {
            if (!this.selectAllDmrcTicket.isChecked()) {
                String.valueOf(this.noOfPassenger.getText());
                if (String.valueOf(this.noOfPassenger.getText()).length() != 1) {
                    if ((!this.selectall.isChecked() || this.selectAllDmrcTicket.isChecked() || !this.noOfPassenger.getText().toString().equalsIgnoreCase("")) && !this.noOfPassenger.getText().toString().equalsIgnoreCase("0") && !this.noOfPassenger.getText().toString().equalsIgnoreCase("No. of Passenger")) {
                        C0535I5.p(getActivity(), false, getString(R.string.Do_you_want_Cancel_ticket), getString(R.string.CONFIRM_CANCELLATIONS), getString(R.string.yes), new g(), getString(R.string.no), new h()).show();
                        return;
                    }
                    C0535I5.t0(getActivity(), getString(R.string.metro_tkt_booked));
                    C0535I5.p(getActivity(), false, getString(R.string.Do_you_want_Cancel_only_railway_ticket), getString(R.string.CONFIRM_CANCELLATIONS), getString(R.string.yes), new e(), getString(R.string.no), new f()).show();
                    return;
                }
            }
            C0535I5.p(getActivity(), false, getString(R.string.cancel_dmrc_railway_tkt), getString(R.string.CONFIRM_CANCELLATIONS), getString(R.string.confirm), new c(), getString(R.string.cancel), new d()).show();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_cancel_inner, (ViewGroup) null);
        this.f4479a = getActivity();
        ButterKnife.bind((Object) this, inflate);
        BookingResponseDTO bookingResponseDTO = (BookingResponseDTO) getArguments().getSerializable("tkt");
        this.b = bookingResponseDTO;
        C0793b1 b1Var = C0793b1.a;
        StationDb stationDb = b1Var.f3911a;
        if (bookingResponseDTO.getBoardingDate() != null) {
            C0535I5.f3621a.format(this.b.getBoardingDate());
        }
        if (this.b.getDestArrvDate() != null) {
            C0535I5.f3621a.format(this.b.getDestArrvDate());
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.cancel_detail_bottom, googleAdParamDTO);
        this.tvFavpnricon.setVisibility(4);
        this.passengerList.setLayoutManager(new LinearLayoutManager(this.f4479a));
        this.pnr.setText(this.b.getPnrNumber());
        TextView textView = this.trainno;
        textView.setText("(" + this.b.getTrainNumber() + ")");
        this.trainName.setText(this.b.getTrainName());
        HomeActivity.x();
        Date journeyDate2 = this.b.getJourneyDate();
        Locale locale = new Locale("hi", "IN");
        new SimpleDateFormat("yyyy-MM-dd");
        SpannableString spannableString = new SpannableString(new SimpleDateFormat("EEE\ndd", locale).format(journeyDate2));
        try {
            RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.8f);
            RelativeSizeSpan relativeSizeSpan2 = new RelativeSizeSpan(2.0f);
            spannableString.setSpan(relativeSizeSpan, 0, 3, 18);
            spannableString.setSpan(relativeSizeSpan2, 4, spannableString.length(), 18);
        } catch (Exception e2) {
            e2.getMessage();
        }
        if (this.b.getBoardingDate() != null) {
            this.journeyDate.setText(C0535I5.U(this.b.getBoardingDate()));
        } else {
            this.journeyDate.setText(C0535I5.U(this.b.getJourneyDate()));
        }
        TextView textView2 = this.tocitycode;
        textView2.setText(C0535I5.s0(stationDb.m(this.b.getDestStn())) + "(" + this.b.getDestStn() + ")");
        if (C1450w1.f7024c) {
            this.selectAlllayout.setVisibility(8);
        }
        this.selectall.setOnClickListener(new j());
        this.selectAllDmrcTicket.setOnClickListener(new k());
        String reservationId = this.b.getReservationId();
        if (!C0535I5.O((ConnectivityManager) this.f4479a.getSystemService("connectivity"), this.f4479a)) {
            new Handler().postDelayed(new C0777a4(), 5000);
        } else {
            this.f4478a = ProgressDialog.show(getActivity(), getString(R.string.Fetching_Ticket_Details), getString(R.string.please_wait_text));
            String f2 = C0657Qt.f();
            String format = String.format("/%s", new Object[]{reservationId});
            ((Om) C0657Qt.c(b1Var.f3912a)).M0(f2 + "historySearchByTxnId" + format, "C").c(C1181iv.a()).a(E0.a()).b(new A(this));
        }
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4478a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4478a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131362886})
    public void onDmrcDecrementClick() {
        this.selectAllDmrcTicket.setChecked(false);
        String trim = this.noOfPassenger.getText().toString().trim();
        if (trim.isEmpty()) {
            this.c = 1;
        } else {
            try {
                this.c = Integer.parseInt(trim);
            } catch (NumberFormatException unused) {
                this.c = 1;
            }
        }
        int i2 = this.c;
        int i3 = i2 - 1;
        if (i2 < 2) {
            this.noOfPassenger.setText("No. of Passenger");
            this.selected_psgn.setText("(" + this.e + RemoteSettings.FORWARD_SLASH_STRING + this.b.getMetroServiceDetail().getNumberOfPassengerOpted() + ")");
            return;
        }
        this.noOfPassenger.setText(String.valueOf(i3));
        this.selected_psgn.setText("(" + String.valueOf(i3) + RemoteSettings.FORWARD_SLASH_STRING + this.b.getMetroServiceDetail().getNumberOfPassengerOpted() + ")");
    }

    @OnClick({2131362887})
    public void onDmrcIncrementtClick() {
        if (this.selectAllDmrcTicket.isChecked()) {
            this.selectAllDmrcTicket.setChecked(true);
        } else {
            this.selectAllDmrcTicket.setChecked(false);
        }
        String trim = this.noOfPassenger.getText().toString().trim();
        if (trim.isEmpty()) {
            this.c = 0;
        } else {
            try {
                this.c = Integer.parseInt(trim);
            } catch (NumberFormatException unused) {
                this.c = 0;
            }
        }
        int i2 = this.c;
        int i3 = i2 + 1;
        if (i2 >= this.d - this.e) {
            this.noOfPassenger.setText(String.valueOf(i2));
            return;
        }
        this.noOfPassenger.setText(String.valueOf(i3));
        TextView textView = this.selected_psgn;
        textView.setText("(" + String.valueOf(i3) + RemoteSettings.FORWARD_SLASH_STRING + this.b.getMetroServiceDetail().getNumberOfPassengerOpted() + ")");
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f4478a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4478a.dismiss();
        }
        C0535I5.u();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4478a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4478a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363604})
    public void rme() {
        this.f4478a = ProgressDialog.show(this.f4479a, getString(R.string.refund_amount_information), getString(R.string.please_wait_text));
        String f2 = C0657Qt.f();
        String format = String.format("/%s/%s", new Object[]{this.b.getPnrNumber(), this.f4480a.getPassengerToken()});
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).I0(f2 + "cancelChargeEnq" + format).c(C1181iv.a()).a(E0.a()).b(new C1054z(this));
    }

    @OnClick({2131363619})
    public void sortBottomLLClick() {
        this.refund_enquiry_bottom_ll.setVisibility(8);
    }
}
