package com.google.android.gms.internal.ads;

import android.media.Spatializer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzxl implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ zzxt zza;

    public zzxl(zzxm zzxm, zzxt zzxt) {
        this.zza = zzxt;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.zza.zzu();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.zza.zzu();
    }
}
