package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.HomeActivity;

/* renamed from: lt  reason: default package and case insensitive filesystem */
/* compiled from: ReleasePanAadhaarFragment */
public final class C1246lt implements DialogInterface.OnClickListener {
    public final /* synthetic */ C1289nt a;

    public C1246lt(C1289nt ntVar) {
        this.a = ntVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        HomeActivity.B(this.a.a.getActivity());
        HomeActivity.A(1);
    }
}
