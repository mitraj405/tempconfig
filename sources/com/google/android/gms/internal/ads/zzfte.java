package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzfte implements Runnable {
    public final /* synthetic */ zzfti zza;
    public final /* synthetic */ zzftk zzb;
    public final /* synthetic */ zzftn zzc;

    public /* synthetic */ zzfte(zzfti zzfti, zzftk zzftk, zzftn zzftn) {
        this.zza = zzfti;
        this.zzb = zzftk;
        this.zzc = zzftn;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc);
    }
}
