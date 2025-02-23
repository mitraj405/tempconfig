package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzejm implements zzful {
    public final /* synthetic */ zzcej zza;
    public final /* synthetic */ zzfel zzb;
    public final /* synthetic */ zzdoq zzc;

    public /* synthetic */ zzejm(zzejq zzejq, zzcej zzcej, zzfel zzfel, zzdoq zzdoq) {
        this.zza = zzcej;
        this.zzb = zzfel;
        this.zzc = zzdoq;
    }

    public final Object apply(Object obj) {
        zzcej zzcej = this.zza;
        if (this.zzb.zzM) {
            zzcej.zzah();
        }
        zzdoq zzdoq = this.zzc;
        zzcej.zzab();
        zzcej.onPause();
        return zzdoq.zzi();
    }
}
