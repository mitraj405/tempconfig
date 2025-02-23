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

public class TDRTicketFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public TDRTicketFragment f5144a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketFragment a;

        public a(TDRTicketFragment tDRTicketFragment) {
            this.a = tDRTicketFragment;
        }

        public final void doClick(View view) {
            this.a.sortSelectClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketFragment a;

        public b(TDRTicketFragment tDRTicketFragment) {
            this.a = tDRTicketFragment;
        }

        public final void doClick(View view) {
            this.a.departure(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketFragment a;

        public c(TDRTicketFragment tDRTicketFragment) {
            this.a = tDRTicketFragment;
        }

        public final void doClick(View view) {
            this.a.arrival(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ TDRTicketFragment a;

        public d(TDRTicketFragment tDRTicketFragment) {
            this.a = tDRTicketFragment;
        }

        public final void doClick(View view) {
            this.a.sortByClick();
        }
    }

    public TDRTicketFragment_ViewBinding(TDRTicketFragment tDRTicketFragment, View view) {
        this.f5144a = tDRTicketFragment;
        tDRTicketFragment.tdrTicketList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_tdr_ticket_list, "field 'tdrTicketList'", RecyclerView.class);
        Class cls = AdManagerAdView.class;
        tDRTicketFragment.filetdr = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.file_tdr_bottom, "field 'filetdr'", cls);
        tDRTicketFragment.tdrhistory_add_top = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.tdrhistory_add_top, "field 'tdrhistory_add_top'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll' and method 'sortSelectClick'");
        tDRTicketFragment.sortby_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll'", RelativeLayout.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(tDRTicketFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.dept_date, "field 'departure' and method 'departure'");
        Class cls2 = TextView.class;
        tDRTicketFragment.departure = (TextView) Utils.castView(findRequiredView2, R.id.dept_date, "field 'departure'", cls2);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(tDRTicketFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.booking_date, "field 'booking' and method 'arrival'");
        tDRTicketFragment.booking = (TextView) Utils.castView(findRequiredView3, R.id.booking_date, "field 'booking'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(tDRTicketFragment));
        tDRTicketFragment.sort_by_spinner_text = (TextView) Utils.findRequiredViewAsType(view, R.id.sort_by_spinner_text, "field 'sort_by_spinner_text'", cls2);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.sortby_ll, "method 'sortByClick'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(tDRTicketFragment));
    }

    public final void unbind() {
        TDRTicketFragment tDRTicketFragment = this.f5144a;
        if (tDRTicketFragment != null) {
            this.f5144a = null;
            tDRTicketFragment.tdrTicketList = null;
            tDRTicketFragment.filetdr = null;
            tDRTicketFragment.tdrhistory_add_top = null;
            tDRTicketFragment.sortby_bottom_ll = null;
            tDRTicketFragment.departure = null;
            tDRTicketFragment.booking = null;
            tDRTicketFragment.sort_by_spinner_text = null;
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
