package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzakc implements zzacn {
    private final zzacn zzb;
    private final zzajy zzc;
    private final SparseArray zzd = new SparseArray();

    public zzakc(zzacn zzacn, zzajy zzajy) {
        this.zzb = zzacn;
        this.zzc = zzajy;
    }

    public final void zzD() {
        this.zzb.zzD();
    }

    public final void zzO(zzadi zzadi) {
        this.zzb.zzO(zzadi);
    }

    public final void zza() {
        for (int i = 0; i < this.zzd.size(); i++) {
            ((zzake) this.zzd.valueAt(i)).zzb();
        }
    }

    public final zzadp zzw(int i, int i2) {
        if (i2 != 3) {
            return this.zzb.zzw(i, i2);
        }
        zzake zzake = (zzake) this.zzd.get(i);
        if (zzake != null) {
            return zzake;
        }
        zzake zzake2 = new zzake(this.zzb.zzw(i, 3), this.zzc);
        this.zzd.put(i, zzake2);
        return zzake2;
    }
}
