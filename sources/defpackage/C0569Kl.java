package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.prs.ima.R;
import defpackage.C1480xl;

/* renamed from: Kl  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C0569Kl implements DialogInterface.OnClickListener {
    public final /* synthetic */ C1480xl.f.a a;

    public C0569Kl(C1480xl.f.a aVar) {
        this.a = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C1480xl.f.a aVar = this.a;
        C1480xl.f fVar = C1480xl.f.this;
        if (C1480xl.this.f7046c != null) {
            C0535I5.W(fVar.f7055a.getString(R.string.some_error_occurred_check_bkg), false, new C0822cf(C1480xl.f.this.f7055a.getActivity()), (String) null, (String) null);
        }
        HomeActivity.B(C1480xl.f.this.a);
    }
}
