package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class TransactionPasswordFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public TransactionPasswordFragment f5180a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ TransactionPasswordFragment a;

        public a(TransactionPasswordFragment transactionPasswordFragment) {
            this.a = transactionPasswordFragment;
        }

        public final void doClick(View view) {
            this.a.onRegisterClick();
        }
    }

    public TransactionPasswordFragment_ViewBinding(TransactionPasswordFragment transactionPasswordFragment, View view) {
        this.f5180a = transactionPasswordFragment;
        Class cls = EditText.class;
        transactionPasswordFragment.txnPw = (EditText) Utils.findRequiredViewAsType(view, R.id.txn_pw, "field 'txnPw'", cls);
        transactionPasswordFragment.cnfTxnPassword = (EditText) Utils.findRequiredViewAsType(view, R.id.cnf_txn_pw, "field 'cnfTxnPassword'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_save, "field 'submit' and method 'onRegisterClick'");
        transactionPasswordFragment.submit = (TextView) Utils.castView(findRequiredView, R.id.tv_save, "field 'submit'", TextView.class);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(transactionPasswordFragment));
    }

    public final void unbind() {
        TransactionPasswordFragment transactionPasswordFragment = this.f5180a;
        if (transactionPasswordFragment != null) {
            this.f5180a = null;
            transactionPasswordFragment.txnPw = null;
            transactionPasswordFragment.cnfTxnPassword = null;
            transactionPasswordFragment.submit = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
