package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcaw implements Runnable {
    final /* synthetic */ zzcay zza;

    public zzcaw(zzcay zzcay) {
        this.zza = zzcay;
    }

    public final void run() {
        this.zza.zzK("surfaceDestroyed", new String[0]);
    }
}
