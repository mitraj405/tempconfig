package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeqm implements zzevo {
    private final zzgcu zza;
    private final zzdqg zzb;
    private final String zzc;
    private final zzffg zzd;

    public zzeqm(zzgcu zzgcu, zzdqg zzdqg, zzffg zzffg, String str) {
        this.zza = zzgcu;
        this.zzb = zzdqg;
        this.zzd = zzffg;
        this.zzc = str;
    }

    public final int zza() {
        return 17;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeql(this));
    }

    public final /* synthetic */ zzeqn zzc() throws Exception {
        zzffg zzffg = this.zzd;
        zzdqg zzdqg = this.zzb;
        return new zzeqn(zzdqg.zzb(zzffg.zzf, this.zzc), zzdqg.zza());
    }
}
