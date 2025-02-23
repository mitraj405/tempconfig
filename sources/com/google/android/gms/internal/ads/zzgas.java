package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgas {
    public static byte zza(long j) {
        boolean z;
        if ((j >> 8) == 0) {
            z = true;
        } else {
            z = false;
        }
        zzfuu.zzg(z, "out of range: %s", j);
        return (byte) ((int) j);
    }
}
