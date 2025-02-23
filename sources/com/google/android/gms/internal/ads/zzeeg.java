package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzeeg implements Runnable {
    public final /* synthetic */ zzflq zza;

    public /* synthetic */ zzeeg(zzflq zzflq) {
        this.zza = zzflq;
    }

    public final void run() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzez)).booleanValue() && zzflo.zzb()) {
            this.zza.zzc();
        }
    }
}
