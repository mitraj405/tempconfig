package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
final class zzi implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzj zzb;

    public zzi(zzj zzj, Task task) {
        this.zzb = zzj;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            zzj zzj = this.zzb;
            if (zzj.zzc != null) {
                zzj.zzc.onComplete(this.zza);
            }
        }
    }
}
