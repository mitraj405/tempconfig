package com.google.firebase.messaging;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ SharedPreferencesQueue a;

    public /* synthetic */ i(SharedPreferencesQueue sharedPreferencesQueue) {
        this.a = sharedPreferencesQueue;
    }

    public final void run() {
        this.a.syncState();
    }
}
