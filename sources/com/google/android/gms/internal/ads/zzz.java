package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzz {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzz zza(int i) {
        zzdi.zzf(!this.zzb);
        this.zza.append(i, true);
        return this;
    }

    public final zzab zzb() {
        zzdi.zzf(!this.zzb);
        this.zzb = true;
        return new zzab(this.zza, (zzaa) null);
    }
}
