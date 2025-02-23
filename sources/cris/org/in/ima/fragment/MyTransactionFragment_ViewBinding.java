package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class MyTransactionFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public MyTransactionFragment f4842a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MyTransactionFragment a;

        public a(MyTransactionFragment myTransactionFragment) {
            this.a = myTransactionFragment;
        }

        public final void doClick(View view) {
            this.a.onLastTransactionClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MyTransactionFragment a;

        public b(MyTransactionFragment myTransactionFragment) {
            this.a = myTransactionFragment;
        }

        public final void doClick(View view) {
            this.a.onTdrHistoryClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ MyTransactionFragment a;

        public c(MyTransactionFragment myTransactionFragment) {
            this.a = myTransactionFragment;
        }

        public final void doClick(View view) {
            this.a.onMyBookingClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ MyTransactionFragment a;

        public d(MyTransactionFragment myTransactionFragment) {
            this.a = myTransactionFragment;
        }

        public final void doClick(View view) {
            this.a.onFailedTxnHistoryClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ MyTransactionFragment a;

        public e(MyTransactionFragment myTransactionFragment) {
            this.a = myTransactionFragment;
        }

        public final void doClick(View view) {
            this.a.onTktCancellationHistoryClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ MyTransactionFragment a;

        public f(MyTransactionFragment myTransactionFragment) {
            this.a = myTransactionFragment;
        }

        public final void doClick(View view) {
            this.a.onRefundHistoryClick(view);
        }
    }

    public MyTransactionFragment_ViewBinding(MyTransactionFragment myTransactionFragment, View view) {
        this.f4842a = myTransactionFragment;
        myTransactionFragment.mytransactionbottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.my_transaction_bottom, "field 'mytransactionbottom'", AdManagerAdView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.last_transation_detail_ll, "field 'lastTransationDetailLL' and method 'onLastTransactionClick'");
        myTransactionFragment.lastTransationDetailLL = (RelativeLayout) Utils.castView(findRequiredView, R.id.last_transation_detail_ll, "field 'lastTransationDetailLL'", RelativeLayout.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(myTransactionFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.rl_tdrhistory, "method 'onTdrHistoryClick'");
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(myTransactionFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.rl_mybooking, "method 'onMyBookingClick'");
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(myTransactionFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.rl_failedtransaction, "method 'onFailedTxnHistoryClick'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(myTransactionFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.rl_cancelledticket, "method 'onTktCancellationHistoryClick'");
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(myTransactionFragment));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.rl_ticketrefund, "method 'onRefundHistoryClick'");
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new f(myTransactionFragment));
    }

    public final void unbind() {
        MyTransactionFragment myTransactionFragment = this.f4842a;
        if (myTransactionFragment != null) {
            this.f4842a = null;
            myTransactionFragment.mytransactionbottom = null;
            myTransactionFragment.lastTransationDetailLL = null;
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
