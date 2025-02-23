package cris.org.in.ima.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.view_holder.TDRHistoryPassengerViewHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class TdrDisplayFragment extends Fragment {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public SimpleDateFormat f5146a = new SimpleDateFormat("EEE, dd MMM");
    @BindView(2131361960)
    TextView arvDate;
    @BindView(2131361961)
    TextView arvTime;
    public final SimpleDateFormat b = new SimpleDateFormat("HH:mm");
    @BindView(2131362262)
    TextView clsQtBoarding;
    @BindView(2131362395)
    TextView deptDate;
    @BindView(2131362396)
    TextView deptTime;
    @BindView(2131362712)
    TextView fromStation;
    @BindView(2131363208)
    ImageView menu;
    @BindView(2131363506)
    TextView pnr;
    @BindView(2131363549)
    RecyclerView psgnList;
    @BindView(2131363625)
    TextView refundStatusWithZonalRailway;
    @BindView(2131364155)
    ScrollView scrollView;
    @BindView(2131364071)
    TextView tdrFiledDate;
    @BindView(2131364073)
    TextView tdrReason;
    @BindView(2131364075)
    TextView tdrRepDate;
    @BindView(2131364077)
    TextView tdrStatus;
    @BindView(2131364079)
    TextView tdrZone;
    @BindView(2131364070)
    AdManagerAdView tdr_details_bottom;
    @BindView(2131364076)
    LinearLayout tdr_repo_date_ll;
    @BindView(2131364078)
    TextView tdr_txnid;
    @BindView(2131364167)
    TextView toStation;
    @BindView(2131364184)
    TextView totalFare;
    @BindView(2131364201)
    TextView trainName;
    @BindView(2131364203)
    TextView trainNo;
    @BindView(2131364247)
    TextView travelTime;

    static {
        C1354qp.R(TdrDisplayFragment.class);
        new SimpleDateFormat("yyyyMMdd");
    }

    public TdrDisplayFragment() {
        new SimpleDateFormat("dd MMM yyyy HH:mm");
        new ArrayList();
        new HashMap();
        new ArrayList();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        String str;
        View inflate = layoutInflater.inflate(R.layout.activity_tdr_history_inner, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        this.a = getContext();
        StrictMode.setVmPolicy(builder.build());
        C0535I5.H(getActivity(), getView());
        this.refundStatusWithZonalRailway.setVisibility(0);
        if (IrctcImaApplication.e.equals("hi")) {
            this.f5146a = new SimpleDateFormat("EEE, dd MMM", new Locale("hi", "IN"));
        }
        Bundle arguments = getArguments();
        C0793b1 b1Var = C0793b1.a;
        if (arguments != null) {
            BookingResponseDTO bookingResponseDTO = (BookingResponseDTO) arguments.getSerializable("TicketErs");
            bookingResponseDTO.toString();
            StationDb stationDb = b1Var.f3911a;
            this.tdr_txnid.setText(" " + bookingResponseDTO.getReservationId());
            this.trainName.setText(bookingResponseDTO.getTrainName());
            this.trainNo.setText("(" + bookingResponseDTO.getTrainNumber() + ")");
            this.pnr.setText(bookingResponseDTO.getPnrNumber());
            this.fromStation.setText(stationDb.m(bookingResponseDTO.getFromStn()) + " (" + bookingResponseDTO.getFromStn() + ")");
            this.toStation.setText(stationDb.m(bookingResponseDTO.getDestStn()) + " (" + bookingResponseDTO.getDestStn() + ")");
            stationDb.close();
            Date boardingDate = bookingResponseDTO.getBoardingDate();
            SimpleDateFormat simpleDateFormat = this.b;
            if (boardingDate != null) {
                this.deptDate.setText(this.f5146a.format(Long.valueOf(bookingResponseDTO.getBoardingDate().getTime())));
                if (bookingResponseDTO.getScheduleDepartureFlag() == null || !bookingResponseDTO.getScheduleDepartureFlag().booleanValue()) {
                    this.deptTime.setText(" *N.A.");
                } else {
                    this.deptTime.setText(simpleDateFormat.format(Long.valueOf(bookingResponseDTO.getBoardingDate().getTime())));
                }
            }
            if (bookingResponseDTO.getDestArrvDate() != null) {
                this.arvDate.setText(this.f5146a.format(bookingResponseDTO.getDestArrvDate()));
                if (bookingResponseDTO.getScheduleArrivalFlag() == null || !bookingResponseDTO.getScheduleArrivalFlag().booleanValue()) {
                    this.arvTime.setText(" *N.A.");
                } else {
                    this.arvTime.setText(simpleDateFormat.format(bookingResponseDTO.getDestArrvDate()));
                }
            } else {
                this.arvDate.setText(" *N.A.");
                this.arvTime.setText(" *N.A.");
            }
            if (bookingResponseDTO.getBoardingDate() == null || bookingResponseDTO.getDestArrvDate() == null) {
                this.travelTime.setVisibility(4);
            } else {
                this.travelTime.setVisibility(0);
                this.travelTime.setText(C0535I5.A(bookingResponseDTO.getBoardingDate(), bookingResponseDTO.getDestArrvDate()));
            }
            try {
                i = Integer.parseInt(bookingResponseDTO.getNoOfBkdChild()) - Integer.parseInt(bookingResponseDTO.getNoOfCanChild());
            } catch (NumberFormatException e) {
                e.getMessage();
                i = 0;
            }
            String str2 = "";
            if (bookingResponseDTO.getNoOfBkdPsgn() == null || bookingResponseDTO.getNoOfCanPsgn() == null || bookingResponseDTO.getNoOfBkdPsgn().trim().equalsIgnoreCase(str2) || bookingResponseDTO.getNoOfCanPsgn().trim().equalsIgnoreCase(str2)) {
                str = str2;
            } else {
                str = str2 + String.valueOf((Integer.parseInt(bookingResponseDTO.getNoOfBkdPsgn()) - Integer.parseInt(bookingResponseDTO.getNoOfCanPsgn())) - i) + " " + getString(R.string.adult) + " ";
            }
            if (!(bookingResponseDTO.getNoOfBkdChild() == null || bookingResponseDTO.getNoOfCanChild() == null)) {
                StringBuilder J = xx.J(str);
                J.append(String.valueOf(Integer.parseInt(bookingResponseDTO.getNoOfBkdChild().trim()) - Integer.parseInt(bookingResponseDTO.getNoOfCanChild().trim())));
                J.append(" ");
                J.append(getString(R.string.child));
                J.append(" ");
                str = J.toString();
            }
            if (bookingResponseDTO.getJourneyClass() != null) {
                StringBuilder n = lf.n(str, " | ");
                n.append(bookingResponseDTO.getJourneyClass());
                str = n.toString();
            }
            if (bookingResponseDTO.getJourneyQuota() != null) {
                StringBuilder n2 = lf.n(str, " | ");
                n2.append(bookingResponseDTO.getJourneyQuota());
                str = n2.toString();
            }
            if (bookingResponseDTO.getTdrDetailsDTO().getRepudiateDate() != null) {
                this.tdr_repo_date_ll.setVisibility(0);
            }
            StringBuilder n3 = lf.n(str, " | ");
            n3.append(stationDb.m(bookingResponseDTO.getBoardingStn()));
            this.clsQtBoarding.setText(n3.toString());
            TextView textView = this.tdrReason;
            String tdrReason2 = bookingResponseDTO.getTdrDetailsDTO().getTdrReason();
            if (tdrReason2 == null) {
                tdrReason2 = str2;
            }
            textView.setText(" ".concat(tdrReason2));
            TextView textView2 = this.tdrZone;
            String tdrZone2 = bookingResponseDTO.getTdrDetailsDTO().getTdrZone();
            if (tdrZone2 == null) {
                tdrZone2 = str2;
            }
            textView2.setText(" ".concat(tdrZone2));
            TextView textView3 = this.tdrFiledDate;
            String replace = bookingResponseDTO.getTdrDetailsDTO().getTdrFilingDate().replace(" HRS", str2);
            if (replace == null) {
                replace = str2;
            }
            textView3.setText(" ".concat(replace));
            this.tdrRepDate.setText(" " + C0535I5.d(bookingResponseDTO.getTdrDetailsDTO().getRepudiateDate()));
            TextView textView4 = this.tdrStatus;
            String tdrStatus2 = bookingResponseDTO.getTdrDetailsDTO().getTdrStatus();
            if (tdrStatus2 != null) {
                str2 = tdrStatus2;
            }
            textView4.setText(" ".concat(str2));
            C0535I5.f3652m = true;
            TDRHistoryPassengerViewHolder tDRHistoryPassengerViewHolder = new TDRHistoryPassengerViewHolder(this.a, bookingResponseDTO.getPsgnDtlList());
            this.psgnList.setLayoutManager(new LinearLayoutManager(getContext()));
            this.psgnList.setAdapter(tDRHistoryPassengerViewHolder);
        }
        b1Var.f3911a.close();
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.tdr_details_bottom, googleAdParamDTO);
        return inflate;
    }

    public final void onPause() {
        super.onPause();
        C0535I5.u();
    }

    public final void onResume() {
        super.onResume();
        C0535I5.u();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.clear();
        super.onSaveInstanceState(bundle);
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }

    @OnClick({2131363625})
    public void refundstatuswithzonalrailwayClick() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://refunds.indianrail.gov.in/refund/refund.ref_status")));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
