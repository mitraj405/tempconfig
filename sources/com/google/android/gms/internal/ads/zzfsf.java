package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfsf {
    public static ListenableFuture zza(Task task, CancellationTokenSource cancellationTokenSource) {
        zzfse zzfse = new zzfse(task, (Runnable) null);
        task.addOnCompleteListener(zzgda.zzb(), new zzfsd(zzfse));
        return zzfse;
    }
}
