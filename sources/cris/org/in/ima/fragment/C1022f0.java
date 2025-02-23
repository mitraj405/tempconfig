package cris.org.in.ima.fragment;

import java.util.ArrayList;
import java.util.regex.Pattern;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.f0  reason: case insensitive filesystem */
/* compiled from: PurchaseLoyaltyPointsFragment */
public final class C1022f0 extends Subscriber<C0812c0> {
    public final /* synthetic */ PurchaseLoyaltyPointsFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Boolean f5237a;

    public C1022f0(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment, Boolean bool) {
        this.a = purchaseLoyaltyPointsFragment;
        this.f5237a = bool;
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
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        C0812c0 c0Var = (C0812c0) obj;
        Pattern pattern = PurchaseLoyaltyPointsFragment.a;
        PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment = this.a;
        if (c0Var != null) {
            c0Var.getPostofficeList().toString();
            purchaseLoyaltyPointsFragment.f5052a.dismiss();
            if (this.f5237a.booleanValue()) {
                purchaseLoyaltyPointsFragment.state.setText(c0Var.getState());
                return;
            }
            ArrayList<String> arrayList = purchaseLoyaltyPointsFragment.f5056a;
            arrayList.clear();
            for (int i = 0; i < c0Var.getPostofficeList().size(); i++) {
                arrayList.add(c0Var.getPostofficeList().get(i));
            }
            return;
        }
        purchaseLoyaltyPointsFragment.f5052a.dismiss();
    }
}
