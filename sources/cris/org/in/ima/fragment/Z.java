package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.ima.fragment.NewBookingFragment;

/* compiled from: NewBookingFragment */
public final class Z implements DialogInterface.OnClickListener {
    public final /* synthetic */ NewBookingFragment.p a;

    public Z(NewBookingFragment.p pVar) {
        this.a = pVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        NewBookingFragment.this.f4844a.dismiss();
        dialogInterface.dismiss();
    }
}
