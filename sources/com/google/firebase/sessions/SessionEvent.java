package com.google.firebase.sessions;

import com.google.firebase.encoders.annotations.Encodable;

@Encodable
/* compiled from: SessionEvent.kt */
public final class SessionEvent {
    private final ApplicationInfo applicationInfo;
    private final EventType eventType;
    private final SessionInfo sessionData;

    public SessionEvent(EventType eventType2, SessionInfo sessionInfo, ApplicationInfo applicationInfo2) {
        C1177ig.f(eventType2, "eventType");
        C1177ig.f(sessionInfo, "sessionData");
        C1177ig.f(applicationInfo2, "applicationInfo");
        this.eventType = eventType2;
        this.sessionData = sessionInfo;
        this.applicationInfo = applicationInfo2;
    }

    public static /* synthetic */ SessionEvent copy$default(SessionEvent sessionEvent, EventType eventType2, SessionInfo sessionInfo, ApplicationInfo applicationInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            eventType2 = sessionEvent.eventType;
        }
        if ((i & 2) != 0) {
            sessionInfo = sessionEvent.sessionData;
        }
        if ((i & 4) != 0) {
            applicationInfo2 = sessionEvent.applicationInfo;
        }
        return sessionEvent.copy(eventType2, sessionInfo, applicationInfo2);
    }

    public final EventType component1() {
        return this.eventType;
    }

    public final SessionInfo component2() {
        return this.sessionData;
    }

    public final ApplicationInfo component3() {
        return this.applicationInfo;
    }

    public final SessionEvent copy(EventType eventType2, SessionInfo sessionInfo, ApplicationInfo applicationInfo2) {
        C1177ig.f(eventType2, "eventType");
        C1177ig.f(sessionInfo, "sessionData");
        C1177ig.f(applicationInfo2, "applicationInfo");
        return new SessionEvent(eventType2, sessionInfo, applicationInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionEvent)) {
            return false;
        }
        SessionEvent sessionEvent = (SessionEvent) obj;
        if (this.eventType == sessionEvent.eventType && C1177ig.a(this.sessionData, sessionEvent.sessionData) && C1177ig.a(this.applicationInfo, sessionEvent.applicationInfo)) {
            return true;
        }
        return false;
    }

    public final ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    public final EventType getEventType() {
        return this.eventType;
    }

    public final SessionInfo getSessionData() {
        return this.sessionData;
    }

    public int hashCode() {
        int hashCode = this.sessionData.hashCode();
        return this.applicationInfo.hashCode() + ((hashCode + (this.eventType.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.eventType + ", sessionData=" + this.sessionData + ", applicationInfo=" + this.applicationInfo + ')';
    }
}
