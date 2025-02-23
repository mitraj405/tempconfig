package com.google.firebase.sessions;

/* compiled from: SessionEvent.kt */
public final class SessionInfo {
    private final DataCollectionStatus dataCollectionStatus;
    private final long eventTimestampUs;
    private final String firebaseAuthenticationToken;
    private final String firebaseInstallationId;
    private final String firstSessionId;
    private final String sessionId;
    private final int sessionIndex;

    public SessionInfo(String str, String str2, int i, long j, DataCollectionStatus dataCollectionStatus2, String str3, String str4) {
        C1177ig.f(str, "sessionId");
        C1177ig.f(str2, "firstSessionId");
        C1177ig.f(dataCollectionStatus2, "dataCollectionStatus");
        C1177ig.f(str3, "firebaseInstallationId");
        C1177ig.f(str4, "firebaseAuthenticationToken");
        this.sessionId = str;
        this.firstSessionId = str2;
        this.sessionIndex = i;
        this.eventTimestampUs = j;
        this.dataCollectionStatus = dataCollectionStatus2;
        this.firebaseInstallationId = str3;
        this.firebaseAuthenticationToken = str4;
    }

    public static /* synthetic */ SessionInfo copy$default(SessionInfo sessionInfo, String str, String str2, int i, long j, DataCollectionStatus dataCollectionStatus2, String str3, String str4, int i2, Object obj) {
        String str5;
        String str6;
        int i3;
        long j2;
        DataCollectionStatus dataCollectionStatus3;
        String str7;
        String str8;
        SessionInfo sessionInfo2 = sessionInfo;
        if ((i2 & 1) != 0) {
            str5 = sessionInfo2.sessionId;
        } else {
            str5 = str;
        }
        if ((i2 & 2) != 0) {
            str6 = sessionInfo2.firstSessionId;
        } else {
            str6 = str2;
        }
        if ((i2 & 4) != 0) {
            i3 = sessionInfo2.sessionIndex;
        } else {
            i3 = i;
        }
        if ((i2 & 8) != 0) {
            j2 = sessionInfo2.eventTimestampUs;
        } else {
            j2 = j;
        }
        if ((i2 & 16) != 0) {
            dataCollectionStatus3 = sessionInfo2.dataCollectionStatus;
        } else {
            dataCollectionStatus3 = dataCollectionStatus2;
        }
        if ((i2 & 32) != 0) {
            str7 = sessionInfo2.firebaseInstallationId;
        } else {
            str7 = str3;
        }
        if ((i2 & 64) != 0) {
            str8 = sessionInfo2.firebaseAuthenticationToken;
        } else {
            str8 = str4;
        }
        return sessionInfo.copy(str5, str6, i3, j2, dataCollectionStatus3, str7, str8);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.firstSessionId;
    }

    public final int component3() {
        return this.sessionIndex;
    }

    public final long component4() {
        return this.eventTimestampUs;
    }

    public final DataCollectionStatus component5() {
        return this.dataCollectionStatus;
    }

    public final String component6() {
        return this.firebaseInstallationId;
    }

    public final String component7() {
        return this.firebaseAuthenticationToken;
    }

    public final SessionInfo copy(String str, String str2, int i, long j, DataCollectionStatus dataCollectionStatus2, String str3, String str4) {
        C1177ig.f(str, "sessionId");
        C1177ig.f(str2, "firstSessionId");
        DataCollectionStatus dataCollectionStatus3 = dataCollectionStatus2;
        C1177ig.f(dataCollectionStatus3, "dataCollectionStatus");
        String str5 = str3;
        C1177ig.f(str5, "firebaseInstallationId");
        String str6 = str4;
        C1177ig.f(str6, "firebaseAuthenticationToken");
        return new SessionInfo(str, str2, i, j, dataCollectionStatus3, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) obj;
        if (C1177ig.a(this.sessionId, sessionInfo.sessionId) && C1177ig.a(this.firstSessionId, sessionInfo.firstSessionId) && this.sessionIndex == sessionInfo.sessionIndex && this.eventTimestampUs == sessionInfo.eventTimestampUs && C1177ig.a(this.dataCollectionStatus, sessionInfo.dataCollectionStatus) && C1177ig.a(this.firebaseInstallationId, sessionInfo.firebaseInstallationId) && C1177ig.a(this.firebaseAuthenticationToken, sessionInfo.firebaseAuthenticationToken)) {
            return true;
        }
        return false;
    }

    public final DataCollectionStatus getDataCollectionStatus() {
        return this.dataCollectionStatus;
    }

    public final long getEventTimestampUs() {
        return this.eventTimestampUs;
    }

    public final String getFirebaseAuthenticationToken() {
        return this.firebaseAuthenticationToken;
    }

    public final String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
    }

    public final String getFirstSessionId() {
        return this.firstSessionId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    public int hashCode() {
        int g = lf.g(this.firstSessionId, this.sessionId.hashCode() * 31, 31);
        int hashCode = Long.hashCode(this.eventTimestampUs);
        int hashCode2 = this.dataCollectionStatus.hashCode();
        return this.firebaseAuthenticationToken.hashCode() + lf.g(this.firebaseInstallationId, (hashCode2 + ((hashCode + ((Integer.hashCode(this.sessionIndex) + g) * 31)) * 31)) * 31, 31);
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.sessionId + ", firstSessionId=" + this.firstSessionId + ", sessionIndex=" + this.sessionIndex + ", eventTimestampUs=" + this.eventTimestampUs + ", dataCollectionStatus=" + this.dataCollectionStatus + ", firebaseInstallationId=" + this.firebaseInstallationId + ", firebaseAuthenticationToken=" + this.firebaseAuthenticationToken + ')';
    }
}
