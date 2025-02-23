package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseKt;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d;

/* compiled from: FirebaseSessions.kt */
public final class FirebaseSessions {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "FirebaseSessions";
    /* access modifiers changed from: private */
    public final FirebaseApp firebaseApp;
    /* access modifiers changed from: private */
    public final SessionsSettings settings;

    @C1128g8(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", l = {45, 49}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.FirebaseSessions$1  reason: invalid class name */
    /* compiled from: FirebaseSessions.kt */
    public static final class AnonymousClass1 extends Py implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FirebaseSessions this$0;

        {
            this.this$0 = r1;
        }

        /* access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(String str, FirebaseOptions firebaseOptions) {
            SessionsActivityLifecycleCallbacks.INSTANCE.setLifecycleClient((SessionLifecycleClient) null);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, coroutineContext, sessionLifecycleServiceBinder, continuation);
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                v7 r0 = defpackage.C1438v7.COROUTINE_SUSPENDED
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0018
                if (r1 != r2) goto L_0x0010
                defpackage.r1.R(r5)
                goto L_0x0069
            L_0x0010:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L_0x0018:
                defpackage.r1.R(r5)
                goto L_0x002a
            L_0x001c:
                defpackage.r1.R(r5)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r5 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
                r4.label = r3
                java.lang.Object r5 = r5.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r4)
                if (r5 != r0) goto L_0x002a
                return r0
            L_0x002a:
                java.util.Map r5 = (java.util.Map) r5
                java.util.Collection r5 = r5.values()
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                boolean r1 = r5 instanceof java.util.Collection
                if (r1 == 0) goto L_0x0040
                r1 = r5
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x0040
                goto L_0x0057
            L_0x0040:
                java.util.Iterator r5 = r5.iterator()
            L_0x0044:
                boolean r1 = r5.hasNext()
                if (r1 == 0) goto L_0x0057
                java.lang.Object r1 = r5.next()
                com.google.firebase.sessions.api.SessionSubscriber r1 = (com.google.firebase.sessions.api.SessionSubscriber) r1
                boolean r1 = r1.isDataCollectionEnabled()
                if (r1 == 0) goto L_0x0044
                r3 = 0
            L_0x0057:
                if (r3 == 0) goto L_0x005a
                goto L_0x0095
            L_0x005a:
                com.google.firebase.sessions.FirebaseSessions r5 = r4.this$0
                com.google.firebase.sessions.settings.SessionsSettings r5 = r5.settings
                r4.label = r2
                java.lang.Object r5 = r5.updateSettings(r4)
                if (r5 != r0) goto L_0x0069
                return r0
            L_0x0069:
                com.google.firebase.sessions.FirebaseSessions r5 = r4.this$0
                com.google.firebase.sessions.settings.SessionsSettings r5 = r5.settings
                boolean r5 = r5.getSessionsEnabled()
                if (r5 != 0) goto L_0x0076
                goto L_0x0095
            L_0x0076:
                com.google.firebase.sessions.SessionLifecycleClient r5 = new com.google.firebase.sessions.SessionLifecycleClient
                kotlin.coroutines.CoroutineContext r0 = r4
                r5.<init>(r0)
                com.google.firebase.sessions.SessionLifecycleServiceBinder r0 = r5
                r5.bindToService(r0)
                com.google.firebase.sessions.SessionsActivityLifecycleCallbacks r0 = com.google.firebase.sessions.SessionsActivityLifecycleCallbacks.INSTANCE
                r0.setLifecycleClient(r5)
                com.google.firebase.sessions.FirebaseSessions r5 = r4.this$0
                com.google.firebase.FirebaseApp r5 = r5.firebaseApp
                com.google.firebase.sessions.a r0 = new com.google.firebase.sessions.a
                r0.<init>()
                r5.addLifecycleEventListener(r0)
            L_0x0095:
                kotlin.Unit r5 = kotlin.Unit.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }
    }

    /* compiled from: FirebaseSessions.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FirebaseSessions getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(FirebaseSessions.class);
            C1177ig.e(obj, "Firebase.app[FirebaseSessions::class.java]");
            return (FirebaseSessions) obj;
        }
    }

    public FirebaseSessions(FirebaseApp firebaseApp2, SessionsSettings sessionsSettings, final CoroutineContext coroutineContext, final SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        C1177ig.f(firebaseApp2, "firebaseApp");
        C1177ig.f(sessionsSettings, "settings");
        C1177ig.f(coroutineContext, "backgroundDispatcher");
        C1177ig.f(sessionLifecycleServiceBinder, "lifecycleServiceBinder");
        this.firebaseApp = firebaseApp2;
        this.settings = sessionsSettings;
        Context applicationContext = firebaseApp2.getApplicationContext().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(SessionsActivityLifecycleCallbacks.INSTANCE);
            C1354qp.c0(d.a(coroutineContext), new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null));
            return;
        }
        applicationContext.getClass().toString();
    }
}
