package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzemr implements zzemz {
    final /* synthetic */ zzems zza;

    public zzemr(zzems zzems) {
        this.zza = zzems;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzj = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdfo zzdfo = (zzdfo) obj;
        synchronized (this.zza) {
            this.zza.zzj = zzdfo;
            this.zza.zzj.zzk();
        }
    }
}
