package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcax implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcay zzb;

    public zzcax(zzcay zzcay, boolean z) {
        this.zza = z;
        this.zzb = zzcay;
    }

    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
