package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzab {
    private final SparseBooleanArray zza;

    public /* synthetic */ zzab(SparseBooleanArray sparseBooleanArray, zzaa zzaa) {
        this.zza = sparseBooleanArray;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzab)) {
            return false;
        }
        zzab zzab = (zzab) obj;
        if (zzet.zza >= 24) {
            return this.zza.equals(zzab.zza);
        }
        if (this.zza.size() != zzab.zza.size()) {
            return false;
        }
        for (int i = 0; i < this.zza.size(); i++) {
            if (zza(i) != zzab.zza(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        if (zzet.zza >= 24) {
            return this.zza.hashCode();
        }
        int size = this.zza.size();
        for (int i = 0; i < this.zza.size(); i++) {
            size = (size * 31) + zza(i);
        }
        return size;
    }

    public final int zza(int i) {
        zzdi.zza(i, 0, this.zza.size());
        return this.zza.keyAt(i);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final boolean zzc(int i) {
        return this.zza.get(i);
    }
}
