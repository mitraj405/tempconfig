package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.j;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import defpackage.B4;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* compiled from: BiometricFragment */
public class d extends Fragment {
    public final Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    public j f1290a;

    /* compiled from: BiometricFragment */
    public class a implements Runnable {
        public final /* synthetic */ int c;

        public a(int i, CharSequence charSequence) {
            this.c = i;
        }

        public final void run() {
            j jVar = d.this.f1290a;
            if (jVar.f1294a == null) {
                jVar.f1294a = new i();
            }
            jVar.f1294a.a(this.c);
        }
    }

    /* compiled from: BiometricFragment */
    public static class b {
        public static Intent a(KeyguardManager keyguardManager, CharSequence charSequence, CharSequence charSequence2) {
            return keyguardManager.createConfirmDeviceCredentialIntent(charSequence, charSequence2);
        }
    }

    /* compiled from: BiometricFragment */
    public static class c {
        public static void a(BiometricPrompt biometricPrompt, BiometricPrompt.CryptoObject cryptoObject, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt.AuthenticationCallback authenticationCallback) {
            biometricPrompt.authenticate(cryptoObject, cancellationSignal, executor, authenticationCallback);
        }

        public static void b(BiometricPrompt biometricPrompt, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt.AuthenticationCallback authenticationCallback) {
            biometricPrompt.authenticate(cancellationSignal, executor, authenticationCallback);
        }

        public static BiometricPrompt c(BiometricPrompt.Builder builder) {
            return builder.build();
        }

        public static BiometricPrompt.Builder d(Context context) {
            return new BiometricPrompt.Builder(context);
        }

        public static void e(BiometricPrompt.Builder builder, CharSequence charSequence, Executor executor, DialogInterface.OnClickListener onClickListener) {
            builder.setNegativeButton(charSequence, executor, onClickListener);
        }

