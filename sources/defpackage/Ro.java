package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.NewBookingFragment;

/* renamed from: Ro  reason: default package */
/* compiled from: PassengerDetailFragment */
public final class Ro implements DialogInterface.OnClickListener {
    public final /* synthetic */ So a;

    public Ro(So so) {
        this.a = so;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        So so = this.a;
        HomeActivity.B(so.f3790a.getActivity());
        HomeActivity.n(so.f3790a.getActivity(), new NewBookingFragment(), C1218kf.NEW_BOOKING.a(), Boolean.TRUE, Boolean.FALSE);
    }
}
