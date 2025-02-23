package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.security.identity.IdentityCredential;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.j;
import androidx.biometric.k;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: AuthenticationCallbackProvider */
public final class b {
    public BiometricPrompt.AuthenticationCallback a;

    /* renamed from: a  reason: collision with other field name */
    public a f1288a;

    /* renamed from: a  reason: collision with other field name */
    public final c f1289a;

    /* renamed from: androidx.biometric.b$b  reason: collision with other inner class name */
    /* compiled from: AuthenticationCallbackProvider */
    public static class C0003b {
        public static int a(BiometricPrompt.AuthenticationResult authenticationResult) {
            return authenticationResult.getAuthenticationType();
        }
    }

    /* compiled from: AuthenticationCallbackProvider */
    public static class c {
        public void a(int i, CharSequence charSequence) {
            throw null;
        }

        public void b() {
            throw null;
        }

        public void c(BiometricPrompt.b bVar) {
            throw null;
        }
    }

    public b(j.a aVar) {
        this.f1289a = aVar;
    }

    /* compiled from: AuthenticationCallbackProvider */
    public static class a {
        public static BiometricPrompt.AuthenticationCallback a(c cVar) {
            return new C0002a(cVar);
        }

        /* renamed from: androidx.biometric.b$a$a  reason: collision with other inner class name */
        /* compiled from: AuthenticationCallbackProvider */
        public class C0002a extends BiometricPrompt.AuthenticationCallback {
            public final /* synthetic */ c a;

            public C0002a(c cVar) {
                this.a = cVar;
            }

            public void onAuthenticationError(int i, CharSequence charSequence) {
                this.a.a(i, charSequence);
            }

            public void onAuthenticationFailed() {
                this.a.b();
            }

            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                BiometricPrompt.CryptoObject g;
                IdentityCredential b;
                BiometricPrompt.c cVar = null;
                if (!(authenticationResult == null || (g = authenticationResult.getCryptoObject()) == null)) {
                    Cipher d = k.b.d(g);
                    if (d != null) {
                        cVar = new BiometricPrompt.c(d);
                    } else {
                        Signature f = k.b.f(g);
                        if (f != null) {
                            cVar = new BiometricPrompt.c(f);
                        } else {
                            Mac e = k.b.e(g);
                            if (e != null) {
                                cVar = new BiometricPrompt.c(e);
                            } else if (Build.VERSION.SDK_INT >= 30 && (b = k.c.b(g)) != null) {
                                cVar = new BiometricPrompt.c(b);
                            }
                        }
                    }
                }
                int i = Build.VERSION.SDK_INT;
                int i2 = -1;
                if (i >= 30) {
                    if (authenticationResult != null) {
                        i2 = C0003b.a(authenticationResult);
                    }
                } else if (i != 29) {
                    i2 = 2;
                }
                this.a.c(new BiometricPrompt.b(cVar, i2));
            }

            public void onAuthenticationHelp(int i, CharSequence charSequence) {
            }
        }
    }
}
