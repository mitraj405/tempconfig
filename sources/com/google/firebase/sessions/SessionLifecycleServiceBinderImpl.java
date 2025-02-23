package com.google.firebase.sessions;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SessionLifecycleServiceBinder.kt */
public final class SessionLifecycleServiceBinderImpl implements SessionLifecycleServiceBinder {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String TAG = "LifecycleServiceBinder";
    private final FirebaseApp firebaseApp;

    /* compiled from: SessionLifecycleServiceBinder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionLifecycleServiceBinderImpl(FirebaseApp firebaseApp2) {
        C1177ig.f(firebaseApp2, "firebaseApp");
        this.firebaseApp = firebaseApp2;
    }

    private final Object unbindServiceSafely(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
            return Unit.a;
        } catch (IllegalArgumentException e) {
            return Integer.valueOf(Log.w(TAG, "Session lifecycle service binding failed.", e));
        }
    }

    public void bindToService(Messenger messenger, ServiceConnection serviceConnection) {
        boolean z;
        C1177ig.f(messenger, "callback");
        C1177ig.f(serviceConnection, "serviceConnection");
        Context applicationContext = this.firebaseApp.getApplicationContext().getApplicationContext();
        Intent intent = new Intent(applicationContext, SessionLifecycleService.class);
        intent.setAction(String.valueOf(Process.myPid()));
        intent.putExtra(SessionLifecycleService.CLIENT_CALLBACK_MESSENGER, messenger);
        try {
            z = applicationContext.bindService(intent, serviceConnection, 65);
        } catch (SecurityException unused) {
            z = false;
        }
        if (!z) {
            C1177ig.e(applicationContext, "appContext");
            unbindServiceSafely(applicationContext, serviceConnection);
        }
    }
}
