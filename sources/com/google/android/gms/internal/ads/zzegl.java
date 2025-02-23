package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzegl implements Callable {
    public final /* synthetic */ zzegn zza;
    public final /* synthetic */ zzfex zzb;
    public final /* synthetic */ zzfel zzc;

    public /* synthetic */ zzegl(zzegn zzegn, zzfex zzfex, zzfel zzfel) {
        this.zza = zzegn;
        this.zzb = zzfex;
        this.zzc = zzfel;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc);
    }
}
