package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdsf;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ zzl zza;
    public final /* synthetic */ zzdsf zzb;
    public final /* synthetic */ ArrayDeque zzc;
    public final /* synthetic */ ArrayDeque zzd;

    public /* synthetic */ zzi(zzl zzl, zzdsf zzdsf, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        this.zza = zzl;
        this.zzb = zzdsf;
        this.zzc = arrayDeque;
        this.zzd = arrayDeque2;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc, this.zzd);
    }
}
