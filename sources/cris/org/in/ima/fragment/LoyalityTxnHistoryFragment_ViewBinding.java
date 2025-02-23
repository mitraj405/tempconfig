package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class LoyalityTxnHistoryFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public LoyalityTxnHistoryFragment f4760a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ LoyalityTxnHistoryFragment a;

        public a(LoyalityTxnHistoryFragment loyalityTxnHistoryFragment) {
            this.a = loyalityTxnHistoryFragment;
        }

        public final void doClick(View view) {
            this.a.onLoyalityTransationtypeClick(view);
        }
    }

    public LoyalityTxnHistoryFragment_ViewBinding(LoyalityTxnHistoryFragment loyalityTxnHistoryFragment, View view) {
        this.f4760a = loyalityTxnHistoryFragment;
        Class cls = TextView.class;
        loyalityTxnHistoryFragment.loyalityAccNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_Account_Number, "field 'loyalityAccNumber'", cls);
        loyalityTxnHistoryFragment.loyalityAccStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_Account_status, "field 'loyalityAccStatus'", cls);
        loyalityTxnHistoryFragment.loyalityMemberOn = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_member_on, "field 'loyalityMemberOn'", cls);
        loyalityTxnHistoryFragment.loyalityMemberValid = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_member_valid, "field 'loyalityMemberValid'", cls);
        loyalityTxnHistoryFragment.loyalityTotalPoint = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_balance_point, "field 'loyalityTotalPoint'", cls);
        loyalityTxnHistoryFragment.loyalitypointRedm = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_redeem_point, "field 'loyalitypointRedm'", cls);
        loyalityTxnHistoryFragment.loyalityTravelPoint = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_travel_point, "field 'loyalityTravelPoint'", cls);
        loyalityTxnHistoryFragment.loyalityParternerPoint = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_partner_point, "field 'loyalityParternerPoint'", cls);
        loyalityTxnHistoryFragment.loyalitycardType = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_card_type, "field 'loyalitycardType'", cls);
        loyalityTxnHistoryFragment.loyalityPurchasePoint = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_purchase_point, "field 'loyalityPurchasePoint'", cls);
        loyalityTxnHistoryFragment.loyalityTransactionType = (TextView) Utils.findRequiredViewAsType(view, R.id.ly_transaction_type, "field 'loyalityTransactionType'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.transaction_type_ll, "field 'transaction_type_ll' and method 'onLoyalityTransationtypeClick'");
        Class cls2 = LinearLayout.class;
        loyalityTxnHistoryFragment.transaction_type_ll = (LinearLayout) Utils.castView(findRequiredView, R.id.transaction_type_ll, "field 'transaction_type_ll'", cls2);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(loyalityTxnHistoryFragment));
        loyalityTxnHistoryFragment.annualTransactionView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.ly_recycle, "field 'annualTransactionView'", RecyclerView.class);
        loyalityTxnHistoryFragment.annualTxnScrollView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ly_scroll, "field 'annualTxnScrollView'", cls2);
        loyalityTxnHistoryFragment.NoRecordFoundMsg = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tv_no_record_found, "field 'NoRecordFoundMsg'", cls2);
    }

    public final void unbind() {
        LoyalityTxnHistoryFragment loyalityTxnHistoryFragment = this.f4760a;
        if (loyalityTxnHistoryFragment != null) {
            this.f4760a = null;
            loyalityTxnHistoryFragment.loyalityAccNumber = null;
            loyalityTxnHistoryFragment.loyalityAccStatus = null;
            loyalityTxnHistoryFragment.loyalityMemberOn = null;
            loyalityTxnHistoryFragment.loyalityMemberValid = null;
            loyalityTxnHistoryFragment.loyalityTotalPoint = null;
            loyalityTxnHistoryFragment.loyalitypointRedm = null;
            loyalityTxnHistoryFragment.loyalityTravelPoint = null;
            loyalityTxnHistoryFragment.loyalityParternerPoint = null;
            loyalityTxnHistoryFragment.loyalitycardType = null;
            loyalityTxnHistoryFragment.loyalityPurchasePoint = null;
            loyalityTxnHistoryFragment.loyalityTransactionType = null;
            loyalityTxnHistoryFragment.transaction_type_ll = null;
            loyalityTxnHistoryFragment.annualTransactionView = null;
            loyalityTxnHistoryFragment.annualTxnScrollView = null;
            loyalityTxnHistoryFragment.NoRecordFoundMsg = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
