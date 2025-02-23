package defpackage;

import android.content.DialogInterface;

/* renamed from: vl  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C1444vl implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0474Cl a;
    public final /* synthetic */ String c;

    public C1444vl(C0474Cl cl, String str) {
        this.a = cl;
        this.c = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0474Cl cl = this.a;
        C1480xl xlVar = cl.f3552a;
        if (xlVar.f7046c == null) {
            return;
        }
        if (xlVar.f7042a.getJuspayLoadDTO() != null) {
            C0535I5.W("PG_ISSUE", false, new C0822cf(cl.f3551a.a().getActivity()), (String) null, (String) null);
        } else {
            C0535I5.W(this.c.split("-")[0], true, new C0822cf(cl.f3551a.a().getActivity()), (String) null, (String) null);
        }
    }
}
