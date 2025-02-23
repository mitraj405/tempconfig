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

public class CancelTktFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public CancelTktFragment f4503a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTktFragment a;

        public a(CancelTktFragment cancelTktFragment) {
            this.a = cancelTktFragment;
        }

        public final void doClick(View view) {
            this.a.sortSelectClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTktFragment a;

        public b(CancelTktFragment cancelTktFragment) {
            this.a = cancelTktFragment;
        }

        public final void doClick(View view) {
            this.a.departure(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTktFragment a;

        public c(CancelTktFragment cancelTktFragment) {
            this.a = cancelTktFragment;
        }

        public final void doClick(View view) {
            this.a.arrival(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTktFragment a;

        public d(CancelTktFragment cancelTktFragment) {
            this.a = cancelTktFragment;
        }

        public final void doClick(View view) {
            this.a.sortByClick();
        }
    }

    public CancelTktFragment_ViewBinding(CancelTktFragment cancelTktFragment, View view) {
        this.f4503a = cancelTktFragment;
        cancelTktFragment.bookingItems = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_booking_items, "field 'bookingItems'", RecyclerView.class);
        Class cls = AdManagerAdView.class;
        cancelTktFragment.cancelTicketBottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.center_ticket_bottom, "field 'cancelTicketBottom'", cls);
        cancelTktFragment.cancel_tkt_top = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.cancel_tkt_top, "field 'cancel_tkt_top'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll' and method 'sortSelectClick'");
        cancelTktFragment.sortby_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll'", RelativeLayout.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(cancelTktFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.dept_date, "field 'departure' and method 'departure'");
        Class cls2 = TextView.class;
        cancelTktFragment.departure = (TextView) Utils.castView(findRequiredView2, R.id.dept_date, "field 'departure'", cls2);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(cancelTktFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.booking_date, "field 'booking' and method 'arrival'");
        cancelTktFragment.booking = (TextView) Utils.castView(findRequiredView3, R.id.booking_date, "field 'booking'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(cancelTktFragment));
        cancelTktFragment.sort_by_spinner_text = (TextView) Utils.findRequiredViewAsType(view, R.id.sort_by_spinner_text, "field 'sort_by_spinner_text'", cls2);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.sortby_ll, "method 'sortByClick'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(cancelTktFragment));
    }

    public final void unbind() {
        CancelTktFragment cancelTktFragment = this.f4503a;
        if (cancelTktFragment != null) {
            this.f4503a = null;
            cancelTktFragment.bookingItems = null;
            cancelTktFragment.cancelTicketBottom = null;
            cancelTktFragment.cancel_tkt_top = null;
            cancelTktFragment.sortby_bottom_ll = null;
            cancelTktFragment.departure = null;
            cancelTktFragment.booking = null;
            cancelTktFragment.sort_by_spinner_text = null;
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
