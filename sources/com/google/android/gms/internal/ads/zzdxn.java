package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdxn implements zzgbq {
    public final ListenableFuture zza(Object obj) {
        TimeoutException timeoutException = (TimeoutException) obj;
        return zzgcj.zzg(new zzdwl(5));
    }
}
