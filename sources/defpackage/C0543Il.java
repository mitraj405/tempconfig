package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.HomeActivity;
import defpackage.C1480xl;

/* renamed from: Il  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C0543Il implements DialogInterface.OnClickListener {
    public final /* synthetic */ C1074dm a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1480xl.f.a f3663a;

    public C0543Il(C1480xl.f.a aVar, C1074dm dmVar) {
        this.f3663a = aVar;
        this.a = dmVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C1480xl.f.a aVar = this.f3663a;
        C1480xl xlVar = C1480xl.this;
        if (!(xlVar.f7046c == null || xlVar.f7042a.getJuspayLoadDTO() == null)) {
            C0535I5.W(this.a.getErrorMessage(), false, new C0822cf(C1480xl.f.this.f7055a.getActivity()), (String) null, (String) null);
        }
        HomeActivity.B(C1480xl.f.this.a);
    }
}
