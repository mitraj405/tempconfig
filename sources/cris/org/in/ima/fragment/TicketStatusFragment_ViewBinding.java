package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class TicketStatusFragment_ViewBinding implements Unbinder {
    public TicketStatusFragment a;

    public TicketStatusFragment_ViewBinding(TicketStatusFragment ticketStatusFragment, View view) {
        this.a = ticketStatusFragment;
        Class cls = TextView.class;
        ticketStatusFragment.pnrNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnrNumber'", cls);
        ticketStatusFragment.trainNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainNumber'", cls);
        ticketStatusFragment.journeyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'journeyDate'", cls);
        ticketStatusFragment.journeyTime = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_time, "field 'journeyTime'", cls);
        ticketStatusFragment.destArrDate = (TextView) Utils.findRequiredViewAsType(view, R.id.dest_arr_date, "field 'destArrDate'", cls);
        ticketStatusFragment.destArrTime = (TextView) Utils.findRequiredViewAsType(view, R.id.dest_arr_time, "field 'destArrTime'", cls);
        ticketStatusFragment.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
        ticketStatusFragment.fromStation = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcidtycode, "field 'fromStation'", cls);
        ticketStatusFragment.toStation = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'toStation'", cls);
        ticketStatusFragment.traveltime = (TextView) Utils.findRequiredViewAsType(view, R.id.travel_time, "field 'traveltime'", cls);
        ticketStatusFragment.tktDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tkt_details, "field 'tktDetails'", cls);
        ticketStatusFragment.refundAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_amount, "field 'refundAmount'", cls);
        Class cls2 = RelativeLayout.class;
        ticketStatusFragment.refund_amount_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.refund_amount_rl, "field 'refund_amount_rl'", cls2);
        Class cls3 = LinearLayout.class;
        ticketStatusFragment.tv_psgn_detail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tv_psgn_detail_ll, "field 'tv_psgn_detail_ll'", cls3);
        ticketStatusFragment.passengerList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.psgn_list, "field 'passengerList'", RecyclerView.class);
        ticketStatusFragment.tvFavpnricon = (ImageView) Utils.findRequiredViewAsType(view, R.id.tv_favpnricon, "field 'tvFavpnricon'", ImageView.class);
        ticketStatusFragment.camcel_tkt_status_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.camcel_tkt_status_bottom, "field 'camcel_tkt_status_bottom'", AdManagerAdView.class);
        ticketStatusFragment.tv_it_refund_amount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_it_refund_amount, "field 'tv_it_refund_amount'", cls);
        ticketStatusFragment.no_of_psgn = (TextView) Utils.findRequiredViewAsType(view, R.id.no_of_psgn, "field 'no_of_psgn'", cls);
        ticketStatusFragment.fromcdmrcstn = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcdmrcstn, "field 'fromcdmrcstn'", cls);
        ticketStatusFragment.todmrcstn = (TextView) Utils.findRequiredViewAsType(view, R.id.todmrcstn, "field 'todmrcstn'", cls);
        ticketStatusFragment.linked_pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.linked_pnr, "field 'linked_pnr'", cls);
        ticketStatusFragment.refund_subject = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_subject, "field 'refund_subject'", cls);
        ticketStatusFragment.no_of_can_psgn = (TextView) Utils.findRequiredViewAsType(view, R.id.no_of_can_psgn, "field 'no_of_can_psgn'", cls);
        ticketStatusFragment.booking_amnt = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_amnt, "field 'booking_amnt'", cls);
        ticketStatusFragment.refund_amnt = (TextView) Utils.findRequiredViewAsType(view, R.id.refund_amnt, "field 'refund_amnt'", cls);
        ticketStatusFragment.metro_ticket = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.metro_ticket, "field 'metro_ticket'", cls3);
        ticketStatusFragment.dmrc_cancel_status = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_cancel_status, "field 'dmrc_cancel_status'", cls);
        ticketStatusFragment.dmrcJdate = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_Jdate, "field 'dmrcJdate'", cls);
        ticketStatusFragment.travel_insurance_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.travel_insurance_rl, "field 'travel_insurance_rl'", cls2);
        ticketStatusFragment.feedback_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.feedback_ll, "field 'feedback_ll'", cls3);
    }

    public final void unbind() {
        TicketStatusFragment ticketStatusFragment = this.a;
        if (ticketStatusFragment != null) {
            this.a = null;
            ticketStatusFragment.pnrNumber = null;
            ticketStatusFragment.trainNumber = null;
            ticketStatusFragment.journeyDate = null;
            ticketStatusFragment.journeyTime = null;
            ticketStatusFragment.destArrDate = null;
            ticketStatusFragment.destArrTime = null;
            ticketStatusFragment.trainName = null;
            ticketStatusFragment.fromStation = null;
            ticketStatusFragment.toStation = null;
            ticketStatusFragment.traveltime = null;
            ticketStatusFragment.tktDetails = null;
            ticketStatusFragment.refundAmount = null;
            ticketStatusFragment.refund_amount_rl = null;
            ticketStatusFragment.tv_psgn_detail_ll = null;
            ticketStatusFragment.passengerList = null;
            ticketStatusFragment.tvFavpnricon = null;
            ticketStatusFragment.camcel_tkt_status_bottom = null;
            ticketStatusFragment.tv_it_refund_amount = null;
            ticketStatusFragment.no_of_psgn = null;
            ticketStatusFragment.fromcdmrcstn = null;
            ticketStatusFragment.todmrcstn = null;
            ticketStatusFragment.linked_pnr = null;
            ticketStatusFragment.refund_subject = null;
            ticketStatusFragment.no_of_can_psgn = null;
            ticketStatusFragment.booking_amnt = null;
            ticketStatusFragment.refund_amnt = null;
            ticketStatusFragment.metro_ticket = null;
            ticketStatusFragment.dmrc_cancel_status = null;
            ticketStatusFragment.dmrcJdate = null;
            ticketStatusFragment.travel_insurance_rl = null;
            ticketStatusFragment.feedback_ll = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
