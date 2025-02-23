package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcen implements Runnable {
    public final /* synthetic */ zzcer zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcen(zzcer zzcer, boolean z, long j) {
        this.zza = zzcer;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzo(this.zzb, this.zzc);
    }
}
