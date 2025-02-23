package defpackage;

import defpackage.C1364r7;

/* renamed from: C0  reason: default package */
/* compiled from: AndroidExceptionPreHandler.kt */
public final class C0 extends C1232l implements C1364r7 {
    private volatile Object _preHandler = this;

    public C0() {
        super(C1364r7.a.a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r1 != false) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n(kotlin.coroutines.CoroutineContext r6, java.lang.Throwable r7) {
        /*
            r5 = this;
            int r6 = android.os.Build.VERSION.SDK_INT
            r0 = 28
            r1 = 1
            r2 = 0
            if (r6 >= r0) goto L_0x000a
            r6 = r1
            goto L_0x000b
        L_0x000a:
            r6 = r2
        L_0x000b:
            if (r6 == 0) goto L_0x0055
            java.lang.Object r6 = r5._preHandler
            r0 = 0
            if (r6 == r5) goto L_0x0015
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            goto L_0x003b
        L_0x0015:
            java.lang.Class<java.lang.Thread> r6 = java.lang.Thread.class
            java.lang.String r3 = "getUncaughtExceptionPreHandler"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ all -> 0x0038 }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r3, r4)     // Catch:{ all -> 0x0038 }
            int r3 = r6.getModifiers()     // Catch:{ all -> 0x0038 }
            boolean r3 = java.lang.reflect.Modifier.isPublic(r3)     // Catch:{ all -> 0x0038 }
            if (r3 == 0) goto L_0x0034
            int r3 = r6.getModifiers()     // Catch:{ all -> 0x0038 }
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)     // Catch:{ all -> 0x0038 }
            if (r3 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r1 = r2
        L_0x0035:
            if (r1 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r6 = r0
        L_0x0039:
            r5._preHandler = r6
        L_0x003b:
            if (r6 == 0) goto L_0x0044
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.Object r6 = r6.invoke(r0, r1)
            goto L_0x0045
        L_0x0044:
            r6 = r0
        L_0x0045:
            boolean r1 = r6 instanceof java.lang.Thread.UncaughtExceptionHandler
            if (r1 == 0) goto L_0x004c
            r0 = r6
            java.lang.Thread$UncaughtExceptionHandler r0 = (java.lang.Thread.UncaughtExceptionHandler) r0
        L_0x004c:
            if (r0 == 0) goto L_0x0055
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r0.uncaughtException(r6, r7)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0.n(kotlin.coroutines.CoroutineContext, java.lang.Throwable):void");
    }
}
