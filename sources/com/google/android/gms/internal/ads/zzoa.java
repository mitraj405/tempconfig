package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzoa {
    public static boolean zza(AudioManager audioManager, zzon zzon) {
        AudioDeviceInfo[] audioDeviceInfoArr;
        if (zzon == null) {
            audioManager.getClass();
            audioDeviceInfoArr = audioManager.getDevices(2);
        } else {
            audioDeviceInfoArr = new AudioDeviceInfo[]{zzon.zza};
        }
        zzfxw<Integer> zzb = zzb();
        for (AudioDeviceInfo type : audioDeviceInfoArr) {
            if (zzb.contains(Integer.valueOf(type.getType()))) {
                return true;
            }
        }
        return false;
    }

    private static zzfxw<Integer> zzb() {
        zzfxv zzfxv = new zzfxv();
        zzfxv.zzg(8, 7);
        int i = zzet.zza;
        if (i >= 31) {
            zzfxv.zzg(26, 27);
        }
        if (i >= 33) {
            zzfxv.zzf(30);
        }
        return zzfxv.zzi();
    }
}
