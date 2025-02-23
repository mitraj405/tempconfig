package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class CancelTicketHistoryFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public CancelTicketHistoryFragment f4497a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTicketHistoryFragment a;

        public a(CancelTicketHistoryFragment cancelTicketHistoryFragment) {
            this.a = cancelTicketHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortSelectClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTicketHistoryFragment a;

        public b(CancelTicketHistoryFragment cancelTicketHistoryFragment) {
            this.a = cancelTicketHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.departure(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTicketHistoryFragment a;

        public c(CancelTicketHistoryFragment cancelTicketHistoryFragment) {
            this.a = cancelTicketHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.arrival(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ CancelTicketHistoryFragment a;

        public d(CancelTicketHistoryFragment cancelTicketHistoryFragment) {
            this.a = cancelTicketHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortByClick();
        }
    }

    public CancelTicketHistoryFragment_ViewBinding(CancelTicketHistoryFragment cancelTicketHistoryFragment, View view) {
        this.f4497a = cancelTicketHistoryFragment;
        cancelTicketHistoryFragment.bookingItems = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_booking_items, "field 'bookingItems'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll' and method 'sortSelectClick'");
        cancelTicketHistoryFragment.sortby_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll'", RelativeLayout.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(cancelTicketHistoryFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.dept_date, "field 'departure' and method 'departure'");
        Class cls = TextView.class;
        cancelTicketHistoryFragment.departure = (TextView) Utils.castView(findRequiredView2, R.id.dept_date, "field 'departure'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(cancelTicketHistoryFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.booking_date, "field 'booking' and method 'arrival'");
        cancelTicketHistoryFragment.booking = (TextView) Utils.castView(findRequiredView3, R.id.booking_date, "field 'booking'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(cancelTicketHistoryFragment));
        cancelTicketHistoryFragment.sort_by_spinner_text = (TextView) Utils.findRequiredViewAsType(view, R.id.sort_by_spinner_text, "field 'sort_by_spinner_text'", cls);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.sortby_ll, "method 'sortByClick'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(cancelTicketHistoryFragment));
    }

    public final void unbind() {
        CancelTicketHistoryFragment cancelTicketHistoryFragment = this.f4497a;
        if (cancelTicketHistoryFragment != null) {
            this.f4497a = null;
            cancelTicketHistoryFragment.bookingItems = null;
            cancelTicketHistoryFragment.sortby_bottom_ll = null;
            cancelTicketHistoryFragment.departure = null;
            cancelTicketHistoryFragment.booking = null;
            cancelTicketHistoryFragment.sort_by_spinner_text = null;
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
