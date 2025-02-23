package defpackage;

import androidx.biometric.d;
import androidx.biometric.e;
import androidx.biometric.j;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.Executor;

/* renamed from: O2  reason: default package */
/* compiled from: BiometricFragment */
public final class O2 implements Observer<Boolean> {
    public final /* synthetic */ d a;

    public O2(d dVar) {
        this.a = dVar;
    }

    public final void a(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            d dVar = this.a;
            if (dVar.i()) {
                dVar.m(dVar.getString(Wr.fingerprint_not_recognized));
            }
            j jVar = dVar.f1290a;
            if (jVar.f1304c) {
                Executor executor = jVar.f1301a;
                if (executor == null) {
                    executor = new j.b();
                }
                executor.execute(new e(dVar));
            }
            j jVar2 = dVar.f1290a;
            if (jVar2.d == null) {
                jVar2.d = new MutableLiveData<>();
            }
            j.i(jVar2.d, Boolean.FALSE);
        }
    }
}
