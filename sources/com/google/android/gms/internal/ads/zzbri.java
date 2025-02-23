package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbri implements Runnable {
    public final /* synthetic */ zzbrk zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzbri(zzbrk zzbrk, boolean z) {
        this.zza = zzbrk;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
