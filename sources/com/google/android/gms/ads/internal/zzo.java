package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzo implements View.OnTouchListener {
    final /* synthetic */ zzt zza;

    public zzo(zzt zzt) {
        this.zza = zzt;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        zzt zzt = this.zza;
        if (zzt.zzh == null) {
            return false;
        }
        zzt.zzh.zzd(motionEvent);
        return false;
    }
}
