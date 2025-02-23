package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.material.tabs.TabLayout;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.TicketViewHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import rx.Subscriber;

public class BookingHistoryFragment extends Fragment {
    public static FragmentActivity a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4469a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4470a;

    /* renamed from: a  reason: collision with other field name */
    public b f4471a;

    /* renamed from: a  reason: collision with other field name */
    public TicketViewHolder f4472a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<BookingResponseDTO> f4473a;

    /* renamed from: a  reason: collision with other field name */
    public C1223kn f4474a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4475a = false;
    @BindView(2131362060)
    TextView booking;
    @BindView(2131363807)
    RecyclerView bookingItems;
    public String c = null;
    @BindView(2131362395)
    TextView departure;
    @BindView(2131362950)
    TextView lastUpdatedTime;
    @BindView(2131363281)
    AdManagerAdView mybooking_bottom;
    @BindView(2131363284)
    AdManagerAdView mybooking_top;
    @BindView(2131363979)
    LinearLayout sortLayout;
    @BindView(2131363974)
    RelativeLayout sort_by_and_lastUpdate;
    @BindView(2131363975)
    TextView sort_by_spinner_text;
    @BindView(2131363978)
    RelativeLayout sortby_bottom_ll;
    @BindView(2131364048)
    TabLayout tabLayout;

    public class a extends ClickableSpan {
        public a() {
        }

        public final void onClick(View view) {
            BookingHistoryFragment bookingHistoryFragment = BookingHistoryFragment.this;
            try {
                bookingHistoryFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.irctc.co.in")));
            } catch (Exception e) {
                FragmentActivity fragmentActivity = BookingHistoryFragment.a;
                e.getMessage();
                Toast.makeText(bookingHistoryFragment.getContext(), bookingHistoryFragment.getString(R.string.no_application_can_handle_this_request), 1).show();
            }
        }
    }

    static {
        C1354qp.R(BookingHistoryFragment.class);
        new SimpleDateFormat("yyyyMMdd");
    }

    public static String f(BookingHistoryFragment bookingHistoryFragment, String str, C0707Ue ue) {
        bookingHistoryFragment.getClass();
        String str2 = "";
        if (!(ue.getBookingResponseList() == null || str == null || str.isEmpty())) {
            Iterator<BookingResponseDTO> it = ue.getBookingResponseList().iterator();
            while (it.hasNext()) {
                BookingResponseDTO next = it.next();
                if (str.equalsIgnoreCase(next.getPnrNumber())) {
                    str2 = next.getReservationId();
                }
            }
        }
        return str2;
    }

