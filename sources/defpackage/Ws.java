package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.G;

/* renamed from: Ws  reason: default package */
/* compiled from: RegistrationActivity */
public final class Ws implements DialogInterface.OnClickListener {
    public final /* synthetic */ G a;

    public Ws(G g) {
        this.a = g;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.a.finish();
    }
}
