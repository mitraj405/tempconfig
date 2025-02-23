package androidx.biometric;

import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import defpackage.C0296pc;
import java.lang.reflect.Method;

/* compiled from: BiometricManager */
public final class h {
    public final BiometricManager a;

    /* renamed from: a  reason: collision with other field name */
    public final d f1291a;

    /* renamed from: a  reason: collision with other field name */
    public final C0296pc f1292a;

    /* compiled from: BiometricManager */
    public static class a {
        public static int a(BiometricManager biometricManager) {
            return biometricManager.canAuthenticate();
        }

        public static BiometricManager b(Context context) {
            return (BiometricManager) context.getSystemService(BiometricManager.class);
        }

        public static Method c() {
            try {
                return BiometricManager.class.getMethod("canAuthenticate", new Class[]{BiometricPrompt.CryptoObject.class});
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }

    /* compiled from: BiometricManager */
    public static class b {
        public static int a(BiometricManager biometricManager, int i) {
            return biometricManager.canAuthenticate(i);
        }
    }

    /* compiled from: BiometricManager */
    public static class c implements d {
        public final Context a;

        public c(Context context) {
            this.a = context.getApplicationContext();
        }
    }

    /* compiled from: BiometricManager */
    public interface d {
    }

    public h(c cVar) {
        BiometricManager biometricManager;
        this.f1291a = cVar;
        int i = Build.VERSION.SDK_INT;
        Context context = cVar.a;
        C0296pc pcVar = null;
        if (i >= 29) {
            biometricManager = a.b(context);
        } else {
            biometricManager = null;
        }
        this.a = biometricManager;
        this.f1292a = i <= 29 ? new C0296pc(context) : pcVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c2, code lost:
        if (b() == 0) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00fc, code lost:
        if (b() == 0) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(int r10) {
        /*
            r9 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            android.hardware.biometrics.BiometricManager r1 = r9.a
            r2 = 1
            r3 = 30
            if (r0 < r3) goto L_0x0011
            if (r1 != 0) goto L_0x000c
            return r2
        L_0x000c:
            int r10 = androidx.biometric.h.b.a(r1, r10)
            return r10
        L_0x0011:
            boolean r4 = androidx.biometric.c.b(r10)
            if (r4 != 0) goto L_0x001a
            r10 = -2
            goto L_0x0107
        L_0x001a:
            if (r10 != 0) goto L_0x001e
            goto L_0x0100
        L_0x001e:
            androidx.biometric.h$d r4 = r9.f1291a
            r5 = r4
            androidx.biometric.h$c r5 = (androidx.biometric.h.c) r5
            android.content.Context r6 = r5.a
            android.app.KeyguardManager r6 = defpackage.Fh.a(r6)
            r7 = 0
            if (r6 == 0) goto L_0x002e
            r6 = r2
            goto L_0x002f
        L_0x002e:
            r6 = r7
        L_0x002f:
            if (r6 != 0) goto L_0x0033
            goto L_0x0100
        L_0x0033:
            boolean r6 = androidx.biometric.c.a(r10)
            android.content.Context r5 = r5.a
            if (r6 == 0) goto L_0x0050
            android.app.KeyguardManager r10 = defpackage.Fh.a(r5)
            if (r10 != 0) goto L_0x0043
            r10 = r7
            goto L_0x0047
        L_0x0043:
            boolean r10 = defpackage.Fh.b(r10)
        L_0x0047:
            if (r10 == 0) goto L_0x004c
        L_0x0049:
            r10 = r7
            goto L_0x0107
        L_0x004c:
            r10 = 11
            goto L_0x0107
        L_0x0050:
            r6 = 29
            r8 = -1
            if (r0 != r6) goto L_0x00c7
            r0 = 255(0xff, float:3.57E-43)
            r10 = r10 & r0
            if (r10 != r0) goto L_0x005c
            r10 = r2
            goto L_0x005d
        L_0x005c:
            r10 = r7
        L_0x005d:
            if (r10 == 0) goto L_0x0069
            if (r1 != 0) goto L_0x0062
            goto L_0x0066
        L_0x0062:
            int r2 = androidx.biometric.h.a.a(r1)
        L_0x0066:
            r10 = r2
            goto L_0x0107
        L_0x0069:
            java.lang.reflect.Method r10 = androidx.biometric.h.a.c()
            if (r10 == 0) goto L_0x008d
            androidx.biometric.BiometricPrompt$c r0 = androidx.biometric.k.a()
            android.hardware.biometrics.BiometricPrompt$CryptoObject r0 = androidx.biometric.k.b(r0)
            if (r0 == 0) goto L_0x008d
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x008d }
            r6[r7] = r0     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x008d }
            java.lang.Object r10 = r10.invoke(r1, r6)     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x008d }
            boolean r0 = r10 instanceof java.lang.Integer     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x008d }
            if (r0 == 0) goto L_0x008d
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x008d }
            int r10 = r10.intValue()     // Catch:{ IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x008d }
            goto L_0x0107
        L_0x008d:
            if (r1 != 0) goto L_0x0090
            goto L_0x0094
        L_0x0090:
            int r2 = androidx.biometric.h.a.a(r1)
        L_0x0094:
            java.lang.String r10 = android.os.Build.MODEL
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x009c
            r10 = r7
            goto L_0x00a2
        L_0x009c:
            int r0 = defpackage.Zq.assume_strong_biometrics_models
            boolean r10 = defpackage.R8.a(r5, r0, r10)
        L_0x00a2:
            if (r10 != 0) goto L_0x0066
            if (r2 == 0) goto L_0x00a7
            goto L_0x0066
        L_0x00a7:
            androidx.biometric.h$c r4 = (androidx.biometric.h.c) r4
            android.content.Context r10 = r4.a
            android.app.KeyguardManager r10 = defpackage.Fh.a(r10)
            if (r10 != 0) goto L_0x00b3
            r10 = r7
            goto L_0x00b7
        L_0x00b3:
            boolean r10 = defpackage.Fh.b(r10)
        L_0x00b7:
            if (r10 != 0) goto L_0x00be
            int r10 = r9.b()
            goto L_0x0107
        L_0x00be:
            int r10 = r9.b()
            if (r10 != 0) goto L_0x00c5
            goto L_0x0049
        L_0x00c5:
            r7 = r8
            goto L_0x0049
        L_0x00c7:
            r10 = 28
            if (r0 != r10) goto L_0x0103
            if (r5 == 0) goto L_0x00de
            android.content.pm.PackageManager r10 = r5.getPackageManager()
            if (r10 == 0) goto L_0x00de
            android.content.pm.PackageManager r10 = r5.getPackageManager()
            boolean r10 = defpackage.yo.a(r10)
            if (r10 == 0) goto L_0x00de
            goto L_0x00df
        L_0x00de:
            r2 = r7
        L_0x00df:
            if (r2 == 0) goto L_0x0100
            androidx.biometric.h$c r4 = (androidx.biometric.h.c) r4
            android.content.Context r10 = r4.a
            android.app.KeyguardManager r10 = defpackage.Fh.a(r10)
            if (r10 != 0) goto L_0x00ed
            r10 = r7
            goto L_0x00f1
        L_0x00ed:
            boolean r10 = defpackage.Fh.b(r10)
        L_0x00f1:
            if (r10 != 0) goto L_0x00f8
            int r10 = r9.b()
            goto L_0x0107
        L_0x00f8:
            int r10 = r9.b()
            if (r10 != 0) goto L_0x00c5
            goto L_0x0049
        L_0x0100:
            r10 = 12
            goto L_0x0107
        L_0x0103:
            int r10 = r9.b()
        L_0x0107:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.biometric.h.a(int):int");
    }

    public final int b() {
        boolean z;
        boolean z2 = true;
        C0296pc pcVar = this.f1292a;
        if (pcVar == null) {
            return 1;
        }
        Context context = pcVar.a;
        FingerprintManager c2 = C0296pc.a.c(context);
        if (c2 == null || !C0296pc.a.e(c2)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return 12;
        }
        FingerprintManager c3 = C0296pc.a.c(context);
        if (c3 == null || !C0296pc.a.d(c3)) {
            z2 = false;
        }
        if (!z2) {
            return 11;
        }
        return 0;
    }
}
