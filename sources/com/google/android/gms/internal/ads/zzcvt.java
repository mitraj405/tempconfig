package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcvt implements Callable {
    public final /* synthetic */ zzcvu zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzcvt(zzcvu zzcvu, ListenableFuture listenableFuture, Bundle bundle) {
        this.zza = zzcvu;
        this.zzb = listenableFuture;
        this.zzc = bundle;
    }

    public final Object call() {
        return this.zza.zza(this.zzb, this.zzc);
    }
}
