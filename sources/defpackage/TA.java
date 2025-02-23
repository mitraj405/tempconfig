package defpackage;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import androidx.collection.LruCache;
import defpackage.Et;

/* renamed from: TA  reason: default package */
/* compiled from: TypefaceCompat */
public final class TA {
    public static final ZA a;

    /* renamed from: a  reason: collision with other field name */
    public static final LruCache<String, Typeface> f546a = new LruCache<>(16);

    /* renamed from: TA$a */
    /* compiled from: TypefaceCompat */
    public static class a extends r1 {
        public final Et.e a;

        public a(Et.e eVar) {
            this.a = eVar;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            a = new XA();
        } else if (i >= 28) {
            a = new WA();
        } else {
            a = new VA();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r0.equals(r4) == false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface a(android.content.Context r7, defpackage.C0180ed.b r8, android.content.res.Resources r9, int r10, java.lang.String r11, int r12, int r13, defpackage.Et.e r14, boolean r15) {
        /*
            boolean r0 = r8 instanceof defpackage.C0180ed.e
            r1 = 0
            r2 = -3
            if (r0 == 0) goto L_0x0143
            ed$e r8 = (defpackage.C0180ed.e) r8
            java.lang.String r0 = r8.f2887a
            r3 = 0
            if (r0 == 0) goto L_0x0027
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x0014
            goto L_0x0027
        L_0x0014:
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r3)
            android.graphics.Typeface r4 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r4, r3)
            if (r0 == 0) goto L_0x0027
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x0030
            if (r14 == 0) goto L_0x002f
            r14.callbackSuccessAsync(r0, r1)
        L_0x002f:
            return r0
        L_0x0030:
            if (r15 == 0) goto L_0x0037
            int r0 = r8.b
            if (r0 != 0) goto L_0x003a
            goto L_0x0039
        L_0x0037:
            if (r14 != 0) goto L_0x003a
        L_0x0039:
            r3 = 1
        L_0x003a:
            r0 = -1
            if (r15 == 0) goto L_0x0040
            int r15 = r8.a
            goto L_0x0041
        L_0x0040:
            r15 = r0
        L_0x0041:
            android.os.Handler r4 = defpackage.Et.e.getHandler(r1)
            TA$a r5 = new TA$a
            r5.<init>(r14)
            Yc r8 = r8.f2886a
            K3 r14 = new K3
            r14.<init>(r5, r4)
            if (r3 == 0) goto L_0x00c7
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r3 = defpackage.C0169dd.a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r8.d
            r3.append(r6)
            java.lang.String r6 = "-"
            r3.append(r6)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r6 = defpackage.C0169dd.a
            java.lang.Object r6 = r6.get(r3)
            android.graphics.Typeface r6 = (android.graphics.Typeface) r6
            if (r6 == 0) goto L_0x0080
            I3 r7 = new I3
            r7.<init>(r5, r6)
            r4.post(r7)
            r1 = r6
            goto L_0x0157
        L_0x0080:
            if (r15 != r0) goto L_0x008d
            dd$a r7 = defpackage.C0169dd.a(r3, r7, r8, r13)
            r14.a(r7)
            android.graphics.Typeface r1 = r7.f2872a
            goto L_0x0157
        L_0x008d:
            Zc r0 = new Zc
            r0.<init>(r3, r7, r8, r13)
            java.util.concurrent.ThreadPoolExecutor r7 = defpackage.C0169dd.f2871a     // Catch:{ InterruptedException -> 0x00b9 }
            java.util.concurrent.Future r7 = r7.submit(r0)     // Catch:{ InterruptedException -> 0x00b9 }
            long r3 = (long) r15
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException -> 0x00b2, InterruptedException -> 0x00b0, TimeoutException -> 0x00a8 }
            java.lang.Object r7 = r7.get(r3, r8)     // Catch:{ ExecutionException -> 0x00b2, InterruptedException -> 0x00b0, TimeoutException -> 0x00a8 }
            dd$a r7 = (defpackage.C0169dd.a) r7     // Catch:{ InterruptedException -> 0x00b9 }
            r14.a(r7)     // Catch:{ InterruptedException -> 0x00b9 }
            android.graphics.Typeface r1 = r7.f2872a     // Catch:{ InterruptedException -> 0x00b9 }
            goto L_0x0157
        L_0x00a8:
            java.lang.InterruptedException r7 = new java.lang.InterruptedException     // Catch:{ InterruptedException -> 0x00b9 }
            java.lang.String r8 = "timeout"
            r7.<init>(r8)     // Catch:{ InterruptedException -> 0x00b9 }
            throw r7     // Catch:{ InterruptedException -> 0x00b9 }
        L_0x00b0:
            r7 = move-exception
            throw r7     // Catch:{ InterruptedException -> 0x00b9 }
        L_0x00b2:
            r7 = move-exception
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ InterruptedException -> 0x00b9 }
            r8.<init>(r7)     // Catch:{ InterruptedException -> 0x00b9 }
            throw r8     // Catch:{ InterruptedException -> 0x00b9 }
        L_0x00b9:
            J3 r7 = new J3
            r1 r8 = r14.f332a
            r7.<init>(r8, r2)
            android.os.Handler r8 = r14.a
            r8.post(r7)
            goto L_0x0157
        L_0x00c7:
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r15 = defpackage.C0169dd.a
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = r8.d
            r15.append(r0)
            java.lang.String r0 = "-"
            r15.append(r0)
            r15.append(r13)
            java.lang.String r15 = r15.toString()
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r0 = defpackage.C0169dd.a
            java.lang.Object r0 = r0.get(r15)
            android.graphics.Typeface r0 = (android.graphics.Typeface) r0
            if (r0 == 0) goto L_0x00f3
            I3 r7 = new I3
            r7.<init>(r5, r0)
            r4.post(r7)
            r1 = r0
            goto L_0x0157
        L_0x00f3:
            ad r0 = new ad
            r0.<init>(r14)
            java.lang.Object r3 = defpackage.C0169dd.f2870a
            monitor-enter(r3)
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<U6<dd$a>>> r14 = defpackage.C0169dd.f2869a     // Catch:{ all -> 0x0140 }
            java.lang.Object r2 = r14.getOrDefault(r15, r1)     // Catch:{ all -> 0x0140 }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x0140 }
            if (r2 == 0) goto L_0x010a
            r2.add(r0)     // Catch:{ all -> 0x0140 }
            monitor-exit(r3)     // Catch:{ all -> 0x0140 }
            goto L_0x0157
        L_0x010a:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0140 }
            r2.<init>()     // Catch:{ all -> 0x0140 }
            r2.add(r0)     // Catch:{ all -> 0x0140 }
            r14.put(r15, r2)     // Catch:{ all -> 0x0140 }
            monitor-exit(r3)     // Catch:{ all -> 0x0140 }
            bd r14 = new bd
            r14.<init>(r15, r7, r8, r13)
            java.util.concurrent.ThreadPoolExecutor r7 = defpackage.C0169dd.f2871a
            cd r8 = new cd
            r8.<init>(r15)
            android.os.Looper r15 = android.os.Looper.myLooper()
            if (r15 != 0) goto L_0x0132
            android.os.Handler r15 = new android.os.Handler
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r15.<init>(r0)
            goto L_0x0137
        L_0x0132:
            android.os.Handler r15 = new android.os.Handler
            r15.<init>()
        L_0x0137:
            zt r0 = new zt
            r0.<init>(r15, r14, r8)
            r7.execute(r0)
            goto L_0x0157
        L_0x0140:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0140 }
            throw r7
        L_0x0143:
            ZA r15 = a
            ed$c r8 = (defpackage.C0180ed.c) r8
            android.graphics.Typeface r7 = r15.a(r7, r8, r9, r13)
            if (r14 == 0) goto L_0x0156
            if (r7 == 0) goto L_0x0153
            r14.callbackSuccessAsync(r7, r1)
            goto L_0x0156
        L_0x0153:
            r14.callbackFailAsync(r2, r1)
        L_0x0156:
            r1 = r7
        L_0x0157:
            if (r1 == 0) goto L_0x0162
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r7 = f546a
            java.lang.String r8 = b(r9, r10, r11, r12, r13)
            r7.put(r8, r1)
        L_0x0162:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.TA.a(android.content.Context, ed$b, android.content.res.Resources, int, java.lang.String, int, int, Et$e, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }
}
