package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.TDRItemHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import rx.Subscriber;

public class TdrHistoryFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f5148a;

    /* renamed from: a  reason: collision with other field name */
    public C0816cB f5149a = null;

    /* renamed from: a  reason: collision with other field name */
    public TDRItemHolder f5150a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<BookingResponseDTO> f5151a;

    /* renamed from: a  reason: collision with other field name */
    public C1223kn f5152a;
    @BindView(2131362060)
    TextView booking;
    @BindView(2131363838)
    RecyclerView bookingItems;
    @BindView(2131362395)
    TextView departure;
    @BindView(2131362651)
    AdManagerAdView file_tdr_bottom;
    @BindView(2131363975)
    TextView sort_by_spinner_text;
    @BindView(2131363978)
    RelativeLayout sortby_bottom_ll;
    @BindView(2131364080)
    AdManagerAdView tdrhistory_add_top;

    public class b extends Subscriber<C0707Ue> {
        public b() {
        }

        public final void onCompleted() {
            int i = TdrHistoryFragment.c;
            TdrHistoryFragment.this.a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = TdrHistoryFragment.c;
            th.getClass();
            th.getMessage();
            TdrHistoryFragment.this.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            C0707Ue ue = (C0707Ue) obj;
            TdrHistoryFragment tdrHistoryFragment = TdrHistoryFragment.this;
            if (ue != null) {
                try {
                    if (ue.getErrorMsg() == null || ue.getErrorMsg().equalsIgnoreCase("no transaction found.")) {
                        TicketHistoryUtil.a(ue.getBookingResponseList(), TicketHistoryUtil.SortFor.TDR_HISTORY);
                        ArrayList<BookingResponseDTO> allJourney = TicketHistoryUtil.f.getAllJourney();
                        tdrHistoryFragment.f5151a = allJourney;
                        if (allJourney.isEmpty()) {
                            C0535I5.t0(tdrHistoryFragment.getActivity(), tdrHistoryFragment.getString(R.string.no_TDR_Transactions));
                        }
                        tdrHistoryFragment.g();
                        return;
                    }
                    C0535I5.m(tdrHistoryFragment.getActivity(), false, ue.getErrorMsg(), tdrHistoryFragment.getString(R.string.information), tdrHistoryFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } catch (Exception e) {
                    int i = TdrHistoryFragment.c;
                    e.getMessage();
                    tdrHistoryFragment.a.dismiss();
                    C0535I5.t0(tdrHistoryFragment.getActivity(), tdrHistoryFragment.getResources().getString(R.string.unable_process_message));
                }
            } else {
                int i2 = TdrHistoryFragment.c;
                tdrHistoryFragment.a.dismiss();
                C0535I5.m(tdrHistoryFragment.getActivity(), false, tdrHistoryFragment.getString(R.string.unable_process), tdrHistoryFragment.getString(R.string.error), tdrHistoryFragment.getString(R.string.OK), new w0()).show();
            }
        }
    }

    public class c implements Comparator<BookingResponseDTO> {
        public final int compare(Object obj, Object obj2) {
            return -((BookingResponseDTO) obj).getJourneyDate().compareTo(((BookingResponseDTO) obj2).getJourneyDate());
        }
    }

    public class d implements TDRItemHolder.a {
        public d() {
        }
    }

    static {
        C1354qp.R(TdrHistoryFragment.class);
    }

    public TdrHistoryFragment() {
        new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss' HRS'");
    }

    public static void f(TdrHistoryFragment tdrHistoryFragment, BookingResponseDTO bookingResponseDTO, BookingResponseDTO bookingResponseDTO2, Date date) {
        tdrHistoryFragment.getClass();
        bookingResponseDTO.setInsuranceOpted(bookingResponseDTO2.getInsuranceOpted());
        bookingResponseDTO.setInsuranceCompany(bookingResponseDTO2.getInsuranceCompany());
        bookingResponseDTO.setInsuranceOpted(bookingResponseDTO2.getInsuranceOpted());
        bookingResponseDTO.setPolicyIssueDate(bookingResponseDTO2.getPolicyIssueDate());
        bookingResponseDTO.setInsuranceCompanyUrl(bookingResponseDTO2.getInsuranceCompanyUrl());
        bookingResponseDTO.setRequestedClientTransactionId(bookingResponseDTO2.getRequestedClientTransactionId());
        bookingResponseDTO.setNumberOfpassenger(bookingResponseDTO2.getNumberOfpassenger());
        bookingResponseDTO.setTimeTableFlag(bookingResponseDTO2.getTimeTableFlag());
        bookingResponseDTO.setPnrNumber(bookingResponseDTO2.getPnrNumber());
        bookingResponseDTO.setDepartureTime(bookingResponseDTO2.getDepartureTime());
        bookingResponseDTO.setArrivalTime(bookingResponseDTO2.getArrivalTime());
        bookingResponseDTO.setReasonType(bookingResponseDTO2.getReasonType());
        bookingResponseDTO.setReasonIndex(bookingResponseDTO2.getReasonIndex());
        bookingResponseDTO.setErrorMessage(bookingResponseDTO2.getErrorMessage());
        bookingResponseDTO.setInformationMessage(bookingResponseDTO2.getInformationMessage());
        bookingResponseDTO.setJourneyDate(bookingResponseDTO2.getJourneyDate());
        bookingResponseDTO.setBoardingDate(bookingResponseDTO2.getBoardingDate());
        bookingResponseDTO.setDestArrvDate(bookingResponseDTO2.getDestArrvDate());
        bookingResponseDTO.setBookingDate(bookingResponseDTO2.getBookingDate());
        bookingResponseDTO.setNumberOfChilds(bookingResponseDTO2.getNumberOfChilds());
        bookingResponseDTO.setNumberOfAdults(bookingResponseDTO2.getNumberOfAdults());
        bookingResponseDTO.setTdrDetailsDTO(bookingResponseDTO2.getTdrDetailsDTO());
        bookingResponseDTO.setBoardingStn(bookingResponseDTO2.getBoardingStn());
        bookingResponseDTO.setErsGovMsg(bookingResponseDTO2.getErsGovMsg());
        bookingResponseDTO.setResvnUptoStn(bookingResponseDTO2.getResvnUptoStn());
        bookingResponseDTO.setJourneyClass(bookingResponseDTO2.getJourneyClass());
        bookingResponseDTO.setJourneyQuota(bookingResponseDTO2.getJourneyQuota());
        bookingResponseDTO.setTotalCollectibleAmount(bookingResponseDTO2.getTotalCollectibleAmount());
        bookingResponseDTO.setPsgnDtlList(bookingResponseDTO2.getPsgnDtlList());
        bookingResponseDTO.setClientTransactionId(bookingResponseDTO2.getClientTransactionId());
        bookingResponseDTO.setBookingErrorMessage(bookingResponseDTO2.getBookingErrorMessage());
        bookingResponseDTO.setScheduleDepartureFlag(bookingResponseDTO2.getScheduleDepartureFlag());
        bookingResponseDTO.setScheduleArrivalFlag(bookingResponseDTO2.getScheduleArrivalFlag());
        bookingResponseDTO.setCancellationDetails(bookingResponseDTO2.getCancellationDetails());
        bookingResponseDTO.setResvDetails(bookingResponseDTO2.getResvDetails());
        bookingResponseDTO.setInfantDetails(bookingResponseDTO2.getInfantDetails());
        bookingResponseDTO.setNoOfCanPsgn(bookingResponseDTO2.getNoOfCanPsgn());
        bookingResponseDTO.setNoOfCanChild(bookingResponseDTO2.getNoOfCanChild());
        bookingResponseDTO.setTransactionStatusEtTkt(bookingResponseDTO2.getTransactionStatusEtTkt());
        bookingResponseDTO.setTrainChartStatus(bookingResponseDTO2.getTrainChartStatus());
        bookingResponseDTO.setCurrentPrsAmt(bookingResponseDTO2.getCurrentPrsAmt());
        bookingResponseDTO.setTaServiceCharge(bookingResponseDTO2.getTaServiceCharge());
        bookingResponseDTO.setServiceChargeTotal(bookingResponseDTO2.getServiceChargeTotal());
        bookingResponseDTO.setPrsBookingResponse(bookingResponseDTO2.getPrsBookingResponse());
        bookingResponseDTO.setTrainStartDate(bookingResponseDTO2.getTrainStartDate());
        bookingResponseDTO.setTktLegendMessage(bookingResponseDTO2.getTktLegendMessage());
        bookingResponseDTO.setBookingTatkalCharge(bookingResponseDTO2.getBookingTatkalCharge());
        bookingResponseDTO.setBookingResvCharge(bookingResponseDTO2.getBookingResvCharge());
        bookingResponseDTO.setBookingFuelCharge(bookingResponseDTO2.getBookingFuelCharge());
        bookingResponseDTO.setBookingSuperFastCharge(bookingResponseDTO2.getBookingSuperFastCharge());
        bookingResponseDTO.setCurTatkalCharge(bookingResponseDTO2.getCurTatkalCharge());
        bookingResponseDTO.setCurResvCharge(bookingResponseDTO2.getCurResvCharge());
        bookingResponseDTO.setCurFuelCharge(bookingResponseDTO2.getCurFuelCharge());
        bookingResponseDTO.setCurSuperFastCharge(bookingResponseDTO2.getCurSuperFastCharge());
        bookingResponseDTO.setRefundStatusEtTkt(bookingResponseDTO2.getRefundStatusEtTkt());
        bookingResponseDTO.setTicketType(bookingResponseDTO2.getTicketType());
        bookingResponseDTO.setRetryWithoutChoice(bookingResponseDTO2.getRetryWithoutChoice());
        bookingResponseDTO.setTimeTableFlag(bookingResponseDTO2.getTimeTableFlag());
        bookingResponseDTO.setTicketAmount(bookingResponseDTO2.getTicketAmount());
        bookingResponseDTO.setRefundAmount(bookingResponseDTO2.getRefundAmount());
        bookingResponseDTO.setCancellationDate(bookingResponseDTO2.getCancellationDate());
        bookingResponseDTO.setLapNumberEtTkt(bookingResponseDTO2.getLapNumberEtTkt());
        bookingResponseDTO.setPrefCoachId(bookingResponseDTO2.getPrefCoachId());
        bookingResponseDTO.setIgnoreChoiceIf(bookingResponseDTO2.getIgnoreChoiceIf());
        bookingResponseDTO.setAutoUpgradeChoice(bookingResponseDTO2.getAutoUpgradeChoice());
        bookingResponseDTO.setGnToCkOpt(bookingResponseDTO2.getGnToCkOpt());
        bookingResponseDTO.setTicketChoiceBerth(bookingResponseDTO2.getTicketChoiceBerth());
        bookingResponseDTO.setTicketChoiceCoach(bookingResponseDTO2.getTicketChoiceCoach());
        bookingResponseDTO.setDispatchDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS").format(date));
        bookingResponseDTO.setBookedQuota(bookingResponseDTO2.getBookedQuota());
        bookingResponseDTO.setReservationUpTo(bookingResponseDTO2.getReservationUpTo());
        bookingResponseDTO.setNoOfBkdChild(bookingResponseDTO2.getNoOfBkdChild());
        bookingResponseDTO.setNoOfBkdPsgn(bookingResponseDTO2.getNoOfBkdPsgn());
        bookingResponseDTO.setScheduleArrivalFlag(bookingResponseDTO2.getScheduleArrivalFlag());
        bookingResponseDTO.setScheduleDepartureFlag(bookingResponseDTO2.getScheduleDepartureFlag());
        bookingResponseDTO.setScheduleDepartureFlag(bookingResponseDTO2.getScheduleDepartureFlag());
        bookingResponseDTO.setQuota(bookingResponseDTO2.getQuota());
        bookingResponseDTO.setReservationId(bookingResponseDTO2.getReservationId());
        if (TicketHistoryUtil.f5370a == TicketHistoryUtil.SortFor.FAILED_TICKETS) {
            bookingResponseDTO.setCancellationId(bookingResponseDTO2.getCancellationId());
            bookingResponseDTO.setTrainNumber(bookingResponseDTO2.getTrainNumber());
            bookingResponseDTO.setTrainName(bookingResponseDTO2.getTrainName());
        }
    }

    @OnClick({2131362060})
    public void arrival(View view) {
        h(this.booking, R.color.dark);
        h(this.departure, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.booking.setTextAppearance(getActivity(), R.style.fontForbold);
        k(2);
        this.sort_by_spinner_text.setText(getString(R.string.booking_date));
        this.sortby_bottom_ll.setVisibility(8);
    }

    @OnClick({2131362395})
    public void departure(View view) {
        h(this.booking, R.color.white);
        h(this.departure, R.color.dark);
        this.departure.setTextAppearance(getActivity(), R.style.fontForbold);
        this.booking.setTextAppearance(getActivity(), R.style.fontForNormal);
        k(1);
        this.sort_by_spinner_text.setText(getString(R.string.departure_date));
        this.sortby_bottom_ll.setVisibility(8);
    }

    public final void g() {
        Collections.sort(this.f5151a, new c());
        TDRItemHolder tDRItemHolder = new TDRItemHolder(this.f5148a, this.f5151a, new d());
        this.f5150a = tDRItemHolder;
        this.bookingItems.setAdapter(tDRItemHolder);
        this.bookingItems.setLayoutManager(new LinearLayoutManager(getContext()));
        this.a.dismiss();
    }

    public final void h(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void i() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f5148a)) {
            new Handler().postDelayed(new a(), 5000);
            return;
        }
        this.a = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticket_List), getString(R.string.please_wait_text), true, false);
        C1223kn knVar = C0793b1.a.f3912a;
        this.f5152a = knVar;
        if (knVar == null) {
            TicketHistoryUtil.c();
        }
        try {
            C0813c3 c3Var = TicketHistoryUtil.f;
            if (c3Var == null || c3Var.getAllJourney().size() <= 0) {
                String f = C0657Qt.f();
                ((Om) C0657Qt.c(this.f5152a)).P0(f + "fileTDRHistorySearch").c(C1181iv.a()).a(E0.a()).b(new b());
                return;
            }
            this.f5151a = TicketHistoryUtil.f.getAllJourney();
            g();
        } catch (Exception e) {
            this.a.dismiss();
            e.getMessage();
            C0535I5.t0(getActivity(), getString(R.string.please_try_again));
        }
    }

    public final void j(BookingResponseDTO bookingResponseDTO) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("TicketErs", bookingResponseDTO);
        TdrDisplayFragment tdrDisplayFragment = new TdrDisplayFragment();
        tdrDisplayFragment.setArguments(bundle);
        HomeActivity.n(getActivity(), tdrDisplayFragment, C1218kf.TDR_DETAILS.a(), Boolean.TRUE, Boolean.FALSE);
    }

    public final void k(int i) {
        ArrayList<BookingResponseDTO> arrayList = this.f5151a;
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<BookingResponseDTO> arrayList2 = this.f5151a;
            if (arrayList2 == null || arrayList2.size() == 0) {
                arrayList2 = null;
            } else if (i == 1) {
                Collections.sort(arrayList2, new C0467Bz());
            } else if (i == 2) {
                Collections.sort(arrayList2, new C0478Cz());
            }
            this.f5151a = arrayList2;
            this.f5150a.notifyDataSetChanged();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_file_tdr, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f5148a = getContext();
        TicketHistoryUtil.f5370a = TicketHistoryUtil.SortFor.TDR_HISTORY;
        try {
            C0816cB cBVar = this.f5149a;
            if (cBVar == null) {
                C0816cB cBVar2 = new C0816cB(new C0491Dz(this), 120);
                this.f5149a = cBVar2;
                cBVar2.a();
            } else {
                cBVar.a();
            }
        } catch (Exception e) {
            e.getMessage();
            this.a.dismiss();
            i();
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.tdrhistory_add_top, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.file_tdr_bottom, googleAdParamDTO);
        HomeActivity.J();
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363979})
    public void sortByClick() {
        this.sortby_bottom_ll.setVisibility(8);
        if (this.sortby_bottom_ll.getVisibility() == 8) {
            this.sortby_bottom_ll.setVisibility(0);
        } else {
            this.sortby_bottom_ll.setVisibility(8);
        }
    }

    @OnClick({2131363978})
    public void sortSelectClick() {
        if (this.sortby_bottom_ll.getVisibility() == 8) {
            this.sortby_bottom_ll.setVisibility(0);
        } else {
            this.sortby_bottom_ll.setVisibility(8);
        }
    }

    public class a implements Runnable {
        public final void run() {
        }
    }
}
