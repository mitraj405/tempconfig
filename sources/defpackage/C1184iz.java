package defpackage;

import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.C1044q0;
import cris.org.in.ima.fragment.TDRTicketFragment;

/* renamed from: iz  reason: default package and case insensitive filesystem */
/* compiled from: TDRTicketDetailsFragment */
public final class C1184iz implements DialogInterface.OnClickListener {
    public final /* synthetic */ C1044q0 a;

    public C1184iz(C1044q0 q0Var) {
        this.a = q0Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        C1044q0 q0Var = this.a;
        HomeActivity.B(q0Var.a.getActivity());
        HomeActivity.n((AppCompatActivity) q0Var.a.getActivity(), new TDRTicketFragment(), C1218kf.TDR_TICKET.a(), Boolean.TRUE, Boolean.FALSE);
    }
}
