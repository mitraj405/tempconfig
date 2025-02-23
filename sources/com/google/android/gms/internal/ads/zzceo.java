package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzceo implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzbxl zza;
    final /* synthetic */ zzcer zzb;

    public zzceo(zzcer zzcer, zzbxl zzbxl) {
        this.zza = zzbxl;
        this.zzb = zzcer;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzW(view, this.zza, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
