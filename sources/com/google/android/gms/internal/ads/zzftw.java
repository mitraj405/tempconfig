package com.google.android.gms.internal.ads;

import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzftw implements Runnable {
    public final /* synthetic */ zzfty zza;

    public /* synthetic */ zzftw(zzfty zzfty) {
        this.zza = zzfty;
    }

    public final void run() {
        zzfty zzfty = this.zza;
        zzfty.zza.zzc.zzc("unlinkToDeath", new Object[0]);
        zzftz zzftz = zzfty.zza;
        IInterface zzb = zzftz.zzj;
        zzb.getClass();
        zzb.asBinder().unlinkToDeath(zzftz.zzh, 0);
        zzfty.zza.zzj = null;
        zzfty.zza.zzf = false;
    }
}
