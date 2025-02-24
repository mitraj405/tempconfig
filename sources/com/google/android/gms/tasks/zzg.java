package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
final class zzg implements Runnable {
    final /* synthetic */ zzh zza;

    public zzg(zzh zzh) {
        this.zza = zzh;
    }

    public final void run() {
        synchronized (this.zza.zzb) {
            zzh zzh = this.zza;
            if (zzh.zzc != null) {
                zzh.zzc.onCanceled();
            }
        }
    }
}
