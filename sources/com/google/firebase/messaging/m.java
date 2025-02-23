package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ m(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.a;
        switch (i) {
            case 0:
                ((WithinAppServiceConnection.BindRequest) obj).lambda$arrangeTimeout$0();
                return;
            default:
                ((FirebaseMessaging) obj).lambda$new$4();
                return;
        }
    }
}
