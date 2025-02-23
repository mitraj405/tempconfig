package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzpc implements Runnable {
    public final /* synthetic */ zzpd zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzpc(zzpd zzpd, String str) {
        this.zza = zzpd;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
