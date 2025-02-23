package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import cris.org.in.ima.fragment.ERSFragment;

/* renamed from: M9  reason: default package and case insensitive filesystem */
/* compiled from: ERSFragment */
public final class C0588M9 implements DialogInterface.OnClickListener {
    public final /* synthetic */ ERSFragment a;

    public C0588M9(ERSFragment eRSFragment) {
        this.a = eRSFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        short s;
        C0486Dp dp = new C0486Dp();
        dp.setLocation("CNF_PAGE_POPUP");
        ERSFragment eRSFragment = this.a;
        dp.setPnr(eRSFragment.f4548a.getPnrNumber());
        dp.setReservationId(Long.valueOf(Long.parseLong(eRSFragment.f4548a.getReservationId())));
        short s2 = 0;
        if (eRSFragment.f4548a.getNumberOfAdults() == null) {
            s = 0;
        } else {
            s = eRSFragment.f4548a.getNumberOfAdults().shortValue();
        }
        if (eRSFragment.f4548a.getNumberOfChilds() != null) {
            s2 = eRSFragment.f4548a.getNumberOfChilds().shortValue();
        }
        dp.setPsgnCount(Integer.valueOf(s + s2));
        eRSFragment.p(dp);
        eRSFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(C1450w1.f7018b.get("pledgeUrl"))));
        eRSFragment.f4555b = true;
    }
}
