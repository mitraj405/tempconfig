package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.PurchaseLoyaltyPointsConfirmationFragment;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: Bl  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C0462Bl extends Subscriber<C1263mp> {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Fragment f3531a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1480xl f3532a;

    public C0462Bl(FragmentActivity fragmentActivity, Fragment fragment, C1480xl xlVar) {
        this.f3532a = xlVar;
        this.a = fragmentActivity;
        this.f3531a = fragment;
    }

    public final void onCompleted() {
        Boolean bool = C1480xl.a;
        this.f3532a.f7040a.dismiss();
    }

    public final void onError(Throwable th) {
        Boolean bool = C1480xl.a;
        th.getClass();
        th.getMessage();
        this.f3532a.f7040a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C1263mp mpVar = (C1263mp) obj;
        Boolean bool = C1480xl.a;
        this.f3532a.f7040a.dismiss();
        if (mpVar != null) {
            mpVar.toString();
            if (mpVar.getErrorMessage() == null) {
                PurchaseLoyaltyPointsConfirmationFragment purchaseLoyaltyPointsConfirmationFragment = new PurchaseLoyaltyPointsConfirmationFragment();
                purchaseLoyaltyPointsConfirmationFragment.f5048a = mpVar;
                HomeActivity.n(this.a, purchaseLoyaltyPointsConfirmationFragment, C1218kf.PURCHASE_POINTS_LOYALTY_CONFIRMATION.a(), Boolean.TRUE, Boolean.FALSE);
                return;
            }
            Fragment fragment = this.f3531a;
            C0535I5.m(fragment.getActivity(), true, mpVar.getErrorMessage(), fragment.getContext().getString(R.string.error), fragment.getActivity().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
