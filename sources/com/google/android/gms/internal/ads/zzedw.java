package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzedw implements Runnable {
    public final /* synthetic */ zzflq zza;
    public final /* synthetic */ View zzb;

    public /* synthetic */ zzedw(zzflq zzflq, View view) {
        this.zza = zzflq;
        this.zzb = view;
    }

    public final void run() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzez)).booleanValue() && zzflo.zzb()) {
            this.zza.zzb(this.zzb, zzflx.NOT_VISIBLE, "Ad overlay");
        }
    }
}
