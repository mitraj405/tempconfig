package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzflk implements Runnable {
    public final /* synthetic */ zzfll zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzfkf zzc;

    public /* synthetic */ zzflk(zzfll zzfll, String str, zzfkf zzfkf) {
        this.zza = zzfll;
        this.zzb = str;
        this.zzc = zzfkf;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc);
    }
}
