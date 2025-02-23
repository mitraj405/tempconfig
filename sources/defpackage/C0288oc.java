package defpackage;

import android.hardware.fingerprint.FingerprintManager;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.a;
import androidx.biometric.j;
import androidx.lifecycle.MutableLiveData;
import defpackage.C0296pc;
import java.lang.ref.WeakReference;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: oc  reason: default package and case insensitive filesystem */
/* compiled from: FingerprintManagerCompat */
public final class C0288oc extends FingerprintManager.AuthenticationCallback {
    public final /* synthetic */ C0296pc.b a;

    public C0288oc(a aVar) {
        this.a = aVar;
    }

    public final void onAuthenticationError(int i, CharSequence charSequence) {
        ((a) this.a).a.f1289a.a(i, charSequence);
    }

    public final void onAuthenticationFailed() {
        ((a) this.a).a.f1289a.b();
    }

    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        WeakReference<j> weakReference = ((j.a) ((a) this.a).a.f1289a).a;
        if (weakReference.get() != null) {
            j jVar = weakReference.get();
            if (jVar.c == null) {
                jVar.c = new MutableLiveData<>();
            }
            j.i(jVar.c, charSequence);
        }
    }

    public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        BiometricPrompt.c cVar;
        C0296pc.c f = C0296pc.a.f(C0296pc.a.b(authenticationResult));
        a aVar = (a) this.a;
        aVar.getClass();
        if (f != null) {
            Cipher cipher = f.f3172a;
            if (cipher != null) {
                cVar = new BiometricPrompt.c(cipher);
            } else {
                Signature signature = f.a;
                if (signature != null) {
                    cVar = new BiometricPrompt.c(signature);
                } else {
                    Mac mac = f.f3173a;
                    if (mac != null) {
                        cVar = new BiometricPrompt.c(mac);
                    }
                }
            }
            aVar.a.f1289a.c(new BiometricPrompt.b(cVar, 2));
        }
        cVar = null;
        aVar.a.f1289a.c(new BiometricPrompt.b(cVar, 2));
    }
}
