package defpackage;

import android.content.DialogInterface;
import cris.org.in.prs.ima.R;

/* renamed from: Dl  reason: default package */
/* compiled from: MobilePayment */
public final class Dl implements DialogInterface.OnClickListener {
    public final /* synthetic */ C1245lp a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1480xl f3567a;

    public Dl(C1480xl xlVar, C1245lp lpVar) {
        this.f3567a = xlVar;
        this.a = lpVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3567a.f7046c != null) {
            C1245lp lpVar = this.a;
            C0535I5.W(lpVar.a().getResources().getString(R.string.your_session_is_expired), false, new C0822cf(lpVar.a().getActivity()), (String) null, (String) null);
        }
    }
}
