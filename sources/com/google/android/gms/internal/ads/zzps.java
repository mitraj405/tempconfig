package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzps {
    public static zzoq zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
        int c = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        if (c == 0) {
            return zzoq.zza;
        }
        zzoo zzoo = new zzoo();
        boolean z2 = false;
        if (zzet.zza > 32 && c == 2) {
            z2 = true;
        }
        zzoo.zza(true);
        zzoo.zzb(z2);
        zzoo.zzc(z);
        return zzoo.zzd();
    }
}
