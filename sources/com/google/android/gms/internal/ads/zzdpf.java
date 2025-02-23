package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdpf implements View.OnTouchListener {
    public final /* synthetic */ zzdpk zza;

    public /* synthetic */ zzdpf(zzdpk zzdpk) {
        this.zza = zzdpk;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zza.zzh(view, motionEvent);
        return false;
    }
}
