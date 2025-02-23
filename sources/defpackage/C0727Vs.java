package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.F;

/* renamed from: Vs  reason: default package and case insensitive filesystem */
/* compiled from: RegistrationActivity */
public final class C0727Vs implements DialogInterface.OnClickListener {
    public final /* synthetic */ F a;

    public C0727Vs(F f) {
        this.a = f;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.a.finish();
    }
}
