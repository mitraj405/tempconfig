package defpackage;

import cris.org.in.ima.fragment.PurchaseLoyaltyPointsFragment;
import cris.org.in.prs.ima.R;
import java.util.regex.Pattern;
import rx.Subscriber;

/* renamed from: Tq  reason: default package */
/* compiled from: PurchaseLoyaltyPointsFragment */
public final class Tq extends Subscriber<C1432ux> {
    public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

    public Tq(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment) {
        this.a = purchaseLoyaltyPointsFragment;
    }

    public final void onCompleted() {
        Pattern pattern = PurchaseLoyaltyPointsFragment.a;
        this.a.f5052a.dismiss();
    }

    public final void onError(Throwable th) {
        Pattern pattern = PurchaseLoyaltyPointsFragment.a;
        th.getClass();
        th.getMessage();
        this.a.f5052a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C1432ux uxVar = (C1432ux) obj;
        Pattern pattern = PurchaseLoyaltyPointsFragment.a;
        PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment = this.a;
        purchaseLoyaltyPointsFragment.f5052a.dismiss();
        if (uxVar != null) {
            uxVar.toString();
            if (uxVar.getErrorMessage() == null) {
                purchaseLoyaltyPointsFragment.f5057a = uxVar;
                PurchaseLoyaltyPointsFragment.a = Pattern.compile(uxVar.getSoftPointsPurchaseView().getGstPatternRegExp());
                return;
            }
            C0535I5.m(purchaseLoyaltyPointsFragment.getContext(), false, uxVar.getErrorMessage(), purchaseLoyaltyPointsFragment.getString(R.string.error), purchaseLoyaltyPointsFragment.getString(R.string.OK), new Sq(this, uxVar)).show();
        }
    }
}
