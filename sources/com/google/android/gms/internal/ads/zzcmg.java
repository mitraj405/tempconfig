package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcmg implements zzgbq {
    public final ListenableFuture zza(Object obj) {
        Throwable th = (Throwable) obj;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjA)).booleanValue()) {
            zzu.zzo().zzx(th, "GetTopicsApiWithRecordObservationActionHandlerUnsampled");
        } else {
            zzu.zzo().zzv(th, "GetTopicsApiWithRecordObservationActionHandler");
        }
        return zzgcj.zzh(new C0280ne(zzfxr.zzm()));
    }
}
