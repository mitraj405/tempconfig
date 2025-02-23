package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.CheckBox;
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

public class TDRTicketDetailsFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public TDRTicketDetailsFragment f5138a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketDetailsFragment a;

        public a(TDRTicketDetailsFragment tDRTicketDetailsFragment) {
            this.a = tDRTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.confirmCancelTicket();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketDetailsFragment a;

        public b(TDRTicketDetailsFragment tDRTicketDetailsFragment) {
            this.a = tDRTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.confirmHide();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketDetailsFragment a;

        public c(TDRTicketDetailsFragment tDRTicketDetailsFragment) {
            this.a = tDRTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.tdrResonLayoutHide();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketDetailsFragment a;

        public d(TDRTicketDetailsFragment tDRTicketDetailsFragment) {
            this.a = tDRTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.tdrReasonClick();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketDetailsFragment a;

        public e(TDRTicketDetailsFragment tDRTicketDetailsFragment) {
            this.a = tDRTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.yesConfirm();
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketDetailsFragment a;

        public f(TDRTicketDetailsFragment tDRTicketDetailsFragment) {
            this.a = tDRTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.confirmFileTdrReasonClick();
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketDetailsFragment a;

        public g(TDRTicketDetailsFragment tDRTicketDetailsFragment) {
            this.a = tDRTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.finishedClick();
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketDetailsFragment a;

        public h(TDRTicketDetailsFragment tDRTicketDetailsFragment) {
            this.a = tDRTicketDetailsFragment;
        }

        public final void doClick(View view) {
            this.a.noClick();
        }
    }

    public TDRTicketDetailsFragment_ViewBinding(TDRTicketDetailsFragment tDRTicketDetailsFragment, View view) {
        this.f5138a = tDRTicketDetailsFragment;
        tDRTicketDetailsFragment.passengerList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_passenger_list, "field 'passengerList'", RecyclerView.class);
        Class cls = TextView.class;
        tDRTicketDetailsFragment.pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnr'", cls);
        Class cls2 = LinearLayout.class;
        tDRTicketDetailsFragment.pnrFav = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tv_pnradd, "field 'pnrFav'", cls2);
        tDRTicketDetailsFragment.trainno = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainno'", cls);
        tDRTicketDetailsFragment.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
        tDRTicketDetailsFragment.journeyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'journeyDate'", cls);
        tDRTicketDetailsFragment.journeyTime = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_time, "field 'journeyTime'", cls);
        tDRTicketDetailsFragment.destArrDate = (TextView) Utils.findRequiredViewAsType(view, R.id.dest_arr_date, "field 'destArrDate'", cls);
        tDRTicketDetailsFragment.destArrTime = (TextView) Utils.findRequiredViewAsType(view, R.id.dest_arr_time, "field 'destArrTime'", cls);
        tDRTicketDetailsFragment.selectall = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select_all1, "field 'selectall'", CheckBox.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'confirm' and method 'confirmCancelTicket'");
        tDRTicketDetailsFragment.confirm = (TextView) Utils.castView(findRequiredView, R.id.confirm, "field 'confirm'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(tDRTicketDetailsFragment));
        tDRTicketDetailsFragment.tktDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tkt_details, "field 'tktDetails'", cls);
        tDRTicketDetailsFragment.tocitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'tocitycode'", cls);
        tDRTicketDetailsFragment.fromcitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcidtycode, "field 'fromcitycode'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.confirm_ll, "field 'confirm_ll' and method 'confirmHide'");
        Class cls3 = RelativeLayout.class;
        tDRTicketDetailsFragment.confirm_ll = (RelativeLayout) Utils.castView(findRequiredView2, R.id.confirm_ll, "field 'confirm_ll'", cls3);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(tDRTicketDetailsFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tdr_reason_ll, "field 'tdrReasonLl' and method 'tdrResonLayoutHide'");
        tDRTicketDetailsFragment.tdrReasonLl = (RelativeLayout) Utils.castView(findRequiredView3, R.id.tdr_reason_ll, "field 'tdrReasonLl'", cls3);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(tDRTicketDetailsFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.tdr_reason, "field 'tdrReason' and method 'tdrReasonClick'");
        tDRTicketDetailsFragment.tdrReason = (TextView) Utils.castView(findRequiredView4, R.id.tdr_reason, "field 'tdrReason'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(tDRTicketDetailsFragment));
        tDRTicketDetailsFragment.traveltime = (TextView) Utils.findRequiredViewAsType(view, R.id.travel_time, "field 'traveltime'", cls);
        tDRTicketDetailsFragment.filledLl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.filled_ll, "field 'filledLl'", cls3);
        tDRTicketDetailsFragment.fileTdrSuccessMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.file_tdr_success_msg, "field 'fileTdrSuccessMsg'", cls);
        tDRTicketDetailsFragment.vikalpopt = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_vikalp_opt, "field 'vikalpopt'", cls);
        tDRTicketDetailsFragment.chartstatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_chart_status, "field 'chartstatus'", cls);
        tDRTicketDetailsFragment.bankname = (TextView) Utils.findRequiredViewAsType(view, R.id.bank_name, "field 'bankname'", cls);
        Class cls4 = AdManagerAdView.class;
        tDRTicketDetailsFragment.filetdr_reason_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.file_tdr_reason_bottom, "field 'filetdr_reason_bottom'", cls4);
        tDRTicketDetailsFragment.tdr_confirmation_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.tdr_confirmation_bottom, "field 'tdr_confirmation_bottom'", cls4);
        Class cls5 = EditText.class;
        tDRTicketDetailsFragment.et_eftGCnumber = (EditText) Utils.findRequiredViewAsType(view, R.id.et_eftGCnumber, "field 'et_eftGCnumber'", cls5);
        tDRTicketDetailsFragment.et_gc_amount = (EditText) Utils.findRequiredViewAsType(view, R.id.et_gc_amount, "field 'et_gc_amount'", cls5);
        tDRTicketDetailsFragment.et_gc_date = (EditText) Utils.findRequiredViewAsType(view, R.id.et_gc_date, "field 'et_gc_date'", cls5);
        tDRTicketDetailsFragment.calender_carddob_rl = (ImageView) Utils.findRequiredViewAsType(view, R.id.calender_carddob_rl, "field 'calender_carddob_rl'", ImageView.class);
        tDRTicketDetailsFragment.et_eftdetail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.et_eft_detail_ll, "field 'et_eftdetail_ll'", cls2);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.yes_confirm, "method 'yesConfirm'");
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(tDRTicketDetailsFragment));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.confirm_file_tdr_reason, "method 'confirmFileTdrReasonClick'");
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new f(tDRTicketDetailsFragment));
        View findRequiredView7 = Utils.findRequiredView(view, R.id.finished, "method 'finishedClick'");
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new g(tDRTicketDetailsFragment));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.no, "method 'noClick'");
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new h(tDRTicketDetailsFragment));
    }

    public final void unbind() {
        TDRTicketDetailsFragment tDRTicketDetailsFragment = this.f5138a;
        if (tDRTicketDetailsFragment != null) {
            this.f5138a = null;
            tDRTicketDetailsFragment.passengerList = null;
            tDRTicketDetailsFragment.pnr = null;
            tDRTicketDetailsFragment.pnrFav = null;
            tDRTicketDetailsFragment.trainno = null;
            tDRTicketDetailsFragment.trainName = null;
            tDRTicketDetailsFragment.journeyDate = null;
            tDRTicketDetailsFragment.journeyTime = null;
            tDRTicketDetailsFragment.destArrDate = null;
            tDRTicketDetailsFragment.destArrTime = null;
            tDRTicketDetailsFragment.selectall = null;
            tDRTicketDetailsFragment.confirm = null;
            tDRTicketDetailsFragment.tktDetails = null;
            tDRTicketDetailsFragment.tocitycode = null;
            tDRTicketDetailsFragment.fromcitycode = null;
            tDRTicketDetailsFragment.confirm_ll = null;
            tDRTicketDetailsFragment.tdrReasonLl = null;
            tDRTicketDetailsFragment.tdrReason = null;
            tDRTicketDetailsFragment.traveltime = null;
            tDRTicketDetailsFragment.filledLl = null;
            tDRTicketDetailsFragment.fileTdrSuccessMsg = null;
            tDRTicketDetailsFragment.vikalpopt = null;
            tDRTicketDetailsFragment.chartstatus = null;
            tDRTicketDetailsFragment.bankname = null;
            tDRTicketDetailsFragment.filetdr_reason_bottom = null;
            tDRTicketDetailsFragment.tdr_confirmation_bottom = null;
            tDRTicketDetailsFragment.et_eftGCnumber = null;
            tDRTicketDetailsFragment.et_gc_amount = null;
            tDRTicketDetailsFragment.et_gc_date = null;
            tDRTicketDetailsFragment.calender_carddob_rl = null;
            tDRTicketDetailsFragment.et_eftdetail_ll = null;
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
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
            this.g.setOnClickListener((View.OnClickListener) null);
            this.g = null;
            this.h.setOnClickListener((View.OnClickListener) null);
            this.h = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
