package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzot implements Runnable {
    public final /* synthetic */ zzpd zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzot(zzpd zzpd, long j) {
        this.zza = zzpd;
        this.zzb = j;
    }

    public final void run() {
        this.zza.zzs(this.zzb);
    }
}
