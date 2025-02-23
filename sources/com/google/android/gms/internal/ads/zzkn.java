package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzkn implements Runnable {
    public final /* synthetic */ zzks zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zztz zzc;
    public final /* synthetic */ zzue zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzkn(zzks zzks, Pair pair, zztz zztz, zzue zzue, IOException iOException, boolean z) {
        this.zza = zzks;
        this.zzb = pair;
        this.zzc = zztz;
        this.zzd = zzue;
        this.zze = iOException;
        this.zzf = z;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzah(((Integer) pair.first).intValue(), (zzui) pair.second, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
