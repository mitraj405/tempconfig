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
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.FailedItemHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import rx.Subscriber;

public class FailedTxnHistoryFragment extends Fragment {
    public static FragmentActivity a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4628a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4629a;

    /* renamed from: a  reason: collision with other field name */
    public a f4630a;

    /* renamed from: a  reason: collision with other field name */
    public FailedItemHolder f4631a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<BookingResponseDTO> f4632a;

    /* renamed from: a  reason: collision with other field name */
    public C1223kn f4633a;
    @BindView(2131362060)
    TextView booking;
    @BindView(2131363807)
    RecyclerView bookingItems;
    @BindView(2131362395)
    TextView departure;
    @BindView(2131362628)
    AdManagerAdView failed_txn_bottom;
    @BindView(2131362629)
    AdManagerAdView failed_txn_top;
    @BindView(2131363979)
    LinearLayout sortLayout;
    @BindView(2131363975)
    TextView sort_by_spinner_text;
    @BindView(2131363978)
    RelativeLayout sortby_bottom_ll;

    static {
        C1354qp.R(FailedTxnHistoryFragment.class);
        new SimpleDateFormat("yyyyMMdd");
    }

    public FailedTxnHistoryFragment() {
        new ArrayList();
        new HashMap();
        new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss' HRS'");
    }

    public static void f(FailedTxnHistoryFragment failedTxnHistoryFragment, BookingResponseDTO bookingResponseDTO, BookingResponseDTO bookingResponseDTO2, Date date) {
        failedTxnHistoryFragment.getClass();
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
        bookingResponseDTO.setBoardingStnName(bookingResponseDTO2.getBoardingStnName());
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
        if (TicketHistoryUtil.f5370a != TicketHistoryUtil.SortFor.CANCELLATION_HISTORY) {
            bookingResponseDTO.setCancellationId(bookingResponseDTO2.getCancellationId());
            bookingResponseDTO.setTrainNumber(bookingResponseDTO2.getTrainNumber());
            bookingResponseDTO.setTrainName(bookingResponseDTO2.getTrainName());
            bookingResponseDTO.setRefundAmount(bookingResponseDTO2.getRefundAmount());
            bookingResponseDTO.setTicketAmount(bookingResponseDTO2.getTicketAmount());
            bookingResponseDTO.setBankName(bookingResponseDTO2.getBankName());
        }
        bookingResponseDTO.setQuota(bookingResponseDTO2.getQuota());
        bookingResponseDTO.setSoftFlag(bookingResponseDTO2.getSoftFlag());
        if (bookingResponseDTO2.getSoftFlag() != null && bookingResponseDTO2.getSoftFlag().intValue() == 2) {
            bookingResponseDTO.setBankName(failedTxnHistoryFragment.f4629a.getString(R.string.show_bank_name_in_refund_history));
        }
        bookingResponseDTO.setRefundStatusId(bookingResponseDTO2.getRefundStatusId());
        bookingResponseDTO.setRefundStatusDes(bookingResponseDTO2.getRefundStatusDes());
    }

