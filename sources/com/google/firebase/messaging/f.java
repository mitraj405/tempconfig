package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TaskCompletionSource f2851a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f2852a;

    public /* synthetic */ f(Context context, boolean z, TaskCompletionSource taskCompletionSource) {
        this.a = context;
        this.f2852a = z;
        this.f2851a = taskCompletionSource;
    }

    public final void run() {
        ProxyNotificationInitializer.lambda$setEnableProxyNotification$0(this.a, this.f2852a, this.f2851a);
    }
}
