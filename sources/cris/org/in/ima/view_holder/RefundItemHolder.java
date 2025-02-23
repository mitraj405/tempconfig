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
import cris.org.in.ima.fragment.RefundTxnHistoryFragment;
import cris.org.in.prs.ima.R;
import defpackage.C0613Ns;
import java.util.ArrayList;

public final class RefundItemHolder extends RecyclerView.Adapter<ViewHolder> {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Context f5410a;

    /* renamed from: a  reason: collision with other field name */
    public final a f5411a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<C0613Ns.a> f5412a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5413a = false;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131361813)
        TextView TI_refund_amount;
        @BindView(2131361814)
        LinearLayout TI_refund_ll;
        public C0613Ns.a a;
        @BindView(2131362060)
        TextView bookingDate;
        @BindView(2131362120)
        TextView cancellationId;
        @BindView(2131362123)
        RelativeLayout cancellationIdRl;
        @BindView(2131362122)
        LinearLayout cancellation_id_layout;
        @BindView(2131362624)
        LinearLayout expandLayout;
        @BindView(2131362631)
        LinearLayout failureReasonLl;
        @BindView(2131362716)
        TextView fromCity;
        @BindView(2131362920)
        TextView journeyDate;
        @BindView(2131363216)
        TextView metroTicketOpted;
        @BindView(2131363475)
        TextView paymentMode;
        @BindView(2131364526)
        TextView paymentStatus;
        @BindView(2131363477)
        LinearLayout payment_mode_ll;
        @BindView(2131363506)
        TextView pnr;
        @BindView(2131363517)
        TextView pnrLabel;
        @BindView(2131363547)
        TextView psgnCount_Class_Quota;
        @BindView(2131363609)
        TextView refundAmount;
        @BindView(2131363614)
        TextView refundDate;
        @BindView(2131363615)
        LinearLayout refundDateLayout;
        @BindView(2131363622)
        TextView refundMsg;
        @BindView(2131363624)
        TextView refundStatus;
        @BindView(2131363611)
        LinearLayout refund_amount_ll;
        @BindView(2131363616)
        TextView refund_detail;
        @BindView(2131363617)
        TextView refund_detail_id;
        @BindView(2131363621)
        AdManagerAdView refund_history_center;
        @BindView(2131363631)
        LinearLayout refunddetail_ll;
        @BindView(2131364133)
        TextView ticketAmount;
        @BindView(2131364660)
        TextView ticketStatus;
        @BindView(2131364143)
        RelativeLayout ticketStatusRL;
        @BindView(2131364134)
        TextView ticket_amount_label;
        @BindView(2131364138)
        CardView tktDtls;
        @BindView(2131364169)
        TextView toCity;
        @BindView(2131364201)
        TextView trainName;
        @BindView(2131364203)
        TextView trainNumber;
        @BindView(2131364214)
        TextView transactionId;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131364138})
        public void TicketDtls(View view) {
            RefundItemHolder refundItemHolder = RefundItemHolder.this;
            if (refundItemHolder.f5413a) {
                this.expandLayout.setVisibility(8);
                refundItemHolder.f5413a = false;
                int i = RefundItemHolder.a;
                return;
            }
            a aVar = refundItemHolder.f5411a;
            if (aVar != null) {
                ((RefundTxnHistoryFragment.b) aVar).a(this.a, view);
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public View a;

        /* renamed from: a  reason: collision with other field name */
        public ViewHolder f5415a;

        /* compiled from: RefundItemHolder$ViewHolder_ViewBinding */
        public class a extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public a(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.TicketDtls(view);
            }
        }

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f5415a = viewHolder;
            Class cls = TextView.class;
            viewHolder.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
            viewHolder.trainNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainNumber'", cls);
            viewHolder.fromCity = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcitycode, "field 'fromCity'", cls);
            viewHolder.toCity = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'toCity'", cls);
            Class cls2 = LinearLayout.class;
            viewHolder.expandLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.expand_layout, "field 'expandLayout'", cls2);
            viewHolder.transactionId = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_id, "field 'transactionId'", cls);
            viewHolder.journeyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'journeyDate'", cls);
            viewHolder.refundStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_status, "field 'refundStatus'", cls);
            viewHolder.bookingDate = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_date, "field 'bookingDate'", cls);
            viewHolder.ticketAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.ticket_amount, "field 'ticketAmount'", cls);
            viewHolder.refundAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_amount, "field 'refundAmount'", cls);
            viewHolder.metroTicketOpted = (TextView) Utils.findRequiredViewAsType(view, R.id.metroTicketOpted, "field 'metroTicketOpted'", cls);
            viewHolder.payment_mode_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.payment_mode_ll, "field 'payment_mode_ll'", cls2);
            viewHolder.paymentMode = (TextView) Utils.findRequiredViewAsType(view, R.id.payment_mode, "field 'paymentMode'", cls);
            Class cls3 = RelativeLayout.class;
            viewHolder.cancellationIdRl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.cancellation_id_rl, "field 'cancellationIdRl'", cls3);
            viewHolder.refundDate = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_date, "field 'refundDate'", cls);
            viewHolder.refundMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_msg, "field 'refundMsg'", cls);
            viewHolder.pnrLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr_label, "field 'pnrLabel'", cls);
            viewHolder.pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnr'", cls);
            viewHolder.cancellationId = (TextView) Utils.findRequiredViewAsType(view, R.id.cancellation_id, "field 'cancellationId'", cls);
            viewHolder.refundDateLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.refund_date_layout, "field 'refundDateLayout'", cls2);
            viewHolder.failureReasonLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.failure_Reason_ll, "field 'failureReasonLl'", cls2);
            View findRequiredView = Utils.findRequiredView(view, R.id.ticket_details, "field 'tktDtls' and method 'TicketDtls'");
            viewHolder.tktDtls = (CardView) Utils.castView(findRequiredView, R.id.ticket_details, "field 'tktDtls'", CardView.class);
            this.a = findRequiredView;
            findRequiredView.setOnClickListener(new a(viewHolder));
            viewHolder.paymentStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_payment_status, "field 'paymentStatus'", cls);
            viewHolder.ticketStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ticket_status, "field 'ticketStatus'", cls);
            viewHolder.ticketStatusRL = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ticket_status_rl, "field 'ticketStatusRL'", cls3);
            viewHolder.refunddetail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.refunddetail_ll, "field 'refunddetail_ll'", cls2);
            viewHolder.refund_detail = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_detail, "field 'refund_detail'", cls);
            viewHolder.refund_detail_id = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_detail_id, "field 'refund_detail_id'", cls);
            viewHolder.ticket_amount_label = (TextView) Utils.findRequiredViewAsType(view, R.id.ticket_amount_label, "field 'ticket_amount_label'", cls);
            viewHolder.refund_amount_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.refund_amount_ll, "field 'refund_amount_ll'", cls2);
            viewHolder.refund_history_center = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.refund_history_center, "field 'refund_history_center'", AdManagerAdView.class);
            viewHolder.psgnCount_Class_Quota = (TextView) Utils.findRequiredViewAsType(view, R.id.psgnCount_Class_Quota, "field 'psgnCount_Class_Quota'", cls);
            viewHolder.TI_refund_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.TI_refund_ll, "field 'TI_refund_ll'", cls2);
            viewHolder.TI_refund_amount = (TextView) Utils.findRequiredViewAsType(view, R.id.TI_refund_amount, "field 'TI_refund_amount'", cls);
            viewHolder.cancellation_id_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.cancellation_id_layout, "field 'cancellation_id_layout'", cls2);
        }

        public final void unbind() {
            ViewHolder viewHolder = this.f5415a;
            if (viewHolder != null) {
                this.f5415a = null;
                viewHolder.trainName = null;
                viewHolder.trainNumber = null;
                viewHolder.fromCity = null;
                viewHolder.toCity = null;
                viewHolder.expandLayout = null;
                viewHolder.transactionId = null;
                viewHolder.journeyDate = null;
                viewHolder.refundStatus = null;
                viewHolder.bookingDate = null;
                viewHolder.ticketAmount = null;
                viewHolder.refundAmount = null;
                viewHolder.metroTicketOpted = null;
                viewHolder.payment_mode_ll = null;
                viewHolder.paymentMode = null;
                viewHolder.cancellationIdRl = null;
                viewHolder.refundDate = null;
                viewHolder.refundMsg = null;
                viewHolder.pnrLabel = null;
                viewHolder.pnr = null;
                viewHolder.cancellationId = null;
                viewHolder.refundDateLayout = null;
                viewHolder.failureReasonLl = null;
                viewHolder.tktDtls = null;
                viewHolder.paymentStatus = null;
                viewHolder.ticketStatus = null;
                viewHolder.ticketStatusRL = null;
                viewHolder.refunddetail_ll = null;
                viewHolder.refund_detail = null;
                viewHolder.refund_detail_id = null;
                viewHolder.ticket_amount_label = null;
                viewHolder.refund_amount_ll = null;
                viewHolder.refund_history_center = null;
                viewHolder.psgnCount_Class_Quota = null;
                viewHolder.TI_refund_ll = null;
                viewHolder.TI_refund_amount = null;
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
        C1354qp.R(RefundItemHolder.class);
    }

    public RefundItemHolder(ArrayList arrayList, a aVar) {
        this.f5411a = aVar;
        this.f5412a = arrayList;
    }

    public final int getItemCount() {
        ArrayList<C0613Ns.a> arrayList = this.f5412a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        C0613Ns.a aVar = this.f5412a.get(i);
        StationDb stationDb = C0793b1.a.f3911a;
        viewHolder2.psgnCount_Class_Quota.setVisibility(8);
        aVar.toString();
        viewHolder2.a = aVar;
        viewHolder2.trainName.setText(aVar.getTrainName());
        TextView textView = viewHolder2.trainNumber;
        textView.setText("(" + aVar.getTrainNo() + ")");
        TextView textView2 = viewHolder2.fromCity;
        textView2.setText(stationDb.m(aVar.getFromStation()) + "(" + aVar.getFromStation() + ")");
        TextView textView3 = viewHolder2.toCity;
        textView3.setText(stationDb.m(aVar.getToStation()) + "(" + aVar.getToStation() + ")");
        viewHolder2.bookingDate.setText(C0535I5.d(aVar.getTransactionDate()));
        viewHolder2.journeyDate.setText(C0535I5.l(aVar.getJourneyDate()));
        viewHolder2.refundStatus.setText(aVar.getEtRefundStatus());
        if (aVar.getRefundStatusDes() == null || aVar.getRefundStatusDes() == "") {
            viewHolder2.refundMsg.setText("");
        } else {
            TextView textView4 = viewHolder2.refundMsg;
            textView4.setText("Remark: " + aVar.getRefundStatusDes());
        }
        viewHolder2.ticketAmount.setText(String.valueOf(aVar.getTicketAmount()));
        viewHolder2.refundAmount.setText(" ".concat(String.valueOf(aVar.getEtRefundAmount())));
        if (aVar.getSoftFlag() != null && aVar.getSoftFlag().intValue() == 2) {
            aVar.setBankName(this.f5410a.getString(R.string.show_bank_name_in_refund_history));
        }
        if (aVar.getBankName() == null || aVar.getBankName() == "") {
            viewHolder2.payment_mode_ll.setVisibility(8);
        } else {
            viewHolder2.paymentMode.setText(aVar.getBankName());
        }
        String str = C0535I5.f;
        if (str == null || str == "") {
            viewHolder2.refunddetail_ll.setVisibility(8);
        } else {
            viewHolder2.refund_detail_id.setText(str);
        }
        viewHolder2.TI_refund_ll.setVisibility(0);
        viewHolder2.TI_refund_amount.setText(String.valueOf(aVar.getTravelnsuranceRefundAmount()));
        viewHolder2.refundDate.setText(C0535I5.d(aVar.getEtRefundTransDate()));
        if (aVar.getEtRefundTransDate() == null) {
            viewHolder2.refundDateLayout.setVisibility(8);
        } else {
            viewHolder2.refundDateLayout.setVisibility(0);
        }
        viewHolder2.transactionId.setText(aVar.getReservationId());
        viewHolder2.failureReasonLl.setVisibility(8);
        if (aVar.getEtRefundType() != null) {
            viewHolder2.ticketStatusRL.setVisibility(0);
            viewHolder2.paymentStatus.setText("Refund Status:");
            viewHolder2.ticketStatus.setText(aVar.getEtRefundType());
        } else {
            viewHolder2.ticketStatusRL.setVisibility(8);
        }
        if (aVar.getPsgnDtlList() == null || this.f5413a) {
            viewHolder2.expandLayout.setVisibility(8);
            this.f5413a = false;
        } else {
            viewHolder2.expandLayout.setVisibility(0);
            this.f5413a = true;
        }
        viewHolder2.cancellationIdRl.setVisibility(0);
        TextView textView5 = viewHolder2.cancellationId;
        textView5.setText(" " + aVar.getTransactionId());
        if (aVar.getPnr() != null) {
            viewHolder2.pnrLabel.setVisibility(0);
            viewHolder2.pnr.setVisibility(0);
            TextView textView6 = viewHolder2.pnr;
            textView6.setText(" " + aVar.getPnr());
        } else {
            viewHolder2.pnrLabel.setVisibility(8);
            viewHolder2.pnr.setVisibility(8);
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        if (i == 0 || (i + 1) % 3 != 0) {
            viewHolder2.refund_history_center.setVisibility(8);
        } else {
            viewHolder2.refund_history_center.setVisibility(0);
            C0535I5.Y(RefundTxnHistoryFragment.a, viewHolder2.refund_history_center, googleAdParamDTO);
        }
        if (aVar.isMetroServiceOpted()) {
            viewHolder2.metroTicketOpted.setVisibility(0);
        } else {
            viewHolder2.metroTicketOpted.setVisibility(8);
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_failed_ticket, (ViewGroup) null);
        this.f5410a = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
