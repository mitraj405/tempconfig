package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcfa implements Runnable {
    public final /* synthetic */ zzcfb zza;
    public final /* synthetic */ zzeem zzb;

    public /* synthetic */ zzcfa(zzcfb zzcfb, zzeem zzeem) {
        this.zza = zzcfb;
        this.zzb = zzeem;
    }

    public final void run() {
        this.zzb.zzf(new zzcey(this.zza));
    }
}
