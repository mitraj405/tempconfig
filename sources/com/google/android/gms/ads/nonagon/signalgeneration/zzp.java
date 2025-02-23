package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzdsf;
import com.google.android.gms.internal.ads.zzdsp;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzp implements Runnable {
    public final /* synthetic */ zzdsp zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Pair[] zzc;

    public /* synthetic */ zzp(zzdsp zzdsp, zzdsf zzdsf, String str, Pair[] pairArr) {
        this.zza = zzdsp;
        this.zzb = str;
        this.zzc = pairArr;
    }

    public final void run() {
        zzq.zze(this.zza, (zzdsf) null, this.zzb, this.zzc);
    }
}
