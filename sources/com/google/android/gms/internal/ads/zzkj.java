package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzkj implements Runnable {
    public final /* synthetic */ zzkk zza;
    public final /* synthetic */ zzfxo zzb;
    public final /* synthetic */ zzui zzc;

    public /* synthetic */ zzkj(zzkk zzkk, zzfxo zzfxo, zzui zzui) {
        this.zza = zzkk;
        this.zzb = zzfxo;
        this.zzc = zzui;
    }

    public final void run() {
        this.zza.zzk(this.zzb, this.zzc);
    }
}
