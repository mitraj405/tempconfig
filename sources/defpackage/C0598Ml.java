package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.HomeFragment;
import defpackage.Nl;

/* renamed from: Ml  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C0598Ml implements DialogInterface.OnClickListener {
    public final /* synthetic */ Nl.a a;

    public C0598Ml(Nl.a aVar) {
        this.a = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Nl.a aVar = this.a;
        HomeActivity.B(Nl.this.a.getContext());
        Context context = Nl.this.a.getContext();
        HomeFragment homeFragment = new HomeFragment();
        String a2 = C1218kf.HOME_PAGE.a();
        Boolean bool = Boolean.TRUE;
        HomeActivity.n(context, homeFragment, a2, bool, bool);
    }
}
