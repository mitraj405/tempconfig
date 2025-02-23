package com.google.firebase.sessions;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SessionGenerator.kt */
public final class SessionGenerator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private SessionDetails currentSession;
    private final String firstSessionId;
    private int sessionIndex;
    private final TimeProvider timeProvider;
    private final Function0<UUID> uuidGenerator;

    /* compiled from: SessionGenerator.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SessionGenerator getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(SessionGenerator.class);
            C1177ig.e(obj, "Firebase.app[SessionGenerator::class.java]");
            return (SessionGenerator) obj;
        }
    }

    public SessionGenerator(TimeProvider timeProvider2, Function0<UUID> function0) {
        C1177ig.f(timeProvider2, "timeProvider");
        C1177ig.f(function0, "uuidGenerator");
        this.timeProvider = timeProvider2;
        this.uuidGenerator = function0;
        this.firstSessionId = generateSessionId();
        this.sessionIndex = -1;
    }

    private final String generateSessionId() {
        String uuid = this.uuidGenerator.invoke().toString();
        C1177ig.e(uuid, "uuidGenerator().toString()");
        String lowerCase = C1268my.T0(uuid, "-", "").toLowerCase(Locale.ROOT);
        C1177ig.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @CanIgnoreReturnValue
    public final SessionDetails generateNewSession() {
        String str;
        int i = this.sessionIndex + 1;
        this.sessionIndex = i;
        if (i == 0) {
            str = this.firstSessionId;
        } else {
            str = generateSessionId();
        }
        this.currentSession = new SessionDetails(str, this.firstSessionId, this.sessionIndex, this.timeProvider.currentTimeUs());
        return getCurrentSession();
    }

    public final SessionDetails getCurrentSession() {
        SessionDetails sessionDetails = this.currentSession;
        if (sessionDetails != null) {
            return sessionDetails;
        }
        C1177ig.l("currentSession");
        throw null;
    }

    public final boolean getHasGenerateSession() {
        if (this.currentSession != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SessionGenerator(TimeProvider timeProvider2, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeProvider2, (i & 2) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
