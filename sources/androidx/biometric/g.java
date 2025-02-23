package androidx.biometric;

import androidx.biometric.BiometricPrompt;

/* compiled from: BiometricFragment */
public final class g implements Runnable {
    public final /* synthetic */ d a;

    public g(d dVar, BiometricPrompt.b bVar) {
        this.a = dVar;
    }

    public final void run() {
        j jVar = this.a.f1290a;
        if (jVar.f1294a == null) {
            jVar.f1294a = new i();
        }
        jVar.f1294a.c();
    }
}
