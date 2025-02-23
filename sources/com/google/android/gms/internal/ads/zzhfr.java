package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhfr implements zzhfl {
    private static final Object zza = new Object();
    private volatile zzhfl zzb;
    private volatile Object zzc = zza;

    private zzhfr(zzhfl zzhfl) {
        this.zzb = zzhfl;
    }

    public static zzhfl zza(zzhfl zzhfl) {
        if ((zzhfl instanceof zzhfr) || (zzhfl instanceof zzhfb)) {
            return zzhfl;
        }
        return new zzhfr(zzhfl);
    }

    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        zzhfl zzhfl = this.zzb;
        if (zzhfl == null) {
            return this.zzc;
        }
        Object zzb2 = zzhfl.zzb();
        this.zzc = zzb2;
        this.zzb = null;
        return zzb2;
    }
}
