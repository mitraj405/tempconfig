package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzftg implements Runnable {
    public final /* synthetic */ zzfti zza;
    public final /* synthetic */ zzfsz zzb;
    public final /* synthetic */ zzftn zzc;

    public /* synthetic */ zzftg(zzfti zzfti, zzfsz zzfsz, zzftn zzftn) {
        this.zza = zzfti;
        this.zzb = zzfsz;
        this.zzc = zzftn;
    }

    public final void run() {
        this.zza.zzc(this.zzb, this.zzc);
    }
}