    @OnClick({2131362060})
    public void arrival(View view) {
        g(this.booking, R.color.dark);
        g(this.departure, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.booking.setTextAppearance(getActivity(), R.style.fontForbold);
        h(2);
        this.sort_by_spinner_text.setText("Booking Date");
        this.sortby_bottom_ll.setVisibility(8);
    }

    @OnClick({2131362395})
    public void departure(View view) {
        g(this.booking, R.color.white);
        g(this.departure, R.color.dark);
        this.departure.setTextAppearance(getActivity(), R.style.fontForbold);
        this.booking.setTextAppearance(getActivity(), R.style.fontForNormal);
        h(1);
        this.sort_by_spinner_text.setText("Departure Date");
        this.sortby_bottom_ll.setVisibility(8);
    }

    public final void g(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void h(int i) {
        ArrayList<BookingResponseDTO> arrayList = this.f4632a;
        if (arrayList == null || arrayList.size() == 0) {
            arrayList = null;
        } else if (i == 1) {
            Collections.sort(arrayList, new C0590Mb());
        } else if (i == 2) {
            Collections.sort(arrayList, new C0606Nb());
        }
        this.f4632a = arrayList;
        this.f4631a.notifyDataSetChanged();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_failed_transaction, (ViewGroup) null);
        if (!(getArguments() == null || getArguments().getSerializable("ticket") == null)) {
            this.f4632a = (ArrayList) getArguments().getSerializable("ticket");
        }
        ButterKnife.bind((Object) this, inflate);
        this.f4629a = getContext();
        a = getActivity();
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.failed_txn_top, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.failed_txn_bottom, googleAdParamDTO);
        this.failed_txn_top.setVisibility(0);
        this.failed_txn_bottom.setVisibility(0);
        this.f4630a = new a();
        if (TicketHistoryUtil.f5370a == TicketHistoryUtil.SortFor.LAST_TXN) {
            this.sortLayout.setVisibility(8);
            TicketHistoryUtil.f5370a = TicketHistoryUtil.SortFor.FAILED_TICKETS;
            if (this.f4632a != null) {
                FailedItemHolder failedItemHolder = new FailedItemHolder(this.f4630a, this.f4632a);
                this.f4631a = failedItemHolder;
                this.bookingItems.setAdapter(failedItemHolder);
                this.bookingItems.setLayoutManager(new LinearLayoutManager(getContext()));
                h(2);
            }
        } else {
            this.sortLayout.setVisibility(0);
            if (!C0535I5.O((ConnectivityManager) this.f4629a.getSystemService("connectivity"), this.f4629a)) {
                new Handler().postDelayed(new C0621Ob(), 5000);
            } else {
                C1223kn knVar = C0793b1.a.f3912a;
                this.f4633a = knVar;
                if (knVar == null) {
                    TicketHistoryUtil.c();
                }
                try {
                    C0813c3 c3Var = TicketHistoryUtil.d;
                    if (c3Var == null || c3Var.getAllJourney().size() <= 0) {
                        this.f4628a = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticket_List), getString(R.string.please_wait_text), true, false);
                        String f = C0657Qt.f();
                        ((Om) C0657Qt.c(this.f4633a)).o0(f + "failedTxnHistorySearch").c(C1181iv.a()).a(E0.a()).b(new O(this));
                    } else {
                        this.f4632a = TicketHistoryUtil.d.getAllJourney();
                        FailedItemHolder failedItemHolder2 = new FailedItemHolder(this.f4630a, this.f4632a);
                        this.f4631a = failedItemHolder2;
                        this.bookingItems.setAdapter(failedItemHolder2);
                        this.bookingItems.setLayoutManager(new LinearLayoutManager(getContext()));
                    }
                } catch (Exception e) {
                    e.getMessage();
                    this.f4628a.dismiss();
                    C0535I5.t0(getActivity(), getString(R.string.please_try_again));
                }
            }
        }
        HomeActivity.J();
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4628a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4628a.dismiss();
        }
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f4628a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4628a.dismiss();
        }
        C0535I5.u();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4628a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4628a.dismiss();
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

    public class a implements FailedItemHolder.a {

        public class b extends Subscriber<C0707Ue> {
            public final /* synthetic */ View a;

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ BookingResponseDTO f4635a;
            public final /* synthetic */ String c;

            public b(BookingResponseDTO bookingResponseDTO, String str, View view) {
                this.f4635a = bookingResponseDTO;
                this.c = str;
                this.a = view;
            }

            public final void onCompleted() {
                FragmentActivity fragmentActivity = FailedTxnHistoryFragment.a;
                FailedTxnHistoryFragment.this.f4628a.dismiss();
            }

            public final void onError(Throwable th) {
                FailedTxnHistoryFragment.this.f4628a.dismiss();
                FragmentActivity fragmentActivity = FailedTxnHistoryFragment.a;
                xx.S(th, true, th);
            }

            public final void onNext(Object obj) {
                FailedTxnHistoryFragment failedTxnHistoryFragment;
                C0707Ue ue = (C0707Ue) obj;
                BookingResponseDTO bookingResponseDTO = this.f4635a;
                a aVar = a.this;
                FragmentActivity fragmentActivity = FailedTxnHistoryFragment.a;
                ue.toString();
                C0657Qt.h();
                try {
                    if (ue.getErrorMsg() != null) {
                        FailedTxnHistoryFragment failedTxnHistoryFragment2 = FailedTxnHistoryFragment.this;
                        FailedTxnHistoryFragment failedTxnHistoryFragment3 = FailedTxnHistoryFragment.this;
                        C0535I5.m(failedTxnHistoryFragment2.getActivity(), false, ue.getErrorMsg().split("-")[0], failedTxnHistoryFragment3.getString(R.string.error), failedTxnHistoryFragment3.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    } else {
                        ue.getTimeStamp().toString();
                        FailedTxnHistoryFragment failedTxnHistoryFragment4 = FailedTxnHistoryFragment.this;
                        FailedTxnHistoryFragment failedTxnHistoryFragment5 = FailedTxnHistoryFragment.this;
                        FailedTxnHistoryFragment.f(failedTxnHistoryFragment4, bookingResponseDTO, ue.getBookingResponseList().get(0), ue.getTimeStamp());
                        bookingResponseDTO.setRetryBooking(Boolean.TRUE);
                        bookingResponseDTO.setTrainNumber(this.c);
                        failedTxnHistoryFragment5.bookingItems.getAdapter().notifyItemChanged(failedTxnHistoryFragment5.bookingItems.getChildAdapterPosition(this.a));
                    }
                    failedTxnHistoryFragment = FailedTxnHistoryFragment.this;
                } catch (Exception e) {
                    FragmentActivity fragmentActivity2 = FailedTxnHistoryFragment.a;
                    e.getMessage();
                    FailedTxnHistoryFragment failedTxnHistoryFragment6 = FailedTxnHistoryFragment.this;
                    FailedTxnHistoryFragment failedTxnHistoryFragment7 = FailedTxnHistoryFragment.this;
                    C0535I5.t0(failedTxnHistoryFragment6.getActivity(), failedTxnHistoryFragment7.getResources().getString(R.string.unable_process_message));
                    failedTxnHistoryFragment = failedTxnHistoryFragment7;
                } catch (Throwable th) {
                    FailedTxnHistoryFragment.this.f4628a.dismiss();
                    throw th;
                }
                failedTxnHistoryFragment.f4628a.dismiss();
            }
        }

        public a() {
        }

        public final void a(BookingResponseDTO bookingResponseDTO, View view) {
            FailedTxnHistoryFragment failedTxnHistoryFragment = FailedTxnHistoryFragment.this;
            if (!C0535I5.O((ConnectivityManager) failedTxnHistoryFragment.getActivity().getSystemService("connectivity"), failedTxnHistoryFragment.f4629a)) {
                new Handler().postDelayed(new C0063a(), 5000);
            } else if (bookingResponseDTO.getRetryBooking().booleanValue()) {
                failedTxnHistoryFragment.bookingItems.getAdapter().notifyItemChanged(failedTxnHistoryFragment.bookingItems.getChildAdapterPosition(view));
            } else {
                String trainNumber = bookingResponseDTO.getTrainNumber();
                C1223kn knVar = C0793b1.a.f3912a;
                failedTxnHistoryFragment.f4633a = knVar;
                if (knVar != null) {
                    try {
                        failedTxnHistoryFragment.f4628a = ProgressDialog.show(failedTxnHistoryFragment.getActivity(), failedTxnHistoryFragment.getString(R.string.fetching_transaction_Details), failedTxnHistoryFragment.getString(R.string.please_wait_text));
                        Om om = (Om) C0657Qt.c(failedTxnHistoryFragment.f4633a);
                        String f = C0657Qt.f();
                        if (bookingResponseDTO.isMetroServiceOpted()) {
                            bookingResponseDTO.getRefundStatusEtTkt();
                        } else if (bookingResponseDTO.isPostMealOpt()) {
                            bookingResponseDTO.getRefundStatusEtTkt();
                        } else {
                            bookingResponseDTO.getRefundStatusEtTkt();
                        }
                        String format = String.format("/%s/%s", new Object[]{bookingResponseDTO.getReservationId(), "F"});
                        om.y1(f + "refundDetailsSearch" + format).c(C1181iv.a()).a(E0.a()).b(new b(bookingResponseDTO, trainNumber, view));
                    } catch (Exception e) {
                        FragmentActivity fragmentActivity = FailedTxnHistoryFragment.a;
                        e.getMessage();
                        failedTxnHistoryFragment.f4628a.dismiss();
                        C0535I5.t0(failedTxnHistoryFragment.getActivity(), failedTxnHistoryFragment.getString(R.string.please_try_again));
                    }
                } else {
                    C0535I5.m(failedTxnHistoryFragment.getActivity(), false, failedTxnHistoryFragment.getResources().getString(R.string.unable_process_message), failedTxnHistoryFragment.getString(R.string.error), failedTxnHistoryFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            }
        }

        /* renamed from: cris.org.in.ima.fragment.FailedTxnHistoryFragment$a$a  reason: collision with other inner class name */
        public class C0063a implements Runnable {
            public final void run() {
            }
        }
    }
}
