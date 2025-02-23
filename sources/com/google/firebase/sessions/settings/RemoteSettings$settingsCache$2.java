package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import kotlin.jvm.functions.Function0;

/* compiled from: RemoteSettings.kt */
public final class RemoteSettings$settingsCache$2 extends C0595Mh implements Function0<SettingsCache> {
    final /* synthetic */ DataStore<Preferences> $dataStore;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteSettings$settingsCache$2(DataStore<Preferences> dataStore) {
        super(0);
        this.$dataStore = dataStore;
    }

    public final SettingsCache invoke() {
        return new SettingsCache(this.$dataStore);
    }
}
