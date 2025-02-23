package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentManager;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.A;
import cris.org.in.ima.fragment.CancelTicketDetailsFragment;

/* renamed from: c4  reason: default package and case insensitive filesystem */
/* compiled from: CancelTicketDetailsFragment */
public final class C0814c4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ A a;

    public C0814c4(A a2) {
        this.a = a2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        A a2 = this.a;
        FragmentManager fragmentManager = a2.a.f4482a.getFragmentManager();
        CancelTicketDetailsFragment cancelTicketDetailsFragment = a2.a;
        HomeActivity.F(fragmentManager.E(cancelTicketDetailsFragment.f4482a.getFragmentManager().F() - 2).getName());
        cancelTicketDetailsFragment.f4482a.getFragmentManager().Q();
    }
}
