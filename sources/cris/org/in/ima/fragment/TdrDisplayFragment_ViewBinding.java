package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class TdrDisplayFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public TdrDisplayFragment f5147a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TdrDisplayFragment a;

        public a(TdrDisplayFragment tdrDisplayFragment) {
            this.a = tdrDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.refundstatuswithzonalrailwayClick();
        }
    }

    public TdrDisplayFragment_ViewBinding(TdrDisplayFragment tdrDisplayFragment, View view) {
        this.f5147a = tdrDisplayFragment;
        Class cls = TextView.class;
        tdrDisplayFragment.trainNo = (TextView) Utils.findOptionalViewAsType(view, R.id.train_no, "field 'trainNo'", cls);
        tdrDisplayFragment.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
        tdrDisplayFragment.fromStation = (TextView) Utils.findOptionalViewAsType(view, R.id.from_station, "field 'fromStation'", cls);
        tdrDisplayFragment.toStation = (TextView) Utils.findOptionalViewAsType(view, R.id.to_station, "field 'toStation'", cls);
        tdrDisplayFragment.deptDate = (TextView) Utils.findOptionalViewAsType(view, R.id.dept_date, "field 'deptDate'", cls);
        tdrDisplayFragment.arvDate = (TextView) Utils.findOptionalViewAsType(view, R.id.arv_date, "field 'arvDate'", cls);
        tdrDisplayFragment.deptTime = (TextView) Utils.findRequiredViewAsType(view, R.id.dept_time, "field 'deptTime'", cls);
        tdrDisplayFragment.arvTime = (TextView) Utils.findOptionalViewAsType(view, R.id.arv_time, "field 'arvTime'", cls);
        tdrDisplayFragment.travelTime = (TextView) Utils.findOptionalViewAsType(view, R.id.travel_time, "field 'travelTime'", cls);
        tdrDisplayFragment.clsQtBoarding = (TextView) Utils.findOptionalViewAsType(view, R.id.cls_qt_stn, "field 'clsQtBoarding'", cls);
        tdrDisplayFragment.pnr = (TextView) Utils.findOptionalViewAsType(view, R.id.pnr, "field 'pnr'", cls);
        tdrDisplayFragment.totalFare = (TextView) Utils.findOptionalViewAsType(view, R.id.total_fare, "field 'totalFare'", cls);
        tdrDisplayFragment.psgnList = (RecyclerView) Utils.findOptionalViewAsType(view, R.id.psgnList, "field 'psgnList'", RecyclerView.class);
        tdrDisplayFragment.tdrReason = (TextView) Utils.findOptionalViewAsType(view, R.id.tdr_reason, "field 'tdrReason'", cls);
        tdrDisplayFragment.tdrStatus = (TextView) Utils.findOptionalViewAsType(view, R.id.tdr_status, "field 'tdrStatus'", cls);
        tdrDisplayFragment.tdrFiledDate = (TextView) Utils.findOptionalViewAsType(view, R.id.tdr_filed_date, "field 'tdrFiledDate'", cls);
        tdrDisplayFragment.tdrRepDate = (TextView) Utils.findOptionalViewAsType(view, R.id.tdr_rep_date, "field 'tdrRepDate'", cls);
        tdrDisplayFragment.tdrZone = (TextView) Utils.findOptionalViewAsType(view, R.id.tdr_zone, "field 'tdrZone'", cls);
        tdrDisplayFragment.tdr_txnid = (TextView) Utils.findRequiredViewAsType(view, R.id.tdr_txnid, "field 'tdr_txnid'", cls);
        tdrDisplayFragment.scrollView = (ScrollView) Utils.findOptionalViewAsType(view, R.id.tkt, "field 'scrollView'", ScrollView.class);
        tdrDisplayFragment.menu = (ImageView) Utils.findOptionalViewAsType(view, R.id.menu, "field 'menu'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.refund_status_with_zonalrailway, "field 'refundStatusWithZonalRailway' and method 'refundstatuswithzonalrailwayClick'");
        tdrDisplayFragment.refundStatusWithZonalRailway = (TextView) Utils.castView(findRequiredView, R.id.refund_status_with_zonalrailway, "field 'refundStatusWithZonalRailway'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(tdrDisplayFragment));
        tdrDisplayFragment.tdr_repo_date_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tdr_repo_date_ll, "field 'tdr_repo_date_ll'", LinearLayout.class);
        tdrDisplayFragment.tdr_details_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.tdr_details_bottom, "field 'tdr_details_bottom'", AdManagerAdView.class);
    }

    public final void unbind() {
        TdrDisplayFragment tdrDisplayFragment = this.f5147a;
        if (tdrDisplayFragment != null) {
            this.f5147a = null;
            tdrDisplayFragment.trainNo = null;
            tdrDisplayFragment.trainName = null;
            tdrDisplayFragment.fromStation = null;
            tdrDisplayFragment.toStation = null;
            tdrDisplayFragment.deptDate = null;
            tdrDisplayFragment.arvDate = null;
            tdrDisplayFragment.deptTime = null;
            tdrDisplayFragment.arvTime = null;
            tdrDisplayFragment.travelTime = null;
            tdrDisplayFragment.clsQtBoarding = null;
            tdrDisplayFragment.pnr = null;
            tdrDisplayFragment.totalFare = null;
            tdrDisplayFragment.psgnList = null;
            tdrDisplayFragment.tdrReason = null;
            tdrDisplayFragment.tdrStatus = null;
            tdrDisplayFragment.tdrFiledDate = null;
            tdrDisplayFragment.tdrRepDate = null;
            tdrDisplayFragment.tdrZone = null;
            tdrDisplayFragment.tdr_txnid = null;
            tdrDisplayFragment.scrollView = null;
            tdrDisplayFragment.menu = null;
            tdrDisplayFragment.refundStatusWithZonalRailway = null;
            tdrDisplayFragment.tdr_repo_date_ll = null;
            tdrDisplayFragment.tdr_details_bottom = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
