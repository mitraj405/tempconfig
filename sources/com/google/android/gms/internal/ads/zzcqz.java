package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcqz implements Runnable {
    public final /* synthetic */ zzcra zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcqz(zzcra zzcra, Runnable runnable) {
        this.zza = zzcra;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzl(this.zzb);
    }
}
