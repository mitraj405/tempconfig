package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzpy {
    public static void zza(AudioTrack audioTrack, zzon zzon) {
        AudioDeviceInfo audioDeviceInfo;
        if (zzon == null) {
            audioDeviceInfo = null;
        } else {
            audioDeviceInfo = zzon.zza;
        }
        audioTrack.setPreferredDevice(audioDeviceInfo);
    }
}
