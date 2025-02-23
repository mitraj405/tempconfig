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
import cris.org.in.ima.view_holder.CancellationItemHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import rx.Subscriber;

public class CancellationHistoryFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4504a;

    /* renamed from: a  reason: collision with other field name */
    public a f4505a;

    /* renamed from: a  reason: collision with other field name */
    public CancellationItemHolder f4506a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<BookingResponseDTO> f4507a;

    /* renamed from: a  reason: collision with other field name */
    public C1223kn f4508a;
    @BindView(2131362060)
    TextView booking;
    @BindView(2131363807)
    RecyclerView bookingItems;
    @BindView(2131362116)
    AdManagerAdView cancelTicketBotAd;
    @BindView(2131362117)
    AdManagerAdView cancelTicketTopAd;
    @BindView(2131362395)
    TextView departure;
    @BindView(2131363975)
    TextView sort_by_spinner_text;
    @BindView(2131363978)
    RelativeLayout sortby_bottom_ll;

    static {
        C1354qp.R(CancellationHistoryFragment.class);
        new SimpleDateFormat("yyyyMMdd");
    }

    public CancellationHistoryFragment() {
        new ArrayList();
        new HashMap();
        new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss' HRS'");
    }

    public static void f(CancellationHistoryFragment cancellationHistoryFragment, BookingResponseDTO bookingResponseDTO, BookingResponseDTO bookingResponseDTO2, Date date) {
        cancellationHistoryFragment.getClass();
        bookingResponseDTO.setBankName(bookingResponseDTO2.getBankName());
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
        bookingResponseDTO.setRefundStatusEtTkt(bookingResponseDTO2.getRefundStatusEtTkt());
        bookingResponseDTO.setBankRefundtransactionId(bookingResponseDTO2.getBankRefundtransactionId());
        bookingResponseDTO.setRefundId(bookingResponseDTO2.getRefundId());
        bookingResponseDTO.setMetroServiceDetail(bookingResponseDTO2.getMetroServiceDetail());
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
        bookingResponseDTO.setQuota(bookingResponseDTO2.getQuota());
    }

    @OnClick({2131362060})
    public void arrival(View view) {
        g(this.booking, R.color.dark);
        g(this.departure, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.booking.setTextAppearance(getActivity(), R.style.fontForbold);
        h(2);
        this.sort_by_spinner_text.setText(getString(R.string.cancellation_date));
        this.sortby_bottom_ll.setVisibility(8);
        this.booking.setText(getString(R.string.cancellation_date));
    }

    @OnClick({2131362395})
    public void departure(View view) {
        g(this.booking, R.color.white);
        g(this.departure, R.color.dark);
        this.departure.setTextAppearance(getActivity(), R.style.fontForbold);
        this.booking.setTextAppearance(getActivity(), R.style.fontForNormal);
        h(1);
        this.sort_by_spinner_text.setText(getString(R.string.departure_date));
        this.sortby_bottom_ll.setVisibility(8);
        this.booking.setText(getString(R.string.cancellation_date));
    }

    public final void g(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void h(int i) {
        ArrayList<BookingResponseDTO> arrayList = this.f4507a;
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<BookingResponseDTO> arrayList2 = this.f4507a;
            if (arrayList2 == null || arrayList2.size() == 0) {
                arrayList2 = null;
            } else if (i == 1) {
                Collections.sort(arrayList2, new C1435v4());
            } else if (i == 2) {
                Collections.sort(arrayList2, new C1451w4());
            }
            this.f4507a = arrayList2;
            this.f4506a.notifyDataSetChanged();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_failed_transaction, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4504a = getContext();
        this.booking.setText(getString(R.string.cancellation_date));
        this.sort_by_spinner_text.setText(getString(R.string.cancellation_date));
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.cancelTicketTopAd, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.cancelTicketBotAd, googleAdParamDTO);
        this.cancelTicketTopAd.setVisibility(0);
        this.cancelTicketBotAd.setVisibility(0);
        this.f4505a = new a();
        if (!C0535I5.O((ConnectivityManager) this.f4504a.getSystemService("connectivity"), this.f4504a)) {
            new Handler().postDelayed(new C1471x4(), 5000);
        } else {
            C1223kn knVar = C0793b1.a.f3912a;
            this.f4508a = knVar;
            if (knVar == null) {
                TicketHistoryUtil.c();
            }
            try {
                if (this.f4507a != null) {
                    CancellationItemHolder cancellationItemHolder = new CancellationItemHolder(this.f4505a, this.f4507a);
                    this.f4506a = cancellationItemHolder;
                    this.bookingItems.setAdapter(cancellationItemHolder);
                    this.bookingItems.setLayoutManager(new LinearLayoutManager(getContext()));
                } else {
                    this.a = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticket_List), getString(R.string.please_wait_text), true, false);
                    String f = C0657Qt.f();
                    ((Om) C0657Qt.c(this.f4508a)).j0(f + "canceledTktHistorySearch").c(C1181iv.a()).a(E0.a()).b(new D(this));
                }
            } catch (Exception e) {
                e.getMessage();
                this.a.dismiss();
                C0535I5.t0(getActivity(), getString(R.string.please_try_again));
            }
        }
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

    public class a implements CancellationItemHolder.a {

        public class b extends Subscriber<C0707Ue> {
            public final /* synthetic */ View a;

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ BookingResponseDTO f4510a;

            public b(BookingResponseDTO bookingResponseDTO, View view) {
                this.f4510a = bookingResponseDTO;
                this.a = view;
            }

            public final void onCompleted() {
                int i = CancellationHistoryFragment.c;
                CancellationHistoryFragment.this.a.dismiss();
            }

            public final void onError(Throwable th) {
                CancellationHistoryFragment.this.a.dismiss();
                int i = CancellationHistoryFragment.c;
                xx.S(th, true, th);
            }

            public final void onNext(Object obj) {
                CancellationHistoryFragment cancellationHistoryFragment;
                C0707Ue ue = (C0707Ue) obj;
                BookingResponseDTO bookingResponseDTO = this.f4510a;
                a aVar = a.this;
                if (ue != null) {
                    C0657Qt.h();
                    try {
                        if (ue.getErrorMsg() != null) {
                            CancellationHistoryFragment cancellationHistoryFragment2 = CancellationHistoryFragment.this;
                            CancellationHistoryFragment cancellationHistoryFragment3 = CancellationHistoryFragment.this;
                            C0535I5.m(cancellationHistoryFragment2.getActivity(), false, ue.getErrorMsg().split("-")[0], cancellationHistoryFragment3.getString(R.string.error), cancellationHistoryFragment3.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        } else {
                            int i = CancellationHistoryFragment.c;
                            ue.getTimeStamp().toString();
                            CancellationHistoryFragment cancellationHistoryFragment4 = CancellationHistoryFragment.this;
                            CancellationHistoryFragment cancellationHistoryFragment5 = CancellationHistoryFragment.this;
                            CancellationHistoryFragment.f(cancellationHistoryFragment4, bookingResponseDTO, ue.getBookingResponseList().get(0), ue.getTimeStamp());
                            bookingResponseDTO.setRetryBooking(Boolean.TRUE);
                            cancellationHistoryFragment5.bookingItems.getAdapter().notifyItemChanged(cancellationHistoryFragment5.bookingItems.getChildAdapterPosition(this.a));
                        }
                        cancellationHistoryFragment = CancellationHistoryFragment.this;
                    } catch (Exception e) {
                        int i2 = CancellationHistoryFragment.c;
                        e.getMessage();
                        CancellationHistoryFragment cancellationHistoryFragment6 = CancellationHistoryFragment.this;
                        CancellationHistoryFragment cancellationHistoryFragment7 = CancellationHistoryFragment.this;
                        C0535I5.t0(cancellationHistoryFragment6.getActivity(), cancellationHistoryFragment7.getResources().getString(R.string.unable_process_message));
                        cancellationHistoryFragment = cancellationHistoryFragment7;
                    } catch (Throwable th) {
                        CancellationHistoryFragment.this.a.dismiss();
                        throw th;
                    }
                    cancellationHistoryFragment.a.dismiss();
                    return;
                }
                CancellationHistoryFragment.this.a.dismiss();
                CancellationHistoryFragment cancellationHistoryFragment8 = CancellationHistoryFragment.this;
                C0535I5.t0(cancellationHistoryFragment8.getActivity(), cancellationHistoryFragment8.getResources().getString(R.string.unable_process_message));
            }
        }

        public a() {
        }

        public final void a(BookingResponseDTO bookingResponseDTO, View view) {
            String str;
            CancellationHistoryFragment cancellationHistoryFragment = CancellationHistoryFragment.this;
            if (!C0535I5.O((ConnectivityManager) cancellationHistoryFragment.getActivity().getSystemService("connectivity"), cancellationHistoryFragment.f4504a)) {
                new Handler().postDelayed(new C0059a(), 5000);
            } else if (bookingResponseDTO.getRetryBooking().booleanValue()) {
                cancellationHistoryFragment.bookingItems.getAdapter().notifyItemChanged(cancellationHistoryFragment.bookingItems.getChildAdapterPosition(view));
            } else {
                ProgressDialog show = ProgressDialog.show(cancellationHistoryFragment.getActivity(), cancellationHistoryFragment.getString(R.string.fetching_transaction_Details), cancellationHistoryFragment.getString(R.string.please_wait_text));
                cancellationHistoryFragment.a = show;
                C1223kn knVar = C0793b1.a.f3912a;
                cancellationHistoryFragment.f4508a = knVar;
                if (knVar != null) {
                    try {
                        show.show();
                        Om om = (Om) C0657Qt.c(cancellationHistoryFragment.f4508a);
                        String f = C0657Qt.f();
                        if (bookingResponseDTO.isMetroServiceOpted()) {
                            str = String.format("/%s/%s", new Object[]{bookingResponseDTO.getCancellationId(), "M"});
                        } else if (bookingResponseDTO.isPostMealOpt()) {
                            str = String.format("/%s/%s", new Object[]{bookingResponseDTO.getCancellationId(), "P"});
                        } else {
                            str = String.format("/%s/%s", new Object[]{bookingResponseDTO.getCancellationId(), "C"});
                        }
                        om.n(f + "cancellationAndTdrDetailByCanId" + str).c(C1181iv.a()).a(E0.a()).b(new b(bookingResponseDTO, view));
                    } catch (Exception e) {
                        int i = CancellationHistoryFragment.c;
                        e.getMessage();
                        cancellationHistoryFragment.a.dismiss();
                        C0535I5.t0(cancellationHistoryFragment.getActivity(), cancellationHistoryFragment.getString(R.string.please_try_again));
                    }
                } else {
                    C0535I5.m(cancellationHistoryFragment.getActivity(), false, cancellationHistoryFragment.getResources().getString(R.string.unable_process_message), cancellationHistoryFragment.getString(R.string.error), cancellationHistoryFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            }
        }

        /* renamed from: cris.org.in.ima.fragment.CancellationHistoryFragment$a$a  reason: collision with other inner class name */
        public class C0059a implements Runnable {
            public final void run() {
            }
        }
    }
}
