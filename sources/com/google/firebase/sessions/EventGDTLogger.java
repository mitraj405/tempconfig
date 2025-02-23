package com.google.firebase.sessions;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EventGDTLogger.kt */
public final class EventGDTLogger implements EventGDTLoggerInterface {
    private static final String AQS_LOG_SOURCE = "FIREBASE_APPQUALITY_SESSION";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "EventGDTLogger";
    private final Provider<TransportFactory> transportFactoryProvider;

    /* compiled from: EventGDTLogger.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EventGDTLogger(Provider<TransportFactory> provider) {
        C1177ig.f(provider, "transportFactoryProvider");
        this.transportFactoryProvider = provider;
    }

    /* access modifiers changed from: private */
    public final byte[] encode(SessionEvent sessionEvent) {
        String encode = SessionEvents.INSTANCE.getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions().encode(sessionEvent);
        C1177ig.e(encode, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
        byte[] bytes = encode.getBytes(Y4.a);
        C1177ig.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public void log(SessionEvent sessionEvent) {
        C1177ig.f(sessionEvent, "sessionEvent");
        this.transportFactoryProvider.get().getTransport(AQS_LOG_SOURCE, SessionEvent.class, Encoding.of("json"), new L(this, 9)).send(Event.ofData(sessionEvent));
    }
}
