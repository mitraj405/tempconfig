package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcbs implements Runnable {
    public final /* synthetic */ zzccc zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzcbs(zzccc zzccc, int i) {
        this.zza = zzccc;
        this.zzb = i;
    }

    public final void run() {
        this.zza.zzQ(this.zzb);
    }
}
