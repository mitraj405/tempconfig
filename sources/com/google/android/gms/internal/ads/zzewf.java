package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzewf implements Runnable {
    public final /* synthetic */ Throwable zza;

    public /* synthetic */ zzewf(Throwable th) {
        this.zza = th;
    }

    public final void run() {
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbbw.zzjA)).booleanValue();
        Throwable th = this.zza;
        if (booleanValue) {
            zzu.zzo().zzx(th, "TopicsSignalUnsampled.fetchTopicsSignal");
        } else {
            zzu.zzo().zzv(th, "TopicsSignal.fetchTopicsSignal");
        }
    }
}
