package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcaf implements Runnable {
    public final /* synthetic */ zzcao zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzcaf(zzcao zzcao, int i) {
        this.zza = zzcao;
        this.zzb = i;
    }

    public final void run() {
        this.zza.zzm(this.zzb);
    }
}
