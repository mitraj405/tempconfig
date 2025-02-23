package com.google.firebase.sessions;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.Unit;

/* compiled from: SessionsActivityLifecycleCallbacks.kt */
public final class SessionsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public static final SessionsActivityLifecycleCallbacks INSTANCE = new SessionsActivityLifecycleCallbacks();
    private static boolean hasPendingForeground;
    private static SessionLifecycleClient lifecycleClient;

    private SessionsActivityLifecycleCallbacks() {
    }

    public final boolean getHasPendingForeground$com_google_firebase_firebase_sessions() {
        return hasPendingForeground;
    }

    public final SessionLifecycleClient getLifecycleClient() {
        return lifecycleClient;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        C1177ig.f(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        C1177ig.f(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        C1177ig.f(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = lifecycleClient;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.backgrounded();
        }
    }

    public void onActivityResumed(Activity activity) {
        Unit unit;
        C1177ig.f(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = lifecycleClient;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.foregrounded();
            unit = Unit.a;
        } else {
            unit = null;
        }
        if (unit == null) {
            hasPendingForeground = true;
        }
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

    public final void setHasPendingForeground$com_google_firebase_firebase_sessions(boolean z) {
        hasPendingForeground = z;
    }

    public final void setLifecycleClient(SessionLifecycleClient sessionLifecycleClient) {
        lifecycleClient = sessionLifecycleClient;
        if (sessionLifecycleClient != null && hasPendingForeground) {
            hasPendingForeground = false;
            sessionLifecycleClient.foregrounded();
        }
    }

    public static /* synthetic */ void getHasPendingForeground$com_google_firebase_firebase_sessions$annotations() {
    }
}
