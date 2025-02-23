package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzjd {
    public static zznz zza(Context context, zzjm zzjm, boolean z, String str) {
        zznv zzb = zznv.zzb(context);
        if (zzb == null) {
            zzea.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new zznz(LogSessionId.LOG_SESSION_ID_NONE, str);
        }
        if (z) {
            zzjm.zzy(zzb);
        }
        return new zznz(zzb.zza(), str);
    }
}
