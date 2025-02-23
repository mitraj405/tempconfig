package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzoz implements Runnable {
    public final /* synthetic */ zzpd zza;
    public final /* synthetic */ zzaf zzb;
    public final /* synthetic */ zzho zzc;

    public /* synthetic */ zzoz(zzpd zzpd, zzaf zzaf, zzho zzho) {
        this.zza = zzpd;
        this.zzb = zzaf;
        this.zzc = zzho;
    }

    public final void run() {
        this.zza.zzr(this.zzb, this.zzc);
    }
}
