package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.PurchaseLoyaltyPointsConfirmationFragment;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: Al  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C0451Al extends Subscriber<C1432ux> {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Fragment f3522a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1480xl f3523a;

    public C0451Al(FragmentActivity fragmentActivity, Fragment fragment, C1480xl xlVar) {
        this.f3523a = xlVar;
        this.a = fragmentActivity;
        this.f3522a = fragment;
    }

    public final void onCompleted() {
        Boolean bool = C1480xl.a;
        this.f3523a.f7040a.dismiss();
    }

    public final void onError(Throwable th) {
        Boolean bool = C1480xl.a;
        th.getClass();
        th.getMessage();
        this.f3523a.f7040a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C1432ux uxVar = (C1432ux) obj;
        Boolean bool = C1480xl.a;
        C1480xl xlVar = this.f3523a;
        xlVar.f7040a.dismiss();
        if (uxVar != null) {
            uxVar.toString();
            String errorMessage = uxVar.getErrorMessage();
            Context context = this.a;
            if (errorMessage == null) {
                Bundle bundle = new Bundle();
                PurchaseLoyaltyPointsConfirmationFragment purchaseLoyaltyPointsConfirmationFragment = new PurchaseLoyaltyPointsConfirmationFragment();
                purchaseLoyaltyPointsConfirmationFragment.f5049a = uxVar;
                bundle.putLong("txnId", xlVar.f7042a.getTransationId());
                purchaseLoyaltyPointsConfirmationFragment.setArguments(bundle);
                HomeActivity.n(context, purchaseLoyaltyPointsConfirmationFragment, C1218kf.PURCHASE_POINTS_LOYALTY_CONFIRMATION.a(), Boolean.TRUE, Boolean.FALSE);
                return;
            }
            Fragment fragment = this.f3522a;
            C0535I5.m(fragment.getActivity(), true, uxVar.getErrorMessage(), fragment.getContext().getString(R.string.error), context.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
