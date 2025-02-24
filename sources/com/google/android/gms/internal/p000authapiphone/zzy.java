package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzy  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.3.0 */
final class zzy extends zzk {
    private final /* synthetic */ TaskCompletionSource zza;

    public zzy(zzu zzu, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zza(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }
}
