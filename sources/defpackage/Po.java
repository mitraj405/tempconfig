package defpackage;

import android.content.DialogInterface;

/* renamed from: Po  reason: default package */
/* compiled from: PassengerDetailFragment */
public final class Po implements DialogInterface.OnClickListener {
    public final /* synthetic */ So a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1100f2 f3757a;

    public Po(So so, C1100f2 f2Var) {
        this.a = so;
        this.f3757a = f2Var;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        So so = this.a;
        so.a.show();
        so.f3790a.D0(this.f3757a);
        so.a.dismiss();
    }
}
