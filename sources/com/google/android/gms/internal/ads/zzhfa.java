package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhfa implements zzhfc {
    private zzhfl zza;

    public static void zza(zzhfl zzhfl, zzhfl zzhfl2) {
        zzhfa zzhfa = (zzhfa) zzhfl;
        if (zzhfa.zza == null) {
            zzhfa.zza = zzhfl2;
            return;
        }
        throw new IllegalStateException();
    }

    public final Object zzb() {
        zzhfl zzhfl = this.zza;
        if (zzhfl != null) {
            return zzhfl.zzb();
        }
        throw new IllegalStateException();
    }
}
