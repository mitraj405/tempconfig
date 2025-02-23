package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class TdrHistoryFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public TdrHistoryFragment f5153a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TdrHistoryFragment a;

        public a(TdrHistoryFragment tdrHistoryFragment) {
            this.a = tdrHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortSelectClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ TdrHistoryFragment a;

        public b(TdrHistoryFragment tdrHistoryFragment) {
            this.a = tdrHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.departure(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ TdrHistoryFragment a;

        public c(TdrHistoryFragment tdrHistoryFragment) {
            this.a = tdrHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.arrival(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ TdrHistoryFragment a;

        public d(TdrHistoryFragment tdrHistoryFragment) {
            this.a = tdrHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortByClick();
        }
    }

    public TdrHistoryFragment_ViewBinding(TdrHistoryFragment tdrHistoryFragment, View view) {
        this.f5153a = tdrHistoryFragment;
        tdrHistoryFragment.bookingItems = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_tdr_ticket_list, "field 'bookingItems'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll' and method 'sortSelectClick'");
        tdrHistoryFragment.sortby_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll'", RelativeLayout.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(tdrHistoryFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.dept_date, "field 'departure' and method 'departure'");
        Class cls = TextView.class;
        tdrHistoryFragment.departure = (TextView) Utils.castView(findRequiredView2, R.id.dept_date, "field 'departure'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(tdrHistoryFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.booking_date, "field 'booking' and method 'arrival'");
        tdrHistoryFragment.booking = (TextView) Utils.castView(findRequiredView3, R.id.booking_date, "field 'booking'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(tdrHistoryFragment));
        tdrHistoryFragment.sort_by_spinner_text = (TextView) Utils.findRequiredViewAsType(view, R.id.sort_by_spinner_text, "field 'sort_by_spinner_text'", cls);
        Class cls2 = AdManagerAdView.class;
        tdrHistoryFragment.tdrhistory_add_top = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.tdrhistory_add_top, "field 'tdrhistory_add_top'", cls2);
        tdrHistoryFragment.file_tdr_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.file_tdr_bottom, "field 'file_tdr_bottom'", cls2);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.sortby_ll, "method 'sortByClick'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(tdrHistoryFragment));
    }

    public final void unbind() {
        TdrHistoryFragment tdrHistoryFragment = this.f5153a;
        if (tdrHistoryFragment != null) {
            this.f5153a = null;
            tdrHistoryFragment.bookingItems = null;
            tdrHistoryFragment.sortby_bottom_ll = null;
            tdrHistoryFragment.departure = null;
            tdrHistoryFragment.booking = null;
            tdrHistoryFragment.sort_by_spinner_text = null;
            tdrHistoryFragment.tdrhistory_add_top = null;
            tdrHistoryFragment.file_tdr_bottom = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
