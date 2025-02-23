package com.google.firebase.sessions;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;

/* compiled from: SessionFirelogPublisher.kt */
public interface SessionFirelogPublisher {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: SessionFirelogPublisher.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SessionFirelogPublisher getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(SessionFirelogPublisher.class);
            C1177ig.e(obj, "Firebase.app[SessionFirelogPublisher::class.java]");
            return (SessionFirelogPublisher) obj;
        }
    }

    void logSession(SessionDetails sessionDetails);
}
