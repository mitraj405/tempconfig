package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzlp {
    private final zzab zza;
    private final SparseArray zzb;

    public zzlp(zzab zzab, SparseArray sparseArray) {
        this.zza = zzab;
        SparseArray sparseArray2 = new SparseArray(zzab.zzb());
        for (int i = 0; i < zzab.zzb(); i++) {
            int zza2 = zzab.zza(i);
            zzlo zzlo = (zzlo) sparseArray.get(zza2);
            zzlo.getClass();
            sparseArray2.append(zza2, zzlo);
        }
        this.zzb = sparseArray2;
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final zzlo zzc(int i) {
        zzlo zzlo = (zzlo) this.zzb.get(i);
        zzlo.getClass();
        return zzlo;
    }

    public final boolean zzd(int i) {
        return this.zza.zzc(i);
    }
}
