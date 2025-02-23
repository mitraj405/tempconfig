package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzfvl implements Serializable, zzfvk {
    final zzfvk zza;
    volatile transient boolean zzb;
    transient Object zzc;

    public zzfvl(zzfvk zzfvk) {
        this.zza = zzfvk;
    }

    public final String toString() {
        Object obj;
        if (this.zzb) {
            obj = lf.j("<supplier that returned ", String.valueOf(this.zzc), ">");
        } else {
            obj = this.zza;
        }
        return lf.j("Suppliers.memoize(", obj.toString(), ")");
    }

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    Object zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
