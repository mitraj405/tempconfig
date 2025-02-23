package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
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

public class PnrEnquiryFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public PnrEnquiryFragment f5046a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ PnrEnquiryFragment a;

        public a(PnrEnquiryFragment pnrEnquiryFragment) {
            this.a = pnrEnquiryFragment;
        }

        public final void doClick(View view) {
            this.a.cnfCheckCetails();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ PnrEnquiryFragment a;

        public b(PnrEnquiryFragment pnrEnquiryFragment) {
            this.a = pnrEnquiryFragment;
        }

        public final void doClick(View view) {
            this.a.onClickFavoritePnr();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ PnrEnquiryFragment a;

        public c(PnrEnquiryFragment pnrEnquiryFragment) {
            this.a = pnrEnquiryFragment;
        }

        public final void doClick(View view) {
            this.a.onSearchClick();
        }
    }

    public PnrEnquiryFragment_ViewBinding(PnrEnquiryFragment pnrEnquiryFragment, View view) {
        this.f5046a = pnrEnquiryFragment;
        Class cls = TextView.class;
        pnrEnquiryFragment.pnrNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnrNumber'", cls);
        pnrEnquiryFragment.trainNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainNumber'", cls);
        pnrEnquiryFragment.destArrDate = (TextView) Utils.findRequiredViewAsType(view, R.id.dest_arr_date, "field 'destArrDate'", cls);
        pnrEnquiryFragment.destArrTime = (TextView) Utils.findRequiredViewAsType(view, R.id.dest_arr_time, "field 'destArrTime'", cls);
        pnrEnquiryFragment.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
        pnrEnquiryFragment.fromStation = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcidtycode, "field 'fromStation'", cls);
        pnrEnquiryFragment.toStation = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'toStation'", cls);
        pnrEnquiryFragment.jrnyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'jrnyDate'", cls);
        Class cls2 = RecyclerView.class;
        pnrEnquiryFragment.psgnList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.psgn_list, "field 'psgnList'", cls2);
        pnrEnquiryFragment.tktDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tkt_details, "field 'tktDetails'", cls);
        pnrEnquiryFragment.pnr_view = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_pnr, "field 'pnr_view'", EditText.class);
        pnrEnquiryFragment.pre = (TextView) Utils.findRequiredViewAsType(view, R.id.pre, "field 'pre'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.cnf_check_details, "field 'cnfCheckCetails' and method 'cnfCheckCetails'");
        pnrEnquiryFragment.cnfCheckCetails = (TextView) Utils.castView(findRequiredView, R.id.cnf_check_details, "field 'cnfCheckCetails'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(pnrEnquiryFragment));
        Class cls3 = LinearLayout.class;
        pnrEnquiryFragment.cnfBtnLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.cnf_btn_layout, "field 'cnfBtnLayout'", cls3);
        Class cls4 = AdManagerAdView.class;
        pnrEnquiryFragment.pnrEquiryTop = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.pnr_equiry_top, "field 'pnrEquiryTop'", cls4);
        pnrEnquiryFragment.pnrResultTop = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.pnr_equiry_result_top, "field 'pnrResultTop'", cls4);
        pnrEnquiryFragment.pnrEquiryBottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.pnr_equiry_bottom, "field 'pnrEquiryBottom'", cls4);
        pnrEnquiryFragment.favPnrList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.tv_fav_pnr, "field 'favPnrList'", cls2);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_pnradd, "field 'selectFavPnr' and method 'onClickFavoritePnr'");
        pnrEnquiryFragment.selectFavPnr = (LinearLayout) Utils.castView(findRequiredView2, R.id.tv_pnradd, "field 'selectFavPnr'", cls3);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(pnrEnquiryFragment));
        pnrEnquiryFragment.favIconImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.tv_favpnricon, "field 'favIconImage'", ImageView.class);
        pnrEnquiryFragment.psgn_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tv_psgn_detail, "field 'psgn_layout'", cls3);
        pnrEnquiryFragment.ticketfare = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ticket_fare, "field 'ticketfare'", cls3);
        pnrEnquiryFragment.total_fare = (TextView) Utils.findRequiredViewAsType(view, R.id.total_fare, "field 'total_fare'", cls);
        pnrEnquiryFragment.remarks_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.remarks_rl, "field 'remarks_rl'", RelativeLayout.class);
        pnrEnquiryFragment.remarks_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.remarks_tv, "field 'remarks_tv'", cls);
        pnrEnquiryFragment.tv_chart_status = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_chart_status, "field 'tv_chart_status'", cls);
        pnrEnquiryFragment.tv_ir_recovers = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ir_recovers, "field 'tv_ir_recovers'", cls);
        pnrEnquiryFragment.journeyTime = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_time, "field 'journeyTime'", cls);
        pnrEnquiryFragment.travelTimeLL = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.travel_time2, "field 'travelTimeLL'", cls3);
        pnrEnquiryFragment.ll_delay_msg = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_delay_msg, "field 'll_delay_msg'", cls3);
        pnrEnquiryFragment.tv_delay_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_delay_msg, "field 'tv_delay_msg'", cls);
        pnrEnquiryFragment.ll_delay_value = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_delay_value, "field 'll_delay_value'", cls3);
        pnrEnquiryFragment.tv_delay_value = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_delay_value, "field 'tv_delay_value'", cls);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_search, "method 'onSearchClick'");
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(pnrEnquiryFragment));
    }

    public final void unbind() {
        PnrEnquiryFragment pnrEnquiryFragment = this.f5046a;
        if (pnrEnquiryFragment != null) {
            this.f5046a = null;
            pnrEnquiryFragment.pnrNumber = null;
            pnrEnquiryFragment.trainNumber = null;
            pnrEnquiryFragment.destArrDate = null;
            pnrEnquiryFragment.destArrTime = null;
            pnrEnquiryFragment.trainName = null;
            pnrEnquiryFragment.fromStation = null;
            pnrEnquiryFragment.toStation = null;
            pnrEnquiryFragment.jrnyDate = null;
            pnrEnquiryFragment.psgnList = null;
            pnrEnquiryFragment.tktDetails = null;
            pnrEnquiryFragment.pnr_view = null;
            pnrEnquiryFragment.pre = null;
            pnrEnquiryFragment.cnfCheckCetails = null;
            pnrEnquiryFragment.cnfBtnLayout = null;
            pnrEnquiryFragment.pnrEquiryTop = null;
            pnrEnquiryFragment.pnrResultTop = null;
            pnrEnquiryFragment.pnrEquiryBottom = null;
            pnrEnquiryFragment.favPnrList = null;
            pnrEnquiryFragment.selectFavPnr = null;
            pnrEnquiryFragment.favIconImage = null;
            pnrEnquiryFragment.psgn_layout = null;
            pnrEnquiryFragment.ticketfare = null;
            pnrEnquiryFragment.total_fare = null;
            pnrEnquiryFragment.remarks_rl = null;
            pnrEnquiryFragment.remarks_tv = null;
            pnrEnquiryFragment.tv_chart_status = null;
            pnrEnquiryFragment.tv_ir_recovers = null;
            pnrEnquiryFragment.journeyTime = null;
            pnrEnquiryFragment.travelTimeLL = null;
            pnrEnquiryFragment.ll_delay_msg = null;
            pnrEnquiryFragment.tv_delay_msg = null;
            pnrEnquiryFragment.ll_delay_value = null;
            pnrEnquiryFragment.tv_delay_value = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
