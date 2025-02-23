package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcbv implements Runnable {
    public final /* synthetic */ zzccc zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcbv(zzccc zzccc, boolean z, long j) {
        this.zza = zzccc;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzJ(this.zzb, this.zzc);
    }
}
