package defpackage;

import defpackage.Et;
import defpackage.TA;

/* renamed from: J3  reason: default package */
/* compiled from: CallbackWithHandler */
public final class J3 implements Runnable {
    public final /* synthetic */ r1 a;
    public final /* synthetic */ int c;

    public J3(r1 r1Var, int i) {
        this.a = r1Var;
        this.c = i;
    }

    public final void run() {
        Et.e eVar = ((TA.a) this.a).a;
        if (eVar != null) {
            eVar.lambda$callbackFailAsync$1(this.c);
        }
    }
}
