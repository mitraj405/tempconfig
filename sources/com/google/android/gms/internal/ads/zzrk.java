package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzrk {
    public static final boolean zza;

    static {
        boolean z = false;
        if ("Amazon".equals(zzet.zzc)) {
            String str = zzet.zzd;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z = true;
            }
        }
        zza = z;
    }
}
