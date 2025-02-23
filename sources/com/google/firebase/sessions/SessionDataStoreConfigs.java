package com.google.firebase.sessions;

import android.util.Base64;

/* compiled from: SessionDataStoreConfigs.kt */
public final class SessionDataStoreConfigs {
    public static final SessionDataStoreConfigs INSTANCE = new SessionDataStoreConfigs();
    private static final String PROCESS_NAME;
    private static final String SESSIONS_CONFIG_NAME;
    private static final String SETTINGS_CONFIG_NAME;

    static {
        String processName$com_google_firebase_firebase_sessions = ProcessDetailsProvider.INSTANCE.getProcessName$com_google_firebase_firebase_sessions();
        C1177ig.f(processName$com_google_firebase_firebase_sessions, "<this>");
        byte[] bytes = processName$com_google_firebase_firebase_sessions.getBytes(Y4.a);
        C1177ig.e(bytes, "this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 10);
        PROCESS_NAME = encodeToString;
        SESSIONS_CONFIG_NAME = lf.j("firebase_session_", encodeToString, "_data");
        SETTINGS_CONFIG_NAME = lf.j("firebase_session_", encodeToString, "_settings");
    }

    private SessionDataStoreConfigs() {
    }

    public final String getSESSIONS_CONFIG_NAME() {
        return SESSIONS_CONFIG_NAME;
    }

    public final String getSETTINGS_CONFIG_NAME() {
        return SETTINGS_CONFIG_NAME;
    }
}
