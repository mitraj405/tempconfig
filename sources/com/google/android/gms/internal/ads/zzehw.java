package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzehw implements zzgcf {
    final /* synthetic */ zzfel zza;
    final /* synthetic */ zzehx zzb;

    public zzehw(zzehx zzehx, zzfel zzfel) {
        this.zza = zzfel;
        this.zzb = zzehx;
    }

    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zzh.zzb(th, this.zza);
            zzfel zza2 = this.zzb.zzh.zza();
            if (this.zza.zzav) {
                while (zza2 != null) {
                    this.zzb.zze(zza2);
                    zza2 = this.zzb.zzh.zza();
                }
            } else if (zza2 != null) {
                this.zzb.zze(zza2);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeio zzeio = (zzeio) obj;
        synchronized (this.zzb) {
            this.zzb.zzh.zzc(zzeio, this.zza);
            zzfel zza2 = this.zzb.zzh.zza();
            if (zza2 != null) {
                this.zzb.zze(zza2);
            }
        }
    }
}
