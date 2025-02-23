package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzxe implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzxe(zzaf zzaf, int i) {
        this.zza = 1 != (zzaf.zze & 1) ? false : true;
        this.zzb = zzlf.zza(i, false);
    }

    /* renamed from: zza */
    public final int compareTo(zzxe zzxe) {
        return zzfxg.zzj().zzd(this.zzb, zzxe.zzb).zzd(this.zza, zzxe.zza).zza();
    }
}
