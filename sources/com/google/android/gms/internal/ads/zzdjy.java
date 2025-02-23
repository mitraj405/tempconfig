package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdjy implements Runnable {
    public final /* synthetic */ zzdkb zza;
    public final /* synthetic */ ViewGroup zzb;

    public /* synthetic */ zzdjy(zzdkb zzdkb, ViewGroup viewGroup) {
        this.zza = zzdkb;
        this.zzb = viewGroup;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
