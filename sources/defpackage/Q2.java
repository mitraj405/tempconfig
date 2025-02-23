package defpackage;

import androidx.biometric.d;
import androidx.biometric.j;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/* renamed from: Q2  reason: default package */
/* compiled from: BiometricFragment */
public final class Q2 implements Observer<Boolean> {
    public final /* synthetic */ d a;

    public Q2(d dVar) {
        this.a = dVar;
    }

    public final void a(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            d dVar = this.a;
            dVar.f(1);
            dVar.dismiss();
            j jVar = dVar.f1290a;
            if (jVar.f == null) {
                jVar.f = new MutableLiveData<>();
            }
            j.i(jVar.f, Boolean.FALSE);
        }
    }
}
