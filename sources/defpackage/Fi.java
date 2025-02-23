package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import cris.org.in.ima.activities.C0860q;
import cris.org.in.ima.activities.LoginActivity;

/* renamed from: Fi  reason: default package */
/* compiled from: LoginActivity */
public final class Fi implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0860q a;

    public Fi(C0860q qVar) {
        this.a = qVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0860q qVar = this.a;
        qVar.a.startActivity(new Intent(qVar.a.getApplicationContext(), LoginActivity.class));
    }
}
