package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class l implements OnCompleteListener {
    public final /* synthetic */ WithinAppServiceConnection.BindRequest a;

    public /* synthetic */ l(WithinAppServiceConnection.BindRequest bindRequest) {
        this.a = bindRequest;
    }

    public final void onComplete(Task task) {
        this.a.finish();
    }
}
