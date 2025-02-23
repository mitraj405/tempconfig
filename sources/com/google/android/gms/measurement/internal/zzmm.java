package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzmm {
    final /* synthetic */ zzmh zza;
    private zzml zzb;

    public zzmm(zzmh zzmh) {
        this.zza = zzmh;
    }

    public final void zza(long j) {
        this.zzb = new zzml(this, this.zza.zzb().currentTimeMillis(), j);
        this.zza.zzc.postDelayed(this.zzb, 2000);
    }

    public final void zza() {
        this.zza.zzt();
        if (this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
        this.zza.zzk().zzn.zza(false);
        this.zza.zza(false);
    }
}
