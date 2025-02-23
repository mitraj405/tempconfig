package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcsi implements zzgcf {
    final /* synthetic */ zzgcf zza;
    final /* synthetic */ zzcsj zzb;

    public zzcsi(zzcsj zzcsj, zzgcf zzgcf) {
        this.zza = zzgcf;
        this.zzb = zzcsj;
    }

    public final void zza(Throwable th) {
        zzbzo.zze.execute(new zzcsd(this.zzb));
        this.zza.zza(th);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbzo.zze.execute(new zzcsd(this.zzb));
        this.zza.zzb((zzcru) obj);
    }
}
