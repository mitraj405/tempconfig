package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.zxing.client.android.Intents;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
public final /* synthetic */ class zzac implements Runnable {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzac(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void run() {
        this.zza.trySetException(new IOException(Intents.Scan.TIMEOUT));
    }
}
