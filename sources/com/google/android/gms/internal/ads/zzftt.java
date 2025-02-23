package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzftt implements Runnable {
    public final /* synthetic */ zzftz zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzftt(zzftz zzftz, Runnable runnable) {
        this.zza = zzftz;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzj(this.zzb);
    }
}
