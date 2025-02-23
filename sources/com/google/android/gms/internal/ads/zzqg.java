package com.google.android.gms.internal.ads;

import android.media.AudioRouting;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzqg implements AudioRouting.OnRoutingChangedListener {
    public final /* synthetic */ zzqh zza;

    public /* synthetic */ zzqg(zzqh zzqh) {
        this.zza = zzqh;
    }

    public final void onRoutingChanged(AudioRouting audioRouting) {
        this.zza.zzc(audioRouting);
    }
}
