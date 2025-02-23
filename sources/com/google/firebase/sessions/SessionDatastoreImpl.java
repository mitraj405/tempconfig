package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import in.juspay.hyper.constants.LogCategory;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: SessionDatastore.kt */
public final class SessionDatastoreImpl implements SessionDatastore {
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "FirebaseSessionsRepo";
    /* access modifiers changed from: private */
    public static final ReadOnlyProperty<Context, DataStore<Preferences>> dataStore$delegate = r1.L(SessionDataStoreConfigs.INSTANCE.getSESSIONS_CONFIG_NAME(), new wt(SessionDatastoreImpl$Companion$dataStore$2.INSTANCE));
    private final CoroutineContext backgroundDispatcher;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final AtomicReference<FirebaseSessionsData> currentSessionFromDatastore = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final Flow<FirebaseSessionsData> firebaseSessionDataFlow;

    @C1128g8(c = "com.google.firebase.sessions.SessionDatastoreImpl$1", f = "SessionDatastore.kt", l = {82}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$1  reason: invalid class name */
    /* compiled from: SessionDatastore.kt */
    public static final class AnonymousClass1 extends Py implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SessionDatastoreImpl this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                r1.R(obj);
                Flow access$getFirebaseSessionDataFlow$p = this.this$0.firebaseSessionDataFlow;
                final SessionDatastoreImpl sessionDatastoreImpl = this.this$0;
                AnonymousClass1 r1 = new FlowCollector() {
                    public final Object emit(FirebaseSessionsData firebaseSessionsData, Continuation<? super Unit> continuation) {
                        sessionDatastoreImpl.currentSessionFromDatastore.set(firebaseSessionsData);
                        return Unit.a;
                    }
                };
                this.label = 1;
                if (access$getFirebaseSessionDataFlow$p.collect(r1, this) == v7Var) {
                    return v7Var;
                }
            } else if (i == 1) {
                r1.R(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.a;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }
    }

    /* compiled from: SessionDatastore.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;

        static {
            C0557Jq jq = new C0557Jq(Companion.class);
            C0584Ls.a.getClass();
            $$delegatedProperties = new KProperty[]{jq};
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final DataStore<Preferences> getDataStore(Context context) {
            return SessionDatastoreImpl.dataStore$delegate.a(context, $$delegatedProperties[0]);
        }
    }

    /* compiled from: SessionDatastore.kt */
    public static final class FirebaseSessionDataKeys {
        public static final FirebaseSessionDataKeys INSTANCE = new FirebaseSessionDataKeys();
        private static final Preferences.Key<String> SESSION_ID = new Preferences.Key<>("session_id");

        private FirebaseSessionDataKeys() {
        }

        public final Preferences.Key<String> getSESSION_ID() {
            return SESSION_ID;
        }
    }

    public SessionDatastoreImpl(Context context2, CoroutineContext coroutineContext) {
        C1177ig.f(context2, LogCategory.CONTEXT);
        C1177ig.f(coroutineContext, "backgroundDispatcher");
        this.context = context2;
        this.backgroundDispatcher = coroutineContext;
        this.firebaseSessionDataFlow = new SessionDatastoreImpl$special$$inlined$map$1(new C0565Kc(Companion.getDataStore(context2).b(), new SessionDatastoreImpl$firebaseSessionDataFlow$1((Continuation<? super SessionDatastoreImpl$firebaseSessionDataFlow$1>) null)), this);
        C1354qp.c0(d.a(coroutineContext), new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null));
    }

    /* access modifiers changed from: private */
    public final FirebaseSessionsData mapSessionsData(Preferences preferences) {
        return new FirebaseSessionsData((String) preferences.b(FirebaseSessionDataKeys.INSTANCE.getSESSION_ID()));
    }

    public String getCurrentSessionId() {
        FirebaseSessionsData firebaseSessionsData = this.currentSessionFromDatastore.get();
        if (firebaseSessionsData != null) {
            return firebaseSessionsData.getSessionId();
        }
        return null;
    }

    public void updateSessionId(String str) {
        C1177ig.f(str, "sessionId");
        C1354qp.c0(d.a(this.backgroundDispatcher), new SessionDatastoreImpl$updateSessionId$1(this, str, (Continuation<? super SessionDatastoreImpl$updateSessionId$1>) null));
    }
}
