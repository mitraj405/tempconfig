package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import cris.org.in.ima.activities.LoginActivity;
import cris.org.in.ima.activities.P;

/* renamed from: NB  reason: default package */
/* compiled from: UserVerificationActivity */
public final class NB implements DialogInterface.OnClickListener {
    public final /* synthetic */ P a;

    public NB(P p) {
        this.a = p;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        P p = this.a;
        p.a.finish();
        p.a.startActivity(new Intent(p.a.getBaseContext(), LoginActivity.class));
    }
}
