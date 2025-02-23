package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.e0  reason: case insensitive filesystem */
/* compiled from: PurchaseLoyaltyPointsConfirmationFragment */
public final class C1020e0 extends Subscriber<C1432ux> {
    public final /* synthetic */ PurchaseLoyaltyPointsConfirmationFragment a;

    public C1020e0(PurchaseLoyaltyPointsConfirmationFragment purchaseLoyaltyPointsConfirmationFragment) {
        this.a = purchaseLoyaltyPointsConfirmationFragment;
    }

    public final void onCompleted() {
        int i = PurchaseLoyaltyPointsConfirmationFragment.c;
        this.a.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = PurchaseLoyaltyPointsConfirmationFragment.c;
        th.getClass();
        th.getMessage();
        this.a.a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C1432ux uxVar = (C1432ux) obj;
        int i = PurchaseLoyaltyPointsConfirmationFragment.c;
        PurchaseLoyaltyPointsConfirmationFragment purchaseLoyaltyPointsConfirmationFragment = this.a;
        purchaseLoyaltyPointsConfirmationFragment.a.dismiss();
        if (uxVar != null) {
            uxVar.toString();
            if (uxVar.getErrorMessage() == null) {
                C1450w1.f7017b = uxVar.getUserDetail().getUserConfigurablesDTOs();
                purchaseLoyaltyPointsConfirmationFragment.totalPurchasePoint.setText(String.valueOf(uxVar.getSoftPointsPurchaseView().getPointsToPurchase()));
                purchaseLoyaltyPointsConfirmationFragment.totalAmount.setText(String.format(purchaseLoyaltyPointsConfirmationFragment.getResources().getString(R.string.format_rupees), new Object[]{uxVar.getSoftPointsPurchaseView().getPurchaseAmount()}));
                purchaseLoyaltyPointsConfirmationFragment.transactionId.setText(String.valueOf(uxVar.getSoftPointsPurchaseView().getLoyaltyTxnDtlsSrlNo()));
                return;
            }
            C0535I5.m(purchaseLoyaltyPointsConfirmationFragment.getActivity(), true, uxVar.getErrorMessage(), purchaseLoyaltyPointsConfirmationFragment.getString(R.string.error), purchaseLoyaltyPointsConfirmationFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        C0535I5.m(purchaseLoyaltyPointsConfirmationFragment.getActivity(), true, purchaseLoyaltyPointsConfirmationFragment.getString(R.string.some_error_purchase_loyalty), purchaseLoyaltyPointsConfirmationFragment.getString(R.string.error), purchaseLoyaltyPointsConfirmationFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }
}
