package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

final class AutoValue_StaticSessionData_OsData extends StaticSessionData.OsData {
    private final boolean isRooted;
    private final String osCodeName;
    private final String osRelease;

    public AutoValue_StaticSessionData_OsData(String str, String str2, boolean z) {
        if (str != null) {
            this.osRelease = str;
            if (str2 != null) {
                this.osCodeName = str2;
                this.isRooted = z;
                return;
            }
            throw new NullPointerException("Null osCodeName");
        }
        throw new NullPointerException("Null osRelease");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.OsData)) {
            return false;
        }
        StaticSessionData.OsData osData = (StaticSessionData.OsData) obj;
        if (!this.osRelease.equals(osData.osRelease()) || !this.osCodeName.equals(osData.osCodeName()) || this.isRooted != osData.isRooted()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        int hashCode = (((this.osRelease.hashCode() ^ 1000003) * 1000003) ^ this.osCodeName.hashCode()) * 1000003;
        if (this.isRooted) {
            i = 1231;
        } else {
            i = 1237;
        }
        return hashCode ^ i;
    }

    public boolean isRooted() {
        return this.isRooted;
    }

    public String osCodeName() {
        return this.osCodeName;
    }

    public String osRelease() {
        return this.osRelease;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OsData{osRelease=");
        sb.append(this.osRelease);
        sb.append(", osCodeName=");
        sb.append(this.osCodeName);
        sb.append(", isRooted=");
        return xx.G(sb, this.isRooted, "}");
    }
}
