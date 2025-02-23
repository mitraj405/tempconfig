package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzeec implements Runnable {
    public final /* synthetic */ zzfmb zza;
    public final /* synthetic */ View zzb;

    public /* synthetic */ zzeec(zzfmb zzfmb, View view) {
        this.zza = zzfmb;
        this.zzb = view;
    }

    public final void run() {
        this.zza.zze(this.zzb, zzflx.NOT_VISIBLE, "Ad overlay");
    }
}
