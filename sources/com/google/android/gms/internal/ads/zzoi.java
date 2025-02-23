package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzoi extends AudioDeviceCallback {
    final /* synthetic */ zzom zza;

    public /* synthetic */ zzoi(zzom zzom, zzoh zzoh) {
        this.zza = zzom;
    }

    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzom zzom = this.zza;
        this.zza.zzj(zzof.zzc(zzom.zza, zzom.zzh, zzom.zzg));
    }

    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzon zzd = this.zza.zzg;
        int i = zzet.zza;
        int length = audioDeviceInfoArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (zzet.zzG(audioDeviceInfoArr[i2], zzd)) {
                this.zza.zzg = null;
                break;
            } else {
                i2++;
            }
        }
        zzom zzom = this.zza;
        zzom.zzj(zzof.zzc(zzom.zza, zzom.zzh, zzom.zzg));
    }
}
