package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcbt implements Runnable {
    public final /* synthetic */ zzccc zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcbt(zzccc zzccc, int i, int i2) {
        this.zza = zzccc;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzO(this.zzb, this.zzc);
    }
}
