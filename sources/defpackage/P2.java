package defpackage;

import androidx.biometric.d;
import androidx.lifecycle.Observer;

/* renamed from: P2  reason: default package */
/* compiled from: BiometricFragment */
public final class P2 implements Observer<Boolean> {
    public final /* synthetic */ d a;

    public P2(d dVar) {
        this.a = dVar;
    }

    public final void a(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            d dVar = this.a;
            if (dVar.h()) {
                dVar.j();
            } else {
                CharSequence d = dVar.f1290a.d();
                if (d == null) {
                    d = dVar.getString(Wr.default_error_msg);
                }
                dVar.k(13, d);
                dVar.f(2);
            }
            dVar.f1290a.h(false);
        }
    }
}
