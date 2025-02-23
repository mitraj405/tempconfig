package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbxc implements Runnable {
    public final /* synthetic */ zzbxg zza;
    public final /* synthetic */ Bitmap zzb;

    public /* synthetic */ zzbxc(zzbxg zzbxg, Bitmap bitmap) {
        this.zza = zzbxg;
        this.zzb = bitmap;
    }

    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
