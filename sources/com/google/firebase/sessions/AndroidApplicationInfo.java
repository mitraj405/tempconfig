package com.google.firebase.sessions;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;

/* compiled from: ApplicationInfo.kt */
public final class AndroidApplicationInfo {
    private final String appBuildVersion;
    private final List<ProcessDetails> appProcessDetails;
    private final ProcessDetails currentProcessDetails;
    private final String deviceManufacturer;
    private final String packageName;
    private final String versionName;

    public AndroidApplicationInfo(String str, String str2, String str3, String str4, ProcessDetails processDetails, List<ProcessDetails> list) {
        C1177ig.f(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        C1177ig.f(str2, "versionName");
        C1177ig.f(str3, "appBuildVersion");
        C1177ig.f(str4, "deviceManufacturer");
        C1177ig.f(processDetails, "currentProcessDetails");
        C1177ig.f(list, "appProcessDetails");
        this.packageName = str;
        this.versionName = str2;
        this.appBuildVersion = str3;
        this.deviceManufacturer = str4;
        this.currentProcessDetails = processDetails;
        this.appProcessDetails = list;
    }

    public static /* synthetic */ AndroidApplicationInfo copy$default(AndroidApplicationInfo androidApplicationInfo, String str, String str2, String str3, String str4, ProcessDetails processDetails, List<ProcessDetails> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = androidApplicationInfo.packageName;
        }
        if ((i & 2) != 0) {
            str2 = androidApplicationInfo.versionName;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = androidApplicationInfo.appBuildVersion;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = androidApplicationInfo.deviceManufacturer;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            processDetails = androidApplicationInfo.currentProcessDetails;
        }
        ProcessDetails processDetails2 = processDetails;
        if ((i & 32) != 0) {
            list = androidApplicationInfo.appProcessDetails;
        }
        return androidApplicationInfo.copy(str, str5, str6, str7, processDetails2, list);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.versionName;
    }

    public final String component3() {
        return this.appBuildVersion;
    }

    public final String component4() {
        return this.deviceManufacturer;
    }

    public final ProcessDetails component5() {
        return this.currentProcessDetails;
    }

    public final List<ProcessDetails> component6() {
        return this.appProcessDetails;
    }

    public final AndroidApplicationInfo copy(String str, String str2, String str3, String str4, ProcessDetails processDetails, List<ProcessDetails> list) {
        C1177ig.f(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        C1177ig.f(str2, "versionName");
        C1177ig.f(str3, "appBuildVersion");
        C1177ig.f(str4, "deviceManufacturer");
        C1177ig.f(processDetails, "currentProcessDetails");
        C1177ig.f(list, "appProcessDetails");
        return new AndroidApplicationInfo(str, str2, str3, str4, processDetails, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidApplicationInfo)) {
            return false;
        }
        AndroidApplicationInfo androidApplicationInfo = (AndroidApplicationInfo) obj;
        if (C1177ig.a(this.packageName, androidApplicationInfo.packageName) && C1177ig.a(this.versionName, androidApplicationInfo.versionName) && C1177ig.a(this.appBuildVersion, androidApplicationInfo.appBuildVersion) && C1177ig.a(this.deviceManufacturer, androidApplicationInfo.deviceManufacturer) && C1177ig.a(this.currentProcessDetails, androidApplicationInfo.currentProcessDetails) && C1177ig.a(this.appProcessDetails, androidApplicationInfo.appProcessDetails)) {
            return true;
        }
        return false;
    }

    public final String getAppBuildVersion() {
        return this.appBuildVersion;
    }

    public final List<ProcessDetails> getAppProcessDetails() {
        return this.appProcessDetails;
    }

    public final ProcessDetails getCurrentProcessDetails() {
        return this.currentProcessDetails;
    }

    public final String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        int g = lf.g(this.deviceManufacturer, lf.g(this.appBuildVersion, lf.g(this.versionName, this.packageName.hashCode() * 31, 31), 31), 31);
        return this.appProcessDetails.hashCode() + ((this.currentProcessDetails.hashCode() + g) * 31);
    }

    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.packageName + ", versionName=" + this.versionName + ", appBuildVersion=" + this.appBuildVersion + ", deviceManufacturer=" + this.deviceManufacturer + ", currentProcessDetails=" + this.currentProcessDetails + ", appProcessDetails=" + this.appProcessDetails + ')';
    }
}
