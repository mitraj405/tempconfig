package com.google.firebase.sessions;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;

/* compiled from: SessionDatastore.kt */
public interface SessionDatastore {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: SessionDatastore.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final SessionDatastore getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(SessionDatastore.class);
            C1177ig.e(obj, "Firebase.app[SessionDatastore::class.java]");
            return (SessionDatastore) obj;
        }
    }

    String getCurrentSessionId();

    void updateSessionId(String str);
}