        public static void f(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    /* renamed from: androidx.biometric.d$d  reason: collision with other inner class name */
    /* compiled from: BiometricFragment */
    public static class C0004d {
        public static void a(BiometricPrompt.Builder builder, boolean z) {
            builder.setConfirmationRequired(z);
        }

        public static void b(BiometricPrompt.Builder builder, boolean z) {
            builder.setDeviceCredentialAllowed(z);
        }
    }

    /* compiled from: BiometricFragment */
    public static class e {
        public static void a(BiometricPrompt.Builder builder, int i) {
            builder.setAllowedAuthenticators(i);
        }
    }

    /* compiled from: BiometricFragment */
    public static class f implements Executor {
        public final Handler a = new Handler(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    /* compiled from: BiometricFragment */
    public static class g implements Runnable {
        public final WeakReference<d> a;

        public g(d dVar) {
            this.a = new WeakReference<>(dVar);
        }

        public final void run() {
            WeakReference<d> weakReference = this.a;
            if (weakReference.get() != null) {
                weakReference.get().n();
            }
        }
    }

    /* compiled from: BiometricFragment */
    public static class h implements Runnable {
        public final WeakReference<j> a;

        public h(j jVar) {
            this.a = new WeakReference<>(jVar);
        }

        public final void run() {
            WeakReference<j> weakReference = this.a;
            if (weakReference.get() != null) {
                weakReference.get().f1306e = false;
            }
        }
    }

    /* compiled from: BiometricFragment */
    public static class i implements Runnable {
        public final WeakReference<j> a;

        public i(j jVar) {
            this.a = new WeakReference<>(jVar);
        }

        public final void run() {
            WeakReference<j> weakReference = this.a;
            if (weakReference.get() != null) {
                weakReference.get().f1307f = false;
            }
        }
    }

    public final void dismiss() {
        boolean z = false;
        this.f1290a.f1303b = false;
        g();
        if (!this.f1290a.f1305d && isAdded()) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            parentFragmentManager.getClass();
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(parentFragmentManager);
            aVar.n(this);
            aVar.d();
        }
        Context context = getContext();
        if (context != null) {
            String str = Build.MODEL;
            if (Build.VERSION.SDK_INT == 29) {
                z = R8.a(context, Zq.delay_showing_prompt_models, str);
            }
            if (z) {
                j jVar = this.f1290a;
                jVar.f1306e = true;
                this.a.postDelayed(new h(jVar), 600);
            }
        }
    }

    public final void f(int i2) {
        if (i2 == 3 || !this.f1290a.f1307f) {
            if (i()) {
                this.f1290a.a = i2;
                if (i2 == 1) {
                    l(10, C1354qp.O(getContext(), 10));
                }
            }
            j jVar = this.f1290a;
            if (jVar.f1293a == null) {
                jVar.f1293a = new B4();
            }
            B4 b4 = jVar.f1293a;
            CancellationSignal cancellationSignal = b4.f41a;
            if (cancellationSignal != null) {
                try {
                    B4.b.a(cancellationSignal);
                } catch (NullPointerException unused) {
                }
                b4.f41a = null;
            }
            A4 a4 = b4.a;
            if (a4 != null) {
                try {
                    a4.a();
                } catch (NullPointerException unused2) {
                }
                b4.a = null;
            }
        }
    }

    public final void g() {
        this.f1290a.f1303b = false;
        if (isAdded()) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C0258lc lcVar = (C0258lc) parentFragmentManager.C("androidx.biometric.FingerprintDialogFragment");
            if (lcVar == null) {
                return;
            }
            if (lcVar.isAdded()) {
                lcVar.dismissAllowingStateLoss();
                return;
            }
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(parentFragmentManager);
            aVar.n(lcVar);
            aVar.d();
        }
    }

    public final boolean h() {
        if (Build.VERSION.SDK_INT > 28 || !c.a(this.f1290a.c())) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i() {
        /*
            r10 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 28
            if (r0 < r2) goto L_0x0075
            androidx.fragment.app.FragmentActivity r3 = r10.getActivity()
            r4 = 0
            if (r3 == 0) goto L_0x004c
            androidx.biometric.j r5 = r10.f1290a
            androidx.biometric.BiometricPrompt$c r5 = r5.f1295a
            if (r5 == 0) goto L_0x004c
            java.lang.String r5 = android.os.Build.MANUFACTURER
            java.lang.String r6 = android.os.Build.MODEL
            if (r0 == r2) goto L_0x001b
            goto L_0x0045
        L_0x001b:
            int r0 = defpackage.Zq.crypto_fingerprint_fallback_vendors
            if (r5 != 0) goto L_0x0020
            goto L_0x0039
        L_0x0020:
            android.content.res.Resources r7 = r3.getResources()
            java.lang.String[] r0 = r7.getStringArray(r0)
            int r7 = r0.length
            r8 = r4
        L_0x002a:
            if (r8 >= r7) goto L_0x0039
            r9 = r0[r8]
            boolean r9 = r5.equalsIgnoreCase(r9)
            if (r9 == 0) goto L_0x0036
            r0 = r1
            goto L_0x003a
        L_0x0036:
            int r8 = r8 + 1
            goto L_0x002a
        L_0x0039:
            r0 = r4
        L_0x003a:
            if (r0 != 0) goto L_0x0047
            int r0 = defpackage.Zq.crypto_fingerprint_fallback_prefixes
            boolean r0 = defpackage.R8.b(r3, r0, r6)
            if (r0 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r0 = r4
            goto L_0x0048
        L_0x0047:
            r0 = r1
        L_0x0048:
            if (r0 == 0) goto L_0x004c
            r0 = r1
            goto L_0x004d
        L_0x004c:
            r0 = r4
        L_0x004d:
            if (r0 != 0) goto L_0x0075
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 != r2) goto L_0x0070
            android.content.Context r0 = r10.getContext()
            if (r0 == 0) goto L_0x006b
            android.content.pm.PackageManager r2 = r0.getPackageManager()
            if (r2 == 0) goto L_0x006b
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            boolean r0 = defpackage.yo.a(r0)
            if (r0 == 0) goto L_0x006b
            r0 = r1
            goto L_0x006c
        L_0x006b:
            r0 = r4
        L_0x006c:
            if (r0 != 0) goto L_0x0070
            r0 = r1
            goto L_0x0071
        L_0x0070:
            r0 = r4
        L_0x0071:
            if (r0 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r1 = r4
        L_0x0075:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.biometric.d.i():boolean");
    }

    public final void j() {
        CharSequence charSequence;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            KeyguardManager a2 = Fh.a(activity);
            if (a2 == null) {
                k(12, getString(Wr.generic_error_no_keyguard));
                return;
            }
            j jVar = this.f1290a;
            BiometricPrompt.d dVar = jVar.f1296a;
            if (dVar != null) {
                charSequence = dVar.a;
            } else {
                charSequence = null;
            }
            jVar.getClass();
            this.f1290a.getClass();
            Intent a3 = b.a(a2, charSequence, (CharSequence) null);
            if (a3 == null) {
                k(14, getString(Wr.generic_error_no_device_credential));
                return;
            }
            this.f1290a.f1305d = true;
            if (i()) {
                g();
            }
            a3.setFlags(134742016);
            startActivityForResult(a3, 1);
        }
    }

    public final void k(int i2, CharSequence charSequence) {
        l(i2, charSequence);
        dismiss();
    }

    public final void l(int i2, CharSequence charSequence) {
        j jVar = this.f1290a;
        if (!jVar.f1305d && jVar.f1304c) {
            jVar.f1304c = false;
            Executor executor = jVar.f1301a;
            if (executor == null) {
                executor = new j.b();
            }
            executor.execute(new a(i2, charSequence));
        }
    }

    public final void m(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = getString(Wr.default_error_msg);
        }
        this.f1290a.g(2);
        this.f1290a.f(charSequence);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.CharSequence} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.CharSequence} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.CharSequence} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: android.os.CancellationSignal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.CharSequence} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.CharSequence} */
    /* JADX WARNING: type inference failed for: r2v11, types: [android.os.CancellationSignal] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fb A[SYNTHETIC, Splitter:B:60:0x00fb] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011c A[Catch:{ NullPointerException -> 0x012a }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n() {
        /*
            r12 = this;
            androidx.biometric.j r0 = r12.f1290a
            boolean r0 = r0.f1303b
            if (r0 != 0) goto L_0x0211
            android.content.Context r0 = r12.getContext()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            androidx.biometric.j r0 = r12.f1290a
            r1 = 1
            r0.f1303b = r1
            r0.f1304c = r1
            boolean r0 = r12.i()
            r2 = 0
            if (r0 == 0) goto L_0x0133
            android.content.Context r0 = r12.requireContext()
            android.content.Context r0 = r0.getApplicationContext()
            android.hardware.fingerprint.FingerprintManager r3 = defpackage.C0296pc.a.c(r0)
            r4 = 0
            if (r3 == 0) goto L_0x0032
            boolean r3 = defpackage.C0296pc.a.e(r3)
            if (r3 == 0) goto L_0x0032
            r3 = r1
            goto L_0x0033
        L_0x0032:
            r3 = r4
        L_0x0033:
            if (r3 != 0) goto L_0x0038
            r3 = 12
            goto L_0x004d
        L_0x0038:
            android.hardware.fingerprint.FingerprintManager r3 = defpackage.C0296pc.a.c(r0)
            if (r3 == 0) goto L_0x0046
            boolean r3 = defpackage.C0296pc.a.d(r3)
            if (r3 == 0) goto L_0x0046
            r3 = r1
            goto L_0x0047
        L_0x0046:
            r3 = r4
        L_0x0047:
            if (r3 != 0) goto L_0x004c
            r3 = 11
            goto L_0x004d
        L_0x004c:
            r3 = r4
        L_0x004d:
            if (r3 == 0) goto L_0x0058
            java.lang.String r0 = defpackage.C1354qp.O(r0, r3)
            r12.k(r3, r0)
            goto L_0x0211
        L_0x0058:
            boolean r3 = r12.isAdded()
            if (r3 == 0) goto L_0x0211
            androidx.biometric.j r3 = r12.f1290a
            r3.f1308g = r1
            java.lang.String r3 = android.os.Build.MODEL
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 28
            if (r5 == r6) goto L_0x006c
            r3 = r4
            goto L_0x0072
        L_0x006c:
            int r5 = defpackage.Zq.hide_fingerprint_instantly_prefixes
            boolean r3 = defpackage.R8.b(r0, r5, r3)
        L_0x0072:
            if (r3 != 0) goto L_0x008e
            android.os.Handler r3 = r12.a
            R2 r5 = new R2
            r5.<init>(r12)
            r6 = 500(0x1f4, double:2.47E-321)
            r3.postDelayed(r5, r6)
            lc r3 = new lc
            r3.<init>()
            androidx.fragment.app.FragmentManager r5 = r12.getParentFragmentManager()
            java.lang.String r6 = "androidx.biometric.FingerprintDialogFragment"
            r3.show((androidx.fragment.app.FragmentManager) r5, (java.lang.String) r6)
        L_0x008e:
            androidx.biometric.j r3 = r12.f1290a
            r3.a = r4
            androidx.biometric.BiometricPrompt$c r4 = r3.f1295a
            if (r4 != 0) goto L_0x0097
            goto L_0x00b6
        L_0x0097:
            javax.crypto.Cipher r5 = r4.f1286a
            if (r5 == 0) goto L_0x00a1
            pc$c r4 = new pc$c
            r4.<init>((javax.crypto.Cipher) r5)
            goto L_0x00b7
        L_0x00a1:
            java.security.Signature r5 = r4.f1285a
            if (r5 == 0) goto L_0x00ab
            pc$c r4 = new pc$c
            r4.<init>((java.security.Signature) r5)
            goto L_0x00b7
        L_0x00ab:
            javax.crypto.Mac r4 = r4.f1287a
            if (r4 == 0) goto L_0x00b6
            pc$c r5 = new pc$c
            r5.<init>((javax.crypto.Mac) r4)
            r4 = r5
            goto L_0x00b7
        L_0x00b6:
            r4 = r2
        L_0x00b7:
            B4 r5 = r3.f1293a
            if (r5 != 0) goto L_0x00c2
            B4 r5 = new B4
            r5.<init>()
            r3.f1293a = r5
        L_0x00c2:
            B4 r3 = r3.f1293a
            A4 r5 = r3.a
            if (r5 != 0) goto L_0x00d4
            B4$a r5 = r3.f40a
            r5.getClass()
            A4 r5 = new A4
            r5.<init>()
            r3.a = r5
        L_0x00d4:
            A4 r3 = r3.a
            androidx.biometric.j r5 = r12.f1290a
            androidx.biometric.b r6 = r5.f1297a
            if (r6 != 0) goto L_0x00e8
            androidx.biometric.b r6 = new androidx.biometric.b
            androidx.biometric.j$a r7 = new androidx.biometric.j$a
            r7.<init>(r5)
            r6.<init>(r7)
            r5.f1297a = r6
        L_0x00e8:
            androidx.biometric.b r5 = r5.f1297a
            androidx.biometric.a r6 = r5.f1288a
            if (r6 != 0) goto L_0x00f5
            androidx.biometric.a r6 = new androidx.biometric.a
            r6.<init>(r5)
            r5.f1288a = r6
        L_0x00f5:
            androidx.biometric.a r5 = r5.f1288a
            r9 = 0
            r11 = 0
            if (r3 == 0) goto L_0x0115
            monitor-enter(r3)     // Catch:{ NullPointerException -> 0x012a }
            android.os.CancellationSignal r2 = r3.f1a     // Catch:{ all -> 0x0112 }
            if (r2 != 0) goto L_0x010e
            android.os.CancellationSignal r2 = new android.os.CancellationSignal     // Catch:{ all -> 0x0112 }
            r2.<init>()     // Catch:{ all -> 0x0112 }
            r3.f1a = r2     // Catch:{ all -> 0x0112 }
            boolean r6 = r3.f2a     // Catch:{ all -> 0x0112 }
            if (r6 == 0) goto L_0x010e
            r2.cancel()     // Catch:{ all -> 0x0112 }
        L_0x010e:
            android.os.CancellationSignal r2 = r3.f1a     // Catch:{ all -> 0x0112 }
            monitor-exit(r3)     // Catch:{ all -> 0x0112 }
            goto L_0x0115
        L_0x0112:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0112 }
            throw r2     // Catch:{ NullPointerException -> 0x012a }
        L_0x0115:
            r8 = r2
            android.hardware.fingerprint.FingerprintManager r6 = defpackage.C0296pc.a.c(r0)     // Catch:{ NullPointerException -> 0x012a }
            if (r6 == 0) goto L_0x0211
            android.hardware.fingerprint.FingerprintManager$CryptoObject r7 = defpackage.C0296pc.a.g(r4)     // Catch:{ NullPointerException -> 0x012a }
            oc r10 = new oc     // Catch:{ NullPointerException -> 0x012a }
            r10.<init>(r5)     // Catch:{ NullPointerException -> 0x012a }
            defpackage.C0296pc.a.a(r6, r7, r8, r9, r10, r11)     // Catch:{ NullPointerException -> 0x012a }
            goto L_0x0211
        L_0x012a:
            java.lang.String r0 = defpackage.C1354qp.O(r0, r1)
            r12.k(r1, r0)
            goto L_0x0211
        L_0x0133:
            android.content.Context r0 = r12.requireContext()
            android.content.Context r0 = r0.getApplicationContext()
            android.hardware.biometrics.BiometricPrompt$Builder r0 = androidx.biometric.d.c.d(r0)
            androidx.biometric.j r3 = r12.f1290a
            androidx.biometric.BiometricPrompt$d r4 = r3.f1296a
            if (r4 == 0) goto L_0x0147
            java.lang.CharSequence r2 = r4.a
        L_0x0147:
            r3.getClass()
            androidx.biometric.j r3 = r12.f1290a
            r3.getClass()
            if (r2 == 0) goto L_0x0154
            androidx.biometric.d.c.f(r0, r2)
        L_0x0154:
            androidx.biometric.j r2 = r12.f1290a
            java.lang.CharSequence r2 = r2.d()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x017e
            androidx.biometric.j r3 = r12.f1290a
            java.util.concurrent.Executor r3 = r3.f1301a
            if (r3 == 0) goto L_0x0167
            goto L_0x016c
        L_0x0167:
            androidx.biometric.j$b r3 = new androidx.biometric.j$b
            r3.<init>()
        L_0x016c:
            androidx.biometric.j r4 = r12.f1290a
            androidx.biometric.j$c r5 = r4.f1298a
            if (r5 != 0) goto L_0x0179
            androidx.biometric.j$c r5 = new androidx.biometric.j$c
            r5.<init>(r4)
            r4.f1298a = r5
        L_0x0179:
            androidx.biometric.j$c r4 = r4.f1298a
            androidx.biometric.d.c.e(r0, r2, r3, r4)
        L_0x017e:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r2 < r3) goto L_0x018b
            androidx.biometric.j r4 = r12.f1290a
            androidx.biometric.BiometricPrompt$d r4 = r4.f1296a
            androidx.biometric.d.C0004d.a(r0, r1)
        L_0x018b:
            androidx.biometric.j r4 = r12.f1290a
            int r4 = r4.c()
            r5 = 30
            if (r2 < r5) goto L_0x0199
            androidx.biometric.d.e.a(r0, r4)
            goto L_0x01a2
        L_0x0199:
            if (r2 < r3) goto L_0x01a2
            boolean r2 = androidx.biometric.c.a(r4)
            androidx.biometric.d.C0004d.b(r0, r2)
        L_0x01a2:
            android.hardware.biometrics.BiometricPrompt r0 = androidx.biometric.d.c.c(r0)
            android.content.Context r2 = r12.getContext()
            androidx.biometric.j r3 = r12.f1290a
            androidx.biometric.BiometricPrompt$c r3 = r3.f1295a
            android.hardware.biometrics.BiometricPrompt$CryptoObject r3 = androidx.biometric.k.b(r3)
            androidx.biometric.j r4 = r12.f1290a
            B4 r5 = r4.f1293a
            if (r5 != 0) goto L_0x01bf
            B4 r5 = new B4
            r5.<init>()
            r4.f1293a = r5
        L_0x01bf:
            B4 r4 = r4.f1293a
            android.os.CancellationSignal r5 = r4.f41a
            if (r5 != 0) goto L_0x01d0
            B4$a r5 = r4.f40a
            r5.getClass()
            android.os.CancellationSignal r5 = defpackage.B4.b.b()
            r4.f41a = r5
        L_0x01d0:
            android.os.CancellationSignal r4 = r4.f41a
            androidx.biometric.d$f r5 = new androidx.biometric.d$f
            r5.<init>()
            androidx.biometric.j r6 = r12.f1290a
            androidx.biometric.b r7 = r6.f1297a
            if (r7 != 0) goto L_0x01e9
            androidx.biometric.b r7 = new androidx.biometric.b
            androidx.biometric.j$a r8 = new androidx.biometric.j$a
            r8.<init>(r6)
            r7.<init>(r8)
            r6.f1297a = r7
        L_0x01e9:
            androidx.biometric.b r6 = r6.f1297a
            android.hardware.biometrics.BiometricPrompt$AuthenticationCallback r7 = r6.a
            if (r7 != 0) goto L_0x01f7
            androidx.biometric.b$c r7 = r6.f1289a
            android.hardware.biometrics.BiometricPrompt$AuthenticationCallback r7 = androidx.biometric.b.a.a(r7)
            r6.a = r7
        L_0x01f7:
            android.hardware.biometrics.BiometricPrompt$AuthenticationCallback r6 = r6.a
            if (r3 != 0) goto L_0x01ff
            androidx.biometric.d.c.b(r0, r4, r5, r6)     // Catch:{ NullPointerException -> 0x0203 }
            goto L_0x0211
        L_0x01ff:
            androidx.biometric.d.c.a(r0, r3, r4, r5, r6)     // Catch:{ NullPointerException -> 0x0203 }
            goto L_0x0211
        L_0x0203:
            if (r2 == 0) goto L_0x020c
            int r0 = defpackage.Wr.default_error_msg
            java.lang.String r0 = r2.getString(r0)
            goto L_0x020e
        L_0x020c:
            java.lang.String r0 = ""
        L_0x020e:
            r12.k(r1, r0)
        L_0x0211:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.biometric.d.n():void");
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            j jVar = this.f1290a;
            jVar.f1305d = false;
            if (i3 == -1) {
                BiometricPrompt.b bVar = new BiometricPrompt.b((BiometricPrompt.c) null, 1);
                if (jVar.f1304c) {
                    jVar.f1304c = false;
                    Executor executor = jVar.f1301a;
                    if (executor == null) {
                        executor = new j.b();
                    }
                    executor.execute(new g(this, bVar));
                }
                dismiss();
                return;
            }
            k(10, getString(Wr.generic_error_user_canceled));
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            j jVar = (j) new ViewModelProvider(getActivity()).a(j.class);
            this.f1290a = jVar;
            if (jVar.f1299a == null) {
                jVar.f1299a = new MutableLiveData<>();
            }
            jVar.f1299a.d(this, new f(this));
            j jVar2 = this.f1290a;
            if (jVar2.f1302b == null) {
                jVar2.f1302b = new MutableLiveData<>();
            }
            jVar2.f1302b.d(this, new M2(this));
            j jVar3 = this.f1290a;
            if (jVar3.c == null) {
                jVar3.c = new MutableLiveData<>();
            }
            jVar3.c.d(this, new N2(this));
            j jVar4 = this.f1290a;
            if (jVar4.d == null) {
                jVar4.d = new MutableLiveData<>();
            }
            jVar4.d.d(this, new O2(this));
            j jVar5 = this.f1290a;
            if (jVar5.e == null) {
                jVar5.e = new MutableLiveData<>();
            }
            jVar5.e.d(this, new P2(this));
            j jVar6 = this.f1290a;
            if (jVar6.f == null) {
                jVar6.f = new MutableLiveData<>();
            }
            jVar6.f.d(this, new Q2(this));
        }
    }

    public final void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT == 29 && c.a(this.f1290a.c())) {
            j jVar = this.f1290a;
            jVar.f1307f = true;
            this.a.postDelayed(new i(jVar), 250);
        }
    }

    public final void onStop() {
        boolean z;
        super.onStop();
        if (Build.VERSION.SDK_INT < 29 && !this.f1290a.f1305d) {
            FragmentActivity activity = getActivity();
            if (activity == null || !activity.isChangingConfigurations()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                f(0);
            }
        }
    }
}
