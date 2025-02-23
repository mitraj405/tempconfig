package com.google.firebase.sessions;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import kotlin.jvm.functions.Function1;

/* compiled from: SessionDatastore.kt */
public final class SessionDatastoreImpl$Companion$dataStore$2 extends C0595Mh implements Function1<CorruptionException, Preferences> {
    public static final SessionDatastoreImpl$Companion$dataStore$2 INSTANCE = new SessionDatastoreImpl$Companion$dataStore$2();

    public SessionDatastoreImpl$Companion$dataStore$2() {
        super(1);
    }

    public final Preferences invoke(CorruptionException corruptionException) {
        C1177ig.f(corruptionException, "ex");
        ProcessDetailsProvider.INSTANCE.getProcessName$com_google_firebase_firebase_sessions();
        return new MutablePreferences(true, 1);
    }
}
