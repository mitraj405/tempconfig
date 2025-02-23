package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* renamed from: ua  reason: default package and case insensitive filesystem */
/* compiled from: EmptyActivityLifecycleCallbacks.kt */
public class C0352ua implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        C1177ig.f(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        C1177ig.f(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        C1177ig.f(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        C1177ig.f(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        C1177ig.f(activity, "activity");
        C1177ig.f(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        C1177ig.f(activity, "activity");
    }

    public void onActivityStopped(Activity activity) {
        C1177ig.f(activity, "activity");
    }
}
