package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.InstallIdProvider;

final class AutoValue_InstallIdProvider_InstallIds extends InstallIdProvider.InstallIds {
    private final String crashlyticsInstallId;
    private final String firebaseAuthenticationToken;
    private final String firebaseInstallationId;

    public AutoValue_InstallIdProvider_InstallIds(String str, String str2, String str3) {
        if (str != null) {
            this.crashlyticsInstallId = str;
            this.firebaseInstallationId = str2;
            this.firebaseAuthenticationToken = str3;
            return;
        }
        throw new NullPointerException("Null crashlyticsInstallId");
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallIdProvider.InstallIds)) {
            return false;
        }
        InstallIdProvider.InstallIds installIds = (InstallIdProvider.InstallIds) obj;
        if (this.crashlyticsInstallId.equals(installIds.getCrashlyticsInstallId()) && ((str = this.firebaseInstallationId) != null ? str.equals(installIds.getFirebaseInstallationId()) : installIds.getFirebaseInstallationId() == null)) {
            String str2 = this.firebaseAuthenticationToken;
            if (str2 == null) {
                if (installIds.getFirebaseAuthenticationToken() == null) {
                    return true;
                }
            } else if (str2.equals(installIds.getFirebaseAuthenticationToken())) {
                return true;
            }
        }
        return false;
    }

    public String getCrashlyticsInstallId() {
        return this.crashlyticsInstallId;
    }

    public String getFirebaseAuthenticationToken() {
        return this.firebaseAuthenticationToken;
    }

    public String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
    }

    public int hashCode() {
        int i;
        int hashCode = (this.crashlyticsInstallId.hashCode() ^ 1000003) * 1000003;
        String str = this.firebaseInstallationId;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i3 = (hashCode ^ i) * 1000003;
        String str2 = this.firebaseAuthenticationToken;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 ^ i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InstallIds{crashlyticsInstallId=");
        sb.append(this.crashlyticsInstallId);
        sb.append(", firebaseInstallationId=");
        sb.append(this.firebaseInstallationId);
        sb.append(", firebaseAuthenticationToken=");
        return C0709Uj.j(sb, this.firebaseAuthenticationToken, "}");
    }
}
