package com.google.firebase.sessions.settings;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.time.Duration;

/* compiled from: SettingsProvider.kt */
public interface SettingsProvider {

    /* compiled from: SettingsProvider.kt */
    public static final class DefaultImpls {
        public static boolean isSettingsStale(SettingsProvider settingsProvider) {
            return false;
        }

        public static Object updateSettings(SettingsProvider settingsProvider, Continuation<? super Unit> continuation) {
            return Unit.a;
        }
    }

    Double getSamplingRate();

    Boolean getSessionEnabled();

    /* renamed from: getSessionRestartTimeout-FghU774  reason: not valid java name */
    Duration m17getSessionRestartTimeoutFghU774();

    boolean isSettingsStale();

    Object updateSettings(Continuation<? super Unit> continuation);
}
