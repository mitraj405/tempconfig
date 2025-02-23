package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbcd {
    public static boolean zza(zzbcl zzbcl, zzbci zzbci, String... strArr) {
        if (zzbci == null) {
            return false;
        }
        zzbcl.zze(zzbci, zzu.zzB().elapsedRealtime(), strArr);
        return true;
    }
}
