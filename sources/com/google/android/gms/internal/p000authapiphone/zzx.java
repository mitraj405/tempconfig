package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzx  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.3.0 */
final /* synthetic */ class zzx implements RemoteCall {
    private final zzu zza;
    private final String zzb;

    public zzx(zzu zzu, String str) {
        this.zza = zzu;
        this.zzb = str;
    }

    public final void accept(Object obj, Object obj2) {
        zzu zzu = this.zza;
        ((zzj) ((zzv) obj).getService()).zza(this.zzb, (zzl) new zzy(zzu, (TaskCompletionSource) obj2));
    }
}
