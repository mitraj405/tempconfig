package com.google.firebase.sessions.settings;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.ProcessDetailsProvider;
import kotlin.jvm.functions.Function1;

/* compiled from: SessionsSettings.kt */
public final class SessionsSettings$Companion$dataStore$2 extends C0595Mh implements Function1<CorruptionException, Preferences> {
    public static final SessionsSettings$Companion$dataStore$2 INSTANCE = new SessionsSettings$Companion$dataStore$2();

    public SessionsSettings$Companion$dataStore$2() {
        super(1);
    }

    public final Preferences invoke(CorruptionException corruptionException) {
        C1177ig.f(corruptionException, "ex");
        ProcessDetailsProvider.INSTANCE.getProcessName$com_google_firebase_firebase_sessions();
        return new MutablePreferences(true, 1);
    }
}
