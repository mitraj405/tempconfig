package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzkq implements Runnable {
    public final /* synthetic */ zzks zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zzue zzc;

    public /* synthetic */ zzkq(zzks zzks, Pair pair, zzue zzue) {
        this.zza = zzks;
        this.zzb = pair;
        this.zzc = zzue;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzae(((Integer) pair.first).intValue(), (zzui) pair.second, this.zzc);
    }
}
