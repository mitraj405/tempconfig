package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.BookMealPassengerAdaptor;
import cris.org.in.ima.db.StationDb;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.PnrEnquiryResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import rx.Subscriber;

public class BookMealFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public FragmentActivity a;

    /* renamed from: a  reason: collision with other field name */
    public BookMealPassengerAdaptor f4461a;

    /* renamed from: a  reason: collision with other field name */
    public final StationDb f4462a = C0793b1.a.f3911a;

    /* renamed from: a  reason: collision with other field name */
    public final BookMealFragment f4463a = this;

    /* renamed from: a  reason: collision with other field name */
    public PnrEnquiryResponseDTO f4464a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f4465a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4466a = false;
    public PnrEnquiryResponseDTO b;

    /* renamed from: c  reason: collision with other field name */
    public String f4467c = null;
    @BindView(2131362403)
    TextView destArrDate;
    @BindView(2131362404)
    TextView destArrTime;
    @BindView(2131362715)
    TextView fromcitycode;
    @BindView(2131362920)
    TextView journeyDate;
    @BindView(2131362925)
    TextView journeyTime;
    @BindView(2131363825)
    RecyclerView passengerList;
    @BindView(2131363506)
    TextView pnr;
    @BindView(2131364156)
    TextView tktDetails;
    @BindView(2131364169)
    TextView tocitycode;
    @BindView(2131364201)
    TextView trainName;
    @BindView(2131364203)
    TextView trainno;
    @BindView(2131364247)
    TextView travel_time;
    @BindView(2131364248)
    LinearLayout traveltime2;
    @BindView(2131364404)
    ImageView tvFavpnricon;

    public class a extends Subscriber<Wp> {
        public a() {
        }

        public final void onCompleted() {
            int i = BookMealFragment.c;
        }

        public final void onError(Throwable th) {
            int i = BookMealFragment.c;
            th.getClass();
            th.getMessage();
            BookMealFragment.this.getClass();
            throw null;
        }

        public final void onNext(Object obj) {
            Wp wp = (Wp) obj;
            int i = (wp.getTotalPayableAmount() > 0.0d ? 1 : (wp.getTotalPayableAmount() == 0.0d ? 0 : -1));
            BookMealFragment bookMealFragment = BookMealFragment.this;
            if (i == 0) {
                FragmentActivity fragmentActivity = bookMealFragment.a;
                C0535I5.p(fragmentActivity, false, fragmentActivity.getResources().getString(R.string.opt_for_1_passenger), bookMealFragment.a.getResources().getString(R.string.error), bookMealFragment.a.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                return;
            }
            C0535I5.p(bookMealFragment.getContext(), false, "Total Payable Amount is ₹" + wp.getTotalPayableAmount() + ". Do You Want To Continue?", bookMealFragment.getString(R.string.confirmation), bookMealFragment.getString(R.string.Proceed_to_Pay) + " ₹ " + wp.getTotalPayableAmount(), new C1051w(this, wp), bookMealFragment.getString(R.string.cancel), new C1052x()).show();
        }
    }

    static {
        C1354qp.R(BookMealFragment.class);
    }

    @OnClick({2131363383})
    public void hj() {
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).L(C1058d.z(C0657Qt.f(), "initPostBookingServices"), this.f4461a.preparePostBookingRequestDto()).c(C1181iv.a()).a(E0.a()).b(new a());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_book_meal, (ViewGroup) null);
        this.a = getActivity();
        ButterKnife.bind((Object) this, inflate);
        Bundle arguments = getArguments();
        this.f4467c = arguments.getString("txnId");
        this.b = (PnrEnquiryResponseDTO) arguments.getSerializable("tkt");
        this.f4464a = (PnrEnquiryResponseDTO) arguments.getSerializable("tkt");
        StationDb stationDb = C0793b1.a.f3911a;
        this.tvFavpnricon.setVisibility(4);
        this.passengerList.setLayoutManager(new LinearLayoutManager(this.a));
        this.pnr.setText(this.f4464a.getPnrNumber());
        TextView textView = this.trainno;
        textView.setText("(" + this.f4464a.getTrainNumber() + ")");
        this.trainName.setText(this.f4464a.getTrainName());
        HomeActivity.x();
        Date dateOfJourney = this.f4464a.getDateOfJourney();
        AlertDialog alertDialog = C0535I5.f3619a;
        Locale locale = new Locale("hi", "IN");
        new SimpleDateFormat("yyyy-MM-dd");
        SpannableString spannableString = new SpannableString(new SimpleDateFormat("EEE\ndd", locale).format(dateOfJourney));
        try {
            RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.8f);
            RelativeSizeSpan relativeSizeSpan2 = new RelativeSizeSpan(2.0f);
            spannableString.setSpan(relativeSizeSpan, 0, 3, 18);
            spannableString.setSpan(relativeSizeSpan2, 4, spannableString.length(), 18);
        } catch (Exception unused) {
        }
        this.destArrDate.setText(C0535I5.U(this.f4464a.getDateOfArrivalDestination()));
        if (this.f4464a.getDateOfJourney() != null) {
            this.journeyDate.setText(C0535I5.U(this.f4464a.getDateOfJourney()));
        } else {
            this.journeyDate.setText(C0535I5.U(this.f4464a.getDateOfJourney()));
        }
        TextView textView2 = this.tocitycode;
        textView2.setText(C0535I5.s0(stationDb.m(this.f4464a.getDestinationStation())) + "(" + this.f4464a.getDestinationStation() + ")");
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        C0535I5.u();
    }

    public final void onResume() {
        String str;
        super.onResume();
        if (this.f4466a) {
            this.f4464a = this.b;
        }
        PnrEnquiryResponseDTO pnrEnquiryResponseDTO = this.f4464a;
        if (pnrEnquiryResponseDTO != null) {
            this.travel_time.setVisibility(4);
            ArrayList<PassengerDetailDTO> passengerList2 = pnrEnquiryResponseDTO.getPassengerList();
            this.f4465a = passengerList2;
            Collections.sort(passengerList2, new C0776a3());
            if (pnrEnquiryResponseDTO.getJourneyClass() == null) {
                str = "";
            } else if (xx.e(pnrEnquiryResponseDTO.getJourneyClass()) != null) {
                str = " | " + xx.e(pnrEnquiryResponseDTO.getJourneyClass());
            } else {
                str = " | " + pnrEnquiryResponseDTO.getJourneyClass();
            }
            int size = pnrEnquiryResponseDTO.getPassengerList().size();
            StationDb stationDb = this.f4462a;
            if (size > 1) {
                this.tktDetails.setText(pnrEnquiryResponseDTO.getPassengerList().size() + " " + getString(R.string.passengers) + " | " + pnrEnquiryResponseDTO.getQuota() + str + " | " + C0535I5.s0(stationDb.m(pnrEnquiryResponseDTO.getSourceStation())) + "(" + pnrEnquiryResponseDTO.getSourceStation() + ") | " + C0535I5.h(pnrEnquiryResponseDTO.getDateOfJourney()));
            } else {
                this.tktDetails.setText(pnrEnquiryResponseDTO.getPassengerList().size() + " " + getString(R.string.passenger) + " | " + pnrEnquiryResponseDTO.getQuota() + str + " | " + C0535I5.s0(stationDb.m(pnrEnquiryResponseDTO.getSourceStation())) + "(" + pnrEnquiryResponseDTO.getSourceStation() + ") | " + C0535I5.h(pnrEnquiryResponseDTO.getDateOfJourney()));
            }
            this.fromcitycode.setText(C0535I5.s0(C0793b1.a.f3911a.m(pnrEnquiryResponseDTO.getBoardingPoint())) + "(" + pnrEnquiryResponseDTO.getBoardingPoint() + ")");
            this.destArrTime.setVisibility(8);
            this.journeyTime.setVisibility(8);
            this.traveltime2.setVisibility(8);
            this.f4466a = true;
            BookMealPassengerAdaptor bookMealPassengerAdaptor = new BookMealPassengerAdaptor(this.f4463a, this.f4465a, pnrEnquiryResponseDTO, this.f4467c);
            this.f4461a = bookMealPassengerAdaptor;
            this.passengerList.setAdapter(bookMealPassengerAdaptor);
        }
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }
}
