package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzob {
    public static int zza(int i, int i2, zzh zzh) {
        for (int i3 = 10; i3 > 0; i3--) {
            int zzh2 = zzet.zzh(i3);
            if (zzh2 != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(zzh2).build(), zzh.zza().zza)) {
                return i3;
            }
        }
        return 0;
    }

    public static zzfxr<Integer> zzb(zzh zzh) {
        zzfxo zzfxo = new zzfxo();
        zzfzx zze = zzof.zzb.keySet().iterator();
        while (zze.hasNext()) {
            int intValue = ((Integer) zze.next()).intValue();
            if (zzet.zza >= zzet.zzg(intValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), zzh.zza().zza)) {
                zzfxo.zzf(Integer.valueOf(intValue));
            }
        }
        zzfxo.zzf(2);
        return zzfxo.zzi();
    }
}
