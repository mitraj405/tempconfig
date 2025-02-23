package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzfsd implements OnCompleteListener {
    public final /* synthetic */ zzfse zza;

    public /* synthetic */ zzfsd(zzfse zzfse) {
        this.zza = zzfse;
    }

    public final void onComplete(Task task) {
        zzfse zzfse = this.zza;
        if (task.isCanceled()) {
            zzfse.cancel(false);
        } else if (task.isSuccessful()) {
            zzfse.zzc(task.getResult());
        } else {
            Exception exception = task.getException();
            if (exception != null) {
                zzfse.zzd(exception);
                return;
            }
            throw new IllegalStateException();
        }
    }
}
