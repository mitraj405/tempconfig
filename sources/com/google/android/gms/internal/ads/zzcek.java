package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcek implements Runnable {
    public final /* synthetic */ zzcer zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzbxl zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzcek(zzcer zzcer, View view, zzbxl zzbxl, int i) {
        this.zza = zzcer;
        this.zzb = view;
        this.zzc = zzbxl;
        this.zzd = i;
    }

    public final void run() {
        this.zza.zzp(this.zzb, this.zzc, this.zzd);
    }
}
