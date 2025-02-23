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
import rx.Observable;
import rx.Subscriber;

public class MyBookingFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4831a;

    /* renamed from: a  reason: collision with other field name */
    public b f4832a;

    /* renamed from: a  reason: collision with other field name */
    public TicketHistoryUtil.SortFor f4833a;

    /* renamed from: a  reason: collision with other field name */
    public TicketViewHolder f4834a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<BookingResponseDTO> f4835a;

    /* renamed from: a  reason: collision with other field name */
    public C1223kn f4836a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4837a = false;
    @BindView(2131362060)
    TextView booking;
    @BindView(2131363807)
    RecyclerView bookingItems;

    /* renamed from: c  reason: collision with other field name */
    public String f4838c = null;
    @BindView(2131362395)
    TextView departure;
    @BindView(2131362950)
    TextView lastUpdatedTime;
    @BindView(2131363281)
    AdManagerAdView my_booking_bottom;
    @BindView(2131363284)
    AdManagerAdView my_booking_top;
    @BindView(2131363975)
    TextView sort_by_spinner_text;
    @BindView(2131363978)
    RelativeLayout sortby_bottom_ll;
    @BindView(2131364048)
    TabLayout tabLayout;

    static {
        C1354qp.R(MyBookingFragment.class);
        new SimpleDateFormat("yyyyMMdd");
    }

    public static String f(MyBookingFragment myBookingFragment, String str, C0707Ue ue) {
        myBookingFragment.getClass();
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

    public static void g(MyBookingFragment myBookingFragment, BookingResponseDTO bookingResponseDTO, BookingResponseDTO bookingResponseDTO2, Date date) {
        myBookingFragment.getClass();
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
    }

    @OnClick({2131362060})
    public void arrival(View view) {
        h(this.booking, R.color.dark);
        h(this.departure, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.booking.setTextAppearance(getActivity(), R.style.fontForbold);
        j(2);
        this.sort_by_spinner_text.setText(getString(R.string.booking_date));
        this.sortby_bottom_ll.setVisibility(8);
    }

    @OnClick({2131362395})
    public void departure(View view) {
        h(this.booking, R.color.white);
        h(this.departure, R.color.dark);
        this.departure.setTextAppearance(getActivity(), R.style.fontForbold);
        this.booking.setTextAppearance(getActivity(), R.style.fontForNormal);
        j(1);
        this.sort_by_spinner_text.setText(getString(R.string.departure_date));
        this.sortby_bottom_ll.setVisibility(8);
    }

    public final void h(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void i(ArrayList<BookingResponseDTO> arrayList, C0707Ue ue, String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("TicketErs", arrayList);
        bundle.putBoolean("multiLapFlag", this.f4837a);
        bundle.putSerializable("historyEnquiryDTO", ue);
        if (str != null && !str.isEmpty()) {
            bundle.putSerializable("connectingTxnId", str);
        }
        ErsDisplayFragment ersDisplayFragment = new ErsDisplayFragment();
        ersDisplayFragment.setArguments(bundle);
        HomeActivity.n(getActivity(), ersDisplayFragment, C1218kf.TicketDetails.a(), Boolean.TRUE, Boolean.FALSE);
    }

    public final void j(int i) {
        ArrayList<BookingResponseDTO> arrayList = this.f4835a;
        if (arrayList == null || arrayList.size() == 0) {
            arrayList = null;
        } else if (i == 1) {
            Collections.sort(this.f4835a, new C1222km());
        } else if (i == 2) {
            Collections.sort(this.f4835a, new C1242lm());
        }
        this.f4835a = arrayList;
        if (arrayList != null) {
            this.f4834a.notifyDataSetChanged();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Observable<C0707Ue> observable;
        View inflate = layoutInflater.inflate(R.layout.activity_my_booking, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        HomeActivity.x();
        HomeActivity.z();
        this.f4833a = TicketHistoryUtil.f5370a;
        this.f4831a = getContext();
        TabLayout tabLayout2 = this.tabLayout;
        tabLayout2.addTab(tabLayout2.newTab().setText((CharSequence) getString(R.string.all_journey)));
        TabLayout tabLayout3 = this.tabLayout;
        tabLayout3.addTab(tabLayout3.newTab().setText((CharSequence) getString(R.string.upcoming)));
        TabLayout tabLayout4 = this.tabLayout;
        tabLayout4.addTab(tabLayout4.newTab().setText((CharSequence) getString(R.string.past_journey)));
        this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
        if (!C0535I5.O((ConnectivityManager) this.f4831a.getSystemService("connectivity"), this.f4831a)) {
            new Handler().postDelayed(new C1260mm(), 5000);
        } else {
            C1223kn knVar = C0793b1.a.f3912a;
            this.f4836a = knVar;
            if (knVar == null) {
                TicketHistoryUtil.c();
            }
            try {
                if (this.f4835a != null) {
                    TicketViewHolder ticketViewHolder = new TicketViewHolder(this.f4831a, this.f4835a, this.f4832a);
                    this.f4834a = ticketViewHolder;
                    this.bookingItems.setAdapter(ticketViewHolder);
                    this.bookingItems.setLayoutManager(new LinearLayoutManager(getContext()));
                } else {
                    this.a = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticket_List), getString(R.string.please_wait_text), true, false);
                    Om om = (Om) C0657Qt.c(this.f4836a);
                    String f = C0657Qt.f();
                    if (this.f4833a == TicketHistoryUtil.SortFor.BOOKINGS) {
                        observable = om.p1(f + "bookedHistorySearch", "ALL");
                    } else {
                        observable = om.p1(f + "bookedHistorySearch", "EWALLET");
                    }
                    observable.c(C1181iv.a()).a(E0.a()).b(new X(this));
                }
                this.a.dismiss();
            } catch (Exception e) {
                e.getMessage();
                this.a.dismiss();
                C0535I5.t0(getActivity(), getString(R.string.please_try_again));
            }
        }
        this.f4832a = new b();
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.my_booking_top, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.my_booking_bottom, googleAdParamDTO);
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    @OnClick({2131363978})
    public void sortBottomllClick() {
        this.sortby_bottom_ll.setVisibility(8);
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

    public class b implements TicketViewHolder.a {

        /* renamed from: cris.org.in.ima.fragment.MyBookingFragment$b$b  reason: collision with other inner class name */
        public class C0066b extends Subscriber<C0707Ue> {

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ BookingResponseDTO f4839a;

            public C0066b(BookingResponseDTO bookingResponseDTO) {
                this.f4839a = bookingResponseDTO;
            }

            public final void onCompleted() {
                int i = MyBookingFragment.c;
            }

            public final void onError(Throwable th) {
                MyBookingFragment.this.a.dismiss();
                int i = MyBookingFragment.c;
                xx.S(th, true, th);
            }

            public final void onNext(Object obj) {
                MyBookingFragment myBookingFragment;
                C0707Ue ue = (C0707Ue) obj;
                BookingResponseDTO bookingResponseDTO = this.f4839a;
                b bVar = b.this;
                if (ue != null) {
                    C0657Qt.h();
                    try {
                        if (ue.getErrorMsg() != null) {
                            MyBookingFragment myBookingFragment2 = MyBookingFragment.this;
                            MyBookingFragment myBookingFragment3 = MyBookingFragment.this;
                            C0535I5.m(myBookingFragment2.getActivity(), false, ue.getErrorMsg().split("-")[0], myBookingFragment3.getString(R.string.error), myBookingFragment3.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        } else {
                            int i = MyBookingFragment.c;
                            ue.toString();
                            ue.getTimeStamp().toString();
                            MyBookingFragment.g(MyBookingFragment.this, bookingResponseDTO, ue.getBookingResponseList().get(0), ue.getTimeStamp());
                            ArrayList arrayList = new ArrayList();
                            boolean isMultiLapFlag = bookingResponseDTO.isMultiLapFlag();
                            MyBookingFragment myBookingFragment4 = MyBookingFragment.this;
                            if (isMultiLapFlag) {
                                myBookingFragment4.f4837a = bookingResponseDTO.isMultiLapFlag();
                                arrayList.addAll(ue.getBookingResponseList());
                            } else {
                                MyBookingFragment.g(myBookingFragment4, bookingResponseDTO, ue.getBookingResponseList().get(0), ue.getTimeStamp());
                                arrayList.add(bookingResponseDTO);
                                myBookingFragment4.f4837a = false;
                            }
                            if (bookingResponseDTO.getConnectingPnrNumber() != null && !bookingResponseDTO.getConnectingPnrNumber().isEmpty()) {
                                myBookingFragment4.f4838c = MyBookingFragment.f(myBookingFragment4, bookingResponseDTO.getConnectingPnrNumber(), TicketHistoryUtil.b);
                            }
                            myBookingFragment4.i(arrayList, ue, myBookingFragment4.f4838c);
                            myBookingFragment4.f4838c = null;
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS");
                            if (bookingResponseDTO.getVikalpStatus() != null && !bookingResponseDTO.getVikalpStatus().toString().equalsIgnoreCase("NO") && bookingResponseDTO.getBoardingDate().after(simpleDateFormat.parse(bookingResponseDTO.getDispatchDate())) && (bookingResponseDTO.getReservationStatus().compareToIgnoreCase("Booked") == 0 || bookingResponseDTO.getReservationStatus().compareToIgnoreCase("Partial Cancelled") == 0)) {
                                C0535I5.p(myBookingFragment4.getActivity(), false, myBookingFragment4.getResources().getString(R.string.vikalp_info_msg), myBookingFragment4.getString(R.string.info), myBookingFragment4.getString(R.string.ok), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                            }
                        }
                        myBookingFragment = MyBookingFragment.this;
                    } catch (Exception e) {
                        int i2 = MyBookingFragment.c;
                        e.getMessage();
                        MyBookingFragment myBookingFragment5 = MyBookingFragment.this;
                        MyBookingFragment myBookingFragment6 = MyBookingFragment.this;
                        C0535I5.t0(myBookingFragment5.getActivity(), myBookingFragment6.getResources().getString(R.string.unable_process_message));
                        myBookingFragment = myBookingFragment6;
                    } catch (Throwable th) {
                        MyBookingFragment.this.a.dismiss();
                        throw th;
                    }
                    myBookingFragment.a.dismiss();
                    return;
                }
                MyBookingFragment.this.a.dismiss();
                MyBookingFragment myBookingFragment7 = MyBookingFragment.this;
                C0535I5.t0(myBookingFragment7.getActivity(), myBookingFragment7.getResources().getString(R.string.unable_process_message));
            }
        }

        public b() {
        }

        public final void a(BookingResponseDTO bookingResponseDTO) {
            MyBookingFragment myBookingFragment = MyBookingFragment.this;
            if (!C0535I5.O((ConnectivityManager) myBookingFragment.getActivity().getSystemService("connectivity"), myBookingFragment.f4831a)) {
                new Handler().postDelayed(new a(), 5000);
            } else if (bookingResponseDTO.getPsgnDtlList() == null || bookingResponseDTO.getPsgnDtlList().size() <= 0) {
                ProgressDialog show = ProgressDialog.show(myBookingFragment.getActivity(), myBookingFragment.getString(R.string.fetching_Passenger_List), myBookingFragment.getString(R.string.please_wait_text));
                myBookingFragment.a = show;
                C1223kn knVar = C0793b1.a.f3912a;
                myBookingFragment.f4836a = knVar;
                if (knVar != null) {
                    try {
                        show.show();
                        String f = C0657Qt.f();
                        String format = String.format("/%s", new Object[]{bookingResponseDTO.getTransactionId()});
                        ((Om) C0657Qt.c(myBookingFragment.f4836a)).F0(f + "historySearchByTxnId" + format).c(C1181iv.a()).a(E0.a()).b(new C0066b(bookingResponseDTO));
                    } catch (Exception e) {
                        int i = MyBookingFragment.c;
                        e.getMessage();
                        myBookingFragment.a.dismiss();
                        C0535I5.t0(myBookingFragment.getActivity(), myBookingFragment.getString(R.string.please_try_again));
                    }
                } else {
                    C0535I5.m(myBookingFragment.getActivity(), false, myBookingFragment.getResources().getString(R.string.unable_process_message), myBookingFragment.getString(R.string.error), myBookingFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bookingResponseDTO);
                if (!(bookingResponseDTO.getConnectingPnrNumber() == null || bookingResponseDTO.getConnectingPnrNumber().isEmpty() || TicketHistoryUtil.b == null)) {
                    myBookingFragment.f4838c = MyBookingFragment.f(myBookingFragment, bookingResponseDTO.getConnectingPnrNumber(), TicketHistoryUtil.b);
                }
                myBookingFragment.i(arrayList, new C0707Ue(), myBookingFragment.f4838c);
                myBookingFragment.f4838c = null;
            }
        }

        public class a implements Runnable {
            public final void run() {
            }
        }
    }

    public class a implements TabLayout.OnTabSelectedListener {
        public a() {
        }

        public final void onTabSelected(TabLayout.Tab tab) {
            String charSequence = tab.getText().toString();
            MyBookingFragment myBookingFragment = MyBookingFragment.this;
            boolean equalsIgnoreCase = charSequence.equalsIgnoreCase(myBookingFragment.getString(R.string.all_journey));
            TicketHistoryUtil.SortFor sortFor = TicketHistoryUtil.SortFor.EWALLET_TXN;
            TicketHistoryUtil.SortFor sortFor2 = TicketHistoryUtil.SortFor.CANCELLATION;
            TicketHistoryUtil.SortFor sortFor3 = TicketHistoryUtil.SortFor.BOOKINGS;
            if (equalsIgnoreCase) {
                if (myBookingFragment.f4833a.equals(sortFor3)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.f5369a.getAllJourney();
                } else if (myBookingFragment.f4833a.equals(sortFor2)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.f5372b.getAllJourney();
                } else if (myBookingFragment.f4833a.equals(sortFor)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.c.getAllJourney();
                }
            } else if (tab.getText().toString().equals(myBookingFragment.getString(R.string.upcoming))) {
                if (myBookingFragment.f4833a.equals(sortFor3)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.f5369a.getUpcomingJourney();
                } else if (myBookingFragment.f4833a.equals(sortFor2)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.f5372b.getUpcomingJourney();
                } else if (myBookingFragment.f4833a.equals(sortFor)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.c.getUpcomingJourney();
                }
            } else if (tab.getText().toString().equalsIgnoreCase(myBookingFragment.getString(R.string.past_journey))) {
                if (myBookingFragment.f4833a.equals(sortFor3)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.f5369a.getPastJourney();
                } else if (myBookingFragment.f4833a.equals(sortFor2)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.f5372b.getPastJourney();
                } else if (myBookingFragment.f4833a.equals(sortFor)) {
                    myBookingFragment.f4835a = TicketHistoryUtil.c.getPastJourney();
                }
            }
            TicketViewHolder ticketViewHolder = new TicketViewHolder(myBookingFragment.f4831a, myBookingFragment.f4835a, myBookingFragment.f4832a);
            myBookingFragment.f4834a = ticketViewHolder;
            myBookingFragment.bookingItems.setAdapter(ticketViewHolder);
        }

        public final void onTabReselected(TabLayout.Tab tab) {
        }

        public final void onTabUnselected(TabLayout.Tab tab) {
        }
    }
}
