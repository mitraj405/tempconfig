package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdxi implements Callable {
    public final /* synthetic */ zzdxk zza;
    public final /* synthetic */ zzbvb zzb;

    public /* synthetic */ zzdxi(zzdxk zzdxk, zzbvb zzbvb) {
        this.zza = zzdxk;
        this.zzb = zzbvb;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
