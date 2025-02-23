package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class j implements Callable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ FirebaseMessaging f2855a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ GmsRpc f2856a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Metadata f2857a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ScheduledExecutorService f2858a;

    public /* synthetic */ j(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) {
        this.a = context;
        this.f2858a = scheduledExecutorService;
        this.f2855a = firebaseMessaging;
        this.f2857a = metadata;
        this.f2856a = gmsRpc;
    }

    public final Object call() {
        return TopicsSubscriber.lambda$createInstance$0(this.a, this.f2858a, this.f2855a, this.f2857a, this.f2856a);
    }
}
