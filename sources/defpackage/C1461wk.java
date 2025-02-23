package defpackage;

import android.content.DialogInterface;
import android.content.Intent;

/* renamed from: wk  reason: default package and case insensitive filesystem */
/* compiled from: MasterPassengerNewActivity */
public final class C1461wk implements DialogInterface.OnClickListener {
    public final /* synthetic */ C1479xk a;

    public C1461wk(C1479xk xkVar) {
        this.a = xkVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        C1479xk xkVar = this.a;
        xkVar.a.setResult(0, intent);
        xkVar.a.finish();
    }
}
