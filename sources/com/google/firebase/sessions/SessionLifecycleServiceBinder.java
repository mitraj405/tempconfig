package com.google.firebase.sessions;

import android.content.ServiceConnection;
import android.os.Messenger;

/* compiled from: SessionLifecycleServiceBinder.kt */
public interface SessionLifecycleServiceBinder {
    void bindToService(Messenger messenger, ServiceConnection serviceConnection);
}
