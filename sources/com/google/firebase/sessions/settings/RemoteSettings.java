package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import kotlinx.coroutines.d;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: RemoteSettings.kt */
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String FORWARD_SLASH_STRING = "/";
    @Deprecated
    public static final String TAG = "SessionConfigFetcher";
    private final ApplicationInfo appInfo;
    private final CoroutineContext backgroundDispatcher;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final Mutex fetchInProgress = new C1180im(false);
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final Lazy settingsCache$delegate;

    /* compiled from: RemoteSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RemoteSettings(CoroutineContext coroutineContext, FirebaseInstallationsApi firebaseInstallationsApi2, ApplicationInfo applicationInfo, CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, DataStore<Preferences> dataStore) {
        C1177ig.f(coroutineContext, "backgroundDispatcher");
        C1177ig.f(firebaseInstallationsApi2, "firebaseInstallationsApi");
        C1177ig.f(applicationInfo, "appInfo");
        C1177ig.f(crashlyticsSettingsFetcher, "configsFetcher");
        C1177ig.f(dataStore, "dataStore");
        this.backgroundDispatcher = coroutineContext;
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.appInfo = applicationInfo;
        this.configsFetcher = crashlyticsSettingsFetcher;
        this.settingsCache$delegate = C1354qp.d0(new RemoteSettings$settingsCache$2(dataStore));
    }

    /* access modifiers changed from: private */
    public final SettingsCache getSettingsCache() {
        return (SettingsCache) this.settingsCache$delegate.getValue();
    }

    private final String removeForwardSlashesIn(String str) {
        Pattern compile = Pattern.compile(FORWARD_SLASH_STRING);
        C1177ig.e(compile, "compile(pattern)");
        C1177ig.f(str, "input");
        String replaceAll = compile.matcher(str).replaceAll("");
        C1177ig.e(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final void clearCachedSettings$com_google_firebase_firebase_sessions() {
        C1354qp.c0(d.a(this.backgroundDispatcher), new RemoteSettings$clearCachedSettings$1(this, (Continuation<? super RemoteSettings$clearCachedSettings$1>) null));
    }

    public Double getSamplingRate() {
        return getSettingsCache().sessionSamplingRate();
    }

    public Boolean getSessionEnabled() {
        return getSettingsCache().sessionsEnabled();
    }

    /* renamed from: getSessionRestartTimeout-FghU774  reason: not valid java name */
    public Duration m14getSessionRestartTimeoutFghU774() {
        Integer sessionRestartTimeout = getSettingsCache().sessionRestartTimeout();
        if (sessionRestartTimeout == null) {
            return null;
        }
        int i = Duration.c;
        return new Duration(C1354qp.H0(sessionRestartTimeout.intValue(), C0513G9.SECONDS));
    }

    public boolean isSettingsStale() {
        return getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089 A[Catch:{ all -> 0x0158 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008f A[SYNTHETIC, Splitter:B:37:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ae A[Catch:{ all -> 0x0158 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateSettings(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r0 = (com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r0 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            r0.<init>(r14, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 3
            r5 = 2
            r6 = 0
            if (r2 == 0) goto L_0x0056
            if (r2 == r3) goto L_0x004a
            if (r2 == r5) goto L_0x003e
            if (r2 != r4) goto L_0x0036
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            defpackage.r1.R(r15)     // Catch:{ all -> 0x0033 }
            goto L_0x0150
        L_0x0033:
            r15 = move-exception
            goto L_0x015a
        L_0x0036:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x003e:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r7 = r0.L$0
            com.google.firebase.sessions.settings.RemoteSettings r7 = (com.google.firebase.sessions.settings.RemoteSettings) r7
            defpackage.r1.R(r15)     // Catch:{ all -> 0x0158 }
            goto L_0x00a0
        L_0x004a:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r7 = r0.L$0
            com.google.firebase.sessions.settings.RemoteSettings r7 = (com.google.firebase.sessions.settings.RemoteSettings) r7
            defpackage.r1.R(r15)
            goto L_0x007f
        L_0x0056:
            defpackage.r1.R(r15)
            kotlinx.coroutines.sync.Mutex r15 = r14.fetchInProgress
            boolean r15 = r15.a()
            if (r15 != 0) goto L_0x006e
            com.google.firebase.sessions.settings.SettingsCache r15 = r14.getSettingsCache()
            boolean r15 = r15.hasCacheExpired$com_google_firebase_firebase_sessions()
            if (r15 != 0) goto L_0x006e
            kotlin.Unit r15 = kotlin.Unit.a
            return r15
        L_0x006e:
            kotlinx.coroutines.sync.Mutex r15 = r14.fetchInProgress
            r0.L$0 = r14
            r0.L$1 = r15
            r0.label = r3
            java.lang.Object r2 = r15.c(r0)
            if (r2 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r7 = r14
            r2 = r15
        L_0x007f:
            com.google.firebase.sessions.settings.SettingsCache r15 = r7.getSettingsCache()     // Catch:{ all -> 0x0158 }
            boolean r15 = r15.hasCacheExpired$com_google_firebase_firebase_sessions()     // Catch:{ all -> 0x0158 }
            if (r15 != 0) goto L_0x008f
            kotlin.Unit r15 = kotlin.Unit.a     // Catch:{ all -> 0x0158 }
            r2.b(r6)
            return r15
        L_0x008f:
            com.google.firebase.sessions.InstallationId$Companion r15 = com.google.firebase.sessions.InstallationId.Companion     // Catch:{ all -> 0x0158 }
            com.google.firebase.installations.FirebaseInstallationsApi r8 = r7.firebaseInstallationsApi     // Catch:{ all -> 0x0158 }
            r0.L$0 = r7     // Catch:{ all -> 0x0158 }
            r0.L$1 = r2     // Catch:{ all -> 0x0158 }
            r0.label = r5     // Catch:{ all -> 0x0158 }
            java.lang.Object r15 = r15.create(r8, r0)     // Catch:{ all -> 0x0158 }
            if (r15 != r1) goto L_0x00a0
            return r1
        L_0x00a0:
            com.google.firebase.sessions.InstallationId r15 = (com.google.firebase.sessions.InstallationId) r15     // Catch:{ all -> 0x0158 }
            java.lang.String r15 = r15.getFid()     // Catch:{ all -> 0x0158 }
            java.lang.String r8 = ""
            boolean r8 = defpackage.C1177ig.a(r15, r8)     // Catch:{ all -> 0x0158 }
            if (r8 == 0) goto L_0x00b4
            kotlin.Unit r15 = kotlin.Unit.a     // Catch:{ all -> 0x0158 }
            r2.b(r6)
            return r15
        L_0x00b4:
            r8 = 5
            kotlin.Pair[] r9 = new kotlin.Pair[r8]     // Catch:{ all -> 0x0158 }
            java.lang.String r10 = "X-Crashlytics-Installation-ID"
            kotlin.Pair r11 = new kotlin.Pair     // Catch:{ all -> 0x0158 }
            r11.<init>(r10, r15)     // Catch:{ all -> 0x0158 }
            r15 = 0
            r9[r15] = r11     // Catch:{ all -> 0x0158 }
            java.lang.String r10 = "X-Crashlytics-Device-Model"
            java.lang.String r11 = "%s/%s"
            java.lang.Object[] r12 = new java.lang.Object[r5]     // Catch:{ all -> 0x0158 }
            java.lang.String r13 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0158 }
            r12[r15] = r13     // Catch:{ all -> 0x0158 }
            java.lang.String r13 = android.os.Build.MODEL     // Catch:{ all -> 0x0158 }
            r12[r3] = r13     // Catch:{ all -> 0x0158 }
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r5)     // Catch:{ all -> 0x0158 }
            java.lang.String r11 = java.lang.String.format(r11, r12)     // Catch:{ all -> 0x0158 }
            java.lang.String r12 = "format(format, *args)"
            defpackage.C1177ig.e(r11, r12)     // Catch:{ all -> 0x0158 }
            java.lang.String r11 = r7.removeForwardSlashesIn(r11)     // Catch:{ all -> 0x0158 }
            kotlin.Pair r12 = new kotlin.Pair     // Catch:{ all -> 0x0158 }
            r12.<init>(r10, r11)     // Catch:{ all -> 0x0158 }
            r9[r3] = r12     // Catch:{ all -> 0x0158 }
            java.lang.String r3 = "X-Crashlytics-OS-Build-Version"
            java.lang.String r10 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x0158 }
            java.lang.String r11 = "INCREMENTAL"
            defpackage.C1177ig.e(r10, r11)     // Catch:{ all -> 0x0158 }
            java.lang.String r10 = r7.removeForwardSlashesIn(r10)     // Catch:{ all -> 0x0158 }
            kotlin.Pair r11 = new kotlin.Pair     // Catch:{ all -> 0x0158 }
            r11.<init>(r3, r10)     // Catch:{ all -> 0x0158 }
            r9[r5] = r11     // Catch:{ all -> 0x0158 }
            java.lang.String r3 = "X-Crashlytics-OS-Display-Version"
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0158 }
            java.lang.String r10 = "RELEASE"
            defpackage.C1177ig.e(r5, r10)     // Catch:{ all -> 0x0158 }
            java.lang.String r5 = r7.removeForwardSlashesIn(r5)     // Catch:{ all -> 0x0158 }
            kotlin.Pair r10 = new kotlin.Pair     // Catch:{ all -> 0x0158 }
            r10.<init>(r3, r5)     // Catch:{ all -> 0x0158 }
            r9[r4] = r10     // Catch:{ all -> 0x0158 }
            java.lang.String r3 = "X-Crashlytics-API-Client-Version"
            com.google.firebase.sessions.ApplicationInfo r5 = r7.appInfo     // Catch:{ all -> 0x0158 }
            java.lang.String r5 = r5.getSessionSdkVersion()     // Catch:{ all -> 0x0158 }
            kotlin.Pair r10 = new kotlin.Pair     // Catch:{ all -> 0x0158 }
            r10.<init>(r3, r5)     // Catch:{ all -> 0x0158 }
            r3 = 4
            r9[r3] = r10     // Catch:{ all -> 0x0158 }
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0158 }
            int r5 = defpackage.r1.H(r8)     // Catch:{ all -> 0x0158 }
            r3.<init>(r5)     // Catch:{ all -> 0x0158 }
        L_0x0128:
            if (r15 >= r8) goto L_0x0136
            r5 = r9[r15]     // Catch:{ all -> 0x0158 }
            A r10 = r5.a     // Catch:{ all -> 0x0158 }
            B r5 = r5.b     // Catch:{ all -> 0x0158 }
            r3.put(r10, r5)     // Catch:{ all -> 0x0158 }
            int r15 = r15 + 1
            goto L_0x0128
        L_0x0136:
            com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher r15 = r7.configsFetcher     // Catch:{ all -> 0x0158 }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1 r5 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1     // Catch:{ all -> 0x0158 }
            r5.<init>(r7, r6)     // Catch:{ all -> 0x0158 }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2 r7 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2     // Catch:{ all -> 0x0158 }
            r7.<init>(r6)     // Catch:{ all -> 0x0158 }
            r0.L$0 = r2     // Catch:{ all -> 0x0158 }
            r0.L$1 = r6     // Catch:{ all -> 0x0158 }
            r0.label = r4     // Catch:{ all -> 0x0158 }
            java.lang.Object r15 = r15.doConfigFetch(r3, r5, r7, r0)     // Catch:{ all -> 0x0158 }
            if (r15 != r1) goto L_0x014f
            return r1
        L_0x014f:
            r0 = r2
        L_0x0150:
            kotlin.Unit r15 = kotlin.Unit.a     // Catch:{ all -> 0x0033 }
            r0.b(r6)
            kotlin.Unit r15 = kotlin.Unit.a
            return r15
        L_0x0158:
            r15 = move-exception
            r0 = r2
        L_0x015a:
            r0.b(r6)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.updateSettings(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
