package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdwn implements Callable {
    public final /* synthetic */ zzdwq zza;
    public final /* synthetic */ zzbvb zzb;

    public /* synthetic */ zzdwn(zzdwq zzdwq, zzbvb zzbvb) {
        this.zza = zzdwq;
        this.zzb = zzbvb;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
