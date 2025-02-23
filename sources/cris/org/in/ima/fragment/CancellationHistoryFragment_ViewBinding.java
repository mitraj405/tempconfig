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

public class CancellationHistoryFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public CancellationHistoryFragment f4511a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ CancellationHistoryFragment a;

        public a(CancellationHistoryFragment cancellationHistoryFragment) {
            this.a = cancellationHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortSelectClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ CancellationHistoryFragment a;

        public b(CancellationHistoryFragment cancellationHistoryFragment) {
            this.a = cancellationHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.departure(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ CancellationHistoryFragment a;

        public c(CancellationHistoryFragment cancellationHistoryFragment) {
            this.a = cancellationHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.arrival(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ CancellationHistoryFragment a;

        public d(CancellationHistoryFragment cancellationHistoryFragment) {
            this.a = cancellationHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortByClick();
        }
    }

    public CancellationHistoryFragment_ViewBinding(CancellationHistoryFragment cancellationHistoryFragment, View view) {
        this.f4511a = cancellationHistoryFragment;
        cancellationHistoryFragment.bookingItems = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_booking_items, "field 'bookingItems'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll' and method 'sortSelectClick'");
        cancellationHistoryFragment.sortby_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll'", RelativeLayout.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(cancellationHistoryFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.dept_date, "field 'departure' and method 'departure'");
        Class cls = TextView.class;
        cancellationHistoryFragment.departure = (TextView) Utils.castView(findRequiredView2, R.id.dept_date, "field 'departure'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(cancellationHistoryFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.booking_date, "field 'booking' and method 'arrival'");
        cancellationHistoryFragment.booking = (TextView) Utils.castView(findRequiredView3, R.id.booking_date, "field 'booking'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(cancellationHistoryFragment));
        cancellationHistoryFragment.sort_by_spinner_text = (TextView) Utils.findRequiredViewAsType(view, R.id.sort_by_spinner_text, "field 'sort_by_spinner_text'", cls);
        Class cls2 = AdManagerAdView.class;
        cancellationHistoryFragment.cancelTicketTopAd = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.cancel_ticket_top_ad, "field 'cancelTicketTopAd'", cls2);
        cancellationHistoryFragment.cancelTicketBotAd = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.cancel_ticket_bot_ad, "field 'cancelTicketBotAd'", cls2);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.sortby_ll, "method 'sortByClick'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(cancellationHistoryFragment));
    }

    public final void unbind() {
        CancellationHistoryFragment cancellationHistoryFragment = this.f4511a;
        if (cancellationHistoryFragment != null) {
            this.f4511a = null;
            cancellationHistoryFragment.bookingItems = null;
            cancellationHistoryFragment.sortby_bottom_ll = null;
            cancellationHistoryFragment.departure = null;
            cancellationHistoryFragment.booking = null;
            cancellationHistoryFragment.sort_by_spinner_text = null;
            cancellationHistoryFragment.cancelTicketTopAd = null;
            cancellationHistoryFragment.cancelTicketBotAd = null;
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
