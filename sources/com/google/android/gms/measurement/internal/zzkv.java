package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzkv implements Runnable {
    private final /* synthetic */ zzkp zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzks zzc;

    public zzkv(zzks zzks, zzkp zzkp, long j) {
        this.zza = zzkp;
        this.zzb = j;
        this.zzc = zzks;
    }

    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        zzks zzks = this.zzc;
        zzks.zza = null;
        zzks.zzo().zza((zzkp) null);
    }
}
