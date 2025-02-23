package cris.org.in.ima.fragment;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class TrainDashboardFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public TrainDashboardFragment f5175a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TrainDashboardFragment a;

        public a(TrainDashboardFragment trainDashboardFragment) {
            this.a = trainDashboardFragment;
        }

        public final void doClick(View view) {
            this.a.specialtrainListClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ TrainDashboardFragment a;

        public b(TrainDashboardFragment trainDashboardFragment) {
            this.a = trainDashboardFragment;
        }

        public final void doClick(View view) {
            this.a.onClickTransationView(view);
        }
    }

    public TrainDashboardFragment_ViewBinding(TrainDashboardFragment trainDashboardFragment, View view) {
        this.f5175a = trainDashboardFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.specialtrain_list_rl, "field 'specialtrain_list_rl' and method 'specialtrainListClick'");
        Class cls = RelativeLayout.class;
        trainDashboardFragment.specialtrain_list_rl = (RelativeLayout) Utils.castView(findRequiredView, R.id.specialtrain_list_rl, "field 'specialtrain_list_rl'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(trainDashboardFragment));
        Class cls2 = RecyclerView.class;
        trainDashboardFragment.rv_specialtrainlist = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_specialtrainlist, "field 'rv_specialtrainlist'", cls2);
        trainDashboardFragment.rv_infomation = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_information, "field 'rv_infomation'", cls2);
        Class cls3 = TextView.class;
        trainDashboardFragment.informationHeading = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_information_heading, "field 'informationHeading'", cls3);
        trainDashboardFragment.information_view = Utils.findRequiredView(view, R.id.rv_information_view, "field 'information_view'");
        Class cls4 = LinearLayout.class;
        trainDashboardFragment.ll_tab_dashboard = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tab_dashboard, "field 'll_tab_dashboard'", cls4);
        trainDashboardFragment.ll_tab_upcoming_journey = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tab_upcoming_journey, "field 'll_tab_upcoming_journey'", cls4);
        trainDashboardFragment.ll_tab_last_txn = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tab_last_txn, "field 'll_tab_last_txn'", cls4);
        trainDashboardFragment.rv_tab_upcoming_journey_items = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_tab_upcoming_journey_items, "field 'rv_tab_upcoming_journey_items'", cls2);
        trainDashboardFragment.tv_no_upcomingjourney = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_no_upcomingjourney, "field 'tv_no_upcomingjourney'", cls3);
        trainDashboardFragment.ll_tab_lasttxn_txnid = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tab_lasttxn_txnid, "field 'll_tab_lasttxn_txnid'", cls4);
        trainDashboardFragment.ll_tab_lasttxn_status = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tab_lasttxn_status, "field 'll_tab_lasttxn_status'", cls4);
        trainDashboardFragment.ll_tab_lasttxn_date = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tab_lasttxn_date, "field 'll_tab_lasttxn_date'", cls4);
        trainDashboardFragment.ll_tab_lasttxn_bookingdate = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tab_lasttxn_bookingdate, "field 'll_tab_lasttxn_bookingdate'", cls4);
        trainDashboardFragment.ll_tab_lasttxn_from = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tab_lasttxn_from, "field 'll_tab_lasttxn_from'", cls4);
        trainDashboardFragment.ll_tab_lasttxn_to = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tab_lasttxn_to, "field 'll_tab_lasttxn_to'", cls4);
        trainDashboardFragment.tv_tab_lasttxn_view_details = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_lasttxn_view_details, "field 'tv_tab_lasttxn_view_details'", cls3);
        trainDashboardFragment.ll_tab_lasttxn_pnr = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tab_lasttxn_pnr, "field 'll_tab_lasttxn_pnr'", cls4);
        trainDashboardFragment.tv_tab_lasttxn_pnr_value = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_lasttxn_pnr_value, "field 'tv_tab_lasttxn_pnr_value'", cls3);
        trainDashboardFragment.ll_nolast_txn = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_nolast_txn, "field 'll_nolast_txn'", cls4);
        trainDashboardFragment.rv_lasttxn = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_lasttxn, "field 'rv_lasttxn'", cls2);
        trainDashboardFragment.attention_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.attention_msg, "field 'attention_msg'", cls3);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.last_transation_detail_ll, "field 'lastTransationDtail' and method 'onClickTransationView'");
        trainDashboardFragment.lastTransationDtail = (RelativeLayout) Utils.castView(findRequiredView2, R.id.last_transation_detail_ll, "field 'lastTransationDtail'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(trainDashboardFragment));
        trainDashboardFragment.last_txn_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.last_txn_layout, "field 'last_txn_layout'", cls4);
        trainDashboardFragment.last_txn_ll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.last_txn_ll, "field 'last_txn_ll'", cls);
        trainDashboardFragment.transationNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_transation_number, "field 'transationNumber'", cls3);
        trainDashboardFragment.bkgStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bkg_status, "field 'bkgStatus'", cls3);
        trainDashboardFragment.lastTransationTimeStamp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timestamp, "field 'lastTransationTimeStamp'", cls3);
        trainDashboardFragment.trainDashboardAds = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.train_dashboard_ads, "field 'trainDashboardAds'", AdManagerAdView.class);
        trainDashboardFragment.train_dashboard_image_layout_rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.train_dashboard_image_layout_rv, "field 'train_dashboard_image_layout_rv'", cls2);
        trainDashboardFragment.webView = (WebView) Utils.findRequiredViewAsType(view, R.id.webView, "field 'webView'", WebView.class);
        trainDashboardFragment.webView_ll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.webView_ll, "field 'webView_ll'", cls);
    }

    public final void unbind() {
        TrainDashboardFragment trainDashboardFragment = this.f5175a;
        if (trainDashboardFragment != null) {
            this.f5175a = null;
            trainDashboardFragment.specialtrain_list_rl = null;
            trainDashboardFragment.rv_specialtrainlist = null;
            trainDashboardFragment.rv_infomation = null;
            trainDashboardFragment.informationHeading = null;
            trainDashboardFragment.information_view = null;
            trainDashboardFragment.ll_tab_dashboard = null;
            trainDashboardFragment.ll_tab_upcoming_journey = null;
            trainDashboardFragment.ll_tab_last_txn = null;
            trainDashboardFragment.rv_tab_upcoming_journey_items = null;
            trainDashboardFragment.tv_no_upcomingjourney = null;
            trainDashboardFragment.ll_tab_lasttxn_txnid = null;
            trainDashboardFragment.ll_tab_lasttxn_status = null;
            trainDashboardFragment.ll_tab_lasttxn_date = null;
            trainDashboardFragment.ll_tab_lasttxn_bookingdate = null;
            trainDashboardFragment.ll_tab_lasttxn_from = null;
            trainDashboardFragment.ll_tab_lasttxn_to = null;
            trainDashboardFragment.tv_tab_lasttxn_view_details = null;
            trainDashboardFragment.ll_tab_lasttxn_pnr = null;
            trainDashboardFragment.tv_tab_lasttxn_pnr_value = null;
            trainDashboardFragment.ll_nolast_txn = null;
            trainDashboardFragment.rv_lasttxn = null;
            trainDashboardFragment.attention_msg = null;
            trainDashboardFragment.lastTransationDtail = null;
            trainDashboardFragment.last_txn_layout = null;
            trainDashboardFragment.last_txn_ll = null;
            trainDashboardFragment.transationNumber = null;
            trainDashboardFragment.bkgStatus = null;
            trainDashboardFragment.lastTransationTimeStamp = null;
            trainDashboardFragment.trainDashboardAds = null;
            trainDashboardFragment.train_dashboard_image_layout_rv = null;
            trainDashboardFragment.webView = null;
            trainDashboardFragment.webView_ll = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
