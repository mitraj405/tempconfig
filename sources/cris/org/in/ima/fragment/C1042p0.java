package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.SplTrainFragment;

/* renamed from: cris.org.in.ima.fragment.p0  reason: case insensitive filesystem */
/* compiled from: SplTrainFragment */
public final class C1042p0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SplTrainFragment.d a;

    public C1042p0(SplTrainFragment.d dVar) {
        this.a = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        SplTrainFragment.d dVar = this.a;
        HomeActivity.B(SplTrainFragment.this.getActivity());
        HomeActivity.n(SplTrainFragment.this.getActivity(), new MyBookingFragment(), C1218kf.MY_BOOKING.a(), Boolean.TRUE, Boolean.FALSE);
    }
}
