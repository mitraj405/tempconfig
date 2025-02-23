package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzfvn implements zzfvk {
    private static final zzfvk zza = new zzfvm();
    private volatile zzfvk zzb;
    private Object zzc;

    public zzfvn(zzfvk zzfvk) {
        this.zzb = zzfvk;
    }

    public final String toString() {
        Object obj = this.zzb;
        if (obj == zza) {
            obj = lf.j("<supplier that returned ", String.valueOf(this.zzc), ">");
        }
        return lf.j("Suppliers.memoize(", String.valueOf(obj), ")");
    }

    public final Object zza() {
        zzfvk zzfvk = this.zzb;
        zzfvk zzfvk2 = zza;
        if (zzfvk != zzfvk2) {
            synchronized (this) {
                if (this.zzb != zzfvk2) {
                    Object zza2 = this.zzb.zza();
                    this.zzc = zza2;
                    this.zzb = zzfvk2;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
