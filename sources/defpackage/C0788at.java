package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import cris.org.in.ima.activities.J;
import cris.org.in.ima.activities.LoginActivity;

/* renamed from: at  reason: default package and case insensitive filesystem */
/* compiled from: RegistrationPage2Activity */
public final class C0788at implements DialogInterface.OnClickListener {
    public final /* synthetic */ J a;

    public C0788at(J j) {
        this.a = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        J j = this.a;
        j.f4204a.startActivity(new Intent(j.f4204a.getBaseContext(), LoginActivity.class));
    }
}