    public static void g(BookingHistoryFragment bookingHistoryFragment, BookingResponseDTO bookingResponseDTO, BookingResponseDTO bookingResponseDTO2, Date date) {
        bookingHistoryFragment.getClass();
        bookingResponseDTO.setConnectingPnrNumber(bookingResponseDTO2.getConnectingPnrNumber());
        bookingResponseDTO.setJourneyLap(bookingResponseDTO2.getJourneyLap());
        bookingResponseDTO.setPnrLinkStatus(bookingResponseDTO2.getPnrLinkStatus());
        bookingResponseDTO.setVikalpDTO(bookingResponseDTO2.getVikalpDTO());
        bookingResponseDTO.setVikalpStatus(bookingResponseDTO2.getVikalpStatus());
        bookingResponseDTO.setTrainChartStatus(bookingResponseDTO2.getTrainChartStatus());
        bookingResponseDTO.setInsuranceOpted(bookingResponseDTO2.getInsuranceOpted());
        bookingResponseDTO.setInsuranceCompany(bookingResponseDTO2.getInsuranceCompany());
        bookingResponseDTO.setInsuranceOpted(bookingResponseDTO2.getInsuranceOpted());
        bookingResponseDTO.setInsuranceCharge(bookingResponseDTO2.getInsuranceCharge());
        bookingResponseDTO.setPolicyIssueDate(bookingResponseDTO2.getPolicyIssueDate());
        bookingResponseDTO.setInsuranceCompanyUrl(bookingResponseDTO2.getInsuranceCompanyUrl());
        bookingResponseDTO.setRequestedClientTransactionId(bookingResponseDTO2.getRequestedClientTransactionId());
        bookingResponseDTO.setNumberOfpassenger(bookingResponseDTO2.getNumberOfpassenger());
        bookingResponseDTO.setGstCharge(bookingResponseDTO2.getGstCharge());
        bookingResponseDTO.setGstDetailsDTO(bookingResponseDTO2.getGstDetailsDTO());
        bookingResponseDTO.setGstFlag(bookingResponseDTO2.getGstFlag());
        bookingResponseDTO.setBankName(bookingResponseDTO2.getBankName());
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
        bookingResponseDTO.setTrainNumber(bookingResponseDTO2.getTrainNumber());
        bookingResponseDTO.setFromStn(bookingResponseDTO2.getFromStn());
        bookingResponseDTO.setDestStn(bookingResponseDTO2.getDestStn());
        bookingResponseDTO.setBoardingStn(bookingResponseDTO2.getBoardingStn());
        bookingResponseDTO.setErsGovMsg(bookingResponseDTO2.getErsGovMsg());
        bookingResponseDTO.setResvnUptoStn(bookingResponseDTO2.getResvnUptoStn());
        bookingResponseDTO.setJourneyClass(bookingResponseDTO2.getJourneyClass());
        bookingResponseDTO.setJourneyQuota(bookingResponseDTO2.getJourneyQuota());
        bookingResponseDTO.setTotalCollectibleAmount(bookingResponseDTO2.getTotalCollectibleAmount());
        bookingResponseDTO.setTotalFare(bookingResponseDTO2.getTotalFare());
        bookingResponseDTO.setPsgnDtlList(bookingResponseDTO2.getPsgnDtlList());
        bookingResponseDTO.setRetryBooking(bookingResponseDTO2.getRetryBooking());
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
        bookingResponseDTO.setServiceTax(bookingResponseDTO2.getServiceTax());
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
        bookingResponseDTO.setFailureReason(bookingResponseDTO2.getFailureReason());
        bookingResponseDTO.setPaymentStatus(bookingResponseDTO2.getPaymentStatus());
        bookingResponseDTO.setTransactionAmt(bookingResponseDTO2.getTransactionAmt());
        bookingResponseDTO.setTransactionDate(bookingResponseDTO2.getTransactionDate());
        bookingResponseDTO.setCancellationId(bookingResponseDTO2.getCancellationId());
        bookingResponseDTO.setTicketAmount(bookingResponseDTO2.getTicketAmount());
        bookingResponseDTO.setRefundAmount(bookingResponseDTO2.getRefundAmount());
        bookingResponseDTO.setCancellationStatus(bookingResponseDTO2.getCancellationStatus());
        bookingResponseDTO.setReservationStatus(bookingResponseDTO2.getReservationStatus());
        bookingResponseDTO.setCancellationDate(bookingResponseDTO2.getCancellationDate());
        bookingResponseDTO.setTdrFilingDate(bookingResponseDTO2.getTdrFilingDate());
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
        bookingResponseDTO.setAvlForVikalp(bookingResponseDTO2.getAvlForVikalp());
        bookingResponseDTO.setVikalpStatus(bookingResponseDTO2.getVikalpStatus());
        bookingResponseDTO.setErsDisplayMessage(bookingResponseDTO2.getErsDisplayMessage());
        bookingResponseDTO.setDutiesMessage(bookingResponseDTO2.getDutiesMessage());
        bookingResponseDTO.setQrCodeText(bookingResponseDTO2.getQrCodeText());
        bookingResponseDTO.setMealTransaction(bookingResponseDTO2.getMealTransaction());
        bookingResponseDTO.setMealChoiceEnable(bookingResponseDTO2.isMealChoiceEnable());
        bookingResponseDTO.setRrHbFlag(bookingResponseDTO2.getRrHbFlag());
        bookingResponseDTO.setMultiLapFlag(bookingResponseDTO2.isMultiLapFlag());
    }

