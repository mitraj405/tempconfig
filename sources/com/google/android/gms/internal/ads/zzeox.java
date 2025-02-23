package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeox implements zzevo {
    private final zzgcu zza;
    private final zzffg zzb;
    private final VersionInfoParcel zzc;
    private final zzbzi zzd;

    public zzeox(zzgcu zzgcu, zzffg zzffg, VersionInfoParcel versionInfoParcel, zzbzi zzbzi) {
        this.zza = zzgcu;
        this.zzb = zzffg;
        this.zzc = versionInfoParcel;
        this.zzd = zzbzi;
    }

    public final int zza() {
        return 9;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeow(this));
    }

    public final /* synthetic */ zzeoy zzc() throws Exception {
        return new zzeoy(this.zzb.zzj, this.zzc, this.zzd.zzm());
    }
}
