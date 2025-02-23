package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfaq implements zzemz {
    final /* synthetic */ zzfar zza;

    public zzfaq(zzfar zzfar) {
        this.zza = zzfar;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpe zzcpe = (zzcpe) obj;
        synchronized (this.zza) {
            zzcpe zzcpe2 = this.zza.zza;
            if (zzcpe2 != null) {
                zzcpe2.zzb();
            }
            zzfar zzfar = this.zza;
            zzfar.zza = zzcpe;
            zzcpe.zzc(zzfar);
            zzfar zzfar2 = this.zza;
            zzfar2.zzg.zzk(new zzcpf(zzcpe, zzfar2, zzfar2.zzg, zzfar2.zzi));
            zzcpe.zzk();
        }
    }
}
