package com.google.android.gms.internal.p000authapiphone;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzab  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.3.0 */
abstract class zzab extends TaskApiCall<zzv, Void> {
    private TaskCompletionSource<Void> zza;

    private zzab() {
    }

    public /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zza = taskCompletionSource;
        zza((zzj) ((zzv) anyClient).getService());
    }

    public final void zza(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    public abstract void zza(zzj zzj) throws RemoteException;

    public /* synthetic */ zzab(zzw zzw) {
        this();
    }
}
