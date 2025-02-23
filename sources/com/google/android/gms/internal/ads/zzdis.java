package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdis implements Runnable {
    public final /* synthetic */ zzdiw zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzdis(zzdiw zzdiw, boolean z) {
        this.zza = zzdiw;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzy(this.zzb);
    }
}
