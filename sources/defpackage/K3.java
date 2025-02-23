package defpackage;

import android.os.Handler;
import defpackage.C0169dd;
import defpackage.TA;

/* renamed from: K3  reason: default package */
/* compiled from: CallbackWithHandler */
public final class K3 {
    public final Handler a;

    /* renamed from: a  reason: collision with other field name */
    public final r1 f332a;

    public K3(TA.a aVar, Handler handler) {
        this.f332a = aVar;
        this.a = handler;
    }

    public final void a(C0169dd.a aVar) {
        boolean z;
        int i = aVar.a;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        Handler handler = this.a;
        r1 r1Var = this.f332a;
        if (z) {
            handler.post(new I3(r1Var, aVar.f2872a));
        } else {
            handler.post(new J3(r1Var, i));
        }
    }
}
