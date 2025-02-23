package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzevp implements Runnable {
    public final /* synthetic */ zzevr zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzevo zzc;
    public final /* synthetic */ Bundle zzd;

    public /* synthetic */ zzevp(zzevr zzevr, long j, zzevo zzevo, Bundle bundle) {
        this.zza = zzevr;
        this.zzb = j;
        this.zzc = zzevo;
        this.zzd = bundle;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc, this.zzd);
    }
}
