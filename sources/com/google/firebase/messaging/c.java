package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c implements RequestDeduplicator.GetTokenRequest, SuccessContinuation {
    public final /* synthetic */ FirebaseMessaging a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Store.Token f2848a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f2849a;

    public /* synthetic */ c(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.a = firebaseMessaging;
        this.f2849a = str;
        this.f2848a = token;
    }

    public final Task start() {
        return this.a.lambda$blockingGetToken$14(this.f2849a, this.f2848a);
    }

    public final Task then(Object obj) {
        return this.a.lambda$blockingGetToken$13(this.f2849a, this.f2848a, (String) obj);
    }
}
