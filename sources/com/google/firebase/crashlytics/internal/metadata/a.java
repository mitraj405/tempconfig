package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.concurrent.Callable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Callable {
    public final /* synthetic */ UserMetadata.SerializeableKeysMap a;

    public /* synthetic */ a(UserMetadata.SerializeableKeysMap serializeableKeysMap) {
        this.a = serializeableKeysMap;
    }

    public final Object call() {
        return this.a.lambda$scheduleSerializationTaskIfNeeded$0();
    }
}
