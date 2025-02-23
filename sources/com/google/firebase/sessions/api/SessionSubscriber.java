package com.google.firebase.sessions.api;

/* compiled from: SessionSubscriber.kt */
public interface SessionSubscriber {

    /* compiled from: SessionSubscriber.kt */
    public enum Name {
        CRASHLYTICS,
        PERFORMANCE,
        MATT_SAYS_HI
    }

    /* compiled from: SessionSubscriber.kt */
    public static final class SessionDetails {
        private final String sessionId;

        public SessionDetails(String str) {
            C1177ig.f(str, "sessionId");
            this.sessionId = str;
        }

        public static /* synthetic */ SessionDetails copy$default(SessionDetails sessionDetails, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sessionDetails.sessionId;
            }
            return sessionDetails.copy(str);
        }

        public final String component1() {
            return this.sessionId;
        }

        public final SessionDetails copy(String str) {
            C1177ig.f(str, "sessionId");
            return new SessionDetails(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SessionDetails) && C1177ig.a(this.sessionId, ((SessionDetails) obj).sessionId)) {
                return true;
            }
            return false;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            return this.sessionId.hashCode();
        }

        public String toString() {
            return "SessionDetails(sessionId=" + this.sessionId + ')';
        }
    }

    Name getSessionSubscriberName();

    boolean isDataCollectionEnabled();

    void onSessionChanged(SessionDetails sessionDetails);
}
