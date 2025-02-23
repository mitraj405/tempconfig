package com.google.firebase.iid.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

@KeepForSdk
/* compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
public interface FirebaseInstanceIdInternal {

    @KeepForSdk
    /* compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
    public interface NewTokenListener {
        @KeepForSdk
        void onNewToken(String str);
    }

    @KeepForSdk
    void addNewTokenListener(NewTokenListener newTokenListener);

    @KeepForSdk
    void deleteToken(String str, String str2) throws IOException;

    @KeepForSdk
    String getId();

    @KeepForSdk
    String getToken();

    @KeepForSdk
    Task<String> getTokenTask();
}
