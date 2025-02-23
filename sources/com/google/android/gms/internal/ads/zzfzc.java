package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzfzc implements Comparator {
    public static zzfzc zzb(Comparator comparator) {
        return new zzfxc(comparator);
    }

    public static zzfzc zzc() {
        return zzfza.zza;
    }

    public abstract int compare(Object obj, Object obj2);

    public zzfzc zza() {
        return new zzfzl(this);
    }
}
