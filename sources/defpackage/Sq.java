package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.MyAccountFragment;

/* renamed from: Sq  reason: default package */
/* compiled from: PurchaseLoyaltyPointsFragment */
public final class Sq implements DialogInterface.OnClickListener {
    public final /* synthetic */ Tq a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1432ux f3791a;

    public Sq(Tq tq, C1432ux uxVar) {
        this.a = tq;
        this.f3791a = uxVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3791a.getErrorMessage().contains("not allowed")) {
            dialogInterface.dismiss();
            Tq tq = this.a;
            HomeActivity.B(tq.a.getActivity());
            FragmentActivity activity = tq.a.getActivity();
            MyAccountFragment myAccountFragment = new MyAccountFragment();
            String a2 = C1218kf.MY_ACCOUNT.a();
            Boolean bool = Boolean.TRUE;
            HomeActivity.n(activity, myAccountFragment, a2, bool, bool);
            return;
        }
        dialogInterface.dismiss();
    }
}
