package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class CancelTicketDetailsFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public CancelTicketDetailsFragment f4491a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTicketDetailsFragment a;

        public a(CancelTicketDetailsFragment cancelTicketDetailsFragment) {
            this.a = cancelTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.sortBottomLLClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTicketDetailsFragment a;

        public b(CancelTicketDetailsFragment cancelTicketDetailsFragment) {
            this.a = cancelTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.onDmrcDecrementClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTicketDetailsFragment a;

        public c(CancelTicketDetailsFragment cancelTicketDetailsFragment) {
            this.a = cancelTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.onDmrcIncrementtClick();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTicketDetailsFragment a;

        public d(CancelTicketDetailsFragment cancelTicketDetailsFragment) {
            this.a = cancelTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.hj();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTicketDetailsFragment a;

        public e(CancelTicketDetailsFragment cancelTicketDetailsFragment) {
            this.a = cancelTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.rme();
        }
    }

    public CancelTicketDetailsFragment_ViewBinding(CancelTicketDetailsFragment cancelTicketDetailsFragment, View view) {
        this.f4491a = cancelTicketDetailsFragment;
        cancelTicketDetailsFragment.passengerList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_passenger_list, "field 'passengerList'", RecyclerView.class);
        Class cls = TextView.class;
        cancelTicketDetailsFragment.pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnr'", cls);
        cancelTicketDetailsFragment.pnrNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr_number, "field 'pnrNumber'", cls);
        cancelTicketDetailsFragment.transactionId = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_id, "field 'transactionId'", cls);
        cancelTicketDetailsFragment.refundAmountTime = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_amount_time, "field 'refundAmountTime'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.refund_enquiry_bottom_ll, "field 'refund_enquiry_bottom_ll' and method 'sortBottomLLClick'");
        cancelTicketDetailsFragment.refund_enquiry_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView, R.id.refund_enquiry_bottom_ll, "field 'refund_enquiry_bottom_ll'", RelativeLayout.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(cancelTicketDetailsFragment));
        cancelTicketDetailsFragment.refundAmt = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_amount, "field 'refundAmt'", cls);
        cancelTicketDetailsFragment.cancellationCharge = (TextView) Utils.findRequiredViewAsType(view, R.id.cancellation_charge, "field 'cancellationCharge'", cls);
        Class cls2 = LinearLayout.class;
        cancelTicketDetailsFragment.connectingPnrLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.connecting_pnr_layout, "field 'connectingPnrLayout'", cls2);
        cancelTicketDetailsFragment.connectingPnr = (TextView) Utils.findRequiredViewAsType(view, R.id.connecting_pnr, "field 'connectingPnr'", cls);
        cancelTicketDetailsFragment.lapType = (TextView) Utils.findRequiredViewAsType(view, R.id.lap_type, "field 'lapType'", cls);
        cancelTicketDetailsFragment.trainno = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainno'", cls);
        cancelTicketDetailsFragment.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
        Class cls3 = ImageView.class;
        cancelTicketDetailsFragment.tvFavpnricon = (ImageView) Utils.findRequiredViewAsType(view, R.id.tv_favpnricon, "field 'tvFavpnricon'", cls3);
        cancelTicketDetailsFragment.journeyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'journeyDate'", cls);
        cancelTicketDetailsFragment.journeyTime = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_time, "field 'journeyTime'", cls);
        cancelTicketDetailsFragment.destArrDate = (TextView) Utils.findRequiredViewAsType(view, R.id.dest_arr_date, "field 'destArrDate'", cls);
        cancelTicketDetailsFragment.destArrTime = (TextView) Utils.findRequiredViewAsType(view, R.id.dest_arr_time, "field 'destArrTime'", cls);
        cancelTicketDetailsFragment.noOfPassenger = (TextView) Utils.findRequiredViewAsType(view, R.id.no_of_passenger, "field 'noOfPassenger'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.iv_dmrc_min, "field 'ivdmrcmin' and method 'onDmrcDecrementClick'");
        cancelTicketDetailsFragment.ivdmrcmin = (ImageView) Utils.castView(findRequiredView2, R.id.iv_dmrc_min, "field 'ivdmrcmin'", cls3);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(cancelTicketDetailsFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_dmrc_plus, "field 'ivdmrcplus' and method 'onDmrcIncrementtClick'");
        cancelTicketDetailsFragment.ivdmrcplus = (ImageView) Utils.castView(findRequiredView3, R.id.iv_dmrc_plus, "field 'ivdmrcplus'", cls3);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(cancelTicketDetailsFragment));
        Class cls4 = CheckBox.class;
        cancelTicketDetailsFragment.selectall = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select_all, "field 'selectall'", cls4);
        cancelTicketDetailsFragment.selectAlllayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.select_layout, "field 'selectAlllayout'", cls2);
        cancelTicketDetailsFragment.tktDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tkt_details, "field 'tktDetails'", cls);
        cancelTicketDetailsFragment.tocitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'tocitycode'", cls);
        cancelTicketDetailsFragment.fromcitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcidtycode, "field 'fromcitycode'", cls);
        cancelTicketDetailsFragment.travel_time = (TextView) Utils.findRequiredViewAsType(view, R.id.travel_time, "field 'travel_time'", cls);
        cancelTicketDetailsFragment.traveltime2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.travel_time2, "field 'traveltime2'", cls2);
        cancelTicketDetailsFragment.tv_chart_status = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_chart_status, "field 'tv_chart_status'", cls);
        cancelTicketDetailsFragment.errmessage = (TextView) Utils.findRequiredViewAsType(view, R.id.errmessage, "field 'errmessage'", cls);
        cancelTicketDetailsFragment.fromStnDmrc = (TextView) Utils.findRequiredViewAsType(view, R.id.fromStnDmrc, "field 'fromStnDmrc'", cls);
        cancelTicketDetailsFragment.no_of_can_psgn = (TextView) Utils.findRequiredViewAsType(view, R.id.no_of_can_psgn, "field 'no_of_can_psgn'", cls);
        cancelTicketDetailsFragment.no_of_psgn = (TextView) Utils.findRequiredViewAsType(view, R.id.no_of_psgn, "field 'no_of_psgn'", cls);
        cancelTicketDetailsFragment.toStnDmrc = (TextView) Utils.findRequiredViewAsType(view, R.id.toStnDmrc, "field 'toStnDmrc'", cls);
        cancelTicketDetailsFragment.selected_psgn = (TextView) Utils.findRequiredViewAsType(view, R.id.selected_psgn, "field 'selected_psgn'", cls);
        cancelTicketDetailsFragment.no_of_passenger_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.no_of_passenger_ll, "field 'no_of_passenger_ll'", cls2);
        cancelTicketDetailsFragment.selection_checkbox_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.selection_checkbox_ll, "field 'selection_checkbox_ll'", cls2);
        cancelTicketDetailsFragment.selectAllDmrcTicket = (CheckBox) Utils.findRequiredViewAsType(view, R.id.select_all_dmrc, "field 'selectAllDmrcTicket'", cls4);
        cancelTicketDetailsFragment.metro_ticket = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.metro_ticket, "field 'metro_ticket'", cls2);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.cancel, "field 'cancel' and method 'hj'");
        cancelTicketDetailsFragment.cancel = (TextView) Utils.castView(findRequiredView4, R.id.cancel, "field 'cancel'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(cancelTicketDetailsFragment));
        cancelTicketDetailsFragment.booking_amnt = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_amnt, "field 'booking_amnt'", cls);
        cancelTicketDetailsFragment.refund_amnt = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_amnt, "field 'refund_amnt'", cls);
        cancelTicketDetailsFragment.fromcdmrcstn = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcdmrcstn, "field 'fromcdmrcstn'", cls);
        cancelTicketDetailsFragment.todmrcstn = (TextView) Utils.findRequiredViewAsType(view, R.id.todmrcstn, "field 'todmrcstn'", cls);
        cancelTicketDetailsFragment.cancel_detail_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.cancel_detail_bottom, "field 'cancel_detail_bottom'", AdManagerAdView.class);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.refundEnq, "method 'rme'");
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(cancelTicketDetailsFragment));
    }

    public final void unbind() {
        CancelTicketDetailsFragment cancelTicketDetailsFragment = this.f4491a;
        if (cancelTicketDetailsFragment != null) {
            this.f4491a = null;
            cancelTicketDetailsFragment.passengerList = null;
            cancelTicketDetailsFragment.pnr = null;
            cancelTicketDetailsFragment.pnrNumber = null;
            cancelTicketDetailsFragment.transactionId = null;
            cancelTicketDetailsFragment.refundAmountTime = null;
            cancelTicketDetailsFragment.refund_enquiry_bottom_ll = null;
            cancelTicketDetailsFragment.refundAmt = null;
            cancelTicketDetailsFragment.cancellationCharge = null;
            cancelTicketDetailsFragment.connectingPnrLayout = null;
            cancelTicketDetailsFragment.connectingPnr = null;
            cancelTicketDetailsFragment.lapType = null;
            cancelTicketDetailsFragment.trainno = null;
            cancelTicketDetailsFragment.trainName = null;
            cancelTicketDetailsFragment.tvFavpnricon = null;
            cancelTicketDetailsFragment.journeyDate = null;
            cancelTicketDetailsFragment.journeyTime = null;
            cancelTicketDetailsFragment.destArrDate = null;
            cancelTicketDetailsFragment.destArrTime = null;
            cancelTicketDetailsFragment.noOfPassenger = null;
            cancelTicketDetailsFragment.ivdmrcmin = null;
            cancelTicketDetailsFragment.ivdmrcplus = null;
            cancelTicketDetailsFragment.selectall = null;
            cancelTicketDetailsFragment.selectAlllayout = null;
            cancelTicketDetailsFragment.tktDetails = null;
            cancelTicketDetailsFragment.tocitycode = null;
            cancelTicketDetailsFragment.fromcitycode = null;
            cancelTicketDetailsFragment.travel_time = null;
            cancelTicketDetailsFragment.traveltime2 = null;
            cancelTicketDetailsFragment.tv_chart_status = null;
            cancelTicketDetailsFragment.errmessage = null;
            cancelTicketDetailsFragment.fromStnDmrc = null;
            cancelTicketDetailsFragment.no_of_can_psgn = null;
            cancelTicketDetailsFragment.no_of_psgn = null;
            cancelTicketDetailsFragment.toStnDmrc = null;
            cancelTicketDetailsFragment.selected_psgn = null;
            cancelTicketDetailsFragment.no_of_passenger_ll = null;
            cancelTicketDetailsFragment.selection_checkbox_ll = null;
            cancelTicketDetailsFragment.selectAllDmrcTicket = null;
            cancelTicketDetailsFragment.metro_ticket = null;
            cancelTicketDetailsFragment.cancel = null;
            cancelTicketDetailsFragment.booking_amnt = null;
            cancelTicketDetailsFragment.refund_amnt = null;
            cancelTicketDetailsFragment.fromcdmrcstn = null;
            cancelTicketDetailsFragment.todmrcstn = null;
            cancelTicketDetailsFragment.cancel_detail_bottom = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            this.e.setOnClickListener((View.OnClickListener) null);
            this.e = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
