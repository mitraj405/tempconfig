package cris.org.in.ima.view_holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.fragment.FailedTxnHistoryFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public final class FailedItemHolder extends RecyclerView.Adapter<ViewHolder> {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Context f5396a;

    /* renamed from: a  reason: collision with other field name */
    public StationDb f5397a = null;

    /* renamed from: a  reason: collision with other field name */
    public final a f5398a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<BookingResponseDTO> f5399a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5400a = false;

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with other field name */
        public BookingResponseDTO f5401a;
        @BindView(2131362060)
        TextView bookingDate;
        @BindView(2131362062)
        TextView bookingDateLabel;
        @BindView(2131362122)
        LinearLayout cancellation_id_layout;
        @BindView(2131362624)
        LinearLayout expandLayout;
        @BindView(2131362631)
        LinearLayout failureReasonLl;
        @BindView(2131362630)
        TextView failure_Reason;
        @BindView(2131362716)
        TextView fromCity;
        @BindView(2131362920)
        TextView journeyDate;
        @BindView(2131363475)
        TextView paymentMode;
        @BindView(2131363489)
        LinearLayout paymentStatusLl;
        @BindView(2131363477)
        LinearLayout payment_mode_ll;
        @BindView(2131363547)
        TextView psgnCount_Class_Quota;
        @BindView(2131363609)
        TextView refundAmount;
        @BindView(2131363614)
        TextView refundDate;
        @BindView(2131363624)
        TextView refundStatus;
        @BindView(2131363615)
        LinearLayout refund_date_layout;
        @BindView(2131363617)
        TextView refund_detail_id;
        @BindView(2131363621)
        AdManagerAdView refund_history_center;
        @BindView(2131363622)
        TextView refund_msg;
        @BindView(2131363623)
        LinearLayout refund_msg_layout;
        @BindView(2131363631)
        LinearLayout refunddetail_ll;
        @BindView(2131363635)
        TextView refundtext;
        @BindView(2131364133)
        TextView ticketAmount;
        @BindView(2131364138)
        CardView ticketDetails;
        @BindView(2131364660)
        TextView ticketStatus;
        @BindView(2131364143)
        RelativeLayout ticketStatusRL;
        @BindView(2131364156)
        TextView tkt_details1;
        @BindView(2131364169)
        TextView toCity;
        @BindView(2131364201)
        TextView trainName;
        @BindView(2131364203)
        TextView trainNumber;
        @BindView(2131364214)
        TextView transactionId;
        @BindView(2131364216)
        TextView transactionIdLabel;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131364138})
        public void onTicketClick(View view) {
            FailedItemHolder failedItemHolder = FailedItemHolder.this;
            if (failedItemHolder.f5400a) {
                this.expandLayout.setVisibility(8);
                this.tkt_details1.setVisibility(8);
                failedItemHolder.f5400a = false;
                int i = FailedItemHolder.a;
                return;
            }
            a aVar = failedItemHolder.f5398a;
            if (aVar != null) {
                ((FailedTxnHistoryFragment.a) aVar).a(this.f5401a, view);
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public View a;

        /* renamed from: a  reason: collision with other field name */
        public ViewHolder f5402a;

        /* compiled from: FailedItemHolder$ViewHolder_ViewBinding */
        public class a extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public a(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.onTicketClick(view);
            }
        }

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f5402a = viewHolder;
            View findRequiredView = Utils.findRequiredView(view, R.id.ticket_details, "field 'ticketDetails' and method 'onTicketClick'");
            viewHolder.ticketDetails = (CardView) Utils.castView(findRequiredView, R.id.ticket_details, "field 'ticketDetails'", CardView.class);
            this.a = findRequiredView;
            findRequiredView.setOnClickListener(new a(viewHolder));
            Class cls = TextView.class;
            viewHolder.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
            viewHolder.trainNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainNumber'", cls);
            viewHolder.fromCity = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcitycode, "field 'fromCity'", cls);
            viewHolder.toCity = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'toCity'", cls);
            Class cls2 = LinearLayout.class;
            viewHolder.expandLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.expand_layout, "field 'expandLayout'", cls2);
            viewHolder.transactionId = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_id, "field 'transactionId'", cls);
            viewHolder.transactionIdLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_id_label, "field 'transactionIdLabel'", cls);
            viewHolder.journeyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'journeyDate'", cls);
            viewHolder.refundStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_status, "field 'refundStatus'", cls);
            viewHolder.ticketAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.ticket_amount, "field 'ticketAmount'", cls);
            viewHolder.payment_mode_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.payment_mode_ll, "field 'payment_mode_ll'", cls2);
            viewHolder.paymentMode = (TextView) Utils.findRequiredViewAsType(view, R.id.payment_mode, "field 'paymentMode'", cls);
            viewHolder.refund_date_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.refund_date_layout, "field 'refund_date_layout'", cls2);
            viewHolder.refundDate = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_date, "field 'refundDate'", cls);
            viewHolder.refundAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_amount, "field 'refundAmount'", cls);
            viewHolder.bookingDate = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_date, "field 'bookingDate'", cls);
            viewHolder.bookingDateLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_date_label, "field 'bookingDateLabel'", cls);
            viewHolder.refundtext = (TextView) Utils.findRequiredViewAsType(view, R.id.refundtext, "field 'refundtext'", cls);
            viewHolder.tkt_details1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tkt_details, "field 'tkt_details1'", cls);
            viewHolder.failure_Reason = (TextView) Utils.findRequiredViewAsType(view, R.id.failure_Reason, "field 'failure_Reason'", cls);
            viewHolder.failureReasonLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.failure_Reason_ll, "field 'failureReasonLl'", cls2);
            viewHolder.ticketStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ticket_status, "field 'ticketStatus'", cls);
            viewHolder.ticketStatusRL = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ticket_status_rl, "field 'ticketStatusRL'", RelativeLayout.class);
            viewHolder.paymentStatusLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.payment_status_ll, "field 'paymentStatusLl'", cls2);
            viewHolder.refunddetail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.refunddetail_ll, "field 'refunddetail_ll'", cls2);
            viewHolder.refund_detail_id = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_detail_id, "field 'refund_detail_id'", cls);
            viewHolder.refund_msg_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.refund_msg_layout, "field 'refund_msg_layout'", cls2);
            viewHolder.refund_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_msg, "field 'refund_msg'", cls);
            viewHolder.refund_history_center = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.refund_history_center, "field 'refund_history_center'", AdManagerAdView.class);
            viewHolder.psgnCount_Class_Quota = (TextView) Utils.findRequiredViewAsType(view, R.id.psgnCount_Class_Quota, "field 'psgnCount_Class_Quota'", cls);
            viewHolder.cancellation_id_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.cancellation_id_layout, "field 'cancellation_id_layout'", cls2);
        }

        public final void unbind() {
            ViewHolder viewHolder = this.f5402a;
            if (viewHolder != null) {
                this.f5402a = null;
                viewHolder.ticketDetails = null;
                viewHolder.trainName = null;
                viewHolder.trainNumber = null;
                viewHolder.fromCity = null;
                viewHolder.toCity = null;
                viewHolder.expandLayout = null;
                viewHolder.transactionId = null;
                viewHolder.transactionIdLabel = null;
                viewHolder.journeyDate = null;
                viewHolder.refundStatus = null;
                viewHolder.ticketAmount = null;
                viewHolder.payment_mode_ll = null;
                viewHolder.paymentMode = null;
                viewHolder.refund_date_layout = null;
                viewHolder.refundDate = null;
                viewHolder.refundAmount = null;
                viewHolder.bookingDate = null;
                viewHolder.bookingDateLabel = null;
                viewHolder.refundtext = null;
                viewHolder.tkt_details1 = null;
                viewHolder.failure_Reason = null;
                viewHolder.failureReasonLl = null;
                viewHolder.ticketStatus = null;
                viewHolder.ticketStatusRL = null;
                viewHolder.paymentStatusLl = null;
                viewHolder.refunddetail_ll = null;
                viewHolder.refund_detail_id = null;
                viewHolder.refund_msg_layout = null;
                viewHolder.refund_msg = null;
                viewHolder.refund_history_center = null;
                viewHolder.psgnCount_Class_Quota = null;
                viewHolder.cancellation_id_layout = null;
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
        C1354qp.R(FailedItemHolder.class);
        new SimpleDateFormat("dd MMM yyyy");
        new SimpleDateFormat("dd-MMM-yyyy HH24:mm:SS 'HRS'");
        new SimpleDateFormat("dd");
        new SimpleDateFormat("MMM");
        new SimpleDateFormat("yyyy");
        new SimpleDateFormat("EEE");
        new SimpleDateFormat("HH:mm");
    }

    public FailedItemHolder(a aVar, ArrayList arrayList) {
        this.f5398a = aVar;
        this.f5399a = arrayList;
    }

    public final int getItemCount() {
        ArrayList<BookingResponseDTO> arrayList = this.f5399a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        String str2;
        int i2;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        BookingResponseDTO bookingResponseDTO = this.f5399a.get(i);
        viewHolder2.f5401a = bookingResponseDTO;
        this.f5397a = C0793b1.a.f3911a;
        bookingResponseDTO.toString();
        viewHolder2.cancellation_id_layout.setVisibility(8);
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        if (i == 0 || (i + 1) % 3 != 0) {
            viewHolder2.refund_history_center.setVisibility(8);
        } else {
            viewHolder2.refund_history_center.setVisibility(0);
            C0535I5.Y(FailedTxnHistoryFragment.a, viewHolder2.refund_history_center, googleAdParamDTO);
        }
        viewHolder2.transactionId.setText(" " + bookingResponseDTO.getReservationId());
        viewHolder2.trainName.setText(bookingResponseDTO.getTrainName());
        if (bookingResponseDTO.getTrainNumber() != null) {
            viewHolder2.trainNumber.setText("(" + bookingResponseDTO.getTrainNumber() + ")");
        }
        viewHolder2.fromCity.setText(this.f5397a.m(bookingResponseDTO.getFromStn()) + "(" + bookingResponseDTO.getFromStn() + ")");
        viewHolder2.toCity.setText(this.f5397a.m(bookingResponseDTO.getDestStn()) + "(" + bookingResponseDTO.getDestStn() + ")");
        TextView textView = viewHolder2.bookingDate;
        StringBuilder sb = new StringBuilder(" ");
        sb.append(C0535I5.k(bookingResponseDTO.getTransactionDate()));
        textView.setText(sb.toString());
        String str3 = "";
        if (bookingResponseDTO.getTdrFilingDate() != null) {
            viewHolder2.bookingDate.setText(" " + bookingResponseDTO.getTdrFilingDate().replace(" HRS", str3));
        }
        if (bookingResponseDTO.getJourneyDate() != null) {
            viewHolder2.journeyDate.setText(C0535I5.l(bookingResponseDTO.getJourneyDate()));
        } else {
            viewHolder2.journeyDate.setVisibility(8);
        }
        if (bookingResponseDTO.getNumberOfAdults() != null) {
            StringBuilder J = xx.J(str3 + bookingResponseDTO.getNumberOfAdults().toString() + " " + this.f5396a.getResources().getString(R.string.adult) + " ");
            J.append(bookingResponseDTO.getNumberOfChilds().toString());
            J.append(" ");
            J.append(this.f5396a.getResources().getString(R.string.child));
            J.append(" ");
            str = J.toString();
        } else {
            try {
                i2 = Integer.parseInt(bookingResponseDTO.getNoOfBkdChild()) - Integer.parseInt(bookingResponseDTO.getNoOfCanChild());
            } catch (NumberFormatException e) {
                e.getMessage();
                i2 = 0;
            }
            if (bookingResponseDTO.getNoOfBkdPsgn() == null || bookingResponseDTO.getNoOfCanPsgn() == null || bookingResponseDTO.getNoOfBkdPsgn().trim().equalsIgnoreCase(str3) || bookingResponseDTO.getNoOfCanPsgn().trim().equalsIgnoreCase(str3)) {
                str = str3;
            } else {
                str = str3 + String.valueOf(Integer.parseInt(bookingResponseDTO.getNoOfBkdPsgn()) - i2) + " " + this.f5396a.getResources().getString(R.string.adult) + " ";
            }
            if (!(bookingResponseDTO.getNoOfBkdChild() == null || bookingResponseDTO.getNoOfCanChild() == null)) {
                StringBuilder J2 = xx.J(str);
                J2.append(String.valueOf(Integer.parseInt(bookingResponseDTO.getNoOfBkdChild().trim())));
                J2.append(" ");
                J2.append(this.f5396a.getResources().getString(R.string.child));
                J2.append(" ");
                str = J2.toString();
            }
        }
        if (bookingResponseDTO.getJourneyClass() != null) {
            StringBuilder n = lf.n(str, " | ");
            n.append(bookingResponseDTO.getJourneyClass());
            str = n.toString();
        }
        if (bookingResponseDTO.getQuota() != null) {
            StringBuilder n2 = lf.n(str, " | ");
            n2.append(bookingResponseDTO.getQuota());
            str2 = n2.toString();
        } else {
            StringBuilder n3 = lf.n(str, " | ");
            n3.append(bookingResponseDTO.getBookedQuota());
            str2 = n3.toString();
        }
        if (bookingResponseDTO.getBoardingStn() != null) {
            StringBuilder n4 = lf.n(str2, " | ");
            n4.append(C0535I5.s0(this.f5397a.m(bookingResponseDTO.getBoardingStn())));
            str2 = n4.toString();
        }
        if (bookingResponseDTO.getBoardingDate() != null) {
            StringBuilder n5 = lf.n(str2, " | ");
            n5.append(C0535I5.h(bookingResponseDTO.getBoardingDate()));
            str2 = n5.toString();
        }
        viewHolder2.psgnCount_Class_Quota.setText(str2);
        if (!bookingResponseDTO.getRetryBooking().booleanValue() || this.f5400a) {
            viewHolder2.expandLayout.setVisibility(8);
            this.f5400a = false;
        } else {
            viewHolder2.expandLayout.setVisibility(0);
            this.f5400a = true;
            if (bookingResponseDTO.getFailureReason() != null) {
                viewHolder2.failureReasonLl.setVisibility(0);
                viewHolder2.failure_Reason.setText(bookingResponseDTO.getFailureReason());
            } else {
                viewHolder2.failureReasonLl.setVisibility(8);
            }
            viewHolder2.ticketAmount.setText(String.valueOf(bookingResponseDTO.getTotalCollectibleAmount()));
            if (bookingResponseDTO.getRefundAmount() == null || bookingResponseDTO.getPaymentStatus() == null || bookingResponseDTO.getPaymentStatus().contains("Pending from bank End")) {
                viewHolder2.refundtext.setVisibility(8);
                viewHolder2.refundAmount.setVisibility(8);
            } else {
                viewHolder2.refundAmount.setText(" ".concat(String.valueOf(bookingResponseDTO.getRefundAmount())));
            }
            if (bookingResponseDTO.getBankName() == null || bookingResponseDTO.getBankName() == str3) {
                viewHolder2.payment_mode_ll.setVisibility(8);
            } else {
                viewHolder2.paymentMode.setText(bookingResponseDTO.getBankName());
            }
            if (bookingResponseDTO.getRefundDate() != null) {
                viewHolder2.refundDate.setText(new SimpleDateFormat("dd MMM, yyyy | HH:mm:ss").format(bookingResponseDTO.getRefundDate()));
            } else {
                viewHolder2.refundDate.setText(str3);
                viewHolder2.refund_date_layout.setVisibility(8);
            }
        }
        if (bookingResponseDTO.getReservationStatus() != null) {
            viewHolder2.paymentStatusLl.setVisibility(0);
            viewHolder2.ticketStatusRL.setVisibility(0);
            viewHolder2.ticketStatus.setVisibility(0);
            viewHolder2.ticketStatus.setText(bookingResponseDTO.getReservationStatus());
        } else {
            viewHolder2.ticketStatusRL.setVisibility(8);
            viewHolder2.paymentStatusLl.setVisibility(8);
        }
        if (bookingResponseDTO.getPaymentStatus() != null) {
            viewHolder2.paymentStatusLl.setVisibility(0);
            viewHolder2.refundStatus.setText(bookingResponseDTO.getPaymentStatus());
        } else {
            viewHolder2.paymentStatusLl.setVisibility(8);
        }
        if (bookingResponseDTO.getRefundStatusEtTkt() == null || bookingResponseDTO.getRefundStatusEtTkt() == str3) {
            viewHolder2.refunddetail_ll.setVisibility(8);
        } else {
            viewHolder2.refund_detail_id.setText(bookingResponseDTO.getRefundStatusEtTkt());
        }
        if (!(bookingResponseDTO.getRefundStatusDes() == null || bookingResponseDTO.getRefundStatusDes() == str3)) {
            str3 = bookingResponseDTO.getRefundStatusDes() + "\n\n";
        }
        TextView textView2 = viewHolder2.refund_msg;
        StringBuilder J3 = xx.J(str3);
        J3.append(this.f5396a.getString(R.string.refund_msg));
        textView2.setText(J3.toString());
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_failed_ticket, (ViewGroup) null);
        this.f5396a = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
