package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzuo implements Runnable {
    public final /* synthetic */ zzur zza;
    public final /* synthetic */ zzus zzb;
    public final /* synthetic */ zztz zzc;
    public final /* synthetic */ zzue zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzuo(zzur zzur, zzus zzus, zztz zztz, zzue zzue, IOException iOException, boolean z) {
        this.zza = zzur;
        this.zzb = zzus;
        this.zzc = zztz;
        this.zzd = zzue;
        this.zze = iOException;
        this.zzf = z;
    }

    public final void run() {
        this.zzb.zzah(0, this.zza.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
