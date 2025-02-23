package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class DelhiMetroFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public DelhiMetroFragment f4545a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ DelhiMetroFragment a;

        public a(DelhiMetroFragment delhiMetroFragment) {
            this.a = delhiMetroFragment;
        }

        public final void doClick(View view) {
            this.a.onTomorrowClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ DelhiMetroFragment a;

        public b(DelhiMetroFragment delhiMetroFragment) {
            this.a = delhiMetroFragment;
        }

        public final void doClick(View view) {
            this.a.onJourneyDateClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ DelhiMetroFragment a;

        public c(DelhiMetroFragment delhiMetroFragment) {
            this.a = delhiMetroFragment;
        }

        public final void doClick(View view) {
            this.a.onDrmcTrainTimingClickLink();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ DelhiMetroFragment a;

        public d(DelhiMetroFragment delhiMetroFragment) {
            this.a = delhiMetroFragment;
        }

        public final void doClick(View view) {
            this.a.onDmrcSearchClick();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ DelhiMetroFragment a;

        public e(DelhiMetroFragment delhiMetroFragment) {
            this.a = delhiMetroFragment;
        }

        public final void doClick(View view) {
            this.a.onDmrcIncrementtClick();
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ DelhiMetroFragment a;

        public f(DelhiMetroFragment delhiMetroFragment) {
            this.a = delhiMetroFragment;
        }

        public final void doClick(View view) {
            this.a.onDmrcDecrementClick();
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ DelhiMetroFragment a;

        public g(DelhiMetroFragment delhiMetroFragment) {
            this.a = delhiMetroFragment;
        }

        public final void doClick(View view) {
            this.a.onFromStationClick();
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ DelhiMetroFragment a;

        public h(DelhiMetroFragment delhiMetroFragment) {
            this.a = delhiMetroFragment;
        }

        public final void doClick(View view) {
            this.a.onToStationClick();
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ DelhiMetroFragment a;

        public i(DelhiMetroFragment delhiMetroFragment) {
            this.a = delhiMetroFragment;
        }

        public final void doClick(View view) {
            this.a.onDrmcTrainRouteMapClickLink();
        }
    }

    public DelhiMetroFragment_ViewBinding(DelhiMetroFragment delhiMetroFragment, View view) {
        this.f4545a = delhiMetroFragment;
        Class cls = ImageView.class;
        delhiMetroFragment.dmrccalender = (ImageView) Utils.findRequiredViewAsType(view, R.id.delhi_metro_cal, "field 'dmrccalender'", cls);
        Class cls2 = TextView.class;
        delhiMetroFragment.dmrcjourneydate = (TextView) Utils.findRequiredViewAsType(view, R.id.delhi_metro_journey_date, "field 'dmrcjourneydate'", cls2);
        delhiMetroFragment.dmrcjourneydatelabel = (TextView) Utils.findRequiredViewAsType(view, R.id.delhi_metro_journey_date_label, "field 'dmrcjourneydatelabel'", cls2);
        View findRequiredView = Utils.findRequiredView(view, R.id.dmrc_tomorrow_ll, "field 'dmrctomorrow_ll' and method 'onTomorrowClick'");
        Class cls3 = LinearLayout.class;
        delhiMetroFragment.dmrctomorrow_ll = (LinearLayout) Utils.castView(findRequiredView, R.id.dmrc_tomorrow_ll, "field 'dmrctomorrow_ll'", cls3);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(delhiMetroFragment));
        delhiMetroFragment.dmrctomorrowDate = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrctomorrow_date, "field 'dmrctomorrowDate'", cls2);
        delhiMetroFragment.dmrctomorrowlabel = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrctomorrow_label, "field 'dmrctomorrowlabel'", cls2);
        View findRequiredView2 = Utils.findRequiredView(view, R.id._dmrc_select_journey_date, "field 'dmrcSelectJourneyDate' and method 'onJourneyDateClick'");
        delhiMetroFragment.dmrcSelectJourneyDate = (LinearLayout) Utils.castView(findRequiredView2, R.id._dmrc_select_journey_date, "field 'dmrcSelectJourneyDate'", cls3);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(delhiMetroFragment));
        delhiMetroFragment.stnrotation = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.dmrc_stn_rotation, "field 'stnrotation'", cls3);
        delhiMetroFragment.dmrcfromStnName = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_fromStn, "field 'dmrcfromStnName'", cls2);
        delhiMetroFragment.dmrctoStnName = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_toStn, "field 'dmrctoStnName'", cls2);
        delhiMetroFragment.dmrcToStnLine = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_toStn_line, "field 'dmrcToStnLine'", cls2);
        delhiMetroFragment.dmrcFromStnLine = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_fromStn_line, "field 'dmrcFromStnLine'", cls2);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.dmrc_train_timing_link, "field 'dmrcTrainTiminglink' and method 'onDrmcTrainTimingClickLink'");
        delhiMetroFragment.dmrcTrainTiminglink = (TextView) Utils.castView(findRequiredView3, R.id.dmrc_train_timing_link, "field 'dmrcTrainTiminglink'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(delhiMetroFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.tv_dmrc_search, "field 'dmrcsearch' and method 'onDmrcSearchClick'");
        delhiMetroFragment.dmrcsearch = (TextView) Utils.castView(findRequiredView4, R.id.tv_dmrc_search, "field 'dmrcsearch'", cls2);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(delhiMetroFragment));
        delhiMetroFragment.noOfPassenger = (TextView) Utils.findRequiredViewAsType(view, R.id.no_of_passenger, "field 'noOfPassenger'", cls2);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.iv_dmrc_plus, "field 'dmrcPlusIcon' and method 'onDmrcIncrementtClick'");
        delhiMetroFragment.dmrcPlusIcon = (ImageView) Utils.castView(findRequiredView5, R.id.iv_dmrc_plus, "field 'dmrcPlusIcon'", cls);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(delhiMetroFragment));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.iv_dmrc_min, "field 'dmrcminIcon' and method 'onDmrcDecrementClick'");
        delhiMetroFragment.dmrcminIcon = (ImageView) Utils.castView(findRequiredView6, R.id.iv_dmrc_min, "field 'dmrcminIcon'", cls);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new f(delhiMetroFragment));
        delhiMetroFragment.linkedPnrNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.linked_pnr_number, "field 'linkedPnrNumber'", cls2);
        View findRequiredView7 = Utils.findRequiredView(view, R.id.ll_from_station_delhi_metro, "method 'onFromStationClick'");
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new g(delhiMetroFragment));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.ll_to_station_layout_dmrc, "method 'onToStationClick'");
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new h(delhiMetroFragment));
        View findRequiredView9 = Utils.findRequiredView(view, R.id.dmrc_train_rout_link, "method 'onDrmcTrainRouteMapClickLink'");
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new i(delhiMetroFragment));
    }

    public final void unbind() {
        DelhiMetroFragment delhiMetroFragment = this.f4545a;
        if (delhiMetroFragment != null) {
            this.f4545a = null;
            delhiMetroFragment.dmrccalender = null;
            delhiMetroFragment.dmrcjourneydate = null;
            delhiMetroFragment.dmrcjourneydatelabel = null;
            delhiMetroFragment.dmrctomorrow_ll = null;
            delhiMetroFragment.dmrctomorrowDate = null;
            delhiMetroFragment.dmrctomorrowlabel = null;
            delhiMetroFragment.dmrcSelectJourneyDate = null;
            delhiMetroFragment.stnrotation = null;
            delhiMetroFragment.dmrcfromStnName = null;
            delhiMetroFragment.dmrctoStnName = null;
            delhiMetroFragment.dmrcToStnLine = null;
            delhiMetroFragment.dmrcFromStnLine = null;
            delhiMetroFragment.dmrcTrainTiminglink = null;
            delhiMetroFragment.dmrcsearch = null;
            delhiMetroFragment.noOfPassenger = null;
            delhiMetroFragment.dmrcPlusIcon = null;
            delhiMetroFragment.dmrcminIcon = null;
            delhiMetroFragment.linkedPnrNumber = null;
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
            this.i.setOnClickListener((View.OnClickListener) null);
            this.i = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
