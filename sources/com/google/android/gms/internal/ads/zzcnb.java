package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcnb implements Runnable {
    public final /* synthetic */ zzcni zza;
    public final /* synthetic */ Throwable zzb;

    public /* synthetic */ zzcnb(zzcni zzcni, Throwable th) {
        this.zza = zzcni;
        this.zzb = th;
    }

    public final void run() {
        this.zza.zzg(this.zzb);
    }
}
