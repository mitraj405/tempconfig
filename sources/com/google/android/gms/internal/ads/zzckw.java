package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzckw implements Runnable {
    public final /* synthetic */ zzcky zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzckw(zzcky zzcky, Runnable runnable) {
        this.zza = zzcky;
        this.zzb = runnable;
    }

    public final void run() {
        zzbzo.zze.execute(new zzckx(this.zza, this.zzb));
    }
}
