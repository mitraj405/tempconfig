package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzlb extends zztw {
    private final zzcb zzc = new zzcb();

    public zzlb(zzlc zzlc, zzcc zzcc) {
        super(zzcc);
    }

    public final zzca zzd(int i, zzca zzca, boolean z) {
        zzca zzd = this.zzb.zzd(i, zzca, z);
        if (this.zzb.zze(zzd.zzc, this.zzc, 0).zzb()) {
            zzd.zzl(zzca.zza, zzca.zzb, zzca.zzc, zzca.zzd, 0, zzb.zza, true);
        } else {
            zzd.zzf = true;
        }
        return zzd;
    }
}
