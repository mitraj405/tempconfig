package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcjj implements zzdtm {
    private final Long zza;
    private final String zzb;
    private final zzcif zzc;
    private final zzcjn zzd;

    public /* synthetic */ zzcjj(zzcif zzcif, zzcjn zzcjn, Long l, String str, zzcji zzcji) {
        this.zzc = zzcif;
        this.zzd = zzcjn;
        this.zza = l;
        this.zzb = str;
    }

    public final zzdtw zza() {
        zzcjn zzcjn = this.zzd;
        return zzdtx.zza(this.zza.longValue(), zzcjn.zza, zzdtq.zzc(zzcjn.zzb), this.zzc, this.zzb);
    }

    public final zzdua zzb() {
        zzcjn zzcjn = this.zzd;
        return zzdub.zza(this.zza.longValue(), zzcjn.zza, zzdtq.zzc(zzcjn.zzb), this.zzc, this.zzb);
    }
}
