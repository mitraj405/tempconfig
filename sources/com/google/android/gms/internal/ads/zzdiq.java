package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdiq implements Runnable {
    public final /* synthetic */ zzdiw zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzdiq(zzdiw zzdiw, View view, boolean z, int i) {
        this.zza = zzdiw;
        this.zzb = view;
        this.zzc = z;
        this.zzd = i;
    }

    public final void run() {
        this.zza.zzx(this.zzb, this.zzc, this.zzd);
    }
}
