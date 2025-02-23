package com.google.android.gms.internal.ads;

import java.util.AbstractList;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzgyi extends AbstractList {
    private final zzgyg zza;
    private final zzgyh zzb;

    public zzgyi(zzgyg zzgyg, zzgyh zzgyh) {
        this.zza = zzgyg;
        this.zzb = zzgyh;
    }

    public final Object get(int i) {
        return this.zzb.zzb(this.zza.zzd(i));
    }

    public final int size() {
        return this.zza.size();
    }
}
