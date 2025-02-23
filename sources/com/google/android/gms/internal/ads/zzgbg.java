package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzgbg implements Runnable {
    public final /* synthetic */ zzgbi zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzgbg(zzgbi zzgbi, ListenableFuture listenableFuture, int i) {
        this.zza = zzgbi;
        this.zzb = listenableFuture;
        this.zzc = i;
    }

    public final void run() {
        this.zza.zzw(this.zzb, this.zzc);
    }
}
