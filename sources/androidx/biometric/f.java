package androidx.biometric;

import androidx.biometric.BiometricPrompt;
import androidx.biometric.j;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.Executor;

/* compiled from: BiometricFragment */
public final class f implements Observer<BiometricPrompt.b> {
    public final /* synthetic */ d a;

    public f(d dVar) {
        this.a = dVar;
    }

    public final void a(Object obj) {
        BiometricPrompt.b bVar = (BiometricPrompt.b) obj;
        if (bVar != null) {
            d dVar = this.a;
            j jVar = dVar.f1290a;
            if (jVar.f1304c) {
                jVar.f1304c = false;
                Executor executor = jVar.f1301a;
                if (executor == null) {
                    executor = new j.b();
                }
                executor.execute(new g(dVar, bVar));
            }
            dVar.dismiss();
            j jVar2 = dVar.f1290a;
            if (jVar2.f1299a == null) {
                jVar2.f1299a = new MutableLiveData<>();
            }
            j.i(jVar2.f1299a, null);
        }
    }
}
