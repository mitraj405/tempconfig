package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdnw {
    private final zzcwo zza;
    private final zzcxx zzb;
    private final zzcyk zzc;
    private final zzcyw zzd;
    private final zzdbn zze;
    private final zzfel zzf;
    private final zzfeo zzg;
    private final zzcni zzh;

    public zzdnw(zzcwo zzcwo, zzcxx zzcxx, zzcyk zzcyk, zzcyw zzcyw, zzdbn zzdbn, zzfel zzfel, zzfeo zzfeo, zzcni zzcni) {
        this.zza = zzcwo;
        this.zzb = zzcxx;
        this.zzc = zzcyk;
        this.zzd = zzcyw;
        this.zze = zzdbn;
        this.zzf = zzfel;
        this.zzg = zzfeo;
        this.zzh = zzcni;
    }

    public final void zza(zzdoa zzdoa) {
        zzcxx zzcxx = this.zzb;
        zzdnn zzb2 = zzdoa.zza;
        Objects.requireNonNull(zzcxx);
        zzb2.zzh(this.zza, this.zzc, this.zzd, this.zze, new zzdnv(zzcxx));
        zzdoa.zzh(this.zzf, this.zzg, this.zzh);
    }
}
