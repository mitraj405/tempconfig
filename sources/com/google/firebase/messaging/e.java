package com.google.firebase.messaging;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class e implements EventHandler {
    public final /* synthetic */ FirebaseMessaging.AutoInit a;

    public /* synthetic */ e(FirebaseMessaging.AutoInit autoInit) {
        this.a = autoInit;
    }

    public final void handle(Event event) {
        this.a.lambda$initialize$0(event);
    }
}
