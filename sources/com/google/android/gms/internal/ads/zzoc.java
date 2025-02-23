package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioProfile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzoc {
    public static zzof zza(AudioManager audioManager, zzh zzh) {
        List directProfilesForAttributes = audioManager.getDirectProfilesForAttributes(zzh.zza().zza);
        HashMap hashMap = new HashMap();
        hashMap.put(2, new HashSet(zzgap.zzg(12)));
        for (int i = 0; i < directProfilesForAttributes.size(); i++) {
            AudioProfile audioProfile = (AudioProfile) directProfilesForAttributes.get(i);
            if (audioProfile.getEncapsulationType() != 1) {
                int d = audioProfile.getFormat();
                if (zzet.zzK(d) || zzof.zzb.containsKey(Integer.valueOf(d))) {
                    Integer valueOf = Integer.valueOf(d);
                    if (hashMap.containsKey(valueOf)) {
                        Set set = (Set) hashMap.get(valueOf);
                        set.getClass();
                        set.addAll(zzgap.zzg(audioProfile.getChannelMasks()));
                    } else {
                        hashMap.put(valueOf, new HashSet(zzgap.zzg(audioProfile.getChannelMasks())));
                    }
                }
            }
        }
        zzfxo zzfxo = new zzfxo();
        for (Map.Entry entry : hashMap.entrySet()) {
            zzfxo.zzf(new zzod(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
        }
        return new zzof(zzfxo.zzi());
    }

    public static zzon zzb(AudioManager audioManager, zzh zzh) {
        audioManager.getClass();
        try {
            List audioDevicesForAttributes = audioManager.getAudioDevicesForAttributes(zzh.zza().zza);
            if (audioDevicesForAttributes.isEmpty()) {
                return null;
            }
            return new zzon((AudioDeviceInfo) audioDevicesForAttributes.get(0));
        } catch (RuntimeException unused) {
            return null;
        }
    }
}
