package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class h implements Continuation {
    public final /* synthetic */ RequestDeduplicator a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f2854a;

    public /* synthetic */ h(RequestDeduplicator requestDeduplicator, String str) {
        this.a = requestDeduplicator;
        this.f2854a = str;
    }

    public final Object then(Task task) {
        return this.a.lambda$getOrStartGetTokenRequest$0(this.f2854a, task);
    }
}
