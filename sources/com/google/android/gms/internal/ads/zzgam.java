package com.google.android.gms.internal.ads;

import com.google.common.primitives.UnsignedBytes;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgam {
    public static char zza(long j) {
        boolean z;
        char c = (char) ((int) j);
        if (((long) c) == j) {
            z = true;
        } else {
            z = false;
        }
        zzfuu.zzg(z, "Out of range: %s", j);
        return c;
    }

    public static char zzb(byte b, byte b2) {
        return (char) ((b << 8) | (b2 & UnsignedBytes.MAX_VALUE));
    }
}
