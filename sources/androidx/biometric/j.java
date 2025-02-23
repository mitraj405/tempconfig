package androidx.biometric;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.b;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.perf.util.Constants;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* compiled from: BiometricViewModel */
public final class j extends C0404yC {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public B4 f1293a;

    /* renamed from: a  reason: collision with other field name */
    public BiometricPrompt.a f1294a;

    /* renamed from: a  reason: collision with other field name */
    public BiometricPrompt.c f1295a;

    /* renamed from: a  reason: collision with other field name */
    public BiometricPrompt.d f1296a;

    /* renamed from: a  reason: collision with other field name */
    public b f1297a;

    /* renamed from: a  reason: collision with other field name */
    public c f1298a;

    /* renamed from: a  reason: collision with other field name */
    public MutableLiveData<BiometricPrompt.b> f1299a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f1300a;

    /* renamed from: a  reason: collision with other field name */
    public Executor f1301a;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public MutableLiveData<L2> f1302b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1303b;
    public MutableLiveData<CharSequence> c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1304c;
    public MutableLiveData<Boolean> d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f1305d;
    public MutableLiveData<Boolean> e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f1306e;
    public MutableLiveData<Boolean> f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f1307f;
    public MutableLiveData<Integer> g;

    /* renamed from: g  reason: collision with other field name */
    public boolean f1308g = true;
    public MutableLiveData<CharSequence> h;

    /* compiled from: BiometricViewModel */
    public static final class a extends b.c {
        public final WeakReference<j> a;

        public a(j jVar) {
            this.a = new WeakReference<>(jVar);
        }

        public final void a(int i, CharSequence charSequence) {
            WeakReference<j> weakReference = this.a;
            if (weakReference.get() != null && !weakReference.get().f1305d && weakReference.get().f1304c) {
                weakReference.get().e(new L2(i, charSequence));
            }
        }

        public final void b() {
            WeakReference<j> weakReference = this.a;
            if (weakReference.get() != null && weakReference.get().f1304c) {
                j jVar = weakReference.get();
                if (jVar.d == null) {
                    jVar.d = new MutableLiveData<>();
                }
                j.i(jVar.d, Boolean.TRUE);
            }
        }

        public final void c(BiometricPrompt.b bVar) {
            boolean z;
            WeakReference<j> weakReference = this.a;
            if (weakReference.get() != null && weakReference.get().f1304c) {
                int i = -1;
                if (bVar.a == -1) {
                    int c = weakReference.get().c();
                    if ((c & 32767) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && !c.a(c)) {
                        i = 2;
                    }
                    bVar = new BiometricPrompt.b(bVar.f1284a, i);
                }
                j jVar = weakReference.get();
                if (jVar.f1299a == null) {
                    jVar.f1299a = new MutableLiveData<>();
                }
                j.i(jVar.f1299a, bVar);
            }
        }
    }

    /* compiled from: BiometricViewModel */
    public static class b implements Executor {
        public final Handler a = new Handler(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    /* compiled from: BiometricViewModel */
    public static class c implements DialogInterface.OnClickListener {
        public final WeakReference<j> a;

        public c(j jVar) {
            this.a = new WeakReference<>(jVar);
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            WeakReference<j> weakReference = this.a;
            if (weakReference.get() != null) {
                weakReference.get().h(true);
            }
        }
    }

    public static <T> void i(MutableLiveData<T> mutableLiveData, T t) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            mutableLiveData.i(t);
        } else {
            mutableLiveData.j(t);
        }
    }

    public final int c() {
        if (this.f1296a == null) {
            return 0;
        }
        if (this.f1295a != null) {
            return 15;
        }
        return Constants.MAX_HOST_LENGTH;
    }

    public final CharSequence d() {
        CharSequence charSequence = this.f1300a;
        if (charSequence != null) {
            return charSequence;
        }
        BiometricPrompt.d dVar = this.f1296a;
        if (dVar == null) {
            return null;
        }
        CharSequence charSequence2 = dVar.b;
        if (charSequence2 != null) {
            return charSequence2;
        }
        return "";
    }

    public final void e(L2 l2) {
        if (this.f1302b == null) {
            this.f1302b = new MutableLiveData<>();
        }
        i(this.f1302b, l2);
    }

    public final void f(CharSequence charSequence) {
        if (this.h == null) {
            this.h = new MutableLiveData<>();
        }
        i(this.h, charSequence);
    }

    public final void g(int i) {
        if (this.g == null) {
            this.g = new MutableLiveData<>();
        }
        i(this.g, Integer.valueOf(i));
    }

    public final void h(boolean z) {
        if (this.e == null) {
            this.e = new MutableLiveData<>();
        }
        i(this.e, Boolean.valueOf(z));
    }
}
