package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzko implements Runnable {
    public final /* synthetic */ zzks zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zztz zzc;
    public final /* synthetic */ zzue zzd;

    public /* synthetic */ zzko(zzks zzks, Pair pair, zztz zztz, zzue zzue) {
        this.zza = zzks;
        this.zzb = pair;
        this.zzc = zztz;
        this.zzd = zzue;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzaf(((Integer) pair.first).intValue(), (zzui) pair.second, this.zzc, this.zzd);
    }
}
