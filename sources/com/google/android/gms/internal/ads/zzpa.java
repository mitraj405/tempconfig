package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzpa implements Runnable {
    public final /* synthetic */ zzpd zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzpa(zzpd zzpd, boolean z) {
        this.zza = zzpd;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzt(this.zzb);
    }
}
