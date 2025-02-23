package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzyf implements Runnable {
    public final /* synthetic */ zzyg zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzyf(zzyg zzyg, int i, long j, long j2) {
        this.zza = zzyg;
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzb.zzX(this.zzb, this.zzc, this.zzd);
    }
}