    @OnClick({2131362060})
    public void arrival(View view) {
        i(this.booking, R.color.dark);
        i(this.departure, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.booking.setTextAppearance(getActivity(), R.style.fontForbold);
        k(2);
        this.sort_by_spinner_text.setText(getString(R.string.booking_date));
        this.sortby_bottom_ll.setVisibility(8);
    }

    @OnClick({2131362395})
    public void departure(View view) {
        i(this.booking, R.color.white);
        i(this.departure, R.color.dark);
        this.departure.setTextAppearance(getActivity(), R.style.fontForbold);
        this.booking.setTextAppearance(getActivity(), R.style.fontForNormal);
        k(1);
        this.sort_by_spinner_text.setText(getString(R.string.departure_date));
        this.sortby_bottom_ll.setVisibility(8);
    }

    public final void h() {
        ProgressDialog progressDialog = this.f4469a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4469a.dismiss();
        }
    }

    public final void i(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void j(ArrayList<BookingResponseDTO> arrayList, C0707Ue ue, String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("TicketErs", arrayList);
        bundle.putBoolean("multiLapFlag", this.f4475a);
        bundle.putSerializable("historyEnquiryDTO", ue);
        if (str != null && !str.isEmpty()) {
            bundle.putSerializable("connectingTxnId", str);
        }
        ErsDisplayFragment ersDisplayFragment = new ErsDisplayFragment();
        ersDisplayFragment.setArguments(bundle);
        HomeActivity.n(getActivity(), ersDisplayFragment, C1218kf.TicketDetails.a(), Boolean.TRUE, Boolean.FALSE);
    }

    public final void k(int i) {
        ArrayList<BookingResponseDTO> arrayList = this.f4473a;
        if (arrayList != null && arrayList.size() % 5 == 0) {
            this.mybooking_bottom.setVisibility(8);
        }
        if (arrayList == null || arrayList.size() == 0) {
            arrayList = null;
        } else if (i == 1) {
            Collections.sort(this.f4473a, new C1061d3());
        } else if (i == 2) {
            Collections.sort(this.f4473a, new C1082e3());
        }
        this.f4473a = arrayList;
        TicketViewHolder ticketViewHolder = this.f4472a;
        if (ticketViewHolder != null) {
            ticketViewHolder.notifyDataSetChanged();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_my_booking, (ViewGroup) null);
        if (!(getArguments() == null || getArguments().getSerializable("ticket") == null)) {
            this.f4473a = (ArrayList) getArguments().getSerializable("ticket");
        }
        ButterKnife.bind((Object) this, inflate);
        this.f4470a = getContext();
        a = getActivity();
        TabLayout tabLayout2 = this.tabLayout;
        tabLayout2.addTab(tabLayout2.newTab().setText((CharSequence) getString(R.string.upcoming)));
        TabLayout tabLayout3 = this.tabLayout;
        tabLayout3.addTab(tabLayout3.newTab().setText((CharSequence) getString(R.string.completed)));
        HomeActivity.x();
        HomeActivity.z();
        new a();
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.mybooking_top, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.mybooking_bottom, googleAdParamDTO);
        this.f4471a = new b();
        TicketHistoryUtil.SortFor sortFor = TicketHistoryUtil.f5370a;
        if (sortFor == TicketHistoryUtil.SortFor.LAST_TXN || sortFor == TicketHistoryUtil.SortFor.UPCOMPING) {
            this.sortLayout.setVisibility(8);
            if (this.f4473a != null) {
                this.sort_by_and_lastUpdate.setVisibility(8);
                this.tabLayout.setVisibility(8);
                TicketViewHolder ticketViewHolder = new TicketViewHolder(this.f4470a, this.f4473a, this.f4471a);
                this.f4472a = ticketViewHolder;
                this.bookingItems.setAdapter(ticketViewHolder);
                this.bookingItems.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        } else {
            this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new c());
            this.sortLayout.setVisibility(0);
            C0707Ue ue = TicketHistoryUtil.b;
            if (ue != null) {
                TicketHistoryUtil.a(ue.getBookingResponseList(), TicketHistoryUtil.SortFor.BOOKINGS);
                this.f4473a = TicketHistoryUtil.f5369a.getUpcomingJourney();
                TicketViewHolder ticketViewHolder2 = new TicketViewHolder(this.f4470a, this.f4473a, this.f4471a);
                this.f4472a = ticketViewHolder2;
                this.bookingItems.setAdapter(ticketViewHolder2);
                this.bookingItems.setLayoutManager(new LinearLayoutManager(getContext()));
                this.lastUpdatedTime.setText(C0535I5.X(TicketHistoryUtil.b.getTimeStamp()));
                k(1);
            } else if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f4470a)) {
                new Handler().postDelayed(new C1101f3(), 5000);
            } else {
                C1223kn knVar = C0793b1.a.f3912a;
                this.f4474a = knVar;
                if (knVar == null) {
                    TicketHistoryUtil.c();
                }
                try {
                    ArrayList<BookingResponseDTO> arrayList = this.f4473a;
                    if (arrayList == null || arrayList.size() <= 0) {
                        this.f4469a = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticket_List), getString(R.string.please_wait_text), true, false);
                        String f = C0657Qt.f();
                        ((Om) C0657Qt.c(this.f4474a)).p1(f + "bookedHistorySearch", "ALL").c(C1181iv.a()).a(E0.a()).b(new C1053y(this));
                    } else {
                        TicketViewHolder ticketViewHolder3 = new TicketViewHolder(this.f4470a, this.f4473a, this.f4471a);
                        this.f4472a = ticketViewHolder3;
                        this.bookingItems.setAdapter(ticketViewHolder3);
                        this.bookingItems.setLayoutManager(new LinearLayoutManager(getContext()));
                    }
                    h();
                } catch (Exception e) {
                    e.getMessage();
                    h();
                    C0535I5.t0(getActivity(), getString(R.string.please_try_again));
                }
            }
        }
        HomeActivity.J();
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4469a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4469a.dismiss();
        }
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f4469a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4469a.dismiss();
        }
        C0535I5.u();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4469a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4469a.dismiss();
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

    public class b implements TicketViewHolder.a {

        /* renamed from: cris.org.in.ima.fragment.BookingHistoryFragment$b$b  reason: collision with other inner class name */
        public class C0058b extends Subscriber<C0707Ue> {

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ BookingResponseDTO f4476a;

            public C0058b(BookingResponseDTO bookingResponseDTO) {
                this.f4476a = bookingResponseDTO;
            }

            public final void onCompleted() {
                FragmentActivity fragmentActivity = BookingHistoryFragment.a;
            }

            public final void onError(Throwable th) {
                BookingHistoryFragment bookingHistoryFragment = BookingHistoryFragment.this;
                FragmentActivity fragmentActivity = BookingHistoryFragment.a;
                bookingHistoryFragment.h();
                FragmentActivity fragmentActivity2 = BookingHistoryFragment.a;
                xx.S(th, true, th);
            }

            public final void onNext(Object obj) {
                BookingHistoryFragment bookingHistoryFragment;
                C0707Ue ue = (C0707Ue) obj;
                BookingResponseDTO bookingResponseDTO = this.f4476a;
                b bVar = b.this;
                if (ue != null) {
                    C0657Qt.h();
                    try {
                        if (ue.getErrorMsg() != null) {
                            BookingHistoryFragment bookingHistoryFragment2 = BookingHistoryFragment.this;
                            BookingHistoryFragment bookingHistoryFragment3 = BookingHistoryFragment.this;
                            C0535I5.m(bookingHistoryFragment2.getActivity(), false, ue.getErrorMsg().split("-")[0], bookingHistoryFragment3.getString(R.string.error), bookingHistoryFragment3.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        } else {
                            FragmentActivity fragmentActivity = BookingHistoryFragment.a;
                            ue.toString();
                            ue.getTimeStamp().toString();
                            ArrayList arrayList = new ArrayList();
                            if (bookingResponseDTO.isMultiLapFlag()) {
                                BookingHistoryFragment.this.f4475a = bookingResponseDTO.isMultiLapFlag();
                                arrayList.addAll(ue.getBookingResponseList());
                            } else {
                                BookingHistoryFragment.g(BookingHistoryFragment.this, bookingResponseDTO, ue.getBookingResponseList().get(0), ue.getTimeStamp());
                                arrayList.add(bookingResponseDTO);
                                BookingHistoryFragment.this.f4475a = false;
                            }
                            if (bookingResponseDTO.getConnectingPnrNumber() != null && !bookingResponseDTO.getConnectingPnrNumber().isEmpty()) {
                                BookingHistoryFragment bookingHistoryFragment4 = BookingHistoryFragment.this;
                                bookingHistoryFragment4.c = BookingHistoryFragment.f(bookingHistoryFragment4, bookingResponseDTO.getConnectingPnrNumber(), TicketHistoryUtil.b);
                            }
                            BookingHistoryFragment bookingHistoryFragment5 = BookingHistoryFragment.this;
                            BookingHistoryFragment bookingHistoryFragment6 = BookingHistoryFragment.this;
                            bookingHistoryFragment5.j(arrayList, ue, bookingHistoryFragment5.c);
                            bookingHistoryFragment6.c = null;
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS");
                            if (bookingResponseDTO.getVikalpStatus() != null && !bookingResponseDTO.getVikalpStatus().toString().equalsIgnoreCase("NO") && bookingResponseDTO.getBoardingDate().after(simpleDateFormat.parse(bookingResponseDTO.getDispatchDate())) && (bookingResponseDTO.getReservationStatus().compareToIgnoreCase("Booked") == 0 || bookingResponseDTO.getReservationStatus().compareToIgnoreCase("Partial Cancelled") == 0)) {
                                C0535I5.p(bookingHistoryFragment6.getActivity(), false, bookingHistoryFragment6.getResources().getString(R.string.vikalp_info_msg), bookingHistoryFragment6.getString(R.string.info), bookingHistoryFragment6.getString(R.string.ok), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                            }
                        }
                        bookingHistoryFragment = BookingHistoryFragment.this;
                        FragmentActivity fragmentActivity2 = BookingHistoryFragment.a;
                    } catch (Exception e) {
                        FragmentActivity fragmentActivity3 = BookingHistoryFragment.a;
                        e.getMessage();
                        BookingHistoryFragment bookingHistoryFragment7 = BookingHistoryFragment.this;
                        BookingHistoryFragment bookingHistoryFragment8 = BookingHistoryFragment.this;
                        C0535I5.t0(bookingHistoryFragment7.getActivity(), bookingHistoryFragment8.getResources().getString(R.string.unable_process_message));
                        bookingHistoryFragment = bookingHistoryFragment8;
                    } catch (Throwable th) {
                        BookingHistoryFragment bookingHistoryFragment9 = BookingHistoryFragment.this;
                        FragmentActivity fragmentActivity4 = BookingHistoryFragment.a;
                        bookingHistoryFragment9.h();
                        throw th;
                    }
                    bookingHistoryFragment.h();
                    return;
                }
                BookingHistoryFragment bookingHistoryFragment10 = BookingHistoryFragment.this;
                FragmentActivity fragmentActivity5 = BookingHistoryFragment.a;
                bookingHistoryFragment10.h();
                BookingHistoryFragment bookingHistoryFragment11 = BookingHistoryFragment.this;
                C0535I5.t0(bookingHistoryFragment11.getActivity(), bookingHistoryFragment11.getResources().getString(R.string.unable_process_message));
            }
        }

        public b() {
        }

        public final void a(BookingResponseDTO bookingResponseDTO) {
            BookingHistoryFragment bookingHistoryFragment = BookingHistoryFragment.this;
            if (!C0535I5.O((ConnectivityManager) bookingHistoryFragment.getActivity().getSystemService("connectivity"), bookingHistoryFragment.f4470a)) {
                new Handler().postDelayed(new a(), 5000);
            } else if (bookingResponseDTO.getPsgnDtlList() == null || bookingResponseDTO.getPsgnDtlList().size() <= 0) {
                ProgressDialog show = ProgressDialog.show(bookingHistoryFragment.getActivity(), bookingHistoryFragment.getString(R.string.fetching_ticket_List), bookingHistoryFragment.getString(R.string.please_wait_text));
                bookingHistoryFragment.f4469a = show;
                C1223kn knVar = C0793b1.a.f3912a;
                bookingHistoryFragment.f4474a = knVar;
                if (knVar != null) {
                    try {
                        show.show();
                        String f = C0657Qt.f();
                        String format = String.format("/%s", new Object[]{bookingResponseDTO.getTransactionId()});
                        ((Om) C0657Qt.c(bookingHistoryFragment.f4474a)).F0(f + "historySearchByTxnId" + format).c(C1181iv.a()).a(E0.a()).b(new C0058b(bookingResponseDTO));
                    } catch (Exception e) {
                        FragmentActivity fragmentActivity = BookingHistoryFragment.a;
                        e.getMessage();
                        bookingHistoryFragment.h();
                        C0535I5.t0(bookingHistoryFragment.getActivity(), bookingHistoryFragment.getString(R.string.please_try_again));
                    }
                } else {
                    C0535I5.m(bookingHistoryFragment.getActivity(), false, bookingHistoryFragment.getResources().getString(R.string.unable_process_message), bookingHistoryFragment.getString(R.string.error), bookingHistoryFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bookingResponseDTO);
                if (!(bookingResponseDTO.getConnectingPnrNumber() == null || bookingResponseDTO.getConnectingPnrNumber().isEmpty() || TicketHistoryUtil.b == null)) {
                    bookingHistoryFragment.c = BookingHistoryFragment.f(bookingHistoryFragment, bookingResponseDTO.getConnectingPnrNumber(), TicketHistoryUtil.b);
                }
                bookingHistoryFragment.j(arrayList, new C0707Ue(), bookingHistoryFragment.c);
                bookingHistoryFragment.c = null;
            }
        }

        public class a implements Runnable {
            public final void run() {
            }
        }
    }

    public class c implements TabLayout.OnTabSelectedListener {
        public c() {
        }

        public final void onTabSelected(TabLayout.Tab tab) {
            boolean equals = tab.getText().toString().equals("Upcoming");
            BookingHistoryFragment bookingHistoryFragment = BookingHistoryFragment.this;
            if (equals) {
                bookingHistoryFragment.f4473a = TicketHistoryUtil.f5369a.getUpcomingJourney();
            } else {
                bookingHistoryFragment.f4473a = TicketHistoryUtil.f5369a.getPastJourney();
            }
            bookingHistoryFragment.bookingItems.setLayoutManager(new LinearLayoutManager(bookingHistoryFragment.getContext()));
            TicketViewHolder ticketViewHolder = new TicketViewHolder(bookingHistoryFragment.f4470a, bookingHistoryFragment.f4473a, bookingHistoryFragment.f4471a);
            bookingHistoryFragment.f4472a = ticketViewHolder;
            bookingHistoryFragment.bookingItems.setAdapter(ticketViewHolder);
        }

        public final void onTabReselected(TabLayout.Tab tab) {
        }

        public final void onTabUnselected(TabLayout.Tab tab) {
        }
    }
}
