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

public class RefundTxnHistoryFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public RefundTxnHistoryFragment f5070a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ RefundTxnHistoryFragment a;

        public a(RefundTxnHistoryFragment refundTxnHistoryFragment) {
            this.a = refundTxnHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortSelectClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ RefundTxnHistoryFragment a;

        public b(RefundTxnHistoryFragment refundTxnHistoryFragment) {
            this.a = refundTxnHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.departure(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ RefundTxnHistoryFragment a;

        public c(RefundTxnHistoryFragment refundTxnHistoryFragment) {
            this.a = refundTxnHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.arrival(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ RefundTxnHistoryFragment a;

        public d(RefundTxnHistoryFragment refundTxnHistoryFragment) {
            this.a = refundTxnHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.sortByClick();
        }
    }

    public RefundTxnHistoryFragment_ViewBinding(RefundTxnHistoryFragment refundTxnHistoryFragment, View view) {
        this.f5070a = refundTxnHistoryFragment;
        refundTxnHistoryFragment.bookingItems = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_booking_items, "field 'bookingItems'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll' and method 'sortSelectClick'");
        refundTxnHistoryFragment.sortby_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll'", RelativeLayout.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(refundTxnHistoryFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.dept_date, "field 'departure' and method 'departure'");
        Class cls = TextView.class;
        refundTxnHistoryFragment.departure = (TextView) Utils.castView(findRequiredView2, R.id.dept_date, "field 'departure'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(refundTxnHistoryFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.booking_date, "field 'booking' and method 'arrival'");
        refundTxnHistoryFragment.booking = (TextView) Utils.castView(findRequiredView3, R.id.booking_date, "field 'booking'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(refundTxnHistoryFragment));
        refundTxnHistoryFragment.sort_by_spinner_text = (TextView) Utils.findRequiredViewAsType(view, R.id.sort_by_spinner_text, "field 'sort_by_spinner_text'", cls);
        Class cls2 = AdManagerAdView.class;
        refundTxnHistoryFragment.refund_history_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.refund_history_bottom, "field 'refund_history_bottom'", cls2);
        refundTxnHistoryFragment.refund_add_top = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.refund_add_top, "field 'refund_add_top'", cls2);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.sortby_ll, "method 'sortByClick'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(refundTxnHistoryFragment));
    }

    public final void unbind() {
        RefundTxnHistoryFragment refundTxnHistoryFragment = this.f5070a;
        if (refundTxnHistoryFragment != null) {
            this.f5070a = null;
            refundTxnHistoryFragment.bookingItems = null;
            refundTxnHistoryFragment.sortby_bottom_ll = null;
            refundTxnHistoryFragment.departure = null;
            refundTxnHistoryFragment.booking = null;
            refundTxnHistoryFragment.sort_by_spinner_text = null;
            refundTxnHistoryFragment.refund_history_bottom = null;
            refundTxnHistoryFragment.refund_add_top = null;
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
