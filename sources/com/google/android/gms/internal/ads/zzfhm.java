package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfhm implements zzgcf {
    final /* synthetic */ zzfhp zza;
    final /* synthetic */ zzfhq zzb;

    public zzfhm(zzfhq zzfhq, zzfhp zzfhp) {
        this.zza = zzfhp;
        this.zzb = zzfhq;
    }

    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        synchronized (this.zzb) {
            this.zzb.zze = null;
            this.zzb.zzd.addFirst(this.zza);
            zzfhq zzfhq = this.zzb;
            if (zzfhq.zzf == 1) {
                zzfhq.zzh();
            }
        }
    }
}
