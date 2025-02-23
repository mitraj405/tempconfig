package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.momagic.C0835h;
import com.momagic.H;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: M  reason: default package */
/* compiled from: ActivityLifecycleListener */
public final class M implements Application.ActivityLifecycleCallbacks {
    public static M a;

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        C0835h.a = activity;
    }

    public final void onActivityResumed(Activity activity) {
        AtomicLong atomicLong;
        C0835h.a = activity;
        Context context = C0835h.f4046a;
        if (context != null) {
            C1139gq c = C1139gq.c(context);
            C0835h.a = activity;
            if (!c.a("notificationIdUpdated") && C0835h.f4049a != null && c.a("isCheck")) {
                C1348qc qcVar = C0835h.f4049a;
                Context context2 = qcVar.f6898a;
                if (!(context2 == null || C1348qc.f6896a == null || C1348qc.f6897a == null)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - C1348qc.f6896a.get() <= 120000 && ((atomicLong = C1348qc.b) == null || currentTimeMillis - atomicLong.get() >= 30000)) {
                        try {
                            Object c2 = qcVar.c(context2);
                            Method e = C1348qc.e(C1348qc.a);
                            if (C1348qc.b(C1348qc.f6897a) != null) {
                                Bundle b = C1348qc.b(C1348qc.f6897a);
                                if (b != null) {
                                    b.putString("time_of_click", C1348qc.d());
                                }
                                if (e != null) {
                                    e.invoke(c2, new Object[]{"push_notification_influence_open", b});
                                }
                            }
                        } catch (Exception e2) {
                            H.r(context2, e2.toString(), "FirebaseAnalyticsClass", "influence");
                        }
                    }
                }
                c.f("notificationIdUpdated", true);
            }
            try {
                Dw.a(C0835h.f4046a, 0);
            } catch (Exception e3) {
                H.r(C0835h.f4046a, e3.toString(), "DATB", "onActivityResumed");
            }
        }
    }

    public final void onActivityStarted(Activity activity) {
        C0835h.a = activity;
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
