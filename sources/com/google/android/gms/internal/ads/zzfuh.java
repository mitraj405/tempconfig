package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzfuh extends zzfug {
    private final char zza;

    public zzfuh(char c) {
        this.zza = c;
    }

    public final String toString() {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        int i = this.zza;
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        return lf.j("CharMatcher.is('", String.copyValueOf(cArr), "')");
    }

    public final boolean zzb(char c) {
        if (c == this.zza) {
            return true;
        }
        return false;
    }
}
