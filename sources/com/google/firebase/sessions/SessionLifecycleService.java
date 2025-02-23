package com.google.firebase.sessions;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.google.firebase.sessions.SessionGenerator;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;

/* compiled from: SessionLifecycleService.kt */
public final class SessionLifecycleService extends Service {
    public static final int BACKGROUNDED = 2;
    private static final int CLIENT_BOUND = 4;
    public static final String CLIENT_CALLBACK_MESSENGER = "ClientCallbackMessenger";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FOREGROUNDED = 1;
    public static final int SESSION_UPDATED = 3;
    public static final String SESSION_UPDATE_EXTRA = "SessionUpdateExtra";
    public static final String TAG = "SessionLifecycleService";
    private final HandlerThread handlerThread = new HandlerThread("FirebaseSessions_HandlerThread");
    private MessageHandler messageHandler;
    private Messenger messenger;

    /* compiled from: SessionLifecycleService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SessionLifecycleService.kt */
    public static final class MessageHandler extends Handler {
        private final ArrayList<Messenger> boundClients = new ArrayList<>();
        private boolean hasForegrounded;
        private long lastMsgTimeMs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessageHandler(Looper looper) {
            super(looper);
            C1177ig.f(looper, "looper");
        }

        private final void broadcastSession() {
            SessionGenerator.Companion companion = SessionGenerator.Companion;
            Objects.toString(companion.getInstance().getCurrentSession());
            SessionFirelogPublisher.Companion.getInstance().logSession(companion.getInstance().getCurrentSession());
            for (Messenger messenger : new ArrayList(this.boundClients)) {
                C1177ig.e(messenger, "it");
                maybeSendSessionToClient(messenger);
            }
        }

        private final void handleBackgrounding(Message message) {
            message.getWhen();
            this.lastMsgTimeMs = message.getWhen();
        }

        private final void handleClientBound(Message message) {
            this.boundClients.add(message.replyTo);
            Messenger messenger = message.replyTo;
            C1177ig.e(messenger, "msg.replyTo");
            maybeSendSessionToClient(messenger);
            Objects.toString(message.replyTo);
            message.getWhen();
            this.boundClients.size();
        }

        private final void handleForegrounding(Message message) {
            message.getWhen();
            if (!this.hasForegrounded) {
                this.hasForegrounded = true;
                newSession();
            } else if (isSessionRestart(message.getWhen())) {
                newSession();
            }
            this.lastMsgTimeMs = message.getWhen();
        }

        private final boolean isSessionRestart(long j) {
            boolean z;
            long j2;
            long j3 = j - this.lastMsgTimeMs;
            long r0 = SessionsSettings.Companion.getInstance().m16getSessionRestartTimeoutUwyO8pc();
            int i = Duration.c;
            if ((((int) r0) & 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z || !(!Duration.f(r0))) {
                j2 = Duration.h(r0, C0513G9.MILLISECONDS);
            } else {
                j2 = r0 >> 1;
            }
            if (j3 > j2) {
                return true;
            }
            return false;
        }

        private final void maybeSendSessionToClient(Messenger messenger) {
            if (this.hasForegrounded) {
                sendSessionToClient(messenger, SessionGenerator.Companion.getInstance().getCurrentSession().getSessionId());
                return;
            }
            String currentSessionId = SessionDatastore.Companion.getInstance().getCurrentSessionId();
            if (currentSessionId != null) {
                sendSessionToClient(messenger, currentSessionId);
            }
        }

        private final void newSession() {
            SessionGenerator.Companion companion = SessionGenerator.Companion;
            companion.getInstance().generateNewSession();
            companion.getInstance().getCurrentSession().getSessionId();
            broadcastSession();
            SessionDatastore.Companion.getInstance().updateSessionId(companion.getInstance().getCurrentSession().getSessionId());
        }

        private final void sendSessionToClient(Messenger messenger, String str) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString(SessionLifecycleService.SESSION_UPDATE_EXTRA, str);
                Message obtain = Message.obtain((Handler) null, 3, 0, 0);
                obtain.setData(bundle);
                messenger.send(obtain);
            } catch (DeadObjectException unused) {
                Objects.toString(messenger);
                this.boundClients.remove(messenger);
            } catch (Exception unused2) {
                Objects.toString(messenger);
            }
        }

        public void handleMessage(Message message) {
            C1177ig.f(message, "msg");
            if (this.lastMsgTimeMs > message.getWhen()) {
                message.getWhen();
                return;
            }
            int i = message.what;
            if (i == 1) {
                handleForegrounding(message);
            } else if (i == 2) {
                handleBackgrounding(message);
            } else if (i != 4) {
                message.toString();
                super.handleMessage(message);
            } else {
                handleClientBound(message);
            }
        }
    }

    private final Messenger getClientCallback(Intent intent) {
        if (Build.VERSION.SDK_INT >= 33) {
            return (Messenger) intent.getParcelableExtra(CLIENT_CALLBACK_MESSENGER, Messenger.class);
        }
        return (Messenger) intent.getParcelableExtra(CLIENT_CALLBACK_MESSENGER);
    }

    public final HandlerThread getHandlerThread$com_google_firebase_firebase_sessions() {
        return this.handlerThread;
    }

    public IBinder onBind(Intent intent) {
        if (intent == null) {
            return null;
        }
        intent.getAction();
        Messenger clientCallback = getClientCallback(intent);
        if (clientCallback != null) {
            Message obtain = Message.obtain((Handler) null, 4, 0, 0);
            obtain.replyTo = clientCallback;
            MessageHandler messageHandler2 = this.messageHandler;
            if (messageHandler2 != null) {
                messageHandler2.sendMessage(obtain);
            }
        }
        Messenger messenger2 = this.messenger;
        if (messenger2 != null) {
            return messenger2.getBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.handlerThread.start();
        Looper looper = this.handlerThread.getLooper();
        C1177ig.e(looper, "handlerThread.looper");
        this.messageHandler = new MessageHandler(looper);
        this.messenger = new Messenger(this.messageHandler);
    }

    public void onDestroy() {
        super.onDestroy();
        this.handlerThread.quit();
    }
}
