package com.google.android.gms.internal.ads;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaaj implements DisplayManager.DisplayListener {
    final /* synthetic */ zzaal zza;
    private final DisplayManager zzb;

    public zzaaj(zzaal zzaal, DisplayManager displayManager) {
        this.zza = zzaal;
        this.zzb = displayManager;
    }

    private final Display zzc() {
        return this.zzb.getDisplay(0);
    }

    public final void onDisplayChanged(int i) {
        if (i == 0) {
            zzaal.zzb(this.zza, zzc());
        }
    }

    public final void zza() {
        this.zzb.registerDisplayListener(this, zzet.zzx((Handler.Callback) null));
        zzaal.zzb(this.zza, zzc());
    }

    public final void zzb() {
        this.zzb.unregisterDisplayListener(this);
    }

    public final void onDisplayAdded(int i) {
    }

    public final void onDisplayRemoved(int i) {
    }
}
