package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* compiled from: SettingsCache.kt */
public final class SettingsCache {
    /* access modifiers changed from: private */
    public static final Preferences.Key<Integer> CACHE_DURATION_SECONDS = new Preferences.Key<>("firebase_sessions_cache_duration");
    /* access modifiers changed from: private */
    public static final Preferences.Key<Long> CACHE_UPDATED_TIME = new Preferences.Key<>("firebase_sessions_cache_updated_time");
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Preferences.Key<Integer> RESTART_TIMEOUT_SECONDS = new Preferences.Key<>("firebase_sessions_restart_timeout");
    /* access modifiers changed from: private */
    public static final Preferences.Key<Double> SAMPLING_RATE = new Preferences.Key<>(LocalOverrideSettings.SAMPLING_RATE);
    /* access modifiers changed from: private */
    public static final Preferences.Key<Boolean> SESSIONS_ENABLED = new Preferences.Key<>(LocalOverrideSettings.SESSIONS_ENABLED);
    @Deprecated
    public static final String TAG = "SettingsCache";
    /* access modifiers changed from: private */
    public final DataStore<Preferences> dataStore;
    private SessionConfigs sessionConfigs;

    @C1128g8(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {46}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$1  reason: invalid class name */
    /* compiled from: SettingsCache.kt */
    public static final class AnonymousClass1 extends Py implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ SettingsCache this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            SettingsCache settingsCache;
            C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                r1.R(obj);
                SettingsCache settingsCache2 = this.this$0;
                Flow b = settingsCache2.dataStore.b();
                this.L$0 = settingsCache2;
                this.label = 1;
                Object r = r1.r(b, this);
                if (r == v7Var) {
                    return v7Var;
                }
                settingsCache = settingsCache2;
                obj = r;
            } else if (i == 1) {
                settingsCache = (SettingsCache) this.L$0;
                r1.R(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map<Preferences.Key<?>, Object> a = ((Preferences) obj).a();
            C1177ig.f(a, "<this>");
            settingsCache.updateSessionConfigs(new MutablePreferences((Map<Preferences.Key<?>, Object>) new LinkedHashMap(a), true));
            return Unit.a;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }
    }

