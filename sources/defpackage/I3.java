package defpackage;

import android.graphics.Typeface;
import defpackage.Et;
import defpackage.TA;

/* renamed from: I3  reason: default package */
/* compiled from: CallbackWithHandler */
public final class I3 implements Runnable {
    public final /* synthetic */ Typeface a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ r1 f264a;

    public I3(r1 r1Var, Typeface typeface) {
        this.f264a = r1Var;
        this.a = typeface;
    }

    public final void run() {
        Et.e eVar = ((TA.a) this.f264a).a;
        if (eVar != null) {
            eVar.lambda$callbackSuccessAsync$0(this.a);
        }
    }
}
