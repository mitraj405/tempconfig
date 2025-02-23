package com.google.firebase.sessions;

import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* compiled from: ApplicationInfo.kt */
public final class ApplicationInfo {
    private final AndroidApplicationInfo androidAppInfo;
    private final String appId;
    private final String deviceModel;
    private final LogEnvironment logEnvironment;
    private final String osVersion;
    private final String sessionSdkVersion;

    public ApplicationInfo(String str, String str2, String str3, String str4, LogEnvironment logEnvironment2, AndroidApplicationInfo androidApplicationInfo) {
        C1177ig.f(str, RemoteConfigConstants.RequestFieldKey.APP_ID);
        C1177ig.f(str2, "deviceModel");
        C1177ig.f(str3, "sessionSdkVersion");
        C1177ig.f(str4, "osVersion");
        C1177ig.f(logEnvironment2, "logEnvironment");
        C1177ig.f(androidApplicationInfo, "androidAppInfo");
        this.appId = str;
        this.deviceModel = str2;
        this.sessionSdkVersion = str3;
        this.osVersion = str4;
        this.logEnvironment = logEnvironment2;
        this.androidAppInfo = androidApplicationInfo;
    }

    public static /* synthetic */ ApplicationInfo copy$default(ApplicationInfo applicationInfo, String str, String str2, String str3, String str4, LogEnvironment logEnvironment2, AndroidApplicationInfo androidApplicationInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = applicationInfo.appId;
        }
        if ((i & 2) != 0) {
            str2 = applicationInfo.deviceModel;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = applicationInfo.sessionSdkVersion;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = applicationInfo.osVersion;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            logEnvironment2 = applicationInfo.logEnvironment;
        }
        LogEnvironment logEnvironment3 = logEnvironment2;
        if ((i & 32) != 0) {
            androidApplicationInfo = applicationInfo.androidAppInfo;
        }
        return applicationInfo.copy(str, str5, str6, str7, logEnvironment3, androidApplicationInfo);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.deviceModel;
    }

    public final String component3() {
        return this.sessionSdkVersion;
    }

    public final String component4() {
        return this.osVersion;
    }

    public final LogEnvironment component5() {
        return this.logEnvironment;
    }

    public final AndroidApplicationInfo component6() {
        return this.androidAppInfo;
    }

    public final ApplicationInfo copy(String str, String str2, String str3, String str4, LogEnvironment logEnvironment2, AndroidApplicationInfo androidApplicationInfo) {
        C1177ig.f(str, RemoteConfigConstants.RequestFieldKey.APP_ID);
        C1177ig.f(str2, "deviceModel");
        C1177ig.f(str3, "sessionSdkVersion");
        C1177ig.f(str4, "osVersion");
        C1177ig.f(logEnvironment2, "logEnvironment");
        C1177ig.f(androidApplicationInfo, "androidAppInfo");
        return new ApplicationInfo(str, str2, str3, str4, logEnvironment2, androidApplicationInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationInfo)) {
            return false;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) obj;
        if (C1177ig.a(this.appId, applicationInfo.appId) && C1177ig.a(this.deviceModel, applicationInfo.deviceModel) && C1177ig.a(this.sessionSdkVersion, applicationInfo.sessionSdkVersion) && C1177ig.a(this.osVersion, applicationInfo.osVersion) && this.logEnvironment == applicationInfo.logEnvironment && C1177ig.a(this.androidAppInfo, applicationInfo.androidAppInfo)) {
            return true;
        }
        return false;
    }

    public final AndroidApplicationInfo getAndroidAppInfo() {
        return this.androidAppInfo;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final LogEnvironment getLogEnvironment() {
        return this.logEnvironment;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getSessionSdkVersion() {
        return this.sessionSdkVersion;
    }

    public int hashCode() {
        int g = lf.g(this.osVersion, lf.g(this.sessionSdkVersion, lf.g(this.deviceModel, this.appId.hashCode() * 31, 31), 31), 31);
        return this.androidAppInfo.hashCode() + ((this.logEnvironment.hashCode() + g) * 31);
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.appId + ", deviceModel=" + this.deviceModel + ", sessionSdkVersion=" + this.sessionSdkVersion + ", osVersion=" + this.osVersion + ", logEnvironment=" + this.logEnvironment + ", androidAppInfo=" + this.androidAppInfo + ')';
    }
}
