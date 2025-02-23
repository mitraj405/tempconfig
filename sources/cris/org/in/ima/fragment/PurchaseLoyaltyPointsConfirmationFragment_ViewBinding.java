package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class PurchaseLoyaltyPointsConfirmationFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public PurchaseLoyaltyPointsConfirmationFragment f5050a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ PurchaseLoyaltyPointsConfirmationFragment a;

        public a(PurchaseLoyaltyPointsConfirmationFragment purchaseLoyaltyPointsConfirmationFragment) {
            this.a = purchaseLoyaltyPointsConfirmationFragment;
        }

        public final void doClick(View view) {
            this.a.okButton();
        }
    }

    public PurchaseLoyaltyPointsConfirmationFragment_ViewBinding(PurchaseLoyaltyPointsConfirmationFragment purchaseLoyaltyPointsConfirmationFragment, View view) {
        this.f5050a = purchaseLoyaltyPointsConfirmationFragment;
        Class cls = TextView.class;
        purchaseLoyaltyPointsConfirmationFragment.transactionId = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_txn_id, "field 'transactionId'", cls);
        purchaseLoyaltyPointsConfirmationFragment.totalPurchasePoint = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_total_purchase_point, "field 'totalPurchasePoint'", cls);
        purchaseLoyaltyPointsConfirmationFragment.totalAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_total_amount, "field 'totalAmount'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.btn_ok, "method 'okButton'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(purchaseLoyaltyPointsConfirmationFragment));
    }

    public final void unbind() {
        PurchaseLoyaltyPointsConfirmationFragment purchaseLoyaltyPointsConfirmationFragment = this.f5050a;
        if (purchaseLoyaltyPointsConfirmationFragment != null) {
            this.f5050a = null;
            purchaseLoyaltyPointsConfirmationFragment.transactionId = null;
            purchaseLoyaltyPointsConfirmationFragment.totalPurchasePoint = null;
            purchaseLoyaltyPointsConfirmationFragment.totalAmount = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
