package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzayr implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzayv zzb;

    public zzayr(zzayv zzayv, View view) {
        this.zza = view;
        this.zzb = zzayv;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
