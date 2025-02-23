package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcdc implements Runnable {
    public final /* synthetic */ zzcbk zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcdc(zzcbk zzcbk, boolean z, long j) {
        this.zza = zzcbk;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzv(this.zzb, this.zzc);
    }
}
