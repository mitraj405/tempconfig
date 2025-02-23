package com.google.firebase.sessions.settings;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.sessions.settings.SettingsProvider;
import in.juspay.hyper.constants.LogCategory;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;

/* compiled from: LocalOverrideSettings.kt */
public final class LocalOverrideSettings implements SettingsProvider {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String SAMPLING_RATE = "firebase_sessions_sampling_rate";
    @Deprecated
    public static final String SESSIONS_ENABLED = "firebase_sessions_enabled";
    @Deprecated
    public static final String SESSION_RESTART_TIMEOUT = "firebase_sessions_sessions_restart_timeout";
    private final Bundle metadata;

    /* compiled from: LocalOverrideSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LocalOverrideSettings(Context context) {
        C1177ig.f(context, LogCategory.CONTEXT);
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.metadata = bundle == null ? Bundle.EMPTY : bundle;
    }

    public Double getSamplingRate() {
        if (this.metadata.containsKey(SAMPLING_RATE)) {
            return Double.valueOf(this.metadata.getDouble(SAMPLING_RATE));
        }
        return null;
    }

    public Boolean getSessionEnabled() {
        if (this.metadata.containsKey(SESSIONS_ENABLED)) {
            return Boolean.valueOf(this.metadata.getBoolean(SESSIONS_ENABLED));
        }
        return null;
    }

    /* renamed from: getSessionRestartTimeout-FghU774  reason: not valid java name */
    public Duration m13getSessionRestartTimeoutFghU774() {
        if (this.metadata.containsKey(SESSION_RESTART_TIMEOUT)) {
            return new Duration(C1354qp.H0(this.metadata.getInt(SESSION_RESTART_TIMEOUT), C0513G9.SECONDS));
        }
        return null;
    }

    public boolean isSettingsStale() {
        return SettingsProvider.DefaultImpls.isSettingsStale(this);
    }

    public Object updateSettings(Continuation<? super Unit> continuation) {
        return SettingsProvider.DefaultImpls.updateSettings(this, continuation);
    }

    private static /* synthetic */ void getMetadata$annotations() {
    }
}
