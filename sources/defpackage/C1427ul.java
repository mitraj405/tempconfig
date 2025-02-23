package defpackage;

import android.content.DialogInterface;

/* renamed from: ul  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C1427ul implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0474Cl a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1225kp f6985a;

    public C1427ul(C0474Cl cl, C1225kp kpVar) {
        this.a = cl;
        this.f6985a = kpVar;
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
            C0535I5.W(this.f6985a.getErrorMsg(), true, new C0822cf(cl.f3551a.a().getActivity()), (String) null, (String) null);
        }
    }
}
