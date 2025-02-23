package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.material.tabs.TabLayout;
import cris.org.in.prs.ima.R;

public class MyBookingFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public MyBookingFragment f4840a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MyBookingFragment a;

        public a(MyBookingFragment myBookingFragment) {
            this.a = myBookingFragment;
        }

        public final void doClick(View view) {
            this.a.sortBottomllClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MyBookingFragment a;

        public b(MyBookingFragment myBookingFragment) {
            this.a = myBookingFragment;
        }

        public final void doClick(View view) {
            this.a.departure(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ MyBookingFragment a;

        public c(MyBookingFragment myBookingFragment) {
            this.a = myBookingFragment;
        }

        public final void doClick(View view) {
            this.a.arrival(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ MyBookingFragment a;

        public d(MyBookingFragment myBookingFragment) {
            this.a = myBookingFragment;
        }

        public final void doClick(View view) {
            this.a.sortByClick();
        }
    }

    public MyBookingFragment_ViewBinding(MyBookingFragment myBookingFragment, View view) {
        this.f4840a = myBookingFragment;
        myBookingFragment.bookingItems = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_booking_items, "field 'bookingItems'", RecyclerView.class);
        myBookingFragment.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tabs, "field 'tabLayout'", TabLayout.class);
        Class cls = TextView.class;
        myBookingFragment.lastUpdatedTime = (TextView) Utils.findRequiredViewAsType(view, R.id.last_updated_time, "field 'lastUpdatedTime'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll' and method 'sortBottomllClick'");
        myBookingFragment.sortby_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll'", RelativeLayout.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(myBookingFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.dept_date, "field 'departure' and method 'departure'");
        myBookingFragment.departure = (TextView) Utils.castView(findRequiredView2, R.id.dept_date, "field 'departure'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(myBookingFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.booking_date, "field 'booking' and method 'arrival'");
        myBookingFragment.booking = (TextView) Utils.castView(findRequiredView3, R.id.booking_date, "field 'booking'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(myBookingFragment));
        myBookingFragment.sort_by_spinner_text = (TextView) Utils.findRequiredViewAsType(view, R.id.sort_by_spinner_text, "field 'sort_by_spinner_text'", cls);
        Class cls2 = AdManagerAdView.class;
        myBookingFragment.my_booking_top = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.my_booking_top, "field 'my_booking_top'", cls2);
        myBookingFragment.my_booking_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.my_booking_bottom, "field 'my_booking_bottom'", cls2);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.sortby_ll, "method 'sortByClick'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(myBookingFragment));
    }

    public final void unbind() {
        MyBookingFragment myBookingFragment = this.f4840a;
        if (myBookingFragment != null) {
            this.f4840a = null;
            myBookingFragment.bookingItems = null;
            myBookingFragment.tabLayout = null;
            myBookingFragment.lastUpdatedTime = null;
            myBookingFragment.sortby_bottom_ll = null;
            myBookingFragment.departure = null;
            myBookingFragment.booking = null;
            myBookingFragment.sort_by_spinner_text = null;
            myBookingFragment.my_booking_top = null;
            myBookingFragment.my_booking_bottom = null;
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