    /* compiled from: SettingsCache.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Preferences.Key<Integer> getCACHE_DURATION_SECONDS() {
            return SettingsCache.CACHE_DURATION_SECONDS;
        }

        public final Preferences.Key<Long> getCACHE_UPDATED_TIME() {
            return SettingsCache.CACHE_UPDATED_TIME;
        }

        public final Preferences.Key<Integer> getRESTART_TIMEOUT_SECONDS() {
            return SettingsCache.RESTART_TIMEOUT_SECONDS;
        }

        public final Preferences.Key<Double> getSAMPLING_RATE() {
            return SettingsCache.SAMPLING_RATE;
        }

        public final Preferences.Key<Boolean> getSESSIONS_ENABLED() {
            return SettingsCache.SESSIONS_ENABLED;
        }
    }

    public SettingsCache(DataStore<Preferences> dataStore2) {
        C1177ig.f(dataStore2, "dataStore");
        this.dataStore = dataStore2;
        C1354qp.u0(new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object updateConfigValue(androidx.datastore.preferences.core.Preferences.Key<T> r6, T r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            defpackage.r1.R(r8)     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0027:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x002f:
            defpackage.r1.R(r8)
            androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> r8 = r5.dataStore     // Catch:{ IOException -> 0x0048 }
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2     // Catch:{ IOException -> 0x0048 }
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch:{ IOException -> 0x0048 }
            r0.label = r3     // Catch:{ IOException -> 0x0048 }
            iq r6 = new iq     // Catch:{ IOException -> 0x0048 }
            r6.<init>(r2, r4)     // Catch:{ IOException -> 0x0048 }
            java.lang.Object r6 = r8.a(r6, r0)     // Catch:{ IOException -> 0x0048 }
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x0048:
            r6 = move-exception
            r6.toString()
        L_0x004c:
            kotlin.Unit r6 = kotlin.Unit.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.updateConfigValue(androidx.datastore.preferences.core.Preferences$Key, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void updateSessionConfigs(Preferences preferences) {
        this.sessionConfigs = new SessionConfigs((Boolean) preferences.b(SESSIONS_ENABLED), (Double) preferences.b(SAMPLING_RATE), (Integer) preferences.b(RESTART_TIMEOUT_SECONDS), (Integer) preferences.b(CACHE_DURATION_SECONDS), (Long) preferences.b(CACHE_UPDATED_TIME));
    }

    public final boolean hasCacheExpired$com_google_firebase_firebase_sessions() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        if (sessionConfigs2 != null) {
            Long cacheUpdatedTime = sessionConfigs2.getCacheUpdatedTime();
            SessionConfigs sessionConfigs3 = this.sessionConfigs;
            if (sessionConfigs3 != null) {
                Integer cacheDuration = sessionConfigs3.getCacheDuration();
                if (cacheUpdatedTime == null || cacheDuration == null || (System.currentTimeMillis() - cacheUpdatedTime.longValue()) / ((long) 1000) >= ((long) cacheDuration.intValue())) {
                    return true;
                }
                return false;
            }
            C1177ig.l("sessionConfigs");
            throw null;
        }
        C1177ig.l("sessionConfigs");
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object removeConfigs$com_google_firebase_firebase_sessions(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            defpackage.r1.R(r6)     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0027:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x002f:
            defpackage.r1.R(r6)
            androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> r6 = r5.dataStore     // Catch:{ IOException -> 0x0048 }
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2     // Catch:{ IOException -> 0x0048 }
            r4 = 0
            r2.<init>(r5, r4)     // Catch:{ IOException -> 0x0048 }
            r0.label = r3     // Catch:{ IOException -> 0x0048 }
            iq r3 = new iq     // Catch:{ IOException -> 0x0048 }
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x0048 }
            java.lang.Object r6 = r6.a(r3, r0)     // Catch:{ IOException -> 0x0048 }
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x0048:
            r6 = move-exception
            r6.toString()
        L_0x004c:
            kotlin.Unit r6 = kotlin.Unit.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.removeConfigs$com_google_firebase_firebase_sessions(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Integer sessionRestartTimeout() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        if (sessionConfigs2 != null) {
            return sessionConfigs2.getSessionRestartTimeout();
        }
        C1177ig.l("sessionConfigs");
        throw null;
    }

    public final Double sessionSamplingRate() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        if (sessionConfigs2 != null) {
            return sessionConfigs2.getSessionSamplingRate();
        }
        C1177ig.l("sessionConfigs");
        throw null;
    }

    public final Boolean sessionsEnabled() {
        SessionConfigs sessionConfigs2 = this.sessionConfigs;
        if (sessionConfigs2 != null) {
            return sessionConfigs2.getSessionEnabled();
        }
        C1177ig.l("sessionConfigs");
        throw null;
    }

    public final Object updateSamplingRate(Double d, Continuation<? super Unit> continuation) {
        Object updateConfigValue = updateConfigValue(SAMPLING_RATE, d, continuation);
        if (updateConfigValue == C1438v7.COROUTINE_SUSPENDED) {
            return updateConfigValue;
        }
        return Unit.a;
    }

    public final Object updateSessionCacheDuration(Integer num, Continuation<? super Unit> continuation) {
        Object updateConfigValue = updateConfigValue(CACHE_DURATION_SECONDS, num, continuation);
        if (updateConfigValue == C1438v7.COROUTINE_SUSPENDED) {
            return updateConfigValue;
        }
        return Unit.a;
    }

    public final Object updateSessionCacheUpdatedTime(Long l, Continuation<? super Unit> continuation) {
        Object updateConfigValue = updateConfigValue(CACHE_UPDATED_TIME, l, continuation);
        if (updateConfigValue == C1438v7.COROUTINE_SUSPENDED) {
            return updateConfigValue;
        }
        return Unit.a;
    }

    public final Object updateSessionRestartTimeout(Integer num, Continuation<? super Unit> continuation) {
        Object updateConfigValue = updateConfigValue(RESTART_TIMEOUT_SECONDS, num, continuation);
        if (updateConfigValue == C1438v7.COROUTINE_SUSPENDED) {
            return updateConfigValue;
        }
        return Unit.a;
    }

    public final Object updateSettingsEnabled(Boolean bool, Continuation<? super Unit> continuation) {
        Object updateConfigValue = updateConfigValue(SESSIONS_ENABLED, bool, continuation);
        if (updateConfigValue == C1438v7.COROUTINE_SUSPENDED) {
            return updateConfigValue;
        }
        return Unit.a;
    }
}
