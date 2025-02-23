package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class SplTrainFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public SplTrainFragment f5117a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SplTrainFragment a;

        public a(SplTrainFragment splTrainFragment) {
            this.a = splTrainFragment;
        }

        public final void doClick(View view) {
            this.a.onDateClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SplTrainFragment a;

        public b(SplTrainFragment splTrainFragment) {
            this.a = splTrainFragment;
        }

        public final void doClick(View view) {
            this.a.onSubmitClick();
        }
    }

    public SplTrainFragment_ViewBinding(SplTrainFragment splTrainFragment, View view) {
        this.f5117a = splTrainFragment;
        Class cls = LinearLayout.class;
        splTrainFragment.txnIdLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_txn_id, "field 'txnIdLayout'", cls);
        splTrainFragment.vikalpTrainDateLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_vikalp_train_date, "field 'vikalpTrainDateLayout'", cls);
        Class cls2 = EditText.class;
        splTrainFragment.trainNumber = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_train_number, "field 'trainNumber'", cls2);
        Class cls3 = TextView.class;
        splTrainFragment.pnrNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr_number, "field 'pnrNumber'", cls3);
        splTrainFragment.tvTxnId = (TextView) Utils.findRequiredViewAsType(view, R.id.txn_id, "field 'tvTxnId'", cls3);
        View findRequiredView = Utils.findRequiredView(view, R.id.vikalp_train_date, "field 'vikalpTrainDate' and method 'onDateClick'");
        splTrainFragment.vikalpTrainDate = (TextView) Utils.castView(findRequiredView, R.id.vikalp_train_date, "field 'vikalpTrainDate'", cls3);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(splTrainFragment));
        splTrainFragment.otpLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_otp, "field 'otpLayout'", cls);
        splTrainFragment.otp = (EditText) Utils.findRequiredViewAsType(view, R.id.otp, "field 'otp'", cls2);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_submit, "method 'onSubmitClick'");
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(splTrainFragment));
    }

    public final void unbind() {
        SplTrainFragment splTrainFragment = this.f5117a;
        if (splTrainFragment != null) {
            this.f5117a = null;
            splTrainFragment.txnIdLayout = null;
            splTrainFragment.vikalpTrainDateLayout = null;
            splTrainFragment.trainNumber = null;
            splTrainFragment.pnrNumber = null;
            splTrainFragment.tvTxnId = null;
            splTrainFragment.vikalpTrainDate = null;
            splTrainFragment.otpLayout = null;
            splTrainFragment.otp = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
