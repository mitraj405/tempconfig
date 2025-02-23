package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcjh implements zzdtl {
    private final zzcif zza;
    private final zzcjn zzb;
    private Long zzc;
    private String zzd;

    public /* synthetic */ zzcjh(zzcif zzcif, zzcjn zzcjn, zzcjg zzcjg) {
        this.zza = zzcif;
        this.zzb = zzcjn;
    }

    public final /* synthetic */ zzdtl zza(String str) {
        str.getClass();
        this.zzd = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzdtl zzb(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }

    public final zzdtm zzc() {
        zzhfk.zzc(this.zzc, Long.class);
        zzhfk.zzc(this.zzd, String.class);
        return new zzcjj(this.zza, this.zzb, this.zzc, this.zzd, (zzcji) null);
    }
}
