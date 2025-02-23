package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.G;

/* renamed from: Xs  reason: default package */
/* compiled from: RegistrationActivity */
public final class Xs implements DialogInterface.OnClickListener {
    public final /* synthetic */ G a;

    public Xs(G g) {
        this.a = g;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.a.finish();
    }
}
