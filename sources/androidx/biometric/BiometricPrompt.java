package androidx.biometric;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.identity.IdentityCredential;
import android.text.TextUtils;
import androidx.biometric.d;
import androidx.biometric.h;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.g;
import com.google.firebase.perf.util.Constants;
import cris.org.in.ima.activities.MoreDrawerActivity;
import java.lang.ref.WeakReference;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class BiometricPrompt {
    public FragmentManager a;

    public static class ResetCallbackObserver implements Yh {
        public final WeakReference<j> a;

        public ResetCallbackObserver(j jVar) {
            this.a = new WeakReference<>(jVar);
        }

        @g(Lifecycle.a.ON_DESTROY)
        public void resetCallback() {
            WeakReference<j> weakReference = this.a;
            if (weakReference.get() != null) {
                weakReference.get().f1294a = null;
            }
        }
    }

    public static class b {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final c f1284a;

        public b(c cVar, int i) {
            this.f1284a = cVar;
            this.a = i;
        }
    }

    public static class d {
        public final CharSequence a;
        public final CharSequence b;

        public static class a {
            public CharSequence a = null;
            public CharSequence b = null;

            public final d a() {
                if (TextUtils.isEmpty(this.a)) {
                    throw new IllegalArgumentException("Title must be set and non-empty.");
                } else if (!c.b(0)) {
                    throw new IllegalArgumentException("Authenticator combination is unsupported on API " + Build.VERSION.SDK_INT + ": " + String.valueOf(0));
                } else if (!TextUtils.isEmpty(this.b)) {
                    TextUtils.isEmpty(this.b);
                    return new d(this.a, this.b);
                } else {
                    throw new IllegalArgumentException("Negative text must be set and non-empty.");
                }
            }
        }

        public d(CharSequence charSequence, CharSequence charSequence2) {
            this.a = charSequence;
            this.b = charSequence2;
        }
    }

    @SuppressLint({"LambdaLast"})
    public BiometricPrompt(FragmentActivity fragmentActivity, Executor executor, a aVar) {
        if (fragmentActivity == null) {
            throw new IllegalArgumentException("FragmentActivity must not be null.");
        } else if (executor != null) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            j jVar = (j) new ViewModelProvider(fragmentActivity).a(j.class);
            this.a = supportFragmentManager;
            jVar.f1301a = executor;
            jVar.f1294a = aVar;
        } else {
            throw new IllegalArgumentException("Executor must not be null.");
        }
    }

    public final void a(d dVar) {
        if (dVar != null) {
            FragmentManager fragmentManager = this.a;
            if (fragmentManager != null && !fragmentManager.N()) {
                FragmentManager fragmentManager2 = this.a;
                d dVar2 = (d) fragmentManager2.C("androidx.biometric.BiometricFragment");
                if (dVar2 == null) {
                    dVar2 = new d();
                    androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager2);
                    aVar.g(0, dVar2, "androidx.biometric.BiometricFragment", 1);
                    aVar.d();
                    fragmentManager2.z();
                }
                FragmentActivity activity = dVar2.getActivity();
                if (activity != null) {
                    j jVar = dVar2.f1290a;
                    jVar.f1296a = dVar;
                    int i = Build.VERSION.SDK_INT;
                    jVar.f1295a = null;
                    if (dVar2.h()) {
                        dVar2.f1290a.f1300a = dVar2.getString(Wr.confirm_device_credential_password);
                    } else {
                        dVar2.f1290a.f1300a = null;
                    }
                    if (dVar2.h() && new h(new h.c(activity)).a(Constants.MAX_HOST_LENGTH) != 0) {
                        dVar2.f1290a.f1304c = true;
                        dVar2.j();
                    } else if (dVar2.f1290a.f1306e) {
                        dVar2.a.postDelayed(new d.g(dVar2), 600);
                    } else {
                        dVar2.n();
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("PromptInfo cannot be null.");
        }
    }

    public static class c {
        public final IdentityCredential a;

        /* renamed from: a  reason: collision with other field name */
        public final Signature f1285a;

        /* renamed from: a  reason: collision with other field name */
        public final Cipher f1286a;

        /* renamed from: a  reason: collision with other field name */
        public final Mac f1287a;

        public c(Signature signature) {
            this.f1285a = signature;
            this.f1286a = null;
            this.f1287a = null;
            this.a = null;
        }

        public c(Cipher cipher) {
            this.f1285a = null;
            this.f1286a = cipher;
            this.f1287a = null;
            this.a = null;
        }

        public c(Mac mac) {
            this.f1285a = null;
            this.f1286a = null;
            this.f1287a = mac;
            this.a = null;
        }

        public c(IdentityCredential identityCredential) {
            this.f1285a = null;
            this.f1286a = null;
            this.f1287a = null;
            this.a = identityCredential;
        }
    }

    @SuppressLint({"LambdaLast"})
    public BiometricPrompt(Fragment fragment, Executor executor, MoreDrawerActivity.a aVar) {
        if (fragment == null) {
            throw new IllegalArgumentException("Fragment must not be null.");
        } else if (executor != null) {
            FragmentActivity activity = fragment.getActivity();
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            j jVar = activity != null ? (j) new ViewModelProvider(activity).a(j.class) : null;
            if (jVar != null) {
                fragment.getLifecycle().a(new ResetCallbackObserver(jVar));
            }
            this.a = childFragmentManager;
            if (jVar != null) {
                jVar.f1301a = executor;
                jVar.f1294a = aVar;
            }
        } else {
            throw new IllegalArgumentException("Executor must not be null.");
        }
    }

    public static abstract class a {
        public void b() {
        }

        public void c() {
        }

        public void a(int i) {
        }
    }
}
