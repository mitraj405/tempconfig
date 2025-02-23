package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class g implements OnSuccessListener {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f2853a;

    public /* synthetic */ g(Context context, boolean z) {
        this.a = context;
        this.f2853a = z;
    }

    public final void onSuccess(Object obj) {
        ProxyNotificationPreferences.setProxyRetentionPreferences(this.a, this.f2853a);
    }
}
