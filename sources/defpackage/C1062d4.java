package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.fragment.A;
import cris.org.in.ima.fragment.CancelTicketDetailsFragment;

/* renamed from: d4  reason: default package and case insensitive filesystem */
/* compiled from: CancelTicketDetailsFragment */
public final class C1062d4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ A a;

    public C1062d4(A a2) {
        this.a = a2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        A a2 = this.a;
        if (a2.a.f4482a.getFragmentManager() != null) {
            CancelTicketDetailsFragment cancelTicketDetailsFragment = a2.a;
            if (cancelTicketDetailsFragment.f4482a.getFragmentManager().F() > 0) {
                cancelTicketDetailsFragment.f4482a.getFragmentManager().Q();
            }
        }
    }
}
