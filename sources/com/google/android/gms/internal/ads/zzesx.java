package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzesx implements zzevo {
    private final zzgcu zza;
    private final zzdvi zzb;

    public zzesx(zzgcu zzgcu, zzdvi zzdvi) {
        this.zza = zzgcu;
        this.zzb = zzdvi;
    }

    public final int zza() {
        return 23;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzesw(this));
    }

    public final /* synthetic */ zzesy zzc() throws Exception {
        zzdvi zzdvi = this.zzb;
        String zzc = zzdvi.zzc();
        boolean zzr = zzdvi.zzr();
        boolean zzl = zzu.zzs().zzl();
        zzdvi zzdvi2 = this.zzb;
        return new zzesy(zzc, zzr, zzl, zzdvi2.zzp(), zzdvi2.zzs());
    }
}
