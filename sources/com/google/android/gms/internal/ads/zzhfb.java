package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhfb implements zzhfl, zzhew {
    private static final Object zza = new Object();
    private volatile zzhfl zzb;
    private volatile Object zzc = zza;

    private zzhfb(zzhfl zzhfl) {
        this.zzb = zzhfl;
    }

    public static zzhew zza(zzhfl zzhfl) {
        if (zzhfl instanceof zzhew) {
            return (zzhew) zzhfl;
        }
        return new zzhfb(zzhfl);
    }

    public static zzhfl zzc(zzhfl zzhfl) {
        if (zzhfl instanceof zzhfb) {
            return zzhfl;
        }
        return new zzhfb(zzhfl);
    }

    public final Object zzb() {
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.zzc;
                if (obj == obj2) {
                    obj = this.zzb.zzb();
                    Object obj3 = this.zzc;
                    if (obj3 != obj2) {
                        if (obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.zzc = obj;
                    this.zzb = null;
                }
            }
        }
        return obj;
    }
}
