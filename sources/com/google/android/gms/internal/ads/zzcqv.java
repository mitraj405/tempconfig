package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcqv implements Runnable {
    public final /* synthetic */ zzcej zza;

    public /* synthetic */ zzcqv(zzcej zzcej) {
        this.zza = zzcej;
    }

    public final void run() {
        this.zza.onPause();
    }
}
