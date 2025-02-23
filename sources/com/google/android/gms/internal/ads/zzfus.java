package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class zzfus implements Serializable {
    public static zzfus zzc() {
        return zzfud.zza;
    }

    public static zzfus zzd(Object obj) {
        if (obj == null) {
            return zzfud.zza;
        }
        return new zzfuz(obj);
    }

    public abstract zzfus zza(zzful zzful);

    public abstract Object zzb(Object obj);
}
