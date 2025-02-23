package com.google.firebase.sessions;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.google.firebase.FirebaseApp;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;

/* compiled from: SessionEvents.kt */
public final class SessionEvents {
    public static final SessionEvents INSTANCE = new SessionEvents();
    private static final DataEncoder SESSION_EVENT_ENCODER;

    static {
        DataEncoder build = new JsonDataEncoderBuilder().configureWith(AutoSessionEventEncoder.CONFIG).ignoreNullValues(true).build();
        C1177ig.e(build, "JsonDataEncoderBuilder()…lues(true)\n      .build()");
        SESSION_EVENT_ENCODER = build;
    }

    private SessionEvents() {
    }

    public static /* synthetic */ SessionEvent buildSession$default(SessionEvents sessionEvents, FirebaseApp firebaseApp, SessionDetails sessionDetails, SessionsSettings sessionsSettings, Map map, String str, String str2, int i, Object obj) {
        String str3;
        String str4;
        if ((i & 8) != 0) {
            map = C1497ya.a;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            str3 = "";
        } else {
            str3 = str;
        }
        if ((i & 32) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        return sessionEvents.buildSession(firebaseApp, sessionDetails, sessionsSettings, map2, str3, str4);
    }

    private final DataCollectionState toDataCollectionState(SessionSubscriber sessionSubscriber) {
        if (sessionSubscriber == null) {
            return DataCollectionState.COLLECTION_SDK_NOT_INSTALLED;
        }
        if (sessionSubscriber.isDataCollectionEnabled()) {
            return DataCollectionState.COLLECTION_ENABLED;
        }
        return DataCollectionState.COLLECTION_DISABLED;
    }

    public final SessionEvent buildSession(FirebaseApp firebaseApp, SessionDetails sessionDetails, SessionsSettings sessionsSettings, Map<SessionSubscriber.Name, ? extends SessionSubscriber> map, String str, String str2) {
        Map<SessionSubscriber.Name, ? extends SessionSubscriber> map2 = map;
        C1177ig.f(firebaseApp, "firebaseApp");
        C1177ig.f(sessionDetails, "sessionDetails");
        C1177ig.f(sessionsSettings, "sessionsSettings");
        C1177ig.f(map2, "subscribers");
        C1177ig.f(str, "firebaseInstallationId");
        C1177ig.f(str2, "firebaseAuthenticationToken");
        return new SessionEvent(EventType.SESSION_START, new SessionInfo(sessionDetails.getSessionId(), sessionDetails.getFirstSessionId(), sessionDetails.getSessionIndex(), sessionDetails.getSessionStartTimestampUs(), new DataCollectionStatus(toDataCollectionState((SessionSubscriber) map2.get(SessionSubscriber.Name.PERFORMANCE)), toDataCollectionState((SessionSubscriber) map2.get(SessionSubscriber.Name.CRASHLYTICS)), sessionsSettings.getSamplingRate()), str, str2), getApplicationInfo(firebaseApp));
    }

    public final ApplicationInfo getApplicationInfo(FirebaseApp firebaseApp) {
        String str;
        String str2;
        C1177ig.f(firebaseApp, "firebaseApp");
        Context applicationContext = firebaseApp.getApplicationContext();
        C1177ig.e(applicationContext, "firebaseApp.applicationContext");
        String packageName = applicationContext.getPackageName();
        PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(packageName, 0);
        if (Build.VERSION.SDK_INT >= 28) {
            str = String.valueOf(packageInfo.getLongVersionCode());
        } else {
            str = String.valueOf(packageInfo.versionCode);
        }
        String str3 = str;
        String applicationId = firebaseApp.getOptions().getApplicationId();
        C1177ig.e(applicationId, "firebaseApp.options.applicationId");
        String str4 = Build.MODEL;
        C1177ig.e(str4, "MODEL");
        String str5 = Build.VERSION.RELEASE;
        C1177ig.e(str5, "RELEASE");
        LogEnvironment logEnvironment = LogEnvironment.LOG_ENVIRONMENT_PROD;
        C1177ig.e(packageName, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        String str6 = packageInfo.versionName;
        if (str6 == null) {
            str2 = str3;
        } else {
            str2 = str6;
        }
        String str7 = Build.MANUFACTURER;
        C1177ig.e(str7, "MANUFACTURER");
        ProcessDetailsProvider processDetailsProvider = ProcessDetailsProvider.INSTANCE;
        Context applicationContext2 = firebaseApp.getApplicationContext();
        C1177ig.e(applicationContext2, "firebaseApp.applicationContext");
        ProcessDetails currentProcessDetails = processDetailsProvider.getCurrentProcessDetails(applicationContext2);
        Context applicationContext3 = firebaseApp.getApplicationContext();
        C1177ig.e(applicationContext3, "firebaseApp.applicationContext");
        return new ApplicationInfo(applicationId, str4, BuildConfig.VERSION_NAME, str5, logEnvironment, new AndroidApplicationInfo(packageName, str2, str3, str7, currentProcessDetails, processDetailsProvider.getAppProcessDetails(applicationContext3)));
    }

    public final DataEncoder getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions() {
        return SESSION_EVENT_ENCODER;
    }
}
