package defpackage;

import androidx.biometric.d;
import androidx.lifecycle.Observer;

/* renamed from: N2  reason: default package */
/* compiled from: BiometricFragment */
public final class N2 implements Observer<CharSequence> {
    public final /* synthetic */ d a;

    public N2(d dVar) {
        this.a = dVar;
    }

    public final void a(Object obj) {
        CharSequence charSequence = (CharSequence) obj;
        if (charSequence != null) {
            d dVar = this.a;
            if (dVar.i()) {
                dVar.m(charSequence);
            }
            dVar.f1290a.e((L2) null);
        }
    }
}
