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
import cris.org.in.prs.ima.R;

public class FailedTxnHistoryFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public FailedTxnHistoryFragment f4636a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ FailedTxnHistoryFragment a;

        public a(FailedTxnHistoryFragment failedTxnHistoryFragment) {
            this.a = failedTxnHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortSelectClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ FailedTxnHistoryFragment a;

        public b(FailedTxnHistoryFragment failedTxnHistoryFragment) {
            this.a = failedTxnHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.departure(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ FailedTxnHistoryFragment a;

        public c(FailedTxnHistoryFragment failedTxnHistoryFragment) {
            this.a = failedTxnHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.arrival(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ FailedTxnHistoryFragment a;

        public d(FailedTxnHistoryFragment failedTxnHistoryFragment) {
            this.a = failedTxnHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortByClick();
        }
    }

    public FailedTxnHistoryFragment_ViewBinding(FailedTxnHistoryFragment failedTxnHistoryFragment, View view) {
        this.f4636a = failedTxnHistoryFragment;
        failedTxnHistoryFragment.bookingItems = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_booking_items, "field 'bookingItems'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll' and method 'sortSelectClick'");
        failedTxnHistoryFragment.sortby_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll'", RelativeLayout.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(failedTxnHistoryFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.dept_date, "field 'departure' and method 'departure'");
        Class cls = TextView.class;
        failedTxnHistoryFragment.departure = (TextView) Utils.castView(findRequiredView2, R.id.dept_date, "field 'departure'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(failedTxnHistoryFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.booking_date, "field 'booking' and method 'arrival'");
        failedTxnHistoryFragment.booking = (TextView) Utils.castView(findRequiredView3, R.id.booking_date, "field 'booking'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(failedTxnHistoryFragment));
        failedTxnHistoryFragment.sort_by_spinner_text = (TextView) Utils.findRequiredViewAsType(view, R.id.sort_by_spinner_text, "field 'sort_by_spinner_text'", cls);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.sortby_ll, "field 'sortLayout' and method 'sortByClick'");
        failedTxnHistoryFragment.sortLayout = (LinearLayout) Utils.castView(findRequiredView4, R.id.sortby_ll, "field 'sortLayout'", LinearLayout.class);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(failedTxnHistoryFragment));
        Class cls2 = AdManagerAdView.class;
        failedTxnHistoryFragment.failed_txn_top = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.failed_txn_top, "field 'failed_txn_top'", cls2);
        failedTxnHistoryFragment.failed_txn_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.failed_txn_bottom, "field 'failed_txn_bottom'", cls2);
    }

    public final void unbind() {
        FailedTxnHistoryFragment failedTxnHistoryFragment = this.f4636a;
        if (failedTxnHistoryFragment != null) {
            this.f4636a = null;
            failedTxnHistoryFragment.bookingItems = null;
            failedTxnHistoryFragment.sortby_bottom_ll = null;
            failedTxnHistoryFragment.departure = null;
            failedTxnHistoryFragment.booking = null;
            failedTxnHistoryFragment.sort_by_spinner_text = null;
            failedTxnHistoryFragment.sortLayout = null;
            failedTxnHistoryFragment.failed_txn_top = null;
            failedTxnHistoryFragment.failed_txn_bottom = null;
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
