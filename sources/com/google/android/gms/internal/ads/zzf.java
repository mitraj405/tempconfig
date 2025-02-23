package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzf {
    public final AudioAttributes zza;

    public /* synthetic */ zzf(zzh zzh, zze zze) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        int i = zzet.zza;
        if (i >= 29) {
            zzc.zza(usage, 1);
        }
        if (i >= 32) {
            zzd.zza(usage, 0);
        }
        this.zza = usage.build();
    }
}
