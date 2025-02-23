package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdoa;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzw implements Runnable {
    public final /* synthetic */ zzak zza;
    public final /* synthetic */ zzdoa[] zzb;

    public /* synthetic */ zzw(zzak zzak, zzdoa[] zzdoaArr) {
        this.zza = zzak;
        this.zzb = zzdoaArr;
    }

    public final void run() {
        this.zza.zzJ(this.zzb);
    }
}
