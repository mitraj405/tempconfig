package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import cris.org.in.ima.fragment.ErsDisplayFragment;

/* renamed from: Ma  reason: default package and case insensitive filesystem */
/* compiled from: ErsDisplayFragment */
public final class C0589Ma implements DialogInterface.OnClickListener {
    public final /* synthetic */ ErsDisplayFragment a;

    public C0589Ma(ErsDisplayFragment ersDisplayFragment) {
        this.a = ersDisplayFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0486Dp dp = new C0486Dp();
        dp.setLocation("ERS_POP_UP");
        ErsDisplayFragment ersDisplayFragment = this.a;
        dp.setPnr(ersDisplayFragment.f4577a.getPnrNumber());
        dp.setReservationId(Long.valueOf(Long.parseLong(ersDisplayFragment.f4577a.getReservationId())));
        dp.setPsgnCount(Integer.valueOf(Integer.parseInt(ersDisplayFragment.f4577a.getNoOfBkdChild()) + Integer.parseInt(ersDisplayFragment.f4577a.getNoOfBkdPsgn())));
        ersDisplayFragment.r(dp);
        ersDisplayFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(C1450w1.f7018b.get("pledgeUrl"))));
    }
}
