package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbma implements Runnable {
    public final /* synthetic */ zzbmd zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbma(zzbmd zzbmd, String str) {
        this.zza = zzbmd;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzn(this.zzb);
    }
}
