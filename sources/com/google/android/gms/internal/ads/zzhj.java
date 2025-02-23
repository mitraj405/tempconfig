package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzhj implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ zzhl zza;
    private final Handler zzb;

    public zzhj(zzhl zzhl, Handler handler) {
        this.zza = zzhl;
        this.zzb = handler;
    }

    public final void onAudioFocusChange(int i) {
        this.zzb.post(new zzhi(this, i));
    }
}
