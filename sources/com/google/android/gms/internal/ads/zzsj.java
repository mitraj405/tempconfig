package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzsj {
    public static void zza(zzrz zzrz, zznz zznz) {
        LogSessionId zza = zznz.zza();
        if (!zza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            zzrz.zzb.setString("log-session-id", zza.getStringId());
        }
    }
}
