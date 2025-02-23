package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.material.tabs.TabLayout;
import cris.org.in.prs.ima.R;

public class BookingHistoryFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public BookingHistoryFragment f4477a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ BookingHistoryFragment a;

        public a(BookingHistoryFragment bookingHistoryFragment) {
            this.a = bookingHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortSelectClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ BookingHistoryFragment a;

        public b(BookingHistoryFragment bookingHistoryFragment) {
            this.a = bookingHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.departure(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ BookingHistoryFragment a;

        public c(BookingHistoryFragment bookingHistoryFragment) {
            this.a = bookingHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.arrival(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ BookingHistoryFragment a;

        public d(BookingHistoryFragment bookingHistoryFragment) {
            this.a = bookingHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortByClick();
        }
    }

    public BookingHistoryFragment_ViewBinding(BookingHistoryFragment bookingHistoryFragment, View view) {
        this.f4477a = bookingHistoryFragment;
        bookingHistoryFragment.bookingItems = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_booking_items, "field 'bookingItems'", RecyclerView.class);
        bookingHistoryFragment.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tabs, "field 'tabLayout'", TabLayout.class);
        Class cls = TextView.class;
        bookingHistoryFragment.lastUpdatedTime = (TextView) Utils.findRequiredViewAsType(view, R.id.last_updated_time, "field 'lastUpdatedTime'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll' and method 'sortSelectClick'");
        Class cls2 = RelativeLayout.class;
        bookingHistoryFragment.sortby_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll'", cls2);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(bookingHistoryFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.dept_date, "field 'departure' and method 'departure'");
        bookingHistoryFragment.departure = (TextView) Utils.castView(findRequiredView2, R.id.dept_date, "field 'departure'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(bookingHistoryFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.booking_date, "field 'booking' and method 'arrival'");
        bookingHistoryFragment.booking = (TextView) Utils.castView(findRequiredView3, R.id.booking_date, "field 'booking'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(bookingHistoryFragment));
        bookingHistoryFragment.sort_by_spinner_text = (TextView) Utils.findRequiredViewAsType(view, R.id.sort_by_spinner_text, "field 'sort_by_spinner_text'", cls);
        Class cls3 = AdManagerAdView.class;
        bookingHistoryFragment.mybooking_top = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.my_booking_top, "field 'mybooking_top'", cls3);
        bookingHistoryFragment.mybooking_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.my_booking_bottom, "field 'mybooking_bottom'", cls3);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.sortby_ll, "field 'sortLayout' and method 'sortByClick'");
        bookingHistoryFragment.sortLayout = (LinearLayout) Utils.castView(findRequiredView4, R.id.sortby_ll, "field 'sortLayout'", LinearLayout.class);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(bookingHistoryFragment));
        bookingHistoryFragment.sort_by_and_lastUpdate = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.sort_by_and_lastUpdate, "field 'sort_by_and_lastUpdate'", cls2);
    }

    public final void unbind() {
        BookingHistoryFragment bookingHistoryFragment = this.f4477a;
        if (bookingHistoryFragment != null) {
            this.f4477a = null;
            bookingHistoryFragment.bookingItems = null;
            bookingHistoryFragment.tabLayout = null;
            bookingHistoryFragment.lastUpdatedTime = null;
            bookingHistoryFragment.sortby_bottom_ll = null;
            bookingHistoryFragment.departure = null;
            bookingHistoryFragment.booking = null;
            bookingHistoryFragment.sort_by_spinner_text = null;
            bookingHistoryFragment.mybooking_top = null;
            bookingHistoryFragment.mybooking_bottom = null;
            bookingHistoryFragment.sortLayout = null;
            bookingHistoryFragment.sort_by_and_lastUpdate = null;
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
