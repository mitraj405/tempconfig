package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaip {
    public final zzaiw zza;
    public final zzaiz zzb;
    public final zzadp zzc;
    public final zzadq zzd;
    public int zze;

    public zzaip(zzaiw zzaiw, zzaiz zzaiz, zzadp zzadp) {
        zzadq zzadq;
        this.zza = zzaiw;
        this.zzb = zzaiz;
        this.zzc = zzadp;
        if ("audio/true-hd".equals(zzaiw.zzf.zzm)) {
            zzadq = new zzadq();
        } else {
            zzadq = null;
        }
        this.zzd = zzadq;
    }
}
