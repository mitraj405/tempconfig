package com.google.android.gms.internal.appset;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.appset.zzc;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
final class zzo extends zze {
    final /* synthetic */ TaskCompletionSource zza;

    public zzo(zzp zzp, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status, zzc zzc) {
        AppSetIdInfo appSetIdInfo;
        if (zzc != null) {
            appSetIdInfo = new AppSetIdInfo(zzc.zzb(), zzc.zza());
        } else {
            appSetIdInfo = null;
        }
        TaskUtil.setResultOrApiException(status, appSetIdInfo, this.zza);
    }
}
