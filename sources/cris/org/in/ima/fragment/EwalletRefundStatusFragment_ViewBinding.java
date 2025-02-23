package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class EwalletRefundStatusFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public EwalletRefundStatusFragment f4614a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletRefundStatusFragment a;

        public a(EwalletRefundStatusFragment ewalletRefundStatusFragment) {
            this.a = ewalletRefundStatusFragment;
        }

        public final void doClick(View view) {
            this.a.onDateFromClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletRefundStatusFragment a;

        public b(EwalletRefundStatusFragment ewalletRefundStatusFragment) {
            this.a = ewalletRefundStatusFragment;
        }

        public final void doClick(View view) {
            this.a.onDateUptoClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletRefundStatusFragment a;

        public c(EwalletRefundStatusFragment ewalletRefundStatusFragment) {
            this.a = ewalletRefundStatusFragment;
        }

        public final void doClick(View view) {
            this.a.onApplyClick();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletRefundStatusFragment a;

        public d(EwalletRefundStatusFragment ewalletRefundStatusFragment) {
            this.a = ewalletRefundStatusFragment;
        }

        public final void doClick(View view) {
            this.a.onResetClick();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletRefundStatusFragment a;

        public e(EwalletRefundStatusFragment ewalletRefundStatusFragment) {
            this.a = ewalletRefundStatusFragment;
        }

        public final void doClick(View view) {
            this.a.onFilterClick();
        }
    }

    public EwalletRefundStatusFragment_ViewBinding(EwalletRefundStatusFragment ewalletRefundStatusFragment, View view) {
        this.f4614a = ewalletRefundStatusFragment;
        ewalletRefundStatusFragment.rs_txn_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rs_tnx_list, "field 'rs_txn_list'", RecyclerView.class);
        Class cls = TextView.class;
        ewalletRefundStatusFragment.rs_empty_list = (TextView) Utils.findRequiredViewAsType(view, R.id.rs_ewalet_empty_list, "field 'rs_empty_list'", cls);
        ewalletRefundStatusFragment.rs_date_from_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.rs_date_from_tv, "field 'rs_date_from_tv'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.rs_date_from_calendar, "field 'rs_date_from_calendar' and method 'onDateFromClick'");
        ewalletRefundStatusFragment.rs_date_from_calendar = (TextView) Utils.castView(findRequiredView, R.id.rs_date_from_calendar, "field 'rs_date_from_calendar'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(ewalletRefundStatusFragment));
        ewalletRefundStatusFragment.rs_date_upto_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.rs_date_upto_tv, "field 'rs_date_upto_tv'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.rs_date_upto_calendar, "field 'rs_date_upto_calendar' and method 'onDateUptoClick'");
        ewalletRefundStatusFragment.rs_date_upto_calendar = (TextView) Utils.castView(findRequiredView2, R.id.rs_date_upto_calendar, "field 'rs_date_upto_calendar'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(ewalletRefundStatusFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.rs_apply_tv, "field 'rs_apply_tv' and method 'onApplyClick'");
        ewalletRefundStatusFragment.rs_apply_tv = (TextView) Utils.castView(findRequiredView3, R.id.rs_apply_tv, "field 'rs_apply_tv'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(ewalletRefundStatusFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.rs_reset_tv, "field 'rs_reset_tv' and method 'onResetClick'");
        ewalletRefundStatusFragment.rs_reset_tv = (TextView) Utils.castView(findRequiredView4, R.id.rs_reset_tv, "field 'rs_reset_tv'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(ewalletRefundStatusFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.rs_filter_rl, "field 'rs_filter_rl' and method 'onFilterClick'");
        ewalletRefundStatusFragment.rs_filter_rl = (RelativeLayout) Utils.castView(findRequiredView5, R.id.rs_filter_rl, "field 'rs_filter_rl'", RelativeLayout.class);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(ewalletRefundStatusFragment));
        ewalletRefundStatusFragment.rs_filter_rl_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.rs_filter_rl_ll, "field 'rs_filter_rl_ll'", LinearLayout.class);
    }

    public final void unbind() {
        EwalletRefundStatusFragment ewalletRefundStatusFragment = this.f4614a;
        if (ewalletRefundStatusFragment != null) {
            this.f4614a = null;
            ewalletRefundStatusFragment.rs_txn_list = null;
            ewalletRefundStatusFragment.rs_empty_list = null;
            ewalletRefundStatusFragment.rs_date_from_tv = null;
            ewalletRefundStatusFragment.rs_date_from_calendar = null;
            ewalletRefundStatusFragment.rs_date_upto_tv = null;
            ewalletRefundStatusFragment.rs_date_upto_calendar = null;
            ewalletRefundStatusFragment.rs_apply_tv = null;
            ewalletRefundStatusFragment.rs_reset_tv = null;
            ewalletRefundStatusFragment.rs_filter_rl = null;
            ewalletRefundStatusFragment.rs_filter_rl_ll = null;
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
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
