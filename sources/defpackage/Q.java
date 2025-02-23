package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: Q  reason: default package */
/* compiled from: ActivityRecreator */
public final class Q {
    public static final Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    public static final Class<?> f482a;

    /* renamed from: a  reason: collision with other field name */
    public static final Field f483a;

    /* renamed from: a  reason: collision with other field name */
    public static final Method f484a;
    public static final Field b;

    /* renamed from: b  reason: collision with other field name */
    public static final Method f485b;
    public static final Method c;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[SYNTHETIC, Splitter:B:23:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007c  */
    static {
        /*
            java.lang.Class<android.app.Activity> r0 = android.app.Activity.class
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            a = r1
            r1 = 0
            java.lang.String r2 = "android.app.ActivityThread"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0015 }
            goto L_0x0016
        L_0x0015:
            r2 = r1
        L_0x0016:
            f482a = r2
            r2 = 1
            java.lang.String r3 = "mMainThread"
            java.lang.reflect.Field r3 = r0.getDeclaredField(r3)     // Catch:{ all -> 0x0023 }
            r3.setAccessible(r2)     // Catch:{ all -> 0x0023 }
            goto L_0x0024
        L_0x0023:
            r3 = r1
        L_0x0024:
            f483a = r3
            java.lang.String r3 = "mToken"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r3)     // Catch:{ all -> 0x0030 }
            r0.setAccessible(r2)     // Catch:{ all -> 0x0030 }
            goto L_0x0031
        L_0x0030:
            r0 = r1
        L_0x0031:
            b = r0
            java.lang.Class<?> r0 = f482a
            r3 = 0
            r4 = 3
            java.lang.String r5 = "performStopActivity"
            r6 = 2
            java.lang.Class<android.os.IBinder> r7 = android.os.IBinder.class
            if (r0 != 0) goto L_0x003f
            goto L_0x0053
        L_0x003f:
            java.lang.Class[] r8 = new java.lang.Class[r4]     // Catch:{ all -> 0x0053 }
            r8[r3] = r7     // Catch:{ all -> 0x0053 }
            java.lang.Class r9 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0053 }
            r8[r2] = r9     // Catch:{ all -> 0x0053 }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r8[r6] = r9     // Catch:{ all -> 0x0053 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r5, r8)     // Catch:{ all -> 0x0053 }
            r0.setAccessible(r2)     // Catch:{ all -> 0x0053 }
            goto L_0x0054
        L_0x0053:
            r0 = r1
        L_0x0054:
            f484a = r0
            java.lang.Class<?> r0 = f482a
            if (r0 != 0) goto L_0x005b
            goto L_0x006b
        L_0x005b:
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch:{ all -> 0x006b }
            r8[r3] = r7     // Catch:{ all -> 0x006b }
            java.lang.Class r9 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x006b }
            r8[r2] = r9     // Catch:{ all -> 0x006b }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r5, r8)     // Catch:{ all -> 0x006b }
            r0.setAccessible(r2)     // Catch:{ all -> 0x006b }
            goto L_0x006c
        L_0x006b:
            r0 = r1
        L_0x006c:
            f485b = r0
            java.lang.Class<?> r0 = f482a
            java.lang.Class<android.content.res.Configuration> r5 = android.content.res.Configuration.class
            java.lang.Class<java.util.List> r8 = java.util.List.class
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 27
            if (r9 != r10) goto L_0x007c
            r9 = r2
            goto L_0x007d
        L_0x007c:
            r9 = r3
        L_0x007d:
            if (r9 == 0) goto L_0x00ac
            if (r0 != 0) goto L_0x0082
            goto L_0x00ac
        L_0x0082:
            java.lang.String r9 = "requestRelaunchActivity"
            r10 = 9
            java.lang.Class[] r10 = new java.lang.Class[r10]     // Catch:{ all -> 0x00ac }
            r10[r3] = r7     // Catch:{ all -> 0x00ac }
            r10[r2] = r8     // Catch:{ all -> 0x00ac }
            r10[r6] = r8     // Catch:{ all -> 0x00ac }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00ac }
            r10[r4] = r3     // Catch:{ all -> 0x00ac }
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00ac }
            r4 = 4
            r10[r4] = r3     // Catch:{ all -> 0x00ac }
            r4 = 5
            r10[r4] = r5     // Catch:{ all -> 0x00ac }
            r4 = 6
            r10[r4] = r5     // Catch:{ all -> 0x00ac }
            r4 = 7
            r10[r4] = r3     // Catch:{ all -> 0x00ac }
            r4 = 8
            r10[r4] = r3     // Catch:{ all -> 0x00ac }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r9, r10)     // Catch:{ all -> 0x00ac }
            r0.setAccessible(r2)     // Catch:{ all -> 0x00ac }
            r1 = r0
        L_0x00ac:
            c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Q.<clinit>():void");
    }

    /* renamed from: Q$a */
    /* compiled from: ActivityRecreator */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        public Activity a;

        /* renamed from: a  reason: collision with other field name */
        public Object f486a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f487a = false;
        public boolean b = false;
        public final int c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f488c = false;

        public a(Activity activity) {
            this.a = activity;
            this.c = activity.hashCode();
        }

        public final void onActivityDestroyed(Activity activity) {
            if (this.a == activity) {
                this.a = null;
                this.b = true;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onActivityPaused(android.app.Activity r5) {
            /*
                r4 = this;
                boolean r0 = r4.b
                if (r0 == 0) goto L_0x003a
                boolean r0 = r4.f488c
                if (r0 != 0) goto L_0x003a
                boolean r0 = r4.f487a
                if (r0 != 0) goto L_0x003a
                java.lang.Object r0 = r4.f486a
                r1 = 1
                java.lang.reflect.Field r2 = defpackage.Q.b     // Catch:{ all -> 0x0032 }
                java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x0032 }
                if (r2 != r0) goto L_0x0032
                int r0 = r5.hashCode()     // Catch:{ all -> 0x0032 }
                int r3 = r4.c
                if (r0 == r3) goto L_0x0020
                goto L_0x0032
            L_0x0020:
                java.lang.reflect.Field r0 = defpackage.Q.f483a     // Catch:{ all -> 0x0032 }
                java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x0032 }
                android.os.Handler r0 = defpackage.Q.a     // Catch:{ all -> 0x0032 }
                P r3 = new P     // Catch:{ all -> 0x0032 }
                r3.<init>(r5, r2)     // Catch:{ all -> 0x0032 }
                r0.postAtFrontOfQueue(r3)     // Catch:{ all -> 0x0032 }
                r5 = r1
                goto L_0x0033
            L_0x0032:
                r5 = 0
            L_0x0033:
                if (r5 == 0) goto L_0x003a
                r4.f488c = r1
                r5 = 0
                r4.f486a = r5
            L_0x003a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.Q.a.onActivityPaused(android.app.Activity):void");
        }

        public final void onActivityStarted(Activity activity) {
            if (this.a == activity) {
                this.f487a = true;
            }
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
