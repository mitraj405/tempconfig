package com.google.firebase.sessions;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

@C1128g8(c = "com.google.firebase.sessions.SessionDatastoreImpl$firebaseSessionDataFlow$1", f = "SessionDatastore.kt", l = {76}, m = "invokeSuspend")
/* compiled from: SessionDatastore.kt */
public final class SessionDatastoreImpl$firebaseSessionDataFlow$1 extends Py implements C0694Td<FlowCollector<? super Preferences>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public SessionDatastoreImpl$firebaseSessionDataFlow$1(Continuation<? super SessionDatastoreImpl$firebaseSessionDataFlow$1> continuation) {
        super(3, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            r1.R(obj);
            Throwable th = (Throwable) this.L$1;
            MutablePreferences mutablePreferences = new MutablePreferences(true, 1);
            this.L$0 = null;
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(mutablePreferences, this) == v7Var) {
                return v7Var;
            }
        } else if (i == 1) {
            r1.R(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.a;
    }

    public final Object invoke(FlowCollector<? super Preferences> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        SessionDatastoreImpl$firebaseSessionDataFlow$1 sessionDatastoreImpl$firebaseSessionDataFlow$1 = new SessionDatastoreImpl$firebaseSessionDataFlow$1(continuation);
        sessionDatastoreImpl$firebaseSessionDataFlow$1.L$0 = flowCollector;
        sessionDatastoreImpl$firebaseSessionDataFlow$1.L$1 = th;
        return sessionDatastoreImpl$firebaseSessionDataFlow$1.invokeSuspend(Unit.a);
    }
}
