package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class EwalletStatementFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public EwalletStatementFragment f4625a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletStatementFragment a;

        public a(EwalletStatementFragment ewalletStatementFragment) {
            this.a = ewalletStatementFragment;
        }

        public final void doClick(View view) {
            this.a.onDateFromClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletStatementFragment a;

        public b(EwalletStatementFragment ewalletStatementFragment) {
            this.a = ewalletStatementFragment;
        }

        public final void doClick(View view) {
            this.a.onDateUptoClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletStatementFragment a;

        public c(EwalletStatementFragment ewalletStatementFragment) {
            this.a = ewalletStatementFragment;
        }

        public final void doClick(View view) {
            this.a.onApplyClick();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletStatementFragment a;

        public d(EwalletStatementFragment ewalletStatementFragment) {
            this.a = ewalletStatementFragment;
        }

        public final void doClick(View view) {
            this.a.onResetClick();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletStatementFragment a;

        public e(EwalletStatementFragment ewalletStatementFragment) {
            this.a = ewalletStatementFragment;
        }

        public final void doClick(View view) {
            this.a.onFilterClick();
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ EwalletStatementFragment a;

        public f(EwalletStatementFragment ewalletStatementFragment) {
            this.a = ewalletStatementFragment;
        }

        public final void doClick(View view) {
            this.a.onSaveAccStmtClick();
        }
    }

    public EwalletStatementFragment_ViewBinding(EwalletStatementFragment ewalletStatementFragment, View view) {
        this.f4625a = ewalletStatementFragment;
        Class cls = TextView.class;
        ewalletStatementFragment.as_user_id_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.as_user_id_tv, "field 'as_user_id_tv'", cls);
        ewalletStatementFragment.as_account_status = (TextView) Utils.findRequiredViewAsType(view, R.id.as_account_status, "field 'as_account_status'", cls);
        ewalletStatementFragment.as_closing_balance = (TextView) Utils.findRequiredViewAsType(view, R.id.as_closing_balance, "field 'as_closing_balance'", cls);
        ewalletStatementFragment.as_reg_date = (TextView) Utils.findRequiredViewAsType(view, R.id.as_regd_date, "field 'as_reg_date'", cls);
        ewalletStatementFragment.as_transaction_id = (TextView) Utils.findRequiredViewAsType(view, R.id.as_transaction_id, "field 'as_transaction_id'", cls);
        ewalletStatementFragment.as_total_amount = (TextView) Utils.findRequiredViewAsType(view, R.id.as_total_amount, "field 'as_total_amount'", cls);
        ewalletStatementFragment.as_txn_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.as_tnx_list, "field 'as_txn_list'", RecyclerView.class);
        ewalletStatementFragment.as_ewallet_empty_list = (TextView) Utils.findRequiredViewAsType(view, R.id.as_ewallet_empty_list, "field 'as_ewallet_empty_list'", cls);
        Class cls2 = AdManagerAdView.class;
        ewalletStatementFragment.ewalet_acc_statment_top = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.ewalet_acc_statment_top, "field 'ewalet_acc_statment_top'", cls2);
        ewalletStatementFragment.ewalet_acc_statment_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.ewalet_acc_statment_bottom, "field 'ewalet_acc_statment_bottom'", cls2);
        ewalletStatementFragment.as_user_name_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.as_user_name_tv, "field 'as_user_name_tv'", cls);
        ewalletStatementFragment.as_amount = (TextView) Utils.findRequiredViewAsType(view, R.id.as_amount, "field 'as_amount'", cls);
        ewalletStatementFragment.as_total_gst = (TextView) Utils.findRequiredViewAsType(view, R.id.as_total_gst, "field 'as_total_gst'", cls);
        ewalletStatementFragment.as_cgst = (TextView) Utils.findRequiredViewAsType(view, R.id.as_cgst, "field 'as_cgst'", cls);
        ewalletStatementFragment.as_ugst = (TextView) Utils.findRequiredViewAsType(view, R.id.as_ugst, "field 'as_ugst'", cls);
        ewalletStatementFragment.as_igst = (TextView) Utils.findRequiredViewAsType(view, R.id.as_igst, "field 'as_igst'", cls);
        ewalletStatementFragment.as_sgst = (TextView) Utils.findRequiredViewAsType(view, R.id.as_sgst, "field 'as_sgst'", cls);
        ewalletStatementFragment.as_date_from_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.as_date_from_tv, "field 'as_date_from_tv'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.as_date_from_calendar, "field 'as_date_from_calendar' and method 'onDateFromClick'");
        ewalletStatementFragment.as_date_from_calendar = (TextView) Utils.castView(findRequiredView, R.id.as_date_from_calendar, "field 'as_date_from_calendar'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(ewalletStatementFragment));
        ewalletStatementFragment.as_date_upto_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.as_date_upto_tv, "field 'as_date_upto_tv'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.as_date_upto_calendar, "field 'as_date_upto_calendar' and method 'onDateUptoClick'");
        ewalletStatementFragment.as_date_upto_calendar = (TextView) Utils.castView(findRequiredView2, R.id.as_date_upto_calendar, "field 'as_date_upto_calendar'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(ewalletStatementFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.as_apply_tv, "field 'as_apply_tv' and method 'onApplyClick'");
        ewalletStatementFragment.as_apply_tv = (TextView) Utils.castView(findRequiredView3, R.id.as_apply_tv, "field 'as_apply_tv'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(ewalletStatementFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.as_reset_tv, "field 'as_reset_tv' and method 'onResetClick'");
        ewalletStatementFragment.as_reset_tv = (TextView) Utils.castView(findRequiredView4, R.id.as_reset_tv, "field 'as_reset_tv'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(ewalletStatementFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.as_filter_rl, "field 'as_filter_rl' and method 'onFilterClick'");
        ewalletStatementFragment.as_filter_rl = (RelativeLayout) Utils.castView(findRequiredView5, R.id.as_filter_rl, "field 'as_filter_rl'", RelativeLayout.class);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(ewalletStatementFragment));
        Class cls3 = LinearLayout.class;
        ewalletStatementFragment.as_filter_rl_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.as_filter_rl_ll, "field 'as_filter_rl_ll'", cls3);
        ewalletStatementFragment.as_acc_stmt = (NestedScrollView) Utils.findOptionalViewAsType(view, R.id.as_acc_stmt, "field 'as_acc_stmt'", NestedScrollView.class);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.as_save_acc_stmt, "field 'as_save_acc_stmt' and method 'onSaveAccStmtClick'");
        ewalletStatementFragment.as_save_acc_stmt = (LinearLayout) Utils.castView(findRequiredView6, R.id.as_save_acc_stmt, "field 'as_save_acc_stmt'", cls3);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new f(ewalletStatementFragment));
    }

    public final void unbind() {
        EwalletStatementFragment ewalletStatementFragment = this.f4625a;
        if (ewalletStatementFragment != null) {
            this.f4625a = null;
            ewalletStatementFragment.as_user_id_tv = null;
            ewalletStatementFragment.as_account_status = null;
            ewalletStatementFragment.as_closing_balance = null;
            ewalletStatementFragment.as_reg_date = null;
            ewalletStatementFragment.as_transaction_id = null;
            ewalletStatementFragment.as_total_amount = null;
            ewalletStatementFragment.as_txn_list = null;
            ewalletStatementFragment.as_ewallet_empty_list = null;
            ewalletStatementFragment.ewalet_acc_statment_top = null;
            ewalletStatementFragment.ewalet_acc_statment_bottom = null;
            ewalletStatementFragment.as_user_name_tv = null;
            ewalletStatementFragment.as_amount = null;
            ewalletStatementFragment.as_total_gst = null;
            ewalletStatementFragment.as_cgst = null;
            ewalletStatementFragment.as_ugst = null;
            ewalletStatementFragment.as_igst = null;
            ewalletStatementFragment.as_sgst = null;
            ewalletStatementFragment.as_date_from_tv = null;
            ewalletStatementFragment.as_date_from_calendar = null;
            ewalletStatementFragment.as_date_upto_tv = null;
            ewalletStatementFragment.as_date_upto_calendar = null;
            ewalletStatementFragment.as_apply_tv = null;
            ewalletStatementFragment.as_reset_tv = null;
            ewalletStatementFragment.as_filter_rl = null;
            ewalletStatementFragment.as_filter_rl_ll = null;
            ewalletStatementFragment.as_acc_stmt = null;
            ewalletStatementFragment.as_save_acc_stmt = null;
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
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
