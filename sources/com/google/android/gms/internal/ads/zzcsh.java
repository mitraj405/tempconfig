package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcsh implements zzgcf {
    final /* synthetic */ zzgcf zza;
    final /* synthetic */ zzcsj zzb;

    public zzcsh(zzcsj zzcsj, zzgcf zzgcf) {
        this.zza = zzgcf;
        this.zzb = zzcsj;
    }

    public final void zza(Throwable th) {
        this.zza.zza(th);
        zzbzo.zze.execute(new zzcsd(this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcsj.zzb(this.zzb, ((zzcsc) obj).zza, this.zza);
    }
}
