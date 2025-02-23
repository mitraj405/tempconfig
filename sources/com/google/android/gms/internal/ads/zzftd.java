package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzftd implements Runnable {
    public final /* synthetic */ zzfti zza;
    public final /* synthetic */ zzftp zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ zzftn zzd;

    public /* synthetic */ zzftd(zzfti zzfti, zzftp zzftp, int i, zzftn zzftn) {
        this.zza = zzfti;
        this.zzb = zzftp;
        this.zzc = i;
        this.zzd = zzftn;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc, this.zzd);
    }
}
