package com.google.firebase.sessions;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d;

/* compiled from: SessionLifecycleClient.kt */
public final class SessionLifecycleClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_QUEUED_MESSAGES = 20;
    public static final String TAG = "SessionLifecycleClient";
    private final CoroutineContext backgroundDispatcher;
    /* access modifiers changed from: private */
    public final LinkedBlockingDeque<Message> queuedMessages = new LinkedBlockingDeque<>(20);
    /* access modifiers changed from: private */
    public Messenger service;
    /* access modifiers changed from: private */
    public boolean serviceBound;
    private final SessionLifecycleClient$serviceConnection$1 serviceConnection = new SessionLifecycleClient$serviceConnection$1(this);

    /* compiled from: SessionLifecycleClient.kt */
    public static final class ClientUpdateHandler extends Handler {
        private final CoroutineContext backgroundDispatcher;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClientUpdateHandler(CoroutineContext coroutineContext) {
            super(Looper.getMainLooper());
            C1177ig.f(coroutineContext, "backgroundDispatcher");
            this.backgroundDispatcher = coroutineContext;
        }

        private final void handleSessionUpdate(String str) {
            C1354qp.c0(d.a(this.backgroundDispatcher), new SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(str, (Continuation<? super SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1>) null));
        }

        public void handleMessage(Message message) {
            String str;
            C1177ig.f(message, "msg");
            if (message.what == 3) {
                Bundle data = message.getData();
                if (data == null || (str = data.getString(SessionLifecycleService.SESSION_UPDATE_EXTRA)) == null) {
                    str = "";
                }
                handleSessionUpdate(str);
                return;
            }
            message.toString();
            super.handleMessage(message);
        }
    }

    /* compiled from: SessionLifecycleClient.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionLifecycleClient(CoroutineContext coroutineContext) {
        C1177ig.f(coroutineContext, "backgroundDispatcher");
        this.backgroundDispatcher = coroutineContext;
    }

    /* access modifiers changed from: private */
    public final List<Message> drainQueue() {
        ArrayList arrayList = new ArrayList();
        this.queuedMessages.drainTo(arrayList);
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.os.Message} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Message getLatestByCode(java.util.List<android.os.Message> r7, int r8) {
        /*
            r6 = this;
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x000b:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0025
            java.lang.Object r1 = r7.next()
            r2 = r1
            android.os.Message r2 = (android.os.Message) r2
            int r2 = r2.what
            if (r2 != r8) goto L_0x001e
            r2 = 1
            goto L_0x001f
        L_0x001e:
            r2 = 0
        L_0x001f:
            if (r2 == 0) goto L_0x000b
            r0.add(r1)
            goto L_0x000b
        L_0x0025:
            java.util.Iterator r7 = r0.iterator()
            boolean r8 = r7.hasNext()
            if (r8 != 0) goto L_0x0031
            r7 = 0
            goto L_0x005c
        L_0x0031:
            java.lang.Object r8 = r7.next()
            boolean r0 = r7.hasNext()
            if (r0 != 0) goto L_0x003d
        L_0x003b:
            r7 = r8
            goto L_0x005c
        L_0x003d:
            r0 = r8
            android.os.Message r0 = (android.os.Message) r0
            long r0 = r0.getWhen()
        L_0x0044:
            java.lang.Object r2 = r7.next()
            r3 = r2
            android.os.Message r3 = (android.os.Message) r3
            long r3 = r3.getWhen()
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0055
            r8 = r2
            r0 = r3
        L_0x0055:
            boolean r2 = r7.hasNext()
            if (r2 != 0) goto L_0x0044
            goto L_0x003b
        L_0x005c:
            android.os.Message r7 = (android.os.Message) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionLifecycleClient.getLatestByCode(java.util.List, int):android.os.Message");
    }

    private final void queueMessage(Message message) {
        if (this.queuedMessages.offer(message)) {
            int i = message.what;
            this.queuedMessages.size();
            return;
        }
        int i2 = message.what;
    }

    private final void sendLifecycleEvent(int i) {
        List<Message> drainQueue = drainQueue();
        Message obtain = Message.obtain((Handler) null, i, 0, 0);
        C1177ig.e(obtain, "obtain(null, messageCode, 0, 0)");
        drainQueue.add(obtain);
        sendLifecycleEvents(drainQueue);
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public final Job sendLifecycleEvents(List<Message> list) {
        return C1354qp.c0(d.a(this.backgroundDispatcher), new SessionLifecycleClient$sendLifecycleEvents$1(this, list, (Continuation<? super SessionLifecycleClient$sendLifecycleEvents$1>) null));
    }

    /* access modifiers changed from: private */
    public final void sendMessageToServer(Message message) {
        Messenger messenger = this.service;
        if (messenger != null) {
            try {
                int i = message.what;
                if (messenger != null) {
                    messenger.send(message);
                }
            } catch (RemoteException unused) {
                int i2 = message.what;
                queueMessage(message);
            }
        } else {
            queueMessage(message);
        }
    }

    public final void backgrounded() {
        sendLifecycleEvent(2);
    }

    public final void bindToService(SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        C1177ig.f(sessionLifecycleServiceBinder, "sessionLifecycleServiceBinder");
        sessionLifecycleServiceBinder.bindToService(new Messenger(new ClientUpdateHandler(this.backgroundDispatcher)), this.serviceConnection);
    }

    public final void foregrounded() {
        sendLifecycleEvent(1);
    }
}
