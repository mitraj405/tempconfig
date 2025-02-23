package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.SplTrainFragment;

/* renamed from: cris.org.in.ima.fragment.m0  reason: case insensitive filesystem */
/* compiled from: SplTrainFragment */
public final class C1036m0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SplTrainFragment.c a;

    public C1036m0(SplTrainFragment.c cVar) {
        this.a = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        SplTrainFragment.c cVar = this.a;
        HomeActivity.B(SplTrainFragment.this.getActivity());
        HomeActivity.n(SplTrainFragment.this.getActivity(), new MyBookingFragment(), C1218kf.MY_BOOKING.a(), Boolean.TRUE, Boolean.FALSE);
    }
}
