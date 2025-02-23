package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.F;

/* renamed from: Us  reason: default package */
/* compiled from: RegistrationActivity */
public final class Us implements DialogInterface.OnClickListener {
    public final /* synthetic */ F a;

    public Us(F f) {
        this.a = f;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a.finish();
    }
}
