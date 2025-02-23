package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgak {
    public static long zza(String str, long j) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " (" + j + ") must be >= 0");
    }

    public static void zzb(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
