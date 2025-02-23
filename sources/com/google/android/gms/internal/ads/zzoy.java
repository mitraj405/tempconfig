package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzoy implements Runnable {
    public final /* synthetic */ zzpd zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzoy(zzpd zzpd, Exception exc) {
        this.zza = zzpd;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzk(this.zzb);
    }
}
