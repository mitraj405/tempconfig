package defpackage;

/* renamed from: b6  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0140b6 implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ C0140b6(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x017a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            int r0 = r13.c
            r1 = 0
            r2 = 1
            r3 = 0
            switch(r0) {
                case 0: goto L_0x018c;
                case 1: goto L_0x017e;
                case 2: goto L_0x00d6;
                case 3: goto L_0x00c2;
                case 4: goto L_0x0098;
                case 5: goto L_0x003a;
                case 6: goto L_0x0008;
                case 7: goto L_0x0032;
                case 8: goto L_0x002a;
                case 9: goto L_0x0022;
                case 10: goto L_0x001a;
                case 11: goto L_0x0012;
                case 12: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0194
        L_0x000a:
            java.lang.Object r0 = r13.a
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            in.juspay.hypersdk.analytics.LogSessioniser.lambda$sessioniseLogs$5(r0)
            return
        L_0x0012:
            java.lang.Object r0 = r13.a
            java.util.Queue r0 = (java.util.Queue) r0
            in.juspay.hypersdk.analytics.LogPusher.lambda$addLogsFromSessioniser$4(r0)
            return
        L_0x001a:
            java.lang.Object r0 = r13.a
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            in.juspay.hypersdk.analytics.LogPusher.lambda$addLogLines$5(r0)
            return
        L_0x0022:
            java.lang.Object r0 = r13.a
            in.juspay.hypernfc.NfcActivity r0 = (in.juspay.hypernfc.NfcActivity) r0
            r0.lambda$onNewIntent$1()
            return
        L_0x002a:
            java.lang.Object r0 = r13.a
            cris.org.in.ima.activities.LoginActivity r0 = (cris.org.in.ima.activities.LoginActivity) r0
            cris.org.in.ima.activities.LoginActivity.l(r0)
            return
        L_0x0032:
            java.lang.Object r0 = r13.a
            com.google.firebase.perf.metrics.AppStartTrace r0 = (com.google.firebase.perf.metrics.AppStartTrace) r0
            r0.recordOnDrawFrontOfQueue()
            return
        L_0x003a:
            java.lang.Object r0 = r13.a
            Mj r0 = (defpackage.Mj) r0
            Lj<T> r1 = r0.f407a
            if (r1 != 0) goto L_0x0043
            goto L_0x0094
        L_0x0043:
            V r2 = r1.a
            if (r2 == 0) goto L_0x0068
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0065 }
            java.util.LinkedHashSet r3 = r0.f409a     // Catch:{ all -> 0x0065 }
            r1.<init>(r3)     // Catch:{ all -> 0x0065 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0065 }
        L_0x0053:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0065 }
            if (r3 == 0) goto L_0x0063
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0065 }
            Hj r3 = (defpackage.Hj) r3     // Catch:{ all -> 0x0065 }
            r3.onResult(r2)     // Catch:{ all -> 0x0065 }
            goto L_0x0053
        L_0x0063:
            monitor-exit(r0)
            goto L_0x0094
        L_0x0065:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0068:
            java.lang.Throwable r1 = r1.f387a
            monitor-enter(r0)
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0095 }
            java.util.LinkedHashSet r3 = r0.b     // Catch:{ all -> 0x0095 }
            r2.<init>(r3)     // Catch:{ all -> 0x0095 }
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0095 }
            if (r3 == 0) goto L_0x007f
            java.lang.String r2 = "Lottie encountered an error but no failure listener was added:"
            defpackage.Ai.c(r2, r1)     // Catch:{ all -> 0x0095 }
            monitor-exit(r0)
            goto L_0x0094
        L_0x007f:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0095 }
        L_0x0083:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0095 }
            if (r3 == 0) goto L_0x0093
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0095 }
            Hj r3 = (defpackage.Hj) r3     // Catch:{ all -> 0x0095 }
            r3.onResult(r1)     // Catch:{ all -> 0x0095 }
            goto L_0x0083
        L_0x0093:
            monitor-exit(r0)
        L_0x0094:
            return
        L_0x0095:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0098:
            java.lang.Object r0 = r13.a
            androidx.lifecycle.h r0 = (androidx.lifecycle.h) r0
            androidx.lifecycle.h r1 = androidx.lifecycle.h.a
            java.lang.String r1 = "this$0"
            defpackage.C1177ig.f(r0, r1)
            int r1 = r0.d
            if (r1 != 0) goto L_0x00b0
            r0.f2207a = r2
            androidx.lifecycle.LifecycleRegistry r1 = r0.f2204a
            androidx.lifecycle.Lifecycle$a r3 = androidx.lifecycle.Lifecycle.a.ON_PAUSE
            r1.f(r3)
        L_0x00b0:
            int r1 = r0.c
            if (r1 != 0) goto L_0x00c1
            boolean r1 = r0.f2207a
            if (r1 == 0) goto L_0x00c1
            androidx.lifecycle.LifecycleRegistry r1 = r0.f2204a
            androidx.lifecycle.Lifecycle$a r3 = androidx.lifecycle.Lifecycle.a.ON_STOP
            r1.f(r3)
            r0.b = r2
        L_0x00c1:
            return
        L_0x00c2:
            java.lang.Object r0 = r13.a
            android.view.View r0 = (android.view.View) r0
            android.content.Context r2 = r0.getContext()
            java.lang.String r3 = "input_method"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.view.inputmethod.InputMethodManager r2 = (android.view.inputmethod.InputMethodManager) r2
            r2.showSoftInput(r0, r1)
            return
        L_0x00d6:
            java.lang.Object r0 = r13.a
            android.app.Activity r0 = (android.app.Activity) r0
            int r4 = defpackage.J.a
            boolean r4 = r0.isFinishing()
            if (r4 != 0) goto L_0x017d
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 28
            if (r4 < r5) goto L_0x00ef
            java.lang.Class<?> r1 = defpackage.Q.f482a
            r0.recreate()
            goto L_0x016c
        L_0x00ef:
            java.lang.Class<?> r5 = defpackage.Q.f482a
            r5 = 27
            if (r4 != r5) goto L_0x00f7
            r6 = r2
            goto L_0x00f8
        L_0x00f7:
            r6 = r1
        L_0x00f8:
            java.lang.reflect.Method r7 = defpackage.Q.c
            if (r6 == 0) goto L_0x0100
            if (r7 != 0) goto L_0x0100
            goto L_0x0178
        L_0x0100:
            java.lang.reflect.Method r6 = defpackage.Q.f485b
            if (r6 != 0) goto L_0x010a
            java.lang.reflect.Method r6 = defpackage.Q.f484a
            if (r6 != 0) goto L_0x010a
            goto L_0x0178
        L_0x010a:
            java.lang.reflect.Field r6 = defpackage.Q.b     // Catch:{ all -> 0x0178 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ all -> 0x0178 }
            if (r6 != 0) goto L_0x0113
            goto L_0x0178
        L_0x0113:
            java.lang.reflect.Field r8 = defpackage.Q.f483a     // Catch:{ all -> 0x0178 }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ all -> 0x0178 }
            if (r8 != 0) goto L_0x011c
            goto L_0x0178
        L_0x011c:
            android.app.Application r9 = r0.getApplication()     // Catch:{ all -> 0x0178 }
            Q$a r10 = new Q$a     // Catch:{ all -> 0x0178 }
            r10.<init>(r0)     // Catch:{ all -> 0x0178 }
            r9.registerActivityLifecycleCallbacks(r10)     // Catch:{ all -> 0x0178 }
            android.os.Handler r11 = defpackage.Q.a
            N r12 = new N     // Catch:{ all -> 0x0178 }
            r12.<init>(r10, r6)     // Catch:{ all -> 0x0178 }
            r11.post(r12)     // Catch:{ all -> 0x0178 }
            if (r4 != r5) goto L_0x0136
            r4 = r2
            goto L_0x0137
        L_0x0136:
            r4 = r1
        L_0x0137:
            if (r4 == 0) goto L_0x0161
            r4 = 9
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x016e }
            r4[r1] = r6     // Catch:{ all -> 0x016e }
            r4[r2] = r3     // Catch:{ all -> 0x016e }
            r5 = 2
            r4[r5] = r3     // Catch:{ all -> 0x016e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x016e }
            r6 = 3
            r4[r6] = r5     // Catch:{ all -> 0x016e }
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x016e }
            r6 = 4
            r4[r6] = r5     // Catch:{ all -> 0x016e }
            r6 = 5
            r4[r6] = r3     // Catch:{ all -> 0x016e }
            r6 = 6
            r4[r6] = r3     // Catch:{ all -> 0x016e }
            r3 = 7
            r4[r3] = r5     // Catch:{ all -> 0x016e }
            r3 = 8
            r4[r3] = r5     // Catch:{ all -> 0x016e }
            r7.invoke(r8, r4)     // Catch:{ all -> 0x016e }
            goto L_0x0164
        L_0x0161:
            r0.recreate()     // Catch:{ all -> 0x016e }
        L_0x0164:
            O r3 = new O     // Catch:{ all -> 0x0178 }
            r3.<init>(r9, r10)     // Catch:{ all -> 0x0178 }
            r11.post(r3)     // Catch:{ all -> 0x0178 }
        L_0x016c:
            r1 = r2
            goto L_0x0178
        L_0x016e:
            r2 = move-exception
            O r3 = new O     // Catch:{ all -> 0x0178 }
            r3.<init>(r9, r10)     // Catch:{ all -> 0x0178 }
            r11.post(r3)     // Catch:{ all -> 0x0178 }
            throw r2     // Catch:{ all -> 0x0178 }
        L_0x0178:
            if (r1 != 0) goto L_0x017d
            r0.recreate()
        L_0x017d:
            return
        L_0x017e:
            java.lang.Object r0 = r13.a
            androidx.activity.ComponentActivity$f r0 = (androidx.activity.ComponentActivity.f) r0
            java.lang.Runnable r1 = r0.f808a
            if (r1 == 0) goto L_0x018b
            r1.run()
            r0.f808a = r3
        L_0x018b:
            return
        L_0x018c:
            java.lang.Object r0 = r13.a
            androidx.activity.ComponentActivity r0 = (androidx.activity.ComponentActivity) r0
            r0.invalidateMenu()
            return
        L_0x0194:
            java.lang.Object r0 = r13.a
            in.juspay.hypersdk.analytics.LogSessioniserExp r0 = (in.juspay.hypersdk.analytics.LogSessioniserExp) r0
            r0.updatePushFile()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0140b6.run():void");
    }
}
